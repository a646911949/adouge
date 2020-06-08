package com.adouge.gateway.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Vinson
 * @date : 2020/5/19 2:01 下午
 */
@Slf4j
@Component
@Primary
@AllArgsConstructor
public class SwaggerResourceConfig implements SwaggerResourcesProvider {

    private final RouteLocator routeLocator;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<Route> routes1 = new ArrayList<>();
        routeLocator.getRoutes().subscribe(routes1::add);
        routes1.forEach(route ->
                resources.add(swaggerResource(route.getId().replace("ReactiveCompositeDiscoveryClient_", ""),
                        String.join("", route.getUri().toString().replace("lb://", ""), "/v2/api-docs"))));
        //取出gateway的route
//        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
//        //结合配置的route-路径(Path)，和route过滤，只获取有效的route节点
//        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
//                .forEach(routeDefinition -> routeDefinition.getPredicates().stream()
//                        .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
//                        .forEach(predicateDefinition -> resources.add(swaggerResource(routeDefinition.getId(),
//                                "/"+routeDefinition.getId()+API_URI ))));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        log.info("name:{},location:{}", name, location);
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}

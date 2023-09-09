package petstore.api.config;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configs/base.properties",
        "classpath:configs/${env}.properties"
})
public interface WebConfig extends Config {

    @Key("BaseUri")
    @DefaultValue("https://petstore.swagger.io")
    String getBaseUri();

    @Key("BasePath")
    @DefaultValue("/v2")
    String getBasePath();
}
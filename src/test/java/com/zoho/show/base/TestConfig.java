package com.zoho.show.base;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:develop.properties",
        "system:properties",
        "system:env"
})
public interface TestConfig extends Config {

    @Key("BASE_URL")
    @DefaultValue("")
    String baseUrl();

    @Key("ZOHO_USER_NAME")
    @DefaultValue("")
    String zohoUserName();

    @Key("ZOHO_USER_PASSWORD")
    @DefaultValue("")
    String zohoUserPassword();

    @Key("USE_HEADLESS_BROWSER")
    @DefaultValue("false")
    boolean useHeadlessBrowser();

    @Key("KEEP_BROWSER_OPEN")
    @DefaultValue("false")
    boolean keepBrowserOpen();

    @Key("CHROME_DRIVER_PATH")
    @DefaultValue("")
    String chromeDriverPath();

}

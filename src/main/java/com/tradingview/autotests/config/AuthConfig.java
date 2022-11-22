package com.tradingview.autotests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties"
})
public interface AuthConfig extends Config {

    @Key("username")
    String username();
    @Key("password")
    String password();
}

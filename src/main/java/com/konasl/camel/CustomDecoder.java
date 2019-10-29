package com.konasl.camel;


import org.apache.camel.component.netty.ChannelHandlerFactory;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.handler.codec.string.StringDecoder;

import java.nio.charset.Charset;

public class CustomDecoder implements ChannelHandlerFactory {

    @Override
    public ChannelHandler newChannelHandler() {
        return new StringDecoder(Charset.forName("UTF-8"));
    }
}

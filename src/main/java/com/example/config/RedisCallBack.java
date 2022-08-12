package com.example.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * Redis监听过期的Key
 */
@Component
public class RedisCallBack extends KeyExpirationEventMessageListener {

    public RedisCallBack(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 针对redis key ttl数据处理（回调）
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {

        System.out.println("过期key:"+message.toString());

    }
}

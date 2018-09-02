package com.lwk.tools

import org.apache.commons.pool2.impl.GenericObjectPoolConfig
import redis.clients.jedis.{Jedis, JedisPool}

object JedisPoolss {

    var genericObjectPoolConfig = new GenericObjectPoolConfig()
    var jedisPool = new JedisPool("192.168.88.1")

    def getJedis()={
      val jedis = jedisPool.getResource
      jedis.select(0)
      jedis
    }

}

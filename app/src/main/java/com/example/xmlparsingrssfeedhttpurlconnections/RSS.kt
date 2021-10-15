package com.example.xmlparsingrssfeedhttpurlconnections

import com.example.xmlparsingrssfeedhttpurlconnections.Channel
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "rss", strict = false)
class RSS constructor() : Serializable {
    @field:Element( name = "channel")
    var channels: Channel? = null

}
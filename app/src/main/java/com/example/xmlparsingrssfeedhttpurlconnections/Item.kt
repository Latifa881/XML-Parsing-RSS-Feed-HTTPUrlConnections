package com.example.xmlparsingrssfeedhttpurlconnections


import org.simpleframework.xml.*
import java.io.Serializable

@Root(name = "item", strict = false)
class Item @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String? = null,
    @field:Element(name = "description")
    @param:Element(name = "description")
    var description: String? = null,
    @field:Element(name = "link")
    @param:Element(name = "link")
    var link: String? = null,

) : Serializable {}
package com.example.xmlparsingrssfeedhttpurlconnections

import org.simpleframework.xml.Element
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text
import java.io.Serializable

@Root(name = "item", strict = false)
class Item @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String? = null,
    @field:Element(name = "description")
    @param:Element(name = "description")
    var description: String? = null

): Serializable {}
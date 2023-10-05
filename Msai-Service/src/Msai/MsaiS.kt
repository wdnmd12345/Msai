package Msai

import arc.*
import arc.util.*
import mindustry.game.EventType.*
import mindustry.mod.*
import mindustry.ui.dialogs.*

import java.net.Socket
import java.lang.Exception

class MsaiS : Mod(){
    init{
        Log.info("Msai-Service Loading...")

        //listen for game load event
        Events.on(ClientLoadEvent::class.java){
            //show dialog upon startup
            Time.runTask(10f){
                BaseDialog("frog").apply{
                    cont.apply{
                        add("behold").row()
                        //mod sprites are prefixed with the mod name (this mod is called 'example-kotlin-mod' in its config)
                        image(Core.atlas.find("example-kotlin-mod-frog")).pad(20f).row()
                        button("I see"){ hide() }.size(100f, 50f)
                    }
                    show()
                }
            }
        }
    }

    override fun loadContent(){
        var sc:Socket?
        Log.info("Msai-Service loading success")
        try {
            sc = Socket("localhost", 12345)
        } catch (e: Exception) {
            Log.warn("unknown error")
            sc = null
        }
        if (sc != null) {
            Log.info("connect success")
            Time.runTask(10f){
                BaseDialog("frog").apply{
                    cont.apply{
                        add("behold").row()
                        //mod sprites are prefixed with the mod name (this mod is called 'example-kotlin-mod' in its config)
                        image(Core.atlas.find("example-kotlin-mod-frog")).pad(20f).row()
                        button("I see"){ hide() }.size(100f, 50f)
                    }
                    show()
                }
            }
        } else {
            Log.warn("connect fail")
        }
    }
}

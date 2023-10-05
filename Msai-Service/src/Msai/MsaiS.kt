package Msai

import arc.*
import arc.util.*
import mindustry.game.EventType.*
import mindustry.mod.*
import mindustry.ui.dialogs.*

import java.net.ServerSocket

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
        Log.info("Msai-Service loading success")
        val server:ServerSocket = ServerSocket(12345)
        while (true){
            val sc = server.accept()
        }
        Log.info("客户端:"+sc.getInetAddress().getLocalHost()+"已连接到服务器")
    }
}

package com.github.tacowasa059.tacowasa_014_chat;
import java.util.Random;
public class wasawasa {//語尾にわさをつけるように変更
    private final TACOWASA_014_chat plugin;
    public wasawasa(TACOWASA_014_chat plugin){
        this.plugin=plugin;
    }
    public String addWASA(String s){//ネームタグ付き
        Random random=new Random();
        double b = random.nextDouble();
        if(b<plugin.getConfig().getDouble("suffix-probability")&&s.contains("<TACOWASA_014>")){
            return s+"わさ～";
        }
        return s;
    }
    public String addWASAto014(String s){
        Random random=new Random();
        double b = random.nextDouble();
        if(b<plugin.getConfig().getDouble("suffix-probability")){
            return s+"わさ～";
        }
        return s;
    }
    public String addWASA(String name,String s){//ネームタグ別
        Random random=new Random();
        double b = random.nextDouble();
        if(b<plugin.getConfig().getDouble("suffix-probability")&&name=="TACOWASA_014"){
            return s+"わさ～";
        }
        return s;
    }
}

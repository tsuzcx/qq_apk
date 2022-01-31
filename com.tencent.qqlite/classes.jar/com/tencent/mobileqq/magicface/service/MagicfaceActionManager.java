package com.tencent.mobileqq.magicface.service;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;

public class MagicfaceActionManager
{
  public static final int a = 0;
  public static final String a = "sendSound";
  public static final int b = 1;
  public static final String b = "receiveSound";
  public static final String c = "send.xml";
  public static final String d = "receive.xml";
  public static final String e = "MagicfaceActionManager";
  public int c = 0;
  
  public static ActionGlobalData a(Emoticon paramEmoticon, int paramInt)
  {
    MagicfaceResLoader localMagicfaceResLoader = new MagicfaceResLoader(EmosmUtils.getMagicfaceFolderPath(paramEmoticon.epId, paramEmoticon.eId));
    paramEmoticon = null;
    if (paramInt == 0) {
      paramEmoticon = localMagicfaceResLoader.a("send.xml");
    }
    for (;;)
    {
      return new MagicfaceActionDecoder().a(paramEmoticon);
      if (paramInt == 1) {
        paramEmoticon = localMagicfaceResLoader.a("receive.xml");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager
 * JD-Core Version:    0.7.0.1
 */
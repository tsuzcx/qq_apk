package com.tencent.mobileqq.extendfriend.wiget;

import afwv;
import afxw;
import afyt;
import aqnm;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExtendFriendVoiceView$1
  implements Runnable
{
  ExtendFriendVoiceView$1(ExtendFriendVoiceView paramExtendFriendVoiceView) {}
  
  public void run()
  {
    Object localObject;
    int j;
    if (ExtendFriendVoiceView.a(this.this$0) == 0)
    {
      localObject = afxw.kL("expand_voice_animation.json");
      j = aqnm.dip2px(19.0F);
    }
    for (int i = aqnm.dip2px(19.0F);; i = aqnm.dip2px(17.0F))
    {
      try
      {
        localObject = new BufferedInputStream(new FileInputStream((String)localObject));
        LottieComposition.Factory.fromInputStream(this.this$0.getContext(), (InputStream)localObject, new afyt(this, j, i));
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ExtendFriendVoiceView", 1, "loadVoiceAnimation fail.", localException);
      }
      localObject = afwv.kJ("expand_voice_animation2.json");
      j = aqnm.dip2px(16.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView.1
 * JD-Core Version:    0.7.0.1
 */
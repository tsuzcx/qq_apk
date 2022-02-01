package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.util.Set;
import wpj;
import wpk;

public class AudioTransitionAnimManager$1
  implements Runnable
{
  public AudioTransitionAnimManager$1(wpj paramwpj, String paramString, Context paramContext, int paramInt) {}
  
  public void run()
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(wpj.aTO + this.val$path + "data.json");
      wpj.a(this.this$0, LottieComposition.Factory.fromInputStream(this.val$context, localFileInputStream, new wpk(this)));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AudioTransitionAnimManager", 1, "loadVoiceAnimation fail.", localThrowable);
      wpj.a(this.this$0).remove(Integer.valueOf(this.val$type));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.1
 * JD-Core Version:    0.7.0.1
 */
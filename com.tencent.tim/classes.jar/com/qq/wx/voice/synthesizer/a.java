package com.qq.wx.voice.synthesizer;

import android.content.Context;
import com.qq.wx.voice.util.ManagerDataStore;
import com.qq.wx.voice.util.ManagerDeviceInfo;
import com.qq.wx.voice.util.ManagerInfoRecord;
import java.io.UnsupportedEncodingException;

final class a
{
  protected InnerHttp a = null;
  private boolean b = false;
  
  protected static void a(float paramFloat)
  {
    InfoSynthesizer.i = paramFloat;
  }
  
  protected static void a(int paramInt)
  {
    InfoSynthesizer.h = paramInt;
  }
  
  protected static void a(SpeechSynthesizerListener paramSpeechSynthesizerListener)
  {
    InfoSynthesizer.b.b = paramSpeechSynthesizerListener;
  }
  
  protected final int a(Context paramContext, String paramString)
  {
    int i = 0;
    if (InfoSynthesizer.b.b == null) {
      i = -1;
    }
    do
    {
      return i;
      InfoSynthesizer.b.a = this;
    } while (this.b);
    InfoSynthesizer.a = paramString;
    InfoSynthesizer.c.init(paramContext);
    InfoSynthesizer.d.init(paramContext);
    InfoSynthesizer.e.init(paramContext);
    this.b = true;
    return 0;
  }
  
  protected final int a(String paramString)
  {
    if (InfoSynthesizer.b.b == null) {
      return -1;
    }
    if (!this.b)
    {
      InfoSynthesizer.b.a(-401);
      return -1;
    }
    if (this.a != null)
    {
      InfoSynthesizer.b.a(-405);
      return -1;
    }
    InfoSynthesizer.b.a();
    if ((paramString == null) || (paramString.isEmpty()))
    {
      InfoSynthesizer.b.a(-402);
      return -1;
    }
    try
    {
      if (paramString.getBytes("gbk").length > InfoSynthesizer.f)
      {
        InfoSynthesizer.b.a(-403);
        return -1;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      InfoSynthesizer.b.a(-404);
      return -1;
    }
    this.a = new InnerHttp(paramString);
    new Thread(this.a).start();
    return 0;
  }
  
  protected final void a()
  {
    if (this.a != null)
    {
      SpeechSynthesizerState localSpeechSynthesizerState = SpeechSynthesizerState.Canceling;
      InfoSynthesizer.b.a(localSpeechSynthesizerState);
      this.a.a();
      this.a = null;
      localSpeechSynthesizerState = SpeechSynthesizerState.Canceled;
      InfoSynthesizer.b.a(localSpeechSynthesizerState);
    }
  }
  
  protected final void b()
  {
    if (this.b)
    {
      a();
      this.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.wx.voice.synthesizer.a
 * JD-Core Version:    0.7.0.1
 */
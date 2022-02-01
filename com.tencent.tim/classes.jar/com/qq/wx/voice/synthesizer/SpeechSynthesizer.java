package com.qq.wx.voice.synthesizer;

import android.content.Context;

public class SpeechSynthesizer
{
  private static SpeechSynthesizer a = null;
  private a b = new a();
  
  public static SpeechSynthesizer shareInstance()
  {
    if (a == null) {
      a = new SpeechSynthesizer();
    }
    return a;
  }
  
  public void cancel()
  {
    this.b.a();
  }
  
  public void destroy()
  {
    this.b.b();
  }
  
  public int init(Context paramContext, String paramString)
  {
    return this.b.a(paramContext, paramString);
  }
  
  public void setFormat(int paramInt)
  {
    a locala = this.b;
    a.a(paramInt);
  }
  
  public void setListener(SpeechSynthesizerListener paramSpeechSynthesizerListener)
  {
    a locala = this.b;
    a.a(paramSpeechSynthesizerListener);
  }
  
  public void setOpenLogCat(boolean paramBoolean)
  {
    a locala = this.b;
    com.qq.wx.voice.util.LogTool.isShow = paramBoolean;
  }
  
  public void setVolume(float paramFloat)
  {
    a locala = this.b;
    a.a(paramFloat);
  }
  
  public int start(String paramString)
  {
    return this.b.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.wx.voice.synthesizer.SpeechSynthesizer
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoySkinGuideView
  extends RelativeLayout
{
  protected boolean Yp;
  public SpriteNativeView a;
  private int aYE = 2;
  public MediaPlayer mMediaPlayer;
  
  public ReadInJoySkinGuideView(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(2131562927, this);
    this.a = ((SpriteNativeView)findViewById(2131378464));
    setClickable(true);
    if (261 == paramInt2) {
      this.aYE = 1;
    }
    this.a.post(new ReadInJoySkinGuideView.1(this, paramQQAppInterface, paramString2, paramOnClickListener1, paramString1, paramOnClickListener2, paramContext, paramInt1));
  }
  
  public void onDestroy()
  {
    if (!this.Yp)
    {
      this.Yp = true;
      this.a.onDestroy();
    }
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(localException));
    }
  }
  
  public void onPause()
  {
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.pause();
      this.mMediaPlayer.seekTo(0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView
 * JD-Core Version:    0.7.0.1
 */
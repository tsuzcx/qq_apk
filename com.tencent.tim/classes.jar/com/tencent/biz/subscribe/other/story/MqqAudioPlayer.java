package com.tencent.biz.subscribe.other.story;

import android.content.Context;
import android.os.Message;
import aycg;
import aycj;
import com.tencent.qg.sdk.audio.AudioPlayer;
import com.tencent.qg.sdk.audio.AudioPlayer.PlayHandler;
import com.tencent.qphone.base.util.QLog;

public class MqqAudioPlayer
  extends AudioPlayer
{
  public static final String TAG = "MqqAudioPlayer2";
  
  public MqqAudioPlayer(Context paramContext, long paramLong)
  {
    super(paramContext, paramLong);
    this.mContext = paramContext;
    this.mPlayerHandle = paramLong;
  }
  
  public void muxPlay()
  {
    String str = aycg.sM(this.mSrc);
    if (str != null)
    {
      aycj.a().adu(str);
      if (QLog.isColorLevel()) {
        QLog.d("MqqAudioPlayer2", 2, "play muxPlay:" + aycg.sM(this.mSrc));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MqqAudioPlayer2", 2, "play failed:" + this.mSrc);
  }
  
  public void play()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MqqAudioPlayer2", 2, "MqqAudioPlayer2 fanzheng play:" + aycg.sM(this.mSrc));
    }
    Object localObject = aycj.a();
    if ((this.mSrc != null) && (((aycj)localObject).eJC == 1) && (((aycj)localObject).uk(this.mSrc)))
    {
      aycj.a().eQe();
      return;
    }
    if ((this.mSrc != null) && (((aycj)localObject).eJC == 2))
    {
      muxPlay();
      return;
    }
    checkAudioThread();
    localObject = Message.obtain();
    ((Message)localObject).what = 1;
    this.mPlayHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.MqqAudioPlayer
 * JD-Core Version:    0.7.0.1
 */
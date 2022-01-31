package com.tencent.mobileqq.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import ewj;
import ewk;
import java.util.ArrayList;
import java.util.Iterator;

public class VoicePlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 500;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 7;
  public static final int k = 8;
  public static final int l = 50;
  public static final int m = 200;
  private Context jdField_a_of_type_AndroidContentContext;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ewj(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private int n;
  private int o;
  
  public VoicePlayer(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(paramContext, paramInt);
    this.n = 1;
    this.o = 1;
  }
  
  public VoicePlayer(String paramString, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.n = 1;
    this.o = 2;
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 0;
    if (this.b) {
      AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    if (paramBoolean) {}
    for (this.n = 8;; this.n = 4)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        i1 = i2;
        if (this.n == 4) {
          i1 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((VoicePlayer.VoicePlayerListener)localIterator.next()).a(this.n, this.jdField_a_of_type_JavaLangString, i1);
      }
    }
  }
  
  public int a()
  {
    return this.n;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.n == 1)
    {
      try
      {
        this.n = 2;
        if (this.o == 2)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          a(true);
        }
      }
      if (this.b) {
        AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      QLog.d("Q.profilecard.VoicePlayer", 2, "start to play...  for test time=" + System.currentTimeMillis());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
      if (this.n == 3)
      {
        this.n = 2;
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        if (this.b) {
          AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, true);
        }
        QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
      }
    }
  }
  
  public void a(VoicePlayer.VoicePlayerListener paramVoicePlayerListener)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramVoicePlayerListener)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramVoicePlayerListener);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public boolean a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.b = true;
    }
    return this.b;
  }
  
  public int b()
  {
    return this.o;
  }
  
  public void b()
  {
    if (this.n == 7) {}
    for (;;)
    {
      return;
      if (this.b) {
        AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, false);
      }
      this.n = 3;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((VoicePlayer.VoicePlayerListener)localIterator.next()).b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration(), this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition());
      }
    }
  }
  
  public void c()
  {
    if (this.b) {
      AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    this.n = 6;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QLog.d("Q.profilecard.VoicePlayer", 2, "onCompletion duration=" + this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration() + " current=" + this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition() + " enableEndBuffer=" + this.jdField_a_of_type_Boolean + " thread=" + Thread.currentThread().getName());
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.n = 7;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ewk(this), 500L);
        return;
      }
      a(false);
      return;
    }
    a(false);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.VoicePlayer", 2, "onError what=" + paramInt1 + " extra=" + paramInt2);
    }
    a(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer
 * JD-Core Version:    0.7.0.1
 */
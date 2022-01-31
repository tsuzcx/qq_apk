package com.tencent.mobileqq.activity.aio;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;
import com.tencent.mobileqq.utils.AudioUtil;

public class AudioPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  public static final int a = -1;
  public static final String a;
  public static final int b = -2;
  public static final int c = -3;
  public static final int d = 1;
  public static final int e = 2;
  private static final int f = 1000;
  private Application jdField_a_of_type_AndroidAppApplication;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private AudioPlayer.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener;
  private boolean jdField_a_of_type_Boolean = false;
  AudioHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = AudioHelper.a();
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = AudioPlayer.class.getSimpleName();
  }
  
  public AudioPlayer(Context paramContext, AudioPlayer.AudioPlayerListener paramAudioPlayerListener)
  {
    this.jdField_a_of_type_AndroidAppApplication = ((Application)paramContext.getApplicationContext());
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = paramAudioPlayerListener;
  }
  
  private AudioHelper.AudioPlayerParameter a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[3];
    }
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[2];
    }
    AudioHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
    if (this.c) {}
    for (int i = 0;; i = 1) {
      return arrayOfAudioPlayerParameter[i];
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      a(this.jdField_b_of_type_JavaLangString, paramInt);
    }
  }
  
  /* Error */
  private boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 82	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9: aload_0
    //   10: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   13: ifnull +32 -> 45
    //   16: aload_0
    //   17: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   20: invokevirtual 97	android/media/MediaPlayer:isPlaying	()Z
    //   23: ifeq +10 -> 33
    //   26: aload_0
    //   27: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   30: invokevirtual 100	android/media/MediaPlayer:stop	()V
    //   33: aload_0
    //   34: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   37: invokevirtual 103	android/media/MediaPlayer:release	()V
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   45: aload_0
    //   46: getfield 66	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidAppApplication	Landroid/app/Application;
    //   49: iconst_1
    //   50: invokestatic 108	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   53: pop
    //   54: aload_0
    //   55: invokespecial 110	com/tencent/mobileqq/activity/aio/AudioPlayer:a	()Lcom/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter;
    //   58: astore 4
    //   60: aload_0
    //   61: getfield 76	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   64: aload 4
    //   66: getfield 114	com/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter:jdField_a_of_type_Int	I
    //   69: invokevirtual 117	android/media/AudioManager:setMode	(I)V
    //   72: aload_0
    //   73: getfield 76	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   76: aload 4
    //   78: getfield 118	com/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter:jdField_a_of_type_Boolean	Z
    //   81: invokevirtual 122	android/media/AudioManager:setSpeakerphoneOn	(Z)V
    //   84: aload_0
    //   85: new 93	android/media/MediaPlayer
    //   88: dup
    //   89: invokespecial 123	android/media/MediaPlayer:<init>	()V
    //   92: putfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   95: aload_0
    //   96: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   99: aload 4
    //   101: getfield 125	com/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter:b	I
    //   104: invokevirtual 128	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   107: aload_0
    //   108: getfield 78	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   111: ifnull +18 -> 129
    //   114: aload_0
    //   115: getfield 78	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   118: aload_0
    //   119: aload 4
    //   121: getfield 125	com/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter:b	I
    //   124: invokeinterface 133 3 0
    //   129: aload_1
    //   130: invokestatic 138	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   133: ifne +92 -> 225
    //   136: new 87	java/io/FileNotFoundException
    //   139: dup
    //   140: new 140	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   147: ldc 143
    //   149: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokespecial 153	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   162: athrow
    //   163: astore 4
    //   165: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +29 -> 197
    //   171: getstatic 38	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   174: iconst_2
    //   175: new 140	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   182: ldc 160
    //   184: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_1
    //   188: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_0
    //   198: invokevirtual 165	com/tencent/mobileqq/activity/aio/AudioPlayer:a	()V
    //   201: aload_0
    //   202: getfield 78	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   205: ifnull +14 -> 219
    //   208: aload_0
    //   209: getfield 78	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   212: aload_0
    //   213: iconst_m1
    //   214: invokeinterface 167 3 0
    //   219: iconst_0
    //   220: istore_3
    //   221: aload_0
    //   222: monitorexit
    //   223: iload_3
    //   224: ireturn
    //   225: aload_0
    //   226: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   229: aload_1
    //   230: invokevirtual 170	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   233: aload_0
    //   234: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   237: invokevirtual 173	android/media/MediaPlayer:prepare	()V
    //   240: aload_0
    //   241: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   244: invokevirtual 176	android/media/MediaPlayer:start	()V
    //   247: iload_2
    //   248: sipush 1000
    //   251: isub
    //   252: istore_2
    //   253: iload_2
    //   254: ifle +11 -> 265
    //   257: aload_0
    //   258: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   261: iload_2
    //   262: invokevirtual 179	android/media/MediaPlayer:seekTo	(I)V
    //   265: aload_0
    //   266: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   269: aload_0
    //   270: invokevirtual 183	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   273: aload_0
    //   274: getfield 91	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   277: aload_0
    //   278: invokevirtual 187	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   281: goto -60 -> 221
    //   284: astore_1
    //   285: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +42 -> 330
    //   291: getstatic 38	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   294: astore 4
    //   296: new 140	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   303: ldc 189
    //   305: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_1
    //   309: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: ifnull +28 -> 343
    //   318: aload_1
    //   319: invokevirtual 195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   322: astore_1
    //   323: aload 4
    //   325: iconst_2
    //   326: aload_1
    //   327: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: aload_0
    //   331: aconst_null
    //   332: iconst_0
    //   333: iconst_0
    //   334: invokevirtual 199	com/tencent/mobileqq/activity/aio/AudioPlayer:onError	(Landroid/media/MediaPlayer;II)Z
    //   337: pop
    //   338: iconst_0
    //   339: istore_3
    //   340: goto -119 -> 221
    //   343: ldc 201
    //   345: astore_1
    //   346: goto -23 -> 323
    //   349: astore_1
    //   350: aload_0
    //   351: monitorexit
    //   352: aload_1
    //   353: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	AudioPlayer
    //   0	354	1	paramString	String
    //   0	354	2	paramInt	int
    //   1	339	3	bool	boolean
    //   58	62	4	localAudioPlayerParameter	AudioHelper.AudioPlayerParameter
    //   163	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   294	30	4	str	String
    // Exception table:
    //   from	to	target	type
    //   54	129	163	java/io/FileNotFoundException
    //   129	163	163	java/io/FileNotFoundException
    //   225	247	163	java/io/FileNotFoundException
    //   257	265	163	java/io/FileNotFoundException
    //   265	281	163	java/io/FileNotFoundException
    //   54	129	284	java/lang/Exception
    //   129	163	284	java/lang/Exception
    //   225	247	284	java/lang/Exception
    //   257	265	284	java/lang/Exception
    //   265	281	284	java/lang/Exception
    //   4	33	349	finally
    //   33	45	349	finally
    //   45	54	349	finally
    //   54	129	349	finally
    //   129	163	349	finally
    //   165	197	349	finally
    //   197	219	349	finally
    //   225	247	349	finally
    //   257	265	349	finally
    //   265	281	349	finally
    //   285	323	349	finally
    //   323	330	349	finally
    //   330	338	349	finally
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        this.jdField_b_of_type_JavaLangString = null;
        AudioUtil.a(this.jdField_a_of_type_AndroidAppApplication, false);
        this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
        this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(false);
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (a()) {
      a(this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition());
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
  }
  
  public boolean a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (!this.jdField_b_of_type_Boolean) {
        if (paramBoolean1 == this.c)
        {
          bool1 = bool2;
          if (!paramBoolean2) {}
        }
        else
        {
          this.c = paramBoolean1;
          if (a()) {
            a(0);
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (a()) {
      a(this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition());
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.a(this);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.a(this, -2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */
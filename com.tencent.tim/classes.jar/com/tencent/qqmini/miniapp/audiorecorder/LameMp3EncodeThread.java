package com.tencent.qqmini.miniapp.audiorecorder;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.task.MiniAppSoLoader;
import java.io.File;
import java.io.IOException;

public class LameMp3EncodeThread
  extends Thread
{
  public static final String TAG = LameMp3EncodeThread.class.getName();
  private boolean isPause = false;
  private boolean isRecording = false;
  private String mAudioFileFormat = "mp3";
  private int mAudioSource = 1;
  private int mCallbackFrameSize;
  private int mEncodingPcmFormat = 2;
  private int mInSampleRate = 8000;
  private Handler mMainHandler;
  private MediaPlayer mMediaPlayer;
  private boolean mNativeLoaded = false;
  private int mOutBitRate = 32;
  private int mOutChannel = 1;
  private int mOutSampleRate = 8000;
  private String mPlayFilePath;
  private int mQuality = 7;
  private String mRecordFilPath;
  private long mRecordTime = 60000L;
  private int mVoiceLevel;
  private LameMp3Recorder mp3Player;
  
  public LameMp3EncodeThread(LameMp3Recorder paramLameMp3Recorder, Handler paramHandler)
  {
    super(AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getString(R.string.mini_sdk_record_thread));
    this.mp3Player = paramLameMp3Recorder;
    this.mMainHandler = paramHandler;
    start();
    loadLameMp3So();
  }
  
  public static File createSDFile(String paramString)
    throws IOException
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    File localFile;
    do
    {
      return paramString;
      localFile = new File(paramString);
      paramString = localFile;
    } while (localFile.exists());
    if (localFile.isDirectory())
    {
      localFile.mkdirs();
      return localFile;
    }
    localFile.createNewFile();
    return localFile;
  }
  
  private void loadLameMp3So()
  {
    this.mNativeLoaded = MiniAppSoLoader.g().isLameMp3SoLoaded();
    QMLog.e("[miniapp]-LameMp3Native", "mNativeLoaded : " + this.mNativeLoaded);
    if (!this.mNativeLoaded) {}
    try
    {
      this.mNativeLoaded = MiniAppSoLoader.g().loadLameMp3So();
      if (this.mNativeLoaded) {}
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          System.loadLibrary("mini_lamemp3");
          this.mNativeLoaded = true;
          QMLog.i("[miniapp]-LameMp3Native", "load so exception, load local libmini_lamemp3.so success!");
          return;
        }
        catch (Throwable localThrowable2)
        {
          this.mNativeLoaded = false;
          QMLog.i("[miniapp]-LameMp3Native", "load so exception, fail to load local libmini_lamemp3.so:" + this.mNativeLoaded, localThrowable2);
        }
        localThrowable1 = localThrowable1;
        QMLog.e("[miniapp]-LameMp3Native", "load so exception, fail to load network libmini_lamemp3.so:" + this.mNativeLoaded, localThrowable1);
      }
    }
  }
  
  private void onFrameRecord(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Message localMessage;
    if ((this.mMainHandler != null) && (paramArrayOfByte != null))
    {
      localMessage = Message.obtain();
      localMessage.obj = paramArrayOfByte;
      localMessage.what = 6;
      if (!paramBoolean) {
        break label52;
      }
    }
    label52:
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.mMainHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public int getAudioSource()
  {
    return this.mAudioSource;
  }
  
  public int getEncodingPcmFormat()
  {
    return this.mEncodingPcmFormat;
  }
  
  public int getInSampleRate()
  {
    return this.mInSampleRate;
  }
  
  public MediaPlayer getMediaPlayer()
  {
    if (this.mMediaPlayer == null) {
      this.mMediaPlayer = new MediaPlayer();
    }
    return this.mMediaPlayer;
  }
  
  public int getOutBitRate()
  {
    return this.mOutBitRate;
  }
  
  public int getOutChannel()
  {
    return this.mOutChannel;
  }
  
  public int getOutSampleRate()
  {
    return this.mOutSampleRate;
  }
  
  public void getPlayTime()
  {
    if (this.mMediaPlayer != null) {}
  }
  
  public int getQuality()
  {
    return this.mQuality;
  }
  
  public String getRecordFilPath()
  {
    return this.mRecordFilPath;
  }
  
  public long getRecordTime()
  {
    return this.mRecordTime;
  }
  
  public int getVoiceLevel()
  {
    return this.mVoiceLevel;
  }
  
  public int getVoiceSize(int paramInt, short[] paramArrayOfShort)
  {
    if (this.isRecording)
    {
      long l = 0L;
      int i = 0;
      try
      {
        while (i < paramArrayOfShort.length)
        {
          l += paramArrayOfShort[i] * paramArrayOfShort[i];
          i += 1;
        }
        paramInt = (int)(Math.log10(l / paramInt) * 10.0D) / 10;
        return paramInt - 1;
      }
      catch (Exception paramArrayOfShort)
      {
        paramArrayOfShort.printStackTrace();
      }
    }
    return 1;
  }
  
  public boolean isPause()
  {
    return this.isPause;
  }
  
  public boolean isRecording()
  {
    return this.isRecording;
  }
  
  public void onDestory()
  {
    stopPlay();
    restoreRecording();
  }
  
  public boolean play()
  {
    return play(this.mPlayFilePath);
  }
  
  public boolean play(String paramString)
  {
    if (this.isRecording)
    {
      QMLog.e(TAG, "请先关闭录音");
      return false;
    }
    if (this.mMediaPlayer == null) {
      this.mMediaPlayer = new MediaPlayer();
    }
    try
    {
      this.mMediaPlayer.setAudioStreamType(3);
      this.mMediaPlayer.setDataSource(paramString);
      this.mMediaPlayer.prepareAsync();
      this.mMediaPlayer.setOnPreparedListener(new LameMp3EncodeThread.1(this));
      this.mMediaPlayer.setOnCompletionListener(new LameMp3EncodeThread.2(this));
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.mMainHandler.sendMessage(LameMp3Recorder.generatePlayErrMsg(AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getString(R.string.mini_sdk_record_play_error)));
      stopPlay();
    }
    return false;
  }
  
  public boolean playPause()
  {
    if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()))
    {
      this.mMediaPlayer.pause();
      return true;
    }
    return false;
  }
  
  public boolean playResume()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.start();
      return true;
    }
    return false;
  }
  
  public void restoreRecording()
  {
    this.isRecording = false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   4: ifeq +13 -> 17
    //   7: getstatic 41	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   10: ldc_w 335
    //   13: invokestatic 338	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: return
    //   17: aload_0
    //   18: getfield 249	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   21: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +13 -> 37
    //   27: getstatic 41	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   30: ldc_w 340
    //   33: invokestatic 185	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: return
    //   37: aload_0
    //   38: getfield 108	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mNativeLoaded	Z
    //   41: ifne +42 -> 83
    //   44: aload_0
    //   45: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   48: ifnull -32 -> 16
    //   51: aload_0
    //   52: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   55: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   58: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   61: invokeinterface 60 1 0
    //   66: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   69: getstatic 343	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_so_unload	I
    //   72: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   75: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   78: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   81: pop
    //   82: return
    //   83: bipush 237
    //   85: invokestatic 351	android/os/Process:setThreadPriority	(I)V
    //   88: aload_0
    //   89: getfield 90	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   92: bipush 16
    //   94: iconst_2
    //   95: invokestatic 357	android/media/AudioRecord:getMinBufferSize	(III)I
    //   98: istore 6
    //   100: iload 6
    //   102: ifge +42 -> 144
    //   105: aload_0
    //   106: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   109: ifnull -93 -> 16
    //   112: aload_0
    //   113: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   116: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   119: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   122: invokeinterface 60 1 0
    //   127: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   130: getstatic 360	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_samplerate_error	I
    //   133: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   136: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   139: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   142: pop
    //   143: return
    //   144: aload_0
    //   145: getfield 90	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   148: iconst_2
    //   149: imul
    //   150: iconst_1
    //   151: imul
    //   152: iconst_5
    //   153: imul
    //   154: newarray short
    //   156: astore 14
    //   158: ldc2_w 361
    //   161: aload 14
    //   163: arraylength
    //   164: i2d
    //   165: ldc2_w 363
    //   168: dmul
    //   169: dadd
    //   170: d2i
    //   171: newarray byte
    //   173: astore 12
    //   175: aload_0
    //   176: getfield 366	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   179: ifle +1067 -> 1246
    //   182: aload_0
    //   183: getfield 366	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   186: newarray byte
    //   188: astore 10
    //   190: new 368	java/io/FileOutputStream
    //   193: dup
    //   194: aload_0
    //   195: getfield 249	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   198: invokestatic 370	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:createSDFile	(Ljava/lang/String;)Ljava/io/File;
    //   201: invokespecial 373	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   204: astore 11
    //   206: aload 11
    //   208: ifnonnull +138 -> 346
    //   211: getstatic 41	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   214: ldc_w 375
    //   217: invokestatic 185	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_0
    //   221: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   224: ifnull -208 -> 16
    //   227: aload_0
    //   228: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   231: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   234: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   237: invokeinterface 60 1 0
    //   242: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   245: getstatic 378	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_input_null	I
    //   248: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   251: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   254: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   257: pop
    //   258: return
    //   259: astore 8
    //   261: aload_0
    //   262: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   265: ifnull -249 -> 16
    //   268: aload_0
    //   269: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   272: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   275: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   278: invokeinterface 60 1 0
    //   283: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   286: getstatic 381	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_mk_file_error	I
    //   289: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   292: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   295: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   298: pop
    //   299: return
    //   300: astore 8
    //   302: aload_0
    //   303: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   306: ifnull +34 -> 340
    //   309: aload_0
    //   310: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   313: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   316: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   319: invokeinterface 60 1 0
    //   324: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   327: getstatic 384	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_wr_file_error	I
    //   330: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   333: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   336: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   339: pop
    //   340: aconst_null
    //   341: astore 11
    //   343: goto -137 -> 206
    //   346: aload_0
    //   347: getfield 90	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   350: aload_0
    //   351: getfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mOutChannel	I
    //   354: aload_0
    //   355: getfield 90	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   358: aload_0
    //   359: getfield 96	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mOutBitRate	I
    //   362: aload_0
    //   363: getfield 98	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mQuality	I
    //   366: invokestatic 390	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniInit	(IIIII)V
    //   369: aload_0
    //   370: iconst_1
    //   371: putfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   374: aload_0
    //   375: iconst_0
    //   376: putfield 102	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isPause	Z
    //   379: new 353	android/media/AudioRecord
    //   382: dup
    //   383: aload_0
    //   384: getfield 82	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mAudioSource	I
    //   387: aload_0
    //   388: getfield 90	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   391: bipush 16
    //   393: aload_0
    //   394: getfield 84	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mEncodingPcmFormat	I
    //   397: iload 6
    //   399: iconst_2
    //   400: imul
    //   401: invokespecial 392	android/media/AudioRecord:<init>	(IIIII)V
    //   404: astore 13
    //   406: aload 13
    //   408: invokestatic 398	allc:a	(Landroid/media/AudioRecord;)V
    //   411: aload_0
    //   412: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   415: ifnull +837 -> 1252
    //   418: aload_0
    //   419: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   422: iconst_1
    //   423: invokevirtual 402	android/os/Handler:sendEmptyMessage	(I)Z
    //   426: pop
    //   427: goto +825 -> 1252
    //   430: aload_0
    //   431: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   434: ifeq +799 -> 1233
    //   437: aload_0
    //   438: getfield 102	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isPause	Z
    //   441: istore 7
    //   443: iload 7
    //   445: ifeq +61 -> 506
    //   448: iload_2
    //   449: ifne -19 -> 430
    //   452: iconst_1
    //   453: istore_2
    //   454: goto -24 -> 430
    //   457: astore 8
    //   459: aload_0
    //   460: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   463: ifnull +34 -> 497
    //   466: aload_0
    //   467: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   470: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   473: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   476: invokeinterface 60 1 0
    //   481: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   484: getstatic 405	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_init_error	I
    //   487: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   490: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   493: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   496: pop
    //   497: invokestatic 408	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   500: aload_0
    //   501: iconst_0
    //   502: putfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   505: return
    //   506: iload_2
    //   507: ifeq +729 -> 1236
    //   510: iconst_0
    //   511: istore_2
    //   512: aload 13
    //   514: aload 14
    //   516: iconst_0
    //   517: iload 6
    //   519: invokevirtual 412	android/media/AudioRecord:read	([SII)I
    //   522: istore_3
    //   523: aload_0
    //   524: aload_0
    //   525: iload_3
    //   526: aload 14
    //   528: invokevirtual 414	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:getVoiceSize	(I[S)I
    //   531: putfield 254	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mVoiceLevel	I
    //   534: iload_3
    //   535: ifge +191 -> 726
    //   538: aload_0
    //   539: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   542: ifnull +691 -> 1233
    //   545: aload_0
    //   546: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   549: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   552: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   555: invokeinterface 60 1 0
    //   560: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   563: getstatic 417	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_error	I
    //   566: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   569: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   572: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   575: pop
    //   576: goto +686 -> 1262
    //   579: aload_0
    //   580: aload 8
    //   582: iload 7
    //   584: invokespecial 419	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   587: iload_1
    //   588: ifle +25 -> 613
    //   591: iload_1
    //   592: newarray byte
    //   594: astore 8
    //   596: aload 10
    //   598: iconst_0
    //   599: aload 8
    //   601: iconst_0
    //   602: iload_1
    //   603: invokestatic 423	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   606: aload_0
    //   607: aload 8
    //   609: iconst_1
    //   610: invokespecial 419	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   613: aload 12
    //   615: invokestatic 427	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniFlush	([B)I
    //   618: istore_1
    //   619: iload_1
    //   620: ifge +41 -> 661
    //   623: aload_0
    //   624: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   627: ifnull +34 -> 661
    //   630: aload_0
    //   631: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   634: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   637: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   640: invokeinterface 60 1 0
    //   645: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   648: getstatic 430	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_encode_error	I
    //   651: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   654: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   657: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   660: pop
    //   661: iload_1
    //   662: ifeq +12 -> 674
    //   665: aload 11
    //   667: aload 12
    //   669: iconst_0
    //   670: iload_1
    //   671: invokevirtual 434	java/io/FileOutputStream:write	([BII)V
    //   674: aload 11
    //   676: invokevirtual 437	java/io/FileOutputStream:close	()V
    //   679: aload 13
    //   681: invokevirtual 440	android/media/AudioRecord:stop	()V
    //   684: aload 13
    //   686: invokevirtual 443	android/media/AudioRecord:release	()V
    //   689: invokestatic 408	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   692: aload_0
    //   693: iconst_0
    //   694: putfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   697: aload_0
    //   698: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   701: ifnull -685 -> 16
    //   704: aload_0
    //   705: getfield 110	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mp3Player	Lcom/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder;
    //   708: invokevirtual 446	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:getRecordDuration	()J
    //   711: lconst_1
    //   712: lcmp
    //   713: ifle +473 -> 1186
    //   716: aload_0
    //   717: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   720: iconst_5
    //   721: invokevirtual 402	android/os/Handler:sendEmptyMessage	(I)Z
    //   724: pop
    //   725: return
    //   726: iload_3
    //   727: ifne +6 -> 733
    //   730: goto -300 -> 430
    //   733: aload 14
    //   735: aload 14
    //   737: iload_3
    //   738: aload 12
    //   740: invokestatic 450	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniEncode	([S[SI[B)I
    //   743: istore 5
    //   745: iload 5
    //   747: ifge +44 -> 791
    //   750: aload_0
    //   751: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   754: ifnull +479 -> 1233
    //   757: aload_0
    //   758: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   761: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   764: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   767: invokeinterface 60 1 0
    //   772: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   775: getstatic 430	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_encode_error	I
    //   778: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   781: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   784: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   787: pop
    //   788: goto +474 -> 1262
    //   791: iload_1
    //   792: istore 4
    //   794: aload 8
    //   796: astore 9
    //   798: iload 5
    //   800: ifeq +205 -> 1005
    //   803: aload 11
    //   805: aload 12
    //   807: iconst_0
    //   808: iload 5
    //   810: invokevirtual 434	java/io/FileOutputStream:write	([BII)V
    //   813: iload_1
    //   814: istore 4
    //   816: aload 8
    //   818: astore 9
    //   820: aload_0
    //   821: getfield 366	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   824: ifle +181 -> 1005
    //   827: aload 8
    //   829: astore 9
    //   831: aload 8
    //   833: ifnull +13 -> 846
    //   836: aload_0
    //   837: aload 8
    //   839: iconst_0
    //   840: invokespecial 419	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   843: aconst_null
    //   844: astore 9
    //   846: iconst_0
    //   847: istore_3
    //   848: iload_1
    //   849: istore 4
    //   851: iload_1
    //   852: iload 5
    //   854: iadd
    //   855: istore 5
    //   857: iload 4
    //   859: istore_1
    //   860: aload 9
    //   862: astore 8
    //   864: iload 5
    //   866: istore 4
    //   868: iload 4
    //   870: aload_0
    //   871: getfield 366	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   874: if_icmplt +109 -> 983
    //   877: aload_0
    //   878: getfield 366	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   881: newarray byte
    //   883: astore 9
    //   885: iload_1
    //   886: ifle +70 -> 956
    //   889: aload 10
    //   891: iconst_0
    //   892: aload 9
    //   894: iconst_0
    //   895: iload_1
    //   896: invokestatic 423	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   899: aload_0
    //   900: getfield 366	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   903: iload_1
    //   904: isub
    //   905: istore 5
    //   907: aload 12
    //   909: iconst_0
    //   910: aload 9
    //   912: iload_1
    //   913: iload 5
    //   915: invokestatic 423	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   918: iconst_0
    //   919: istore_1
    //   920: iload_3
    //   921: iload 5
    //   923: iadd
    //   924: istore_3
    //   925: iload 4
    //   927: aload_0
    //   928: getfield 366	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   931: isub
    //   932: istore 4
    //   934: iload 4
    //   936: aload_0
    //   937: getfield 366	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   940: if_icmplt +299 -> 1239
    //   943: aload_0
    //   944: aload 9
    //   946: iconst_0
    //   947: invokespecial 419	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   950: aconst_null
    //   951: astore 8
    //   953: goto -85 -> 868
    //   956: aload 12
    //   958: iload_3
    //   959: aload 9
    //   961: iconst_0
    //   962: aload_0
    //   963: getfield 366	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   966: invokestatic 423	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   969: aload_0
    //   970: getfield 366	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   973: istore 5
    //   975: iload 5
    //   977: iload_3
    //   978: iadd
    //   979: istore_3
    //   980: goto -55 -> 925
    //   983: iload 4
    //   985: ifle +30 -> 1015
    //   988: aload 12
    //   990: iload_3
    //   991: aload 10
    //   993: iload_1
    //   994: iload 4
    //   996: iload_1
    //   997: isub
    //   998: invokestatic 423	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1001: aload 8
    //   1003: astore 9
    //   1005: iload 4
    //   1007: istore_1
    //   1008: aload 9
    //   1010: astore 8
    //   1012: goto -582 -> 430
    //   1015: iconst_0
    //   1016: istore 4
    //   1018: aload 8
    //   1020: astore 9
    //   1022: goto -17 -> 1005
    //   1025: astore 8
    //   1027: aload 9
    //   1029: astore 8
    //   1031: aload_0
    //   1032: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1035: ifnull +242 -> 1277
    //   1038: aload_0
    //   1039: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1042: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   1045: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   1048: invokeinterface 60 1 0
    //   1053: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1056: getstatic 453	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_write_file_error	I
    //   1059: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1062: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   1065: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1068: pop
    //   1069: goto +208 -> 1277
    //   1072: astore 8
    //   1074: aload_0
    //   1075: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1078: ifnull -404 -> 674
    //   1081: aload_0
    //   1082: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1085: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   1088: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   1091: invokeinterface 60 1 0
    //   1096: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1099: getstatic 453	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_write_file_error	I
    //   1102: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1105: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   1108: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1111: pop
    //   1112: goto -438 -> 674
    //   1115: astore 8
    //   1117: aload 13
    //   1119: invokevirtual 440	android/media/AudioRecord:stop	()V
    //   1122: aload 13
    //   1124: invokevirtual 443	android/media/AudioRecord:release	()V
    //   1127: aload 8
    //   1129: athrow
    //   1130: astore 8
    //   1132: invokestatic 408	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   1135: aload_0
    //   1136: iconst_0
    //   1137: putfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   1140: aload 8
    //   1142: athrow
    //   1143: astore 8
    //   1145: aload_0
    //   1146: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1149: ifnull -470 -> 679
    //   1152: aload_0
    //   1153: getfield 112	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1156: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   1159: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getMiniAppEnv	()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppEnv;
    //   1162: invokeinterface 60 1 0
    //   1167: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1170: getstatic 456	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_close_error	I
    //   1173: invokevirtual 77	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1176: invokestatic 346	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   1179: invokevirtual 232	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1182: pop
    //   1183: goto -504 -> 679
    //   1186: new 136	java/io/File
    //   1189: dup
    //   1190: aload_0
    //   1191: getfield 249	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   1194: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   1197: astore 8
    //   1199: aload 8
    //   1201: invokevirtual 141	java/io/File:exists	()Z
    //   1204: ifeq -1188 -> 16
    //   1207: aload 8
    //   1209: invokevirtual 459	java/io/File:delete	()Z
    //   1212: pop
    //   1213: return
    //   1214: astore 8
    //   1216: aload 9
    //   1218: astore 8
    //   1220: goto -189 -> 1031
    //   1223: astore 9
    //   1225: goto -194 -> 1031
    //   1228: astore 9
    //   1230: goto -199 -> 1031
    //   1233: goto +29 -> 1262
    //   1236: goto -724 -> 512
    //   1239: aload 9
    //   1241: astore 8
    //   1243: goto -375 -> 868
    //   1246: aconst_null
    //   1247: astore 10
    //   1249: goto -1059 -> 190
    //   1252: iconst_0
    //   1253: istore_2
    //   1254: iconst_0
    //   1255: istore_1
    //   1256: aconst_null
    //   1257: astore 8
    //   1259: goto -829 -> 430
    //   1262: aload 8
    //   1264: ifnull -677 -> 587
    //   1267: iload_1
    //   1268: ifne +12 -> 1280
    //   1271: iconst_1
    //   1272: istore 7
    //   1274: goto -695 -> 579
    //   1277: goto -15 -> 1262
    //   1280: iconst_0
    //   1281: istore 7
    //   1283: goto -704 -> 579
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1286	0	this	LameMp3EncodeThread
    //   587	681	1	i	int
    //   448	806	2	j	int
    //   522	469	3	k	int
    //   792	225	4	m	int
    //   743	236	5	n	int
    //   98	420	6	i1	int
    //   441	841	7	bool	boolean
    //   259	1	8	localFileNotFoundException	java.io.FileNotFoundException
    //   300	1	8	localIOException	IOException
    //   457	124	8	localIllegalStateException	java.lang.IllegalStateException
    //   594	425	8	localObject1	java.lang.Object
    //   1025	1	8	localThrowable1	Throwable
    //   1029	1	8	localObject2	java.lang.Object
    //   1072	1	8	localThrowable2	Throwable
    //   1115	13	8	localObject3	java.lang.Object
    //   1130	11	8	localObject4	java.lang.Object
    //   1143	1	8	localThrowable3	Throwable
    //   1197	11	8	localFile	File
    //   1214	1	8	localThrowable4	Throwable
    //   1218	45	8	localObject5	java.lang.Object
    //   796	421	9	localObject6	java.lang.Object
    //   1223	1	9	localThrowable5	Throwable
    //   1228	12	9	localThrowable6	Throwable
    //   188	1060	10	arrayOfByte1	byte[]
    //   204	600	11	localFileOutputStream	java.io.FileOutputStream
    //   173	816	12	arrayOfByte2	byte[]
    //   404	719	13	localAudioRecord	android.media.AudioRecord
    //   156	580	14	arrayOfShort	short[]
    // Exception table:
    //   from	to	target	type
    //   190	206	259	java/io/FileNotFoundException
    //   190	206	300	java/io/IOException
    //   406	411	457	java/lang/IllegalStateException
    //   889	918	1025	java/lang/Throwable
    //   956	975	1025	java/lang/Throwable
    //   665	674	1072	java/lang/Throwable
    //   411	427	1115	finally
    //   430	443	1115	finally
    //   512	534	1115	finally
    //   538	576	1115	finally
    //   579	587	1115	finally
    //   591	613	1115	finally
    //   613	619	1115	finally
    //   623	661	1115	finally
    //   665	674	1115	finally
    //   674	679	1115	finally
    //   733	745	1115	finally
    //   750	788	1115	finally
    //   803	813	1115	finally
    //   820	827	1115	finally
    //   836	843	1115	finally
    //   868	885	1115	finally
    //   889	918	1115	finally
    //   925	950	1115	finally
    //   956	975	1115	finally
    //   988	1001	1115	finally
    //   1031	1069	1115	finally
    //   1074	1112	1115	finally
    //   1145	1183	1115	finally
    //   406	411	1130	finally
    //   459	497	1130	finally
    //   679	689	1130	finally
    //   1117	1130	1130	finally
    //   674	679	1143	java/lang/Throwable
    //   925	950	1214	java/lang/Throwable
    //   868	885	1223	java/lang/Throwable
    //   988	1001	1223	java/lang/Throwable
    //   803	813	1228	java/lang/Throwable
    //   820	827	1228	java/lang/Throwable
    //   836	843	1228	java/lang/Throwable
  }
  
  public void setAudioSource(int paramInt)
  {
    this.mAudioSource = paramInt;
  }
  
  public void setAudioSource(String paramString)
  {
    int j = 1;
    int i;
    if (TextUtils.isEmpty(paramString)) {
      i = j;
    }
    for (;;)
    {
      setAudioSource(i);
      return;
      paramString = paramString.toLowerCase();
      if ("auto".equals(paramString))
      {
        i = 0;
      }
      else
      {
        i = j;
        if (!"mic".equals(paramString)) {
          if ("camcorder".equals(paramString))
          {
            i = 5;
          }
          else if ("voice_communication".equals(paramString))
          {
            i = 7;
          }
          else
          {
            i = j;
            if ("voice_recognition".equals(paramString)) {
              i = 6;
            }
          }
        }
      }
    }
  }
  
  public void setCallbackFrameSize(int paramInt)
  {
    this.mCallbackFrameSize = paramInt;
  }
  
  public void setEncodingPcmFormat(int paramInt)
  {
    this.mEncodingPcmFormat = paramInt;
  }
  
  public void setFilePath(String paramString)
  {
    this.mRecordFilPath = paramString;
  }
  
  public void setFilePlayPath(String paramString)
  {
    this.mPlayFilePath = paramString;
  }
  
  public void setInSampleRate(int paramInt)
  {
    this.mInSampleRate = paramInt;
  }
  
  public void setOutBitRate(int paramInt)
  {
    this.mOutBitRate = paramInt;
  }
  
  public void setOutChannel(int paramInt)
  {
    this.mOutChannel = paramInt;
  }
  
  public void setOutSampleRate(int paramInt)
  {
    this.mOutSampleRate = paramInt;
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.isPause = paramBoolean;
  }
  
  public void setQuality(int paramInt)
  {
    this.mQuality = paramInt;
  }
  
  public void setRecordFilPath(String paramString)
  {
    this.mRecordFilPath = paramString;
  }
  
  public void setRecordFileFormat(String paramString)
  {
    this.mAudioFileFormat = paramString;
  }
  
  public void setRecordTime(long paramLong)
  {
    this.mRecordTime = paramLong;
  }
  
  public void startRecord()
  {
    ThreadManager.getSubThreadHandler().post(this);
  }
  
  public boolean stopPlay()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread
 * JD-Core Version:    0.7.0.1
 */
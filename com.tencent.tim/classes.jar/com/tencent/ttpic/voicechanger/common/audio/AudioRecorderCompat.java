package com.tencent.ttpic.voicechanger.common.audio;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.logic.watermark.FFTData;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class AudioRecorderCompat
{
  public static int AUDIO_BIT_RATE = BIT_RATES[1];
  public static int AUDIO_CHANNEL_COUNT = 0;
  public static int AUDIO_INPUT_BUFFER_SIZE = (int)(AUDIO_SAMPLE_RATE_IN_HZ * 0.02D * AUDIO_CHANNEL_COUNT * 4.0D);
  public static int AUDIO_OUTPUT_BUFFER_SIZE = AUDIO_INPUT_BUFFER_SIZE * AUDIO_CHANNEL_COUNT;
  public static int AUDIO_SAMPLE_RATE_IN_HZ = 0;
  public static final int[] BIT_RATES;
  public static final int ERROR_AUDIO_FILE_NOT_EXIST = 1;
  public static final int ERROR_AUDIO_ILLEGAL_ARGUMENT = 3;
  public static final int ERROR_AUDIO_INIT_AUDIORECORD_FAILED = 4;
  public static final int ERROR_AUDIO_OUT_OF_MEMORY = 2;
  public static final int ERROR_AUDIO_REAL_PACKER_FAILED = 7;
  public static final int ERROR_AUDIO_RECORD_READ_FAILED = 6;
  public static final int ERROR_AUDIO_RECORD_START_FAILED = 5;
  public static final int[] SAMPLE_RATES;
  protected static final String TAG = AudioRecorderCompat.class.getSimpleName();
  public static final int WX_VOICE_HTTP_ERROR_NETWORK = -201;
  protected AudioRecord mARecorder;
  protected AsyncPcmWriter mAsyncPcmWriter;
  protected String mAudioPath;
  protected int mBufSize = AUDIO_OUTPUT_BUFFER_SIZE;
  protected byte[] mBuffer;
  protected State mCurrentState = new State();
  private int mDecibel;
  protected int mDelay;
  private FFTData mFFTDataResult = new FFTData(AUDIO_INPUT_BUFFER_SIZE, AUDIO_SAMPLE_RATE_IN_HZ / 2);
  protected boolean mHasDelaySet;
  protected int mHasRecordLength;
  private int mLastBufferSize = AUDIO_INPUT_BUFFER_SIZE;
  private int mLastSampleRate = AUDIO_SAMPLE_RATE_IN_HZ;
  protected AudioListener mListener;
  protected OnErrorListener mOnErrorListener;
  protected RealTimePcmPacker mPcmPacker;
  protected boolean mRealPackerEnable;
  protected SimpleRecordThread mRecThread;
  protected boolean mVoice2TextEnable;
  protected boolean mVoiceChangeEnable;
  protected VoiceChanger mVoiceChanger;
  protected boolean mWrite2FileEnable;
  private short[] mfftbuffer = new short[AUDIO_INPUT_BUFFER_SIZE];
  private boolean needDB = false;
  
  static
  {
    SAMPLE_RATES = new int[] { 8000, 11025, 16000, 22050, 44100, 48000 };
    BIT_RATES = new int[] { 64000, 96000, 128000 };
    AUDIO_SAMPLE_RATE_IN_HZ = SAMPLE_RATES[2];
    AUDIO_CHANNEL_COUNT = 1;
  }
  
  public AudioRecorderCompat(String paramString)
  {
    this.mAudioPath = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = true;
      this.mWrite2FileEnable = bool1;
      if ((TextUtils.isEmpty(paramString)) || (!this.mAudioPath.endsWith(".m4a"))) {
        break label123;
      }
    }
    label123:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mRealPackerEnable = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public void enableVoice2Text(Context paramContext, OnErrorListener paramOnErrorListener)
  {
    VoiceTextRecognizer.getInstance().init(paramContext, true);
    VoiceTextRecognizer.getInstance().setVRErrorListener(new AudioRecorderCompat.1(this, paramOnErrorListener));
    VoiceTextRecognizer.getInstance().start();
    this.mVoice2TextEnable = true;
  }
  
  public int getDecibel()
  {
    return this.mDecibel;
  }
  
  public int getDelay()
  {
    return this.mDelay;
  }
  
  public FFTData getFFTResult()
  {
    return this.mFFTDataResult;
  }
  
  public int init()
  {
    return initWithAudioSource(1);
  }
  
  public int init(int paramInt1, int paramInt2)
  {
    return initWithAudioSource(1, paramInt1, paramInt2);
  }
  
  /* Error */
  public int initWithAudioSource(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: getstatic 101	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   9: bipush 16
    //   11: iconst_2
    //   12: invokestatic 234	android/media/AudioRecord:getMinBufferSize	(III)I
    //   15: putfield 127	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   18: getstatic 90	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   21: new 236	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   28: ldc 239
    //   30: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 127	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   37: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 255	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 127	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   50: getstatic 113	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   53: if_icmpgt +10 -> 63
    //   56: aload_0
    //   57: getstatic 113	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   60: putfield 127	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 127	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   68: newarray byte
    //   70: putfield 257	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
    //   73: aload_0
    //   74: new 231	android/media/AudioRecord
    //   77: dup
    //   78: iload_1
    //   79: getstatic 101	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   82: getstatic 103	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_CHANNEL_COUNT	I
    //   85: bipush 16
    //   87: imul
    //   88: iconst_2
    //   89: aload_0
    //   90: getfield 127	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   93: invokespecial 260	android/media/AudioRecord:<init>	(IIIII)V
    //   96: putfield 262	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   99: aload_0
    //   100: getfield 262	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   103: invokevirtual 265	android/media/AudioRecord:getState	()I
    //   106: iconst_1
    //   107: if_icmpeq +72 -> 179
    //   110: getstatic 90	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   113: ldc_w 267
    //   116: invokestatic 270	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: getfield 125	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   123: iconst_1
    //   124: invokevirtual 274	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   127: iconst_4
    //   128: ireturn
    //   129: astore 6
    //   131: getstatic 90	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   134: aload 6
    //   136: invokevirtual 277	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   139: invokestatic 270	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 125	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   146: iconst_1
    //   147: invokevirtual 274	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   150: iconst_2
    //   151: ireturn
    //   152: astore 6
    //   154: getstatic 90	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   157: ldc_w 279
    //   160: aload 6
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 282	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: getfield 125	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   173: iconst_1
    //   174: invokevirtual 274	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   177: iconst_3
    //   178: ireturn
    //   179: aload_0
    //   180: getfield 262	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   183: invokevirtual 285	android/media/AudioRecord:getRecordingState	()I
    //   186: iconst_1
    //   187: if_icmpne +10 -> 197
    //   190: aload_0
    //   191: getfield 262	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   194: invokestatic 291	allc:a	(Landroid/media/AudioRecord;)V
    //   197: aload_0
    //   198: getfield 262	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   201: invokevirtual 285	android/media/AudioRecord:getRecordingState	()I
    //   204: iconst_3
    //   205: if_icmpne +10 -> 215
    //   208: aload_0
    //   209: getfield 262	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   212: invokevirtual 294	android/media/AudioRecord:stop	()V
    //   215: aload_0
    //   216: getfield 125	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   219: iconst_4
    //   220: invokevirtual 274	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   223: aload_0
    //   224: new 6	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter
    //   227: dup
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 142	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAudioPath	Ljava/lang/String;
    //   233: getstatic 111	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_INPUT_BUFFER_SIZE	I
    //   236: invokespecial 297	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;Ljava/lang/String;I)V
    //   239: putfield 299	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter;
    //   242: aload_0
    //   243: new 12	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread
    //   246: dup
    //   247: aload_0
    //   248: new 236	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 301
    //   258: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   264: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   267: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokespecial 307	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;Ljava/lang/String;)V
    //   273: putfield 309	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread;
    //   276: aload_0
    //   277: getfield 309	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread;
    //   280: invokevirtual 310	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:start	()V
    //   283: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   286: lstore_2
    //   287: getstatic 90	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   290: new 236	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 312
    //   300: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: lload_2
    //   304: lload 4
    //   306: lsub
    //   307: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   310: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 255	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: getfield 160	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mRealPackerEnable	Z
    //   320: ifeq +75 -> 395
    //   323: aload_0
    //   324: new 314	com/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker
    //   327: dup
    //   328: getstatic 105	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_BIT_RATE	I
    //   331: getstatic 101	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   334: getstatic 103	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_CHANNEL_COUNT	I
    //   337: invokespecial 317	com/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker:<init>	(III)V
    //   340: putfield 319	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mPcmPacker	Lcom/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker;
    //   343: aload_0
    //   344: getfield 319	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mPcmPacker	Lcom/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker;
    //   347: aload_0
    //   348: getfield 142	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAudioPath	Ljava/lang/String;
    //   351: invokevirtual 322	com/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker:setOutputPath	(Ljava/lang/String;)V
    //   354: aload_0
    //   355: getfield 299	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter;
    //   358: invokevirtual 325	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter:onPrepare	()V
    //   361: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   364: lstore 4
    //   366: getstatic 90	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   369: new 236	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 327
    //   379: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: lload 4
    //   384: lload_2
    //   385: lsub
    //   386: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   389: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 255	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: iconst_0
    //   396: ireturn
    //   397: astore 6
    //   399: getstatic 90	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   402: ldc_w 329
    //   405: aload 6
    //   407: iconst_0
    //   408: anewarray 4	java/lang/Object
    //   411: invokestatic 332	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   414: aload_0
    //   415: getfield 125	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   418: iconst_1
    //   419: invokevirtual 274	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   422: iconst_5
    //   423: ireturn
    //   424: astore 6
    //   426: getstatic 90	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   429: aload 6
    //   431: invokevirtual 333	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   434: invokestatic 270	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: aload_0
    //   438: getfield 125	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   441: iconst_1
    //   442: invokevirtual 274	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   445: iconst_1
    //   446: ireturn
    //   447: astore 6
    //   449: getstatic 90	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   452: aload 6
    //   454: invokevirtual 334	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   457: invokestatic 270	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload_0
    //   461: getfield 125	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   464: iconst_1
    //   465: invokevirtual 274	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   468: bipush 7
    //   470: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	AudioRecorderCompat
    //   0	471	1	paramInt	int
    //   286	99	2	l1	long
    //   3	380	4	l2	long
    //   129	6	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   152	9	6	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   397	9	6	localSecurityException	java.lang.SecurityException
    //   424	6	6	localFileNotFoundException	FileNotFoundException
    //   447	6	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   63	73	129	java/lang/OutOfMemoryError
    //   73	99	152	java/lang/IllegalArgumentException
    //   190	197	397	java/lang/SecurityException
    //   223	242	424	java/io/FileNotFoundException
    //   316	395	447	java/lang/Exception
  }
  
  public int initWithAudioSource(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = initWithAudioSource(paramInt1);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    long l = System.currentTimeMillis();
    this.mVoiceChanger = new VoiceChanger(this.mAudioPath, AUDIO_SAMPLE_RATE_IN_HZ, paramInt2, paramInt3);
    LogUtils.d(TAG, "Audio Processers: start voice changer = " + (System.currentTimeMillis() - l));
    LogUtils.d(TAG, "init() - currentState = " + this.mCurrentState);
    this.mVoiceChangeEnable = true;
    return paramInt1;
  }
  
  public void onDelaySet(int paramInt) {}
  
  public void onRecordError(int paramInt)
  {
    LogUtils.e(TAG, "onRecordError() - currentState = " + this.mCurrentState);
    if (this.mOnErrorListener != null) {
      this.mOnErrorListener.onError(paramInt);
    }
  }
  
  public void onRecordStop()
  {
    LogUtils.d(TAG, "onRecordStop() - currentState = " + this.mCurrentState);
    if (this.mAsyncPcmWriter != null) {
      this.mAsyncPcmWriter.onStop();
    }
  }
  
  public void onRecording(byte[] paramArrayOfByte, int paramInt)
  {
    if ((this.mWrite2FileEnable) && (this.mAsyncPcmWriter != null)) {
      this.mAsyncPcmWriter.onRecord(paramArrayOfByte, paramInt);
    }
    if (this.mVoice2TextEnable) {
      VoiceTextRecognizer.getInstance().recognizeFromPCMBuffer(paramArrayOfByte, paramInt);
    }
  }
  
  public void pause()
  {
    LogUtils.d(TAG, "pause() - currentState = " + this.mCurrentState);
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 16 }))
      {
        LogUtils.d(TAG, "current state has been 16");
        return;
      }
      if (!this.mCurrentState.equalState(new int[] { 8, 4 })) {
        throw new IllegalStateException("current status is: " + this.mCurrentState);
      }
    }
    this.mCurrentState.transfer(16);
  }
  
  public void release()
  {
    LogUtils.d(TAG, "release start");
    synchronized (this.mCurrentState)
    {
      if (!this.mCurrentState.equalState(new int[] { 32 }))
      {
        LogUtils.i(TAG, "stop() is forgotten by someone, so call it now!");
        stop(null);
      }
      this.mCurrentState.transfer(2);
      this.mHasRecordLength = 0;
      if ((this.mRecThread == null) || (this.mRecThread.equals(Thread.currentThread()))) {}
    }
    try
    {
      this.mRecThread.join();
      if (this.mARecorder != null) {
        this.mARecorder.release();
      }
      LogUtils.d(TAG, "AduioRecord release finish");
      this.mHasRecordLength = 0;
      LogUtils.d(TAG, "release finish");
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        LogUtils.e(TAG, localInterruptedException.getMessage());
        this.mRecThread = null;
      }
    }
  }
  
  public void resume()
  {
    LogUtils.d(TAG, "resume() - currentState = " + this.mCurrentState);
    start();
  }
  
  public void setNeedDB(boolean paramBoolean)
  {
    this.needDB = paramBoolean;
  }
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setSampleRate(int paramInt)
  {
    AUDIO_SAMPLE_RATE_IN_HZ = paramInt;
    AUDIO_INPUT_BUFFER_SIZE = (int)(AUDIO_SAMPLE_RATE_IN_HZ * 0.02D * AUDIO_CHANNEL_COUNT * 4.0D);
    AUDIO_OUTPUT_BUFFER_SIZE = AUDIO_INPUT_BUFFER_SIZE * AUDIO_CHANNEL_COUNT;
    if ((this.mLastBufferSize != AUDIO_INPUT_BUFFER_SIZE) || (this.mLastSampleRate != AUDIO_SAMPLE_RATE_IN_HZ))
    {
      this.mFFTDataResult = new FFTData(AUDIO_INPUT_BUFFER_SIZE, AUDIO_SAMPLE_RATE_IN_HZ);
      this.mfftbuffer = new short[AUDIO_INPUT_BUFFER_SIZE];
    }
  }
  
  public void start()
  {
    LogUtils.d(TAG, "start() - currentState = " + this.mCurrentState);
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 8 }))
      {
        LogUtils.w(TAG, "current state has been 8");
        return;
      }
      if (!this.mCurrentState.equalState(new int[] { 16, 4 })) {
        throw new IllegalStateException("current status is: " + this.mCurrentState);
      }
    }
    this.mCurrentState.transfer(8);
  }
  
  public void stop(AudioListener paramAudioListener)
  {
    LogUtils.d(TAG, "stop() - currentState = " + this.mCurrentState);
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 32 }))
      {
        LogUtils.d(TAG, "current state has been 32");
        return;
      }
      this.mCurrentState.transfer(32);
      if ((this.mRecThread == null) || (this.mRecThread.equals(Thread.currentThread()))) {
        return;
      }
      this.mListener = paramAudioListener;
    }
    try
    {
      this.mRecThread.join();
      LogUtils.d(TAG, "stop() - join() - currentState = " + this.mCurrentState);
      this.mRecThread = null;
      return;
      paramAudioListener = finally;
      throw paramAudioListener;
    }
    catch (InterruptedException paramAudioListener)
    {
      for (;;)
      {
        LogUtils.e(TAG, paramAudioListener.getMessage());
      }
    }
  }
  
  protected void tryReleaseChanger()
  {
    if (this.mVoiceChanger != null) {
      this.mVoiceChanger.release();
    }
  }
  
  protected void tryReleasePacker()
  {
    if (this.mPcmPacker != null) {
      this.mPcmPacker.stop();
    }
  }
  
  protected void tryReleaseRecognizer()
  {
    if (this.mVoice2TextEnable)
    {
      VoiceTextRecognizer.getInstance().destroy();
      this.mVoice2TextEnable = false;
    }
  }
  
  public class AsyncPcmWriter
    extends HandlerThread
  {
    private static final String T_TAG = "AudioRecorder.AsyncPcmWriter";
    private final LinkedList<byte[]> fileBuffers = new LinkedList();
    private Handler mHandler = null;
    private RandomAccessFile mMicfile = null;
    private int perBufSize;
    
    public AsyncPcmWriter(String paramString, int paramInt)
      throws FileNotFoundException
    {
      super();
      FileUtils.delete(paramString);
      if (AudioRecorderCompat.this.mWrite2FileEnable) {
        this.mMicfile = new RandomAccessFile(paramString, "rw");
      }
      this.perBufSize = paramInt;
      start();
      this.mHandler = new Handler(getLooper());
      int i = 0;
      while (i < 4)
      {
        this$1 = new byte[paramInt];
        this.fileBuffers.add(AudioRecorderCompat.this);
        i += 1;
      }
    }
    
    public void onPrepare()
    {
      this.mHandler.post(new AudioRecorderCompat.AsyncPcmWriter.1(this));
    }
    
    public void onRecord(byte[] paramArrayOfByte, int paramInt)
    {
      if (!AudioRecorderCompat.this.mWrite2FileEnable) {
        return;
      }
      synchronized (this.fileBuffers)
      {
        if (this.fileBuffers.size() > 0)
        {
          arrayOfByte = (byte[])this.fileBuffers.peek();
          this.fileBuffers.remove();
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
          this.mHandler.post(new AudioRecorderCompat.AsyncPcmWriter.2(this, arrayOfByte, paramInt));
          return;
        }
        byte[] arrayOfByte = new byte[this.perBufSize];
      }
    }
    
    public void onStop()
    {
      this.mHandler.post(new AudioRecorderCompat.AsyncPcmWriter.3(this));
    }
  }
  
  public static abstract interface AudioListener
  {
    public abstract void onAudioRecordFinish();
  }
  
  class SimpleRecordThread
    extends Thread
  {
    private static final String TAG = "SimpleRecordThread";
    
    public SimpleRecordThread(String paramString)
    {
      super();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 10
      //   2: new 28	java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   9: aload_0
      //   10: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
      //   13: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: ldc 40
      //   18: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   24: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   27: aload_0
      //   28: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   31: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   34: astore 4
      //   36: aload 4
      //   38: monitorenter
      //   39: aload_0
      //   40: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   43: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   46: iconst_1
      //   47: newarray int
      //   49: dup
      //   50: iconst_0
      //   51: iconst_4
      //   52: iastore
      //   53: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:equalState	([I)Z
      //   56: ifeq +94 -> 150
      //   59: ldc 10
      //   61: ldc 61
      //   63: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   66: ldc 10
      //   68: new 28	java/lang/StringBuilder
      //   71: dup
      //   72: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   75: aload_0
      //   76: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
      //   79: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   82: ldc 66
      //   84: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   87: aload_0
      //   88: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   91: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   94: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   97: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   100: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   103: aload_0
      //   104: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   107: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   110: invokevirtual 74	java/lang/Object:wait	()V
      //   113: ldc 10
      //   115: new 28	java/lang/StringBuilder
      //   118: dup
      //   119: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   122: aload_0
      //   123: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
      //   126: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   129: ldc 76
      //   131: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   134: aload_0
      //   135: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   138: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   141: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   144: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   147: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   150: aload 4
      //   152: monitorexit
      //   153: aload_0
      //   154: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   157: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   160: astore 4
      //   162: aload 4
      //   164: monitorenter
      //   165: aload_0
      //   166: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   169: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   172: iconst_1
      //   173: newarray int
      //   175: dup
      //   176: iconst_0
      //   177: bipush 16
      //   179: iastore
      //   180: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:equalState	([I)Z
      //   183: ifeq +148 -> 331
      //   186: ldc 10
      //   188: ldc 78
      //   190: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   193: aload_0
      //   194: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   197: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
      //   200: invokevirtual 88	android/media/AudioRecord:getRecordingState	()I
      //   203: iconst_3
      //   204: if_icmpne +43 -> 247
      //   207: ldc 10
      //   209: new 28	java/lang/StringBuilder
      //   212: dup
      //   213: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   216: ldc 90
      //   218: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   221: aload_0
      //   222: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   225: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   228: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   231: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   234: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   237: aload_0
      //   238: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   241: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
      //   244: invokevirtual 93	android/media/AudioRecord:stop	()V
      //   247: ldc 10
      //   249: new 28	java/lang/StringBuilder
      //   252: dup
      //   253: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   256: aload_0
      //   257: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
      //   260: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: ldc 66
      //   265: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   268: aload_0
      //   269: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   272: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   275: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   278: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   281: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   284: aload_0
      //   285: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   288: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   291: invokevirtual 74	java/lang/Object:wait	()V
      //   294: ldc 10
      //   296: new 28	java/lang/StringBuilder
      //   299: dup
      //   300: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   303: aload_0
      //   304: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
      //   307: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   310: ldc 76
      //   312: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   315: aload_0
      //   316: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   319: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   322: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   325: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   328: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   331: aload 4
      //   333: monitorexit
      //   334: aload_0
      //   335: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   338: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   341: iconst_2
      //   342: newarray int
      //   344: dup
      //   345: iconst_0
      //   346: bipush 32
      //   348: iastore
      //   349: dup
      //   350: iconst_1
      //   351: iconst_1
      //   352: iastore
      //   353: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:equalState	([I)Z
      //   356: ifeq +159 -> 515
      //   359: ldc 10
      //   361: ldc 95
      //   363: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   366: aload_0
      //   367: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   370: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
      //   373: invokevirtual 88	android/media/AudioRecord:getRecordingState	()I
      //   376: iconst_3
      //   377: if_icmpne +43 -> 420
      //   380: ldc 10
      //   382: new 28	java/lang/StringBuilder
      //   385: dup
      //   386: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   389: ldc 90
      //   391: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   394: aload_0
      //   395: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   398: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   401: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   404: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   407: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   410: aload_0
      //   411: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   414: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
      //   417: invokevirtual 93	android/media/AudioRecord:stop	()V
      //   420: aload_0
      //   421: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   424: invokevirtual 98	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onRecordStop	()V
      //   427: aload_0
      //   428: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   431: aconst_null
      //   432: putfield 102	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mOnErrorListener	Lcom/tencent/ttpic/voicechanger/common/audio/OnErrorListener;
      //   435: ldc 10
      //   437: new 28	java/lang/StringBuilder
      //   440: dup
      //   441: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   444: aload_0
      //   445: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:getName	()Ljava/lang/String;
      //   448: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   451: ldc 104
      //   453: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   456: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   459: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   462: return
      //   463: astore 5
      //   465: ldc 10
      //   467: ldc 106
      //   469: aload 5
      //   471: iconst_0
      //   472: anewarray 71	java/lang/Object
      //   475: invokestatic 110	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
      //   478: goto -365 -> 113
      //   481: astore 5
      //   483: aload 4
      //   485: monitorexit
      //   486: aload 5
      //   488: athrow
      //   489: astore 5
      //   491: ldc 10
      //   493: ldc 106
      //   495: aload 5
      //   497: iconst_0
      //   498: anewarray 71	java/lang/Object
      //   501: invokestatic 110	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
      //   504: goto -210 -> 294
      //   507: astore 5
      //   509: aload 4
      //   511: monitorexit
      //   512: aload 5
      //   514: athrow
      //   515: aload_0
      //   516: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   519: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   522: iconst_1
      //   523: newarray int
      //   525: dup
      //   526: iconst_0
      //   527: bipush 8
      //   529: iastore
      //   530: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:equalState	([I)Z
      //   533: ifeq +437 -> 970
      //   536: ldc 10
      //   538: ldc 112
      //   540: invokestatic 115	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   543: aload_0
      //   544: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   547: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
      //   550: invokevirtual 88	android/media/AudioRecord:getRecordingState	()I
      //   553: iconst_1
      //   554: if_icmpne +215 -> 769
      //   557: invokestatic 121	java/lang/System:currentTimeMillis	()J
      //   560: lstore_2
      //   561: aload_0
      //   562: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   565: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
      //   568: invokestatic 127	allc:a	(Landroid/media/AudioRecord;)V
      //   571: ldc 10
      //   573: new 28	java/lang/StringBuilder
      //   576: dup
      //   577: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   580: ldc 129
      //   582: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   585: invokestatic 121	java/lang/System:currentTimeMillis	()J
      //   588: lload_2
      //   589: lsub
      //   590: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   593: ldc 134
      //   595: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   598: aload_0
      //   599: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   602: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   605: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   608: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   611: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   614: aload_0
      //   615: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   618: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
      //   621: invokevirtual 88	android/media/AudioRecord:getRecordingState	()I
      //   624: iconst_1
      //   625: if_icmpne +69 -> 694
      //   628: ldc 10
      //   630: ldc 136
      //   632: invokestatic 139	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   635: aload_0
      //   636: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   639: iconst_5
      //   640: invokevirtual 143	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onRecordError	(I)V
      //   643: aload_0
      //   644: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   647: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   650: iconst_1
      //   651: invokevirtual 146	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
      //   654: goto -627 -> 27
      //   657: astore 4
      //   659: ldc 10
      //   661: ldc 148
      //   663: aload 4
      //   665: iconst_0
      //   666: anewarray 71	java/lang/Object
      //   669: invokestatic 110	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
      //   672: aload_0
      //   673: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   676: iconst_5
      //   677: invokevirtual 143	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onRecordError	(I)V
      //   680: aload_0
      //   681: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   684: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   687: iconst_1
      //   688: invokevirtual 146	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
      //   691: goto -664 -> 27
      //   694: aload_0
      //   695: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   698: getfield 152	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mHasDelaySet	Z
      //   701: ifne +68 -> 769
      //   704: aload_0
      //   705: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   708: invokestatic 121	java/lang/System:currentTimeMillis	()J
      //   711: lload_2
      //   712: lsub
      //   713: l2i
      //   714: putfield 156	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mDelay	I
      //   717: ldc 10
      //   719: new 28	java/lang/StringBuilder
      //   722: dup
      //   723: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   726: ldc 158
      //   728: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   731: aload_0
      //   732: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   735: getfield 156	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mDelay	I
      //   738: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   741: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   744: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   747: aload_0
      //   748: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   751: aload_0
      //   752: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   755: getfield 156	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mDelay	I
      //   758: invokevirtual 164	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onDelaySet	(I)V
      //   761: aload_0
      //   762: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   765: iconst_1
      //   766: putfield 152	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mHasDelaySet	Z
      //   769: aload_0
      //   770: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   773: getfield 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
      //   776: aload_0
      //   777: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   780: getfield 168	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
      //   783: iconst_0
      //   784: getstatic 171	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_INPUT_BUFFER_SIZE	I
      //   787: invokevirtual 175	android/media/AudioRecord:read	([BII)I
      //   790: istore_1
      //   791: aload_0
      //   792: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   795: invokestatic 179	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$200	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;)Z
      //   798: ifeq +76 -> 874
      //   801: aload_0
      //   802: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   805: aload_0
      //   806: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   809: getfield 168	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
      //   812: iload_1
      //   813: invokestatic 185	com/tencent/ttpic/util/AudioUtil:getPcmDB16Bit	([BI)I
      //   816: invokestatic 189	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$302	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;I)I
      //   819: pop
      //   820: aload_0
      //   821: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   824: aload_0
      //   825: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   828: getfield 168	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
      //   831: iload_1
      //   832: invokestatic 193	com/tencent/ttpic/util/AudioUtil:pcm16BitToShort	([BI)[S
      //   835: invokestatic 197	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$402	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;[S)[S
      //   838: pop
      //   839: aload_0
      //   840: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   843: invokestatic 201	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$400	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;)[S
      //   846: ifnull +28 -> 874
      //   849: aload_0
      //   850: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   853: invokestatic 201	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$400	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;)[S
      //   856: aload_0
      //   857: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   860: invokestatic 201	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$400	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;)[S
      //   863: arraylength
      //   864: aload_0
      //   865: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   868: invokestatic 205	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:access$500	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;)Lcom/tencent/ttpic/logic/watermark/FFTData;
      //   871: invokestatic 209	com/tencent/ttpic/util/AudioUtil:getPcmFFTFromShortBuffer	([SILcom/tencent/ttpic/logic/watermark/FFTData;)V
      //   874: iload_1
      //   875: bipush 253
      //   877: if_icmpeq +13 -> 890
      //   880: iload_1
      //   881: bipush 254
      //   883: if_icmpeq +7 -> 890
      //   886: iload_1
      //   887: ifgt +50 -> 937
      //   890: ldc 10
      //   892: new 28	java/lang/StringBuilder
      //   895: dup
      //   896: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   899: ldc 211
      //   901: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   904: iload_1
      //   905: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   908: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   911: invokestatic 139	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   914: aload_0
      //   915: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   918: bipush 6
      //   920: invokevirtual 143	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onRecordError	(I)V
      //   923: aload_0
      //   924: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   927: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   930: iconst_1
      //   931: invokevirtual 146	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
      //   934: goto -907 -> 27
      //   937: aload_0
      //   938: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   941: astore 4
      //   943: aload 4
      //   945: aload 4
      //   947: getfield 214	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mHasRecordLength	I
      //   950: iload_1
      //   951: iadd
      //   952: putfield 214	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mHasRecordLength	I
      //   955: aload_0
      //   956: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   959: aload_0
      //   960: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   963: getfield 168	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
      //   966: iload_1
      //   967: invokevirtual 218	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:onRecording	([BI)V
      //   970: ldc 10
      //   972: new 28	java/lang/StringBuilder
      //   975: dup
      //   976: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   979: ldc 220
      //   981: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   984: aload_0
      //   985: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;
      //   988: getfield 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
      //   991: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   994: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   997: invokestatic 115	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   1000: goto -973 -> 27
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1003	0	this	SimpleRecordThread
      //   790	177	1	i	int
      //   560	152	2	l	long
      //   657	7	4	localSecurityException	java.lang.SecurityException
      //   941	5	4	localAudioRecorderCompat	AudioRecorderCompat
      //   463	7	5	localInterruptedException1	InterruptedException
      //   481	6	5	localObject1	Object
      //   489	7	5	localInterruptedException2	InterruptedException
      //   507	6	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   103	113	463	java/lang/InterruptedException
      //   39	103	481	finally
      //   103	113	481	finally
      //   113	150	481	finally
      //   150	153	481	finally
      //   465	478	481	finally
      //   483	486	481	finally
      //   284	294	489	java/lang/InterruptedException
      //   165	247	507	finally
      //   247	284	507	finally
      //   284	294	507	finally
      //   294	331	507	finally
      //   331	334	507	finally
      //   491	504	507	finally
      //   509	512	507	finally
      //   561	571	657	java/lang/SecurityException
    }
  }
  
  public class State
  {
    public static final int STATE_ERROR = 1;
    public static final int STATE_IDLE = 2;
    public static final int STATE_INITIALIZED = 4;
    public static final int STATE_PAUSED = 16;
    public static final int STATE_STARTED = 8;
    public static final int STATE_STOPPED = 32;
    protected int state = 2;
    
    public State() {}
    
    private String getStateName(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return "STATE_ERROR";
      case 2: 
        return "STATE_IDLE";
      case 4: 
        return "STATE_INITIALIZED";
      case 8: 
        return "STATE_STARTED";
      case 16: 
        return "STATE_PAUSED";
      }
      return "STATE_STOPPED";
    }
    
    public boolean equalState(int... paramVarArgs)
    {
      boolean bool = false;
      int j = 0;
      int i = 0;
      try
      {
        while (j < paramVarArgs.length)
        {
          i |= paramVarArgs[j];
          j += 1;
        }
        j = this.state;
        if ((j & i) != 0) {
          bool = true;
        }
        return bool;
      }
      finally {}
    }
    
    public int state()
    {
      try
      {
        int i = this.state;
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public String toString()
    {
      return "State[" + getStateName(this.state) + "]";
    }
    
    public void transfer(int paramInt)
    {
      try
      {
        LogUtils.i(AudioRecorderCompat.TAG, "switch state: " + getStateName(this.state) + " -> " + getStateName(paramInt));
        this.state = paramInt;
        AudioRecorderCompat.this.mCurrentState.notifyAll();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
 * JD-Core Version:    0.7.0.1
 */
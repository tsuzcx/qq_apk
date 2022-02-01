package com.tencent.ttpic.voicechanger.common.audio;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

@Deprecated
public class AudioRecorderAndChangerForKitKat
  extends AudioRecorderCompat
{
  public static final int AUDIO_BIT_RATE = BIT_RATES[1];
  public static final int AUDIO_CHANNEL_COUNT = 1;
  public static final int AUDIO_INPUT_BUFFER_SIZE = (int)(AUDIO_SAMPLE_RATE_IN_HZ * 0.02D * 1.0D * 4.0D);
  public static final int AUDIO_OUTPUT_BUFFER_SIZE = AUDIO_INPUT_BUFFER_SIZE * 1;
  public static final int AUDIO_SAMPLE_RATE_IN_HZ;
  public static final int[] BIT_RATES;
  public static final int ERROR_AUDIO_FILE_NOT_EXIST = 1;
  public static final int ERROR_AUDIO_ILLEGAL_ARGUMENT = 3;
  public static final int ERROR_AUDIO_INIT_AUDIORECORD_FAILED = 4;
  public static final int ERROR_AUDIO_OUT_OF_MEMORY = 2;
  public static final int ERROR_AUDIO_RECORD_READ_FAILED = 6;
  public static final int ERROR_AUDIO_RECORD_START_FAILED = 5;
  public static final int[] SAMPLE_RATES = { 8000, 11025, 16000, 22050, 44100, 48000 };
  protected AudioRecord mARecorder;
  protected AsyncPcmWriterForKitKat mAsyncPcmWriter;
  protected int mBufSize = AUDIO_OUTPUT_BUFFER_SIZE;
  protected byte[] mBuffer;
  protected State mCurrentState = new State();
  protected int mDelay;
  protected boolean mHasDelaySet;
  protected int mHasRecordLength;
  protected OnErrorListener mOnErrorListener;
  protected RealTimePcmPacker mPcmPacker;
  protected String mPcmPath;
  protected SimpleRecordThreadForKitKat mRecThread;
  protected VoiceChanger mVoiceChanger;
  protected boolean needVoiceChange = false;
  
  static
  {
    BIT_RATES = new int[] { 64000, 96000, 128000 };
    AUDIO_SAMPLE_RATE_IN_HZ = SAMPLE_RATES[5];
  }
  
  public AudioRecorderAndChangerForKitKat(String paramString)
  {
    super(paramString);
  }
  
  public int getDelay()
  {
    return this.mDelay;
  }
  
  /* Error */
  public int init()
  {
    // Byte code:
    //   0: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: getstatic 72	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   8: bipush 16
    //   10: iconst_2
    //   11: invokestatic 121	android/media/AudioRecord:getMinBufferSize	(III)I
    //   14: putfield 94	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   17: getstatic 124	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   20: new 126	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   27: ldc 130
    //   29: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 94	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   36: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 147	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 94	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   49: getstatic 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   52: if_icmpgt +10 -> 62
    //   55: aload_0
    //   56: getstatic 82	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   59: putfield 94	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 94	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   67: newarray byte
    //   69: putfield 149	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBuffer	[B
    //   72: aload_0
    //   73: new 117	android/media/AudioRecord
    //   76: dup
    //   77: iconst_1
    //   78: getstatic 72	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   81: bipush 16
    //   83: iconst_2
    //   84: aload_0
    //   85: getfield 94	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   88: invokespecial 152	android/media/AudioRecord:<init>	(IIIII)V
    //   91: putfield 154	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   94: aload_0
    //   95: getfield 154	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   98: invokevirtual 157	android/media/AudioRecord:getState	()I
    //   101: iconst_1
    //   102: if_icmpeq +66 -> 168
    //   105: getstatic 124	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   108: ldc 159
    //   110: invokestatic 162	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: getfield 92	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   117: iconst_1
    //   118: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   121: iconst_4
    //   122: ireturn
    //   123: astore_1
    //   124: getstatic 124	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   127: aload_1
    //   128: invokevirtual 169	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   131: invokestatic 162	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_0
    //   135: getfield 92	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   138: iconst_1
    //   139: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   142: iconst_2
    //   143: ireturn
    //   144: astore_1
    //   145: getstatic 124	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   148: ldc 171
    //   150: aload_1
    //   151: iconst_0
    //   152: anewarray 173	java/lang/Object
    //   155: invokestatic 176	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   158: aload_0
    //   159: getfield 92	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   162: iconst_1
    //   163: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   166: iconst_3
    //   167: ireturn
    //   168: aload_0
    //   169: getfield 154	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   172: invokevirtual 179	android/media/AudioRecord:getRecordingState	()I
    //   175: iconst_1
    //   176: if_icmpne +10 -> 186
    //   179: aload_0
    //   180: getfield 154	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   183: invokestatic 185	allc:a	(Landroid/media/AudioRecord;)V
    //   186: aload_0
    //   187: getfield 154	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   190: invokevirtual 179	android/media/AudioRecord:getRecordingState	()I
    //   193: iconst_3
    //   194: if_icmpne +10 -> 204
    //   197: aload_0
    //   198: getfield 154	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   201: invokevirtual 188	android/media/AudioRecord:stop	()V
    //   204: aload_0
    //   205: getfield 92	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   208: iconst_4
    //   209: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   212: aload_0
    //   213: new 6	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat
    //   216: dup
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 190	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mPcmPath	Ljava/lang/String;
    //   222: getstatic 80	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_INPUT_BUFFER_SIZE	I
    //   225: invokespecial 193	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;Ljava/lang/String;I)V
    //   228: putfield 195	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat;
    //   231: aload_0
    //   232: new 9	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat
    //   235: dup
    //   236: aload_0
    //   237: new 126	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   244: ldc 197
    //   246: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   252: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokespecial 203	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;Ljava/lang/String;)V
    //   261: putfield 205	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat;
    //   264: aload_0
    //   265: getfield 205	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat;
    //   268: invokevirtual 208	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:start	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: getstatic 124	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   277: ldc 210
    //   279: aload_1
    //   280: iconst_0
    //   281: anewarray 173	java/lang/Object
    //   284: invokestatic 213	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   287: aload_0
    //   288: getfield 92	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   291: iconst_1
    //   292: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   295: iconst_5
    //   296: ireturn
    //   297: astore_1
    //   298: getstatic 124	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   301: aload_1
    //   302: invokevirtual 214	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   305: invokestatic 162	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_0
    //   309: getfield 92	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   312: iconst_1
    //   313: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   316: iconst_1
    //   317: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	AudioRecorderAndChangerForKitKat
    //   123	5	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   144	7	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   273	7	1	localSecurityException	java.lang.SecurityException
    //   297	5	1	localFileNotFoundException	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   62	72	123	java/lang/OutOfMemoryError
    //   72	94	144	java/lang/IllegalArgumentException
    //   179	186	273	java/lang/SecurityException
    //   212	231	297	java/io/FileNotFoundException
  }
  
  public int init(int paramInt1, int paramInt2)
  {
    init();
    long l = System.currentTimeMillis();
    this.mVoiceChanger = new VoiceChanger(this.mPcmPath, AUDIO_SAMPLE_RATE_IN_HZ, paramInt1, paramInt2);
    this.needVoiceChange = true;
    LogUtils.d(TAG, "Audio Processers: start voice changer = " + (System.currentTimeMillis() - l));
    LogUtils.d(TAG, "init() - currentState = " + this.mCurrentState);
    return 0;
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
    if (this.mAsyncPcmWriter != null) {
      this.mAsyncPcmWriter.onRecord(paramArrayOfByte, paramInt);
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
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
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
  
  public void stop(AudioRecorderCompat.AudioListener paramAudioListener)
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
  
  public class AsyncPcmWriterForKitKat
    extends HandlerThread
  {
    protected static final String T_TAG = "AudioRecorder.AsyncPcmWriterForKitKat";
    protected boolean canSave = true;
    protected final LinkedList<byte[]> fileBuffers = new LinkedList();
    protected Handler mHandler = null;
    protected RandomAccessFile mMicfile = null;
    protected int perBufSize;
    
    public AsyncPcmWriterForKitKat(String paramString, int paramInt)
      throws FileNotFoundException
    {
      super();
      FileUtils.delete(paramString);
      this.perBufSize = paramInt;
      this.mMicfile = new RandomAccessFile(paramString, "rw");
      start();
      this.mHandler = new Handler(getLooper());
      int i = 0;
      while (i < 4)
      {
        this$1 = new byte[paramInt];
        this.fileBuffers.add(AudioRecorderAndChangerForKitKat.this);
        i += 1;
      }
    }
    
    public void onRecord(byte[] paramArrayOfByte, int paramInt)
    {
      if (!this.canSave) {
        return;
      }
      synchronized (this.fileBuffers)
      {
        if (this.fileBuffers.size() > 0)
        {
          arrayOfByte = (byte[])this.fileBuffers.peek();
          this.fileBuffers.remove();
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
          this.mHandler.post(new AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat.1(this, paramInt, arrayOfByte));
          return;
        }
        byte[] arrayOfByte = new byte[this.perBufSize];
      }
    }
    
    public void onStop()
    {
      this.mHandler.post(new AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat.2(this));
    }
  }
  
  public class SimpleRecordThreadForKitKat
    extends Thread
  {
    protected static final String TAG = "SimpleRecordThread";
    
    public SimpleRecordThreadForKitKat(String paramString)
    {
      super();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 11
      //   2: new 29	java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   9: aload_0
      //   10: invokevirtual 35	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
      //   13: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: ldc 41
      //   18: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   24: invokestatic 50	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   27: aload_0
      //   28: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   31: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   34: astore 4
      //   36: aload 4
      //   38: monitorenter
      //   39: aload_0
      //   40: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   43: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   46: iconst_1
      //   47: newarray int
      //   49: dup
      //   50: iconst_0
      //   51: iconst_4
      //   52: iastore
      //   53: invokevirtual 60	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:equalState	([I)Z
      //   56: ifeq +94 -> 150
      //   59: ldc 11
      //   61: ldc 62
      //   63: invokestatic 65	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   66: ldc 11
      //   68: new 29	java/lang/StringBuilder
      //   71: dup
      //   72: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   75: aload_0
      //   76: invokevirtual 35	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
      //   79: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   82: ldc 67
      //   84: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   87: aload_0
      //   88: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   91: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   94: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   97: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   100: invokestatic 50	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   103: aload_0
      //   104: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   107: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   110: invokevirtual 75	java/lang/Object:wait	()V
      //   113: ldc 11
      //   115: new 29	java/lang/StringBuilder
      //   118: dup
      //   119: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   122: aload_0
      //   123: invokevirtual 35	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
      //   126: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   129: ldc 77
      //   131: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   134: aload_0
      //   135: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   138: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   141: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   144: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   147: invokestatic 50	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   150: aload 4
      //   152: monitorexit
      //   153: aload_0
      //   154: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   157: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   160: astore 4
      //   162: aload 4
      //   164: monitorenter
      //   165: aload_0
      //   166: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   169: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   172: iconst_1
      //   173: newarray int
      //   175: dup
      //   176: iconst_0
      //   177: bipush 16
      //   179: iastore
      //   180: invokevirtual 60	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:equalState	([I)Z
      //   183: ifeq +148 -> 331
      //   186: ldc 11
      //   188: ldc 79
      //   190: invokestatic 65	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   193: aload_0
      //   194: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   197: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
      //   200: invokevirtual 89	android/media/AudioRecord:getRecordingState	()I
      //   203: iconst_3
      //   204: if_icmpne +43 -> 247
      //   207: ldc 11
      //   209: new 29	java/lang/StringBuilder
      //   212: dup
      //   213: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   216: ldc 91
      //   218: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   221: aload_0
      //   222: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   225: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   228: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   231: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   234: invokestatic 65	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   237: aload_0
      //   238: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   241: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
      //   244: invokevirtual 94	android/media/AudioRecord:stop	()V
      //   247: ldc 11
      //   249: new 29	java/lang/StringBuilder
      //   252: dup
      //   253: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   256: aload_0
      //   257: invokevirtual 35	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
      //   260: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: ldc 67
      //   265: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   268: aload_0
      //   269: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   272: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   275: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   278: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   281: invokestatic 50	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   284: aload_0
      //   285: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   288: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   291: invokevirtual 75	java/lang/Object:wait	()V
      //   294: ldc 11
      //   296: new 29	java/lang/StringBuilder
      //   299: dup
      //   300: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   303: aload_0
      //   304: invokevirtual 35	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
      //   307: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   310: ldc 77
      //   312: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   315: aload_0
      //   316: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   319: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   322: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   325: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   328: invokestatic 50	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   331: aload 4
      //   333: monitorexit
      //   334: aload_0
      //   335: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   338: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
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
      //   353: invokevirtual 60	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:equalState	([I)Z
      //   356: ifeq +159 -> 515
      //   359: ldc 11
      //   361: ldc 96
      //   363: invokestatic 65	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   366: aload_0
      //   367: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   370: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
      //   373: invokevirtual 89	android/media/AudioRecord:getRecordingState	()I
      //   376: iconst_3
      //   377: if_icmpne +43 -> 420
      //   380: ldc 11
      //   382: new 29	java/lang/StringBuilder
      //   385: dup
      //   386: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   389: ldc 91
      //   391: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   394: aload_0
      //   395: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   398: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   401: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   404: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   407: invokestatic 65	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   410: aload_0
      //   411: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   414: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
      //   417: invokevirtual 94	android/media/AudioRecord:stop	()V
      //   420: aload_0
      //   421: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   424: invokevirtual 99	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onRecordStop	()V
      //   427: aload_0
      //   428: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   431: aconst_null
      //   432: putfield 103	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mOnErrorListener	Lcom/tencent/ttpic/voicechanger/common/audio/OnErrorListener;
      //   435: ldc 11
      //   437: new 29	java/lang/StringBuilder
      //   440: dup
      //   441: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   444: aload_0
      //   445: invokevirtual 35	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:getName	()Ljava/lang/String;
      //   448: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   451: ldc 105
      //   453: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   456: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   459: invokestatic 50	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   462: return
      //   463: astore 5
      //   465: ldc 11
      //   467: ldc 107
      //   469: aload 5
      //   471: iconst_0
      //   472: anewarray 72	java/lang/Object
      //   475: invokestatic 111	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
      //   478: goto -365 -> 113
      //   481: astore 5
      //   483: aload 4
      //   485: monitorexit
      //   486: aload 5
      //   488: athrow
      //   489: astore 5
      //   491: ldc 11
      //   493: ldc 107
      //   495: aload 5
      //   497: iconst_0
      //   498: anewarray 72	java/lang/Object
      //   501: invokestatic 111	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
      //   504: goto -210 -> 294
      //   507: astore 5
      //   509: aload 4
      //   511: monitorexit
      //   512: aload 5
      //   514: athrow
      //   515: aload_0
      //   516: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   519: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   522: iconst_1
      //   523: newarray int
      //   525: dup
      //   526: iconst_0
      //   527: bipush 8
      //   529: iastore
      //   530: invokevirtual 60	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:equalState	([I)Z
      //   533: ifeq +354 -> 887
      //   536: ldc 11
      //   538: ldc 113
      //   540: invokestatic 65	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   543: aload_0
      //   544: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   547: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
      //   550: invokevirtual 89	android/media/AudioRecord:getRecordingState	()I
      //   553: iconst_1
      //   554: if_icmpne +215 -> 769
      //   557: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   560: lstore_2
      //   561: aload_0
      //   562: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   565: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
      //   568: invokestatic 125	allc:a	(Landroid/media/AudioRecord;)V
      //   571: ldc 11
      //   573: new 29	java/lang/StringBuilder
      //   576: dup
      //   577: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   580: ldc 127
      //   582: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   585: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   588: lload_2
      //   589: lsub
      //   590: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   593: ldc 132
      //   595: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   598: aload_0
      //   599: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   602: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   605: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   608: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   611: invokestatic 65	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   614: aload_0
      //   615: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   618: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
      //   621: invokevirtual 89	android/media/AudioRecord:getRecordingState	()I
      //   624: iconst_1
      //   625: if_icmpne +69 -> 694
      //   628: ldc 11
      //   630: ldc 134
      //   632: invokestatic 137	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   635: aload_0
      //   636: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   639: iconst_5
      //   640: invokevirtual 141	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onRecordError	(I)V
      //   643: aload_0
      //   644: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   647: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   650: iconst_1
      //   651: invokevirtual 144	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
      //   654: goto -627 -> 27
      //   657: astore 4
      //   659: ldc 11
      //   661: ldc 146
      //   663: aload 4
      //   665: iconst_0
      //   666: anewarray 72	java/lang/Object
      //   669: invokestatic 111	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
      //   672: aload_0
      //   673: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   676: iconst_5
      //   677: invokevirtual 141	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onRecordError	(I)V
      //   680: aload_0
      //   681: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   684: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   687: iconst_1
      //   688: invokevirtual 144	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
      //   691: goto -664 -> 27
      //   694: aload_0
      //   695: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   698: getfield 150	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mHasDelaySet	Z
      //   701: ifne +68 -> 769
      //   704: aload_0
      //   705: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   708: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   711: lload_2
      //   712: lsub
      //   713: l2i
      //   714: putfield 154	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mDelay	I
      //   717: ldc 11
      //   719: new 29	java/lang/StringBuilder
      //   722: dup
      //   723: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   726: ldc 156
      //   728: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   731: aload_0
      //   732: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   735: getfield 154	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mDelay	I
      //   738: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   741: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   744: invokestatic 50	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   747: aload_0
      //   748: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   751: aload_0
      //   752: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   755: getfield 154	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mDelay	I
      //   758: invokevirtual 162	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onDelaySet	(I)V
      //   761: aload_0
      //   762: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   765: iconst_1
      //   766: putfield 150	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mHasDelaySet	Z
      //   769: aload_0
      //   770: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   773: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
      //   776: aload_0
      //   777: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   780: getfield 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBuffer	[B
      //   783: iconst_0
      //   784: getstatic 169	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_INPUT_BUFFER_SIZE	I
      //   787: invokevirtual 173	android/media/AudioRecord:read	([BII)I
      //   790: istore_1
      //   791: iload_1
      //   792: bipush 253
      //   794: if_icmpeq +13 -> 807
      //   797: iload_1
      //   798: bipush 254
      //   800: if_icmpeq +7 -> 807
      //   803: iload_1
      //   804: ifgt +50 -> 854
      //   807: ldc 11
      //   809: new 29	java/lang/StringBuilder
      //   812: dup
      //   813: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   816: ldc 175
      //   818: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   821: iload_1
      //   822: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   825: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   828: invokestatic 137	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   831: aload_0
      //   832: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   835: bipush 6
      //   837: invokevirtual 141	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onRecordError	(I)V
      //   840: aload_0
      //   841: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   844: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   847: iconst_1
      //   848: invokevirtual 144	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
      //   851: goto -824 -> 27
      //   854: aload_0
      //   855: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   858: astore 4
      //   860: aload 4
      //   862: aload 4
      //   864: getfield 178	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mHasRecordLength	I
      //   867: iload_1
      //   868: iadd
      //   869: putfield 178	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mHasRecordLength	I
      //   872: aload_0
      //   873: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   876: aload_0
      //   877: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   880: getfield 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBuffer	[B
      //   883: iload_1
      //   884: invokevirtual 182	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:onRecording	([BI)V
      //   887: ldc 11
      //   889: new 29	java/lang/StringBuilder
      //   892: dup
      //   893: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   896: ldc 184
      //   898: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   901: aload_0
      //   902: getfield 17	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;
      //   905: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
      //   908: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   911: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   914: invokestatic 65	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   917: goto -890 -> 27
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	920	0	this	SimpleRecordThreadForKitKat
      //   790	94	1	i	int
      //   560	152	2	l	long
      //   657	7	4	localSecurityException	java.lang.SecurityException
      //   858	5	4	localAudioRecorderAndChangerForKitKat	AudioRecorderAndChangerForKitKat
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
      return "State[" + this.state + "]";
    }
    
    public void transfer(int paramInt)
    {
      try
      {
        LogUtils.i(AudioRecorderCompat.TAG, "switch state: " + this.state + " -> " + paramInt);
        this.state = paramInt;
        AudioRecorderAndChangerForKitKat.this.mCurrentState.notifyAll();
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
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat
 * JD-Core Version:    0.7.0.1
 */
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
public class AudioRecorder
{
  public static final int ERROR_AUDIO_FILE_NOT_EXIST = 1;
  public static final int ERROR_AUDIO_ILLEGAL_ARGUMENT = 3;
  public static final int ERROR_AUDIO_INIT_AUDIORECORD_FAILED = 4;
  public static final int ERROR_AUDIO_OUT_OF_MEMORY = 2;
  public static final int ERROR_AUDIO_RECORD_READ_FAILED = 6;
  public static final int ERROR_AUDIO_RECORD_START_FAILED = 5;
  private static final String TAG = AudioRecorder.class.getSimpleName();
  private AudioRecord mARecorder;
  private AsyncPcmWriter mAsyncPcmWriter;
  private int mBufSize = AudioRecorderCompat.AUDIO_OUTPUT_BUFFER_SIZE;
  private byte[] mBuffer;
  private State mCurrentState = new State();
  private int mDelay;
  private boolean mHasDelaySet;
  private int mHasRecordLength;
  private OnErrorListener mOnErrorListener;
  private String mPcmPath;
  private SimpleRecordThread mRecThread;
  
  public AudioRecorder(String paramString)
  {
    this.mPcmPath = paramString;
  }
  
  public int getDelay()
  {
    return this.mDelay;
  }
  
  /* Error */
  public int init()
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 121	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   4: bipush 16
    //   6: iconst_2
    //   7: invokestatic 127	android/media/AudioRecord:getMinBufferSize	(III)I
    //   10: putfield 74	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   13: getstatic 57	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   16: new 129	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   23: ldc 132
    //   25: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 74	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   32: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 148	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 74	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   45: getstatic 72	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   48: if_icmpgt +10 -> 58
    //   51: aload_0
    //   52: getstatic 72	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   55: putfield 74	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 74	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   63: newarray byte
    //   65: putfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBuffer	[B
    //   68: aload_0
    //   69: new 123	android/media/AudioRecord
    //   72: dup
    //   73: iconst_1
    //   74: getstatic 121	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   77: getstatic 151	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_CHANNEL_COUNT	I
    //   80: bipush 16
    //   82: imul
    //   83: iconst_2
    //   84: aload_0
    //   85: getfield 74	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   88: invokespecial 154	android/media/AudioRecord:<init>	(IIIII)V
    //   91: putfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   94: aload_0
    //   95: getfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   98: invokevirtual 157	android/media/AudioRecord:getState	()I
    //   101: iconst_1
    //   102: if_icmpeq +66 -> 168
    //   105: getstatic 57	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   108: ldc 159
    //   110: invokestatic 162	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: getfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   117: iconst_0
    //   118: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   121: iconst_4
    //   122: ireturn
    //   123: astore_1
    //   124: getstatic 57	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   127: aload_1
    //   128: invokevirtual 169	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   131: invokestatic 162	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_0
    //   135: getfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   138: iconst_0
    //   139: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   142: iconst_2
    //   143: ireturn
    //   144: astore_1
    //   145: getstatic 57	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   148: ldc 171
    //   150: aload_1
    //   151: iconst_0
    //   152: anewarray 4	java/lang/Object
    //   155: invokestatic 174	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   158: aload_0
    //   159: getfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   162: iconst_0
    //   163: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   166: iconst_3
    //   167: ireturn
    //   168: aload_0
    //   169: getfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   172: invokevirtual 177	android/media/AudioRecord:getRecordingState	()I
    //   175: iconst_1
    //   176: if_icmpne +10 -> 186
    //   179: aload_0
    //   180: getfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   183: invokestatic 183	allc:a	(Landroid/media/AudioRecord;)V
    //   186: aload_0
    //   187: getfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   190: invokevirtual 177	android/media/AudioRecord:getRecordingState	()I
    //   193: iconst_3
    //   194: if_icmpne +10 -> 204
    //   197: aload_0
    //   198: getfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   201: invokevirtual 186	android/media/AudioRecord:stop	()V
    //   204: aload_0
    //   205: getfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   208: iconst_2
    //   209: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   212: aload_0
    //   213: new 6	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$AsyncPcmWriter
    //   216: dup
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 76	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mPcmPath	Ljava/lang/String;
    //   222: getstatic 189	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_INPUT_BUFFER_SIZE	I
    //   225: invokespecial 192	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$AsyncPcmWriter:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;Ljava/lang/String;I)V
    //   228: putfield 194	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$AsyncPcmWriter;
    //   231: aload_0
    //   232: new 9	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread
    //   235: dup
    //   236: aload_0
    //   237: new 129	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   244: ldc 196
    //   246: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokestatic 202	java/lang/System:currentTimeMillis	()J
    //   252: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokespecial 208	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;Ljava/lang/String;)V
    //   261: putfield 210	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread;
    //   264: aload_0
    //   265: getfield 210	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread;
    //   268: invokevirtual 213	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:start	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: getstatic 57	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   277: ldc 215
    //   279: aload_1
    //   280: iconst_0
    //   281: anewarray 4	java/lang/Object
    //   284: invokestatic 218	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   287: aload_0
    //   288: getfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   291: iconst_0
    //   292: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   295: iconst_5
    //   296: ireturn
    //   297: astore_1
    //   298: getstatic 57	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   301: aload_1
    //   302: invokevirtual 219	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   305: invokestatic 162	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_0
    //   309: getfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   312: iconst_0
    //   313: invokevirtual 166	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   316: iconst_1
    //   317: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	AudioRecorder
    //   123	5	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   144	7	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   273	7	1	localSecurityException	java.lang.SecurityException
    //   297	5	1	localFileNotFoundException	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   58	68	123	java/lang/OutOfMemoryError
    //   68	94	144	java/lang/IllegalArgumentException
    //   179	186	273	java/lang/SecurityException
    //   212	231	297	java/io/FileNotFoundException
  }
  
  public void onDelaySet(int paramInt) {}
  
  public void onRecordError(int paramInt)
  {
    if (this.mOnErrorListener != null) {
      this.mOnErrorListener.onError(paramInt);
    }
  }
  
  public void onRecordStop()
  {
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
    LogUtils.d(TAG, "pause");
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 8 }))
      {
        LogUtils.d(TAG, "current state has been 8");
        return;
      }
      if (!this.mCurrentState.equalState(new int[] { 4, 2 })) {
        throw new IllegalStateException("current status is: " + this.mCurrentState);
      }
    }
    this.mCurrentState.transfer(8);
  }
  
  public void release()
  {
    LogUtils.d(TAG, "release start");
    synchronized (this.mCurrentState)
    {
      if (!this.mCurrentState.equalState(new int[] { 16 }))
      {
        LogUtils.i(TAG, "stop() is forgotten by someone, so call it now!");
        stop();
      }
      this.mCurrentState.transfer(1);
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
    LogUtils.d(TAG, "resume, delegate to start");
    start();
  }
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void start()
  {
    LogUtils.d(TAG, "start");
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 4 }))
      {
        LogUtils.w(TAG, "current state has been 4");
        return;
      }
      if (!this.mCurrentState.equalState(new int[] { 8, 2 })) {
        throw new IllegalStateException("current status is: " + this.mCurrentState);
      }
    }
    this.mCurrentState.transfer(4);
  }
  
  public void stop()
  {
    LogUtils.d(TAG, "stop");
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 16 }))
      {
        LogUtils.d(TAG, "current state has been 16");
        return;
      }
      this.mCurrentState.transfer(16);
      if ((this.mRecThread == null) || (this.mRecThread.equals(Thread.currentThread()))) {
        return;
      }
    }
    try
    {
      this.mRecThread.join();
      this.mRecThread = null;
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        LogUtils.e(TAG, localInterruptedException.getMessage());
      }
    }
  }
  
  public class AsyncPcmWriter
  {
    private static final String T_TAG = "AudioRecorder.AsyncPcmWriter";
    private boolean canSave = true;
    private final LinkedList<byte[]> fileBuffers = new LinkedList();
    private Handler mHandler = null;
    private HandlerThread mHandlerThread = null;
    private RandomAccessFile mMicfile = null;
    private int perBufSize;
    
    public AsyncPcmWriter(String paramString, int paramInt)
      throws FileNotFoundException
    {
      FileUtils.delete(paramString);
      this.perBufSize = paramInt;
      this.mMicfile = new RandomAccessFile(paramString, "rw");
      int i = 0;
      while (i < 4)
      {
        this$1 = new byte[paramInt];
        this.fileBuffers.add(AudioRecorder.this);
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
          this.mHandler.post(new AudioRecorder.AsyncPcmWriter.1(this, paramInt, arrayOfByte));
          return;
        }
        byte[] arrayOfByte = new byte[this.perBufSize];
      }
    }
    
    public void onStop()
    {
      this.mHandler.post(new AudioRecorder.AsyncPcmWriter.2(this));
    }
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
      //   10: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
      //   13: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: ldc 40
      //   18: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   24: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   27: aload_0
      //   28: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   31: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   34: astore 4
      //   36: aload 4
      //   38: monitorenter
      //   39: aload_0
      //   40: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   43: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   46: iconst_1
      //   47: newarray int
      //   49: dup
      //   50: iconst_0
      //   51: iconst_2
      //   52: iastore
      //   53: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:equalState	([I)Z
      //   56: ifeq +87 -> 143
      //   59: ldc 10
      //   61: new 28	java/lang/StringBuilder
      //   64: dup
      //   65: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   68: aload_0
      //   69: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
      //   72: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: ldc 61
      //   77: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   80: aload_0
      //   81: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   84: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   87: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   90: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   93: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   96: aload_0
      //   97: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   100: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   103: invokevirtual 69	java/lang/Object:wait	()V
      //   106: ldc 10
      //   108: new 28	java/lang/StringBuilder
      //   111: dup
      //   112: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   115: aload_0
      //   116: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
      //   119: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   122: ldc 71
      //   124: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   127: aload_0
      //   128: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   131: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   134: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   137: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   140: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   143: aload 4
      //   145: monitorexit
      //   146: aload_0
      //   147: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   150: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   153: astore 4
      //   155: aload 4
      //   157: monitorenter
      //   158: aload_0
      //   159: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   162: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   165: iconst_1
      //   166: newarray int
      //   168: dup
      //   169: iconst_0
      //   170: bipush 8
      //   172: iastore
      //   173: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:equalState	([I)Z
      //   176: ifeq +141 -> 317
      //   179: aload_0
      //   180: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   183: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
      //   186: invokevirtual 81	android/media/AudioRecord:getRecordingState	()I
      //   189: iconst_3
      //   190: if_icmpne +43 -> 233
      //   193: ldc 10
      //   195: new 28	java/lang/StringBuilder
      //   198: dup
      //   199: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   202: ldc 83
      //   204: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   207: aload_0
      //   208: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   211: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   214: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   217: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   220: invokestatic 86	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   223: aload_0
      //   224: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   227: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
      //   230: invokevirtual 89	android/media/AudioRecord:stop	()V
      //   233: ldc 10
      //   235: new 28	java/lang/StringBuilder
      //   238: dup
      //   239: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   242: aload_0
      //   243: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
      //   246: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   249: ldc 61
      //   251: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   254: aload_0
      //   255: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   258: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   261: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   264: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   267: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   270: aload_0
      //   271: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   274: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   277: invokevirtual 69	java/lang/Object:wait	()V
      //   280: ldc 10
      //   282: new 28	java/lang/StringBuilder
      //   285: dup
      //   286: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   289: aload_0
      //   290: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
      //   293: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   296: ldc 71
      //   298: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   301: aload_0
      //   302: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   305: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   308: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   311: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   314: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   317: aload 4
      //   319: monitorexit
      //   320: aload_0
      //   321: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   324: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   327: iconst_2
      //   328: newarray int
      //   330: dup
      //   331: iconst_0
      //   332: bipush 16
      //   334: iastore
      //   335: dup
      //   336: iconst_1
      //   337: iconst_0
      //   338: iastore
      //   339: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:equalState	([I)Z
      //   342: ifeq +153 -> 495
      //   345: aload_0
      //   346: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   349: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
      //   352: invokevirtual 81	android/media/AudioRecord:getRecordingState	()I
      //   355: iconst_3
      //   356: if_icmpne +43 -> 399
      //   359: ldc 10
      //   361: new 28	java/lang/StringBuilder
      //   364: dup
      //   365: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   368: ldc 83
      //   370: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   373: aload_0
      //   374: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   377: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   380: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   383: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   386: invokestatic 86	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   389: aload_0
      //   390: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   393: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
      //   396: invokevirtual 89	android/media/AudioRecord:stop	()V
      //   399: aload_0
      //   400: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   403: invokevirtual 92	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onRecordStop	()V
      //   406: aload_0
      //   407: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   410: aconst_null
      //   411: invokestatic 96	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$702	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;Lcom/tencent/ttpic/voicechanger/common/audio/OnErrorListener;)Lcom/tencent/ttpic/voicechanger/common/audio/OnErrorListener;
      //   414: pop
      //   415: ldc 10
      //   417: new 28	java/lang/StringBuilder
      //   420: dup
      //   421: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   424: aload_0
      //   425: invokevirtual 34	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:getName	()Ljava/lang/String;
      //   428: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   431: ldc 98
      //   433: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   436: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   439: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   442: return
      //   443: astore 5
      //   445: ldc 10
      //   447: ldc 100
      //   449: aload 5
      //   451: iconst_0
      //   452: anewarray 66	java/lang/Object
      //   455: invokestatic 104	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
      //   458: goto -352 -> 106
      //   461: astore 5
      //   463: aload 4
      //   465: monitorexit
      //   466: aload 5
      //   468: athrow
      //   469: astore 5
      //   471: ldc 10
      //   473: ldc 100
      //   475: aload 5
      //   477: iconst_0
      //   478: anewarray 66	java/lang/Object
      //   481: invokestatic 104	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
      //   484: goto -204 -> 280
      //   487: astore 5
      //   489: aload 4
      //   491: monitorexit
      //   492: aload 5
      //   494: athrow
      //   495: aload_0
      //   496: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   499: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   502: iconst_1
      //   503: newarray int
      //   505: dup
      //   506: iconst_0
      //   507: iconst_4
      //   508: iastore
      //   509: invokevirtual 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:equalState	([I)Z
      //   512: ifeq -485 -> 27
      //   515: aload_0
      //   516: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   519: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
      //   522: invokevirtual 81	android/media/AudioRecord:getRecordingState	()I
      //   525: iconst_1
      //   526: if_icmpne +217 -> 743
      //   529: invokestatic 110	java/lang/System:currentTimeMillis	()J
      //   532: lstore_2
      //   533: aload_0
      //   534: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   537: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
      //   540: invokestatic 116	allc:a	(Landroid/media/AudioRecord;)V
      //   543: ldc 10
      //   545: new 28	java/lang/StringBuilder
      //   548: dup
      //   549: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   552: ldc 118
      //   554: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   557: invokestatic 110	java/lang/System:currentTimeMillis	()J
      //   560: lload_2
      //   561: lsub
      //   562: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   565: ldc 123
      //   567: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   570: aload_0
      //   571: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   574: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   577: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   580: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   583: invokestatic 86	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   586: aload_0
      //   587: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   590: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
      //   593: invokevirtual 81	android/media/AudioRecord:getRecordingState	()I
      //   596: iconst_1
      //   597: if_icmpne +69 -> 666
      //   600: ldc 10
      //   602: ldc 125
      //   604: invokestatic 128	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   607: aload_0
      //   608: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   611: iconst_5
      //   612: invokevirtual 132	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onRecordError	(I)V
      //   615: aload_0
      //   616: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   619: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   622: iconst_0
      //   623: invokevirtual 135	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
      //   626: goto -599 -> 27
      //   629: astore 4
      //   631: ldc 10
      //   633: ldc 137
      //   635: aload 4
      //   637: iconst_0
      //   638: anewarray 66	java/lang/Object
      //   641: invokestatic 104	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
      //   644: aload_0
      //   645: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   648: iconst_5
      //   649: invokevirtual 132	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onRecordError	(I)V
      //   652: aload_0
      //   653: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   656: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   659: iconst_0
      //   660: invokevirtual 135	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
      //   663: goto -636 -> 27
      //   666: aload_0
      //   667: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   670: invokestatic 141	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$800	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Z
      //   673: ifne +70 -> 743
      //   676: aload_0
      //   677: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   680: invokestatic 110	java/lang/System:currentTimeMillis	()J
      //   683: lload_2
      //   684: lsub
      //   685: l2i
      //   686: invokestatic 145	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$902	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;I)I
      //   689: pop
      //   690: ldc 10
      //   692: new 28	java/lang/StringBuilder
      //   695: dup
      //   696: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   699: ldc 147
      //   701: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   704: aload_0
      //   705: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   708: invokestatic 151	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$900	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)I
      //   711: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   714: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   717: invokestatic 49	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   720: aload_0
      //   721: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   724: aload_0
      //   725: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   728: invokestatic 151	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$900	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)I
      //   731: invokevirtual 157	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onDelaySet	(I)V
      //   734: aload_0
      //   735: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   738: iconst_1
      //   739: invokestatic 161	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$802	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;Z)Z
      //   742: pop
      //   743: aload_0
      //   744: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   747: invokestatic 75	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$600	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Landroid/media/AudioRecord;
      //   750: aload_0
      //   751: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   754: invokestatic 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$1000	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)[B
      //   757: iconst_0
      //   758: getstatic 171	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_INPUT_BUFFER_SIZE	I
      //   761: invokevirtual 175	android/media/AudioRecord:read	([BII)I
      //   764: istore_1
      //   765: iload_1
      //   766: bipush 253
      //   768: if_icmpeq +13 -> 781
      //   771: iload_1
      //   772: bipush 254
      //   774: if_icmpeq +7 -> 781
      //   777: iload_1
      //   778: ifgt +50 -> 828
      //   781: ldc 10
      //   783: new 28	java/lang/StringBuilder
      //   786: dup
      //   787: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   790: ldc 177
      //   792: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   795: iload_1
      //   796: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   799: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   802: invokestatic 128	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   805: aload_0
      //   806: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   809: bipush 6
      //   811: invokevirtual 132	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onRecordError	(I)V
      //   814: aload_0
      //   815: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   818: invokestatic 53	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
      //   821: iconst_0
      //   822: invokevirtual 135	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
      //   825: goto -798 -> 27
      //   828: aload_0
      //   829: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   832: aload_0
      //   833: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   836: invokestatic 180	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$1100	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)I
      //   839: iload_1
      //   840: iadd
      //   841: invokestatic 183	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$1102	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;I)I
      //   844: pop
      //   845: aload_0
      //   846: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   849: aload_0
      //   850: getfield 16	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:this$0	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;
      //   853: invokestatic 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:access$1000	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;)[B
      //   856: iload_1
      //   857: invokevirtual 187	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:onRecording	([BI)V
      //   860: goto -833 -> 27
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	863	0	this	SimpleRecordThread
      //   764	93	1	i	int
      //   532	152	2	l	long
      //   629	7	4	localSecurityException	java.lang.SecurityException
      //   443	7	5	localInterruptedException1	InterruptedException
      //   461	6	5	localObject1	Object
      //   469	7	5	localInterruptedException2	InterruptedException
      //   487	6	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   96	106	443	java/lang/InterruptedException
      //   39	96	461	finally
      //   96	106	461	finally
      //   106	143	461	finally
      //   143	146	461	finally
      //   445	458	461	finally
      //   463	466	461	finally
      //   270	280	469	java/lang/InterruptedException
      //   158	233	487	finally
      //   233	270	487	finally
      //   270	280	487	finally
      //   280	317	487	finally
      //   317	320	487	finally
      //   471	484	487	finally
      //   489	492	487	finally
      //   533	543	629	java/lang/SecurityException
    }
  }
  
  public class State
  {
    public static final int STATE_ERROR = 0;
    public static final int STATE_IDLE = 1;
    public static final int STATE_INITIALIZED = 2;
    public static final int STATE_PAUSED = 8;
    public static final int STATE_STARTED = 4;
    public static final int STATE_STOPPED = 16;
    private int state = 1;
    
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
        LogUtils.i(AudioRecorder.TAG, "switch state: " + this.state + " -> " + paramInt);
        this.state = paramInt;
        AudioRecorder.this.mCurrentState.notifyAll();
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
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorder
 * JD-Core Version:    0.7.0.1
 */
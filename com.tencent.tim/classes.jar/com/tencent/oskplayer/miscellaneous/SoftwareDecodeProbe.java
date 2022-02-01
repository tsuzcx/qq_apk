package com.tencent.oskplayer.miscellaneous;

import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import java.util.HashSet;
import java.util.Set;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.annotations.CalledByNative;

public class SoftwareDecodeProbe
  implements IMediaPlayer.OnPreparedListener
{
  public static final String TAG = SoftwareDecodeProbe.class.getSimpleName();
  static long mDecodeFrameAvgCost = 2147483647L;
  static Object mLockObject = new Object();
  static int mMaxFrameNo;
  static volatile SwProbeCallback mProbeCallback;
  static int mProbeError;
  static Set<Integer> mSaveFrames = new HashSet();
  static String mSavedDir;
  IjkMediaPlayer mProber;
  
  public static long getDecodeFrameAvgCost()
  {
    return mDecodeFrameAvgCost;
  }
  
  @CalledByNative
  public static int getMaxNeedSaveFrameNo()
  {
    return mMaxFrameNo;
  }
  
  @CalledByNative
  public static String getSavedDir()
  {
    return mSavedDir;
  }
  
  @CalledByNative
  public static boolean needSaveFrame(int paramInt)
  {
    return mSaveFrames.contains(Integer.valueOf(paramInt));
  }
  
  @CalledByNative
  public static void onProbeDone(int paramInt, long paramLong)
  {
    Logger.g().i(TAG, "[onProbeDone] errorCode=" + paramInt + ", avgCost=" + paramLong);
    mProbeError = paramInt;
    mDecodeFrameAvgCost = paramLong;
    synchronized (mLockObject)
    {
      mLockObject.notifyAll();
      return;
    }
  }
  
  @CalledByNative
  public static void onProbeOneFrame(int paramInt)
  {
    if (mProbeCallback != null) {
      mProbeCallback.onSwProbeOneFrame(paramInt);
    }
  }
  
  public static void setProbeCallback(SwProbeCallback paramSwProbeCallback)
  {
    mProbeCallback = paramSwProbeCallback;
  }
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    try
    {
      paramIMediaPlayer.start();
      return;
    }
    catch (Exception paramIMediaPlayer)
    {
      Logger.g().e(TAG, "[probe] start error, " + paramIMediaPlayer.toString());
      mProbeError = 20002;
    }
  }
  
  /* Error */
  public int probe(@android.support.annotation.NonNull String arg1, @android.support.annotation.NonNull String paramString2, Set<Integer> paramSet)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 150	com/tencent/oskplayer/support/util/OskFile:isLocalFile	(Ljava/lang/String;)Z
    //   4: ifeq +52 -> 56
    //   7: new 152	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 159	java/io/File:canRead	()Z
    //   18: ifne +38 -> 56
    //   21: invokestatic 84	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   24: getstatic 36	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:TAG	Ljava/lang/String;
    //   27: new 86	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   34: ldc 161
    //   36: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokeinterface 139 3 0
    //   51: pop
    //   52: sipush 20015
    //   55: ireturn
    //   56: new 152	java/io/File
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 4
    //   66: aload 4
    //   68: invokevirtual 164	java/io/File:exists	()Z
    //   71: ifne +15 -> 86
    //   74: aload 4
    //   76: invokevirtual 167	java/io/File:mkdirs	()Z
    //   79: ifne +7 -> 86
    //   82: sipush 20004
    //   85: ireturn
    //   86: aload_2
    //   87: putstatic 62	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mSavedDir	Ljava/lang/String;
    //   90: getstatic 46	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mSaveFrames	Ljava/util/Set;
    //   93: invokeinterface 170 1 0
    //   98: iconst_m1
    //   99: putstatic 58	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mMaxFrameNo	I
    //   102: aload_3
    //   103: invokeinterface 174 1 0
    //   108: astore_2
    //   109: aload_2
    //   110: invokeinterface 179 1 0
    //   115: ifeq +39 -> 154
    //   118: aload_2
    //   119: invokeinterface 183 1 0
    //   124: checkcast 66	java/lang/Integer
    //   127: astore_3
    //   128: getstatic 58	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mMaxFrameNo	I
    //   131: aload_3
    //   132: invokevirtual 186	java/lang/Integer:intValue	()I
    //   135: invokestatic 192	java/lang/Math:max	(II)I
    //   138: putstatic 58	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mMaxFrameNo	I
    //   141: getstatic 46	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mSaveFrames	Ljava/util/Set;
    //   144: aload_3
    //   145: invokeinterface 195 2 0
    //   150: pop
    //   151: goto -42 -> 109
    //   154: invokestatic 84	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   157: getstatic 36	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:TAG	Ljava/lang/String;
    //   160: new 86	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   167: ldc 197
    //   169: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: getstatic 58	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mMaxFrameNo	I
    //   175: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc 199
    //   180: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: getstatic 62	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mSavedDir	Ljava/lang/String;
    //   186: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokeinterface 202 3 0
    //   197: pop
    //   198: aload_0
    //   199: new 204	tv/danmaku/ijk/media/player/IjkMediaPlayer
    //   202: dup
    //   203: invokespecial 205	tv/danmaku/ijk/media/player/IjkMediaPlayer:<init>	()V
    //   206: putfield 207	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mProber	Ltv/danmaku/ijk/media/player/IjkMediaPlayer;
    //   209: aload_0
    //   210: getfield 207	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mProber	Ltv/danmaku/ijk/media/player/IjkMediaPlayer;
    //   213: iconst_4
    //   214: ldc 209
    //   216: lconst_1
    //   217: invokevirtual 213	tv/danmaku/ijk/media/player/IjkMediaPlayer:setOption	(ILjava/lang/String;J)V
    //   220: aload_0
    //   221: getfield 207	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mProber	Ltv/danmaku/ijk/media/player/IjkMediaPlayer;
    //   224: iconst_4
    //   225: ldc 215
    //   227: ldc2_w 216
    //   230: invokevirtual 213	tv/danmaku/ijk/media/player/IjkMediaPlayer:setOption	(ILjava/lang/String;J)V
    //   233: aload_0
    //   234: getfield 207	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mProber	Ltv/danmaku/ijk/media/player/IjkMediaPlayer;
    //   237: aload_0
    //   238: invokevirtual 221	tv/danmaku/ijk/media/player/IjkMediaPlayer:setOnPreparedListener	(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;)V
    //   241: aload_0
    //   242: getfield 207	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mProber	Ltv/danmaku/ijk/media/player/IjkMediaPlayer;
    //   245: aload_1
    //   246: invokevirtual 224	tv/danmaku/ijk/media/player/IjkMediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   249: aload_0
    //   250: getfield 207	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mProber	Ltv/danmaku/ijk/media/player/IjkMediaPlayer;
    //   253: invokevirtual 227	tv/danmaku/ijk/media/player/IjkMediaPlayer:prepareAsync	()V
    //   256: sipush 20003
    //   259: putstatic 112	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mProbeError	I
    //   262: getstatic 41	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mLockObject	Ljava/lang/Object;
    //   265: astore_1
    //   266: aload_1
    //   267: monitorenter
    //   268: getstatic 41	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mLockObject	Ljava/lang/Object;
    //   271: ldc2_w 228
    //   274: invokevirtual 233	java/lang/Object:wait	(J)V
    //   277: aload_1
    //   278: monitorexit
    //   279: invokestatic 84	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   282: getstatic 36	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:TAG	Ljava/lang/String;
    //   285: new 86	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   292: ldc 235
    //   294: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: getstatic 112	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mProbeError	I
    //   300: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokeinterface 202 3 0
    //   311: pop
    //   312: getstatic 112	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:mProbeError	I
    //   315: ireturn
    //   316: astore_1
    //   317: invokestatic 84	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   320: getstatic 36	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:TAG	Ljava/lang/String;
    //   323: new 86	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   330: ldc 237
    //   332: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_1
    //   336: invokevirtual 136	java/lang/Exception:toString	()Ljava/lang/String;
    //   339: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokeinterface 139 3 0
    //   350: pop
    //   351: sipush 20001
    //   354: ireturn
    //   355: astore_2
    //   356: invokestatic 84	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   359: getstatic 36	com/tencent/oskplayer/miscellaneous/SoftwareDecodeProbe:TAG	Ljava/lang/String;
    //   362: new 86	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   369: ldc 239
    //   371: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload_2
    //   375: invokevirtual 240	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   378: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokeinterface 139 3 0
    //   389: pop
    //   390: goto -113 -> 277
    //   393: astore_2
    //   394: aload_1
    //   395: monitorexit
    //   396: aload_2
    //   397: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	SoftwareDecodeProbe
    //   0	398	2	paramString2	String
    //   0	398	3	paramSet	Set<Integer>
    //   64	11	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   241	256	316	java/lang/Exception
    //   268	277	355	java/lang/InterruptedException
    //   268	277	393	finally
    //   277	279	393	finally
    //   356	390	393	finally
    //   394	396	393	finally
  }
  
  public static abstract interface SwProbeCallback
  {
    public abstract void onSwProbeOneFrame(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.miscellaneous.SoftwareDecodeProbe
 * JD-Core Version:    0.7.0.1
 */
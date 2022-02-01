package com.tencent.qq.effect.alphavideo.videoplayer.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder;
import com.tencent.qq.effect.utils.LogUtil;
import java.nio.ByteBuffer;

public class HardwareFileDecoder
  implements IVideoFileDecoder
{
  private String TAG = "VideoPlayer|HardwareFileDecoder";
  private IVideoFileDecodeListener mDecodeListener = null;
  private MediaExtractor mExtractor = null;
  private long mFirstFrameSysTime = 0L;
  private long mFirstFrameTimeUS = 0L;
  private MediaFormat mFormat = null;
  private ByteBuffer[] mInputBuffers = null;
  private boolean mLoop = false;
  private MediaCodec mMediaCodec = null;
  private String mMime = null;
  private ByteBuffer[] mOutputBuffers = null;
  private long mPresentationTimeUs = 0L;
  private long mSamplePresentationTimeUs = 0L;
  private boolean mStart = false;
  
  public HardwareFileDecoder() {}
  
  public HardwareFileDecoder(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  private void releaseCodec()
  {
    if (this.mMediaCodec != null) {}
    try
    {
      LogUtil.i(this.TAG, "mMediaCodec stop + release begin!" + hashCode());
      this.mMediaCodec.stop();
      this.mMediaCodec.release();
      this.mMediaCodec = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        LogUtil.e(this.TAG, "Failed to stop MediaCodec");
      }
    }
  }
  
  private void releaseExtractor()
  {
    if (this.mExtractor != null)
    {
      this.mExtractor.release();
      this.mExtractor = null;
    }
  }
  
  /* Error */
  public int createDecoder(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 5
    //   3: aload_0
    //   4: new 109	android/media/MediaExtractor
    //   7: dup
    //   8: invokespecial 115	android/media/MediaExtractor:<init>	()V
    //   11: putfield 36	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   14: aload_0
    //   15: getfield 36	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   18: aload_1
    //   19: invokevirtual 119	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   22: iconst_0
    //   23: istore_3
    //   24: iload 5
    //   26: istore 4
    //   28: iload_3
    //   29: aload_0
    //   30: getfield 36	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   33: invokevirtual 122	android/media/MediaExtractor:getTrackCount	()I
    //   36: if_icmpge +35 -> 71
    //   39: aload_0
    //   40: getfield 36	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   43: iload_3
    //   44: invokevirtual 126	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   47: ldc 128
    //   49: invokevirtual 134	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: ldc 136
    //   54: invokevirtual 142	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   57: ifeq +162 -> 219
    //   60: aload_0
    //   61: getfield 36	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   64: iload_3
    //   65: invokevirtual 146	android/media/MediaExtractor:selectTrack	(I)V
    //   68: iload_3
    //   69: istore 4
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 36	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   76: iload 4
    //   78: invokevirtual 126	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   81: putfield 38	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   84: aload_0
    //   85: getfield 38	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   88: ifnull +16 -> 104
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 38	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   96: ldc 128
    //   98: invokevirtual 134	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: putfield 40	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMime	Ljava/lang/String;
    //   104: aload_0
    //   105: getfield 36	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   108: iload 4
    //   110: invokevirtual 146	android/media/MediaExtractor:selectTrack	(I)V
    //   113: aload_0
    //   114: getfield 38	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   117: ifnull +15 -> 132
    //   120: aload_0
    //   121: getfield 40	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMime	Ljava/lang/String;
    //   124: ldc 136
    //   126: invokevirtual 142	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   129: ifne +152 -> 281
    //   132: aload_0
    //   133: getfield 60	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   136: ldc 148
    //   138: invokestatic 106	com/tencent/qq/effect/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_0
    //   142: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   145: ifnull +14 -> 159
    //   148: aload_0
    //   149: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   152: bipush 253
    //   154: invokeinterface 153 2 0
    //   159: aload_0
    //   160: invokespecial 155	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:releaseExtractor	()V
    //   163: bipush 253
    //   165: ireturn
    //   166: astore_1
    //   167: aload_0
    //   168: getfield 60	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   171: new 69	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   178: ldc 157
    //   180: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_1
    //   184: invokevirtual 160	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 106	com/tencent/qq/effect/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_0
    //   197: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   200: ifnull +13 -> 213
    //   203: aload_0
    //   204: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   207: iconst_m1
    //   208: invokeinterface 153 2 0
    //   213: aload_0
    //   214: invokespecial 155	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:releaseExtractor	()V
    //   217: iconst_m1
    //   218: ireturn
    //   219: iload_3
    //   220: iconst_1
    //   221: iadd
    //   222: istore_3
    //   223: goto -199 -> 24
    //   226: astore_1
    //   227: aload_0
    //   228: getfield 60	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   231: new 69	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   238: ldc 162
    //   240: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_1
    //   244: invokevirtual 160	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   247: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 106	com/tencent/qq/effect/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload_0
    //   257: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   260: ifnull +14 -> 274
    //   263: aload_0
    //   264: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   267: bipush 254
    //   269: invokeinterface 153 2 0
    //   274: aload_0
    //   275: invokespecial 155	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:releaseExtractor	()V
    //   278: bipush 254
    //   280: ireturn
    //   281: aload_0
    //   282: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   285: ifnull +16 -> 301
    //   288: aload_0
    //   289: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   292: aload_0
    //   293: getfield 38	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   296: invokeinterface 166 2 0
    //   301: aload_0
    //   302: getfield 38	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   305: ldc 168
    //   307: invokevirtual 172	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   310: istore_3
    //   311: aload_0
    //   312: getfield 38	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   315: ldc 174
    //   317: invokevirtual 172	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   320: istore 4
    //   322: aload_0
    //   323: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   326: ifnull +15 -> 341
    //   329: aload_0
    //   330: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   333: iload_3
    //   334: iload 4
    //   336: invokeinterface 178 3 0
    //   341: aload_0
    //   342: aload_0
    //   343: getfield 40	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMime	Ljava/lang/String;
    //   346: invokestatic 182	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   349: putfield 34	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   352: aload_0
    //   353: getfield 60	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   356: new 69	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   363: ldc 184
    //   365: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_0
    //   369: invokevirtual 80	java/lang/Object:hashCode	()I
    //   372: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 93	com/tencent/qq/effect/utils/LogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload_0
    //   382: getfield 34	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   385: aload_0
    //   386: getfield 38	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   389: aload_2
    //   390: checkcast 186	android/view/Surface
    //   393: aconst_null
    //   394: iconst_0
    //   395: invokevirtual 190	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   398: aload_0
    //   399: getfield 60	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   402: new 69	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   409: ldc 192
    //   411: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_0
    //   415: invokevirtual 80	java/lang/Object:hashCode	()I
    //   418: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 93	com/tencent/qq/effect/utils/LogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   427: aload_0
    //   428: getfield 34	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   431: invokevirtual 195	android/media/MediaCodec:start	()V
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 34	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   439: invokevirtual 199	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   442: putfield 50	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mInputBuffers	[Ljava/nio/ByteBuffer;
    //   445: aload_0
    //   446: aload_0
    //   447: getfield 34	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   450: invokevirtual 202	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   453: putfield 52	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mOutputBuffers	[Ljava/nio/ByteBuffer;
    //   456: aload_0
    //   457: getfield 60	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   460: ldc 204
    //   462: invokestatic 93	com/tencent/qq/effect/utils/LogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: aload_0
    //   466: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   469: ifnull +13 -> 482
    //   472: aload_0
    //   473: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   476: iconst_1
    //   477: invokeinterface 207 2 0
    //   482: iconst_1
    //   483: ireturn
    //   484: astore_1
    //   485: aload_1
    //   486: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   489: aload_0
    //   490: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   493: ifnull +14 -> 507
    //   496: aload_0
    //   497: getfield 62	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mDecodeListener	Lcom/tencent/qq/effect/alphavideo/videoplayer/interfaces/IVideoFileDecodeListener;
    //   500: bipush 251
    //   502: invokeinterface 153 2 0
    //   507: aload_0
    //   508: getfield 34	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   511: ifnull +44 -> 555
    //   514: aload_0
    //   515: getfield 60	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:TAG	Ljava/lang/String;
    //   518: new 69	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   525: ldc 212
    //   527: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_0
    //   531: invokevirtual 80	java/lang/Object:hashCode	()I
    //   534: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   537: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 93	com/tencent/qq/effect/utils/LogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: aload_0
    //   544: getfield 34	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   547: invokevirtual 101	android/media/MediaCodec:release	()V
    //   550: aload_0
    //   551: aconst_null
    //   552: putfield 34	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   555: aload_0
    //   556: aconst_null
    //   557: putfield 50	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mInputBuffers	[Ljava/nio/ByteBuffer;
    //   560: aload_0
    //   561: aconst_null
    //   562: putfield 52	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:mOutputBuffers	[Ljava/nio/ByteBuffer;
    //   565: aload_0
    //   566: invokespecial 155	com/tencent/qq/effect/alphavideo/videoplayer/decoder/HardwareFileDecoder:releaseExtractor	()V
    //   569: bipush 251
    //   571: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	HardwareFileDecoder
    //   0	572	1	paramString	String
    //   0	572	2	paramObject	Object
    //   23	311	3	i	int
    //   26	309	4	j	int
    //   1	24	5	k	int
    // Exception table:
    //   from	to	target	type
    //   3	22	166	java/lang/Exception
    //   28	68	226	java/lang/Exception
    //   71	104	226	java/lang/Exception
    //   104	113	226	java/lang/Exception
    //   341	465	484	java/lang/Exception
  }
  
  public void decode()
  {
    int j = 0;
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    if (this.mDecodeListener != null) {
      this.mDecodeListener.onVideoDecodeStart();
    }
    this.mFirstFrameSysTime = 0L;
    this.mFirstFrameTimeUS = 0L;
    int k;
    int i;
    try
    {
      this.mStart = true;
      k = 1;
      i = 0;
      if (j == 0)
      {
        if (!this.mStart) {
          LogUtil.i(this.TAG, "decode stop!");
        }
      }
      else
      {
        if (this.mStart) {
          this.mStart = false;
        }
        releaseCodec();
        releaseExtractor();
        this.mMime = null;
        this.mFormat = null;
        this.mInputBuffers = null;
        this.mOutputBuffers = null;
        this.mSamplePresentationTimeUs = 0L;
        this.mPresentationTimeUs = 0L;
        this.mFirstFrameTimeUS = 0L;
        this.mFirstFrameSysTime = 0L;
        if ((k != 0) && (this.mDecodeListener != null)) {
          this.mDecodeListener.onVideoDecodeEnd();
        }
        return;
      }
    }
    finally {}
    if (i == 0) {}
    label701:
    label704:
    for (;;)
    {
      for (;;)
      {
        try
        {
          i1 = this.mMediaCodec.dequeueInputBuffer(1000L);
          if (i1 < 0) {
            break label704;
          }
          localObject2 = this.mInputBuffers[i1];
          m = this.mExtractor.readSampleData((ByteBuffer)localObject2, 0);
          if (m < 0)
          {
            LogUtil.d(this.TAG, "saw input EOS. Stopping playback");
            i = 1;
            m = 0;
          }
        }
        catch (RuntimeException localRuntimeException2)
        {
          int i1;
          Object localObject2;
          int m;
          long l1;
          int n;
          long l2;
          continue;
        }
        try
        {
          localObject2 = this.mMediaCodec;
          l1 = this.mSamplePresentationTimeUs;
          if (i != 0)
          {
            n = 4;
            ((MediaCodec)localObject2).queueInputBuffer(i1, 0, m, l1, n);
            if (i == 0) {
              this.mExtractor.advance();
            }
          }
        }
        catch (RuntimeException localRuntimeException3)
        {
          continue;
          continue;
        }
        try
        {
          m = this.mMediaCodec.dequeueOutputBuffer(localBufferInfo, 1000L);
          if (m >= 0) {
            if (this.mFirstFrameSysTime == 0L)
            {
              this.mFirstFrameSysTime = System.currentTimeMillis();
              this.mFirstFrameTimeUS = localBufferInfo.presentationTimeUs;
              this.mPresentationTimeUs = localBufferInfo.presentationTimeUs;
              this.mMediaCodec.releaseOutputBuffer(m, true);
              if (this.mDecodeListener != null) {
                this.mDecodeListener.onVideoDecodeFrame(this.mPresentationTimeUs, null);
              }
              if ((localBufferInfo.flags & 0x4) == 0) {
                break label701;
              }
              LogUtil.d(this.TAG, "decode output EOS. End");
              boolean bool = this.mLoop;
              if (!bool) {
                continue;
              }
            }
          }
        }
        catch (RuntimeException localRuntimeException1)
        {
          LogUtil.e(this.TAG, "decoding error:" + localRuntimeException1.getMessage());
          if (this.mDecodeListener != null) {
            this.mDecodeListener.onVideoDecodeError(-101);
          }
          this.mStart = false;
          k = 0;
        }
        try
        {
          this.mFirstFrameSysTime = 0L;
          this.mFirstFrameTimeUS = 0L;
          this.mPresentationTimeUs = 0L;
          this.mExtractor.seekTo(0L, 2);
          this.mMediaCodec.flush();
          i = 0;
        }
        catch (RuntimeException localRuntimeException4)
        {
          MediaFormat localMediaFormat;
          i = 0;
        }
      }
      this.mSamplePresentationTimeUs = this.mExtractor.getSampleTime();
      continue;
      n = 0;
      continue;
      l1 = System.currentTimeMillis() - this.mFirstFrameSysTime;
      l2 = (localBufferInfo.presentationTimeUs - this.mFirstFrameTimeUS) / 1000L;
      if (l1 < l2)
      {
        try
        {
          Thread.sleep(l2 - l1);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        continue;
        break;
        j = 1;
        continue;
        if (m == -3)
        {
          this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
          LogUtil.d(this.TAG, "output buffers have changed.");
        }
        else if (m == -2)
        {
          localMediaFormat = this.mMediaCodec.getOutputFormat();
          LogUtil.d(this.TAG, "output mFormat has changed to " + localMediaFormat);
        }
        else if (m == -1)
        {
          LogUtil.d(this.TAG, "dequeueOutputBuffer timed out! MediaCodec.INFO_TRY_AGAIN_LATER ");
        }
        else
        {
          LogUtil.d(this.TAG, " dequeueOutputBuffer returned " + m);
        }
      }
    }
  }
  
  public long getCurPresentationTimeUs()
  {
    return this.mPresentationTimeUs;
  }
  
  public IVideoFileDecodeListener getDecodeListener()
  {
    return this.mDecodeListener;
  }
  
  public void release()
  {
    releaseCodec();
    releaseExtractor();
  }
  
  public void setDecodeListener(IVideoFileDecodeListener paramIVideoFileDecodeListener)
  {
    this.mDecodeListener = paramIVideoFileDecodeListener;
  }
  
  public void setLoopState(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  public void stop()
  {
    try
    {
      this.mStart = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.decoder.HardwareFileDecoder
 * JD-Core Version:    0.7.0.1
 */
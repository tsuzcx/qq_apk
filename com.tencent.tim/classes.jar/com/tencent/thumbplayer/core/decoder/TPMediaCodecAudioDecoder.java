package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.tmediacodec.TMediaCodec;
import java.nio.ByteBuffer;

@RequiresApi(api=16)
public class TPMediaCodecAudioDecoder
  extends TPBaseMediaCodecDecoder
{
  private static final String TAG = "TPMediaCodecAudioDecoder";
  private int mAudioFormat = 0;
  private int mChannelCount = 0;
  private byte[] mCsd0Data = null;
  private boolean mEnableAudioPassThrough = false;
  private boolean mIsAdts = false;
  private String mMimeType = null;
  private int mSampleRate = 0;
  
  public TPMediaCodecAudioDecoder(int paramInt)
  {
    super(paramInt);
  }
  
  void configCodec(@NonNull TMediaCodec paramTMediaCodec)
  {
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "configCodec: ");
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannelCount);
    if (this.mCsd0Data != null) {
      localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(this.mCsd0Data));
    }
    if (this.mIsAdts)
    {
      TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "configCodec: set is adts");
      localMediaFormat.setInteger("is-adts", 1);
    }
    paramTMediaCodec.configure(localMediaFormat, null, this.mMediaCrypto, 0);
  }
  
  String getLogTag()
  {
    return "TPMediaCodecAudioDecoder";
  }
  
  String getMimeType()
  {
    return this.mMimeType;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "initDecoder, mimeType:" + paramString + " sampleRate:" + paramInt1 + " channelCount:" + paramInt2 + " drmType:" + paramInt3 + " audioFormat:" + paramInt4);
    this.mMimeType = paramString;
    this.mSampleRate = paramInt1;
    this.mChannelCount = paramInt2;
    this.mDrmType = paramInt3;
    this.mAudioFormat = paramInt4;
    return true;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface, int paramInt4, int paramInt5, int paramInt6)
  {
    return false;
  }
  
  void processMediaCodecException(Exception paramException) {}
  
  void processOutputBuffer(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo)
  {
    paramTPFrameInfo.sampleRate = this.mSampleRate;
    paramTPFrameInfo.channelCount = this.mChannelCount;
    paramTPFrameInfo.format = this.mAudioFormat;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (ByteBuffer localByteBuffer = paramTMediaCodec.getOutputBuffer(paramInt);; localByteBuffer = paramTMediaCodec.getOutputBuffers()[paramInt])
    {
      byte[] arrayOfByte = null;
      if (localByteBuffer != null)
      {
        arrayOfByte = new byte[paramBufferInfo.size];
        localByteBuffer.get(arrayOfByte, paramBufferInfo.offset, paramBufferInfo.size);
      }
      paramTPFrameInfo.data = arrayOfByte;
      if ((paramBufferInfo.flags == 4) && (paramBufferInfo.size <= 0))
      {
        TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "processOutputBuffer: bufferInfo.flags is BUFFER_FLAG_END_OF_STREAM, return EOS!");
        paramTPFrameInfo.errCode = 2;
      }
      paramTMediaCodec.releaseOutputBuffer(paramInt, false);
      return;
    }
  }
  
  void processOutputConfigData(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo)
  {
    paramTMediaCodec.releaseOutputBuffer(paramInt, false);
    paramTPFrameInfo.errCode = 1;
  }
  
  /* Error */
  void processOutputFormatChanged(@NonNull MediaFormat paramMediaFormat)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 184
    //   3: invokevirtual 188	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 184
    //   13: invokevirtual 192	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   16: putfield 29	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mSampleRate	I
    //   19: aload_1
    //   20: ldc 194
    //   22: invokevirtual 188	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   25: ifeq +13 -> 38
    //   28: aload_0
    //   29: aload_1
    //   30: ldc 194
    //   32: invokevirtual 192	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   35: putfield 31	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mChannelCount	I
    //   38: getstatic 142	android/os/Build$VERSION:SDK_INT	I
    //   41: bipush 24
    //   43: if_icmplt +157 -> 200
    //   46: aload_1
    //   47: ldc 196
    //   49: invokevirtual 188	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   52: ifeq +148 -> 200
    //   55: aload_1
    //   56: ldc 196
    //   58: invokevirtual 192	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   61: istore_2
    //   62: iconst_2
    //   63: ldc 11
    //   65: new 95	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   72: ldc 198
    //   74: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: iload_2
    //   78: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 51	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   87: iconst_2
    //   88: ldc 11
    //   90: new 95	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   97: ldc 200
    //   99: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: getfield 39	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mEnableAudioPassThrough	Z
    //   106: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   109: ldc 205
    //   111: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: getfield 29	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mSampleRate	I
    //   118: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc 207
    //   123: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: getfield 31	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mChannelCount	I
    //   130: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc 209
    //   135: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: getfield 33	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mAudioFormat	I
    //   142: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: ldc 211
    //   147: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_2
    //   151: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 51	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   160: return
    //   161: astore_1
    //   162: iconst_2
    //   163: istore_2
    //   164: iconst_4
    //   165: ldc 11
    //   167: new 95	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   174: ldc 213
    //   176: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_0
    //   180: aload_1
    //   181: invokevirtual 217	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:getStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 51	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   193: goto -106 -> 87
    //   196: astore_1
    //   197: goto -33 -> 164
    //   200: iconst_2
    //   201: istore_2
    //   202: goto -115 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	TPMediaCodecAudioDecoder
    //   0	205	1	paramMediaFormat	MediaFormat
    //   61	141	2	i	int
    // Exception table:
    //   from	to	target	type
    //   0	19	161	java/lang/Exception
    //   19	38	161	java/lang/Exception
    //   38	62	161	java/lang/Exception
    //   62	87	196	java/lang/Exception
  }
  
  public int setOperateRate(float paramFloat)
  {
    return super.setOperateRate(paramFloat);
  }
  
  public boolean setParamBool(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 2)
    {
      this.mIsAdts = paramBoolean;
      return true;
    }
    if (paramInt == 3)
    {
      this.mEnableAudioPassThrough = paramBoolean;
      TPNativeLog.printLog(2, getLogTag(), "setParamBool mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
      return true;
    }
    return super.setParamBool(paramInt, paramBoolean);
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt == 200) {
      this.mCsd0Data = paramArrayOfByte;
    }
    return super.setParamBytes(paramInt, paramArrayOfByte);
  }
  
  public boolean setParamObject(int paramInt, Object paramObject)
  {
    return super.setParamObject(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecAudioDecoder
 * JD-Core Version:    0.7.0.1
 */
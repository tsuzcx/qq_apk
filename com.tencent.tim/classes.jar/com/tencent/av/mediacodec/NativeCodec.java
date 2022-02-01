package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import imm;
import ioc;
import ioc.a;
import ioc.c;
import iod;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import jjd;

@TargetApi(16)
public class NativeCodec
  implements iod
{
  public static String AVCPPS = "csd-1";
  public static String AVCSPS;
  public static String BOTTOM;
  public static String HEVCVPSSPSPPS = "csd-0";
  public static String LEFT = "crop-left";
  public static String RIGHT;
  public static String SLICEHEIGHT = "slice-height";
  public static String STRIDE;
  public static String TOP = "crop-top";
  static a gAVCDecoderCaps;
  static a gAVCEncoderCaps;
  static a gHEVCDecoderCaps;
  static a gHEVCEncoderCaps;
  public static int mH264DecBaseLineLevel;
  public static int mH264DecHighProfileLevel;
  public static int mH264EncBaseLineLevel;
  public static int mH264EncHighProfileLevel;
  public static int mH265DecLevel;
  public static int mH265EncLevel;
  public static boolean mHasGetLevelInfo;
  public static boolean mUseAsyncAPI;
  public static boolean printLog;
  public final String TAG;
  int mBitRate;
  ioc mCodec;
  AtomicBoolean mCodersExit = new AtomicBoolean(false);
  int mColorFormat;
  boolean mDebugDelay = false;
  Map<Long, Long> mDebugDelayMap = null;
  Map<Integer, Long> mDebugDelayMap2 = null;
  Map<Long, Integer> mDebugIndexMap = null;
  MediaFormat mFormat = null;
  int mFrameInverval = 40000;
  int mFrameRate = 20;
  int mHeight = 240;
  long mLastEncFrameTime = 0L;
  String mMime;
  private long mNativeContext;
  List<ioc.c> mPendingInputBuffers = new ArrayList();
  long mTimeStamp = 0L;
  int mTotalDecInFrameNum = 0;
  int mTotalDecOutFrameNum = 0;
  int mTryAgainLaterCount = 0;
  int mTryAgainLaterCount2 = 0;
  int mWidth = 320;
  boolean misdecoder;
  int setBitRatePending = 0;
  boolean setIFramePending = false;
  
  static
  {
    RIGHT = "crop-right";
    BOTTOM = "crop-bottom";
    STRIDE = "stride";
    AVCSPS = "csd-0";
  }
  
  public NativeCodec()
  {
    this.TAG = ("NativeCodec_" + AudioHelper.hG());
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public NativeCodec(String paramString, long paramLong, Map<String, Object> paramMap, boolean paramBoolean)
  {
    mUseAsyncAPI = DeviceCheck.isSupportAsyncAPI();
    this.misdecoder = paramBoolean;
    Object localObject2 = new StringBuilder().append("NativeCodec_");
    Object localObject1;
    if (mUseAsyncAPI)
    {
      localObject1 = "Async ";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
      if (!this.misdecoder) {
        break label594;
      }
      localObject1 = "DEC";
      label174:
      this.TAG = ((String)localObject1 + "_i" + paramLong + "_" + AudioHelper.hG());
      this.mMime = paramString;
      this.mNativeContext = paramLong;
      this.mWidth = ((Integer)paramMap.get("width")).intValue();
      this.mHeight = ((Integer)paramMap.get("height")).intValue();
      if (AudioHelper.aCz()) {
        QLog.w(this.TAG, 1, "NativeCodec, w[" + this.mWidth + "], h[" + this.mHeight + "], isdecoder[" + this.misdecoder + "], mMime[" + this.mMime + "]");
      }
      if (!this.misdecoder) {
        break label611;
      }
    }
    for (;;)
    {
      try
      {
        int i = this.mWidth;
        int j = this.mHeight;
        this.mFormat = MediaFormat.createVideoFormat(paramString, i, j);
        if (paramString.contains(ioc.AVC_CODEC_MIME))
        {
          this.mFormat.setInteger("max-input-size", i * j);
          this.mFormat.setInteger("color-format", 21);
          this.mFormat.setInteger("frame-rate", 25);
          localObject1 = (ByteBuffer)paramMap.get(AVCSPS);
          localObject2 = (ByteBuffer)paramMap.get(AVCPPS);
          this.mFormat.setByteBuffer(AVCSPS, (ByteBuffer)localObject1);
          this.mFormat.setByteBuffer(AVCPPS, (ByteBuffer)localObject2);
        }
        if (paramString.contains(ioc.OM))
        {
          this.mFormat.setInteger("max-input-size", i * j);
          this.mFormat.setInteger("color-format", 21);
          this.mFormat.setInteger("frame-rate", 25);
          paramString = (ByteBuffer)paramMap.get(HEVCVPSSPSPPS);
          this.mFormat.setByteBuffer(HEVCVPSSPSPPS, paramString);
        }
        createDecCodec();
      }
      catch (Exception paramString)
      {
        label594:
        this.mCodec = null;
        continue;
      }
      if (this.mDebugDelay)
      {
        this.mDebugDelayMap = new HashMap();
        this.mDebugDelayMap2 = new HashMap();
        this.mDebugIndexMap = new HashMap();
      }
      return;
      localObject1 = " Sync ";
      break;
      localObject1 = "ENC";
      break label174;
      try
      {
        label611:
        this.mBitRate = ((Integer)paramMap.get("bitrate")).intValue();
        this.mFrameRate = ((Integer)paramMap.get("frame-rate")).intValue();
        createEncCodec();
      }
      catch (Exception paramString)
      {
        this.mCodec = null;
        QLog.w(this.TAG, 1, "NativeCodec, createEncCodec Exception", paramString);
      }
    }
  }
  
  public static boolean canLog()
  {
    return (QLog.isDevelopLevel()) || ((QLog.isColorLevel()) && (printLog));
  }
  
  private void createDecCodec()
  {
    this.mCodec = new ioc(this.TAG);
    List localList;
    if (this.misdecoder)
    {
      localList = ioc.getDecoderInfos(this.mMime);
      if (localList.size() != 0) {
        break label59;
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "createDecCodec fail, list.size为0");
      }
    }
    label59:
    label214:
    for (;;)
    {
      return;
      MediaCodecInfo localMediaCodecInfo = (MediaCodecInfo)localList.get(0);
      int i = 0;
      Object localObject;
      for (;;)
      {
        localObject = localMediaCodecInfo;
        if (i >= localList.size()) {
          break label152;
        }
        localObject = ioc.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
        if (localObject != null) {
          break;
        }
        i += 1;
      }
      if (jjd.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19))
      {
        localObject = (MediaCodecInfo)localList.get(i);
        this.mFormat.setInteger("color-format", 19);
      }
      for (;;)
      {
        if (this.mCodec.a(this.mFormat, ((MediaCodecInfo)localObject).getName(), this)) {
          break label214;
        }
        this.mCodec = null;
        return;
        if (!jjd.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21)) {
          break;
        }
        localObject = (MediaCodecInfo)localList.get(i);
        this.mFormat.setInteger("color-format", 21);
      }
    }
  }
  
  private boolean dequeueLastFrame(int paramInt)
  {
    if (this.mCodec == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 1, "dequeueLastFrame err!! mCodec is null");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        ioc.a locala = this.mCodec.a();
        int i = 0;
        Object localObject = locala;
        int j;
        if (locala == null)
        {
          j = i + 1;
          if (this.misdecoder) {
            dequeueOutFrameMore(3000000L);
          }
          locala = this.mCodec.a();
          if (locala != null) {
            localObject = locala;
          }
        }
        else
        {
          ((ioc.a)localObject).buffer = null;
          this.mCodec.queueInputBuffer(((ioc.a)localObject).index, 0, 0L, 4);
          i = 0;
          j = 0;
          if (i >= 10) {
            break;
          }
          i += 1;
          locala = this.mCodec.b();
          if ((locala == null) || (locala.index < 0)) {
            break label514;
          }
          if (locala.success) {
            continue;
          }
          if (!AudioHelper.aCz()) {
            break label511;
          }
          QLog.e(this.TAG, 1, "dequeueLastFrame output.success is false");
          continue;
        }
        i = j;
        if (j <= 8) {
          continue;
        }
        if (!canLog()) {
          break label517;
        }
        QLog.e(this.TAG, 2, "dequeueLastFrame not available, try count=" + j);
        break label517;
        if ((locala.format == null) || (locala.buffer == null))
        {
          if (AudioHelper.aCz())
          {
            localObject = this.TAG;
            StringBuilder localStringBuilder = new StringBuilder().append("dequeueLastFrame err! output.format == null: ");
            if (locala.format != null) {
              break label519;
            }
            bool = true;
            localStringBuilder = localStringBuilder.append(bool).append(", output.buffer == null: ");
            if (locala.buffer != null) {
              break label525;
            }
            bool = true;
            QLog.e((String)localObject, 1, bool);
          }
          this.mCodec.releaseOutputBuffer(locala.index);
          continue;
        }
        if (this.misdecoder)
        {
          setFrame(locala.buffer, locala.info.size, locala.format);
          this.mCodec.releaseOutputBuffer(locala.index);
          if ((locala.info.flags & 0x4) != 0)
          {
            if (!AudioHelper.aCz()) {
              break;
            }
            QLog.w(this.TAG, 1, "dequeueLastFrame reach eof getFrame: " + j + ", lastFrameCount: " + paramInt + ", loopCount:" + i);
            break;
          }
        }
        else
        {
          readOutputStream(locala.buffer, locala.info.presentationTimeUs, locala.info.offset, locala.info.size, locala.info.flags);
          continue;
        }
        j += 1;
      }
      catch (Exception localException)
      {
        if (AudioHelper.aCz()) {
          QLog.e(this.TAG, 1, "dequeueLastFrame CodecException!!", localException);
        }
        return false;
      }
      label514:
      for (;;)
      {
        break;
        label511:
        break;
      }
      label517:
      return false;
      label519:
      boolean bool = false;
      continue;
      label525:
      bool = false;
    }
    return true;
  }
  
  private boolean dequeueOutFrameMore(long paramLong)
  {
    long l1 = 0L;
    while (l1 < paramLong)
    {
      long l2 = System.nanoTime();
      ioc.a locala = this.mCodec.a(3000L);
      l2 = l1 + (System.nanoTime() - l2);
      l1 = l2;
      if (locala != null)
      {
        l1 = l2;
        if (locala.index != -1)
        {
          l1 = l2;
          if (locala.index >= 0) {
            if (!locala.success)
            {
              l1 = l2;
              if (AudioHelper.aCz())
              {
                QLog.e(this.TAG, 1, "dequeueOutFrameMore get output buffer failed with exception");
                l1 = l2;
              }
            }
            else if ((locala.format == null) || (locala.buffer == null))
            {
              if (AudioHelper.aCz()) {
                QLog.e(this.TAG, 1, "dequeueOutFrameMore get output buffer error");
              }
              this.mCodec.releaseOutputBuffer(locala.index);
              l1 = l2;
            }
            else
            {
              setFrame(locala.buffer, locala.info.size, locala.format);
              this.mCodec.releaseOutputBuffer(locala.index);
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  private static int getIntValues(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = getIntValuesImp("NativeCodec", paramString1, paramString2, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.w("NativeCodec", 1, "getIntValues, mime[" + paramString1 + "], isDecoder[" + paramBoolean + "], key[" + paramString2 + "], value[" + i + "]");
    }
    return i;
  }
  
  static int getIntValuesImp(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    label172:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return 0;
                        if (!"supportAsync".equalsIgnoreCase(paramString3)) {
                          break;
                        }
                      } while (!mUseAsyncAPI);
                      return 1;
                      if (!paramString2.equalsIgnoreCase(ioc.AVC_CODEC_MIME)) {
                        break label172;
                      }
                      if (!paramBoolean) {
                        break;
                      }
                      if (gAVCDecoderCaps == null) {
                        initAVCDecoderCaps(paramString1);
                      }
                    } while (gAVCDecoderCaps == null);
                    if (paramString3.equalsIgnoreCase("width")) {
                      return gAVCDecoderCaps.width;
                    }
                    if (paramString3.equalsIgnoreCase("height")) {
                      return gAVCDecoderCaps.height;
                    }
                  } while (!paramString3.equalsIgnoreCase("profile"));
                  return gAVCDecoderCaps.profile;
                  if (gAVCEncoderCaps == null) {
                    initAVCEncoderCaps(paramString1);
                  }
                } while (gAVCEncoderCaps == null);
                if (paramString3.equalsIgnoreCase("width")) {
                  return gAVCEncoderCaps.width;
                }
                if (paramString3.equalsIgnoreCase("height")) {
                  return gAVCEncoderCaps.height;
                }
              } while (!paramString3.equalsIgnoreCase("profile"));
              return gAVCEncoderCaps.profile;
            } while (!paramString2.equalsIgnoreCase(ioc.OM));
            if (!paramBoolean) {
              break;
            }
            if (gHEVCDecoderCaps == null) {
              initHevcDecoderCaps(paramString1);
            }
          } while (gHEVCDecoderCaps == null);
          if (paramString3.equalsIgnoreCase("width")) {
            return gHEVCDecoderCaps.width;
          }
          if (paramString3.equalsIgnoreCase("height")) {
            return gHEVCDecoderCaps.height;
          }
        } while (!paramString3.equalsIgnoreCase("profile"));
        return gHEVCDecoderCaps.profile;
        if (gHEVCEncoderCaps == null) {
          initHevcEncoderCaps();
        }
      } while (gHEVCEncoderCaps == null);
      if (paramString3.equalsIgnoreCase("width")) {
        return gHEVCEncoderCaps.width;
      }
      if (paramString3.equalsIgnoreCase("height")) {
        return gHEVCEncoderCaps.height;
      }
    } while (!paramString3.equalsIgnoreCase("profile"));
    return gHEVCEncoderCaps.profile;
  }
  
  public static native int getVersion();
  
  public static void hardwareCodecLevelInfo()
  {
    if (mHasGetLevelInfo) {
      return;
    }
    String[] arrayOfString = new String[2];
    arrayOfString[0] = ioc.AVC_CODEC_MIME;
    arrayOfString[1] = ioc.OM;
    int m = arrayOfString.length;
    int k = 0;
    String str;
    Object localObject;
    int i;
    label53:
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    int j;
    if (k < m)
    {
      str = arrayOfString[k];
      localObject = ioc.getEndoderInfos(str);
      i = 0;
      if (i >= ((List)localObject).size()) {
        break label824;
      }
      localCodecCapabilities = ioc.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(i), str);
      if (localCodecCapabilities != null) {
        break label120;
      }
      j = 0;
    }
    for (;;)
    {
      if (((List)localObject).size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("NativeCodec", 1, "getEndoderInfos list.size为0");
        }
        mHasGetLevelInfo = true;
        return;
        label120:
        j = i;
        if (jjd.contains(localCodecCapabilities.colorFormats, 21)) {
          continue;
        }
        j = i;
        if (jjd.contains(localCodecCapabilities.colorFormats, 19)) {
          continue;
        }
        i += 1;
        break label53;
      }
      localObject = ioc.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(j), str);
      if (localObject != null) {
        if (str.contains(ioc.AVC_CODEC_MIME))
        {
          i = 0;
          if (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
          {
            QLog.d("NativeCodec", 1, "AVC ENC caps: " + i + ", profile: " + localObject.profileLevels[i].profile + ", level:" + localObject.profileLevels[i].level);
            switch (localObject.profileLevels[i].profile)
            {
            }
            for (;;)
            {
              i += 1;
              break;
              mH264EncBaseLineLevel = localObject.profileLevels[i].level;
              continue;
              mH264EncHighProfileLevel = localObject.profileLevels[i].level;
            }
          }
        }
        else if (str.contains(ioc.OM))
        {
          i = 0;
        }
      }
      for (;;)
      {
        if (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
        {
          QLog.d("NativeCodec", 1, "HEVC ENC caps: " + i + ", profile: " + localObject.profileLevels[i].profile + ", level:" + localObject.profileLevels[i].level);
          if (localObject.profileLevels[i].profile == 1) {
            mH265EncLevel = localObject.profileLevels[i].level;
          }
        }
        else
        {
          localObject = ioc.getDecoderInfos(str);
          if (((List)localObject).size() != 0) {
            break label501;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("NativeCodec", 1, "getDecoderInfos list.size为0");
          break;
        }
        i += 1;
      }
      label501:
      localObject = ioc.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), str);
      if ((localObject != null) && (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels != null)) {
        if (str.contains(ioc.AVC_CODEC_MIME))
        {
          i = 0;
          if (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
          {
            QLog.d("NativeCodec", 1, "AVC DEC caps: " + i + ", profile: " + localObject.profileLevels[i].profile + ", level:" + localObject.profileLevels[i].level);
            switch (localObject.profileLevels[i].profile)
            {
            }
            for (;;)
            {
              i += 1;
              break;
              mH264DecBaseLineLevel = localObject.profileLevels[i].level;
              continue;
              mH264DecHighProfileLevel = localObject.profileLevels[i].level;
            }
          }
        }
        else if (str.contains(ioc.OM))
        {
          i = 0;
        }
      }
      for (;;)
      {
        if (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
        {
          QLog.d("NativeCodec", 1, "HEVC DEC caps: " + i + ", profile: " + localObject.profileLevels[i].profile + ", level:" + localObject.profileLevels[i].level);
          if (localObject.profileLevels[i].profile == 1) {
            mH265DecLevel = localObject.profileLevels[i].level;
          }
        }
        else
        {
          k += 1;
          break;
        }
        i += 1;
      }
      label824:
      j = 0;
    }
  }
  
  private static void initAVCDecoderCaps(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, "initAVCDecoderCaps");
    }
    Object localObject = ioc.getDecoderInfos(ioc.AVC_CODEC_MIME);
    if (((List)localObject).size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.w(paramString, 1, "initAVCDecoderCaps fail, list.size为0");
      }
    }
    int i;
    do
    {
      do
      {
        return;
        localObject = ioc.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), ioc.AVC_CODEC_MIME);
      } while ((localObject == null) || (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels == null));
      gAVCDecoderCaps = new a();
      i = 0;
    } while (i >= ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length);
    switch (localObject.profileLevels[i].profile)
    {
    default: 
      label168:
      switch (localObject.profileLevels[i].level)
      {
      default: 
        if (localObject.profileLevels[i].level < 1) {
          if ((gAVCDecoderCaps.width < 176) || (gAVCDecoderCaps.height < 144))
          {
            gAVCDecoderCaps.width = 176;
            gAVCDecoderCaps.height = 144;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      i += 1;
      break;
      if (gAVCDecoderCaps.profile > 3) {
        break label168;
      }
      gAVCDecoderCaps.profile = 3;
      break label168;
      if (gAVCDecoderCaps.profile > 5) {
        break label168;
      }
      gAVCDecoderCaps.profile = 5;
      break label168;
      if (gAVCDecoderCaps.profile > 5) {
        break label168;
      }
      gAVCDecoderCaps.profile = 5;
      break label168;
      if (gAVCDecoderCaps.profile > 5) {
        break label168;
      }
      gAVCDecoderCaps.profile = 5;
      break label168;
      if (gAVCDecoderCaps.profile > 5) {
        break label168;
      }
      gAVCDecoderCaps.profile = 5;
      break label168;
      if (gAVCDecoderCaps.profile > 5) {
        break label168;
      }
      gAVCDecoderCaps.profile = 5;
      break label168;
      if (gAVCDecoderCaps.profile > 4) {
        break label168;
      }
      gAVCDecoderCaps.profile = 4;
      break label168;
      if ((gAVCDecoderCaps.width < 176) || (gAVCDecoderCaps.height < 144))
      {
        gAVCDecoderCaps.width = 176;
        gAVCDecoderCaps.height = 144;
        continue;
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          gAVCDecoderCaps.width = 352;
          gAVCDecoderCaps.height = 288;
          continue;
          if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
          {
            gAVCDecoderCaps.width = 352;
            gAVCDecoderCaps.height = 288;
            continue;
            if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
            {
              gAVCDecoderCaps.width = 352;
              gAVCDecoderCaps.height = 288;
              continue;
              if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
              {
                gAVCDecoderCaps.width = 352;
                gAVCDecoderCaps.height = 288;
                continue;
                if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
                {
                  gAVCDecoderCaps.width = 352;
                  gAVCDecoderCaps.height = 288;
                  continue;
                  if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 576))
                  {
                    gAVCDecoderCaps.width = 352;
                    gAVCDecoderCaps.height = 576;
                    continue;
                    if ((gAVCDecoderCaps.width < 720) || (gAVCDecoderCaps.height < 576))
                    {
                      gAVCDecoderCaps.width = 720;
                      gAVCDecoderCaps.height = 576;
                      continue;
                      if ((gAVCDecoderCaps.width < 720) || (gAVCDecoderCaps.height < 576))
                      {
                        gAVCDecoderCaps.width = 720;
                        gAVCDecoderCaps.height = 576;
                        continue;
                        if ((gAVCDecoderCaps.width < 1280) || (gAVCDecoderCaps.height < 720))
                        {
                          gAVCDecoderCaps.width = 1280;
                          gAVCDecoderCaps.height = 720;
                          continue;
                          if ((gAVCDecoderCaps.width < 1280) || (gAVCDecoderCaps.height < 1024))
                          {
                            gAVCDecoderCaps.width = 1280;
                            gAVCDecoderCaps.height = 1024;
                            continue;
                            if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1024))
                            {
                              gAVCDecoderCaps.width = 2048;
                              gAVCDecoderCaps.height = 1024;
                              continue;
                              if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1024))
                              {
                                gAVCDecoderCaps.width = 2048;
                                gAVCDecoderCaps.height = 1024;
                                continue;
                                if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1088))
                                {
                                  gAVCDecoderCaps.width = 2048;
                                  gAVCDecoderCaps.height = 1088;
                                  continue;
                                  if ((gAVCDecoderCaps.width < 3680) || (gAVCDecoderCaps.height < 1536))
                                  {
                                    gAVCDecoderCaps.width = 3680;
                                    gAVCDecoderCaps.height = 1536;
                                    continue;
                                    if ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 2048))
                                    {
                                      gAVCDecoderCaps.width = 4096;
                                      gAVCDecoderCaps.height = 2048;
                                      continue;
                                      if (localObject.profileLevels[i].level > 32768)
                                      {
                                        if ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 2160))
                                        {
                                          gAVCDecoderCaps.width = 4096;
                                          gAVCDecoderCaps.height = 2160;
                                        }
                                      }
                                      else {
                                        QLog.e(paramString, 2, "initAVCDecoder caps.profileLevels[k].level: " + localObject.profileLevels[i].level);
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static void initAVCEncoderCaps(String paramString)
  {
    boolean bool = false;
    Object localObject1 = ioc.getDecoderInfos(ioc.AVC_CODEC_MIME);
    if (((List)localObject1).size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.w(paramString, 1, "initAVCEncoderCaps fail, lists.size为0");
      }
    }
    do
    {
      int i;
      do
      {
        do
        {
          return;
          localObject1 = ioc.getCodecCapabilities((MediaCodecInfo)((List)localObject1).get(0), ioc.AVC_CODEC_MIME);
        } while ((localObject1 == null) || (((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels == null));
        gAVCEncoderCaps = new a();
        if (((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels.length <= 0) {
          break;
        }
        i = 0;
      } while (i >= ((MediaCodecInfo.CodecCapabilities)localObject1).profileLevels.length);
      if (QLog.isColorLevel()) {
        QLog.w(paramString, 1, "initAVCEncoderCaps, index[" + i + "], profile[" + localObject1.profileLevels[i].profile + "]");
      }
      switch (localObject1.profileLevels[i].profile)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        gAVCEncoderCaps.profile = 3;
        localObject2 = localObject1.profileLevels[i];
        ((MediaCodecInfo.CodecProfileLevel)localObject2).level = 512;
        setLevel((MediaCodecInfo.CodecProfileLevel)localObject2, gAVCEncoderCaps);
      }
    } while (!QLog.isColorLevel());
    Object localObject2 = new StringBuilder().append("initAVCEncoderCaps fail, caps[");
    if (localObject1 != null) {
      bool = true;
    }
    QLog.w(paramString, 1, bool + "]");
  }
  
  private static void initHevcDecoderCaps(String paramString)
  {
    Object localObject = ioc.getDecoderInfos(ioc.OM);
    if (((List)localObject).size() == 0) {}
    do
    {
      return;
      localObject = ioc.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), ioc.OM);
    } while ((localObject == null) || (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels == null));
    gHEVCDecoderCaps = new a();
    if (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length == 0) {}
    int i = 0;
    label65:
    if (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
    {
      if (localObject.profileLevels[i].profile > 1) {
        break label179;
      }
      if (gHEVCDecoderCaps.profile <= 1) {
        gHEVCDecoderCaps.profile = 1;
      }
      label104:
      if ((localObject.profileLevels[i].level > 1) && (localObject.profileLevels[i].level > 2)) {
        break label245;
      }
      if ((gHEVCDecoderCaps.width < 176) || (gHEVCDecoderCaps.height < 144))
      {
        gHEVCDecoderCaps.width = 176;
        gHEVCDecoderCaps.height = 144;
      }
    }
    for (;;)
    {
      i += 1;
      break label65;
      break;
      label179:
      if (localObject.profileLevels[i].profile == 2)
      {
        if (gHEVCDecoderCaps.profile > 2) {
          break label104;
        }
        gHEVCDecoderCaps.profile = 2;
        break label104;
      }
      if ((localObject.profileLevels[i].profile < 2) || (gHEVCDecoderCaps.profile > 2)) {
        break label104;
      }
      gHEVCDecoderCaps.profile = 2;
      break label104;
      label245:
      if ((localObject.profileLevels[i].level == 4) || (localObject.profileLevels[i].level == 8))
      {
        if ((gHEVCDecoderCaps.width < 352) || (gHEVCDecoderCaps.height < 288))
        {
          gHEVCDecoderCaps.width = 352;
          gHEVCDecoderCaps.height = 288;
        }
      }
      else if ((localObject.profileLevels[i].level == 16) || (localObject.profileLevels[i].level == 32))
      {
        if ((gHEVCDecoderCaps.width < 640) || (gHEVCDecoderCaps.height < 360))
        {
          gHEVCDecoderCaps.width = 640;
          gHEVCDecoderCaps.height = 360;
        }
      }
      else if ((localObject.profileLevels[i].level == 64) || (localObject.profileLevels[i].level == 128))
      {
        if ((gHEVCDecoderCaps.width < 960) || (gHEVCDecoderCaps.height < 540))
        {
          gHEVCDecoderCaps.width = 960;
          gHEVCDecoderCaps.height = 540;
        }
      }
      else if ((localObject.profileLevels[i].level == 256) || (localObject.profileLevels[i].level == 512))
      {
        if ((gHEVCDecoderCaps.width < 1280) || (gHEVCDecoderCaps.height < 720))
        {
          gHEVCDecoderCaps.width = 1280;
          gHEVCDecoderCaps.height = 720;
        }
      }
      else if ((localObject.profileLevels[i].level == 1024) || (localObject.profileLevels[i].level == 2048))
      {
        if ((gHEVCDecoderCaps.width < 2048) || (gHEVCDecoderCaps.height < 1080))
        {
          gHEVCDecoderCaps.width = 2048;
          gHEVCDecoderCaps.height = 1080;
        }
      }
      else if ((localObject.profileLevels[i].level == 4096) || (localObject.profileLevels[i].level == 8192))
      {
        if ((gHEVCDecoderCaps.width < 2048) || (gHEVCDecoderCaps.height < 1080))
        {
          gHEVCDecoderCaps.width = 2048;
          gHEVCDecoderCaps.height = 1080;
        }
      }
      else if ((localObject.profileLevels[i].level == 16384) || (localObject.profileLevels[i].level == 32768))
      {
        if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
        {
          gHEVCDecoderCaps.width = 4096;
          gHEVCDecoderCaps.height = 2160;
        }
      }
      else if ((localObject.profileLevels[i].level == 65536) || (localObject.profileLevels[i].level == 131072))
      {
        if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
        {
          gHEVCDecoderCaps.width = 4096;
          gHEVCDecoderCaps.height = 2160;
        }
      }
      else if ((localObject.profileLevels[i].level == 262144) || (localObject.profileLevels[i].level == 524288))
      {
        if ((gHEVCDecoderCaps.width < 4096) || (gHEVCDecoderCaps.height < 2160))
        {
          gHEVCDecoderCaps.width = 4096;
          gHEVCDecoderCaps.height = 2160;
        }
      }
      else if ((localObject.profileLevels[i].level == 1048576) || (localObject.profileLevels[i].level == 2097152))
      {
        if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
        {
          gHEVCDecoderCaps.width = 8192;
          gHEVCDecoderCaps.height = 4320;
        }
      }
      else if ((localObject.profileLevels[i].level == 4194304) || (localObject.profileLevels[i].level == 8388608))
      {
        if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
        {
          gHEVCDecoderCaps.width = 8192;
          gHEVCDecoderCaps.height = 4320;
        }
      }
      else if ((localObject.profileLevels[i].level >= 16777216) || (localObject.profileLevels[i].level >= 33554432))
      {
        if ((gHEVCDecoderCaps.width < 8192) || (gHEVCDecoderCaps.height < 4320))
        {
          gHEVCDecoderCaps.width = 8192;
          gHEVCDecoderCaps.height = 4320;
        }
      }
      else {
        QLog.e(paramString, 2, "initHevcDecoderCaps caps.profileLevels[" + i + "].level = " + localObject.profileLevels[i].level);
      }
    }
  }
  
  private static void initHevcEncoderCaps()
  {
    Object localObject = ioc.getDecoderInfos(ioc.OM);
    if (((List)localObject).size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.w("NativieCodec", 1, "initHevcEncoderCaps fail, lists.size为0");
      }
    }
    int i;
    do
    {
      do
      {
        return;
        localObject = ioc.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), ioc.OM);
      } while ((localObject == null) || (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels == null));
      gHEVCEncoderCaps = new a();
      i = 0;
    } while (i >= ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length);
    switch (localObject.profileLevels[i].profile)
    {
    }
    for (;;)
    {
      i += 1;
      break;
      gHEVCEncoderCaps.profile = 1;
      MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = localObject.profileLevels[i];
      localCodecProfileLevel.level = 16384;
      setHevcLevel(localCodecProfileLevel, gHEVCEncoderCaps);
    }
  }
  
  private static boolean onAttach(String paramString, long paramLong, boolean paramBoolean, Map<String, Object> paramMap)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return false;
    }
    NativeCodec localNativeCodec = new NativeCodec(paramString, paramLong, paramMap, paramBoolean);
    QLog.w(localNativeCodec.TAG, 1, "onAttach, mime[" + paramString + "], instance[" + paramLong + "], isDecoder[" + paramBoolean + "]");
    AudioHelper.b(localNativeCodec.TAG, paramMap, true);
    if (localNativeCodec.mCodec == null)
    {
      QLog.w(localNativeCodec.TAG, 1, "onAttach, fail");
      return false;
    }
    localNativeCodec.attachCodec(localNativeCodec);
    localNativeCodec.mTimeStamp = 0L;
    localNativeCodec.mTryAgainLaterCount = 0;
    localNativeCodec.mLastEncFrameTime = 0L;
    localNativeCodec.mTotalDecOutFrameNum = 0;
    localNativeCodec.mTotalDecInFrameNum = 0;
    return localNativeCodec.mCodec.start();
  }
  
  private boolean onCalcDelay(int paramInt)
  {
    if (this.mDebugDelay)
    {
      long l = System.currentTimeMillis();
      if (canLog()) {
        QLog.w(this.TAG, 1, "onCalcDelay, frameIndex[" + paramInt + "], cur[" + l + "]");
      }
      this.mDebugDelayMap2.put(Integer.valueOf(paramInt), Long.valueOf(l));
    }
    return true;
  }
  
  private static void onDetach(Object arg0)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    NativeCodec localNativeCodec = (NativeCodec)???;
    if (localNativeCodec != null)
    {
      localNativeCodec.detachCodec();
      localNativeCodec.mTryAgainLaterCount = 0;
      localNativeCodec.mTimeStamp = 0L;
      localNativeCodec.mFormat = null;
      localNativeCodec.mLastEncFrameTime = 0L;
      localNativeCodec.mTotalDecOutFrameNum = 0;
      localNativeCodec.mTotalDecInFrameNum = 0;
      synchronized (localNativeCodec.mPendingInputBuffers)
      {
        localNativeCodec.mCodersExit.set(true);
        localNativeCodec.mPendingInputBuffers.clear();
        if (localNativeCodec.mDebugDelay)
        {
          localNativeCodec.mDebugDelayMap.clear();
          localNativeCodec.mDebugDelayMap2.clear();
          localNativeCodec.mDebugIndexMap.clear();
        }
        ioc localioc = localNativeCodec.mCodec;
        if (localioc == null) {}
      }
    }
    try
    {
      localNativeCodec.mCodec.stop();
      localNativeCodec.mCodec.release();
      label133:
      localNativeCodec.mCodec = null;
      QLog.w(localNativeCodec.TAG, 1, "onDetach");
      return;
      localObject = finally;
      throw localObject;
      QLog.w("NativeCodec", 1, "onDetach, jNativeCodec[" + ??? + "]");
      return;
    }
    catch (Exception localException)
    {
      break label133;
    }
  }
  
  private boolean onDoCodec(int paramInt1, int paramInt2)
  {
    if (this.mCodec == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 1, "onDoCodec err!! mCodec is null");
      }
      return false;
    }
    if (canLog()) {
      QLog.w(this.TAG, 1, "onDoCodec,frameIndex[" + paramInt2 + "], flag[" + paramInt1 + "], mTryAgainLaterCount[" + this.mTryAgainLaterCount + "]");
    }
    if ((this.mTryAgainLaterCount >= 10) && (paramInt1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 1, "onDoCodec err!! restCodec mTryAgainLaterCount: " + this.mTryAgainLaterCount + ", flag: " + paramInt1);
      }
      resetCodec();
      if (this.mCodec == null) {
        return false;
      }
    }
    Object localObject4;
    Object localObject5;
    label410:
    for (;;)
    {
      try
      {
        Object localObject1 = this.mCodec.a();
        paramInt1 = 0;
        localObject4 = localObject1;
        int j;
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.TAG, 2, "onDoCodec not available");
          }
          j = paramInt1;
          localObject5 = localObject1;
        }
        try
        {
          Thread.sleep(50L);
          j = paramInt1;
          localObject5 = localObject1;
          localObject4 = this.mCodec.a();
          int i = paramInt1 + 1;
          if (localObject4 != null)
          {
            if (!this.misdecoder) {
              break label410;
            }
            paramInt1 = writeInputData(((ioc.a)localObject4).buffer, false);
            if (paramInt1 >= 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.e(this.TAG, 2, "writeInputData, SampleSize < 0");
            }
            return false;
          }
          j = i;
          localObject5 = localObject4;
          if (QLog.isColorLevel())
          {
            j = i;
            localObject5 = localObject4;
            QLog.e(this.TAG, 2, "onDoCodec not available");
          }
          paramInt1 = i;
          localObject1 = localObject4;
          if (i <= 8) {
            continue;
          }
          j = i;
          localObject5 = localObject4;
          if (QLog.isColorLevel())
          {
            j = i;
            localObject5 = localObject4;
            QLog.e(this.TAG, 2, "onDoCodec not available, try count=" + i);
          }
          return false;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          paramInt1 = j;
          Object localObject2 = localObject5;
        }
        continue;
        paramInt1 = writeInputData2(((ioc.a)localObject4).buffer, this.mColorFormat, false);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "onDoCodec Exception!", localException);
        }
        return false;
      }
    }
    this.mLastEncFrameTime += this.mFrameInverval;
    if (this.mDebugDelay)
    {
      this.mDebugDelayMap.put(Long.valueOf(this.mLastEncFrameTime), Long.valueOf(System.currentTimeMillis()));
      this.mDebugIndexMap.put(Long.valueOf(this.mLastEncFrameTime), Integer.valueOf(paramInt2));
    }
    this.mCodec.queueInputBuffer(((ioc.a)localObject4).index, paramInt1, this.mLastEncFrameTime, 0);
    this.mTotalDecInFrameNum += 1;
    long l2 = System.nanoTime();
    long l1 = 33000000L;
    Object localObject3;
    if (this.misdecoder)
    {
      if (paramInt2 < 4) {
        l1 = 45000000L;
      }
      localObject3 = this.mCodec.a(l1);
    }
    for (;;)
    {
      if (localObject3 != null) {
        if (((ioc.a)localObject3).index == -1)
        {
          this.mTryAgainLaterCount += 1;
          if (QLog.isColorLevel()) {
            QLog.w(this.TAG, 1, "onDoCodec, try again, count[" + this.mTryAgainLaterCount + "]");
          }
          if ((this.misdecoder) && (dequeueOutFrameMore(l1 - (System.nanoTime() - l2))))
          {
            this.mTryAgainLaterCount = 0;
            return true;
            localObject3 = this.mCodec.b();
            l1 = 33000000L;
            continue;
          }
          if (this.mTryAgainLaterCount >= 16) {
            return false;
          }
        }
        else
        {
          this.mTryAgainLaterCount = 0;
          if (!((ioc.a)localObject3).success)
          {
            if (!QLog.isColorLevel()) {
              break label1333;
            }
            QLog.e(this.TAG, 2, "onDoCodec err!");
            break label1333;
          }
          if ((((ioc.a)localObject3).format == null) || (((ioc.a)localObject3).buffer == null))
          {
            this.mCodec.releaseOutputBuffer(((ioc.a)localObject3).index);
            if (!QLog.isColorLevel()) {
              break label1335;
            }
            localObject4 = this.TAG;
            localObject5 = new StringBuilder().append("onDoCodec err! output.format == null: ");
            if (((ioc.a)localObject3).format != null) {
              break label1337;
            }
            bool = true;
            localObject5 = ((StringBuilder)localObject5).append(bool).append(", output.buffer == null: ");
            if (((ioc.a)localObject3).buffer != null) {
              break label1343;
            }
            bool = true;
            label808:
            QLog.e((String)localObject4, 1, bool);
            break label1335;
          }
          if (this.misdecoder)
          {
            calcDelay(true, ((ioc.a)localObject3).info);
            setFrame(((ioc.a)localObject3).buffer, ((ioc.a)localObject3).info.size, ((ioc.a)localObject3).format);
            this.mCodec.releaseOutputBuffer(((ioc.a)localObject3).index);
            if ((!this.misdecoder) || (this.mTotalDecInFrameNum - this.mTotalDecOutFrameNum <= 0) || (!dequeueOutFrameMore(l1 - (System.nanoTime() - l2))) || (!QLog.isColorLevel())) {
              break label1349;
            }
            QLog.d(this.TAG, 2, "dequeue one store Frame success");
            break label1349;
          }
          if (((ioc.a)localObject3).info.flags == 1) {
            QLog.e(this.TAG, 2, "onDoCodec err flags!");
          }
          if (((ioc.a)localObject3).info.flags == 2)
          {
            this.mCodec.releaseOutputBuffer(((ioc.a)localObject3).index);
            readOutputStream(((ioc.a)localObject3).buffer, ((ioc.a)localObject3).info.presentationTimeUs, ((ioc.a)localObject3).info.offset, ((ioc.a)localObject3).info.size, ((ioc.a)localObject3).info.flags);
            localObject4 = this.mCodec.b();
            if (localObject4 != null)
            {
              if (((ioc.a)localObject4).index == -1)
              {
                this.mTryAgainLaterCount2 += 1;
                if (QLog.isColorLevel()) {
                  QLog.e(this.TAG, 2, "onDoCodec, re-dequeue dequeueOutputBuffer, try again later,count =" + this.mTryAgainLaterCount2);
                }
                if (this.mTryAgainLaterCount2 < 16) {
                  break label1351;
                }
                return false;
              }
              this.mTryAgainLaterCount2 = 0;
              if (!((ioc.a)localObject4).success)
              {
                if (!QLog.isColorLevel()) {
                  break label1353;
                }
                QLog.e(this.TAG, 2, "onDoCodec, re-dequeue onDoCodec err!");
                break label1353;
              }
              if ((((ioc.a)localObject4).format == null) || (((ioc.a)localObject4).buffer == null))
              {
                this.mCodec.releaseOutputBuffer(((ioc.a)localObject4).index);
                if (!QLog.isColorLevel()) {
                  break label1355;
                }
                localObject3 = this.TAG;
                localObject5 = new StringBuilder().append("onDoCodec err! output.format == null: ");
                if (((ioc.a)localObject4).format != null) {
                  break label1357;
                }
                bool = true;
                label1203:
                localObject5 = ((StringBuilder)localObject5).append(bool).append(", output.buffer == null: ");
                if (((ioc.a)localObject4).buffer != null) {
                  break label1363;
                }
              }
            }
          }
        }
      }
    }
    label1333:
    label1335:
    label1337:
    label1343:
    label1349:
    label1351:
    label1353:
    label1355:
    label1357:
    label1363:
    for (boolean bool = true;; bool = false)
    {
      QLog.e((String)localObject3, 1, bool);
      break label1355;
      localObject3 = localObject4;
      if (QLog.isColorLevel())
      {
        QLog.e(this.TAG, 2, "onDoCodec, re-dequeue success");
        localObject3 = localObject4;
      }
      for (;;)
      {
        calcDelay(true, ((ioc.a)localObject3).info);
        readOutputStream(((ioc.a)localObject3).buffer, ((ioc.a)localObject3).info.presentationTimeUs, ((ioc.a)localObject3).info.offset, ((ioc.a)localObject3).info.size, ((ioc.a)localObject3).info.flags);
        break;
      }
      return true;
      return false;
      return false;
      bool = false;
      break;
      bool = false;
      break label808;
      return true;
      return true;
      return false;
      return false;
      bool = false;
      break label1203;
    }
  }
  
  private int onDoCodecAsync(int paramInt1, int paramInt2)
  {
    if (!mUseAsyncAPI)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "NOT in async mode.");
      }
      return -1;
    }
    for (;;)
    {
      synchronized (this.mPendingInputBuffers)
      {
        if (this.mCodersExit.get())
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.TAG, 2, "hardware coders exit, return.");
          }
          return 2;
        }
        if (this.mPendingInputBuffers.size() > 0)
        {
          if (canLog()) {
            QLog.e(this.TAG, 2, "InputData pendingInputBuffers exist, size:" + this.mPendingInputBuffers.size());
          }
          ioc.c localc = (ioc.c)this.mPendingInputBuffers.get(0);
          if (localc == null) {
            return 2;
          }
          if (localc.buffer == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.TAG, 2, "inputbuffer null, return");
            }
            return -1;
          }
          if (localc.processing)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.TAG, 2, "curr buffer is being processed by other thread, return");
            }
            return 2;
          }
          if (this.misdecoder)
          {
            paramInt1 = writeInputData(localc.buffer, false);
            if (canLog()) {
              QLog.w(this.TAG, 1, "onDoCodecAsync, sampleSize[" + paramInt1 + "]");
            }
            if (paramInt1 > 0)
            {
              this.mLastEncFrameTime += this.mFrameInverval;
              this.mPendingInputBuffers.remove(0);
              if (this.mDebugDelay)
              {
                this.mDebugDelayMap.put(Long.valueOf(this.mLastEncFrameTime), Long.valueOf(System.currentTimeMillis()));
                this.mDebugIndexMap.put(Long.valueOf(this.mLastEncFrameTime), Integer.valueOf(paramInt2));
              }
              this.mCodec.queueInputBuffer(localc.index, paramInt1, this.mLastEncFrameTime, 0);
              return 1;
            }
          }
          else
          {
            paramInt1 = writeInputData2(localc.buffer, this.mColorFormat, false);
            continue;
            return 0;
            return -1;
          }
        }
        else
        {
          return 2;
        }
      }
      if (paramInt1 != 0) {
        if (paramInt1 != -1) {}
      }
    }
  }
  
  public static native boolean putByteArray2ByteBuffer(ByteBuffer paramByteBuffer, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  /* Error */
  private void resetCodec()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 301	com/tencent/av/mediacodec/NativeCodec:mCodec	Lioc;
    //   4: ifnull +82 -> 86
    //   7: aload_0
    //   8: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 149	com/tencent/av/mediacodec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   18: iconst_1
    //   19: invokevirtual 659	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   22: aload_0
    //   23: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   26: invokeinterface 662 1 0
    //   31: aload_0
    //   32: getfield 151	com/tencent/av/mediacodec/NativeCodec:mDebugDelay	Z
    //   35: ifeq +30 -> 65
    //   38: aload_0
    //   39: getfield 153	com/tencent/av/mediacodec/NativeCodec:mDebugDelayMap	Ljava/util/Map;
    //   42: invokeinterface 663 1 0
    //   47: aload_0
    //   48: getfield 155	com/tencent/av/mediacodec/NativeCodec:mDebugDelayMap2	Ljava/util/Map;
    //   51: invokeinterface 663 1 0
    //   56: aload_0
    //   57: getfield 157	com/tencent/av/mediacodec/NativeCodec:mDebugIndexMap	Ljava/util/Map;
    //   60: invokeinterface 663 1 0
    //   65: aload_0
    //   66: getfield 301	com/tencent/av/mediacodec/NativeCodec:mCodec	Lioc;
    //   69: invokevirtual 666	ioc:stop	()V
    //   72: aload_0
    //   73: getfield 301	com/tencent/av/mediacodec/NativeCodec:mCodec	Lioc;
    //   76: invokevirtual 669	ioc:release	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 301	com/tencent/av/mediacodec/NativeCodec:mCodec	Lioc;
    //   84: aload_1
    //   85: monitorexit
    //   86: aload_0
    //   87: getfield 200	com/tencent/av/mediacodec/NativeCodec:misdecoder	Z
    //   90: ifeq +65 -> 155
    //   93: aload_0
    //   94: invokespecial 292	com/tencent/av/mediacodec/NativeCodec:createDecCodec	()V
    //   97: aload_0
    //   98: lconst_0
    //   99: putfield 116	com/tencent/av/mediacodec/NativeCodec:mTimeStamp	J
    //   102: aload_0
    //   103: lconst_0
    //   104: putfield 118	com/tencent/av/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   107: aload_0
    //   108: getfield 301	com/tencent/av/mediacodec/NativeCodec:mCodec	Lioc;
    //   111: invokevirtual 629	ioc:start	()Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 149	com/tencent/av/mediacodec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   119: iconst_0
    //   120: invokevirtual 659	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   123: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +14 -> 140
    //   129: aload_0
    //   130: getfield 185	com/tencent/av/mediacodec/NativeCodec:TAG	Ljava/lang/String;
    //   133: iconst_2
    //   134: ldc_w 776
    //   137: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: return
    //   141: astore_2
    //   142: aload_1
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    //   146: astore_1
    //   147: aload_0
    //   148: aconst_null
    //   149: putfield 301	com/tencent/av/mediacodec/NativeCodec:mCodec	Lioc;
    //   152: goto -66 -> 86
    //   155: aload_0
    //   156: invokevirtual 308	com/tencent/av/mediacodec/NativeCodec:createEncCodec	()V
    //   159: goto -62 -> 97
    //   162: astore_1
    //   163: goto -40 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	NativeCodec
    //   146	1	1	localException1	Exception
    //   162	1	1	localException2	Exception
    //   141	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	65	141	finally
    //   65	86	141	finally
    //   142	144	141	finally
    //   7	14	146	java/lang/Exception
    //   144	146	146	java/lang/Exception
    //   86	97	162	java/lang/Exception
    //   97	123	162	java/lang/Exception
    //   155	159	162	java/lang/Exception
  }
  
  private boolean setFrame(ByteBuffer paramByteBuffer, int paramInt, MediaFormat paramMediaFormat)
  {
    int i9 = paramMediaFormat.getInteger("width");
    int i6 = paramMediaFormat.getInteger("height");
    int m = paramMediaFormat.getInteger(LEFT);
    int i7 = paramMediaFormat.getInteger(RIGHT);
    int k = paramMediaFormat.getInteger(TOP);
    int i8 = paramMediaFormat.getInteger(BOTTOM);
    int i = paramMediaFormat.getInteger(STRIDE);
    int j = paramMediaFormat.getInteger(SLICEHEIGHT);
    int i10 = paramMediaFormat.getInteger("color-format");
    j = Math.max(j, i6);
    int i11 = Math.max(i, i9);
    if (i10 == 2130706688)
    {
      j -= k / 2;
      k = 0;
      m = 0;
    }
    for (;;)
    {
      int i1 = Math.max(i11, i9);
      if (((2141391876 == i10) || (2130706433 == i10) || (2130706944 == i10)) && (i6 < j)) {}
      for (i = j;; i = i6)
      {
        int i5;
        int i2;
        int i4;
        int i3;
        int n;
        if (m + i7 + k + i8 == 0)
        {
          i5 = 0;
          i2 = i6 - 1;
          i4 = 0;
          i3 = i9 - 1;
          n = i1;
          if ((n <= 0) || (i <= 0) || (i3 <= 0) || (i2 <= 0))
          {
            if (QLog.isColorLevel()) {
              QLog.w(this.TAG, 1, "setFrame, error, size[" + paramInt + "], colorFormat[0x" + Integer.toHexString(i10).toUpperCase() + "]");
            }
            return false;
          }
        }
        else
        {
          i3 = i7 - m + 1;
          i2 = i8 - k + 1;
          n = i1;
          if (i1 < i3) {
            n = i3;
          }
          if (i >= i2) {
            break label650;
          }
          i = i2;
        }
        label650:
        for (;;)
        {
          i3 = i7;
          i1 = k;
          i4 = m;
          i2 = i8;
          i5 = i1;
          break;
          long l1 = SystemClock.elapsedRealtime();
          i1 = readOutputDataEx(paramByteBuffer, paramInt, n, i, i4, i5, i3 - i4 + 1, i2 - i5 + 1, i10);
          this.mTotalDecOutFrameNum += 1;
          long l2 = SystemClock.elapsedRealtime();
          if (canLog()) {
            QLog.w(this.TAG, 1, "setFrame, size[" + paramInt + "], width[" + i9 + "], height[" + i6 + "], crop_left[" + paramMediaFormat.getInteger(LEFT) + "->" + m + "], crop_right[" + i7 + "], crop_top[" + paramMediaFormat.getInteger(TOP) + "->" + k + "], crop_bottom[" + i8 + "], stride[" + paramMediaFormat.getInteger(STRIDE) + "->" + i11 + "], slice_height[" + paramMediaFormat.getInteger(SLICEHEIGHT) + "->" + j + "], picWidth[" + n + "], picHeight[" + i + "], colorFormat[0x" + Integer.toHexString(i10).toUpperCase() + "], cost[" + (l2 - l1) + "]");
          }
          return i1 > 0;
        }
      }
    }
  }
  
  private static void setHevcLevel(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, a parama)
  {
    if (paramCodecProfileLevel.level == 1) {
      if ((parama.width < 192) || (parama.height < 144))
      {
        parama.width = 192;
        parama.height = 144;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            if (paramCodecProfileLevel.level != 4) {
                              break;
                            }
                          } while ((parama.width >= 352) && (parama.height >= 288));
                          parama.width = 352;
                          parama.height = 288;
                          return;
                          if (paramCodecProfileLevel.level != 16) {
                            break;
                          }
                        } while ((parama.width >= 352) && (parama.height >= 576));
                        parama.width = 352;
                        parama.height = 576;
                        return;
                        if (paramCodecProfileLevel.level != 64) {
                          break;
                        }
                      } while ((parama.width >= 720) && (parama.height >= 576));
                      parama.width = 720;
                      parama.height = 576;
                      return;
                      if (paramCodecProfileLevel.level != 256) {
                        break;
                      }
                    } while ((parama.width >= 1280) && (parama.height >= 720));
                    parama.width = 1280;
                    parama.height = 720;
                    return;
                    if (paramCodecProfileLevel.level != 1024) {
                      break;
                    }
                  } while ((parama.width >= 1920) && (parama.height >= 1080));
                  parama.width = 1920;
                  parama.height = 1080;
                  return;
                  if (paramCodecProfileLevel.level != 4096) {
                    break;
                  }
                } while ((parama.width >= 1920) && (parama.height >= 1080));
                parama.width = 1920;
                parama.height = 1080;
                return;
                if (paramCodecProfileLevel.level != 16384) {
                  break;
                }
              } while ((parama.width >= 4096) && (parama.height >= 2048));
              parama.width = 4096;
              parama.height = 2048;
              return;
              if (paramCodecProfileLevel.level != 65536) {
                break;
              }
            } while ((parama.width >= 4096) && (parama.height >= 2048));
            parama.width = 4096;
            parama.height = 2048;
            return;
            if (paramCodecProfileLevel.level != 262144) {
              break;
            }
          } while ((parama.width >= 4096) && (parama.height >= 2048));
          parama.width = 4096;
          parama.height = 2048;
          return;
          if (paramCodecProfileLevel.level != 1048576) {
            break;
          }
        } while ((parama.width >= 4096) && (parama.height >= 4096));
        parama.width = 4096;
        parama.height = 4096;
        return;
        if (paramCodecProfileLevel.level != 4194304) {
          break;
        }
      } while ((parama.width >= 4096) && (parama.height >= 4096));
      parama.width = 4096;
      parama.height = 4096;
      return;
      if (paramCodecProfileLevel.level != 16777216) {
        break;
      }
    } while ((parama.width >= 4096) && (parama.height >= 4096));
    parama.width = 4096;
    parama.height = 4096;
    return;
    QLog.e("NativeCodec", 2, "setHevcLevel level.level = " + paramCodecProfileLevel.level);
  }
  
  private static void setLevel(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, a parama)
  {
    switch (paramCodecProfileLevel.level)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                  } while ((parama.width >= 176) && (parama.height >= 144));
                                  parama.width = 176;
                                  parama.height = 144;
                                  return;
                                } while ((parama.width >= 352) && (parama.height >= 288));
                                parama.width = 352;
                                parama.height = 288;
                                return;
                              } while ((parama.width >= 352) && (parama.height >= 288));
                              parama.width = 352;
                              parama.height = 288;
                              return;
                            } while ((parama.width >= 352) && (parama.height >= 288));
                            parama.width = 352;
                            parama.height = 288;
                            return;
                          } while ((parama.width >= 352) && (parama.height >= 288));
                          parama.width = 352;
                          parama.height = 288;
                          return;
                        } while ((parama.width >= 352) && (parama.height >= 288));
                        parama.width = 352;
                        parama.height = 288;
                        return;
                      } while ((parama.width >= 352) && (parama.height >= 576));
                      parama.width = 352;
                      parama.height = 576;
                      return;
                    } while ((parama.width >= 720) && (parama.height >= 576));
                    parama.width = 720;
                    parama.height = 576;
                    return;
                  } while ((parama.width >= 720) && (parama.height >= 576));
                  parama.width = 720;
                  parama.height = 576;
                  return;
                } while ((parama.width >= 1280) && (parama.height >= 720));
                parama.width = 1280;
                parama.height = 720;
                return;
              } while ((parama.width >= 1280) && (parama.height >= 1024));
              parama.width = 1280;
              parama.height = 1024;
              return;
            } while ((parama.width >= 2048) && (parama.height >= 1024));
            parama.width = 2048;
            parama.height = 1024;
            return;
          } while ((parama.width >= 2048) && (parama.height >= 1024));
          parama.width = 2048;
          parama.height = 1024;
          return;
        } while ((parama.width >= 2048) && (parama.height >= 1088));
        parama.width = 2048;
        parama.height = 1088;
        return;
      } while ((parama.width >= 3680) && (parama.height >= 1536));
      parama.width = 3680;
      parama.height = 1536;
      return;
    } while ((parama.width >= 4096) && (parama.height >= 2304));
    parama.width = 4096;
    parama.height = 2304;
  }
  
  private void setParameters(String paramString, int paramInt)
  {
    if (this.mCodec == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramString == null);
        if (!paramString.equalsIgnoreCase("frame-rate")) {
          break;
        }
      } while (paramInt <= 0);
      this.mFrameRate = paramInt;
      this.mFrameInverval = (1000000 / this.mFrameRate);
      resetCodec();
      QLog.e(this.TAG, 2, "HWENC setParameters mFrameRate =" + this.mFrameRate);
    } while (Build.VERSION.SDK_INT < 19);
    int i = paramInt;
    if (paramString.equalsIgnoreCase("i-frame-interval"))
    {
      QLog.e(this.TAG, 2, "HWENC setParameters i-frame-interval: " + paramInt + ", frameRate: " + this.mFrameRate);
      i = paramInt;
      if (this.mFrameRate * paramInt > 255)
      {
        i = 255 / this.mFrameRate;
        QLog.e(this.TAG, 2, "HWENC setParameters i-frame-interval changed: " + i);
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(paramString, i);
    this.mCodec.setParameters(localBundle);
  }
  
  public static native void set_device_infos(String paramString);
  
  public native boolean attachCodec(Object paramObject);
  
  void calcDelay(boolean paramBoolean, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.mDebugDelay)
    {
      Object localObject = (Long)this.mDebugDelayMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject != null)
      {
        if (canLog()) {
          QLog.w(this.TAG, 1, "calcDelay, small[" + paramBufferInfo.presentationTimeUs + "], takes[" + (System.currentTimeMillis() - ((Long)localObject).longValue()) + "]");
        }
        this.mDebugDelayMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
      localObject = (Integer)this.mDebugIndexMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject != null)
      {
        Long localLong = (Long)this.mDebugDelayMap2.get(localObject);
        if (localLong != null)
        {
          if (canLog()) {
            QLog.w(this.TAG, 1, "calcDelay, big[" + paramBufferInfo.presentationTimeUs + "], takes[" + (System.currentTimeMillis() - localLong.longValue()) + "]");
          }
          this.mDebugDelayMap2.remove(localObject);
        }
        this.mDebugIndexMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
    }
  }
  
  void createEncCodec()
  {
    int m = 0;
    int i;
    Object localObject;
    label85:
    int j;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    int k;
    if (this.mCodec == null) {
      try
      {
        List localList = ioc.getEndoderInfos(this.mMime);
        this.mColorFormat = 21;
        i = 0;
        if (i >= localList.size()) {
          break label671;
        }
        localObject = ioc.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
        if (localObject == null) {
          break label676;
        }
        if (jjd.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21)) {}
        for (this.mColorFormat = 21;; this.mColorFormat = 19)
        {
          localObject = MediaFormat.createVideoFormat(this.mMime, this.mWidth, this.mHeight);
          ((MediaFormat)localObject).setInteger("color-format", this.mColorFormat);
          ((MediaFormat)localObject).setInteger("frame-rate", this.mFrameRate);
          ((MediaFormat)localObject).setInteger("bitrate", this.mBitRate);
          j = 30;
          if (this.mFrameRate * 30 > 255) {
            j = 255 / this.mFrameRate;
          }
          QLog.e(this.TAG, 2, "KEY_I_FRAME_INTERVAL =" + j + ", mFrameRate = " + this.mFrameRate);
          ((MediaFormat)localObject).setInteger("i-frame-interval", j);
          localCodecCapabilities = ioc.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
          if (localCodecCapabilities == null) {
            break;
          }
          if (!this.mMime.contains(ioc.AVC_CODEC_MIME)) {
            break label390;
          }
          j = 0;
          if (j >= localCodecCapabilities.profileLevels.length) {
            break label390;
          }
          switch (localCodecCapabilities.profileLevels[j].profile)
          {
          case 1: 
            if (!jjd.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19)) {
              break label676;
            }
          }
        }
        k = 512;
        ((MediaFormat)localObject).setInteger("profile", 1);
        if (512 < localCodecCapabilities.profileLevels[j].level) {
          k = localCodecCapabilities.profileLevels[j].level;
        }
        ((MediaFormat)localObject).setInteger("level", k);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e(this.TAG, 2, "Exception at CreateCodec!!!!");
        this.mCodec = null;
      }
    } else {
      return;
    }
    label390:
    if (this.mMime.contains(ioc.OM)) {
      j = m;
    }
    for (;;)
    {
      if (j < localCodecCapabilities.profileLevels.length) {}
      switch (localCodecCapabilities.profileLevels[j].profile)
      {
      case 1: 
        k = 16384;
        ((MediaFormat)localObject).setInteger("profile", 1);
        if (16384 < localCodecCapabilities.profileLevels[j].level) {
          k = localCodecCapabilities.profileLevels[j].level;
        }
        String str = imm.gU();
        if ((str != null) && ((str.equalsIgnoreCase("QualcommTechnologies,IncMSM8953")) || (str.equalsIgnoreCase("QualcommTechnologies,Inc625"))))
        {
          ((MediaFormat)localObject).setInteger("level", 16384);
        }
        else
        {
          ((MediaFormat)localObject).setInteger("level", k);
          break label690;
          this.mFormat = ((MediaFormat)localObject);
          if (this.mFrameRate > 0) {}
          for (this.mFrameInverval = (1000000 / this.mFrameRate);; this.mFrameInverval = 40000)
          {
            this.mCodec = new ioc(this.TAG);
            QLog.d(this.TAG, 2, "createEncCodec format: " + localObject + ", codec name: " + ((MediaCodecInfo)localException.get(i)).getName());
            this.mCodec.a(this.mFormat, ((MediaCodecInfo)localException.get(i)).getName(), this);
            return;
          }
          i = 0;
          break label85;
          i += 1;
          break;
          j += 1;
        }
        break;
      default: 
        label671:
        label676:
        label690:
        j += 1;
      }
    }
  }
  
  public native void detachCodec();
  
  public void onError(MediaCodec paramMediaCodec, Exception paramException)
  {
    if (this.mCodersExit.get()) {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "codec exit, return onError");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.TAG, 2, "onError", paramException);
  }
  
  /* Error */
  public void onInputBufferAvailable(MediaCodec arg1, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 301	com/tencent/av/mediacodec/NativeCodec:mCodec	Lioc;
    //   10: iload_2
    //   11: invokevirtual 902	ioc:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnonnull +38 -> 56
    //   21: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +31 -> 55
    //   27: aload_0
    //   28: getfield 185	com/tencent/av/mediacodec/NativeCodec:TAG	Ljava/lang/String;
    //   31: iconst_2
    //   32: new 163	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 904
    //   42: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_2
    //   46: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: return
    //   56: iload 5
    //   58: istore_3
    //   59: aload_0
    //   60: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   63: astore_1
    //   64: iload 5
    //   66: istore_3
    //   67: aload_1
    //   68: monitorenter
    //   69: aload_0
    //   70: getfield 149	com/tencent/av/mediacodec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   73: invokevirtual 753	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   76: ifeq +78 -> 154
    //   79: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +14 -> 96
    //   85: aload_0
    //   86: getfield 185	com/tencent/av/mediacodec/NativeCodec:TAG	Ljava/lang/String;
    //   89: iconst_2
    //   90: ldc_w 906
    //   93: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload_1
    //   97: monitorexit
    //   98: aload_0
    //   99: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   102: astore_1
    //   103: aload_1
    //   104: monitorenter
    //   105: aload_0
    //   106: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   109: iconst_0
    //   110: invokeinterface 342 2 0
    //   115: checkcast 759	ioc$c
    //   118: iconst_0
    //   119: putfield 765	ioc$c:processing	Z
    //   122: aload_1
    //   123: monitorexit
    //   124: return
    //   125: astore 6
    //   127: aload_1
    //   128: monitorexit
    //   129: aload 6
    //   131: athrow
    //   132: astore 6
    //   134: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq -15 -> 122
    //   140: aload_0
    //   141: getfield 185	com/tencent/av/mediacodec/NativeCodec:TAG	Ljava/lang/String;
    //   144: iconst_2
    //   145: ldc_w 908
    //   148: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: goto -29 -> 122
    //   154: aload_0
    //   155: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   158: new 759	ioc$c
    //   161: dup
    //   162: aload 6
    //   164: iload_2
    //   165: invokespecial 911	ioc$c:<init>	(Ljava/nio/ByteBuffer;I)V
    //   168: invokeinterface 914 2 0
    //   173: pop
    //   174: aload_0
    //   175: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   178: iconst_0
    //   179: invokeinterface 342 2 0
    //   184: checkcast 759	ioc$c
    //   187: iconst_1
    //   188: putfield 765	ioc$c:processing	Z
    //   191: aload_1
    //   192: monitorexit
    //   193: iload 5
    //   195: istore_3
    //   196: invokestatic 404	com/tencent/av/mediacodec/NativeCodec:canLog	()Z
    //   199: ifeq +42 -> 241
    //   202: iload 5
    //   204: istore_3
    //   205: aload_0
    //   206: getfield 185	com/tencent/av/mediacodec/NativeCodec:TAG	Ljava/lang/String;
    //   209: iconst_2
    //   210: new 163	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 916
    //   220: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: getfield 200	com/tencent/av/mediacodec/NativeCodec:misdecoder	Z
    //   227: invokevirtual 243	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   230: ldc 247
    //   232: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: iload 5
    //   243: istore_3
    //   244: aload_0
    //   245: getfield 200	com/tencent/av/mediacodec/NativeCodec:misdecoder	Z
    //   248: ifeq +256 -> 504
    //   251: iload 5
    //   253: istore_3
    //   254: aload_0
    //   255: aload_0
    //   256: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   259: iconst_0
    //   260: invokeinterface 342 2 0
    //   265: checkcast 759	ioc$c
    //   268: getfield 760	ioc$c:buffer	Ljava/nio/ByteBuffer;
    //   271: iconst_1
    //   272: invokevirtual 708	com/tencent/av/mediacodec/NativeCodec:writeInputData	(Ljava/nio/ByteBuffer;Z)I
    //   275: istore_2
    //   276: iload_2
    //   277: ifle +122 -> 399
    //   280: iload_2
    //   281: istore_3
    //   282: invokestatic 404	com/tencent/av/mediacodec/NativeCodec:canLog	()Z
    //   285: ifeq +33 -> 318
    //   288: iload_2
    //   289: istore_3
    //   290: aload_0
    //   291: getfield 185	com/tencent/av/mediacodec/NativeCodec:TAG	Ljava/lang/String;
    //   294: iconst_2
    //   295: new 163	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 918
    //   305: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload_2
    //   309: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: iload_2
    //   319: istore_3
    //   320: aload_0
    //   321: aload_0
    //   322: getfield 118	com/tencent/av/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   325: aload_0
    //   326: getfield 133	com/tencent/av/mediacodec/NativeCodec:mFrameInverval	I
    //   329: i2l
    //   330: ladd
    //   331: putfield 118	com/tencent/av/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   334: iload_2
    //   335: istore_3
    //   336: aload_0
    //   337: getfield 151	com/tencent/av/mediacodec/NativeCodec:mDebugDelay	Z
    //   340: ifeq +28 -> 368
    //   343: iload_2
    //   344: istore_3
    //   345: aload_0
    //   346: getfield 153	com/tencent/av/mediacodec/NativeCodec:mDebugDelayMap	Ljava/util/Map;
    //   349: aload_0
    //   350: getfield 118	com/tencent/av/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   353: invokestatic 647	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   356: invokestatic 634	java/lang/System:currentTimeMillis	()J
    //   359: invokestatic 647	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   362: invokeinterface 651 3 0
    //   367: pop
    //   368: iload_2
    //   369: istore_3
    //   370: aload_0
    //   371: getfield 301	com/tencent/av/mediacodec/NativeCodec:mCodec	Lioc;
    //   374: aload_0
    //   375: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   378: iconst_0
    //   379: invokeinterface 342 2 0
    //   384: checkcast 759	ioc$c
    //   387: getfield 773	ioc$c:index	I
    //   390: iload_2
    //   391: aload_0
    //   392: getfield 118	com/tencent/av/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   395: iconst_0
    //   396: invokevirtual 394	ioc:queueInputBuffer	(IIJI)V
    //   399: aload_0
    //   400: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   403: astore_1
    //   404: aload_1
    //   405: monitorenter
    //   406: aload_0
    //   407: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   410: iconst_0
    //   411: invokeinterface 342 2 0
    //   416: checkcast 759	ioc$c
    //   419: iconst_0
    //   420: putfield 765	ioc$c:processing	Z
    //   423: iload_2
    //   424: ifle +14 -> 438
    //   427: aload_0
    //   428: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   431: iconst_0
    //   432: invokeinterface 772 2 0
    //   437: pop
    //   438: aload_1
    //   439: monitorexit
    //   440: return
    //   441: astore 6
    //   443: aload_1
    //   444: monitorexit
    //   445: aload 6
    //   447: athrow
    //   448: astore 6
    //   450: aload_1
    //   451: monitorexit
    //   452: iload 5
    //   454: istore_3
    //   455: aload 6
    //   457: athrow
    //   458: astore 6
    //   460: aload_0
    //   461: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   464: astore_1
    //   465: aload_1
    //   466: monitorenter
    //   467: aload_0
    //   468: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   471: iconst_0
    //   472: invokeinterface 342 2 0
    //   477: checkcast 759	ioc$c
    //   480: iconst_0
    //   481: putfield 765	ioc$c:processing	Z
    //   484: iload_3
    //   485: ifle +14 -> 499
    //   488: aload_0
    //   489: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   492: iconst_0
    //   493: invokeinterface 772 2 0
    //   498: pop
    //   499: aload_1
    //   500: monitorexit
    //   501: aload 6
    //   503: athrow
    //   504: iload 5
    //   506: istore_3
    //   507: aload_0
    //   508: aload_0
    //   509: getfield 142	com/tencent/av/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   512: iconst_0
    //   513: invokeinterface 342 2 0
    //   518: checkcast 759	ioc$c
    //   521: getfield 760	ioc$c:buffer	Ljava/nio/ByteBuffer;
    //   524: aload_0
    //   525: getfield 719	com/tencent/av/mediacodec/NativeCodec:mColorFormat	I
    //   528: iconst_1
    //   529: invokevirtual 723	com/tencent/av/mediacodec/NativeCodec:writeInputData2	(Ljava/nio/ByteBuffer;IZ)I
    //   532: istore_2
    //   533: goto -257 -> 276
    //   536: astore_1
    //   537: iload 4
    //   539: istore_2
    //   540: iload 5
    //   542: istore_3
    //   543: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq -270 -> 276
    //   549: iload 5
    //   551: istore_3
    //   552: aload_0
    //   553: getfield 185	com/tencent/av/mediacodec/NativeCodec:TAG	Ljava/lang/String;
    //   556: iconst_2
    //   557: ldc_w 920
    //   560: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: iload 4
    //   565: istore_2
    //   566: goto -290 -> 276
    //   569: astore_1
    //   570: iload_2
    //   571: istore_3
    //   572: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq -176 -> 399
    //   578: iload_2
    //   579: istore_3
    //   580: aload_0
    //   581: getfield 185	com/tencent/av/mediacodec/NativeCodec:TAG	Ljava/lang/String;
    //   584: iconst_2
    //   585: ldc_w 922
    //   588: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: goto -192 -> 399
    //   594: astore 6
    //   596: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   599: ifeq -161 -> 438
    //   602: aload_0
    //   603: getfield 185	com/tencent/av/mediacodec/NativeCodec:TAG	Ljava/lang/String;
    //   606: iconst_2
    //   607: ldc_w 908
    //   610: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: goto -175 -> 438
    //   616: astore 7
    //   618: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   621: ifeq -122 -> 499
    //   624: aload_0
    //   625: getfield 185	com/tencent/av/mediacodec/NativeCodec:TAG	Ljava/lang/String;
    //   628: iconst_2
    //   629: ldc_w 908
    //   632: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: goto -136 -> 499
    //   638: astore 6
    //   640: aload_1
    //   641: monitorexit
    //   642: aload 6
    //   644: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	this	NativeCodec
    //   0	645	2	paramInt	int
    //   58	522	3	i	int
    //   4	560	4	j	int
    //   1	549	5	k	int
    //   14	3	6	localByteBuffer	ByteBuffer
    //   125	5	6	localObject1	Object
    //   132	31	6	localException1	Exception
    //   441	5	6	localObject2	Object
    //   448	8	6	localObject3	Object
    //   458	44	6	localObject4	Object
    //   594	1	6	localException2	Exception
    //   638	5	6	localObject5	Object
    //   616	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   105	122	125	finally
    //   122	124	125	finally
    //   127	129	125	finally
    //   134	151	125	finally
    //   105	122	132	java/lang/Exception
    //   406	423	441	finally
    //   427	438	441	finally
    //   438	440	441	finally
    //   443	445	441	finally
    //   596	613	441	finally
    //   69	96	448	finally
    //   96	98	448	finally
    //   154	193	448	finally
    //   450	452	448	finally
    //   59	64	458	finally
    //   67	69	458	finally
    //   196	202	458	finally
    //   205	241	458	finally
    //   244	251	458	finally
    //   254	276	458	finally
    //   282	288	458	finally
    //   290	318	458	finally
    //   320	334	458	finally
    //   336	343	458	finally
    //   345	368	458	finally
    //   370	399	458	finally
    //   455	458	458	finally
    //   507	533	458	finally
    //   543	549	458	finally
    //   552	563	458	finally
    //   572	578	458	finally
    //   580	591	458	finally
    //   196	202	536	java/lang/Exception
    //   205	241	536	java/lang/Exception
    //   244	251	536	java/lang/Exception
    //   254	276	536	java/lang/Exception
    //   507	533	536	java/lang/Exception
    //   370	399	569	java/lang/Exception
    //   406	423	594	java/lang/Exception
    //   427	438	594	java/lang/Exception
    //   467	484	616	java/lang/Exception
    //   488	499	616	java/lang/Exception
    //   467	484	638	finally
    //   488	499	638	finally
    //   499	501	638	finally
    //   618	635	638	finally
    //   640	642	638	finally
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.mCodersExit.get()) {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "codec exit, return onOutputBufferAvailable");
      }
    }
    do
    {
      return;
      paramMediaCodec = this.mCodec.getOutputBuffer(paramInt);
    } while ((paramMediaCodec == null) || (paramBufferInfo == null));
    if (this.misdecoder)
    {
      MediaFormat localMediaFormat = this.mCodec.getOutputFormat(paramInt);
      if (localMediaFormat != null)
      {
        calcDelay(false, paramBufferInfo);
        setFrame(paramMediaCodec, paramBufferInfo.size, localMediaFormat);
      }
    }
    for (;;)
    {
      this.mCodec.releaseOutputBuffer(paramInt);
      return;
      if (QLog.isColorLevel())
      {
        QLog.e(this.TAG, 2, "getOutputFormat null");
        continue;
        if (paramBufferInfo.flags == 1) {}
        calcDelay(false, paramBufferInfo);
        readOutputStream(paramMediaCodec, paramBufferInfo.presentationTimeUs, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.flags);
      }
    }
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    if (this.mCodersExit.get()) {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "codec exit, return onOutputFormatChanged");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.TAG, 2, "onOutputFormatChanged");
  }
  
  public native int readOutputData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public native int readOutputDataEx(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public native int readOutputStream(ByteBuffer paramByteBuffer, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native int setAVCParams(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  void setParams_impl()
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.TAG, 2, "setParams_impl");
    }
    Bundle localBundle;
    if (this.setIFramePending)
    {
      localBundle = new Bundle();
      localBundle.putInt(ioc.ForceIFrame, 1);
      this.setIFramePending = false;
      if (this.setBitRatePending > 0) {
        localBundle.putInt("bitrate", this.setBitRatePending);
      }
      this.mCodec.setParameters(localBundle);
      this.setBitRatePending = 0;
    }
    if (this.setBitRatePending > 0)
    {
      localBundle = new Bundle();
      localBundle.putInt("bitrate", this.setBitRatePending);
      if (this.setIFramePending == true) {
        localBundle.putInt(ioc.ForceIFrame, 1);
      }
      this.mCodec.setParameters(localBundle);
      this.setBitRatePending = 0;
      this.setIFramePending = false;
    }
  }
  
  public String toString()
  {
    return this.TAG;
  }
  
  public native int writeInputData(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public native int writeInputData2(ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean);
  
  static class a
  {
    public int height;
    public int profile = 3;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.mediacodec.NativeCodec
 * JD-Core Version:    0.7.0.1
 */
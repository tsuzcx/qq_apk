package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TPCodecUtils
{
  public static final int CAP_AUDIO_AAC = 8;
  public static final int CAP_AUDIO_DD = 16;
  public static final int CAP_AUDIO_DDP = 32;
  public static final int CAP_AUDIO_DTS = 128;
  public static final int CAP_AUDIO_FLAC = 64;
  public static final int CAP_VIDEO_AVC = 1;
  public static final int CAP_VIDEO_HEVC = 2;
  public static final int CAP_VIDEO_VP9 = 4;
  public static final int PLAYER_LEVEL_1 = 1;
  public static final int PLAYER_LEVEL_11 = 11;
  public static final int PLAYER_LEVEL_16 = 16;
  public static final int PLAYER_LEVEL_21 = 21;
  public static final int PLAYER_LEVEL_26 = 26;
  public static final int PLAYER_LEVEL_28 = 28;
  public static final int PLAYER_LEVEL_33 = 33;
  public static final int PLAYER_LEVEL_6 = 6;
  private static final String TAG = "TPCodecUtils";
  private static int mAACMaxSupportedBitrate;
  private static int mAACMaxSupportedChannels;
  private static int mAACMaxSupportedSamplerate;
  private static ArrayList<String> mAMediaCodecBlackListInstance;
  private static ArrayList<String> mAMediaCodecBlackListModel;
  protected static ArrayList<String> mAMediaCodecCapList;
  private static TPCodecCapability.TPCodecMaxCapability mAVCSWMaxCapability;
  private static TPCodecCapability.TPCodecMaxCapability mAVS3WMaxCapability;
  private static HashMap<String, String> mAudioMaxCapCodecInstance;
  private static int mAvs3DeviceLevel;
  private static HashMap<String, Integer> mCodecCapBlackList;
  private static HashMap<String, Integer> mCodecCapWhiteList;
  private static Context mContext;
  private static HashMap<String, TPCodecCapability.TPHdrSupportVersionRange> mCuvaSupportVersionMap;
  private static int mDDPMaxSupportedBitrate;
  private static int mDDPMaxSupportedChannels;
  private static int mDDPMaxSupportedSamplerate;
  private static HashMap<Integer, ArrayList<String>> mDrmL1BlackList;
  private static int mFLACMaxSupportedBitrate;
  private static int mFLACMaxSupportedChannels;
  private static int mFLACMaxSupportedSamplerate;
  private static int mFhdAvs3HisiIndex;
  private static int mFhdAvs3QualcommIndex;
  private static TPCodecCapability.TPCodecMaxCapability mHEVCSWMaxCapability;
  private static int mHdHevcHisiIndex;
  private static int mHdHevcMtkIndex;
  private static int mHdHevcQualcommIndex;
  private static int mHdHevcSumsingIndex;
  private static HashMap<Integer, HashMap<String, TPCodecCapability.TPHdrSupportVersionRange>> mHdrBlackMap;
  private static HashMap<Integer, HashMap<String, TPCodecCapability.TPHdrSupportVersionRange>> mHdrWhiteMap;
  private static int mHevcDeviceLevel = -1;
  private static boolean mIsFFmpegCapGot;
  private static boolean mIsInitDone;
  private static LocalCache mLocalCache;
  private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxACodecHwCapabilityMap = new HashMap();
  private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxACodecSwCapabilityMap = new HashMap();
  private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxVCodecHwCapabilityMap;
  private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxVCodecSwCapabilityMap;
  private static int mShdAvs3QualcommIndex;
  private static int mShdHevcHisiIndex;
  private static int mShdHevcMtkIndex;
  private static int mShdHevcQualcommIndex;
  private static int mShdHevcSumsingIndex;
  private static ArrayList<String> mSupportedMediaCodec;
  private static ArrayList<String> mVMediaCodecBlackListModel;
  protected static ArrayList<String> mVMediaCodecCapList;
  private static TPCodecCapability.TPCodecMaxCapability mVP9SWMaxCapability;
  private static ArrayList<String> mWideVineBlackListModel;
  
  static
  {
    mAvs3DeviceLevel = -1;
    mAACMaxSupportedSamplerate = 96000;
    mFLACMaxSupportedSamplerate = 192000;
    mDDPMaxSupportedSamplerate = 48000;
    mAACMaxSupportedChannels = 8;
    mFLACMaxSupportedChannels = 8;
    mDDPMaxSupportedChannels = 8;
    mAACMaxSupportedBitrate = 510000;
    mFLACMaxSupportedBitrate = 21000000;
    mDDPMaxSupportedBitrate = 6144000;
    mCodecCapWhiteList = null;
    mCodecCapBlackList = null;
    mContext = null;
    mLocalCache = null;
    mVMediaCodecCapList = new ArrayList();
    mAMediaCodecCapList = new ArrayList();
    mVMediaCodecBlackListModel = new ArrayList();
    mAMediaCodecBlackListModel = new ArrayList();
    mAMediaCodecBlackListInstance = new ArrayList();
    mSupportedMediaCodec = new ArrayList();
    mHdrWhiteMap = new HashMap();
    mHdrBlackMap = new HashMap();
    mCuvaSupportVersionMap = new HashMap();
    mAudioMaxCapCodecInstance = new HashMap();
    mWideVineBlackListModel = new ArrayList();
    mDrmL1BlackList = new HashMap();
    mIsInitDone = false;
    mShdHevcQualcommIndex = 32;
    mHdHevcQualcommIndex = 20;
    mShdHevcMtkIndex = 12;
    mHdHevcMtkIndex = 8;
    mShdHevcHisiIndex = 8;
    mHdHevcHisiIndex = 3;
    mShdHevcSumsingIndex = 8;
    mHdHevcSumsingIndex = 5;
    mFhdAvs3QualcommIndex = 58;
    mShdAvs3QualcommIndex = 55;
    mFhdAvs3HisiIndex = 14;
    mCodecCapWhiteList = new HashMap();
    mCodecCapWhiteList.put("NX511J", Integer.valueOf(11));
    mCodecCapWhiteList.put("Hi3798MV100", Integer.valueOf(11));
    mCodecCapWhiteList.put("长虹智能电视", Integer.valueOf(11));
    mCodecCapWhiteList.put("Android TV on Tcl 901", Integer.valueOf(11));
    mCodecCapWhiteList.put("xt880b", Integer.valueOf(11));
    TPNativeLog.printLog(2, "TPCodecUtils", "white list init");
    mSupportedMediaCodec.add("video/avc");
    mSupportedMediaCodec.add("video/hevc");
    mSupportedMediaCodec.add("video/x-vnd.on2.vp9");
    mSupportedMediaCodec.add("video/av01");
    mSupportedMediaCodec.add("audio/mp4a-latm");
    mSupportedMediaCodec.add("audio/ac3");
    mSupportedMediaCodec.add("audio/eac3");
    mSupportedMediaCodec.add("audio/eac3-joc");
    mSupportedMediaCodec.add("audio/flac");
    mSupportedMediaCodec.add("audio/vnd.dts");
    mAMediaCodecBlackListInstance.add("OMX.qti.audio.decoder.flac");
    mVMediaCodecBlackListModel.add("SM-J7008");
    mVMediaCodecBlackListModel.add("SM-J5008");
    mVMediaCodecBlackListModel.add("TCL i806");
    mVMediaCodecBlackListModel.add("NX511J");
    mVMediaCodecBlackListModel.add("vivo Y11i T");
    mVMediaCodecBlackListModel.add("长虹智能电视");
    mVMediaCodecBlackListModel.add("MI 1S");
    mVMediaCodecBlackListModel.add("SP9832A");
    mVMediaCodecBlackListModel.add("SP9830A");
    mVMediaCodecBlackListModel.add("VOTO GT17");
    mVMediaCodecBlackListModel.add("EVA-AL10");
    mCuvaSupportVersionMap.put("TAS-AL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("TAS-TL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("TAS-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("LIO-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("LIO-AN00P", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("LIO-TL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("LIO-AL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("ANA-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("ANA-TN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("ELS-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("ELS-TN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("ELS-AN10", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100166, 99, 3));
    mCuvaSupportVersionMap.put("MRX-AL09", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-AL19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-W09", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-W19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-AN19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-W29", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-W39", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("OCE-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
    mCuvaSupportVersionMap.put("NOH-NX9", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
    mCuvaSupportVersionMap.put("NOH-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
    mCuvaSupportVersionMap.put("NOP-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
    mWideVineBlackListModel.add("RVL-AL09");
    mWideVineBlackListModel.add("CLT-L29");
    mWideVineBlackListModel.add("ASUS_Z00AD");
    mWideVineBlackListModel.add(Build.MODEL);
    mDrmL1BlackList.put(Integer.valueOf(0), mWideVineBlackListModel);
    mIsFFmpegCapGot = false;
    mAVCSWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    mHEVCSWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    mVP9SWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    mAVS3WMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    mMaxVCodecHwCapabilityMap = new HashMap();
    mMaxVCodecSwCapabilityMap = new HashMap();
  }
  
  public static boolean addDRMLevel1Blacklist(int paramInt)
  {
    if (mDrmL1BlackList.containsKey(Integer.valueOf(paramInt)))
    {
      ArrayList localArrayList = (ArrayList)mDrmL1BlackList.get(Integer.valueOf(paramInt));
      if (!localArrayList.contains(Build.MODEL)) {
        localArrayList.add(Build.MODEL);
      }
      mDrmL1BlackList.remove(Integer.valueOf(paramInt));
      mDrmL1BlackList.put(Integer.valueOf(paramInt), localArrayList);
    }
    return true;
  }
  
  public static boolean addHDRBlackList(int paramInt, String paramString, TPCodecCapability.TPHdrSupportVersionRange paramTPHdrSupportVersionRange)
  {
    if (paramTPHdrSupportVersionRange == null) {
      return false;
    }
    HashMap localHashMap;
    if (mHdrBlackMap.containsKey(Integer.valueOf(paramInt)))
    {
      localHashMap = (HashMap)mHdrBlackMap.get(Integer.valueOf(paramInt));
      mHdrBlackMap.remove(Integer.valueOf(paramInt));
      if (!localHashMap.containsKey(paramString)) {
        localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      }
      localHashMap.remove(paramString);
      localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      mHdrBlackMap.put(Integer.valueOf(paramInt), localHashMap);
    }
    for (;;)
    {
      return true;
      localHashMap = new HashMap();
      localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      mHdrBlackMap.put(Integer.valueOf(paramInt), localHashMap);
    }
  }
  
  public static boolean addHDRWhiteList(int paramInt, String paramString, TPCodecCapability.TPHdrSupportVersionRange paramTPHdrSupportVersionRange)
  {
    if (paramTPHdrSupportVersionRange == null) {
      return false;
    }
    HashMap localHashMap;
    if (mHdrWhiteMap.containsKey(Integer.valueOf(paramInt)))
    {
      localHashMap = (HashMap)mHdrWhiteMap.get(Integer.valueOf(paramInt));
      mHdrWhiteMap.remove(Integer.valueOf(paramInt));
      if (!localHashMap.containsKey(paramString)) {
        localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      }
      localHashMap.remove(paramString);
      localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      mHdrWhiteMap.put(Integer.valueOf(paramInt), localHashMap);
    }
    for (;;)
    {
      return true;
      localHashMap = new HashMap();
      localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      mHdrWhiteMap.put(Integer.valueOf(paramInt), localHashMap);
    }
  }
  
  /* Error */
  public static boolean checkCuvaSupportByVersion(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_1
    //   4: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +706 -> 713
    //   10: aload_1
    //   11: ldc_w 387
    //   14: invokevirtual 393	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   17: astore 10
    //   19: aload 10
    //   21: arraylength
    //   22: iconst_4
    //   23: if_icmpne +690 -> 713
    //   26: aload 10
    //   28: iconst_0
    //   29: aaload
    //   30: ldc_w 395
    //   33: invokevirtual 393	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   36: astore 11
    //   38: aload 11
    //   40: arraylength
    //   41: iconst_2
    //   42: if_icmpne +18 -> 60
    //   45: aload 11
    //   47: iconst_1
    //   48: aaload
    //   49: ifnull +11 -> 60
    //   52: aload 10
    //   54: iconst_0
    //   55: aload 11
    //   57: iconst_1
    //   58: aaload
    //   59: aastore
    //   60: aload 10
    //   62: iconst_3
    //   63: aaload
    //   64: ldc_w 397
    //   67: invokevirtual 393	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore 11
    //   72: aload 11
    //   74: arraylength
    //   75: iconst_2
    //   76: if_icmpne +18 -> 94
    //   79: aload 11
    //   81: iconst_0
    //   82: aaload
    //   83: ifnull +11 -> 94
    //   86: aload 10
    //   88: iconst_3
    //   89: aload 11
    //   91: iconst_0
    //   92: aaload
    //   93: aastore
    //   94: iconst_0
    //   95: istore_3
    //   96: iload_3
    //   97: iconst_4
    //   98: if_icmpge +621 -> 719
    //   101: aload 10
    //   103: iload_3
    //   104: aaload
    //   105: ifnull +34 -> 139
    //   108: aload 10
    //   110: iload_3
    //   111: aaload
    //   112: invokevirtual 401	java/lang/String:length	()I
    //   115: iconst_4
    //   116: newarray int
    //   118: dup
    //   119: iconst_0
    //   120: iconst_2
    //   121: iastore
    //   122: dup
    //   123: iconst_1
    //   124: iconst_1
    //   125: iastore
    //   126: dup
    //   127: iconst_2
    //   128: iconst_1
    //   129: iastore
    //   130: dup
    //   131: iconst_3
    //   132: iconst_3
    //   133: iastore
    //   134: iload_3
    //   135: iaload
    //   136: if_icmpeq +218 -> 354
    //   139: iconst_0
    //   140: istore_3
    //   141: iload_3
    //   142: ifeq +571 -> 713
    //   145: aload_1
    //   146: ldc_w 403
    //   149: invokevirtual 407	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   152: istore 4
    //   154: iload 4
    //   156: iconst_m1
    //   157: if_icmpne +204 -> 361
    //   160: iconst_0
    //   161: istore_3
    //   162: aload_1
    //   163: ldc_w 403
    //   166: iload 4
    //   168: iconst_1
    //   169: iadd
    //   170: invokevirtual 410	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   173: istore 5
    //   175: iload 5
    //   177: iconst_m1
    //   178: if_icmpne +197 -> 375
    //   181: iconst_0
    //   182: istore 4
    //   184: aload_1
    //   185: ldc_w 403
    //   188: iload 5
    //   190: iconst_1
    //   191: iadd
    //   192: invokevirtual 410	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   195: istore 6
    //   197: iload 6
    //   199: iconst_m1
    //   200: if_icmpne +190 -> 390
    //   203: iconst_0
    //   204: istore 5
    //   206: iload 6
    //   208: iconst_m1
    //   209: if_icmpne +196 -> 405
    //   212: iconst_0
    //   213: istore 6
    //   215: iload 6
    //   217: iload 5
    //   219: sipush 1000
    //   222: imul
    //   223: iload 4
    //   225: sipush 10000
    //   228: imul
    //   229: iload_3
    //   230: ldc_w 411
    //   233: imul
    //   234: iadd
    //   235: iadd
    //   236: iadd
    //   237: istore 4
    //   239: aload_2
    //   240: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifne +465 -> 708
    //   246: aload_2
    //   247: ldc_w 413
    //   250: invokevirtual 393	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   253: astore_1
    //   254: aload_1
    //   255: arraylength
    //   256: iconst_2
    //   257: if_icmpne +451 -> 708
    //   260: aload_1
    //   261: iconst_1
    //   262: aaload
    //   263: ifnull +445 -> 708
    //   266: aload_1
    //   267: iconst_1
    //   268: aaload
    //   269: invokevirtual 401	java/lang/String:length	()I
    //   272: iconst_3
    //   273: if_icmpne +435 -> 708
    //   276: aload_2
    //   277: ldc_w 413
    //   280: invokevirtual 407	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   283: istore_3
    //   284: iload_3
    //   285: iconst_m1
    //   286: if_icmpne +190 -> 476
    //   289: iconst_0
    //   290: istore_3
    //   291: aload_0
    //   292: iload 4
    //   294: iload_3
    //   295: invokestatic 417	com/tencent/thumbplayer/core/common/TPCodecUtils:isInCuvaHDRWhiteList	(Ljava/lang/String;II)Z
    //   298: ifeq +228 -> 526
    //   301: iconst_2
    //   302: ldc 39
    //   304: new 419	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 422
    //   314: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 428
    //   324: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload 4
    //   329: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 433
    //   335: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_2
    //   339: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   348: iconst_1
    //   349: istore 8
    //   351: iload 8
    //   353: ireturn
    //   354: iload_3
    //   355: iconst_1
    //   356: iadd
    //   357: istore_3
    //   358: goto -262 -> 96
    //   361: aload_1
    //   362: iload 4
    //   364: iconst_2
    //   365: isub
    //   366: iload 4
    //   368: invokestatic 441	com/tencent/thumbplayer/core/common/TPCodecUtils:getValueFromSubstring	(Ljava/lang/String;II)I
    //   371: istore_3
    //   372: goto -210 -> 162
    //   375: aload_1
    //   376: iload 5
    //   378: iconst_1
    //   379: isub
    //   380: iload 5
    //   382: invokestatic 441	com/tencent/thumbplayer/core/common/TPCodecUtils:getValueFromSubstring	(Ljava/lang/String;II)I
    //   385: istore 4
    //   387: goto -203 -> 184
    //   390: aload_1
    //   391: iload 6
    //   393: iconst_1
    //   394: isub
    //   395: iload 6
    //   397: invokestatic 441	com/tencent/thumbplayer/core/common/TPCodecUtils:getValueFromSubstring	(Ljava/lang/String;II)I
    //   400: istore 5
    //   402: goto -196 -> 206
    //   405: aload_1
    //   406: iload 6
    //   408: iconst_1
    //   409: iadd
    //   410: iload 6
    //   412: iconst_4
    //   413: iadd
    //   414: invokestatic 441	com/tencent/thumbplayer/core/common/TPCodecUtils:getValueFromSubstring	(Ljava/lang/String;II)I
    //   417: istore 6
    //   419: goto -204 -> 215
    //   422: astore_1
    //   423: iconst_0
    //   424: istore 4
    //   426: iconst_0
    //   427: istore 5
    //   429: iconst_0
    //   430: istore_3
    //   431: iconst_4
    //   432: ldc 39
    //   434: new 419	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   441: ldc_w 443
    //   444: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_1
    //   448: invokevirtual 446	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   451: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   460: iload 5
    //   462: istore 7
    //   464: iconst_0
    //   465: istore 6
    //   467: iload_3
    //   468: istore 5
    //   470: iload 7
    //   472: istore_3
    //   473: goto -258 -> 215
    //   476: aload_2
    //   477: iload_3
    //   478: iconst_5
    //   479: iadd
    //   480: iload_3
    //   481: bipush 7
    //   483: iadd
    //   484: invokestatic 441	com/tencent/thumbplayer/core/common/TPCodecUtils:getValueFromSubstring	(Ljava/lang/String;II)I
    //   487: istore_3
    //   488: goto -197 -> 291
    //   491: astore_1
    //   492: iconst_4
    //   493: ldc 39
    //   495: new 419	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 448
    //   505: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_1
    //   509: invokevirtual 446	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   512: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   521: iconst_0
    //   522: istore_3
    //   523: goto -232 -> 291
    //   526: aload_0
    //   527: iload 4
    //   529: iload_3
    //   530: invokestatic 451	com/tencent/thumbplayer/core/common/TPCodecUtils:isInCuvaHDRBlackList	(Ljava/lang/String;II)Z
    //   533: ifeq +52 -> 585
    //   536: iconst_2
    //   537: ldc 39
    //   539: new 419	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 453
    //   549: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_0
    //   553: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 428
    //   559: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload 4
    //   564: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: ldc_w 433
    //   570: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload_2
    //   574: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   583: iconst_0
    //   584: ireturn
    //   585: iload 9
    //   587: istore 8
    //   589: getstatic 164	com/tencent/thumbplayer/core/common/TPCodecUtils:mCuvaSupportVersionMap	Ljava/util/HashMap;
    //   592: aload_0
    //   593: invokevirtual 362	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   596: ifeq -245 -> 351
    //   599: getstatic 164	com/tencent/thumbplayer/core/common/TPCodecUtils:mCuvaSupportVersionMap	Ljava/util/HashMap;
    //   602: aload_0
    //   603: invokevirtual 366	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   606: checkcast 270	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange
    //   609: astore_0
    //   610: iload 9
    //   612: istore 8
    //   614: iload 4
    //   616: aload_0
    //   617: getfield 456	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange:upperboundSystemVersion	I
    //   620: if_icmpgt -269 -> 351
    //   623: iload 4
    //   625: aload_0
    //   626: getfield 459	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange:lowerboundSystemVersion	I
    //   629: if_icmple +5 -> 634
    //   632: iconst_1
    //   633: ireturn
    //   634: iload 9
    //   636: istore 8
    //   638: iload 4
    //   640: aload_0
    //   641: getfield 459	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange:lowerboundSystemVersion	I
    //   644: if_icmpne -293 -> 351
    //   647: iload 9
    //   649: istore 8
    //   651: iload_3
    //   652: aload_0
    //   653: getfield 462	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange:upperboundPatchVersion	I
    //   656: if_icmpgt -305 -> 351
    //   659: iload 9
    //   661: istore 8
    //   663: iload_3
    //   664: aload_0
    //   665: getfield 465	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange:lowerboundPatchVersion	I
    //   668: if_icmplt -317 -> 351
    //   671: iconst_1
    //   672: ireturn
    //   673: astore_1
    //   674: iconst_0
    //   675: istore 4
    //   677: iload_3
    //   678: istore 5
    //   680: iconst_0
    //   681: istore_3
    //   682: goto -251 -> 431
    //   685: astore_1
    //   686: iload_3
    //   687: istore 5
    //   689: iconst_0
    //   690: istore_3
    //   691: goto -260 -> 431
    //   694: astore_1
    //   695: iload_3
    //   696: istore 6
    //   698: iload 5
    //   700: istore_3
    //   701: iload 6
    //   703: istore 5
    //   705: goto -274 -> 431
    //   708: iconst_0
    //   709: istore_3
    //   710: goto -419 -> 291
    //   713: iconst_0
    //   714: istore 4
    //   716: goto -477 -> 239
    //   719: iconst_1
    //   720: istore_3
    //   721: goto -580 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	724	0	paramString1	String
    //   0	724	1	paramString2	String
    //   0	724	2	paramString3	String
    //   95	626	3	i	int
    //   152	563	4	j	int
    //   173	531	5	k	int
    //   195	507	6	m	int
    //   462	9	7	n	int
    //   349	313	8	bool1	boolean
    //   1	659	9	bool2	boolean
    //   17	92	10	arrayOfString1	String[]
    //   36	54	11	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   145	154	422	java/lang/NumberFormatException
    //   361	372	422	java/lang/NumberFormatException
    //   276	284	491	java/lang/NumberFormatException
    //   476	488	491	java/lang/NumberFormatException
    //   162	175	673	java/lang/NumberFormatException
    //   375	387	673	java/lang/NumberFormatException
    //   184	197	685	java/lang/NumberFormatException
    //   390	402	685	java/lang/NumberFormatException
    //   405	419	694	java/lang/NumberFormatException
  }
  
  public static int convertDolbyVisionToOmxLevel(int paramInt)
  {
    int i = 1 << paramInt;
    if ((i >= 1) && (i <= 256))
    {
      TPNativeLog.printLog(2, "TPCodecUtils", "convertDolbyVisionToOmxLevel dolbyVisionLevel:" + paramInt + " omxLevel:" + i);
      return i;
    }
    TPNativeLog.printLog(2, "TPCodecUtils", "convertDolbyVisionToOmxLevel Unsupported level" + paramInt);
    return paramInt;
  }
  
  public static int convertDolbyVisionToOmxProfile(int paramInt)
  {
    int i = 1 << paramInt;
    if ((paramInt >= 1) && (paramInt <= 512))
    {
      TPNativeLog.printLog(2, "TPCodecUtils", "convertDolbyVisionToOmxProfile dolbyVisionProfile:" + paramInt + " omxProfile:" + i);
      return i;
    }
    TPNativeLog.printLog(2, "TPCodecUtils", "convertDolbyVisionToOmxProfile Unsupported profile" + paramInt);
    return paramInt;
  }
  
  /* Error */
  public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getACodecSWMaxCapabilityMap()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_2
    //   4: ldc 39
    //   6: ldc_w 486
    //   9: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   12: getstatic 353	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxACodecSwCapabilityMap	Ljava/util/HashMap;
    //   15: invokevirtual 489	java/util/HashMap:isEmpty	()Z
    //   18: ifne +12 -> 30
    //   21: getstatic 353	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxACodecSwCapabilityMap	Ljava/util/HashMap;
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: new 336	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability
    //   33: dup
    //   34: iconst_0
    //   35: iconst_0
    //   36: getstatic 109	com/tencent/thumbplayer/core/common/TPCodecUtils:mAACMaxSupportedSamplerate	I
    //   39: getstatic 124	com/tencent/thumbplayer/core/common/TPCodecUtils:mAACMaxSupportedBitrate	I
    //   42: getstatic 117	com/tencent/thumbplayer/core/common/TPCodecUtils:mAACMaxSupportedChannels	I
    //   45: invokespecial 492	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:<init>	(IIIII)V
    //   48: astore_0
    //   49: new 336	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability
    //   52: dup
    //   53: iconst_0
    //   54: iconst_0
    //   55: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mFLACMaxSupportedSamplerate	I
    //   58: getstatic 127	com/tencent/thumbplayer/core/common/TPCodecUtils:mFLACMaxSupportedBitrate	I
    //   61: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mFLACMaxSupportedChannels	I
    //   64: invokespecial 492	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:<init>	(IIIII)V
    //   67: astore_1
    //   68: new 336	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability
    //   71: dup
    //   72: iconst_0
    //   73: iconst_0
    //   74: getstatic 115	com/tencent/thumbplayer/core/common/TPCodecUtils:mDDPMaxSupportedSamplerate	I
    //   77: getstatic 130	com/tencent/thumbplayer/core/common/TPCodecUtils:mDDPMaxSupportedBitrate	I
    //   80: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mDDPMaxSupportedChannels	I
    //   83: invokespecial 492	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:<init>	(IIIII)V
    //   86: astore_2
    //   87: new 336	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability
    //   90: dup
    //   91: iconst_0
    //   92: iconst_0
    //   93: getstatic 115	com/tencent/thumbplayer/core/common/TPCodecUtils:mDDPMaxSupportedSamplerate	I
    //   96: getstatic 130	com/tencent/thumbplayer/core/common/TPCodecUtils:mDDPMaxSupportedBitrate	I
    //   99: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mDDPMaxSupportedChannels	I
    //   102: invokespecial 492	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:<init>	(IIIII)V
    //   105: astore_3
    //   106: getstatic 353	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxACodecSwCapabilityMap	Ljava/util/HashMap;
    //   109: sipush 5002
    //   112: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aload_0
    //   116: invokevirtual 206	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: getstatic 353	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxACodecSwCapabilityMap	Ljava/util/HashMap;
    //   123: sipush 5012
    //   126: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aload_1
    //   130: invokevirtual 206	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: pop
    //   134: getstatic 353	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxACodecSwCapabilityMap	Ljava/util/HashMap;
    //   137: sipush 5003
    //   140: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: aload_2
    //   144: invokevirtual 206	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: getstatic 353	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxACodecSwCapabilityMap	Ljava/util/HashMap;
    //   151: sipush 5040
    //   154: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aload_3
    //   158: invokevirtual 206	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: iconst_2
    //   163: ldc_w 494
    //   166: invokestatic 497	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   169: getstatic 353	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxACodecSwCapabilityMap	Ljava/util/HashMap;
    //   172: astore_0
    //   173: goto -148 -> 25
    //   176: astore_0
    //   177: iconst_4
    //   178: ldc 39
    //   180: ldc_w 499
    //   183: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   186: aconst_null
    //   187: astore_0
    //   188: goto -163 -> 25
    //   191: astore_0
    //   192: ldc 2
    //   194: monitorexit
    //   195: aload_0
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	149	0	localObject1	Object
    //   176	1	0	localException	Exception
    //   187	1	0	localObject2	Object
    //   191	5	0	localObject3	Object
    //   67	63	1	localTPCodecMaxCapability1	TPCodecCapability.TPCodecMaxCapability
    //   86	58	2	localTPCodecMaxCapability2	TPCodecCapability.TPCodecMaxCapability
    //   105	53	3	localTPCodecMaxCapability3	TPCodecCapability.TPCodecMaxCapability
    // Exception table:
    //   from	to	target	type
    //   30	173	176	java/lang/Exception
    //   3	25	191	finally
    //   30	173	191	finally
    //   177	186	191	finally
  }
  
  public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getAMediaCodecMaxCapabilityMap()
  {
    label454:
    for (;;)
    {
      try
      {
        TPNativeLog.printLog(2, "TPCodecUtils", "getAMediaCodecMaxCapabilityMap func in");
        Object localObject1;
        if (!mMaxACodecHwCapabilityMap.isEmpty())
        {
          TPNativeLog.printLog(2, "TPCodecUtils", "return memory stored audio max cap map");
          localObject1 = mMaxACodecHwCapabilityMap;
          return localObject1;
        }
        int i;
        try
        {
          localObject1 = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            Object localObject3 = localObject1[i];
            String str = localObject3.getDecoderMimeType();
            if ((!localObject3.isAudio()) || (!isSupportedMediaCodec(str)) || (isInMediaCodecBlackList(str)) || (isAMediaCodecBlackListInstance(localObject3.getDecoderName()))) {
              break label454;
            }
            TPNativeLog.printLog(2, "TPCodecUtils", "Audio MimeType: " + str + " codecName: " + localObject3.getDecoderName());
            Object localObject4 = localObject3.getMaxProfileLevel();
            localObject4 = new TPCodecCapability.TPCodecMaxCapability(((TPMediaDecoderInfo.DecoderProfileLevel)localObject4).profile, ((TPMediaDecoderInfo.DecoderProfileLevel)localObject4).level, localObject3.getMaxAudioSampleRate(), localObject3.getMaxAudioBitRate(), localObject3.getMaxAudioChannels());
            if (mMaxACodecHwCapabilityMap.containsKey(Integer.valueOf(getSupportedCodecId(str))))
            {
              if ((localObject3.getMaxAudioSampleRate() > ((TPCodecCapability.TPCodecMaxCapability)mMaxACodecHwCapabilityMap.get(Integer.valueOf(getSupportedCodecId(str)))).maxSampleRate) || (TextUtils.equals(str, "audio/eac3-joc")))
              {
                TPNativeLog.printLog(2, "TPCodecUtils", "audio codecName: " + localObject3.getDecoderName() + " maxSamplerate: " + localObject3.getMaxAudioSampleRate() + " maxChannels: " + localObject3.getMaxAudioChannels());
                replace(Integer.valueOf(getSupportedCodecId(str)), localObject4, mMaxACodecHwCapabilityMap);
                replace(str, localObject3.getDecoderName(), mAudioMaxCapCodecInstance);
              }
            }
            else
            {
              TPNativeLog.printLog(2, "TPCodecUtils", "audio codecName: " + localObject3.getDecoderName() + " maxSamplerate: " + localObject3.getMaxAudioSampleRate() + " maxChannels: " + localObject3.getMaxAudioChannels());
              replace(Integer.valueOf(getSupportedCodecId(str)), localObject4, mMaxACodecHwCapabilityMap);
              replace(str, localObject3.getDecoderName(), mAudioMaxCapCodecInstance);
              mAMediaCodecCapList.add(str);
            }
          }
        }
        catch (Exception localException)
        {
          TPNativeLog.printLog(4, "TPCodecUtils", "getAMediaCodecMaxCapabilityMap failed:" + localException.getMessage());
          HashMap localHashMap = mMaxACodecHwCapabilityMap;
        }
        continue;
        i += 1;
      }
      finally {}
    }
  }
  
  public static boolean getAudioMediaCodecPassThroughCap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 5004) {
      return false;
    }
    paramInt1 = 1;
    if (paramInt2 == 20) {}
    for (paramInt1 = 7;; paramInt1 = 8) {
      do
      {
        return TPAudioPassThroughPluginDetector.isAudioPassThroughSupport(paramInt1, paramInt3);
      } while ((paramInt2 != 50) && (paramInt2 != 60));
    }
  }
  
  public static int getAvs3SWDecodeLevel()
  {
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    TPNativeLog.printLog(2, "TPCodecUtils", "[getAvs3SWDecodeLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + j + ", hardware=" + str);
    if (-1 != mAvs3DeviceLevel) {
      return mAvs3DeviceLevel;
    }
    mAvs3DeviceLevel = 0;
    if (-1 == i) {
      mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
    }
    for (;;)
    {
      return mAvs3DeviceLevel;
      switch (i)
      {
      default: 
        break;
      case 0: 
        if (j >= mFhdAvs3QualcommIndex) {
          mAvs3DeviceLevel = 26;
        } else if (j >= mShdAvs3QualcommIndex) {
          mAvs3DeviceLevel = 21;
        } else {
          mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      case 1: 
        mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        break;
      case 2: 
        if (j >= mFhdAvs3HisiIndex) {
          mAvs3DeviceLevel = 26;
        } else {
          mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      case 3: 
        mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
      }
    }
  }
  
  private static int getDecodeLevelByCoresAndFreq()
  {
    if (TPSystemInfo.getNumCores() >= 8) {
      if (TPSystemInfo.getMaxCpuFreq() / 1000L < 1200L) {}
    }
    do
    {
      do
      {
        return 21;
        return 16;
        if (TPSystemInfo.getNumCores() < 6) {
          break;
        }
      } while (TPSystemInfo.getMaxCpuFreq() / 1000L >= 1400L);
      return 16;
      if (TPSystemInfo.getNumCores() < 4) {
        break;
      }
    } while (TPSystemInfo.getMaxCpuFreq() / 1000L >= 1600L);
    return 16;
    return 6;
  }
  
  /* Error */
  public static void getDecoderMaxCapabilityMapAsync()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 172	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsInitDone	Z
    //   6: ifeq +16 -> 22
    //   9: iconst_2
    //   10: ldc 39
    //   12: ldc_w 635
    //   15: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: iconst_2
    //   23: ldc 39
    //   25: ldc_w 637
    //   28: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   31: new 639	java/lang/Thread
    //   34: dup
    //   35: new 641	com/tencent/thumbplayer/core/common/TPCodecUtils$1
    //   38: dup
    //   39: invokespecial 642	com/tencent/thumbplayer/core/common/TPCodecUtils$1:<init>	()V
    //   42: invokespecial 645	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   45: astore_0
    //   46: aload_0
    //   47: ldc_w 647
    //   50: invokevirtual 651	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   53: aload_0
    //   54: invokevirtual 654	java/lang/Thread:start	()V
    //   57: goto -39 -> 18
    //   60: astore_0
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	9	0	localThread	java.lang.Thread
    //   60	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	18	60	finally
    //   22	57	60	finally
  }
  
  public static String getDecoderName(String paramString, boolean paramBoolean)
  {
    if (paramString.contains("audio"))
    {
      if ((TextUtils.equals(paramString, "audio/eac3")) && (mAudioMaxCapCodecInstance.containsKey("audio/eac3-joc"))) {
        return (String)mAudioMaxCapCodecInstance.get("audio/eac3-joc");
      }
      if (mAudioMaxCapCodecInstance.containsKey(paramString)) {
        return (String)mAudioMaxCapCodecInstance.get(paramString);
      }
    }
    else
    {
      TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
      int j = arrayOfTPMediaDecoderInfo.length;
      int i = 0;
      if (i < j)
      {
        TPMediaDecoderInfo localTPMediaDecoderInfo = arrayOfTPMediaDecoderInfo[i];
        if (!TextUtils.equals(paramString, localTPMediaDecoderInfo.getDecoderMimeType())) {}
        while (localTPMediaDecoderInfo.isSecureDecoder() != paramBoolean)
        {
          i += 1;
          break;
        }
        TPNativeLog.printLog(2, "TPCodecUtils", "getDecoderName:" + localTPMediaDecoderInfo.getDecoderName());
        return localTPMediaDecoderInfo.getDecoderName();
      }
    }
    return null;
  }
  
  public static String getDisplayVersion()
  {
    if (!TextUtils.equals(Build.BRAND, "HUAWEI")) {
      return null;
    }
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      localObject1 = (String)((Class)localObject1).getDeclaredMethod("get", new Class[] { String.class }).invoke(localObject1, new Object[] { "ro.build.display.id" });
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get huawei display version failed:" + localException.getMessage());
        Object localObject2 = null;
      }
    }
  }
  
  public static String getDolbyVisionDecoderName(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 21) || (!TextUtils.equals("video/dolby-vision", paramString))) {
      return null;
    }
    int j = convertDolbyVisionToOmxProfile(paramInt1);
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
    int k = arrayOfTPMediaDecoderInfo.length;
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      TPMediaDecoderInfo localTPMediaDecoderInfo = arrayOfTPMediaDecoderInfo[paramInt2];
      TPMediaDecoderInfo.DecoderProfileLevel[] arrayOfDecoderProfileLevel = localTPMediaDecoderInfo.getProfileLevels();
      if (!TextUtils.equals(localTPMediaDecoderInfo.getDecoderMimeType(), paramString))
      {
        paramInt2 += 1;
      }
      else
      {
        int m = arrayOfDecoderProfileLevel.length;
        int i = 0;
        label87:
        TPMediaDecoderInfo.DecoderProfileLevel localDecoderProfileLevel;
        if (i < m)
        {
          localDecoderProfileLevel = arrayOfDecoderProfileLevel[i];
          if (localDecoderProfileLevel.profile == j) {
            break label120;
          }
        }
        label120:
        do
        {
          i += 1;
          break label87;
          break;
          TPNativeLog.printLog(2, "TPCodecUtils", "getDolbyVisionDecoderName  profile:" + localDecoderProfileLevel.profile + " dvProfile:" + paramInt1 + " bSecure:" + paramBoolean + " name:" + localTPMediaDecoderInfo.getDecoderName());
        } while (localTPMediaDecoderInfo.isSecureDecoder() != paramBoolean);
        return localTPMediaDecoderInfo.getDecoderName();
      }
    }
    return null;
  }
  
  public static int getHevcSWDecodeLevel()
  {
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    TPNativeLog.printLog(2, "TPCodecUtils", "[getHevcSWDecodeLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + j + ", hardware=" + str);
    if (-1 != mHevcDeviceLevel) {
      return mHevcDeviceLevel;
    }
    mHevcDeviceLevel = 0;
    if (-1 == i) {
      mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
    }
    for (;;)
    {
      return mHevcDeviceLevel;
      switch (i)
      {
      default: 
        break;
      case 0: 
        if (j >= mShdHevcQualcommIndex) {
          mHevcDeviceLevel = 21;
        } else if (j >= mHdHevcQualcommIndex) {
          mHevcDeviceLevel = 16;
        } else {
          mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      case 1: 
        if (j >= mShdHevcMtkIndex) {
          mHevcDeviceLevel = 21;
        } else if (j >= mHdHevcMtkIndex) {
          mHevcDeviceLevel = 16;
        } else {
          mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      case 2: 
        if (j >= mShdHevcHisiIndex) {
          mHevcDeviceLevel = 21;
        } else if (j >= mHdHevcHisiIndex) {
          mHevcDeviceLevel = 16;
        } else {
          mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      case 3: 
        if (j >= mShdHevcSumsingIndex) {
          mHevcDeviceLevel = 21;
        } else if (j >= mHdHevcSumsingIndex) {
          mHevcDeviceLevel = 16;
        } else {
          mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      }
    }
  }
  
  public static int getMaxLumaSample(String paramString, int paramInt)
  {
    if (TextUtils.equals(paramString, "video/avc")) {
      return TPMediaCodecProfileLevel.getAVCMaxLumaSample(paramInt);
    }
    if (TextUtils.equals(paramString, "video/hevc")) {
      return TPMediaCodecProfileLevel.getHEVCMaxLumaSample(paramInt);
    }
    if (TextUtils.equals(paramString, "video/x-vnd.on2.vp9")) {
      return TPMediaCodecProfileLevel.getVP9MaxLumaSample(paramInt);
    }
    if (TextUtils.equals(paramString, "video/av01")) {
      return TPMediaCodecProfileLevel.getAV1MaxLumaSample(paramInt);
    }
    return 0;
  }
  
  public static int getMaxSupportedFrameRatesFor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      int i;
      try
      {
        i = Build.VERSION.SDK_INT;
        if ((i < 21) || (paramInt1 == 101) || (paramInt1 == -1))
        {
          paramInt1 = 30;
          return paramInt1;
        }
        String str = getSupportedHWMimeType(paramInt2);
        if (str.isEmpty())
        {
          paramInt1 = 30;
          continue;
        }
        Integer localInteger2 = Integer.valueOf(30);
        Integer localInteger1 = localInteger2;
        try
        {
          TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
          localInteger1 = localInteger2;
          paramInt2 = arrayOfTPMediaDecoderInfo.length;
          paramInt1 = 0;
          localInteger1 = localInteger2;
          if (paramInt1 >= paramInt2) {
            continue;
          }
          TPMediaDecoderInfo localTPMediaDecoderInfo = arrayOfTPMediaDecoderInfo[paramInt1];
          localInteger1 = localInteger2;
          if (!str.equals(localTPMediaDecoderInfo.getDecoderMimeType())) {
            break label461;
          }
          localInteger1 = localInteger2;
          paramInt1 = localTPMediaDecoderInfo.getDecoderMaxWidth();
          localInteger1 = localInteger2;
          paramInt2 = localTPMediaDecoderInfo.getDecoderMaxHeight();
          localInteger1 = localInteger2;
          i = localTPMediaDecoderInfo.getDecoderLumaWidth();
          localInteger1 = localInteger2;
          j = localTPMediaDecoderInfo.getDecoderLumaHeight();
          localInteger1 = localInteger2;
          k = localTPMediaDecoderInfo.getDecoderMaxFrameRateForMaxLuma();
          localInteger1 = localInteger2;
          m = localTPMediaDecoderInfo.getDecoderMaxFrameRate();
          if ((paramInt3 <= paramInt4) || ((paramInt3 <= paramInt1) && (paramInt4 <= j))) {
            break label442;
          }
          localInteger1 = localInteger2;
          TPNativeLog.printLog(4, "TPCodecUtils", "width:" + paramInt3 + " height:" + paramInt4 + " do not support! maxWidth:" + paramInt1 + " maxHeight:" + paramInt2);
          paramInt1 = 0;
        }
        catch (Exception localException)
        {
          int j;
          int k;
          int m;
          TPNativeLog.printLog(4, "TPCodecUtils", "getMaxSupportedFrameRatesFor failed:" + localException.getMessage());
          continue;
        }
        localInteger1 = localInteger2;
        localInteger2 = Integer.valueOf(Math.min(m, Math.max(1, (int)(paramInt1 * j * 1L / Math.max(paramInt3 * paramInt4 * 1L, 1L)) * k)));
        localInteger1 = localInteger2;
        TPNativeLog.printLog(2, "TPCodecUtils", "getSupportedFrameRatesFor max width:" + paramInt1 + " max height:" + j + " max framerate for max resolution:" + k + " current width:" + paramInt3 + " height:" + paramInt4 + " max support framerate:" + localInteger2);
        localInteger1 = localInteger2;
        paramInt1 = localInteger1.intValue();
        continue;
        if (paramInt3 >= paramInt4) {
          continue;
        }
      }
      finally {}
      label442:
      if (paramInt3 <= i) {
        if (paramInt4 > paramInt2)
        {
          continue;
          label461:
          paramInt1 += 1;
        }
      }
    }
  }
  
  private static int getSoftMaxSamples(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return 407040;
    case 1: 
      return 129600;
    case 6: 
      return 307200;
    case 16: 
      return 480000;
    case 21: 
      return 921600;
    case 26: 
      return 2073600;
    case 28: 
      return 8294400;
    }
    return 8847360;
  }
  
  private static int getSupportedCodecId(String paramString)
  {
    if (TextUtils.equals(paramString, "video/avc")) {
      return 26;
    }
    if (TextUtils.equals(paramString, "video/hevc")) {
      return 172;
    }
    if (TextUtils.equals(paramString, "video/x-vnd.on2.vp9")) {
      return 166;
    }
    if (TextUtils.equals(paramString, "video/av01")) {
      return 1029;
    }
    if (TextUtils.equals(paramString, "audio/mp4a-latm")) {
      return 5002;
    }
    if (TextUtils.equals(paramString, "audio/ac3")) {
      return 5003;
    }
    if ((TextUtils.equals(paramString, "audio/eac3")) || (TextUtils.equals(paramString, "audio/eac3-joc"))) {
      return 5040;
    }
    if (TextUtils.equals(paramString, "audio/flac")) {
      return 5012;
    }
    if (TextUtils.equals(paramString, "audio/vnd.dts")) {
      return 5004;
    }
    return -1;
  }
  
  private static String getSupportedHWMimeType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 26: 
      return "video/avc";
    case 172: 
      return "video/hevc";
    case 166: 
      return "video/x-vnd.on2.vp9";
    }
    return "video/av01";
  }
  
  public static String getSystemPatchVersion()
  {
    if (!TextUtils.equals(Build.BRAND, "HUAWEI")) {
      return null;
    }
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      localObject1 = (String)((Class)localObject1).getDeclaredMethod("get", new Class[] { String.class }).invoke(localObject1, new Object[] { "hwouc.hwpatch.version" });
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get huawei system patch version failed:" + localException.getMessage());
        Object localObject2 = null;
      }
    }
  }
  
  /* Error */
  public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVCodecSWMaxCapabilityMap()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_2
    //   4: ldc 39
    //   6: ldc_w 821
    //   9: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   12: getstatic 334	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsFFmpegCapGot	Z
    //   15: ifeq +14 -> 29
    //   18: getstatic 349	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   21: astore 4
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload 4
    //   28: areturn
    //   29: invokestatic 823	com/tencent/thumbplayer/core/common/TPCodecUtils:getHevcSWDecodeLevel	()I
    //   32: istore_0
    //   33: iload_0
    //   34: invokestatic 825	com/tencent/thumbplayer/core/common/TPCodecUtils:getSoftMaxSamples	(I)I
    //   37: istore_1
    //   38: invokestatic 827	com/tencent/thumbplayer/core/common/TPCodecUtils:getAvs3SWDecodeLevel	()I
    //   41: istore_2
    //   42: iload_2
    //   43: invokestatic 825	com/tencent/thumbplayer/core/common/TPCodecUtils:getSoftMaxSamples	(I)I
    //   46: istore_3
    //   47: iconst_2
    //   48: new 419	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 829
    //   58: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_0
    //   62: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc_w 831
    //   68: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_2
    //   72: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 497	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   81: getstatic 339	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   84: iload_1
    //   85: putfield 834	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxLumaSamples	I
    //   88: getstatic 339	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   91: bipush 64
    //   93: putfield 837	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxProfile	I
    //   96: getstatic 339	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   99: ldc_w 838
    //   102: putfield 841	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxLevel	I
    //   105: getstatic 349	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   108: bipush 26
    //   110: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: getstatic 339	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   116: invokevirtual 206	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: getstatic 341	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   123: iload_1
    //   124: putfield 834	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxLumaSamples	I
    //   127: getstatic 341	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   130: iconst_2
    //   131: putfield 837	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxProfile	I
    //   134: getstatic 341	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   137: ldc_w 842
    //   140: putfield 841	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxLevel	I
    //   143: getstatic 349	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   146: sipush 172
    //   149: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: getstatic 341	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   155: invokevirtual 206	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: getstatic 343	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9SWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   162: iload_1
    //   163: putfield 834	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxLumaSamples	I
    //   166: getstatic 343	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9SWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   169: bipush 8
    //   171: putfield 837	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxProfile	I
    //   174: getstatic 343	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9SWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   177: sipush 8192
    //   180: putfield 841	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxLevel	I
    //   183: getstatic 349	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   186: sipush 166
    //   189: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: getstatic 343	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9SWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   195: invokevirtual 206	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: getstatic 345	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVS3WMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   202: iload_3
    //   203: putfield 834	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxLumaSamples	I
    //   206: getstatic 345	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVS3WMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   209: iconst_0
    //   210: putfield 837	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxProfile	I
    //   213: getstatic 345	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVS3WMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   216: iconst_0
    //   217: putfield 841	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:maxLevel	I
    //   220: getstatic 349	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   223: sipush 192
    //   226: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: getstatic 345	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVS3WMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability;
    //   232: invokevirtual 206	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   235: pop
    //   236: iconst_2
    //   237: new 419	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 844
    //   247: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload_1
    //   251: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: ldc_w 846
    //   257: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: iload_3
    //   261: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 497	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   270: iconst_1
    //   271: putstatic 334	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsFFmpegCapGot	Z
    //   274: getstatic 349	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   277: astore 4
    //   279: goto -256 -> 23
    //   282: astore 4
    //   284: iconst_4
    //   285: ldc 39
    //   287: ldc_w 848
    //   290: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   293: aconst_null
    //   294: astore 4
    //   296: goto -273 -> 23
    //   299: astore 4
    //   301: ldc 2
    //   303: monitorexit
    //   304: aload 4
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	30	0	i	int
    //   37	214	1	j	int
    //   41	31	2	k	int
    //   46	215	3	m	int
    //   21	257	4	localHashMap	HashMap
    //   282	1	4	localException	Exception
    //   294	1	4	localObject1	Object
    //   299	6	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	279	282	java/lang/Exception
    //   3	23	299	finally
    //   29	279	299	finally
    //   284	293	299	finally
  }
  
  /* Error */
  public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVMediaCodecMaxCapabilityMap()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_2
    //   4: ldc 39
    //   6: ldc_w 851
    //   9: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   12: getstatic 347	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   15: invokevirtual 489	java/util/HashMap:isEmpty	()Z
    //   18: ifne +21 -> 39
    //   21: iconst_2
    //   22: ldc 39
    //   24: ldc_w 853
    //   27: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   30: getstatic 347	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   33: astore_2
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mLocalCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache;
    //   42: invokestatic 512	com/tencent/thumbplayer/core/common/TPMediaDecoderList:getTPMediaDecoderInfos	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache;)[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   45: astore_2
    //   46: aload_2
    //   47: arraylength
    //   48: istore_1
    //   49: iconst_0
    //   50: istore_0
    //   51: iload_0
    //   52: iload_1
    //   53: if_icmpge +237 -> 290
    //   56: aload_2
    //   57: iload_0
    //   58: aaload
    //   59: astore_3
    //   60: aload_3
    //   61: invokevirtual 517	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderMimeType	()Ljava/lang/String;
    //   64: astore 4
    //   66: aload_3
    //   67: invokevirtual 856	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:isVideo	()Z
    //   70: ifeq +183 -> 253
    //   73: getstatic 145	com/tencent/thumbplayer/core/common/TPCodecUtils:mVMediaCodecCapList	Ljava/util/ArrayList;
    //   76: aload 4
    //   78: invokevirtual 228	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: iconst_2
    //   83: ldc 39
    //   85: new 419	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 858
    //   95: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 4
    //   100: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 537
    //   106: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 530	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderName	()Ljava/lang/String;
    //   113: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   122: aload 4
    //   124: invokestatic 524	com/tencent/thumbplayer/core/common/TPCodecUtils:isSupportedMediaCodec	(Ljava/lang/String;)Z
    //   127: ifeq +126 -> 253
    //   130: aload_3
    //   131: invokevirtual 662	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:isSecureDecoder	()Z
    //   134: ifne +119 -> 253
    //   137: aload_3
    //   138: invokevirtual 541	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getMaxProfileLevel	()Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel;
    //   141: astore 5
    //   143: new 336	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability
    //   146: dup
    //   147: aload 4
    //   149: aload 5
    //   151: getfield 549	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel:level	I
    //   154: invokestatic 860	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxLumaSample	(Ljava/lang/String;I)I
    //   157: aload 5
    //   159: getfield 546	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel:profile	I
    //   162: aload 5
    //   164: getfield 549	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel:level	I
    //   167: aload_3
    //   168: invokevirtual 761	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderMaxFrameRateForMaxLuma	()I
    //   171: invokespecial 337	com/tencent/thumbplayer/core/common/TPCodecCapability$TPCodecMaxCapability:<init>	(IIII)V
    //   174: astore 6
    //   176: iconst_2
    //   177: ldc 39
    //   179: new 419	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 862
    //   189: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_3
    //   193: invokevirtual 530	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderName	()Ljava/lang/String;
    //   196: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 864
    //   202: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 4
    //   207: aload 5
    //   209: getfield 549	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel:level	I
    //   212: invokestatic 860	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxLumaSample	(Ljava/lang/String;I)I
    //   215: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: ldc_w 866
    //   221: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_3
    //   225: invokevirtual 761	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderMaxFrameRateForMaxLuma	()I
    //   228: invokevirtual 431	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   237: aload 4
    //   239: invokestatic 561	com/tencent/thumbplayer/core/common/TPCodecUtils:getSupportedCodecId	(Ljava/lang/String;)I
    //   242: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aload 6
    //   247: getstatic 347	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   250: invokestatic 578	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   253: iload_0
    //   254: iconst_1
    //   255: iadd
    //   256: istore_0
    //   257: goto -206 -> 51
    //   260: astore_2
    //   261: iconst_4
    //   262: ldc 39
    //   264: new 419	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 868
    //   274: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_2
    //   278: invokestatic 874	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   281: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 222	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   290: getstatic 347	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   293: astore_2
    //   294: goto -260 -> 34
    //   297: astore_2
    //   298: ldc 2
    //   300: monitorexit
    //   301: aload_2
    //   302: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	207	0	i	int
    //   48	6	1	j	int
    //   33	24	2	localObject1	Object
    //   260	18	2	localException	Exception
    //   293	1	2	localHashMap	HashMap
    //   297	5	2	localObject2	Object
    //   59	166	3	localObject3	Object
    //   64	174	4	str	String
    //   141	67	5	localDecoderProfileLevel	TPMediaDecoderInfo.DecoderProfileLevel
    //   174	72	6	localTPCodecMaxCapability	TPCodecCapability.TPCodecMaxCapability
    // Exception table:
    //   from	to	target	type
    //   39	49	260	java/lang/Exception
    //   60	253	260	java/lang/Exception
    //   3	34	297	finally
    //   39	49	297	finally
    //   60	253	297	finally
    //   261	290	297	finally
    //   290	294	297	finally
  }
  
  private static int getValueFromSubstring(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    if (paramInt2 >= paramString.length()) {}
    for (paramInt1 = paramString.length() - 1;; paramInt1 = paramInt2)
    {
      paramInt2 = i;
      if (i > paramInt1) {
        paramInt2 = paramInt1;
      }
      return Integer.parseInt(paramString.substring(paramInt2, paramInt1));
    }
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      TPNativeLog.printLog(2, "TPCodecUtils", "is local cache enabled:" + paramBoolean);
      mContext = paramContext.getApplicationContext();
      if (paramBoolean) {
        mLocalCache = LocalCache.get(mContext);
      }
      getDecoderMaxCapabilityMapAsync();
      return;
    }
    finally {}
  }
  
  public static boolean isAMediaCodecBlackListInstance(String paramString)
  {
    return mAMediaCodecBlackListInstance.contains(paramString);
  }
  
  public static boolean isAMediaCodecBlackListModel()
  {
    return mAMediaCodecBlackListModel.contains(Build.MODEL);
  }
  
  public static boolean isBlackListType(String paramString)
  {
    return (Arrays.asList(new String[] { "PRO 7 Plus", "PRO 7-H", "PRO+7+Plus" }).contains(Build.MODEL)) && (TextUtils.equals(paramString, "video/hevc")) && (Build.VERSION.SDK_INT >= 14);
  }
  
  private static boolean isHDR10Support(int paramInt)
  {
    boolean bool2 = false;
    label132:
    for (;;)
    {
      try
      {
        TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
        int k = arrayOfTPMediaDecoderInfo.length;
        int i = 0;
        boolean bool1 = bool2;
        int j;
        if (i < k)
        {
          Object localObject2 = arrayOfTPMediaDecoderInfo[i];
          if (!TextUtils.equals(((TPMediaDecoderInfo)localObject2).getDecoderMimeType(), "video/hevc")) {
            break label132;
          }
          localObject2 = ((TPMediaDecoderInfo)localObject2).getProfileLevels();
          int m = localObject2.length;
          j = 0;
          if (j >= m) {
            break label132;
          }
          if (localObject2[j].profile == paramInt)
          {
            TPNativeLog.printLog(2, "TPCodecUtils", "support hdr10 " + paramInt);
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        j += 1;
        continue;
        i += 1;
      }
      finally {}
    }
  }
  
  private static boolean isHDRDVSupport(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    boolean bool1;
    try
    {
      bool1 = mVMediaCodecCapList.contains("video/dolby-vision");
      return bool1;
    }
    finally {}
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
    int k = arrayOfTPMediaDecoderInfo.length;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= k) {
        break;
      }
      Object localObject2 = arrayOfTPMediaDecoderInfo[i];
      if (TextUtils.equals(((TPMediaDecoderInfo)localObject2).getDecoderMimeType(), "video/dolby-vision"))
      {
        localObject2 = ((TPMediaDecoderInfo)localObject2).getProfileLevels();
        int m = localObject2.length;
        int j = 0;
        for (;;)
        {
          if (j >= m) {
            break label153;
          }
          Object localObject3 = localObject2[j];
          if ((localObject3.profile == paramInt1) && (localObject3.level == paramInt2))
          {
            TPNativeLog.printLog(2, "TPCodecUtils", "support dolbyvision");
            bool1 = true;
            break;
          }
          j += 1;
        }
      }
      label153:
      i += 1;
    }
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 2) {
      bool1 = isHDRDVSupport(paramInt2, paramInt3);
    }
    do
    {
      do
      {
        return bool1;
        if (paramInt1 == 0) {
          return isHDR10Support(4096);
        }
        if (paramInt1 == 1) {
          return isHDR10Support(8192);
        }
        bool1 = bool2;
      } while (paramInt1 != 4);
      bool1 = bool2;
    } while (!TextUtils.equals(Build.BRAND, "HUAWEI"));
    String str1 = getDisplayVersion();
    String str2 = getSystemPatchVersion();
    TPNativeLog.printLog(2, "TPCodecUtils", "isHDRsupport(cuva):display version:" + str1);
    TPNativeLog.printLog(2, "TPCodecUtils", "isHDRsupport(cuva):patch version:" + str2);
    return checkCuvaSupportByVersion(Build.MODEL, str1, str2);
  }
  
  public static boolean isInCuvaHDRBlackList(String paramString, int paramInt1, int paramInt2)
  {
    if (mHdrBlackMap.containsKey(Integer.valueOf(4)))
    {
      HashMap localHashMap = (HashMap)mHdrBlackMap.get(Integer.valueOf(4));
      if (localHashMap.containsKey(paramString))
      {
        paramString = (TPCodecCapability.TPHdrSupportVersionRange)localHashMap.get(paramString);
        return (paramInt1 <= paramString.upperboundSystemVersion) && (paramInt1 >= paramString.lowerboundSystemVersion) && (paramInt2 <= paramString.upperboundPatchVersion) && (paramInt2 >= paramString.lowerboundPatchVersion);
      }
      return false;
    }
    return false;
  }
  
  public static boolean isInCuvaHDRWhiteList(String paramString, int paramInt1, int paramInt2)
  {
    if (mHdrWhiteMap.containsKey(Integer.valueOf(4)))
    {
      HashMap localHashMap = (HashMap)mHdrWhiteMap.get(Integer.valueOf(4));
      if (localHashMap.containsKey(paramString))
      {
        paramString = (TPCodecCapability.TPHdrSupportVersionRange)localHashMap.get(paramString);
        return (paramInt1 <= paramString.upperboundSystemVersion) && (paramInt1 >= paramString.lowerboundSystemVersion) && (paramInt2 <= paramString.upperboundPatchVersion) && (paramInt2 >= paramString.lowerboundPatchVersion);
      }
      return false;
    }
    return false;
  }
  
  public static boolean isInDRMLevel1Blacklist(int paramInt)
  {
    if (mDrmL1BlackList.containsKey(Integer.valueOf(paramInt))) {
      return ((ArrayList)mDrmL1BlackList.get(Integer.valueOf(paramInt))).contains(Build.MODEL);
    }
    return false;
  }
  
  public static boolean isInMediaCodecBlackList(String paramString)
  {
    boolean bool = true;
    Object localObject = Build.MODEL;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (mCodecCapBlackList != null) && (mCodecCapBlackList.containsKey(localObject)))
    {
      localObject = (Integer)mCodecCapBlackList.get(localObject);
      if (TextUtils.equals(paramString, "video/avc")) {
        if ((((Integer)localObject).intValue() & 0x1) != 0) {
          bool = true;
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
                      for (;;)
                      {
                        return bool;
                        bool = false;
                      }
                      if (!TextUtils.equals(paramString, "video/hevc")) {
                        break;
                      }
                    } while ((((Integer)localObject).intValue() & 0x2) != 0);
                    return false;
                    if (!TextUtils.equals(paramString, "video/x-vnd.on2.vp9")) {
                      break;
                    }
                  } while ((((Integer)localObject).intValue() & 0x4) != 0);
                  return false;
                  if (!TextUtils.equals(paramString, "audio/mp4a-latm")) {
                    break;
                  }
                } while ((((Integer)localObject).intValue() & 0x8) != 0);
                return false;
                if (!TextUtils.equals(paramString, "audio/ac3")) {
                  break;
                }
              } while ((((Integer)localObject).intValue() & 0x10) != 0);
              return false;
              if (!TextUtils.equals(paramString, "audio/eac3")) {
                break;
              }
            } while ((((Integer)localObject).intValue() & 0x20) != 0);
            return false;
            if (!TextUtils.equals(paramString, "audio/flac")) {
              break;
            }
          } while ((((Integer)localObject).intValue() & 0x40) != 0);
          return false;
          if (!TextUtils.equals(paramString, "audio/vnd.dts")) {
            break;
          }
        } while ((((Integer)localObject).intValue() & 0x80) != 0);
        return false;
        if (!TextUtils.equals(paramString, "audio/eac3-joc")) {
          break;
        }
      } while ((((Integer)localObject).intValue() & 0x20) != 0);
      return false;
    }
    return false;
    return false;
  }
  
  public static boolean isInMediaCodecWhiteList(String paramString)
  {
    boolean bool = true;
    Object localObject = Build.MODEL;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (mCodecCapWhiteList != null) && (mCodecCapWhiteList.containsKey(localObject)))
    {
      localObject = (Integer)mCodecCapWhiteList.get(localObject);
      if (TextUtils.equals(paramString, "video/avc")) {
        if ((((Integer)localObject).intValue() & 0x1) != 0) {
          bool = true;
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
                    for (;;)
                    {
                      return bool;
                      bool = false;
                    }
                    if (!TextUtils.equals(paramString, "video/hevc")) {
                      break;
                    }
                  } while ((((Integer)localObject).intValue() & 0x2) != 0);
                  return false;
                  if (!TextUtils.equals(paramString, "video/x-vnd.on2.vp9")) {
                    break;
                  }
                } while ((((Integer)localObject).intValue() & 0x4) != 0);
                return false;
                if (!TextUtils.equals(paramString, "audio/mp4a-latm")) {
                  break;
                }
              } while ((((Integer)localObject).intValue() & 0x8) != 0);
              return false;
              if (!TextUtils.equals(paramString, "audio/ac3")) {
                break;
              }
            } while ((((Integer)localObject).intValue() & 0x10) != 0);
            return false;
            if (!TextUtils.equals(paramString, "audio/eac3")) {
              break;
            }
          } while ((((Integer)localObject).intValue() & 0x20) != 0);
          return false;
          if (!TextUtils.equals(paramString, "audio/flac")) {
            break;
          }
        } while ((((Integer)localObject).intValue() & 0x40) != 0);
        return false;
        if (!TextUtils.equals(paramString, "audio/vnd.dts")) {
          break;
        }
      } while ((((Integer)localObject).intValue() & 0x80) != 0);
      return false;
    }
    return false;
    return false;
  }
  
  /* Error */
  public static boolean isMediaCodecDDPlusSupported()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 941	com/tencent/thumbplayer/core/common/TPCodecUtils:isAMediaCodecBlackListModel	()Z
    //   8: istore_1
    //   9: iload_1
    //   10: ifeq +8 -> 18
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mAMediaCodecCapList	Ljava/util/ArrayList;
    //   21: ldc 240
    //   23: invokevirtual 369	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   26: ifne +16 -> 42
    //   29: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mAMediaCodecCapList	Ljava/util/ArrayList;
    //   32: ldc 242
    //   34: invokevirtual 369	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   37: istore_1
    //   38: iload_1
    //   39: ifeq -26 -> 13
    //   42: iconst_1
    //   43: istore_0
    //   44: goto -31 -> 13
    //   47: astore_2
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	43	0	bool1	boolean
    //   8	31	1	bool2	boolean
    //   47	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	47	finally
    //   18	38	47	finally
  }
  
  /* Error */
  public static boolean isMediaCodecDolbyDSSupported()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 941	com/tencent/thumbplayer/core/common/TPCodecUtils:isAMediaCodecBlackListModel	()Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +10 -> 18
    //   11: iconst_0
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mAMediaCodecCapList	Ljava/util/ArrayList;
    //   21: ldc 238
    //   23: invokevirtual 369	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   26: istore_0
    //   27: goto -14 -> 13
    //   30: astore_1
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	21	0	bool	boolean
    //   30	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	30	finally
    //   18	27	30	finally
  }
  
  private static boolean isSupportedMediaCodec(String paramString)
  {
    return mSupportedMediaCodec.contains(paramString);
  }
  
  public static boolean isVMediaCodecBlackListModel()
  {
    return mVMediaCodecBlackListModel.contains(Build.MODEL);
  }
  
  private static <K, T> void replace(K paramK, T paramT, HashMap<K, T> paramHashMap)
  {
    if (paramHashMap.containsKey(paramK))
    {
      paramHashMap.remove(paramK);
      paramHashMap.put(paramK, paramT);
      return;
    }
    paramHashMap.put(paramK, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecUtils
 * JD-Core Version:    0.7.0.1
 */
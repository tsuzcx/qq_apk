package com.tencent.thumbplayer.core.common;

import java.util.HashMap;

public final class TPMediaCodecProfileLevel
{
  public static final int AACObjectELD = 39;
  public static final int AACObjectERLC = 17;
  public static final int AACObjectHE = 5;
  public static final int AACObjectHE_PS = 29;
  public static final int AACObjectLC = 2;
  public static final int AACObjectLD = 23;
  public static final int AACObjectLTP = 4;
  public static final int AACObjectMain = 1;
  public static final int AACObjectSSR = 3;
  public static final int AACObjectScalable = 6;
  public static final int AV1Level2 = 1;
  public static final int AV1Level21 = 2;
  public static final int AV1Level22 = 4;
  public static final int AV1Level23 = 8;
  public static final int AV1Level3 = 16;
  public static final int AV1Level31 = 32;
  public static final int AV1Level32 = 64;
  public static final int AV1Level33 = 128;
  public static final int AV1Level4 = 256;
  public static final int AV1Level41 = 512;
  public static final int AV1Level42 = 1024;
  public static final int AV1Level43 = 2048;
  public static final int AV1Level5 = 4096;
  public static final int AV1Level51 = 8192;
  public static final int AV1Level52 = 16384;
  public static final int AV1Level53 = 32768;
  public static final int AV1Level6 = 65536;
  public static final int AV1Level61 = 131072;
  public static final int AV1Level62 = 262144;
  public static final int AV1Level63 = 524288;
  public static final int AV1Level7 = 1048576;
  public static final int AV1Level71 = 2097152;
  public static final int AV1Level72 = 4194304;
  public static final int AV1Level73 = 8388608;
  public static final int AV1ProfileMain10 = 2;
  public static final int AV1ProfileMain10HDR10 = 4096;
  public static final int AV1ProfileMain10HDR10Plus = 8192;
  public static final int AV1ProfileMain8 = 1;
  public static final int AVCLevel1 = 1;
  public static final int AVCLevel11 = 4;
  public static final int AVCLevel12 = 8;
  public static final int AVCLevel13 = 16;
  public static final int AVCLevel1b = 2;
  public static final int AVCLevel2 = 32;
  public static final int AVCLevel21 = 64;
  public static final int AVCLevel22 = 128;
  public static final int AVCLevel3 = 256;
  public static final int AVCLevel31 = 512;
  public static final int AVCLevel32 = 1024;
  public static final int AVCLevel4 = 2048;
  public static final int AVCLevel41 = 4096;
  public static final int AVCLevel42 = 8192;
  public static final int AVCLevel5 = 16384;
  public static final int AVCLevel51 = 32768;
  public static final int AVCLevel52 = 65536;
  public static final int AVCLevel6 = 131072;
  public static final int AVCLevel61 = 262144;
  public static final int AVCLevel62 = 524288;
  public static final int AVCProfileBaseline = 1;
  public static final int AVCProfileConstrainedBaseline = 65536;
  public static final int AVCProfileConstrainedHigh = 524288;
  public static final int AVCProfileExtended = 4;
  public static final int AVCProfileHigh = 8;
  public static final int AVCProfileHigh10 = 16;
  public static final int AVCProfileHigh422 = 32;
  public static final int AVCProfileHigh444 = 64;
  public static final int AVCProfileMain = 2;
  public static final int DisplayHdrTypeCuvaVision = 5;
  public static final int DisplayHdrTypeDolbyVision = 1;
  public static final int DisplayHdrTypeHdr10 = 2;
  public static final int DisplayHdrTypeHdr10Plus = 4;
  public static final int DisplayHdrTypeHlg = 3;
  public static final int DolbyVisionLevelFhd24 = 4;
  public static final int DolbyVisionLevelFhd30 = 8;
  public static final int DolbyVisionLevelFhd60 = 16;
  public static final int DolbyVisionLevelHd24 = 1;
  public static final int DolbyVisionLevelHd30 = 2;
  public static final int DolbyVisionLevelUhd24 = 32;
  public static final int DolbyVisionLevelUhd30 = 64;
  public static final int DolbyVisionLevelUhd48 = 128;
  public static final int DolbyVisionLevelUhd60 = 256;
  public static final int DolbyVisionProfileDvavPen = 2;
  public static final int DolbyVisionProfileDvavPer = 1;
  public static final int DolbyVisionProfileDvavSe = 512;
  public static final int DolbyVisionProfileDvheDen = 8;
  public static final int DolbyVisionProfileDvheDer = 4;
  public static final int DolbyVisionProfileDvheDtb = 128;
  public static final int DolbyVisionProfileDvheDth = 64;
  public static final int DolbyVisionProfileDvheDtr = 16;
  public static final int DolbyVisionProfileDvheSt = 256;
  public static final int DolbyVisionProfileDvheStn = 32;
  public static final int H263Level10 = 1;
  public static final int H263Level20 = 2;
  public static final int H263Level30 = 4;
  public static final int H263Level40 = 8;
  public static final int H263Level45 = 16;
  public static final int H263Level50 = 32;
  public static final int H263Level60 = 64;
  public static final int H263Level70 = 128;
  public static final int H263ProfileBackwardCompatible = 4;
  public static final int H263ProfileBaseline = 1;
  public static final int H263ProfileH320Coding = 2;
  public static final int H263ProfileHighCompression = 32;
  public static final int H263ProfileHighLatency = 256;
  public static final int H263ProfileISWV2 = 8;
  public static final int H263ProfileISWV3 = 16;
  public static final int H263ProfileInterlace = 128;
  public static final int H263ProfileInternet = 64;
  public static final int HEVCHighTierLevel1 = 2;
  public static final int HEVCHighTierLevel2 = 8;
  public static final int HEVCHighTierLevel21 = 32;
  public static final int HEVCHighTierLevel3 = 128;
  public static final int HEVCHighTierLevel31 = 512;
  public static final int HEVCHighTierLevel4 = 2048;
  public static final int HEVCHighTierLevel41 = 8192;
  public static final int HEVCHighTierLevel5 = 32768;
  public static final int HEVCHighTierLevel51 = 131072;
  public static final int HEVCHighTierLevel52 = 524288;
  public static final int HEVCHighTierLevel6 = 2097152;
  public static final int HEVCHighTierLevel61 = 8388608;
  public static final int HEVCHighTierLevel62 = 33554432;
  private static final int HEVCHighTierLevels = 44739242;
  public static final int HEVCMainTierLevel1 = 1;
  public static final int HEVCMainTierLevel2 = 4;
  public static final int HEVCMainTierLevel21 = 16;
  public static final int HEVCMainTierLevel3 = 64;
  public static final int HEVCMainTierLevel31 = 256;
  public static final int HEVCMainTierLevel4 = 1024;
  public static final int HEVCMainTierLevel41 = 4096;
  public static final int HEVCMainTierLevel5 = 16384;
  public static final int HEVCMainTierLevel51 = 65536;
  public static final int HEVCMainTierLevel52 = 262144;
  public static final int HEVCMainTierLevel6 = 1048576;
  public static final int HEVCMainTierLevel61 = 4194304;
  public static final int HEVCMainTierLevel62 = 16777216;
  public static final int HEVCProfileMain = 1;
  public static final int HEVCProfileMain10 = 2;
  public static final int HEVCProfileMain10HDR10 = 4096;
  public static final int HEVCProfileMain10HDR10Plus = 8192;
  public static final int HEVCProfileMainStill = 4;
  public static final int MPEG2LevelH14 = 2;
  public static final int MPEG2LevelHL = 3;
  public static final int MPEG2LevelHP = 4;
  public static final int MPEG2LevelLL = 0;
  public static final int MPEG2LevelML = 1;
  public static final int MPEG2Profile422 = 2;
  public static final int MPEG2ProfileHigh = 5;
  public static final int MPEG2ProfileMain = 1;
  public static final int MPEG2ProfileSNR = 3;
  public static final int MPEG2ProfileSimple = 0;
  public static final int MPEG2ProfileSpatial = 4;
  public static final int MPEG4Level0 = 1;
  public static final int MPEG4Level0b = 2;
  public static final int MPEG4Level1 = 4;
  public static final int MPEG4Level2 = 8;
  public static final int MPEG4Level3 = 16;
  public static final int MPEG4Level3b = 24;
  public static final int MPEG4Level4 = 32;
  public static final int MPEG4Level4a = 64;
  public static final int MPEG4Level5 = 128;
  public static final int MPEG4Level6 = 256;
  public static final int MPEG4ProfileAdvancedCoding = 4096;
  public static final int MPEG4ProfileAdvancedCore = 8192;
  public static final int MPEG4ProfileAdvancedRealTime = 1024;
  public static final int MPEG4ProfileAdvancedScalable = 16384;
  public static final int MPEG4ProfileAdvancedSimple = 32768;
  public static final int MPEG4ProfileBasicAnimated = 256;
  public static final int MPEG4ProfileCore = 4;
  public static final int MPEG4ProfileCoreScalable = 2048;
  public static final int MPEG4ProfileHybrid = 512;
  public static final int MPEG4ProfileMain = 8;
  public static final int MPEG4ProfileNbit = 16;
  public static final int MPEG4ProfileScalableTexture = 32;
  public static final int MPEG4ProfileSimple = 1;
  public static final int MPEG4ProfileSimpleFBA = 128;
  public static final int MPEG4ProfileSimpleFace = 64;
  public static final int MPEG4ProfileSimpleScalable = 2;
  public static final int TP_PROFILE_AAC_HE = 4;
  public static final int TP_PROFILE_AAC_HE_V2 = 28;
  public static final int TP_PROFILE_AAC_LOW = 1;
  public static final int TP_PROFILE_DTS = 20;
  public static final int TP_PROFILE_DTS_HD_HRA = 50;
  public static final int VP8Level_Version0 = 1;
  public static final int VP8Level_Version1 = 2;
  public static final int VP8Level_Version2 = 4;
  public static final int VP8Level_Version3 = 8;
  public static final int VP8ProfileMain = 1;
  public static final int VP9Level1 = 1;
  public static final int VP9Level11 = 2;
  public static final int VP9Level2 = 4;
  public static final int VP9Level21 = 8;
  public static final int VP9Level3 = 16;
  public static final int VP9Level31 = 32;
  public static final int VP9Level4 = 64;
  public static final int VP9Level41 = 128;
  public static final int VP9Level5 = 256;
  public static final int VP9Level51 = 512;
  public static final int VP9Level52 = 1024;
  public static final int VP9Level6 = 2048;
  public static final int VP9Level61 = 4096;
  public static final int VP9Level62 = 8192;
  public static final int VP9Profile0 = 1;
  public static final int VP9Profile1 = 2;
  public static final int VP9Profile2 = 4;
  public static final int VP9Profile2HDR = 4096;
  public static final int VP9Profile3 = 8;
  public static final int VP9Profile3HDR = 8192;
  public static final HashMap<Integer, Integer> av1LumaSampleMap;
  public static final HashMap<Integer, Integer> avcLumaSampleMap = new HashMap();
  public static final HashMap<Integer, Integer> hevcLumaSampleMap;
  public static final HashMap<Integer, Integer> vp9LumaSampleMap;
  
  static
  {
    avcLumaSampleMap.put(Integer.valueOf(1), Integer.valueOf(25344));
    avcLumaSampleMap.put(Integer.valueOf(2), Integer.valueOf(25344));
    avcLumaSampleMap.put(Integer.valueOf(4), Integer.valueOf(101376));
    avcLumaSampleMap.put(Integer.valueOf(8), Integer.valueOf(101376));
    avcLumaSampleMap.put(Integer.valueOf(16), Integer.valueOf(101376));
    avcLumaSampleMap.put(Integer.valueOf(32), Integer.valueOf(202752));
    avcLumaSampleMap.put(Integer.valueOf(64), Integer.valueOf(202752));
    avcLumaSampleMap.put(Integer.valueOf(128), Integer.valueOf(414720));
    avcLumaSampleMap.put(Integer.valueOf(256), Integer.valueOf(414720));
    avcLumaSampleMap.put(Integer.valueOf(512), Integer.valueOf(921600));
    avcLumaSampleMap.put(Integer.valueOf(1024), Integer.valueOf(1310720));
    avcLumaSampleMap.put(Integer.valueOf(2048), Integer.valueOf(2097152));
    avcLumaSampleMap.put(Integer.valueOf(4096), Integer.valueOf(2097152));
    avcLumaSampleMap.put(Integer.valueOf(8192), Integer.valueOf(2228224));
    avcLumaSampleMap.put(Integer.valueOf(16384), Integer.valueOf(5652480));
    avcLumaSampleMap.put(Integer.valueOf(32768), Integer.valueOf(9437184));
    avcLumaSampleMap.put(Integer.valueOf(65536), Integer.valueOf(9437184));
    avcLumaSampleMap.put(Integer.valueOf(131072), Integer.valueOf(36651584));
    avcLumaSampleMap.put(Integer.valueOf(262144), Integer.valueOf(36651584));
    avcLumaSampleMap.put(Integer.valueOf(524288), Integer.valueOf(36651584));
    hevcLumaSampleMap = new HashMap();
    hevcLumaSampleMap.put(Integer.valueOf(1), Integer.valueOf(36864));
    hevcLumaSampleMap.put(Integer.valueOf(2), Integer.valueOf(36864));
    hevcLumaSampleMap.put(Integer.valueOf(4), Integer.valueOf(122880));
    hevcLumaSampleMap.put(Integer.valueOf(8), Integer.valueOf(122880));
    hevcLumaSampleMap.put(Integer.valueOf(16), Integer.valueOf(245760));
    hevcLumaSampleMap.put(Integer.valueOf(32), Integer.valueOf(245760));
    hevcLumaSampleMap.put(Integer.valueOf(64), Integer.valueOf(552960));
    hevcLumaSampleMap.put(Integer.valueOf(128), Integer.valueOf(552960));
    hevcLumaSampleMap.put(Integer.valueOf(256), Integer.valueOf(983040));
    hevcLumaSampleMap.put(Integer.valueOf(512), Integer.valueOf(983040));
    hevcLumaSampleMap.put(Integer.valueOf(1024), Integer.valueOf(2228224));
    hevcLumaSampleMap.put(Integer.valueOf(2048), Integer.valueOf(2228224));
    hevcLumaSampleMap.put(Integer.valueOf(4096), Integer.valueOf(2228224));
    hevcLumaSampleMap.put(Integer.valueOf(8192), Integer.valueOf(2228224));
    hevcLumaSampleMap.put(Integer.valueOf(16384), Integer.valueOf(8912896));
    hevcLumaSampleMap.put(Integer.valueOf(32768), Integer.valueOf(8912896));
    hevcLumaSampleMap.put(Integer.valueOf(65536), Integer.valueOf(8912896));
    hevcLumaSampleMap.put(Integer.valueOf(131072), Integer.valueOf(8912896));
    hevcLumaSampleMap.put(Integer.valueOf(262144), Integer.valueOf(8912896));
    hevcLumaSampleMap.put(Integer.valueOf(524288), Integer.valueOf(8912896));
    hevcLumaSampleMap.put(Integer.valueOf(1048576), Integer.valueOf(35651584));
    hevcLumaSampleMap.put(Integer.valueOf(2097152), Integer.valueOf(35651584));
    hevcLumaSampleMap.put(Integer.valueOf(4194304), Integer.valueOf(35651584));
    hevcLumaSampleMap.put(Integer.valueOf(8388608), Integer.valueOf(35651584));
    hevcLumaSampleMap.put(Integer.valueOf(16777216), Integer.valueOf(35651584));
    hevcLumaSampleMap.put(Integer.valueOf(33554432), Integer.valueOf(35651584));
    vp9LumaSampleMap = new HashMap();
    vp9LumaSampleMap.put(Integer.valueOf(1), Integer.valueOf(36864));
    vp9LumaSampleMap.put(Integer.valueOf(2), Integer.valueOf(73728));
    vp9LumaSampleMap.put(Integer.valueOf(4), Integer.valueOf(122880));
    vp9LumaSampleMap.put(Integer.valueOf(8), Integer.valueOf(245760));
    vp9LumaSampleMap.put(Integer.valueOf(16), Integer.valueOf(552960));
    vp9LumaSampleMap.put(Integer.valueOf(32), Integer.valueOf(983040));
    vp9LumaSampleMap.put(Integer.valueOf(64), Integer.valueOf(2228224));
    vp9LumaSampleMap.put(Integer.valueOf(128), Integer.valueOf(2228224));
    vp9LumaSampleMap.put(Integer.valueOf(256), Integer.valueOf(8912896));
    vp9LumaSampleMap.put(Integer.valueOf(512), Integer.valueOf(8912896));
    vp9LumaSampleMap.put(Integer.valueOf(1024), Integer.valueOf(8912896));
    vp9LumaSampleMap.put(Integer.valueOf(2048), Integer.valueOf(35651584));
    vp9LumaSampleMap.put(Integer.valueOf(4096), Integer.valueOf(35651584));
    vp9LumaSampleMap.put(Integer.valueOf(8192), Integer.valueOf(35651584));
    av1LumaSampleMap = new HashMap();
    av1LumaSampleMap.put(Integer.valueOf(1), Integer.valueOf(147456));
    av1LumaSampleMap.put(Integer.valueOf(2), Integer.valueOf(278784));
    av1LumaSampleMap.put(Integer.valueOf(4), Integer.valueOf(278784));
    av1LumaSampleMap.put(Integer.valueOf(8), Integer.valueOf(278784));
    av1LumaSampleMap.put(Integer.valueOf(16), Integer.valueOf(665856));
    av1LumaSampleMap.put(Integer.valueOf(32), Integer.valueOf(1065024));
    av1LumaSampleMap.put(Integer.valueOf(64), Integer.valueOf(1065024));
    av1LumaSampleMap.put(Integer.valueOf(128), Integer.valueOf(1065024));
    av1LumaSampleMap.put(Integer.valueOf(256), Integer.valueOf(2359296));
    av1LumaSampleMap.put(Integer.valueOf(512), Integer.valueOf(2359296));
    av1LumaSampleMap.put(Integer.valueOf(1024), Integer.valueOf(2359296));
    av1LumaSampleMap.put(Integer.valueOf(2048), Integer.valueOf(2359296));
    av1LumaSampleMap.put(Integer.valueOf(4096), Integer.valueOf(8912896));
    av1LumaSampleMap.put(Integer.valueOf(8192), Integer.valueOf(8912896));
    av1LumaSampleMap.put(Integer.valueOf(16384), Integer.valueOf(8912896));
    av1LumaSampleMap.put(Integer.valueOf(32768), Integer.valueOf(8912896));
    av1LumaSampleMap.put(Integer.valueOf(65536), Integer.valueOf(35651584));
    av1LumaSampleMap.put(Integer.valueOf(131072), Integer.valueOf(35651584));
    av1LumaSampleMap.put(Integer.valueOf(262144), Integer.valueOf(35651584));
    av1LumaSampleMap.put(Integer.valueOf(524288), Integer.valueOf(35651584));
    av1LumaSampleMap.put(Integer.valueOf(1048576), Integer.valueOf(35651584));
    av1LumaSampleMap.put(Integer.valueOf(2097152), Integer.valueOf(35651584));
    av1LumaSampleMap.put(Integer.valueOf(4194304), Integer.valueOf(35651584));
    av1LumaSampleMap.put(Integer.valueOf(8388608), Integer.valueOf(35651584));
  }
  
  public static int getAV1MaxLumaSample(int paramInt)
  {
    Integer localInteger2 = (Integer)av1LumaSampleMap.get(Integer.valueOf(paramInt));
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = (Integer)av1LumaSampleMap.get(Integer.valueOf(8192));
    }
    return localInteger1.intValue();
  }
  
  public static int getAVCMaxLumaSample(int paramInt)
  {
    if (avcLumaSampleMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)avcLumaSampleMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return ((Integer)avcLumaSampleMap.get(Integer.valueOf(256))).intValue();
  }
  
  public static int getHEVCMaxLumaSample(int paramInt)
  {
    if (hevcLumaSampleMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)hevcLumaSampleMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return ((Integer)hevcLumaSampleMap.get(Integer.valueOf(64))).intValue();
  }
  
  public static int getVP9MaxLumaSample(int paramInt)
  {
    if (vp9LumaSampleMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)vp9LumaSampleMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return ((Integer)vp9LumaSampleMap.get(Integer.valueOf(16))).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel
 * JD-Core Version:    0.7.0.1
 */
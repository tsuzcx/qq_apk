package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class IjkMediaCodecInfo
{
  public static final int RANK_ACCEPTABLE = 700;
  public static final int RANK_LAST_CHANCE = 600;
  public static final int RANK_MAX = 1000;
  public static final int RANK_NON_STANDARD = 100;
  public static final int RANK_NO_SENSE = 0;
  public static final int RANK_SECURE = 300;
  public static final int RANK_SOFTWARE = 200;
  public static final int RANK_TESTED = 800;
  private static final String TAG = "IjkMediaCodecInfo";
  private static Map<String, Integer> sKnownCodecList;
  public MediaCodecInfo mCodecInfo;
  public String mMimeType;
  public int mRank = 0;
  
  private static Map<String, Integer> getKnownCodecList()
  {
    try
    {
      if (sKnownCodecList != null)
      {
        localMap = sKnownCodecList;
        return localMap;
      }
      sKnownCodecList = new TreeMap(String.CASE_INSENSITIVE_ORDER);
      sKnownCodecList.put("OMX.Nvidia.h264.decode", Integer.valueOf(800));
      sKnownCodecList.put("OMX.Nvidia.h264.decode.secure", Integer.valueOf(300));
      sKnownCodecList.put("OMX.Intel.hw_vd.h264", Integer.valueOf(801));
      sKnownCodecList.put("OMX.Intel.VideoDecoder.AVC", Integer.valueOf(800));
      sKnownCodecList.put("OMX.qcom.video.decoder.avc", Integer.valueOf(800));
      sKnownCodecList.put("OMX.ittiam.video.decoder.avc", Integer.valueOf(0));
      sKnownCodecList.put("OMX.SEC.avc.dec", Integer.valueOf(800));
      sKnownCodecList.put("OMX.SEC.AVC.Decoder", Integer.valueOf(799));
      sKnownCodecList.put("OMX.SEC.avcdec", Integer.valueOf(798));
      sKnownCodecList.put("OMX.SEC.avc.sw.dec", Integer.valueOf(200));
      sKnownCodecList.put("OMX.Exynos.avc.dec", Integer.valueOf(800));
      sKnownCodecList.put("OMX.Exynos.AVC.Decoder", Integer.valueOf(799));
      sKnownCodecList.put("OMX.k3.video.decoder.avc", Integer.valueOf(800));
      sKnownCodecList.put("OMX.IMG.MSVDX.Decoder.AVC", Integer.valueOf(800));
      sKnownCodecList.put("OMX.TI.DUCATI1.VIDEO.DECODER", Integer.valueOf(800));
      sKnownCodecList.put("OMX.rk.video_decoder.avc", Integer.valueOf(800));
      sKnownCodecList.put("OMX.amlogic.avc.decoder.awesome", Integer.valueOf(800));
      sKnownCodecList.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", Integer.valueOf(800));
      sKnownCodecList.put("OMX.MARVELL.VIDEO.H264DECODER", Integer.valueOf(200));
      sKnownCodecList.remove("OMX.Action.Video.Decoder");
      sKnownCodecList.remove("OMX.allwinner.video.decoder.avc");
      sKnownCodecList.remove("OMX.BRCM.vc4.decoder.avc");
      sKnownCodecList.remove("OMX.brcm.video.h264.hw.decoder");
      sKnownCodecList.remove("OMX.brcm.video.h264.decoder");
      sKnownCodecList.remove("OMX.cosmo.video.decoder.avc");
      sKnownCodecList.remove("OMX.duos.h264.decoder");
      sKnownCodecList.remove("OMX.hantro.81x0.video.decoder");
      sKnownCodecList.remove("OMX.hantro.G1.video.decoder");
      sKnownCodecList.remove("OMX.hisi.video.decoder");
      sKnownCodecList.remove("OMX.LG.decoder.video.avc");
      sKnownCodecList.remove("OMX.MS.AVC.Decoder");
      sKnownCodecList.remove("OMX.RENESAS.VIDEO.DECODER.H264");
      sKnownCodecList.remove("OMX.RTK.video.decoder");
      sKnownCodecList.remove("OMX.sprd.h264.decoder");
      sKnownCodecList.remove("OMX.ST.VFM.H264Dec");
      sKnownCodecList.remove("OMX.vpu.video_decoder.avc");
      sKnownCodecList.remove("OMX.WMT.decoder.avc");
      sKnownCodecList.remove("OMX.bluestacks.hw.decoder");
      sKnownCodecList.put("OMX.google.h264.decoder", Integer.valueOf(200));
      sKnownCodecList.put("OMX.google.h264.lc.decoder", Integer.valueOf(200));
      sKnownCodecList.put("OMX.k3.ffmpeg.decoder", Integer.valueOf(200));
      sKnownCodecList.put("OMX.ffmpeg.video.decoder", Integer.valueOf(200));
      sKnownCodecList.put("OMX.sprd.soft.h264.decoder", Integer.valueOf(200));
      Map localMap = sKnownCodecList;
      return localMap;
    }
    finally {}
  }
  
  public static String getLevelName(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        switch (paramInt)
        {
        default: 
          return "0";
        case 65536: 
          return "52";
        case 32768: 
          return "51";
        case 16384: 
          return "5";
        case 8192: 
          return "42";
        case 4096: 
          return "41";
        case 2048: 
          return "4";
        case 1024: 
          return "32";
        case 512: 
          return "31";
        case 256: 
          return "3";
        case 128: 
          return "22";
        case 64: 
          return "21";
        case 32: 
          return "2";
        case 16: 
          return "13";
        case 8: 
          return "12";
        }
        return "11";
      }
      return "1b";
    }
    return "1";
  }
  
  public static String getProfileLevelName(int paramInt1, int paramInt2)
  {
    return String.format(Locale.US, " %s Profile Level %s (%d,%d)", new Object[] { getProfileName(paramInt1), getLevelName(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static String getProfileName(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8)
          {
            if (paramInt != 16)
            {
              if (paramInt != 32)
              {
                if (paramInt != 64) {
                  return "Unknown";
                }
                return "High444";
              }
              return "High422";
            }
            return "High10";
          }
          return "High";
        }
        return "Extends";
      }
      return "Main";
    }
    return "Baseline";
  }
  
  @TargetApi(16)
  public static IjkMediaCodecInfo setupCandidate(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    Object localObject = null;
    int i;
    if (paramMediaCodecInfo != null)
    {
      if (Build.VERSION.SDK_INT < 16) {
        return null;
      }
      localObject = paramMediaCodecInfo.getName();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      localObject = ((String)localObject).toLowerCase(Locale.US);
      boolean bool = ((String)localObject).startsWith("omx.");
      i = 600;
      if (!bool)
      {
        i = 100;
      }
      else
      {
        if (((String)localObject).startsWith("omx.pv")) {}
        while ((((String)localObject).startsWith("omx.google.")) || (((String)localObject).startsWith("omx.ffmpeg.")) || (((String)localObject).startsWith("omx.k3.ffmpeg.")) || (((String)localObject).startsWith("omx.avcodec.")))
        {
          i = 200;
          break;
        }
        if (((String)localObject).startsWith("omx.ittiam.")) {}
        do
        {
          i = 0;
          break label230;
          if (!((String)localObject).startsWith("omx.mtk.")) {
            break;
          }
        } while (Build.VERSION.SDK_INT < 18);
        i = 800;
        break label230;
        localObject = (Integer)getKnownCodecList().get(localObject);
        if (localObject != null) {
          i = ((Integer)localObject).intValue();
        }
      }
    }
    try
    {
      localObject = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      if (localObject != null) {
        i = 700;
      }
    }
    catch (Throwable localThrowable)
    {
      label230:
      break label230;
    }
    localObject = new IjkMediaCodecInfo();
    ((IjkMediaCodecInfo)localObject).mCodecInfo = paramMediaCodecInfo;
    ((IjkMediaCodecInfo)localObject).mRank = i;
    ((IjkMediaCodecInfo)localObject).mMimeType = paramString;
    return localObject;
  }
  
  @TargetApi(16)
  public void dumpProfileLevels(String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    try
    {
      paramString = this.mCodecInfo.getCapabilitiesForType(paramString);
      if ((paramString == null) || (paramString.profileLevels == null)) {
        break label148;
      }
      paramString = paramString.profileLevels;
      i1 = paramString.length;
      k = 0;
      i = 0;
      j = 0;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        int i1;
        int k;
        int i;
        int j;
        Object localObject;
        continue;
        for (;;)
        {
          m = i;
          n = j;
          if (k >= i1) {
            break label71;
          }
          localObject = paramString[k];
          if (localObject != null) {
            break;
          }
          k += 1;
        }
        int m = 0;
        int n = 0;
      }
    }
    i = Math.max(i, localObject.profile);
    j = Math.max(j, localObject.level);
    break label139;
    label71:
    Log.i("IjkMediaCodecInfo", String.format(Locale.US, "%s", new Object[] { getProfileLevelName(m, n) }));
    return;
    Log.i("IjkMediaCodecInfo", "profile-level: exception");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.IjkMediaCodecInfo
 * JD-Core Version:    0.7.0.1
 */
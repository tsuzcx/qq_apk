import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.pkvideo.PKManager;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ayyh
{
  public static int eNn = 1280;
  private volatile boolean mFinished;
  private Object mLock = new Object();
  PKManager mPKManager;
  
  private void a(ayyh.a parama, DecodeConfig paramDecodeConfig, amae paramamae, PublishVideoEntry paramPublishVideoEntry)
  {
    boolean bool1 = parama.i.getBooleanExtra("local_import", false);
    int k = parama.i.getIntExtra("video_rotation", 0);
    boolean bool2 = parama.i.getBooleanExtra("landscape_video", false);
    int i;
    int j;
    if (parama.i.businessId == 1)
    {
      i = 1;
      if (parama.i.businessId != 14) {
        break label415;
      }
      j = 1;
      label65:
      if (QLog.isColorLevel())
      {
        QLog.d("MergeEditVideo", 2, new Object[] { "before adjust rotation:", Integer.valueOf(k), ", isLocalImport:", Boolean.valueOf(bool1) });
        QLog.d("MergeEditVideo", 2, "before adjust config: " + paramamae.toString());
      }
      if (!bool1) {
        break label497;
      }
      if (k != 0)
      {
        paramamae.adjustRotation = k;
        if ((i == 0) && (j == 0)) {
          break label421;
        }
        paramamae.orientation = 0;
      }
      label166:
      j = paramamae.width;
      i = paramamae.height;
      if (parama.i.businessId == 14) {
        break label444;
      }
      j = Math.min(paramamae.width, paramamae.height);
      i = Math.max(paramamae.width, paramamae.height);
      label216:
      int m = i;
      k = j;
      if (i > eNn)
      {
        k = (int)(j * eNn / i);
        m = eNn;
      }
      paramamae.width = alwy.iN(k);
      paramamae.height = alwy.iN(m);
      paramDecodeConfig.width = paramamae.width;
      paramDecodeConfig.height = paramamae.height;
      if ((paramamae.cBC) || (paramamae.cBE))
      {
        k = paramamae.width;
        m = (int)(paramamae.width * 16.0F / 9.0F);
        j = m;
        i = k;
        if (m > eNn)
        {
          i = (int)(k * eNn / m);
          j = eNn;
        }
        paramamae.width = alwy.iN(i);
        paramamae.height = alwy.iN(j);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + paramamae.toString());
      }
      return;
      i = 0;
      break;
      label415:
      j = 0;
      break label65;
      label421:
      if (bool2)
      {
        paramamae.orientation = 270;
        break label166;
      }
      paramamae.orientation = 0;
      break label166;
      label444:
      if ((paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) || (!bool2))
      {
        j = Math.min(paramamae.width, paramamae.height);
        i = Math.max(paramamae.width, paramamae.height);
        break label216;
      }
      paramamae.cBF = false;
      break label216;
      label497:
      if (i != 0) {
        paramamae.orientation = 0;
      }
    }
  }
  
  private void a(azap paramazap, HWVideoDecoder paramHWVideoDecoder, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry != null)
    {
      boolean bool = paramPublishVideoEntry.getBooleanExtra("has_game_pk_filter", false);
      String str1 = paramPublishVideoEntry.getStringExtra("game_pk_video_path", "");
      String str2 = paramPublishVideoEntry.getStringExtra("game_pk_cover_path", "");
      String str3 = paramPublishVideoEntry.getStringExtra("game_pk_result_path", "");
      if ((bool) && (!TextUtils.isEmpty(str2)) && (FileUtil.fileExistsAndNotEmpty(str2)))
      {
        paramazap = paramazap.getQQFilterRenderManager();
        if (!paramazap.hasQQFilter(183)) {
          paramazap.pushChainBasedStackTopChain(183, null);
        }
        paramazap = (PKFilter)paramazap.getQQFilterByType(183);
        if (paramazap != null)
        {
          paramazap.enableDebug(false);
          paramazap.config(str1, str2, str3, paramPublishVideoEntry.videoDuration, true);
          this.mPKManager = new PKManager(paramHWVideoDecoder, paramazap.getPKDecoder());
          paramazap.prepare();
        }
        return;
      }
      ram.e(PKFilter.TAG_ENCODE, "is pkVideo=" + bool + " path is empty file :" + str1);
      return;
    }
    ram.w(PKFilter.TAG_ENCODE, "pk video path is null");
  }
  
  public static boolean a(PublishVideoEntry paramPublishVideoEntry)
  {
    return (paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath));
  }
  
  public int a(String arg1, String paramString2, ayyh.a parama, PublishVideoEntry paramPublishVideoEntry)
  {
    int i;
    if ((parama == null) || (parama.i == null))
    {
      i = -1;
      return i;
    }
    parama.Uf(parama.i.saveMode);
    boolean bool1 = parama.i.getBooleanExtra("hasAVFilter", false);
    Object localObject4 = parama.i.getJSONArrayExtra("jsonAVFilterData");
    String str = parama.i.getStringExtra("transfer_effect_data", null);
    boolean bool4 = parama.i.getBooleanExtra("extra_is_need_gaussion_blur", false);
    boolean bool2 = parama.i.getBooleanExtra("is_follow_capture_video", false);
    boolean bool3 = parama.i.getBooleanExtra("is_video_forward", false);
    Object localObject3 = parama.i.getJSONExtra("follow_capture_param");
    Object localObject1;
    if (localObject4 == null)
    {
      localObject1 = null;
      bool1 = false;
    }
    label128:
    label514:
    label1161:
    for (;;)
    {
      boolean bool5 = parama.i.getBooleanExtra("has_game_pk_filter", false);
      if ((parama.dAP == 0) && (!bool5) && (parama.filterType == 0) && (parama.i.doodlePath == null) && (parama.i.mosaicPath == null) && (!bool1) && (str == null) && (!bool4) && (!parama.i.hasFragments) && (TextUtils.isEmpty(parama.i.fragments)) && (!bool2) && (!bool3)) {}
      Object localObject2;
      int m;
      int n;
      int i1;
      for (bool1 = true;; bool1 = false)
      {
        localObject2 = new azbt.a();
        j = azbt.a(???, (azbt.a)localObject2);
        i = j;
        if (j != 0) {
          break;
        }
        m = localObject2.mMetaData[0];
        n = localObject2.mMetaData[1];
        i1 = localObject2.mMetaData[2];
        if (a(parama, paramPublishVideoEntry, m, n, bool1)) {
          break label342;
        }
        QLog.d("MergeEditVideo", 1, "mergeVideo reEncoder false");
        return -1;
        localObject1 = FilterDesc.parse((JSONArray)localObject4);
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          break label1161;
        }
        bool1 = false;
        break label128;
      }
      label342:
      i = parama.i.videoRangeStart;
      int j = parama.i.videoRangeEnd;
      if (parama.dAP == 5)
      {
        localObject2 = parama.i.mIFrameVideoPath;
        j = 0;
        i = 0;
      }
      for (;;)
      {
        int k;
        if (localObject1 != null)
        {
          atao.dgW = true;
          JSONObject localJSONObject = parama.i.getJSONExtra("jsonMusicData");
          ??? = null;
          if (localJSONObject != null) {
            ??? = new MusicItemInfo(localJSONObject);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("MergeEditVideo", 2, "getAVFilterJSONArray " + ((JSONArray)localObject4).toString());
            localObject4 = new StringBuilder().append("getMusicInfo id = ");
            if (??? == null) {
              break label1047;
            }
            k = ???.mItemId;
          }
        }
        for (;;)
        {
          QLog.d("MergeEditVideo", 2, k);
          ??? = new azap((List)localObject1, ???, m, n, null);
          if ((a(paramPublishVideoEntry)) || (paramPublishVideoEntry.isMixOriginal))
          {
            QLog.d("MergeEditVideo", 1, "useHwAudioRecorder");
            localObject1 = new ayyk();
            paramString2 = new amae(paramString2, m, n, parama.bitrate, 1, 30, parama.filterType, false, i1, parama.i.doodlePath, parama.i.mosaicPath, null, parama.dBX);
            localObject2 = new DecodeConfig((String)localObject2, parama.dAP, false, true, i, j);
            ((DecodeConfig)localObject2).width = m;
            ((DecodeConfig)localObject2).height = n;
            paramString2.cBC = parama.i.getBooleanExtra("extra_is_need_gaussion_blur", false);
            if (bool3)
            {
              paramString2.cBE = true;
              paramString2.dBd = paramString2.width;
              paramString2.dBe = paramString2.height;
              paramString2.bZF = parama.i.getStringExtra("video_forward_watermark", "");
            }
            a(parama, (DecodeConfig)localObject2, paramString2, paramPublishVideoEntry);
            ((DecodeConfig)localObject2).isLocal = parama.i.getBooleanExtra("local_import", false);
            ((DecodeConfig)localObject2).isLandscape = parama.i.getBooleanExtra("landscape_video", false);
            ((DecodeConfig)localObject2).adjustRotation = i1;
            paramString2.dzA = parama.dzA;
            paramString2.dzB = parama.dzB;
            if ((parama.dzA == -1) && (paramPublishVideoEntry.getBooleanExtra("composite_key_bitrate_mode", false))) {
              paramString2.dzA = 0;
            }
            if (bool2)
            {
              paramString2.cBD = true;
              localObject4 = rpv.a(m, n, ankt.SCREEN_WIDTH, ankt.cIE);
              paramString2.dBd = paramString2.width;
              paramString2.dBe = paramString2.height;
              paramString2.width = ((Integer)((Pair)localObject4).first).intValue();
              paramString2.height = ((Integer)((Pair)localObject4).second).intValue();
              if (localObject3 != null) {
                paramString2.b = FollowCaptureParam.parseFromJson((JSONObject)localObject3);
              }
            }
            if (bool5)
            {
              ((DecodeConfig)localObject2).prolongToTime = alzu.getDuration(parama.i.getStringExtra("game_pk_video_path", ""));
              ((DecodeConfig)localObject2).syncDecode = true;
              ((ayyj)localObject1).a(???.a());
              a(???, ((ayyj)localObject1).a(), parama.i);
            }
            localObject3 = parama.i.getStringExtra("dynamic_Sticker_data", null);
            if (localObject3 != null) {
              ((ayyj)localObject1).fF(ayon.au((String)localObject3));
            }
            parama = parama.i.getStringExtra("tracker_Sticker_data", null);
            if (parama != null) {
              ((ayyj)localObject1).fG(TrackerStickerParam.FromString(parama));
            }
            if (str != null) {
              ((ayyj)localObject1).adI(str);
            }
            ((ayyj)localObject1).a((DecodeConfig)localObject2, paramString2, new ayyi(this, ???, paramString2, paramPublishVideoEntry, (ayyj)localObject1), ???);
            if (this.mFinished) {}
          }
          synchronized (this.mLock)
          {
            bool1 = this.mFinished;
            if (!bool1) {}
            try
            {
              this.mLock.wait();
              if (paramPublishVideoEntry.isCancel)
              {
                return -16;
                label1047:
                k = -1;
                continue;
                if (bool5)
                {
                  atao.dgW = true;
                  localObject4 = parama.i.getJSONExtra("jsonMusicData");
                  ??? = null;
                  if (localObject4 != null) {
                    ??? = new MusicItemInfo((JSONObject)localObject4);
                  }
                  ??? = new azap((List)localObject1, ???, m, n, parama.i);
                  break label514;
                }
                ??? = null;
                break label514;
                localObject1 = new ayyj();
              }
            }
            catch (InterruptedException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
              }
            }
          }
        }
        if (((ayyj)localObject1).mErrorCode == 0) {
          return 0;
        }
        return 1;
        localObject2 = ???;
      }
    }
  }
  
  public boolean a(ayyh.a parama, PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    do
    {
      long l;
      do
      {
        do
        {
          return true;
          if (!paramPublishVideoEntry.isLocalPublish) {
            return false;
          }
        } while ((paramPublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)));
        l = ShortVideoUtils.getDurationOfVideo(paramPublishVideoEntry.mLocalRawVideoDir);
      } while ((parama.i.videoRangeStart > 0) || (parama.i.videoRangeEnd < l));
      if ((parama.i.businessId != 11) && (parama.i.businessId != 12) && (parama.i.businessId != 1) && (parama.i.businessId != 14)) {
        return false;
      }
      paramBoolean = parama.i.getBooleanExtra("landscape_video", false);
      if (Math.max(paramInt1, paramInt2) <= eNn) {}
      for (paramInt1 = 1; (paramInt1 != 0) && ((parama.i.businessId == 11) || (parama.i.businessId == 12)); paramInt1 = 0) {
        return false;
      }
    } while ((paramInt1 == 0) || (paramBoolean) || (parama.i.businessId != 1));
    return false;
  }
  
  public static class a
  {
    protected int bitrate;
    int dAP;
    public boolean dBX;
    protected int dzA = -1;
    protected int dzB = -1;
    int filterType;
    protected PublishVideoEntry i;
    
    public a(int paramInt, PublishVideoEntry paramPublishVideoEntry)
    {
      this.bitrate = paramInt;
      this.i = new PublishVideoEntry();
      this.i.copy(paramPublishVideoEntry);
      Uf(this.i.saveMode);
    }
    
    private int getFilterType(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 7: 
        return 5;
      case 8: 
        return 6;
      case 9: 
        return 7;
      }
      return 4;
    }
    
    public void TV(int paramInt)
    {
      this.dzA = paramInt;
    }
    
    public void Uf(int paramInt)
    {
      this.filterType = getFilterType(paramInt);
      this.dAP = iV(paramInt);
    }
    
    public void afP(int paramInt)
    {
      this.dzB = paramInt;
    }
    
    public void eUt()
    {
      this.i.doodlePath = null;
    }
    
    public int iV(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 1: 
        return 1;
      case 2: 
        return 2;
      case 3: 
        return 3;
      case 4: 
        return 4;
      }
      return 5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyh
 * JD-Core Version:    0.7.0.1
 */
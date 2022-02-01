import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.PosListener.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class mss
{
  private mtg a;
  private int aTZ = 78888889;
  private int aUa;
  private int aUb;
  private int aUc;
  private int aUd;
  private int aUe;
  private int aUf;
  private int aUg;
  private int aUh = 1;
  private boolean anI;
  private boolean anJ;
  private boolean anK;
  private boolean anL;
  private SparseArray<VideoInfo> aq = new SparseArray();
  private SparseArray<VideoInfo> ar = new SparseArray();
  private VideoFeedsRecyclerView jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private lhw.a jdField_b_of_type_Lhw$a;
  private SparseBooleanArray c = new SparseBooleanArray();
  private int channelID = 78888888;
  private SparseBooleanArray d = new SparseBooleanArray();
  private SparseBooleanArray e = new SparseBooleanArray();
  private SparseBooleanArray g = new SparseBooleanArray();
  private ArrayList<Integer> lm = new ArrayList();
  private ArrayList<VideoInfo> ln = new ArrayList();
  private List<VideoInfo> mDataList;
  private Handler mUIHandler;
  
  public mss(mtg parammtg, List<VideoInfo> paramList, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, Handler paramHandler)
  {
    this.a = parammtg;
    this.mDataList = paramList;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.mUIHandler = paramHandler;
    kxm.getAppRuntime().getManager(163);
    this.jdField_b_of_type_Lhw$a = new mss.a(this);
  }
  
  private VideoInfo a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    int i = 0;
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.isAD = true;
    localVideoInfo.b = jzk.a(paramAdvertisementInfo);
    localVideoInfo.busiType = 5;
    localVideoInfo.WB = paramAdvertisementInfo.mJsonVideoList;
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList))
      {
        localObject = kxm.a(paramAdvertisementInfo.mJsonVideoList, paramAdvertisementInfo);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(";");
          paramAdvertisementInfo.mVideoVid = localObject[0];
          paramAdvertisementInfo.mVideoDuration = Integer.valueOf(localObject[1]).intValue();
          paramAdvertisementInfo.mVideoJsonWidth = Integer.valueOf(localObject[7]).intValue();
          paramAdvertisementInfo.mVideoJsonHeight = Integer.valueOf(localObject[8]).intValue();
        }
      }
      if (paramAdvertisementInfo.mVideoCoverUrl != null)
      {
        localVideoInfo.coverUrl = paramAdvertisementInfo.mVideoCoverUrl.toString();
        localVideoInfo.title = paramAdvertisementInfo.mTitle;
        localVideoInfo.vid = paramAdvertisementInfo.mVideoVid;
        localVideoInfo.videoUrl = paramAdvertisementInfo.mAdVideoUrl;
        localVideoInfo.hH = paramAdvertisementInfo.mSubscribeID;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.mSubscribeName)) {
          break label382;
        }
        localVideoInfo.accountName = paramAdvertisementInfo.mAdCorporateImageName;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.thirdIcon)) {
          break label394;
        }
        localVideoInfo.WC = paramAdvertisementInfo.mAdCorporateLogo;
        if (TextUtils.isEmpty(localVideoInfo.WB)) {
          localVideoInfo.vid = localVideoInfo.videoUrl;
        }
        if (paramBoolean)
        {
          localObject = localVideoInfo.b;
          if (paramBoolean) {
            i = 1;
          }
          ((VideoAdInfo)localObject).replay = i;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "videoinfo = " + localVideoInfo.toLogString());
        }
        if (paramAdvertisementInfo.mVideoJsonWidth != 0) {
          break label406;
        }
        i = 540;
        localVideoInfo.width = i;
        if (paramAdvertisementInfo.mVideoJsonHeight != 0) {
          break label414;
        }
        i = 960;
        localVideoInfo.height = i;
        localVideoInfo.b.adA = true;
        return localVideoInfo;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("VideoAdExposureManager", 2, localException.getMessage());
          continue;
          localVideoInfo.coverUrl = paramAdvertisementInfo.mAdImg;
          continue;
          label382:
          localVideoInfo.accountName = paramAdvertisementInfo.mSubscribeName;
          continue;
          label394:
          localVideoInfo.WC = paramAdvertisementInfo.thirdIcon;
          continue;
          label406:
          i = paramAdvertisementInfo.mVideoJsonWidth;
          continue;
          label414:
          i = paramAdvertisementInfo.mVideoJsonHeight;
        }
      }
    }
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if (paramInt2 == this.aTZ)
    {
      this.aUc = paramInt1;
      this.aUd = paramAdvertisementInfo.mAdKdPos;
    }
    for (;;)
    {
      jys localjys = new jys();
      localjys.aEw = paramAdvertisementInfo.mAdMaterialId;
      localjys.aEx = 1;
      localjys.aEy = paramAdvertisementInfo.mAdKdPos;
      localjys.re = paramAdvertisementInfo.mAdPosID;
      lbz.a().a().a(paramInt2, this.jdField_b_of_type_Lhw$a);
      ThreadManager.executeOnSubThread(new VideoAdExposureManager.1(this, paramInt3, paramInt2, localjys));
      return;
      this.aUa = paramInt1;
      this.aUb = paramAdvertisementInfo.mAdKdPos;
    }
  }
  
  private void b(VideoInfo paramVideoInfo, int paramInt)
  {
    this.g.put(paramInt, true);
    this.ar.put(paramInt, paramVideoInfo);
    this.a.notifyItemChanged(paramInt);
  }
  
  private void j(AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo = a(paramAdvertisementInfo, true);
    this.aq.put(this.aUa, paramAdvertisementInfo);
    this.aUa = 0;
  }
  
  private void k(AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo = a(paramAdvertisementInfo, false);
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) && (this.a != null) && ((this.aUc < this.mDataList.size()) || (this.aUc <= 0)))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.mDataList.get(this.aUc);
      int i = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.qa();
      this.ln.add(paramAdvertisementInfo);
      if ((localVideoInfo != null) && (!localVideoInfo.isAD) && (this.aUc > i))
      {
        this.ln.remove(paramAdvertisementInfo);
        this.mDataList.add(this.aUc, paramAdvertisementInfo);
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "onAsyncDataReady add at =" + this.aUc + ", currentAdpaterPosition=" + i);
        }
        this.a.notifyItemInserted(this.aUc);
        this.aUc = 0;
      }
      if ((localVideoInfo != null) && (localVideoInfo.isAD) && (localVideoInfo.b != null) && (this.a.dX(localVideoInfo.b.We)))
      {
        this.ln.remove(paramAdvertisementInfo);
        b(paramAdvertisementInfo, this.aUc);
        this.aUc = 0;
      }
    }
  }
  
  private void qY(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "onAsyncDataReady channelID=" + paramInt);
        }
        int i;
        if (paramInt == this.aTZ)
        {
          i = this.aUd;
          this.aUd = 0;
          AdvertisementInfo localAdvertisementInfo1 = lbz.a().a(paramInt, i);
          if (localAdvertisementInfo1 == null) {
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,not get fetch data!!!??");
            }
          }
        }
        else
        {
          i = this.aUb;
          this.aUb = 0;
          continue;
        }
        lbz.a().b(paramInt, i);
      }
      finally {}
      if (paramInt == this.aTZ) {
        k(localAdvertisementInfo2);
      } else {
        j(localAdvertisementInfo2);
      }
    }
  }
  
  public VideoInfo a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "getVideoInfo");
    }
    VideoInfo localVideoInfo2 = (VideoInfo)this.aq.get(paramInt);
    VideoInfo localVideoInfo1;
    if (localVideoInfo2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,not get fetch data!!!??");
      }
      localVideoInfo1 = null;
    }
    do
    {
      return localVideoInfo1;
      localVideoInfo1 = localVideoInfo2;
    } while (!QLog.isColorLevel());
    QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,videoInfo");
    return localVideoInfo2;
  }
  
  public void a(int paramInt1, int paramInt2, VideoInfo paramVideoInfo)
  {
    int j = this.mDataList.size();
    int i = 0;
    if (i < this.mDataList.size()) {
      if ((!((VideoInfo)this.mDataList.get(i)).isAD) || (i == paramInt1)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "adapterPosition = " + paramInt1 + " ,size = " + j + " ,nextAdPosition = " + i);
      }
      sq(paramInt2);
      ss(paramInt2);
      b(paramVideoInfo, paramInt1);
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public void a(int paramInt, VideoFeedsPlayManager.b paramb, ArrayList<VideoInfo> paramArrayList)
  {
    if ((paramb == null) || (paramb.d == null) || (!this.anK)) {}
    for (;;)
    {
      return;
      if (!paramb.d.isAD)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount=" + this.aUh);
        }
        b(paramInt, paramb, paramArrayList);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("VideoAdExposureManager", 2, "onVideoStart , mPlayVmCount =" + this.aUh);
        return;
        this.aUh = 0;
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount= 0 ");
        }
      }
    }
  }
  
  public void a(VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    if (paramVideoAdInfo != null)
    {
      VideoInfo localVideoInfo = (VideoInfo)this.aq.get(paramInt);
      boolean bool1 = this.c.get(paramInt);
      boolean bool2 = this.e.get(paramInt);
      if ((!bool1) && (localVideoInfo == null) && (!bool2))
      {
        this.c.put(paramInt, true);
        paramVideoAdInfo = jzk.a(paramVideoAdInfo);
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd !!! , pos=" + paramInt);
        }
        a(paramVideoAdInfo, paramInt, this.channelID, 5);
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if ((paramVideoInfo == null) || (paramVideoInfo.b == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchChangePosAd insert wait pos = " + paramInt);
    }
    a(jzk.a(paramVideoInfo.b), paramInt, this.aTZ, 6);
  }
  
  public void a(mtg.g paramg)
  {
    try
    {
      if (this.anK)
      {
        this.anI = false;
        if ((paramg != null) && (paramg.a != null) && (paramg.a.d != null) && (paramg.a.d.isAD) && (paramg.a.d.b != null))
        {
          st(paramg.position);
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAndRecord reset notCountFlag , mPlayingVideoHolder.position=" + paramg.position);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt, ArrayList<VideoInfo> paramArrayList)
  {
    boolean bool1 = true;
    int j;
    int i;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAdPos , hasQueryParam= " + this.anJ + " ,needChangeAdPos =" + this.anK);
        }
        if (this.anJ)
        {
          boolean bool2 = this.anK;
          if (!bool2) {
            return;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAdPos enter, hasNewVideo= " + paramBoolean + " ,newSize =" + paramInt);
        }
        if ((paramBoolean) && (paramInt > 1))
        {
          j = paramArrayList.size();
          i = j - paramInt;
          paramInt = i;
          if (paramInt >= paramArrayList.size()) {
            break label735;
          }
          if ((((VideoInfo)paramArrayList.get(paramInt)).isAD) && (((VideoInfo)paramArrayList.get(paramInt)).b != null))
          {
            label176:
            if (paramInt != -1) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "checkAdPos can not find Ad !!");
            }
          }
          else
          {
            paramInt += 1;
          }
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "checkAdPos findAdIndex = " + paramInt);
    }
    VideoInfo localVideoInfo = (VideoInfo)paramArrayList.get(paramInt);
    if (!this.anJ)
    {
      this.anJ = true;
      if ((!knc.f(localVideoInfo.b)) || (!this.anL)) {
        break label740;
      }
    }
    label735:
    label740:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      int k;
      for (;;)
      {
        this.anK = paramBoolean;
        Object localObject = localVideoInfo.b.mAdExtInfo;
        try
        {
          localObject = new JSONObject((String)localObject);
          this.aUe = ((JSONObject)localObject).optInt("ad_first_pos", 3);
          this.aUf = ((JSONObject)localObject).optInt("ad_interval", 3);
          this.aUg = ((JSONObject)localObject).optInt("ad_protect_interval", 2);
          if (QLog.isColorLevel())
          {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos needChangeAdPos = " + this.anK);
            QLog.d("VideoAdExposureManager", 2, "checkAdPos ad_first_pos = " + this.aUe + ",ad_interval=" + this.aUf + ",ad_protect_interval=" + this.aUg);
          }
          if (!this.anK) {
            break;
          }
          if (this.lm.isEmpty())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VideoAdExposureManager", 2, "mInsertAdPos.isEmpty()");
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            this.anK = false;
          }
          k = ((Integer)this.lm.get(this.lm.size() - 1)).intValue();
          if ((j - 1 > k) && (k >= i))
          {
            if (paramInt == k) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "checkAdPos change findAdIndex=" + paramInt + ", lastNeedInsertAdPos=" + k);
            }
            if (k >= paramArrayList.size()) {
              break;
            }
            paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(k));
            paramArrayList.set(k, localVideoInfo);
          }
        }
      }
      if (localVideoInfo.b == null) {
        break;
      }
      i = k + this.aUg;
      if (i <= paramInt) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "checkAdPos change findAdIndex=" + paramInt + ", lastNeedInsertAdPos=" + k + ", minAdIndex=" + i);
      }
      if (i >= paramArrayList.size()) {
        break;
      }
      paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(i));
      paramArrayList.set(i, localVideoInfo);
      st(i);
      break;
      paramInt = -1;
      break label176;
    }
  }
  
  public VideoInfo b(int paramInt)
  {
    boolean bool = this.g.get(paramInt);
    VideoInfo localVideoInfo = (VideoInfo)this.ar.get(paramInt);
    if ((bool) && (localVideoInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "onAsyncDataReady replace at =" + this.aUc + ", currentAdpaterPosition=" + paramInt);
      }
      this.g.put(paramInt, false);
      this.ar.remove(paramInt);
      return localVideoInfo;
    }
    return null;
  }
  
  public void b(int paramInt, VideoFeedsPlayManager.b paramb, ArrayList<VideoInfo> paramArrayList)
  {
    boolean bool;
    label25:
    int j;
    label111:
    int k;
    label250:
    do
    {
      do
      {
        do
        {
          try
          {
            paramb = paramb.d;
            if (paramb != null)
            {
              bool = paramb.isAD;
              if (!bool) {
                break label25;
              }
            }
            for (;;)
            {
              return;
              if ((this.anK) && (!this.anI)) {
                break;
              }
              if (QLog.isColorLevel())
              {
                if (!this.anK) {
                  QLog.d("VideoAdExposureManager", 2, "命中 调整广告位置的开关关闭 ");
                }
                if (this.anI) {
                  QLog.d("VideoAdExposureManager", 2, "该位置已经 触发过判断的情况");
                }
              }
            }
            this.aUh += 1;
          }
          finally {}
          j = dv(paramInt);
          if (j == -1) {
            break;
          }
          i = 1;
          if (QLog.isColorLevel())
          {
            QLog.d("VideoAdExposureManager", 2, "nextAdPos =" + j);
            QLog.d("VideoAdExposureManager", 2, "insertAd , mPlayVmCount=" + this.aUh);
          }
        } while ((i == 0) && (paramArrayList.size() > paramInt + 1) && (((VideoInfo)paramArrayList.get(paramInt + 1)).isAD));
        k = du(paramInt);
        if ((k == -1) && (paramInt < this.aUe) && (this.aUh >= this.aUe)) {
          break;
        }
        if (this.aUh < this.aUf) {
          break label798;
        }
        break;
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "isCountEnough =" + bool + ",position =" + paramInt + ",lastAdPos1 =" + k);
        }
      } while (!bool);
      this.aUh = 0;
      this.anI = true;
      if (i != 0) {
        break label631;
      }
      k = du(paramInt);
      if (k != -1) {
        break;
      }
      j = paramInt + 1;
      st(j);
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , lastAdPos =" + k + " ，recordAdPos =" + j);
      }
    } while (j >= paramArrayList.size());
    label342:
    int i = paramInt;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        if (!((VideoInfo)paramArrayList.get(i)).isAD) {}
      }
      else
      {
        for (;;)
        {
          paramb = null;
          if (i == -1) {
            if (this.ln.size() > 0)
            {
              paramb = (VideoInfo)this.ln.get(0);
              this.ln.remove(0);
            }
          }
          for (;;)
          {
            if ((paramb != null) || (k == -1) || (k >= paramArrayList.size())) {
              break label587;
            }
            a((VideoInfo)paramArrayList.get(k), j);
            break;
            j = Math.max(this.aUg + k + 1, paramInt + 1);
            break label342;
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , findPos =" + i + " ，startPos =" + paramInt);
            }
            paramb = (VideoInfo)paramArrayList.get(i);
            paramArrayList.remove(i);
          }
          label587:
          if (paramb == null) {
            break;
          }
          paramArrayList.add(j, paramb);
          if (this.a != null) {
            this.a.i(paramb);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , move!!! and notify!!! ");
          break;
          label631:
          if (j >= paramArrayList.size()) {
            break;
          }
          paramb = (VideoInfo)paramArrayList.get(j);
          if ((paramb == null) || (!paramb.isAD) || (paramb.b == null) || (this.a == null) || (!this.a.dX(paramb.b.We))) {
            break;
          }
          VideoInfo localVideoInfo = (VideoInfo)this.ar.get(j);
          paramb = localVideoInfo;
          if (localVideoInfo == null)
          {
            paramb = localVideoInfo;
            if (this.ln.size() > 0)
            {
              paramb = (VideoInfo)this.ln.get(0);
              this.ln.remove(0);
            }
          }
          if (paramb != null)
          {
            b(paramb, j);
            break;
          }
          a((VideoInfo)paramArrayList.get(j), j);
          break;
          i = -1;
        }
        bool = true;
        break label250;
        i = 0;
        break label111;
        label798:
        bool = false;
        break label250;
      }
      i += 1;
    }
  }
  
  public boolean dU(int paramInt)
  {
    boolean bool = this.d.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "isNeedShowAnotherAd pos=" + paramInt + ",result =" + bool);
    }
    return bool;
  }
  
  public void doOnDestory()
  {
    lhb locallhb = lbz.a().a();
    if (locallhb != null)
    {
      locallhb.rd(this.channelID);
      locallhb.rd(this.aTZ);
    }
  }
  
  public int du(int paramInt)
  {
    int j = -1;
    int i = 0;
    while (i < this.lm.size())
    {
      Integer localInteger = (Integer)this.lm.get(i);
      if (localInteger.intValue() >= paramInt) {
        break;
      }
      j = localInteger.intValue();
      i += 1;
    }
    return j;
  }
  
  public int dv(int paramInt)
  {
    int i = 0;
    while (i < this.lm.size())
    {
      Integer localInteger = (Integer)this.lm.get(i);
      if (localInteger.intValue() > paramInt) {
        return localInteger.intValue();
      }
      i += 1;
    }
    return -1;
  }
  
  public void ob(boolean paramBoolean)
  {
    this.anL = paramBoolean;
  }
  
  public void sq(int paramInt)
  {
    this.d.put(paramInt, true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "hasShowAnotherAd");
    }
  }
  
  public void sr(int paramInt)
  {
    if ((VideoInfo)this.aq.get(paramInt) == null) {
      this.c.put(paramInt, false);
    }
  }
  
  public void ss(int paramInt)
  {
    this.aq.remove(paramInt);
    this.e.put(paramInt, true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "removeCacheVideoInfo ");
    }
  }
  
  public void st(int paramInt)
  {
    try
    {
      if (!this.lm.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "recordAdPos recordAdPos=" + paramInt);
        }
        this.lm.add(Integer.valueOf(paramInt));
      }
      return;
    }
    finally {}
  }
  
  public static final class a
    implements lhw.a
  {
    private WeakReference<mss> co;
    
    public a(mss parammss)
    {
      this.co = new WeakReference(parammss);
    }
    
    public void rc(int paramInt)
    {
      if (this.co != null)
      {
        mss localmss = (mss)this.co.get();
        if ((localmss != null) && (mss.a(localmss) != null)) {
          mss.a(localmss).post(new VideoAdExposureManager.PosListener.1(this, localmss, paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mss
 * JD-Core Version:    0.7.0.1
 */
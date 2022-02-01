import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager.1;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ulq
{
  private int jdField_a_of_type_Int = 78888888;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<VideoInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private qfo jdField_a_of_type_Qfo;
  private shl jdField_a_of_type_Shl;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 78888889;
  private SparseArray<VideoInfo> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_b_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private SparseBooleanArray jdField_c_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private int jdField_d_of_type_Int;
  private SparseBooleanArray jdField_d_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private int e;
  private int f;
  private int g = 1;
  
  public ulq(shl paramshl, List<VideoInfo> paramList, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, Handler paramHandler)
  {
    this.jdField_a_of_type_Shl = paramshl;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    pkh.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    this.jdField_a_of_type_Qfo = new ulr(this);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -1) {
      return paramInt1 + 1;
    }
    return Math.max(uls.h + paramInt2 + 1, paramInt1 + 1);
  }
  
  public static VideoInfo a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    int i = 0;
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_c_of_type_Boolean = true;
    localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = ois.a(paramAdvertisementInfo);
    localVideoInfo.jdField_a_of_type_Int = 5;
    localVideoInfo.l = paramAdvertisementInfo.mJsonVideoList;
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList))
      {
        localObject = pqa.a(paramAdvertisementInfo.mJsonVideoList, paramAdvertisementInfo);
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
        localVideoInfo.jdField_b_of_type_JavaLangString = paramAdvertisementInfo.mVideoCoverUrl.toString();
        localVideoInfo.jdField_c_of_type_JavaLangString = paramAdvertisementInfo.mTitle;
        localVideoInfo.jdField_a_of_type_JavaLangString = paramAdvertisementInfo.mVideoVid;
        localVideoInfo.r = paramAdvertisementInfo.mAdVideoUrl;
        localVideoInfo.j = paramAdvertisementInfo.mSubscribeID;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.mSubscribeName)) {
          break label360;
        }
        localVideoInfo.k = paramAdvertisementInfo.mAdCorporateImageName;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.thirdIcon)) {
          break label371;
        }
        localVideoInfo.p = paramAdvertisementInfo.mAdCorporateLogo;
        if (TextUtils.isEmpty(localVideoInfo.l)) {
          localVideoInfo.jdField_a_of_type_JavaLangString = localVideoInfo.r;
        }
        if (paramBoolean)
        {
          localObject = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
          if (paramBoolean) {
            i = 1;
          }
          ((VideoAdInfo)localObject).q = i;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "videoinfo = " + localVideoInfo.b());
        }
        if (paramAdvertisementInfo.mVideoJsonWidth != 0) {
          break label382;
        }
        i = 540;
        localVideoInfo.jdField_b_of_type_Int = i;
        if (paramAdvertisementInfo.mVideoJsonHeight != 0) {
          break label390;
        }
        i = 960;
        localVideoInfo.jdField_c_of_type_Int = i;
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.d = true;
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
          localVideoInfo.jdField_b_of_type_JavaLangString = paramAdvertisementInfo.mAdImg;
          continue;
          label360:
          localVideoInfo.k = paramAdvertisementInfo.mSubscribeName;
          continue;
          label371:
          localVideoInfo.p = paramAdvertisementInfo.thirdIcon;
          continue;
          label382:
          i = paramAdvertisementInfo.mVideoJsonWidth;
          continue;
          label390:
          i = paramAdvertisementInfo.mVideoJsonHeight;
        }
      }
    }
  }
  
  private void a(int paramInt, ArrayList<VideoInfo> paramArrayList)
  {
    int j = a(paramInt);
    int k = a(paramInt, j);
    d(k);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , lastAdPos =" + j + " ，recordAdPos =" + k);
    }
    if (k >= paramArrayList.size()) {
      return;
    }
    int i = paramInt;
    if (i < paramArrayList.size()) {
      if (!((VideoInfo)paramArrayList.get(i)).jdField_c_of_type_Boolean) {}
    }
    for (;;)
    {
      VideoInfo localVideoInfo = null;
      if (i == -1) {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          localVideoInfo = (VideoInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0);
          this.jdField_b_of_type_JavaUtilArrayList.remove(0);
        }
      }
      for (;;)
      {
        if ((localVideoInfo != null) || (j == -1) || (j >= paramArrayList.size())) {
          break label253;
        }
        ukq.a("VIDEO_LINK", "fetchChangePosAd : 当前广告位置后面没有广告");
        a((VideoInfo)paramArrayList.get(j), k);
        return;
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , findPos =" + i + " ，startPos =" + paramInt);
        }
        localVideoInfo = (VideoInfo)paramArrayList.get(i);
        paramArrayList.remove(i);
      }
      label253:
      a(localVideoInfo, paramArrayList, k);
      return;
      i = -1;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    if (paramVideoInfo == null) {}
    do
    {
      return;
      paramArrayList.add(paramInt, paramVideoInfo);
      if (this.jdField_a_of_type_Shl != null) {
        this.jdField_a_of_type_Shl.a(paramVideoInfo);
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , move!!! and notify!!! ");
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo = a(paramAdvertisementInfo, true);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_c_of_type_Int, paramAdvertisementInfo);
    this.jdField_c_of_type_Int = 0;
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if (paramInt2 == this.jdField_b_of_type_Int)
    {
      this.e = paramInt1;
      this.f = paramAdvertisementInfo.mAdKdPos;
    }
    for (;;)
    {
      oha localoha = new oha();
      localoha.jdField_a_of_type_Int = paramAdvertisementInfo.mAdMaterialId;
      localoha.jdField_b_of_type_Int = 1;
      localoha.jdField_c_of_type_Int = paramAdvertisementInfo.mAdKdPos;
      localoha.jdField_a_of_type_Long = paramAdvertisementInfo.mAdPosID;
      localoha.jdField_a_of_type_Boolean = true;
      pvj.a().a().a(paramInt2, this.jdField_a_of_type_Qfo);
      ThreadManager.executeOnSubThread(new VideoAdExposureManager.1(this, paramInt3, paramInt2, localoha));
      return;
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramAdvertisementInfo.mAdKdPos;
    }
  }
  
  private void a(ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    if (paramInt >= paramArrayList.size()) {}
    do
    {
      return;
      localObject = (VideoInfo)paramArrayList.get(paramInt);
    } while ((localObject == null) || (!((VideoInfo)localObject).jdField_c_of_type_Boolean) || (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (this.jdField_a_of_type_Shl == null) || (!this.jdField_a_of_type_Shl.a(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h)));
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localVideoInfo;
    if (localVideoInfo == null)
    {
      localObject = localVideoInfo;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject = (VideoInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        this.jdField_b_of_type_JavaUtilArrayList.remove(0);
      }
    }
    if (localObject != null)
    {
      b((VideoInfo)localObject, paramInt);
      return;
    }
    ukq.a("VIDEO_LINK", "fetchChangePosAd : 下一个广告存在但是已经曝光过");
    a((VideoInfo)paramArrayList.get(paramInt), paramInt);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == -1) && (paramInt2 < uls.f) && (this.g >= uls.f)) || (this.g >= uls.g);
  }
  
  private boolean a(skq paramskq)
  {
    if ((uls.a()) && (uls.b())) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramskq = paramskq.a;
        } while ((paramskq == null) || (paramskq.jdField_c_of_type_Boolean));
        if ((uls.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      if (!uls.jdField_a_of_type_Boolean) {
        QLog.d("VideoAdExposureManager", 2, "命中 调整广告位置的开关关闭 ");
      }
    } while (!this.jdField_a_of_type_Boolean);
    QLog.d("VideoAdExposureManager", 2, "该位置已经 触发过判断的情况");
    return false;
    return true;
  }
  
  private void b(VideoInfo paramVideoInfo, int paramInt)
  {
    if ((uls.a()) && (uls.b())) {
      return;
    }
    this.jdField_d_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramVideoInfo);
    this.jdField_a_of_type_Shl.notifyItemChanged(paramInt);
  }
  
  private void b(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((uls.a()) && (uls.b())) {}
    VideoInfo localVideoInfo;
    do
    {
      do
      {
        return;
        paramAdvertisementInfo = a(paramAdvertisementInfo, false);
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) || (this.jdField_a_of_type_Shl == null) || ((this.e >= this.jdField_a_of_type_JavaUtilList.size()) && (this.e > 0)));
      localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.e);
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
      this.jdField_b_of_type_JavaUtilArrayList.add(paramAdvertisementInfo);
      if ((localVideoInfo != null) && (!localVideoInfo.jdField_c_of_type_Boolean) && (this.e > i))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramAdvertisementInfo);
        this.jdField_a_of_type_JavaUtilList.add(this.e, paramAdvertisementInfo);
        ukq.a("AdVideoDataLink", "onAsyncDataReady add at =" + this.e + ", currentAdpaterPosition=" + i);
        this.jdField_a_of_type_Shl.notifyItemInserted(this.e);
        this.e = 0;
      }
    } while ((localVideoInfo == null) || (!localVideoInfo.jdField_c_of_type_Boolean) || (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (!this.jdField_a_of_type_Shl.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h)));
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramAdvertisementInfo);
    b(paramAdvertisementInfo, this.e);
    this.e = 0;
  }
  
  private void e(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "onAsyncDataReady channelID=" + paramInt);
        }
        int i;
        if (paramInt == this.jdField_b_of_type_Int)
        {
          i = this.f;
          this.f = 0;
          AdvertisementInfo localAdvertisementInfo1 = pvj.a().a(paramInt, i);
          if (localAdvertisementInfo1 == null) {
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,not get fetch data!!!??");
            }
          }
        }
        else
        {
          i = this.jdField_d_of_type_Int;
          this.jdField_d_of_type_Int = 0;
          continue;
        }
        pvj.a().b(paramInt, i);
      }
      finally {}
      if (paramInt == this.jdField_b_of_type_Int) {
        b(localAdvertisementInfo2);
      } else {
        a(localAdvertisementInfo2);
      }
    }
  }
  
  public int a(int paramInt)
  {
    int j = -1;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localInteger.intValue() >= paramInt) {
        break;
      }
      j = localInteger.intValue();
      i += 1;
    }
    return j;
  }
  
  public VideoInfo a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "getVideoInfo");
    }
    VideoInfo localVideoInfo2 = (VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
  
  public void a()
  {
    qel localqel = pvj.a().a();
    if (localqel != null)
    {
      localqel.a(this.jdField_a_of_type_Int);
      localqel.a(this.jdField_b_of_type_Int);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "hasShowAnotherAd");
    }
  }
  
  public void a(int paramInt1, int paramInt2, VideoInfo paramVideoInfo)
  {
    if ((uls.a()) && (uls.b())) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((!((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_c_of_type_Boolean) || (i == paramInt1)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "adapterPosition = " + paramInt1 + " ,size = " + j + " ,nextAdPosition = " + i);
      }
      a(paramInt2);
      c(paramInt2);
      b(paramVideoInfo, paramInt1);
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public void a(int paramInt, skq paramskq, ArrayList<VideoInfo> paramArrayList)
  {
    if ((uls.a()) && (uls.b())) {}
    for (;;)
    {
      return;
      if ((paramskq != null) && (paramskq.a != null) && (uls.jdField_a_of_type_Boolean))
      {
        if (!paramskq.a.jdField_c_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount=" + this.g);
          }
          b(paramInt, paramskq, paramArrayList);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("VideoAdExposureManager", 2, "onVideoStart , mPlayVmCount =" + this.g);
          return;
          this.g = 0;
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount= 0 ");
          }
        }
      }
    }
  }
  
  public void a(VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    if ((uls.a()) && (uls.b())) {}
    VideoInfo localVideoInfo;
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (paramVideoAdInfo == null);
      localVideoInfo = (VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      bool1 = this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
      bool2 = this.jdField_c_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    } while ((bool1) || (localVideoInfo != null) || (bool2));
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    paramVideoAdInfo = ois.a(paramVideoAdInfo);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd !!! , pos=" + paramInt);
    }
    a(paramVideoAdInfo, paramInt, this.jdField_a_of_type_Int, 5);
  }
  
  public void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if ((uls.a()) && (uls.b())) {}
    while ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchChangePosAd insert wait pos = " + paramInt);
    }
    a(ois.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo), paramInt, this.jdField_b_of_type_Int, 6);
  }
  
  /* Error */
  public void a(swm paramswm)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 403	uls:a	()Z
    //   5: ifeq +14 -> 19
    //   8: invokestatic 405	uls:b	()Z
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: getstatic 411	uls:jdField_a_of_type_Boolean	Z
    //   22: ifeq -6 -> 16
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 412	ulq:jdField_a_of_type_Boolean	Z
    //   30: aload_1
    //   31: ifnull -15 -> 16
    //   34: aload_1
    //   35: getfield 506	swm:a	Lskq;
    //   38: ifnull -22 -> 16
    //   41: aload_1
    //   42: getfield 506	swm:a	Lskq;
    //   45: getfield 410	skq:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   48: ifnull -32 -> 16
    //   51: aload_1
    //   52: getfield 506	swm:a	Lskq;
    //   55: getfield 410	skq:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   58: getfield 117	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_Boolean	Z
    //   61: ifeq -45 -> 16
    //   64: aload_1
    //   65: getfield 506	swm:a	Lskq;
    //   68: getfield 410	skq:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   71: getfield 125	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   74: ifnull -58 -> 16
    //   77: aload_0
    //   78: aload_1
    //   79: getfield 507	swm:jdField_b_of_type_Int	I
    //   82: invokevirtual 275	ulq:d	(I)V
    //   85: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq -72 -> 16
    //   91: ldc 238
    //   93: iconst_2
    //   94: new 240	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 509
    //   104: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: getfield 507	swm:jdField_b_of_type_Int	I
    //   111: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: goto -104 -> 16
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	ulq
    //   0	128	1	paramswm	swm
    //   11	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	123	finally
    //   19	30	123	finally
    //   34	120	123	finally
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt, ArrayList<VideoInfo> paramArrayList)
  {
    boolean bool1 = false;
    for (;;)
    {
      int j;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAdPos , hasQueryParam= " + uls.jdField_b_of_type_Boolean + " ,needChangeAdPos =" + uls.jdField_a_of_type_Boolean);
        }
        if (uls.jdField_b_of_type_Boolean)
        {
          boolean bool2 = uls.jdField_a_of_type_Boolean;
          if (!bool2) {
            return;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAdPos enter, hasNewVideo= " + paramBoolean + " ,newSize =" + paramInt);
        }
        if ((!paramBoolean) || (paramInt <= 1)) {
          continue;
        }
        j = paramArrayList.size();
        i = j - paramInt;
        paramInt = i;
        if (paramInt >= paramArrayList.size()) {
          break label967;
        }
        if ((((VideoInfo)paramArrayList.get(paramInt)).jdField_c_of_type_Boolean) && (((VideoInfo)paramArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
        {
          if (paramInt != -1) {
            break label210;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos can not find Ad !!");
          }
          uls.a();
          continue;
        }
        paramInt += 1;
      }
      finally {}
      continue;
      label210:
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "checkAdPos findAdIndex = " + paramInt);
      }
      VideoInfo localVideoInfo = (VideoInfo)paramArrayList.get(paramInt);
      Object localObject;
      if (!uls.jdField_b_of_type_Boolean)
      {
        uls.jdField_b_of_type_Boolean = true;
        paramBoolean = bool1;
        if (ukr.f(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          paramBoolean = bool1;
          if (this.jdField_b_of_type_Boolean) {
            paramBoolean = true;
          }
        }
        uls.jdField_a_of_type_Boolean = paramBoolean;
        localObject = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v;
      }
      label724:
      int k;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("strategy"))
        {
          uls.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("strategy", 0);
          if (uls.jdField_a_of_type_Int == 3) {
            uls.jdField_c_of_type_Boolean = true;
          }
        }
        for (;;)
        {
          uls.f = ((JSONObject)localObject).optInt("ad_first_pos", 3);
          uls.g = ((JSONObject)localObject).optInt("ad_interval", 3);
          uls.h = ((JSONObject)localObject).optInt("ad_protect_interval", 2);
          uls.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("ad_first_time", 10);
          uls.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("ad_interval_time", 25);
          uls.jdField_d_of_type_Int = ((JSONObject)localObject).optInt("ad_pre_req", 2);
          uls.e = ((JSONObject)localObject).optInt("ad_protect_gap", 2);
          uls.i = ((JSONObject)localObject).optInt("first_stay_time", 3);
          if ((uls.jdField_a_of_type_Int == 3) && (uls.jdField_b_of_type_Int < uls.i)) {
            uls.jdField_a_of_type_Int = 2;
          }
          ukq.a("VideoAdStrategy", "setAdStrategyFromServer: strategy = " + uls.jdField_a_of_type_Int + " adFirstTime = " + uls.jdField_b_of_type_Int + " adIntervalTime = " + uls.jdField_c_of_type_Int + " adPreReq = " + uls.jdField_d_of_type_Int + " adProtectGap = " + uls.e + " adFirstPos = " + uls.f + " adIntervalPos = " + uls.g + " adProtectInterval = " + uls.h);
          uls.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
          if (uls.jdField_a_of_type_Int == 1)
          {
            localObject = ult.a(paramArrayList);
            if (localObject != null) {
              paramArrayList.removeAll((Collection)localObject);
            }
          }
          if (uls.jdField_a_of_type_Int == 3) {
            ult.a(paramArrayList);
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos needChangeAdPos = " + uls.jdField_a_of_type_Boolean);
          }
          if (((uls.a()) && (uls.b())) || (!uls.jdField_a_of_type_Boolean)) {
            break;
          }
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            break label724;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VideoAdExposureManager", 2, "mInsertAdPos.isEmpty()");
          break;
          uls.jdField_a_of_type_Int = 2;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          uls.jdField_a_of_type_Boolean = false;
        }
        k = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).intValue();
        if ((j - 1 > k) && (k >= i))
        {
          if (paramInt == k) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos change findAdIndex=" + paramInt + ", lastNeedInsertAdPos=" + k);
          }
          if (k >= paramArrayList.size()) {
            continue;
          }
          paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(k));
          paramArrayList.set(k, localVideoInfo);
        }
      }
      if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)
      {
        i = k + uls.h;
        if (i > paramInt)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos change findAdIndex=" + paramInt + ", lastNeedInsertAdPos=" + k + ", minAdIndex=" + i);
          }
          if (i < paramArrayList.size())
          {
            paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(i));
            paramArrayList.set(i, localVideoInfo);
            d(i);
            continue;
            label967:
            paramInt = -1;
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = this.jdField_b_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "isNeedShowAnotherAd pos=" + paramInt + ",result =" + bool);
    }
    return bool;
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localInteger.intValue() > paramInt) {
        return localInteger.intValue();
      }
      i += 1;
    }
    return -1;
  }
  
  public VideoInfo b(int paramInt)
  {
    if ((uls.a()) && (uls.b())) {
      return null;
    }
    boolean bool = this.jdField_d_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((bool) && (localVideoInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "onAsyncDataReady replace at =" + this.e + ", currentAdpaterPosition=" + paramInt);
      }
      this.jdField_d_of_type_AndroidUtilSparseBooleanArray.put(paramInt, false);
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(paramInt);
      return localVideoInfo;
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    if ((uls.a()) && (uls.b())) {}
    while ((VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      return;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, false);
  }
  
  public void b(int paramInt, skq paramskq, ArrayList<VideoInfo> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        boolean bool = a(paramskq);
        if (!bool) {
          return;
        }
        this.g += 1;
        int j = b(paramInt);
        if (j != -1) {
          i = 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "nextAdPos =" + j + ", insertAd , mPlayVmCount=" + this.g);
        }
        if ((i != 0) || (paramArrayList.size() <= paramInt + 1) || (!((VideoInfo)paramArrayList.get(paramInt + 1)).jdField_c_of_type_Boolean))
        {
          int k = a(paramInt);
          bool = a(k, paramInt);
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "isCountEnough =" + bool + ",position =" + paramInt + ",lastAdPos1 =" + k);
          }
          if (bool)
          {
            this.g = 0;
            this.jdField_a_of_type_Boolean = true;
            if (i == 0) {
              a(paramInt, paramArrayList);
            } else {
              a(paramArrayList, j);
            }
          }
        }
      }
      finally {}
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    this.jdField_c_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "removeCacheVideoInfo ");
    }
  }
  
  /* Error */
  public void d(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 403	uls:a	()Z
    //   5: ifeq +14 -> 19
    //   8: invokestatic 405	uls:b	()Z
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 57	ulq:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   23: iload_1
    //   24: invokestatic 669	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokevirtual 672	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   30: ifne -14 -> 16
    //   33: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +29 -> 65
    //   39: ldc 238
    //   41: iconst_2
    //   42: new 240	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 674
    //   52: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: iload_1
    //   56: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_0
    //   66: getfield 57	ulq:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   69: iload_1
    //   70: invokestatic 669	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 433	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   76: pop
    //   77: goto -61 -> 16
    //   80: astore_3
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	ulq
    //   0	85	1	paramInt	int
    //   11	2	2	bool	boolean
    //   80	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	80	finally
    //   19	65	80	finally
    //   65	77	80	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulq
 * JD-Core Version:    0.7.0.1
 */
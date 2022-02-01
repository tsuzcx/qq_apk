import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager.1;
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

public class txu
{
  private int jdField_a_of_type_Int = 78888888;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<VideoInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private puu jdField_a_of_type_Puu;
  private ruw jdField_a_of_type_Ruw;
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
  
  public txu(ruw paramruw, List<VideoInfo> paramList, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, Handler paramHandler)
  {
    this.jdField_a_of_type_Ruw = paramruw;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    pay.a().getManager(163);
    this.jdField_a_of_type_Puu = new txv(this);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -1) {
      return paramInt1 + 1;
    }
    return Math.max(txw.h + paramInt2 + 1, paramInt1 + 1);
  }
  
  public static VideoInfo a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    int i = 0;
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_c_of_type_Boolean = true;
    localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = obb.a(paramAdvertisementInfo);
    localVideoInfo.jdField_a_of_type_Int = 5;
    localVideoInfo.l = paramAdvertisementInfo.mJsonVideoList;
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList))
      {
        localObject = pay.a(paramAdvertisementInfo.mJsonVideoList, paramAdvertisementInfo);
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
        twp.a("VIDEO_LINK", "fetchChangePosAd : 当前广告位置后面没有广告");
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
      if (this.jdField_a_of_type_Ruw != null) {
        this.jdField_a_of_type_Ruw.b(paramVideoInfo);
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
      oaa localoaa = new oaa();
      localoaa.jdField_a_of_type_Int = paramAdvertisementInfo.mAdMaterialId;
      localoaa.jdField_b_of_type_Int = 1;
      localoaa.jdField_c_of_type_Int = paramAdvertisementInfo.mAdKdPos;
      localoaa.jdField_a_of_type_Long = paramAdvertisementInfo.mAdPosID;
      pkm.a().a().a(paramInt2, this.jdField_a_of_type_Puu);
      ThreadManager.executeOnSubThread(new VideoAdExposureManager.1(this, paramInt3, paramInt2, localoaa));
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
    } while ((localObject == null) || (!((VideoInfo)localObject).jdField_c_of_type_Boolean) || (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (this.jdField_a_of_type_Ruw == null) || (!this.jdField_a_of_type_Ruw.a(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h)));
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
    twp.a("VIDEO_LINK", "fetchChangePosAd : 下一个广告存在但是已经曝光过");
    a((VideoInfo)paramArrayList.get(paramInt), paramInt);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == -1) && (paramInt2 < txw.f) && (this.g >= txw.f)) || (this.g >= txw.g);
  }
  
  private boolean a(ryo paramryo)
  {
    if (txw.a()) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramryo = paramryo.a;
        } while ((paramryo == null) || (paramryo.jdField_c_of_type_Boolean));
        if ((txw.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      if (!txw.jdField_a_of_type_Boolean) {
        QLog.d("VideoAdExposureManager", 2, "命中 调整广告位置的开关关闭 ");
      }
    } while (!this.jdField_a_of_type_Boolean);
    QLog.d("VideoAdExposureManager", 2, "该位置已经 触发过判断的情况");
    return false;
    return true;
  }
  
  private void b(VideoInfo paramVideoInfo, int paramInt)
  {
    if (txw.a()) {
      return;
    }
    this.jdField_d_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramVideoInfo);
    this.jdField_a_of_type_Ruw.notifyItemChanged(paramInt);
  }
  
  private void b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (txw.a()) {}
    VideoInfo localVideoInfo;
    do
    {
      do
      {
        return;
        paramAdvertisementInfo = a(paramAdvertisementInfo, false);
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) || (this.jdField_a_of_type_Ruw == null) || ((this.e >= this.jdField_a_of_type_JavaUtilList.size()) && (this.e > 0)));
      localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.e);
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
      this.jdField_b_of_type_JavaUtilArrayList.add(paramAdvertisementInfo);
      if ((localVideoInfo != null) && (!localVideoInfo.jdField_c_of_type_Boolean) && (this.e > i))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramAdvertisementInfo);
        this.jdField_a_of_type_JavaUtilList.add(this.e, paramAdvertisementInfo);
        twp.a("AdVideoDataLink", "onAsyncDataReady add at =" + this.e + ", currentAdpaterPosition=" + i);
        this.jdField_a_of_type_Ruw.notifyItemInserted(this.e);
        this.e = 0;
      }
    } while ((localVideoInfo == null) || (!localVideoInfo.jdField_c_of_type_Boolean) || (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (!this.jdField_a_of_type_Ruw.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h)));
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
          AdvertisementInfo localAdvertisementInfo1 = pkm.a().a(paramInt, i);
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
        pkm.a().b(paramInt, i);
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
    pto localpto = pkm.a().a();
    if (localpto != null)
    {
      localpto.a(this.jdField_a_of_type_Int);
      localpto.a(this.jdField_b_of_type_Int);
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
    if (txw.a()) {
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
  
  public void a(int paramInt, ryo paramryo, ArrayList<VideoInfo> paramArrayList)
  {
    if (txw.a()) {}
    for (;;)
    {
      return;
      if ((paramryo != null) && (paramryo.a != null) && (txw.jdField_a_of_type_Boolean))
      {
        if (!paramryo.a.jdField_c_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount=" + this.g);
          }
          b(paramInt, paramryo, paramArrayList);
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
    if (txw.a()) {}
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
    paramVideoAdInfo = obb.a(paramVideoAdInfo);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd !!! , pos=" + paramInt);
    }
    a(paramVideoAdInfo, paramInt, this.jdField_a_of_type_Int, 5);
  }
  
  public void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if (txw.a()) {}
    while ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchChangePosAd insert wait pos = " + paramInt);
    }
    a(obb.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo), paramInt, this.jdField_b_of_type_Int, 6);
  }
  
  /* Error */
  public void a(rvn paramrvn)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 394	txw:a	()Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: getstatic 401	txw:jdField_a_of_type_Boolean	Z
    //   16: ifeq -6 -> 10
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 402	txu:jdField_a_of_type_Boolean	Z
    //   24: aload_1
    //   25: ifnull -15 -> 10
    //   28: aload_1
    //   29: getfield 496	rvn:a	Lryo;
    //   32: ifnull -22 -> 10
    //   35: aload_1
    //   36: getfield 496	rvn:a	Lryo;
    //   39: getfield 399	ryo:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   42: ifnull -32 -> 10
    //   45: aload_1
    //   46: getfield 496	rvn:a	Lryo;
    //   49: getfield 399	ryo:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   52: getfield 112	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_Boolean	Z
    //   55: ifeq -45 -> 10
    //   58: aload_1
    //   59: getfield 496	rvn:a	Lryo;
    //   62: getfield 399	ryo:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   65: getfield 120	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   68: ifnull -58 -> 10
    //   71: aload_0
    //   72: aload_1
    //   73: getfield 497	rvn:jdField_b_of_type_Int	I
    //   76: invokevirtual 268	txu:d	(I)V
    //   79: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq -72 -> 10
    //   85: ldc 231
    //   87: iconst_2
    //   88: new 233	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 499
    //   98: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_1
    //   102: getfield 497	rvn:jdField_b_of_type_Int	I
    //   105: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: goto -104 -> 10
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	txu
    //   0	122	1	paramrvn	rvn
    //   5	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	6	117	finally
    //   13	24	117	finally
    //   28	114	117	finally
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
          QLog.d("VideoAdExposureManager", 2, "checkAdPos , hasQueryParam= " + txw.jdField_b_of_type_Boolean + " ,needChangeAdPos =" + txw.jdField_a_of_type_Boolean);
        }
        if (txw.jdField_b_of_type_Boolean)
        {
          boolean bool2 = txw.jdField_a_of_type_Boolean;
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
          break label906;
        }
        if ((((VideoInfo)paramArrayList.get(paramInt)).jdField_c_of_type_Boolean) && (((VideoInfo)paramArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
        {
          if (paramInt != -1) {
            break label210;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos can not find Ad !!");
          }
          txw.a();
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
      if (!txw.jdField_b_of_type_Boolean)
      {
        txw.jdField_b_of_type_Boolean = true;
        paramBoolean = bool1;
        if (twq.f(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          paramBoolean = bool1;
          if (this.jdField_b_of_type_Boolean) {
            paramBoolean = true;
          }
        }
        txw.jdField_a_of_type_Boolean = paramBoolean;
        localObject = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v;
      }
      label663:
      int k;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("strategy")) {}
        for (txw.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("strategy", 0);; txw.jdField_a_of_type_Int = 2)
        {
          txw.f = ((JSONObject)localObject).optInt("ad_first_pos", 3);
          txw.g = ((JSONObject)localObject).optInt("ad_interval_pos", 3);
          txw.h = ((JSONObject)localObject).optInt("ad_protect_interval", 2);
          txw.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("ad_first_time", 10);
          txw.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("ad_interval_time", 25);
          txw.jdField_d_of_type_Int = ((JSONObject)localObject).optInt("ad_pre_req", 2);
          txw.e = ((JSONObject)localObject).optInt("ad_protect_gap", 2);
          twp.a("VideoAdStrategy", "setAdStrategyFromServer: strategy = " + txw.jdField_a_of_type_Int + " adFirstTime = " + txw.jdField_b_of_type_Int + " adIntervalTime = " + txw.jdField_c_of_type_Int + " adPreReq = " + txw.jdField_d_of_type_Int + " adProtectGap = " + txw.e + " adFirstPos = " + txw.f + " adIntervalPos = " + txw.g + " adProtectInterval = " + txw.h);
          txw.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
          if (txw.jdField_a_of_type_Int == 1)
          {
            localObject = txx.a(paramArrayList);
            if (localObject != null) {
              paramArrayList.removeAll((Collection)localObject);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos needChangeAdPos = " + txw.jdField_a_of_type_Boolean);
          }
          if ((txw.a()) || (!txw.jdField_a_of_type_Boolean)) {
            break;
          }
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            break label663;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VideoAdExposureManager", 2, "mInsertAdPos.isEmpty()");
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          txw.jdField_a_of_type_Boolean = false;
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
        i = k + txw.h;
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
            label906:
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
    if (txw.a()) {
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
    if (txw.a()) {}
    while ((VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      return;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, false);
  }
  
  public void b(int paramInt, ryo paramryo, ArrayList<VideoInfo> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        boolean bool = a(paramryo);
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
    //   2: invokestatic 394	txw:a	()Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: getfield 57	txu:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: iload_1
    //   18: invokestatic 653	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: invokevirtual 656	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   24: ifne -14 -> 10
    //   27: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +29 -> 59
    //   33: ldc 231
    //   35: iconst_2
    //   36: new 233	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 658
    //   46: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: getfield 57	txu:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   63: iload_1
    //   64: invokestatic 653	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: invokevirtual 423	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   70: pop
    //   71: goto -61 -> 10
    //   74: astore_3
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_3
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	txu
    //   0	79	1	paramInt	int
    //   5	2	2	bool	boolean
    //   74	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	74	finally
    //   13	59	74	finally
    //   59	71	74	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txu
 * JD-Core Version:    0.7.0.1
 */
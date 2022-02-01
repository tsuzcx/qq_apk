import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StFollowPageData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class ozu
{
  private static volatile ozu a;
  private boolean azc = QzoneConfig.getQQCircleEnableFolderPageCache();
  private boolean azd;
  private boolean aze;
  private ConcurrentHashMap<String, ozu.a> bJ = new ConcurrentHashMap();
  private List<QQCircleFeedBase.StTabInfo> lq = new ArrayList();
  private List<QQCircleFeedBase.StPolyLike> ls = new ArrayList();
  private List<QQCircleBase.UserCircleInfo> lt = new ArrayList();
  private List<QQCircleBase.UserCircleInfo> mSchoolInfos = new ArrayList();
  private long zo = System.currentTimeMillis();
  private final long zp = QzoneConfig.getQQCircleFolderPageCacheLifeCycle() * 1000;
  
  private boolean HF()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.zo;
    if ((this.azc) && (l1 - l2 <= this.zp)) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static ozu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ozu();
      }
      return a;
    }
    finally {}
  }
  
  private void biH()
  {
    this.lq.clear();
    this.ls.clear();
    this.mSchoolInfos.clear();
    this.lt.clear();
  }
  
  public void a(pdy parampdy, int paramInt1, int paramInt2)
  {
    int i = 1;
    QLog.d("QCircleFolderCacheHelper", 1, "savePageCache,pos:" + paramInt1 + ",top:" + paramInt2);
    if (parampdy != null)
    {
      parampdy = ozu.a.a(parampdy, paramInt1, paramInt2);
      if (parampdy != null)
      {
        String str = ozu.a.a(parampdy).tabName.get();
        this.bJ.put(str, parampdy);
        QLog.d("QCircleFolderCacheHelper", 1, "savePageCache success！tapid:" + str);
      }
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      this.aze = (paramInt1 | this.aze);
      if (this.aze) {
        this.zo = System.currentTimeMillis();
      }
      return;
    }
  }
  
  public void a(peh parampeh)
  {
    biH();
    if (parampeh != null)
    {
      this.lq.addAll(parampeh.bm());
      this.ls.addAll(parampeh.bn());
      this.mSchoolInfos.addAll(parampeh.bo());
      this.mSchoolInfos.addAll(parampeh.bp());
    }
    if (!this.lq.isEmpty())
    {
      this.azd = true;
      this.zo = System.currentTimeMillis();
    }
  }
  
  public boolean a(pdy parampdy)
  {
    if (HF())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "checkCacheAlive cache not alive");
      return false;
    }
    if (!this.aze)
    {
      clearAllCache();
      return false;
    }
    if (parampdy != null)
    {
      Object localObject = parampdy.a();
      if (localObject != null)
      {
        localObject = ((QQCircleFeedBase.StTabInfo)localObject).tabName.get();
        if (this.bJ.containsKey(localObject))
        {
          ozu.a locala = (ozu.a)this.bJ.get(localObject);
          if (locala != null)
          {
            parampdy.a(ozu.a.a(locala), ozu.a.a(locala), ozu.a.a(locala), ozu.a.a(locala), ozu.a.a(locala));
            parampdy.dK(ozu.a.a(locala), ozu.a.b(locala));
            QLog.d("QCircleFolderCacheHelper", 1, "readPageCache success！tapid:" + (String)localObject + ",pos:" + ozu.a.a(locala) + ",top:" + ozu.a.b(locala));
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(peh parampeh)
  {
    if (HF())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "checkCacheAlive cache not alive");
      clearAllCache();
    }
    do
    {
      return false;
      if (!this.azd)
      {
        clearAllCache();
        return false;
      }
    } while (parampeh == null);
    parampeh.a(this.lq, this.ls, this.mSchoolInfos, this.lt);
    parampeh.bkk();
    return true;
  }
  
  public void clearAllCache()
  {
    biH();
    this.bJ.clear();
    this.azd = false;
    this.aze = false;
  }
  
  public static class a
  {
    private FeedCloudCommon.StCommonExt jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt;
    private QQCircleFeedBase.StFollowPageData jdField_a_of_type_QqcircleQQCircleFeedBase$StFollowPageData;
    private String arO;
    private QQCircleFeedBase.StTabInfo b;
    private boolean fV;
    private int mPos;
    private int mTopOffset;
    private ArrayList<FeedCloudMeta.StFeed> mq;
    
    public static a a(pdy parampdy, int paramInt1, int paramInt2)
    {
      if (parampdy == null)
      {
        QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!model is null");
        return null;
      }
      a locala = new a();
      QQCircleFeedBase.StTabInfo localStTabInfo = parampdy.a();
      Collection localCollection = parampdy.a();
      boolean bool = parampdy.HU();
      FeedCloudCommon.StCommonExt localStCommonExt = parampdy.a();
      String str = parampdy.mc();
      if ((localStTabInfo == null) || (localCollection == null) || (localCollection.isEmpty()) || (TextUtils.isEmpty(str)))
      {
        QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!miss key data!");
        return null;
      }
      locala.mPos = paramInt1;
      locala.mTopOffset = paramInt2;
      locala.b = localStTabInfo;
      locala.mq = new ArrayList();
      locala.mq.addAll(localCollection);
      locala.fV = bool;
      locala.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt = localStCommonExt;
      locala.arO = str;
      locala.jdField_a_of_type_QqcircleQQCircleFeedBase$StFollowPageData = ((QQCircleFeedBase.StFollowPageData)parampdy.m().getValue());
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozu
 * JD-Core Version:    0.7.0.1
 */
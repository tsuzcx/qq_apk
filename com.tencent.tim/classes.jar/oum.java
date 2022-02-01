import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class oum
{
  private static String arB;
  private static HashMap<String, FeedCloudMeta.StFeed> eT = new HashMap();
  private static HashMap<String, Integer> eU = new HashMap();
  private static List<QQCircleFeedBase.StPolyLike> lk = new ArrayList();
  private static volatile FeedCloudMeta.StUser mCurrentUser;
  private static volatile ArrayList<QQCircleBase.UserCircleInfo> mm;
  private static volatile ArrayList<QQCircleBase.UserCircleInfo> mn;
  
  static
  {
    arB = "";
    mm = new ArrayList();
    mn = new ArrayList();
  }
  
  public static FeedCloudMeta.StFeed a(String paramString)
  {
    return (FeedCloudMeta.StFeed)eT.get(paramString);
  }
  
  public static FeedCloudMeta.StUser a()
  {
    try
    {
      if (mCurrentUser == null)
      {
        if (VSNetworkHelper.a() != null) {
          VSNetworkHelper.a().a(new QCircleGetMainPageRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount()), new oun());
        }
        FeedCloudMeta.StUser localStUser = b();
        return localStUser;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return mCurrentUser;
  }
  
  public static void a(String paramString, FeedCloudMeta.StFeed paramStFeed)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramStFeed != null)) {
      eT.put(paramString, paramStFeed);
    }
  }
  
  public static void a(String paramString, Integer paramInteger)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("qcircle_fakeid_"))) {
      eU.put(paramString, paramInteger);
    }
  }
  
  public static FeedCloudMeta.StUser b()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    return localStUser;
  }
  
  public static Integer b(String paramString)
  {
    if (eU.containsKey(paramString)) {
      return (Integer)eU.get(paramString);
    }
    return Integer.valueOf(-1);
  }
  
  public static void bhI()
  {
    try
    {
      pbu.a().clearAll();
      pbz.a().clearAll();
      oue.release();
      bhJ();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void bhJ()
  {
    try
    {
      mCurrentUser = null;
      eT.clear();
      eU.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void bhK()
  {
    QCircleGetTabListRequest localQCircleGetTabListRequest = new QCircleGetTabListRequest(null);
    ouo localouo = new ouo(localQCircleGetTabListRequest);
    VSNetworkHelper.a().a(localQCircleGetTabListRequest, localouo);
  }
  
  public static void bhL()
  {
    QCircleGetTabListRequest localQCircleGetTabListRequest = new QCircleGetTabListRequest(null);
    VSNetworkHelper.a().a(localQCircleGetTabListRequest, new oup());
  }
  
  public static ArrayList<QQCircleBase.UserCircleInfo> bi()
  {
    return mm;
  }
  
  public static ArrayList<QQCircleBase.UserCircleInfo> bj()
  {
    return mn;
  }
  
  public static List<QQCircleFeedBase.StPolyLike> br()
  {
    if (lk.isEmpty())
    {
      Iterator localIterator = QCirclePolymorphicLikePopWindow.eZ.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = "qcircle_stpoly_" + (String)localIterator.next();
        localObject = aqfe.get(BaseApplicationImpl.getApplication(), (String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            localObject = (QQCircleFeedBase.StPolyLike)new QQCircleFeedBase.StPolyLike().mergeFrom(((String)localObject).getBytes());
            lk.add(localObject);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
    }
    if (lk.isEmpty()) {
      bhK();
    }
    return lk;
  }
  
  public static void dD(List<QQCircleFeedBase.StPolyLike> paramList)
  {
    lk.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleFeedBase.StPolyLike localStPolyLike1 = (QQCircleFeedBase.StPolyLike)paramList.next();
      QQCircleFeedBase.StPolyLike localStPolyLike2 = ovd.a(localStPolyLike1);
      lk.add(localStPolyLike2);
      if (!TextUtils.isEmpty(localStPolyLike2.polySource.get())) {
        ozq.a().a(localStPolyLike2.polySource.get(), null);
      }
      aqfe.J(BaseApplicationImpl.getApplication(), "qcircle_stpoly_" + localStPolyLike2.polyLikeID.get(), new String(localStPolyLike1.toByteArray()));
    }
  }
  
  public static String lQ()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static String lR()
  {
    return arB;
  }
  
  public static void qd(String paramString)
  {
    arB = paramString;
  }
  
  public static void r(List<QQCircleBase.UserCircleInfo> paramList1, List<QQCircleBase.UserCircleInfo> paramList2)
  {
    if (paramList1 != null) {
      mm = new ArrayList(paramList1);
    }
    if (paramList2 != null) {
      mn = new ArrayList(paramList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oum
 * JD-Core Version:    0.7.0.1
 */
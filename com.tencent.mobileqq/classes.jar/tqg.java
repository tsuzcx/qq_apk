import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class tqg
{
  private static volatile FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private static FeedCloudRead.StGetMainPageRsp jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp;
  private static final String jdField_a_of_type_JavaLangString = tqg.class.getSimpleName();
  private static volatile ArrayList<QQCircleBase.UserCircleInfo> jdField_a_of_type_JavaUtilArrayList;
  private static HashMap<String, FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static List<QQCircleFeedBase.StPolyLike> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static String jdField_b_of_type_JavaLangString = "";
  private static volatile ArrayList<QQCircleBase.UserCircleInfo> jdField_b_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static FeedCloudMeta.StFeed a(String paramString)
  {
    return (FeedCloudMeta.StFeed)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public static FeedCloudMeta.StUser a()
  {
    try
    {
      if (jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null)
      {
        if (VSNetworkHelper.a() != null) {
          VSNetworkHelper.a().a(new QCircleGetMainPageRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount()), new tqh());
        }
        FeedCloudMeta.StUser localStUser = b();
        return localStUser;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static ArrayList<QQCircleBase.UserCircleInfo> a()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static List<QQCircleFeedBase.StPolyLike> a()
  {
    if (jdField_a_of_type_JavaUtilList.isEmpty())
    {
      Iterator localIterator = QCirclePolymorphicLikePopWindow.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = "qcircle_stpoly_" + (String)localIterator.next();
        localObject = bczr.a(BaseApplicationImpl.getApplication(), (String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            localObject = (QQCircleFeedBase.StPolyLike)new QQCircleFeedBase.StPolyLike().mergeFrom(((String)localObject).getBytes());
            jdField_a_of_type_JavaUtilList.add(localObject);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
    }
    return jdField_a_of_type_JavaUtilList;
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = null;
      jdField_a_of_type_FeedcloudFeedCloudRead$StGetMainPageRsp = null;
      txt.a().a();
      txu.a().a();
      tpz.a();
      jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(String paramString)
  {
    jdField_b_of_type_JavaLangString = paramString;
  }
  
  public static void a(String paramString, FeedCloudMeta.StFeed paramStFeed)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramStFeed != null)) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramStFeed);
    }
  }
  
  public static void a(List<QQCircleFeedBase.StPolyLike> paramList)
  {
    jdField_a_of_type_JavaUtilList.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleFeedBase.StPolyLike localStPolyLike1 = (QQCircleFeedBase.StPolyLike)paramList.next();
      QQCircleFeedBase.StPolyLike localStPolyLike2 = tra.a(localStPolyLike1);
      jdField_a_of_type_JavaUtilList.add(localStPolyLike2);
      if (!TextUtils.isEmpty(localStPolyLike2.polySource.get())) {
        tvt.a().a(localStPolyLike2.polySource.get(), null);
      }
      bczr.a(BaseApplicationImpl.getApplication(), "qcircle_stpoly_" + localStPolyLike2.polyLikeID.get(), new String(localStPolyLike1.toByteArray()));
    }
  }
  
  public static void a(List<QQCircleBase.UserCircleInfo> paramList1, List<QQCircleBase.UserCircleInfo> paramList2)
  {
    if (paramList1 != null) {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList1);
    }
    if (paramList2 != null) {
      jdField_b_of_type_JavaUtilArrayList = new ArrayList(paramList2);
    }
  }
  
  public static FeedCloudMeta.StUser b()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    return localStUser;
  }
  
  public static String b()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public static ArrayList<QQCircleBase.UserCircleInfo> b()
  {
    return jdField_b_of_type_JavaUtilArrayList;
  }
  
  public static void b()
  {
    QCircleGetTabListRequest localQCircleGetTabListRequest = new QCircleGetTabListRequest(null);
    VSNetworkHelper.a().a(localQCircleGetTabListRequest, new tqi());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqg
 * JD-Core Version:    0.7.0.1
 */
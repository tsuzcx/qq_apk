import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import qqcircle.QQCircleBase.UserCircleInfo;

public class uyn
{
  private static int jdField_a_of_type_Int = QzoneConfig.getQQCircleDefaultShowTabType();
  private static volatile FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private static String jdField_a_of_type_JavaLangString = "";
  private static volatile ArrayList<QQCircleBase.UserCircleInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static HashMap<String, FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilHashMap;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static volatile ArrayList<QQCircleBase.UserCircleInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return BaseApplicationImpl.getApplication().getResources().getDrawable(2130840274);
    }
    Bitmap localBitmap = paramQQAppInterface.a(paramQQAppInterface.a(1, paramString, (byte)3, 0, 100, true));
    if (localBitmap != null) {
      return new BitmapDrawable(localBitmap);
    }
    return aoot.a(paramQQAppInterface, 1, 4, paramString);
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
          VSNetworkHelper.a().a(new QCircleGetMainPageRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount()), new uyo());
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
  
  public static Integer a(String paramString)
  {
    if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramString);
    }
    return Integer.valueOf(-1);
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static ArrayList<QQCircleBase.UserCircleInfo> a()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static void a()
  {
    try
    {
      vqn.a().a();
      vrc.a().a();
      vqt.a().a();
      uyk.a();
      a(true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static void a(String paramString, FeedCloudMeta.StFeed paramStFeed)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramStFeed != null)) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, paramStFeed);
    }
  }
  
  public static void a(String paramString, Integer paramInteger)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("qcircle_fakeid_"))) {
      jdField_b_of_type_JavaUtilHashMap.put(paramString, paramInteger);
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
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      if ((jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) || (paramBoolean))
      {
        jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = null;
        jdField_b_of_type_JavaUtilHashMap.clear();
        vsd.b();
        QCircleFeedPicLoader.a().b();
        vkx.a().a();
      }
      return;
    }
    finally {}
  }
  
  public static FeedCloudMeta.StUser b()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    return localStUser;
  }
  
  public static String b()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static ArrayList<QQCircleBase.UserCircleInfo> b()
  {
    return jdField_b_of_type_JavaUtilArrayList;
  }
  
  public static void b()
  {
    QCircleGetTabListRequest localQCircleGetTabListRequest = new QCircleGetTabListRequest(null);
    VSNetworkHelper.a().a(localQCircleGetTabListRequest, new uyp());
  }
  
  public static void c()
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    QLog.d("QCircleGlobalInfo", 1, "enter a page currentPageCount:" + i);
  }
  
  public static void d()
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    QLog.d("QCircleGlobalInfo", 1, "exit a page currentPageCount:" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyn
 * JD-Core Version:    0.7.0.1
 */
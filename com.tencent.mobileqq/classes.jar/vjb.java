import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Collection;
import qqcircle.QQCircleFeedBase.StFollowPageData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class vjb
{
  private int jdField_a_of_type_Int;
  private FeedCloudCommon.StCommonExt jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilArrayList;
  private QQCircleFeedBase.StFollowPageData jdField_a_of_type_QqcircleQQCircleFeedBase$StFollowPageData;
  private QQCircleFeedBase.StTabInfo jdField_a_of_type_QqcircleQQCircleFeedBase$StTabInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public static vjb a(vtz paramvtz, int paramInt1, int paramInt2)
  {
    if (paramvtz == null)
    {
      QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!model is null");
      return null;
    }
    vjb localvjb = new vjb();
    QQCircleFeedBase.StTabInfo localStTabInfo = paramvtz.a();
    Collection localCollection = paramvtz.a();
    boolean bool = paramvtz.b();
    FeedCloudCommon.StCommonExt localStCommonExt = paramvtz.a();
    String str1 = paramvtz.b();
    String str2 = paramvtz.c();
    if ((localStTabInfo == null) || (localCollection == null) || (localCollection.isEmpty()) || (TextUtils.isEmpty(str1)))
    {
      QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!miss key data!");
      return null;
    }
    localvjb.jdField_a_of_type_Int = paramInt1;
    localvjb.jdField_b_of_type_Int = paramInt2;
    localvjb.jdField_a_of_type_QqcircleQQCircleFeedBase$StTabInfo = localStTabInfo;
    localvjb.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    localvjb.jdField_a_of_type_JavaUtilArrayList.addAll(localCollection);
    localvjb.jdField_a_of_type_Boolean = bool;
    localvjb.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt = localStCommonExt;
    localvjb.jdField_a_of_type_JavaLangString = str1;
    localvjb.jdField_b_of_type_JavaLangString = str2;
    localvjb.jdField_a_of_type_QqcircleQQCircleFeedBase$StFollowPageData = ((QQCircleFeedBase.StFollowPageData)paramvtz.c().getValue());
    return localvjb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjb
 * JD-Core Version:    0.7.0.1
 */
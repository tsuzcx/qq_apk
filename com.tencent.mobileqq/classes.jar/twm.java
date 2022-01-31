import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Collection;
import qqcircle.QQCircleFeedBase.StFollowPageData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class twm
{
  private int jdField_a_of_type_Int;
  private FeedCloudCommon.StCommonExt jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilArrayList;
  private QQCircleFeedBase.StFollowPageData jdField_a_of_type_QqcircleQQCircleFeedBase$StFollowPageData;
  private QQCircleFeedBase.StTabInfo jdField_a_of_type_QqcircleQQCircleFeedBase$StTabInfo;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public static twm a(ubm paramubm, int paramInt1, int paramInt2)
  {
    if (paramubm == null)
    {
      QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!model is null");
      return null;
    }
    twm localtwm = new twm();
    QQCircleFeedBase.StTabInfo localStTabInfo = paramubm.a();
    Collection localCollection = paramubm.a();
    boolean bool = paramubm.b();
    FeedCloudCommon.StCommonExt localStCommonExt = paramubm.a();
    String str = paramubm.b();
    if ((localStTabInfo == null) || (localCollection == null) || (localCollection.isEmpty()) || (TextUtils.isEmpty(str)))
    {
      QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!miss key data!");
      return null;
    }
    localtwm.jdField_a_of_type_Int = paramInt1;
    localtwm.b = paramInt2;
    localtwm.jdField_a_of_type_QqcircleQQCircleFeedBase$StTabInfo = localStTabInfo;
    localtwm.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    localtwm.jdField_a_of_type_JavaUtilArrayList.addAll(localCollection);
    localtwm.jdField_a_of_type_Boolean = bool;
    localtwm.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt = localStCommonExt;
    localtwm.jdField_a_of_type_JavaLangString = str;
    localtwm.jdField_a_of_type_QqcircleQQCircleFeedBase$StFollowPageData = ((QQCircleFeedBase.StFollowPageData)paramubm.c().getValue());
    return localtwm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twm
 * JD-Core Version:    0.7.0.1
 */
import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Collection;
import qqcircle.QQCircleFeedBase.StFollowPageData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class vlf
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
  
  public static vlf a(vwy paramvwy, int paramInt1, int paramInt2)
  {
    if (paramvwy == null)
    {
      QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!model is null");
      return null;
    }
    vlf localvlf = new vlf();
    QQCircleFeedBase.StTabInfo localStTabInfo = paramvwy.a();
    Collection localCollection = paramvwy.a();
    boolean bool = paramvwy.b();
    FeedCloudCommon.StCommonExt localStCommonExt = paramvwy.a();
    String str1 = paramvwy.b();
    String str2 = paramvwy.c();
    if ((localStTabInfo == null) || (localCollection == null) || (localCollection.isEmpty()) || (TextUtils.isEmpty(str1)))
    {
      QLog.d("QCircleFolderCacheHelper", 1, "wrap failed!miss key data!");
      return null;
    }
    localvlf.jdField_a_of_type_Int = paramInt1;
    localvlf.jdField_b_of_type_Int = paramInt2;
    localvlf.jdField_a_of_type_QqcircleQQCircleFeedBase$StTabInfo = localStTabInfo;
    localvlf.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    localvlf.jdField_a_of_type_JavaUtilArrayList.addAll(localCollection);
    localvlf.jdField_a_of_type_Boolean = bool;
    localvlf.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt = localStCommonExt;
    localvlf.jdField_a_of_type_JavaLangString = str1;
    localvlf.jdField_b_of_type_JavaLangString = str2;
    localvlf.jdField_a_of_type_QqcircleQQCircleFeedBase$StFollowPageData = ((QQCircleFeedBase.StFollowPageData)paramvwy.b().getValue());
    QLog.d("QCircleFolderCacheHelper", 1, "wrap success!");
    return localvlf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlf
 * JD-Core Version:    0.7.0.1
 */
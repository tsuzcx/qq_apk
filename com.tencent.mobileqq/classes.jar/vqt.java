import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StPushList;
import java.util.concurrent.ConcurrentHashMap;

public class vqt
{
  private static volatile vqt jdField_a_of_type_Vqt;
  private ConcurrentHashMap<String, FeedCloudMeta.StPushList> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static vqt a()
  {
    if (jdField_a_of_type_Vqt == null) {}
    try
    {
      if (jdField_a_of_type_Vqt == null) {
        jdField_a_of_type_Vqt = new vqt();
      }
      return jdField_a_of_type_Vqt;
    }
    finally {}
  }
  
  public FeedCloudMeta.StPushList a(String paramString)
  {
    return (FeedCloudMeta.StPushList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void a(String paramString, FeedCloudMeta.StPushList paramStPushList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramStPushList == null)) {
      return;
    }
    FeedCloudMeta.StPushList localStPushList = a(paramString);
    if ((localStPushList == null) || (localStPushList.totalClickCount.get() <= paramStPushList.totalClickCount.get()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramStPushList);
      QLog.d("QCirclePushTimesManager", 4, "updatePushInfo feedId" + paramString);
      return;
    }
    paramStPushList.set(localStPushList);
    QLog.d("QCirclePushTimesManager", 4, "setPushInfo from Manager feedId" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqt
 * JD-Core Version:    0.7.0.1
 */
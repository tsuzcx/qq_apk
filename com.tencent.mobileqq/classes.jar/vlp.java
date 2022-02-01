import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

public class vlp
{
  private static volatile vlp jdField_a_of_type_Vlp;
  private ConcurrentHashMap<String, QQCirclePrivateMsgShow.UserPMGiftInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static vlp a()
  {
    if (jdField_a_of_type_Vlp == null) {}
    try
    {
      if (jdField_a_of_type_Vlp == null) {
        jdField_a_of_type_Vlp = new vlp();
      }
      return jdField_a_of_type_Vlp;
    }
    finally {}
  }
  
  public QQCirclePrivateMsgShow.UserPMGiftInfo a(String paramString)
  {
    return (QQCirclePrivateMsgShow.UserPMGiftInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a(List<QQCirclePrivateMsgShow.UserPMGiftInfo> paramList)
  {
    QLog.d("QCircleChatGiftManager", 1, "updateGiftInfo");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCirclePrivateMsgShow.UserPMGiftInfo localUserPMGiftInfo = (QQCirclePrivateMsgShow.UserPMGiftInfo)paramList.next();
      if (localUserPMGiftInfo != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localUserPMGiftInfo.uid.get(), localUserPMGiftInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlp
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

public class vjl
{
  private static volatile vjl jdField_a_of_type_Vjl;
  private ConcurrentHashMap<String, QQCirclePrivateMsgShow.UserPMGiftInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static vjl a()
  {
    if (jdField_a_of_type_Vjl == null) {}
    try
    {
      if (jdField_a_of_type_Vjl == null) {
        jdField_a_of_type_Vjl = new vjl();
      }
      return jdField_a_of_type_Vjl;
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
 * Qualified Name:     vjl
 * JD-Core Version:    0.7.0.1
 */
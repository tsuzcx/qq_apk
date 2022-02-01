import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class abhr
  implements Manager
{
  public static String TAG = "ApolloNativeSSOReqMgr";
  
  public abhr(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[ApolloNativeSSOReqMgr]");
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhr
 * JD-Core Version:    0.7.0.1
 */
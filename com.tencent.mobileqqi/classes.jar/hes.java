import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import com.tencent.mobileqq.util.FetchInfoListManager.FetchInfoListener;
import com.tencent.mobileqq.util.FetchInfoReq;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class hes
  implements FetchInfoListManager.FetchInfoListener
{
  public hes(FetchBuddyAndTroopNameHelper paramFetchBuddyAndTroopNameHelper) {}
  
  public void a(FetchInfoReq paramFetchInfoReq)
  {
    if ((paramFetchInfoReq == null) || (!paramFetchInfoReq.a())) {}
    TroopHandler localTroopHandler;
    do
    {
      do
      {
        return;
        localObject = (FriendListHandler)FetchBuddyAndTroopNameHelper.a(this.a).a(1);
        localTroopHandler = (TroopHandler)FetchBuddyAndTroopNameHelper.a(this.a).a(19);
      } while ((localObject == null) || (localTroopHandler == null));
      if (QLog.isColorLevel()) {
        QLog.d(FetchBuddyAndTroopNameHelper.a(), 2, StringUtil.a(new Object[] { "fetchInfo()", paramFetchInfoReq.toString() }));
      }
      if (paramFetchInfoReq.f == 2)
      {
        localTroopHandler.j(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
        return;
      }
      if (paramFetchInfoReq.f == 1)
      {
        ((FriendListHandler)localObject).a(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (paramFetchInfoReq.f != 3);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
    localTroopHandler.a(paramFetchInfoReq.b, (String)paramFetchInfoReq.jdField_a_of_type_JavaLangObject, (ArrayList)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hes
 * JD-Core Version:    0.7.0.1
 */
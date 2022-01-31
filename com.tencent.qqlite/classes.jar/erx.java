import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import com.tencent.mobileqq.util.FetchInfoListManager.FetchInfoListener;
import com.tencent.mobileqq.util.FetchInfoReq;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class erx
  implements FetchInfoListManager.FetchInfoListener
{
  public erx(FetchBuddyAndTroopNameHelper paramFetchBuddyAndTroopNameHelper) {}
  
  public void a(FetchInfoReq paramFetchInfoReq)
  {
    if ((paramFetchInfoReq == null) || (!paramFetchInfoReq.a())) {}
    Object localObject;
    do
    {
      TroopHandler localTroopHandler;
      do
      {
        return;
        localObject = (FriendListHandler)FetchBuddyAndTroopNameHelper.a(this.a).a(1);
        localTroopHandler = (TroopHandler)FetchBuddyAndTroopNameHelper.a(this.a).a(17);
      } while ((localObject == null) || (localTroopHandler == null));
      if (QLog.isColorLevel()) {
        QLog.d(FetchBuddyAndTroopNameHelper.a(), 2, StringUtil.a(new Object[] { "fetchInfo()", paramFetchInfoReq.toString() }));
      }
      if (paramFetchInfoReq.g == 2)
      {
        localTroopHandler.j(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
        return;
      }
      if (paramFetchInfoReq.g == 1)
      {
        ((FriendListHandler)localObject).a(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
        return;
      }
      if (paramFetchInfoReq.g == 3)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
        localTroopHandler.a(paramFetchInfoReq.b, (String)paramFetchInfoReq.jdField_a_of_type_JavaLangObject, (ArrayList)localObject);
        return;
      }
    } while (paramFetchInfoReq.g != 4);
    ((FriendListHandler)localObject).b(paramFetchInfoReq.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     erx
 * JD-Core Version:    0.7.0.1
 */
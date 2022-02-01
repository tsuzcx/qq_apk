import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class wjn
  implements wje.a
{
  public ProfileActivity.AllInOne b(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = new ProfileActivity.AllInOne(paramSessionInfo.aTl, 115);
    paramQQAppInterface.nickname = paramSessionInfo.aTn;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wjn
 * JD-Core Version:    0.7.0.1
 */
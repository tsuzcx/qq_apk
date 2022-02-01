import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class wjg
  implements wje.a
{
  public ProfileActivity.AllInOne b(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = new ProfileActivity.AllInOne(paramMessageRecord.frienduin, 47);
    paramQQAppInterface.nickname = paramSessionInfo.aTn;
    paramQQAppInterface.discussUin = paramSessionInfo.troopUin;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wjg
 * JD-Core Version:    0.7.0.1
 */
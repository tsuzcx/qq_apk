import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class wju
  implements wje.a
{
  public ProfileActivity.AllInOne b(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    paramString = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 21);
    paramString.subSourceId = 11;
    paramString.nickname = aqgv.h(paramQQAppInterface, paramSessionInfo.troopUin, paramMessageRecord.senderuin);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wju
 * JD-Core Version:    0.7.0.1
 */
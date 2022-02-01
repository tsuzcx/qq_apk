import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class aobt
  extends aobe
{
  aobt(aobs paramaobs) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.aoR != aobs.a(this.a).uniseq) {
      return;
    }
    aobs.a(this.a).saveExtInfoToExtStr("errorString", aobs.a(this.a, paramTeamWorkFileImportInfo.retCode));
    aobs.a(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.retCode));
    aobs.a(this.a).a().e(aobs.a(this.a).frienduin, aobs.a(this.a).istroop, aobs.a(this.a).uniseq);
    aobs.a(this.a).removeObserver(aobs.a(this.a));
    aobs.a(this.a).b().a(aobs.a(this.a).frienduin, aobs.a(this.a).istroop, aobs.a(this.a).uniseq, "extStr", aobs.a(this.a).extStr);
    aobs.a(this.a).b().b(aobs.a(this.a).frienduin, aobs.a(this.a).istroop, aobs.a(this.a).uniseq, 32768, -1);
    QLog.i("TeamWorkSender", 1, aobs.a(this.a).uniseq + " import file faild");
    aobs.a(this.a).a().b(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.aoR != aobs.a(this.a).uniseq) {}
    do
    {
      return;
      aobs.a(this.a).removeObserver(aobs.a(this.a));
      aobs.a(this.a).mMsgUrl = paramString;
      aobs.a(this.a).structingMsg.mMsgUrl = paramString;
      aobs.a(this.a).msgData = aobs.a(this.a).getBytes();
      aobs.a(this.a).removeFlag(1);
      aobs.a(this.a).removeFlag(2);
      aobs.a(this.a).b().b(aobs.a(this.a), null, false);
      QLog.i("TeamWorkSender", 1, "start import file success");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkSender", 1, "msg uniseq : " + aobs.a(this.a).uniseq + " import success, url:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobt
 * JD-Core Version:    0.7.0.1
 */
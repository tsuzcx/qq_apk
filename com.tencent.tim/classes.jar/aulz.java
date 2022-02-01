import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamworkforgroup.GroupTeamAddLinkDlg;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;

public class aulz
  implements DialogInterface.OnClickListener
{
  public aulz(GroupTeamAddLinkDlg paramGroupTeamAddLinkDlg, int paramInt, String paramString, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GroupTeamAddLinkDlg.a(this.a);
    paramDialogInterface = (aumb)this.a.app.getBusinessHandler(143);
    Object localObject = (aull)this.a.app.getManager(372);
    if ((paramDialogInterface == null) || (localObject == null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("qqBaseActivity", 1, "handler or manager is null");
      }
      this.a.finish();
    }
    localObject = ault.a(this.erH, this.cIF);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.a(this.ayU, (online_docs.DocId)localObject, this.a.mTitle);
      paramDialogInterface = this.ayU + "_" + this.erH + "_" + this.cIF;
      aqmj.G(this.a, paramDialogInterface, true);
      if (QLog.isColorLevel()) {
        QLog.i("Group_Team_Work_Doc_Link", 2, paramDialogInterface + " set");
      }
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulz
 * JD-Core Version:    0.7.0.1
 */
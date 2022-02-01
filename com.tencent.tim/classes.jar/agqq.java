import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agqq
  implements View.OnClickListener
{
  agqq(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    label97:
    boolean bool2;
    if ((this.b != null) && (this.val$activity != null))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (this.ceQ)
      {
        aodb.aN(null, "0X800A21D");
        localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
        localTeamWorkFileImportInfo.filePath = this.b.getFilePath();
        localTeamWorkFileImportInfo.fileName = this.b.fileName;
        localTeamWorkFileImportInfo.nFileType = this.b.nFileType;
        if (!this.ceQ) {
          break label241;
        }
        localTeamWorkFileImportInfo.dNQ = 8;
        localTeamWorkFileImportInfo.fileSize = this.b.fileSize;
        if (!(this.val$activity instanceof FileBrowserActivity)) {
          break label415;
        }
        bool2 = ((FileBrowserActivity)this.val$activity).amh();
        if ((!((FileBrowserActivity)this.val$activity).bY()) || (bool2)) {
          break label250;
        }
        bool1 = true;
        label149:
        localTeamWorkFileImportInfo.isFromAIO = bool1;
      }
    }
    label415:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if ((bool1) && (!aqhq.fileExistsAndNotEmpty(this.b.getFilePath()))) {
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131720922), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        anot.a(localQQAppInterface, "dc00898", "", "", "0X8009063", "0X8009063", 0, 0, "", "", "", "");
        break;
        label241:
        localTeamWorkFileImportInfo.dNQ = 5;
        break label97;
        label250:
        bool1 = false;
        break label149;
        if (!TextUtils.isEmpty(this.b.peerUin))
        {
          localTeamWorkFileImportInfo.peerType = this.b.peerType;
          localTeamWorkFileImportInfo.peerUin = this.b.peerUin;
          localTeamWorkFileImportInfo.troopUin = String.valueOf(this.b.TroopUin);
          localTeamWorkFileImportInfo.cjE = this.b.strTroopFilePath;
          localTeamWorkFileImportInfo.dNP = this.b.busId;
          localTeamWorkFileImportInfo.msgUniseq = this.b.uniseq;
          if (this.b.status != 16) {
            localTeamWorkFileImportInfo.cKX = true;
          }
        }
        aoag.a(localTeamWorkFileImportInfo, this.val$activity, localQQAppInterface, localTeamWorkFileImportInfo.dNQ);
        continue;
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131720917), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqq
 * JD-Core Version:    0.7.0.1
 */
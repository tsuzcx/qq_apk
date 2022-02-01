import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;

final class atxv
  implements View.OnClickListener
{
  atxv(FileManagerEntity paramFileManagerEntity, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    boolean bool2;
    if ((this.b != null) && (this.val$activity != null))
    {
      localIntent = new Intent(this.val$activity, TeamWorkDocEditBrowserActivity.class);
      localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.filePath = this.b.strFilePath;
      localTeamWorkFileImportInfo.fileName = this.b.fileName;
      localTeamWorkFileImportInfo.dNQ = 5;
      localTeamWorkFileImportInfo.fileSize = this.b.fileSize;
      if (!(this.val$activity instanceof FileBrowserActivity)) {
        break label532;
      }
      bool2 = ((FileBrowserActivity)this.val$activity).amh();
      if ((((FileBrowserActivity)this.val$activity).bY()) && (!bool2))
      {
        bool1 = true;
        localTeamWorkFileImportInfo.isFromAIO = bool1;
      }
    }
    label532:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if ((bool1) && (!aqhq.fileExistsAndNotEmpty(this.b.getFilePath()))) {
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131720922), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bool1 = false;
        break;
        if ((this.b.uniseq == -1L) && ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)))
        {
          localObject = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(this.b.cloudId);
          if (localObject != null)
          {
            this.b.uniseq = ((FileManagerEntity)localObject).uniseq;
            this.b.peerType = ((FileManagerEntity)localObject).peerType;
            localTeamWorkFileImportInfo.nSessionId = ((FileManagerEntity)localObject).nSessionId;
          }
        }
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
        Object localObject = null;
        if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
          localObject = ((aoar)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(120)).c(localTeamWorkFileImportInfo);
        }
        localIntent.putExtra("key_team_work_file_import_info", localTeamWorkFileImportInfo);
        localIntent.putExtra("temp_preview_from_qq", true);
        localIntent.putExtra("temp_preview_show_loading", true);
        localIntent.putExtra("tdsourcetag", "s_tim_file_share_edit");
        TeamWorkDocEditBrowserActivity.a(localIntent, ault.bD((String)localObject, "s_tim_file_share_edit"), this.val$activity);
        localIntent.addFlags(603979776);
        this.val$activity.startActivity(localIntent);
        continue;
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131720917), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxv
 * JD-Core Version:    0.7.0.1
 */
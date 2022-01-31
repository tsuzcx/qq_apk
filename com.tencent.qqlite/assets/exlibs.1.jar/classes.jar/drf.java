import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ProgressBar;
import com.dataline.mpfile.MpFileConstant;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.QualityReportUtil;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class drf
  extends BroadcastReceiver
{
  public drf(BaseActionBarDataLineFile paramBaseActionBarDataLineFile) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    long l1;
    label406:
    label485:
    label500:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramContext = paramIntent.getAction();
            } while (paramContext == null);
            if (!paramContext.equals("com.dataline.mpfile.download_progress")) {
              break;
            }
          } while (paramIntent.getLongExtra("token_task_id", 0L) != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
          l1 = paramIntent.getLongExtra("token_current_size", 0L);
          l2 = paramIntent.getLongExtra("token_total_size", 0L);
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
          this.a.h();
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)l1 / (float)l2);
          BaseActionBarDataLineFile.d(this.a);
          BaseActionBarDataLineFile.a(this.a).setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
          return;
          if (!paramContext.equals("com.dataline.mpfile.download_completed")) {
            break;
          }
          l1 = paramIntent.getLongExtra("token_task_id", 0L);
        } while (l1 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        BaseActionBarDataLineFile.a(this.a, NetConnInfoCenter.getServerTimeMillis());
        long l2 = paramIntent.getLongExtra("token_current_size", 0L);
        boolean bool = paramIntent.getBooleanExtra("token_is_success", false);
        int j = paramIntent.getIntExtra("token_http_code", 0);
        paramContext = new ReportItem();
        paramContext.uSessionID = l1;
        paramContext.uChannelType = 6;
        paramContext.bSend = false;
        paramContext.uNotifyTime = BaseActionBarDataLineFile.a(this.a);
        paramContext.uFileSize = l2;
        paramContext.bFileExist = false;
        paramContext.uStartPos = 0L;
        paramContext.uTaskStart = BaseActionBarDataLineFile.a(this.a);
        paramContext.uTaskEnd = BaseActionBarDataLineFile.b(this.a);
        paramContext.uDuration = (BaseActionBarDataLineFile.b(this.a) - BaseActionBarDataLineFile.a(this.a));
        paramContext.bUserRetry = false;
        paramContext.sSuffix = "";
        int i;
        if (bool)
        {
          i = 2;
          paramContext.emResult = i;
          paramContext.nFailCode = 0;
          paramContext.nUserCode = j;
          paramContext.dwServerIP = DBNetworkUtil.a(MpfileDataCenter.k);
          paramContext.dwClientIP = DBNetworkUtil.a(DBNetworkUtil.b());
          paramContext.wServerPort = ((short)MpfileDataCenter.E);
          QualityReportUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), paramContext);
          this.a.g();
          if (bool) {
            break label500;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
          if (j != 2) {
            break label485;
          }
          FMToastUtil.a(2131361916);
          this.a.c();
        }
        for (;;)
        {
          ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID);
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
          return;
          if (BaseActionBarDataLineFile.a(this.a))
          {
            i = 32;
            break;
          }
          i = 41;
          break;
          if (j != 8) {
            break label406;
          }
          FMToastUtil.a(2131361932);
          break label406;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = String.format("%s/%s", new Object[] { MpfileDataCenter.a(), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName });
          this.a.a();
        }
      } while (!paramContext.equals(MpFileConstant.d));
      l1 = paramIntent.getLongExtra(MpFileConstant.f, 0L);
    } while (BaseActionBarDataLineFile.c(this.a) != l1);
    BaseActionBarDataLineFile.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     drf
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.dataline.activities.DLBaseFileViewActivity.DLFileState;
import com.dataline.mpfile.LiteMpFileFileDetailActivity;
import com.dataline.mpfile.MpFileConstant;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.QualityReportUtil;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class cy
  extends BroadcastReceiver
{
  public cy(LiteMpFileFileDetailActivity paramLiteMpFileFileDetailActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    long l1;
    label418:
    label433:
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
          } while (paramIntent.getLongExtra("token_task_id", 0L) != LiteMpFileFileDetailActivity.a(this.a));
          l1 = paramIntent.getLongExtra("token_current_size", 0L);
          l2 = paramIntent.getLongExtra("token_total_size", 0L);
          LiteMpFileFileDetailActivity.a(this.a).a = DLBaseFileViewActivity.DLFileState.RECVING;
          LiteMpFileFileDetailActivity.a(this.a, (float)l1 / (float)l2);
          LiteMpFileFileDetailActivity.a(this.a);
          return;
          if (!paramContext.equals("com.dataline.mpfile.download_completed")) {
            break;
          }
          l1 = paramIntent.getLongExtra("token_task_id", 0L);
        } while (l1 != LiteMpFileFileDetailActivity.a(this.a));
        LiteMpFileFileDetailActivity.a(this.a, NetConnInfoCenter.getServerTimeMillis());
        long l2 = paramIntent.getLongExtra("token_current_size", 0L);
        boolean bool = paramIntent.getBooleanExtra("token_is_success", false);
        int j = paramIntent.getIntExtra("token_http_code", 0);
        paramContext = new ReportItem();
        paramContext.uSessionID = l1;
        paramContext.uChannelType = 6;
        paramContext.bSend = false;
        paramContext.uNotifyTime = LiteMpFileFileDetailActivity.b(this.a);
        paramContext.uFileSize = l2;
        paramContext.bFileExist = false;
        paramContext.uStartPos = 0L;
        paramContext.uTaskStart = LiteMpFileFileDetailActivity.b(this.a);
        paramContext.uTaskEnd = LiteMpFileFileDetailActivity.c(this.a);
        paramContext.uDuration = (LiteMpFileFileDetailActivity.c(this.a) - LiteMpFileFileDetailActivity.b(this.a));
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
          paramContext.dwClientIP = DBNetworkUtil.a(DBNetworkUtil.a());
          paramContext.wServerPort = ((short)MpfileDataCenter.E);
          QualityReportUtil.a(this.a.b, paramContext);
          if (bool) {
            break label433;
          }
          LiteMpFileFileDetailActivity.b(this.a).a = DLBaseFileViewActivity.DLFileState.RECVFAILED;
          if (j != 2) {
            break label418;
          }
          FMToastUtil.a(2131558589);
        }
        for (;;)
        {
          ((DataLineHandler)this.a.b.a(8)).a().a(LiteMpFileFileDetailActivity.a(this.a));
          LiteMpFileFileDetailActivity.c(this.a);
          return;
          if (LiteMpFileFileDetailActivity.a(this.a))
          {
            i = 32;
            break;
          }
          i = 41;
          break;
          if (j == 8)
          {
            FMToastUtil.a(2131558606);
            continue;
            LiteMpFileFileDetailActivity.c(this.a).a = DLBaseFileViewActivity.DLFileState.DONE;
            LiteMpFileFileDetailActivity.a(this.a, 1.0F);
            LiteMpFileFileDetailActivity.b(this.a);
          }
        }
      } while (!paramContext.equals(MpFileConstant.d));
      l1 = paramIntent.getLongExtra(MpFileConstant.f, 0L);
    } while (LiteMpFileFileDetailActivity.d(this.a) != l1);
    LiteMpFileFileDetailActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     cy
 * JD-Core Version:    0.7.0.1
 */
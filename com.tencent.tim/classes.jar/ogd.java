import UserGrowth.eConfigBit;
import UserGrowth.stGlobalConfig;
import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ogd
{
  private Dialog t;
  
  public static boolean GI()
  {
    stGlobalConfig localstGlobalConfig = ohy.a().a();
    ooz.i("WSUserAuthDialog", "判断是否需要弹窗");
    if ((localstGlobalConfig == null) || (localstGlobalConfig.user_auth == null))
    {
      ooz.i("WSUserAuthDialog", "没有授权弹窗结构体");
      return false;
    }
    if (localstGlobalConfig.user_auth.schema == null)
    {
      ooz.i("WSUserAuthDialog", "user_auth.schema == null");
      return false;
    }
    if ((localstGlobalConfig.user_auth.schema.type != 1) || (TextUtils.isEmpty(localstGlobalConfig.user_auth.schema.miniAppSchema)))
    {
      ooz.i("WSUserAuthDialog", "下发scheme不合法，不展示弹窗");
      return false;
    }
    ooz.i("WSUserAuthDialog", localstGlobalConfig.user_auth.toString());
    return localstGlobalConfig.user_auth.show_confirm;
  }
  
  private Dialog a(Context paramContext, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131756779);
    localReportDialog.setContentView(2131560196);
    View localView = localReportDialog.findViewById(2131365896);
    localView.findViewById(2131382347).setOnClickListener(new ogf(this, paramContext, paramString));
    localReportDialog.setOnCancelListener(new ogh(this, paramString));
    localView.findViewById(2131382346).setOnClickListener(new ogi(this, paramString));
    return localReportDialog;
  }
  
  public static void aV(Context paramContext, String paramString)
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_exposure", paramString, "authorized_window", 0);
    bex();
    new ogd().ax(paramContext, paramString);
  }
  
  private static void bex()
  {
    ooz.i("WSUserAuthDialog", "doTask: UserConfig request");
    okz localokz = new okz(new ooc(eConfigBit.eShowConfirmWindow), null, new oge(), 4010);
    oks.a().b(localokz);
  }
  
  private void dismiss()
  {
    ooz.i("WSUserAuthDialog", "dialog dismiss");
    if ((this.t != null) && (this.t.isShowing())) {
      this.t.dismiss();
    }
  }
  
  public void ax(Context paramContext, String paramString)
  {
    this.t = a(paramContext, paramString);
    if (this.t != null)
    {
      this.t.setCanceledOnTouchOutside(true);
      this.t.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogd
 * JD-Core Version:    0.7.0.1
 */
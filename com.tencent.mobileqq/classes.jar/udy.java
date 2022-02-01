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

public class udy
{
  private Dialog a;
  
  private Dialog a(Context paramContext, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131756034);
    localReportDialog.setContentView(2131559991);
    View localView = localReportDialog.findViewById(2131365507);
    localView.findViewById(2131381311).setOnClickListener(new uea(this, paramContext, paramString));
    localReportDialog.setOnCancelListener(new uec(this, paramString));
    localView.findViewById(2131381310).setOnClickListener(new ued(this, paramString));
    return localReportDialog;
  }
  
  private static void a()
  {
    upe.a("WSUserAuthDialog", "doTask: UserConfig request");
    uju localuju = new uju(new uoa(eConfigBit.eShowConfirmWindow), null, new udz(), 4010);
    ujn.a().a(localuju);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_exposure", paramString, "authorized_window", 0);
    a();
    new udy().b(paramContext, paramString);
  }
  
  public static boolean a()
  {
    stGlobalConfig localstGlobalConfig = ugb.a().a();
    upe.a("WSUserAuthDialog", "判断是否需要弹窗");
    if ((localstGlobalConfig == null) || (localstGlobalConfig.user_auth == null))
    {
      upe.a("WSUserAuthDialog", "没有授权弹窗结构体");
      return false;
    }
    if (localstGlobalConfig.user_auth.schema == null)
    {
      upe.a("WSUserAuthDialog", "user_auth.schema == null");
      return false;
    }
    if ((localstGlobalConfig.user_auth.schema.type != 1) || (TextUtils.isEmpty(localstGlobalConfig.user_auth.schema.miniAppSchema)))
    {
      upe.a("WSUserAuthDialog", "下发scheme不合法，不展示弹窗");
      return false;
    }
    upe.a("WSUserAuthDialog", localstGlobalConfig.user_auth.toString());
    return localstGlobalConfig.user_auth.show_confirm;
  }
  
  private void b()
  {
    upe.a("WSUserAuthDialog", "dialog dismiss");
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
  
  public void b(Context paramContext, String paramString)
  {
    this.a = a(paramContext, paramString);
    if (this.a != null)
    {
      this.a.setCanceledOnTouchOutside(true);
      this.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     udy
 * JD-Core Version:    0.7.0.1
 */
import UserGrowth.eConfigBit;
import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class uea
{
  private Dialog a;
  
  private Dialog a(Context paramContext, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131756035);
    localReportDialog.setContentView(2131559997);
    View localView = localReportDialog.findViewById(2131365549);
    localView.findViewById(2131381490).setOnClickListener(new uec(this, paramContext, paramString));
    localReportDialog.setOnCancelListener(new uee(this, paramString));
    localView.findViewById(2131381489).setOnClickListener(new uef(this, paramString));
    return localReportDialog;
  }
  
  private static void a()
  {
    uqf.a("WSUserAuthDialog", "doTask: UserConfig request");
    uko localuko = new uko(new upb(eConfigBit.eShowConfirmWindow), null, new ueb(), 4010);
    ukh.a().a(localuko);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_exposure", paramString, "authorized_window", 0);
    a();
    new uea().b(paramContext, paramString);
  }
  
  public static boolean a()
  {
    stUserAuth localstUserAuth = ugd.a().a();
    uqf.a("WSUserAuthDialog", "判断是否需要弹窗");
    if (localstUserAuth == null)
    {
      uqf.a("WSUserAuthDialog", "没有授权弹窗结构体");
      return false;
    }
    if (localstUserAuth.schema == null)
    {
      uqf.a("WSUserAuthDialog", "user_auth.schema == null");
      return false;
    }
    if ((localstUserAuth.schema.type != 1) || (TextUtils.isEmpty(localstUserAuth.schema.miniAppSchema)))
    {
      uqf.a("WSUserAuthDialog", "下发scheme不合法，不展示弹窗");
      return false;
    }
    uqf.a("WSUserAuthDialog", localstUserAuth.toString());
    return localstUserAuth.show_confirm;
  }
  
  private void b()
  {
    uqf.a("WSUserAuthDialog", "dialog dismiss");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uea
 * JD-Core Version:    0.7.0.1
 */
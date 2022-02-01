import UserGrowth.eConfigBit;
import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ukq
{
  private Dialog a;
  
  private Dialog a(Context paramContext, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131756036);
    localReportDialog.setContentView(2131560003);
    View localView = localReportDialog.findViewById(2131365582);
    localView.findViewById(2131381207).setOnClickListener(new uks(this, paramContext, paramString));
    localReportDialog.setOnCancelListener(new uku(this, paramString));
    localView.findViewById(2131381206).setOnClickListener(new ukv(this, paramString));
    return localReportDialog;
  }
  
  private static void a()
  {
    uya.a("WSUserAuthDialog", "doTask: UserConfig request");
    urj localurj = new urj(new uww(eConfigBit.eShowConfirmWindow), null, new ukr(), 4010);
    urc.a().a(localurj);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_exposure", paramString, "authorized_window", 0);
    a();
    new ukq().b(paramContext, paramString);
  }
  
  public static boolean a()
  {
    stUserAuth localstUserAuth = umu.a().a();
    uya.a("WSUserAuthDialog", "判断是否需要弹窗");
    if (localstUserAuth == null)
    {
      uya.a("WSUserAuthDialog", "没有授权弹窗结构体");
      return false;
    }
    if (localstUserAuth.schema == null)
    {
      uya.a("WSUserAuthDialog", "user_auth.schema == null");
      return false;
    }
    if ((localstUserAuth.schema.type != 1) || (TextUtils.isEmpty(localstUserAuth.schema.miniAppSchema)))
    {
      uya.a("WSUserAuthDialog", "下发scheme不合法，不展示弹窗");
      return false;
    }
    uya.a("WSUserAuthDialog", localstUserAuth.toString());
    return localstUserAuth.show_confirm;
  }
  
  private void b()
  {
    uya.a("WSUserAuthDialog", "dialog dismiss");
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
 * Qualified Name:     ukq
 * JD-Core Version:    0.7.0.1
 */
import UserGrowth.eConfigBit;
import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class uyn
{
  private Dialog a;
  
  private Dialog a(Context paramContext, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131756043);
    localReportDialog.setContentView(2131560047);
    View localView = localReportDialog.findViewById(2131365674);
    localView.findViewById(2131381570).setOnClickListener(new uyp(this, paramContext, paramString));
    localReportDialog.setOnCancelListener(new uyr(this, paramString));
    localView.findViewById(2131381569).setOnClickListener(new uys(this, paramString));
    return localReportDialog;
  }
  
  private static void a()
  {
    vmp.a("WSUserAuthDialog", "doTask: UserConfig request");
    vfr localvfr = new vfr(new vll(eConfigBit.eShowConfirmWindow), null, new uyo(), 4010);
    vfk.a().a(localvfr);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_exposure", paramString, "authorized_window", 0);
    a();
    new uyn().b(paramContext, paramString);
  }
  
  public static boolean a()
  {
    stUserAuth localstUserAuth = vau.a().a();
    vmp.a("WSUserAuthDialog", "判断是否需要弹窗");
    if (localstUserAuth == null)
    {
      vmp.a("WSUserAuthDialog", "没有授权弹窗结构体");
      return false;
    }
    if (localstUserAuth.schema == null)
    {
      vmp.a("WSUserAuthDialog", "user_auth.schema == null");
      return false;
    }
    if ((localstUserAuth.schema.type != 1) || (TextUtils.isEmpty(localstUserAuth.schema.miniAppSchema)))
    {
      vmp.a("WSUserAuthDialog", "下发scheme不合法，不展示弹窗");
      return false;
    }
    vmp.a("WSUserAuthDialog", localstUserAuth.toString());
    return localstUserAuth.show_confirm;
  }
  
  private void b()
  {
    vmp.a("WSUserAuthDialog", "dialog dismiss");
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
 * Qualified Name:     uyn
 * JD-Core Version:    0.7.0.1
 */
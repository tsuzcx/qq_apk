import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.studymode.StudyModeSwitchDialog.btnSwitchOn.2;
import com.tencent.mobileqq.studymode.StudyModeSwitchDialog.ivClose.2;
import com.tencent.mobileqq.studymode.StudyModeSwitchDialog.manager.2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$OnModeChangeResultCallback;", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "btnSwitchOn", "Landroid/widget/Button;", "getBtnSwitchOn", "()Landroid/widget/Button;", "btnSwitchOn$delegate", "Lkotlin/Lazy;", "ivClose", "Landroid/widget/ImageView;", "getIvClose", "()Landroid/widget/ImageView;", "ivClose$delegate", "loadingDialog", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "manager", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "getManager", "()Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "manager$delegate", "initView", "", "onModeChangeComplete", "isSuccess", "", "targetType", "", "oldType", "message", "", "onModeChangeStart", "onModeSwitching", "onSelectModeRecover", "onSwitchClick", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anwc
  extends ReportDialog
  implements anvv.a
{
  private arhz S;
  private final Lazy g;
  private final BaseActivity jdField_h_of_type_ComTencentMobileqqAppBaseActivity;
  private final Lazy jdField_h_of_type_KotlinLazy;
  private final Lazy i;
  
  public anwc(@NotNull BaseActivity paramBaseActivity)
  {
    super((Context)paramBaseActivity, 2131755365);
    this.jdField_h_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.g = LazyKt.lazy((Function0)new StudyModeSwitchDialog.ivClose.2(this));
    this.jdField_h_of_type_KotlinLazy = LazyKt.lazy((Function0)new StudyModeSwitchDialog.btnSwitchOn.2(this));
    this.i = LazyKt.lazy((Function0)new StudyModeSwitchDialog.manager.2(this));
    paramBaseActivity = getWindow();
    if (paramBaseActivity != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        paramBaseActivity.addFlags(67108864);
      }
      ImmersiveUtils.clearCoverForStatus(paramBaseActivity, true);
    }
    setContentView(2131559039);
    initView();
    a().a((anvv.a)this);
    anot.a(this.jdField_h_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800ADD4", "0X800ADD4", 0, 0, "", "", "", "");
  }
  
  private final anvv a()
  {
    return (anvv)this.i.getValue();
  }
  
  private final void dTG()
  {
    if (a().azc())
    {
      QQToast.a((Context)this.jdField_h_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131719969, 0).show();
      return;
    }
    if (anvt.mk() == 2)
    {
      QQToast.a((Context)this.jdField_h_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131720498, 0).show();
      dismiss();
      return;
    }
    int j = anlm.Kd();
    anvv.b localb = a().a((Activity)this.jdField_h_of_type_ComTencentMobileqqAppBaseActivity, 2, j, true);
    if ((!localb.azc()) && (localb.Kv() == localb.Kw()))
    {
      QQToast.a((Context)this.jdField_h_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131720498, 0).show();
      dismiss();
    }
    anot.a(this.jdField_h_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800ADD5", "0X800ADD5", 0, 0, "", "", "", "");
  }
  
  private final Button e()
  {
    return (Button)this.jdField_h_of_type_KotlinLazy.getValue();
  }
  
  private final void initView()
  {
    x().setOnClickListener((View.OnClickListener)new anwd(this));
    e().setOnClickListener((View.OnClickListener)new anwe(this));
    setOnDismissListener((DialogInterface.OnDismissListener)new anwf(this));
  }
  
  private final ImageView x()
  {
    return (ImageView)this.g.getValue();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Context localContext;
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      localContext = (Context)this.jdField_h_of_type_ComTencentMobileqqAppBaseActivity;
      if (!paramBoolean) {
        break label70;
      }
    }
    label70:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      QQToast.a(localContext, paramInt1, (CharSequence)paramString, 0).show();
      paramString = this.S;
      if (paramString != null) {
        paramString.dismiss();
      }
      dismiss();
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    anvv.a.a.a(this, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString)
  {
    anvv.a.a.a(this, paramBoolean1, paramBoolean2, paramBoolean3, paramInt, paramString);
  }
  
  public void fe(int paramInt1, int paramInt2)
  {
    arhz localarhz = this.S;
    if ((localarhz != null) && (localarhz.isShowing() == true))
    {
      localarhz = this.S;
      if (localarhz != null) {
        localarhz.dismiss();
      }
    }
    this.S = new arhz((Context)this.jdField_h_of_type_ComTencentMobileqqAppBaseActivity);
    localarhz = this.S;
    if (localarhz == null) {
      Intrinsics.throwNpe();
    }
    Window localWindow = localarhz.getWindow();
    if (localWindow != null) {
      localWindow.setDimAmount(0.0F);
    }
    localarhz.show();
  }
  
  public void ff(int paramInt1, int paramInt2)
  {
    arhz localarhz = this.S;
    if (localarhz != null) {
      localarhz.dismiss();
    }
  }
  
  public void fg(int paramInt1, int paramInt2)
  {
    QQToast.a((Context)this.jdField_h_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131719969, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwc
 * JD-Core Version:    0.7.0.1
 */
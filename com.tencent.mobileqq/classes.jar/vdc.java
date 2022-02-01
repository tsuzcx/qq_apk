import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.os.MqqHandler;

public class vdc
  extends zxj
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(a(), 2131755241);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      View localView = LayoutInflater.from(a()).inflate(2131560780, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)localView.findViewById(2131373792));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(4.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(20, Color.parseColor("#ffffff"), 90, Color.parseColor("#ffffff"));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373791));
      this.jdField_a_of_type_AndroidAppDialog.setContentView(localView);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + "%");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Toast localToast;
    View localView;
    TextView localTextView;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      if (paramBoolean) {
        a(100);
      }
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      localToast = new Toast(a());
      localView = LayoutInflater.from(a()).inflate(2131560781, null);
      localToast.setDuration(0);
      localTextView = (TextView)localView.findViewById(2131365681);
      if (!paramBoolean) {
        break label120;
      }
    }
    label120:
    for (String str = a().getResources().getString(2131697141);; str = a().getResources().getString(2131697140))
    {
      localTextView.setText(str);
      localToast.setGravity(17, 0, 0);
      localToast.setView(localView);
      localToast.show();
      return;
    }
  }
  
  public String a()
  {
    return null;
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
  }
  
  public void a(String paramString, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new QCircleRichMediaDownLoadPart.1(this, paramString, paramObject));
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return true;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdc
 * JD-Core Version:    0.7.0.1
 */
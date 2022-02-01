import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class zhz
  extends ReportDialog
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  
  public zhz(Context paramContext)
  {
    super(paramContext);
    super.requestWindowFeature(1);
    super.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramContext = LayoutInflater.from(paramContext).inflate(2131561628, null);
    super.setCanceledOnTouchOutside(true);
    super.setContentView(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131367940));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367938));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367969));
    paramContext = new ScaleAnimation(1.0F, 1.6F, 1.0F, 1.6F, 1, 0.5F, 1, 0.5F);
    paramContext.setDuration(1000L);
    paramContext.setRepeatCount(-1);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.8F, 0.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setRepeatCount(-1);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new zia(this));
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new zib(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhz
 * JD-Core Version:    0.7.0.1
 */
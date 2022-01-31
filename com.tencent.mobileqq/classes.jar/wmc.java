import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.comment.ActionSheetDialog.1;
import com.tencent.biz.subscribe.comment.ActionSheetDialog.4;
import java.util.ArrayList;

public class wmc
  extends wos
  implements DialogInterface.OnCancelListener, Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  protected Context a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArrayList<Button> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected Context b;
  private LinearLayout b;
  
  public wmc(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    setContentView(2131558713);
    a();
    c();
    b();
  }
  
  public wmc(Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {}
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364872));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369656));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131361891));
    this.jdField_a_of_type_AndroidWidgetButton.setDrawingCacheEnabled(false);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362998);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377350));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new wmd(this));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void d()
  {
    Object localObject = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight(), 0.0F);
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(this.jdField_a_of_type_AndroidContentContext, 17432582));
    ((TranslateAnimation)localObject).setDuration(200L);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
  }
  
  private void e()
  {
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight());
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(this.jdField_a_of_type_AndroidContentContext, 17432582));
    ((TranslateAnimation)localObject).setDuration(200L);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
    ((AlphaAnimation)localObject).setAnimationListener(this);
  }
  
  public Button a(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    Button localButton = new Button(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localButton);
    Object localObject = (LinearLayout.LayoutParams)localButton.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = -1;
    ((LinearLayout.LayoutParams)localObject).height = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297170));
    ((LinearLayout.LayoutParams)localObject).bottomMargin = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296648));
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localButton.setText(paramString);
    int i;
    switch (paramInt)
    {
    default: 
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131165229);
      paramInt = 2130838743;
    }
    for (;;)
    {
      localButton.setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(paramInt));
      localButton.setTextColor(i);
      localButton.setTextSize(16.0F);
      localButton.setOnClickListener(paramOnClickListener);
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilArrayList.add(localButton);
      return localButton;
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131166756);
      paramInt = 2130838743;
      continue;
      i = -14207157;
      paramInt = 2130838741;
      continue;
      paramInt = actj.a(8.0F, getContext().getResources());
      paramString = new SpannableString(localButton.getText());
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840068);
      ((Drawable)localObject).setBounds(paramInt, 0, ((Drawable)localObject).getIntrinsicWidth() + paramInt, ((Drawable)localObject).getIntrinsicHeight());
      paramString.setSpan(new ImageSpan((Drawable)localObject, 1), paramString.length() - 1, paramString.length(), 33);
      localButton.setText(paramString);
      i = -16777216;
      paramInt = 2130838743;
      continue;
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167158);
      localButton.setTypeface(Typeface.defaultFromStyle(1));
      paramInt = 2130838743;
      continue;
      i = -14833678;
      paramInt = 2130838743;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetButton.post(new ActionSheetDialog.4(this, paramString));
  }
  
  public void dismiss()
  {
    e();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {}
    try
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(null);
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      dismiss();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      dismiss();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void show()
  {
    if (isShowing()) {}
    while (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
      return;
    }
    super.show();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ActionSheetDialog.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wmc
 * JD-Core Version:    0.7.0.1
 */
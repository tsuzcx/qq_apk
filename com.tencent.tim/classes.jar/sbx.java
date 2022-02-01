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

public class sbx
  extends sdz
  implements DialogInterface.OnCancelListener, Animation.AnimationListener
{
  private Button C;
  protected Context K;
  private int buttonCount;
  private ArrayList<Button> buttonsList = new ArrayList();
  private View.OnClickListener cancelListener;
  private LinearLayout customButtonContainer;
  private Handler handler;
  private View mBackgroundView;
  private LinearLayout mContainer;
  protected Context mContext;
  private TextView mTitleText;
  
  public sbx(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
    this.K = paramContext;
    setContentView(2131558882);
    init();
    bindEvents();
    beF();
  }
  
  public sbx(Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {}
  
  private void bindEvents()
  {
    this.C.setOnClickListener(new sby(this));
    this.handler = new Handler(Looper.getMainLooper());
  }
  
  private void bxR()
  {
    Object localObject = new TranslateAnimation(0.0F, 0.0F, this.mContainer.getHeight(), 0.0F);
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(this.mContext, 17432582));
    ((TranslateAnimation)localObject).setDuration(200L);
    this.mContainer.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    this.mBackgroundView.startAnimation((Animation)localObject);
  }
  
  private void bxS()
  {
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mContainer.getHeight());
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setInterpolator(AnimationUtils.loadInterpolator(this.mContext, 17432582));
    ((TranslateAnimation)localObject).setDuration(200L);
    this.mContainer.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    this.mBackgroundView.startAnimation((Animation)localObject);
    ((AlphaAnimation)localObject).setAnimationListener(this);
  }
  
  private void init()
  {
    this.customButtonContainer = ((LinearLayout)findViewById(2131365560));
    this.mContainer = ((LinearLayout)findViewById(2131370991));
    this.C = ((Button)findViewById(2131361965));
    this.C.setDrawingCacheEnabled(false);
    this.mBackgroundView = findViewById(2131363236);
    this.mTitleText = ((TextView)findViewById(2131379769));
    this.mTitleText.setVisibility(8);
    this.mTitleText.setText("");
  }
  
  public Button addButton(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    Button localButton = new Button(this.mContext);
    this.customButtonContainer.addView(localButton);
    Object localObject = (LinearLayout.LayoutParams)localButton.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = -1;
    ((LinearLayout.LayoutParams)localObject).height = ((int)this.mContext.getResources().getDimension(2131297692));
    ((LinearLayout.LayoutParams)localObject).bottomMargin = ((int)this.mContext.getResources().getDimension(2131296936));
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localButton.setText(paramString);
    int i;
    switch (paramInt)
    {
    default: 
      i = this.K.getResources().getColor(2131165322);
      paramInt = 2130839239;
    }
    for (;;)
    {
      localButton.setBackgroundDrawable(this.K.getResources().getDrawable(paramInt));
      localButton.setTextColor(i);
      localButton.setTextSize(16.0F);
      localButton.setOnClickListener(paramOnClickListener);
      this.buttonCount += 1;
      this.buttonsList.add(localButton);
      return localButton;
      i = this.K.getResources().getColor(2131167179);
      paramInt = 2130839239;
      continue;
      i = -14207157;
      paramInt = 2130839237;
      continue;
      paramInt = wja.dp2px(8.0F, getContext().getResources());
      paramString = new SpannableString(localButton.getText());
      localObject = this.mContext.getResources().getDrawable(2130841025);
      ((Drawable)localObject).setBounds(paramInt, 0, ((Drawable)localObject).getIntrinsicWidth() + paramInt, ((Drawable)localObject).getIntrinsicHeight());
      paramString.setSpan(new ImageSpan((Drawable)localObject, 1), paramString.length() - 1, paramString.length(), 33);
      localButton.setText(paramString);
      i = -16777216;
      paramInt = 2130839239;
      continue;
      i = this.K.getResources().getColor(2131167693);
      localButton.setTypeface(Typeface.defaultFromStyle(1));
      paramInt = 2130839239;
      continue;
      i = -14833678;
      paramInt = 2130839239;
    }
  }
  
  public void dismiss()
  {
    bxS();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.cancelListener != null) {}
    try
    {
      this.cancelListener.onClick(null);
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
  
  public void sZ(String paramString)
  {
    this.C.post(new ActionSheetDialog.4(this, paramString));
  }
  
  public void show()
  {
    if (isShowing()) {}
    while (((this.mContext instanceof Activity)) && (((Activity)this.mContext).isFinishing())) {
      return;
    }
    super.show();
    this.mContainer.setVisibility(4);
    this.mBackgroundView.setVisibility(4);
    this.handler.postDelayed(new ActionSheetDialog.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbx
 * JD-Core Version:    0.7.0.1
 */
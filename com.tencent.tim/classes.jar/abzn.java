import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.view.ApolloGameProcessBar;

public class abzn
  extends aqju
{
  ApolloGameProcessBar a;
  Button mButton;
  
  public abzn(Context paramContext)
  {
    super(paramContext, 2131755397);
    initView(paramContext);
  }
  
  @TargetApi(16)
  private void initView(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    Object localObject = new FrameLayout.LayoutParams(-2, -2, 17);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a = new ApolloGameProcessBar(paramContext, 2130838698, 2130838700);
    localObject = new LinearLayout.LayoutParams(wja.dp2px(80.0F, paramContext.getResources()), wja.dp2px(80.0F, paramContext.getResources()));
    ((LinearLayout.LayoutParams)localObject).setMargins(wja.dp2px(60.5F, paramContext.getResources()), 0, wja.dp2px(60.5F, paramContext.getResources()), 0);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.addView(this.a);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setText(acfp.m(2131702533));
    ((TextView)localObject).setTextSize(16.0F);
    ((TextView)localObject).setTextColor(Color.parseColor("#ababab"));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, wja.dp2px(10.0F, paramContext.getResources()), 0, 0);
    localLayoutParams.gravity = 1;
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localLinearLayout.addView((View)localObject);
    this.mButton = new Button(paramContext);
    this.mButton.setText(acfp.m(2131702524));
    this.mButton.setTextSize(14.0F);
    this.mButton.setTextColor(Color.parseColor("#ffffff"));
    this.mButton.setBackground(paramContext.getResources().getDrawable(2130838699));
    this.mButton.setOnClickListener(new abzo(this));
    localObject = new LinearLayout.LayoutParams(wja.dp2px(100.0F, paramContext.getResources()), wja.dp2px(30.0F, paramContext.getResources()));
    ((LinearLayout.LayoutParams)localObject).setMargins(0, wja.dp2px(35.0F, paramContext.getResources()), 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    this.mButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.addView(this.mButton);
    getWindow().setDimAmount(0.85F);
    getWindow().setGravity(17);
    setContentView(localLinearLayout);
    setCanceledOnTouchOutside(false);
    setCancelable(false);
    this.mButton.setOnClickListener(new abzp(this));
  }
  
  public void setClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mButton != null) {
      this.mButton.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setProgress(int paramInt)
  {
    if (this.a != null) {
      this.a.setProgress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abzn
 * JD-Core Version:    0.7.0.1
 */
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.app.AppRuntime;

public class nhr
  extends ReportDialog
  implements View.OnClickListener
{
  Button bV;
  private Runnable cR;
  private BaseActivity mActivity;
  View mClose;
  TextView tk;
  
  public nhr(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public nhr(@NonNull Context paramContext, Runnable paramRunnable)
  {
    this(paramContext, 0);
    this.cR = paramRunnable;
  }
  
  public static boolean a(BaseActivity paramBaseActivity, Runnable paramRunnable)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramBaseActivity);
    boolean bool1 = localSharedPreferences.getBoolean("qq_readinjoy_user_protocol_agreed_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), false);
    boolean bool2 = localSharedPreferences.getString("qq_readinjoy_user_protocol_92_switch_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0").equals("1");
    if ((bool1) || (!bool2))
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return true;
    }
    paramRunnable = new nhr(paramBaseActivity, paramRunnable);
    paramRunnable.mActivity = paramBaseActivity;
    paramRunnable.show();
    kbp.a(null, "", "0X800992C", "0X800992C", 0, 0, "", "", "", "");
    return false;
  }
  
  private Drawable ao()
  {
    float f = wja.dp2px(3.0F, getContext().getResources());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(Color.parseColor("#12B7F5"));
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    return localShapeDrawable;
  }
  
  private Drawable ap()
  {
    float f = wja.dp2px(3.0F, getContext().getResources());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(-1);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    return localShapeDrawable;
  }
  
  private SpannableString e()
  {
    int i = "".indexOf("《QQ看点用户行为规范》");
    SpannableString localSpannableString = new SpannableString("");
    localSpannableString.setSpan(new nhs(this, Color.parseColor("#12B7F5")), i, "《QQ看点用户行为规范》".length() + i, 33);
    return localSpannableString;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.mClose) {
      dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.bV)
      {
        PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putBoolean("qq_readinjoy_user_protocol_agreed_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), true).apply();
        dismiss();
        if (this.cR != null) {
          this.cR.run();
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131560351, null);
    this.tk = ((TextView)paramBundle.findViewById(2131365393));
    this.tk.setFocusable(false);
    this.bV = ((Button)paramBundle.findViewById(2131362355));
    this.mClose = paramBundle.findViewById(2131364694);
    this.tk.setText(e());
    this.tk.setMovementMethod(new nhr.a());
    this.bV.setOnClickListener(this);
    this.bV.setBackgroundDrawable(ao());
    this.mClose.setOnClickListener(this);
    Drawable localDrawable = ap();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramBundle.findViewById(2131363410).setBackgroundDrawable(localDrawable);
    setContentView(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -2;
    paramBundle.width = wja.dp2px(320.0F, getContext().getResources());
    getWindow().setAttributes(paramBundle);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
  }
  
  public static class a
    extends LinkMovementMethod
  {
    public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      boolean bool = super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 0)) {
        Selection.removeSelection(paramSpannable);
      }
      paramTextView.setPressed(false);
      paramTextView.setFocusable(false);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhr
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class akkn
  extends ReportDialog
{
  protected TextView Wj;
  protected View.OnClickListener fw = new akko(this);
  protected RelativeLayout gc;
  protected LinearLayout iu;
  protected ImageView mCloseView;
  protected TextView mTitleView;
  
  public akkn(Context paramContext)
  {
    super(paramContext, 2131756467);
    init();
  }
  
  private void init()
  {
    setContentView(2131559145);
    this.gc = ((RelativeLayout)findViewById(2131368407));
    this.mTitleView = ((TextView)findViewById(2131379769));
    this.Wj = ((TextView)findViewById(2131371103));
    this.iu = ((LinearLayout)findViewById(2131363674));
    this.mCloseView = ((ImageView)findViewById(2131368994));
    this.mCloseView.setOnClickListener(this.fw);
    this.mCloseView.setContentDescription(acfp.m(2131708674));
  }
  
  public akkn a(akki paramakki)
  {
    Button localButton = new Button(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = rpq.dip2px(getContext(), 10.0F);
    Object localObject;
    if (paramakki.mContent != null)
    {
      localObject = paramakki.mContent;
      localButton.setText((CharSequence)localObject);
      localButton.setTextSize(20.0F);
      if (paramakki.mBackgroundDrawable == null) {
        break label134;
      }
      localObject = paramakki.mBackgroundDrawable;
      label76:
      localButton.setBackgroundDrawable((Drawable)localObject);
      if (paramakki.mTextColor == -1) {
        break label150;
      }
    }
    label134:
    label150:
    for (int i = paramakki.mTextColor;; i = -1)
    {
      localButton.setTextColor(i);
      localButton.setOnClickListener(new akkp(this, paramakki));
      this.iu.addView(localButton, localLayoutParams);
      return this;
      localObject = "";
      break;
      localObject = getContext().getResources().getDrawable(2130839524);
      break label76;
    }
  }
  
  public akkn a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.gc.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public akkn a(CharSequence paramCharSequence)
  {
    this.mTitleView.setText(paramCharSequence);
    return this;
  }
  
  public akkn b(CharSequence paramCharSequence)
  {
    this.Wj.setText(paramCharSequence);
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkn
 * JD-Core Version:    0.7.0.1
 */
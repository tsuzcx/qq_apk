import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ubp
  extends ReportDialog
{
  public static boolean aQQ;
  private ImageView mAppIcon;
  private TextView mAppName;
  private TextView mAuthDesc;
  private TextView mAuthTitle;
  private Context mContext;
  private TextView mLeftBtn;
  private TextView mRightBtn;
  private ImageView mUserIcon;
  private TextView mUserName;
  
  public ubp(@NonNull Context paramContext)
  {
    super(paramContext, 2131755457);
    initViews(paramContext);
  }
  
  private void initViews(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131559731, null);
    setContentView(paramContext);
    this.mAppIcon = ((ImageView)$(paramContext, 2131362847));
    this.mAppName = ((TextView)$(paramContext, 2131362859));
    this.mAuthTitle = ((TextView)$(paramContext, 2131363115));
    this.mUserIcon = ((ImageView)$(paramContext, 2131381405));
    this.mUserName = ((TextView)$(paramContext, 2131381433));
    this.mAuthDesc = ((TextView)$(paramContext, 2131363105));
    this.mAuthDesc.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.mLeftBtn = ((TextView)$(paramContext, 2131370358));
    this.mRightBtn = ((TextView)$(paramContext, 2131377294));
    setCanceledOnTouchOutside(false);
    paramContext = getWindow();
    if (paramContext != null) {
      paramContext.setGravity(80);
    }
  }
  
  public <T extends View> T $(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public void bFi()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void mm(String paramString)
  {
    if (jqc.isValidUrl(paramString))
    {
      paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
      ViewGroup.LayoutParams localLayoutParams = this.mAppIcon.getLayoutParams();
      paramString.setTag(aqbn.d(localLayoutParams.width, localLayoutParams.height, rpq.dip2px(this.mContext, 5.0F)));
      paramString.setDecodeHandler(aqbn.a);
      this.mAppIcon.setImageDrawable(paramString);
    }
  }
  
  public void s(View.OnClickListener paramOnClickListener)
  {
    this.mRightBtn.setOnClickListener(new ubq(this, paramOnClickListener));
  }
  
  public void setAppName(String paramString)
  {
    this.mAppName.setText(paramString);
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    setOnCancelListener(new ubs(this, paramOnCancelListener));
    setOnKeyListener(new ubt(this, paramOnCancelListener));
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void t(View.OnClickListener paramOnClickListener)
  {
    this.mLeftBtn.setOnClickListener(new ubr(this, paramOnClickListener));
  }
  
  public void uK(String paramString)
  {
    this.mAuthTitle.setText(paramString);
  }
  
  public void uL(String paramString)
  {
    this.mAuthDesc.setText(paramString);
  }
  
  public void uM(String paramString)
  {
    this.mRightBtn.setText(paramString);
  }
  
  public void uN(String paramString)
  {
    this.mLeftBtn.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubp
 * JD-Core Version:    0.7.0.1
 */
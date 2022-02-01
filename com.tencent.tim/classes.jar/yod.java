import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class yod
  extends ReportDialog
{
  private View mContainerView;
  private String mTitle;
  
  public yod(Context paramContext)
  {
    super(paramContext, 2131755744);
  }
  
  public yod(Context paramContext, String paramString)
  {
    super(paramContext, 2131755744);
    this.mTitle = paramString;
  }
  
  public View C(int paramInt)
  {
    if (this.mContainerView != null) {
      return this.mContainerView.findViewById(paramInt);
    }
    return null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131561785, null);
    Object localObject = getWindow();
    ((Window)localObject).setContentView(paramBundle);
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 48;
    localLayoutParams.y += getContext().getResources().getDimensionPixelOffset(2131299722);
    ((Window)localObject).setAttributes(localLayoutParams);
    if (!TextUtils.isEmpty(this.mTitle))
    {
      localObject = (TextView)paramBundle.findViewById(2131371994);
      if (localObject != null) {
        ((TextView)localObject).setText(this.mTitle);
      }
    }
    this.mContainerView = paramBundle;
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yod
 * JD-Core Version:    0.7.0.1
 */
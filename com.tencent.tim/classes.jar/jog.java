import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.QQAnonymousDialog.2;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class jog
  extends ReportDialog
{
  public int aCx;
  public ImageView hk;
  public Context mContext;
  public Handler mHandler = new Handler(new joh(this));
  public LayoutInflater mInflater;
  public View mRootView;
  public TextView np;
  
  public jog(Context paramContext)
  {
    super(paramContext, 2131756467);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mRootView = this.mInflater.inflate(2131560762, null);
    this.np = ((TextView)this.mRootView.findViewById(2131370799));
    this.hk = ((ImageView)this.mRootView.findViewById(2131370810));
  }
  
  public void al(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
    case 1: 
    case 3: 
      do
      {
        do
        {
          return;
          this.hk.setImageResource(2130844467);
          this.np.setText(paramString);
        } while (!AppSetting.enableTalkBack);
        QQAppInterface.EI(paramString);
        return;
        this.hk.setImageResource(2130844461);
        this.np.setText(paramString);
      } while (!AppSetting.enableTalkBack);
      QQAppInterface.EI(paramString);
      return;
    }
    this.aCx = 0;
    this.hk.setImageResource(2130844466);
    this.np.setText(this.mContext.getResources().getString(2131698288));
  }
  
  public void ayG()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.hk.getLayoutParams();
    localLayoutParams.width = ((int)aqho.convertDpToPixel(this.mContext, 44.0F));
    localLayoutParams.height = ((int)aqho.convertDpToPixel(this.mContext, 44.0F));
    super.show();
    this.mRootView.postDelayed(new QQAnonymousDialog.2(this), 1000L);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.mRootView);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 17;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jog
 * JD-Core Version:    0.7.0.1
 */
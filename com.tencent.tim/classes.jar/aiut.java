import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.location.window.CanBackFrameLayout;
import com.tencent.mobileqq.location.window.GlobalFloatDialogEventReceiver;
import com.tencent.qphone.base.util.BaseApplication;

public class aiut
{
  private final TextView Dk;
  private final TextView Dl = (TextView)this.contentView.findViewById(2131365852);
  private final TextView Uw;
  private CanBackFrameLayout jdField_a_of_type_ComTencentMobileqqLocationWindowCanBackFrameLayout = (CanBackFrameLayout)this.contentView.findViewById(2131365888);
  private GlobalFloatDialogEventReceiver jdField_a_of_type_ComTencentMobileqqLocationWindowGlobalFloatDialogEventReceiver;
  private final View contentView = View.inflate(BaseApplicationImpl.context, 2131559134, null);
  private WindowManager windowManager = (WindowManager)BaseApplicationImpl.context.getSystemService("window");
  
  public aiut()
  {
    this.Dl.setOnClickListener(new aiuu(this));
    this.Dk = ((TextView)this.contentView.findViewById(2131365858));
    this.Dk.setOnClickListener(new aiuv(this));
    this.Uw = ((TextView)this.contentView.findViewById(2131365867));
    this.Uw.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowGlobalFloatDialogEventReceiver = new GlobalFloatDialogEventReceiver();
  }
  
  public void I(View.OnClickListener paramOnClickListener)
  {
    this.Dl.setOnClickListener(new aiuw(this, paramOnClickListener));
  }
  
  public void J(View.OnClickListener paramOnClickListener)
  {
    this.Dk.setOnClickListener(new aiux(this, paramOnClickListener));
  }
  
  public void LX(String paramString)
  {
    this.Dl.setText(paramString);
  }
  
  public void LY(String paramString)
  {
    this.Dk.setText(paramString);
  }
  
  public void dismiss()
  {
    this.windowManager.removeView(this.contentView);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowGlobalFloatDialogEventReceiver.lq();
  }
  
  public void pause()
  {
    this.contentView.setVisibility(8);
  }
  
  public void resume()
  {
    this.contentView.setVisibility(0);
  }
  
  public void setBackKeyListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowCanBackFrameLayout.setBackKeyListener(new aiuy(this, paramOnClickListener));
  }
  
  public void setContentText(String paramString)
  {
    ((TextView)this.contentView.findViewById(2131365863)).setText(paramString);
  }
  
  public void show()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (Build.VERSION.SDK_INT >= 26) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = -3;
      localLayoutParams.height = aqnm.getScreenHeight();
      localLayoutParams.width = aqnm.getScreenWidth();
      this.windowManager.addView(this.contentView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqLocationWindowGlobalFloatDialogEventReceiver.a(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiut
 * JD-Core Version:    0.7.0.1
 */
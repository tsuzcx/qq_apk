import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;
import dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder.1;
import dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder.2;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class awzw
  extends awwn
{
  private AEProviderContainerView f;
  
  public awzw(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  public void a(alwn paramalwn)
  {
    aA(new BeautyAndFilterPanelViewStubHolder.1(this, paramalwn));
  }
  
  public boolean aOd()
  {
    if (!aOe()) {
      return false;
    }
    return this.f.aOd();
  }
  
  public void apk()
  {
    if (!aOe()) {
      return;
    }
    this.f.apk();
  }
  
  public void dLp()
  {
    if (!aOe()) {
      return;
    }
    this.f.dLp();
  }
  
  public void eHZ()
  {
    if (!aOe()) {
      return;
    }
    this.f.eHZ();
  }
  
  protected void jm(View paramView)
  {
    this.f = ((AEProviderContainerView)paramView.findViewById(2131363367));
  }
  
  public void onDestroy()
  {
    if (!aOe()) {
      return;
    }
    this.f.onDestroy();
  }
  
  public void onResume()
  {
    if (!aOe()) {
      return;
    }
    this.f.onResume();
  }
  
  public void onStop()
  {
    if (!aOe()) {
      return;
    }
    this.f.onStop();
  }
  
  public void setCaptureMode(AECaptureMode paramAECaptureMode)
  {
    if (!aOe()) {
      return;
    }
    this.f.setCaptureMode(paramAECaptureMode);
  }
  
  public void setControllerAndManager(awwk paramawwk, axgi paramaxgi)
  {
    aA(new BeautyAndFilterPanelViewStubHolder.2(this, paramawwk, paramaxgi));
  }
  
  public void show()
  {
    eHc();
    this.f.setVisibility(0);
    this.f.eId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzw
 * JD-Core Version:    0.7.0.1
 */
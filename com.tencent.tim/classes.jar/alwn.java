import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class alwn
  implements GLGestureListener
{
  private alwn.a a;
  protected ProviderContainerView a;
  protected AEMaterialPanel a;
  protected AEProviderContainerView a;
  protected QIMProviderContainerView a;
  protected View mRootView;
  
  public alwn() {}
  
  public alwn(QIMProviderContainerView paramQIMProviderContainerView)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView = paramQIMProviderContainerView;
  }
  
  public void a(alwn.a parama)
  {
    this.jdField_a_of_type_Alwn$a = parama;
  }
  
  public void a(AEMaterialPanel paramAEMaterialPanel)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = paramAEMaterialPanel;
  }
  
  public void a(AEProviderContainerView paramAEProviderContainerView)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView = paramAEProviderContainerView;
  }
  
  public void dX(View paramView)
  {
    this.mRootView = paramView;
  }
  
  public int onGetPriority()
  {
    return 1060;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int j = paramMotionEvent.getPointerCount();
    int k = paramMotionEvent.getAction() & 0xFF;
    Object localObject = new StringBuilder().append("action: ").append(k).append(" event Y: ").append(paramMotionEvent.getY()).append(" container view height: ");
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight())
    {
      axiy.d("CameraProviderViewGesture", i);
      if ((j == 1) && (!paramBoolean)) {}
      switch (k)
      {
      default: 
        return false;
      }
    }
    if (this.mRootView != null) {}
    for (localObject = this.mRootView;; localObject = GLGestureProxy.getInstance().getGLSurfaceView())
    {
      if (this.jdField_a_of_type_Alwn$a != null) {
        this.jdField_a_of_type_Alwn$a.dKp();
      }
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.getHeight())) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.dLp();
      }
      if ((localObject != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.getHeight()))
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCloseEventTouch(true);
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.dLp();
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCloseEventTouch(false);
      }
      if ((localObject != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight()))
      {
        axiy.d("CameraProviderViewGesture", "in hide close panel.");
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.XW(true);
      }
      if ((localObject == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView == null) || (paramMotionEvent.getY() >= ((View)localObject).getHeight() - this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.getHeight())) {
        break;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.dLp();
      return false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void dKp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwn
 * JD-Core Version:    0.7.0.1
 */
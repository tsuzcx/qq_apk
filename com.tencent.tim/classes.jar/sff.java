import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.a;
import com.tencent.qg.StoryQGSurfaceView;
import com.tencent.qg.doraemon.impl.DoraemonApiWrapperImpl;
import com.tencent.qg.sdk.QGJNIBridge;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.view.NestedScrollingParentLayout;
import java.util.Set;

public class sff
  extends aycl
  implements EffectsCameraCaptureView.a, IEventReceiver, sfa.a, sfh.a
{
  private StoryQGSurfaceView jdField_a_of_type_ComTencentQgStoryQGSurfaceView;
  private DoraemonApiWrapperImpl jdField_a_of_type_ComTencentQgDoraemonImplDoraemonApiWrapperImpl;
  NestedScrollingParentLayout jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout;
  sfh jdField_a_of_type_Sfh;
  private boolean aLe;
  private boolean aLf;
  private boolean aLg;
  private boolean aLh;
  private boolean aLi;
  public boolean aLj;
  private Set<Object> aQ;
  private pno c;
  private View mRootView;
  private TextView zL;
  
  private void byh() {}
  
  private void uB(boolean paramBoolean)
  {
    if ((this.aLf) && (!paramBoolean) && (aycj.a().eJC != 0)) {
      aycj.a().eQf();
    }
    this.aLf = paramBoolean;
    if (paramBoolean)
    {
      uC(false);
      return;
    }
    byh();
  }
  
  private void uC(boolean paramBoolean) {}
  
  void byi() {}
  
  public void initView()
  {
    rar.a("video_game", "clk_tab", 0, 0, new String[0]);
  }
  
  public boolean isSupport()
  {
    return false;
  }
  
  public boolean isValidate()
  {
    return (this.dyn) && (!this.avm);
  }
  
  public void o(int paramInt, View paramView) {}
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    ram.d("StoryEffectGameMode", "onActivityDestroy");
    if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView != null) {
      byi();
    }
    if (this.zL != null) {
      ((ViewGroup)this.mBaseView).removeView(this.zL);
    }
    if (this.aQ != null) {
      this.aQ.clear();
    }
    if (this.jdField_a_of_type_ComTencentQgDoraemonImplDoraemonApiWrapperImpl != null) {
      this.jdField_a_of_type_ComTencentQgDoraemonImplDoraemonApiWrapperImpl.release();
    }
    if (this.c != null) {
      this.c.stop();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    ram.d("StoryEffectGameMode", "onActivityResume");
    if (this.aLh)
    {
      uB(false);
      if (this.jdField_a_of_type_Sfh != null) {
        this.jdField_a_of_type_Sfh.a();
      }
    }
    for (;;)
    {
      this.aLh = false;
      this.jdField_a_of_type_Awsy.a();
      if (this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout.setOnResume(true);
      }
      if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView != null) {
        this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.onResume();
      }
      return;
      uA(true);
    }
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    if (QLog.isColorLevel()) {
      QLog.d("StoryEffectGameMode", 2, "onActivityStop");
    }
    this.aLh = true;
    if (this.mRootView != null) {
      uB(false);
    }
    if (this.aLg)
    {
      this.aLi = true;
      this.aLj = true;
      this.jdField_a_of_type_Awsy.coB();
      this.aLg = false;
      ram.d("StoryEffectGameMode", "cancelGameRecord");
    }
    if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView != null)
    {
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.getQGBridge().clearRegisteredEvents();
      CameraCaptureView localCameraCaptureView = this.jdField_a_of_type_Awsy.a();
      if (!(localCameraCaptureView instanceof EffectsCameraCaptureView)) {
        break label145;
      }
      ((EffectsCameraCaptureView)localCameraCaptureView).a(false, true, false, false, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.onPause();
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.reset();
      if (this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewNestedScrollingParentLayout.setOnResume(false);
      }
      return;
      label145:
      ram.d("StoryEffectGameMode", "震惊！呼叫leo！！有人偷偷把cameraCaptureView换掉了！！！");
    }
  }
  
  public void shutdown() {}
  
  public void uA(boolean paramBoolean) {}
  
  public void uz(boolean paramBoolean)
  {
    super.uz(paramBoolean);
  }
  
  public void w(double paramDouble)
  {
    if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView != null)
    {
      double d = paramDouble;
      if (Double.isInfinite(paramDouble)) {
        d = 40.0D;
      }
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.getQGBridge().dispatchJSEvent("qg_story_media_decibel", String.valueOf(d));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sff
 * JD-Core Version:    0.7.0.1
 */
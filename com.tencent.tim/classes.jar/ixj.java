import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ixj
  extends ill
{
  public ixj(AVActivity paramAVActivity) {}
  
  protected void anV()
  {
    jjb.a("switch_camera", "onBeforeSwitchCamera", 3, new Object[0]);
    if (this.this$0.mControlUI != null) {
      this.this$0.mControlUI.L(2131374253, false);
    }
  }
  
  protected void bZ(long paramLong)
  {
    Object localObject;
    boolean bool;
    if (QLog.isDevelopLevel())
    {
      localObject = this.this$0.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("onBeforeCloseCamera, mControlUI[");
      if (this.this$0.mControlUI != null)
      {
        bool = true;
        QLog.w((String)localObject, 1, bool + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if (!this.this$0.isDestroyed()) {
        break label86;
      }
    }
    label86:
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while ((this.this$0.mControlUI == null) || (this.this$0.mControlUI.isDestroyed()));
      this.this$0.mControlUI.bZ(paramLong);
      if (this.this$0.mControlUI.a() != null) {
        this.this$0.mControlUI.a().ma(3);
      }
      localObject = VideoController.a().a(this.this$0);
    } while (localObject == null);
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 1, "onHide clear state");
    }
    ((iov)localObject).uninit();
  }
  
  protected void d(long paramLong, boolean paramBoolean, int paramInt)
  {
    QLog.w(this.this$0.TAG, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], mRotationAngle[" + this.this$0.auI + "], mShutCamera[" + this.this$0.VD + "], seq[" + paramLong + "]");
    if (this.this$0.isDestroyed()) {}
    label224:
    do
    {
      do
      {
        return;
      } while ((this.this$0.mControlUI == null) || (this.this$0.mControlUI.isDestroyed()));
      this.this$0.mControlUI.O(paramLong, 65535);
      this.this$0.mControlUI.E(paramLong, this.this$0.auI);
      this.this$0.mControlUI.d(paramLong, paramBoolean, paramInt);
      ikg.a().ih(this.this$0.jdField_b_of_type_ComTencentAvCameraCameraUtils.isFrontCamera());
      if (this.this$0.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        if (this.this$0.a.b().anb == 2) {
          break;
        }
        this.this$0.jdField_b_of_type_ComTencentAvUiVideoLayerUI.F(this.this$0.auI, false);
        this.this$0.jdField_b_of_type_ComTencentAvUiVideoLayerUI.R(paramLong, this.this$0.jdField_b_of_type_ComTencentAvCameraCameraUtils.isFrontCamera());
      }
      if (this.this$0.a.b().anb != 2) {
        this.this$0.jdField_b_of_type_ComTencentAvCameraCameraUtils.setRotation(this.this$0.auI);
      }
    } while (paramBoolean);
    this.this$0.VD = true;
    String str;
    if ((this.this$0.a != null) && (this.this$0.a.b() != null))
    {
      str = "";
      if (!this.this$0.a.b().ti()) {
        break label429;
      }
      str = "0X8004894";
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.this$0.mApp == null) {
        break;
      }
      this.this$0.mApp.l(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
      return;
      this.this$0.jdField_b_of_type_ComTencentAvUiVideoLayerUI.setRotation(this.this$0.auI);
      break label224;
      label429:
      if (this.this$0.a.b().amK == 1) {
        str = "0X8004888";
      } else if (this.this$0.a.b().amK == 2) {
        str = "0X800488E";
      }
    }
  }
  
  protected void ip(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    jjb.a("switch_camera", "onAfterSwitchCamera", 3, new Object[] { Long.valueOf(l) });
    QLog.w(this.this$0.TAG, 1, "onAfterSwitchCamera, success[" + paramBoolean + "], seq[" + l + "]");
    if (paramBoolean)
    {
      if (this.this$0.mControlUI != null) {
        this.this$0.mControlUI.L(2131374253, true);
      }
      if (this.this$0.jdField_b_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.this$0.jdField_b_of_type_ComTencentAvUiVideoLayerUI.kC(this.this$0.jdField_b_of_type_ComTencentAvCameraCameraUtils.isFrontCamera());
      }
      if (this.this$0.jdField_b_of_type_ComTencentAvCameraCameraUtils != null) {
        ikg.a().ih(this.this$0.jdField_b_of_type_ComTencentAvCameraCameraUtils.isFrontCamera());
      }
      return;
    }
    this.this$0.cH(l);
  }
  
  protected void r(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.TAG, 1, "onBeforeOpenCamera, bLastOpen[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    if (this.this$0.isDestroyed()) {}
    while ((this.this$0.mControlUI == null) || (this.this$0.mControlUI.isDestroyed())) {
      return;
    }
    this.this$0.mControlUI.O(paramLong, 65535);
  }
  
  protected void s(long paramLong, boolean paramBoolean)
  {
    boolean bool;
    if (QLog.isDevelopLevel())
    {
      localObject = this.this$0.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("onAfterCloseCamera, success[").append(paramBoolean).append("], mControlUI[");
      if (this.this$0.mControlUI != null)
      {
        bool = true;
        QLog.w((String)localObject, 1, bool + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if (!this.this$0.isDestroyed()) {
        break label100;
      }
    }
    label100:
    while ((this.this$0.mControlUI == null) || (this.this$0.mControlUI.isDestroyed()))
    {
      return;
      bool = false;
      break;
    }
    Object localObject = this.this$0.a.a;
    this.this$0.a.a = null;
    if (localObject != null) {
      ((jjo)localObject).clear();
    }
    this.this$0.mControlUI.s(paramLong, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixj
 * JD-Core Version:    0.7.0.1
 */
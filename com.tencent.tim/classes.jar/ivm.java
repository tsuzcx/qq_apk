import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin.1;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ivm
{
  private static volatile ivm jdField_a_of_type_Ivm;
  boolean Vq = false;
  public boolean Vr = true;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  public VideoAppInterface mApp;
  
  private ivm(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
  }
  
  public static ivm a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_a_of_type_Ivm == null) {}
    try
    {
      if (jdField_a_of_type_Ivm == null) {
        jdField_a_of_type_Ivm = new ivm(paramVideoAppInterface);
      }
      return jdField_a_of_type_Ivm;
    }
    finally {}
  }
  
  public void aqT()
  {
    this.Vq = false;
  }
  
  public void jd(boolean paramBoolean)
  {
    if (ivv.tY())
    {
      this.Vq = false;
      this.Vr = false;
    }
  }
  
  public void onBackPressed()
  {
    if (ivv.tY()) {
      this.Vq = false;
    }
  }
  
  public void onResume()
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenActivityPlugin", 1, "onResume, seq[" + l + "]");
    }
    if (ivv.tY())
    {
      this.Vq = false;
      this.Vr = true;
      ThreadManager.excute(new SmallScreenActivityPlugin.1(this, l), 16, null, false);
    }
    ivv.a(l, this.mApp, 0);
  }
  
  public boolean vA()
  {
    return (this.Vq) || (!ivv.tY());
  }
  
  public void x(long paramLong, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = VideoController.isScreenOn(this.mApp.getApp());
    if ((QLog.isColorLevel()) || (!bool2) || (paramBoolean)) {
      QLog.w("SmallScreenActivityPlugin", 1, "onPauseRender, isQuit[" + paramBoolean + "], isScreenOn[" + bool2 + "], seq[" + paramLong + "]");
    }
    iiv localiiv;
    if (!paramBoolean)
    {
      if (!ivv.tY()) {
        break label170;
      }
      localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
      int i = localiiv.amI;
      paramBoolean = bool1;
      if (i != 2) {
        if (i != 4) {
          break label165;
        }
      }
    }
    label165:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      ThreadManager.excute(new SmallScreenActivityPlugin.2(this, paramLong, bool2, this.jdField_a_of_type_ComTencentAvVideoController.a().wG(), paramBoolean), 16, null, false);
      ivv.a(this.mApp.getApp(), localiiv);
      return;
    }
    label170:
    ivv.a(paramLong, this.mApp, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivm
 * JD-Core Version:    0.7.0.1
 */
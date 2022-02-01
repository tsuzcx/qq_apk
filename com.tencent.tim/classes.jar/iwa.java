import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.qphone.base.util.QLog;

class iwa
  extends ill
{
  iwa(ivz paramivz) {}
  
  protected void anV() {}
  
  protected void d(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    }
    if (paramBoolean)
    {
      if ((this.this$0.mApp != null) && (ivv.tY()) && ((paramInt == 1) || (paramInt == 3)) && (this.this$0.jdField_a_of_type_Iwb != null))
      {
        this.this$0.jdField_a_of_type_Iwb.d(true, false);
        this.this$0.jdField_a_of_type_Iwb.R(paramLong, this.this$0.b.isFrontCamera());
      }
      return;
    }
    String str;
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b() != null))
    {
      str = "";
      if (!this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().ti()) {
        break label250;
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
      label250:
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().amK == 1) {
        str = "0X8004888";
      } else if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().amK == 2) {
        str = "0X800488E";
      }
    }
  }
  
  protected void ip(boolean paramBoolean) {}
  
  protected void s(long paramLong, boolean paramBoolean)
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && ((this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1011) || (this.this$0.jdField_a_of_type_ComTencentAvVideoController.OD)))
    {
      this.this$0.jdField_a_of_type_Iwb.d(false, false);
      this.this$0.jdField_a_of_type_Iwb.arv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwa
 * JD-Core Version:    0.7.0.1
 */
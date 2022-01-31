import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class bjm
  implements MultiVideoMembersClickListener
{
  public bjm(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().a == 4) {
      this.a.W();
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI", 2, "mMembersOnClickListener,Uin=" + paramLong + ",videoScr=" + paramInt + "isNeedRequest" + paramBoolean);
    }
    if ((!paramBoolean) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong == this.a.jdField_a_of_type_ComTencentAvVideoController.a().c) && (paramInt != 0))
    {
      this.a.w();
      this.a.W();
      if (paramInt == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8004426", "0X8004426", 0, 0, "", "", "", "");
      }
    }
    while ((paramInt == 0) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null))
    {
      do
      {
        return;
      } while (paramInt != 2);
      ReportController.b(null, "CliOper", "", "", "0X8004427", "0X8004427", 0, 0, "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_Bjq.a = new bjv(this.a, paramLong, paramInt, paramBoolean);
    this.a.jdField_a_of_type_Bjq.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjm
 * JD-Core Version:    0.7.0.1
 */
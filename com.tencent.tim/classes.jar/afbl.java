import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.a;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.b;

public class afbl
  implements DialogInterface.OnClickListener
{
  public afbl(DataReportSettingFragment.b paramb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    afbx.a().b(this.a.jdField_a_of_type_Afbe);
    this.a.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbl
 * JD-Core Version:    0.7.0.1
 */
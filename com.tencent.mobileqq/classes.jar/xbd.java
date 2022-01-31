import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class xbd
  implements View.OnClickListener
{
  xbd(xay paramxay) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText(this.a.jdField_a_of_type_JavaLangString);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.a.d);
    this.a.jdField_a_of_type_Xah.a = this.a.d;
    this.a.jdField_a_of_type_Xah.d = this.a.e;
    this.a.dismiss();
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a == 3)) {
      LpReportInfo_pf00064.allReport(615, 3, 3);
    }
    wtb.a("0X80076C5");
    wtb.b("0X80075D9");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbd
 * JD-Core Version:    0.7.0.1
 */
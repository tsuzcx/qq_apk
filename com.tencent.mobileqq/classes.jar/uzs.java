import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class uzs
  implements View.OnClickListener
{
  uzs(uzn paramuzn) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText(this.a.jdField_a_of_type_JavaLangString);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.a.d);
    this.a.jdField_a_of_type_Uyw.a = this.a.d;
    this.a.jdField_a_of_type_Uyw.d = this.a.e;
    this.a.dismiss();
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a == 3)) {
      LpReportInfo_pf00064.allReport(615, 3, 3);
    }
    urq.a("0X80076C5");
    urq.b("0X80075D9");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzs
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class vax
  implements vbz
{
  private vax(DoodleLayout paramDoodleLayout) {}
  
  private void a()
  {
    this.a.a(new View[] { this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout });
    this.a.a(false);
    this.a.b(new View[] { this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    this.a.setDoodleGLViewVisibility(0);
    this.a.c(0);
    this.a.d(0);
  }
  
  public void a(uyv paramuyv, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    urk.a("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s ", paramuyv, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    a();
    uyb localuyb = new uyb(paramFloat1, paramFloat2 + this.a.a(), paramFloat3, 0.0F, 0.0F, 0.0F, paramuyv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), paramuyv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a == 3))
    {
      LpReportInfo_pf00064.allReport(615, 6);
      LpReportInfo_pf00064.allReport(615, 4, 2);
    }
    if (this.a.a().a(paramuyv.jdField_a_of_type_JavaLangString, paramuyv.b, paramuyv.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localuyb))
    {
      DoodleLayout.a("clk_oneface");
      urq.a("0X80076CA");
      urq.b("0X80075DF");
    }
  }
  
  public void a(vcb paramvcb)
  {
    urk.b("DoodleLayout", "onLocationFaceSelected, pictureUrl:" + paramvcb.d);
    a();
    this.a.a(paramvcb);
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a == 3) {
      LpReportInfo_pf00064.report(615, 6);
    }
    urq.b("0X80075E3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vax
 * JD-Core Version:    0.7.0.1
 */
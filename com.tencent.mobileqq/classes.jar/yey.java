import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class yey
  implements yga
{
  private yey(DoodleLayout paramDoodleLayout) {}
  
  private void a()
  {
    this.a.a(new View[] { this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout });
    this.a.a(false);
    this.a.b(new View[] { this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    this.a.setDoodleGLViewVisibility(0);
    this.a.c(0);
    this.a.d(0);
  }
  
  public void a(ydd paramydd, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    xvv.a("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s ", paramydd, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    a();
    yck localyck = new yck(paramFloat1, paramFloat2 + this.a.a(), paramFloat3, 0.0F, 0.0F, 0.0F, paramydd.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), paramydd.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3))
    {
      LpReportInfo_pf00064.allReport(615, 6);
      LpReportInfo_pf00064.allReport(615, 4, 2);
    }
    if (this.a.a().a(paramydd.jdField_a_of_type_JavaLangString, paramydd.b, paramydd.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localyck))
    {
      DoodleLayout.a("clk_oneface");
      xwb.a("0X80076CA");
      xwb.b("0X80075DF");
    }
  }
  
  public void a(ygc paramygc)
  {
    xvv.b("DoodleLayout", "onLocationFaceSelected, pictureUrl:" + paramygc.d);
    a();
    this.a.a(paramygc);
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3) {
      LpReportInfo_pf00064.report(615, 6);
    }
    xwb.b("0X80075E3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yey
 * JD-Core Version:    0.7.0.1
 */
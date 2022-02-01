import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class ytr
  implements yut
{
  private ytr(DoodleLayout paramDoodleLayout) {}
  
  private void a()
  {
    this.a.a(new View[] { this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout });
    this.a.a(false);
    this.a.b(new View[] { this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    this.a.setDoodleGLViewVisibility(0);
    this.a.c(0);
    this.a.d(0);
  }
  
  public void a(yrw paramyrw, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ykq.a("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s ", paramyrw, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    a();
    yrd localyrd = new yrd(paramFloat1, paramFloat2 + this.a.a(), paramFloat3, 0.0F, 0.0F, 0.0F, paramyrw.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), paramyrw.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3))
    {
      LpReportInfo_pf00064.allReport(615, 6);
      LpReportInfo_pf00064.allReport(615, 4, 2);
    }
    yqv localyqv = this.a.a();
    if ((localyqv != null) && (localyqv.a(paramyrw.jdField_a_of_type_JavaLangString, paramyrw.b, paramyrw.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localyrd)))
    {
      DoodleLayout.a("clk_oneface");
      ykw.a("0X80076CA");
      ykw.b("0X80075DF");
    }
  }
  
  public void a(yuv paramyuv)
  {
    ykq.b("DoodleLayout", "onLocationFaceSelected, pictureUrl:" + paramyuv.d);
    a();
    this.a.a(paramyuv);
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3) {
      LpReportInfo_pf00064.report(615, 6);
    }
    ykw.b("0X80075E3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytr
 * JD-Core Version:    0.7.0.1
 */
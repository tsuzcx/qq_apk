import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class vbg
  implements uyi
{
  private vbg(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    this.a.d(3);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.a.jdField_a_of_type_Uzn.a(this.a.a().a());
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3) {}
  
  public boolean a(uyj paramuyj)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (paramuyj != null))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((vcw)localObject).d = false;
        if (!(localObject instanceof uxx)) {
          break label124;
        }
        uxt localuxt = this.a.a();
        if (localuxt != null) {
          localuxt.a.add((uxx)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramuyj);
        paramuyj.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label124:
        if ((localObject instanceof uyj))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((uyh)localObject).d();
          }
        }
      }
    }
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbg
 * JD-Core Version:    0.7.0.1
 */
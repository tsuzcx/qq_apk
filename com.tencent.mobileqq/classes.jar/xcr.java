import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class xcr
  implements wzt
{
  private xcr(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    this.a.d(3);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.a.jdField_a_of_type_Xay.a(this.a.a().a());
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3) {}
  
  public boolean a(wzu paramwzu)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (paramwzu != null))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((xeh)localObject).d = false;
        if (!(localObject instanceof wzi)) {
          break label124;
        }
        wze localwze = this.a.a();
        if (localwze != null) {
          localwze.a.add((wzi)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramwzu);
        paramwzu.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label124:
        if ((localObject instanceof wzu))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((wzs)localObject).d();
          }
        }
      }
    }
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xcr
 * JD-Core Version:    0.7.0.1
 */
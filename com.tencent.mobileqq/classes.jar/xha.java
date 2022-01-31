import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class xha
  implements xec
{
  private xha(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    this.a.d(3);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.a.jdField_a_of_type_Xfh.a(this.a.a().a());
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3) {}
  
  public boolean a(xed paramxed)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (paramxed != null))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((xiq)localObject).d = false;
        if (!(localObject instanceof xdr)) {
          break label124;
        }
        xdn localxdn = this.a.a();
        if (localxdn != null) {
          localxdn.a.add((xdr)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramxed);
        paramxed.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label124:
        if ((localObject instanceof xed))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((xeb)localObject).d();
          }
        }
      }
    }
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xha
 * JD-Core Version:    0.7.0.1
 */
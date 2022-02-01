import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class zal
  implements yxn
{
  private zal(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    this.a.d(3);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.a.jdField_a_of_type_Yys.a(this.a.a().a());
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3) {}
  
  public boolean a(yxo paramyxo)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (paramyxo != null))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((zcb)localObject).d = false;
        if (!(localObject instanceof yxc)) {
          break label124;
        }
        ywy localywy = this.a.a();
        if (localywy != null) {
          localywy.a.add((yxc)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramyxo);
        paramyxo.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label124:
        if ((localObject instanceof yxo))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((yxm)localObject).d();
          }
        }
      }
    }
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zal
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class yzw
  implements yxf
{
  public yzw(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Zaa != null) {
      this.a.jdField_a_of_type_Zaa.b(1, paramInt);
    }
  }
  
  public void a(ywz paramywz)
  {
    this.a.jdField_a_of_type_Ywz = paramywz;
    if (this.a.jdField_a_of_type_Zaa != null)
    {
      yqp.b("DoodleLayout", "selectLocation: clickItem-->" + paramywz.toString());
      this.a.jdField_a_of_type_Zaa.a(this.a.jdField_a_of_type_Ywz.a());
    }
  }
  
  public boolean a(yxc paramyxc)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((zcb)localObject).d = false;
        if (!(localObject instanceof yxc)) {
          break label120;
        }
        ywy localywy = this.a.a();
        if (localywy != null) {
          localywy.a.add((yxc)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramyxc);
        paramyxc.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzw
 * JD-Core Version:    0.7.0.1
 */
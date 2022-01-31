import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class vnn
  implements vkw
{
  public vnn(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Vnr != null) {
      this.a.jdField_a_of_type_Vnr.b(1, paramInt);
    }
  }
  
  public void a(vkq paramvkq)
  {
    this.a.jdField_a_of_type_Vkq = paramvkq;
    if (this.a.jdField_a_of_type_Vnr != null)
    {
      veg.b("DoodleLayout", "selectLocation: clickItem-->" + paramvkq.toString());
      this.a.jdField_a_of_type_Vnr.a(this.a.jdField_a_of_type_Vkq.a());
    }
  }
  
  public boolean a(vkt paramvkt)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((vps)localObject).d = false;
        if (!(localObject instanceof vkt)) {
          break label120;
        }
        vkp localvkp = this.a.a();
        if (localvkp != null) {
          localvkp.a.add((vkt)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramvkt);
        paramvkt.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
        if ((localObject instanceof vlf))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((vld)localObject).d();
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vnn
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class vnk
  implements vkt
{
  public vnk(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Vno != null) {
      this.a.jdField_a_of_type_Vno.b(1, paramInt);
    }
  }
  
  public void a(vkn paramvkn)
  {
    this.a.jdField_a_of_type_Vkn = paramvkn;
    if (this.a.jdField_a_of_type_Vno != null)
    {
      ved.b("DoodleLayout", "selectLocation: clickItem-->" + paramvkn.toString());
      this.a.jdField_a_of_type_Vno.a(this.a.jdField_a_of_type_Vkn.a());
    }
  }
  
  public boolean a(vkq paramvkq)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((vpp)localObject).d = false;
        if (!(localObject instanceof vkq)) {
          break label120;
        }
        vkm localvkm = this.a.a();
        if (localvkm != null) {
          localvkm.a.add((vkq)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramvkq);
        paramvkq.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
        if ((localObject instanceof vlc))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((vla)localObject).d();
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vnk
 * JD-Core Version:    0.7.0.1
 */
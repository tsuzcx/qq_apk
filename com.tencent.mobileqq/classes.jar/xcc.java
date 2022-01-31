import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class xcc
  implements wzl
{
  public xcc(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Xcg != null) {
      this.a.jdField_a_of_type_Xcg.b(1, paramInt);
    }
  }
  
  public void a(wzf paramwzf)
  {
    this.a.jdField_a_of_type_Wzf = paramwzf;
    if (this.a.jdField_a_of_type_Xcg != null)
    {
      wsv.b("DoodleLayout", "selectLocation: clickItem-->" + paramwzf.toString());
      this.a.jdField_a_of_type_Xcg.a(this.a.jdField_a_of_type_Wzf.a());
    }
  }
  
  public boolean a(wzi paramwzi)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((xeh)localObject).d = false;
        if (!(localObject instanceof wzi)) {
          break label120;
        }
        wze localwze = this.a.a();
        if (localwze != null) {
          localwze.a.add((wzi)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramwzi);
        paramwzi.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xcc
 * JD-Core Version:    0.7.0.1
 */
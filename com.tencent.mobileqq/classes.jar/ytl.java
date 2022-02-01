import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class ytl
  implements yrc
{
  public ytl(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Ytp != null) {
      this.a.jdField_a_of_type_Ytp.b(1, paramInt);
    }
  }
  
  public void a(yqw paramyqw)
  {
    this.a.jdField_a_of_type_Yqw = paramyqw;
    if (this.a.jdField_a_of_type_Ytp != null)
    {
      ykq.b("DoodleLayout", "selectLocation: clickItem-->" + paramyqw.toString());
      this.a.jdField_a_of_type_Ytp.a(this.a.jdField_a_of_type_Yqw.a());
    }
  }
  
  public boolean a(yqz paramyqz)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((yvp)localObject).d = false;
        if (!(localObject instanceof yqz)) {
          break label120;
        }
        yqv localyqv = this.a.a();
        if (localyqv != null) {
          localyqv.a.add((yqz)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramyqz);
        paramyqz.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
        if ((localObject instanceof yrk))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((yri)localObject).d();
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytl
 * JD-Core Version:    0.7.0.1
 */
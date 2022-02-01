import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class yes
  implements ycj
{
  public yes(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Yew != null) {
      this.a.jdField_a_of_type_Yew.b(1, paramInt);
    }
  }
  
  public void a(ycd paramycd)
  {
    this.a.jdField_a_of_type_Ycd = paramycd;
    if (this.a.jdField_a_of_type_Yew != null)
    {
      xvv.b("DoodleLayout", "selectLocation: clickItem-->" + paramycd.toString());
      this.a.jdField_a_of_type_Yew.a(this.a.jdField_a_of_type_Ycd.a());
    }
  }
  
  public boolean a(ycg paramycg)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((ygw)localObject).d = false;
        if (!(localObject instanceof ycg)) {
          break label120;
        }
        ycc localycc = this.a.a();
        if (localycc != null) {
          localycc.a.add((ycg)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramycg);
        paramycg.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
        if ((localObject instanceof ycr))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((ycp)localObject).d();
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yes
 * JD-Core Version:    0.7.0.1
 */
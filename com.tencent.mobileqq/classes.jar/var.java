import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class var
  implements uya
{
  public var(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Vav != null) {
      this.a.jdField_a_of_type_Vav.b(1, paramInt);
    }
  }
  
  public void a(uxu paramuxu)
  {
    this.a.jdField_a_of_type_Uxu = paramuxu;
    if (this.a.jdField_a_of_type_Vav != null)
    {
      urk.b("DoodleLayout", "selectLocation: clickItem-->" + paramuxu.toString());
      this.a.jdField_a_of_type_Vav.a(this.a.jdField_a_of_type_Uxu.a());
    }
  }
  
  public boolean a(uxx paramuxx)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((vcw)localObject).d = false;
        if (!(localObject instanceof uxx)) {
          break label120;
        }
        uxt localuxt = this.a.a();
        if (localuxt != null) {
          localuxt.a.add((uxx)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramuxx);
        paramuxx.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     var
 * JD-Core Version:    0.7.0.1
 */
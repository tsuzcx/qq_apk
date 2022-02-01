import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class zdr
  implements zba
{
  public zdr(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Zdv != null) {
      this.a.jdField_a_of_type_Zdv.b(1, paramInt);
    }
  }
  
  public void a(zau paramzau)
  {
    this.a.jdField_a_of_type_Zau = paramzau;
    if (this.a.jdField_a_of_type_Zdv != null)
    {
      yuk.b("DoodleLayout", "selectLocation: clickItem-->" + paramzau.toString());
      this.a.jdField_a_of_type_Zdv.a(this.a.jdField_a_of_type_Zau.a());
    }
  }
  
  public boolean a(zax paramzax)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((zfw)localObject).d = false;
        if (!(localObject instanceof zax)) {
          break label120;
        }
        zat localzat = this.a.a();
        if (localzat != null) {
          localzat.a.add((zax)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramzax);
        paramzax.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
        if ((localObject instanceof zbj))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((zbh)localObject).d();
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdr
 * JD-Core Version:    0.7.0.1
 */
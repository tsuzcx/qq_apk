import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class xgl
  implements xdu
{
  public xgl(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Xgp != null) {
      this.a.jdField_a_of_type_Xgp.b(1, paramInt);
    }
  }
  
  public void a(xdo paramxdo)
  {
    this.a.jdField_a_of_type_Xdo = paramxdo;
    if (this.a.jdField_a_of_type_Xgp != null)
    {
      wxe.b("DoodleLayout", "selectLocation: clickItem-->" + paramxdo.toString());
      this.a.jdField_a_of_type_Xgp.a(this.a.jdField_a_of_type_Xdo.a());
    }
  }
  
  public boolean a(xdr paramxdr)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((xiq)localObject).d = false;
        if (!(localObject instanceof xdr)) {
          break label120;
        }
        xdn localxdn = this.a.a();
        if (localxdn != null) {
          localxdn.a.add((xdr)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramxdr);
        paramxdr.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xgl
 * JD-Core Version:    0.7.0.1
 */
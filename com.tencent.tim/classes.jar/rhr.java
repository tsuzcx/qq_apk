import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.b;
import java.util.List;

public class rhr
  implements rft.c
{
  public rhr(DoodleLayout paramDoodleLayout) {}
  
  public void a(rft.a parama)
  {
    this.this$0.b = parama;
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b != null)
    {
      ram.d("DoodleLayout", "selectLocation: clickItem-->" + parama.toString());
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.ss(this.this$0.b.getText());
    }
  }
  
  public boolean a(rft.b paramb)
  {
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)
    {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.Lp())
      {
        localObject = this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((riy.a)localObject).aIp = false;
        if (!(localObject instanceof rft.b)) {
          break label120;
        }
        rft localrft = this.this$0.a();
        if (localrft != null) {
          localrft.oJ.add((rft.b)localObject);
        }
      }
      for (;;)
      {
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b(paramb);
        paramb.aIp = true;
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label120:
        if ((localObject instanceof rgb.b))
        {
          localObject = this.this$0.a();
          if (localObject != null) {
            ((rgb)localObject).btV();
          }
        }
      }
    }
    return false;
  }
  
  public void xj(int paramInt)
  {
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b != null) {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.eb(1, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rhr
 * JD-Core Version:    0.7.0.1
 */
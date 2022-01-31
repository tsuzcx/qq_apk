import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;

public class xhs
  implements AdapterView.OnItemClickListener
{
  public xhs(FacePanel paramFacePanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.a) {}
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { paramAdapterView });
      if (this.a.jdField_a_of_type_Xic != null)
      {
        paramAdapterView = this.a.jdField_a_of_type_Xic.a(paramInt);
        if ((paramAdapterView != null) && ((paramAdapterView instanceof xhr)))
        {
          wxk.a("0X80076C7", "", "", ((xhr)paramAdapterView).a, "");
          wxk.a("0X80075DC", ((xhr)paramAdapterView).a);
        }
      }
      if (paramInt == 1)
      {
        wxk.a("0X80076CC");
        wxk.b("0X80075E1");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhs
 * JD-Core Version:    0.7.0.1
 */
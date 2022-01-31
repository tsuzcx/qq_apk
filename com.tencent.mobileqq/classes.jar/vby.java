import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;

public class vby
  implements AdapterView.OnItemClickListener
{
  public vby(FacePanel paramFacePanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.a) {}
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { paramAdapterView });
      if (this.a.jdField_a_of_type_Vci != null)
      {
        paramAdapterView = this.a.jdField_a_of_type_Vci.a(paramInt);
        if ((paramAdapterView != null) && ((paramAdapterView instanceof vbx)))
        {
          urq.a("0X80076C7", "", "", ((vbx)paramAdapterView).a, "");
          urq.a("0X80075DC", ((vbx)paramAdapterView).a);
        }
      }
      if (paramInt == 1)
      {
        urq.a("0X80076CC");
        urq.b("0X80075E1");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vby
 * JD-Core Version:    0.7.0.1
 */
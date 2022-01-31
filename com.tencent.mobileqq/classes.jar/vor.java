import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;

public class vor
  implements AdapterView.OnItemClickListener
{
  public vor(FacePanel paramFacePanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.a) {}
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { paramAdapterView });
      if (this.a.jdField_a_of_type_Vpb != null)
      {
        paramAdapterView = this.a.jdField_a_of_type_Vpb.a(paramInt);
        if ((paramAdapterView != null) && ((paramAdapterView instanceof voq)))
        {
          vej.a("0X80076C7", "", "", ((voq)paramAdapterView).a, "");
          vej.a("0X80075DC", ((voq)paramAdapterView).a);
        }
      }
      if (paramInt == 1)
      {
        vej.a("0X80076CC");
        vej.b("0X80075E1");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vor
 * JD-Core Version:    0.7.0.1
 */
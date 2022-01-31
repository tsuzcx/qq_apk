import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;

public class vou
  implements AdapterView.OnItemClickListener
{
  public vou(FacePanel paramFacePanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.a) {}
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { paramAdapterView });
      if (this.a.jdField_a_of_type_Vpe != null)
      {
        paramAdapterView = this.a.jdField_a_of_type_Vpe.a(paramInt);
        if ((paramAdapterView != null) && ((paramAdapterView instanceof vot)))
        {
          vem.a("0X80076C7", "", "", ((vot)paramAdapterView).a, "");
          vem.a("0X80075DC", ((vot)paramAdapterView).a);
        }
      }
      if (paramInt == 1)
      {
        vem.a("0X80076CC");
        vem.b("0X80075E1");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vou
 * JD-Core Version:    0.7.0.1
 */
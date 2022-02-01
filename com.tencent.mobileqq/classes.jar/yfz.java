import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yfz
  implements AdapterView.OnItemClickListener
{
  public yfz(FacePanel paramFacePanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.a) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
      if (this.a.jdField_a_of_type_Ygj != null)
      {
        localObject = this.a.jdField_a_of_type_Ygj.a(paramInt);
        if ((localObject != null) && ((localObject instanceof yfy)))
        {
          xwb.a("0X80076C7", "", "", ((yfy)localObject).a, "");
          xwb.a("0X80075DC", ((yfy)localObject).a);
        }
      }
      if (paramInt == 1)
      {
        xwb.a("0X80076CC");
        xwb.b("0X80075E1");
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfz
 * JD-Core Version:    0.7.0.1
 */
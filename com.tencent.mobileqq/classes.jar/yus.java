import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yus
  implements AdapterView.OnItemClickListener
{
  public yus(FacePanel paramFacePanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.a) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
      if (this.a.jdField_a_of_type_Yvc != null)
      {
        localObject = this.a.jdField_a_of_type_Yvc.a(paramInt);
        if ((localObject != null) && ((localObject instanceof yur)))
        {
          ykw.a("0X80076C7", "", "", ((yur)localObject).a, "");
          ykw.a("0X80075DC", ((yur)localObject).a);
        }
      }
      if (paramInt == 1)
      {
        ykw.a("0X80076CC");
        ykw.b("0X80075E1");
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yus
 * JD-Core Version:    0.7.0.1
 */
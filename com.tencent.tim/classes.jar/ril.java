import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ril
  implements AdapterView.OnItemClickListener
{
  public ril(FacePanel paramFacePanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.aHL) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.e("change_face", 0, 0, new String[] { localObject });
      if (this.b.jdField_a_of_type_Ris != null)
      {
        localObject = this.b.jdField_a_of_type_Ris.a(paramInt);
        if ((localObject != null) && ((localObject instanceof rik)))
        {
          ras.g("0X80076C7", "", "", ((rik)localObject).id, "");
          ras.cz("0X80075DC", ((rik)localObject).id);
        }
      }
      if (paramInt == 1)
      {
        ras.so("0X80076CC");
        ras.sp("0X80075E1");
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ril
 * JD-Core Version:    0.7.0.1
 */
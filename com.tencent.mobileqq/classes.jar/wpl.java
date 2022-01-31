import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class wpl
  implements xrc
{
  public void a(SegmentList paramSegmentList)
  {
    if (!(paramSegmentList instanceof MystoryListView)) {
      throw new IllegalArgumentException("arg should match type!");
    }
    paramSegmentList = (MystoryListView)paramSegmentList;
    Activity localActivity = paramSegmentList.jdField_a_of_type_AndroidAppActivity;
    Object localObject = paramSegmentList.jdField_a_of_type_Wpi;
    boolean bool = paramSegmentList.a();
    paramSegmentList.a(ume.a(localActivity, 5));
    paramSegmentList.a(new wrh(localActivity, (wpi)localObject));
    paramSegmentList.a(new wrg(localActivity));
    paramSegmentList.a(new wqx(localActivity));
    localObject = new wps(localActivity, localActivity, 10, (wpi)localObject, bool);
    paramSegmentList.a((xrg)localObject);
    paramSegmentList.a(new wsa(localActivity, "FeedSegment", alpo.a(2131707436) + ugx.a + "\n拍摄一段视频，分享眼前的世界", 2130846083, 2130846084));
    ((wps)localObject).e_(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpl
 * JD-Core Version:    0.7.0.1
 */
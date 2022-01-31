import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class wtu
  implements xvl
{
  public void a(SegmentList paramSegmentList)
  {
    if (!(paramSegmentList instanceof MystoryListView)) {
      throw new IllegalArgumentException("arg should match type!");
    }
    paramSegmentList = (MystoryListView)paramSegmentList;
    Activity localActivity = paramSegmentList.jdField_a_of_type_AndroidAppActivity;
    Object localObject = paramSegmentList.jdField_a_of_type_Wtr;
    boolean bool = paramSegmentList.a();
    paramSegmentList.a(uqn.a(localActivity, 5));
    paramSegmentList.a(new wvq(localActivity, (wtr)localObject));
    paramSegmentList.a(new wvp(localActivity));
    paramSegmentList.a(new wvg(localActivity));
    localObject = new wub(localActivity, localActivity, 10, (wtr)localObject, bool);
    paramSegmentList.a((xvp)localObject);
    paramSegmentList.a(new wwj(localActivity, "FeedSegment", alud.a(2131707448) + ulg.a + "\n拍摄一段视频，分享眼前的世界", 2130846156, 2130846157));
    ((wub)localObject).e_(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wtu
 * JD-Core Version:    0.7.0.1
 */
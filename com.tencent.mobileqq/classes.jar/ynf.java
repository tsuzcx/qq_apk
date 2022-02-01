import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class ynf
  implements zow
{
  public void a(SegmentList paramSegmentList)
  {
    if (!(paramSegmentList instanceof MystoryListView)) {
      throw new IllegalArgumentException("arg should match type!");
    }
    paramSegmentList = (MystoryListView)paramSegmentList;
    Activity localActivity = paramSegmentList.jdField_a_of_type_AndroidAppActivity;
    Object localObject = paramSegmentList.jdField_a_of_type_Ync;
    boolean bool = paramSegmentList.a();
    paramSegmentList.a(wjz.a(localActivity, 5));
    paramSegmentList.a(new ypb(localActivity, (ync)localObject));
    paramSegmentList.a(new ypa(localActivity));
    paramSegmentList.a(new yor(localActivity));
    localObject = new ynm(localActivity, localActivity, 10, (ync)localObject, bool);
    paramSegmentList.a((zpa)localObject);
    paramSegmentList.a(new ypu(localActivity, "FeedSegment", anni.a(2131705839) + wes.a + "\n拍摄一段视频，分享眼前的世界", 2130846595, 2130846596));
    ((ynm)localObject).e_(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynf
 * JD-Core Version:    0.7.0.1
 */
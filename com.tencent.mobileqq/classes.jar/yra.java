import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class yra
  implements zsr
{
  public void a(SegmentList paramSegmentList)
  {
    if (!(paramSegmentList instanceof MystoryListView)) {
      throw new IllegalArgumentException("arg should match type!");
    }
    paramSegmentList = (MystoryListView)paramSegmentList;
    Activity localActivity = paramSegmentList.jdField_a_of_type_AndroidAppActivity;
    Object localObject = paramSegmentList.jdField_a_of_type_Yqx;
    boolean bool = paramSegmentList.a();
    paramSegmentList.a(wnu.a(localActivity, 5));
    paramSegmentList.a(new ysw(localActivity, (yqx)localObject));
    paramSegmentList.a(new ysv(localActivity));
    paramSegmentList.a(new ysm(localActivity));
    localObject = new yrh(localActivity, localActivity, 10, (yqx)localObject, bool);
    paramSegmentList.a((zsv)localObject);
    paramSegmentList.a(new ytp(localActivity, "FeedSegment", anzj.a(2131705946) + win.a + "\n拍摄一段视频，分享眼前的世界", 2130846612, 2130846613));
    ((yrh)localObject).e_(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yra
 * JD-Core Version:    0.7.0.1
 */
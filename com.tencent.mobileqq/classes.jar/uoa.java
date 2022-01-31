import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class uoa
  implements vpr
{
  public void a(SegmentList paramSegmentList)
  {
    if (!(paramSegmentList instanceof MystoryListView)) {
      throw new IllegalArgumentException("arg should match type!");
    }
    paramSegmentList = (MystoryListView)paramSegmentList;
    Activity localActivity = paramSegmentList.jdField_a_of_type_AndroidAppActivity;
    Object localObject = paramSegmentList.jdField_a_of_type_Unx;
    boolean bool = paramSegmentList.a();
    paramSegmentList.a(skt.a(localActivity, 5));
    paramSegmentList.a(new upw(localActivity, (unx)localObject));
    paramSegmentList.a(new upv(localActivity));
    paramSegmentList.a(new upm(localActivity));
    localObject = new uoh(localActivity, localActivity, 10, (unx)localObject, bool);
    paramSegmentList.a((vpv)localObject);
    paramSegmentList.a(new uqp(localActivity, "FeedSegment", ajjy.a(2131641268) + sfm.a + "\n拍摄一段视频，分享眼前的世界", 2130845515, 2130845516));
    ((uoh)localObject).f_(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uoa
 * JD-Core Version:    0.7.0.1
 */
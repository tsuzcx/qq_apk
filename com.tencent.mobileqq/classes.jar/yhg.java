import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class yhg
  implements zgv
{
  public void a(SegmentList paramSegmentList)
  {
    if (!(paramSegmentList instanceof MystoryListView)) {
      throw new IllegalArgumentException("arg should match type!");
    }
    paramSegmentList = (MystoryListView)paramSegmentList;
    Activity localActivity = paramSegmentList.jdField_a_of_type_AndroidAppActivity;
    Object localObject = paramSegmentList.jdField_a_of_type_Yhd;
    boolean bool = paramSegmentList.a();
    paramSegmentList.a(weg.a(localActivity, 5));
    paramSegmentList.a(new yjc(localActivity, (yhd)localObject));
    paramSegmentList.a(new yjb(localActivity));
    paramSegmentList.a(new yis(localActivity));
    localObject = new yhn(localActivity, localActivity, 10, (yhd)localObject, bool);
    paramSegmentList.a((zgz)localObject);
    paramSegmentList.a(new yjv(localActivity, "FeedSegment", anvx.a(2131706528) + vzh.a + "\n拍摄一段视频，分享眼前的世界", 2130846616, 2130846617));
    ((yhn)localObject).d_(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhg
 * JD-Core Version:    0.7.0.1
 */
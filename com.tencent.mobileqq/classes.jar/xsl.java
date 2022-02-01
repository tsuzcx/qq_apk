import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class xsl
  implements ysc
{
  public void a(SegmentList paramSegmentList)
  {
    if (!(paramSegmentList instanceof MystoryListView)) {
      throw new IllegalArgumentException("arg should match type!");
    }
    paramSegmentList = (MystoryListView)paramSegmentList;
    Activity localActivity = paramSegmentList.jdField_a_of_type_AndroidAppActivity;
    Object localObject = paramSegmentList.jdField_a_of_type_Xsi;
    boolean bool = paramSegmentList.a();
    paramSegmentList.a(vpl.a(localActivity, 5));
    paramSegmentList.a(new xuh(localActivity, (xsi)localObject));
    paramSegmentList.a(new xug(localActivity));
    paramSegmentList.a(new xtx(localActivity));
    localObject = new xss(localActivity, localActivity, 10, (xsi)localObject, bool);
    paramSegmentList.a((ysg)localObject);
    paramSegmentList.a(new xva(localActivity, "FeedSegment", amtj.a(2131706176) + vkm.a + "\n拍摄一段视频，分享眼前的世界", 2130846520, 2130846521));
    ((xss)localObject).d_(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsl
 * JD-Core Version:    0.7.0.1
 */
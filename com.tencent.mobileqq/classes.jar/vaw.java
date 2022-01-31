import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class vaw
  implements wcn
{
  public void a(SegmentList paramSegmentList)
  {
    if (!(paramSegmentList instanceof MystoryListView)) {
      throw new IllegalArgumentException("arg should match type!");
    }
    paramSegmentList = (MystoryListView)paramSegmentList;
    Activity localActivity = paramSegmentList.jdField_a_of_type_AndroidAppActivity;
    Object localObject = paramSegmentList.jdField_a_of_type_Vat;
    boolean bool = paramSegmentList.a();
    paramSegmentList.a(sxp.a(localActivity, 5));
    paramSegmentList.a(new vcs(localActivity, (vat)localObject));
    paramSegmentList.a(new vcr(localActivity));
    paramSegmentList.a(new vci(localActivity));
    localObject = new vbd(localActivity, localActivity, 10, (vat)localObject, bool);
    paramSegmentList.a((wcr)localObject);
    paramSegmentList.a(new vdl(localActivity, "FeedSegment", ajyc.a(2131707053) + ssi.a + "\n拍摄一段视频，分享眼前的世界", 2130845698, 2130845699));
    ((vbd)localObject).e_(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vaw
 * JD-Core Version:    0.7.0.1
 */
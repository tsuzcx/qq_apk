import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class vat
  implements wck
{
  public void a(SegmentList paramSegmentList)
  {
    if (!(paramSegmentList instanceof MystoryListView)) {
      throw new IllegalArgumentException("arg should match type!");
    }
    paramSegmentList = (MystoryListView)paramSegmentList;
    Activity localActivity = paramSegmentList.jdField_a_of_type_AndroidAppActivity;
    Object localObject = paramSegmentList.jdField_a_of_type_Vaq;
    boolean bool = paramSegmentList.a();
    paramSegmentList.a(sxm.a(localActivity, 5));
    paramSegmentList.a(new vcp(localActivity, (vaq)localObject));
    paramSegmentList.a(new vco(localActivity));
    paramSegmentList.a(new vcf(localActivity));
    localObject = new vba(localActivity, localActivity, 10, (vaq)localObject, bool);
    paramSegmentList.a((wco)localObject);
    paramSegmentList.a(new vdi(localActivity, "FeedSegment", ajya.a(2131707064) + ssf.a + "\n拍摄一段视频，分享眼前的世界", 2130845704, 2130845705));
    ((vba)localObject).e_(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vat
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class xit
  extends xil<HotRecommendFeedPlayInfo>
{
  public xit(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public yib a(String paramString)
  {
    paramString = new yib(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, xjd paramxjd)
  {
    ArrayList localArrayList = new ArrayList();
    xim localxim = new xim(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new yib(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localxim.a.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(localxim);
    paramxjd.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xit
 * JD-Core Version:    0.7.0.1
 */
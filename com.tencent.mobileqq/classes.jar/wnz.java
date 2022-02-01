import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class wnz
  extends wnr<HotRecommendFeedPlayInfo>
{
  public wnz(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public xnh a(String paramString)
  {
    paramString = new xnh(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, woj paramwoj)
  {
    ArrayList localArrayList = new ArrayList();
    wns localwns = new wns(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new xnh(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localwns.a.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(localwns);
    paramwoj.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnz
 * JD-Core Version:    0.7.0.1
 */
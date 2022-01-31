import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class twh
  extends tvz<HotRecommendFeedPlayInfo>
{
  public twh(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public uvp a(String paramString)
  {
    paramString = new uvp(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, twr paramtwr)
  {
    ArrayList localArrayList = new ArrayList();
    twa localtwa = new twa(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new uvp(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localtwa.a.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(localtwa);
    paramtwr.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twh
 * JD-Core Version:    0.7.0.1
 */
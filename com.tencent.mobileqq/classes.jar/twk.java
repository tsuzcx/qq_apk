import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class twk
  extends twc<HotRecommendFeedPlayInfo>
{
  public twk(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public uvs a(String paramString)
  {
    paramString = new uvs(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, twu paramtwu)
  {
    ArrayList localArrayList = new ArrayList();
    twd localtwd = new twd(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new uvs(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localtwd.a.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(localtwd);
    paramtwu.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twk
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class tjo
  extends tjg<HotRecommendFeedPlayInfo>
{
  public tjo(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public uiw a(String paramString)
  {
    paramString = new uiw(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, tjy paramtjy)
  {
    ArrayList localArrayList = new ArrayList();
    tjh localtjh = new tjh(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new uiw(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localtjh.a.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(localtjh);
    paramtjy.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjo
 * JD-Core Version:    0.7.0.1
 */
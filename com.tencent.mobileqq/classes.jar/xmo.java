import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class xmo
  extends xmg<HotRecommendFeedPlayInfo>
{
  public xmo(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public ylw a(String paramString)
  {
    paramString = new ylw(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, xmy paramxmy)
  {
    ArrayList localArrayList = new ArrayList();
    xmh localxmh = new xmh(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new ylw(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localxmh.a.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(localxmh);
    paramxmy.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmo
 * JD-Core Version:    0.7.0.1
 */
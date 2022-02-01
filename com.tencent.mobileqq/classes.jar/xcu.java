import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class xcu
  extends xcm<HotRecommendFeedPlayInfo>
{
  public xcu(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public ycc a(String paramString)
  {
    paramString = new ycc(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, xde paramxde)
  {
    ArrayList localArrayList = new ArrayList();
    xcn localxcn = new xcn(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new ycc(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localxcn.a.b = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(localxcn);
    paramxde.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcu
 * JD-Core Version:    0.7.0.1
 */
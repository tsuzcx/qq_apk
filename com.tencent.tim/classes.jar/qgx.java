import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class qgx
  extends qgr<HotRecommendFeedPlayInfo>
{
  public qgx(HotRecommendFeedPlayInfo paramHotRecommendFeedPlayInfo)
  {
    super(paramHotRecommendFeedPlayInfo);
  }
  
  public qvd a(String paramString)
  {
    paramString = new qvd(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.bls = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, qgz.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    qgr.a locala = new qgr.a(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, new qvd(((HotRecommendFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    locala.a.bls = ((HotRecommendFeedPlayInfo)this.a).mPullType;
    localArrayList.add(locala);
    paramb.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgx
 * JD-Core Version:    0.7.0.1
 */
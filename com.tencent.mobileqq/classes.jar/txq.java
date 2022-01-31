import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class txq
  extends twc<SingleFeedPlayInfo>
{
  public txq(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public uvs a(String paramString)
  {
    paramString = new uvs(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, twu paramtwu)
  {
    ArrayList localArrayList = new ArrayList();
    twd localtwd = new twd(((SingleFeedPlayInfo)this.a).mFeedFeedId, new uvs(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localtwd.a.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(localtwd);
    paramtwu.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txq
 * JD-Core Version:    0.7.0.1
 */
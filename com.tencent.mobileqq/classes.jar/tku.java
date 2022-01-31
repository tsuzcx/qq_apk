import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class tku
  extends tjg<SingleFeedPlayInfo>
{
  public tku(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public uiw a(String paramString)
  {
    paramString = new uiw(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, tjy paramtjy)
  {
    ArrayList localArrayList = new ArrayList();
    tjh localtjh = new tjh(((SingleFeedPlayInfo)this.a).mFeedFeedId, new uiw(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localtjh.a.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(localtjh);
    paramtjy.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tku
 * JD-Core Version:    0.7.0.1
 */
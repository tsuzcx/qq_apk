import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class txn
  extends tvz<SingleFeedPlayInfo>
{
  public txn(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public uvp a(String paramString)
  {
    paramString = new uvp(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, twr paramtwr)
  {
    ArrayList localArrayList = new ArrayList();
    twa localtwa = new twa(((SingleFeedPlayInfo)this.a).mFeedFeedId, new uvp(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localtwa.a.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(localtwa);
    paramtwr.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txn
 * JD-Core Version:    0.7.0.1
 */
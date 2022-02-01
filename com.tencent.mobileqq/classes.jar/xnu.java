import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class xnu
  extends xmg<SingleFeedPlayInfo>
{
  public xnu(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public ylw a(String paramString)
  {
    paramString = new ylw(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, xmy paramxmy)
  {
    ArrayList localArrayList = new ArrayList();
    xmh localxmh = new xmh(((SingleFeedPlayInfo)this.a).mFeedFeedId, new ylw(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localxmh.a.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(localxmh);
    paramxmy.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnu
 * JD-Core Version:    0.7.0.1
 */
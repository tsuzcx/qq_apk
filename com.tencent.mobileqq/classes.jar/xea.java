import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class xea
  extends xcm<SingleFeedPlayInfo>
{
  public xea(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public ycc a(String paramString)
  {
    paramString = new ycc(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, xde paramxde)
  {
    ArrayList localArrayList = new ArrayList();
    xcn localxcn = new xcn(((SingleFeedPlayInfo)this.a).mFeedFeedId, new ycc(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    localxcn.a.b = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(localxcn);
    paramxde.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xea
 * JD-Core Version:    0.7.0.1
 */
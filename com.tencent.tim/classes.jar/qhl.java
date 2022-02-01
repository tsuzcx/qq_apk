import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import java.util.ArrayList;
import java.util.List;

public class qhl
  extends qgr<SingleFeedPlayInfo>
{
  public qhl(SingleFeedPlayInfo paramSingleFeedPlayInfo)
  {
    super(paramSingleFeedPlayInfo);
  }
  
  public qvd a(String paramString)
  {
    paramString = new qvd(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", "");
    paramString.bls = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    return paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt, qgz.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    qgr.a locala = new qgr.a(((SingleFeedPlayInfo)this.a).mFeedFeedId, new qvd(((SingleFeedPlayInfo)this.a).mFeedFeedId, 0, "", ""));
    locala.a.bls = ((SingleFeedPlayInfo)this.a).mFeedPullType;
    localArrayList.add(locala);
    paramb.a(new ErrorMessage(), localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhl
 * JD-Core Version:    0.7.0.1
 */
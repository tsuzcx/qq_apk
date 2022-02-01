import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class qhp
  extends qgz.a
{
  private VidListPlayInfo a;
  private qgy.c d;
  
  public qhp(VidListPlayInfo paramVidListPlayInfo)
  {
    this.a = paramVidListPlayInfo;
    this.d = new qgy.c("vidList");
  }
  
  public void a(int paramInt, qgz.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    qgy.d locald = new qgy.d(this.d);
    localArrayList.add(locald);
    locald.nv = this.a.mVidList;
    int i = this.a.mVideoFeedIdList.size();
    paramInt = 0;
    if (paramInt < this.a.mVidList.size())
    {
      if (paramInt < i) {}
      for (String str = (String)this.a.mVideoFeedIdList.get(paramInt);; str = (String)this.a.mVideoFeedIdList.get(i - 1))
      {
        locald.fR.put(this.a.mVidList.get(paramInt), str);
        paramInt += 1;
        break;
      }
    }
    paramb.b(new ErrorMessage(), localArrayList, true);
  }
  
  public List<qgz.c> ap(List<qgy.c> paramList)
  {
    return null;
  }
  
  public qgy.f b()
  {
    return new qgy.f(this.d, this.a.mStartVid, this.a.mStartVideoFeedId);
  }
  
  public void create() {}
  
  public void destroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhp
 * JD-Core Version:    0.7.0.1
 */
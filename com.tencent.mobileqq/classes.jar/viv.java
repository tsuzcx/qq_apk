import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class viv
  extends JobSegment<List<vil>, List<vil>>
{
  private viz a;
  
  public viv(viz paramviz)
  {
    this.a = paramviz;
  }
  
  protected void a(JobContext paramJobContext, List<vil> paramList)
  {
    int i = 1;
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((vil)paramJobContext.next()).a(this.a);
    }
    via.a(paramList);
    via localvia = (via)vux.a(30);
    vht localvht = localvia.a();
    paramJobContext = paramList;
    if (!this.a.a())
    {
      paramJobContext = paramList;
      if (paramList.size() > localvht.a())
      {
        xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localvht.a());
        paramJobContext = paramList.subList(0, localvht.a());
      }
    }
    if (localvia.a(paramJobContext, this.a.a()))
    {
      long l2;
      for (long l1 = ((vil)paramJobContext.get(0)).e(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((vil)paramJobContext.get(i)).e();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((vil)paramJobContext.get(0)).e());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     viv
 * JD-Core Version:    0.7.0.1
 */
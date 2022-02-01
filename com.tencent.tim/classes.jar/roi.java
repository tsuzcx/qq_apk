import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class roi
  extends qve<qvq>
{
  public roi(@Nullable qve.d paramd)
  {
    super(paramd);
  }
  
  protected void K(List<String> paramList, boolean paramBoolean)
  {
    ((qvf)psx.a(11)).R(paramList, paramBoolean);
  }
  
  protected JobSegment<qve.c, qvq> a()
  {
    return new qvl();
  }
  
  protected JobSegment<Integer, qve.c> a(qve.b paramb)
  {
    return new roi.a(paramb);
  }
  
  protected qvq a()
  {
    qvf localqvf = (qvf)psx.a(11);
    List localList = localqvf.bW();
    qvq localqvq = new qvq(new ErrorMessage());
    localqvq.or = localqvf.av(localList);
    localqvq.aCu = true;
    localqvq.isEnd = localqvq.or.isEmpty();
    return localqvq;
  }
  
  protected qvq a(ErrorMessage paramErrorMessage)
  {
    return new qvq(paramErrorMessage);
  }
  
  static class a
    extends JobSegment<Integer, qve.c>
  {
    private qve.b b;
    
    public a(@NonNull qve.b paramb)
    {
      this.b = paramb;
    }
    
    protected void a(JobContext paramJobContext, Integer paramInteger)
    {
      Object localObject = this.b.a(paramInteger.intValue(), 5);
      if ((((qve.c)localObject).oq.size() > 0) || (((qve.c)localObject).mIsEnd))
      {
        ram.d("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
        notifyResult(localObject);
        return;
      }
      localObject = new pzk();
      ((pzk)localObject).cookie = this.b.mP();
      ppv.a().a((ppw)localObject, new roj(this, paramJobContext, paramInteger));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     roi
 * JD-Core Version:    0.7.0.1
 */
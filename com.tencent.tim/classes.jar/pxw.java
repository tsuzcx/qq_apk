import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;

public class pxw
  implements ppv.b<pzr, qay>
{
  public void a(@NonNull pzr parampzr, @Nullable qay paramqay, @NonNull ErrorMessage paramErrorMessage)
  {
    parampzr = new pxw.a(paramErrorMessage, parampzr.vid, parampzr.unionId, parampzr.blk);
    pmi.a().dispatch(parampzr);
  }
  
  public class a
    extends plt
  {
    public final int blk;
    public final String uin;
    public final String vid;
    
    public a(ErrorMessage paramErrorMessage, String paramString1, String paramString2, int paramInt)
    {
      this.b = paramErrorMessage;
      this.uin = paramString2;
      this.vid = paramString1;
      this.blk = paramInt;
    }
    
    public String toString()
    {
      return "ReportEvent{vid='" + this.vid + '\'' + ", uin='" + this.uin + '\'' + ", impeachType=" + this.blk + "} " + super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxw
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback.1;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;

public class ppv
{
  public static volatile ppv a;
  
  public static ppv a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        ppv localppv2 = a;
        localObject = localppv2;
        if (localppv2 == null)
        {
          localObject = new ppv();
          a = (ppv)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localppv1;
  }
  
  public <Request extends ppw, Respond extends ppu> void a(Request paramRequest, ppv.b<Request, Respond> paramb)
  {
    paramRequest = new ppv.a(paramRequest);
    paramRequest.jdField_a_of_type_Ppv$b = paramb;
    paramRequest.jdField_a_of_type_Ppw.a(paramRequest);
    QQStoryContext.a().a().a(paramRequest.jdField_a_of_type_Ppw);
  }
  
  static class a<Request extends ppw, Respond extends ppu>
    implements ppw.a<Respond>
  {
    protected ppv.b<Request, Respond> a;
    public Request a;
    protected final long mStartTime;
    
    public a(Request paramRequest)
    {
      this.jdField_a_of_type_Ppw = paramRequest;
      this.mStartTime = System.currentTimeMillis();
    }
    
    private void b(int paramInt, String paramString, Respond paramRespond)
    {
      ppv.b localb = this.jdField_a_of_type_Ppv$b;
      if (localb != null)
      {
        localb.a(this.jdField_a_of_type_Ppw, paramRespond, new ErrorMessage(paramInt, paramString));
        return;
      }
      ram.w("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
    }
    
    public void a(int paramInt, String paramString, Respond paramRespond)
    {
      b(paramInt, paramString, paramRespond);
    }
  }
  
  public static abstract interface b<Request extends ppw, Respond extends ppu>
  {
    public abstract void a(@NonNull Request paramRequest, @Nullable Respond paramRespond, @NonNull ErrorMessage paramErrorMessage);
  }
  
  public static abstract class c<Request extends ppw, Respond extends ppu>
    implements ppv.b<Request, Respond>
  {
    public static Handler sHandler = new Handler(Looper.getMainLooper());
    
    public void a(@NonNull Request paramRequest, @Nullable Respond paramRespond, @NonNull ErrorMessage paramErrorMessage)
    {
      if (Thread.currentThread() == sHandler.getLooper().getThread())
      {
        b(paramRequest, paramRespond, paramErrorMessage);
        return;
      }
      sHandler.post(new CmdTaskManger.UIThreadCallback.1(this, paramRequest, paramRespond, paramErrorMessage));
    }
    
    public abstract void b(@NonNull Request paramRequest, @Nullable Respond paramRespond, @NonNull ErrorMessage paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppv
 * JD-Core Version:    0.7.0.1
 */
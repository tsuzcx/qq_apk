import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class awqq
  implements Handler.Callback
{
  private awqd.d jdField_a_of_type_Awqd$d;
  private final awqq.a jdField_a_of_type_Awqq$a;
  private final ReleaseLooperHandler mHandler;
  
  public awqq(awqq.a parama, awqd.d paramd, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_Awqq$a = parama;
    this.mHandler = paramReleaseLooperHandler;
    this.mHandler.addCallback(this);
    this.jdField_a_of_type_Awqd$d = paramd;
  }
  
  private void b(awqb paramawqb, int paramInt)
  {
    if (paramawqb == null) {}
    long l;
    String str;
    do
    {
      return;
      l = paramawqb.dbId();
      str = paramawqb.b().fileId;
    } while (paramawqb.isCanceled());
    this.jdField_a_of_type_Awqd$d.a(paramawqb.b().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new awqr(this, str, l, paramawqb, paramInt));
  }
  
  public void a(awqb paramawqb, int paramInt)
  {
    if (paramawqb == null) {
      return;
    }
    this.mHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, paramawqb));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((awqb)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, awpy.a parama);
    
    public abstract void onFetchError(long paramLong, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqq
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class asem
  extends asek
{
  private static asem a;
  private int mAppId;
  private AppRuntime mAppRuntime;
  
  public static asem a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new asem();
      }
      return a;
    }
    finally {}
  }
  
  protected void bP(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.mAppRuntime.getApplication(), aseo.class);
    localNewIntent.putExtra("req_type", 6);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.mAppRuntime.startServlet(localNewIntent);
  }
  
  protected void bQ(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.mAppRuntime.getApplication(), aseo.class);
    localNewIntent.putExtra("req_type", 2);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.mAppRuntime.startServlet(localNewIntent);
  }
  
  protected void bR(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.mAppRuntime.getApplication(), aseo.class);
    localNewIntent.putExtra("req_type", 3);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.mAppRuntime.startServlet(localNewIntent);
  }
  
  protected void bS(byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(this.mAppRuntime.getApplication(), aseo.class);
    localNewIntent.putExtra("req_type", 4);
    localNewIntent.putExtra("wup_buffer", paramArrayOfByte);
    this.mAppRuntime.startServlet(localNewIntent);
  }
  
  protected void emS()
  {
    NewIntent localNewIntent = new NewIntent(this.mAppRuntime.getApplication(), aseo.class);
    localNewIntent.putExtra("req_type", 5);
    localNewIntent.putExtra("app_id", this.mAppId);
    this.mAppRuntime.startServlet(localNewIntent);
  }
  
  protected long getSelfUin()
  {
    long l = 0L;
    if (this.mAppRuntime != null) {
      l = this.mAppRuntime.getLongAccountUin();
    }
    return l;
  }
  
  public void s(AppRuntime paramAppRuntime)
  {
    int i = 0;
    if ((paramAppRuntime instanceof AppInterface)) {
      i = ((AppInterface)paramAppRuntime).getAppid();
    }
    this.mAppRuntime = paramAppRuntime;
    this.mAppId = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asem
 * JD-Core Version:    0.7.0.1
 */
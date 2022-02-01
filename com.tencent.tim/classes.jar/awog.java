import android.os.IBinder;
import android.os.IBinder.DeathRecipient;

class awog
  implements IBinder.DeathRecipient
{
  awog(awof paramawof) {}
  
  public void binderDied()
  {
    asbt.i("WadlProxyServiceManager", "wadl download process is died!");
    awof.a(this.this$0).asBinder().unlinkToDeath(awof.a(this.this$0), 0);
    awof.a(this.this$0, null);
    if ((awof.a(this.this$0) != null) && (awof.a(this.this$0).aNj()))
    {
      asbt.i("WadlProxyServiceManager", "download process died restart service");
      this.this$0.eEB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awog
 * JD-Core Version:    0.7.0.1
 */
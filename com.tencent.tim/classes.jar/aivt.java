import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import com.tencent.qphone.base.util.QLog;

class aivt
  extends ConnectivityManager.NetworkCallback
{
  aivt(aivs paramaivs) {}
  
  public void onAvailable(Network paramNetwork)
  {
    QLog.d("GateWayVerifyManager", 1, "switch network success");
    if ((aivs.a(this.this$0) == null) || (!aivs.a(this.this$0).equals(paramNetwork)))
    {
      aivs.a(this.this$0, paramNetwork);
      if (aivs.a(this.this$0) != null) {
        aivs.a(this.this$0).a(paramNetwork);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivt
 * JD-Core Version:    0.7.0.1
 */
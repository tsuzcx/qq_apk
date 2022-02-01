import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

public class ahlc
  implements Manager
{
  private ahhh b;
  private Map<String, Map<String, Object>> kT = new HashMap();
  
  public ahlc()
  {
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> init");
    this.b = new ahhh();
  }
  
  public ahhh a()
  {
    return this.b;
  }
  
  public void h(String paramString, Map<String, Object> paramMap)
  {
    this.kT.put(paramString, paramMap);
  }
  
  public void onDestroy()
  {
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> onDestroy");
    this.b.onDestroy();
  }
  
  public Map<String, Object> r(String paramString)
  {
    return (Map)this.kT.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlc
 * JD-Core Version:    0.7.0.1
 */
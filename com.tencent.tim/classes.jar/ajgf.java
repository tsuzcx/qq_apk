import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public abstract class ajgf
  extends ajge
{
  protected MsgBackupResEntity a;
  protected Map<String, String> mMap;
  
  public ajgf(MsgBackupResEntity paramMsgBackupResEntity)
  {
    this.mMap = u(paramMsgBackupResEntity.extraDataStr);
    this.a = paramMsgBackupResEntity;
  }
  
  protected static int Gn()
  {
    return acbn.SDCARD_PATH.length();
  }
  
  public static HashMap<String, String> u(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localHashMap.put(str, paramString.get(str).toString());
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public abstract ajem a();
  
  public void dxm()
  {
    Object localObject = this.a;
    printLog("import resEntity:" + ((MsgBackupResEntity)localObject).toLogString());
    localObject = getAbsolutePath();
    String str = xo();
    try
    {
      gI(str, (String)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void gI(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      printLog("importFile null error ");
    }
    int i;
    do
    {
      return;
      i = aqhq.ad(paramString1, paramString2);
    } while (!QLog.isColorLevel());
    File localFile = new File(paramString2);
    paramString2 = new StringBuilder().append("restore,quickMove: ").append(paramString1).append(" to ").append(paramString2).append(" status:").append(i).append(" size:");
    if ((localFile != null) && (localFile.exists())) {}
    for (paramString1 = Long.valueOf(localFile.length());; paramString1 = "-1")
    {
      printLog(paramString1);
      return;
    }
  }
  
  public abstract String getAbsolutePath();
  
  public abstract String xo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgf
 * JD-Core Version:    0.7.0.1
 */
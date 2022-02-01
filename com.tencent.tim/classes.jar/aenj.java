import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.QuickAuthorityConfBean.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class aenj
{
  public int cNY;
  public int cNZ;
  public int cOa = 1;
  public int cOb;
  public int cOc;
  public ConcurrentHashMap<String, String> fa = new ConcurrentHashMap(10);
  
  public static aenj a(String paramString)
  {
    aenj localaenj = new aenj();
    if (paramString == null) {
      return localaenj;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localaenj.cNY = paramString.optInt("kCheckSignatureSwitch", 0);
      localaenj.cNZ = paramString.optInt("kDisableChooseSwitch", 0);
      localaenj.cOa = paramString.optInt("kShowKickDialog", 1);
      localaenj.cOb = paramString.optInt("kFDHookSwitch", 0);
      localaenj.cOc = paramString.optInt("kWtloginPowTest", 0);
      paramString = paramString.optJSONObject("kSignatureList");
      if (paramString != null)
      {
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = paramString.optString(str1);
          if (!TextUtils.isEmpty(str2))
          {
            localaenj.fa.put(str1, str2);
            if (QLog.isColorLevel()) {
              QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "package: ", str1, " signature:", str2 });
            }
          }
        }
      }
      QLog.d("QuickAuthorityConfProcessor", 2, "confBean = " + localaenj.toString());
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QuickAuthorityConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
      return null;
    }
    if (localaenj.cOc == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManagerV2.executeOnSubThread(new QuickAuthorityConfBean.1(bool));
      return localaenj;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("kCheckSignatureSwitch:").append(this.cNY);
    localStringBuilder.append(" kDisableChooseSwitch:").append(this.cNZ);
    localStringBuilder.append(" signatureMaps:").append(this.fa.size());
    localStringBuilder.append(" fdSwitch:").append(this.cOb);
    localStringBuilder.append(" wtloginPowTest:").append(this.cOc);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenj
 * JD-Core Version:    0.7.0.1
 */
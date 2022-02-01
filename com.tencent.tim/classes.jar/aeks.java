import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

public class aeks
{
  private List<String> apiReportList = new ArrayList(Arrays.asList(new String[] { "requestPayment", "updateHTMLWebView", "insertHTMLWebView", "removeHTMLWebView", "insertMap", "wnsRequest", "getQua", "openUrl", "notifyNative", "launchApplication", "getUserInfoExtra", "updateShareMenu", "showShareMenu", "hideShareMenu", "getShareInfo", "shareAppMessage" }));
  
  public static aeks a(aeic[] paramArrayOfaeic)
  {
    aeks localaeks = new aeks();
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = localaeks;
      try
      {
        if (i < paramArrayOfaeic.length)
        {
          localaeks.apiReportList.clear();
          localObject = paramArrayOfaeic[i].content;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONArray((String)localObject);
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              localaeks.apiReportList.add(((JSONArray)localObject).getString(j));
              j += 1;
            }
          }
          i += 1;
        }
      }
      catch (Throwable paramArrayOfaeic)
      {
        QLog.d("MiniAppApiReportProcessor", 2, "parse, failed!", paramArrayOfaeic);
        localObject = null;
      }
    }
    return localObject;
  }
  
  public List<String> er()
  {
    return this.apiReportList;
  }
  
  public String toString()
  {
    new StringBuilder().append("getApiReportList:").append(TextUtils.join(",", er()));
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeks
 * JD-Core Version:    0.7.0.1
 */
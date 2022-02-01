import android.content.Context;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class xen
{
  public static void a(Context paramContext, String paramString, xep paramxep, biau parambiau)
  {
    ThreadManager.getUIHandler().post(new StoryShareEncryptHelper.2(paramString, parambiau, paramContext, paramxep));
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length == 2) {
        paramHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      i += 1;
    }
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    HashMap<String, String> localHashMap = null;
    Iterator localIterator = paramHashMap.keySet().iterator();
    paramHashMap = localHashMap;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!str.equals("src_type")) && (!str.equals("version")) && (!str.equals("from_leba")) && (!str.equals("leba_resid")) && (!str.equals("config_res_plugin_item_name")) && (!str.equals("redtouch_click_timestamp")) && (!str.equals("lebaVersion")) && (!str.equals("redid")))
      {
        localHashMap = paramHashMap;
        if (QLog.isColorLevel())
        {
          if (paramHashMap != null) {
            break label144;
          }
          paramHashMap = new StringBuilder();
        }
        for (;;)
        {
          paramHashMap.append(str);
          localHashMap = paramHashMap;
          localIterator.remove();
          paramHashMap = localHashMap;
          break;
          label144:
          paramHashMap.append('|');
        }
      }
    }
    if ((paramHashMap != null) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "remove attrs:" + paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xen
 * JD-Core Version:    0.7.0.1
 */
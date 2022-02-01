import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;

public class aclk
  implements Manager
{
  public static final String TAG = aclk.class.getSimpleName();
  public static boolean bJm;
  private QQAppInterface app;
  
  public aclk() {}
  
  public aclk(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private static void EP(String paramString)
  {
    bJm = true;
    awit.H("search_keyword_list", paramString);
  }
  
  private static String rN()
  {
    return (String)awit.f("search_keyword_list", "");
  }
  
  public void EO(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "addSearchHistory key word is null");
      }
      return;
    }
    ArrayList localArrayList = cD();
    if (localArrayList.size() >= 10) {
      localArrayList.remove(localArrayList.size() - 1);
    }
    localArrayList.remove(paramString);
    localArrayList.add(0, paramString);
    paramString = new JSONArray();
    while (i < localArrayList.size())
    {
      paramString.put(localArrayList.get(i));
      i += 1;
    }
    EP(paramString.toString());
  }
  
  public void JU(int paramInt)
  {
    ArrayList localArrayList = cD();
    if ((localArrayList != null) && (paramInt < localArrayList.size())) {
      localArrayList.remove(paramInt);
    }
    JSONArray localJSONArray = new JSONArray();
    paramInt = 0;
    while (paramInt < localArrayList.size())
    {
      localJSONArray.put(localArrayList.get(paramInt));
      paramInt += 1;
    }
    EP(localJSONArray.toString());
  }
  
  public ArrayList<String> cD()
  {
    localArrayList = new ArrayList();
    Object localObject = rN();
    if (localObject != null) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(((JSONArray)localObject).optString(i));
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void cMp()
  {
    EP("");
  }
  
  public void onDestroy() {}
  
  public void r(JSONArray paramJSONArray)
  {
    int j = 0;
    if (paramJSONArray == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "addAllSearchHistory key word is null");
      }
      return;
    }
    ArrayList localArrayList2 = cD();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i);
      if (!TextUtils.isEmpty(str))
      {
        localArrayList2.add(str);
        localArrayList1.remove(str);
      }
      i += 1;
    }
    localArrayList2.addAll(localArrayList1);
    paramJSONArray = new JSONArray();
    if (localArrayList2.size() > 10) {
      i = 10;
    }
    while (j < i)
    {
      paramJSONArray.put(localArrayList2.get(j));
      j += 1;
      continue;
      i = localArrayList2.size();
    }
    EP(paramJSONArray.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aclk
 * JD-Core Version:    0.7.0.1
 */
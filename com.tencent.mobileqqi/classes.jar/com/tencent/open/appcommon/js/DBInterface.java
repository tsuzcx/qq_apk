package com.tencent.open.appcommon.js;

import android.app.Activity;
import com.tencent.open.base.LogUtility;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DBInterface
  extends BaseInterface
{
  protected DBHelper dbHelper = null;
  
  public DBInterface(Activity paramActivity, String paramString, int paramInt)
  {
    this.dbHelper = new DBHelper(paramActivity, paramString, paramInt);
  }
  
  public int createTable(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      int i = Integer.parseInt(paramString3);
      if (!hasRight()) {}
      while (!this.dbHelper.a(paramString1, paramString2, i)) {
        return -1;
      }
      return 0;
    }
    catch (NumberFormatException paramString1) {}
    return -1;
  }
  
  public int exec(String paramString)
  {
    if (!hasRight()) {}
    while (!this.dbHelper.a(paramString)) {
      return -1;
    }
    return 0;
  }
  
  protected HashMap execSelect(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = this.dbHelper.a(paramString).iterator();
    while (paramString.hasNext())
    {
      String[] arrayOfString = (String[])paramString.next();
      if (arrayOfString.length == 2) {
        try
        {
          localHashMap.put(arrayOfString[0], Integer.valueOf(Integer.parseInt(arrayOfString[1])));
        }
        catch (Exception localException)
        {
          localHashMap.put(arrayOfString[0], Integer.valueOf(1));
        }
      }
    }
    return localHashMap;
  }
  
  public String getAllTableInfo()
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    JSONObject localJSONObject = this.dbHelper.a();
    LogUtility.c("", "getAllTableInfo >>> " + localJSONObject.toString());
    return localJSONObject.toString();
  }
  
  public String getInterfaceName()
  {
    return "qzone_db";
  }
  
  public String getMemValue(String paramString)
  {
    if (!hasRight()) {
      paramString = "baby,you don't have permission";
    }
    String str;
    do
    {
      return paramString;
      str = MemCache.a(paramString);
      paramString = str;
    } while (str != null);
    return "";
  }
  
  public String select(String paramString)
  {
    if (!hasRight()) {
      return "[]";
    }
    Object localObject = this.dbHelper.a(paramString);
    paramString = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String[] arrayOfString = (String[])((Iterator)localObject).next();
      JSONArray localJSONArray = new JSONArray();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(arrayOfString[i]);
        i += 1;
      }
      paramString.put(localJSONArray);
    }
    LogUtility.c("", "select >>> " + paramString.toString());
    return paramString.toString();
  }
  
  public void setMemValue(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    MemCache.a(paramString1, paramString2);
  }
  
  public int verifyTable(String paramString)
  {
    HashMap localHashMap = execSelect("select * from sys_table ;");
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      if (localIterator == null) {
        return -1;
      }
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        Object localObject = paramString.optJSONObject(str);
        if (localObject != null)
        {
          int i = ((JSONObject)localObject).optInt("version");
          localObject = ((JSONObject)localObject).optString("sql");
          if ((localHashMap == null) || (!localHashMap.containsKey(str)) || (((Integer)localHashMap.get(str)).intValue() != i))
          {
            exec("drop table " + str + " if exists;");
            createTable(str, (String)localObject, i + "");
          }
        }
      }
      return 0;
    }
    catch (JSONException paramString)
    {
      LogUtility.b(getInterfaceName(), "verifyTable exec err", paramString);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DBInterface
 * JD-Core Version:    0.7.0.1
 */
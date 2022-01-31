package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonWording
{
  public static final String a = "EmoticonWording.json";
  public static final String b = "wording_json";
  public static final String c = "http://imgcache.qq.com/club/item/parcel/client_wording.json";
  private static final String d = "EmoticonWording";
  private static final String e = "EmoticonPkgWording";
  private static final String f = "WordingVersion";
  Context jdField_a_of_type_AndroidContentContext;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  public EmoticonWording(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("EmoticonPkgWording", 0).getInt("WordingVersion", -1);
  }
  
  private void a()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "EmoticonWording.json");
    if ((localFile == null) || (localFile.length() <= 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonWording", 2, "wordingJson not exists probably.");
      }
      int i = a(this.jdField_a_of_type_AndroidContentContext);
      new EmoticonWording.DownloadWordingJsonTask().execute(new Object[] { this.jdField_a_of_type_AndroidContentContext, Integer.valueOf(i) });
      return;
    }
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(FileUtils.a(localFile));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("EmoticonPkgWording", 0);
    int i = paramContext.getInt("WordingVersion", 0);
    if ((paramInt > i) && (i >= 0)) {
      paramContext.edit().putInt("WordingVersion", paramInt).commit();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "EmoticonWording.json");
    return (paramContext != null) && (paramContext.length() > 0L);
  }
  
  public String a(long paramLong1, long paramLong2)
  {
    Object localObject2;
    if (paramLong1 == -1L) {
      localObject2 = "";
    }
    for (;;)
    {
      return localObject2;
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = 1L;
      }
      try
      {
        if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
          break label289;
        }
        localObject1 = this.jdField_a_of_type_OrgJsonJSONObject.getJSONArray("wording");
        if (localObject1 == null) {
          break label289;
        }
        if ((l < 1L) || (l > ((JSONArray)localObject1).length()))
        {
          if (!QLog.isColorLevel()) {
            break label292;
          }
          QLog.d("EmoticonWording", 2, "Illegal wordingId,wordingId=" + l + ",listSize=" + ((JSONArray)localObject1).length());
          break label292;
        }
        str2 = ((JSONObject)((JSONArray)localObject1).get((int)l - 1)).getString("desc_mqq");
        localObject2 = str2;
        if (str2 != null)
        {
          localObject2 = str2;
          localObject1 = str2;
          try
          {
            if (str2.contains("$EXPIRE_DATE$"))
            {
              if (paramLong2 > 0L) {
                break label244;
              }
              str2 = "";
              localObject2 = str2;
              localObject1 = str2;
              if (QLog.isColorLevel())
              {
                localObject1 = str2;
                QLog.d("EmoticonWording", 2, "Illegal expireTime, expireTime=" + paramLong2);
                return "";
              }
            }
          }
          catch (JSONException localJSONException1) {}
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          String str2;
          String str1;
          Object localObject1 = "";
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonWording", 2, "Error occurred while parsing wording.json");
    }
    localJSONException1.printStackTrace();
    return localObject1;
    label244:
    localObject1 = str2;
    str1 = str2.replaceAll("\\$EXPIRE_DATE\\$", new SimpleDateFormat("yyyy年MM月dd日").format(Long.valueOf(1000L * paramLong2)));
    return str1;
    label289:
    return "";
    label292:
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonWording
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zct
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private zco jdField_a_of_type_Zco;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public zct(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i = 0;
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("enable", false);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("patchType", null);
    this.jdField_a_of_type_Int = paramJSONObject.optInt("patchVersion", 0);
    this.b = paramJSONObject.optString("appVersion", null);
    this.c = paramJSONObject.optString("revision", null);
    paramJSONObject = paramJSONObject.optJSONArray("patchItemConfigs");
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (i < paramJSONObject.length())
        {
          zco localzco = zco.a(this.jdField_a_of_type_JavaLangString, paramJSONObject.getJSONObject(i));
          if (localzco != null) {
            this.jdField_a_of_type_Zco = localzco;
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PatchLogTag", 2, "PatchConfig readFromJsonString", paramJSONObject);
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public zco a()
  {
    return this.jdField_a_of_type_Zco;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Context paramContext, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig enable is false");
      return false;
    }
    if (!"a15c4095".equals(this.c))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig revision not match expect: a15c4095");
      return false;
    }
    if ((TextUtils.isEmpty(this.b)) || (!this.b.equals(anet.a(paramContext) + "." + anet.a(paramContext))))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig app version not match expect: " + anet.a(paramContext) + "." + anet.a(paramContext));
      return false;
    }
    if ((this.jdField_a_of_type_Zco == null) || (!this.jdField_a_of_type_Zco.a(paramBoolean)))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig patchItemConfig null or invalid");
      return false;
    }
    QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig return true");
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Zco != null) {
      return this.jdField_a_of_type_Zco.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Zco != null) {
      return this.jdField_a_of_type_Zco.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Zco != null) && (this.jdField_a_of_type_Zco.a());
  }
  
  public int c()
  {
    if ((!b()) && (PatchCommonUtil.isArtGeN()) && (this.jdField_a_of_type_Zco != null)) {
      return ((zcp)this.jdField_a_of_type_Zco).a();
    }
    return b();
  }
  
  public String c()
  {
    String str = b();
    if (b()) {}
    do
    {
      return str;
      if (PatchCommonUtil.isArtGeO()) {
        return "androidO7z_" + str;
      }
    } while (!PatchCommonUtil.isArtGeN());
    return "androidN7z_" + str;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Zco != null) && (this.jdField_a_of_type_Zco.b());
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Zco != null) {
      return this.jdField_a_of_type_Zco.b;
    }
    return null;
  }
  
  public String e()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("enable", this.jdField_a_of_type_Boolean);
      ((JSONObject)localObject2).put("patchType", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("patchVersion", this.jdField_a_of_type_Int);
      ((JSONObject)localObject2).put("appVersion", this.b);
      ((JSONObject)localObject2).put("revision", this.c);
      if (this.jdField_a_of_type_Zco != null)
      {
        String str = this.jdField_a_of_type_Zco.a();
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(0, new JSONObject(str));
        ((JSONObject)localObject2).put("patchItemConfigs", localJSONArray);
      }
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PatchLogTag", 2, "PatchConfig writeToJsonString", localJSONException);
    }
    return localObject1;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zct
 * JD-Core Version:    0.7.0.1
 */
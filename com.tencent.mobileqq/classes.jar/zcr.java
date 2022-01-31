import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class zcr
  extends zco
{
  private ArrayList<String> a;
  
  public zcr(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a(paramJSONObject);
  }
  
  public String a()
  {
    String str1 = super.a();
    try
    {
      JSONObject localJSONObject = new JSONObject(str1);
      localJSONObject.put("patchName", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("patchUrl", this.b);
      localJSONObject.put("patchSize", this.jdField_a_of_type_Int);
      StringBuilder localStringBuilder = new StringBuilder("");
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str3)) {
            localStringBuilder.append(str3).append(";");
          }
        }
      }
      localJSONException.put("classIdList", localStringBuilder.toString());
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigDalvik writeToJsonString", localJSONException);
      return str1;
    }
    String str2 = localJSONException.toString();
    return str2;
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = 0;
    super.a(paramJSONObject);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("patchName", null);
    this.b = paramJSONObject.optString("patchUrl", null);
    this.jdField_a_of_type_Int = paramJSONObject.optInt("patchSize", 0);
    paramJSONObject = paramJSONObject.optString("classIdList", "").split(";");
    if ((paramJSONObject != null) && (paramJSONObject.length > 0))
    {
      int j = paramJSONObject.length;
      while (i < j)
      {
        CharSequence localCharSequence = paramJSONObject[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localCharSequence);
        }
        i += 1;
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigDalvik isValidConfig classIdList is empty");
      return false;
    }
    return super.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcr
 * JD-Core Version:    0.7.0.1
 */
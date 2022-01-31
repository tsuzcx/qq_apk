import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzf
{
  public int a;
  public String a;
  public ArrayList<Integer> a;
  public ArrayList<String> b = new ArrayList();
  public ArrayList<Integer> c = new ArrayList();
  public ArrayList<Integer> d = new ArrayList();
  
  public zzf()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
  }
  
  public static ArrayList<zzf> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(zzj.a(paramString));
      int i = 0;
      while (i < paramString.length())
      {
        zyw.b("KingKongSubPatch", "Parsing sub patch " + i);
        zzf localzzf = new zzf();
        if (localzzf.a(paramString.getJSONObject(i)))
        {
          localzzf.a();
          localArrayList.add(localzzf);
          i += 1;
        }
        else
        {
          zyw.a("KingKongSubPatch", "Parse sub patch failed, give up");
          return null;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      zyw.a("KingKongSubPatch", "Parse SubPatch List exception : " + paramString);
    }
    return null;
  }
  
  public void a()
  {
    int k = 0;
    int i = 0;
    while (i < this.c.size())
    {
      zyw.b("KingKongSubPatch", "--> HookPoints : " + this.c.get(i));
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      zyw.b("KingKongSubPatch", "--> Parameters : " + ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).toString());
      i += 1;
    }
    while (j < this.b.size())
    {
      zyw.b("KingKongSubPatch", "--> FingerPrint : " + (String)this.b.get(j) + ", " + this.d.get(j));
      j += 1;
    }
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    int i;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("patch_file").trim();
        JSONArray localJSONArray1 = paramJSONObject.getJSONArray("parameters");
        localJSONArray2 = paramJSONObject.getJSONArray("fingerprints");
        localJSONArray3 = paramJSONObject.getJSONArray("hook_point");
        localJSONArray4 = paramJSONObject.getJSONArray("fingerprints_value");
        int m = localJSONArray1.length();
        k = localJSONArray2.length();
        int n = localJSONArray4.length();
        j = localJSONArray3.length();
        i = 0;
        if (i < m)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(localJSONArray1.getInt(i)));
          i += 1;
          continue;
        }
        if (n == k) {
          break;
        }
        zyw.a("KingKongSubPatch", "Fingerprint value count mismatch " + n + ", " + k);
        return false;
      }
      catch (JSONException paramJSONObject)
      {
        JSONArray localJSONArray2;
        JSONArray localJSONArray3;
        JSONArray localJSONArray4;
        int k;
        int j;
        zyw.a("KingKongSubPatch", "Parse SubPatch error : " + paramJSONObject);
        return false;
      }
      catch (Exception paramJSONObject)
      {
        return false;
      }
      if (i >= k) {
        break label272;
      }
      this.b.add(localJSONArray2.getString(i).trim());
      this.d.add(Integer.valueOf(localJSONArray4.getInt(i)));
      i += 1;
    }
    for (;;)
    {
      if (i < j)
      {
        this.c.add(Integer.valueOf(localJSONArray3.getInt(i)));
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_Int = paramJSONObject.optInt("isThumb2", 1);
        return true;
        i = 0;
        break;
        label272:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zzf
 * JD-Core Version:    0.7.0.1
 */
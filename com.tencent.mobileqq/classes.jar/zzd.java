import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;

public class zzd
{
  private static zzd jdField_a_of_type_Zzd;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public String a;
  private ArrayList<zzk> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private zzd()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private zzd(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramContext = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("PATCH_LIST", "").split(";");
    int j = paramContext.length;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if (!((String)localObject).equals(""))
      {
        localObject = new zzk(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        zyz.a("KingKongMainConfig", "--> " + localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public static zzd a(Context paramContext)
  {
    if (jdField_a_of_type_Zzd != null) {
      return jdField_a_of_type_Zzd;
    }
    try
    {
      if (jdField_a_of_type_Zzd != null)
      {
        paramContext = jdField_a_of_type_Zzd;
        return paramContext;
      }
    }
    finally {}
    jdField_a_of_type_Zzd = new zzd(paramContext);
    paramContext = jdField_a_of_type_Zzd;
    return paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    zzk localzzk;
    for (String str = ""; localIterator.hasNext(); str = str + localzzk.jdField_a_of_type_JavaLangString + ";") {
      localzzk = (zzk)localIterator.next();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public ArrayList<zzk> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public zzk a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      zzk localzzk = (zzk)localIterator.next();
      if (localzzk.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localzzk;
      }
    }
    return null;
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      zzk localzzk = (zzk)localIterator.next();
      if (localzzk.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localzzk.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localzzk);
      }
    }
    a();
  }
  
  public void a(zzk paramzzk)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((zzk)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramzzk.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramzzk);
      }
      for (;;)
      {
        paramzzk.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        return;
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramzzk);
        a();
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zzd
 * JD-Core Version:    0.7.0.1
 */
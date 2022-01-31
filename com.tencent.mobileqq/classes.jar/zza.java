import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;

public class zza
{
  private static zza jdField_a_of_type_Zza;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public String a;
  private ArrayList<zzh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private zza()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private zza(Context paramContext)
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
        localObject = new zzh(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        zyw.a("KingKongMainConfig", "--> " + localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public static zza a(Context paramContext)
  {
    if (jdField_a_of_type_Zza != null) {
      return jdField_a_of_type_Zza;
    }
    try
    {
      if (jdField_a_of_type_Zza != null)
      {
        paramContext = jdField_a_of_type_Zza;
        return paramContext;
      }
    }
    finally {}
    jdField_a_of_type_Zza = new zza(paramContext);
    paramContext = jdField_a_of_type_Zza;
    return paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    zzh localzzh;
    for (String str = ""; localIterator.hasNext(); str = str + localzzh.jdField_a_of_type_JavaLangString + ";") {
      localzzh = (zzh)localIterator.next();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public ArrayList<zzh> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public zzh a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      zzh localzzh = (zzh)localIterator.next();
      if (localzzh.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localzzh;
      }
    }
    return null;
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      zzh localzzh = (zzh)localIterator.next();
      if (localzzh.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localzzh.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localzzh);
      }
    }
    a();
  }
  
  public void a(zzh paramzzh)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((zzh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramzzh.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramzzh);
      }
      for (;;)
      {
        paramzzh.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        return;
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramzzh);
        a();
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zza
 * JD-Core Version:    0.7.0.1
 */
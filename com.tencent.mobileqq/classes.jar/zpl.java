import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;

public class zpl
{
  private static zpl jdField_a_of_type_Zpl;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public String a;
  private ArrayList<zps> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private zpl()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private zpl(Context paramContext)
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
        localObject = new zps(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        zph.a("KingKongMainConfig", "--> " + localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public static zpl a(Context paramContext)
  {
    if (jdField_a_of_type_Zpl != null) {
      return jdField_a_of_type_Zpl;
    }
    try
    {
      if (jdField_a_of_type_Zpl != null)
      {
        paramContext = jdField_a_of_type_Zpl;
        return paramContext;
      }
    }
    finally {}
    jdField_a_of_type_Zpl = new zpl(paramContext);
    paramContext = jdField_a_of_type_Zpl;
    return paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    zps localzps;
    for (String str = ""; localIterator.hasNext(); str = str + localzps.jdField_a_of_type_JavaLangString + ";") {
      localzps = (zps)localIterator.next();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public ArrayList<zps> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public zps a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      zps localzps = (zps)localIterator.next();
      if (localzps.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localzps;
      }
    }
    return null;
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      zps localzps = (zps)localIterator.next();
      if (localzps.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localzps.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localzps);
      }
    }
    a();
  }
  
  public void a(zps paramzps)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((zps)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramzps.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, paramzps);
      }
      for (;;)
      {
        paramzps.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        return;
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramzps);
        a();
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zpl
 * JD-Core Version:    0.7.0.1
 */
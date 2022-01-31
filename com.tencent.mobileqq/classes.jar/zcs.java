import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;

class zcs
  implements nbt
{
  zcs(zcr paramzcr, long paramLong, Context paramContext, boolean paramBoolean, nbt paramnbt) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ViewPluginManager", 4, "transToLocalUrl transUrl:" + paramString);
    }
    this.jdField_a_of_type_Zcr.d = nbv.a(this.jdField_a_of_type_Zcr.jdField_a_of_type_JavaLangString);
    String str = ncb.a(this.jdField_a_of_type_Zcr.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_Zcr.jdField_a_of_type_JavaLangString + "/" + this.jdField_a_of_type_Zcr.b;
    try
    {
      Object localObject = new File(this.jdField_a_of_type_Zcr.c);
      if (!this.jdField_a_of_type_Zcr.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.jdField_a_of_type_Zcr.a(this.jdField_a_of_type_Zcr.jdField_a_of_type_JavaLangString), "-1").equals(this.jdField_a_of_type_Zcr.d))
      {
        if (!((File)localObject).exists()) {
          break label379;
        }
        bdhb.a(((File)localObject).getAbsolutePath());
        this.jdField_a_of_type_Zcr.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.jdField_a_of_type_Zcr.a(this.jdField_a_of_type_Zcr.jdField_a_of_type_JavaLangString), nbv.a(this.jdField_a_of_type_Zcr.jdField_a_of_type_JavaLangString)).commit();
        ((File)localObject).mkdirs();
      }
      for (;;)
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Zcr.b).getCanonicalPath();
        this.jdField_a_of_type_Zcr.jdField_a_of_type_JavaLangClassLoader = new DexClassLoader(str, this.jdField_a_of_type_Zcr.c, (String)localObject, this.jdField_a_of_type_AndroidContentContext.getClassLoader());
        this.jdField_a_of_type_Zcr.jdField_a_of_type_Zcm = new zcm(this.jdField_a_of_type_AndroidContentContext, 0, str, null, null, this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Nbt == null) {
          break;
        }
        this.jdField_a_of_type_Nbt.loaded(paramInt, paramString);
        return;
        label379:
        ((File)localObject).mkdirs();
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginManager", 2, "create classloader failed:" + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zcs
 * JD-Core Version:    0.7.0.1
 */
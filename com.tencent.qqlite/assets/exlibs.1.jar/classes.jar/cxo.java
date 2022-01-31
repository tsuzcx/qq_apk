import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.qphone.base.util.BaseApplication;

public class cxo
{
  private static final String i = "_timeToWait";
  private static final String j = "_lastReportTime";
  private static final String k = "_lastUpdateTime";
  private static final String l = "_sigHash";
  private static final String m = "_md5";
  private static final String n = "_serverResult";
  private static final String o = "_dlgTitle";
  private static final String p = "_dlgContent";
  private static final String q = "_dlgLButton";
  private static final String r = "_dlgRButoon";
  private static final String s = "_dlgUrl";
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  String h;
  
  public cxo(StartAppCheckHandler paramStartAppCheckHandler, String paramString)
  {
    this.h = paramString;
    a();
  }
  
  public void a()
  {
    if (this.h == null) {
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("AppStartedObserver", 0);
    this.jdField_a_of_type_Long = localSharedPreferences.getLong(this.h + "_timeToWait", 0L);
    this.jdField_b_of_type_Long = localSharedPreferences.getLong(this.h + "_lastReportTime", 0L);
    this.jdField_c_of_type_Long = localSharedPreferences.getLong(this.h + "_lastUpdateTime", 0L);
    this.jdField_a_of_type_JavaLangString = localSharedPreferences.getString(this.h + "_sigHash", "");
    this.jdField_b_of_type_JavaLangString = localSharedPreferences.getString(this.h + "_md5", "");
    this.jdField_a_of_type_Int = localSharedPreferences.getInt(this.h + "_serverResult", 0);
    this.jdField_c_of_type_JavaLangString = localSharedPreferences.getString(this.h + "_dlgTitle", "");
    this.d = localSharedPreferences.getString(this.h + "_dlgContent", "");
    this.e = localSharedPreferences.getString(this.h + "_dlgLButton", "");
    this.f = localSharedPreferences.getString(this.h + "_dlgRButoon", "");
    this.g = localSharedPreferences.getString(this.h + "_dlgUrl", "");
  }
  
  public void b()
  {
    if (this.h == null) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("AppStartedObserver", 0).edit();
    localEditor.putLong(this.h + "_timeToWait", this.jdField_a_of_type_Long);
    localEditor.putLong(this.h + "_lastReportTime", this.jdField_b_of_type_Long);
    localEditor.putLong(this.h + "_lastUpdateTime", this.jdField_c_of_type_Long);
    localEditor.putString(this.h + "_sigHash", this.jdField_a_of_type_JavaLangString);
    localEditor.putString(this.h + "_md5", this.jdField_b_of_type_JavaLangString);
    localEditor.putInt(this.h + "_serverResult", this.jdField_a_of_type_Int);
    localEditor.putString(this.h + "_dlgTitle", this.jdField_c_of_type_JavaLangString);
    localEditor.putString(this.h + "_dlgContent", this.d);
    localEditor.putString(this.h + "_dlgLButton", this.e);
    localEditor.putString(this.h + "_dlgRButoon", this.f);
    localEditor.putString(this.h + "_dlgUrl", this.g);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cxo
 * JD-Core Version:    0.7.0.1
 */
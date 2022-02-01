package cooperation.qzone;

import android.os.Bundle;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import cooperation.qzone.widget.RadioPreference;
import ibv;
import ibw;

public class QZoneStatisticsSettingActivity
  extends PreferenceActivity
{
  public static int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "test100";
  public static final boolean a = true;
  public static int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "test50";
  private static final int jdField_c_of_type_Int = 0;
  private static final String jdField_c_of_type_JavaLangString = "testDefault";
  private static final int jdField_d_of_type_Int = 1;
  private static final String jdField_d_of_type_JavaLangString = "leiji";
  private static final String jdField_e_of_type_JavaLangString = "leiji2";
  private static final String jdField_f_of_type_JavaLangString = "leijiDefault";
  Preference.OnPreferenceClickListener jdField_a_of_type_AndroidPreferencePreference$OnPreferenceClickListener = new ibv(this);
  RadioPreference jdField_a_of_type_CooperationQzoneWidgetRadioPreference;
  Preference.OnPreferenceClickListener jdField_b_of_type_AndroidPreferencePreference$OnPreferenceClickListener = new ibw(this);
  RadioPreference jdField_b_of_type_CooperationQzoneWidgetRadioPreference;
  RadioPreference jdField_c_of_type_CooperationQzoneWidgetRadioPreference;
  RadioPreference jdField_d_of_type_CooperationQzoneWidgetRadioPreference;
  RadioPreference jdField_e_of_type_CooperationQzoneWidgetRadioPreference;
  RadioPreference jdField_f_of_type_CooperationQzoneWidgetRadioPreference;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
  }
  
  private void a()
  {
    this.jdField_a_of_type_CooperationQzoneWidgetRadioPreference.setOnPreferenceClickListener(this.jdField_a_of_type_AndroidPreferencePreference$OnPreferenceClickListener);
    this.jdField_b_of_type_CooperationQzoneWidgetRadioPreference.setOnPreferenceClickListener(this.jdField_a_of_type_AndroidPreferencePreference$OnPreferenceClickListener);
    this.c.setOnPreferenceClickListener(this.jdField_a_of_type_AndroidPreferencePreference$OnPreferenceClickListener);
    this.jdField_a_of_type_CooperationQzoneWidgetRadioPreference.setKey("test100");
    this.jdField_b_of_type_CooperationQzoneWidgetRadioPreference.setKey("test50");
    this.c.setKey("testDefault");
    this.d.setOnPreferenceClickListener(this.jdField_b_of_type_AndroidPreferencePreference$OnPreferenceClickListener);
    this.e.setOnPreferenceClickListener(this.jdField_b_of_type_AndroidPreferencePreference$OnPreferenceClickListener);
    this.f.setOnPreferenceClickListener(this.jdField_b_of_type_AndroidPreferencePreference$OnPreferenceClickListener);
    this.d.setKey("leiji");
    this.e.setKey("leiji2");
    this.f.setKey("leijiDefault");
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_CooperationQzoneWidgetRadioPreference.a(false);
      this.jdField_b_of_type_CooperationQzoneWidgetRadioPreference.a(false);
      this.c.a(false);
      return;
    }
    this.d.a(false);
    this.e.a(false);
    this.f.a(false);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramString.equals("test100")) {
      jdField_a_of_type_Int = 1;
    }
    do
    {
      return;
      if (paramString.equals("test50"))
      {
        jdField_a_of_type_Int = 2;
        return;
      }
      if (paramString.equals("testDefault"))
      {
        jdField_a_of_type_Int = 0;
        return;
      }
      if (paramString.equals("leiji"))
      {
        jdField_b_of_type_Int = 1;
        return;
      }
      if (paramString.equals("leiji2"))
      {
        jdField_b_of_type_Int = 2;
        return;
      }
    } while (!paramString.equals("leijiDefault"));
    jdField_b_of_type_Int = 0;
  }
  
  private void b()
  {
    boolean bool2 = true;
    RadioPreference localRadioPreference = this.jdField_a_of_type_CooperationQzoneWidgetRadioPreference;
    if (jdField_a_of_type_Int == 1)
    {
      bool1 = true;
      localRadioPreference.a(bool1);
      localRadioPreference = this.jdField_b_of_type_CooperationQzoneWidgetRadioPreference;
      if (jdField_a_of_type_Int != 2) {
        break label120;
      }
      bool1 = true;
      label35:
      localRadioPreference.a(bool1);
      localRadioPreference = this.c;
      if (jdField_a_of_type_Int != 0) {
        break label125;
      }
      bool1 = true;
      label53:
      localRadioPreference.a(bool1);
      localRadioPreference = this.d;
      if (jdField_b_of_type_Int != 1) {
        break label130;
      }
      bool1 = true;
      label72:
      localRadioPreference.a(bool1);
      localRadioPreference = this.e;
      if (jdField_b_of_type_Int != 2) {
        break label135;
      }
      bool1 = true;
      label91:
      localRadioPreference.a(bool1);
      localRadioPreference = this.f;
      if (jdField_b_of_type_Int != 0) {
        break label140;
      }
    }
    label130:
    label135:
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localRadioPreference.a(bool1);
      return;
      bool1 = false;
      break;
      label120:
      bool1 = false;
      break label35;
      label125:
      bool1 = false;
      break label53;
      bool1 = false;
      break label72;
      bool1 = false;
      break label91;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_CooperationQzoneWidgetRadioPreference = ((RadioPreference)findPreference("test100"));
    this.jdField_b_of_type_CooperationQzoneWidgetRadioPreference = ((RadioPreference)findPreference("test50"));
    this.c = ((RadioPreference)findPreference("testDefault"));
    this.d = ((RadioPreference)findPreference("leiji"));
    this.e = ((RadioPreference)findPreference("leiji2"));
    this.f = ((RadioPreference)findPreference("leijiDefault"));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099657);
    c();
    a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneStatisticsSettingActivity
 * JD-Core Version:    0.7.0.1
 */
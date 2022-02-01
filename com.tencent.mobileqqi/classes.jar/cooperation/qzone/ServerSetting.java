package cooperation.qzone;

import android.os.Bundle;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import cooperation.qzone.widget.RadioPreference;
import ibz;

public class ServerSetting
  extends PreferenceActivity
{
  public static final boolean a = true;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 0, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "正式", "TEST_001", "TOUCH_001", "DB", "PUBLISH", "DEV_001", "DEV_002", "DEV_003", "DEV_004", "DEV_005", "DEV_006", "DEV_007", "DEV_008", "DEV_009", "DEV_010", "DEV_011", "DEV_012", "DEV_013", "DEV_014", "DEV_015", "DEV_016", "DEV_017", "DEV_018", "DEV_019", "DEV_020", "DEV_021", "DEV_022", "TEST_002", "TEST_003", "TEST_004", "TEST_005", "DEV_027", "DEV_028", "DEV_029", "DEV_030", "DEV_031", "DEV_032", "DEV_033", "DEV_034", "DEV_035", "DEV_036", "DEV_037", "DEV_050", "DEV_051", "DEV_052", "DEV_053", "DEV_054", "DEV_055", "DEV_056", "DEV_057", "DEV_058", "DEV_059", "DEV_060", "DEV_061", "DEV_062", "DEV_063", "DEV_064", "DEV_065", "DEV_066", "DEV_067", "DEV_068", "DEV_069" };
  RadioPreference[] jdField_a_of_type_ArrayOfCooperationQzoneWidgetRadioPreference;
  
  private void a()
  {
    RadioPreference[] arrayOfRadioPreference = this.jdField_a_of_type_ArrayOfCooperationQzoneWidgetRadioPreference;
    int j = arrayOfRadioPreference.length;
    int i = 0;
    while (i < j)
    {
      arrayOfRadioPreference[i].a(false);
      i += 1;
    }
  }
  
  private void a(Preference.OnPreferenceClickListener paramOnPreferenceClickListener)
  {
    RadioPreference[] arrayOfRadioPreference = this.jdField_a_of_type_ArrayOfCooperationQzoneWidgetRadioPreference;
    int j = arrayOfRadioPreference.length;
    int i = 0;
    while (i < j)
    {
      arrayOfRadioPreference[i].setOnPreferenceClickListener(paramOnPreferenceClickListener);
      i += 1;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    int i = 0;
    if (i < jdField_a_of_type_ArrayOfJavaLangString.length) {
      if (paramString != jdField_a_of_type_ArrayOfJavaLangString[i]) {}
    }
    for (int j = i;; j = -1)
    {
      i = paramInt;
      if (j != -1) {
        i = jdField_a_of_type_ArrayOfInt[j];
      }
      if (i == 0)
      {
        if (!ServerListProvider.c()) {
          break label89;
        }
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          QZoneHelper.LocalConfig.a("ServerEnvironment", i);
          return;
          i += 1;
          break;
          if (!ServerListProvider.b()) {
            break label89;
          }
          paramInt = 1;
          continue;
        }
        Toast.makeText(this, "切换环境失败", 0).show();
        return;
        label89:
        paramInt = 0;
      }
    }
  }
  
  private void b()
  {
    int j = ServerListProvider.a();
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfCooperationQzoneWidgetRadioPreference.length)
    {
      RadioPreference localRadioPreference = this.jdField_a_of_type_ArrayOfCooperationQzoneWidgetRadioPreference[i];
      if (j == jdField_a_of_type_ArrayOfInt[i]) {}
      for (boolean bool = true;; bool = false)
      {
        localRadioPreference.a(bool);
        i += 1;
        break;
      }
    }
  }
  
  private void c()
  {
    PreferenceScreen localPreferenceScreen = getPreferenceScreen();
    this.jdField_a_of_type_ArrayOfCooperationQzoneWidgetRadioPreference = new RadioPreference[jdField_a_of_type_ArrayOfJavaLangString.length];
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      RadioPreference localRadioPreference = new RadioPreference(this);
      localRadioPreference.setTitle(jdField_a_of_type_ArrayOfJavaLangString[i]);
      localRadioPreference.setKey(jdField_a_of_type_ArrayOfJavaLangString[i]);
      localRadioPreference.setWidgetLayoutResource(2130903860);
      this.jdField_a_of_type_ArrayOfCooperationQzoneWidgetRadioPreference[i] = localRadioPreference;
      localPreferenceScreen.addPreference(localRadioPreference);
      i += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099656);
    paramBundle = new ibz(this);
    c();
    a();
    a(paramBundle);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.ServerSetting
 * JD-Core Version:    0.7.0.1
 */
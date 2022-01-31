package com.tencent.mobileqq.activity.language;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ehn;
import eho;
import ehp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectTransLangActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "SelectTransLangActivity";
  private int jdField_a_of_type_Int = -1;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private ehp jdField_a_of_type_Ehp;
  private final List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap;
  private String b;
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((String)this.jdField_a_of_type_JavaUtilList.get(i)).equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {
        while (i > 0)
        {
          Collections.swap(this.jdField_a_of_type_JavaUtilList, i, i - 1);
          i -= 1;
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131231857));
    if (!"10000512".equals(AppSetting.a(this)))
    {
      View localView = LayoutInflater.from(this).inflate(2130903259, null, false);
      localView.findViewById(2131231861).setOnClickListener(new ehn(this));
      this.jdField_a_of_type_AndroidWidgetListView.addFooterView(localView);
    }
    this.jdField_a_of_type_Ehp = new ehp(this, this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Ehp);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new eho(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put("ar", "العربية");
    this.jdField_a_of_type_JavaUtilMap.put("zh_CN", "简体中文");
    this.jdField_a_of_type_JavaUtilMap.put("zh_TW", "繁體中文");
    this.jdField_a_of_type_JavaUtilMap.put("en", "English");
    this.jdField_a_of_type_JavaUtilMap.put("fr", "Français‬");
    this.jdField_a_of_type_JavaUtilMap.put("de", "Deutsch‬‬");
    this.jdField_a_of_type_JavaUtilMap.put("id", "Bahasa Indonesia");
    this.jdField_a_of_type_JavaUtilMap.put("it", "Italiano");
    this.jdField_a_of_type_JavaUtilMap.put("ja", "‪日本語‬‬");
    this.jdField_a_of_type_JavaUtilMap.put("ko", "‪한국어‬‬");
    this.jdField_a_of_type_JavaUtilMap.put("ms", "Bahasa Melayu‬‬");
    this.jdField_a_of_type_JavaUtilMap.put("fa", "فارسی");
    this.jdField_a_of_type_JavaUtilMap.put("pt", "Português");
    this.jdField_a_of_type_JavaUtilMap.put("ru", "русский");
    this.jdField_a_of_type_JavaUtilMap.put("es", "Español");
    this.jdField_a_of_type_JavaUtilMap.put("th", "ภาษาไทย");
    this.jdField_a_of_type_JavaUtilMap.put("tr", "Türkçe‬‬");
    this.jdField_a_of_type_JavaUtilMap.put("ur", "اردو");
    this.jdField_a_of_type_JavaUtilMap.put("vi", "‪Tiếng Việt‬‬");
    this.jdField_a_of_type_JavaUtilList.add("ar");
    this.jdField_a_of_type_JavaUtilList.add("zh_CN");
    this.jdField_a_of_type_JavaUtilList.add("zh_TW");
    this.jdField_a_of_type_JavaUtilList.add("en");
    this.jdField_a_of_type_JavaUtilList.add("fr");
    this.jdField_a_of_type_JavaUtilList.add("de");
    this.jdField_a_of_type_JavaUtilList.add("id");
    this.jdField_a_of_type_JavaUtilList.add("it");
    this.jdField_a_of_type_JavaUtilList.add("ja");
    this.jdField_a_of_type_JavaUtilList.add("ko");
    this.jdField_a_of_type_JavaUtilList.add("ms");
    this.jdField_a_of_type_JavaUtilList.add("fa");
    this.jdField_a_of_type_JavaUtilList.add("pt");
    this.jdField_a_of_type_JavaUtilList.add("ru");
    this.jdField_a_of_type_JavaUtilList.add("es");
    this.jdField_a_of_type_JavaUtilList.add("th");
    this.jdField_a_of_type_JavaUtilList.add("tr");
    this.jdField_a_of_type_JavaUtilList.add("ur");
    this.jdField_a_of_type_JavaUtilList.add("vi");
    QLog.d("SelectTransLangActivity", 2, "init lauguage list:" + this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903257);
    setTitle(2131559792);
    e();
    this.jdField_b_of_type_JavaLangString = LocaleUtil.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Int != -1) {
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "Translate_external", "Change_target_language", 0, 1, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.language.SelectTransLangActivity
 * JD-Core Version:    0.7.0.1
 */
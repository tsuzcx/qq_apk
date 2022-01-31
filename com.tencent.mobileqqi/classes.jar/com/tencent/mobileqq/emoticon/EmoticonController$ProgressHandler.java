package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class EmoticonController$ProgressHandler
{
  public int a;
  final Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  public final EmoticonPackage a;
  public EPluginInstallTask a;
  public String a;
  public HashMap a;
  public boolean a;
  public int b;
  public String b;
  private boolean b;
  public int c = 0;
  public int d;
  
  EmoticonController$ProgressHandler(EmoticonController paramEmoticonController, Emoticon paramEmoticon)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = null;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramEmoticon;
    a("param_eId", paramEmoticon.eId);
    a("param_epId", paramEmoticon.epId);
  }
  
  EmoticonController$ProgressHandler(EmoticonController paramEmoticonController, EmoticonPackage paramEmoticonPackage)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = null;
    a("param_epId", paramEmoticonPackage.epId);
  }
  
  private float b()
  {
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = f3;
    if (this.jdField_a_of_type_Int > 0)
    {
      f1 = f3;
      if (this.jdField_b_of_type_Int >= 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType != 1) {
          break label79;
        }
        f1 = f3;
        if (this.d != 3)
        {
          f3 = this.jdField_b_of_type_Int * 0.95F / this.jdField_a_of_type_Int;
          f1 = f2;
          if (this.d == 2) {
            f1 = 1.0F - 0.95F;
          }
          f1 += f3;
        }
      }
    }
    return f1;
    label79:
    return this.jdField_b_of_type_Int * 1.0F / this.jdField_a_of_type_Int;
  }
  
  public float a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEPluginInstallTask != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEPluginInstallTask.a())) {}
    for (float f = this.jdField_a_of_type_ComTencentMobileqqEmoticonEPluginInstallTask.a() * 0.7F + b() * 0.3F; f < 0.05F; f = b()) {
      return 0.05F;
    }
    return f;
  }
  
  public int a()
  {
    int i = 11022;
    if (this.jdField_a_of_type_Boolean) {
      i = 0;
    }
    do
    {
      return i;
      if (this.c == 1002) {
        return 11023;
      }
      if (!this.jdField_b_of_type_Boolean) {
        return 11007;
      }
    } while (this.c == 11022);
    return 11009;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEPluginInstallTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEPluginInstallTask.b();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    a(paramString, Integer.toString(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0)) {}
    String str;
    do
    {
      do
      {
        return;
      } while (("param_error".equals(paramString1)) || ("param_resp_content_read".equals(paramString1)) || ("param_resp_content".equals(paramString1)) || ("param_try_count".equals(paramString1)));
      if (("param_step".equals(paramString1)) && (Integer.toString(5).equals(paramString2)))
      {
        if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_key_seq", this.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_encrypt_keys", Integer.toString(this.c));
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_timeout", this.jdField_a_of_type_JavaLangString);
        }
      }
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "put key:" + paramString1 + " value:" + paramString2 + " oldValue:" + str);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmoticonController.ProgressHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.eqq;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.QQText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrmIvrText
  extends QQText
{
  static final String c = "CrmIvrText";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  String jdField_a_of_type_JavaLangString = "";
  String b = "";
  
  public CrmIvrText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    super(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected void a()
  {
    super.a();
    Matcher localMatcher = Pattern.compile(f + "|" + "QQ语音").matcher(this.h);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      a(new CrmIvrText.CrmIvrLinkSpan(this, this.h.substring(i, j)), i, j, 33);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmIvrText
 * JD-Core Version:    0.7.0.1
 */
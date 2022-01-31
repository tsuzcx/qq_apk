package com.tencent.mobileqq.text;

import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.utils.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQText$LinkSpan
  extends ClickableSpan
{
  private String jdField_a_of_type_JavaLangString;
  
  public QQText$LinkSpan(QQText paramQQText, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (Patterns.b.matcher(str).find())
    {
      this.jdField_a_of_type_ComTencentMobileqqTextQQText.a(paramView, str);
      QQText.a = Boolean.valueOf(true);
    }
    do
    {
      return;
      Matcher localMatcher = QQText.b.matcher(str);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == str.length()))
      {
        QQText.a(paramView.getContext(), str, true);
        QQText.a = Boolean.valueOf(true);
        return;
      }
    } while (!Patterns.f.matcher(str).find());
    QQText.a(paramView.getContext(), str, false);
    QQText.a = Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.LinkSpan
 * JD-Core Version:    0.7.0.1
 */
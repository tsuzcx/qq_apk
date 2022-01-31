package com.tencent.mobileqq.activity.voip;

import android.content.Context;
import android.content.res.Resources;

public class VoipPhoneNumber
{
  public Context a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public VoipPhoneNumber(String paramString, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (;;)
    {
      return;
      this.b = "";
      this.c = "";
      this.d = "";
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_JavaLangString.startsWith("+")) && (this.jdField_a_of_type_AndroidContentContext != null))
      {
        String[] arrayOfString = this.jdField_a_of_type_AndroidContentContext.getResources().getStringArray(2131689518);
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = arrayOfString[i].split(" ");
          Object localObject1 = localObject2[0];
          localObject2 = localObject2[1];
          if (this.jdField_a_of_type_JavaLangString.startsWith("+" + (String)localObject2))
          {
            this.b = ((String)localObject2);
            this.d = localObject1;
            this.c = this.jdField_a_of_type_JavaLangString.substring(1).replaceFirst((String)localObject2, "");
            this.jdField_a_of_type_Boolean = true;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean a(VoipPhoneNumber paramVoipPhoneNumber)
  {
    if (this.jdField_a_of_type_JavaLangString == paramVoipPhoneNumber.jdField_a_of_type_JavaLangString) {}
    while (((this.c != null) && (this.c.length() > 0) && ((this.c == paramVoipPhoneNumber.jdField_a_of_type_JavaLangString) || (this.c == paramVoipPhoneNumber.jdField_a_of_type_JavaLangString))) || ((paramVoipPhoneNumber.c != null) && (paramVoipPhoneNumber.c.length() > 0) && ((paramVoipPhoneNumber.c == this.c) || (paramVoipPhoneNumber.c == this.jdField_a_of_type_JavaLangString)))) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipPhoneNumber
 * JD-Core Version:    0.7.0.1
 */
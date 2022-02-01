package com.tencent.mobileqq.app.automator;

import acoo;

public class StepGroup
  extends AsyncStep
{
  protected AsyncStep[] a;
  protected String[] el;
  public int mIndex;
  public String mPattern;
  
  private String ju(String paramString)
  {
    Object localObject = paramString.toCharArray();
    int n = localObject.length;
    int j;
    int i1;
    int k;
    if (localObject[0] == '{')
    {
      j = 125;
      i1 = localObject[0];
      k = 0;
    }
    int i;
    for (int m = 0;; m = i)
    {
      if (k >= n) {
        break label147;
      }
      if (localObject[k] == i1) {
        i = m + 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label135;
        }
        localObject = paramString.substring(0, k + 1);
        do
        {
          return localObject;
          if (localObject[0] == '[')
          {
            j = 93;
            break;
          }
          localObject = paramString;
        } while (paramString.indexOf(",") == -1);
        return paramString.substring(0, paramString.indexOf(","));
        i = m;
        if (localObject[k] == j) {
          i = m - 1;
        }
      }
      label135:
      k += 1;
    }
    label147:
    return "";
  }
  
  private String[] m(String paramString)
  {
    int i = 0;
    if (paramString.length() <= 2) {
      return new String[0];
    }
    String str2 = paramString.substring(1, paramString.length() - 1);
    int k = str2.length();
    StringBuilder localStringBuilder = new StringBuilder(50);
    for (paramString = str2; i < k; paramString = str2.substring(i, k))
    {
      int j = i;
      String str1 = paramString;
      if (paramString.startsWith(","))
      {
        j = i + 1;
        str1 = str2.substring(j, k);
      }
      paramString = ju(str1);
      localStringBuilder.append(paramString).append("-");
      i = j + paramString.length();
    }
    return localStringBuilder.toString().split("-");
  }
  
  public AsyncStep a()
  {
    if (this.mIndex < this.el.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.mIndex] = acoo.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, this.el[this.mIndex]);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.mIndex].mParams = this.mParams;
      AsyncStep[] arrayOfAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep;
      int i = this.mIndex;
      this.mIndex = (i + 1);
      return arrayOfAsyncStep[i];
    }
    return null;
  }
  
  public void onCreate()
  {
    this.mTimeout = 2147483647L;
    this.el = m(this.mPattern);
    this.mIndex = 0;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep = new AsyncStep[this.el.length];
  }
  
  public void setResult(int paramInt)
  {
    if (paramInt != 4) {
      super.setResult(paramInt);
    }
    AsyncStep[] arrayOfAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep;
    int j;
    int i;
    if (((paramInt == 8) || (paramInt == 4)) && (arrayOfAsyncStep != null))
    {
      j = arrayOfAsyncStep.length;
      i = 0;
    }
    for (;;)
    {
      AsyncStep localAsyncStep;
      if (i < j)
      {
        localAsyncStep = arrayOfAsyncStep[i];
        if (localAsyncStep != null) {}
      }
      else
      {
        return;
      }
      localAsyncStep.setResult(paramInt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.StepGroup
 * JD-Core Version:    0.7.0.1
 */
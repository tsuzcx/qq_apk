package com.tencent.mobileqq.app.automator;

import java.util.ArrayList;
import java.util.Iterator;

public class StepGroup
  extends AsyncStep
{
  protected ArrayList a;
  protected String[] a;
  protected String c;
  public int j;
  
  private String a(String paramString)
  {
    Object localObject = paramString.toCharArray();
    int i1 = localObject.length;
    int k;
    int i2;
    int m;
    if (localObject[0] == '{')
    {
      k = 125;
      i2 = localObject[0];
      m = 0;
    }
    int i;
    for (int n = 0;; n = i)
    {
      if (m >= i1) {
        break label147;
      }
      if (localObject[m] == i2) {
        i = n + 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label135;
        }
        localObject = paramString.substring(0, m + 1);
        do
        {
          return localObject;
          if (localObject[0] == '[')
          {
            k = 93;
            break;
          }
          localObject = paramString;
        } while (paramString.indexOf(",") == -1);
        return paramString.substring(0, paramString.indexOf(","));
        i = n;
        if (localObject[m] == k) {
          i = n - 1;
        }
      }
      label135:
      m += 1;
    }
    label147:
    return "";
  }
  
  private String[] a(String paramString)
  {
    int m = paramString.length();
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder(50);
    for (String str1 = paramString; i < m; str1 = paramString.substring(i, m))
    {
      int k = i;
      String str2 = str1;
      if (str1.startsWith(","))
      {
        k = i + 1;
        str2 = paramString.substring(k, m);
      }
      str1 = a(str2);
      localStringBuilder.append(str1).append("-");
      i = k + str1.length();
    }
    return localStringBuilder.toString().split("-");
  }
  
  protected AsyncStep a()
  {
    Object localObject1 = null;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.j < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        int i = this.j;
        this.j = (i + 1);
        localObject1 = StepFactory.a((Automator)localObject1, arrayOfString[i]);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
      return localObject1;
    }
  }
  
  public void a()
  {
    this.b = 2147483647L;
    this.jdField_a_of_type_ArrayOfJavaLangString = a(this.c.substring(1, this.c.length() - 1));
    this.j = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_ArrayOfJavaLangString.length);
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 4) {
      super.a(paramInt);
    }
    if (((paramInt == 8) || (paramInt == 4)) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext()) {
          ((AsyncStep)localIterator.next()).a(paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.StepGroup
 * JD-Core Version:    0.7.0.1
 */
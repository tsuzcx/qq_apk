package com.tencent.mobileqq.conditionsearch.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import fqq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AddressData
{
  public static final String a = "AddressData";
  public static final String b = "#兼容列表";
  public static final String c = "[|]";
  public static final String d = "0";
  public static final String e = "不限";
  public static final String f = "1";
  public HashMap a = new HashMap(30);
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    default: 
      return 0;
    case 2: 
    case 3: 
      return 1;
    case 4: 
    case 5: 
      return 2;
    }
    return 3;
  }
  
  private int a(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    for (;;)
    {
      if (paramInt1 >= paramInt2) {}
      do
      {
        return -1;
        int i = paramInt1 + 1;
        if (!TextUtils.isEmpty(paramArrayOfString[paramInt1]))
        {
          int j = i + 1;
          paramInt1 = j;
          if (!TextUtils.isEmpty(paramArrayOfString[i])) {
            return j - 2;
          }
        }
        else
        {
          paramInt1 = i;
        }
      } while (paramInt1 >= paramInt2 - 1);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.runOnUiThread(new fqq(this, paramString));
  }
  
  private boolean a(String paramString, Map paramMap)
  {
    paramMap = new ArrayList(paramMap.values()).iterator();
    while (paramMap.hasNext()) {
      if (paramString.equals(((BaseAddress)paramMap.next()).jdField_a_of_type_JavaLangString)) {
        return false;
      }
    }
    return true;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("#兼容列表")) {
      return false;
    }
    Object localObject2 = paramString.split("[|]");
    if ((paramString.startsWith("#")) || (localObject2.length < 2)) {
      return true;
    }
    int i = localObject2.length;
    paramString = localObject2[0];
    Object localObject1 = localObject2[1];
    paramQQAppInterface = (BaseAddress)this.a.get(paramString);
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = new BaseAddress((String)localObject1, paramString, a(1));
      this.a.put("0", new BaseAddress("不限", "0", 0));
      this.a.put(paramString, paramQQAppInterface);
    }
    for (;;)
    {
      int k = a(2, i, (String[])localObject2);
      if (k == -1) {
        return true;
      }
      int j = k + 1;
      localObject1 = localObject2[k];
      k = j + 1;
      String str1 = localObject2[j];
      paramString = (BaseAddress)paramQQAppInterface.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1);
      if (paramString == null)
      {
        j = a(k - 1);
        paramString = new BaseAddress(str1, (String)localObject1, j);
        paramQQAppInterface.jdField_a_of_type_JavaUtilLinkedHashMap.put("0", new BaseAddress("不限", "0", j));
        paramQQAppInterface.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, paramString);
        paramQQAppInterface.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        k = a(k, i, (String[])localObject2);
        if (k == -1) {
          return true;
        }
        j = k + 1;
        str1 = localObject2[k];
        k = j + 1;
        String str2 = localObject2[j];
        localObject1 = (BaseAddress)paramString.jdField_a_of_type_JavaUtilLinkedHashMap.get(str1);
        if (localObject1 == null)
        {
          j = a(k - 1);
          localObject1 = new BaseAddress(str2, str1, j);
          paramString.jdField_a_of_type_JavaUtilLinkedHashMap.put("0", new BaseAddress("不限", "0", j));
          paramString.jdField_a_of_type_JavaUtilLinkedHashMap.put(str1, localObject1);
          paramQQAppInterface.b = true;
        }
        for (paramString = (String)localObject1;; paramString = (String)localObject1)
        {
          i = a(k, i, (String[])localObject2);
          if (i == -1) {
            return true;
          }
          j = i + 1;
          localObject1 = localObject2[i];
          localObject2 = localObject2[j];
          if ((BaseAddress)paramString.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1) == null)
          {
            i = a(j + 1 - 1);
            localObject2 = new BaseAddress((String)localObject2, (String)localObject1, i);
            paramString.jdField_a_of_type_JavaUtilLinkedHashMap.put("0", new BaseAddress("不限", "0", i));
            paramString.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, localObject2);
            paramQQAppInterface.c = true;
          }
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.data.AddressData
 * JD-Core Version:    0.7.0.1
 */
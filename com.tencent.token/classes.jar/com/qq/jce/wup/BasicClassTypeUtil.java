package com.qq.jce.wup;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BasicClassTypeUtil
{
  private static void addType(ArrayList<String> paramArrayList, String paramString)
  {
    int i = paramString.length();
    int j;
    do
    {
      j = i;
      if (paramString.charAt(i - 1) != '>') {
        break;
      }
      j = i - 1;
      i = j;
    } while (j != 0);
    paramArrayList.add(0, uni2JavaType(paramString.substring(0, j)));
  }
  
  public static Object createClassByName(String paramString)
  {
    Object localObject;
    if (paramString.equals("java.lang.Integer")) {
      localObject = Integer.valueOf(0);
    }
    do
    {
      return localObject;
      if (paramString.equals("java.lang.Boolean")) {
        return Boolean.valueOf(false);
      }
      if (paramString.equals("java.lang.Byte")) {
        return Byte.valueOf((byte)0);
      }
      if (paramString.equals("java.lang.Double")) {
        return Double.valueOf(0.0D);
      }
      if (paramString.equals("java.lang.Float")) {
        return Float.valueOf(0.0F);
      }
      if (paramString.equals("java.lang.Long")) {
        return Long.valueOf(0L);
      }
      if (paramString.equals("java.lang.Short")) {
        return Short.valueOf((short)0);
      }
      if (paramString.equals("java.lang.Character")) {
        throw new IllegalArgumentException("can not support java.lang.Character");
      }
      if (paramString.equals("java.lang.String")) {
        return "";
      }
      if (paramString.equals("java.util.List")) {
        return new ArrayList();
      }
      if (paramString.equals("java.util.Map")) {
        return new HashMap();
      }
      if (paramString.equals("Array")) {
        return "Array";
      }
      localObject = paramString;
    } while (paramString.equals("?"));
    try
    {
      paramString = Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new ObjectCreateException(paramString);
    }
  }
  
  public static Object createClassByUni(String paramString)
  {
    Iterator localIterator = getTypeList(paramString).iterator();
    Object localObject3 = null;
    paramString = null;
    Object localObject2 = null;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localObject1 = createClassByName((String)localIterator.next());
      if ((localObject1 instanceof String)) {
        if ("Array".equals((String)localObject1))
        {
          if (localObject2 != null) {
            break label310;
          }
          localObject3 = Array.newInstance(Byte.class, 0);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      if ("?".equals((String)localObject1))
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
      }
      else if (localObject2 == null)
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject2;
      }
      else
      {
        paramString = localObject2;
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        continue;
        if ((localObject1 instanceof List))
        {
          if ((localObject2 != null) && ((localObject2 instanceof Byte)))
          {
            localObject3 = Array.newInstance(Byte.class, 1);
            Array.set(localObject3, 0, localObject2);
            localObject1 = localObject2;
          }
          else
          {
            if (localObject2 != null) {
              ((List)localObject1).add(localObject2);
            }
            localObject2 = null;
            localObject3 = localObject1;
            localObject1 = localObject2;
          }
        }
        else
        {
          if ((localObject1 instanceof Map))
          {
            int i;
            if (localObject2 != null)
            {
              i = 1;
              label226:
              if (paramString == null) {
                break label270;
              }
            }
            label270:
            for (int j = 1;; j = 0)
            {
              if ((j & i) != 0) {
                ((Map)localObject1).put(localObject2, paramString);
              }
              paramString = null;
              localObject2 = null;
              localObject3 = localObject1;
              localObject1 = localObject2;
              break;
              i = 0;
              break label226;
            }
          }
          if (localObject2 == null)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            localObject1 = localObject2;
          }
          else
          {
            paramString = localObject2;
            localObject2 = localObject1;
            localObject3 = localObject1;
            localObject1 = localObject2;
            continue;
            return localObject3;
            label310:
            localObject3 = localObject1;
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public static String getClassTransName(String paramString)
  {
    String str;
    if (paramString.equals("int")) {
      str = "Integer";
    }
    do
    {
      return str;
      if (paramString.equals("boolean")) {
        return "Boolean";
      }
      if (paramString.equals("byte")) {
        return "Byte";
      }
      if (paramString.equals("double")) {
        return "Double";
      }
      if (paramString.equals("float")) {
        return "Float";
      }
      if (paramString.equals("long")) {
        return "Long";
      }
      if (paramString.equals("short")) {
        return "Short";
      }
      str = paramString;
    } while (!paramString.equals("char"));
    return "Character";
  }
  
  public static ArrayList<String> getTypeList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = paramString.indexOf("<");
    for (;;)
    {
      if (j < i)
      {
        addType(localArrayList, paramString.substring(j, i));
        j = i + 1;
        int m = paramString.indexOf("<", j);
        int k = paramString.indexOf(",", j);
        i = m;
        if (m == -1) {
          i = k;
        }
        if ((k != -1) && (k < i)) {
          i = k;
        }
      }
      else
      {
        addType(localArrayList, paramString.substring(j, paramString.length()));
        return localArrayList;
      }
    }
  }
  
  public static String getVariableInit(String paramString1, String paramString2)
  {
    if (paramString2.equals("int")) {
      return paramString2 + " " + paramString1 + "=0 ;\n";
    }
    if (paramString2.equals("boolean")) {
      return paramString2 + " " + paramString1 + "=false ;\n";
    }
    if (paramString2.equals("byte")) {
      return paramString2 + " " + paramString1 + " ;\n";
    }
    if (paramString2.equals("double")) {
      return paramString2 + " " + paramString1 + "=0 ;\n";
    }
    if (paramString2.equals("float")) {
      return paramString2 + " " + paramString1 + "=0 ;\n";
    }
    if (paramString2.equals("long")) {
      return paramString2 + " " + paramString1 + "=0 ;\n";
    }
    if (paramString2.equals("short")) {
      return paramString2 + " " + paramString1 + "=0 ;\n";
    }
    if (paramString2.equals("char")) {
      return paramString2 + " " + paramString1 + " ;\n";
    }
    return paramString2 + " " + paramString1 + " = null ;\n";
  }
  
  public static boolean isBasicType(String paramString)
  {
    if (paramString.equals("int")) {}
    while ((paramString.equals("boolean")) || (paramString.equals("byte")) || (paramString.equals("double")) || (paramString.equals("float")) || (paramString.equals("long")) || (paramString.equals("short")) || (paramString.equals("char")) || (paramString.equals("Integer")) || (paramString.equals("Boolean")) || (paramString.equals("Byte")) || (paramString.equals("Double")) || (paramString.equals("Float")) || (paramString.equals("Long")) || (paramString.equals("Short")) || (paramString.equals("Char"))) {
      return true;
    }
    return false;
  }
  
  public static String java2UniType(String paramString)
  {
    String str;
    if ((paramString.equals("java.lang.Integer")) || (paramString.equals("int"))) {
      str = "int32";
    }
    do
    {
      return str;
      if ((paramString.equals("java.lang.Boolean")) || (paramString.equals("boolean"))) {
        return "bool";
      }
      if ((paramString.equals("java.lang.Byte")) || (paramString.equals("byte"))) {
        return "char";
      }
      if ((paramString.equals("java.lang.Double")) || (paramString.equals("double"))) {
        return "double";
      }
      if ((paramString.equals("java.lang.Float")) || (paramString.equals("float"))) {
        return "float";
      }
      if ((paramString.equals("java.lang.Long")) || (paramString.equals("long"))) {
        return "int64";
      }
      if ((paramString.equals("java.lang.Short")) || (paramString.equals("short"))) {
        return "short";
      }
      if (paramString.equals("java.lang.Character")) {
        throw new IllegalArgumentException("can not support java.lang.Character");
      }
      if (paramString.equals("java.lang.String")) {
        return "string";
      }
      if (paramString.equals("java.util.List")) {
        return "list";
      }
      str = paramString;
    } while (!paramString.equals("java.util.Map"));
    return "map";
  }
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new ArrayList();
    paramArrayOfString.add("char");
    paramArrayOfString.add("list<char>");
    paramArrayOfString.add("list<list<char>>");
    paramArrayOfString.add("map<short,string>");
    paramArrayOfString.add("map<double,map<float,list<bool>>>");
    paramArrayOfString.add("map<int64,list<Test.UserInfo>>");
    paramArrayOfString.add("map<short,Test.FriendInfo>");
    paramArrayOfString = paramArrayOfString.iterator();
    while (paramArrayOfString.hasNext())
    {
      ArrayList localArrayList = getTypeList((String)paramArrayOfString.next());
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        System.out.println(str);
      }
      Collections.reverse(localArrayList);
      System.out.println("-------------finished " + transTypeList(localArrayList));
    }
  }
  
  public static String transTypeList(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayList.size())
    {
      paramArrayList.set(i, java2UniType((String)paramArrayList.get(i)));
      i += 1;
    }
    Collections.reverse(paramArrayList);
    i = 0;
    if (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      if (str.equals("list"))
      {
        paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
        paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.equals("map"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1) + ",");
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
        else if (str.equals("Array"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
      }
    }
    Collections.reverse(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next());
    }
    return localStringBuffer.toString();
  }
  
  public static String uni2JavaType(String paramString)
  {
    String str;
    if (paramString.equals("int32")) {
      str = "java.lang.Integer";
    }
    do
    {
      return str;
      if (paramString.equals("bool")) {
        return "java.lang.Boolean";
      }
      if (paramString.equals("char")) {
        return "java.lang.Byte";
      }
      if (paramString.equals("double")) {
        return "java.lang.Double";
      }
      if (paramString.equals("float")) {
        return "java.lang.Float";
      }
      if (paramString.equals("int64")) {
        return "java.lang.Long";
      }
      if (paramString.equals("short")) {
        return "java.lang.Short";
      }
      if (paramString.equals("string")) {
        return "java.lang.String";
      }
      if (paramString.equals("list")) {
        return "java.util.List";
      }
      str = paramString;
    } while (!paramString.equals("map"));
    return "java.util.Map";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.qq.jce.wup.BasicClassTypeUtil
 * JD-Core Version:    0.7.0.1
 */
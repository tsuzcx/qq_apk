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
    if (paramString.equals("java.lang.Integer")) {
      return Integer.valueOf(0);
    }
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
    if (!paramString.equals("java.lang.Character"))
    {
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
      if (paramString.equals("?")) {
        return paramString;
      }
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
    throw new IllegalArgumentException("can not support java.lang.Character");
  }
  
  public static Object createClassByUni(String paramString)
  {
    Iterator localIterator = getTypeList(paramString).iterator();
    Object localObject = null;
    paramString = localObject;
    String str1 = paramString;
    while (localIterator.hasNext())
    {
      localObject = createClassByName((String)localIterator.next());
      boolean bool = localObject instanceof String;
      int j = 0;
      if (bool)
      {
        String str2 = (String)localObject;
        if ("Array".equals(str2))
        {
          if (paramString != null) {
            continue;
          }
          localObject = Array.newInstance(Byte.class, 0);
          continue;
        }
        if ("?".equals(str2)) {
          continue;
        }
        if (paramString != null) {
          break label226;
        }
      }
      else
      {
        if ((localObject instanceof List))
        {
          if ((paramString != null) && ((paramString instanceof Byte)))
          {
            localObject = Array.newInstance(Byte.class, 1);
            Array.set(localObject, 0, paramString);
            continue;
          }
          if (paramString != null) {
            ((List)localObject).add(paramString);
          }
          paramString = null;
          continue;
        }
        if ((localObject instanceof Map))
        {
          int i;
          if (paramString != null) {
            i = 1;
          } else {
            i = 0;
          }
          if (str1 != null) {
            j = 1;
          }
          if ((i & j) != 0) {
            ((Map)localObject).put(paramString, str1);
          }
          paramString = null;
          str1 = paramString;
          continue;
        }
        if (paramString == null) {
          break label229;
        }
      }
      label226:
      str1 = paramString;
      label229:
      paramString = localObject;
    }
    return localObject;
  }
  
  public static String getClassTransName(String paramString)
  {
    if (paramString.equals("int")) {
      return "Integer";
    }
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
    String str = paramString;
    if (paramString.equals("char")) {
      str = "Character";
    }
    return str;
  }
  
  public static ArrayList<String> getTypeList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramString.indexOf("<");
    int m = 0;
    while (m < j)
    {
      addType(localArrayList, paramString.substring(m, j));
      int n = j + 1;
      j = paramString.indexOf("<", n);
      int k = paramString.indexOf(",", n);
      int i = j;
      if (j == -1) {
        i = k;
      }
      j = i;
      m = n;
      if (k != -1)
      {
        j = i;
        m = n;
        if (k < i)
        {
          j = k;
          m = n;
        }
      }
    }
    addType(localArrayList, paramString.substring(m, paramString.length()));
    return localArrayList;
  }
  
  public static String getVariableInit(String paramString1, String paramString2)
  {
    if (paramString2.equals("int"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=0 ;\n");
      return localStringBuilder.toString();
    }
    if (paramString2.equals("boolean"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=false ;\n");
      return localStringBuilder.toString();
    }
    if (paramString2.equals("byte"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" ;\n");
      return localStringBuilder.toString();
    }
    if (paramString2.equals("double"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=0 ;\n");
      return localStringBuilder.toString();
    }
    if (paramString2.equals("float"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=0 ;\n");
      return localStringBuilder.toString();
    }
    if (paramString2.equals("long"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=0 ;\n");
      return localStringBuilder.toString();
    }
    if (paramString2.equals("short"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("=0 ;\n");
      return localStringBuilder.toString();
    }
    if (paramString2.equals("char"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" ;\n");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" = null ;\n");
    return localStringBuilder.toString();
  }
  
  public static boolean isBasicType(String paramString)
  {
    if (paramString.equals("int")) {
      return true;
    }
    if (paramString.equals("boolean")) {
      return true;
    }
    if (paramString.equals("byte")) {
      return true;
    }
    if (paramString.equals("double")) {
      return true;
    }
    if (paramString.equals("float")) {
      return true;
    }
    if (paramString.equals("long")) {
      return true;
    }
    if (paramString.equals("short")) {
      return true;
    }
    if (paramString.equals("char")) {
      return true;
    }
    if (paramString.equals("Integer")) {
      return true;
    }
    if (paramString.equals("Boolean")) {
      return true;
    }
    if (paramString.equals("Byte")) {
      return true;
    }
    if (paramString.equals("Double")) {
      return true;
    }
    if (paramString.equals("Float")) {
      return true;
    }
    if (paramString.equals("Long")) {
      return true;
    }
    if (paramString.equals("Short")) {
      return true;
    }
    return paramString.equals("Char");
  }
  
  public static String java2UniType(String paramString)
  {
    if ((!paramString.equals("java.lang.Integer")) && (!paramString.equals("int")))
    {
      if ((!paramString.equals("java.lang.Boolean")) && (!paramString.equals("boolean")))
      {
        if ((!paramString.equals("java.lang.Byte")) && (!paramString.equals("byte")))
        {
          if ((!paramString.equals("java.lang.Double")) && (!paramString.equals("double")))
          {
            if ((!paramString.equals("java.lang.Float")) && (!paramString.equals("float")))
            {
              if ((!paramString.equals("java.lang.Long")) && (!paramString.equals("long")))
              {
                if ((!paramString.equals("java.lang.Short")) && (!paramString.equals("short")))
                {
                  if (!paramString.equals("java.lang.Character"))
                  {
                    if (paramString.equals("java.lang.String")) {
                      return "string";
                    }
                    if (paramString.equals("java.util.List")) {
                      return "list";
                    }
                    if (paramString.equals("java.util.Map")) {
                      return "map";
                    }
                    return paramString;
                  }
                  throw new IllegalArgumentException("can not support java.lang.Character");
                }
                return "short";
              }
              return "int64";
            }
            return "float";
          }
          return "double";
        }
        return "char";
      }
      return "bool";
    }
    return "int32";
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
      Object localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        System.out.println((String)localObject2);
      }
      Collections.reverse(localArrayList);
      localObject1 = System.out;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("-------------finished ");
      ((StringBuilder)localObject2).append(transTypeList(localArrayList));
      ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
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
    while (i < paramArrayList.size())
    {
      Object localObject = (String)paramArrayList.get(i);
      int j;
      if (((String)localObject).equals("list"))
      {
        j = i - 1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      else if (((String)localObject).equals("map"))
      {
        j = i - 1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        ((StringBuilder)localObject).append(",");
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      else if (((String)localObject).equals("Array"))
      {
        j = i - 1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      i += 1;
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
    if (paramString.equals("int32")) {
      return "java.lang.Integer";
    }
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
    if (paramString.equals("map")) {
      return "java.util.Map";
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.qq.jce.wup.BasicClassTypeUtil
 * JD-Core Version:    0.7.0.1
 */
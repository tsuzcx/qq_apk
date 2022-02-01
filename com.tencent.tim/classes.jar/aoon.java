import com.tencent.qphone.base.util.QLog;

public class aoon
{
  @Deprecated
  public static String a(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('\026');
    localStringBuffer.append(paramString);
    localStringBuffer.append('|');
    localStringBuffer.append(paramLong);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt);
    localStringBuffer.append('|');
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localStringBuffer.append(paramInt);
      return localStringBuffer.toString();
    }
  }
  
  @Deprecated
  public static String a(String paramString1, long paramLong, int paramInt, boolean paramBoolean, String paramString2)
  {
    paramString1 = a(paramString1, paramLong, paramInt, paramBoolean);
    paramString1 = paramString1 + "|";
    if ((paramString2 == null) || (paramString2.length() <= 0)) {
      return paramString1 + "null";
    }
    return paramString1 + paramString2;
  }
  
  public static String a(String paramString1, long paramLong, int paramInt, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = a(paramString1, paramLong, paramInt, paramBoolean);
    paramString1 = paramString1 + "|";
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      paramString1 = paramString1 + "null";
      paramString1 = paramString1 + "|";
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        break label191;
      }
    }
    label191:
    for (paramString1 = paramString1 + "null";; paramString1 = paramString1 + paramString3)
    {
      paramString1 = paramString1 + "|";
      if ((paramString4 != null) && (paramString4.length() > 0)) {
        break label214;
      }
      return paramString1 + "null";
      paramString1 = paramString1 + paramString2;
      break;
    }
    label214:
    return paramString1 + paramString4;
  }
  
  public static String a(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, int paramInt3, String paramString9)
  {
    paramString1 = a(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4);
    paramString1 = paramString1 + "|";
    if ((paramString5 == null) || (paramString5.length() <= 0))
    {
      paramString1 = paramString1 + "null";
      paramString1 = paramString1 + "|";
      if ((paramString6 != null) && (paramString6.length() > 0)) {
        break label382;
      }
      paramString1 = paramString1 + "null";
      label121:
      paramString1 = paramString1 + "|";
      if ((paramString7 != null) && (paramString7.length() > 0)) {
        break label405;
      }
      paramString1 = paramString1 + "null";
      label174:
      paramString1 = paramString1 + "|";
      if ((paramString8 != null) && (paramString8.length() > 0)) {
        break label428;
      }
    }
    label405:
    label428:
    for (paramString1 = paramString1 + "null";; paramString1 = paramString1 + paramString8)
    {
      paramString1 = paramString1 + "|";
      paramString1 = paramString1 + paramInt2;
      paramString1 = paramString1 + "|";
      paramString2 = paramString1 + paramInt3;
      paramString1 = paramString2;
      if (paramString9 != null)
      {
        paramString1 = paramString2 + "|";
        paramString1 = paramString1 + paramString9;
      }
      return paramString1;
      paramString1 = paramString1 + paramString5;
      break;
      label382:
      paramString1 = paramString1 + paramString6;
      break label121;
      paramString1 = paramString1 + paramString7;
      break label174;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\026');
    paramString1 = t(paramString1);
    int i = 0;
    while ((i < paramString1.length) && (i < 5))
    {
      localStringBuilder.append(paramString1[i]);
      localStringBuilder.append('|');
      i += 1;
    }
    if (paramString1.length == 4)
    {
      localStringBuilder.append("");
      localStringBuilder.append('|');
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(paramString2);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString3);
      localStringBuilder.append('|');
      localStringBuilder.append(paramLong);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt);
    }
  }
  
  public static String b(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, int paramInt3)
  {
    return a(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt2, paramInt3, null);
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    paramString1 = a(paramString1, 0L, 1, true, paramString2);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('|');
    localStringBuffer.append(paramString2);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString3);
    localStringBuffer.append('|');
    localStringBuffer.append(paramLong);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt);
    return paramString1 + localStringBuffer.toString();
  }
  
  public static String oy(String paramString)
  {
    paramString = t(paramString);
    if ((paramString == null) || (paramString.length < 6)) {}
    do
    {
      return null;
      paramString = paramString[5];
      if (QLog.isColorLevel()) {
        QLog.d("TransfileUtile", 2, "getPicMD5ByMsgContent:" + paramString);
      }
      if (paramString.length() == 32) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TransfileUtile", 2, "getPicMD5ByMsgContent: error md5: length is not 32.");
    return null;
    return paramString;
  }
  
  public static String[] t(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.split("\026");
    } while ((paramString == null) || (paramString.length < 2));
    return paramString[1].split("\\|");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoon
 * JD-Core Version:    0.7.0.1
 */
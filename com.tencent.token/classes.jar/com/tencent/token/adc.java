package com.tencent.token;

import android.content.Context;
import java.io.File;

public final class adc
{
  public static final agi<adc> a = new a();
  public Object b = new Object();
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getAbsolutePath());
    paramContext = File.separator;
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("8");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(paramContext);
    localStringBuilder.append("2");
    return localStringBuilder.toString();
  }
  
  public final class a
    extends agi<adc>
  {
    public final Object a()
    {
      return new adc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adc
 * JD-Core Version:    0.7.0.1
 */
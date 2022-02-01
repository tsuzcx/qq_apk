package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ObjectUtils;

public class ToStringBuilder
  implements Builder<String>
{
  private static volatile ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
  private final StringBuffer buffer;
  private final Object object;
  private final ToStringStyle style;
  
  public ToStringBuilder(Object paramObject)
  {
    this(paramObject, null, null);
  }
  
  public ToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle)
  {
    this(paramObject, paramToStringStyle, null);
  }
  
  public ToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer)
  {
    ToStringStyle localToStringStyle = paramToStringStyle;
    if (paramToStringStyle == null) {
      localToStringStyle = getDefaultStyle();
    }
    paramToStringStyle = paramStringBuffer;
    if (paramStringBuffer == null) {
      paramToStringStyle = new StringBuffer(512);
    }
    this.buffer = paramToStringStyle;
    this.style = localToStringStyle;
    this.object = paramObject;
    localToStringStyle.appendStart(paramToStringStyle, paramObject);
  }
  
  public static ToStringStyle getDefaultStyle()
  {
    return defaultStyle;
  }
  
  public static String reflectionToString(Object paramObject)
  {
    return ReflectionToStringBuilder.toString(paramObject);
  }
  
  public static String reflectionToString(Object paramObject, ToStringStyle paramToStringStyle)
  {
    return ReflectionToStringBuilder.toString(paramObject, paramToStringStyle);
  }
  
  public static String reflectionToString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean)
  {
    return ReflectionToStringBuilder.toString(paramObject, paramToStringStyle, paramBoolean, false, null);
  }
  
  public static <T> String reflectionToString(T paramT, ToStringStyle paramToStringStyle, boolean paramBoolean, Class<? super T> paramClass)
  {
    return ReflectionToStringBuilder.toString(paramT, paramToStringStyle, paramBoolean, false, paramClass);
  }
  
  public static void setDefaultStyle(ToStringStyle paramToStringStyle)
  {
    if (paramToStringStyle == null) {
      throw new IllegalArgumentException("The style must not be null");
    }
    defaultStyle = paramToStringStyle;
  }
  
  public ToStringBuilder append(byte paramByte)
  {
    this.style.append(this.buffer, null, paramByte);
    return this;
  }
  
  public ToStringBuilder append(char paramChar)
  {
    this.style.append(this.buffer, null, paramChar);
    return this;
  }
  
  public ToStringBuilder append(double paramDouble)
  {
    this.style.append(this.buffer, null, paramDouble);
    return this;
  }
  
  public ToStringBuilder append(float paramFloat)
  {
    this.style.append(this.buffer, null, paramFloat);
    return this;
  }
  
  public ToStringBuilder append(int paramInt)
  {
    this.style.append(this.buffer, null, paramInt);
    return this;
  }
  
  public ToStringBuilder append(long paramLong)
  {
    this.style.append(this.buffer, null, paramLong);
    return this;
  }
  
  public ToStringBuilder append(Object paramObject)
  {
    this.style.append(this.buffer, null, paramObject, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, byte paramByte)
  {
    this.style.append(this.buffer, paramString, paramByte);
    return this;
  }
  
  public ToStringBuilder append(String paramString, char paramChar)
  {
    this.style.append(this.buffer, paramString, paramChar);
    return this;
  }
  
  public ToStringBuilder append(String paramString, double paramDouble)
  {
    this.style.append(this.buffer, paramString, paramDouble);
    return this;
  }
  
  public ToStringBuilder append(String paramString, float paramFloat)
  {
    this.style.append(this.buffer, paramString, paramFloat);
    return this;
  }
  
  public ToStringBuilder append(String paramString, int paramInt)
  {
    this.style.append(this.buffer, paramString, paramInt);
    return this;
  }
  
  public ToStringBuilder append(String paramString, long paramLong)
  {
    this.style.append(this.buffer, paramString, paramLong);
    return this;
  }
  
  public ToStringBuilder append(String paramString, Object paramObject)
  {
    this.style.append(this.buffer, paramString, paramObject, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, Object paramObject, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramObject, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ToStringBuilder append(String paramString, short paramShort)
  {
    this.style.append(this.buffer, paramString, paramShort);
    return this;
  }
  
  public ToStringBuilder append(String paramString, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramBoolean);
    return this;
  }
  
  public ToStringBuilder append(String paramString, byte[] paramArrayOfByte)
  {
    this.style.append(this.buffer, paramString, paramArrayOfByte, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramArrayOfByte, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ToStringBuilder append(String paramString, char[] paramArrayOfChar)
  {
    this.style.append(this.buffer, paramString, paramArrayOfChar, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, char[] paramArrayOfChar, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramArrayOfChar, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ToStringBuilder append(String paramString, double[] paramArrayOfDouble)
  {
    this.style.append(this.buffer, paramString, paramArrayOfDouble, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, double[] paramArrayOfDouble, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramArrayOfDouble, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ToStringBuilder append(String paramString, float[] paramArrayOfFloat)
  {
    this.style.append(this.buffer, paramString, paramArrayOfFloat, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramArrayOfFloat, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ToStringBuilder append(String paramString, int[] paramArrayOfInt)
  {
    this.style.append(this.buffer, paramString, paramArrayOfInt, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramArrayOfInt, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ToStringBuilder append(String paramString, long[] paramArrayOfLong)
  {
    this.style.append(this.buffer, paramString, paramArrayOfLong, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, long[] paramArrayOfLong, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramArrayOfLong, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ToStringBuilder append(String paramString, Object[] paramArrayOfObject)
  {
    this.style.append(this.buffer, paramString, paramArrayOfObject, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramArrayOfObject, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ToStringBuilder append(String paramString, short[] paramArrayOfShort)
  {
    this.style.append(this.buffer, paramString, paramArrayOfShort, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, short[] paramArrayOfShort, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramArrayOfShort, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ToStringBuilder append(String paramString, boolean[] paramArrayOfBoolean)
  {
    this.style.append(this.buffer, paramString, paramArrayOfBoolean, null);
    return this;
  }
  
  public ToStringBuilder append(String paramString, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    this.style.append(this.buffer, paramString, paramArrayOfBoolean, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ToStringBuilder append(short paramShort)
  {
    this.style.append(this.buffer, null, paramShort);
    return this;
  }
  
  public ToStringBuilder append(boolean paramBoolean)
  {
    this.style.append(this.buffer, null, paramBoolean);
    return this;
  }
  
  public ToStringBuilder append(byte[] paramArrayOfByte)
  {
    this.style.append(this.buffer, null, paramArrayOfByte, null);
    return this;
  }
  
  public ToStringBuilder append(char[] paramArrayOfChar)
  {
    this.style.append(this.buffer, null, paramArrayOfChar, null);
    return this;
  }
  
  public ToStringBuilder append(double[] paramArrayOfDouble)
  {
    this.style.append(this.buffer, null, paramArrayOfDouble, null);
    return this;
  }
  
  public ToStringBuilder append(float[] paramArrayOfFloat)
  {
    this.style.append(this.buffer, null, paramArrayOfFloat, null);
    return this;
  }
  
  public ToStringBuilder append(int[] paramArrayOfInt)
  {
    this.style.append(this.buffer, null, paramArrayOfInt, null);
    return this;
  }
  
  public ToStringBuilder append(long[] paramArrayOfLong)
  {
    this.style.append(this.buffer, null, paramArrayOfLong, null);
    return this;
  }
  
  public ToStringBuilder append(Object[] paramArrayOfObject)
  {
    this.style.append(this.buffer, null, paramArrayOfObject, null);
    return this;
  }
  
  public ToStringBuilder append(short[] paramArrayOfShort)
  {
    this.style.append(this.buffer, null, paramArrayOfShort, null);
    return this;
  }
  
  public ToStringBuilder append(boolean[] paramArrayOfBoolean)
  {
    this.style.append(this.buffer, null, paramArrayOfBoolean, null);
    return this;
  }
  
  public ToStringBuilder appendAsObjectToString(Object paramObject)
  {
    ObjectUtils.identityToString(getStringBuffer(), paramObject);
    return this;
  }
  
  public ToStringBuilder appendSuper(String paramString)
  {
    if (paramString != null) {
      this.style.appendSuper(this.buffer, paramString);
    }
    return this;
  }
  
  public ToStringBuilder appendToString(String paramString)
  {
    if (paramString != null) {
      this.style.appendToString(this.buffer, paramString);
    }
    return this;
  }
  
  public String build()
  {
    return toString();
  }
  
  public Object getObject()
  {
    return this.object;
  }
  
  public StringBuffer getStringBuffer()
  {
    return this.buffer;
  }
  
  public ToStringStyle getStyle()
  {
    return this.style;
  }
  
  public String toString()
  {
    if (getObject() == null) {
      getStringBuffer().append(getStyle().getNullText());
    }
    for (;;)
    {
      return getStringBuffer().toString();
      this.style.appendEnd(getStringBuffer(), getObject());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.ToStringBuilder
 * JD-Core Version:    0.7.0.1
 */
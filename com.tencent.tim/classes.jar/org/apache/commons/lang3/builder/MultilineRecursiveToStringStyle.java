package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.SystemUtils;

class MultilineRecursiveToStringStyle
  extends RecursiveToStringStyle
{
  private static final long serialVersionUID = 1L;
  private int indent = 2;
  private int spaces = 2;
  
  public MultilineRecursiveToStringStyle()
  {
    resetIndent();
  }
  
  private void resetIndent()
  {
    setArrayStart("{" + SystemUtils.LINE_SEPARATOR + spacer(this.spaces));
    setArraySeparator("," + SystemUtils.LINE_SEPARATOR + spacer(this.spaces));
    setArrayEnd(SystemUtils.LINE_SEPARATOR + spacer(this.spaces - this.indent) + "}");
    setContentStart("[" + SystemUtils.LINE_SEPARATOR + spacer(this.spaces));
    setFieldSeparator("," + SystemUtils.LINE_SEPARATOR + spacer(this.spaces));
    setContentEnd(SystemUtils.LINE_SEPARATOR + spacer(this.spaces - this.indent) + "]");
  }
  
  private StringBuilder spacer(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append(" ");
      i += 1;
    }
    return localStringBuilder;
  }
  
  public void appendDetail(StringBuffer paramStringBuffer, String paramString, Object paramObject)
  {
    if ((!ClassUtils.isPrimitiveWrapper(paramObject.getClass())) && (!String.class.equals(paramObject.getClass())) && (accept(paramObject.getClass())))
    {
      this.spaces += this.indent;
      resetIndent();
      paramStringBuffer.append(ReflectionToStringBuilder.toString(paramObject, this));
      this.spaces -= this.indent;
      resetIndent();
      return;
    }
    super.appendDetail(paramStringBuffer, paramString, paramObject);
  }
  
  protected void appendDetail(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfByte)
  {
    this.spaces += this.indent;
    resetIndent();
    super.appendDetail(paramStringBuffer, paramString, paramArrayOfByte);
    this.spaces -= this.indent;
    resetIndent();
  }
  
  protected void appendDetail(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfChar)
  {
    this.spaces += this.indent;
    resetIndent();
    super.appendDetail(paramStringBuffer, paramString, paramArrayOfChar);
    this.spaces -= this.indent;
    resetIndent();
  }
  
  protected void appendDetail(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfDouble)
  {
    this.spaces += this.indent;
    resetIndent();
    super.appendDetail(paramStringBuffer, paramString, paramArrayOfDouble);
    this.spaces -= this.indent;
    resetIndent();
  }
  
  protected void appendDetail(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOfFloat)
  {
    this.spaces += this.indent;
    resetIndent();
    super.appendDetail(paramStringBuffer, paramString, paramArrayOfFloat);
    this.spaces -= this.indent;
    resetIndent();
  }
  
  protected void appendDetail(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfInt)
  {
    this.spaces += this.indent;
    resetIndent();
    super.appendDetail(paramStringBuffer, paramString, paramArrayOfInt);
    this.spaces -= this.indent;
    resetIndent();
  }
  
  protected void appendDetail(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOfLong)
  {
    this.spaces += this.indent;
    resetIndent();
    super.appendDetail(paramStringBuffer, paramString, paramArrayOfLong);
    this.spaces -= this.indent;
    resetIndent();
  }
  
  protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject)
  {
    this.spaces += this.indent;
    resetIndent();
    super.appendDetail(paramStringBuffer, paramString, paramArrayOfObject);
    this.spaces -= this.indent;
    resetIndent();
  }
  
  protected void appendDetail(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfShort)
  {
    this.spaces += this.indent;
    resetIndent();
    super.appendDetail(paramStringBuffer, paramString, paramArrayOfShort);
    this.spaces -= this.indent;
    resetIndent();
  }
  
  protected void appendDetail(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfBoolean)
  {
    this.spaces += this.indent;
    resetIndent();
    super.appendDetail(paramStringBuffer, paramString, paramArrayOfBoolean);
    this.spaces -= this.indent;
    resetIndent();
  }
  
  protected void reflectionAppendArrayDetail(StringBuffer paramStringBuffer, String paramString, Object paramObject)
  {
    this.spaces += this.indent;
    resetIndent();
    super.appendDetail(paramStringBuffer, paramString, paramObject);
    this.spaces -= this.indent;
    resetIndent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.pb;

import java.io.IOException;

public final class PBStringField
  extends PBPrimitiveField<String>
{
  public static final PBStringField __repeatHelper__ = new PBStringField("", false);
  private String value = "";
  
  public PBStringField(String paramString, boolean paramBoolean)
  {
    set(paramString, paramBoolean);
  }
  
  public void clear(Object paramObject)
  {
    if ((paramObject instanceof String)) {}
    for (this.value = ((String)paramObject);; this.value = "")
    {
      setHasFlag(false);
      return;
    }
  }
  
  public int computeSize(int paramInt)
  {
    if (has()) {
      return CodedOutputStreamMicro.computeStringSize(paramInt, this.value);
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, String paramString)
  {
    return CodedOutputStreamMicro.computeStringSize(paramInt, paramString);
  }
  
  protected void copyFrom(PBField<String> paramPBField)
  {
    paramPBField = (PBStringField)paramPBField;
    set(paramPBField.value, paramPBField.has());
  }
  
  public String get()
  {
    return this.value;
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    this.value = paramCodedInputStreamMicro.readString();
    setHasFlag(true);
  }
  
  protected String readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return paramCodedInputStreamMicro.readString();
  }
  
  public void set(String paramString)
  {
    set(paramString, true);
  }
  
  public void set(String paramString, boolean paramBoolean)
  {
    this.value = paramString;
    setHasFlag(paramBoolean);
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
    throws IOException
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeString(paramInt, this.value);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, String paramString)
    throws IOException
  {
    paramCodedOutputStreamMicro.writeString(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBStringField
 * JD-Core Version:    0.7.0.1
 */
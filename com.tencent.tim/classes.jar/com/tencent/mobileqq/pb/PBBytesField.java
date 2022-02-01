package com.tencent.mobileqq.pb;

import java.io.IOException;

public final class PBBytesField
  extends PBPrimitiveField<ByteStringMicro>
{
  public static final PBBytesField __repeatHelper__ = new PBBytesField(ByteStringMicro.EMPTY, false);
  private ByteStringMicro value = ByteStringMicro.EMPTY;
  
  public PBBytesField(ByteStringMicro paramByteStringMicro, boolean paramBoolean)
  {
    set(paramByteStringMicro, paramBoolean);
  }
  
  public void clear(Object paramObject)
  {
    if ((paramObject instanceof ByteStringMicro)) {}
    for (this.value = ((ByteStringMicro)paramObject);; this.value = ByteStringMicro.EMPTY)
    {
      setHasFlag(false);
      return;
    }
  }
  
  public int computeSize(int paramInt)
  {
    if (has()) {
      return CodedOutputStreamMicro.computeBytesSize(paramInt, this.value);
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    return CodedOutputStreamMicro.computeBytesSize(paramInt, paramByteStringMicro);
  }
  
  protected void copyFrom(PBField<ByteStringMicro> paramPBField)
  {
    paramPBField = (PBBytesField)paramPBField;
    set(paramPBField.value, paramPBField.has());
  }
  
  public ByteStringMicro get()
  {
    return this.value;
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    this.value = paramCodedInputStreamMicro.readBytes();
    setHasFlag(true);
  }
  
  protected ByteStringMicro readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return paramCodedInputStreamMicro.readBytes();
  }
  
  public void set(ByteStringMicro paramByteStringMicro)
  {
    set(paramByteStringMicro, true);
  }
  
  public void set(ByteStringMicro paramByteStringMicro, boolean paramBoolean)
  {
    this.value = paramByteStringMicro;
    setHasFlag(paramBoolean);
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
    throws IOException
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeBytes(paramInt, this.value);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, ByteStringMicro paramByteStringMicro)
    throws IOException
  {
    paramCodedOutputStreamMicro.writeBytes(paramInt, paramByteStringMicro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBBytesField
 * JD-Core Version:    0.7.0.1
 */
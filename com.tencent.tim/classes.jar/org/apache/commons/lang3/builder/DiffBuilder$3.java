package org.apache.commons.lang3.builder;

class DiffBuilder$3
  extends Diff<Byte>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$3(DiffBuilder paramDiffBuilder, String paramString, byte paramByte1, byte paramByte2)
  {
    super(paramString);
  }
  
  public Byte getLeft()
  {
    return Byte.valueOf(this.val$lhs);
  }
  
  public Byte getRight()
  {
    return Byte.valueOf(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.3
 * JD-Core Version:    0.7.0.1
 */
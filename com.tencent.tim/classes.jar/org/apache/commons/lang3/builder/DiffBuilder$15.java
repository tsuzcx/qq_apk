package org.apache.commons.lang3.builder;

class DiffBuilder$15
  extends Diff<Short>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$15(DiffBuilder paramDiffBuilder, String paramString, short paramShort1, short paramShort2)
  {
    super(paramString);
  }
  
  public Short getLeft()
  {
    return Short.valueOf(this.val$lhs);
  }
  
  public Short getRight()
  {
    return Short.valueOf(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.15
 * JD-Core Version:    0.7.0.1
 */
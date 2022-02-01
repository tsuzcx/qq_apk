package org.apache.commons.lang3.builder;

class DiffBuilder$13
  extends Diff<Long>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$13(DiffBuilder paramDiffBuilder, String paramString, long paramLong1, long paramLong2)
  {
    super(paramString);
  }
  
  public Long getLeft()
  {
    return Long.valueOf(this.val$lhs);
  }
  
  public Long getRight()
  {
    return Long.valueOf(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.13
 * JD-Core Version:    0.7.0.1
 */
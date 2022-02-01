package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$14
  extends Diff<Long[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$14(DiffBuilder paramDiffBuilder, String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    super(paramString);
  }
  
  public Long[] getLeft()
  {
    return ArrayUtils.toObject(this.val$lhs);
  }
  
  public Long[] getRight()
  {
    return ArrayUtils.toObject(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.14
 * JD-Core Version:    0.7.0.1
 */
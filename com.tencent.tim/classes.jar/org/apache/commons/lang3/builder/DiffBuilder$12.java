package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$12
  extends Diff<Integer[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$12(DiffBuilder paramDiffBuilder, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    super(paramString);
  }
  
  public Integer[] getLeft()
  {
    return ArrayUtils.toObject(this.val$lhs);
  }
  
  public Integer[] getRight()
  {
    return ArrayUtils.toObject(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.12
 * JD-Core Version:    0.7.0.1
 */
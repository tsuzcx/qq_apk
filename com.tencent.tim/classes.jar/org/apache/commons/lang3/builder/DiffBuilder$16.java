package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$16
  extends Diff<Short[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$16(DiffBuilder paramDiffBuilder, String paramString, short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    super(paramString);
  }
  
  public Short[] getLeft()
  {
    return ArrayUtils.toObject(this.val$lhs);
  }
  
  public Short[] getRight()
  {
    return ArrayUtils.toObject(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.16
 * JD-Core Version:    0.7.0.1
 */
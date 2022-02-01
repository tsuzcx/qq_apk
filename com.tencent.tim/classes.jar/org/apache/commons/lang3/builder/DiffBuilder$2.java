package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$2
  extends Diff<Boolean[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$2(DiffBuilder paramDiffBuilder, String paramString, boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    super(paramString);
  }
  
  public Boolean[] getLeft()
  {
    return ArrayUtils.toObject(this.val$lhs);
  }
  
  public Boolean[] getRight()
  {
    return ArrayUtils.toObject(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.2
 * JD-Core Version:    0.7.0.1
 */
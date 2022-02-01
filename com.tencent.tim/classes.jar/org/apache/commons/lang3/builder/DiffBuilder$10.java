package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$10
  extends Diff<Float[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$10(DiffBuilder paramDiffBuilder, String paramString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    super(paramString);
  }
  
  public Float[] getLeft()
  {
    return ArrayUtils.toObject(this.val$lhs);
  }
  
  public Float[] getRight()
  {
    return ArrayUtils.toObject(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.10
 * JD-Core Version:    0.7.0.1
 */
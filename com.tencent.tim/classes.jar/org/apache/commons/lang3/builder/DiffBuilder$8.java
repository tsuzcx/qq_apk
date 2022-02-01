package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$8
  extends Diff<Double[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$8(DiffBuilder paramDiffBuilder, String paramString, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    super(paramString);
  }
  
  public Double[] getLeft()
  {
    return ArrayUtils.toObject(this.val$lhs);
  }
  
  public Double[] getRight()
  {
    return ArrayUtils.toObject(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.8
 * JD-Core Version:    0.7.0.1
 */
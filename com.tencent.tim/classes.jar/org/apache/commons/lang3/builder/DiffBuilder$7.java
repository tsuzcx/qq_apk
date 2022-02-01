package org.apache.commons.lang3.builder;

class DiffBuilder$7
  extends Diff<Double>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$7(DiffBuilder paramDiffBuilder, String paramString, double paramDouble1, double paramDouble2)
  {
    super(paramString);
  }
  
  public Double getLeft()
  {
    return Double.valueOf(this.val$lhs);
  }
  
  public Double getRight()
  {
    return Double.valueOf(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.7
 * JD-Core Version:    0.7.0.1
 */
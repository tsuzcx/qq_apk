package org.apache.commons.lang3.builder;

class DiffBuilder$9
  extends Diff<Float>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$9(DiffBuilder paramDiffBuilder, String paramString, float paramFloat1, float paramFloat2)
  {
    super(paramString);
  }
  
  public Float getLeft()
  {
    return Float.valueOf(this.val$lhs);
  }
  
  public Float getRight()
  {
    return Float.valueOf(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.9
 * JD-Core Version:    0.7.0.1
 */
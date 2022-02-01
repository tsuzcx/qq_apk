package org.apache.commons.lang3.builder;

class DiffBuilder$1
  extends Diff<Boolean>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$1(DiffBuilder paramDiffBuilder, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramString);
  }
  
  public Boolean getLeft()
  {
    return Boolean.valueOf(this.val$lhs);
  }
  
  public Boolean getRight()
  {
    return Boolean.valueOf(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.1
 * JD-Core Version:    0.7.0.1
 */
package org.apache.commons.lang3.builder;

class DiffBuilder$5
  extends Diff<Character>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$5(DiffBuilder paramDiffBuilder, String paramString, char paramChar1, char paramChar2)
  {
    super(paramString);
  }
  
  public Character getLeft()
  {
    return Character.valueOf(this.val$lhs);
  }
  
  public Character getRight()
  {
    return Character.valueOf(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.5
 * JD-Core Version:    0.7.0.1
 */
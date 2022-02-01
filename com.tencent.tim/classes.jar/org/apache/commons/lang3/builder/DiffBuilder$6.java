package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$6
  extends Diff<Character[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$6(DiffBuilder paramDiffBuilder, String paramString, char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    super(paramString);
  }
  
  public Character[] getLeft()
  {
    return ArrayUtils.toObject(this.val$lhs);
  }
  
  public Character[] getRight()
  {
    return ArrayUtils.toObject(this.val$rhs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.builder.DiffBuilder.6
 * JD-Core Version:    0.7.0.1
 */
package org.apache.commons.lang3.tuple;

public final class ImmutableTriple<L, M, R>
  extends Triple<L, M, R>
{
  private static final long serialVersionUID = 1L;
  public final L left;
  public final M middle;
  public final R right;
  
  public ImmutableTriple(L paramL, M paramM, R paramR)
  {
    this.left = paramL;
    this.middle = paramM;
    this.right = paramR;
  }
  
  public static <L, M, R> ImmutableTriple<L, M, R> of(L paramL, M paramM, R paramR)
  {
    return new ImmutableTriple(paramL, paramM, paramR);
  }
  
  public L getLeft()
  {
    return this.left;
  }
  
  public M getMiddle()
  {
    return this.middle;
  }
  
  public R getRight()
  {
    return this.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.tuple.ImmutableTriple
 * JD-Core Version:    0.7.0.1
 */
package org.apache.commons.lang3.tuple;

public class MutableTriple<L, M, R>
  extends Triple<L, M, R>
{
  private static final long serialVersionUID = 1L;
  public L left;
  public M middle;
  public R right;
  
  public MutableTriple() {}
  
  public MutableTriple(L paramL, M paramM, R paramR)
  {
    this.left = paramL;
    this.middle = paramM;
    this.right = paramR;
  }
  
  public static <L, M, R> MutableTriple<L, M, R> of(L paramL, M paramM, R paramR)
  {
    return new MutableTriple(paramL, paramM, paramR);
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
  
  public void setLeft(L paramL)
  {
    this.left = paramL;
  }
  
  public void setMiddle(M paramM)
  {
    this.middle = paramM;
  }
  
  public void setRight(R paramR)
  {
    this.right = paramR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.tuple.MutableTriple
 * JD-Core Version:    0.7.0.1
 */
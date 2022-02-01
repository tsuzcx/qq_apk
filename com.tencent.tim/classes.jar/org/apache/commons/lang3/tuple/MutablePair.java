package org.apache.commons.lang3.tuple;

public class MutablePair<L, R>
  extends Pair<L, R>
{
  private static final long serialVersionUID = 4954918890077093841L;
  public L left;
  public R right;
  
  public MutablePair() {}
  
  public MutablePair(L paramL, R paramR)
  {
    this.left = paramL;
    this.right = paramR;
  }
  
  public static <L, R> MutablePair<L, R> of(L paramL, R paramR)
  {
    return new MutablePair(paramL, paramR);
  }
  
  public L getLeft()
  {
    return this.left;
  }
  
  public R getRight()
  {
    return this.right;
  }
  
  public void setLeft(L paramL)
  {
    this.left = paramL;
  }
  
  public void setRight(R paramR)
  {
    this.right = paramR;
  }
  
  public R setValue(R paramR)
  {
    Object localObject = getRight();
    setRight(paramR);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.tuple.MutablePair
 * JD-Core Version:    0.7.0.1
 */
public class oas
  implements obb
{
  final obb a;
  Object aU = null;
  int bdC = 0;
  int bdD = -1;
  int bdE = -1;
  
  public oas(obb paramobb)
  {
    this.a = paramobb;
  }
  
  public void bcV()
  {
    if (this.bdC == 0) {
      return;
    }
    switch (this.bdC)
    {
    }
    for (;;)
    {
      this.aU = null;
      this.bdC = 0;
      return;
      this.a.du(this.bdD, this.bdE);
      continue;
      this.a.dv(this.bdD, this.bdE);
      continue;
      this.a.c(this.bdD, this.bdE, this.aU);
    }
  }
  
  public void c(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.bdC == 3) && (paramInt1 <= this.bdD + this.bdE) && (paramInt1 + paramInt2 >= this.bdD) && (this.aU == paramObject))
    {
      int i = this.bdD;
      int j = this.bdE;
      this.bdD = Math.min(paramInt1, this.bdD);
      this.bdE = (Math.max(i + j, paramInt1 + paramInt2) - this.bdD);
      return;
    }
    bcV();
    this.bdD = paramInt1;
    this.bdE = paramInt2;
    this.aU = paramObject;
    this.bdC = 3;
  }
  
  public void du(int paramInt1, int paramInt2)
  {
    if ((this.bdC == 1) && (paramInt1 >= this.bdD) && (paramInt1 <= this.bdD + this.bdE))
    {
      this.bdE += paramInt2;
      this.bdD = Math.min(paramInt1, this.bdD);
      return;
    }
    bcV();
    this.bdD = paramInt1;
    this.bdE = paramInt2;
    this.bdC = 1;
  }
  
  public void dv(int paramInt1, int paramInt2)
  {
    if ((this.bdC == 2) && (this.bdD >= paramInt1) && (this.bdD <= paramInt1 + paramInt2))
    {
      this.bdE += paramInt2;
      this.bdD = paramInt1;
      return;
    }
    bcV();
    this.bdD = paramInt1;
    this.bdE = paramInt2;
    this.bdC = 2;
  }
  
  public void dw(int paramInt1, int paramInt2)
  {
    bcV();
    this.a.dw(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oas
 * JD-Core Version:    0.7.0.1
 */
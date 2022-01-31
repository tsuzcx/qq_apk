package com.tencent.token;

class ez
  extends ey
{
  int d = 1;
  
  ez() {}
  
  ez(int paramInt)
  {
    super(paramInt);
  }
  
  void a(ez paramez)
  {
    if (this.d == paramez.d)
    {
      c(paramez);
      return;
    }
    this.d *= d(paramez);
  }
  
  void b(ez paramez)
  {
    if (this.d == paramez.d)
    {
      this.d *= d(paramez);
      return;
    }
    c(paramez);
  }
  
  void f(ey paramey)
  {
    if (this.d == 1)
    {
      c(paramey);
      return;
    }
    this.d *= d(paramey);
  }
  
  public String toString()
  {
    return new ex(this, this.d).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ez
 * JD-Core Version:    0.7.0.1
 */
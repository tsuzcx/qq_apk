public class sgd
{
  private sgl a;
  private volatile int mState = 0;
  
  public boolean Mg()
  {
    return this.mState == 1;
  }
  
  public void b(sgl paramsgl)
  {
    this.a = paramsgl;
    setState(this.mState);
  }
  
  public void bys()
  {
    setState(-1);
  }
  
  public boolean isErrorState()
  {
    return this.mState == -1;
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
    if (this.a != null) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.a.bjj();
      return;
    case 1: 
      this.a.bjh();
      return;
    case 2: 
      this.a.bjg();
      return;
    }
    this.a.bji();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgd
 * JD-Core Version:    0.7.0.1
 */
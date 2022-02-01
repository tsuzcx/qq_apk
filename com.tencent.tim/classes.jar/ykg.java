public class ykg
{
  private ykg.a a;
  private int mState = 1;
  
  public ykg() {}
  
  public ykg(ykg.a parama)
  {
    this.a = parama;
  }
  
  public void ciO()
  {
    if (this.mState == 1) {
      if (this.a != null)
      {
        this.a.Ec(1);
        this.mState = 2;
      }
    }
    while ((this.mState != 2) || (this.a == null)) {
      return;
    }
    this.a.Ec(2);
  }
  
  public void ciP()
  {
    if ((this.mState == 2) && (this.a != null))
    {
      this.a.ciR();
      this.mState = 3;
    }
  }
  
  public void ciQ()
  {
    if ((this.mState == 3) && (this.a != null))
    {
      this.a.ciS();
      this.mState = 1;
    }
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public static abstract interface a
  {
    public abstract void Ec(int paramInt);
    
    public abstract void ciR();
    
    public abstract void ciS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykg
 * JD-Core Version:    0.7.0.1
 */
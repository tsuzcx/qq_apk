public abstract class pxe
{
  protected pxd a;
  protected int mRetryCount;
  
  public void a(pxd parampxd)
  {
    this.a = parampxd;
  }
  
  public void bnw()
  {
    if (this.a != null) {
      this.a.a(this);
    }
  }
  
  public void notifyError()
  {
    if (this.a != null) {
      this.a.b(this);
    }
  }
  
  public boolean retry()
  {
    if (this.mRetryCount < 1)
    {
      this.mRetryCount += 1;
      ram.w("Q.qqstory.net:BatchNetHandler", String.format("retry request , retry count = %d", new Object[] { Integer.valueOf(this.mRetryCount) }));
      sendRequest();
      return true;
    }
    return false;
  }
  
  public abstract void sendRequest();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxe
 * JD-Core Version:    0.7.0.1
 */
package btmsdkobf;

class ij
  extends Thread
{
  ij(ds paramds, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    eh.e("TcpNetwork", "[tcp_control]RcvThread start...");
    ds.a(this.a);
    eh.e("TcpNetwork", "[tcp_control]RcvThread end!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ij
 * JD-Core Version:    0.7.0.1
 */
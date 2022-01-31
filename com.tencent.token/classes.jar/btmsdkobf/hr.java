package btmsdkobf;

class hr
  implements Runnable
{
  hr(de paramde) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      if (de.d(this.a))
      {
        eh.e("SharkTcpControler", "[tcp_control][shark_conf][shark_alarm] keep after send timeout, tryCloseConnectionAsyn()");
        this.a.ci();
        de.a(this.a, false);
      }
      eh.e("SharkTcpControler", "[tcp_control][shark_conf][shark_alarm] keep after send timeout(by alarm), delay 5s by handler");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hr
 * JD-Core Version:    0.7.0.1
 */
package btmsdkobf;

final class fe
  implements Runnable
{
  public void run()
  {
    if (System.currentTimeMillis() - bn.gi < 600000L) {
      return;
    }
    bn.gi = System.currentTimeMillis();
    be.w();
    bn.N();
    ec.cS().putLong("rs_rt", System.currentTimeMillis());
    bc.setAutoConnectionSwitch(bc.n(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fe
 * JD-Core Version:    0.7.0.1
 */
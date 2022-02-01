public class aevp
{
  private static aeho a;
  private static aeho b;
  public String bCh = "";
  public String bCi = "";
  public String bCj = "";
  public String bCk = "";
  public String bCl = "";
  public String bCm = "";
  public String bCn = "";
  private aeho c;
  
  public void Hw(boolean paramBoolean)
  {
    aeho[] arrayOfaeho = new aeho[2];
    if ((this.bCk != null) && (!this.bCl.equals("")))
    {
      if (this.c == null) {
        this.c = new aeho(this.bCk, 1, 1);
      }
      arrayOfaeho[0] = this.c;
    }
    if (paramBoolean)
    {
      arrayOfaeho[1] = b;
      return;
    }
    arrayOfaeho[1] = a;
  }
  
  public void cXp()
  {
    if (this.bCl.equals("LOCAL")) {
      if (!this.bCm.equals("1")) {}
    }
    label24:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label24;
              break label24;
              break label24;
              do
              {
                return;
              } while ((this.bCm.equals("2")) || (this.bCm.equals("4")) || (this.bCm.equals("5")) || (this.bCm.equals("6")) || (!this.bCm.equals("7")));
              return;
            } while ((this.bCl.equals("WAP")) || (this.bCl.equals("TMTWAP")) || (this.bCl.equals("WAPI")) || (this.bCl.equals("TMTWAPI")) || (this.bCl.equals("VOICECALL")));
            if (!this.bCl.equals("QQMSG")) {
              break;
            }
          } while (!this.bCj.equals("AUTO"));
          return;
        } while ((this.bCl.equals("AUTOQQMSG")) || (this.bCl.equals("HTTP")) || (this.bCl.equals("AUTOSMS")));
        if (!this.bCl.equals("USERSMS")) {
          break;
        }
      } while (!this.bCj.equals("AUTO"));
      return;
    } while (!this.bCl.equals("RESET"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevp
 * JD-Core Version:    0.7.0.1
 */
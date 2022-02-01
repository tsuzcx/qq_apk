public class aomn
{
  public long aqb;
  public String clT;
  public String clU;
  public String clV;
  public int dPP;
  public int dPQ;
  
  public void RZ(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 12))
    {
      paramString = paramString.split("\\|");
      if ((paramString != null) && (paramString.length < 13)) {}
    }
    try
    {
      this.aqb = Long.parseLong(paramString[12]);
      if (paramString.length >= 14) {
        this.clT = paramString[13];
      }
      if (paramString.length < 15) {}
    }
    catch (Exception localException3)
    {
      try
      {
        this.dPP = Integer.parseInt(paramString[14]);
        if (paramString.length < 16) {}
      }
      catch (Exception localException3)
      {
        try
        {
          this.clU = paramString[15];
          if (paramString.length < 17) {}
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              this.clV = paramString[16];
              if (paramString.length >= 18) {}
              try
              {
                this.dPQ = Integer.parseInt(paramString[17]);
                return;
              }
              catch (Exception paramString)
              {
                this.dPQ = -1;
              }
              localException1 = localException1;
              this.aqb = -1L;
              continue;
              localException2 = localException2;
              this.dPP = -1;
            }
            localException3 = localException3;
            this.clU = null;
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              this.clV = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aomn
 * JD-Core Version:    0.7.0.1
 */
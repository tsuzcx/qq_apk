public class agay
  extends agba
{
  public String bGg;
  public String distance;
  public String troopName;
  public String troopOwnerNick;
  
  public agay(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(2, paramString1);
    this.troopName = paramString2;
    this.bGg = paramString3;
    this.troopOwnerNick = paramString4;
    this.distance = paramString5;
    if (this.bGg == null) {
      this.bGg = "";
    }
    if (this.bGh == null) {
      this.bGh = "";
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof agay))
    {
      paramObject = (agay)paramObject;
      bool1 = bool2;
      if (this.bGg.equals(paramObject.bGg))
      {
        bool1 = bool2;
        if (this.bGh.equals(paramObject.bGh)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    return this.bGh + "_" + this.bGg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agay
 * JD-Core Version:    0.7.0.1
 */
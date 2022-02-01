public class avcu
{
  private String Vb = "";
  private String bizId = "1001";
  private String cJi = "";
  private String cJj = "";
  private String cJk = "";
  private String cJl = "";
  private String cJm = "";
  private String cJn = "";
  private String cJo = "";
  private String cJp = "";
  private String cJq = "";
  private String cJr = "";
  private String duration = "";
  private String guid = "";
  private String[] iJ = { "", "", "", "", "", "", "", "", "", "" };
  private String pageId = "";
  
  public String FA()
  {
    return this.cJj;
  }
  
  public String FB()
  {
    return this.Vb;
  }
  
  public String FC()
  {
    return this.cJk;
  }
  
  public String FD()
  {
    return this.cJl;
  }
  
  public String FE()
  {
    return this.cJm;
  }
  
  public String FF()
  {
    return this.cJn;
  }
  
  public String FG()
  {
    return this.cJo;
  }
  
  public String FH()
  {
    return this.cJp;
  }
  
  public String FI()
  {
    return this.cJq;
  }
  
  public String FJ()
  {
    return this.cJr;
  }
  
  public String FK()
  {
    return this.bizId;
  }
  
  public String Fy()
  {
    return this.pageId;
  }
  
  public String Fz()
  {
    return this.cJi;
  }
  
  public String[] W()
  {
    return this.iJ;
  }
  
  public avcu a(String paramString)
  {
    this.pageId = paramString;
    return this;
  }
  
  public avcu a(String... paramVarArgs)
  {
    int i = 0;
    while ((i < this.iJ.length) && (i < paramVarArgs.length))
    {
      this.iJ[i] = paramVarArgs[i];
      i += 1;
    }
    return this;
  }
  
  public avcu b(String paramString)
  {
    this.cJi = paramString;
    return this;
  }
  
  public avcu c(String paramString)
  {
    this.cJj = paramString;
    return this;
  }
  
  public avcu d(String paramString)
  {
    this.Vb = paramString;
    return this;
  }
  
  public avcu e(String paramString)
  {
    this.cJk = paramString;
    return this;
  }
  
  public String getDuration()
  {
    return this.duration;
  }
  
  public String getGuid()
  {
    return this.guid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcu
 * JD-Core Version:    0.7.0.1
 */
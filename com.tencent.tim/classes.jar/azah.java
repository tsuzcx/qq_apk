public class azah
{
  public static azah.a a(String paramString)
  {
    return new azah.a(paramString);
  }
  
  public static class a
  {
    private String cdG;
    private String[] gB;
    
    a(String paramString)
    {
      this.cdG = paramString;
    }
    
    public int Jm()
    {
      if ((this.cdG == null) || ("".equals(this.cdG))) {
        return -3;
      }
      this.gB = this.cdG.split("\\_");
      if (this.gB == null) {
        return -1;
      }
      if (this.gB.length < 2) {
        return -2;
      }
      return 0;
    }
    
    public String getVersion()
    {
      return this.gB[1].trim();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azah
 * JD-Core Version:    0.7.0.1
 */
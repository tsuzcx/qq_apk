package wf7;

public class hp
  extends hn
{
  public String tC;
  public String tD;
  public int tE = 0;
  public boolean tF = false;
  public int tG = 0;
  
  public hp(String paramString, boolean paramBoolean)
  {
    super(2);
    this.tC = paramString;
    this.tF = paramBoolean;
  }
  
  public hp(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(2);
    this.tC = paramString;
    this.tF = paramBoolean;
    this.tG = paramInt1;
    this.tE = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.hp
 * JD-Core Version:    0.7.0.1
 */
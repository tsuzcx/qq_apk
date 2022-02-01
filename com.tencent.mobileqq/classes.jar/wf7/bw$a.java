package wf7;

public enum bw$a
{
  private static final String[] gD = { "", "UNKNOWN", "WRONG_PWD", "NOT_WRONG_PWD" };
  int dD;
  
  private bw$a(int paramInt)
  {
    this.dD = paramInt;
  }
  
  public String toString()
  {
    return gD[this.dD];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.bw.a
 * JD-Core Version:    0.7.0.1
 */
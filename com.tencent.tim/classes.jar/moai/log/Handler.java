package moai.log;

public abstract class Handler
{
  protected final Formatter formater;
  private int level;
  
  public Handler(int paramInt, String paramString)
  {
    this.level = paramInt;
    this.formater = new Formatter(paramString);
    check();
  }
  
  private void check()
  {
    if ((this.level != 2) && (this.level != 3) && (this.level != 4) && (this.level != 5) && (this.level != 6) && (this.level != 7)) {
      throw new IllegalArgumentException("level " + this.level + " invalid");
    }
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public abstract int publish(int paramInt, String paramString1, String paramString2);
  
  public abstract int publish(int paramInt, String paramString1, String paramString2, Throwable paramThrowable);
  
  public void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.Handler
 * JD-Core Version:    0.7.0.1
 */
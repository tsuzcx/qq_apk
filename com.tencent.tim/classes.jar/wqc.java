public abstract interface wqc
{
  public abstract void Cx(int paramInt);
  
  public abstract void caF();
  
  public abstract void caG();
  
  public abstract void setSttNetFinish();
  
  public abstract void xC(String paramString);
  
  public static class a
  {
    public String aTS;
    public boolean isFinish;
    
    public a(String paramString, boolean paramBoolean)
    {
      this.aTS = paramString;
      this.isFinish = paramBoolean;
    }
    
    public String toString()
    {
      return "ResultBean{rtext='" + this.aTS + '\'' + ", isFinish=" + this.isFinish + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqc
 * JD-Core Version:    0.7.0.1
 */
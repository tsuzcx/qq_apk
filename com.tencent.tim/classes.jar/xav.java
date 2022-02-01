import android.text.TextUtils;

abstract class xav
{
  protected xee a;
  protected String aUH;
  protected String aUI;
  protected int bSV;
  protected int bSW;
  
  public void a(xee paramxee)
  {
    this.a = paramxee;
  }
  
  public abstract void abort();
  
  public String getData()
  {
    return this.aUI;
  }
  
  public int getRetCode()
  {
    return this.bSW;
  }
  
  public boolean open(String paramString)
  {
    abort();
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.aUH = paramString;
    this.bSW = -1;
    return true;
  }
  
  public abstract boolean send(String paramString);
  
  public void setTimeout(int paramInt)
  {
    this.bSV = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xav
 * JD-Core Version:    0.7.0.1
 */
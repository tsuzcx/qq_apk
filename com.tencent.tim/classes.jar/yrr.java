import android.support.annotation.NonNull;

public class yrr
{
  public int aCj = 23;
  public boolean bot = false;
  public int caN = 0;
  
  public boolean Ui()
  {
    return this.bot;
  }
  
  public void clb()
  {
    this.bot = true;
  }
  
  public void clc()
  {
    this.aCj = 23;
    this.caN = 0;
  }
  
  public void reset()
  {
    this.aCj = 23;
    this.caN = 0;
    this.bot = false;
  }
  
  @NonNull
  public String toString()
  {
    return "TabLayoutStatus{tabId=" + this.aCj + ", tabPosition=" + this.caN + ", display='" + this.bot + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrr
 * JD-Core Version:    0.7.0.1
 */
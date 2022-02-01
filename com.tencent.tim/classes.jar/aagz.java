import android.view.View;

public class aagz
{
  public boolean bvz;
  public int cgG;
  public int state;
  public View view;
  
  public aagz(int paramInt1, int paramInt2)
  {
    this.cgG = paramInt1;
    this.state = paramInt2;
  }
  
  public static boolean hw(int paramInt)
  {
    return paramInt >= 2;
  }
  
  public boolean Wm()
  {
    return this.state >= 2;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(20);
    localStringBuffer.append("[").append(this.cgG).append(",").append(this.state).append(",").append(this.bvz).append(",").append(this.view).append("]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagz
 * JD-Core Version:    0.7.0.1
 */
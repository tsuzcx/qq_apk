import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;

public final class thd
  extends tgm
{
  public GdtDwellTimeStatisticsAfterClick a;
  public int height = -2147483648;
  public int style = -2147483648;
  public int width = -2147483648;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.style != -2147483648) && (this.c.isInitialized()) && (this.width > 0) && (this.height > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thd
 * JD-Core Version:    0.7.0.1
 */
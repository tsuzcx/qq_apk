import android.graphics.Point;
import java.util.ArrayList;

public class atap
{
  public atap.a a;
  public boolean dgX;
  
  public static final class a
  {
    ArrayList<Point> DS;
    
    public int Ob()
    {
      return this.DS.size();
    }
    
    public int get(int paramInt1, int paramInt2)
    {
      if ((paramInt1 > this.DS.size() - 1) && (paramInt1 < 0)) {
        return 0;
      }
      if (paramInt2 == 0) {
        return ((Point)this.DS.get(paramInt1)).x;
      }
      return ((Point)this.DS.get(paramInt1)).y;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atap
 * JD-Core Version:    0.7.0.1
 */
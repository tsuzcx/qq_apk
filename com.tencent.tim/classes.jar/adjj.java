import android.graphics.Rect;

public class adjj
{
  public Rect rect = new Rect();
  public float score;
  public int type;
  
  public String toString()
  {
    return String.format("AIRect[%d,%.2f,%s]", new Object[] { Integer.valueOf(this.type), Float.valueOf(this.score), this.rect });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjj
 * JD-Core Version:    0.7.0.1
 */
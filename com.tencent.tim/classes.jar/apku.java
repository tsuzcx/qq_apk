import java.util.ArrayList;
import java.util.List;

public abstract class apku
  extends apkn
{
  public List<Integer> HX = new ArrayList();
  public int mUploadStatus = 0;
  
  public apku()
  {
    this.HX.add(Integer.valueOf(0));
    this.HX.add(Integer.valueOf(3));
    this.HX.add(Integer.valueOf(1));
    this.HX.add(Integer.valueOf(2));
  }
  
  public int sz()
  {
    return this.mUploadStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apku
 * JD-Core Version:    0.7.0.1
 */
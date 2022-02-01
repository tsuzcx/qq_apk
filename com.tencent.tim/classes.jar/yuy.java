import java.util.List;

public class yuy
{
  public Runnable eP;
  public Runnable eQ;
  public int mask;
  public List<String> requestPermissions;
  public int result;
  
  public void AV(boolean paramBoolean)
  {
    if (UC()) {
      if (this.eP != null) {
        this.eP.run();
      }
    }
    while (this.eQ == null) {
      return;
    }
    this.eQ.run();
  }
  
  public boolean UC()
  {
    return (this.result & this.mask) == this.mask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yuy
 * JD-Core Version:    0.7.0.1
 */
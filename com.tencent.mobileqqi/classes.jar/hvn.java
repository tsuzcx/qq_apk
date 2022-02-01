import com.tencent.widget.AdapterView;

public class hvn
  implements Runnable
{
  private hvn(AdapterView paramAdapterView) {}
  
  public void run()
  {
    if (this.a.p)
    {
      if (this.a.a() != null) {
        this.a.post(this);
      }
      return;
    }
    AdapterView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hvn
 * JD-Core Version:    0.7.0.1
 */
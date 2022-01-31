import com.tencent.widget.AdapterView;

public class fhv
  implements Runnable
{
  private fhv(AdapterView paramAdapterView) {}
  
  public void run()
  {
    if (this.a.q)
    {
      if (this.a.a() != null) {
        this.a.post(this);
      }
      return;
    }
    AdapterView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhv
 * JD-Core Version:    0.7.0.1
 */
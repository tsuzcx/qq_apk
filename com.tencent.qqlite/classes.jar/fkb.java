import com.tencent.widget.AdapterView;

public class fkb
  implements Runnable
{
  private fkb(AdapterView paramAdapterView) {}
  
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
 * Qualified Name:     fkb
 * JD-Core Version:    0.7.0.1
 */
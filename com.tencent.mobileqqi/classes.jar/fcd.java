import com.tencent.mobileqq.adapter.BuddyListAdapter;

public class fcd
  implements Runnable
{
  public fcd(BuddyListAdapter paramBuddyListAdapter) {}
  
  public void run()
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fcd
 * JD-Core Version:    0.7.0.1
 */
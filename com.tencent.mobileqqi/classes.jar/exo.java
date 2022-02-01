import com.tencent.mobileqq.adapter.BuddyListAdapter;

public class exo
  implements Runnable
{
  public exo(BuddyListAdapter paramBuddyListAdapter) {}
  
  public void run()
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     exo
 * JD-Core Version:    0.7.0.1
 */
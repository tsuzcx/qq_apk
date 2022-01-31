import com.tencent.mobileqq.adapter.BuddyListAdapter;

public class cpw
  implements Runnable
{
  public cpw(BuddyListAdapter paramBuddyListAdapter) {}
  
  public void run()
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cpw
 * JD-Core Version:    0.7.0.1
 */
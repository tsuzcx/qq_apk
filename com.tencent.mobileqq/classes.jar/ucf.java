import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;

public class ucf
  implements Runnable
{
  public ucf(TroopMemberListActivity.ListAdapter paramListAdapter) {}
  
  public void run()
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ucf
 * JD-Core Version:    0.7.0.1
 */
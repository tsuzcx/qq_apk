import com.dataline.mpfile.LiteMpFileMainActivity;
import com.dataline.mpfile.MpfileMenuListAdapter;

public class cr
  implements Runnable
{
  public cr(LiteMpFileMainActivity paramLiteMpFileMainActivity) {}
  
  public void run()
  {
    LiteMpFileMainActivity.a(this.a).a(LiteMpFileMainActivity.a(this.a));
    LiteMpFileMainActivity.a(this.a).notifyDataSetChanged();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cr
 * JD-Core Version:    0.7.0.1
 */
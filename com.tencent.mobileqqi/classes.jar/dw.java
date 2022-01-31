import com.dataline.mpfile.LiteMpFileMainActivity;
import com.dataline.mpfile.MpfileMenuListAdapter;

public class dw
  implements Runnable
{
  public dw(LiteMpFileMainActivity paramLiteMpFileMainActivity) {}
  
  public void run()
  {
    LiteMpFileMainActivity.a(this.a).a(LiteMpFileMainActivity.a(this.a));
    LiteMpFileMainActivity.a(this.a).notifyDataSetChanged();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     dw
 * JD-Core Version:    0.7.0.1
 */
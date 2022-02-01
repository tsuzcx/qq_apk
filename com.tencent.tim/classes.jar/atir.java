import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.FileShowListActivity;

public class atir
  implements ativ.a
{
  public atir(FileShowListActivity paramFileShowListActivity) {}
  
  public void aSa()
  {
    if (!FileShowListActivity.a(this.a).isComplete())
    {
      QLog.e("IphoneTitleBarActivity", 1, "onLoadMore.");
      if (FileShowListActivity.a(this.a) != null) {
        FileShowListActivity.a(this.a).lz(true);
      }
      if (!FileShowListActivity.a(this.a))
      {
        FileShowListActivity.a(this.a, true);
        FileShowListActivity.a(this.a).aaL(FileShowListActivity.a(this.a));
      }
    }
  }
  
  public void bLR()
  {
    QLog.e("IphoneTitleBarActivity", 1, "onPullToRefresh.");
    FileShowListActivity.a(this.a).aaK(FileShowListActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atir
 * JD-Core Version:    0.7.0.1
 */
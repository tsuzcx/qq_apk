import android.app.Activity;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class qub
{
  public static int boc = 1;
  public static int bod = 2;
  public qye a;
  public int boe;
  public int mSource;
  public String mUid;
  private List<rsd> op = new ArrayList();
  public Activity y;
  
  public qub(Activity paramActivity, int paramInt1, String paramString, int paramInt2, qye paramqye)
  {
    this.y = paramActivity;
    this.mSource = paramInt1;
    this.mUid = paramString;
    this.boe = paramInt2;
    this.a = paramqye;
    if (paramInt2 == boc)
    {
      bqH();
      return;
    }
    if (paramInt2 == bod)
    {
      bqI();
      return;
    }
    throw new IllegalStateException("setup profile list error because unknown list type.");
  }
  
  private void bqH()
  {
    this.op.add(new quj(this.y, this.mSource, this.mUid));
    this.op.add(new quh(this.y.getApplicationContext(), this.y, 12, this.a, false));
    this.op.add(new qug(this.y, "FeedSegment", this.y.getResources().getString(2131701934), 2130847477, 2130847478));
  }
  
  private void bqI()
  {
    this.op.add(new quj(this.y, this.mSource, this.mUid));
    this.op.add(new qul(this.y, this.mSource, this.mUid));
    this.op.add(new quk(this.y, this.mSource, this.mUid));
  }
  
  public List<rsd> getSegmentList()
  {
    return this.op;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qub
 * JD-Core Version:    0.7.0.1
 */
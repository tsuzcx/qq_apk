import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.a;

public abstract class riq<PACKAGE extends rik>
  extends BaseAdapter
{
  protected FacePanel.a b;
  public int brY;
  protected PACKAGE c;
  protected Context context;
  
  public riq(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void a(FacePanel.a parama)
  {
    this.b = parama;
  }
  
  public void d(PACKAGE paramPACKAGE)
  {
    this.c = paramPACKAGE;
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    int i = this.c.getFaceCount();
    int j = this.c.tu();
    if (j < 1) {
      throw new IllegalArgumentException("per item count < 1 :" + j);
    }
    if (i % j == 0) {
      return i / j;
    }
    return i / j + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     riq
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.av.ui.QavMenuBaseView;

public class iyb
  implements jbz.a
{
  private boolean Wc;
  private String mTag;
  
  public iyb(String paramString)
  {
    this.mTag = paramString;
  }
  
  public void a(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if ((!this.Wc) && (!TextUtils.isEmpty(this.mTag)))
    {
      this.Wc = true;
      jjc.au(this.mTag, 0);
    }
    if ((paramRelativeLayout instanceof QavMenuBaseView)) {
      ((QavMenuBaseView)paramRelativeLayout).K(paramLong, paramBoolean);
    }
  }
  
  public void b(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.Wc = false;
    if ((paramRelativeLayout instanceof QavMenuBaseView)) {
      ((QavMenuBaseView)paramRelativeLayout).L(paramLong, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyb
 * JD-Core Version:    0.7.0.1
 */
import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.tencent.widget.XListView;

public class br
  implements acxt.a
{
  public br(LiteActivity paramLiteActivity) {}
  
  public void D(int paramInt)
  {
    if (this.this$0.isFinishing()) {}
    while ((Build.VERSION.SDK_INT >= 17) && (this.this$0.isDestroyed())) {
      return;
    }
    if (paramInt > 0)
    {
      this.this$0.a.cj();
      this.this$0.a.notifyDataSetChanged();
      this.this$0.mListView.setSelectionFromBottom(paramInt, 0);
    }
    this.this$0.mListView.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     br
 * JD-Core Version:    0.7.0.1
 */
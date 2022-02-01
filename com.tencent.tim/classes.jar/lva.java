import android.content.Context;
import android.view.View;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;

public class lva
{
  private PTSLiteItemViewManager a;
  private final boolean showMark = true;
  
  public lva(Context paramContext)
  {
    this.a = new PTSLiteItemViewManager(paramContext);
  }
  
  public View a(View paramView, PTSItemData paramPTSItemData)
  {
    Object localObject = paramView;
    if (this.a != null) {
      localObject = this.a.getView(paramView, paramPTSItemData);
    }
    return localObject;
  }
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  public void setLiteEventListener(IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    if (this.a != null) {
      this.a.setLiteEventListener(paramIPTSLiteEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lva
 * JD-Core Version:    0.7.0.1
 */
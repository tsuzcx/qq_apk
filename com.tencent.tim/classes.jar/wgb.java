import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.VisitorsActivity.a;
import com.tencent.widget.XListView;

public class wgb
  implements amfh
{
  public wgb(VisitorsActivity paramVisitorsActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int i = 0;
    if ((paramBitmap != null) && (paramInt2 == 200))
    {
      paramBitmap = this.this$0.e;
      if (paramBitmap == null) {
        break label108;
      }
      paramInt2 = paramBitmap.getChildCount();
    }
    for (;;)
    {
      if (i < paramInt2)
      {
        Object localObject = paramBitmap.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof VisitorsActivity.a)))
        {
          localObject = (VisitorsActivity.a)localObject;
          if ((((VisitorsActivity.a)localObject).actionId == paramInt1) && (((VisitorsActivity.a)localObject).Hl != null)) {
            VisitorsActivity.a(this.this$0, ((VisitorsActivity.a)localObject).Hl, paramInt1);
          }
        }
        i += 1;
      }
      else
      {
        return;
        label108:
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgb
 * JD-Core Version:    0.7.0.1
 */
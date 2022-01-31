import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.dataline.activities.LiteVideoActivity;
import com.dataline.util.file.ImageInfo;
import com.dataline.util.file.SendInfo;
import java.io.File;
import java.util.ArrayList;

public class ci
  implements AdapterView.OnItemClickListener
{
  public ci(LiteVideoActivity paramLiteVideoActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    paramAdapterView = paramAdapterView.getAdapter();
    if (paramAdapterView == null)
    {
      paramAdapterView = null;
      if ((paramAdapterView != null) && ((paramAdapterView instanceof ImageInfo)))
      {
        paramAdapterView = (ImageInfo)paramAdapterView;
        paramView = (ck)paramView.getTag();
        if (LiteVideoActivity.a(this.a, paramAdapterView)) {
          break label148;
        }
        if (LiteVideoActivity.b(this.a)) {
          break label71;
        }
      }
    }
    label71:
    while (!LiteVideoActivity.a(this.a, paramAdapterView.a()))
    {
      return;
      paramAdapterView = paramAdapterView.getItem(paramInt);
      break;
    }
    LiteVideoActivity.a(this.a, paramAdapterView);
    paramView.b.setVisibility(0);
    paramView = SendInfo.a(paramAdapterView.a(), null, 0L);
    LiteVideoActivity.a(this.a).add(paramView);
    paramAdapterView = new File(paramAdapterView.a());
    LiteVideoActivity.a(this.a, paramAdapterView.length());
    return;
    label148:
    LiteVideoActivity.b(this.a, paramAdapterView);
    paramView.b.setVisibility(4);
    paramView = paramAdapterView.a();
    paramInt = i;
    for (;;)
    {
      if (paramInt < LiteVideoActivity.a(this.a).size())
      {
        if (paramView.equals(((SendInfo)LiteVideoActivity.a(this.a).get(paramInt)).a())) {
          LiteVideoActivity.a(this.a).remove(paramInt);
        }
      }
      else
      {
        paramAdapterView = new File(paramAdapterView.a());
        LiteVideoActivity.b(this.a, paramAdapterView.length());
        return;
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ci
 * JD-Core Version:    0.7.0.1
 */
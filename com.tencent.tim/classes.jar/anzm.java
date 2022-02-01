import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class anzm
  implements AdapterView.OnItemLongClickListener
{
  public anzm(TableQueryViewer paramTableQueryViewer, Context paramContext) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((anzg)TableQueryViewer.a(this.c).get(paramInt)).reportId;
    paramView = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
    if ((paramView != null) && (!TextUtils.isEmpty(paramAdapterView)))
    {
      paramAdapterView = ClipData.newPlainText("bigT", paramAdapterView);
      alkw.a(paramView, paramAdapterView);
      paramView.setPrimaryClip(paramAdapterView);
      QQToast.a(this.c.getContext(), this.val$context.getString(2131690843), 0).show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzm
 * JD-Core Version:    0.7.0.1
 */
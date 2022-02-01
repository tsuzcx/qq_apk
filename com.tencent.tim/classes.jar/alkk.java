import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class alkk
  implements AdapterView.c
{
  public alkk(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = yui.hN(((TextView)paramView.findViewById(2131374868)).getText().toString());
    paramLong = anaz.gQ();
    paramAdapterView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramView));
    this.this$0.startActivity(paramAdapterView);
    alkm localalkm = QCallDetailActivity.a(this.this$0);
    if (QCallDetailActivity.a(this.this$0) == 56938) {}
    for (paramAdapterView = paramView;; paramAdapterView = QCallDetailActivity.a(this.this$0))
    {
      localalkm.b(paramAdapterView, QCallDetailActivity.a(this.this$0), QCallDetailActivity.c(this.this$0), paramLong, paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkk
 * JD-Core Version:    0.7.0.1
 */
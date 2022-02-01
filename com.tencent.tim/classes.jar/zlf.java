import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.messagesearch.C2CLinkElement;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

class zlf
  implements AdapterView.c
{
  zlf(zky paramzky) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((this.b.a.getCount() <= 0) || (paramInt <= 0)) {
      return;
    }
    paramAdapterView = this.b.a.a(paramInt - 1);
    if (paramAdapterView != null)
    {
      paramView = new Intent(this.b.mContext, QQBrowserActivity.class);
      paramView.putExtra("url", paramAdapterView.url);
      this.b.mContext.startActivity(paramView);
      return;
    }
    QLog.e("LinkMessageSearchDialog", 2, "link element is null pos:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlf
 * JD-Core Version:    0.7.0.1
 */
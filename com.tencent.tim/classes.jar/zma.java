import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

class zma
  implements AdapterView.c
{
  zma(zlt paramzlt) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((this.b.a.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return;
      paramAdapterView = (zmc)this.b.a.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.b.o = paramAdapterView.messageRecord;
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, mRecordCount = " + this.b.cdF + ",needSearchInCloud:" + this.b.brB);
    }
    try
    {
      paramAdapterView = aoyb.deserialize(this.b.o.msgData);
      if (paramAdapterView == null) {
        break label214;
      }
      paramAdapterView = (TroopLinkElement)paramAdapterView;
    }
    catch (Exception paramAdapterView)
    {
      for (;;)
      {
        paramAdapterView = null;
        continue;
        paramAdapterView = null;
      }
    }
    if (paramAdapterView != null)
    {
      paramView = new Intent(this.b.mContext, QQBrowserActivity.class);
      paramView.putExtra("url", paramAdapterView.url);
      this.b.mContext.startActivity(paramView);
    }
    this.b.BM(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zma
 * JD-Core Version:    0.7.0.1
 */
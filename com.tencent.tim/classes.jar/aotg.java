import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aotg
  implements AdapterView.OnItemClickListener
{
  aotg(aotc paramaotc) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if ((localObject instanceof aotc.b))
      {
        localObject = (aotc.b)localObject;
        if (((aotc.b)localObject).a != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAppShortcutContainer", 2, "onItemClick appInfo:" + ((aotc.b)localObject).a.toString());
          }
          if (((aotc.b)localObject).a.app_type == 1) {
            aotc.a(this.b, 1);
          } else if (((aotc.b)localObject).a.app_type == 0) {
            aprs.a(this.b.mApp, this.b.mContext, this.b.mSessionInfo, ((aotc.b)localObject).a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aotg
 * JD-Core Version:    0.7.0.1
 */
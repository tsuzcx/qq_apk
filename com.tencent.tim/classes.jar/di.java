import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class di
  implements View.OnClickListener
{
  di(dg paramdg) {}
  
  public void onClick(View paramView)
  {
    dl localdl = (dl)paramView.getTag();
    if (localdl == null) {}
    DataLineMsgSet localDataLineMsgSet;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localDataLineMsgSet = localdl.a();
    } while (localDataLineMsgSet == null);
    long l = 0L;
    if (localDataLineMsgSet.getFirstItem() != null) {
      l = localDataLineMsgSet.getFirstItem().sessionid;
    }
    for (;;)
    {
      localDataLineMsgSet.setPaused(true);
      ((acde)this.a.app.getBusinessHandler(8)).g(localDataLineMsgSet.getGroupId(), l, false);
      dg.a(this.a, localdl, localDataLineMsgSet);
      break;
      QLog.e("DatalineSessionAdapterUseNewFileBubble", 1, "stop recv but no sessionid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     di
 * JD-Core Version:    0.7.0.1
 */
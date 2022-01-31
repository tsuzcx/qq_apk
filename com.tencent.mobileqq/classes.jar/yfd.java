import android.text.TextUtils;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;

public class yfd
  extends CardObserver
{
  public yfd(SystemMsgListAdapter paramSystemMsgListAdapter) {}
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card))) {}
    try
    {
      paramObject = (Card)paramObject;
      if ((!TextUtils.isEmpty(paramObject.strCampusName)) && (this.a.a != null) && (this.a.a.contains(paramObject.uin)))
      {
        SystemMsgListAdapter.a(this.a).runOnUiThread(new yfe(this));
        if (QLog.isDevelopLevel()) {
          QLog.i("SystemMsgListAdapter", 4, String.format(Locale.getDefault(), "onGetCampusInfo [%s, %s]", new Object[] { Utils.b(paramObject.uin), Utils.b(paramObject.strCampusName) }));
        }
      }
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yfd
 * JD-Core Version:    0.7.0.1
 */
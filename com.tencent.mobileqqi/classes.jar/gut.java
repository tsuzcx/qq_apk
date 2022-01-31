import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.troop.data.NearbyOpenTroop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troop.group_activity_info.GroupActInfo;
import java.util.Iterator;
import java.util.List;

public class gut
  extends BizTroopObserver
{
  public gut(NearbyOpenTroop paramNearbyOpenTroop) {}
  
  private void a(group_activity_info.GroupActInfo paramGroupActInfo)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1001;
    localMessage.obj = paramGroupActInfo;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, List paramList)
  {
    if ((!paramBoolean2) || (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    int j = 0;
    int i = j;
    if (paramBoolean1)
    {
      paramString = paramList.iterator();
      i = j;
      if (paramString.hasNext())
      {
        a((group_activity_info.GroupActInfo)paramString.next());
        i = 1;
      }
    }
    if (i == 0)
    {
      NearbyOpenTroop.b(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("EnterTroopTipsMsg", 2, "没有群活动消息，之后直接生成tips");
      }
    }
    NearbyOpenTroop.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gut
 * JD-Core Version:    0.7.0.1
 */
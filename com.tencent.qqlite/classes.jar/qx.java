import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.LBSObserver;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class qx
  extends Handler
{
  public qx(TroopMemberApiClient paramTroopMemberApiClient) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = paramMessage.getData();
    } while (localObject1 == null);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      int i = ((Bundle)localObject1).getInt("type");
      boolean bool = ((Bundle)localObject1).getBoolean("isSuccess", false);
      Object localObject2 = ((Bundle)localObject1).getSerializable("data");
      int j = ((Bundle)localObject1).getInt("observer_type");
      localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (BusinessObserver)((Iterator)localObject1).next();
        if (((j == 1) && ((localObject3 instanceof LBSObserver))) || ((j == 2) && ((localObject3 instanceof FriendListObserver)))) {
          ((BusinessObserver)localObject3).onUpdate(i, bool, localObject2);
        }
      }
      i = ((Bundle)localObject1).getInt("seq", -1);
      if (i != -1)
      {
        localObject2 = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
        if (localObject2 != null)
        {
          ((TroopMemberApiClient.Callback)localObject2).a((Bundle)localObject1);
          continue;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null)
          {
            localObject2 = ((Bundle)localObject1).getString("pageUrl");
            localObject3 = ((Bundle)localObject1).getStringArrayList("lstVideoUrl");
            i = ((Bundle)localObject1).getInt("totalTime", 0);
            this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver.onUpdate(((Bundle)localObject1).getInt("type"), true, new Object[] { localObject2, localObject3, Integer.valueOf(i) });
            continue;
            this.a.a().a((Bundle)localObject1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     qx
 * JD-Core Version:    0.7.0.1
 */
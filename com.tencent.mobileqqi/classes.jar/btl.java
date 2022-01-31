import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.TroopObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class btl
  extends Handler
{
  public btl(TroopMemberApiClient paramTroopMemberApiClient) {}
  
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
      localObject1 = ((Bundle)localObject1).getSerializable("data");
      Object localObject2 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((TroopObserver)((Iterator)localObject2).next()).a(i, bool, localObject1);
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
            ArrayList localArrayList = ((Bundle)localObject1).getStringArrayList("lstVideoUrl");
            i = ((Bundle)localObject1).getInt("totalTime", 0);
            this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver.a(((Bundle)localObject1).getInt("type"), true, new Object[] { localObject2, localArrayList, Integer.valueOf(i) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     btl
 * JD-Core Version:    0.7.0.1
 */
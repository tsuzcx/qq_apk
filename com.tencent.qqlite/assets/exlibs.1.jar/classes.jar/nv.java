import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResponseBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItem;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItemGroup;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public final class nv
  implements BusinessObserver
{
  public nv(Handler paramHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        localObject = new mobileqq_dynamic_search.ResponseBody();
        try
        {
          ((mobileqq_dynamic_search.ResponseBody)localObject).mergeFrom(paramBundle);
          if ((((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.has()) && (((mobileqq_dynamic_search.ResultItemGroup)((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.get(0)).result_items.has()))
          {
            localObject = ((mobileqq_dynamic_search.ResultItemGroup)((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.get(0)).result_items.get();
            paramBundle = new ArrayList();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              mobileqq_dynamic_search.ResultItem localResultItem = (mobileqq_dynamic_search.ResultItem)((Iterator)localObject).next();
              if (localResultItem.word.has()) {
                paramBundle.add(localResultItem.word.get().toStringUtf8());
              }
            }
          }
          paramBundle = this.a.obtainMessage();
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SearchProtocol", 2, paramBundle.getMessage());
          }
        }
      }
    }
    paramBundle.arg1 = -1;
    this.a.sendMessage(paramBundle);
    return;
    Object localObject = this.a.obtainMessage();
    ((Message)localObject).obj = paramBundle;
    ((Message)localObject).arg1 = 0;
    this.a.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     nv
 * JD-Core Version:    0.7.0.1
 */
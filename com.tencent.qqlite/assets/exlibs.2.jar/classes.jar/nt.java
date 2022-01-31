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
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class nt
  implements BusinessObserver
{
  public nt(String paramString, Handler paramHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localObject = new mobileqq_dynamic_search.ResponseBody();
      }
    }
    try
    {
      ((mobileqq_dynamic_search.ResponseBody)localObject).mergeFrom(paramBundle);
      com.tencent.biz.lebasearch.SearchProtocol.a = ((mobileqq_dynamic_search.ResponseBody)localObject).search_id.get();
      paramBundle = new JSONArray();
      if (((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.has())
      {
        localObject = ((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.get().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label515;
        }
        mobileqq_dynamic_search.ResultItemGroup localResultItemGroup = (mobileqq_dynamic_search.ResultItemGroup)((Iterator)localObject).next();
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("result_type", localResultItemGroup.group_mask.get());
        localJSONObject1.put("result_name", localResultItemGroup.group_name.get().toStringUtf8());
        localJSONObject1.put("total_count", localResultItemGroup.total_result_count.get());
        localJSONObject1.put("more_url", localResultItemGroup.more_url.get().toStringUtf8());
        localJSONObject1.put("more_name", localResultItemGroup.more_name.get().toStringUtf8());
        localJSONArray = new JSONArray();
        if (!localResultItemGroup.result_items.has()) {
          break label485;
        }
        Iterator localIterator = localResultItemGroup.result_items.get().iterator();
        while (localIterator.hasNext())
        {
          mobileqq_dynamic_search.ResultItem localResultItem = (mobileqq_dynamic_search.ResultItem)localIterator.next();
          try
          {
            if (!localResultItem.extension.has()) {
              continue;
            }
            JSONObject localJSONObject2 = new JSONObject(localResultItem.extension.get().toStringUtf8());
            if (localResultItem.jmp_url.has()) {
              localJSONObject2.put("jump_url", localResultItem.jmp_url.get().toStringUtf8());
            }
            if (localResultItem.name.has()) {
              localJSONObject2.put("name", localResultItem.name.get().toStringUtf8());
            }
            if (localResultItem.pic_url.has()) {
              localJSONObject2.put("pic_url", localResultItem.pic_url.get().toStringUtf8());
            }
            localJSONObject2.put("keyword", this.jdField_a_of_type_JavaLangString);
            localJSONObject2.put("result_type", localResultItemGroup.group_mask.get());
            localJSONArray.put(localJSONObject2);
          }
          catch (JSONException localJSONException) {}
          if (QLog.isColorLevel()) {
            QLog.d("SearchProtocol", 2, localJSONException.getMessage());
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      for (;;)
      {
        JSONObject localJSONObject1;
        JSONArray localJSONArray;
        if (QLog.isColorLevel()) {
          QLog.d("SearchProtocol", 2, paramBundle.getMessage());
        }
        paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramBundle.arg1 = -1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBundle);
        return;
        localJSONObject1.put("result_extension", localJSONArray);
        paramBundle.put(localJSONObject1);
      }
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchProtocol", 2, paramBundle.getMessage());
        }
      }
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).obj = paramBundle;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
    catch (NullPointerException paramBundle)
    {
      label515:
      for (;;)
      {
        label485:
        if (QLog.isColorLevel()) {
          QLog.d("SearchProtocol", 2, paramBundle.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     nt
 * JD-Core Version:    0.7.0.1
 */
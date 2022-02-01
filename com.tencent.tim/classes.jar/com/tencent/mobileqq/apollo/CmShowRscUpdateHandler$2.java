package com.tencent.mobileqq.apollo;

import abis;
import abis.a;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdRsp;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STDomainInfo;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STPatchInfo;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STVerInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CmShowRscUpdateHandler$2
  implements Runnable
{
  public CmShowRscUpdateHandler$2(abis paramabis, CmShowContentUpdate.STContUpdRsp paramSTContUpdRsp, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    Object localObject3;
    try
    {
      SparseArray localSparseArray = new SparseArray();
      localObject1 = this.a.domain_list.get();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (CmShowContentUpdate.STDomainInfo)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject3 = ((CmShowContentUpdate.STDomainInfo)localObject2).url.get().toStringUtf8();
            if ((localObject3 != null) && (!((String)localObject3).isEmpty()))
            {
              localSparseArray.put(((CmShowContentUpdate.STDomainInfo)localObject2).domain_id.get(), localObject3);
              continue;
              return;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("rscContent_CmShowRscUpdateHandler", 1, localException, new Object[0]);
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.a.cont_list.get();
    label164:
    Object localObject4;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (CmShowContentUpdate.STVerInfo)((Iterator)localObject2).next();
        if (localObject4 != null)
        {
          localObject3 = new abis.a();
          ((abis.a)localObject3).mItemId = ((CmShowContentUpdate.STVerInfo)localObject4).item_id.get();
          ((abis.a)localObject3).cpg = ((CmShowContentUpdate.STVerInfo)localObject4).biz_id.get();
          ((abis.a)localObject3).mName = ((CmShowContentUpdate.STVerInfo)localObject4).name.get().toStringUtf8();
          ((abis.a)localObject3).mVersion = ((CmShowContentUpdate.STVerInfo)localObject4).ver.get();
          ((abis.a)localObject3).cpk = ((CmShowContentUpdate.STVerInfo)localObject4).domain_id.get();
          ((abis.a)localObject3).bgw = ((CmShowContentUpdate.STVerInfo)localObject4).down_file.get().toStringUtf8();
          ((abis.a)localObject3).bgu = abis.a.a((String)localException.get(((abis.a)localObject3).cpk), ((abis.a)localObject3).mItemId, ((abis.a)localObject3).mVersion, ((abis.a)localObject3).bgw);
          if (((CmShowContentUpdate.STVerInfo)localObject4).is_patch.get() != 1) {
            break label762;
          }
        }
      }
    }
    label762:
    for (boolean bool = true;; bool = false)
    {
      ((abis.a)localObject3).bDi = bool;
      ((abis.a)localObject3).cph = this.this$0.a(((abis.a)localObject3).cpg, ((abis.a)localObject3).mItemId, ((abis.a)localObject3).mName);
      ((abis.a)localObject3).mMd5 = ((CmShowContentUpdate.STVerInfo)localObject4).md5.get().toStringUtf8();
      localObject4 = (CmShowContentUpdate.STPatchInfo)((CmShowContentUpdate.STVerInfo)localObject4).patch_info.get();
      if (localObject4 != null)
      {
        ((abis.a)localObject3).cph = ((CmShowContentUpdate.STPatchInfo)localObject4).base_ver.get();
        if ((((CmShowContentUpdate.STPatchInfo)localObject4).patch_data != null) && (((CmShowContentUpdate.STPatchInfo)localObject4).patch_data.get() != null) && (!((CmShowContentUpdate.STPatchInfo)localObject4).patch_data.get().isEmpty()))
        {
          ((abis.a)localObject3).cK = ((CmShowContentUpdate.STPatchInfo)localObject4).patch_data.get().toByteArray();
          ((abis.a)localObject3).NA = ((CmShowContentUpdate.STPatchInfo)localObject4).patch_size.get();
        }
        ((abis.a)localObject3).bgx = ((CmShowContentUpdate.STPatchInfo)localObject4).down_patch_file.get().toStringUtf8();
        ((abis.a)localObject3).bgv = abis.a.a((String)localException.get(((abis.a)localObject3).cpk), ((abis.a)localObject3).mItemId, ((abis.a)localObject3).mVersion, ((abis.a)localObject3).bgx);
      }
      ((abis.a)localObject3).cpi = this.a.intervals_ts.get();
      ((abis.a)localObject3).bDj = this.bDh;
      ((abis.a)localObject3).cpj = this.val$requestId;
      ((List)localObject1).add(localObject3);
      break label164;
      abis.a(this.this$0).edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
      if (QLog.isColorLevel()) {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "checkResults:" + localObject1);
      }
      if (this.bDh)
      {
        abis.a(this.this$0, new ArrayList());
        abis.a(this.this$0).addAll((Collection)localObject1);
      }
      if (!((List)localObject1).isEmpty())
      {
        abis.a(this.this$0, this.val$requestId, (List)localObject1);
        return;
      }
      abis.a(this.this$0, this.val$requestId);
      if ((!this.bDh) || (!abis.a(this.this$0).isEmpty())) {
        break;
      }
      abis.a(this.this$0).edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, "no need update");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.CmShowRscUpdateHandler.2
 * JD-Core Version:    0.7.0.1
 */
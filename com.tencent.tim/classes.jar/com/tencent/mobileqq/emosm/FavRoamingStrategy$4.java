package com.tencent.mobileqq.emosm;

import acbn;
import acfi;
import affx;
import afgn;
import afim;
import afpg;
import afpu;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavRoamingStrategy$4
  implements Runnable
{
  public FavRoamingStrategy$4(afgn paramafgn, Object paramObject, afim paramafim, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i("FavRoamingStrategy", 2, "Call getEmoticonDataList-2 from doDelete.");
    }
    Object localObject1 = this.this$0.a().ez();
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject3).next();
        if (localCustomEmotionData != null) {
          if ((this.val$obj instanceof afpu))
          {
            localObject1 = ((afpu)this.val$obj).e;
            if ((!TextUtils.isEmpty(localCustomEmotionData.eId)) && (localObject1 != null) && (localCustomEmotionData.eId.equals(((Emoticon)localObject1).eId))) {
              ((List)localObject2).add(localCustomEmotionData);
            }
          }
          else if ((this.val$obj instanceof afpg))
          {
            if (this.this$0.zx.contains(this.val$obj)) {}
            for (localObject1 = acbn.bmd + acfi.jj(((afpg)this.val$obj).path);; localObject1 = ((afpg)this.val$obj).path)
            {
              if ((!TextUtils.isEmpty(localCustomEmotionData.emoPath)) && (localCustomEmotionData.emoPath.equals(localObject1))) {
                ((List)localObject2).add(localCustomEmotionData);
              }
              if ((!TextUtils.isEmpty(localCustomEmotionData.emoPath)) || (!"init".equals(localCustomEmotionData.RomaingType))) {
                break;
              }
              QLog.e("FavRoamingStrategy", 2, "delete failed, path is null, state is init. data: " + localCustomEmotionData);
              break;
            }
          }
        }
      }
    }
    if (((List)localObject2).size() > 0)
    {
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (CustomEmotionData)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty(((CustomEmotionData)localObject3).resid))
        {
          ((CustomEmotionData)localObject3).RomaingType = "needDel";
          this.this$0.a().b((CustomEmotionBase)localObject3);
          afgn.a(this.this$0).add(((CustomEmotionData)localObject3).resid);
          if (!TextUtils.isEmpty(((CustomEmotionData)localObject3).md5)) {
            ((List)localObject1).add(((CustomEmotionData)localObject3).md5);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("FavRoamingStrategy", 2, "delete from local, Roma Type: " + ((CustomEmotionData)localObject3).RomaingType);
          }
          this.this$0.a().a((CustomEmotionBase)localObject3);
          if (!TextUtils.isEmpty(((CustomEmotionData)localObject3).md5)) {
            ((List)localObject1).add(((CustomEmotionData)localObject3).md5);
          }
        }
      }
      if (((List)localObject1).size() > 0) {
        this.val$vipComicMqqManager.kn((List)localObject1);
      }
    }
    for (;;)
    {
      if (afgn.a(this.this$0) != null) {
        afgn.a(this.this$0).obtainMessage(207, Integer.valueOf(this.val$index)).sendToTarget();
      }
      return;
      QLog.e("FavRoamingStrategy", 1, "delete failed, not find original emotion data");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.4
 * JD-Core Version:    0.7.0.1
 */
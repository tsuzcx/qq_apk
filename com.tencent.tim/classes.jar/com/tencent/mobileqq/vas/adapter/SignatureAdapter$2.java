package com.tencent.mobileqq.vas.adapter;

import amhd;
import android.os.Bundle;
import aqqr;
import aqqs;
import aqqs.a;
import aqrp;
import aqry;
import com.tencent.mobileqq.app.SignatureManager;

public class SignatureAdapter$2
  implements Runnable
{
  public SignatureAdapter$2(aqry paramaqry, int paramInt, aqqs paramaqqs) {}
  
  public void run()
  {
    if (SignatureManager.existDynamicSource(String.valueOf(this.val$id)))
    {
      aqry.a(this.this$0, true);
      str = aqqr.cb(Integer.toString(this.val$id), "dynamic_aio");
      localObject1 = this.e.a[0];
      localObject2 = aqry.a(this.this$0);
      int i;
      if (((aqqs.a)localObject1).interval != 0)
      {
        i = ((aqqs.a)localObject1).interval;
        if (!aqry.a(this.this$0)) {
          break label96;
        }
      }
      label96:
      for (int j = -1;; j = ((aqqs.a)localObject1).ece)
      {
        ((aqrp)localObject2).aP(str, i, j);
        return;
        i = 50;
        break;
      }
    }
    String str = this.e.a[0].cwj;
    Object localObject1 = amhd.J(this.val$id, str);
    Object localObject2 = aqqr.cb(String.valueOf(this.val$id), str);
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", 16);
    localBundle.putString("tplId", String.valueOf(this.val$id));
    localBundle.putString("fileName", str);
    aqry.a(this.this$0).c((String)localObject1, (String)localObject2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.2
 * JD-Core Version:    0.7.0.1
 */
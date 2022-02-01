package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import android.os.Handler;
import aqqr;
import aqrp;
import aqry;
import aqva;
import java.io.File;

public class SignatureAdapter$3
  implements Runnable
{
  public SignatureAdapter$3(aqry paramaqry, Bundle paramBundle) {}
  
  public void run()
  {
    int i = this.val$params.getInt("dynamicType");
    String str1 = this.val$params.getString("tplId");
    String str2 = this.val$params.getString("fileName");
    Object localObject = null;
    switch (i)
    {
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = new File((String)localObject);
        if (aqva.a(new File(aqqr.cb(str1, str2)), (File)localObject, true)) {
          aqry.a(this.this$0).A().sendEmptyMessage(10003);
        }
      }
      return;
      localObject = aqqr.cb(str1, "dynamic_aio");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureAdapter.3
 * JD-Core Version:    0.7.0.1
 */
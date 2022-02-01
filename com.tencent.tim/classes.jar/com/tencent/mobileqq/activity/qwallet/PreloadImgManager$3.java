package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import zxt;

public class PreloadImgManager$3
  implements Runnable
{
  public PreloadImgManager$3(zxt paramzxt, Set paramSet, String paramString1, String paramString2, AppInterface paramAppInterface, List paramList, String paramString3, Map paramMap, Bundle paramBundle) {}
  
  public void run()
  {
    Iterator localIterator = this.bA.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = MD5.toMD5(str1);
        Object localObject2 = new File(this.bbg, str2);
        Object localObject1 = localObject2;
        if (!((File)localObject2).exists()) {
          localObject1 = new File(this.bbh, str2);
        }
        if (((File)localObject1).exists())
        {
          localObject2 = this.this$0;
          this.b.getApplication();
          if (zxt.a((zxt)localObject2, MobileQQ.getContext(), ((File)localObject1).getPath(), str1) != null) {}
        }
        else
        {
          this.uS.add(str1);
          localObject1 = new File(this.bbi, str2);
          this.iu.put(str1, localObject1);
          this.val$bundle.putString(str1, ((File)localObject1).getPath());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.3
 * JD-Core Version:    0.7.0.1
 */
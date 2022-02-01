package com.tencent.open.wadl;

import android.text.TextUtils;
import aqhq;
import asbv;
import asbw;
import ascf;
import awot;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class WadlConfigCenter$1
  implements Runnable
{
  public WadlConfigCenter$1(asbw paramasbw) {}
  
  public void run()
  {
    ??? = awot.R();
    String str = null;
    if (((File)???).exists()) {
      str = aqhq.readFileContent((File)???);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WadlConfigCenter", 2, "loadConfig content=" + str);
    }
    synchronized (asbw.a(this.this$0))
    {
      asbw.a(this.this$0).clear();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {}
      try
      {
        Object localObject3 = new ascf();
        ((ascf)localObject3).key = "valid_url_regex_lists";
        ((ascf)localObject3).parse(str);
        asbw.a(this.this$0).put("valid_url_regex_lists", localObject3);
        localObject3 = new asbv();
        ((asbv)localObject3).key = "comminfo";
        ((asbv)localObject3).parse(str);
        asbw.a(this.this$0).put("comminfo", localObject3);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.wadl.WadlConfigCenter.1
 * JD-Core Version:    0.7.0.1
 */
package wf7;

import Protocol.MConch.ConchPushInfo;
import Protocol.MConch.c;
import Protocol.MConch.f;
import android.text.TextUtils;
import com.tencent.wifisdk.services.common.api.e;
import java.io.File;
import java.util.ArrayList;

class fn$2$1
  implements Runnable
{
  fn$2$1(fn.2 param2, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject;
      switch (this.nU)
      {
      case 6065: 
        localObject = (f)df.a(fq.eo().av(this.nU).bs.bj, new f(), false);
        if ((localObject != null) && (((f)localObject).by != null) && (((f)localObject).by.size() >= 2) && (TextUtils.equals("102769", (CharSequence)((f)localObject).by.get(0))))
        {
          localObject = (String)((f)localObject).by.get(1);
          fm.dL().J((String)localObject);
          return;
        }
        break;
      case 6165: 
        localObject = (f)df.a(fq.eo().av(this.nU).bs.bj, new f(), false);
        if ((localObject != null) && (((f)localObject).by != null) && (((f)localObject).by.size() >= 4) && (TextUtils.equals("102769", (CharSequence)((f)localObject).by.get(0))))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)((f)localObject).by.get(1)).append(File.separator).append((String)((f)localObject).by.get(2)).append(File.separator).append((String)((f)localObject).by.get(3));
          fn.a(this.qD.qB).b("kfpt", localStringBuilder.toString());
          return;
        }
        break;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fn.2.1
 * JD-Core Version:    0.7.0.1
 */
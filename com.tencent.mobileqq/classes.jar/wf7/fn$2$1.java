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
      int i = this.nU;
      Object localObject;
      if (i != 6065)
      {
        if (i != 6165) {
          return;
        }
        localObject = (f)df.a(fq.eo().av(this.nU).bs.bj, new f(), false);
        if ((localObject != null) && (((f)localObject).by != null))
        {
          if (((f)localObject).by.size() < 4) {
            return;
          }
          if (!TextUtils.equals("102769", (CharSequence)((f)localObject).by.get(0))) {
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)((f)localObject).by.get(1));
          localStringBuilder.append(File.separator);
          localStringBuilder.append((String)((f)localObject).by.get(2));
          localStringBuilder.append(File.separator);
          localStringBuilder.append((String)((f)localObject).by.get(3));
          fn.a(this.qD.qB).b("kfpt", localStringBuilder.toString());
        }
      }
      else
      {
        localObject = (f)df.a(fq.eo().av(this.nU).bs.bj, new f(), false);
        if ((localObject != null) && (((f)localObject).by != null))
        {
          if (((f)localObject).by.size() < 2) {
            return;
          }
          if (!TextUtils.equals("102769", (CharSequence)((f)localObject).by.get(0))) {
            return;
          }
          localObject = (String)((f)localObject).by.get(1);
          fm.dL().J((String)localObject);
        }
        return;
      }
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fn.2.1
 * JD-Core Version:    0.7.0.1
 */
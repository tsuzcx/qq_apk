package wf7;

import Protocol.MConch.ConchPushInfo;
import Protocol.MConch.a;
import Protocol.MConch.c;
import Protocol.MConch.e;
import Protocol.MConch.g;
import Protocol.MConch.h;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import com.tencent.wifisdk.services.common.api.b;
import com.tencent.wifisdk.services.common.api.b.a;
import java.util.ArrayList;
import java.util.Iterator;

class gh$1
  implements b.a
{
  gh$1(gh paramgh, int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if (paramInt3 != 0) {}
    a locala;
    do
    {
      do
      {
        return;
      } while ((paramJceStruct == null) || (((h)paramJceStruct).bA == null) || (((h)paramJceStruct).bA.size() == 0));
      locala = new a();
      locala.bf = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder();
      Handler localHandler = gh.a(this.sj);
      paramJceStruct = ((h)paramJceStruct).bA.iterator();
      while (paramJceStruct.hasNext())
      {
        e locale = (e)paramJceStruct.next();
        if ((locale.bw == null) || (locale.bw.size() == 0))
        {
          localStringBuilder.append("0-;");
          locala.bf.add(gh.a(this.sj, locale.bt, locale.bu, null, 3));
        }
        else
        {
          Iterator localIterator = locale.bw.iterator();
          while (localIterator.hasNext())
          {
            c localc = (c)localIterator.next();
            ConchPushInfo localConchPushInfo = new ConchPushInfo(locale.bt, locale.bu, localc);
            if (localHandler != null) {
              localHandler.obtainMessage(2, localConchPushInfo).sendToTarget();
            }
            if ((localc.bi == this.si) || (gh.b(this.sj).get(localc.bi) != null))
            {
              if (localHandler != null) {
                localHandler.obtainMessage(1, localConchPushInfo).sendToTarget();
              }
              locala.bf.add(gh.a(this.sj, locale.bt, locale.bu, localc, 1));
              localStringBuilder.append("1-" + localc.bi + ";");
            }
            else
            {
              localStringBuilder.append("2-" + localc.bi + ";");
              locala.bf.add(gh.a(this.sj, locale.bt, locale.bu, localc, 5));
            }
          }
        }
      }
    } while (locala.bf.size() <= 0);
    gh.c(this.sj).a(13, locala, new g(), new gh.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.gh.1
 * JD-Core Version:    0.7.0.1
 */
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
    if (paramInt3 != 0) {
      return;
    }
    if (paramJceStruct != null)
    {
      paramJceStruct = (h)paramJceStruct;
      if (paramJceStruct.bA != null)
      {
        if (paramJceStruct.bA.size() == 0) {
          return;
        }
        a locala = new a();
        locala.bf = new ArrayList();
        StringBuilder localStringBuilder = new StringBuilder();
        Handler localHandler = gh.a(this.sj);
        paramJceStruct = paramJceStruct.bA.iterator();
        while (paramJceStruct.hasNext())
        {
          e locale = (e)paramJceStruct.next();
          if ((locale.bw != null) && (locale.bw.size() != 0))
          {
            Iterator localIterator = locale.bw.iterator();
            JceStruct localJceStruct = paramJceStruct;
            for (;;)
            {
              paramJceStruct = localJceStruct;
              if (!localIterator.hasNext()) {
                break;
              }
              paramJceStruct = (c)localIterator.next();
              Object localObject = new ConchPushInfo(locale.bt, locale.bu, paramJceStruct);
              if (localHandler != null) {
                localHandler.obtainMessage(2, localObject).sendToTarget();
              }
              if ((paramJceStruct.bi != this.si) && (gh.b(this.sj).get(paramJceStruct.bi) == null))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("2-");
                ((StringBuilder)localObject).append(paramJceStruct.bi);
                ((StringBuilder)localObject).append(";");
                localStringBuilder.append(((StringBuilder)localObject).toString());
                locala.bf.add(gh.a(this.sj, locale.bt, locale.bu, paramJceStruct, 5));
              }
              else
              {
                if (localHandler != null) {
                  localHandler.obtainMessage(1, localObject).sendToTarget();
                }
                locala.bf.add(gh.a(this.sj, locale.bt, locale.bu, paramJceStruct, 1));
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("1-");
                ((StringBuilder)localObject).append(paramJceStruct.bi);
                ((StringBuilder)localObject).append(";");
                localStringBuilder.append(((StringBuilder)localObject).toString());
              }
            }
          }
          localStringBuilder.append("0-;");
          locala.bf.add(gh.a(this.sj, locale.bt, locale.bu, null, 3));
        }
        if (locala.bf.size() > 0) {
          gh.c(this.sj).a(13, locala, new g(), new gh.1.1(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gh.1
 * JD-Core Version:    0.7.0.1
 */
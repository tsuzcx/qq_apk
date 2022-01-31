package btmsdkobf;

import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import java.util.ArrayList;
import java.util.Iterator;

class ez
  implements cj
{
  ez(bk parambk, ConchService.IConchPushListener paramIConchPushListener, int paramInt) {}
  
  public void onFinish(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if (paramInt3 != 0)
    {
      this.a.mErrorCode = (paramInt3 - 65);
      if (this.a.mErrorCode == 0) {
        break label66;
      }
    }
    label66:
    w localw;
    StringBuilder localStringBuilder;
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt4 != 0)
          {
            this.a.mErrorCode = (paramInt4 - 65);
            break;
          }
          if (paramInt2 == 10011) {
            break;
          }
          this.a.mErrorCode = -4000;
          break;
        } while ((paramJceStruct == null) || (((ag)paramJceStruct).bo == null) || (((ag)paramJceStruct).bo.size() == 0));
        localw = new w();
        localw.aW = new ArrayList();
        localStringBuilder = new StringBuilder();
      } while (bk.a(this.c) == ((ac)((ag)paramJceStruct).bo.get(0)).bg);
      paramJceStruct = ((ag)paramJceStruct).bo.iterator();
      while (paramJceStruct.hasNext())
      {
        ac localac = (ac)paramJceStruct.next();
        if ((localac.bk == null) || (localac.bk.size() == 0))
        {
          localStringBuilder.append("0-;");
          localw.aW.add(bk.a(this.c, localac.bg, localac.bh, null, 3));
        }
        else
        {
          Iterator localIterator = localac.bk.iterator();
          while (localIterator.hasNext())
          {
            z localz = (z)localIterator.next();
            if ((localz.cmdId == this.b) || (bk.b(this.c).get(localz.cmdId) != null))
            {
              bk.a(this.c, new ConchService.ConchPushInfo(localac.bg, localac.bh, localz));
              localw.aW.add(bk.a(this.c, localac.bg, localac.bh, localz, 1));
              localStringBuilder.append("1-" + localz.cmdId + ";");
            }
            else
            {
              localStringBuilder.append("2-" + localz.cmdId + ";");
              localw.aW.add(bk.a(this.c, localac.bg, localac.bh, localz, 5));
            }
          }
        }
      }
    } while (localw.aW.size() <= 0);
    be.SaveStringData(1320061, localStringBuilder.toString());
    bk.c(this.c).a(13, localw, new ae(), 2, null, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ez
 * JD-Core Version:    0.7.0.1
 */
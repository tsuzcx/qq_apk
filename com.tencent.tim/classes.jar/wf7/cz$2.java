package wf7;

import com.qq.taf.jce.JceStruct;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.DogFood;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.a;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.b;
import java.util.List;

class cz$2
  implements aw
{
  cz$2(cz paramcz, long paramLong, List paramList, cz.a parama) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if (this.iR > 0L) {
      cw.bo().br().a(this.iR, new DogFood(b.fU));
    }
    by.d(387645, paramInt3);
    if (cm.R(2) != 1)
    {
      cm.q(2, 1);
      by.d(501099, 1);
    }
    if (cm.R(5) != 1)
    {
      cm.q(5, 1);
      by.d(501102, 1);
    }
    boolean bool;
    if (paramInt3 == 0)
    {
      bool = true;
      if ((!bool) || (paramJceStruct == null) || (!(paramJceStruct instanceof f))) {
        break label286;
      }
      paramJceStruct = cz.a(this.jF, this.jD, (f)paramJceStruct);
      if ((paramJceStruct == null) || (!paramJceStruct.jI)) {
        break label224;
      }
      by.r(387723);
      if (cm.R(3) != 1)
      {
        cm.q(3, 1);
        by.d(501100, 1);
      }
      if (cm.R(6) != 1)
      {
        cm.q(6, 1);
        by.d(501103, 1);
      }
      label179:
      if (this.jE != null)
      {
        if (paramJceStruct == null) {
          break label267;
        }
        this.jE.a(this.iR, bool, paramJceStruct.jG, paramJceStruct.jH, paramInt3);
      }
    }
    label224:
    do
    {
      return;
      bool = false;
      break;
      if (cm.R(3) == 3)
      {
        cm.q(3, 2);
        by.d(501100, -1);
      }
      if (cm.R(6) != 3) {
        break label179;
      }
      cm.q(6, 2);
      by.d(501103, -1);
      break label179;
      this.jE.a(this.iR, bool, null, true, paramInt3);
      return;
      cz.b(this.jF, this.jD);
      paramJceStruct = cz.a(this.jF, this.jD);
    } while (this.jE == null);
    label267:
    label286:
    this.jE.a(this.iR, false, paramJceStruct, false, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.cz.2
 * JD-Core Version:    0.7.0.1
 */
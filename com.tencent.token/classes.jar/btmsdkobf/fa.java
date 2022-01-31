package btmsdkobf;

import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchService.RevokeTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class fa
  implements cm
{
  fa(bk parambk) {}
  
  public dj a(int paramInt1, long paramLong, int paramInt2, JceStruct paramJceStruct)
  {
    if ((paramInt2 != 10010) || (paramJceStruct == null)) {
      return null;
    }
    Object localObject = ((ah)paramJceStruct).bo;
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    paramJceStruct = new w();
    paramJceStruct.aW = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    bk.a(this.a, ((ac)((List)localObject).get(0)).bg);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ac localac = (ac)((Iterator)localObject).next();
      if ((localac.bk == null) || (localac.bk.size() == 0))
      {
        paramJceStruct.aW.add(bk.a(this.a, localac.bg, localac.bh, null, 3));
      }
      else
      {
        Iterator localIterator = localac.bk.iterator();
        label185:
        label333:
        label343:
        for (;;)
        {
          z localz;
          ConchService.ConchPushInfo localConchPushInfo;
          SparseArray localSparseArray;
          if (localIterator.hasNext())
          {
            localz = (z)localIterator.next();
            localConchPushInfo = new ConchService.ConchPushInfo(localac.bg, localac.bh, localz);
            localStringBuilder.append(localz.cmdId + ";");
            localSparseArray = bk.b(this.a);
            if (localConchPushInfo.mRevokeInfo != null) {
              break label333;
            }
          }
          for (paramInt1 = localz.cmdId;; paramInt1 = localConchPushInfo.mRevokeInfo.mRevokeCmdId)
          {
            if ((ConchService.IConchPushListener)localSparseArray.get(paramInt1) == null) {
              break label343;
            }
            bk.a(this.a, localConchPushInfo);
            paramJceStruct.aW.add(bk.a(this.a, localac.bg, localac.bh, localz, 1));
            break label185;
            break;
          }
        }
      }
    }
    if (!TextUtils.isEmpty(localStringBuilder.toString())) {
      be.SaveStringData(1320064, localStringBuilder.toString());
    }
    return new dj(Long.valueOf(paramLong), Integer.valueOf(paramInt2), paramJceStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fa
 * JD-Core Version:    0.7.0.1
 */
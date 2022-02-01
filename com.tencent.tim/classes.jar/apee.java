import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController.1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class apee
{
  protected final aglb a;
  public final apee.a a;
  protected long ark;
  protected boolean cQc;
  protected boolean cQd;
  protected int cXA;
  protected int cXz;
  protected int dTQ;
  protected int dTR;
  protected int dTS = 3;
  protected int dTT = 3;
  protected int dTU = 3;
  protected int dTV = 30;
  protected Map<String, apee.b> nD = new HashMap();
  
  public apee(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString, long paramLong, boolean paramBoolean, apee.a parama)
  {
    this.jdField_a_of_type_Aglb = new aglb(paramQQAppInterface, paramList, paramString);
    if (paramBoolean) {
      this.jdField_a_of_type_Aglb.Jj(true);
    }
    this.jdField_a_of_type_Apee$a = parama;
    this.ark = paramLong;
  }
  
  public String Ba()
  {
    int i = 0;
    int j = 1;
    Object localObject1 = null;
    for (;;)
    {
      String str = this.jdField_a_of_type_Aglb.vg();
      if (!TextUtils.isEmpty(str))
      {
        this.nD.put(str, new apee.b());
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = str;
        }
        apef.b.i("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] retryContrller init:" + str);
        localObject1 = localObject2;
        i += 1;
      }
      while ((j == 0) || (i >= 4))
      {
        return localObject1;
        j = 0;
      }
    }
  }
  
  public int Ez()
  {
    return this.cXA;
  }
  
  public void SN(String paramString)
  {
    for (;;)
    {
      apee.b localb;
      try
      {
        localb = (apee.b)this.nD.get(paramString);
        if (localb == null) {
          return;
        }
        if (!this.cQd)
        {
          this.cQd = true;
          localb.reset();
          this.nD.clear();
          this.nD.put(paramString, localb);
          apef.b.i("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] data conned. lockedUseThisUrl:" + paramString);
          continue;
        }
        if (this.dTR > this.dTV) {
          continue;
        }
      }
      finally {}
      localb.reset();
      this.dTR += 1;
      apef.b.i("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] data conned. resetRetryInfo. resetcount:" + this.dTR);
    }
  }
  
  protected void a(apee.b paramb, int paramInt, boolean paramBoolean)
  {
    if (9056 == paramInt)
    {
      if (paramb.cXy < this.dTT)
      {
        paramb.cXy += 1;
        return;
      }
      paramb.cXy = 0;
      paramb.cXx += 1;
      this.dTQ += 1;
      return;
    }
    if (paramBoolean)
    {
      if (paramb.dTW < this.dTU)
      {
        paramb.dTW += 1;
        return;
      }
      paramb.dTW = 0;
      paramb.cXx += 1;
      this.dTQ += 1;
      return;
    }
    paramb.cXx += 1;
    this.dTQ += 1;
  }
  
  public boolean alZ()
  {
    return this.cQc;
  }
  
  public void dYS()
  {
    this.dTS = 3;
    this.dTT = 3;
    this.dTU = 0;
    this.dTV = 5;
  }
  
  protected String f(String paramString, int paramInt, boolean paramBoolean)
  {
    apee.b localb;
    try
    {
      localb = (apee.b)this.nD.get(paramString);
      if (localb == null)
      {
        apef.b.e("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] selectUrl err. not find strErrUrl. urlCont:" + this.nD.size());
        paramString = null;
      }
      for (;;)
      {
        return paramString;
        if (((9056 != paramInt) && (!paramBoolean)) || (localb.cXx >= this.dTS)) {
          break;
        }
        a(localb, paramInt, paramBoolean);
        apef.b.i("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] selectUrl:" + paramString + localb.toString() + " eof err or serr, use cur errurl");
      }
      localObject1 = new apee.b();
    }
    finally {}
    Object localObject1;
    ((apee.b)localObject1).cXx = 2147483647;
    ((apee.b)localObject1).cXy = 2147483647;
    ((apee.b)localObject1).dTW = 2147483647;
    Iterator localIterator = this.nD.entrySet().iterator();
    Object localObject2 = null;
    label216:
    Object localObject3;
    while (localIterator.hasNext())
    {
      Object localObject4 = (Map.Entry)localIterator.next();
      localObject3 = (String)((Map.Entry)localObject4).getKey();
      localObject4 = (apee.b)((Map.Entry)localObject4).getValue();
      apef.b.i("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "]" + (String)localObject3 + " <->" + ((apee.b)localObject4).toString());
      if (!paramString.equalsIgnoreCase((String)localObject3))
      {
        if (((apee.b)localObject4).cXx >= ((apee.b)localObject1).cXx) {
          break label580;
        }
        localObject2 = localObject4;
        localObject1 = localObject3;
        break label592;
      }
    }
    if ((localObject2 == null) || (((apee.b)localObject1).cXx >= this.dTS)) {
      if (localObject2 == null)
      {
        apef.b.w("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] no next url use cur errurl");
        break label607;
      }
    }
    for (;;)
    {
      if (((apee.b)localObject1).cXx < this.dTS)
      {
        a((apee.b)localObject1, paramInt, paramBoolean);
        apef.b.i("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] selectUrl:" + paramString + ((apee.b)localObject1).toString());
        break;
        apef.b.w("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] minurl retry over, use cur errurl. minRetryUrl:" + localObject2 + ((apee.b)localObject1).toString());
        break label607;
      }
      this.cQc = true;
      apef.b.e("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] all retry over and fail");
      paramString = null;
      break;
      paramString = localObject2;
      continue;
      label580:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      label592:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label216;
      label607:
      localObject1 = localb;
    }
  }
  
  public boolean g(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Apee$a == null)
    {
      apef.b.e("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] reqRetryOnErr fail. sink=null");
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      apef.b.e("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] reqRetryOnErr fail. strErrUrl=null");
      return false;
    }
    String str = f(paramString, paramInt, paramBoolean);
    if (TextUtils.isEmpty(str))
    {
      apef.b.e("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] reqRetryOnErr fail. all retry over or has err. errCode:" + paramInt + " bSvrErr:" + paramBoolean + " ReportR:" + this.cXA + "UrlChgedT:" + this.cXz + " strErrUrl:" + paramString);
      return false;
    }
    long l = 100L;
    if (9056 != paramInt) {
      l = this.jdField_a_of_type_Apee$a.hq();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new TroopFileTransferRetryController.1(this, str), l);
    this.cQc = false;
    this.cXA += 1;
    if (!paramString.equalsIgnoreCase(str)) {
      this.cXz += 1;
    }
    apef.b.i("TroopFileTransferRetryController", apef.b.USR, "[" + this.ark + "] reqRetryOnErr suc, delay:" + l + " errCode:" + paramInt + " bSvrErr:" + paramBoolean + " strErrUrl:" + paramString + " selectUrl:" + str + " ReportR:" + this.cXA + "UrlChgedT:" + this.cXz);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void SO(String paramString);
    
    public abstract long hq();
  }
  
  class b
  {
    int cXx = 0;
    int cXy = 0;
    int dTW = 0;
    
    public b()
    {
      reset();
    }
    
    public void reset()
    {
      this.cXx = 0;
      this.cXy = 0;
      this.dTW = 0;
    }
    
    public String toString()
    {
      return " retryInfo[AutoR-" + this.cXx + " EofR-" + this.cXy + " SvrErrR-" + this.dTW + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apee
 * JD-Core Version:    0.7.0.1
 */
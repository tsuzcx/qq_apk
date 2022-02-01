import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager.13;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class mfs
  extends mfl
{
  protected int aRf = 0;
  protected String afn = "";
  protected SparseArray<mfj[]> aj = new SparseArray();
  protected ArrayList<mfs.a> kT = new ArrayList();
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  
  public mfs(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    a(3, new mfj[] { new mfj(), new mft(this) });
    a(2, new mfj[] { new mfj(), new mfx(this) });
    a(4, new mfj[] { new mfy(this), new mfz(this, paramAppInterface) });
    a(5, new mfj[] { new mga(this), new mgb(this, paramAppInterface) });
    a(6, new mfj[] { new mgc(this), new mgd(this, paramAppInterface) });
    a(7, new mfj[] { new mge(this), new mfu(this, paramAppInterface) });
    a(8, new mfj[] { new mfv(this), new mfw(this) });
  }
  
  private void f(int paramInt, String paramString, boolean paramBoolean)
  {
    this.aRf = paramInt;
    this.afn = paramString;
    mfk.nC(this.afn);
    paramInt = 0;
    while (paramInt < this.kT.size())
    {
      ((mfs.a)this.kT.get(paramInt)).d(this.aRf, this.afn, paramBoolean);
      paramInt += 1;
    }
  }
  
  public String U(String paramString1, String paramString2)
  {
    if ("skin".equals(paramString1)) {
      return mfk.eP(paramString2);
    }
    if ("guide".equals(paramString1)) {
      return mfk.eQ(paramString2);
    }
    return mfk.eQ(paramString2);
  }
  
  public SkinData a(Context paramContext)
  {
    SkinData localSkinData = null;
    paramContext = aqmj.ai(paramContext, this.mApp.getCurrentAccountUin());
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramContext);
        if (paramContext != null) {
          localSkinData = new SkinData(paramContext);
        }
        return localSkinData;
      }
      catch (Exception paramContext)
      {
        paramContext = null;
        continue;
      }
      paramContext = null;
    }
  }
  
  public ErrorMessage a(int paramInt, String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    if ((!mfk.dS(paramString1)) && (!TextUtils.isEmpty(paramString1)))
    {
      QLog.i("ReadInJoySkinManager", 1, "skin is not valid skinId:" + paramString1 + " skinName:" + paramString2);
      return new ErrorMessage(-2, "please download skin first");
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new SkinData(paramString1, paramString3, paramLong1, (int)paramLong2, (int)paramLong3);
      paramLong1 = System.currentTimeMillis() / 1000L;
      if (paramLong1 < paramLong2)
      {
        QLog.i("ReadInJoySkinManager", 1, "current:" + paramLong1 + " startTime:" + paramLong2);
        return new ErrorMessage(-1, "time error");
      }
      if (paramLong1 >= paramLong3)
      {
        QLog.i("ReadInJoySkinManager", 1, "current:" + paramLong1 + " endTime:" + paramLong3);
        return new ErrorMessage(-1, "the skin is expired");
      }
    }
    for (;;)
    {
      boolean bool = aqmj.aJ(this.mApp.getApplication().getBaseContext(), this.mApp.getCurrentAccountUin());
      if ((this.afn.equals(paramString1)) && (paramBoolean == bool)) {
        return new ErrorMessage(-1, "your are already set the skin");
      }
      paramString3 = (mfo)this.mApp.getManager(270);
      Object localObject = paramString3.a(this.mApp.getApplication().getBaseContext(), 0);
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ("".equals(paramString1))
      {
        if (localObject != null)
        {
          ((RefreshData)localObject).isShown = true;
          aqmj.l(this.mApp.getApplication().getBaseContext(), this.mApp.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
          if ((i >= ((RefreshData)localObject).beginTime) && (i <= ((RefreshData)localObject).endTime))
          {
            paramString3.b(1, ((RefreshData)localObject).id, ((RefreshData)localObject).seq, 0);
            paramString3.nQ(true);
          }
        }
        aqmj.u(this.mApp.getApplication().getBaseContext(), this.mApp.getCurrentAccountUin(), paramBoolean);
        paramString3 = this.mApp.getApplication().getBaseContext();
        localObject = this.mApp.getCurrentAccountUin();
        if (paramString2 == null) {
          break label512;
        }
      }
      label512:
      for (paramString2 = paramString2.toJson().toString();; paramString2 = null)
      {
        aqmj.ag(paramString3, (String)localObject, paramString2);
        e(paramInt, paramString1, false);
        return new ErrorMessage();
        if (localObject == null) {
          break;
        }
        ((RefreshData)localObject).isShown = false;
        aqmj.l(this.mApp.getApplication().getBaseContext(), this.mApp.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
        break;
      }
      paramString2 = null;
    }
  }
  
  public mfj a(int paramInt)
  {
    mfj[] arrayOfmfj = (mfj[])this.aj.get(paramInt);
    if ((arrayOfmfj != null) && (this.aRf < arrayOfmfj.length)) {
      return arrayOfmfj[this.aRf];
    }
    return null;
  }
  
  public void a(int paramInt, mfj... paramVarArgs)
  {
    this.aj.put(paramInt, paramVarArgs);
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData)
  {
    aqmj.v(paramContext, paramString, paramBaseResData.seq);
  }
  
  public void a(mfs.a parama)
  {
    synchronized (this.kT)
    {
      if (!this.kT.contains(parama)) {
        this.kT.add(parama);
      }
      return;
    }
  }
  
  public boolean a(GuideData paramGuideData)
  {
    return super.c("guide", paramGuideData);
  }
  
  public boolean a(SkinData paramSkinData)
  {
    return super.c("skin", paramSkinData);
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    return (pg() != 1) || (!paramBaseResData.id.equals(jM()));
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, aquy paramaquy)
  {
    paramString1 = new SkinData(paramString1, paramString3, paramLong1, (int)paramLong2, (int)paramLong3);
    paramString2 = a(this.mApp.getApplication().getBaseContext());
    if ((paramString2 != null) && (paramString2.id.equals(paramString1.id)) && (paramString2.seq != paramString1.seq) && (!this.afn.equals(paramString1.id))) {
      aqhq.cn(mfk.eP(paramString2.id));
    }
    a(paramaquy);
    return super.a("skin", paramString1, 3);
  }
  
  public String aZ(String paramString)
  {
    if ("skin".equals(paramString)) {
      return mfk.getResPath();
    }
    if ("guide".equals(paramString)) {
      return mfk.jH();
    }
    return mfk.jH();
  }
  
  public void b(String paramString, BaseResData paramBaseResData)
  {
    aqmj.ah(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramBaseResData.id);
    aqmj.cQ(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
  }
  
  public void b(mfs.a parama)
  {
    synchronized (this.kT)
    {
      this.kT.remove(parama);
      return;
    }
  }
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    paramString = U(paramString, paramBaseResData.id);
    long l1 = aqmj.q(this.mApp.getApp(), this.mApp.getCurrentAccountUin()) / 86400000L;
    long l2 = System.currentTimeMillis() / 86400000L;
    return (anyk.E(new File(paramString))) && (mfk.dS(paramBaseResData.id)) && (!aqmj.t(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramBaseResData.id)) && (l2 > l1);
  }
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    if ((paramBaseResData instanceof GuideData)) {
      return a((GuideData)paramBaseResData) & true & a(((GuideData)paramBaseResData).skinData);
    }
    return true;
  }
  
  public void clearData()
  {
    this.aRf = 0;
    this.afn = "";
  }
  
  public boolean dT(String paramString)
  {
    paramString = (String)this.ed.remove("skin_" + paramString);
    if (paramString != null)
    {
      this.c.a(false, paramString);
      return true;
    }
    return false;
  }
  
  public void e(int paramInt, String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      f(paramInt, paramString, paramBoolean);
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoySkinManager.13(this, paramInt, paramString, paramBoolean));
  }
  
  public String jM()
  {
    return this.afn;
  }
  
  public void onDestroy()
  {
    this.kT.clear();
  }
  
  public int pg()
  {
    return this.aRf;
  }
  
  public void q(String[] paramArrayOfString)
  {
    anot.a(null, "dc00899", "BizTechReport", "", "skin_download", "skin_guide", 0, 0, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], String.valueOf(aqiw.getSystemNetwork(this.mApp.getApplication())));
  }
  
  public static abstract interface a
  {
    public abstract void d(int paramInt, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfs
 * JD-Core Version:    0.7.0.1
 */
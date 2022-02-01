import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class tbj
{
  private String aIN;
  private String aIO;
  private String aIP;
  private HashMap<String, String> gt;
  private AppInterface mApp;
  private List<String> mParamList;
  
  public tbj(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  public boolean NF()
  {
    if ((TextUtils.isEmpty(this.aIN)) && (TextUtils.isEmpty(this.aIO)) && (TextUtils.isEmpty(this.aIP)) && ((this.gt == null) || (this.gt.size() == 0))) {
      return false;
    }
    for (;;)
    {
      try
      {
        if (this.mParamList == null) {
          this.mParamList = new ArrayList();
        }
        this.mParamList.clear();
        long l = NetConnInfoCenter.getServerTime();
        this.mParamList.add(String.valueOf(l));
        this.mParamList.add("1");
        this.mParamList.add("3.4.4");
        this.mParamList.add("");
        this.mParamList.add("2");
        this.mParamList.add(Build.BRAND);
        int j = jqc.getNetWorkType();
        if (j >= 0)
        {
          i = j;
          if (j < acbn.dQ.length)
          {
            this.mParamList.add(acbn.dQ[i]);
            Object localObject2 = "";
            Object localObject1 = localObject2;
            if (this.mApp != null)
            {
              BaseApplication localBaseApplication = this.mApp.getApp();
              localObject1 = localObject2;
              if (localBaseApplication != null)
              {
                localObject1 = localBaseApplication.getResources().getDisplayMetrics();
                localObject1 = ((DisplayMetrics)localObject1).widthPixels + "*" + ((DisplayMetrics)localObject1).heightPixels;
              }
            }
            this.mParamList.add(localObject1);
            this.mParamList.add("0");
            this.mParamList.add("0");
            this.mParamList.add("1");
            this.mParamList.add(this.aIN);
            this.mParamList.add(this.aIO);
            this.mParamList.add("0");
            this.mParamList.add(this.aIP);
            a(14, Build.MODEL);
            a(15, Build.VERSION.RELEASE);
            if ((this.gt != null) && (this.gt.size() > 0))
            {
              i = 1;
              if (i <= 40)
              {
                localObject1 = String.valueOf(i);
                localObject2 = this.mParamList;
                if (!this.gt.containsKey(localObject1)) {
                  break label495;
                }
                localObject1 = (String)this.gt.get(localObject1);
                ((List)localObject2).add(localObject1);
                i += 1;
                continue;
              }
            }
            avdb.b(null, "dc00087", this.mParamList);
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      int i = 0;
      continue;
      label495:
      String str = "";
    }
  }
  
  public tbj a(int paramInt, String paramString)
  {
    if ((paramInt >= 1) && (paramInt <= 40))
    {
      if (this.gt == null) {
        this.gt = new HashMap();
      }
      this.gt.put(String.valueOf(paramInt), paramString);
    }
    return this;
  }
  
  public tbj a(String paramString)
  {
    this.aIN = paramString;
    return this;
  }
  
  public tbj b(String paramString)
  {
    this.aIO = paramString;
    return this;
  }
  
  public tbj c(String paramString)
  {
    this.aIP = paramString;
    return this;
  }
  
  public tbj d(String paramString)
  {
    return a(4, paramString);
  }
  
  public tbj e(String paramString)
  {
    return a(1, paramString);
  }
  
  public tbj f(String paramString)
  {
    return a(11, paramString);
  }
  
  public tbj g(String paramString)
  {
    return a(12, paramString);
  }
  
  public tbj h(String paramString)
  {
    return a(35, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tbj
 * JD-Core Version:    0.7.0.1
 */
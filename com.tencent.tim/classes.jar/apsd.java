import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileError.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class apsd
{
  public static WeakReference<apsd.c> ii = new WeakReference(null);
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt, Object... paramVarArgs)
  {
    return String.format(h(paramQQAppInterface, paramInt), paramVarArgs);
  }
  
  public static void a(apsd.a parama, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((parama == null) || (paramContext == null)) {
      return;
    }
    if (!TextUtils.isEmpty(parama.cra))
    {
      y(paramContext, parama.cra, 1);
      return;
    }
    String str = apsv.oR(parama.cqZ);
    int i;
    switch (parama.errorCode)
    {
    default: 
      str = null;
      i = 0;
    }
    for (;;)
    {
      if ((parama.errorCode != 602) && (parama.errorCode != 604) && (parama.errorCode != 605)) {
        break label1264;
      }
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      awpl.b(paramQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
      str = h(paramQQAppInterface, 2131699903);
      i = 0;
      continue;
      str = h(paramQQAppInterface, 2131699827);
      i = 0;
      continue;
      r(paramContext, paramLong);
      str = null;
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131699997, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131699995, new Object[] { str });
      i = 0;
      continue;
      str = h(paramQQAppInterface, 2131699996);
      i = 0;
      continue;
      str = h(paramQQAppInterface, 2131699994);
      i = 1;
      continue;
      str = h(paramQQAppInterface, 2131699998);
      i = 2;
      continue;
      str = a(paramQQAppInterface, 2131699524, new Object[] { str });
      i = 0;
      continue;
      str = h(paramQQAppInterface, 2131699522);
      i = 0;
      continue;
      str = h(paramQQAppInterface, 2131699523);
      i = 1;
      continue;
      str = h(paramQQAppInterface, 2131699990);
      i = 1;
      continue;
      str = h(paramQQAppInterface, 2131700018);
      anot.a(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131700016, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131700011, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131699953, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131700013, new Object[] { str });
      i = 0;
      continue;
      str = a(paramQQAppInterface, 2131700012, new Object[] { str });
      i = 0;
      continue;
      str = h(paramQQAppInterface, 2131699903);
      i = 1;
      continue;
      str = h(paramQQAppInterface, 2131699580);
      i = 1;
      continue;
      str = h(paramQQAppInterface, 2131699581);
      i = 0;
      continue;
      str = h(paramQQAppInterface, 2131699541);
      i = 1;
      continue;
      str = h(paramQQAppInterface, 2131699537);
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131699539, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131699540, new Object[] { str });
      i = 1;
      continue;
      str = a(paramQQAppInterface, 2131699538, new Object[] { str });
      i = 0;
      continue;
      if (apbr.a.lY(parama.status))
      {
        str = a(paramQQAppInterface, 2131700010, new Object[] { str });
        i = 1;
      }
      else
      {
        str = a(paramQQAppInterface, 2131699536, new Object[] { str });
        i = 1;
        continue;
        str = h(paramQQAppInterface, 2131699990);
        i = 1;
        continue;
        str = h(paramQQAppInterface, 2131699594);
        i = 0;
        continue;
        str = h(paramQQAppInterface, 2131699595);
        i = 0;
        continue;
        str = h(paramQQAppInterface, 2131699598);
        i = 2;
        continue;
        str = h(paramQQAppInterface, 2131699599);
        i = 1;
        continue;
        str = parama.cra;
        i = 0;
        continue;
        str = h(paramQQAppInterface, 2131699600);
        i = 1;
        continue;
        str = h(paramQQAppInterface, 2131699602);
        i = 0;
        continue;
        str = h(paramQQAppInterface, 2131699601);
        i = 0;
        continue;
        str = h(paramQQAppInterface, 2131699603);
        i = 1;
        continue;
        if (!TextUtils.isEmpty(parama.cra))
        {
          str = parama.cra;
          i = 0;
        }
        else
        {
          str = h(paramQQAppInterface, 2131699604);
          i = 0;
          continue;
          str = h(paramQQAppInterface, 2131699597);
          i = 2;
          continue;
          str = h(paramQQAppInterface, 2131699596);
          i = 0;
        }
      }
    }
    label1264:
    if ((parama.errorCode == 601) || (parama.errorCode == 605) || (parama.errorCode == 802) || (parama.errorCode == 604) || (parama.errorCode == 702))
    {
      a(paramQQAppInterface, paramContext, str, i);
      return;
    }
    y(paramContext, str, i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramInt2 == 0)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("reportSimpleError==> troopUin:");
        localStringBuilder.append(paramLong).append(",filename:").append(paramString).append(",status:").append(paramInt1).append(",errorCode:").append(paramInt2);
        QLog.e("TroopFileError", 2, localStringBuilder.toString());
      }
      paramQQAppInterface = (accc)paramQQAppInterface.getBusinessHandler(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.aR(new apsd.a(paramString, paramLong, paramInt1, paramInt2));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (awou.aNn())
    {
      if (awou.aNo()) {
        awou.eZ(paramQQAppInterface);
      }
    }
    else {
      return;
    }
    y(paramContext, paramString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, apsd.a parama)
  {
    if ((paramQQAppInterface == null) || (parama == null) || (parama.errorCode == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (accc)paramQQAppInterface.getBusinessHandler(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.aR(parama);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, apsd.c paramc)
  {
    if ((ii != null) && (ii.get() != null))
    {
      paramQQAppInterface.removeObserver((acci)ii.get());
      ii = null;
    }
    ii = new WeakReference(paramc);
    paramQQAppInterface.addObserver(paramc);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, apsd.c paramc)
  {
    paramQQAppInterface.removeObserver(paramc);
    if ((ii != null) && (ii.get() == paramc)) {
      ii = null;
    }
  }
  
  public static void ck(Context paramContext, String paramString)
  {
    y(paramContext, paramString, 0);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramLong, null, paramInt1, paramInt2);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    d(paramQQAppInterface, paramLong, 7, paramInt);
  }
  
  private static String h(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramQQAppInterface.getApplication().getResources().getString(paramInt);
  }
  
  private static void r(Context paramContext, long paramLong)
  {
    apse localapse = new apse(paramLong);
    aqha.a(paramContext, 230, paramContext.getResources().getString(2131699825), paramContext.getResources().getString(2131699826), 2131699879, 2131699508, localapse, localapse).show();
  }
  
  public static void y(Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i;
    try
    {
      i = paramContext.getResources().getDimensionPixelSize(2131299627);
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        new Handler(Looper.getMainLooper()).post(new TroopFileError.1(paramContext, paramInt, paramString, i));
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("TroopFileError", 1, "showTipsToast error!", paramContext);
      return;
    }
    QQToast.a(paramContext, paramInt, paramString, 0).show(i);
  }
  
  public static class a
  {
    public String cqZ;
    public String cra;
    public int errorCode = 0;
    public int status;
    public long troopUin;
    
    public a(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      this.cqZ = paramString;
      this.troopUin = paramLong;
      this.errorCode = paramInt2;
      this.status = paramInt1;
    }
    
    public a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
    {
      this.cqZ = paramString1;
      this.troopUin = paramLong;
      this.errorCode = paramInt2;
      this.status = paramInt1;
      this.cra = paramString2;
    }
  }
  
  public static abstract interface b
  {
    public abstract long er();
  }
  
  public static class c
    extends accd
  {
    private apsd.b a;
    private QQAppInterface app;
    int bjJ = 0;
    private WeakReference<Context> context;
    private long troopUin;
    
    public c(Context paramContext, long paramLong, QQAppInterface paramQQAppInterface)
    {
      this.context = new WeakReference(paramContext);
      this.troopUin = paramLong;
      this.app = paramQQAppInterface;
      this.bjJ = 0;
    }
    
    public c(Context paramContext, apsd.b paramb, QQAppInterface paramQQAppInterface)
    {
      this.context = new WeakReference(paramContext);
      this.a = paramb;
      this.app = paramQQAppInterface;
      this.bjJ = 0;
    }
    
    protected void aK(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof apsd.a))) {}
      Context localContext;
      long l1;
      do
      {
        return;
        paramObject = (apsd.a)paramObject;
        localContext = (Context)this.context.get();
        long l2 = this.troopUin;
        l1 = l2;
        if (l2 == 0L)
        {
          l1 = l2;
          if (this.a != null) {
            l1 = this.a.er();
          }
        }
      } while (localContext == null);
      apsd.a(paramObject, l1, this.app, localContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsd
 * JD-Core Version:    0.7.0.1
 */
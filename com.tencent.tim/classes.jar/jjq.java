import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class jjq
{
  private static jjq jdField_a_of_type_Jjq = new jjq();
  private jjq.b jdField_a_of_type_Jjq$b;
  public int aAr = -1;
  private acnd b = new jjr(this);
  private Map<String, jjq.c> dj = new HashMap();
  private aure<jjq.a> e = new aure();
  private long mLastRequestTime;
  
  public static jjq a()
  {
    return jdField_a_of_type_Jjq;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    aqha.a(paramContext, 230, paramString1, paramString2, 2131697803, 2131697805, new jjs(paramContext), paramOnClickListener).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("GroupId");
    a().a(paramQQAppInterface, str, new jjt(paramQQAppInterface, paramContext, paramIntent, str));
  }
  
  private static void bA(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AboutActivity.class);
    if ((paramContext instanceof Activity))
    {
      if (!((Activity)paramContext).isFinishing()) {}
    }
    else {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, jjq.a parama)
  {
    Object localObject = (jjq.c)this.dj.get(paramString);
    if ((localObject != null) && (SystemClock.elapsedRealtime() - ((jjq.c)localObject).mLastRequestTime < 60000L)) {
      parama.a(((jjq.c)localObject).aAs, (jjq.c)localObject, 1000);
    }
    do
    {
      return;
      localObject = (acms)paramAppInterface.getBusinessHandler(20);
      if (localObject != null)
      {
        paramAppInterface.addObserver(this.b);
        long l = ((acms)localObject).e(jlk.c(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
        this.e.put(l, parama);
        return;
      }
      parama.a(-1, null, -1);
    } while (!QLog.isColorLevel());
    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
  }
  
  public void a(AppInterface paramAppInterface, String paramString, jjq.b paramb)
  {
    this.jdField_a_of_type_Jjq$b = paramb;
    if ((this.aAr != -1) && (SystemClock.elapsedRealtime() - this.mLastRequestTime < 7200000L)) {
      paramb.onResult(this.aAr);
    }
    do
    {
      return;
      paramb = (acms)paramAppInterface.getBusinessHandler(20);
    } while (paramb == null);
    paramAppInterface.addObserver(this.b);
    paramb.e(jlk.c(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
  }
  
  public void axn()
  {
    this.jdField_a_of_type_Jjq$b = null;
  }
  
  public void axo()
  {
    this.jdField_a_of_type_Jjq$b = null;
    this.e.clear();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, jjq.c paramc, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void onResult(int paramInt);
  }
  
  public static class c
  {
    public String Sy;
    public String Sz;
    public int aAs = -1;
    public long mLastRequestTime;
    public String url;
    
    public c(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3)
    {
      this.mLastRequestTime = paramLong;
      this.aAs = paramInt;
      this.url = paramString1;
      this.Sy = paramString2;
      this.Sz = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jjq
 * JD-Core Version:    0.7.0.1
 */
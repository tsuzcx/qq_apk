import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aryb
{
  protected static aryb a;
  
  public static aryb a()
  {
    try
    {
      if (a == null) {
        a = new aryb();
      }
      aryb localaryb = a;
      return localaryb;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      aroi.a().setUin(Integer.valueOf(paramString1).intValue());
      label14:
      Object localObject = aryc.Dz();
      String str = String.valueOf(aroi.a().getUin());
      if (!((String)localObject).equals(str))
      {
        arye.a().a((String)localObject, new arya(), null, true, paramBoolean2);
        aryc.Xq(str);
      }
      localObject = new arya();
      ((arya)localObject).actionType = paramString4;
      ((arya)localObject).appId = paramString2;
      ((arya)localObject).network = arwo.bE(aroi.a().getContext());
      ((arya)localObject).qua = paramString5;
      ((arya)localObject).uin = paramString1;
      ((arya)localObject).via = paramString3;
      ((arya)localObject).aIR = String.valueOf(System.currentTimeMillis());
      if (!TextUtils.isEmpty(paramString6)) {
        ((arya)localObject).cDm = paramString6;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenSdkStatic", 2, "reprotInfo = " + ((arya)localObject).toString());
      }
      arye.a().a(str, (arya)localObject, paramBundle, paramBoolean1, paramBoolean2);
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString1, paramString2, paramString3, paramString4, aroi.a().getQUA3(), null, paramString5, paramBoolean1, paramBoolean2);
  }
  
  public void b(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong, int paramInt2, int paramInt3, String paramString5)
  {
    long l = SystemClock.elapsedRealtime() - paramLong.longValue();
    if ((paramLong.longValue() == 0L) || (l < 0L)) {
      l = 0L;
    }
    for (;;)
    {
      paramLong = new StringBuffer("https://c.isdspeed.qq.com/code.cgi");
      paramLong.append("?domain=mobile.opensdk.com&cgi=opensdk&type=").append(paramInt1).append("&code=").append(paramInt2).append("&time=").append(l).append("&rate=").append(paramInt3).append("&uin=").append(paramString2).append("&data=");
      paramString1 = artw.a(String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(l), String.valueOf(paramInt3), paramString1, paramString2, paramString3, paramString4, paramString5);
      arts.a().a(paramLong.toString(), "GET", paramString1, true);
      return;
    }
  }
  
  public void d(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, aroi.a().getQUA3(), null, "", paramBoolean, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aryb
 * JD-Core Version:    0.7.0.1
 */
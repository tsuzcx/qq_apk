import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

class yft
  extends AccountObserver
{
  yft(yfq paramyfq) {}
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2)
  {
    int i;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onRefrshDA2 result: ").append(paramBoolean).append(", da2 length: ");
      if (paramString2 == null)
      {
        i = 0;
        QLog.d("C2CMsgRoamProxy", 2, i);
      }
    }
    else
    {
      if ((!paramBoolean) || (TextUtils.isEmpty(paramString2))) {
        break label98;
      }
      i = 1;
      label64:
      if (i == 0) {
        break label104;
      }
      yfq.a(this.a, true);
    }
    for (;;)
    {
      yfq.c(this.a).chT();
      return;
      i = paramString2.length();
      break;
      label98:
      i = 0;
      break label64;
      label104:
      yfq.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yft
 * JD-Core Version:    0.7.0.1
 */
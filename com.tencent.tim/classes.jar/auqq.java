import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.wxapi.WXApiHelper;
import java.io.File;

public class auqq
  extends AsyncTask<Void, Void, Void>
{
  public auqq(WXApiHelper paramWXApiHelper, String paramString, QQAppInterface paramQQAppInterface) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    int j = 1;
    int k = 0;
    for (;;)
    {
      try
      {
        paramVarArgs = this.this$0.rs(this.bhf);
        QLog.i("WXApiHelper", 1, "1. downloadWxHead with url" + paramVarArgs);
        i = k;
        if (WXApiHelper.a(this.this$0, paramVarArgs))
        {
          paramVarArgs = new File(WXApiHelper.access$100());
          if (!paramVarArgs.exists()) {
            continue;
          }
          l = paramVarArgs.length();
          if ((l <= 0L) || (l >= 1749600L)) {
            continue;
          }
          i = j;
        }
      }
      catch (Exception paramVarArgs)
      {
        int i;
        long l;
        if (!QLog.isColorLevel()) {
          break label257;
        }
        QLog.d("WXApiHelper", 2, "setWxHeadToTim e = " + paramVarArgs);
        return null;
        QLog.i("WXApiHelper", 1, "2. downloadWxHead with url" + this.bhf);
        if (!WXApiHelper.a(this.this$0, this.bhf)) {
          break label257;
        }
        aqep.a(this.val$app, WXApiHelper.access$100(), null);
        return null;
        continue;
      }
      if (i == 0) {
        continue;
      }
      aqep.a(this.val$app, WXApiHelper.access$100(), null);
      return null;
      QLog.w("WXApiHelper", 1, " wxhead too big. len:" + l);
      i = 0;
      continue;
      QLog.w("WXApiHelper", 1, "wxhead not exsited");
      i = k;
    }
    label257:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqq
 * JD-Core Version:    0.7.0.1
 */
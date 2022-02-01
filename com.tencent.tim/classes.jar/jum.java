import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.b;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class jum
  implements PhotoWallViewForAccountDetail.b
{
  jum(juk paramjuk) {}
  
  public void d(jzs.a parama)
  {
    if (parama == null) {}
    label680:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    String str = parama.url;
                    localObject = str;
                    if (str == null) {
                      localObject = "";
                    }
                    kbp.a(this.b.app, "P_CliOper", "Pb_account_lifeservice", this.b.mUin, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
                    if (parama.type != 3) {
                      break label680;
                    }
                    if (parama.aGH != 7) {
                      break;
                    }
                  } while ((TextUtils.isEmpty(parama.lat)) || (TextUtils.isEmpty(parama.lng)) || (TextUtils.isEmpty(parama.content)));
                  Object localObject = new Intent((Context)this.b.mActivity.get(), QQMapActivity.class);
                  ((Intent)localObject).putExtra("lat", parama.lat);
                  ((Intent)localObject).putExtra("lon", parama.lng);
                  ((Intent)localObject).putExtra("loc", parama.content);
                  ((BaseActivity)this.b.mActivity.get()).startActivity((Intent)localObject);
                  return;
                  if (parama.aGH != 8) {
                    break;
                  }
                  parama = parama.Vq;
                } while (TextUtils.isEmpty(parama));
                parama = parama.trim();
              } while (!Pattern.compile("[\\d-]+?").matcher(parama).matches());
              juk.b(this.b, parama);
              return;
            } while (parama.aGH == 13);
            if (parama.aGH == 11)
            {
              parama = new Intent((Context)this.b.mActivity.get(), ScannerActivity.class);
              parama.putExtra("from", this.b.mActivity.getClass().getName());
              parama.putExtra("finishAfterSucc", true);
              ((BaseActivity)this.b.mActivity.get()).startActivity(parama);
              return;
            }
          } while (parama.aGH == 16);
          if (parama.aGH == 20)
          {
            juk.a(this.b);
            return;
          }
          if (parama.aGH == 2)
          {
            smu.b((Activity)this.b.mActivity.get(), new smu.a(this.b.mUin, this.b.a.name, this.b.a.summary), 1, juk.a(this.b));
            return;
          }
          if (parama.aGH == 17)
          {
            smu.a((BaseActivity)this.b.mActivity.get(), new smu.a(this.b.mUin, this.b.a.name, this.b.a.summary), 1, juk.a(this.b));
            return;
          }
          if (parama.aGH == 19)
          {
            smu.a((BaseActivity)this.b.mActivity.get(), new smu.a(this.b.mUin, this.b.a.name, this.b.a.summary), 1, juk.a(this.b), 9);
            return;
          }
          if (parama.aGH == 18)
          {
            smu.a((BaseActivity)this.b.mActivity.get(), new smu.a(this.b.mUin, this.b.a.name, this.b.a.summary), 1, juk.a(this.b), 10);
            return;
          }
        } while (parama.aGH == 21);
        if (parama.aGH == 22)
        {
          parama = parama.url;
          juk.c(this.b, parama);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + parama.aGH);
      return;
    } while (parama.type != 1);
    parama = parama.url;
    juk.c(this.b, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jum
 * JD-Core Version:    0.7.0.1
 */
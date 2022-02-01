import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.VipBannerInfo.2;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class altv
  implements altq.a
{
  public altv(VipBannerInfo.2 param2) {}
  
  public boolean a(altu paramaltu)
  {
    if (paramaltu == null) {}
    label98:
    label357:
    label362:
    label368:
    label372:
    for (;;)
    {
      return false;
      Object localObject = (QQAppInterface)this.a.aT.get();
      if (localObject != null)
      {
        int i;
        int j;
        int k;
        if (1 == paramaltu.dxz)
        {
          this.a.v.edit().putLong("blue_banner_time_out" + ((QQAppInterface)localObject).getAccount(), System.currentTimeMillis() + paramaltu.duration).commit();
          paramaltu.leftTime = paramaltu.duration;
          i = 1;
          if (paramaltu.c == null) {
            break label350;
          }
          m = paramaltu.type;
          if ((1 != paramaltu.c.iNewFlag.get()) || (i == 0) || (TextUtils.isEmpty(paramaltu.content)) || (m < 1) || (m > 4)) {
            continue;
          }
          if ((1 != m) || (VipUtils.cf((QQAppInterface)localObject))) {
            break label352;
          }
          i = 1;
          if ((2 != m) || (VipUtils.ce((QQAppInterface)localObject))) {
            break label357;
          }
          j = 1;
          if ((3 != m) || (!VipUtils.cf((QQAppInterface)localObject))) {
            break label362;
          }
          k = 1;
          if ((4 != m) || (!VipUtils.ce((QQAppInterface)localObject))) {
            break label368;
          }
        }
        for (int m = 1;; m = 0)
        {
          if ((i == 0) && (j == 0) && (k == 0) && (m == 0)) {
            break label372;
          }
          this.a.a.removeMessages(9);
          localObject = this.a.a.obtainMessage(8, paramaltu);
          ((Message)localObject).obj = paramaltu;
          this.a.a.sendMessage((Message)localObject);
          return true;
          long l = this.a.v.getLong("blue_banner_time_out" + ((QQAppInterface)localObject).getAccount(), -1L);
          if (l > System.currentTimeMillis())
          {
            paramaltu.leftTime = (l - System.currentTimeMillis());
            i = 1;
            break label98;
          }
          i = 0;
          break label98;
          break;
          i = 0;
          break label167;
          j = 0;
          break label183;
          k = 0;
          break label200;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altv
 * JD-Core Version:    0.7.0.1
 */
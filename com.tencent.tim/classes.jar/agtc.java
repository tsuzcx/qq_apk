import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class agtc
  implements ahav.f
{
  agtc(agtb paramagtb, long paramLong, boolean paramBoolean, String paramString1, Bundle paramBundle, short paramShort, String paramString2, String paramString3) {}
  
  public void JC(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      new HashMap().put("shouq_bus_type", "bus_type_video_file");
      this.a.jdField_a_of_type_Agkw$a.dhA();
      return;
    }
    if (this.val$retCode == -100001L) {}
    while ((this.bHQ == null) || (this.bHQ.length() == 0))
    {
      long l = 9360L;
      if (this.val$retCode == 0L) {
        l = 9048L;
      }
      this.a.jdField_a_of_type_Agkw$a.onError((int)l, BaseApplication.getContext().getResources().getString(2131691792));
      return;
      if ((this.val$retCode == -25081L) || (this.val$retCode == -6101L) || (this.val$retCode == -7003L))
      {
        this.a.jdField_a_of_type_Agta.JB(true);
        this.a.jdField_a_of_type_Agkw$a.onError((int)this.val$retCode, BaseApplication.getContext().getResources().getString(2131694161));
        return;
      }
      if (!this.val$isSuccess)
      {
        this.a.jdField_a_of_type_Agkw$a.onError((int)9045L, BaseApplication.getContext().getResources().getString(2131691792));
        return;
      }
    }
    String str1 = this.bHQ;
    String str2 = "";
    if (this.aQ != null) {
      str2 = this.aQ.getString("IPv6Dns", "");
    }
    Object localObject = str1;
    if (!TextUtils.isEmpty(str2))
    {
      localObject = str1;
      if (agke.a().l(this.a.jdField_a_of_type_Agta.mApp, 1))
      {
        QLog.i("VideoForC2C<QFile>", 1, "[IPv6-File] offlineVideo download. is config enable IPv6. domain[" + str2 + "]");
        localObject = new agke.a(str2, this.ai);
        localObject = agke.a().a(this.a.jdField_a_of_type_Agta.mApp, (agke.a)localObject, 1);
        if ((localObject == null) || (((agke.c)localObject).alz())) {
          break label521;
        }
        localObject = (agke.b)((agke.c)localObject).Bb.get(0);
        if ((localObject == null) || (TextUtils.isEmpty(((agke.b)localObject).mIp))) {
          break label536;
        }
        str1 = ((agke.b)localObject).mIp;
        QLog.i("VideoForC2C<QFile>", 1, "[IPv6-File] offlineVideo download. use IPv6. hostlist:" + str1);
      }
    }
    label521:
    label536:
    for (;;)
    {
      for (localObject = str1;; localObject = str1)
      {
        str1 = this.bHP;
        localObject = "http://" + (String)localObject + ":" + String.valueOf(this.ai) + this.val$strUrl;
        QLog.i("VideoForC2C<QFile>", 1, "offlineVideo download. downloadUrl:" + (String)localObject);
        this.a.jdField_a_of_type_Agkw$a.fH((String)localObject, str1);
        return;
        QLog.i("VideoForC2C<QFile>", 1, "[IPv6-File] offlineVideo download. use IPv4");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agtc
 * JD-Core Version:    0.7.0.1
 */
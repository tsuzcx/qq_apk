import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.a;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.b;
import com.tencent.qphone.base.util.BaseApplication;

class apcr
  extends accd
{
  apcr(apcq paramapcq) {}
  
  protected void aU(Object paramObject)
  {
    TroopFileTransferManager.b localb = (TroopFileTransferManager.b)paramObject;
    Object localObject1 = localb.retMsg;
    if (!aqiw.isNetworkAvailable(this.a.app.getApp())) {
      localObject1 = this.a.app.getApp().getString(2131693819);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 1) {}
    }
    else
    {
      localObject2 = this.a.app.getApp().getString(2131695453);
    }
    if (agmx.cen)
    {
      localb.bGu = "183.61.37.13";
      localb.bGv = "443";
    }
    if ((apsv.bS(this.a.app)) && (!TextUtils.isEmpty(localb.httpsDomain)))
    {
      short s2 = localb.ah;
      short s1 = s2;
      if (s2 == 0) {
        s1 = 443;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("ishttps", true);
      ((Bundle)localObject1).putString("httpsdomain", localb.httpsDomain);
      ((Bundle)localObject1).putShort("httpsport", s1);
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.a(localb.cew, localb.bGu, localb.bGv, localb.retCode, (String)localObject2, localb.downloadKey, null, localb.strId, (Bundle)localObject1);
      }
      super.aU(paramObject);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apcr
 * JD-Core Version:    0.7.0.1
 */
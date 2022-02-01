import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.b;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class apfc
  extends smq.m
{
  apfc(apfb paramapfb) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (!paramBundle.getBoolean("isPreview", false)) {}
    do
    {
      do
      {
        return;
      } while (paramBundle.getLong("troopUin") != this.a.mTroopUin);
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    TroopFileTransferManager.b localb = new TroopFileTransferManager.b();
    localb.retCode = -1;
    try
    {
      localb.strId = this.a.a().toString();
      localQQAppInterface = apef.getApp();
      if (localQQAppInterface == null)
      {
        apef.b.e("TroopFilePreviewWorker", apef.b.USR, "[" + this.a.coy + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localb.strId = null;
      }
      accc localaccc = (accc)localQQAppInterface.getBusinessHandler(22);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        apef.b.e("TroopFilePreviewWorker", apef.b.USR, "[" + this.a.coy + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        apsd.e(localQQAppInterface, this.a.mTroopUin, 700);
        localb.cew = false;
        localaccc.aS(localb);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localb.retCode = paramInt;
      localb.cew = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localb.bGu = str;
      if ((TextUtils.isEmpty(localb.bGu)) || (localb.bGu.equals("0.0.0.0"))) {
        localb.bGu = paramBundle;
      }
      localb.bGv = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localb.retMsg = paramDownloadFileRspBody.str_ret_msg.get();
      localb.downloadKey = aqhs.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localb.httpsDomain = paramBundle;
      if (paramInt < 0)
      {
        apef.b.e("TroopFilePreviewWorker", apef.b.USR, "[" + this.a.coy + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localb.retMsg);
        apsd.e(localQQAppInterface, this.a.mTroopUin, 700);
        if (TextUtils.isEmpty(localb.retMsg)) {
          localb.retMsg = acfp.m(2131715704);
        }
        localb.cew = false;
        localaccc.aS(localb);
        return;
      }
      apef.b.i("TroopFilePreviewWorker", apef.b.USR, "[" + this.a.coy + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localb.bGv + " downloadKey:" + localb.downloadKey + " retMsg:" + localb.retMsg + " httpsDomain:" + localb.httpsDomain);
      localb.cew = true;
      localaccc.aS(localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfc
 * JD-Core Version:    0.7.0.1
 */
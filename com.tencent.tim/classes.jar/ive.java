import com.tencent.av.ReqGroupVideo.ReqCreateShareUrl;
import com.tencent.av.ReqGroupVideo.RspCreateShareUrl;
import com.tencent.av.common.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class ive
  extends ijl.b<ReqGroupVideo.ReqCreateShareUrl, ReqGroupVideo.RspCreateShareUrl>
{
  ive(ivc paramivc) {}
  
  public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqCreateShareUrl paramReqCreateShareUrl, ReqGroupVideo.RspCreateShareUrl paramRspCreateShareUrl, Object paramObject)
  {
    this.a.gV = false;
    paramReqCreateShareUrl = paramRspCreateShareUrl.share_url_with_no_sig.get().toStringUtf8();
    paramObject = paramRspCreateShareUrl.share_url.get().toStringUtf8();
    paramRspCreateShareUrl = (common.ErrorInfo)paramRspCreateShareUrl.result.get();
    int i = ijl.a(paramRspCreateShareUrl);
    QLog.w("ShareChat", 1, "requestGetUrlFromServer.callback, result[" + i + "], bytes_errmsg[" + paramRspCreateShareUrl.bytes_errmsg.get().toStringUtf8() + "], share_url_with_no_sig[" + paramReqCreateShareUrl + "], share_url[" + paramObject + "], seq[" + paramLong + "]");
    if (i == 0)
    {
      this.a.QG = paramObject;
      this.a.QF = paramReqCreateShareUrl;
      aqji.a().bl(this.a.a.troopUin, this.a.QF, this.a.QG);
    }
    for (;;)
    {
      this.a.a(this.a.mApp, this.a.a.troopUin);
      return;
      if (i != 11001) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ive
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;

class agmn
  implements awpw<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp>
{
  agmn(agmf paramagmf, agmf.a parama) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "sendWeiYun2Dataline onFailed: errcode[" + paramInt + "], errmsg[" + paramString + "]");
    if (this.jdField_b_of_type_Agmf$a != null) {
      this.jdField_b_of_type_Agmf$a.onError(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new String(paramCrossBidProxyCopyFileToOtherBidMsgRsp.dst_path.get().toByteArray());
    if (paramCrossBidProxyCopyFileToOtherBidMsgRsp.length() < 1)
    {
      QLog.e("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^! [CS Replay]sendWeiYun2Dataline onSucceed,But uuid is null!!!");
      if (this.jdField_b_of_type_Agmf$a != null) {
        this.jdField_b_of_type_Agmf$a.onError(-3, "copyFileToOtherBid_fail");
      }
    }
    do
    {
      return;
      QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^ [CS Replay] sendWeiYun2Dataline onSucceed, Uuid[" + paramCrossBidProxyCopyFileToOtherBidMsgRsp + "]");
    } while (this.jdField_b_of_type_Agmf$a == null);
    this.jdField_b_of_type_Agmf$a.onSuccess(paramCrossBidProxyCopyFileToOtherBidMsgRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agmn
 * JD-Core Version:    0.7.0.1
 */
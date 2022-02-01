import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryPic;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryVideo;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;

class aooc
  implements ITransactionCallback
{
  aooc(aoob paramaoob, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = rpe.f((String)paramHashMap.get("upFlow_WiFi"), -1L);
    long l3 = rpe.f((String)paramHashMap.get("dwFlow_WiFi"), -1L);
    long l4 = rpe.f((String)paramHashMap.get("upFlow_Xg"), -1L);
    long l5 = rpe.f((String)paramHashMap.get("dwFlow_Xg"), -1L);
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    ram.i(aoob.TAG, "Transaction End : Failed. take time:" + (l1 - this.val$startTime) + "ms");
    this.a.mM.put("X-piccachetime", paramArrayOfByte);
    this.a.mM.put("param_BdhTrans", str1);
    this.a.mM.put("param_segspercnt", str2);
    this.a.mM.put("param_conf_segSize", str3);
    this.a.mM.put("param_conf_segNum", str4);
    this.a.mM.put("param_conf_connNum", paramHashMap);
    this.a.e(l2, l3, l4, l5);
    this.a.a(paramInt, "OnFailed.", "", this.a.jdField_b_of_type_Aojn$a);
    this.a.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    ram.i(aoob.TAG, "Transaction End : Success. New : SendTotalCost:" + (l1 - this.val$startTime) + "ms ,fileSize:" + this.a.jdField_b_of_type_Aoko.fileSize + " transInfo:" + str2);
    this.a.mM.put("X-piccachetime", str1);
    this.a.mM.put("param_BdhTrans", str2);
    this.a.mM.put("param_segspercnt", str3);
    this.a.mM.put("param_conf_segSize", str4);
    this.a.mM.put("param_conf_segNum", str5);
    this.a.mM.put("param_conf_connNum", paramHashMap);
    this.a.jdField_b_of_type_Aojn$a.dVg();
    this.a.jdField_b_of_type_Aojn$a.result = 1;
    this.a.bz = this.a.mFileSize;
    ram.i(aoob.TAG, "ITransactionCallback.onSuccess()");
    if (paramArrayOfByte == null) {
      this.a.onError();
    }
    for (;;)
    {
      this.a.e(l2, l3, l4, l5);
      this.a.jdField_b_of_type_Aoko.dVw();
      return;
      int i;
      if (this.a.jdField_b_of_type_Aoko.fileType == 196610)
      {
        paramHashMap = new qqstory_bhd_upload_pic.RspStoryPic();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte);
          i = paramHashMap.retcode.get();
          if (i != 0) {
            break label567;
          }
          this.a.clS = paramHashMap.url.get().toStringUtf8();
          ram.b(aoob.TAG, "upload file %s return url %s", this.a.mFileName, this.a.clS);
          if (!TextUtils.isEmpty(this.a.clS)) {
            break label557;
          }
          this.a.errCode = 940010;
          this.a.errDesc = String.format("return illegal arg url:%s", new Object[] { this.a.clS });
          this.a.onError();
          paramHashMap = aqhs.bytes2HexStr(paramArrayOfByte);
          str1 = aoob.TAG;
          paramArrayOfByte = paramHashMap;
          if (paramHashMap == null) {
            paramArrayOfByte = "";
          }
          ram.e(str1, "url not return %s", new Object[] { paramArrayOfByte });
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          ram.w(aoob.TAG, "parser buffer exception");
          this.a.onError();
        }
        continue;
        label557:
        this.a.onSuccess();
        continue;
        label567:
        this.a.errCode = i;
        this.a.errDesc = paramHashMap.msg.get().toStringUtf8();
        this.a.onError();
      }
      else if ((this.a.jdField_b_of_type_Aoko.fileType == 196609) || (this.a.jdField_b_of_type_Aoko.fileType == 327681))
      {
        paramHashMap = new qqstory_bhd_upload_pic.RspStoryVideo();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte);
          i = paramHashMap.retcode.get();
          if (i != 0) {
            break label875;
          }
          this.a.mVideoUrl = paramHashMap.cdn_url.get().toStringUtf8();
          if (this.a.jdField_b_of_type_Aoko.fileType == 196609) {
            this.a.mVideoUrl = rpq.aj(this.a.mVideoUrl, "authkey");
          }
          this.a.mVid = paramHashMap.file_key.get().toStringUtf8();
          if ((!TextUtils.isEmpty(this.a.mVideoUrl)) && (!TextUtils.isEmpty(this.a.mVid))) {
            break label865;
          }
          this.a.errCode = 940010;
          this.a.errDesc = String.format("return illegal arg vid:%s, url:%s", new Object[] { this.a.mVid, this.a.mVideoUrl });
          this.a.onError();
          paramHashMap = aqhs.bytes2HexStr(paramArrayOfByte);
          str1 = aoob.TAG;
          paramArrayOfByte = paramHashMap;
          if (paramHashMap == null) {
            paramArrayOfByte = "";
          }
          ram.e(str1, "url not return %s", new Object[] { paramArrayOfByte });
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          ram.w(aoob.TAG, "parser buffer exception");
          this.a.onError();
        }
        continue;
        label865:
        this.a.onSuccess();
        continue;
        label875:
        this.a.errCode = i;
        this.a.errDesc = paramHashMap.msg.get().toStringUtf8();
        this.a.onError();
      }
      else
      {
        this.a.VR(1005);
        this.a.onError();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    ram.b(aoob.TAG, "onTransStart %s", this.a.h.dQ);
    long l1 = System.currentTimeMillis();
    long l2 = aoob.a(this.a);
    String str2 = rar.getNetworkType(BaseApplication.getContext());
    if (this.a.jdField_b_of_type_Aoko.fileType == 196610) {}
    for (String str1 = "pic";; str1 = "video")
    {
      rar.b("publish_story", "publish_bdh", 0, 0, new String[] { "", String.valueOf(l1 - l2), str2, str1 });
      this.a.jdField_b_of_type_Aojn$a.dVf();
      aoob.a(this.a, System.currentTimeMillis());
      return;
    }
  }
  
  public void onUpdateProgress(int paramInt)
  {
    aoob localaoob = this.a;
    aoko localaoko = this.a.jdField_b_of_type_Aoko;
    long l = paramInt;
    localaoko.transferedSize = l;
    localaoob.bz = l;
    if ((paramInt <= this.a.mFileSize) && (!this.a.mIsCancel) && (!this.a.mIsPause)) {
      this.a.dUZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aooc
 * JD-Core Version:    0.7.0.1
 */
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

class aome
  implements ITransactionCallback
{
  aome(aomd paramaomd, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.val$startTime) + "ms");
    }
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
    long l5 = SystemClock.uptimeMillis();
    long l1 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l2 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    Object localObject = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l5 - this.val$startTime) + "ms ,fileSize:" + this.a.jdField_b_of_type_Aoko.fileSize + " transInfo:" + str1);
    }
    this.a.mM.put("X-piccachetime", localObject);
    this.a.mM.put("param_BdhTrans", str1);
    this.a.mM.put("param_segspercnt", str2);
    this.a.mM.put("param_conf_segSize", str3);
    this.a.mM.put("param_conf_segNum", str4);
    this.a.mM.put("param_conf_connNum", paramHashMap);
    this.a.jdField_b_of_type_Aojn$a.dVg();
    this.a.jdField_b_of_type_Aojn$a.result = 1;
    this.a.bz = this.a.mFileSize;
    if ((this.a.jdField_b_of_type_Aoko.fileType == 50) || (this.a.jdField_b_of_type_Aoko.fileType == 51)) {
      paramHashMap = new Bdh_extinfo.UploadPicExtInfo();
    }
    for (;;)
    {
      try
      {
        paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
        this.a.uuid = paramHashMap.bytes_file_resid.get().toStringUtf8();
        if (!TextUtils.isEmpty(this.a.uuid))
        {
          this.a.onSuccess();
          this.a.e(l1, l2, l3, l4);
          this.a.jdField_b_of_type_Aoko.dVw();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        this.a.onError();
        continue;
      }
      int i;
      if (this.a.jdField_b_of_type_Aoko.fileType == 23)
      {
        paramHashMap = new Bdh_extinfo.CommFileExtRsp();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
          localObject = this.a;
          if (paramHashMap.bytes_download_url.has())
          {
            paramArrayOfByte = paramHashMap.bytes_download_url.get().toStringUtf8();
            ((aomd)localObject).mUrl = paramArrayOfByte;
            if (!paramHashMap.int32_retcode.has()) {
              break label612;
            }
            i = paramHashMap.int32_retcode.get();
            if (QLog.isColorLevel()) {
              QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i + " url : " + this.a.mUrl);
            }
            if (i != 0) {
              break label617;
            }
            this.a.onSuccess();
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte.printStackTrace();
            continue;
            paramArrayOfByte = "";
            continue;
            label612:
            i = -1;
          }
          label617:
          this.a.onError();
        }
      }
      else
      {
        paramHashMap = ByteBuffer.wrap(paramArrayOfByte);
        i = paramHashMap.get();
        if (QLog.isColorLevel()) {
          QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i);
        }
        if (i == 0)
        {
          if ((this.a.jdField_b_of_type_Aoko.fileType == 8) || (this.a.jdField_b_of_type_Aoko.fileType == 64)) {
            aomd.bxx = Integer.parseInt(new String(paramArrayOfByte, 2, paramHashMap.get() & 0xFF));
          }
          for (;;)
          {
            this.a.onSuccess();
            break;
            if (this.a.jdField_b_of_type_Aoko.fileType == 21)
            {
              i = paramHashMap.get();
              this.a.clS = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if (this.a.jdField_b_of_type_Aoko.fileType == 22)
            {
              i = paramHashMap.get();
              this.a.clS = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if (this.a.jdField_b_of_type_Aoko.fileType == 35)
            {
              this.a.jdField_b_of_type_Aoko.fL = paramArrayOfByte;
            }
            else if ((this.a.jdField_b_of_type_Aoko.fileType == 36) || (this.a.jdField_b_of_type_Aoko.fileType == 37) || (this.a.jdField_b_of_type_Aoko.fileType == 38) || (this.a.jdField_b_of_type_Aoko.fileType == 39) || (this.a.jdField_b_of_type_Aoko.fileType == 40) || (this.a.jdField_b_of_type_Aoko.fileType == 41))
            {
              i = paramHashMap.get();
              int j = paramHashMap.get();
              int k = paramHashMap.get();
              int m = paramHashMap.get();
              this.a.yc = new String(paramArrayOfByte, 5, (m & 0xFF) << 24 | 0x0 | i | (j & 0xFF) << 8 | (k & 0xFF) << 16);
            }
            else if (this.a.jdField_b_of_type_Aoko.fileType == 48)
            {
              i = paramHashMap.get();
              this.a.clS = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if (this.a.jdField_b_of_type_Aoko.fileType == 56)
            {
              try
              {
                paramHashMap.getInt();
                l5 = paramHashMap.getLong();
                i = paramHashMap.getInt();
                this.a.clS = new String(paramArrayOfByte, paramHashMap.position(), i);
                if (QLog.isColorLevel()) {
                  QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(). personalityLabel uuid:" + l5 + " url:" + this.a.clS);
                }
                this.a.jdField_b_of_type_Aoko.thumbPath = this.a.h.bN;
                this.a.jdField_b_of_type_Aoko.apJ = l5;
                this.a.jdField_b_of_type_Aoko.fileUrl = this.a.clS;
                if (TextUtils.isEmpty(this.a.jdField_b_of_type_Aoko.fileUrl)) {
                  this.a.jdField_b_of_type_Aoko.fileUrl = this.a.h.dQ;
                }
              }
              catch (Exception paramArrayOfByte) {}
            }
          }
        }
        if (this.a.jdField_b_of_type_Aoko.fileType == 34)
        {
          paramArrayOfByte = new String(paramArrayOfByte);
          this.a.clS = paramArrayOfByte;
          this.a.onSuccess();
        }
        else
        {
          this.a.VR(1005);
          this.a.onError();
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.a.log("<BDH_LOG> onTransStart()");
    this.a.jdField_b_of_type_Aojn$a.dVf();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    aomd localaomd = this.a;
    aoko localaoko = this.a.jdField_b_of_type_Aoko;
    long l = paramInt;
    localaoko.transferedSize = l;
    localaomd.bz = l;
    if ((paramInt <= this.a.mFileSize) && (!this.a.mIsCancel) && (!this.a.mIsPause)) {
      this.a.dUZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aome
 * JD-Core Version:    0.7.0.1
 */
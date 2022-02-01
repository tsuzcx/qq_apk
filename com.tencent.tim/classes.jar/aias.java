import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import face.qqlogin.faceproto.Response;
import java.io.File;
import java.util.HashMap;

class aias
  implements ITransactionCallback
{
  aias(aiaq paramaiaq, File paramFile, EIPCResult paramEIPCResult, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.i("qqidentification_server", 1, "BDH.Upload fail  : result:" + paramInt);
    aiaq.a(this.this$0);
    anot.a(this.val$app, "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, "", "", this.Og + "", "");
    this.b.code = -102;
    paramArrayOfByte = new Bundle();
    paramArrayOfByte.putInt("ret", 209);
    paramArrayOfByte.putString("subError", "UPLOAD onFailed I=" + paramInt);
    paramArrayOfByte.putString("errMsg", acfp.m(2131707356));
    this.b.data = paramArrayOfByte;
    this.this$0.callbackResult(aiaq.a(this.this$0), this.b);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.d("qqidentification_server", 1, "upload file success");
    aiaq.a(this.this$0);
    this.val$file.delete();
    paramHashMap = new faceproto.Response();
    for (;;)
    {
      try
      {
        paramHashMap.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new Bundle();
        i = paramHashMap.Ret.get();
        paramArrayOfByte.putInt("ret", i);
        str = paramHashMap.ErrMsg.get();
        paramArrayOfByte.putString("errMsg", str);
        paramArrayOfByte.putBoolean("needRetry", paramHashMap.NeedRetry.get());
        QLog.d("qqidentification_server", 1, "retry: " + paramHashMap.NeedRetry.get() + " ret=" + i);
        paramArrayOfByte.putString("idKey", paramHashMap.IDKey.get());
        this.b.data = paramArrayOfByte;
        if (i != 0) {
          continue;
        }
        anot.a(this.val$app, "dc00898", "", "", "0X80097ED", "0X80097ED", 0, 0, this.YA + "", "" + this.dcT, this.Og + "", "");
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int i;
        String str;
        QLog.e("qqidentification_server", 1, new Object[] { "parse bytes error : ", paramArrayOfByte.getMessage() });
        this.b.code = -102;
        paramArrayOfByte = new Bundle();
        paramArrayOfByte.putString("subError", "InvalidProtocolBufferMicroException");
        paramArrayOfByte.putInt("ret", 208);
        paramArrayOfByte.putString("errMsg", acfp.m(2131707358));
        this.b.data = paramArrayOfByte;
        anot.a(this.val$app, "dc00898", "", "", "0X80097EC", "0X80097EC", 0, 0, this.YA + "", "" + this.dcT, this.Og + "", "");
        continue;
      }
      this.this$0.callbackResult(aiaq.a(this.this$0), this.b);
      return;
      QLog.e("qqidentification_server", 1, "request err: " + i + ", " + str);
      anot.a(this.val$app, "dc00898", "", "", "0X80097EE", "0X80097EE", 0, 0, this.YA + "", "" + this.dcT, this.Og + "", i + "");
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aias
 * JD-Core Version:    0.7.0.1
 */
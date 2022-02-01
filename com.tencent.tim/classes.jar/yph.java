import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class yph
  extends ypd
{
  yph(ype paramype) {}
  
  public void a(String paramString1, String paramString2, List<ypk> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactPush mSessionId:" + ype.a(this.this$0) + " sessionId:" + paramString2 + " faceFriends:" + paramList + " currentUin:" + paramString1);
    }
    if ((TextUtils.equals(paramString2, ype.a(this.this$0))) && (ype.a(this.this$0) != null) && (TextUtils.equals(paramString1, ype.a(this.this$0).getCurrentAccountUin())) && (paramList != null) && (paramList.size() > 0))
    {
      ype.a(this.this$0);
      if (ype.a(this.this$0) != null) {
        ype.a(this.this$0).s(paramString1, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onEnterFace2FaceAddContact isSuccess:" + paramBoolean1 + " mSessionId:" + ype.a(this.this$0) + " sessionId:" + paramString1 + " errorCode:" + paramInt1 + " errorMsg:" + paramString2 + " securityLevel:" + paramInt2 + " verifyUrl:" + paramString3 + " heartbeatTime:" + paramInt3 + " expireTime:" + paramInt4 + " isEnterAfterVerify:" + paramBoolean2);
    }
    ype.a(this.this$0, paramBoolean1, paramString1, paramInt1, paramString2, paramInt2, paramString3, paramInt3, paramInt4, paramBoolean2);
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactHeartBeat isSuccess:" + paramBoolean + " mSessionId:" + ype.a(this.this$0) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2 + " missingList:" + paramList);
    }
    ype.a(this.this$0, paramBoolean, paramString1, paramInt, paramString2, paramList);
  }
  
  public void h(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onExitFace2FaceAddContact isSuccess:" + paramBoolean + " mSessionId:" + ype.a(this.this$0) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2);
    }
    ype.a(this.this$0);
    if (ype.a(this.this$0) != null) {
      ype.a(this.this$0).cks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yph
 * JD-Core Version:    0.7.0.1
 */
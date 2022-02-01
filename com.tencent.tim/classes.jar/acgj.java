import android.text.TextUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;

class acgj
  extends acfd
{
  acgj(acgi paramacgi) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "onGetFriendDateNick.isSuccess=" + paramBoolean + ",uin=" + paramString1 + ",nick=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (this.this$0.e == null) || (!paramString1.equals(this.this$0.e.ownerUin)) || (!TextUtils.isEmpty(this.this$0.ownerNickname))) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        this.this$0.ownerNickname = paramString2;
      }
      if ((this.this$0.N != null) && (this.this$0.N.isShowing()))
      {
        if (this.this$0.currentState == 0) {
          this.this$0.currentState = 1;
        }
        while (this.this$0.currentState == 3)
        {
          this.this$0.hideProgress();
          acgi.a(this.this$0);
          return;
          if (this.this$0.currentState == 2) {
            this.this$0.currentState = 3;
          }
        }
      }
    }
  }
  
  protected void onStrangerHeadReady(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "onStrangerHeadReady.isSuccess=" + paramBoolean + ",id=" + paramString1 + ",idType=" + paramInt + ",downloadUrl=" + paramString2);
    }
    if ((paramInt != 200) || (TextUtils.isEmpty(paramString1)) || (this.this$0.e == null) || (!paramString1.equals(this.this$0.e.ownerUin))) {}
    for (;;)
    {
      return;
      this.this$0.boq = paramString2;
      if ((this.this$0.N != null) && (this.this$0.N.isShowing()))
      {
        if (this.this$0.currentState == 0) {
          this.this$0.currentState = 2;
        }
        while (this.this$0.currentState == 3)
        {
          this.this$0.hideProgress();
          acgi.a(this.this$0);
          return;
          if (this.this$0.currentState == 1) {
            this.this$0.currentState = 3;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgj
 * JD-Core Version:    0.7.0.1
 */
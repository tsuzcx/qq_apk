import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class afqg
  extends VasQuickUpdateManager.CallBacker
{
  afqg(afqc paramafqc) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((1003L != paramLong) || (!"emotionRecommendEffect".equals(paramString1))) {
      return;
    }
    if (this.this$0.app != null) {
      ((VasQuickUpdateManager)this.this$0.app.getManager(184)).removeCallBacker(this.this$0.callBacker);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect callBacker errorCode:" + paramInt1 + ", httpCode:" + paramInt2 + ", apngSoLoaded:" + aqqv.a().isLoaded());
    }
    paramString1 = this.this$0.dB;
    if (paramInt1 == 0) {}
    try
    {
      if ((this.this$0.wm != null) && (this.this$0.wm.size() > 0))
      {
        paramString2 = VasQuickUpdateManager.getFileFromLocal(this.this$0.app, 1003L, "emotionRecommendEffect", null, false, null);
        if (paramString2 != null)
        {
          paramInt1 = 0;
          while ((paramInt1 < this.this$0.wm.size()) && (paramInt1 < 2))
          {
            paramString3 = (afqc.a)this.this$0.wm.get(paramInt1);
            paramString3.av = paramString2;
            this.this$0.q.sendMessage(this.this$0.q.obtainMessage(102, paramString3));
            paramInt1 += 1;
          }
          this.this$0.wm.clear();
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqg
 * JD-Core Version:    0.7.0.1
 */
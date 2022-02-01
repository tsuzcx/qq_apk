import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class xyy
  extends ahpp
{
  xyy(xys paramxys) {}
  
  protected void Z(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.this$0.sessionInfo.aTl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onBandIntimateRelationship");
      }
      this.this$0.Te();
    }
  }
  
  protected void b(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.this$0.sessionInfo.aTl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onUpdateIntimateRelationship");
      }
      this.this$0.Te();
    }
  }
  
  protected void k(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (TextUtils.equals(paramString, this.this$0.sessionInfo.aTl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onDisbandIntimateRelationship");
      }
      this.this$0.Te();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyy
 * JD-Core Version:    0.7.0.1
 */
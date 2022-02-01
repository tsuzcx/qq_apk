import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

class ydl
  extends acje
{
  ydl(ycd paramycd) {}
  
  public void DH(int paramInt)
  {
    this.this$0.tT(paramInt);
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0)
    {
      if ((paramPublicAccountInfo != null) && (this.this$0.sessionInfo != null) && (this.this$0.sessionInfo.aTl.equals(paramPublicAccountInfo.getUin()))) {
        this.this$0.fV(1);
      }
    }
    else {
      return;
    }
    this.this$0.br(this.this$0.mActivity.getIntent());
  }
  
  public void aH(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.this$0.br(this.this$0.mActivity.getIntent());
    }
    if ((paramBoolean) && (!ycd.d(this.this$0)))
    {
      localObject = (acja)this.this$0.app.getManager(56);
      if (localObject == null) {
        break label102;
      }
    }
    label102:
    for (Object localObject = ((acja)localObject).b(this.this$0.sessionInfo.aTl);; localObject = null)
    {
      if ((localObject != null) && (this.this$0.xt != null) && (!ycd.e(this.this$0))) {
        this.this$0.cgN();
      }
      return;
    }
  }
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.this$0.br(this.this$0.mActivity.getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydl
 * JD-Core Version:    0.7.0.1
 */
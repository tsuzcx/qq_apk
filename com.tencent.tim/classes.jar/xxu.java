import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.qphone.base.util.QLog;

class xxu
  extends aegv
{
  xxu(xxt paramxxt) {}
  
  private void ag(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder;
    if ((this.this$0.mActivity != null) && (!this.this$0.mActivity.isFinishing()))
    {
      localStringBuilder = new StringBuilder();
      if (!paramBoolean) {}
    }
    else
    {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append("屏蔽失败，请重试。");
      this.this$0.q(2, localStringBuilder.toString(), 500);
      return;
    }
    localStringBuilder.append("屏蔽失败，").append(paramString);
    this.this$0.q(2, localStringBuilder.toString(), 500);
  }
  
  public void T(String paramString, int paramInt1, int paramInt2)
  {
    if (!aegp.i(this.this$0.app)) {}
    do
    {
      do
      {
        return;
      } while ((!paramString.equals(this.this$0.sessionInfo.aTl)) || (paramInt1 != this.this$0.sessionInfo.topicId) || (paramInt2 != this.this$0.sessionInfo.cZ));
      xxt.a(this.this$0);
    } while (!QLog.isColorLevel());
    QLog.i(this.this$0.TAG, 2, "onCheckHolmesTipsView  frdUin:" + paramString + " type:" + paramInt2 + " topicid:" + paramInt1);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (!aegp.i(this.this$0.app)) {
      return;
    }
    if (paramBoolean2) {}
    for (;;)
    {
      String str = Long.toString(paramLong2);
      if ((!str.equals(this.this$0.sessionInfo.aTl)) || (paramInt1 != this.this$0.sessionInfo.topicId) || (paramInt2 != this.this$0.sessionInfo.cZ)) {
        break;
      }
      if (paramBoolean1)
      {
        aegz localaegz = this.this$0.app.a().a();
        ConfessConvInfo localConfessConvInfo = localaegz.a(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, this.this$0.sessionInfo.topicId);
        if ((localConfessConvInfo != null) && ((localConfessConvInfo.holmesCurCount != paramInt3) || (localConfessConvInfo.holmesTolCount != paramInt4))) {
          localaegz.d(str, paramInt2, paramInt1, paramInt3, paramInt4);
        }
        xxt.a(this.this$0, true);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(this.this$0.TAG, 2, "onGetHolmesProgress " + paramBoolean1 + " frdUin:" + str + " type:" + paramInt2 + " topicid:" + paramInt1 + " curCount:" + paramInt3);
      return;
      paramLong2 = paramLong1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, ConfessInfo paramConfessInfo)
  {
    String str;
    if ((this.this$0.sessionInfo != null) && (aqft.equalsWithNullCheck(paramString1, this.this$0.sessionInfo.aTl)) && (paramInt1 == this.this$0.sessionInfo.cZ) && (paramInt2 == this.this$0.sessionInfo.topicId)) {
      if (QLog.isColorLevel())
      {
        str = this.this$0.TAG;
        paramInt2 = this.this$0.sessionInfo.topicId;
        if (paramString2 != null) {
          break label162;
        }
      }
    }
    label162:
    for (paramConfessInfo = "";; paramConfessInfo = paramString2)
    {
      QLog.i(str, 2, String.format("onSetShieldFlag suc:%b frdUin:%s uinType:%d topicId:%d hours:%d msg:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramConfessInfo }));
      this.this$0.cfO();
      ag(paramBoolean, paramString2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxu
 * JD-Core Version:    0.7.0.1
 */
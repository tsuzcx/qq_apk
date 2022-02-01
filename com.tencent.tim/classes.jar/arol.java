import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;

class arol
  implements asbh.b
{
  arol(arok paramarok) {}
  
  public void ea(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "preAuthWithRetry onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    AgentActivity.a(this.a.this$0);
    if ((paramInt == 110530) || (paramInt == 1002))
    {
      AgentActivity.a(this.a.this$0, this.a.cBm, this.a.val$bundle, this.a.val$appid, false);
      return;
    }
    if (paramInt == 110509)
    {
      if (this.a.ekE == 1)
      {
        AgentActivity.a(this.a.this$0, this.a.cBm, this.a.val$bundle, this.a.val$appid, 3);
        return;
      }
      AgentActivity.a(this.a.this$0, this.a.cBm, this.a.val$bundle, this.a.val$appid, true, true);
      return;
    }
    if (paramInt == 110513)
    {
      AgentActivity.a(this.a.this$0, 0, "", "");
      return;
    }
    String str;
    if (paramInt == -1) {
      str = this.a.this$0.getResources().getString(2131696664);
    }
    for (;;)
    {
      ForwardUtils.a(str, this.a.this$0, new arom(this, paramInt, paramString));
      return;
      if (TextUtils.isEmpty(paramString)) {
        str = String.format(this.a.this$0.getResources().getString(2131696651), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = String.format(this.a.this$0.getResources().getString(2131698727), new Object[] { paramString, Integer.valueOf(paramInt) });
      }
    }
  }
  
  public void onSuccess()
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, "preAuthWithRetry onSuccess");
    AgentActivity.a(this.a.this$0);
    AgentActivity.a(this.a.this$0, this.a.cBm, this.a.val$bundle, this.a.val$appid, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     arol
 * JD-Core Version:    0.7.0.1
 */
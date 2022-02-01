import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class arrj
  implements asbh.b
{
  public arrj(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void ea(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "getVirtualList onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    if (OpenAuthorityFragment.a(this.this$0, paramInt, true))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "getVirtualList handle110537");
      return;
    }
    if (OpenAuthorityFragment.a(this.this$0, paramInt, 2))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "getVirtualList handle110509");
      return;
    }
    this.this$0.b.a(false, null);
  }
  
  public void onSuccess()
  {
    boolean bool = true;
    GetVirtualListResult localGetVirtualListResult = OpenAuthorityFragment.a(this.this$0).a().a(OpenAuthorityFragment.a(this.this$0));
    if (localGetVirtualListResult != null)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "getVirtualList onSuccess null != virtualResult");
      artd localartd = this.this$0.b;
      if (localGetVirtualListResult.errorCode == 0) {}
      for (;;)
      {
        localartd.a(bool, localGetVirtualListResult);
        return;
        bool = false;
      }
    }
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "getVirtualList onSuccess null == virtualResult");
    this.this$0.b.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrj
 * JD-Core Version:    0.7.0.1
 */
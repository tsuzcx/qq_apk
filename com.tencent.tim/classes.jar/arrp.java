import android.content.res.Resources;
import android.os.Message;
import android.widget.Button;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

public class arrp
  implements asbh.b
{
  public arrp(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void ea(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "updatePreAuthFromServer | onFail: | uin : *" + artw.qx(OpenAuthorityFragment.a(this.this$0).uin), ", errorCode=", Integer.valueOf(paramInt), ", errorMsg=", paramString });
    if (!OpenAuthorityFragment.b(this.this$0))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer onFail for activity is finished");
      return;
    }
    if (OpenAuthorityFragment.a(this.this$0, paramInt, false))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer handle110537");
      return;
    }
    if (OpenAuthorityFragment.a(this.this$0, paramInt, 3))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer handle110509");
      return;
    }
    this.this$0.jdField_b_of_type_Artd.a(false, null);
    OpenAuthorityFragment.a(this.this$0, null);
    paramString = this.this$0.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    paramString.what = 6;
    paramString.arg1 = 3001;
    paramString.obj = this.this$0.getResources().getString(2131696654);
    this.this$0.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramString);
  }
  
  public void onSuccess()
  {
    if (!OpenAuthorityFragment.b(this.this$0))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer onSuccess for activity is finished");
      return;
    }
    Object localObject1 = OpenAuthorityFragment.a(this.this$0).a().a(OpenAuthorityFragment.a(this.this$0));
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "updatePreAuthFromServer use cached realAppid=", OpenAuthorityFragment.a(this.this$0), ", appInfo=", ((ahgf)localObject1).toString() });
    Object localObject2 = this.this$0.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    ((Message)localObject2).what = 3;
    ((Message)localObject2).obj = localObject1;
    this.this$0.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
    localObject1 = OpenAuthorityFragment.a(this.this$0).a().a(OpenAuthorityFragment.a(this.this$0));
    boolean bool;
    if (localObject1 != null)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer onSuccess null != virtualResult");
      localObject2 = this.this$0.jdField_b_of_type_Artd;
      if (((GetVirtualListResult)localObject1).errorCode == 0)
      {
        bool = true;
        ((artd)localObject2).a(bool, (GetVirtualListResult)localObject1);
      }
    }
    for (;;)
    {
      if (!OpenAuthorityFragment.c(this.this$0)) {
        OpenAuthorityFragment.a(this.this$0).setEnabled(true);
      }
      localObject1 = OpenAuthorityFragment.a(this.this$0).a().a(OpenAuthorityFragment.a(this.this$0));
      localObject2 = this.this$0.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      ((Message)localObject2).what = 0;
      ((Message)localObject2).obj = localObject1;
      this.this$0.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
      return;
      bool = false;
      break;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "updatePreAuthFromServer onSuccess null == virtualResult");
      this.this$0.jdField_b_of_type_Artd.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrp
 * JD-Core Version:    0.7.0.1
 */
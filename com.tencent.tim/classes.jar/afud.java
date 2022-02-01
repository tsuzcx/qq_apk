import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class afud
  implements afxx.a
{
  public afud(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  public void bPe()
  {
    afxx.p(this.this$0.mActivity);
  }
  
  public void d(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    afxx.a(this.this$0.mActivity, paramBoolean, paramInt, paramString1, paramString2);
  }
  
  public void dk(String paramString1, String paramString2)
  {
    afxx.A(this.this$0.mActivity, paramString1, paramString2);
  }
  
  public void showToast(int paramInt)
  {
    if (this.this$0.mActivity == null)
    {
      QLog.d("ExtendFriendBaseFragment", 1, "sendMsgDirectly()-> showToast() mActivity is null just return");
      return;
    }
    afxx.b(this.this$0.mActivity, this.this$0.mActivity.getString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afud
 * JD-Core Version:    0.7.0.1
 */
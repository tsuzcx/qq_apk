import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ahmw
  extends aklm
{
  private final FragmentActivity activity = this.a.getActivity();
  
  public ahmw(DeleteFaceFragment paramDeleteFaceFragment, String paramString) {}
  
  public void dg(String paramString1, String paramString2)
  {
    if (DeleteFaceFragment.a(this.a))
    {
      QLog.e("DeleteFaceFragment", 1, "getTmpKeySuccess, activity is null");
      return;
    }
    DeleteFaceFragment.a(this.a, paramString2, this.val$account, paramString1);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    if (DeleteFaceFragment.a(this.a))
    {
      QLog.e("DeleteFaceFragment", 1, "onFailedResponse, activity is null");
      return;
    }
    this.a.bSZ();
    QLog.e("DeleteFaceFragment", 1, new Object[] { "sendGetTmpKeyRequest error, ", paramString2 });
    QQToast.a(this.activity, paramString2, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmw
 * JD-Core Version:    0.7.0.1
 */
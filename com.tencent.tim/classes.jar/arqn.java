import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.CreateVirtualAccountFragment;
import com.tencent.open.agent.CreateVirtualAccountFragment.6.1;
import com.tencent.open.agent.CreateVirtualAccountFragment.6.2;
import com.tencent.open.model.CreateVirtualResult;
import com.tencent.qphone.base.util.QLog;

public class arqn
  extends artd
{
  public arqn(CreateVirtualAccountFragment paramCreateVirtualAccountFragment) {}
  
  public void a(boolean paramBoolean, CreateVirtualResult paramCreateVirtualResult, int paramInt)
  {
    if (this.this$0.getActivity() == null)
    {
      QLog.e("CreateVirtualAccountFragment", 1, "onCreate activity is null");
      return;
    }
    this.this$0.getActivity().runOnUiThread(new CreateVirtualAccountFragment.6.2(this, paramBoolean, paramCreateVirtualResult, paramInt));
  }
  
  public void f(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (this.this$0.getActivity() == null)
    {
      QLog.e("CreateVirtualAccountFragment", 1, "onUploadAvatar activity is null");
      return;
    }
    this.this$0.getActivity().runOnUiThread(new CreateVirtualAccountFragment.6.1(this, paramBoolean, paramString1, paramString2, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqn
 * JD-Core Version:    0.7.0.1
 */
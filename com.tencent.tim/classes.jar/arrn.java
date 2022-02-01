import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.open.agent.OpenCardContainer.a;
import com.tencent.qqconnect.wtlogin.Login;

public class arrn
  implements OpenCardContainer.a
{
  public arrn(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void dw(String paramString, boolean paramBoolean)
  {
    this.this$0.dt(paramString, paramBoolean);
  }
  
  public void elp()
  {
    Intent localIntent = new Intent(this.this$0.getActivity(), Login.class);
    localIntent.putExtra("key_req_src", 1);
    localIntent.putExtra("is_first_login", true);
    localIntent.putExtra("appid", OpenAuthorityFragment.a(this.this$0));
    OpenAuthorityFragment.a(this.this$0, null);
    this.this$0.getActivity().startActivityForResult(localIntent, 1);
  }
  
  public void elq()
  {
    this.this$0.WO(OpenAuthorityFragment.b(this.this$0));
    if (OpenAuthorityFragment.a(this.this$0) != null) {
      OpenAuthorityFragment.a(this.this$0).ekJ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrn
 * JD-Core Version:    0.7.0.1
 */
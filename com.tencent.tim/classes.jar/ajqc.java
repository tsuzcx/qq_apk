import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.troop.NearbyVideoChatProxyActivity;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

class ajqc
  implements skj.a
{
  ajqc(ajqb paramajqb, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isOtherTypeChatting", false))
    {
      paramBundle = aqha.a(this.a.this$0.mRuntime.getActivity(), 230);
      paramBundle.setMessage(this.a.this$0.mRuntime.getActivity().getString(2131698108));
      paramBundle.setNegativeButton(acfp.m(2131708745), new ajqd(this));
      paramBundle.show();
      return;
    }
    skj.a();
    paramBundle = new oidb_0x8dd.SelfInfo();
    paramBundle.uint32_gender.set(this.a.dkp);
    paramBundle.uint32_charm_level.set(this.a.dkq);
    paramBundle.uint32_age.set(this.a.dkr);
    NearbyVideoChatProxyActivity.a(this.a.this$0.mRuntime.a(), this.a.this$0.mRuntime.getActivity(), null, this.val$config, paramBundle, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqc
 * JD-Core Version:    0.7.0.1
 */
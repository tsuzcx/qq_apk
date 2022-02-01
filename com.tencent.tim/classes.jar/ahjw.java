import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ahjw
  extends ahmb
{
  private ChatMessage u;
  
  public ahjw(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public static void a(ahgq paramahgq, long paramLong)
  {
    String str2 = paramahgq.wo();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      if (!str2.startsWith(acfp.m(2131706490))) {
        break label216;
      }
      str1 = str2.substring(4);
    }
    for (;;)
    {
      str2 = paramahgq.bf.getString("uin");
      int i = paramahgq.bf.getInt("uintype", 0);
      Intent localIntent = new Intent();
      localIntent.setClass(paramahgq.mActivity, MiniChatActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("uin", str2);
      localIntent.putExtra("uintype", i);
      localIntent.putExtra("uinname", str1);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("minaio_scaled_ration", paramahgq.B(0.78F));
      localIntent.putExtra("minaio_height_ration", 0.86F);
      localIntent.putExtra("member_dialog_title", str1);
      localIntent.putExtra("structmsg_uniseq", paramLong);
      localIntent.putExtra("multi_forward_title", acfp.m(2131706482));
      localIntent.putExtra("multi_forward_type", 3);
      localIntent.putExtra("key_mini_from", 4);
      PublicFragmentActivity.b.start(paramahgq.mActivity, localIntent, MiniChatActivity.class, MiniMultiForwardFragment.class);
      return;
      label216:
      str1 = str2;
      if (str2.startsWith(acfp.m(2131706483))) {
        str1 = str2.substring(3);
      }
    }
  }
  
  public boolean anj()
  {
    boolean bool = super.anj();
    long l = this.bf.getLong("FORWARD_MSG_UNISEQ", -1L);
    if (l == -1L) {
      return bool;
    }
    this.u = ((alvj)this.app.getManager(340)).c(l);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardReplyMsgOption", 2, "ForwardReplyMsgOption preloadData mChatMessage=" + this.u);
    }
    return bool;
  }
  
  protected View cc()
  {
    View localView = super.cc();
    if (this.u != null) {
      localView.findViewById(2131367542).setOnClickListener(new ahjx(this));
    }
    return localView;
  }
  
  protected void dnr()
  {
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
  }
  
  protected boolean h(String paramString1, String paramString2, int paramInt)
  {
    int i = wte.a().we();
    this.bf.putInt("KEY_MSG_FORWARD_ID", i);
    return super.h(paramString1, paramString2, paramInt);
  }
  
  public String wn()
  {
    String str2 = super.wn();
    String str1 = str2;
    if (this.u != null) {
      str1 = acfp.m(2131706484) + str2;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjw
 * JD-Core Version:    0.7.0.1
 */
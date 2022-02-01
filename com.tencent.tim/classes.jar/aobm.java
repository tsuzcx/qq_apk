import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aobm
  extends MiniMsgUser
{
  MiniMsgUserParam b;
  BaseActivity h;
  String nickName = "";
  int peerType = -1;
  String uin = "";
  
  public aobm(BaseActivity paramBaseActivity, MiniMsgUserParam paramMiniMsgUserParam, String paramString1, int paramInt, String paramString2)
  {
    super(paramBaseActivity, paramMiniMsgUserParam);
    this.uin = paramString1;
    this.peerType = paramInt;
    this.b = paramMiniMsgUserParam;
    this.h = paramBaseActivity;
    this.nickName = paramString2;
  }
  
  public void onClick(View paramView)
  {
    if (this.b == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.b.actionCallback != null) {
        this.b.actionCallback.onOpenMiniAIOCallback();
      }
      String str = this.uin;
      int i = this.peerType;
      if ((i != -1) && (!TextUtils.isEmpty(str)))
      {
        MiniChatActivity.a(this.h, i, str, this.nickName);
        hideUnread();
      }
    }
  }
  
  public void updateUnreadCountSync(int paramInt)
  {
    super.updateUnreadCountSync(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobm
 * JD-Core Version:    0.7.0.1
 */
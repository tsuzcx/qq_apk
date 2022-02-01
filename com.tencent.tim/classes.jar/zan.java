import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;

class zan
  implements ausj.a
{
  zan(zam paramzam, boolean paramBoolean, Friends paramFriends, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!aqiw.isNetworkAvailable(this.this$0.mContext)) {
      QQToast.a(this.this$0.mContext, 1, 2131693404, 0).show();
    }
    for (;;)
    {
      this.val$sheet.superDismiss();
      return;
      paramView = (FriendListHandler)zam.a(this.this$0).getBusinessHandler(1);
      if (this.bpM)
      {
        paramView.b(1, new String[] { this.d.uin }, new boolean[] { false });
        anot.a(zam.a(this.this$0), "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.b(1, new String[] { this.d.uin }, new boolean[] { true });
        anot.a(zam.a(this.this$0), "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zan
 * JD-Core Version:    0.7.0.1
 */
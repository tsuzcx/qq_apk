import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;

class yza
  implements ausj.a
{
  yza(yyy paramyyy, boolean paramBoolean, Friends paramFriends, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!aqiw.isNetworkAvailable(yyy.a(this.this$0))) {
      QQToast.a(yyy.a(this.this$0), 1, 2131693404, 0).show();
    }
    for (;;)
    {
      this.val$sheet.superDismiss();
      return;
      paramView = (FriendListHandler)yyy.a(this.this$0).getBusinessHandler(1);
      if (this.bpM) {
        paramView.b(1, new String[] { this.d.uin }, new boolean[] { false });
      } else {
        paramView.b(1, new String[] { this.d.uin }, new boolean[] { true });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yza
 * JD-Core Version:    0.7.0.1
 */
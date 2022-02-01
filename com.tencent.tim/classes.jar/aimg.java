import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class aimg
  implements Handler.Callback
{
  aimg(aimf paramaimf) {}
  
  private void ckK()
  {
    if (aimf.a(this.b) != null) {
      aimf.a(this.b).setRefreshing(false);
    }
    if (aimf.a(this.b) != null) {
      aimf.a(this.b).setRefresh(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 3: 
      QQToast.a(this.b.getActivity(), 1, 2131720480, 0).show(aimf.a(this.b));
      ckK();
      return false;
    case 4: 
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label134;
        }
        aimf.a(this.b);
        if (aimf.a(this.b) == null) {
          break;
        }
        aimf.a(this.b).tT(0);
        this.b.b.sendEmptyMessageDelayed(5, 800L);
        return false;
      }
      label134:
      ckK();
      QQToast.a(this.b.getActivity(), 1, 2131720480, 0).show(aimf.a(this.b));
      return false;
    }
    ckK();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aimg
 * JD-Core Version:    0.7.0.1
 */
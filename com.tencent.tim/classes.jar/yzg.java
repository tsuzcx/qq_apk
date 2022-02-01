import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class yzg
  implements Handler.Callback
{
  yzg(yzf paramyzf) {}
  
  private void ckK()
  {
    if (yzf.a(this.b) != null) {
      yzf.a(this.b).setRefreshing(false);
    }
    if (yzf.a(this.b) != null) {
      yzf.a(this.b).setRefresh(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      label146:
      do
      {
        return false;
        QQToast.a(this.b.getActivity(), 1, 2131720480, 0).show(yzf.a(this.b));
        ckK();
        return false;
        int i = paramMessage.arg1;
        if (paramMessage.arg2 == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label146;
          }
          yzf.a(this.b);
          if (yzf.a(this.b) == null) {
            break;
          }
          yzf.a(this.b).tT(0);
          this.b.b.sendEmptyMessageDelayed(5, 800L);
          return false;
        }
        ckK();
        QQToast.a(this.b.getActivity(), 1, 2131720480, 0).show(yzf.a(this.b));
        return false;
        ckK();
        return false;
        yzf.a(this.b, true, true);
        return false;
      } while ((yzf.a(this.b) == null) || (yzf.a(this.b) == null));
      yzf.a(this.b).fY(yzf.a(this.b).getScrollY(), yzf.a(this.b).kk());
      return false;
    }
    this.b.cni();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzg
 * JD-Core Version:    0.7.0.1
 */
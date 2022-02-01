import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView.a;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper.2;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper.4;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;

public class amey
  implements OnlineStatusLyricView.a, wvs
{
  public static int dBH = 259200;
  private TextView Cu;
  private TextView Yc;
  private ViewFlipper a;
  private BaseChatPie c;
  private boolean cCn;
  private boolean cCo;
  private View.OnClickListener fH = new amez(this);
  
  public amey(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
  }
  
  private void c(RichStatus paramRichStatus)
  {
    String str;
    if (paramRichStatus != null)
    {
      str = paramRichStatus.getPlainText();
      long l1 = paramRichStatus.time;
      long l2 = NetConnInfoCenter.getServerTime();
      paramRichStatus = aens.a();
      if (paramRichStatus != null)
      {
        dBH = (int)(paramRichStatus.cv * 60.0D * 60.0D);
        if (QLog.isColorLevel()) {
          QLog.d("AioFriendTitleHelper", 2, "needShowRichSubTitle-> richTitleConfBean.c2c_time_interval = " + paramRichStatus.cv);
        }
      }
      if (QLog.isColorLevel())
      {
        paramRichStatus = new StringBuilder().append("needShowRichSubTitle-> c = ").append(l2).append(" time = ").append(l1).append(" needShow =");
        if (l2 - l1 >= dBH) {
          break label196;
        }
        bool = true;
        QLog.d("AioFriendTitleHelper", 2, bool);
      }
      if (l2 - l1 < dBH) {
        if (TextUtils.isEmpty(str)) {
          break label202;
        }
      }
    }
    label196:
    label202:
    for (boolean bool = true;; bool = false)
    {
      this.cCn = bool;
      Py(str);
      this.c.app.reportClickEvent("CliOper", "0X800A66A");
      return;
      bool = false;
      break;
    }
  }
  
  public int[] C()
  {
    return new int[] { 3, 5, 9, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 3: 
    case 5: 
    case 9: 
      do
      {
        return;
        a(this.c.a, this.c.Cu, this.c.Cv);
        return;
        Pz("");
        return;
      } while ((this.a == null) || (!this.a.isFlipping()));
      this.a.stopFlipping();
      return;
    }
    destroy();
  }
  
  protected void Py(String paramString)
  {
    if ((this.Yc != null) && (this.a != null) && (this.Yc != null) && (this.c.sessionInfo != null)) {}
  }
  
  public void Pz(String paramString)
  {
    if ((!this.c.aTa) && (this.cCn)) {}
  }
  
  public void a(ViewFlipper paramViewFlipper, TextView paramTextView1, TextView paramTextView2)
  {
    this.a = paramViewFlipper;
    this.a.setOutAnimation(null);
    this.Cu = paramTextView1;
    this.Yc = paramTextView2;
    dMZ();
    if ((this.Cu instanceof OnlineStatusLyricView)) {
      ((OnlineStatusLyricView)this.Cu).setLyricStateListener(this);
    }
  }
  
  public boolean apu()
  {
    int j = 0;
    if (this.c == null) {
      return false;
    }
    aiqi localaiqi = (aiqi)this.c.a(32);
    int i = j;
    if (localaiqi != null)
    {
      i = j;
      if (localaiqi.apu()) {
        i = 1;
      }
    }
    if (i != 0) {
      return true;
    }
    return ((wxc)this.c.a(43)).Sl();
  }
  
  public boolean avM()
  {
    Friends localFriends = ((acff)this.c.app.getManager(51)).c(this.c.sessionInfo.aTl);
    if (localFriends == null)
    {
      ThreadManager.post(new AioFriendTitleHelper.4(this), 8, null, true);
      return false;
    }
    int i = aqgv.aU(localFriends.detalStatusFlag, localFriends.iTermType);
    if (QLog.isColorLevel()) {
      QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, isStatusOffline() -> status = " + i);
    }
    return i == 0;
  }
  
  public boolean c(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, onShowSubTitleText() isShowInputStatus =  " + paramBoolean + " statusText = " + paramString);
    }
    if (!this.cCn) {
      return false;
    }
    this.c.mActivity.runOnUiThread(new AioFriendTitleHelper.2(this, paramBoolean, paramString));
    return true;
  }
  
  public void dDA()
  {
    Pz(null);
  }
  
  public void dMZ()
  {
    if ((this.Yc == null) || (this.a == null)) {
      return;
    }
    this.Yc.setText("");
    this.a.stopFlipping();
  }
  
  public void destroy()
  {
    if (this.a != null)
    {
      if (this.a.getCurrentView() != this.Cu) {
        this.a.showNext();
      }
      this.a.stopFlipping();
    }
    if (this.Cu != null)
    {
      this.Cu.setText("");
      if (QLog.isColorLevel()) {
        QLog.d("AioFriendTitleHelper", 2, "needShowRichSubTitle-> destroy()");
      }
    }
    this.cCo = false;
    this.cCn = false;
    if ((this.Cu instanceof OnlineStatusLyricView)) {
      ((OnlineStatusLyricView)this.Cu).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amey
 * JD-Core Version:    0.7.0.1
 */
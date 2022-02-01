import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class wsx
  extends wsr
{
  private aotc a;
  private boolean bfR;
  
  public wsx(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void cbE()
  {
    if (this.bfR) {
      return;
    }
    this.bfR = true;
    wxg localwxg = (wxg)this.c.a(55);
    if (localwxg != null) {
      localwxg.cda();
    }
    xrm.ceq();
  }
  
  private void xG(String paramString)
  {
    if (TroopInfo.isQidianPrivateTroop(this.mApp, paramString)) {
      setEnable(false);
    }
  }
  
  public void cbB()
  {
    super.cbB();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerStartOpen", new Object[0]));
    }
    if (this.a != null) {
      this.a.initUI();
    }
    cbE();
  }
  
  public void doOnDestroy()
  {
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
  }
  
  public void h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.a != null) && (isOpen())) {
      this.a.h(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void initData()
  {
    xG(this.c.oL());
  }
  
  public boolean onBackEvent()
  {
    if ((this.a != null) && (isOpen()))
    {
      this.a.onBackEvent();
      return true;
    }
    return false;
  }
  
  protected View onCreateView()
  {
    this.a = new wsy(this, this.mApp, this.mActivity, this.mContext, this.c.sessionInfo, this.c.oL());
    if (this.a.getRootView() == null) {}
    return this.a.getRootView();
  }
  
  public void onDrawerClosed()
  {
    super.onDrawerClosed();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerClosed", new Object[0]));
    }
    if (this.a != null) {
      this.a.dWO();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsx
 * JD-Core Version:    0.7.0.1
 */
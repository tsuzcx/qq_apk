import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.drawer.IntimateInfoChatDrawer.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class wsv
  extends wsr
{
  private wll a;
  private boolean bfQ;
  
  private void cbD()
  {
    if ((this.c instanceof xys))
    {
      xys localxys = (xys)this.c;
      if (localxys.a != null) {
        localxys.a.gv(1);
      }
    }
    ThreadManager.getSubThreadHandler().post(new IntimateInfoChatDrawer.2(this));
  }
  
  public void cbB()
  {
    super.cbB();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened, needReqIntimateInfo: %s", new Object[] { Boolean.valueOf(this.bfQ) }));
    }
    if (this.a != null)
    {
      this.a.aqw = true;
      this.a.bZe();
      if (this.bfQ)
      {
        this.bfQ = false;
        this.a.bZg();
        this.a.bZh();
        this.a.bZp();
      }
    }
    cbD();
  }
  
  public void doOnDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void doOnPause()
  {
    if (this.a != null) {
      this.a.onPaused();
    }
  }
  
  public void doOnResume()
  {
    if (this.a != null)
    {
      if (isOpen())
      {
        this.a.bZg();
        this.a.bZp();
      }
      this.a.onResumed();
    }
  }
  
  public void h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a != null) {
      this.a.h(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void initData()
  {
    if (this.a != null) {
      this.a.initData();
    }
  }
  
  protected View onCreateView()
  {
    this.a = new wsw(this, this.mApp, this.mActivity, this.mContext, this.mSessionInfo.aTl);
    if (this.a.getRootView() == null) {}
    this.a.setCurrentShowType(1);
    return this.a.getRootView();
  }
  
  public void onDrawerClosed()
  {
    super.onDrawerClosed();
    if (this.a != null)
    {
      this.bfQ = true;
      this.a.onDrawerClosed();
    }
  }
  
  public void onDrawerOpened()
  {
    super.onDrawerOpened();
    if (this.a != null)
    {
      this.a.bdX = true;
      this.a.onDrawerOpened();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsv
 * JD-Core Version:    0.7.0.1
 */
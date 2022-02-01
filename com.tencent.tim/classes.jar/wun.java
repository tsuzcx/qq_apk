import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.2;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.3;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class wun
  implements acns, wvs
{
  private final QQAppInterface app;
  private final BaseChatPie c;
  private final BaseActivity mActivity;
  private List<MessageForShakeWindow> rV;
  private final MqqHandler uiHandler;
  private View wA;
  
  public wun(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.app = paramBaseChatPie.app;
    this.mActivity = paramBaseChatPie.a();
    this.uiHandler = paramBaseChatPie.getUIHandler();
  }
  
  private void doOnCreate()
  {
    this.app.a(this);
  }
  
  private void doOnDestroy()
  {
    this.app.b(this);
  }
  
  public int[] C()
  {
    return new int[] { 3, 13 };
  }
  
  public void CQ(int paramInt)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "beforeVibrate() is called,time is:" + System.currentTimeMillis());
      }
      this.uiHandler.post(new AIOShakeHelper.2(this));
    }
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      doOnCreate();
      return;
    }
    doOnDestroy();
  }
  
  public void J(MessageRecord paramMessageRecord)
  {
    if ((!paramMessageRecord.isread) && ((paramMessageRecord instanceof MessageForShakeWindow)))
    {
      paramMessageRecord = (MessageForShakeWindow)paramMessageRecord;
      paramMessageRecord.parse();
      if ((paramMessageRecord.mShakeWindowMsg != null) && (paramMessageRecord.mShakeWindowMsg.onlineFlag == 1))
      {
        if (this.rV == null) {
          this.rV = new ArrayList();
        }
        this.rV.add(paramMessageRecord);
      }
    }
  }
  
  public void a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if (paramMessageForShakeWindow == null) {
      return;
    }
    if (this.rV == null) {
      this.rV = new ArrayList();
    }
    this.rV.add(paramMessageForShakeWindow);
  }
  
  public void bIc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "startShakeAnim() is called,time is:" + System.currentTimeMillis());
    }
    ccg();
    AIOShakeHelper.1 local1 = new AIOShakeHelper.1(this, this.mActivity);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.mActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(this.mActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.uiHandler.postDelayed(local1, 60L);
        return;
      }
      local1.run();
      return;
    }
  }
  
  public void ccg()
  {
    ((ViewGroup)this.mActivity.getWindow().getDecorView()).getChildAt(0).clearAnimation();
    if ((this.wA != null) && (this.wA.getParent() != null)) {
      ((ViewGroup)this.wA.getParent()).removeView(this.wA);
    }
    this.wA = null;
  }
  
  public void cch()
  {
    MessageForShakeWindow localMessageForShakeWindow;
    if ((this.rV != null) && (this.rV.size() > 0))
    {
      localMessageForShakeWindow = (MessageForShakeWindow)this.rV.get(this.rV.size() - 1);
      if (!localMessageForShakeWindow.isSendFromLocal()) {
        break label80;
      }
      this.uiHandler.postDelayed(new AIOShakeHelper.3(this, localMessageForShakeWindow), 20L);
    }
    for (;;)
    {
      this.rV.clear();
      return;
      label80:
      long l = this.app.eV();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "time is:" + System.currentTimeMillis() + ",shmsgseq is:" + localMessageForShakeWindow.shmsgseq + ",msgUid is:" + localMessageForShakeWindow.msgUid + ",uniseq is:" + localMessageForShakeWindow.uniseq + ",onlineStatus is:" + l + ",userActiveStatus is:" + this.app.cxj);
      }
      if ((l == 11L) && (this.app.cxj == 0)) {
        this.uiHandler.postDelayed(new AIOShakeHelper.4(this, localMessageForShakeWindow), 20L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wun
 * JD-Core Version:    0.7.0.1
 */
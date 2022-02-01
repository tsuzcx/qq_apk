import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public class wxo
  extends Observable
  implements wvs
{
  private int HA;
  private TextView IC;
  private boolean aOD;
  private int aOr;
  private int bSo;
  private int bSp;
  private boolean bgq;
  private boolean bgr = true;
  private BaseChatPie c;
  private ChatXListView d;
  private View rK;
  
  public wxo(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.d = paramBaseChatPie.b;
  }
  
  private boolean b(BaseChatPie paramBaseChatPie)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    if (paramBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "chatPie is null");
      }
    }
    SessionInfo localSessionInfo;
    do
    {
      return false;
      localSessionInfo = paramBaseChatPie.sessionInfo;
      if (localSessionInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("UnreadBackBottomHelper", 2, "sessionInfo is null");
    return false;
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if ((paramBaseChatPie instanceof xys))
    {
      boolean bool4 = aqft.rj(localSessionInfo.aTl);
      boolean bool5 = aprg.V(paramBaseChatPie.app, localSessionInfo.aTl);
      bool2 = bool1;
      if (!bool4)
      {
        bool2 = bool1;
        if (!bool5) {
          bool2 = true;
        }
      }
    }
    if ((paramBaseChatPie instanceof ydz)) {
      bool2 = d(paramBaseChatPie.sessionInfo);
    }
    if ((paramBaseChatPie instanceof ybt)) {}
    for (bool1 = bool3;; bool1 = bool2) {
      return bool1;
    }
  }
  
  private void cdi()
  {
    if (!this.aOD) {}
    do
    {
      return;
      if ((this.c != null) && (this.IC == null)) {
        this.c.bHK();
      }
      this.bgr = false;
      notifyObservers();
    } while (!QLog.isColorLevel());
    QLog.d("UnreadBackBottomHelper", 2, "onScrollOutScreen");
  }
  
  private boolean d(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null) {}
    switch (paramSessionInfo.cZ)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void Ad(int paramInt)
  {
    if (!this.aOD) {}
    label237:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "delta: " + paramInt);
      }
      if (Math.abs(paramInt) >= 20) {
        if (paramInt > 0)
        {
          if ((this.IC != null) && (this.aOr == 0)) {
            this.IC.setVisibility(8);
          }
        }
        else if ((this.IC != null) && (this.aOr == 0) && (!this.bgr) && (!this.bgq))
        {
          Object localObject;
          if (this.c != null)
          {
            localObject = (AIOLongShotHelper)this.c.a(15);
            if ((localObject != null) && (((AIOLongShotHelper)localObject).RS())) {
              paramInt = 1;
            }
          }
          for (;;)
          {
            if ((this.IC.getVisibility() != 8) || (paramInt != 0)) {
              break label237;
            }
            this.IC.setText("");
            this.IC.setBackgroundResource(2130838065);
            this.IC.setVisibility(0);
            this.IC.setContentDescription("回到底部");
            if (this.c == null) {
              break;
            }
            localObject = this.c.sessionInfo;
            if (localObject == null) {
              break;
            }
            paramInt = en(((SessionInfo)localObject).cZ);
            if (paramInt == -1) {
              break;
            }
            cA("0X800AC88", paramInt);
            return;
            paramInt = 0;
            continue;
            paramInt = 0;
          }
        }
      }
    }
  }
  
  public int[] C()
  {
    return new int[] { 2 };
  }
  
  public void CY(int paramInt)
  {
    if (!this.aOD) {}
    while ((this.d == null) && (this.c.b == null)) {
      return;
    }
    this.d = this.c.b;
    View localView = this.d.getChildAt(0);
    if (localView != null)
    {
      this.rK = localView;
      this.HA = localView.getTop();
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "firstView != null. top: " + this.HA);
      }
    }
    if ((this.IC != null) && (this.aOr == 0))
    {
      this.IC.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "unread count is 0, core button gone");
      }
    }
    this.bgr = true;
  }
  
  public void CZ(int paramInt)
  {
    if (!this.aOD) {}
    do
    {
      do
      {
        return;
      } while (paramInt < 0);
      this.aOr = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d("UnreadBackBottomHelper", 2, "update unread count: " + paramInt);
  }
  
  public void Ck(int paramInt)
  {
    if ((paramInt == 2) && (b(this.c))) {
      zm(true);
    }
  }
  
  public boolean St()
  {
    if (this.IC == null) {}
    while (this.IC.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    paramInt4 = 0;
    if ((!this.aOD) || (this.c == null)) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.bgq = true;
      label27:
      if ((this.d == null) && (this.c.b == null)) {
        break label235;
      }
      this.d = this.c.b;
      if (paramInt7 <= 0)
      {
        if ((this.IC != null) && (this.aOr == 0) && (this.rK != null) && (this.HA - this.rK.getTop() < this.d.getHeight()))
        {
          this.IC.setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("UnreadBackBottomHelper", 2, "scroll to bottom, button gone");
          }
        }
        this.bSo = paramInt1;
        this.bSp = (paramInt3 - paramInt5 - paramInt1);
        View localView = this.d.getChildAt(0);
        if (localView != null) {
          this.rK = localView;
        }
      }
      if (paramInt1 + paramInt2 >= paramInt3 - paramInt5 - this.bSp) {
        break label237;
      }
    }
    label235:
    label237:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramInt2 = paramInt4;
      if (this.rK != null)
      {
        paramInt2 = paramInt4;
        if (this.rK.getTop() > this.HA + this.d.getHeight()) {
          paramInt2 = 1;
        }
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label242;
      }
      cdi();
      return;
      this.bgq = false;
      break label27;
      break;
    }
    label242:
    this.bgr = true;
  }
  
  public void cA(String paramString, int paramInt)
  {
    if (!this.aOD)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "switch is off. reportType: " + paramString + ", aioType: " + paramInt);
      }
      return;
    }
    anot.a(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public void cdj()
  {
    if (this.IC != null)
    {
      this.IC.setBackgroundResource(2130838460);
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "resume button to unread mode");
      }
    }
  }
  
  public void cdk()
  {
    if (this.IC != null) {
      this.IC.setVisibility(8);
    }
  }
  
  public int en(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public void onClick(View paramView)
  {
    if (this.c != null)
    {
      paramView = this.c.sessionInfo;
      if (paramView != null)
      {
        int i = en(paramView.cZ);
        if (i != -1) {
          cA("0X800AC89", i);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnreadBackBottomHelper", 2, "core button on click");
    }
  }
  
  public void w(TextView paramTextView)
  {
    if (!this.aOD) {}
    do
    {
      return;
      if ((paramTextView == null) && (QLog.isColorLevel())) {
        QLog.e("UnreadBackBottomHelper", 1, "button is null");
      }
      this.IC = paramTextView;
    } while (!QLog.isColorLevel());
    QLog.d("UnreadBackBottomHelper", 2, "attachButton success");
  }
  
  public void zm(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UnreadBackBottomHelper", 2, "state changed from: " + this.aOD + " to: " + paramBoolean);
    }
    this.aOD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxo
 * JD-Core Version:    0.7.0.1
 */
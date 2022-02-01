import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.4;
import com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.5;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.robotchat.RobotChatPanelLayout;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.e;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

public class wxk
  implements wvs
{
  private RobotPanelLayoutBase.e a;
  private QQAppInterface app;
  private int bSn;
  private BaseChatPie c;
  private Context mContext;
  private SessionInfo mSessionInfo;
  
  public wxk(BaseChatPie paramBaseChatPie)
  {
    this.app = paramBaseChatPie.app;
    this.mContext = paramBaseChatPie.mContext;
    this.c = paramBaseChatPie;
    this.mSessionInfo = paramBaseChatPie.sessionInfo;
    this.a = new wxl(this);
  }
  
  private void cdf()
  {
    Object localObject = (abrg)this.app.getManager(249);
    abrc localabrc = ((abrg)localObject).a();
    if (localabrc == null) {}
    do
    {
      do
      {
        return;
      } while (localabrc.cqT == 1);
      localObject = ((abrg)localObject).a();
    } while (localObject == null);
    ((SpriteUIHandler)localObject).c(this.app, this.mSessionInfo.cZ, this.mSessionInfo.aTl);
  }
  
  private int fi(int paramInt)
  {
    if (paramInt == 4) {
      return wja.dp2px(-11.0F, this.mContext.getResources());
    }
    return 0;
  }
  
  private void zk(boolean paramBoolean)
  {
    if (a() == null) {}
    ChatXListView localChatXListView;
    do
    {
      return;
      localChatXListView = this.c.b;
      if (!paramBoolean) {
        break;
      }
      i = wn();
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotHelper", 2, "setListViewPaddingBottom : robotheight:" + i);
      }
    } while (i == 0);
    int j = localChatXListView.getBottom() - this.c.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "setListViewPaddingBottom , old :" + j);
    }
    localChatXListView.setPadding(localChatXListView.getPaddingLeft(), localChatXListView.getPaddingTop(), localChatXListView.getPaddingRight(), i + j);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "setListViewPaddingBottom , old :" + localChatXListView.getPaddingBottom());
    }
    int i = localChatXListView.getBottom() - this.c.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "setListViewPaddingBottom , new :" + i);
    }
    localChatXListView.setPadding(localChatXListView.getPaddingLeft(), localChatXListView.getPaddingTop(), localChatXListView.getPaddingRight(), i);
  }
  
  public int[] C()
  {
    return new int[] { 13 };
  }
  
  public void CX(int paramInt)
  {
    Object localObject = a();
    if ((localObject == null) || (((RobotPanelLayoutBase)localObject).getVisibility() != 0)) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          i = ((RobotPanelLayoutBase)localObject).LH();
        } while (paramInt == i);
        ((RobotPanelLayoutBase)localObject).setInputLineCount(paramInt);
      } while ((i != 4) && (paramInt != 4));
      paramInt = fi(paramInt);
      localObject = ((RobotPanelLayoutBase)localObject).getLayoutParams();
    } while (!(localObject instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
  }
  
  public void Ck(int paramInt) {}
  
  public boolean Sr()
  {
    return ((this.c instanceof xwn)) || ((this.c instanceof ydw));
  }
  
  public boolean Ss()
  {
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    if (localRobotPanelLayoutBase == null) {}
    while (localRobotPanelLayoutBase.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public RobotPanelLayoutBase a()
  {
    TroopAIORobotLayout localTroopAIORobotLayout = null;
    if ((this.c instanceof xwn)) {
      localTroopAIORobotLayout = ((xwn)this.c).a;
    }
    while (!(this.c instanceof ydw)) {
      return localTroopAIORobotLayout;
    }
    return ((ydw)this.c).a;
  }
  
  public void a(int paramInt, RobotPanelLayoutBase paramRobotPanelLayoutBase, RelativeLayout paramRelativeLayout)
  {
    if ((paramRobotPanelLayoutBase == null) || (paramRelativeLayout == null)) {}
    do
    {
      do
      {
        return;
        paramRobotPanelLayoutBase = (TextView)paramRelativeLayout.findViewById(2131372041);
        if (paramRobotPanelLayoutBase != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopRobotHelper", 2, "updateListUnRead unread textview is null");
      return;
      paramRobotPanelLayoutBase = paramRobotPanelLayoutBase.getLayoutParams();
    } while (!(paramRobotPanelLayoutBase instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramRobotPanelLayoutBase).addRule(2, 2131362504);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    if (localRobotPanelLayoutBase == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "invokeRobotFunction, troopuin:" + paramString1 + " robotuin:" + paramString2 + " robotname:" + paramString3);
    }
    aptw localaptw = (aptw)this.app.getManager(203);
    if ((this.c instanceof xwn))
    {
      if (!paramString1.equals(this.mSessionInfo.aTl)) {
        return false;
      }
      if (!localaptw.qY(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopRobotHelper", 2, "invokeRobotFunction, is not rotot troop:" + paramString1);
        }
        return false;
      }
    }
    else if ((this.c instanceof ydw))
    {
      if (!paramString2.equals(this.mSessionInfo.aTl)) {
        return false;
      }
    }
    else
    {
      return false;
    }
    localRobotPanelLayoutBase.a(this.c, paramString1, paramString2, paramString3, paramString5, paramString4, paramString7, paramString6);
    return true;
  }
  
  public void bz(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str1 = paramBundle.getString("troopuin");
    String str2 = paramBundle.getString("robotuin");
    String str3 = paramBundle.getString("robotname");
    String str4 = paramBundle.getString("onurl");
    String str5 = paramBundle.getString("ontitle");
    String str6 = paramBundle.getString("offurl");
    paramBundle = paramBundle.getString("offtitle");
    ThreadManager.getUIHandler().post(new TroopRobotHelper.4(this, str1, str2, str3, str6, paramBundle, str4, str5));
  }
  
  public boolean c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    Object localObject = null;
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    paramMotionEvent = localObject;
    if (!paramBoolean)
    {
      paramMotionEvent = localObject;
      if (this.app != null) {
        paramMotionEvent = ((abrg)this.app.getManager(249)).a();
      }
    }
    if ((paramMotionEvent != null) && (paramMotionEvent.cqT == 1) && (localRobotPanelLayoutBase != null) && (localRobotPanelLayoutBase.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotHelper", 2, "onDoubleTap, do not show sprite!!");
      }
      return true;
    }
    return false;
  }
  
  public void cde()
  {
    if (!Sr()) {}
    label155:
    for (;;)
    {
      return;
      if (this.c.b.getChildCount() > 0)
      {
        int j = 0;
        int m = wn();
        int k = this.c.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop() - m;
        int i = this.c.b.getChildCount() - 1;
        if (i >= 0)
        {
          View localView = this.c.b.getChildAt(i);
          if ((k > localView.getTop()) && (k <= localView.getBottom()))
          {
            j = i + this.c.b.getFirstVisiblePosition();
            i = k - localView.getBottom();
          }
        }
        for (;;)
        {
          if (j == -1) {
            break label155;
          }
          this.c.b.setOnMeasureListener(new wxm(this, j, i + m));
          return;
          i -= 1;
          break;
          k = -1;
          i = j;
          j = k;
        }
      }
    }
  }
  
  public void cdg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "initRobotPanel");
    }
    if (!Sr()) {}
    label406:
    label407:
    for (;;)
    {
      return;
      ViewGroup localViewGroup = (ViewGroup)this.c.mAIORootView.findViewById(2131364469);
      if ((localViewGroup != null) && (this.mContext != null))
      {
        Object localObject1 = (RobotPanelLayoutBase)this.c.mAIORootView.findViewById(2131362504);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopRobotHelper", 2, "initRobotPanel, find panel , reinit");
          }
          ((RobotPanelLayoutBase)localObject1).init();
          if ((this.c instanceof xwn)) {
            ((xwn)this.c).a = ((TroopAIORobotLayout)localObject1);
          }
          for (;;)
          {
            ((RobotPanelLayoutBase)localObject1).setListener(this.a);
            return;
            if ((this.c instanceof ydw)) {
              ((ydw)this.c).a = ((RobotChatPanelLayout)localObject1);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopRobotHelper", 2, "initRobotPanel, create panel ");
        }
        if ((this.c instanceof xwn)) {
          localObject1 = (TroopAIORobotLayout)LayoutInflater.from(this.mContext).inflate(2131558706, localViewGroup, false);
        }
        for (;;)
        {
          label194:
          if (localObject1 == null) {
            break label407;
          }
          Object localObject2 = ((RobotPanelLayoutBase)localObject1).getLayoutParams();
          if ((localObject2 instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131369277);
          }
          localObject2 = this.c.mAIORootView.findViewById(2131362412);
          int i = 1;
          if (localObject2 != null) {
            i = localViewGroup.indexOfChild((View)localObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopRobotHelper", 2, "initRobotPanel, addview index:" + i);
          }
          localViewGroup.addView((View)localObject1, i);
          if ((this.c instanceof xwn)) {
            ((xwn)this.c).a = ((TroopAIORobotLayout)localObject1);
          }
          for (;;)
          {
            ((RobotPanelLayoutBase)localObject1).setListener(this.a);
            localObject1 = (wxk)this.c.a(23);
            if (localObject1 == null) {
              break;
            }
            ((wxk)localObject1).l(false);
            return;
            if (!(this.c instanceof ydw)) {
              break label406;
            }
            localObject1 = (RobotChatPanelLayout)LayoutInflater.from(this.mContext).inflate(2131558686, localViewGroup, false);
            break label194;
            if ((this.c instanceof ydw)) {
              ((ydw)this.c).a = ((RobotChatPanelLayout)localObject1);
            }
          }
        }
      }
    }
  }
  
  public void cdh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "unInitRobotPanel");
    }
    if (!Sr()) {}
    for (;;)
    {
      return;
      Object localObject;
      if ((this.c instanceof xwn)) {
        localObject = ((xwn)this.c).a;
      }
      while (localObject != null)
      {
        ((RobotPanelLayoutBase)localObject).setListener(null);
        return;
        if ((this.c instanceof ydw)) {
          localObject = ((ydw)this.c).a;
        } else {
          localObject = null;
        }
      }
    }
  }
  
  public void fg(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
      } while (a() == null);
      paramView = paramView.getLayoutParams();
    } while (!(paramView instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramView).addRule(2, 2131362504);
  }
  
  public String l(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "showRobotLayout : " + paramBoolean);
    }
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    Object localObject;
    if (localRobotPanelLayoutBase == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = localRobotPanelLayoutBase.BC();
      if (!paramBoolean) {
        break;
      }
      localObject = str;
    } while (localRobotPanelLayoutBase.getItemCount() == 0);
    if (localRobotPanelLayoutBase.getVisibility() != 0) {
      aprg.d(this.app, "0X8009FA1", str, "");
    }
    localRobotPanelLayoutBase.setVisibility(0);
    cdf();
    if ((localRobotPanelLayoutBase.LH() == 0) && (this.c.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      CX(this.c.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
    }
    cde();
    for (;;)
    {
      zj(paramBoolean);
      zk(paramBoolean);
      return str;
      localRobotPanelLayoutBase.setVisibility(8);
    }
  }
  
  public int wn()
  {
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    if (localRobotPanelLayoutBase == null) {}
    int i;
    do
    {
      return 0;
      int j = localRobotPanelLayoutBase.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotHelper", 2, "getRobotPanelHeight : robotheight:" + j);
      }
      i = j;
      if (j == 0)
      {
        if (this.bSn != 0) {
          return this.bSn;
        }
        localRobotPanelLayoutBase.measure(0, 0);
        j = localRobotPanelLayoutBase.getMeasuredHeight();
        this.bSn = j;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopRobotHelper", 2, "getRobotPanelHeight : measure height:" + j);
          i = j;
        }
      }
    } while (i == 0);
    return i;
  }
  
  public void xO(String paramString)
  {
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l == 0L)
      {
        QLog.e("TroopRobotHelper", 2, "RobotRed troopUin is 0 ");
        return;
      }
    }
    catch (Exception paramString)
    {
      long l;
      for (;;)
      {
        QLog.e("TroopRobotHelper", 2, "RobotRed UpdateRobotInfoInSubThread EXCEP" + paramString.toString());
        l = 0L;
      }
      ThreadManager.getSubThreadHandler().post(new TroopRobotHelper.5(this, l));
    }
  }
  
  public void zj(boolean paramBoolean)
  {
    if (!Sr()) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotHelper", 2, "adjustBlurView : pie is invalid");
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.c.mAIORootView.findViewById(2131381443);
        if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopRobotHelper", 2, "adjustBlurView : blur not visible");
      return;
      localObject = ((View)localObject).getLayoutParams();
    } while (!(localObject instanceof RelativeLayout.LayoutParams));
    Object localObject = (RelativeLayout.LayoutParams)localObject;
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "adjustBlurView :" + paramBoolean);
    }
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131362504);
      return;
    }
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131369277);
  }
  
  public void zl(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "tryShowRobotLayout:" + paramBoolean);
    }
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    if (localRobotPanelLayoutBase == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotHelper", 2, "tryShowRobotLayout, panel is null");
      }
    }
    label91:
    do
    {
      do
      {
        do
        {
          return;
          if (paramBoolean) {
            break label91;
          }
          if (localRobotPanelLayoutBase.getVisibility() == 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopRobotHelper", 2, "tryShowRobotLayout, panel is hide");
        return;
        l(paramBoolean);
        return;
        if (localRobotPanelLayoutBase.getVisibility() != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopRobotHelper", 2, "tryShowRobotLayout, panel is show");
      return;
      if (((this.c instanceof xwn)) && (((xwn)this.c).bkf))
      {
        String str1 = ((xwn)this.c).aWO;
        String str2 = ((xwn)this.c).aWP;
        ((TroopAIORobotLayout)localRobotPanelLayoutBase).a(this.mSessionInfo.aTl, str1, str2, (xwn)this.c, new wxn(this, str1));
        return;
      }
      if ((this.c instanceof ydw))
      {
        if (localRobotPanelLayoutBase.getItemCount() > 0)
        {
          l(true);
          return;
        }
        l(false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopRobotHelper", 2, "tryShowRobotLayout, mIsShowRobotIcon = false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxk
 * JD-Core Version:    0.7.0.1
 */
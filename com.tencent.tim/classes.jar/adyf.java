import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.d;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.DrawerFrame.c;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView.b;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONObject;

public class adyf
  implements Handler.Callback, ChatXListView.d, wvs
{
  private View Bq;
  private View Br;
  private final int FA;
  private Handler V;
  private adyf.a jdField_a_of_type_Adyf$a;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  private DrawerFrame.c jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$c = new adyg(this);
  private byte aY = 0;
  private AnimatorSet ak;
  private boolean bRS;
  private boolean bRT;
  private boolean bRU;
  private boolean bRV;
  private BaseChatPie c;
  private int cLn = -1;
  private int cLo = 0;
  private View cX;
  private View cY;
  private ChatXListView d;
  private boolean hasVibrate;
  private int mLastX;
  private Scroller mScroller;
  private int mStartX;
  private int mStartY;
  
  public adyf(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.FA = ViewConfiguration.get(this.c.mContext).getScaledTouchSlop();
    this.mScroller = new Scroller(this.c.mContext, new SwipListView.b());
    this.V = new Handler(Looper.getMainLooper(), this);
  }
  
  private int BY()
  {
    return wja.dp2px(59.0F, this.d.getResources());
  }
  
  private int BZ()
  {
    return BY();
  }
  
  private int Ca()
  {
    return wja.dp2px(89.0F, this.d.getResources());
  }
  
  private void L(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.mStartX;
    float f2 = this.mStartY;
    float f1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2 - f2);
    if ((f1 > this.FA) || (paramFloat2 > this.FA))
    {
      if (paramFloat2 / f1 >= 0.6F) {
        break label177;
      }
      if (paramFloat1 >= 0.0F) {
        break label169;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "swipeDirectionJudge intercept the left swipe gesture");
      }
      this.aY = 1;
      if ((this.d.getAdapter() instanceof auts))
      {
        ListAdapter localListAdapter = ((auts)this.d.getAdapter()).getWrappedAdapter();
        if ((localListAdapter instanceof wki)) {
          ((wki)localListAdapter).bYX();
        }
      }
      this.d.requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("hidePanelFromGesture", 2, "swipeDirectionJudge mSlideStartDir: " + this.aY);
      }
      return;
      label169:
      this.aY = 2;
      continue;
      label177:
      this.aY = 2;
    }
  }
  
  private void LG(int paramInt)
  {
    int i = 0;
    if (paramInt >= BY())
    {
      boolean bool;
      if (!this.hasVibrate)
      {
        bool = aqel.b(BaseApplicationImpl.getApplication().getApplicationContext(), this.c.app);
        if ((!this.c.app.YI()) || (bool)) {
          break label108;
        }
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          this.hasVibrate = true;
          if (QLog.isColorLevel()) {
            QLog.d("LeftSwipeReplyHelper", 2, "scrollItemView Vibrator do vibrate");
          }
          if (!this.bRT) {
            ((Vibrator)this.c.app.getApp().getSystemService("vibrator")).vibrate(100L);
          }
        }
        return;
        label108:
        paramInt = i;
        if (this.c.app.abu())
        {
          paramInt = i;
          if (this.c.app.abv())
          {
            paramInt = i;
            if (!bool) {
              paramInt = 1;
            }
          }
        }
      }
    }
    this.hasVibrate = false;
  }
  
  private boolean Rm()
  {
    if ((this.c.sessionInfo.cZ == 1) && (((apsw)this.c.app.getManager(48)).a(this.c.sessionInfo.aTl, true).cSk))
    {
      QQToast.a(this.c.app.getApp(), 2131699615, 0).show(this.c.mContext.getResources().getDimensionPixelSize(2131299627));
      return true;
    }
    return false;
  }
  
  private void Z(MotionEvent paramMotionEvent)
  {
    View localView = this.d.getChildAt(this.cLn - this.d.getFirstVisiblePosition());
    if (((localView instanceof BaseChatItemLayout)) && (k(((BaseChatItemLayout)localView).findViewById(2131364503), paramMotionEvent)))
    {
      this.cX = localView;
      this.Bq = this.cX.findViewById(2131364526);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LeftSwipeReplyHelper", 2, "determineWhetherConsume() is called. ev" + paramMotionEvent);
    }
  }
  
  private void a(int paramInt, View paramView1, View paramView2)
  {
    int j = BY();
    int k = paramView1.getScrollX();
    int i = Ca();
    if (Math.abs(k) >= BZ())
    {
      paramInt = (int)((paramInt - this.mLastX) * 0.25F);
      paramInt = k - paramInt;
      if (paramInt <= i) {
        break label139;
      }
      paramInt = i;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "scrollItemView : scrollX -> " + k + ", targetX " + paramInt + ", replyDistance -> " + j);
      }
      paramView1.scrollTo(paramInt, 0);
      LG(paramInt);
      ag(paramView2, paramInt);
      return;
      paramInt -= this.mLastX;
      break;
      label139:
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
  }
  
  private boolean aO(int paramInt1, int paramInt2)
  {
    float f1 = Math.abs(paramInt1 - this.mStartX);
    float f2 = Math.abs(paramInt2 - this.mStartY);
    if ((f1 <= this.FA) && (f2 <= this.FA))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "onTouchEventConsume ACTION_MOVE judge fail");
      }
      return true;
    }
    return false;
  }
  
  private boolean afQ()
  {
    boolean bool = true;
    ChatMessage localChatMessage = c();
    if (localChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while ((localChatMessage.shmsgseq == 0L) || ((localChatMessage instanceof MessageForLongTextMsg)) || ((localChatMessage instanceof MessageForMixedMsg)) || ((localChatMessage instanceof MessageForTribeShortVideo)));
        if (((localChatMessage instanceof MessageForScribble)) || ((localChatMessage instanceof MessageForHiBoom)))
        {
          if (localChatMessage.istroop == 0) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
      } while (((localChatMessage.istroop == 3000) || (localChatMessage.istroop == 1)) && ((localChatMessage instanceof MessageForArkFlashChat)));
      if ((this.jdField_a_of_type_Adyf$a != null) && (adyf.a.a(this.jdField_a_of_type_Adyf$a, localChatMessage))) {
        return adyf.a.b(this.jdField_a_of_type_Adyf$a, localChatMessage);
      }
      if ((localChatMessage.senderuin != null) && (localChatMessage.isSupportReply()) && (!localChatMessage.senderuin.equals(this.c.app.getCurrentUin()))) {
        return true;
      }
    } while ((!localChatMessage.isSend()) || (!localChatMessage.isSupportReply()) || (localChatMessage.extraflag == 32772) || (localChatMessage.extraflag == 32768) || (localChatMessage.istroop == 3000));
    return true;
  }
  
  private boolean afR()
  {
    if (this.cLo == 0)
    {
      this.cLo = 1;
      if (((c() instanceof MessageForPtt)) && (((MessageForPtt)c()).playProgress > 0.0F)) {
        this.cLo = 2;
      }
      if (this.cLo != 2)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager == null) && (this.c != null) && (this.c.app != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.c.app.getManager(24));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a() == c()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.isPlaying())) {
          this.cLo = 2;
        }
      }
    }
    return this.cLo == 2;
  }
  
  private void ag(View paramView, int paramInt)
  {
    int i = BY();
    if (!this.bRV) {
      if (paramInt >= i)
      {
        this.bRV = true;
        this.ak = new AnimatorSet();
        this.ak.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F }) });
        this.ak.setDuration(150L);
        this.ak.addListener(new adyh(this));
        this.ak.start();
        if (paramView.getVisibility() != 0) {
          paramView.setVisibility(0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("LeftSwipeReplyHelper", 2, "doReplyIconAlphaAnimation : object animation start");
        }
      }
    }
    do
    {
      do
      {
        return;
        if ((this.ak == null) || (!this.ak.isRunning())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LeftSwipeReplyHelper", 2, "doReplyIconAlphaAnimation : object animation not finish");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "doReplyIconAlphaAnimation : set alpha by scroll distance");
      }
      paramView.setAlpha(z(paramInt));
    } while (paramView.getVisibility() == 0);
    paramView.setVisibility(0);
  }
  
  private boolean ah(MotionEvent paramMotionEvent)
  {
    int k = (int)(paramMotionEvent.getX() + 0.5F);
    int j = (int)(paramMotionEvent.getY() + 0.5F) - ImmersiveUtils.getStatusBarHeight(this.c.mContext);
    if (k < this.d.getWidth() - BaseChatItemLayout.bNX - wja.dp2px(5.0F, this.c.mContext.getResources()) - BaseChatItemLayout.bOz) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = j;
      if (this.d.isOverscrollHeadVisiable()) {
        i = j + this.d.getScrollY();
      }
      i = this.d.pointToPosition(k, i);
      if (i < 0) {
        break;
      }
      View localView = this.d.getChildAt(i - this.d.getFirstVisiblePosition());
      if (!(localView instanceof BaseChatItemLayout)) {
        break;
      }
      boolean bool = k(((BaseChatItemLayout)localView).findViewById(2131364503), paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "isInterestedMotionEvent() is called. ev" + paramMotionEvent + "right to left touchPointInView = " + bool);
      }
      return bool;
    }
    return false;
  }
  
  private int c(ChatMessage paramChatMessage)
  {
    int i = 8;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if (paramChatMessage.structingMsg != null)
      {
        if (paramChatMessage.structingMsg.mMsgServiceID == 35) {
          i = 1;
        }
        while (paramChatMessage.structingMsg.mMsgServiceID == 95) {
          return i;
        }
      }
    }
    for (;;)
    {
      return 10;
      if ((paramChatMessage instanceof MessageForShortVideo)) {
        return 6;
      }
      if ((paramChatMessage instanceof MessageForPic))
      {
        if (((MessageForPic)paramChatMessage).checkGif()) {
          return 4;
        }
        return 5;
      }
      if ((paramChatMessage instanceof MessageForText))
      {
        paramChatMessage = new aofk(((MessageForText)paramChatMessage).sb, 8);
        if ((paramChatMessage.mSpans != null) && (paramChatMessage.mSpans.length > 0))
        {
          paramChatMessage = paramChatMessage.mSpans;
          int j = paramChatMessage.length;
          i = 0;
          while (i < j)
          {
            if ((paramChatMessage[i] instanceof aofk.b)) {
              return 7;
            }
            i += 1;
          }
        }
        return 2;
      }
      if ((paramChatMessage instanceof MessageForMarketFace)) {
        return 3;
      }
      if (((paramChatMessage instanceof MessageForFile)) || ((paramChatMessage instanceof MessageForTroopFile))) {
        return 9;
      }
      if ((paramChatMessage instanceof MessageForArkApp)) {
        try
        {
          boolean bool = "101458937".equals(new JSONObject(((MessageForArkApp)paramChatMessage).ark_app_message.metaList).optJSONObject("news").optString("appid"));
          if (bool) {
            return 8;
          }
        }
        catch (Throwable paramChatMessage)
        {
          paramChatMessage.printStackTrace();
        }
      }
    }
  }
  
  private ChatMessage c()
  {
    if ((this.cLn >= 0) && (this.cLn < this.d.getAdapter().getCount()))
    {
      Object localObject = this.d.getAdapter().getItem(this.cLn);
      if ((localObject instanceof ChatMessage)) {
        return (ChatMessage)localObject;
      }
    }
    return null;
  }
  
  private void cVe()
  {
    n(this.cX, this.Bq);
    this.cLo = 0;
    this.cX = null;
    this.Bq = null;
    this.mLastX = -1;
    this.cLn = -1;
    this.mStartX = -1;
    this.mStartY = -1;
    this.aY = 0;
    this.bRV = false;
    this.d.requestDisallowInterceptTouchEvent(false);
  }
  
  private void cVf()
  {
    if (!Rm())
    {
      Object localObject = c();
      if (localObject != null)
      {
        anot.a(this.c.app, "dc00898", "", "", "0X800A92F", "0X800A92F", c((ChatMessage)localObject), d((ChatMessage)localObject), "", "", "", "");
        this.c.d((ChatMessage)localObject);
        if ((localObject instanceof MessageForStructing))
        {
          localObject = (MessageForStructing)localObject;
          if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 81) && (this.c.app != null)) {
            rar.a(this.c.app, this.c.mContext, (MessageForStructing)localObject, "reply");
          }
        }
      }
    }
  }
  
  private int d(ChatMessage paramChatMessage)
  {
    switch (paramChatMessage.istroop)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  private int gS(int paramInt)
  {
    int i = Ca();
    if (i > 0) {
      return (int)(Math.abs(paramInt) / i * 150.0F) + 50;
    }
    return 150;
  }
  
  private boolean k(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramView == null) {
      return false;
    }
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int k = paramMotionEvent[0];
    int m = paramMotionEvent[1];
    int n = paramView.getMeasuredWidth();
    int i1 = paramView.getMeasuredHeight();
    if ((j >= m) && (j <= i1 + m) && (i >= k) && (i <= n + k)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void n(View paramView1, View paramView2)
  {
    if (paramView1 != null) {}
    for (int i = paramView1.getScrollX();; i = 0)
    {
      if (i != 0)
      {
        this.cY = paramView1;
        this.Br = paramView2;
        int j = BY();
        int k = -i;
        this.mScroller.startScroll(i, 0, k, 0, gS(k));
        this.V.sendEmptyMessage(0);
        if ((i >= j) && (!this.bRT)) {
          cVf();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "recoveryReplyItem : scrollX -> " + i);
      }
      return;
    }
  }
  
  private float z(float paramFloat)
  {
    float f1 = 0.0F;
    float f2 = (Math.abs(paramFloat) - (BaseChatItemLayout.bOD + BaseChatItemLayout.bOE)) / wja.dp2px(20.0F, this.d.getResources());
    if (f2 < 0.0F) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "getReplyIconAlpha : scrollX -> " + paramFloat + ", alpha -> " + f1 + ", BaseChatItemLayout.replayIconSize -> " + BaseChatItemLayout.bOD + ", BaseChatItemLayout.replayIconLeftMargin -> " + BaseChatItemLayout.bOE);
      }
      return f1;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      } else {
        f1 = f2;
      }
    }
  }
  
  public int[] C()
  {
    return new int[] { 3, 13 };
  }
  
  public void Ck(int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.d = this.c.b;
      if (((this.c instanceof xys)) || ((this.c instanceof TroopChatPie)) || ((this.c instanceof xyi))) {
        bool = true;
      }
      this.bRS = bool;
      if (this.c.app != null) {
        this.jdField_a_of_type_Adyf$a = new adyf.a(this.c.app, null);
      }
      this.d.setOnTouchEventConsumer(this);
      this.c.a.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$c);
      return;
      this.bRS = false;
      if (this.d != null) {
        this.d.setOnTouchEventConsumer(null);
      }
    } while ((this.c == null) || (this.c.a == null));
    this.c.a.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$c);
  }
  
  public void GQ(boolean paramBoolean)
  {
    this.bRU = paramBoolean;
  }
  
  public boolean af(MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("LeftSwipeReplyHelper", 2, "onInterceptTouchEvent ：" + paramMotionEvent);
    }
    boolean bool1;
    if ((this.bRT) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
      bool1 = true;
    }
    label287:
    do
    {
      do
      {
        int k;
        int j;
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!this.bRS);
              bool1 = bool2;
            } while (BaseChatItemLayout.bdx);
            k = (int)(paramMotionEvent.getX() + 0.5F);
            j = (int)(paramMotionEvent.getY() + 0.5F);
            switch (paramMotionEvent.getAction())
            {
            default: 
              return false;
            case 0: 
              this.mStartX = k;
              this.mStartY = j;
              this.bRV = false;
              if (k < this.d.getWidth() - BaseChatItemLayout.bNX - wja.dp2px(5.0F, this.c.mContext.getResources()) - BaseChatItemLayout.bOz) {}
              for (;;)
              {
                bool1 = bool2;
                if (i == 0) {
                  break;
                }
                i = j;
                if (this.d.isOverscrollHeadVisiable()) {
                  i = j + this.d.getScrollY();
                }
                this.cLn = this.d.pointToPosition(k, i);
                bool1 = bool2;
                if (this.cLn < 0) {
                  break;
                }
                Z(paramMotionEvent);
                return false;
                i = 0;
              }
            case 2: 
              if (this.aY != 0) {
                break label287;
              }
              bool1 = bool2;
            }
          } while (aO(k, j));
          bool1 = bool2;
        } while (afR());
        if (this.cX == null)
        {
          this.aY = 2;
          return false;
        }
        if (!afQ())
        {
          this.aY = 2;
          return false;
        }
        if (this.aY == 0) {
          L(k, j);
        }
        if (this.aY == 1) {}
        for (bool1 = true;; bool1 = false) {
          return bool1;
        }
        cVe();
        this.bRT = false;
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("LeftSwipeReplyHelper", 2, "onInterceptTouchEvent ACTION_CANCEL isSwipeItemReused value set : false");
      return false;
      cVe();
      this.bRT = false;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("LeftSwipeReplyHelper", 2, "onInterceptTouchEvent ACTION_UP isSwipeItemReused value set : false");
    return false;
  }
  
  public boolean afS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("hidePanelFromGesture", 2, "mSlideStartDir : " + this.aY + ", forceCloseSoftInput: " + this.bRU);
    }
    if (this.bRU) {}
    do
    {
      return true;
      if (this.aY == 0) {
        return false;
      }
    } while (this.aY != 1);
    return false;
  }
  
  public boolean ag(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LeftSwipeReplyHelper", 2, "onTouchEvent ：" + paramMotionEvent);
    }
    if ((this.bRT) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
      return true;
    }
    int i;
    int j;
    if ((this.bRS) && (!BaseChatItemLayout.bdx))
    {
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      this.bRV = false;
      this.mStartX = i;
      this.mStartY = j;
      this.mLastX = i;
      continue;
      if ((this.aY == 0) && (aO(i, j))) {
        return false;
      }
      if (afR()) {
        return false;
      }
      if (this.cX == null)
      {
        this.aY = 2;
        return false;
      }
      if (!afQ())
      {
        this.aY = 2;
        return false;
      }
      if (this.aY == 0) {
        L(i, j);
      }
      if ((this.aY == 1) && (this.cX != null))
      {
        a(i, this.cX, this.Bq);
        this.mLastX = i;
        return true;
      }
      this.mLastX = i;
      continue;
      cVe();
      this.bRT = false;
      if (QLog.isColorLevel())
      {
        QLog.d("LeftSwipeReplyHelper", 2, "onTouchEvent ACTION_CANCEL isSwipeItemReused value set : false");
        continue;
        cVe();
        this.bRT = false;
        if (QLog.isColorLevel()) {
          QLog.d("LeftSwipeReplyHelper", 2, "onTouchEvent ACTION_UP isSwipeItemReused value set : false");
        }
      }
    }
  }
  
  public void gq(View paramView)
  {
    if ((paramView != null) && (paramView == this.cX))
    {
      paramView = (BaseBubbleBuilder.e)paramView.getTag();
      if ((paramView != null) && (paramView.pos + 1 != this.cLn))
      {
        this.bRT = true;
        if (QLog.isColorLevel()) {
          QLog.d("LeftSwipeReplyHelper", 2, "isSwipeItemReused value set :  true, motionPos -> " + this.cLn + ", holder.pos -> " + paramView.pos);
        }
        cVe();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = this.mScroller.computeScrollOffset();
    float f1 = this.mScroller.getCurrX();
    if ((this.bRV) && (this.Br != null))
    {
      float f2 = z(f1);
      this.Br.setAlpha(f2);
    }
    if ((this.cY != null) && (this.cY.getScrollX() > (int)f1))
    {
      this.cY.scrollTo((int)f1, 0);
      this.d.invalidate();
    }
    if (bool)
    {
      this.V.sendEmptyMessage(0);
      return false;
    }
    this.cY = null;
    if (this.Br != null) {
      this.Br.setVisibility(4);
    }
    this.Br = null;
    return false;
  }
  
  static final class a
    extends xeh
  {
    private a(QQAppInterface paramQQAppInterface)
    {
      super(paramQQAppInterface, null, null, null);
    }
    
    private boolean F(ChatMessage paramChatMessage)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramChatMessage != null)
      {
        int i = a(this.app, paramChatMessage);
        if ((i != 81) && (i != 66) && (i != 42) && (i != 47))
        {
          bool1 = bool2;
          if (i != 89) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    private boolean G(ChatMessage paramChatMessage)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      int i;
      MessageForArkApp localMessageForArkApp;
      if (paramChatMessage != null)
      {
        i = a(this.app, paramChatMessage);
        if (i != 81) {
          break label152;
        }
        if (!(paramChatMessage instanceof MessageForArkApp)) {
          break label150;
        }
        localMessageForArkApp = (MessageForArkApp)paramChatMessage;
        if ((localMessageForArkApp.isMultiMsg) || (localMessageForArkApp.istroop != 0)) {
          break label150;
        }
        if ((paramChatMessage.senderuin.equals(this.app.getCurrentUin())) || (!paramChatMessage.isSupportReply())) {
          break label95;
        }
        if (localMessageForArkApp.msg == null) {
          break label90;
        }
        bool1 = true;
      }
      label90:
      label95:
      do
      {
        do
        {
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
          if ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000)) {
            break;
          }
          bool1 = bool2;
        } while (localMessageForArkApp.msg != null);
        return false;
        return false;
        if ((i == 66) || (i == 42) || (i == 47)) {
          break;
        }
        bool1 = bool2;
      } while (i != 89);
      label150:
      label152:
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyf
 * JD-Core Version:    0.7.0.1
 */
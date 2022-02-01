import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.os.SystemClock;
import android.support.v4.util.ArraySet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.b;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.b;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ymg
  extends wki
{
  public final String TAG = getClass().getSimpleName();
  protected ymg.a a;
  protected ymg.b a;
  protected QQAppInterface app;
  public boolean bnz;
  public boolean mHasMore;
  protected SessionInfo mSessionInfo;
  
  public ymg(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, null, null);
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Ymg$b = new ymg.b(null);
    this.mSessionInfo = paramSessionInfo;
  }
  
  private List<ChatMessage> aI(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord instanceof ChatMessage)) {
        localArrayList.add((ChatMessage)localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  private void fQ(int paramInt1, int paramInt2)
  {
    Object localObject;
    label9:
    ChatMessage localChatMessage;
    boolean bool1;
    if (paramInt1 == 0)
    {
      localObject = null;
      long l1 = 0L;
      if (paramInt1 >= paramInt2) {
        break label287;
      }
      localChatMessage = (ChatMessage)this.list.get(paramInt1);
      boolean bool2 = anbk.lt(localChatMessage.msgtype);
      if ((!bool2) || ((paramInt1 != 0) && ((localChatMessage.time >= this.createTime) || (localChatMessage.time - l1 <= 300L)) && ((localChatMessage.time < this.createTime) || (localChatMessage.time - l1 <= 300L) || ((localObject != null) && (localChatMessage.time - ((ChatMessage)localObject).time <= 60L))) && ((!this.b.contains(Long.valueOf(localChatMessage.uniseq))) || (l1 / 60L == localChatMessage.time / 60L)))) {
        break label281;
      }
      bool1 = true;
      label164:
      localChatMessage.mNeedTimeStamp = bool1;
      if (localChatMessage.mNeedTimeStamp)
      {
        long l2 = localChatMessage.time;
        l1 = l2;
        if (localChatMessage.time < this.createTime)
        {
          wmy.I(localChatMessage);
          l1 = l2;
        }
      }
      if ((!bool2) || (((localChatMessage instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localChatMessage).tipParam.dbK == 1))) {
        break label327;
      }
      localObject = localChatMessage;
    }
    label281:
    label287:
    label327:
    for (;;)
    {
      localChatMessage.isFlowMessage = false;
      localChatMessage.isDui = false;
      paramInt1 += 1;
      break label9;
      localObject = (ChatMessage)this.list.get(paramInt1 - 1);
      break;
      bool1 = false;
      break label164;
      if (this.list.size() > 0) {
        this.b.add(Long.valueOf(((ChatMessage)this.list.get(0)).uniseq));
      }
      return;
    }
  }
  
  public boolean B(ChatMessage paramChatMessage)
  {
    return this.list.remove(paramChatMessage);
  }
  
  protected boolean Rq()
  {
    return false;
  }
  
  public void a(ymg.a parama)
  {
    this.jdField_a_of_type_Ymg$a = parama;
  }
  
  public int b(List<MessageRecord> paramList, boolean paramBoolean)
  {
    paramList = aI(paramList);
    int i = paramList.size();
    int k = this.list.size();
    this.list.addAll(0, paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.bnz = paramBoolean;
      int j = this.list.size();
      if ((k > 0) && (j > 200))
      {
        k = Math.max(paramList.size(), 200);
        this.list.subList(k, j).clear();
        this.mHasMore = true;
      }
      fQ(0, paramList.size());
      return i;
    }
  }
  
  public int c(List<MessageRecord> paramList, boolean paramBoolean)
  {
    int j = 0;
    paramList = aI(paramList);
    int k = this.list.size();
    this.list.addAll(paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mHasMore = paramBoolean;
      int m = this.list.size();
      int i = j;
      if (k > 0)
      {
        i = j;
        if (m > 200)
        {
          i = Math.min(m - 200, k);
          this.list.subList(0, i).clear();
          i = -i;
          this.bnz = true;
          fQ(0, 1);
        }
      }
      fQ(this.list.size() - paramList.size(), this.list.size());
      return i;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ChatMessage localChatMessage = (ChatMessage)this.list.get(paramInt);
    Object localObject = this.jdField_a_of_type_Xeh.a(localChatMessage, this);
    if ((localObject instanceof BaseBubbleBuilder)) {
      ((BaseBubbleBuilder)localObject).bdo = true;
    }
    View localView = ((wko)localObject).a(paramInt, this.list.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_Ymg$b);
    if (localView != null) {
      localView.setTag(2131364516, localChatMessage);
    }
    if ((localView instanceof BaseChatItemLayout)) {
      ((BaseChatItemLayout)localView).removeAllStickers();
    }
    if ((localChatMessage.msgtype == -2009) || (localChatMessage.msgtype == -2016)) {
      ((xrc)localObject).zw(false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "AIOTime getView " + localChatMessage.getClass().getName());
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      if (localChatMessage.msgtype == -2076)
      {
        if ((localObject instanceof xjd)) {
          ((xjd)localObject).setClickable(false);
        }
      }
      else if ((localChatMessage.msgtype == -2039) && ((localObject instanceof ApolloItemBuilder)))
      {
        ((ApolloItemBuilder)localObject).setClickable(false);
        localObject = (ApolloItemBuilder.b)wja.a(localView);
        ((ApolloItemBuilder.b)localObject).a.setUnread(false, null, null);
        if (((ApolloItemBuilder.b)localObject).iconView != null)
        {
          localObject = ((ApolloItemBuilder.b)localObject).iconView.getDrawable();
          if ((localObject != null) && ((localObject instanceof AnimationDrawable)))
          {
            ((AnimationDrawable)localObject).stop();
            ((AnimationDrawable)localObject).selectDrawable(0);
          }
        }
      }
      else if (localChatMessage.msgtype == -2071)
      {
        ((LightVideoItemBuilder)localObject).q((ListView)paramViewGroup);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void N(ChatMessage paramChatMessage);
  }
  
  class b
    implements View.OnClickListener, BubblePopupWindow.b, wlz
  {
    aavv jdField_a_of_type_Aavv;
    boolean bdE = false;
    boolean bdF = false;
    private PointF downPoint = new PointF();
    ChatMessage h;
    View wc;
    View wd;
    
    private b() {}
    
    void ez(View paramView)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
      paramView.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
    
    public void onClick(View paramView)
    {
      int i = paramView.getId();
      Object localObject1;
      label157:
      Object localObject2;
      if (this.h != null)
      {
        if (i == 2131365686)
        {
          if (ymg.this.jdField_a_of_type_Ymg$a != null) {
            ymg.this.jdField_a_of_type_Ymg$a.N(this.h);
          }
          if (ymg.this.mSessionInfo.cZ == 1) {
            anot.a(ymg.this.app, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_del", 0, 0, ymg.this.mSessionInfo.aTl, "", "", "");
          }
        }
        for (;;)
        {
          if ((i != 2131377931) && (aavp.a().isSelected())) {
            aavp.a().detach();
          }
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if ((i != 2131365509) || ((this.h instanceof MessageForPtt))) {
            break label327;
          }
          if (!aavp.a().isSelected()) {
            break;
          }
          localObject1 = aavp.a().qL();
          localObject2 = (ClipboardManager)BaseApplicationImpl.getApplication().getSystemService("clipboard");
          alkw.a((ClipboardManager)localObject2, (CharSequence)localObject1);
          ((ClipboardManager)localObject2).setText((CharSequence)localObject1);
          if (ymg.this.mSessionInfo.cZ == 1) {
            anot.a(ymg.this.app, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_copy", 0, 0, ymg.this.mSessionInfo.aTl, "", "", "");
          }
        }
        if ((this.h instanceof MessageForStructing))
        {
          localObject2 = (MessageForStructing)this.h;
          localObject1 = this.h.msg;
          if ((localObject2 == null) || (((MessageForStructing)localObject2).structingMsg == null) || (!"web".equals(((MessageForStructing)localObject2).structingMsg.mMsgAction)) || (((MessageForStructing)localObject2).structingMsg.mMsgUrl == null)) {
            break label391;
          }
          localObject1 = ((MessageForStructing)localObject2).structingMsg.mMsgUrl;
        }
      }
      label391:
      for (;;)
      {
        break label157;
        localObject1 = this.h.msg;
        break label157;
        label327:
        localObject1 = ymg.this.jdField_a_of_type_Xeh.a(this.h, ymg.this);
        localObject2 = paramView.getContext();
        ((wko)localObject1).bOY = 2;
        ((wko)localObject1).a(paramView.getId(), (Context)localObject2, this.h);
        break;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
        break;
      }
    }
    
    public void onDismiss()
    {
      this.bdF = false;
      if (this.jdField_a_of_type_Aavv != null) {
        this.jdField_a_of_type_Aavv.czM();
      }
      Object localObject1;
      if (this.h != null)
      {
        localObject1 = ymg.this.jdField_a_of_type_Xeh.a(this.h, ymg.this);
        if ((localObject1 instanceof BaseBubbleBuilder))
        {
          ((BaseBubbleBuilder)localObject1).bYO();
          localObject1 = ((BaseBubbleBuilder)localObject1).a(this.wc);
          if (localObject1 != null) {
            ((BaseBubbleBuilder.d)localObject1).v(this.wc, true);
          }
        }
      }
      for (;;)
      {
        Object localObject2;
        if (this.wc != null)
        {
          this.wc.setPressed(false);
          localObject2 = this.wc.getTag();
          if ((localObject2 == null) || (!(localObject2 instanceof anqv))) {
            break label153;
          }
          ((anqv)localObject2).hG(this.wc);
        }
        label153:
        label378:
        do
        {
          for (;;)
          {
            this.wc = null;
            this.wd = null;
            return;
            if ((!(localObject2 instanceof StructingMsgItemBuilder.a)) || (this.wd == null)) {
              break;
            }
            Object localObject3 = (StructingMsgItemBuilder.a)localObject2;
            this.wd.getLayoutParams();
            this.wd.getPaddingLeft();
            this.wd.getPaddingTop();
            this.wd.getPaddingRight();
            this.wd.getPaddingBottom();
            if (this.bdE) {
              if (((StructingMsgItemBuilder.a)localObject3).b != null) {
                ((StructingMsgItemBuilder.a)localObject3).b.a(ymg.this.app, ((StructingMsgItemBuilder.a)localObject3).mMessage.isSend(), ((StructingMsgItemBuilder.a)localObject3).mMessage.needVipBubble(), true, ((StructingMsgItemBuilder.a)localObject3).E, false);
              }
            }
            for (;;)
            {
              localObject1 = this.wd.findViewById(2131369004);
              if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
                break label378;
              }
              ((PAHighLightImageView)localObject1).dIv();
              break;
              if ((this.h != null) && (this.h.istroop == 1008))
              {
                if (!((StructingMsgItemBuilder.a)localObject3).bib) {
                  this.wd.setBackgroundResource(2130838401);
                }
              }
              else
              {
                localObject3 = (MessageForStructing)this.h;
                if (localObject1 == null) {
                  ymg.d((MessageForStructing)localObject3, (BaseBubbleBuilder.e)localObject2, this.wd, false);
                }
              }
            }
            localObject1 = this.wd.findViewById(2131378845);
            if ((localObject1 != null) && ((localObject1 instanceof PAHighLightImageView))) {
              ((PAHighLightImageView)localObject1).dIv();
            }
          }
        } while (!(localObject2 instanceof ansl));
        localObject1 = this.wd.getLayoutParams();
        int i = this.wd.getPaddingLeft();
        int j = this.wd.getPaddingTop();
        int k = this.wd.getPaddingRight();
        int m = this.wd.getPaddingBottom();
        int n = ((Integer)this.wd.getTag(2131378828)).intValue();
        if (n == 0) {
          this.wd.setBackgroundResource(2130838389);
        }
        for (;;)
        {
          this.wd.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.wd.setPadding(i, j, k, m);
          break;
          if (n == 2) {
            this.wd.setBackgroundResource(2130838393);
          } else {
            this.wd.setBackgroundResource(2130838391);
          }
        }
        localObject1 = null;
      }
    }
    
    public boolean onLongClick(View paramView)
    {
      this.bdF = true;
      if (ymg.this.bdC) {}
      for (boolean bool1 = false; (!bool1) && (this.jdField_a_of_type_Aavv != null) && (this.jdField_a_of_type_Aavv.isShow()); bool1 = ymg.this.jdField_a_of_type_Aavs.R(paramView))
      {
        ez(paramView);
        return false;
      }
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      Object localObject4 = (wko.a)wja.a(paramView);
      Object localObject2 = new aqoa();
      Object localObject3 = ((wko.a)wja.a(paramView)).mMessage;
      Object localObject1 = ymg.this.jdField_a_of_type_Xeh.a((ChatMessage)localObject3, ymg.this);
      aqob[] arrayOfaqob = ((wko)localObject1).a(paramView);
      int j;
      int k;
      if ((arrayOfaqob != null) && (arrayOfaqob.length > 0))
      {
        j = arrayOfaqob.length;
        i = 0;
        while (i < j)
        {
          aqob localaqob = arrayOfaqob[i];
          k = localaqob.getItemId();
          if ((k == 2131365509) || (k == 2131377931) || (k == 2131367523) || (k == 2131366733)) {
            ((aqoa)localObject2).a(localaqob);
          }
          i += 1;
        }
      }
      ((aqoa)localObject2).Z(2131365686, ymg.this.app.getApp().getResources().getString(2131691404), 2130839081);
      if (((aqoa)localObject2).size() > 0)
      {
        this.h = ((wko.a)localObject4).mMessage;
        if (!(this.h instanceof MessageForStructing)) {
          break label1163;
        }
      }
      label1163:
      for (int i = 1;; i = 0)
      {
        k = (int)this.downPoint.y;
        int m = wja.dp2px(10.0F, paramView.getResources());
        localObject4 = new int[2];
        paramView.getLocationOnScreen((int[])localObject4);
        j = localObject4[1] - wja.dp2px(3.0F, paramView.getResources());
        localObject4 = new Rect();
        paramView.getWindowVisibleDisplayFrame((Rect)localObject4);
        if (j - wja.dp2px(72.0F, paramView.getResources()) > ((Rect)localObject4).top) {}
        for (;;)
        {
          if (this.jdField_a_of_type_Aavv == null)
          {
            this.jdField_a_of_type_Aavv = new aavo(ymg.a(ymg.this));
            this.jdField_a_of_type_Aavv.setOnClickListener(this);
            this.jdField_a_of_type_Aavv.a(this);
          }
          this.jdField_a_of_type_Aavv.clV = ((int)this.downPoint.y);
          k = (int)this.downPoint.x - aqnm.dpToPx(14.0F);
          this.jdField_a_of_type_Aavv.clW = k;
          boolean bool2;
          if (bool1)
          {
            localObject4 = this.jdField_a_of_type_Aavv;
            if ((localObject3 != null) && (((ChatMessage)localObject3).isMultiMsg))
            {
              bool2 = true;
              ((aavv)localObject4).a((aqoa)localObject2, bool2);
              this.jdField_a_of_type_Aavv.GI(k);
              this.jdField_a_of_type_Aavv.GJ(j);
              label491:
              ez(paramView);
              if (i != 0)
              {
                paramView.setPressed(true);
                this.wc = paramView;
                localObject2 = this.wc.getTag();
                if (!(localObject2 instanceof anqv)) {
                  break label691;
                }
                ((anqv)localObject2).hH(this.wc);
              }
              label539:
              if ((localObject1 instanceof BaseBubbleBuilder))
              {
                localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
                if (localObject1 != null)
                {
                  this.wc = paramView;
                  if (!bool1) {
                    break label1117;
                  }
                  ((BaseBubbleBuilder.d)localObject1).v(paramView, true);
                }
              }
              label582:
              if (bool1)
              {
                if ((this.downPoint == null) || (!ymg.this.jdField_a_of_type_Aavs.a(paramView, this.downPoint.x, this.downPoint.y, 1, 2))) {
                  break label1129;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ChatHistoryBubbleListAdapter", 2, "performCursorTouch ");
                }
              }
            }
          }
          for (;;)
          {
            return true;
            bool2 = false;
            break;
            localObject3 = this.jdField_a_of_type_Aavv.a(paramView, ymg.b(ymg.this));
            this.jdField_a_of_type_Aavv.a(paramView, k, ((aavv.a)localObject3).clX, (aqoa)localObject2, true, ((aavv.a)localObject3).clY);
            break label491;
            label691:
            if ((localObject2 instanceof StructingMsgItemBuilder.a))
            {
              localObject4 = (StructingMsgItemBuilder.a)localObject2;
              if ((localObject1 instanceof StructingMsgItemBuilder))
              {
                if (((StructingMsgItemBuilder)localObject1).a(this.h) == 0)
                {
                  if ((((StructingMsgItemBuilder.a)localObject4).hL != null) && (((StructingMsgItemBuilder.a)localObject4).hL.getChildCount() > 0)) {
                    this.wd = ((StructingMsgItemBuilder.a)localObject4).hL.getChildAt(0);
                  }
                  this.bdE = false;
                }
              }
              else
              {
                label766:
                if ((this.wd == null) || (((StructingMsgItemBuilder.a)localObject4).bib)) {
                  break label893;
                }
                localObject3 = this.wd.getLayoutParams();
                i = this.wd.getPaddingLeft();
                j = this.wd.getPaddingTop();
                k = this.wd.getPaddingRight();
                m = this.wd.getPaddingBottom();
                if (!this.bdE) {
                  break label909;
                }
                if (!((StructingMsgItemBuilder.a)localObject4).mMessage.isSend()) {
                  break label895;
                }
                ((StructingMsgItemBuilder.a)localObject4).E.setBackgroundResource(2130851001);
              }
              for (;;)
              {
                this.wd.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.wd.setPadding(i, j, k, m);
                break;
                this.wd = ((StructingMsgItemBuilder.a)localObject4).hL;
                this.bdE = true;
                break label766;
                label893:
                break;
                label895:
                ((StructingMsgItemBuilder.a)localObject4).E.setBackgroundResource(2130850824);
                continue;
                if (this.h.istroop == 1008)
                {
                  this.wd.setBackgroundResource(2130838403);
                }
                else
                {
                  localObject4 = (MessageForStructing)this.h;
                  if (((BaseBubbleBuilder)localObject1).a(paramView) == null) {
                    ymg.c((MessageForStructing)localObject4, (BaseBubbleBuilder.e)localObject2, this.wd, true);
                  }
                }
              }
            }
            label909:
            if (!(localObject2 instanceof ansl)) {
              break label539;
            }
            this.wd = paramView;
            localObject2 = this.wd.getLayoutParams();
            i = this.wd.getPaddingLeft();
            j = this.wd.getPaddingTop();
            k = this.wd.getPaddingRight();
            m = this.wd.getPaddingBottom();
            int n = ((Integer)paramView.getTag(2131378828)).intValue();
            if (n == 0) {
              this.wd.setBackgroundResource(2130838390);
            }
            for (;;)
            {
              this.wd.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.wd.setPadding(i, j, k, m);
              break;
              if (n == 2) {
                this.wd.setBackgroundResource(2130838394);
              } else {
                this.wd.setBackgroundResource(2130838392);
              }
            }
            label1117:
            ((BaseBubbleBuilder.d)localObject1).v(paramView, false);
            break label582;
            label1129:
            ymg.this.jdField_a_of_type_Aavs.a(paramView, this.jdField_a_of_type_Aavv);
          }
          ez(paramView);
          return false;
          j = k - m;
        }
      }
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.downPoint.x = paramMotionEvent.getRawX();
        this.downPoint.y = paramMotionEvent.getRawY();
      }
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
      }
      Object localObject = ymg.this.jdField_a_of_type_Xeh.a(wja.a(paramView), ymg.this);
      if ((!this.bdF) && ((localObject instanceof BaseBubbleBuilder)))
      {
        localObject = ((BaseBubbleBuilder)localObject).a(paramView);
        if (localObject != null) {
          ((BaseBubbleBuilder.d)localObject).e(paramView, paramMotionEvent);
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymg
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.os.SystemClock;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.b;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.b;
import com.tencent.widget.ListView;
import java.util.Calendar;
import java.util.List;

public class wkl
  extends wki
{
  private wkl.a jdField_a_of_type_Wkl$a;
  private wkl.b jdField_a_of_type_Wkl$b = new wkl.b(null);
  public int bFo = -1;
  public Calendar j;
  public Calendar k;
  Context mContext;
  
  public wkl(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie, wkl.a parama)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.mContext = paramContext;
    this.jdField_a_of_type_Wkl$a = parama;
  }
  
  private void bYY()
  {
    long l1 = 0L;
    int i = 0;
    Object localObject = null;
    ChatMessage localChatMessage;
    boolean bool1;
    if (i < this.list.size())
    {
      localChatMessage = (ChatMessage)this.list.get(i);
      boolean bool2 = anbk.lt(localChatMessage.msgtype);
      if ((bool2) && ((i == 0) || ((localChatMessage.time < this.createTime) && (localChatMessage.time - l1 > 300L)) || ((localChatMessage.time >= this.createTime) && (localChatMessage.time - l1 > 300L) && ((localObject == null) || (localChatMessage.time - localObject.time > 60L))) || ((this.b.contains(Long.valueOf(localChatMessage.uniseq))) && (l1 / 60L != localChatMessage.time / 60L))))
      {
        bool1 = true;
        label170:
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
          break label283;
        }
        localObject = localChatMessage;
      }
    }
    label283:
    for (;;)
    {
      if (i != this.list.size() - 1) {
        localChatMessage.isFlowMessage = false;
      }
      i += 1;
      break;
      bool1 = false;
      break label170;
      return;
    }
  }
  
  protected boolean Rq()
  {
    return false;
  }
  
  public int a(List<ChatMessage> paramList, int paramInt1, Calendar paramCalendar1, Calendar paramCalendar2, int paramInt2, MessageRecord paramMessageRecord)
  {
    if ((paramList == null) || (paramCalendar1 == null)) {
      return -1;
    }
    int i;
    int m;
    if (paramInt1 == 2)
    {
      if ((this.k != null) && (this.k.get(1) == paramCalendar1.get(1)) && (this.k.get(2) == paramCalendar1.get(2)) && (this.k.get(5) == paramCalendar1.get(5))) {
        return -1;
      }
      this.k = ((Calendar)paramCalendar1.clone());
      paramInt2 = paramList.size() + 2;
      this.list.addAll(0, paramList);
      bYY();
      if (this.list.size() > 0) {
        this.b.add(Long.valueOf(((ChatMessage)this.list.get(0)).uniseq));
      }
      i = paramInt2;
      if (paramInt1 == 6)
      {
        i = paramInt2;
        if (paramMessageRecord != null)
        {
          m = this.list.size();
          paramInt1 = 0;
        }
      }
    }
    else
    {
      for (;;)
      {
        if (paramInt1 >= m) {
          break label584;
        }
        i = paramInt2;
        if (((ChatMessage)this.list.get(paramInt1)).shmsgseq == paramMessageRecord.shmsgseq)
        {
          if (paramInt1 < m - 1) {}
          for (paramInt2 = paramInt1 + 2;; paramInt2 = paramInt1)
          {
            i = paramInt2;
            if (!QLog.isColorLevel()) {
              break label573;
            }
            QLog.d("ChatHistoryC2CAllFragment", 2, "refreshData---> cache id: " + ((ChatMessage)this.list.get(paramInt1)).getId() + ", searchRecord id: " + paramMessageRecord.getId() + ",msgseq:" + ((ChatMessage)this.list.get(paramInt1)).msgseq + ",searchRecord: " + paramMessageRecord.msgseq + ",selection:" + paramInt2 + ",cacheRecords size:" + m + ",msg text:" + ((ChatMessage)this.list.get(paramInt1)).msg + ",search text:" + paramMessageRecord.msg);
            notifyDataSetChanged();
            return paramInt2;
            if (paramInt1 == 3)
            {
              if ((this.j != null) && (this.j.get(1) == paramCalendar1.get(1)) && (this.j.get(2) == paramCalendar1.get(2)) && (this.j.get(5) == paramCalendar1.get(5))) {
                return -1;
              }
              this.j = ((Calendar)paramCalendar1.clone());
              this.list.addAll(paramList);
              break;
            }
            if ((paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 1) || (paramInt1 == 0))
            {
              this.k = ((Calendar)paramCalendar1.clone());
              if (paramCalendar2 == null) {
                break label553;
              }
            }
            label553:
            for (this.j = ((Calendar)paramCalendar2.clone());; this.j = ((Calendar)paramCalendar1.clone()))
            {
              this.list.clear();
              this.list.addAll(paramList);
              paramInt2 = 0;
              break;
            }
          }
        }
        label573:
        paramInt1 += 1;
        paramInt2 = i;
      }
      label584:
      i = paramInt2;
    }
    notifyDataSetChanged();
    return i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ChatMessage localChatMessage = (ChatMessage)this.list.get(paramInt);
    Object localObject = this.jdField_a_of_type_Xeh.a(localChatMessage, this);
    View localView = ((wko)localObject).a(paramInt, this.list.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_Wkl$b);
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
        QLog.d("ChatHistoryAdapterForC2C", 2, "AIOTime getView " + localChatMessage.getClass().getName());
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      if (localChatMessage.msgtype == -2076)
      {
        if ((localObject instanceof xjd)) {
          ((xjd)localObject).setClickable(false);
        }
      }
      else if (localChatMessage.msgtype == -2039)
      {
        if ((localObject instanceof ApolloItemBuilder))
        {
          ((ApolloItemBuilder)localObject).setClickable(false);
          localObject = (ApolloItemBuilder.b)wja.a(localView);
          if (localObject != null)
          {
            ((ApolloItemBuilder.b)localObject).a.setUnread(false, null, null);
            if (((ApolloItemBuilder.b)localObject).iconView != null)
            {
              localObject = ((ApolloItemBuilder.b)localObject).iconView.getDrawable();
              if ((localObject instanceof AnimationDrawable))
              {
                ((AnimationDrawable)localObject).stop();
                ((AnimationDrawable)localObject).selectDrawable(0);
              }
            }
          }
        }
        else if ((localObject instanceof wyk))
        {
          ((wyk)localObject).setClickable(false);
        }
      }
      else if (localChatMessage.msgtype == -2071) {
        ((LightVideoItemBuilder)localObject).q((ListView)paramViewGroup);
      }
    }
  }
  
  public void gg(List<MessageRecord> paramList)
  {
    if (paramList == null) {
      this.list.clear();
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.list.removeAll(paramList);
      paramList.clear();
    }
  }
  
  public static abstract interface a
  {
    public abstract void F(MessageRecord paramMessageRecord);
  }
  
  class b
    implements View.OnClickListener, BubblePopupWindow.b, wlz
  {
    aavv jdField_a_of_type_Aavv;
    boolean bdE = false;
    boolean bdF = false;
    private boolean bdH = true;
    private boolean bdI;
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
      if (this.h != null) {
        if (i == 2131365686)
        {
          if (wkl.a(wkl.this) != null) {
            wkl.a(wkl.this).F(this.h);
          }
          VipUtils.a(wkl.this.app, "chat_history", "ChatHistory", "Clk_delete", 1, 0, new String[0]);
        }
      }
      for (;;)
      {
        if ((i != 2131377931) && (aavp.a().isSelected())) {
          aavp.a().detach();
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Object localObject;
        if (i == 2131379277)
        {
          anot.a(wkl.this.app, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
          localObject = (MessageForFile)this.h;
          localObject = ahav.a(wkl.this.app, (MessageForFile)localObject);
          if (localObject != null) {
            aoag.a((FileManagerEntity)localObject, wkl.this.mContext, wkl.this.app, 1);
          } else {
            QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131720917), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
          }
        }
        else
        {
          localObject = wkl.this.jdField_a_of_type_Xeh.a(this.h, wkl.this);
          Context localContext = paramView.getContext();
          ((wko)localObject).a(paramView.getId(), localContext, this.h);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
          }
        }
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
        localObject1 = wkl.this.jdField_a_of_type_Xeh.a(this.h, wkl.this);
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
          if (!(localObject2 instanceof anqv)) {
            break label148;
          }
          ((anqv)localObject2).hG(this.wc);
        }
        label148:
        label328:
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
            if (this.bdE) {
              if (((StructingMsgItemBuilder.a)localObject3).b != null) {
                ((StructingMsgItemBuilder.a)localObject3).b.a(wkl.this.app, ((StructingMsgItemBuilder.a)localObject3).mMessage.isSend(), ((StructingMsgItemBuilder.a)localObject3).mMessage.needVipBubble(), true, ((StructingMsgItemBuilder.a)localObject3).E, false);
              }
            }
            for (;;)
            {
              localObject1 = this.wd.findViewById(2131369004);
              if (!(localObject1 instanceof PAHighLightImageView)) {
                break label328;
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
                  wki.a((MessageForStructing)localObject3, (BaseBubbleBuilder.e)localObject2, this.wd, false);
                }
              }
            }
            localObject1 = this.wd.findViewById(2131378845);
            if ((localObject1 instanceof PAHighLightImageView)) {
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
      if (wkl.this.bdC) {}
      for (boolean bool1 = false;; bool1 = wkl.this.jdField_a_of_type_Aavs.R(paramView))
      {
        this.bdF = true;
        if ((paramView instanceof ArkAppView)) {
          ((ArkAppView)paramView).onLongClick(paramView);
        }
        if ((bool1) || (this.jdField_a_of_type_Aavv == null) || (!this.jdField_a_of_type_Aavv.isShow())) {
          break;
        }
        ez(paramView);
        return false;
      }
      Object localObject3 = new aqoa();
      this.h = ((wko.a)wja.a(paramView)).mMessage;
      int i = this.h.msgtype;
      if ((i == -2014) || (i == -2005))
      {
        if (this.bdH)
        {
          this.bdI = aetq.a().ahT();
          this.bdH = false;
        }
        localObject1 = (MessageForFile)this.h;
        localObject4 = ahav.a(wkl.this.app, (MessageForFile)localObject1);
        if ((localObject4 != null) && (((FileManagerEntity)localObject4).status != 16))
        {
          long l = ahav.d(wkl.this.app, ((FileManagerEntity)localObject4).fileName);
          localObject2 = aeuc.a().ud();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = aobw.cjR;
          }
          if ((this.bdI) && (aobw.v(((FileManagerEntity)localObject4).getFilePath(), ((FileManagerEntity)localObject4).fileName, (String)localObject1)) && (((FileManagerEntity)localObject4).fileSize <= l))
          {
            anot.a(wkl.this.app, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
            ((aqoa)localObject3).Z(2131379277, wkl.this.mContext.getString(2131720920), 2130839097);
          }
        }
      }
      Object localObject2 = ((wko.a)wja.a(paramView)).mMessage;
      Object localObject1 = wkl.this.jdField_a_of_type_Xeh.a((ChatMessage)localObject2, wkl.this);
      Object localObject4 = ((wko)localObject1).a(paramView);
      int j;
      int k;
      if ((localObject4 != null) && (localObject4.length > 0))
      {
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          aqob localaqob = localObject4[i];
          k = localaqob.getItemId();
          if (((k == 2131365509) || (k == 2131377931) || (k == 2131367523) || (k == 2131366733)) && (localaqob.getDrawable() != 2130838567)) {
            ((aqoa)localObject3).a(localaqob);
          }
          i += 1;
        }
      }
      ((aqoa)localObject3).Z(2131365686, wkl.this.app.getApp().getResources().getString(2131691404), 2130839081);
      if (((aqoa)localObject3).size() > 0)
      {
        this.h = ((wko.a)wja.a(paramView)).mMessage;
        if ((this.h == null) || (!(this.h instanceof MessageForStructing))) {
          break label1407;
        }
      }
      label735:
      label1010:
      label1139:
      label1407:
      for (i = 1;; i = 0)
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
            this.jdField_a_of_type_Aavv = new aavo(wkl.this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
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
            if ((localObject2 != null) && (((ChatMessage)localObject2).isMultiMsg))
            {
              bool2 = true;
              ((aavv)localObject4).a((aqoa)localObject3, bool2);
              this.jdField_a_of_type_Aavv.GI(k);
              this.jdField_a_of_type_Aavv.GJ(j);
              ez(paramView);
              if (i != 0)
              {
                paramView.setPressed(true);
                this.wc = paramView;
                localObject2 = this.wc.getTag();
                if (!(localObject2 instanceof anqv)) {
                  break label935;
                }
                ((anqv)localObject2).hH(this.wc);
              }
              if ((localObject1 instanceof BaseBubbleBuilder))
              {
                localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
                if (localObject1 != null)
                {
                  this.wc = paramView;
                  if (!bool1) {
                    break label1361;
                  }
                  ((BaseBubbleBuilder.d)localObject1).v(paramView, true);
                }
              }
              if (bool1)
              {
                if ((this.downPoint == null) || (!wkl.this.jdField_a_of_type_Aavs.a(paramView, this.downPoint.x, this.downPoint.y, 1, 2))) {
                  break label1373;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ChatHistoryAdapterForC2C", 2, "performCursorTouch ");
                }
              }
            }
          }
          for (;;)
          {
            return true;
            bool2 = false;
            break;
            localObject2 = this.jdField_a_of_type_Aavv.a(paramView, wkl.this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            this.jdField_a_of_type_Aavv.a(paramView, k, ((aavv.a)localObject2).clX, (aqoa)localObject3, true, ((aavv.a)localObject2).clY);
            break label735;
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
                if ((this.wd == null) || (((StructingMsgItemBuilder.a)localObject4).bib)) {
                  break label1137;
                }
                localObject3 = this.wd.getLayoutParams();
                i = this.wd.getPaddingLeft();
                j = this.wd.getPaddingTop();
                k = this.wd.getPaddingRight();
                m = this.wd.getPaddingBottom();
                if (!this.bdE) {
                  break label1153;
                }
                if (!((StructingMsgItemBuilder.a)localObject4).mMessage.isSend()) {
                  break label1139;
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
                break label1010;
                break;
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
                    wki.a((MessageForStructing)localObject4, (BaseBubbleBuilder.e)localObject2, this.wd, true);
                  }
                }
              }
            }
            if (!(localObject2 instanceof ansl)) {
              break label783;
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
            ((BaseBubbleBuilder.d)localObject1).v(paramView, false);
            break label826;
            wkl.this.jdField_a_of_type_Aavs.a(paramView, this.jdField_a_of_type_Aavv);
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
      Object localObject = wkl.this.jdField_a_of_type_Xeh.a(((wko.a)wja.a(paramView)).mMessage, wkl.this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkl
 * JD-Core Version:    0.7.0.1
 */
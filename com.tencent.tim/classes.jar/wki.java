import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.support.v4.util.ArraySet;
import android.support.v4.util.SparseArrayCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.b;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class wki
  extends auvp
  implements aqdf.a
{
  @Deprecated
  public static long HM = -1L;
  private static SparseArrayCompat<yhs> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private static yhs jdField_a_of_type_Yhs = new yhq();
  private static boolean bdD;
  CharSequence I = null;
  public Boolean Y = Boolean.valueOf(true);
  public aavs a;
  public aavu a;
  public aqdf a;
  protected BaseChatPie a;
  protected ListView a;
  public wki.a a;
  public xeh a;
  QQAppInterface app;
  protected ArraySet<Long> b = new ArraySet();
  public boolean bdC;
  protected long createTime;
  protected List<ChatMessage> list = new ArrayList();
  protected Context mContext;
  SessionInfo sessionInfo;
  
  public wki(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Xeh = new xeh(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.sessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Aqdf = new aqdf(paramQQAppInterface);
    this.jdField_a_of_type_Aqdf.a(this);
    this.mContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie == null) {}
    for (long l = NetConnInfoCenter.getServerTime();; l = paramBaseChatPie.getCreateTime())
    {
      this.createTime = l;
      this.jdField_a_of_type_Aavs = new aavs(this, paramQQAppInterface);
      this.jdField_a_of_type_Aavu = new aavu(paramBaseChatPie);
      this.jdField_a_of_type_Wki$a = new wki.a();
      return;
    }
  }
  
  @Nullable
  private ChatMessage a(List<ChatMessage> paramList)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "create time: " + this.createTime);
    }
    long l1 = 0L;
    int i = 0;
    if (i < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      boolean bool2 = anbk.lt(localChatMessage.msgtype);
      label198:
      Object localObject2;
      if ((bool2) && ((i == 0) || ((localChatMessage.time < this.createTime) && (localChatMessage.time - l1 > 300L)) || ((localChatMessage.time >= this.createTime) && (localChatMessage.time - l1 > 300L) && ((localObject1 == null) || (localChatMessage.time - localObject1.time > 60L))) || ((this.b.contains(Long.valueOf(localChatMessage.uniseq))) && (l1 / 60L != localChatMessage.time / 60L))))
      {
        bool1 = true;
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
        if ((i < 50) && (QLog.isColorLevel()))
        {
          if ((localChatMessage.msg == null) || (localChatMessage.msg.length() <= 0)) {
            break label458;
          }
          localObject2 = localChatMessage.msg.substring(0, 1);
          label287:
          StringBuilder localStringBuilder = new StringBuilder().append("msg: ").append((String)localObject2).append(", type: ").append(localChatMessage.msgtype).append(", mNeedTimeStamp: ").append(localChatMessage.mNeedTimeStamp).append(", time: ").append(localChatMessage.time).append(", lastTimestamp: ").append(l1).append(", last time: ");
          if (localObject1 != null) {
            break label466;
          }
          localObject2 = "null";
          label368:
          QLog.d("ChatAdapter1", 2, localObject2);
        }
        localObject2 = localObject1;
        if (bool2)
        {
          localObject2 = localObject1;
          if (!ahwb.aB(localChatMessage)) {
            localObject2 = localChatMessage;
          }
        }
        if (i != paramList.size() - 1) {
          localChatMessage.isFlowMessage = false;
        }
        if (i != 0) {
          break label479;
        }
      }
      label458:
      label466:
      label479:
      for (boolean bool1 = true;; bool1 = false)
      {
        localChatMessage.isFirstMsg = bool1;
        i += 1;
        localObject1 = localObject2;
        break;
        bool1 = false;
        break label198;
        localObject2 = "";
        break label287;
        localObject2 = Long.valueOf(localObject1.time);
        break label368;
      }
    }
    return localObject1;
  }
  
  private String a(MessageForText paramMessageForText)
  {
    if (paramMessageForText.sb != null) {
      return paramMessageForText.sb.toString();
    }
    return paramMessageForText.msg;
  }
  
  protected static void a(MessageForStructing paramMessageForStructing, BaseBubbleBuilder.e parame, View paramView, boolean paramBoolean)
  {
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {
      return;
    }
    bYW();
    yhs localyhs2 = (yhs)jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramMessageForStructing.structingMsg.mMsgServiceID);
    yhs localyhs1 = localyhs2;
    if (localyhs2 == null) {
      localyhs1 = jdField_a_of_type_Yhs;
    }
    localyhs1.b(paramMessageForStructing, parame, paramView, paramBoolean);
  }
  
  private boolean a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    boolean bool2 = false;
    Object localObject = ((MessageForMarketFace)paramChatMessage1).mMarkFaceMessage;
    MarkFaceMessage localMarkFaceMessage = ((MessageForMarketFace)paramChatMessage2).mMarkFaceMessage;
    if (localObject == null) {
      paramChatMessage1.parse();
    }
    for (paramChatMessage1 = ((MessageForMarketFace)paramChatMessage1).mMarkFaceMessage;; paramChatMessage1 = (ChatMessage)localObject)
    {
      localObject = localMarkFaceMessage;
      if (localMarkFaceMessage == null)
      {
        paramChatMessage2.parse();
        localObject = ((MessageForMarketFace)paramChatMessage2).mMarkFaceMessage;
      }
      boolean bool1 = bool2;
      if (paramChatMessage1 != null)
      {
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (paramChatMessage1.dwTabID == ((MarkFaceMessage)localObject).dwTabID)
          {
            bool1 = bool2;
            if (afgc.c(paramChatMessage1.sbufID, paramChatMessage1.mediaType).equals(afgc.c(((MarkFaceMessage)localObject).sbufID, ((MarkFaceMessage)localObject).mediaType)))
            {
              anot.a(this.app, "CliOper", "", "", "ep_mall", "Ep_show_follow", 0, 0, "", paramChatMessage1.dwTabID + "", "", "");
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
  }
  
  private boolean b(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    paramChatMessage1.parse();
    paramChatMessage2.parse();
    return a((MessageForText)paramChatMessage1).equals(a((MessageForText)paramChatMessage2));
  }
  
  private static void bYW()
  {
    if (bdD) {
      return;
    }
    Object localObject = new yhr();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(83, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(108, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(151, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(156, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(114, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(98, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(97, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(106, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(107, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(116, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(95, localObject);
    localObject = new yht();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(1, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(2, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(14, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(19, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(20, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(15, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(32, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(33, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(35, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(96, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(123, localObject);
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(128, localObject);
    localObject = new yhu();
    jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(21, localObject);
    bdD = true;
  }
  
  public int K(long paramLong)
  {
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      if (getItemId(i) == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int L(long paramLong)
  {
    int j;
    if (paramLong < 0L)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.list.size()) {
        break label58;
      }
      j = i;
      if (((ChatMessage)this.list.get(i)).uniseq == paramLong) {
        break;
      }
      i += 1;
    }
    label58:
    return -1;
  }
  
  public int M(long paramLong)
  {
    int j;
    if (paramLong < 0L)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.list.size()) {
        break label70;
      }
      ChatMessage localChatMessage = (ChatMessage)this.list.get(i);
      if (localChatMessage.shmsgseq == paramLong)
      {
        j = i;
        if (!top.s(localChatMessage)) {
          break;
        }
      }
      i += 1;
    }
    label70:
    return -1;
  }
  
  protected boolean Rq()
  {
    return true;
  }
  
  public ArraySet<Long> a()
  {
    return this.b;
  }
  
  public void a(ArraySet<Long> paramArraySet)
  {
    this.b = paramArraySet;
  }
  
  public void a(ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    a(paramList, paramCharSequence, 0);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    ChatMessage localChatMessage1 = a(paramList);
    if (paramList.size() > 0) {
      this.b.add(Long.valueOf(((ChatMessage)paramList.get(0)).uniseq));
    }
    this.list = paramList;
    if (this.app.b() != null) {
      this.app.b().fr(paramList);
    }
    if (paramCharSequence != null)
    {
      ChatMessage localChatMessage2 = (ChatMessage)this.list.get(0);
      localChatMessage2.mNeedGrayTips = true;
      localChatMessage2.mMessageSource = paramCharSequence;
    }
    if ((localChatMessage1 != null) && (!localChatMessage1.isFlowMessage)) {
      gf(paramList);
    }
    paramCharSequence = (acff)this.app.getManager(51);
    if ((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1) || ((this.sessionInfo.cZ == 0) && (paramCharSequence != null) && (paramCharSequence.isFriend(this.sessionInfo.aTl)))) {
      ((afdw)this.app.getManager(214)).a(paramList, this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramInt);
    }
    if (BaseChatpieHelper.b(this.sessionInfo)) {
      this.list = BaseChatpieHelper.b(this.list, this.sessionInfo.aTq);
    }
    super.notifyDataSetChanged();
    this.jdField_a_of_type_Aavu.czL();
  }
  
  public int b(ChatMessage paramChatMessage)
  {
    if (this.list == null) {
      return -1;
    }
    return this.list.indexOf(paramChatMessage);
  }
  
  public void b(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    this.jdField_a_of_type_Xeh.a(paramChatMessage, this).a(paramView, paramChatMessage, paramInt);
  }
  
  public void bYU()
  {
    if (!this.jdField_a_of_type_Aqdf.isPausing())
    {
      this.jdField_a_of_type_Aqdf.pause();
      this.jdField_a_of_type_Aqdf.edu();
    }
  }
  
  public void bYV()
  {
    if (this.jdField_a_of_type_Aqdf.isPausing())
    {
      this.jdField_a_of_type_Aqdf.resume();
      notifyDataSetChanged();
    }
  }
  
  public void bYX()
  {
    if (this.jdField_a_of_type_Wki$a.a != null)
    {
      aawe localaawe = this.jdField_a_of_type_Wki$a.a.delegate();
      if ((localaawe == null) || (!localaawe.isSelected())) {
        break label41;
      }
      localaawe.detach();
    }
    label41:
    while (!this.jdField_a_of_type_Wki$a.a.isShow()) {
      return;
    }
    this.jdField_a_of_type_Wki$a.a.dismiss();
  }
  
  public void c(ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramChatMessage == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1;
    label22:
    View localView;
    ChatMessage localChatMessage;
    if (i >= 0)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      localChatMessage = (ChatMessage)localView.getTag(2131364516);
      if (localChatMessage != null) {
        break label61;
      }
    }
    label61:
    while (localChatMessage.uniseq != paramChatMessage.uniseq)
    {
      i -= 1;
      break label22;
      break;
    }
    b(localView, paramChatMessage, paramInt);
  }
  
  public void destroy()
  {
    Iterator localIterator = this.list.iterator();
    for (;;)
    {
      label10:
      if (!localIterator.hasNext()) {
        break label295;
      }
      Object localObject1 = (ChatMessage)localIterator.next();
      if (localObject1 != null)
      {
        Object localObject2;
        if ((localObject1 instanceof RecommendCommonMessage))
        {
          localObject1 = (RecommendCommonMessage)localObject1;
          ((RecommendCommonMessage)localObject1).mHasReportShowIconEach = false;
          ((RecommendCommonMessage)localObject1).mHasReportShowUnderlineEach = false;
          if (((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer != null) {
            ((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer.doOnEvent(2);
          }
          localObject1 = ((RecommendCommonMessage)localObject1).mContextList.iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label10;
            }
            localObject2 = (RecommendCommonMessage.ArkContextInfo)((Iterator)localObject1).next();
            if (localObject2 == null) {
              break;
            }
            localObject2 = ((RecommendCommonMessage.ArkContextInfo)localObject2).contextAppInfoList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)((Iterator)localObject2).next();
              if (localArkMsgAppInfo != null)
              {
                localArkMsgAppInfo.doOnEvent(2);
                localArkMsgAppInfo.mOpenCardAppInfoList.clear();
              }
            }
          }
        }
        if ((localObject1 instanceof MessageForArkApp))
        {
          localObject1 = (MessageForArkApp)localObject1;
          if (localObject1 != null)
          {
            ((MessageForArkApp)localObject1).doOnEvent(2);
            ((MessageForArkApp)localObject1).mExtendMsgArkAppList.clear();
          }
        }
        else if ((localObject1 instanceof MessageForArkBabyqReply))
        {
          localObject1 = (MessageForArkBabyqReply)localObject1;
          if ((localObject1 != null) && (((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList != null))
          {
            localObject1 = ((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ArkBabyqCardInfo)((Iterator)localObject1).next();
              if (localObject2 != null)
              {
                ((ArkBabyqCardInfo)localObject2).doOnEvent(2);
                if (((ArkBabyqCardInfo)localObject2).mExtendedArkBabyqCardList != null) {
                  ((ArkBabyqCardInfo)localObject2).mExtendedArkBabyqCardList.clear();
                }
              }
            }
          }
        }
        else if ((localObject1 instanceof MessageForPtt))
        {
          localObject1 = (MessageForPtt)localObject1;
          if (localObject1 != null)
          {
            ((MessageForPtt)localObject1).playProgress = 0.0F;
            ((MessageForPtt)localObject1).playSpeedPos = MediaPlayerManager.pC;
          }
        }
      }
    }
    label295:
    if (this.jdField_a_of_type_Xeh != null) {
      this.jdField_a_of_type_Xeh.destroy();
    }
    this.jdField_a_of_type_Aqdf.a(null);
    this.jdField_a_of_type_Aqdf.destory();
    if (Rq()) {
      wmy.clear();
    }
    this.jdField_a_of_type_Aavu.onDestroy();
  }
  
  public int getCount()
  {
    return this.list.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.list.size()) {
      return this.list.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.list.size() > 0)
    {
      l1 = l2;
      if (paramInt < this.list.size()) {
        l1 = ((ChatMessage)this.list.get(paramInt)).uniseq;
      }
    }
    return l1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt > this.list.size() - 1) {
      paramInt = this.list.size() - 1;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      ChatMessage localChatMessage = (ChatMessage)this.list.get(i);
      if (localChatMessage != null) {
        localChatMessage.parse();
      }
      return xeh.a(this.app, localChatMessage);
    }
  }
  
  public List<ChatMessage> getList()
  {
    return this.list;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= this.list.size()) {
      localObject1 = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      ChatMessage localChatMessage = (ChatMessage)this.list.get(paramInt);
      aqmq.track(null, "AIO_ChatAdapter_getView" + " | " + localChatMessage.getClass().getName());
      Object localObject2 = this.jdField_a_of_type_Xeh.a(localChatMessage, this);
      if (paramInt != 0)
      {
        localObject1 = (ChatMessage)this.list.get(paramInt - 1);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForTroopUnreadTips))) {
          localChatMessage.mNeedTimeStamp = true;
        }
      }
      localObject1 = ((wko)localObject2).a(paramInt, this.list.size(), localChatMessage, paramView, paramViewGroup, this.jdField_a_of_type_Wki$a);
      if (localObject1 != null)
      {
        ((View)localObject1).setTag(2131364516, localChatMessage);
        if (((localObject2 instanceof wjd)) && ((localObject1 instanceof zng))) {
          localObject2 = (zng)localObject1;
        }
      }
      aqmq.track("AIO_ChatAdapter_getView" + " | " + localChatMessage.getClass().getName(), null);
    }
  }
  
  public int getViewTypeCount()
  {
    return 119;
  }
  
  public void gf(List<ChatMessage> paramList)
  {
    ChatMessage localChatMessage1;
    int i;
    int j;
    ChatMessage localChatMessage2;
    ChatMessage localChatMessage4;
    if (paramList.size() > 0)
    {
      localChatMessage1 = (ChatMessage)paramList.get(paramList.size() - 1);
      i = 1;
      for (;;)
      {
        if ((anbk.ls(localChatMessage1.msgtype)) || (top.fB(localChatMessage1.msgtype)))
        {
          i += 1;
          if ((paramList.size() - i >= 0) && (i <= 4))
          {
            localChatMessage1 = (ChatMessage)paramList.get(paramList.size() - i);
          }
          else
          {
            j = 0;
            int k = i + 1;
            if (paramList.size() - k >= 0)
            {
              for (ChatMessage localChatMessage3 = (ChatMessage)paramList.get(paramList.size() - k);; localChatMessage3 = (ChatMessage)paramList.get(paramList.size() - k))
              {
                if (!anbk.ls(localChatMessage3.msgtype))
                {
                  localChatMessage2 = localChatMessage3;
                  localChatMessage4 = localChatMessage1;
                  i = j;
                  if (!top.fB(localChatMessage3.msgtype)) {
                    break label216;
                  }
                }
                k += 1;
                if (paramList.size() - k < 0) {
                  break;
                }
              }
              i = 0;
              localChatMessage4 = localChatMessage1;
              localChatMessage2 = localChatMessage3;
            }
          }
        }
      }
    }
    for (;;)
    {
      label216:
      if ((i != 0) && (localChatMessage4 != null) && (localChatMessage2 != null))
      {
        localChatMessage4.isFlowMessage = false;
        localChatMessage2.isFlowMessage = false;
        if ((localChatMessage4.istroop == 1) || (localChatMessage4.istroop == 3000))
        {
          if (((localChatMessage4 instanceof MessageForMarketFace)) && ((localChatMessage2 instanceof MessageForMarketFace))) {
            localChatMessage4.isFlowMessage = a(localChatMessage4, localChatMessage2);
          }
          if ((localChatMessage4.istroop == 1) && ((localChatMessage4 instanceof MessageForText)) && ((localChatMessage2 instanceof MessageForText))) {
            localChatMessage4.isFlowMessage = b(localChatMessage4, localChatMessage2);
          }
        }
      }
      return;
      localChatMessage2 = null;
      i = 0;
      localChatMessage4 = localChatMessage1;
      continue;
      j = 1;
      break;
      localChatMessage2 = null;
      localChatMessage4 = null;
      i = 1;
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Aqdf.isPausing())) {
      return;
    }
    notifyDataSetChanged();
  }
  
  public void q(ChatMessage paramChatMessage)
  {
    int i = this.list.indexOf(paramChatMessage);
    if (i >= 0)
    {
      Object localObject1;
      if ((paramChatMessage instanceof MessageForArkApp))
      {
        localObject1 = (MessageForArkApp)paramChatMessage;
        if (localObject1 != null) {
          ((MessageForArkApp)localObject1).doOnEvent(2);
        }
      }
      if ((paramChatMessage instanceof RecommendCommonMessage))
      {
        localObject1 = (RecommendCommonMessage)paramChatMessage;
        if ((localObject1 != null) && (((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer != null)) {
          ((RecommendCommonMessage)localObject1).mOldAppInfo.mArkContainer.doOnEvent(2);
        }
        if (localObject1 != null)
        {
          localObject1 = ((RecommendCommonMessage)localObject1).mContextList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (RecommendCommonMessage.ArkContextInfo)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject2 = ((RecommendCommonMessage.ArkContextInfo)localObject2).contextAppInfoList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)((Iterator)localObject2).next();
                if (localArkMsgAppInfo != null) {
                  localArkMsgAppInfo.doOnEvent(2);
                }
              }
            }
          }
        }
      }
      if ((paramChatMessage instanceof MessageForArkFlashChat))
      {
        localObject1 = (MessageForArkFlashChat)paramChatMessage;
        if ((localObject1 != null) && (((MessageForArkFlashChat)localObject1).arkContainer != null)) {
          ((MessageForArkFlashChat)localObject1).arkContainer.doOnEvent(2);
        }
      }
      if ((paramChatMessage instanceof MessageForArkBabyqReply))
      {
        localObject1 = (MessageForArkBabyqReply)paramChatMessage;
        if (localObject1 != null) {
          ((MessageForArkBabyqReply)localObject1).doOnEvent(2);
        }
      }
      this.list.remove(paramChatMessage);
      ld(i, i);
    }
  }
  
  public class a
    implements View.OnClickListener, BubblePopupWindow.b, wlz
  {
    public aavo a;
    private long aQ;
    boolean bdE = false;
    boolean bdF = false;
    private PointF downPoint = new PointF();
    ChatMessage h;
    View wc;
    View wd;
    View we;
    
    public a() {}
    
    private void a(View paramView, wko paramwko)
    {
      paramView.setPressed(true);
      this.wc = paramView;
      Object localObject1 = this.wc.getTag();
      if ((localObject1 instanceof anqv)) {
        ((anqv)localObject1).hH(this.wc);
      }
      label113:
      label254:
      do
      {
        return;
        if ((localObject1 instanceof StructingMsgItemBuilder.a))
        {
          Object localObject2 = (StructingMsgItemBuilder.a)localObject1;
          ViewGroup.LayoutParams localLayoutParams;
          if ((paramwko instanceof StructingMsgItemBuilder))
          {
            if (((StructingMsgItemBuilder)paramwko).a(this.h) == 0)
            {
              if ((((StructingMsgItemBuilder.a)localObject2).hL != null) && (((StructingMsgItemBuilder.a)localObject2).hL.getChildCount() > 0)) {
                this.wd = ((StructingMsgItemBuilder.a)localObject2).hL.getChildAt(0);
              }
              this.bdE = false;
            }
          }
          else
          {
            if ((this.wd == null) || (((StructingMsgItemBuilder.a)localObject2).bib)) {
              break label239;
            }
            localLayoutParams = this.wd.getLayoutParams();
            i = this.wd.getPaddingLeft();
            j = this.wd.getPaddingTop();
            k = this.wd.getPaddingRight();
            m = this.wd.getPaddingBottom();
            if (!this.bdE) {
              break label254;
            }
            if (!((StructingMsgItemBuilder.a)localObject2).mMessage.isSend()) {
              break label241;
            }
            ((StructingMsgItemBuilder.a)localObject2).E.setBackgroundResource(2130851001);
          }
          for (;;)
          {
            this.wd.setLayoutParams(localLayoutParams);
            this.wd.setPadding(i, j, k, m);
            return;
            this.wd = ((StructingMsgItemBuilder.a)localObject2).hL;
            this.bdE = true;
            break label113;
            break;
            ((StructingMsgItemBuilder.a)localObject2).E.setBackgroundResource(2130850824);
            continue;
            if (this.h.istroop == 1008)
            {
              this.wd.setBackgroundResource(2130838403);
            }
            else
            {
              localObject2 = (MessageForStructing)this.h;
              if (((BaseBubbleBuilder)paramwko).a(paramView) == null) {
                wki.a((MessageForStructing)localObject2, (BaseBubbleBuilder.e)localObject1, this.wd, true);
              }
            }
          }
        }
      } while (!(localObject1 instanceof ansl));
      label239:
      label241:
      this.wd = paramView;
      paramwko = this.wd.getLayoutParams();
      int i = this.wd.getPaddingLeft();
      int j = this.wd.getPaddingTop();
      int k = this.wd.getPaddingRight();
      int m = this.wd.getPaddingBottom();
      int n = ((Integer)paramView.getTag(2131378828)).intValue();
      if (n == 0) {
        this.wd.setBackgroundResource(2130838390);
      }
      for (;;)
      {
        this.wd.setLayoutParams(paramwko);
        this.wd.setPadding(i, j, k, m);
        return;
        if (n == 2) {
          this.wd.setBackgroundResource(2130838394);
        } else {
          this.wd.setBackgroundResource(2130838392);
        }
      }
    }
    
    private void a(BaseBubbleBuilder.d paramd)
    {
      Object localObject1 = this.wc.getTag();
      if ((localObject1 instanceof anqv)) {
        ((anqv)localObject1).hG(this.wc);
      }
      do
      {
        do
        {
          return;
          if ((!(localObject1 instanceof StructingMsgItemBuilder.a)) || (this.wd == null)) {
            break;
          }
          Object localObject2 = (StructingMsgItemBuilder.a)localObject1;
          this.wd.getLayoutParams();
          this.wd.getPaddingLeft();
          this.wd.getPaddingTop();
          this.wd.getPaddingRight();
          this.wd.getPaddingBottom();
          if (this.bdE) {
            if (((StructingMsgItemBuilder.a)localObject2).b != null) {
              ((StructingMsgItemBuilder.a)localObject2).b.a(wki.this.app, ((StructingMsgItemBuilder.a)localObject2).mMessage.isSend(), ((StructingMsgItemBuilder.a)localObject2).mMessage.needVipBubble(), true, ((StructingMsgItemBuilder.a)localObject2).E, false);
            }
          }
          for (;;)
          {
            paramd = this.wd.findViewById(2131369004);
            if ((paramd == null) || (!(paramd instanceof PAHighLightImageView))) {
              break;
            }
            ((PAHighLightImageView)paramd).dIv();
            return;
            if ((this.h != null) && (this.h.istroop == 1008))
            {
              if (!((StructingMsgItemBuilder.a)localObject2).bib) {
                this.wd.setBackgroundResource(2130838401);
              }
            }
            else if ((this.h != null) && ((this.h instanceof MessageForStructing)))
            {
              localObject2 = (MessageForStructing)this.h;
              if (paramd == null) {
                wki.a((MessageForStructing)localObject2, (BaseBubbleBuilder.e)localObject1, this.wd, false);
              }
            }
          }
          paramd = this.wd.findViewById(2131378845);
        } while ((paramd == null) || (!(paramd instanceof PAHighLightImageView)));
        ((PAHighLightImageView)paramd).dIv();
        return;
      } while (!(localObject1 instanceof ansl));
      paramd = this.wd.getLayoutParams();
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
        this.wd.setLayoutParams(paramd);
        this.wd.setPadding(i, j, k, m);
        return;
        if (n == 2) {
          this.wd.setBackgroundResource(2130838393);
        } else {
          this.wd.setBackgroundResource(2130838391);
        }
      }
    }
    
    private void a(wko paramwko)
    {
      if ((paramwko instanceof xov)) {
        paramwko = Integer.toString(0);
      }
      for (;;)
      {
        anot.a(wki.this.app, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramwko, "", "", "");
        return;
        if ((paramwko instanceof xkl)) {
          paramwko = Integer.toString(1);
        } else {
          paramwko = Integer.toString(999);
        }
      }
    }
    
    private boolean a(View paramView, boolean paramBoolean, ChatMessage paramChatMessage)
    {
      aqoa localaqoa = new aqoa();
      if (QLog.isColorLevel()) {
        QLog.d("ChatAdapter1", 2, "chatAdapter onLongClick message msgUid = " + paramChatMessage.msgUid + ", time = " + paramChatMessage.time + ", msgtype = " + paramChatMessage.msgtype);
      }
      wko localwko = wki.this.jdField_a_of_type_Xeh.a(paramChatMessage, wki.this);
      Object localObject = localwko.a(paramView);
      int j;
      if ((localObject != null) && (localObject.length > 0))
      {
        this.h = wja.a(paramView);
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          localaqoa.a(localObject[i]);
          i += 1;
        }
        if (localaqoa.size() < 1) {
          return false;
        }
        if ((this.h == null) || (!(this.h instanceof MessageForStructing))) {
          break label616;
        }
      }
      label462:
      label616:
      for (int i = 1;; i = 0)
      {
        int k = (int)this.downPoint.y;
        int m = wja.dp2px(10.0F, paramView.getResources());
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        j = localObject[1] - wja.dp2px(3.0F, paramView.getResources());
        localObject = new Rect();
        paramView.getWindowVisibleDisplayFrame((Rect)localObject);
        if (j - wja.dp2px(72.0F, paramView.getResources()) > ((Rect)localObject).top) {}
        for (;;)
        {
          if (this.a == null)
          {
            this.a = new aavo(wki.this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            this.a.setOnClickListener(this);
            this.a.a(this);
          }
          this.a.clV = ((int)this.downPoint.y);
          k = (int)this.downPoint.x - aqnm.dpToPx(14.0F);
          this.a.clW = k;
          if (paramBoolean)
          {
            this.a.a(localaqoa, paramChatMessage.isMultiMsg);
            this.a.GI(k);
            this.a.GJ(j);
            if ((paramView instanceof ArkAppView))
            {
              ((ArkAppView)paramView).setViewPressed(true);
              this.we = paramView;
            }
            ez(paramView);
            if (i != 0) {
              a(paramView, localwko);
            }
            if ((localwko instanceof BaseBubbleBuilder))
            {
              EmojiStickerManager.a().gs(paramView);
              paramChatMessage = ((BaseBubbleBuilder)localwko).a(paramView);
              if (paramChatMessage != null)
              {
                this.wc = paramView;
                if (!paramBoolean) {
                  break label570;
                }
                paramChatMessage.v(paramView, true);
              }
            }
            if (paramBoolean)
            {
              if ((this.downPoint == null) || (!wki.this.jdField_a_of_type_Aavs.a(paramView, this.downPoint.x, this.downPoint.y, 1, 2))) {
                break label581;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ChatAdapter1", 2, "performCursorTouch ");
              }
            }
          }
          for (;;)
          {
            a(localwko);
            aqgq.cTW = true;
            return true;
            paramChatMessage = this.a.a(paramView, wki.this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            this.a.a(paramView, k, paramChatMessage.clX, localaqoa, true, paramChatMessage.clY);
            break;
            paramChatMessage.v(paramView, false);
            break label462;
            wki.this.jdField_a_of_type_Aavs.a(paramView, this.a);
          }
          ez(paramView);
          return false;
          j = k - m;
        }
      }
    }
    
    void ez(View paramView)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
      paramView.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
    
    public void onClick(View paramView)
    {
      if (this.h != null)
      {
        wko localwko = wki.this.jdField_a_of_type_Xeh.a(this.h, wki.this);
        Context localContext = paramView.getContext();
        localwko.a(paramView.getId(), localContext, this.h);
        if ((paramView.getId() != 2131377931) && (aavp.a().isSelected())) {
          aavp.a().detach();
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
        }
      }
    }
    
    public void onDismiss()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "popup onDismiss is called");
      }
      EmojiStickerManager.a().cZV();
      if (this.a != null) {
        this.a.czM();
      }
      BaseBubbleBuilder.d locald;
      if (this.h != null)
      {
        localObject = wki.this.jdField_a_of_type_Xeh.a(this.h, wki.this);
        if ((localObject instanceof BaseBubbleBuilder))
        {
          ((BaseBubbleBuilder)localObject).bYO();
          locald = ((BaseBubbleBuilder)localObject).a(this.wc);
          localObject = locald;
          if (locald != null) {
            locald.v(this.wc, true);
          }
        }
      }
      for (Object localObject = locald;; localObject = null)
      {
        this.bdF = false;
        aqgq.cTW = false;
        if (this.wc != null)
        {
          this.wc.setPressed(false);
          a((BaseBubbleBuilder.d)localObject);
          this.wc = null;
          this.wd = null;
        }
        if (this.we != null)
        {
          ((ArkAppView)this.we).setViewPressed(false);
          this.we = null;
        }
        return;
      }
    }
    
    public boolean onLongClick(View paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatAdapter1", 2, "onLongClick() called with: v = [" + paramView + "]");
      }
      anpc.report("tim_msg_tab_msg_longtouch");
      boolean bool;
      ChatMessage localChatMessage;
      int i;
      if (wki.this.bdC)
      {
        bool = false;
        if ((paramView instanceof AnimationTextView)) {
          ((AnimationTextView)paramView).setTag(2131368813, Boolean.valueOf(true));
        }
        if ((paramView instanceof ArkAppView)) {
          ((ArkAppView)paramView).onLongClick(paramView);
        }
        localChatMessage = wja.a(paramView);
        if (!localChatMessage.isMultiMsg) {
          break label299;
        }
        if (ajlg.Q(localChatMessage)) {
          break label153;
        }
        i = 1;
      }
      for (;;)
      {
        label117:
        if (i != 0) {
          if (QLog.isColorLevel()) {
            QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 1");
          }
        }
        label153:
        label188:
        do
        {
          do
          {
            return true;
            bool = wki.this.jdField_a_of_type_Aavs.R(paramView);
            break;
            i = 0;
            break label117;
            if (wki.this.Y.booleanValue()) {
              break label188;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 2");
          return true;
          if (!(paramView instanceof ETTextView)) {
            break label237;
          }
          ETTextView localETTextView = (ETTextView)paramView;
          if (!localETTextView.mHasClickedArkSpan) {
            break label237;
          }
          localETTextView.mHasClickedArkSpan = false;
          ez(paramView);
        } while (!QLog.isColorLevel());
        QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 3");
        return true;
        label237:
        this.bdF = true;
        wja.bcO = true;
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble onLongClick() is called");
        }
        if ((!bool) && (this.a != null) && (this.a.isShow()))
        {
          ez(paramView);
          return false;
        }
        return a(paramView, bool, localChatMessage);
        label299:
        i = 0;
      }
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.downPoint.x = paramMotionEvent.getRawX();
        this.downPoint.y = paramMotionEvent.getRawY();
        this.aQ = System.currentTimeMillis();
      }
      if ((paramMotionEvent.getAction() == 1) && (System.currentTimeMillis() - this.aQ < ViewConfiguration.getLongPressTimeout())) {
        anpc.report("tim_msg_tab_msg_click");
      }
      Object localObject1 = wja.a(paramView);
      if ((paramView instanceof ArkAppView))
      {
        ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
        if ((paramMotionEvent.getAction() == 1) && (wki.this.sessionInfo != null))
        {
          if (wki.this.sessionInfo.cZ != 1008) {
            break label275;
          }
          ocp.a(wki.this.app, (ChatMessage)localObject1);
        }
      }
      if ((paramMotionEvent.getAction() == 1) && (wki.this.sessionInfo.cZ == 1008) && (localObject1 != null)) {
        adak.a(118, (ChatMessage)localObject1, wja.a(((ChatMessage)localObject1).uniseq, wki.this.jdField_a_of_type_ComTencentWidgetListView.getAdapter()));
      }
      Object localObject2 = paramView.findViewById(2131369004);
      if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.bdF)) {
        ((PAHighLightImageView)localObject2).h(paramView, paramMotionEvent);
      }
      for (;;)
      {
        localObject1 = wki.this.jdField_a_of_type_Xeh.a((ChatMessage)localObject1, wki.this);
        if ((!this.bdF) && ((localObject1 instanceof BaseBubbleBuilder)))
        {
          localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
          if (localObject1 != null) {
            ((BaseBubbleBuilder.d)localObject1).e(paramView, paramMotionEvent);
          }
        }
        return false;
        label275:
        if ((wki.this.sessionInfo.cZ != 1038) || (!(localObject1 instanceof MessageForArkApp))) {
          break;
        }
        localObject2 = (MessageForArkApp)localObject1;
        if (((MessageForArkApp)localObject2).ark_app_message == null) {
          break;
        }
        MiniProgramLpReportDC04239.reportByQQ("message", "message_aio", "click", "com.tencent.miniapp", ((MessageForArkApp)localObject2).ark_app_message.appView, "", "");
        break;
        localObject2 = paramView.findViewById(2131378845);
        if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.bdF)) {
          ((PAHighLightImageView)localObject2).h(paramView, paramMotionEvent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wki
 * JD-Core Version:    0.7.0.1
 */
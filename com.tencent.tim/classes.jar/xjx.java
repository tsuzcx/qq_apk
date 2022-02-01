import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.a;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class xjx
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.d, wla.a
{
  protected long IX;
  private wly a = new wly();
  private View.OnClickListener dR = new xjy(this);
  private View.OnClickListener onClickListener;
  private AnimationTextView.a onDoubleClick = new xjz(this);
  private ArrayList<String> qF;
  
  public xjx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a.sessionInfo = paramSessionInfo;
    this.onClickListener = new alvl(this);
  }
  
  private MessageRecord a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2)
  {
    MessageForText localMessageForText = (MessageForText)anbi.d(-1000);
    if (paramSpannableStringBuilder1.length() > 0)
    {
      localMessageForText.sb = new SpannableStringBuilder(paramSpannableStringBuilder1);
      paramSpannableStringBuilder1.clear();
    }
    if (paramSpannableStringBuilder2.length() > 0)
    {
      localMessageForText.sb2 = new SpannableStringBuilder(paramSpannableStringBuilder2);
      paramSpannableStringBuilder2.clear();
    }
    return localMessageForText;
  }
  
  private CharSequence a(MessageRecord paramMessageRecord, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {}
    String str;
    int i;
    label74:
    do
    {
      return paramCharSequence;
      if ((paramCharSequence instanceof aofk)) {}
      for (str = ((aofk)paramCharSequence).mSource;; str = paramCharSequence.toString())
      {
        i = ChatTextSizeSettingActivity.vp();
        if (!paramBoolean) {
          break label74;
        }
        if (!str.startsWith("\n")) {
          break;
        }
        return new aofk(str.substring(1), 13, i, paramMessageRecord);
      }
    } while (!str.endsWith("\n"));
    return new aofk(str.substring(0, str.length() - 1), 13, i, paramMessageRecord);
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList, BaseBubbleBuilder.e parame)
  {
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder();
    SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      if ((localObject instanceof MessageForText))
      {
        if (!TextUtils.isEmpty(((MessageForText)localObject).sb)) {
          localSpannableStringBuilder1.append(((MessageForText)localObject).sb);
        }
        if (!TextUtils.isEmpty(((MessageForText)localObject).sb2)) {
          localSpannableStringBuilder2.append(((MessageForText)localObject).sb2);
        } else if (!TextUtils.isEmpty(((MessageForText)localObject).sb)) {
          localSpannableStringBuilder2.append(((MessageForText)localObject).sb);
        }
      }
      else if ((localObject instanceof MessageForPic))
      {
        localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
        localArrayList.add(localObject);
      }
      else if ((localObject instanceof MessageForMixedMsg))
      {
        localObject = (MessageForMixedMsg)localObject;
        Iterator localIterator = ((MessageForMixedMsg)localObject).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if ((localMessageRecord instanceof MessageForPic))
          {
            if (((MessageForPic)localMessageRecord).time == 0L) {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, (MessageForMixedMsg)localObject);
            }
            localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
            localArrayList.add(localMessageRecord);
          }
          else if ((localMessageRecord instanceof MessageForText))
          {
            if (!TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
              localSpannableStringBuilder1.append(((MessageForText)localMessageRecord).sb);
            }
            if (!TextUtils.isEmpty(((MessageForText)localMessageRecord).sb2)) {
              localSpannableStringBuilder2.append(((MessageForText)localMessageRecord).sb2);
            } else if (!TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
              localSpannableStringBuilder2.append(((MessageForText)localMessageRecord).sb);
            }
          }
          else
          {
            localArrayList.add(localMessageRecord);
          }
        }
      }
      else if ((localObject instanceof MessageForReplyText))
      {
        if (!TextUtils.isEmpty(((MessageForReplyText)localObject).sb))
        {
          localSpannableStringBuilder1.append(((MessageForReplyText)localObject).sb);
          localSpannableStringBuilder2.append(((MessageForReplyText)localObject).sb);
        }
        localArrayList.add(localObject);
      }
    }
    localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
    a(parame, aofy.og(localSpannableStringBuilder1.toString()));
    return localArrayList;
  }
  
  private void a(BaseBubbleBuilder.e parame, String paramString)
  {
    if (parame.E == null) {
      parame.E = new StringBuilder();
    }
    if (aTl) {
      parame.E.append(paramString);
    }
  }
  
  private void a(ArrayList<apri.a> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!apri.i(this.app, this.sessionInfo)) {
      break label14;
    }
    label14:
    while (paramArrayList1.isEmpty()) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    int j = -1;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int m = paramArrayList1.size();
    TextView localTextView;
    Object localObject2;
    int k;
    for (;;)
    {
      if (i < m)
      {
        localTextView = (TextView)paramArrayList1.get(i);
        localObject2 = (apri.a)paramArrayList.get(i);
        if ((localObject2 == null) || (((apri.a)localObject2).action == -1))
        {
          localStringBuilder.append(localTextView.getText());
          k = j;
          localObject2 = localObject1;
          if (i != m - 1)
          {
            localStringBuilder.append(" ");
            localObject2 = localObject1;
            k = j;
          }
          label138:
          i += 1;
          j = k;
          localObject1 = localObject2;
        }
        else
        {
          localStringBuilder.append(((apri.a)localObject2).getContent());
          if (i != m - 1) {
            localStringBuilder.append(" ");
          }
          if (localObject1 == null)
          {
            localObject1 = localObject2;
            j = i;
          }
        }
      }
    }
    for (;;)
    {
      localTextView.setTag(2131367211, "school_troop_span");
      k = j;
      localObject2 = localObject1;
      break label138;
      if (((apri.a)localObject2).action < localObject1.action)
      {
        localObject1 = localObject2;
        j = i;
        continue;
        if (localObject1 != null)
        {
          localObject2 = new apri.a();
          ((apri.a)localObject2).msgId = paramMessageRecord.uniseq;
          ((apri.a)localObject2).dVx = localObject1.dVx;
          ((apri.a)localObject2).troopUin = localObject1.troopUin;
          ((apri.a)localObject2).keyword = localObject1.keyword;
          ((apri.a)localObject2).action = localObject1.action;
          ((apri.a)localObject2).setContent(localStringBuilder.toString());
          ((apri.a)localObject2).ahi = localObject1.ahi;
          ((apri.a)localObject2).adh = localObject1.adh;
          ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new apri.b(this.app, this.mContext, (apri.a)localObject2), ((apri.a)localObject2).ahi, ((apri.a)localObject2).adh, 17);
          if (QLog.isDevelopLevel()) {
            QLog.d("school_troop.MixedMsgItemBuilder", 2, new Object[] { "matchKeywordResults.size: ", Integer.valueOf(paramArrayList.size()), "; detect result: ", localObject2 });
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("school_troop.MixedMsgItemBuilder", 2, " updateSchoolTroopHighlight time cost: " + (System.currentTimeMillis() - l));
        return;
      }
    }
  }
  
  private boolean a(xjx.a parama)
  {
    return (parama.mText != null) && (parama.Jm != null) && (parama.d != null) && (parama.e != null);
  }
  
  private HashMap<Integer, CharSequence> b(List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgItemBuilder", 2, "formatTextMessRecordNewLineSymbol, size:" + paramList.size());
    }
    HashMap localHashMap = new HashMap(paramList.size());
    int i = 0;
    if (i < paramList.size())
    {
      if ((paramList.get(i) instanceof MessageForReplyText)) {
        localHashMap.put(Integer.valueOf(i), ((MessageForReplyText)paramList.get(i)).sb);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramList.get(i) instanceof MessageForText))
        {
          localObject1 = (MessageForText)paramList.get(i);
          if (!TextUtils.isEmpty(((MessageForText)localObject1).sb2)) {
            localHashMap.put(Integer.valueOf(i), ((MessageForText)localObject1).sb2);
          } else {
            localHashMap.put(Integer.valueOf(i), ((MessageForText)localObject1).sb);
          }
        }
        else
        {
          localHashMap.put(Integer.valueOf(i), "");
        }
      }
    }
    Object localObject1 = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      if ((paramList.get(i) instanceof MessageForPic)) {
        ((List)localObject1).add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Integer)((Iterator)localObject1).next();
      i = ((Integer)localObject2).intValue() - 1;
      int j = ((Integer)localObject2).intValue() + 1;
      if ((i >= 0) && (i < localHashMap.size()))
      {
        localObject2 = (CharSequence)localHashMap.get(Integer.valueOf(i));
        localHashMap.put(Integer.valueOf(i), a((MessageRecord)paramList.get(i), (CharSequence)localObject2, false));
      }
      if ((j >= 0) && (j < localHashMap.size()))
      {
        localObject2 = (CharSequence)localHashMap.get(Integer.valueOf(j));
        localHashMap.put(Integer.valueOf(j), a((MessageRecord)paramList.get(j), (CharSequence)localObject2, true));
      }
    }
    return localHashMap;
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    wta.a(this.mContext, this.app, paramChatMessage, 2);
    Object localObject;
    int i;
    if (aavp.a().isSelected())
    {
      localObject = aavp.a().qL();
      if (localObject != null) {
        if (((CharSequence)localObject).length() != aavp.a().length())
        {
          i = 1;
          if (i != 0) {
            break label259;
          }
          localObject = aavp.a().qM();
        }
      }
    }
    label259:
    for (;;)
    {
      label65:
      ((ClipboardManager)this.mContext.getSystemService("clipboard")).setText((CharSequence)localObject);
      anot.a(this.app, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      if (i != 0) {
        anot.a(this.app, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          anot.a(this.app, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        localObject = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
        i = 1;
        break label65;
        anot.a(this.app, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    wta.a(this.mContext, this.app, paramChatMessage, 3);
    Object localObject1;
    int i;
    if (aavp.a().isSelected())
    {
      localObject1 = aavp.a().qL();
      if (localObject1 != null) {
        if (((String)localObject1).length() == aavp.a().length())
        {
          i = 1;
          if (i != 0) {
            break label592;
          }
          localObject1 = aavp.a().qM();
        }
      }
    }
    label63:
    label592:
    for (;;)
    {
      Bundle localBundle = new Bundle();
      Object localObject2;
      if ((this.app != null) && (this.app.getApp() != null) && (this.app.getApp().getApplicationContext() != null))
      {
        localObject2 = aqmj.bp(this.app.getApp().getApplicationContext());
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          if ((localObject2 == null) || (localObject2.length <= 0)) {}
        }
      }
      for (;;)
      {
        try
        {
          int j = Integer.parseInt(localObject2[0]);
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgItemBuilder", 2, "get mixMsgForward switch From config : configSwitch = " + j);
          }
          if (j == 1)
          {
            j = 1;
            if ((i == 0) || (j == 0)) {
              break label543;
            }
            localBundle.putInt("forward_type", -5);
            localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
            ((ajcy)this.app.getManager(174)).fO.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
            localBundle.putString("forward_text", (String)localObject1);
            localBundle.putInt("forward_source_uin_type", this.sessionInfo.cZ);
            localBundle.putInt("selection_mode", this.bOY);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras(localBundle);
            ahgq.f((Activity)this.mContext, (Intent)localObject1, 21);
            anot.a(this.app, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
            anot.a(this.app, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            if (i == 0) {
              break label555;
            }
            anot.a(this.app, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
            if (paramChatMessage.isMultiMsg) {
              anot.a(this.app, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
            }
            return;
            i = 0;
            break;
            i = 0;
            break;
            localObject1 = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString();
            i = 1;
            break label63;
          }
          j = 0;
          continue;
          j = 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MixedMsgItemBuilder", 2, "get mixMsgForward switch from config error", localNumberFormatException);
          }
        }
        continue;
        localBundle.putInt("forward_type", -1);
        continue;
        anot.a(this.app, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
    }
  }
  
  private void d(ChatMessage paramChatMessage, String paramString)
  {
    wta.a(this.mContext, this.app, paramChatMessage, 4);
    String str;
    int i;
    if (aavp.a().isSelected())
    {
      str = aavp.a().qL();
      if (str != null) {
        if (str.length() == aavp.a().length())
        {
          i = 1;
          if (i != 0) {
            break label312;
          }
          str = aavp.a().qM();
        }
      }
    }
    label275:
    label312:
    for (;;)
    {
      label63:
      if ((i != 0) || (str == null))
      {
        aviz.b(paramChatMessage).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
        avjg.a(this.app, 4, 0, paramChatMessage.istroop);
        label115:
        avjg.a(this.app, 6, 8);
        if (i == 0) {
          break label275;
        }
        anot.a(this.app, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          anot.a(this.app, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        i = 1;
        str = null;
        break label63;
        avjg.a(this.app, 1, 0, paramChatMessage.istroop);
        aviz.a(null, str).b(this.app, paramChatMessage).b((Activity)this.mContext, this.app.getAccount());
        break label115;
        anot.a(this.app, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      }
    }
  }
  
  private void i(URLDrawable paramURLDrawable)
  {
    String str;
    if (paramURLDrawable.getStatus() != 1)
    {
      if (this.qF == null) {
        this.qF = new ArrayList();
      }
      str = paramURLDrawable.getURL().toString();
      if (str != null) {
        break label39;
      }
    }
    label39:
    while (this.qF.contains(str)) {
      return;
    }
    this.qF.add(str);
    ThreadManager.executeOnSubThread(new MixedMsgItemBuilder.2(this, str, paramURLDrawable), true);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    xjx.a locala = (xjx.a)parame;
    if (locala.E == null) {
      locala.E = new StringBuilder();
    }
    Object localObject1 = (aptw)this.app.getManager(203);
    if (QLog.isColorLevel()) {
      QLog.i("MixedMsgItemBuilder", 1, "getBubbleView: check is need refresh[" + locala.oA + "]");
    }
    if ((!aTl) && (xjx.a.a(locala) != null) && (xjx.a.a(locala) == paramChatMessage.uniseq) && (!locala.oA) && (TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (((aptw)localObject1).f(this.app, paramChatMessage))
      {
        locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.mContext, this.app, paramChatMessage);
        return paramView;
      }
      locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.mContext, this.app, paramChatMessage);
      return paramView;
    }
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      Iterator localIterator;
      if (aqiu.ms(paramChatMessage.issend))
      {
        paramBaseChatItemLayout = "发出";
        a(parame, paramBaseChatItemLayout);
        paramBaseChatItemLayout = (MessageForMixedMsg)paramChatMessage;
        localIterator = paramBaseChatItemLayout.msgElemList.iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label352;
        }
        Object localObject2 = (MessageRecord)localIterator.next();
        if ((localObject2 instanceof MessageForPic))
        {
          a(parame, "图片");
          localObject2 = (MessageForPic)localObject2;
          if (((MessageForPic)localObject2).time != 0L) {
            continue;
          }
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject2, paramBaseChatItemLayout);
          continue;
          paramBaseChatItemLayout = "发来";
          break;
        }
        if ((localObject2 instanceof MessageForReplyText))
        {
          if (((MessageForReplyText)localObject2).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToNormal((MessageRecord)localObject2, paramBaseChatItemLayout);
          }
        }
        else {
          a(parame, aofy.iF(((MessageRecord)localObject2).msg));
        }
      }
      label352:
      paramBaseChatItemLayout = a(parame, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout.msgElemList, paramwlz, paramBaseChatItemLayout);
      xjx.a.a(locala, paramChatMessage.uniseq);
      locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(((aptw)localObject1).f(this.app, paramChatMessage), this.mContext, this.app, paramChatMessage);
    }
    for (;;)
    {
      parame = wla.a(this.app);
      if (parame != null) {
        parame.a(paramBaseChatItemLayout, this);
      }
      if (paramBaseChatItemLayout != null) {
        paramBaseChatItemLayout.setTag(locala);
      }
      paramView = paramBaseChatItemLayout;
      if (locala.jdField_a_of_type_Aavr == null) {
        break;
      }
      locala.jdField_a_of_type_Aavr.P(paramChatMessage);
      return paramBaseChatItemLayout;
      paramBaseChatItemLayout = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject1 = (MessageForLongMsg)paramChatMessage;
        a(parame, "说");
        paramBaseChatItemLayout = paramView;
        if (((MessageForLongMsg)localObject1).longMsgFragmentList != null)
        {
          paramBaseChatItemLayout = paramView;
          if (!((MessageForLongMsg)localObject1).longMsgFragmentList.isEmpty())
          {
            paramBaseChatItemLayout = a(((MessageForLongMsg)localObject1).longMsgFragmentList, locala);
            paramBaseChatItemLayout = a(parame, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout, paramwlz, paramChatMessage);
            xjx.a.a(locala, paramChatMessage.uniseq);
          }
        }
      }
    }
  }
  
  public aqoa a(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    int i = 0;
    paramaqoa.UY(this.mContext.getString(2131692252));
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label126;
      }
    }
    for (;;)
    {
      if (i != 0) {
        paramaqoa.Z(2131365509, this.mContext.getString(2131718654), 2130839079);
      }
      paramaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
      if (wja.eU(5) == 1) {
        paramaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
      }
      return paramaqoa;
      if ((!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
        label126:
        i = 1;
      }
    }
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    if (L(paramView)) {
      return this;
    }
    return null;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xjx.a();
  }
  
  public MixedMsgLinearLayout a(BaseBubbleBuilder.e parame, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, wlz paramwlz, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.mContext);
      paramList.setId(2131364503);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(wja.dp2px(44.0F, this.mContext.getResources()));
      paramList.setPadding(2131296404, 2131296406, 2131296403, 2131296405);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131368698);
      paramMixedMsgLinearLayout.addRule(3, 2131379420);
      paramMixedMsgLinearLayout.leftMargin = wja.dp2px(3.0F, this.mContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = wja.dp2px(3.0F, this.mContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.b = this.onDoubleClick;
      xjx.a.a((xjx.a)parame, paramList);
      ((xjx.a)parame).jdField_a_of_type_Aavr = new aavr();
      ((xjx.a)parame).jdField_a_of_type_Aavr.a(paramList);
      ((xjx.a)parame).jdField_a_of_type_Aavr.a(parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    ((xjx.a)parame).bTz = -1;
    ((xjx.a)parame).oA = false;
    paramList.a(localArrayList1, (xjx.a)parame);
    if (apri.i(this.app, this.sessionInfo)) {}
    for (paramMixedMsgLinearLayout = (apri)this.app.getManager(262);; paramMixedMsgLinearLayout = null)
    {
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      HashMap localHashMap = b(localArrayList1);
      int j = localArrayList1.size();
      int i = 0;
      Object localObject1;
      View localView;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      label545:
      boolean bool;
      for (;;)
      {
        if (i < j)
        {
          localObject1 = (MessageRecord)localArrayList1.get(i);
          localView = paramList.getChildAt(i);
          if (localView == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MixedMsgItemBuilder", 2, "getMixedMsgLayout,child is null. size = " + j + ",i = " + i);
            }
            i += 1;
          }
          else if ((localObject1 instanceof MessageForReplyText))
          {
            if ((localView instanceof LinearLayout))
            {
              localObject3 = (LinearLayout)localView;
              localObject2 = (ViewGroup)((LinearLayout)localObject3).getChildAt(0);
              localObject4 = (TextView)((LinearLayout)localObject3).getChildAt(1);
              localObject3 = (MessageForReplyText)localObject1;
              ((ViewGroup)localObject2).setId(2131364531);
              ((ViewGroup)localObject2).setOnClickListener(this.onClickListener);
              ((ViewGroup)localObject2).setOnTouchListener(paramwlz);
              ((ViewGroup)localObject2).setOnLongClickListener(paramwlz);
              ((ViewGroup)localObject2).findViewById(2131371989).setOnClickListener(this.onClickListener);
              ((ViewGroup)localObject2).findViewById(2131369803).setOnClickListener(this.onClickListener);
              ((ViewGroup)localObject2).findViewById(2131379641).setOnClickListener(this.onClickListener);
              if (TextUtils.isEmpty(((MessageForReplyText)localObject3).sb)) {
                break label769;
              }
              ((TextView)localObject4).setText(((MessageForReplyText)localObject3).sb);
              ((TextView)localObject4).setVisibility(0);
              if (paramMixedMsgLinearLayout != null)
              {
                localArrayList2.add(paramMixedMsgLinearLayout.a(this.sessionInfo, (MessageRecord)localObject1));
                localArrayList3.add(localObject4);
              }
              localObject1 = (MessageForReplyText)localObject1;
              xmb.a(this.mContext, this.app, (ViewGroup)localObject2, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.a.sessionInfo.aTl, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject1, false, this.sessionInfo);
              localObject1 = ((ViewGroup)localObject2).findViewById(2131379641);
              if (localObject1 == null) {
                break label1221;
              }
              localObject1 = ((View)localObject1).getTag(2131364518);
              if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
                break label1221;
              }
              bool = ((Boolean)localObject1).booleanValue();
              ((xjx.a)parame).oA = bool;
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MixedMsgItemBuilder", 1, "getMixedMsgLayout: reply check is need refresh[" + bool + "]");
        }
        label717:
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = BaseChatItemLayout.bOa;
        if (i == j - 1) {}
        for (((LinearLayout.LayoutParams)localObject1).bottomMargin = BaseChatItemLayout.bOa;; ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0)
        {
          localView.setOnTouchListener(paramwlz);
          localView.setOnLongClickListener(paramwlz);
          break;
          label769:
          ((TextView)localObject4).setVisibility(8);
          break label545;
          if ((localObject1 instanceof MessageForText))
          {
            localObject2 = (AnimationTextView)localView;
            ((AnimationTextView)localObject2).setTextSize(0, this.sessionInfo.cN);
            aofy.P((TextView)localObject2);
            ((AnimationTextView)localObject2).setText((CharSequence)localHashMap.get(Integer.valueOf(i)));
            if (paramMixedMsgLinearLayout != null)
            {
              localArrayList2.add(paramMixedMsgLinearLayout.a(this.sessionInfo, (MessageRecord)localObject1));
              localArrayList3.add(localObject2);
            }
            if (!aptw.bg(paramMessageRecord)) {
              break label717;
            }
            aptw.a((TextView)localObject2, (MessageRecord)localObject1);
            break label717;
          }
          if ((localObject1 instanceof MessageForPic))
          {
            localObject1 = (MessageForPic)localObject1;
            localObject2 = (ChatThumbView)localView;
            localObject3 = new int[2];
            Object tmp907_905 = localObject3;
            tmp907_905[0] = 0;
            Object tmp911_907 = tmp907_905;
            tmp911_907[1] = 0;
            tmp911_907;
            localObject4 = xkl.a(this.mContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
            ((ChatThumbView)localObject2).setTag(2131364517, localObject1);
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            String str = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = aoop.a((akxw)localObject1, 65537);
            if (xkl.a(this.mContext, avfp.ns(((MessageForPic)localObject1).imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(xkl.am(), wja.dp2px(6.0F, this.mContext.getResources()), wja.dp2px(6.0F, this.mContext.getResources()));
              ((URLDrawable)localObject4).setWatermarkVisibility(0);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MixedMsgItemBuilder", 2, "getMixedMsgLayout,set picmsg, picDrawable " + localObject4 + ",picMsg = " + localObject1);
              }
              ((ChatThumbView)localObject2).setOnClickListener(this.dR);
              i((URLDrawable)localObject4);
              if (((MessageForPic)localObject1).isSendFromLocal()) {
                break;
              }
              this.app.a().a((MessageForPic)localObject1, 2);
              break;
              ((URLDrawable)localObject4).setWatermarkVisibility(4);
            }
          }
          if (!QLog.isColorLevel()) {
            break label717;
          }
          QLog.e("MixedMsgItemBuilder", 2, "mixed type not support yet." + localObject1.getClass().getSimpleName());
          break label717;
        }
        a(localArrayList2, localArrayList3, paramMessageRecord);
        paramList.setOnTouchListener(paramwlz);
        paramList.setOnLongClickListener(paramwlz);
        paramList.onDoubleClick = this.onDoubleClick;
        return paramList;
        label1221:
        bool = false;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (this.app != null)
    {
      String str2 = this.app.getCurrentAccountUin();
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {}
    }
    for (String str1 = "";; str1 = "") {
      switch (paramInt)
      {
      default: 
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
    }
    ujt.b(this.mContext, this.app, paramChatMessage);
    anot.a(this.app, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
    return;
    super.m(paramChatMessage);
    anot.a(this.app, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
    return;
    b(paramChatMessage, str1);
    return;
    c(paramChatMessage, str1);
    return;
    d(paramChatMessage, str1);
    return;
    super.j(paramChatMessage);
    anot.a(this.app, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
    return;
    aavp.a().O(paramChatMessage);
    anot.a(this.app, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
    return;
    anot.a(this.app, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
    k(paramChatMessage);
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label68:
    label585:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = (xjx.a)wja.a(paramView);
      paramView = null;
      Object localObject2;
      if ((((xjx.a)localObject1).mMessage instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)((xjx.a)localObject1).mMessage;
        if ((xjx.a.a((xjx.a)localObject1) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject2)
          {
            localObject2 = (MessageRecord)paramView.next();
            if ((localObject2 == null) || (((MessageRecord)localObject2).uniseq != paramaoko.uniseq) || (!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).subMsgId != paramaoko.apI)) {
              break label68;
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          if (paramView == null) {
            break label593;
          }
          paramInt2 = xjx.a.a((xjx.a)localObject1).getChildCount();
          paramInt1 = 0;
          label232:
          Object localObject3;
          Object localObject4;
          if (paramInt1 < paramInt2)
          {
            paramaoko = xjx.a.a((xjx.a)localObject1).getChildAt(paramInt1);
            if ((paramaoko instanceof ChatThumbView))
            {
              localObject2 = ((ChatThumbView)paramaoko).getTag(2131364517);
              if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).uniseq == paramView.uniseq) && (((MessageForPic)localObject2).subMsgId == paramView.subMsgId))
              {
                paramaoko = (ChatThumbView)paramaoko;
                if (paramaoko == null) {
                  break label577;
                }
                localObject1 = new int[2];
                tmp243_241 = localObject1;
                tmp243_241[0] = 0;
                tmp247_243 = tmp243_241;
                tmp247_243[1] = 0;
                tmp247_243;
                localObject2 = xkl.a(this.mContext, paramView, paramaoko, (int[])localObject1);
                localObject3 = ((URLDrawable)localObject2).getURL().getProtocol();
                localObject4 = aoop.a(paramView, 65537);
                boolean bool = xkl.a(this.mContext, avfp.ns(paramView.imageType), ((String)localObject3).equals("chatthumb"), localObject1[0], localObject1[1], (URL)localObject4);
                paramaoko.setImageDrawable((Drawable)localObject2);
                if (!bool) {
                  break label567;
                }
                ((URLDrawable)localObject2).setWatermarkDrawable(xkl.am(), wja.dp2px(6.0F, this.mContext.getResources()), wja.dp2px(6.0F, this.mContext.getResources()));
                ((URLDrawable)localObject2).setWatermarkVisibility(0);
                return;
                if (!(((xjx.a)localObject1).mMessage instanceof MessageForLongMsg)) {
                  break label585;
                }
                localObject2 = (MessageForLongMsg)((xjx.a)localObject1).mMessage;
                if ((((MessageForLongMsg)localObject2).longMsgFragmentList == null) || (((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty())) {
                  break label585;
                }
                localObject2 = ((MessageForLongMsg)localObject2).longMsgFragmentList.iterator();
                do
                {
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  localObject3 = (MessageRecord)((Iterator)localObject2).next();
                } while (localObject3 == null);
                if (((MessageRecord)localObject3).uniseq != paramaoko.uniseq) {
                  break label579;
                }
                if ((localObject3 instanceof MessageForPic)) {
                  paramView = (MessageForPic)localObject3;
                }
              }
            }
          }
          for (;;)
          {
            label478:
            break label424;
            if ((localObject3 instanceof MessageForMixedMsg))
            {
              localObject3 = ((MessageForMixedMsg)localObject3).msgElemList.iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (MessageRecord)((Iterator)localObject3).next();
                  if (((localObject4 instanceof MessageForPic)) && (((MessageForPic)localObject4).subMsgId == paramaoko.apI))
                  {
                    paramView = (MessageForPic)localObject4;
                    break label478;
                    paramInt1 += 1;
                    break label153;
                    ((URLDrawable)localObject2).setWatermarkVisibility(4);
                    return;
                    paramaoko = null;
                    break label232;
                    break;
                  }
                }
              }
            }
          }
          continue;
          paramView = null;
          continue;
          paramView = null;
        }
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (xjx.a)paramView.getTag();
    int i = BaseChatItemLayout.bNV;
    if (paramChatMessage.isSend())
    {
      xjx.a.a(paramView).setPadding(xov.bTv, i, xov.bTu, xov.bTt);
      return;
    }
    xjx.a.a(paramView).setPadding(xov.bTu, i, xov.bTv, xov.bTt);
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    xjx.a locala = (xjx.a)parame;
    if ((locala.bTz != -1) && (a(locala)))
    {
      locala.mText.setTextSize(0, this.sessionInfo.cN);
      if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()) || (anlm.ayn()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          parame = paramView.getColorStateList(2131167326);
          locala.mText.setTextColor(parame);
          locala.Jm.setTextColor(parame);
          locala.d.setTextColor(parame);
          locala.e.setTextColor(parame);
          if (!paramChatMessage.isSend()) {
            break label206;
          }
        }
        label206:
        for (parame = paramView.getColorStateList(2131167325);; parame = paramView.getColorStateList(2131167324))
        {
          locala.mText.setLinkTextColor(parame);
          locala.d.setLinkTextColor(parame);
          locala.e.setLinkTextColor(parame);
          ImmersiveUtils.setAlpha(locala.Jm, 0.9F);
          ImmersiveUtils.setAlpha(locala.d, 0.9F);
          ImmersiveUtils.setAlpha(locala.e, 0.9F);
          return;
          parame = paramView.getColorStateList(2131167322);
          break;
        }
      }
      if (paramadxp.mTextColor == 0)
      {
        locala.mText.setTextColor(-16777216);
        locala.Jm.setTextColor(-16777216);
        locala.d.setTextColor(-16777216);
        locala.e.setTextColor(-16777216);
        if (paramadxp.mLinkColor != 0) {
          break label404;
        }
        parame = paramView.getResources().getColorStateList(2131167324);
        locala.mText.setLinkTextColor(parame);
        locala.d.setLinkTextColor(parame);
        locala.e.setLinkTextColor(parame);
      }
      for (;;)
      {
        ImmersiveUtils.setAlpha(locala.Jm, 0.9F);
        ImmersiveUtils.setAlpha(locala.d, 0.9F);
        ImmersiveUtils.setAlpha(locala.e, 0.9F);
        return;
        locala.mText.setTextColor(paramadxp.mTextColor);
        locala.Jm.setTextColor(paramadxp.mTextColor);
        locala.d.setTextColor(paramadxp.mTextColor);
        locala.e.setTextColor(paramadxp.mTextColor);
        break;
        label404:
        locala.mText.setLinkTextColor(paramadxp.mLinkColor);
        locala.d.setLinkTextColor(paramadxp.mLinkColor);
        locala.e.setLinkTextColor(paramadxp.mLinkColor);
      }
    }
    if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()) || (anlm.ayn()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        parame = paramView.getColorStateList(2131167326);
        if (!paramChatMessage.isSend()) {
          break label525;
        }
      }
      label525:
      for (paramView = paramView.getColorStateList(2131167325);; paramView = paramView.getColorStateList(2131167324))
      {
        xjx.a.a(locala).a(parame, paramView);
        return;
        parame = paramView.getColorStateList(2131167322);
        break;
      }
    }
    parame = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131167324);
    if (paramadxp.mTextColor != 0) {
      parame = ColorStateList.valueOf(paramadxp.mTextColor);
    }
    if (paramadxp.mLinkColor != 0) {
      paramView = ColorStateList.valueOf(paramadxp.mLinkColor);
    }
    xjx.a.a(locala).a(parame, paramView);
  }
  
  public void a(BaseBubbleBuilder.e parame, ChatMessage paramChatMessage) {}
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {}
    while (paramChatMessage.extraflag != 32768) {
      return false;
    }
    return true;
  }
  
  public aqob[] a(View paramView)
  {
    paramView = (xjx.a)wja.a(paramView);
    ChatMessage localChatMessage = paramView.mMessage;
    aqoa localaqoa = new aqoa();
    if (localChatMessage != null)
    {
      if (!localChatMessage.isMultiMsg) {
        break label45;
      }
      a(localaqoa, localChatMessage, null);
    }
    for (;;)
    {
      return localaqoa.a();
      label45:
      b(localaqoa, localChatMessage, paramView);
    }
  }
  
  public aqoa b(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    paramaqoa.UY(this.mContext.getString(2131692252));
    int i;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label194;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        paramaqoa.Z(2131365509, this.mContext.getString(2131718654), 2130839079);
      }
      paramaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
      a(paramChatMessage, paramaqoa);
      a(paramaqoa, this.sessionInfo.cZ, parama.mMessage);
      a(paramaqoa, paramChatMessage);
      if (wja.eU(5) == 1) {
        paramaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
      }
      super.a(paramaqoa, this.mContext, paramChatMessage);
      b(paramChatMessage, paramaqoa);
      super.c(paramaqoa, this.mContext);
      super.e(paramaqoa, this.mContext);
      return paramaqoa;
      if (((paramChatMessage instanceof MessageForLongMsg)) && (!((MessageForLongMsg)paramChatMessage).canSelectable())) {
        i = 0;
      } else {
        label194:
        i = 1;
      }
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return "";
  }
  
  public void e(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void ei(View paramView)
  {
    paramView = (xjx.a)wja.a(paramView);
    if ((paramView.mMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.mMessage;
      if (paramView.isSendFromLocal())
      {
        ausj localausj = (ausj)auss.a(this.mContext, null);
        localausj.addButton(2131690230, 5);
        localausj.addCancelButton(2131721058);
        localausj.a(new xka(this, paramView, localausj));
        localausj.show();
      }
    }
  }
  
  public void v(View paramView, boolean paramBoolean)
  {
    Object localObject = (xjx.a)wja.a(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).v(paramView, true);
    }
    localObject = xjx.a.a((xjx.a)localObject).getBackground();
    if (localObject != null) {
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (paramView = null;; paramView = d)
    {
      ((Drawable)localObject).setColorFilter(paramView);
      ((Drawable)localObject).invalidateSelf();
      return;
    }
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    public TextView Jm;
    public aavr a;
    private MixedMsgLinearLayout a;
    private String aUZ = "0";
    public int bTz = -1;
    public ETTextView d;
    public ETTextView e;
    public TextView mText;
    public boolean oA;
    private long uniseq;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjx
 * JD-Core Version:    0.7.0.1
 */
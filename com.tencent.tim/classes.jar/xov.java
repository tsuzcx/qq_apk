import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.RelativeSizeSpan;
import android.text.util.Linkify;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.e;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.util.Pair;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class xov
  extends BaseBubbleBuilder
  implements Handler.Callback, BaseBubbleBuilder.d
{
  private static String aVN = "ArkApp.TextItemBuilder";
  public static final int bTs = BaseChatItemLayout.bNV + BaseChatItemLayout.bOa;
  protected static final int bTt = BaseChatItemLayout.bNW + BaseChatItemLayout.bOb;
  public static final int bTu = BaseChatItemLayout.bNX + BaseChatItemLayout.bOc;
  public static final int bTv = BaseChatItemLayout.bNY + BaseChatItemLayout.bOd;
  public static final LRULinkedHashMap<Long, SpannableString> f = new LRULinkedHashMap(50);
  private ETTextView.e a;
  protected AnimationTextView.a a;
  protected View.OnClickListener dM = new xox(this);
  public Handler mUIHandler = null;
  protected View.OnClickListener onClickListener = new xow(this);
  
  public xov(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$a = new xov.b(this.app, (Activity)this.mContext);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView$e = new xpb(this);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Activity paramActivity, ChatMessage paramChatMessage, String paramString)
  {
    paramChatMessage.msg = p(paramChatMessage.msg, true);
    paramString = p(paramString, true);
    aviz.a(null, paramString).b(paramQQAppInterface, paramChatMessage).b(paramActivity, paramQQAppInterface.getAccount());
    avjg.a(paramQQAppInterface, 6, 1);
    return paramString;
  }
  
  private String a(ChatMessage paramChatMessage, Context paramContext, xov.a parama)
  {
    Object localObject = "";
    if ((paramChatMessage instanceof MessageForText))
    {
      localObject = (MessageForText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008)
      {
        if (paramChatMessage.isSend())
        {
          parama.mText.setText(paramContext.getString(2131719356));
          return "";
        }
        parama.mText.setText(paramContext.getString(2131719355));
        return "";
      }
      a(parama, paramChatMessage);
      if (!TextUtils.isEmpty(((MessageForText)localObject).sb))
      {
        if (!TextUtils.isEmpty(((MessageForText)localObject).sb2))
        {
          parama.mText.setText(((MessageForText)localObject).sb2);
          super.a(parama.mText, paramChatMessage);
          if (AppSetting.enableTalkBack)
          {
            paramChatMessage = aofy.og(paramChatMessage.msg);
            paramContext = Spannable.Factory.getInstance().newSpannable(paramChatMessage);
            if (!Linkify.addLinks(paramContext, 15)) {
              break label180;
            }
            parama.mText.setContentDescription(paramContext);
          }
        }
        for (;;)
        {
          return ((MessageForText)localObject).sb.toString();
          parama.mText.setText(((MessageForText)localObject).sb);
          break;
          label180:
          parama.mText.setContentDescription(paramChatMessage);
        }
      }
      parama.mText.setText("");
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "textitem text.sb is null" + paramChatMessage.msgtype);
      }
      return "";
    }
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramContext = (MessageForHiBoom)paramChatMessage;
      paramChatMessage = (ChatMessage)localObject;
      if (paramContext.mHiBoomMessage != null)
      {
        parama.mText.setText(paramContext.mHiBoomMessage.text);
        paramChatMessage = paramContext.mHiBoomMessage.text;
      }
      return paramChatMessage;
    }
    if ((paramChatMessage instanceof MessageForPoke))
    {
      paramContext = (MessageForPoke)paramChatMessage;
      paramChatMessage = acfp.m(2131715253);
      if (paramContext.name != null) {
        paramChatMessage = "[" + paramContext.name + "]请用最新版手机QQ查看。";
      }
      parama.mText.setText(paramChatMessage);
      return paramChatMessage;
    }
    parama.mText.setText(paramChatMessage.msg);
    super.a(parama.mText, paramChatMessage);
    return paramChatMessage.msg;
  }
  
  public static void a(Message paramMessage, XListView paramXListView)
  {
    long l = paramMessage.getData().getLong("msg_id");
    paramXListView = wja.a(paramXListView, wja.a(l, paramXListView.getAdapter()));
    if ((paramXListView != null) && ((paramXListView.getTag() instanceof xov.a)))
    {
      paramXListView = (xov.a)paramXListView.getTag();
      if (paramXListView.Ji == l)
      {
        if ((paramMessage.obj instanceof SpannableString))
        {
          paramMessage = (SpannableString)paramMessage.obj;
          paramXListView.mText.setText(paramMessage);
          ((ETTextView)paramXListView.mText).mMagicFont = true;
          if ((paramXListView.mText instanceof ETTextView))
          {
            ETTextView localETTextView = (ETTextView)paramXListView.mText;
            if (localETTextView.mFont != null) {
              localETTextView.mFont.mText = paramMessage;
            }
          }
        }
        if (((ETTextView)paramXListView.mText).isUsingHYFont()) {
          ((ETTextView)paramXListView.mText).isParsingMagicFont = false;
        }
        paramXListView.mText.requestLayout();
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, xov.a parama)
  {
    if ((parama.mText instanceof AnimationTextView))
    {
      parama = (AnimationTextView)parama.mText;
      ApolloUtil.a(this.app, this.sessionInfo, paramChatMessage, parama, parame.pos, parame.count, false);
      parama.onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$a;
      parama.onSingleClick = new xoy(this, paramChatMessage.isSend());
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, xov.a parama)
  {
    if (parama.sM != null) {
      parama.sM.setVisibility(8);
    }
    if (parama.sL != null) {
      parama.sL.setVisibility(8);
    }
    paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(2131364534);
    int i;
    if ((paramChatMessage.mNeedTimeStamp) && (paramChatMessage.time > 0L) && (paramBaseChatItemLayout != null) && (paramChatMessage.time != ((Long)paramBaseChatItemLayout.getTag()).longValue()))
    {
      if (parama.sL != null) {
        parama.sL.setPadding(0, wja.dp2px(70.0F, paramContext.getResources()), 0, 0);
      }
      if (parama.sM != null) {
        parama.sM.setPadding(0, wja.dp2px(80.0F, paramContext.getResources()), 0, 0);
      }
      if (((paramChatMessage.extraflag != 32768) || (!paramChatMessage.isSendFromLocal())) && (!this.app.a().aS(paramChatMessage))) {
        break label306;
      }
      i = 1;
      label177:
      if ((paramChatMessage.isFlowMessage) && (i == 0) && (!(this.mContext instanceof MultiForwardActivity)) && (!this.sessionInfo.beB))
      {
        if (!paramChatMessage.isSend()) {
          break label312;
        }
        if (parama.sL != null)
        {
          parama.sL.setImageResource(2130847981);
          parama.sL.setVisibility(0);
        }
      }
    }
    label306:
    label312:
    while (parama.sM == null)
    {
      return;
      if (parama.sL != null) {
        parama.sL.setPadding(0, wja.dp2px(30.0F, paramContext.getResources()), 0, 0);
      }
      if (parama.sM == null) {
        break;
      }
      parama.sM.setPadding(0, wja.dp2px(30.0F, paramContext.getResources()), 0, 0);
      break;
      i = 0;
      break label177;
    }
    parama.sM.setImageResource(2130847981);
    parama.sM.setVisibility(0);
  }
  
  private boolean a(ChatMessage paramChatMessage, xov.a parama)
  {
    int i = 0;
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      i = Color.parseColor("#FFFFFFFF");
      j = Color.parseColor("#ff5078f0");
      parama.mText.setTextColor(i);
      parama.mText.setLinkTextColor(j);
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.sessionInfo.cZ != 0);
      bool1 = bool2;
    } while (!xva.a().a(this, this.sessionInfo));
    if (!paramChatMessage.isSend()) {
      i = 1;
    }
    if (i != 0) {
      j = Color.parseColor("#ff000000");
    }
    for (i = Color.parseColor("#ff80e9ff");; i = Color.parseColor("#ff5078f0"))
    {
      parama.mText.setTextColor(j);
      parama.mText.setLinkTextColor(i);
      return true;
      j = Color.parseColor("#FFFFFFFF");
    }
  }
  
  private void f(ChatMessage paramChatMessage, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    Object localObject;
    int i;
    if ((paramChatMessage instanceof MessageForText))
    {
      wta.a(this.mContext, this.app, paramChatMessage, 3);
      localObject = (MessageForText)paramChatMessage;
      if (!aavp.a().isSelected()) {
        break label273;
      }
      localObject = aavp.a().qL();
      if (localObject == null) {
        break label268;
      }
      if (((String)localObject).length() != aavp.a().length()) {
        break label263;
      }
      i = 1;
      localBundle.putString("forward_text", (String)localObject);
      localBundle.putInt("selection_mode", this.bOY);
      localBundle.putInt("forward_source_uin_type", this.sessionInfo.cZ);
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      ahgq.f((Activity)this.mContext, (Intent)localObject, 21);
      anot.a(this.app, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "1", "", "", "");
      if (i == 0) {
        break label308;
      }
      anot.a(this.app, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
    }
    for (;;)
    {
      if (paramChatMessage.isMultiMsg) {
        anot.a(this.app, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
      }
      return;
      label263:
      i = 0;
      break;
      label268:
      i = 0;
      break;
      label273:
      if (((MessageForText)localObject).sb != null) {}
      for (localObject = ((MessageForText)localObject).sb.toString();; localObject = ((MessageForText)localObject).msg)
      {
        i = 1;
        break;
      }
      label308:
      anot.a(this.app, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
    }
  }
  
  private void g(ChatMessage paramChatMessage, String paramString)
  {
    int i;
    if (paramChatMessage.msg != null)
    {
      wta.a(this.mContext, this.app, paramChatMessage, 2);
      if (paramChatMessage.isMultiMsg)
      {
        ajlg.report("0X8009AB7");
        i = 1;
        if ((paramChatMessage instanceof MessageForLongTextMsg)) {
          i = 2;
        }
        anot.a(this.app, "dc00898", "", "", "0X8009D65", "0X8009D65", i, 0, "" + i, "", "", "");
      }
      anot.a(this.app, "CliOper", "", "", "0X800644A", "0X800644A", 0, 0, "1", "", "", "");
    }
    for (;;)
    {
      try
      {
        if (aavp.a().isSelected())
        {
          paramChatMessage = aavp.a().qL();
          if (paramChatMessage == null) {
            break label312;
          }
          if (paramChatMessage.length() != aavp.a().length()) {
            break label307;
          }
          i = 1;
          break label303;
          if (i != 0)
          {
            anot.a(this.app, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
            ((ClipboardManager)this.mContext.getSystemService("clipboard")).setText(paramChatMessage);
            if (!QLog.isColorLevel()) {
              break label306;
            }
            QLog.d("ChatItemBuilder", 2, "Copy message, msg=" + paramChatMessage);
          }
        }
        else
        {
          paramChatMessage = paramChatMessage.msg;
          i = 1;
          continue;
        }
        anot.a(this.app, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
        continue;
        QLog.e("ChatItemBuilder", 2, paramChatMessage.toString());
      }
      catch (Exception paramChatMessage)
      {
        if (!QLog.isColorLevel()) {
          break label306;
        }
      }
      return;
      for (;;)
      {
        label303:
        break;
        label306:
        return;
        label307:
        i = 0;
      }
      label312:
      i = 0;
    }
  }
  
  public static String p(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int k = paramString.length();
    int i = 0;
    if (i < k)
    {
      int j = i;
      if ('\024' == paramString.charAt(i))
      {
        j = i;
        if (i + 1 < k)
        {
          j = i;
          if ('ÿ' == paramString.charAt(i + 1))
          {
            j = i;
            if (i + 2 < k)
            {
              if (!paramBoolean) {
                break label116;
              }
              if (paramString.charAt(i + 2) == '\024') {
                paramString.setCharAt(i + 2, 'ý');
              }
            }
          }
        }
      }
      for (;;)
      {
        j = i + 4;
        i = j + 1;
        break;
        label116:
        if (paramString.charAt(i + 2) == 'ý') {
          paramString.setCharAt(i + 2, '\024');
        }
      }
    }
    return paramString.toString();
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public SpannableString a(CharSequence paramCharSequence, long paramLong)
  {
    String str1 = aofy.oi(paramCharSequence.toString());
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont msg is empty");
      }
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = adpo.a(null, str1);
    String[] arrayOfString = ((adpo.a)localObject).es;
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont word segment cost " + (l2 - l1) + "ms; msg length = " + paramCharSequence.length());
    }
    if (!((adpo.a)localObject).success)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont so not init");
      }
      return null;
    }
    if (arrayOfString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatItemBuilder", 2, "generateMagicFont words = null");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "generateMagicFont words count = " + arrayOfString.length);
    }
    int i = 0;
    localObject = new ArrayList();
    int j = 0;
    int k;
    if (j < arrayOfString.length)
    {
      while ((i < str1.length()) && (str1.charAt(i) == ' ')) {
        i += 1;
      }
      String str2 = arrayOfString[j];
      k = 0;
      for (;;)
      {
        if ((k >= str2.length()) || (str2.charAt(k) < '一') || (str2.charAt(k) > 40891))
        {
          if (k == str2.length()) {
            ((ArrayList)localObject).add(new Pair(Integer.valueOf(i), Integer.valueOf(str2.length() + i)));
          }
          i += str2.length();
          j += 1;
          break;
        }
        k += 1;
      }
    }
    if (((ArrayList)localObject).size() < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont words count = 0");
      }
      return null;
    }
    float f1 = 1.5F;
    if (acej.aV() == 18.0F) {
      f1 = 1.3F;
    }
    i = (int)(((ArrayList)localObject).size() * 0.3F + 0.5D);
    j = (int)(((ArrayList)localObject).size() * 0.3F + 0.5D);
    float f2;
    boolean bool1;
    int i1;
    if (ku.jdField_E_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f2 = ku.X;
      f1 = ku.Y;
      if (acej.aV() == 18.0F)
      {
        f2 = ku.Z;
        f1 = ku.aa;
      }
      bool1 = ku.cD;
      i = (int)(((ArrayList)localObject).size() * ku.jdField_E_of_type_Float + 0.5D);
      j = (int)(((ArrayList)localObject).size() * ku.W + 0.5D);
      i1 = ku.iD;
    }
    for (;;)
    {
      paramCharSequence = new SpannableString(paramCharSequence);
      if (((ArrayList)localObject).size() != 1) {
        break label1066;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord");
      }
      if ((bool1) && (((Integer)((Pair)((ArrayList)localObject).get(0)).second).intValue() - ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue() > 1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord switch = " + bool1 + " length = " + (((Integer)((Pair)((ArrayList)localObject).get(0)).second).intValue() - ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue()));
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "generateMagicFont config not init");
      }
      i1 = 4;
      f2 = f1;
      bool1 = true;
      f1 = 0.7F;
    }
    if (((Integer)((Pair)((ArrayList)localObject).get(0)).second).intValue() - ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue() == 2) {}
    label1181:
    for (i = 1;; i = 2)
    {
      int m = 0;
      k = 0;
      int n = i;
      if (k < ((Integer)((Pair)((ArrayList)localObject).get(0)).second).intValue() - ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue())
      {
        i = m;
        j = n;
        if (paramLong % (((Integer)((Pair)((ArrayList)localObject).get(0)).second).intValue() - ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue() - k) < n) {
          if (m % 2 != 1) {
            break label1512;
          }
        }
      }
      label1066:
      label1497:
      label1512:
      for (float f3 = f1;; f3 = f2)
      {
        paramCharSequence.setSpan(new RelativeSizeSpan(f3), ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue() + k, ((Integer)((Pair)((ArrayList)localObject).get(0)).first).intValue() + k + 1, 33);
        n -= 1;
        m += 1;
        i = m;
        j = n;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatItemBuilder", 2, "generateMagicFont oneWord change index = " + ((Pair)((ArrayList)localObject).get(0)).first + k + " changeSize = " + f3);
          j = n;
          i = m;
        }
        paramLong = (25214903917L * paramLong + 11L & 0xFFFFFFFF) >> 16;
        k += 1;
        m = i;
        n = j;
        break;
        int i2 = 0;
        k = j;
        m = 0;
        n = 0;
        j = i;
        i = k;
        k = n;
        if (i2 < ((ArrayList)localObject).size())
        {
          boolean bool2 = false;
          bool1 = bool2;
          if (i1 > 0)
          {
            bool1 = bool2;
            if (i2 % i1 == i1 - 1)
            {
              bool1 = bool2;
              if (m == 0) {
                bool1 = true;
              }
            }
          }
          if ((paramLong % (((ArrayList)localObject).size() - i2) >= j + i) && (!bool1)) {
            break label1497;
          }
          if ((j <= 0) && (i > 0))
          {
            f3 = f1;
            m = j;
            if (f3 == f2) {
              m = j - 1;
            }
            j = i;
            if (f3 == f1) {
              j = i - 1;
            }
            paramCharSequence.setSpan(new RelativeSizeSpan(f3), ((Integer)((Pair)((ArrayList)localObject).get(i2)).first).intValue(), ((Integer)((Pair)((ArrayList)localObject).get(i2)).second).intValue(), 33);
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "generateMagicFont word change: " + ((Pair)((ArrayList)localObject).get(i2)).first + " , " + ((Pair)((ArrayList)localObject).get(i2)).second + " size = " + f3 + " index = " + i2 + " forceChange = " + bool1);
            }
            n = 1;
            i = m;
            k += 1;
            m = n;
          }
        }
        for (;;)
        {
          n = m;
          if (i1 > 0)
          {
            n = m;
            if (i2 % i1 == i1 - 1) {
              n = 0;
            }
          }
          paramLong = (25214903917L * paramLong + 11L & 0xFFFFFFFF) >> 16;
          i2 += 1;
          m = n;
          n = i;
          i = j;
          j = n;
          break;
          if ((i <= 0) && (j > 0))
          {
            f3 = f2;
            break label1181;
          }
          if (k % 2 == 1)
          {
            f3 = f1;
            break label1181;
            return paramCharSequence;
          }
          f3 = f2;
          break label1181;
          n = j;
          j = i;
          i = n;
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    xov.a locala;
    Object localObject1;
    label155:
    Object localObject2;
    Object localObject3;
    if ((parame instanceof xov.a))
    {
      locala = (xov.a)parame;
      if (paramView != null) {
        break label843;
      }
      localObject1 = new ImageView(localContext);
      ((ImageView)localObject1).setId(2131367330);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(0, 2131364503);
      paramView.addRule(15, 2131363321);
      ((ImageView)localObject1).setContentDescription(acfp.m(2131715252));
      paramBaseChatItemLayout.addView((View)localObject1, paramView);
      ((ImageView)localObject1).setOnClickListener(this.dM);
      paramView = new ETTextView(localContext);
      aofy.P(paramView);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131167322));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131167316));
      if (!AppSetting.enableTalkBack) {
        break label814;
      }
      paramView.setAutoLinkMask(3);
      paramView.setSpannableFactory(aofk.a);
      paramView.setMaxWidth(BaseChatItemLayout.bNS);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      paramView.setTextAnimationListener(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView$e);
      paramView.setId(2131364506);
      localObject2 = new ImageView(localContext);
      ((ImageView)localObject2).setId(2131367331);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131364503);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, 2131363321);
      ((ImageView)localObject2).setContentDescription(acfp.m(2131715254));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 10;
      paramBaseChatItemLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setOnClickListener(this.dM);
      locala.mText = paramView;
      locala.sL = ((ImageView)localObject1);
      locala.sM = ((ImageView)localObject2);
      locala.jdField_a_of_type_Aavr = new aavr();
      locala.jdField_a_of_type_Aavr.a(paramView);
      locala.jdField_a_of_type_Aavr.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    }
    label814:
    label822:
    label843:
    for (;;)
    {
      ((ETTextView)locala.mText).setFont(0, paramChatMessage.uniseq);
      locala.mText.setTypeface(null);
      ((ETTextView)locala.mText).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      ((ETTextView)locala.mText).setStrokeColor(false, 0);
      ((ETTextView)locala.mText).mMagicFont = false;
      ((ETTextView)locala.mText).setCacheMeasureResult(true);
      locala.mText.setTypeface(lf.a(paramChatMessage));
      if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        localObject1 = ((ETTextView)locala.mText).getETLayout();
        if (localObject1 != null) {
          ((ko)localObject1).mMsgId = (paramChatMessage.uniseq + 1L);
        }
      }
      locala.mText.setTextSize(0, this.sessionInfo.cN);
      locala.mText.setGravity(16);
      int j = BaseChatItemLayout.bOc;
      int i = BaseChatItemLayout.bOd;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.bOd;
        i = BaseChatItemLayout.bOc;
      }
      locala.mText.setPadding(j, BaseChatItemLayout.bOa, i, BaseChatItemLayout.bOb);
      locala.Ji = paramChatMessage.uniseq;
      localObject1 = a(paramChatMessage, localContext, locala);
      localObject2 = (aptw)this.app.getManager(203);
      if (aptw.bg(paramChatMessage)) {
        aptw.a(locala.mText, paramChatMessage);
      }
      localObject3 = aquv.a();
      if (((this.sessionInfo.cZ == 0) || (this.sessionInfo.cZ == 1) || (this.sessionInfo.cZ == 3000)) && (!paramChatMessage.isread))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TextItemBuilder.getBubbleView()");
        }
        ((aquv)localObject3).a(this.app, this.sessionInfo, paramChatMessage, (String)localObject1, localContext, paramChatMessage.isSend());
      }
      locala.mText.setOnTouchListener(paramwlz);
      locala.mText.setOnLongClickListener(paramwlz);
      locala.d = paramwlz;
      locala.mText.setOnClickListener(this.onClickListener);
      a(paramChatMessage, parame, locala);
      a(paramChatMessage, paramBaseChatItemLayout, localContext, locala);
      if (locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
      {
        if (!((aptw)localObject2).f(this.app, paramChatMessage)) {
          break label822;
        }
        locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.mContext, this.app, paramChatMessage);
      }
      for (;;)
      {
        if (locala.jdField_a_of_type_Aavr != null) {
          locala.jdField_a_of_type_Aavr.P(paramChatMessage);
        }
        return paramView;
        locala = (xov.a)a();
        locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
        paramBaseChatItemLayout.setTag(locala);
        paramView = null;
        break;
        paramView.setAutoLinkMask(0);
        break label155;
        locala.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.mContext, this.app, paramChatMessage);
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
    return new xov.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    String str1;
    if (this.app != null)
    {
      String str2 = this.app.getCurrentAccountUin();
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "";
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131365686: 
    case 2131365509: 
    case 2131377193: 
    case 2131367523: 
    case 2131366733: 
      do
      {
        do
        {
          return;
          str1 = "";
          break;
          ujt.b(this.mContext, this.app, paramChatMessage);
          anot.a(this.app, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "1", "", "", "");
          anot.a(this.app, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
          return;
          g(paramChatMessage, str1);
          return;
        } while (this.app == null);
        ujt.a(this.app, this.mContext, this.sessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
        return;
        f(paramChatMessage, str1);
        return;
        e(paramChatMessage, str1);
        wta.a(this.mContext, this.app, paramChatMessage, 4);
        avjg.a(this.app, 1, 0, paramChatMessage.istroop);
      } while (!paramChatMessage.isMultiMsg);
      anot.a(this.app, "dc00898", "", "", "0X8009D67", "0X8009D67", 1, 0, "1", "", "", "");
      return;
    case 2131372073: 
      super.m(paramChatMessage);
      anot.a(this.app, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
      return;
    case 2131372030: 
      super.j(paramChatMessage);
      anot.a(this.app, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
      return;
    case 2131377931: 
      aavp.a().O(paramChatMessage);
      anot.a(this.app, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
      return;
    case 2131377133: 
      anot.a(this.app, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
      k(paramChatMessage);
      return;
    case 2131377644: 
      aupe.a(paramChatMessage, this.mContext, this.app);
      return;
    }
    ((augo)this.app.getManager(374)).B(paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(bTv, bTs, bTu, bTt);
      return;
    }
    paramView.setPadding(bTu, bTs, bTv, bTt);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if (paramInt == 1)
    {
      BaseBubbleBuilder.e locale = (BaseBubbleBuilder.e)paramView.getTag();
      if (locale != null) {
        a(locale, paramView, paramChatMessage, locale.b);
      }
    }
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    Object localObject;
    if ((paramChatMessage instanceof MessageForLongTextMsg))
    {
      localObject = (MessageForLongTextMsg)paramChatMessage;
      if ((!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("2")) && (!((MessageForLongTextMsg)localObject).getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {}
    }
    label47:
    label192:
    label200:
    label246:
    do
    {
      do
      {
        break label47;
        break label47;
        do
        {
          return;
        } while (!(parame instanceof xov.a));
        localObject = (xov.a)parame;
      } while (a(paramChatMessage, (xov.a)localObject));
      boolean bool = anlm.ayn();
      if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()) || (bool))
      {
        paramView = paramView.getResources();
        int i;
        if (paramChatMessage.isSend())
        {
          parame = paramView.getColorStateList(2131167326);
          ((xov.a)localObject).mText.setTextColor(parame);
          if (aine.f(this.sessionInfo))
          {
            if (!paramChatMessage.isSend()) {
              break label192;
            }
            i = -1;
            ((xov.a)localObject).mText.setTextColor(i);
          }
          if (!paramChatMessage.isSend()) {
            break label200;
          }
        }
        for (parame = paramView.getColorStateList(2131167325);; parame = paramView.getColorStateList(2131167324))
        {
          ((xov.a)localObject).mText.setLinkTextColor(parame);
          return;
          parame = paramView.getColorStateList(2131167322);
          break;
          i = -16777216;
          break label146;
        }
      }
      ColorStateList.valueOf(paramadxp.mTextColor);
      if (paramadxp.mTextColor == 0)
      {
        ((xov.a)localObject).mText.setTextColor(-16777216);
        ColorStateList.valueOf(-16777216);
        if (paramadxp.mLinkColor != 0) {
          break label384;
        }
      }
      for (parame = paramView.getResources().getColorStateList(2131167324);; parame = ColorStateList.valueOf(paramadxp.mLinkColor))
      {
        ((xov.a)localObject).mText.setLinkTextColor(parame);
        if (!(((xov.a)localObject).mText instanceof ETTextView)) {
          break;
        }
        if (!paramadxp.hasStroke) {
          break label396;
        }
        ((ETTextView)((xov.a)localObject).mText).setShadowLayer(3.0F, 0.0F, 0.0F, paramadxp.mStrokeColor);
        ((ETTextView)((xov.a)localObject).mText).setStrokeColor(true, paramadxp.mStrokeColor);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramadxp.mStrokeColor);
        return;
        ((xov.a)localObject).mText.setTextColor(paramadxp.mTextColor);
        break label246;
      }
    } while ((!paramadxp.bRF) || (((ChatBackgroundManager)this.app.getManager(63)).a(this.mContext, this.sessionInfo, ((xov.a)localObject).mText.getCurrentTextColor(), 10000.0D * ((xov.a)localObject).b.cs) != 1));
    label146:
    parame = (ETTextView)((xov.a)localObject).mText;
    label384:
    label396:
    float f2 = parame.getTextSize() * 3.0F / 16.0F;
    float f1 = f2;
    if (f2 > 25.0F) {
      f1 = 25.0F;
    }
    parame.setTextColor(-1);
    ColorStateList.valueOf(-1);
    parame.setShadowLayer(f1, 0.0F, 0.0F, paramadxp.mStrokeColor);
  }
  
  public void a(BaseBubbleBuilder.e parame, ChatMessage paramChatMessage) {}
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
  }
  
  void a(xov.a parama, ChatMessage paramChatMessage) {}
  
  public boolean a(BaseBubbleBuilder.e parame)
  {
    return parame instanceof xov.a;
  }
  
  public aqob[] a(View paramView)
  {
    paramView = wja.a(paramView);
    localaqoa = new aqoa();
    if ((paramView != null) && (paramView.istroop == 10007))
    {
      localaqoa.Z(2131365509, this.mContext.getString(2131721060), 2130839077);
      return localaqoa.a();
    }
    if ((paramView != null) && (paramView.isMultiMsg))
    {
      localaqoa.Z(2131365509, this.mContext.getString(2131721060), 2130839077);
      localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
      localaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
      return localaqoa.a();
    }
    if (aegu.ag(paramView)) {
      return localaqoa.a();
    }
    if (ApolloUtil.V(paramView)) {
      return localaqoa.a();
    }
    int i = 0;
    j = 0;
    if ((paramView instanceof MessageForText)) {
      if (TextUtils.isEmpty(((MessageForText)paramView).getExtInfoFromExtStr("sticker_info"))) {
        break label515;
      }
    }
    label515:
    for (i = 1;; i = 0)
    {
      String str = paramView.getExtInfoFromExtStr("key_message_extra_info_flag");
      j = 0;
      try
      {
        int k = Integer.parseInt(str);
        j = k;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("ChatItemBuilder", 1, localThrowable, new Object[0]);
          continue;
          j = 0;
          continue;
          ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
        }
      }
      if ((j & 0x2) != 2) {
        break;
      }
      j = 1;
      if (j != 0) {
        anot.a(this.app, "dc00898", "", "", "0X8009B17", "0X8009B17", 0, 0, "", "", "", "");
      }
      if ((paramView instanceof MessageForPoke)) {
        i = 1;
      }
      if (i != 0) {
        break label542;
      }
      if (j == 0) {
        localaqoa.Z(2131365509, acfp.m(2131715250), 2130839077);
      }
      if ((paramView != null) && (paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
        localaqoa.Z(2131377193, this.mContext.getString(2131718661), 2130839091);
      }
      if (j == 0) {
        localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
      }
      a(paramView, localaqoa);
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.app.a().aR(paramView))) {
        a(localaqoa, this.sessionInfo.cZ, paramView);
      }
      a(localaqoa, paramView);
      if (wja.eU(5) == 1) {
        localaqoa.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
      }
      b(paramView, localaqoa);
      super.c(localaqoa, this.mContext);
      super.e(localaqoa, this.mContext);
      localaqoa.Z(2131377644, this.mContext.getString(2131721205), 2130839098);
      localaqoa.Z(2131377998, this.mContext.getString(2131719492), 2130840517);
      return localaqoa.a();
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForText)) || ((paramChatMessage instanceof MessageForReplyText))) {
      return acfp.m(2131715251) + aofy.og(paramChatMessage.msg);
    }
    return acfp.m(2131715249) + paramChatMessage.msg;
  }
  
  public void b(BaseBubbleBuilder.e parame, ChatMessage paramChatMessage)
  {
    int i = 0;
    super.b(parame, paramChatMessage);
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      break label15;
    }
    label15:
    xov.a locala;
    label146:
    label152:
    for (;;)
    {
      return;
      if ((parame instanceof xov.a))
      {
        locala = (xov.a)parame;
        if (!(paramChatMessage instanceof MessageForText)) {
          break;
        }
        paramChatMessage = (MessageForText)paramChatMessage;
        parame = null;
        if (!TextUtils.isEmpty(paramChatMessage.sb)) {
          if (TextUtils.isEmpty(paramChatMessage.sb2)) {
            break label146;
          }
        }
        for (parame = paramChatMessage.sb2;; parame = paramChatMessage.sb)
        {
          if ((parame == null) || (!(parame instanceof aofk))) {
            break label152;
          }
          paramChatMessage = (aofk)parame;
          parame = (aofk.a[])paramChatMessage.getSpans(0, parame.length(), aofk.a.class);
          if ((parame.length <= 0) || (paramChatMessage.AF().length() != 0)) {
            break;
          }
          int j = parame.length;
          while (i < j)
          {
            parame[i].setSize(ankt.dip2px(26.0F));
            i += 1;
          }
        }
      }
    }
    locala.mText.setText(paramChatMessage);
  }
  
  public void destroy()
  {
    super.destroy();
    ETEngine.getInstance().onAIODestroy();
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
  
  protected void e(ChatMessage paramChatMessage, String paramString)
  {
    aavp localaavp = aavp.a();
    int i;
    if (localaavp.isSelected())
    {
      localObject = localaavp.qL();
      if (localObject != null) {
        if (((String)localObject).length() == localaavp.length())
        {
          i = 1;
          localaavp.detach();
        }
      }
    }
    for (;;)
    {
      localObject = a(this.app, (Activity)this.mContext, paramChatMessage, (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label94;
      }
      return;
      i = 0;
      break;
      i = 0;
      break;
      localObject = paramChatMessage.msg;
      i = 1;
    }
    label94:
    Object localObject = new StringBuilder((String)localObject);
    int j = 0;
    while (j < ((StringBuilder)localObject).length())
    {
      if ((((StringBuilder)localObject).codePointAt(j) == 20) && (j < ((StringBuilder)localObject).length() - 1) && (((StringBuilder)localObject).charAt(j + 1) == 'ÿ'))
      {
        anot.a(this.app, "CliOper", "", "", "ep_mall", "0X800588D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "report save small emoticon amount");
        }
        avjg.a(this.app, 13, 0, paramChatMessage.istroop);
        return;
      }
      j += 1;
    }
    if (i == 0)
    {
      anot.a(this.app, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      return;
    }
    anot.a(this.app, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
  }
  
  public void eT(View paramView)
  {
    super.eT(paramView);
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    if (wja.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)wja.a(paramView);
      str1 = this.mContext.getString(2131690230);
      str2 = this.mContext.getString(2131690231);
    } while (!paramView.isSendFromLocal());
    aqha.a(this.mContext, 230, str1, str2, new xoz(this, paramView), new xpa(this)).show();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.mContext instanceof FragmentActivity))
      {
        ChatFragment localChatFragment = ((FragmentActivity)this.mContext).getChatFragment();
        if ((localChatFragment != null) && (localChatFragment.a() != null) && (localChatFragment.a().b != null)) {
          a(paramMessage, localChatFragment.a().b);
        }
      }
    }
  }
  
  public void v(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramView = null;; paramView = d)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {
    long Ji;
    public aavr a;
    wlz d;
    public TextView mText;
    public ImageView sL;
    public ImageView sM;
  }
  
  class b
    implements AnimationTextView.a
  {
    private WeakReference<QQAppInterface> bV;
    private WeakReference<Activity> eq;
    
    b(QQAppInterface paramQQAppInterface, Activity paramActivity)
    {
      this.bV = new WeakReference(paramQQAppInterface);
      this.eq = new WeakReference(paramActivity);
    }
    
    public void R(View paramView)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.bV.get();
      Activity localActivity = (Activity)this.eq.get();
      if ((localActivity == null) || (localQQAppInterface == null)) {
        QLog.e("ChatItemBuilder", 1, "TextItemBuilder  onDoubleClick  app null fa null");
      }
      do
      {
        do
        {
          return;
          wja.bcO = true;
        } while (xov.this.Rk());
        localObject = wja.a(paramView);
      } while ((aegu.ag((MessageRecord)localObject)) || (aine.f(xov.this.sessionInfo)) || (((ChatMessage)localObject).istroop == 10007) || (paramView.getId() == 2131379641) || (paramView.getId() == 2131371989) || (paramView.getId() == 2131364531));
      Object localObject = (FragmentActivity)paramView.getContext();
      if (localObject != null) {}
      for (localObject = ((FragmentActivity)localObject).getChatFragment();; localObject = null)
      {
        if (localObject == null)
        {
          ChatActivityUtils.a(localQQAppInterface, paramView, localActivity);
          return;
        }
        ChatActivityUtils.a(localQQAppInterface, paramView, localActivity, xov.this.sessionInfo.cZ);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xov
 * JD-Core Version:    0.7.0.1
 */
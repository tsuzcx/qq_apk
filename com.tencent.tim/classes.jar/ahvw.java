import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.StickerGrayTipLayout;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.1;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ahvw
  extends wjd
{
  private ConcurrentHashMap<Long, Boolean> fx = new ConcurrentHashMap(5);
  private HashMap<Long, Boolean> lh = new HashMap(10);
  private SparseBooleanArray o = new SparseBooleanArray(5);
  
  public ahvw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void X(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "onDelBtnClick fail cause message is null");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while (!(this.mContext instanceof FragmentActivity));
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "revoke msg click handle del msg");
      }
      localObject = ((FragmentActivity)this.mContext).getChatFragment();
    } while ((localObject == null) || (((ChatFragment)localObject).a() == null));
    for (;;)
    {
      try
      {
        if (!(paramChatMessage instanceof MessageForUniteGrayTip)) {
          continue;
        }
        localObject = (MessageForUniteGrayTip)paramChatMessage;
        if (((MessageForUniteGrayTip)localObject).istroop != 0) {
          continue;
        }
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.app.getCurrentAccountUin())) {
          continue;
        }
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        boolean bool1;
        boolean bool2;
        String str1;
        String str2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ChatItemBuilder", 1, "0X800A613", localRuntimeException);
        continue;
        int i = -1;
        continue;
        continue;
        i = 8;
        continue;
        i = 8;
        continue;
        i = 8;
        continue;
        i = 10;
        continue;
      }
      anot.a(this.app, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
      ujt.a(this.mContext, this.app, paramChatMessage);
      return;
      i = 2;
      continue;
      if (((MessageForUniteGrayTip)localObject).istroop == 1)
      {
        bool1 = apuh.f(this.app, paramChatMessage.frienduin, this.app.getCurrentUin());
        bool2 = apuh.g(this.app, paramChatMessage.frienduin, this.app.getCurrentUin());
        str1 = ((MessageForUniteGrayTip)localObject).tipParam.wording;
        str2 = acfp.m(2131716245) + this.app.getApp().getString(2131699921);
        if (bool1)
        {
          if (str1.startsWith(str2))
          {
            i = 3;
            continue;
          }
          if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.app.getCurrentAccountUin())) {
            continue;
          }
          i = 4;
          continue;
        }
        if (bool2)
        {
          if (str1.startsWith(str2))
          {
            i = 5;
            continue;
          }
          if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.app.getCurrentAccountUin())) {
            continue;
          }
          i = 6;
          continue;
        }
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.app.getCurrentAccountUin())) {
          continue;
        }
        i = 7;
        continue;
      }
      if (((MessageForUniteGrayTip)localObject).istroop == 3000)
      {
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.app.getCurrentAccountUin())) {
          continue;
        }
        i = 9;
      }
      else
      {
        bool1 = ((MessageForUniteGrayTip)localObject).tipParam.wording.equals(acfp.m(2131716244) + this.app.getApp().getString(2131696088));
        if (!bool1) {
          i = 11;
        } else {
          i = 12;
        }
      }
    }
  }
  
  public static void a(ChatMessage paramChatMessage, wjd.a parama, View paramView)
  {
    if ((parama != null) && (paramView != null) && (paramChatMessage == null)) {}
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    if (!(parama instanceof ahvw.a)) {
      QLog.e("ChatItemBuilder", 1, "diffclashh =" + parama.getClass());
    }
    ahvw.a locala = (ahvw.a)parama;
    if (paramView == null)
    {
      parama = LayoutInflater.from(this.mContext).inflate(2131558954, null);
      locala.mTextView = ((TextView)parama.findViewById(2131368123));
      locala.a = ((AutoBgImageView)parama.findViewById(2131377239));
      paramView = locala.mTextView.getLayoutParams();
      localObject1 = parama;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject1 = parama;
        if (paramView.rightMargin != BaseChatItemLayout.bOg) {
          paramView.rightMargin = BaseChatItemLayout.bOg;
        }
      }
    }
    for (Object localObject1 = parama;; localObject1 = paramView)
    {
      locala.mTextView.setLineSpacing(0.0F, 1.0F);
      locala.mTextView.setIncludeFontPadding(true);
      locala.mTextView.setMovementMethod(null);
      locala.mTextView.setTextColor(((View)localObject1).getResources().getColorStateList(2131167621));
      locala.mTextView.setGravity(19);
      locala.mTextView.setBackgroundResource(0);
      Object localObject2;
      int i1;
      ajdg localajdg;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject1 instanceof StickerGrayTipLayout))
      {
        aqmq.track(null, "AIO_Handle_Sticker_Cost");
        localObject2 = (StickerGrayTipLayout)localObject1;
        ((StickerGrayTipLayout)localObject2).removeAllStickers();
        parama = EmojiStickerManager.a().c(paramMessageRecord);
        i1 = this.mContext.getResources().getDisplayMetrics().widthPixels;
        if ((parama != null) && (parama.size() > 0))
        {
          localajdg = (ajdg)this.app.getManager(14);
          localList = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, parama);
          i = 0;
          j = 0;
          k = localList.size() - 1;
          if (k >= 0)
          {
            paramView = (MessageRecord)localList.get(k);
            if (paramView.extraflag != 32768) {}
          }
        }
      }
      for (;;)
      {
        k -= 1;
        break;
        EmojiStickerManager.StickerInfo localStickerInfo = EmojiStickerManager.a(paramView);
        if ((localStickerInfo != null) && (EmojiStickerManager.at(paramView)))
        {
          int m = i + 1;
          if (m > EmojiStickerManager.cRB)
          {
            paramView.msgtype = -2006;
            i = m;
          }
          else
          {
            if ((paramView instanceof MessageForMarketFace)) {
              parama = localajdg.a(((MessageForMarketFace)paramView).mMarkFaceMessage);
            }
            for (;;)
            {
              label424:
              int i2 = (int)(localStickerInfo.x * i1);
              i = (int)(localStickerInfo.y * i1);
              int i3 = (int)(localStickerInfo.width * i1);
              int i4 = (int)(localStickerInfo.height * i1);
              int i5 = localStickerInfo.rotate;
              if (k == localList.size() - 1)
              {
                if (i >= 0) {
                  break label2752;
                }
                i = -i;
                j = 0;
              }
              for (;;)
              {
                label506:
                float f = this.mContext.getResources().getDisplayMetrics().density;
                if ((parama instanceof afpu))
                {
                  paramView = (afpu)parama;
                  if (paramView.e == null) {
                    break label2725;
                  }
                  if ((!EmojiStickerManager.bYF) && (aqhq.getAvailableInnernalMemorySize() > 1.048576E+008F))
                  {
                    n = 1;
                    label559:
                    if (n == 0) {
                      break label701;
                    }
                    parama = paramView.a("fromAIO", true, false, null, i3, i3);
                    label579:
                    paramView = paramView.e.epId;
                  }
                }
                for (;;)
                {
                  if (parama != null) {
                    ((StickerGrayTipLayout)localObject2).a(parama, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label2767;
                  }
                  parama = (MessageForText)paramView;
                  if (TextUtils.isEmpty(parama.msg)) {
                    break label2767;
                  }
                  parama = EmojiStickerManager.a().a(parama.msg);
                  break label424;
                  n = j + i;
                  if (n >= 0) {
                    break label2733;
                  }
                  n = -i;
                  i = -i;
                  ((StickerGrayTipLayout)localObject2).Cj(n - j);
                  j = 0;
                  break label506;
                  n = 0;
                  break label559;
                  label701:
                  parama = paramView.b(this.mContext, f);
                  break label579;
                  if ((parama instanceof afqr))
                  {
                    parama = ((afqr)parama).c(this.mContext, f);
                    paramView = "";
                  }
                  else if ((parama instanceof afqh))
                  {
                    parama = ((afqh)parama).c(this.mContext, f);
                    paramView = "";
                  }
                  else
                  {
                    if ((paramView instanceof MessageForPic))
                    {
                      parama = xkl.b(this.mContext, (MessageForPic)paramView);
                      ThreadManager.post(new UniteGrayTipItemBuilder.1(this, paramView), 5, null, true);
                      paramView = "";
                      continue;
                      ((StickerGrayTipLayout)localObject1).a = new ahvx(this);
                      aqmq.track("AIO_Handle_Sticker_Cost", null);
                      if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
                      {
                        locala.mTextView.setText(paramMessageRecord.msg);
                        return localObject1;
                      }
                      paramView = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!wja.bcI) {
                        ahwb.a(paramView, this.app);
                      }
                      if ((paramView.tipParam != null) && (paramView.tipParam.dbK == 655381))
                      {
                        parama = (MessageForGrayTips.HightlightItem)paramView.tipParam.xg.get(paramView.tipParam.xg.size() - 1);
                        if ((parama != null) && (parama.actionType == 38)) {
                          j = 0;
                        }
                      }
                      try
                      {
                        i = Integer.parseInt(parama.mMsgActionData);
                        if (this.o.get(i, true))
                        {
                          anot.a(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
                          this.o.put(i, false);
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.dbK == 655383))
                        {
                          j = 0;
                          if (paramView.tipParam.xg != null) {
                            break label2379;
                          }
                          if (paramMessageRecord.istroop != 0) {
                            break label2371;
                          }
                          i = aize.dhb;
                          label1041:
                          if (!this.fx.containsKey(Long.valueOf(paramView.uniseq)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("ChatItemBuilder", 2, "Temp Report mark: grayTipsOnShow " + paramView.uniseq);
                            }
                            anot.a(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
                            this.fx.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.dbK == 655397))
                        {
                          ahwb.a(this.app, paramView);
                          parama = paramView.getExtInfoFromExtStr("unite_gray_tips_align");
                          if ((!TextUtils.isEmpty(parama)) && (parama.equals("center"))) {
                            locala.mTextView.setGravity(17);
                          }
                          locala.mTextView.setLineSpacing(8.0F, 1.0F);
                          if ((!"null".equals(((ChatBackgroundManager)this.app.getManager(63)).lQ(this.sessionInfo.aTl))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
                          {
                            locala.mTextView.setTextColor(((View)localObject1).getResources().getColorStateList(2131167507));
                            locala.mTextView.setBackgroundResource(2130851843);
                          }
                          parama = paramView.getExtInfoFromExtStr("uint64_busi_id");
                          if (("1008".equals(parama)) && (!paramView.docTipHasReport))
                          {
                            paramView.docTipHasReport = true;
                            anot.a(null, "dc00898", "", "", "0X800A638", "0X800A638", paramView.istroop, 0, "", "", "", "");
                          }
                          if (Long.valueOf(parama).equals(Long.valueOf(1021L)))
                          {
                            paramView.dkTipHasReport = true;
                            anot.a(this.app, "dc00898", "", "", "0X800AD82", "0X800AD82", 0, 0, "", "", "", "");
                          }
                        }
                        if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramView.tipParam == null) || ((paramView.tipParam != null) && (paramView.tipParam.xg == null))) && (QLog.isColorLevel()))
                        {
                          localObject2 = paramView.tipParam;
                          if (paramView.tipParam != null)
                          {
                            parama = paramView.tipParam.xg;
                            label1471:
                            QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject2, " hightLightItems=", parama });
                          }
                        }
                        else if ((paramView.tipParam != null) && (paramView.tipParam.dbK == 2))
                        {
                          locala.mTextView.setGravity(17);
                        }
                      }
                      catch (NumberFormatException localNumberFormatException1)
                      {
                        try
                        {
                          if ((paramView.tipParam != null) && (paramView.tipParam.dbK == 1))
                          {
                            parama = this.mContext.getResources().getDrawable(2130850428);
                            locala.a.setImageDrawable(parama);
                            locala.a.setContentDescription(this.mContext.getResources().getString(2131692498));
                            locala.a.setVisibility(0);
                            locala.a.setOnClickListener(new ahvy(this, locala));
                            locala.mTextView.setMaxWidth(aqnm.getScreenWidth() - aqnm.dpToPx(31.0F));
                            ((ViewGroup.MarginLayoutParams)locala.mTextView.getLayoutParams()).rightMargin = 0;
                          }
                          for (;;)
                          {
                            for (;;)
                            {
                              if ((paramView.tipParam == null) || (paramView.tipParam.xg == null)) {
                                break label2615;
                              }
                              long l1 = paramView.uniseq;
                              long l2 = locala.mPosition;
                              if (QLog.isColorLevel()) {
                                QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                              }
                              parama = paramView.tipParam.xg;
                              boolean bool1 = false;
                              if ((paramView.tipParam.dbK == 2097155) || (paramView.tipParam.dbK == 2097153) || (paramView.tipParam.dbK == 2097154) || (paramView.tipParam.dbK == 655397))
                              {
                                boolean bool2 = true;
                                bool1 = bool2;
                                if (!this.fx.containsKey(Long.valueOf(paramView.uniseq)))
                                {
                                  localObject2 = paramMessageRecord.getExtInfoFromExtStr("friendIconType");
                                  if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).equals("3")) || (((String)localObject2).equals("6"))))
                                  {
                                    if (!((String)localObject2).equals("3")) {
                                      break label2582;
                                    }
                                    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "1"));
                                    aiwk.K("6", "1", "1", LpReportInfo_dc03950.getReportUserType(this.app));
                                  }
                                  this.fx.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                                  bool1 = bool2;
                                }
                              }
                              paramLinearLayout = paramView.getHightlightMsgText(this.app, paramLinearLayout.getContext(), bool1, locala.mTextView);
                              locala.mTextView.setText(paramLinearLayout);
                              locala.mTextView.setClickable(true);
                              locala.mTextView.setFocusable(true);
                              locala.mTextView.setMovementMethod(areu.getInstance());
                              if (AppSetting.enableTalkBack) {
                                locala.mTextView.setAccessibilityDelegate(new ahvz(this, l1, l2, parama, paramLinearLayout));
                              }
                              locala.mTextView.setOnTouchListener(paramwlz);
                              locala.mTextView.setOnLongClickListener(paramwlz);
                              if (!TextUtils.isEmpty(paramView.contentDescription)) {
                                locala.mTextView.setContentDescription(paramView.contentDescription);
                              }
                              paramLinearLayout = locala.mTextView.getLayoutParams();
                              if ((paramView == null) || (paramView.tipParam == null) || (paramView.tipParam.dbK != 3276801)) {
                                break label2657;
                              }
                              paramwlz = this.mContext.getResources();
                              if (Build.VERSION.SDK_INT < 21) {
                                break label2645;
                              }
                              parama = paramwlz.getDrawable(2130851592, this.mContext.getTheme());
                              if (parama != null) {
                                parama.setBounds(0, 0, parama.getIntrinsicWidth(), parama.getIntrinsicHeight());
                              }
                              locala.mTextView.setCompoundDrawables(parama, null, null, null);
                              locala.mTextView.setCompoundDrawablePadding(wja.dp2px(8.0F, paramwlz));
                              if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
                              }
                              if ((localObject1 instanceof StickerGrayTipLayout)) {
                                ((StickerGrayTipLayout)localObject1).setGravity(16);
                              }
                              if (AudioHelper.isDev()) {
                                QLog.w("ChatItemBuilder", 1, "TencentDocGrayTips, msg[" + paramView.msg + "], getText[" + locala.mTextView.getText() + "], getLayoutParams[" + ((LinearLayout.LayoutParams)locala.mTextView.getLayoutParams()).gravity + "], gravity[" + ((LinearLayout.LayoutParams)paramLinearLayout).gravity + "]");
                              }
                              b(paramView);
                              a((ChatMessage)paramMessageRecord, locala, (View)localObject1);
                              return localObject1;
                              localNumberFormatException1 = localNumberFormatException1;
                              i = j;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + parama.mMsgActionData);
                              i = j;
                              break;
                              label2371:
                              i = aize.dhc;
                              break label1041;
                              label2379:
                              parama = (MessageForGrayTips.HightlightItem)paramView.tipParam.xg.get(paramView.tipParam.xg.size() - 1);
                              i = j;
                              if (parama == null) {
                                break label1041;
                              }
                              i = j;
                              if (parama.actionType != 38) {
                                break label1041;
                              }
                              try
                              {
                                i = Integer.parseInt(parama.mMsgActionData);
                              }
                              catch (NumberFormatException localNumberFormatException2)
                              {
                                i = j;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1041;
                            }
                            QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + parama.mMsgActionData);
                            i = j;
                            break label1041;
                            parama = null;
                            break label1471;
                            locala.a.setVisibility(8);
                            parama = locala.mTextView.getLayoutParams();
                            if ((parama instanceof ViewGroup.MarginLayoutParams))
                            {
                              parama = (ViewGroup.MarginLayoutParams)parama;
                              if (parama.rightMargin != BaseChatItemLayout.bOg) {
                                parama.rightMargin = BaseChatItemLayout.bOg;
                              }
                            }
                            locala.mTextView.setMaxWidth(2147483647);
                            locala.a.setOnClickListener(null);
                          }
                        }
                        catch (RuntimeException parama)
                        {
                          for (;;)
                          {
                            if (QLog.isColorLevel())
                            {
                              QLog.d("ChatItemBuilder", 2, "deal revoke tips fail", parama);
                              continue;
                              label2582:
                              if (localNumberFormatException2.equals("6"))
                              {
                                LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
                                continue;
                                label2615:
                                locala.mTextView.setText(paramView.msg);
                                if (AppSetting.enableTalkBack)
                                {
                                  locala.mTextView.setAccessibilityDelegate(null);
                                  continue;
                                  label2645:
                                  parama = paramwlz.getDrawable(2130851592);
                                  continue;
                                  label2657:
                                  locala.mTextView.setCompoundDrawables(null, null, null, null);
                                  locala.mTextView.setCompoundDrawablePadding(0);
                                  if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                    ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 17;
                                  }
                                  if ((localObject1 instanceof StickerGrayTipLayout)) {
                                    ((StickerGrayTipLayout)localObject1).setGravity(17);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    paramView = "";
                    parama = null;
                    continue;
                    label2725:
                    paramView = "";
                    parama = null;
                  }
                }
                label2733:
                i = n;
                int n = j;
                j = i;
                i = n;
                continue;
                label2752:
                n = j;
                j = i;
                i = n;
              }
              label2767:
              parama = null;
            }
          }
        }
      }
    }
  }
  
  protected wjd.a a()
  {
    return new ahvw.a();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if ((paramInt == 0) && ((paramChatMessage instanceof MessageForUniteGrayTip)))
    {
      MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)paramChatMessage;
      paramView = (ahvw.a)paramView.getTag();
      if (paramView != null)
      {
        paramView.mTextView.setText(paramChatMessage.msg);
        if (!TextUtils.isEmpty(localMessageForUniteGrayTip.contentDescription)) {
          paramView.mTextView.setContentDescription(localMessageForUniteGrayTip.contentDescription);
        }
      }
    }
  }
  
  public aqob[] a(View paramView)
  {
    return new aqoa().a();
  }
  
  protected void b(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramMessageForUniteGrayTip != null) && (paramMessageForUniteGrayTip.tipParam != null)) {
      switch (paramMessageForUniteGrayTip.tipParam.dbK)
      {
      }
    }
    do
    {
      return;
    } while (this.lh.containsKey(Long.valueOf(paramMessageForUniteGrayTip.msgseq)));
    this.lh.put(Long.valueOf(paramMessageForUniteGrayTip.msgseq), Boolean.valueOf(true));
    apuh.b(this.app, paramMessageForUniteGrayTip);
  }
  
  public class a
    extends wjd.a
  {
    public AutoBgImageView a;
    public TextView mTextView;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvw
 * JD-Core Version:    0.7.0.1
 */
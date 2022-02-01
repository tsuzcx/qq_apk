import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder.3;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.net.URL;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class xkl
  extends xah
  implements BaseChatItemLayout.a
{
  public static long animDuration = 1000L;
  public static int bTD = 100;
  public static boolean bhb;
  public static boolean bhc;
  public static float qh = 0.3F;
  public static float qi = 1.0F;
  
  public xkl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static Intent a(MessageForPic paramMessageForPic, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramSessionInfo = xah.a(paramMessageForPic, paramSessionInfo, paramQQAppInterface, paramContext);
    if (paramMessageForPic.picExtraData != null)
    {
      if (!paramMessageForPic.picExtraData.isCustomFace()) {
        break label77;
      }
      paramSessionInfo.putExtra("forward_is_custom_face", true);
      paramSessionInfo.putExtra("forward_cutsom_face_type", paramMessageForPic.picExtraData.customFaceType);
      paramSessionInfo.putExtra("forward_diy_package_id", paramMessageForPic.picExtraData.emojiPkgId);
      paramSessionInfo.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
    }
    label77:
    do
    {
      do
      {
        return paramSessionInfo;
        if (paramMessageForPic.picExtraData.isHotPics())
        {
          paramSessionInfo.putExtra("HOT_PIC_HAS_EXTRA", true);
          paramSessionInfo.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
          return paramSessionInfo;
        }
        if (paramMessageForPic.picExtraData.isStickerPics())
        {
          paramSessionInfo.putExtra("forward_is_sticker", true);
          paramSessionInfo.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
          paramSessionInfo.putExtra("key_emotion_source_from", paramMessageForPic.picExtraData.from);
          paramSessionInfo.putExtra("key_emotion_source_info", paramMessageForPic.picExtraData.source);
          paramSessionInfo.putExtra("key_emotion_source_weburl", paramMessageForPic.picExtraData.webUrl);
          paramSessionInfo.putExtra("key_emotion_source_iconurl", paramMessageForPic.picExtraData.iconUrl);
          paramSessionInfo.putExtra("key_emotion_source_packagename", paramMessageForPic.picExtraData.packageName);
          paramSessionInfo.putExtra("key_emotion_source_epid", paramMessageForPic.picExtraData.emojiPkgId);
          return paramSessionInfo;
        }
        if (paramMessageForPic.picExtraData.isZhitu())
        {
          paramSessionInfo.putExtra("forward_is_zhitu", true);
          paramSessionInfo.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
          return paramSessionInfo;
        }
        if (!paramMessageForPic.picExtraData.isSelfieFace()) {
          break;
        }
        paramSessionInfo.putExtra("forward_is_selfie_face", true);
        paramSessionInfo.putExtra("forward_summary_extra", paramMessageForPic.picExtraData.textSummary);
      } while (TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId));
      paramSessionInfo.putExtra("widgetinfo", paramMessageForPic.picExtraData.mTemplateId);
      return paramSessionInfo;
    } while (TextUtils.isEmpty(paramMessageForPic.picExtraData.mTemplateId));
    paramSessionInfo.putExtra("forward_send_template_pic", true);
    paramSessionInfo.putExtra("widgetinfo", paramMessageForPic.picExtraData.mTemplateId);
    paramSessionInfo.putExtra("key_camera_material_name", paramMessageForPic.picExtraData.mTemplateName);
    return paramSessionInfo;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    cdP();
    return a(paramContext, paramMessageForPic, paramChatThumbView, paramArrayOfInt, null);
  }
  
  public static URL a(MessageForPic paramMessageForPic)
  {
    return new xah.a(paramMessageForPic).url;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString3))) {}
    while (!"2854196312".equals(paramString1)) {
      return;
    }
    paramString1 = "";
    if (paramInt != -2) {}
    String str;
    switch (paramInt)
    {
    default: 
      paramString1 = "other";
      if (paramQQAppInterface.getCurrentUin() != null)
      {
        str = paramQQAppInterface.getCurrentUin();
        label84:
        if (paramString4 == null) {
          break label141;
        }
        label89:
        if (paramString2 == null) {
          break label148;
        }
      }
      break;
    }
    for (;;)
    {
      anot.a(paramQQAppInterface, "dc00898", "", "", paramString3, paramString3, 0, 0, str, paramString4, paramString1, paramString2);
      return;
      paramString1 = "c2c";
      break;
      paramString1 = "group";
      break;
      paramString1 = "discuss";
      break;
      str = "";
      break label84;
      label141:
      paramString4 = "";
      break label89;
      label148:
      paramString2 = "";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_one_item", paramBoolean1);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean2);
    localBundle.putBoolean(avfp.cKr, paramBoolean3);
    Object localObject;
    if (a(paramContext, paramSessionInfo))
    {
      localObject = ((FragmentActivity)paramContext).getChatFragment();
      if (localObject == null) {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  chatFragment is null.");
      }
    }
    else
    {
      if (paramMessageForReplyText == null) {
        break label223;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    }
    for (;;)
    {
      paramBoolean2 = aklr.ae(paramQQAppInterface.getCurrentAccountUin(), 1);
      localBundle.putBoolean("extra.OCR", paramBoolean2);
      if (paramBoolean2)
      {
        paramMessageForReplyText = aklr.mw(paramQQAppInterface.getCurrentAccountUin());
        if (!TextUtils.isEmpty(paramMessageForReplyText)) {
          localBundle.putString("extra.OCR_TEXT", paramMessageForReplyText);
        }
      }
      xah.a(paramQQAppInterface, paramContext, paramView, paramChatMessage, paramSessionInfo, paramBoolean1, localBundle);
      return;
      localObject = ((ChatFragment)localObject).a();
      if (localObject == null)
      {
        QLog.d("PicItemBuilder", 1, "enterImagePreview  BaseChatPie is null.");
        break;
      }
      int i = ((BaseChatPie)localObject).vm();
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", i);
      if (i != 1) {
        break;
      }
      localObject = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localObject == null) {
        break;
      }
      ((InputMethodManager)localObject).toggleSoftInput(1, 0);
      break;
      label223:
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    }
  }
  
  private void a(MessageForPic paramMessageForPic, Rect paramRect)
  {
    AIOEmotionFragment.a(this.mContext, paramMessageForPic, this.sessionInfo, paramRect);
  }
  
  private void a(MessageForPic paramMessageForPic, BaseChatItemLayout paramBaseChatItemLayout)
  {
    DuiButtonImageView localDuiButtonImageView;
    int i;
    if ((paramBaseChatItemLayout != null) && (!ajpd.aK(paramMessageForPic)) && (!paramMessageForPic.isMultiMsg))
    {
      localDuiButtonImageView = (DuiButtonImageView)paramBaseChatItemLayout.findViewById(2131366152);
      if (((paramMessageForPic.extraflag != 32768) || (!paramMessageForPic.isSendFromLocal())) && (!this.app.a().aS(paramMessageForPic))) {
        break label121;
      }
      i = 1;
      if ((!paramMessageForPic.isDui) || (i != 0) || (!DuiButtonImageView.bXG)) {
        break label395;
      }
      if (!paramMessageForPic.isSend()) {
        break label126;
      }
      if (localDuiButtonImageView != null)
      {
        localDuiButtonImageView.setVisibility(8);
        localDuiButtonImageView.stopAnim();
      }
    }
    for (;;)
    {
      a(this.app, paramBaseChatItemLayout, this.sessionInfo, paramMessageForPic, this);
      return;
      label121:
      i = 0;
      break;
      label126:
      if (localDuiButtonImageView == null)
      {
        localDuiButtonImageView = new DuiButtonImageView(this.mContext, this.app, paramMessageForPic);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(50.0F, this.mContext.getResources()), wja.dp2px(50.0F, this.mContext.getResources()));
        localLayoutParams.addRule(8, 2131364503);
        localLayoutParams.addRule(1, 2131364503);
        localLayoutParams.bottomMargin = (BaseChatItemLayout.bNW - wja.dp2px(6.5F, this.mContext.getResources()));
        localDuiButtonImageView.setId(2131366152);
        paramBaseChatItemLayout.addView(localDuiButtonImageView, localLayoutParams);
        if (QLog.isColorLevel()) {
          QLog.d("PicItemBuilder", 2, "message.hasPlayedDui = " + paramMessageForPic.hasPlayedDui);
        }
        if (QLog.isColorLevel()) {
          QLog.d("[Doutu]CustomFrameAnimationDrawable", 2, " message.isDui = " + paramMessageForPic.isDui + ", message.hasPlayedDui = " + paramMessageForPic.hasPlayedDui);
        }
        if (paramMessageForPic.hasPlayedDui) {
          break label371;
        }
        paramMessageForPic.hasPlayedDui = DuiButtonImageView.a(localDuiButtonImageView);
      }
      for (;;)
      {
        label241:
        if (!DuiButtonImageView.bXG) {
          break label379;
        }
        localDuiButtonImageView.setOnClickListener(this);
        localDuiButtonImageView.setVisibility(0);
        break;
        localDuiButtonImageView.q = paramMessageForPic;
        break label241;
        label371:
        localDuiButtonImageView.ms();
      }
      label379:
      localDuiButtonImageView.setOnClickListener(null);
      localDuiButtonImageView.setVisibility(8);
      continue;
      label395:
      if (localDuiButtonImageView != null)
      {
        localDuiButtonImageView.setVisibility(8);
        localDuiButtonImageView.stopAnim();
      }
    }
  }
  
  private static boolean a(Context paramContext, SessionInfo paramSessionInfo)
  {
    return (((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.beB);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, URL paramURL)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    boolean bool2 = anof.ayA();
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isbigThumb false");
      }
      return false;
    }
    paramContext = aoiz.getFilePath(paramURL.toString());
    if ((paramContext != null) && (paramContext.endsWith("_big400"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isgif=" + paramBoolean1 + "isthumb=" + paramBoolean2 + "w=" + paramInt1 + "h=" + paramInt2 + "==100*density=" + 100.0F * f + "isbugThumb=" + bool2 + "isthumb400=" + bool1);
      }
      if ((!paramBoolean1) || (!paramBoolean2) || (paramInt1 < 100.0F * f) || (paramInt2 < f * 100.0F) || (!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    boolean bool = false;
    if (paramMessageForPic.checkGif()) {}
    do
    {
      return true;
      if (paramMessageForPic.picExtraData != null)
      {
        paramMessageForPic = paramMessageForPic.picExtraData;
        if ((paramMessageForPic.isCustomFace()) || (paramMessageForPic.isDiyDouTu()) || (paramMessageForPic.isHotPics()) || (paramMessageForPic.isZhitu()) || (paramMessageForPic.isSelfieFace()) || (paramMessageForPic.isDoutu())) {
          bool = true;
        }
        return bool;
      }
    } while (ajpd.aK(paramMessageForPic));
    return false;
  }
  
  public static Bitmap am()
  {
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838306);
    if (localDrawable != null)
    {
      if ((localDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)localDrawable).getBitmap();
      }
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
    }
    return null;
  }
  
  public static URLDrawable b(Context paramContext, MessageForPic paramMessageForPic)
  {
    return a(paramContext, paramMessageForPic, null, null);
  }
  
  public static URLDrawable b(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView)
  {
    return a(paramContext, paramMessageForPic, paramChatThumbView, null);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramQQAppInterface, -2, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static void cdP()
  {
    Object localObject;
    if (!bhb)
    {
      localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.aio_gifplay.name());
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 3) {
          bgG = localObject[0].equals("1");
        }
      }
    }
    try
    {
      bTD = Integer.parseInt(localObject[2]);
      if (bTD < 0) {
        bTD = 100;
      }
      com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = bTD;
      bhb = true;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        bTD = 100;
      }
    }
  }
  
  private void fr(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.mContext).getChatFragment();
    if (localChatFragment != null)
    {
      localBaseChatPie = localChatFragment.a();
      if (localBaseChatPie != null)
      {
        localChatFragment = null;
        if ((wja.a(paramView) instanceof xah.b))
        {
          localMessageForPic = (MessageForPic)((xah.b)wja.a(paramView)).mMessage;
          paramView = localChatFragment;
          if (localMessageForPic != null) {
            paramView = new afdv(localMessageForPic.uuid, localMessageForPic.md5, localMessageForPic.groupFileID, localMessageForPic.rawMsgUrl, localMessageForPic.senderuin);
          }
          localBaseChatPie.getUIHandler().obtainMessage(79, paramView).sendToTarget();
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      BaseChatPie localBaseChatPie;
      MessageForPic localMessageForPic;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PicItemBuilder", 2, "[Doutu] curPie is null.");
      return;
    }
    QLog.d("PicItemBuilder", 2, "[Doutu] chatFragment is null.");
  }
  
  private void fs(View paramView)
  {
    MessageRecord localMessageRecord = (MessageRecord)paramView.getTag();
    if (localMessageRecord != null)
    {
      if ((!(localMessageRecord instanceof MessageForPic)) || (((MessageForPic)localMessageRecord).picExtraData == null) || (!((MessageForPic)localMessageRecord).picExtraData.isSelfieFace())) {
        break label169;
      }
      if (((afgw)this.app.getManager(334)).ajk()) {
        break label62;
      }
    }
    label62:
    while (!a(this.mContext, this.sessionInfo)) {
      return;
    }
    paramView = ((FragmentActivity)this.mContext).getChatFragment();
    if ((paramView != null) && (paramView.b != null)) {
      paramView.b.Af(11);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "mTemplateId clickViewId：" + ((MessageForPic)localMessageRecord).picExtraData.mTemplateId);
    }
    aywz.ab((FragmentActivity)this.mContext, ((MessageForPic)localMessageRecord).picExtraData.mTemplateId);
    return;
    label169:
    ((FlashChatManager)this.app.getManager(217)).a(paramView.getContext(), localMessageRecord);
  }
  
  private void k(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new PicItemBuilder.3(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      this.app.a().oy(this.app.a().y(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    akxy.a locala = new akxy.a();
    locala.So(1045);
    locala.NP(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      locala.setProtocolType(aooh.a.dQD);
    }
    for (;;)
    {
      locala.NT(paramMessageForPic.senderuin);
      locala.kc(paramMessageForPic.selfuin);
      locala.Sp(paramMessageForPic.istroop);
      locala.St(paramMessageForPic.getConfessTopicId());
      locala.setMd5(paramMessageForPic.md5);
      locala.extLong = paramMessageForPic.extLong;
      locala.extStr = paramMessageForPic.extStr;
      locala.isQzonePic = true;
      Object localObject = new akxy.b();
      ((akxy.b)localObject).msgseq = paramMessageForPic.msgseq;
      ((akxy.b)localObject).shmsgseq = paramMessageForPic.shmsgseq;
      ((akxy.b)localObject).msgUid = paramMessageForPic.msgUid;
      locala.a((akxy.b)localObject);
      localObject = paramMessageForPic.getExtInfoFromExtStr(anbb.cdc);
      String str2 = paramMessageForPic.getExtInfoFromExtStr(anbb.cdb);
      long l = 0L;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          l = Long.parseLong((String)localObject);
        }
        if (!TextUtils.isEmpty(paramMessageForPic.thumbMsgUrl))
        {
          localObject = paramMessageForPic.thumbMsgUrl;
          locala.b = new PhotoSendParams((String)localObject, paramMessageForPic.md5, "", l, (int)paramMessageForPic.height, (int)paramMessageForPic.width, str2, 1);
          localObject = akxj.a(4, 1045);
          ((akxq)localObject).c(locala.a());
          ((akxq)localObject).b = paramMessageForPic.picExtraData;
          akxj.a((akxq)localObject, this.app);
          return;
          locala.setProtocolType(aooh.a.dQC);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PicItemBuilder", 2, "reuploadQzonePhoto exception:", localException);
          }
          l = 0L;
          continue;
          String str1 = paramMessageForPic.bigThumbMsgUrl;
        }
      }
    }
  }
  
  private void xV(String paramString)
  {
    ((ajdg)this.app.getManager(14)).b(paramString, new xkn(this, paramString));
  }
  
  protected void E(ChatMessage paramChatMessage)
  {
    super.E(paramChatMessage);
    anot.a(this.app, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "3", "", "", "");
  }
  
  protected void H(ChatMessage paramChatMessage)
  {
    if (jof.a(paramChatMessage))
    {
      localObject = jof.a(paramChatMessage);
      if ((((jof.a)localObject).TF == null) && (((jof.a)localObject).flags != 2)) {
        if (QLog.isColorLevel()) {
          QLog.i("PicItemBuilder", 2, "Anonymous report : an_id is null");
        }
      }
      byte[] arrayOfByte;
      do
      {
        return;
        arrayOfByte = ((jof.a)localObject).B();
      } while ((arrayOfByte == null) || (((jof.a)localObject).flags == 2));
      localObject = URLEncoder.encode(Base64.encodeToString(arrayOfByte, 2));
      jof.a().a(paramChatMessage.frienduin, (String)localObject, paramChatMessage);
      stj.b(this.app, paramChatMessage.frienduin, (String)localObject, this.app.getCurrentAccountUin(), jof.a().I(paramChatMessage.frienduin, (String)localObject));
      return;
    }
    Object localObject = paramChatMessage.senderuin;
    stj.a((BaseActivity)this.mContext, (String)localObject, paramChatMessage.frienduin, this.app.getCurrentAccountUin(), stj.es(this.sessionInfo.cZ), null);
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramView = super.a(paramChatMessage, parame, paramView, paramBaseChatItemLayout, paramwlz);
    if (parame == null) {
      return paramView;
    }
    parame = (xah.b)parame;
    paramwlz = (MessageForPic)paramChatMessage;
    d(paramwlz, parame);
    a(paramwlz, paramBaseChatItemLayout);
    if (((aptw)this.app.getManager(203)).f(this.app, paramChatMessage)) {
      parame.a.setRobotNextTipsView(true, this.mContext, this.app, paramChatMessage);
    }
    for (;;)
    {
      if (!a((MessageForPic)paramChatMessage)) {
        parame.a.setMiniAioShieldItemTouchListener(this);
      }
      return paramView;
      parame.a.setRobotNextTipsView(false, this.mContext, this.app, paramChatMessage);
    }
  }
  
  public aqoa a(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    if (aegu.ag(localMessageForPic)) {}
    for (;;)
    {
      return paramaqoa;
      if (!ApolloUtil.V(localMessageForPic))
      {
        if (!TextUtils.isEmpty(localMessageForPic.getExtInfoFromExtStr("sticker_info"))) {}
        for (int i = 1; i == 0; i = 0) {
          return super.a(paramaqoa, paramChatMessage, parama);
        }
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131377159)
    {
      H(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(xah.b paramb, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL)
  {
    Object localObject = paramb.u;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getURL().getProtocol();
      if (a(this.mContext, paramBoolean, ((String)localObject).equals("chatthumb"), paramArrayOfInt[0], paramArrayOfInt[1], paramURL))
      {
        paramb.u.setWatermarkDrawable(am(), wja.dp2px(6.0F, this.mContext.getResources()), wja.dp2px(6.0F, this.mContext.getResources()));
        paramb.u.setWatermarkVisibility(0);
        return;
      }
      paramb.u.setWatermarkVisibility(4);
      return;
    }
    paramb.u.setWatermarkVisibility(4);
  }
  
  boolean a(aqoa paramaqoa, MessageForPic paramMessageForPic)
  {
    if (!ykm.d(paramMessageForPic)) {
      return false;
    }
    a(paramaqoa, this.sessionInfo.cZ, paramMessageForPic);
    a(paramaqoa, paramMessageForPic);
    if (!paramMessageForPic.isSend()) {
      paramaqoa.Z(2131377159, this.mContext.getString(2131721959), 2130848731);
    }
    return true;
  }
  
  public boolean a(BaseBubbleBuilder.e parame)
  {
    return parame instanceof xah.b;
  }
  
  public aqoa b(aqoa paramaqoa, ChatMessage paramChatMessage, wko.a parama)
  {
    MessageForPic localMessageForPic = (MessageForPic)paramChatMessage;
    parama = (xah.b)parama;
    if (aegu.ag(localMessageForPic)) {}
    do
    {
      do
      {
        return paramaqoa;
      } while (ApolloUtil.V(localMessageForPic));
      if (!TextUtils.isEmpty(localMessageForPic.getExtInfoFromExtStr("sticker_info"))) {}
      for (int i = 1; i != 0; i = 0)
      {
        a(paramaqoa, localMessageForPic);
        return paramaqoa;
      }
    } while (a(paramaqoa, localMessageForPic));
    if ((aoop.a(this.mContext, localMessageForPic, 65537)) && (augo.g(this.app, localMessageForPic))) {
      paramaqoa.Z(2131377998, this.mContext.getString(2131719492), 2130840517);
    }
    return super.b(paramaqoa, paramChatMessage, parama);
  }
  
  void b(MessageForPic paramMessageForPic, xah.b paramb)
  {
    d(paramMessageForPic, paramb);
  }
  
  protected void c(MessageForPic paramMessageForPic)
  {
    super.c(paramMessageForPic);
    if (paramMessageForPic.isMultiMsg)
    {
      int i = 4;
      if (paramMessageForPic.checkGif()) {
        i = 3;
      }
      anot.a(this.app, "dc00898", "", "", "0X8009D67", "0X8009D67", i, 0, "" + i, "", "", "");
    }
  }
  
  protected void c(MessageForPic paramMessageForPic, xah.b paramb)
  {
    Object localObject;
    if (!paramMessageForPic.isSendFromLocal())
    {
      c(this.app, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F37", "");
      localObject = (acms)this.app.getBusinessHandler(20);
      if ((!TextUtils.isEmpty(this.sessionInfo.aTl)) && (this.sessionInfo.cZ == 1)) {
        ((acms)localObject).bM(this.sessionInfo.aTl, true);
      }
      if ((paramMessageForPic.picExtraData == null) || (!paramMessageForPic.picExtraData.isDiyDouTu())) {
        break label200;
      }
      if (paramb.Sw()) {
        xV(String.valueOf(paramMessageForPic.picExtraData.emojiPkgId));
      }
    }
    label200:
    do
    {
      return;
      paramb = paramb.a;
      paramb.setProgressVisable(false);
      localObject = akxj.a(6, 1536, 1);
      ((akxq)localObject).a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
      ((akxq)localObject).b(new xkm(this, paramb));
      akxj.a((akxq)localObject, this.app);
      return;
      if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()))
      {
        xV(String.valueOf(paramMessageForPic.picExtraData.emojiPkgId));
        return;
      }
      if (!ykm.e(paramMessageForPic)) {
        break;
      }
    } while (ykm.d(paramMessageForPic));
    a(paramMessageForPic, sxx.getViewRect(paramb.c));
    return;
    if (a(paramMessageForPic))
    {
      a(paramMessageForPic, sxx.getViewRect(paramb.c));
      return;
    }
    a(this.app, this.mContext, paramb.c, paramMessageForPic, this.sessionInfo, false, true, true, null);
  }
  
  protected void d(MessageForPic paramMessageForPic)
  {
    super.d(paramMessageForPic);
    c(this.app, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F3A", "");
  }
  
  void d(MessageForPic paramMessageForPic, xah.b paramb)
  {
    if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isDiyDouTu()))
    {
      paramb.sS.setVisibility(8);
      if (!paramb.Sw())
      {
        paramb.sS.setImageResource(2130838098);
        paramb.sS.setVisibility(0);
      }
    }
  }
  
  protected void e(MessageForPic paramMessageForPic)
  {
    super.e(paramMessageForPic);
    anot.a(this.app, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
    c(this.app, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F38", "");
    if (paramMessageForPic.isMultiMsg)
    {
      int i = 1;
      if (paramMessageForPic.checkGif()) {
        i = 2;
      }
      anot.a(this.app, "dc00898", "", "", "0X8009D68", "0X8009D68", i, 0, "" + i, "", "", "");
    }
    afnu.c(this.app, 1, paramMessageForPic.md5, null);
  }
  
  protected void f(MessageForPic paramMessageForPic)
  {
    Intent localIntent = a(paramMessageForPic, this.sessionInfo, this.app, this.mContext);
    if ((((this.mContext instanceof SplashActivity)) || ((this.mContext instanceof ChatActivity))) && (((FragmentActivity)this.mContext).getChatFragment() != null)) {
      localIntent.putExtra("isBack2Root", ((FragmentActivity)this.mContext).getChatFragment().a().aL);
    }
    if ((this.mContext instanceof SplashActivity))
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = wja.a(localIntent, null);
    }
    for (;;)
    {
      localIntent.putExtra("key_allow_forward_photo_preview_edit", true);
      localIntent.putExtra("selection_mode", this.bOY);
      ahgq.f((Activity)this.mContext, localIntent, 21);
      anot.a(this.app, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "3", "", "", "");
      if (paramMessageForPic.isMultiMsg)
      {
        int i = 4;
        if (paramMessageForPic.checkGif()) {
          i = 3;
        }
        anot.a(this.app, "dc00898", "", "", "0X8009D66", "0X8009D66", i, 0, "" + i, "", "", "");
      }
      c(this.app, paramMessageForPic.senderuin, paramMessageForPic.md5, "0X8009F39", "");
      return;
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    }
  }
  
  void g(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.isQzonePic) {
      k(paramMessageForPic);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      super.g(paramMessageForPic);
    }
  }
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    if (super.Rk())
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = paramView.getId();
    if (i == 2131366152) {
      fr(paramView);
    }
    for (;;)
    {
      super.onClick(paramView);
      break;
      if (i == 2131364531) {
        fs(paramView);
      }
    }
  }
  
  public void p(ChatMessage paramChatMessage)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "2", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkl
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.12;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.4;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.5;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.9;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.selectable.SelectableLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class xmb
  extends xov
{
  protected static Drawable mDefaultDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
  protected xmb.d a;
  protected wlz c = new xmc(this);
  private View.OnClickListener dT = new xmg(this);
  
  public xmb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Xmb$d = new xmb.d(null);
    this.onClickListener = new alvl(this);
  }
  
  protected static boolean K(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForLongMsg)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForShortVideo)) || ((paramMessageRecord instanceof MessageForStructing)) || ((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForVideo));
  }
  
  public static boolean L(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (paramMessageRecord.structingMsg == null) {}
    }
    switch (paramMessageRecord.structingMsg.mMsgServiceID)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong)
  {
    if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000)) {
      return Long.parseLong(paramSessionInfo.aTl);
    }
    if (paramLong == paramQQAppInterface.getLongAccountUin()) {
      return Long.parseLong(paramSessionInfo.aTl);
    }
    return paramQQAppInterface.getLongAccountUin();
  }
  
  private View a(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext, xmb.c paramc, MessageForReplyText paramMessageForReplyText, wlz paramwlz, boolean paramBoolean)
  {
    paramc.mType = 0;
    Object localObject2 = this.jdField_a_of_type_Xmb$d.A(0);
    Object localObject1 = localObject2;
    int j;
    int i;
    if (localObject2 == null)
    {
      localObject1 = new SelectableLinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject3 = a(paramContext);
      paramc.jdField_do = ((ViewGroup)localObject3);
      paramc.JL = ((TextView)((ViewGroup)localObject3).findViewById(2131379679));
      paramc.Jm = ((TextView)((ViewGroup)localObject3).findViewById(2131372190));
      paramc.JK = ((TextView)((ViewGroup)localObject3).findViewById(2131367548));
      paramc.d = ((ETTextView)((ViewGroup)localObject3).findViewById(2131371989));
      paramc.e = ((ETTextView)((ViewGroup)localObject3).findViewById(2131372006));
      ((ViewGroup)localObject3).setId(2131364531);
      aofy.P(paramc.d);
      aofy.P(paramc.e);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
      paramc.tv = ((ImageView)((ViewGroup)localObject3).findViewById(2131369803));
      paramc.tv.setVisibility(4);
      paramc.tv.setContentDescription(acfp.m(2131713899));
      localObject3 = new ETTextView(paramContext);
      aofy.P((TextView)localObject3);
      ((ETTextView)localObject3).setTextColor(paramContext.getResources().getColorStateList(2131167322));
      ((ETTextView)localObject3).setLinkTextColor(paramContext.getResources().getColorStateList(2131167316));
      ((ETTextView)localObject3).setEditableFactory(aofr.a);
      ((ETTextView)localObject3).setSpannableFactory(aofk.a);
      ((ETTextView)localObject3).setMovementMethod(LinkMovementMethod.getInstance());
      j = BaseChatItemLayout.bOc;
      i = BaseChatItemLayout.bOd;
      if (paramMessageForReplyText.isSend())
      {
        j = BaseChatItemLayout.bOd;
        i = BaseChatItemLayout.bOc;
      }
      ((ETTextView)localObject3).setPadding(j, 0, i, BaseChatItemLayout.bOb);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = j;
      ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.bNV;
      ((LinearLayout)localObject1).addView(paramc.jdField_do, (ViewGroup.LayoutParams)localObject2);
      ((ETTextView)localObject3).setId(2131364506);
      paramc.mText = ((TextView)localObject3);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject2).topMargin = wja.dp2px(8.0F, paramContext.getResources());
      ((LinearLayout)localObject1).addView(paramc.mText, (ViewGroup.LayoutParams)localObject2);
    }
    paramc.Jm = ((TextView)((View)localObject1).findViewById(2131372190));
    paramc.JL = ((TextView)((View)localObject1).findViewById(2131379679));
    paramc.JK = ((TextView)((View)localObject1).findViewById(2131367548));
    paramc.d = ((ETTextView)((View)localObject1).findViewById(2131371989));
    paramc.e = ((ETTextView)((View)localObject1).findViewById(2131372006));
    paramc.mText = ((ETTextView)((View)localObject1).findViewById(2131364506));
    paramc.jdField_do = ((ViewGroup)((View)localObject1).findViewById(2131364531));
    paramc.tv = ((ImageView)((View)localObject1).findViewById(2131369803));
    paramc.tv.setContentDescription(acfp.m(2131713896));
    paramc.tv.setVisibility(4);
    paramc.tv.setImageDrawable(this.mContext.getResources().getDrawable(2130838357));
    if (paramMessageForReplyText.getSourceMsgInfo() != null) {}
    for (paramContext = Long.toString(paramMessageForReplyText.getSourceMsgInfo().mSourceMsgSenderUin);; paramContext = "")
    {
      paramContext = lf.a(paramContext);
      paramc.JL.setTypeface(paramContext);
      paramc.Jm.setTypeface(paramContext);
      paramc.JK.setTypeface(paramContext);
      paramc.d.setTypeface(paramContext);
      paramc.e.setTypeface(paramContext);
      if (!TextUtils.isEmpty(paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramContext = ((ETTextView)paramc.mText).getETLayout();
        if (paramContext != null) {
          paramContext.mMsgId = (paramMessageForReplyText.uniseq + 1L);
        }
      }
      ((ETTextView)paramc.mText).setFont(0, paramMessageForReplyText.uniseq);
      i = ((ETTextView)paramc.mText).mMaxWidth;
      j = BaseChatItemLayout.bNS;
      paramc.mText.setMaxWidth(j);
      paramc.mText.setTextSize(0, this.sessionInfo.cN);
      if (i != j) {
        ((ETTextView)paramc.mText).mMsgId = 0L;
      }
      paramc.mText.setText(paramMessageForReplyText.sb);
      if (AppSetting.enableTalkBack) {
        paramc.mText.setContentDescription(aofy.og(paramMessageForReplyText.sb.toString()));
      }
      super.a(paramc.mText, paramMessageForReplyText);
      a(this.mContext, this.app, paramc.jdField_do, paramMessageForReplyText.mSourceMsgInfo, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText, paramBoolean, this.sessionInfo);
      paramc.j = ((BubbleImageView)((View)localObject1).findViewById(2131379641));
      paramc.jdField_do.setOnClickListener(this.onClickListener);
      paramc.d.setOnClickListener(this.onClickListener);
      paramc.j.setOnClickListener(this.onClickListener);
      ((View)localObject1).setOnTouchListener(paramwlz);
      ((View)localObject1).setOnLongClickListener(paramwlz);
      paramc.jdField_do.setOnTouchListener(paramwlz);
      paramc.jdField_do.setOnLongClickListener(paramwlz);
      paramc.d.setOnTouchListener(this.c);
      paramc.d.setOnLongClickListener(this.c);
      paramc.j.setOnTouchListener(this.c);
      paramc.j.setOnLongClickListener(this.c);
      paramc.mText.setOnTouchListener(paramwlz);
      paramc.mText.setOnLongClickListener(paramwlz);
      paramc.tv.setOnClickListener(this.onClickListener);
      if ((paramc.mText instanceof AnimationTextView)) {
        ((AnimationTextView)paramc.mText).onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$a;
      }
      if ((paramc.d instanceof AnimationTextView)) {
        paramc.d.onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$a;
      }
      if (paramc.a == null) {
        paramc.a = new aavr();
      }
      if ((localObject1 instanceof aawc))
      {
        paramc.a.a((aawc)localObject1);
        paramc.a.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
      paramc.a.P(paramMessageForReplyText);
      return localObject1;
    }
  }
  
  public static final RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131560856, null);
    Object localObject = (TextView)localRelativeLayout.findViewById(2131372190);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167322));
    ImmersiveUtils.setAlpha((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(aofr.a);
    ((TextView)localObject).setSpannableFactory(aofk.a);
    localObject = (TextView)localRelativeLayout.findViewById(2131379679);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167322));
    ImmersiveUtils.setAlpha((View)localObject, 0.9F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(aofr.a);
    ((TextView)localObject).setSpannableFactory(aofk.a);
    localObject = (TextView)localRelativeLayout.findViewById(2131367548);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167322));
    ImmersiveUtils.setAlpha((View)localObject, 0.5F);
    ((TextView)localObject).setTextSize(1, 13.0F);
    ((TextView)localObject).setEditableFactory(aofr.a);
    ((TextView)localObject).setSpannableFactory(aofk.a);
    ((ImageView)localRelativeLayout.findViewById(2131369803)).setColorFilter(null);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131371989);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167322));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131167316));
    ImmersiveUtils.setAlpha((View)localObject, 0.9F);
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(aofr.a);
    ((ETTextView)localObject).setSpannableFactory(aofk.a);
    ((ETTextView)localObject).setLineSpacing(wja.dp2px(2.0F, paramContext.getResources()), 1.0F);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131372006);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167322));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131167316));
    ((ETTextView)localObject).setTextSize(1, 13.0F);
    ((ETTextView)localObject).setEditableFactory(aofr.a);
    ((ETTextView)localObject).setSpannableFactory(aofk.a);
    ((ETTextView)localObject).setLineSpacing(wja.dp2px(2.0F, paramContext.getResources()), 1.0F);
    return localRelativeLayout;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, xmb.a parama)
  {
    boolean bool1 = avfp.ns(paramMessageForPic.imageType);
    boolean bool2 = parama.isDynamic;
    URL localURL = parama.url;
    Rect localRect = parama.bl;
    Object localObject = localURL;
    if (localURL == null) {
      parama = aoop.a(paramMessageForPic, 65537, null);
    }
    try
    {
      localObject = new URL(parama.toString());
      parama = (xmb.a)localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
        }
        localMalformedURLException.printStackTrace();
      }
      parama = aoiz.getFile(parama);
      if (parama == null) {
        break label671;
      }
      if (localRect == null) {
        break label541;
      }
      j = localRect.width();
      i = localRect.height();
      paramContext = a(j, i, 6.0F * f1, bool1);
      j = paramContext.width;
      i = paramContext.height;
      float f2 = paramContext.qp;
      j = (j * m + 80) / 160;
      i = (i * m + 80) / 160;
      f1 = f2;
      if (localRect == null) {
        break label433;
      }
      if (localRect.width() >= j) {
        break label639;
      }
      f1 = f2 * (localRect.width() / j);
      for (;;)
      {
        for (;;)
        {
          if (paramArrayOfInt != null)
          {
            paramArrayOfInt[0] = j;
            paramArrayOfInt[1] = i;
          }
          paramContext = aoop.getDrawable(localMalformedURLException, j, i, new afei(j, i), aoop.getFailedDrawable(), true, f1);
          paramContext.setIgnorePause(true);
          paramContext.setFadeInImage(true);
          if (paramChatThumbView != null) {
            paramChatThumbView.flag = true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + j + "," + i);
          }
          break;
          paramContext = new BitmapFactory.Options();
          paramContext.inJustDecodeBounds = true;
          try
          {
            aqhu.d(parama.getAbsolutePath(), paramContext);
            j = paramContext.outWidth;
            i = paramContext.outHeight;
            k = aoop.eI(parama.getAbsolutePath());
            if ((k != 90) && (k != 270)) {
              break label337;
            }
            j = paramContext.outHeight;
            i = paramContext.outWidth;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ReplyTextItemBuilder", 2, "getThumbDrawable", localThrowable);
              }
            }
          }
        }
        f1 = f2;
        if (localRect.height() < i) {
          f1 = f2 * (localRect.height() / i);
        }
      }
      if (aoop.bD(paramContext)) {
        break label927;
      }
    }
    localObject = parama;
    if (QLog.isColorLevel())
    {
      QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + parama);
      localObject = parama;
    }
    parama = ((URL)localObject).toString();
    int m = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (paramChatThumbView != null) {
      paramChatThumbView.flag = false;
    }
    float f1 = m / 160.0F;
    if (BaseApplicationImpl.sImageCache.get(parama) != null)
    {
      paramContext = aoop.getDrawable((URL)localObject, 0, 0, null, null, true, f1 * 6.0F);
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
        paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
        if (QLog.isColorLevel()) {
          QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + paramArrayOfInt[0] + "," + paramArrayOfInt[1]);
        }
      }
      paramContext.setTag(paramMessageForPic);
      if ((paramContext.getCurrDrawable() instanceof GifDrawable)) {
        ((GifDrawable)paramContext.getCurrDrawable()).mutate();
      }
      return paramContext;
    }
    label337:
    label639:
    int i = 1;
    label433:
    int j = paramMessageForPic.thumbWidth;
    label541:
    label671:
    label681:
    int k = paramMessageForPic.thumbHeight;
    if ((j > 0) && (k > 0))
    {
      paramChatThumbView = a(j, k, 0.0F, bool1);
      k = paramChatThumbView.width;
      j = paramChatThumbView.height;
      label726:
      f1 = m / 160.0F;
      k = (int)(k * f1 + 0.5F);
      j = (int)(j * f1 + 0.5F);
      paramChatThumbView = URLDrawable.URLDrawableOptions.obtain();
      paramChatThumbView.mRequestWidth = k;
      paramChatThumbView.mRequestHeight = j;
      paramChatThumbView.mLoadingDrawable = aoop.am();
      paramChatThumbView.mFailedDrawable = aoop.getFailedDrawable();
      paramChatThumbView.mPlayGifImage = bool2;
      paramChatThumbView.mGifRoundCorner = 6.0F;
      paramChatThumbView.mImgType = paramMessageForPic.imageType;
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = k;
        paramArrayOfInt[1] = j;
      }
      paramChatThumbView.mLoadingDrawable = paramContext.getResources().getDrawable(2130844660);
      paramContext = URLDrawable.getDrawable(localMalformedURLException, paramChatThumbView);
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableautoDownload:" + k + "," + j);
      }
      if ((!akxk.cuU) && (i == 0)) {
        break label989;
      }
      paramContext.setAutoDownload(true);
    }
    for (;;)
    {
      paramContext.setProgressDrawable(new argt(aj(), 0, false));
      break;
      label927:
      i = 0;
      break label681;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + j + ", height = " + k);
      }
      k = 99;
      j = 99;
      break label726;
      label989:
      paramContext.setAutoDownload(false);
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = paramMessageRecord;
    if (ahav.ax(paramMessageRecord)) {
      paramQQAppInterface = ahav.e((ChatMessage)paramMessageRecord);
    }
    return paramQQAppInterface;
  }
  
  private static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, StringBuilder paramStringBuilder)
  {
    int k = 0;
    if ((paramMessageRecord1 == null) || (paramMessageRecord2 == null))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    Object localObject;
    MessageRecord localMessageRecord;
    if ((paramMessageRecord2 instanceof MessageForMixedMsg))
    {
      localObject = (MessageForMixedMsg)paramMessageRecord2;
      if (((MessageForMixedMsg)localObject).msgElemList == null) {
        break label412;
      }
      localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(0);
      if ((localMessageRecord instanceof MessageForPic))
      {
        i = 1;
        while (i < ((MessageForMixedMsg)localObject).msgElemList.size())
        {
          localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(i);
          if (((localMessageRecord instanceof MessageForText)) && (!TextUtils.isEmpty(localMessageRecord.msg)))
          {
            paramStringBuilder.append(localMessageRecord.msg);
            i += 1;
          }
          else
          {
            return null;
          }
        }
      }
    }
    label152:
    label412:
    for (int i = 1;; i = 0)
    {
      int m = 1;
      localObject = paramMessageRecord2;
      int j = i;
      i = m;
      for (;;)
      {
        if (i < 10)
        {
          localMessageRecord = paramQQAppInterface.b().c(paramMessageRecord1.frienduin, paramMessageRecord1.istroop, paramMessageRecord2.shmsgseq + i);
          if ((localMessageRecord != null) && (localMessageRecord.isLongMsg()) && ((localMessageRecord instanceof MessageForText))) {
            if (!TextUtils.isEmpty(localMessageRecord.msg)) {
              paramStringBuilder.append(localMessageRecord.msg);
            }
          }
          for (;;)
          {
            if (localMessageRecord != null)
            {
              if (localMessageRecord.isLongMsg()) {
                break label403;
              }
              return localObject;
              if (!(localMessageRecord instanceof MessageForText)) {
                break label412;
              }
              return null;
              if (((paramMessageRecord2 instanceof MessageForText)) && (!TextUtils.isEmpty(paramMessageRecord2.msg))) {
                paramStringBuilder.append(paramMessageRecord2.msg);
              }
              i = 1;
              localObject = null;
              j = 0;
              break label152;
              if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForMixedMsg)) && (localMessageRecord.isLongMsg()))
              {
                paramQQAppInterface = (MessageForMixedMsg)localMessageRecord;
                if (paramQQAppInterface.msgElemList != null)
                {
                  i = k;
                  while (i < paramQQAppInterface.msgElemList.size())
                  {
                    paramMessageRecord1 = (MessageRecord)paramQQAppInterface.msgElemList.get(i);
                    if ((!(paramMessageRecord1 instanceof MessageForText)) || (TextUtils.isEmpty(paramMessageRecord1.msg))) {
                      break;
                    }
                    paramStringBuilder.append(paramMessageRecord1.msg);
                    i += 1;
                  }
                }
                paramQQAppInterface = localMessageRecord;
                if (j == 0) {
                  break;
                }
              }
            }
          }
        }
        return localObject;
        i += 1;
      }
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.b().f(paramString, paramInt);
    int i = paramQQAppInterface.size();
    paramInt = 0;
    while (paramInt < i)
    {
      paramString = (ChatMessage)paramQQAppInterface.get(paramInt);
      if (paramString.shmsgseq == paramLong)
      {
        if (!paramString.mIsParsed) {
          paramString.parse();
        }
        return paramString;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    List localList = paramQQAppInterface.b().f(paramString, paramInt);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ChatMessage localChatMessage = (ChatMessage)localList.get(i);
      if ((localChatMessage.time == paramLong1) && (localChatMessage.msgUid == paramLong2)) {
        if (!localChatMessage.mIsParsed) {
          localChatMessage.parse();
        }
      }
      do
      {
        return localChatMessage;
        if (!(localChatMessage instanceof MessageForFile)) {
          break;
        }
        MessageForFile localMessageForFile = (MessageForFile)localChatMessage;
        if ((localMessageForFile.originalTime != paramLong1) || (localMessageForFile.originalMsgUid != paramLong2)) {
          break;
        }
      } while (localChatMessage.mIsParsed);
      localChatMessage.parse();
      return localChatMessage;
      i += 1;
    }
    return a(paramQQAppInterface, paramString, paramInt, paramLong3);
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForReplyText)) && (((MessageForReplyText)paramMessageRecord).getSourceMessage() != null))
    {
      paramString = ((MessageForReplyText)paramMessageRecord).getSourceMessage();
      return paramString;
    }
    if (paramMessageRecord.isMultiMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "REPLY getMessage  replyTextMsg=" + paramMessageRecord);
      }
      return null;
    }
    if (paramInt == 0) {}
    for (paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgTime, paramSourceMsgInfo.origUid, paramSourceMsgInfo.mSourceMsgSeq);; paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgSeq))
    {
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        break;
      }
      paramString = paramQQAppInterface;
      if (!(paramMessageRecord instanceof MessageForReplyText)) {
        break;
      }
      ((MessageForReplyText)paramMessageRecord).setSourceMessageRecord(paramQQAppInterface);
      return paramQQAppInterface;
    }
  }
  
  private static xmb.a a(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    int j = aoop.I(paramBoolean);
    int i = aoop.J(paramBoolean);
    xmb.a locala = new xmb.a();
    float f1;
    if ((paramInt1 < i) || (paramInt2 < i)) {
      if (paramInt1 < paramInt2)
      {
        f1 = i / paramInt1;
        paramInt1 = (int)(paramInt2 * f1 + 0.5F);
        if (paramInt1 > j)
        {
          paramInt1 = j;
          paramInt2 = paramInt1;
          paramInt1 = i;
          paramFloat *= f1;
        }
      }
    }
    for (;;)
    {
      locala.width = paramInt1;
      locala.height = paramInt2;
      locala.scale = f1;
      locala.qp = paramFloat;
      return locala;
      break;
      f1 = i / paramInt2;
      paramInt1 = (int)(paramInt1 * f1 + 0.5F);
      if (paramInt1 > j) {
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 = i;
        break;
      }
      if ((paramInt1 >= j) || (paramInt2 >= j)) {
        break label162;
      }
      f1 = 0.0F;
    }
    label162:
    if (paramInt1 > paramInt2)
    {
      f1 = j / paramInt1;
      label175:
      if (paramInt1 <= paramInt2) {
        break label233;
      }
    }
    label233:
    for (float f2 = i / paramInt2;; f2 = i / paramInt1)
    {
      f1 = Math.max(f1, f2);
      paramInt1 = (int)(paramInt1 * f1 + 0.5F);
      paramInt2 = (int)(paramInt2 * f1 + 0.5F);
      break;
      f1 = j / paramInt2;
      break label175;
    }
  }
  
  private static xmb.a a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    xmb.a locala = new xmb.a();
    Object localObject3 = null;
    boolean bool = avfp.ns(paramMessageForPic.imageType);
    URL localURL2;
    Object localObject1;
    if ((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000))
    {
      xkl.cdP();
      if (xkl.bgG)
      {
        localURL2 = aoop.a(paramMessageForPic, 1, null);
        localObject1 = aoiz.getFile(localURL2.toString());
        if (localObject1 != null)
        {
          try
          {
            localObject4 = NativeGifImage.getImageSize((File)localObject1, false);
            localObject3 = localObject4;
            localObject1 = localURL2;
          }
          catch (Throwable localThrowable1)
          {
            for (;;)
            {
              Object localObject4;
              label142:
              localObject2 = null;
            }
          }
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using GIF_BIG,uniseq:" + paramMessageForPic.uniseq + " url:" + localURL2);
              localObject1 = localURL2;
              localObject3 = localObject4;
            }
          }
          catch (Throwable localThrowable2)
          {
            localObject3 = localMalformedURLException;
            localURL1 = localURL2;
            break label142;
          }
          locala.isDynamic = true;
          locala.bl = localObject3;
          locala.url = ((URL)localObject1);
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject1;
      if (localObject1 == null) {
        localObject1 = aoop.a(paramMessageForPic, 65537, null);
      }
      try
      {
        localObject4 = new URL(((URL)localObject1).toString());
        localObject1 = localObject4;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        int k;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
          }
          localMalformedURLException.printStackTrace();
        }
        paramContext = aoiz.getFile((String)localObject1);
        if (paramContext == null) {
          break label667;
        }
        if (localObject3 == null) {
          break label548;
        }
        int j = localObject3.width();
        int i = localObject3.height();
        paramContext = a(j, i, f * 6.0F, bool);
        j = paramContext.width;
        i = paramContext.height;
        float f = paramContext.qp;
        j = (j * k + 80) / 160;
        i = (i * k + 80) / 160;
        if (localObject3 == null) {
          break label531;
        }
        if (localObject3.width() >= j) {
          break label642;
        }
        f = localObject3.width() / j;
        while (paramArrayOfInt != null)
        {
          for (;;)
          {
            paramArrayOfInt[0] = j;
            paramArrayOfInt[1] = i;
            return locala;
            paramMessageForPic = new BitmapFactory.Options();
            paramMessageForPic.inJustDecodeBounds = true;
            try
            {
              aqhu.d(paramContext.getAbsolutePath(), paramMessageForPic);
              j = paramMessageForPic.outWidth;
              i = paramMessageForPic.outHeight;
              int m = aoop.eI(paramContext.getAbsolutePath());
              if ((m != 90) && (m != 270)) {
                break;
              }
              j = paramMessageForPic.outHeight;
              i = paramMessageForPic.outWidth;
            }
            catch (Throwable paramChatThumbView)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("ReplyTextItemBuilder", 2, "getThumbDrawable", paramChatThumbView);
                }
              }
            }
          }
          if (localObject3.height() < i) {
            f = localObject3.height() / i;
          }
        }
        i = paramMessageForPic.thumbWidth;
        j = paramMessageForPic.thumbHeight;
        if ((i <= 0) || (j <= 0)) {
          break label764;
        }
        paramContext = a(i, j, 0.0F, bool);
        j = paramContext.width;
        for (i = paramContext.height;; i = 99)
        {
          f = k / 160.0F;
          j = (int)(j * f + 0.5F);
          i = (int)(i * f + 0.5F);
          if (paramArrayOfInt == null) {
            break;
          }
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = i;
          return locala;
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + i + ", height = " + j);
          }
          j = 99;
        }
      }
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("ReplyTextItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + paramMessageForPic.uniseq + " url:" + localObject1);
        localObject4 = localObject1;
      }
      localObject1 = ((URL)localObject4).toString();
      k = paramContext.getResources().getDisplayMetrics().densityDpi;
      if (paramChatThumbView != null) {
        paramChatThumbView.flag = false;
      }
      f = k / 160.0F;
      if (BaseApplicationImpl.sImageCache.get(localObject1) != null)
      {
        paramContext = aoop.getDrawable((URL)localObject4, 0, 0, null, null, true, 6.0F * f);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = paramContext.getIntrinsicWidth();
          paramArrayOfInt[1] = paramContext.getIntrinsicHeight();
          if (QLog.isColorLevel()) {
            QLog.d("ReplyTextItemBuilder", 2, "getNoRoundThumbDrawableAbsDownloader cache:" + paramArrayOfInt[0] + "," + paramArrayOfInt[1]);
          }
        }
        return locala;
      }
      label531:
      label548:
      label764:
      Object localObject2;
      label642:
      label667:
      URL localURL1 = null;
      break;
      localURL1 = null;
      localObject3 = null;
    }
  }
  
  private static xmb.b a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    boolean bool2 = true;
    Object localObject2 = null;
    int m = 0;
    Object localObject3 = "";
    int n = 0;
    int j = 0;
    boolean bool1 = false;
    Object localObject4;
    int k;
    int i;
    Object localObject1;
    if (m < paramMessageForMixedMsg.msgElemList.size())
    {
      if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForText))
      {
        localObject4 = localObject3;
        k = n;
        i = j;
        if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForReplyText)) {}
      }
      else
      {
        localObject4 = localObject3;
        k = n;
        i = j;
        if (n == 0)
        {
          if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForText)) {
            break label289;
          }
          localObject4 = (MessageForText)paramMessageForMixedMsg.msgElemList.get(m);
          if (((MessageForText)localObject4).sb == null) {
            break label267;
          }
          localObject1 = ((MessageForText)localObject4).sb.toString();
          localObject4 = localObject1;
          k = n;
          i = j;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject4 = localObject1;
            k = n;
            i = j;
            if (!((String)localObject1).equals("\n"))
            {
              if (!bool1) {
                break label395;
              }
              i = 2;
              k = 1;
            }
          }
        }
      }
      for (localObject4 = localObject1;; localObject4 = localObject1)
      {
        if ((!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForPic)) || (bool1)) {
          break label406;
        }
        localObject1 = (MessageForPic)paramMessageForMixedMsg.msgElemList.get(m);
        MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
        if (k == 0) {
          break label441;
        }
        localObject3 = localObject4;
        bool1 = bool2;
        label252:
        return new xmb.b((MessageForPic)localObject1, (String)localObject3, i, bool1);
        label267:
        localObject1 = localObject3;
        if (((MessageForText)localObject4).msg == null) {
          break;
        }
        localObject1 = ((MessageForText)localObject4).msg;
        break;
        label289:
        localObject1 = localObject3;
        if (!(paramMessageForMixedMsg.msgElemList.get(m) instanceof MessageForReplyText)) {
          break;
        }
        localObject1 = localObject3;
        if (((MessageForReplyText)paramMessageForMixedMsg.msgElemList.get(m)).sb == null) {
          break;
        }
        localObject4 = (MessageForReplyText)paramMessageForMixedMsg.msgElemList.get(m);
        if (((MessageForReplyText)localObject4).sb != null)
        {
          localObject1 = ((MessageForReplyText)localObject4).sb.toString();
          break;
        }
        localObject1 = localObject3;
        if (((MessageForReplyText)localObject4).msg == null) {
          break;
        }
        localObject1 = ((MessageForReplyText)localObject4).msg;
        break;
        label395:
        k = 1;
        i = 1;
      }
      label406:
      localObject1 = localObject2;
    }
    for (;;)
    {
      m += 1;
      localObject2 = localObject1;
      localObject3 = localObject4;
      n = k;
      j = i;
      break;
      localObject1 = localObject2;
      i = j;
      break label252;
      label441:
      bool1 = true;
    }
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString, ImageView paramImageView)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      paramString = ShortVideoItemBuilder.a(paramString, 55, 95, wja.dp2px(2.0F, paramImageView.getContext().getResources()));
    }
    while ((paramString == null) || (paramString.getCurrent() == null))
    {
      paramImageView.setVisibility(8);
      return;
      if (paramInt1 > paramInt2)
      {
        paramInt1 = (int)(Float.valueOf(paramInt1).floatValue() / 95);
        paramString = ShortVideoItemBuilder.a(paramString, 95, (int)(Float.valueOf(paramInt2).floatValue() / paramInt1), wja.dp2px(2.0F, paramImageView.getContext().getResources()));
      }
      else
      {
        paramInt2 = (int)(Float.valueOf(paramInt2).floatValue() / 95);
        paramString = ShortVideoItemBuilder.a(paramString, (int)(Float.valueOf(paramInt1).floatValue() / paramInt2), 95, wja.dp2px(2.0F, paramImageView.getContext().getResources()));
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.width = paramString.getCurrent().getIntrinsicWidth();
    localLayoutParams.height = paramString.getCurrent().getIntrinsicHeight();
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setImageDrawable(paramString);
  }
  
  private static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    BubbleImageView localBubbleImageView = (BubbleImageView)paramViewGroup.findViewById(2131379641);
    int i = paramViewGroup.findViewById(2131372190).getPaddingLeft();
    localBubbleImageView.setRadius(0.0F);
    localBubbleImageView.setAdjustViewBounds(true);
    localBubbleImageView.TE(false);
    localBubbleImageView.setShowEdge(true);
    if ((paramMessageRecord2 instanceof MessageForShortVideo)) {
      localBubbleImageView.setContentDescription(acfp.m(2131713898));
    }
    Object localObject;
    for (;;)
    {
      localObject = paramViewGroup.findViewById(2131368896);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = aqcx.dip2px(paramContext, 25.0F);
      ((View)localObject).setLayoutParams(localLayoutParams);
      i = Build.VERSION.SDK_INT;
      if ((i == 19) || (i == 18)) {
        localBubbleImageView.aAu = true;
      }
      localObject = (ETTextView)paramViewGroup.findViewById(2131372006);
      paramViewGroup = (ETTextView)paramViewGroup.findViewById(2131371989);
      if (localBubbleImageView.getDrawable() == null) {
        a(localBubbleImageView, paramContext, paramSourceMsgInfo);
      }
      a(localBubbleImageView, paramMessageRecord1);
      a(paramQQAppInterface, paramContext, paramViewGroup, paramMessageRecord2, paramString);
      if (paramMessageRecord2 == null) {
        break;
      }
      a(paramMessageRecord2, paramSourceMsgInfo, localBubbleImageView, paramViewGroup, (ETTextView)localObject, paramInt, paramString, paramMessageRecord1, paramContext, paramQQAppInterface, null);
      return;
      localBubbleImageView.setContentDescription(acfp.m(2131713891));
    }
    if ((paramBoolean2) || (hP(paramString)) || (paramSourceMsgInfo.mSourceSummaryFlag != 1))
    {
      c(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, new xmd(paramViewGroup, (ETTextView)localObject, paramSourceMsgInfo, localBubbleImageView, paramInt, paramString, paramMessageRecord1, paramContext));
      return;
    }
    localBubbleImageView.setVisibility(8);
    a(paramViewGroup, (TextView)localObject, paramInt, paramString, null);
    a(paramContext, paramQQAppInterface, localBubbleImageView, paramMessageRecord1, paramSourceMsgInfo, (ETTextView)localObject, paramViewGroup, paramInt, paramString);
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForReplyText)) && (QLog.isColorLevel())) {
      QLog.d("SendMsgBtn", 2, "ReplyItemBuilder reply:" + paramMessageRecord + " sourceMsg=" + ((MessageForReplyText)paramMessageRecord).getSourceMessage());
    }
    String str2 = aqmu.a(paramContext, 3, paramSourceMsgInfo.mSourceMsgTime * 1000L).toString();
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131372190);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131379679);
    boolean bool1;
    Object localObject2;
    Object localObject1;
    label147:
    String str1;
    int i;
    if ((paramBoolean) || (hP(paramSourceMsgInfo.mSourceMsgText)))
    {
      bool1 = true;
      localObject2 = paramSourceMsgInfo.mSourceMsgText;
      if (TextUtils.isEmpty(paramSourceMsgInfo.mAnonymousNickName)) {
        break label529;
      }
      localObject1 = paramSourceMsgInfo.mAnonymousNickName;
      str1 = null;
      if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
        break label725;
      }
      str1 = paramSourceMsgInfo.mSourceMsgText;
      localObject2 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
      if (!(localObject2 instanceof MessageForPic)) {
        break label1595;
      }
      paramString = str1;
      if (acei.W((MessageRecord)localObject2))
      {
        if (str1 == null) {
          break label714;
        }
        paramInt = str1.indexOf('[');
        if (paramInt < 0) {
          break label714;
        }
        i = str1.indexOf(']');
        if (i <= paramInt) {
          break label714;
        }
        paramString = str1.substring(paramInt, i + 1);
      }
      label245:
      paramBoolean = true;
      paramInt = 0;
    }
    for (;;)
    {
      str1 = paramString;
      paramString = (String)localObject2;
      label274:
      label311:
      Object localObject4;
      Object localObject3;
      long l;
      if ((paramMessageRecord instanceof MessageForReplyText))
      {
        localObject2 = (MessageForReplyText)paramMessageRecord;
        boolean bool2 = MessageForReplyText.needHideLocate((MessageForReplyText)localObject2);
        if (!(paramMessageRecord instanceof MessageForReplyText)) {
          break label1567;
        }
        localObject2 = (MessageForReplyText)paramMessageRecord;
        if (((MessageForReplyText)localObject2).getSourceMessage() == null) {
          break label1567;
        }
        localObject2 = ((MessageForReplyText)localObject2).getSourceMessage();
        localObject4 = (TextView)paramViewGroup.findViewById(2131367548);
        localObject3 = (ImageView)paramViewGroup.findViewById(2131369803);
        if (!a(paramSourceMsgInfo, paramSessionInfo, paramQQAppInterface)) {
          break label1370;
        }
        paramSessionInfo = null;
        paramString = paramSessionInfo;
        if ((paramMessageRecord instanceof MessageForReplyText))
        {
          paramString = paramSessionInfo;
          if (((MessageForReplyText)paramMessageRecord).isBarrageMsg)
          {
            l = ((MessageForReplyText)paramMessageRecord).barrageTimeLocation;
            if (!(localObject2 instanceof MessageForShortVideo)) {
              break label1205;
            }
            paramString = aeeu.e(paramContext, (int)(l / 1000L));
          }
        }
        label404:
        if (paramString == null) {
          break label1354;
        }
        ((TextView)localObject4).setText(paramString);
        ((TextView)localObject4).setVisibility(0);
        label422:
        if (!bool2) {
          break label1364;
        }
        i = 4;
        label430:
        ((ImageView)localObject3).setVisibility(i);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localTextView1.setTag(2131379213, localObject1);
          localTextView1.setTag(2131379214, Long.valueOf(paramSourceMsgInfo.mSourceMsgSenderUin));
          localTextView1.setText((CharSequence)localObject1);
          localTextView2.setText(" " + str2);
        }
        a(paramContext, paramQQAppInterface, paramViewGroup, paramSourceMsgInfo, paramMessageRecord, (MessageRecord)localObject2, paramBoolean, paramInt, str1, bool1);
        return;
        bool1 = false;
        break;
        label529:
        if (paramSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
        {
          localObject1 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
          if (localObject1 != null)
          {
            localObject1 = apsb.a((MessageRecord)localObject1);
            if (localObject1 != null) {
              paramSourceMsgInfo.mAnonymousNickName = ((apsb.a)localObject1).nickname;
            }
          }
          localObject1 = "";
          break label147;
        }
        localObject1 = localTextView1.getTag(2131379214);
        if ((localObject1 == null) || (((Long)localObject1).longValue() != paramSourceMsgInfo.mSourceMsgSenderUin))
        {
          ThreadManager.excute(new ReplyTextItemBuilder.9(paramQQAppInterface, paramInt, paramString, paramSourceMsgInfo, localTextView1, localTextView2, str2), 64, null, true);
          localObject1 = "";
          break label147;
        }
        localTextView1.setText(new aofe((String)localTextView1.getTag(2131379213), 16).k());
        localTextView2.setText(" " + str2);
        localObject1 = "";
        break label147;
        label714:
        paramString = acfp.m(2131713893);
        break label245;
        label725:
        localObject3 = a(paramQQAppInterface, paramString, paramInt, paramMessageRecord, paramSourceMsgInfo);
        if ((localObject3 instanceof MessageForFile))
        {
          if (((MessageForFile)localObject3).fileName == null) {
            break label1574;
          }
          paramString = ((MessageForFile)localObject3).getSummaryMsg();
          paramSourceMsgInfo.mSourceMsgText = paramString;
          paramSourceMsgInfo.mSourceSummaryFlag = 1;
          paramBoolean = false;
          paramInt = 1;
        }
      }
      for (;;)
      {
        str1 = paramString;
        if (paramString == null) {
          str1 = paramSourceMsgInfo.mSourceMsgText;
        }
        paramString = str1;
        if (localObject3 != null)
        {
          paramString = str1;
          if (((MessageRecord)localObject3).shmsgseq == paramMessageRecord.shmsgseq) {
            paramString = (String)localObject2;
          }
        }
        str1 = paramString;
        paramString = (String)localObject3;
        break;
        if ((localObject3 instanceof MessageForTroopFile))
        {
          paramString = str1;
          if (((MessageForTroopFile)localObject3).fileName != null) {
            paramString = ((MessageForTroopFile)localObject3).getSummaryMsg();
          }
          str1 = paramString;
          if (TextUtils.isEmpty(paramString))
          {
            localObject4 = apsv.a(paramQQAppInterface, (MessageForTroopFile)localObject3);
            str1 = paramString;
            if (localObject4 != null) {
              str1 = ((apcy)localObject4).FileName;
            }
          }
          paramString = str1;
          if (TextUtils.isEmpty(str1))
          {
            str1 = ((MessageRecord)localObject3).getExtInfoFromExtStr("_m_ForwardFileName");
            paramString = str1;
            if (!TextUtils.isEmpty(str1)) {
              paramString = acfp.m(2131708144) + str1;
            }
          }
          if (!TextUtils.isEmpty(paramString))
          {
            paramSourceMsgInfo.mSourceMsgText = paramString;
            paramSourceMsgInfo.mSourceSummaryFlag = 1;
            paramBoolean = false;
            paramInt = 1;
          }
        }
        else
        {
          if (((localObject3 instanceof MessageForPic)) && (bool1))
          {
            if ((paramMessageRecord instanceof aezc))
            {
              paramString = null;
              paramBoolean = true;
              paramInt = 0;
            }
          }
          else if (localObject3 != null)
          {
            for (;;)
            {
              try
              {
                if (!((ChatMessage)localObject3).mIsParsed) {
                  ((ChatMessage)localObject3).parse();
                }
                if (!(localObject3 instanceof MessageForReplyText)) {
                  continue;
                }
                if (((MessageForReplyText)localObject3).sb != null) {
                  continue;
                }
                QLog.e("ReplyTextItemBuilder", 2, "MessageForReplyText.sb is null");
                if (((MessageRecord)localObject3).msg == null) {
                  continue;
                }
                paramString = ((MessageRecord)localObject3).msg;
              }
              catch (Throwable localThrowable)
              {
                paramString = "";
                QLog.e("ReplyTextItemBuilder", 2, new Object[] { "msg.getSummaryMsg error, msg type=", localObject3.getClass().getName(), localThrowable });
                continue;
              }
              paramSourceMsgInfo.mSourceMsgText = paramString;
              paramSourceMsgInfo.mSourceSummaryFlag = 1;
              paramInt = 1;
              paramBoolean = false;
              break;
              paramString = "";
              continue;
              paramString = ((MessageForReplyText)localObject3).getSummaryMsg();
              continue;
              paramString = ((ChatMessage)localObject3).getSummaryMsg();
            }
            localObject2 = null;
            break label274;
            label1205:
            paramString = paramSessionInfo;
            if (!ahav.ax((MessageRecord)localObject2)) {
              break label404;
            }
            Object localObject5 = a(paramQQAppInterface, (MessageRecord)localObject2);
            if ((localObject5 instanceof MessageForFile))
            {
              paramString = paramQQAppInterface.a().a(((MessageRecord)localObject5).uniseq, ((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop);
              if ((paramString == null) || (ahav.getFileType(paramString.fileName) != 2)) {
                break label1561;
              }
            }
            label1561:
            for (paramString = aeeu.e(paramContext, (int)(l / 1000L));; paramString = null)
            {
              break;
              paramString = paramSessionInfo;
              if (!(localObject5 instanceof MessageForTroopFile)) {
                break;
              }
              localObject5 = apsv.a(paramQQAppInterface, (MessageForTroopFile)localObject5);
              paramString = paramSessionInfo;
              if (localObject5 == null) {
                break;
              }
              paramString = paramSessionInfo;
              if (ahav.getFileType(((apcy)localObject5).FileName) != 2) {
                break;
              }
              paramString = aeeu.e(paramContext, (int)(l / 1000L));
              break;
              label1354:
              ((TextView)localObject4).setVisibility(8);
              break label422;
              label1364:
              i = 0;
              break label430;
              label1370:
              paramString = paramContext.getString(2131701575);
              if (!TextUtils.isEmpty(paramSourceMsgInfo.mSourceMsgTroopName))
              {
                localObject5 = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSourceMsgInfo.mSourceMsgToUin + "");
                paramSessionInfo = paramSourceMsgInfo.mSourceMsgTroopName;
                paramString = paramSessionInfo;
                if (localObject5 != null)
                {
                  paramString = paramSessionInfo;
                  if (!TextUtils.isEmpty(((TroopInfo)localObject5).getTroopName())) {
                    paramString = ((TroopInfo)localObject5).getTroopName();
                  }
                }
                paramString = paramContext.getString(2131701574) + paramString;
              }
              ((TextView)localObject4).setText(paramString);
              ((TextView)localObject4).setVisibility(0);
              paramString = ((FragmentActivity)paramContext).getChatFragment();
              if ((paramString != null) && ((paramString.a() instanceof ybl))) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {}
                for (i = 4;; i = 0)
                {
                  ((ImageView)localObject3).setVisibility(i);
                  break;
                }
              }
            }
            label1567:
            localObject2 = paramString;
            break label311;
          }
          label1574:
          paramString = null;
          paramBoolean = false;
          paramInt = 1;
          continue;
        }
        paramBoolean = false;
        paramInt = 1;
      }
      label1595:
      paramInt = 1;
      paramBoolean = false;
      paramString = localThrowable;
    }
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 instanceof aezc)) {}
    for (Object localObject = (aezc)paramMessageRecord1;; localObject = null)
    {
      boolean bool;
      if ((paramMessageRecord2 instanceof MessageForPic))
      {
        paramMessageRecord1 = (MessageForPic)paramMessageRecord2;
        bool = avfp.ns(paramMessageRecord1.imageType);
        if (!bool)
        {
          paramContext = xkl.b(paramContext, paramMessageRecord1, paramChatThumbView);
          if (paramContext != null)
          {
            paramQQAppInterface = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
            paramQQAppInterface.width = paramContext.getCurrent().getIntrinsicWidth();
            paramQQAppInterface.height = paramContext.getCurrent().getIntrinsicHeight();
            paramChatThumbView.setLayoutParams(paramQQAppInterface);
            paramChatThumbView.setImageDrawable(paramContext.mutate());
          }
          paramChatThumbView.setTag(2131364517, paramMessageRecord1);
        }
      }
      label284:
      label306:
      label329:
      label465:
      label478:
      label487:
      label496:
      label502:
      label509:
      do
      {
        return;
        paramMessageRecord2 = new int[2];
        tmp111_109 = paramMessageRecord2;
        tmp111_109[0] = 0;
        tmp115_111 = tmp111_109;
        tmp115_111[1] = 0;
        tmp115_111;
        paramQQAppInterface = aoop.a(paramMessageRecord1, 65537);
        try
        {
          paramQQAppInterface = new URL(paramQQAppInterface.toString());
          if (paramQQAppInterface == null)
          {
            paramChatThumbView.setImageDrawable(xpw.b(2, 200, 200));
            return;
          }
        }
        catch (MalformedURLException paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ReplyTextItemBuilder", 2, "group emo new URL error!");
            }
            paramQQAppInterface.printStackTrace();
            paramQQAppInterface = null;
          }
          paramQQAppInterface = a(paramContext, paramMessageRecord1, paramChatThumbView, paramMessageRecord2);
          paramContext = a(paramContext, paramMessageRecord1, paramChatThumbView, new int[] { 0, 0 }, paramQQAppInterface);
          paramChatThumbView.setTag(2131364517, paramMessageRecord1);
          if (paramMessageRecord2[0] <= 0) {
            break label465;
          }
        }
        int j;
        int n;
        int i1;
        int i2;
        int k;
        int m;
        if (paramMessageRecord2[1] > 0)
        {
          paramQQAppInterface = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
          j = aoop.G(bool);
          n = Math.min(aoop.H(bool), 80);
          if (paramMessageRecord2[0] <= j) {
            break label478;
          }
          i = j;
          if (paramMessageRecord2[1] <= j) {
            break label487;
          }
          i1 = wja.dp2px(95.0F, paramChatThumbView.getResources());
          if (i <= j) {
            break label496;
          }
          i2 = 0;
          if ((i2 != 0) || (i <= i1)) {
            break label509;
          }
          if (i1 >= n) {
            break label502;
          }
          k = n;
          m = paramMessageRecord2[1] * k / paramMessageRecord2[0];
        }
        do
        {
          do
          {
            paramQQAppInterface.width = k;
            paramQQAppInterface.height = m;
            if (localObject != null)
            {
              if (((aezc)localObject).getSourceMsgInfo() != null)
              {
                ((aezc)localObject).getSourceMsgInfo().replyPicWidth = k;
                ((aezc)localObject).getSourceMsgInfo().replyPicHeight = m;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ReplyTextItemBuilder", 2, "set size :" + paramMessageRecord2[0] + "," + paramMessageRecord2[1] + " real:" + k + "," + m);
              }
            }
            paramChatThumbView.setImageDrawable(paramContext.mutate());
            i(paramContext);
            return;
            i = paramMessageRecord2[0];
            break;
            j = paramMessageRecord2[1];
            break label284;
            i2 = 1;
            break label306;
            k = i1;
            break label329;
            k = i;
            m = j;
          } while (i2 == 0);
          k = i;
          m = j;
        } while (j <= i1);
        if (i1 < n) {}
        for (int i = n;; i = i1)
        {
          k = paramMessageRecord2[0] * i / paramMessageRecord2[1];
          m = i;
          break;
        }
        if (!ahav.ax(paramMessageRecord2)) {
          break;
        }
        paramContext = a(paramQQAppInterface, paramMessageRecord2);
        if ((paramContext instanceof MessageForTroopFile))
        {
          b(paramQQAppInterface, paramChatThumbView, paramContext);
          return;
        }
      } while (!(paramContext instanceof MessageForFile));
      a(paramQQAppInterface, paramChatThumbView, paramContext);
      return;
      if ((paramMessageRecord2 instanceof MessageForShortVideo))
      {
        paramContext = (MessageForShortVideo)paramMessageRecord2;
        paramMessageRecord2 = ShortVideoUtils.bw(paramContext.thumbMD5, "jpg");
        if (!aqhq.fileExistsAndNotEmpty(paramMessageRecord2)) {}
        for (;;)
        {
          try
          {
            paramMessageRecord2 = anfr.a(2, 2);
            localObject = paramContext.getDownloadInfo(paramMessageRecord2.dFl);
            ((anfu)localObject).thumbPath = ShortVideoUtils.bw(paramContext.thumbMD5, "jpg");
            ((anfu)localObject).jv(paramContext.istroop, 1);
            paramMessageRecord2.c((anfu)localObject);
            paramMessageRecord2.b(new xme(paramContext, paramMessageRecord1, paramQQAppInterface, paramChatThumbView));
            anfr.a(paramMessageRecord2, paramQQAppInterface);
            paramContext = (ImageView)((ViewGroup)paramChatThumbView.getParent()).findViewById(2131368724);
            if (paramContext == null) {
              break;
            }
            paramContext.setImageResource(2130845215);
            paramContext.setVisibility(0);
            return;
          }
          catch (Exception paramContext)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ReplyTextItemBuilder", 2, "no appRuntime");
            continue;
          }
          a(paramContext.thumbWidth, paramContext.thumbHeight, paramMessageRecord2, paramChatThumbView);
        }
      }
      if ((localObject != null) && (((aezc)localObject).getSourceMsgInfo() != null) && (((aezc)localObject).getSourceMsgInfo().replyPicWidth != 0))
      {
        paramChatThumbView.setImageDrawable(xpw.b(2, 200, 200));
        return;
      }
      paramChatThumbView.setVisibility(8);
      return;
    }
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, xmb.e parame)
  {
    ThreadManager.post(new ReplyTextItemBuilder.3(paramMessageRecord, paramQQAppInterface, parame, paramContext, paramChatThumbView), 8, null, true);
  }
  
  protected static void a(Context paramContext, QQAppInterface paramQQAppInterface, BubbleImageView paramBubbleImageView, MessageRecord paramMessageRecord, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString)
  {
    paramSourceMsgInfo = new xmf(paramSourceMsgInfo, paramBubbleImageView, paramETTextView2, paramETTextView1, paramInt, paramString, paramMessageRecord);
    if (paramMessageRecord.istroop == 0)
    {
      a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, paramSourceMsgInfo);
      return;
    }
    b(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord, paramSourceMsgInfo);
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = aqpm.a(str, paramMessageRecord, ChatTextSizeSettingActivity.vq() - 2, 7);
    switch (paramInt)
    {
    default: 
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.enableTalkBack) {
        paramTextView1.setContentDescription(aofy.og(str));
      }
      paramTextView2.setVisibility(8);
      return;
    case 0: 
      paramTextView1.setVisibility(8);
      paramTextView2.setVisibility(8);
      return;
    case 1: 
      paramTextView1.setVisibility(0);
      paramTextView1.setText(paramString);
      if (AppSetting.enableTalkBack) {
        paramTextView1.setContentDescription(aofy.og(str));
      }
      paramTextView2.setVisibility(8);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramString);
    if (AppSetting.enableTalkBack) {
      paramTextView2.setContentDescription(aofy.og(str));
    }
    paramTextView1.setVisibility(8);
  }
  
  public static void a(ChatThumbView paramChatThumbView)
  {
    if (paramChatThumbView == null) {
      return;
    }
    paramChatThumbView.setVisibility(8);
    paramChatThumbView = (ViewGroup)paramChatThumbView.getParent();
    if (paramChatThumbView == null)
    {
      QLog.i("ReplyTextItemBuilder<QFile>", 1, "resetReplyThumbImageView: can not get imageContent");
      return;
    }
    Object localObject = paramChatThumbView.findViewById(2131379633);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131365491);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = paramChatThumbView.findViewById(2131365667);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramChatThumbView.findViewById(2131368724);
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    paramChatThumbView.setVisibility(8);
  }
  
  private static void a(ChatThumbView paramChatThumbView, Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramSourceMsgInfo.replyPicWidth == 0) {
      return;
    }
    Bitmap localBitmap;
    if ((aoop.am() instanceof SkinnableBitmapDrawable))
    {
      localBitmap = ((SkinnableBitmapDrawable)aoop.am()).getBitmap();
      paramChatThumbView.setImageDrawable(new afeg(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    if ((aoop.am() instanceof BitmapDrawable))
    {
      localBitmap = ((BitmapDrawable)aoop.am()).getBitmap();
      paramChatThumbView.setImageDrawable(new afeg(paramContext.getResources(), localBitmap, paramSourceMsgInfo.replyPicWidth, paramSourceMsgInfo.replyPicHeight, -921103));
      return;
    }
    paramChatThumbView.setImageDrawable(aoop.am());
  }
  
  public static void a(ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    try
    {
      if (paramChatThumbView.getTag() == paramMessageRecord) {
        return;
      }
      paramChatThumbView.setTag(paramMessageRecord);
      a(paramChatThumbView);
      return;
    }
    catch (Exception paramChatThumbView) {}
  }
  
  public static void a(ChatThumbView paramChatThumbView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = paramChatThumbView.getContext();
    paramInt2 = wja.dp2px(120.0F, ((Context)localObject).getResources());
    int i = wja.dp2px(80.0F, ((Context)localObject).getResources());
    if (paramInt1 <= 0) {
      if (paramBoolean) {
        paramInt1 = wja.dp2px(60.0F, ((Context)localObject).getResources());
      }
    }
    for (;;)
    {
      if (paramInt1 > paramInt2) {
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        localObject = (ViewGroup)paramChatThumbView.getParent();
        if (localObject == null) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "showDefaultReplyThumb: can not get imageContent");
        }
        do
        {
          return;
          paramInt1 = wja.dp2px(120.0F, ((Context)localObject).getResources());
          break;
          paramChatThumbView.setVisibility(8);
          ((ViewGroup)localObject).setVisibility(0);
          paramChatThumbView = (AsyncImageView)((ViewGroup)localObject).findViewById(2131379633);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131365667);
          if (paramChatThumbView != null)
          {
            ViewGroup.LayoutParams localLayoutParams = paramChatThumbView.getLayoutParams();
            localLayoutParams.width = paramInt1;
            localLayoutParams.height = i;
            paramChatThumbView.setLayoutParams(localLayoutParams);
            paramChatThumbView.setVisibility(0);
            paramChatThumbView.getBackground().setAlpha(26);
          }
          paramChatThumbView = ((ViewGroup)localObject).findViewById(2131365491);
          if (paramChatThumbView != null) {
            paramChatThumbView.setVisibility(8);
          }
          paramChatThumbView = (ImageView)((ViewGroup)localObject).findViewById(2131368724);
        } while (paramChatThumbView == null);
        paramChatThumbView.setVisibility(0);
        if (paramBoolean)
        {
          paramChatThumbView.setImageResource(2130845215);
          return;
        }
        paramChatThumbView.setImageResource(2130845214);
        return;
      }
    }
  }
  
  public static void a(ChatThumbView paramChatThumbView, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if (paramChatThumbView == null) {}
    do
    {
      return;
      paramChatThumbView.getContext();
      ViewGroup localViewGroup = (ViewGroup)paramChatThumbView.getParent();
      if (localViewGroup == null)
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "handleReplyThumbImageView: can not get imageContent");
        return;
      }
      a(paramInt1, paramInt2, paramString, paramChatThumbView);
      if (paramBoolean)
      {
        paramString = localViewGroup.findViewById(2131365491);
        if (paramString != null)
        {
          paramChatThumbView = (RelativeLayout.LayoutParams)paramChatThumbView.getLayoutParams();
          paramString.setVisibility(0);
          ViewGroup.LayoutParams localLayoutParams = paramString.getLayoutParams();
          localLayoutParams.width = paramChatThumbView.width;
          localLayoutParams.height = paramChatThumbView.height;
          paramString.setLayoutParams(paramChatThumbView);
        }
      }
      paramChatThumbView = localViewGroup.findViewById(2131365667);
      if (paramChatThumbView != null) {
        paramChatThumbView.setVisibility(8);
      }
      paramChatThumbView = (ImageView)localViewGroup.findViewById(2131368724);
    } while (paramChatThumbView == null);
    if (paramBoolean)
    {
      paramChatThumbView.setImageResource(2130845215);
      paramChatThumbView.setVisibility(0);
      return;
    }
    paramChatThumbView.setVisibility(8);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord, String paramString)
  {
    int i;
    if (ahav.ax(paramMessageRecord))
    {
      paramMessageRecord = a(paramQQAppInterface, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForFile))
      {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "handleReplyTextStyle, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
        paramMessageRecord = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if ((paramMessageRecord == null) || (paramMessageRecord.status == 16)) {
          break label751;
        }
        i = ahav.aC(ahav.getFileType(paramMessageRecord.fileName), 1);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramQQAppInterface = paramContext.getDrawable(i);
          paramTextView.setText(paramMessageRecord.fileName);
        }
      }
    }
    for (;;)
    {
      if (paramQQAppInterface != null)
      {
        i = wja.dp2px(15.0F, paramContext.getResources());
        int j = wja.dp2px(4.0F, paramContext.getResources());
        paramQQAppInterface.setBounds(0, 0, i, i);
        paramTextView.setCompoundDrawables(paramQQAppInterface, null, null, null);
        paramTextView.setGravity(16);
        paramTextView.setCompoundDrawablePadding(j);
        paramTextView.setPadding(0, 0, 0, 0);
        paramTextView.invalidate();
        paramTextView.setMaxLines(1);
        paramTextView.setIncludeFontPadding(false);
        paramTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        return;
        paramQQAppInterface = paramContext.getResources().getDrawable(i);
        break;
        if (!(paramMessageRecord instanceof MessageForTroopFile)) {
          break label751;
        }
        paramMessageRecord = apsv.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramMessageRecord == null) {
          break label751;
        }
        i = ahav.aC(ahav.getFileType(paramMessageRecord.FileName), 1);
        if (Build.VERSION.SDK_INT >= 21) {}
        for (paramQQAppInterface = paramContext.getDrawable(i);; paramQQAppInterface = paramContext.getResources().getDrawable(i))
        {
          paramTextView.setText(paramMessageRecord.FileName);
          break;
        }
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          if ((!abdy.U(paramMessageRecord)) || (L(paramMessageRecord))) {
            break label746;
          }
          label336:
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          if (Build.VERSION.SDK_INT >= 21)
          {
            paramString = paramContext.getDrawable(2130845175);
            paramQQAppInterface = paramString;
            if (((MessageForStructing)paramMessageRecord).structingMsg != null)
            {
              paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgUrl;
              paramQQAppInterface = aobw.nW(paramMessageRecord);
              i = wja.dp2px(15.0F, paramContext.getResources());
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mLoadingDrawable = paramString;
              localURLDrawableOptions.mFailedDrawable = paramString;
              localURLDrawableOptions.mRequestWidth = i;
              localURLDrawableOptions.mRequestHeight = i;
              localURLDrawableOptions.mUseAutoScaleParams = false;
              if (TextUtils.isEmpty(paramQQAppInterface)) {
                break label458;
              }
              paramQQAppInterface = URLDrawable.getDrawable(paramQQAppInterface, localURLDrawableOptions);
              paramQQAppInterface.setBounds(0, 0, i, i);
            }
          }
          for (;;)
          {
            break;
            paramString = paramContext.getResources().getDrawable(2130845175);
            break label336;
            label458:
            paramQQAppInterface = paramString;
            if (!TextUtils.isEmpty(paramMessageRecord))
            {
              paramQQAppInterface = paramString;
              if (paramMessageRecord.contains(aobw.cjT))
              {
                paramQQAppInterface = URLDrawable.getDrawable(aobw.cjU, localURLDrawableOptions);
                paramQQAppInterface.setBounds(0, 0, i, i);
              }
            }
          }
        }
        if (!(paramMessageRecord instanceof MessageForArkApp)) {
          break label746;
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
              if ((paramMessageRecord == null) || (!aejg.a().aS(paramMessageRecord.appName, paramMessageRecord.appView))) {
                break label746;
              }
              if (Build.VERSION.SDK_INT < 21) {
                break label692;
              }
              paramQQAppInterface = paramContext.getDrawable(2130845175);
              paramMessageRecord = aejg.a().a(new JSONObject(paramMessageRecord.toAppXml())).get("kArkMsgReplyIcon").toString();
              i = wja.dp2px(15.0F, paramContext.getResources());
              paramString = URLDrawable.URLDrawableOptions.obtain();
              paramString.mLoadingDrawable = paramQQAppInterface;
              paramString.mFailedDrawable = paramQQAppInterface;
              paramString.mRequestWidth = i;
              paramString.mRequestHeight = i;
              paramString.mUseAutoScaleParams = false;
              if (TextUtils.isEmpty(paramMessageRecord)) {
                break;
              }
              paramQQAppInterface = URLDrawable.getDrawable(paramMessageRecord, paramString);
              try
              {
                paramQQAppInterface.setBounds(0, 0, i, i);
              }
              catch (Exception paramMessageRecord) {}
            }
          }
          catch (Exception paramMessageRecord)
          {
            label692:
            paramQQAppInterface = null;
            continue;
          }
          QLog.e("ReplyTextItemBuilder", 1, "handle MessageForArkApp error!" + paramMessageRecord.getMessage());
          break;
          paramQQAppInterface = paramContext.getResources().getDrawable(2130845175);
        }
      }
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setPadding(0, 0, 0, 0);
      paramTextView.setCompoundDrawablePadding(0);
      paramTextView.setMaxLines(2147483647);
      paramTextView.setEllipsize(null);
      return;
      label746:
      paramQQAppInterface = null;
      continue;
      label751:
      paramQQAppInterface = null;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg, sourceMsg uniseq[" + paramMessageRecord.uniseq + "]");
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    boolean bool;
    if (localFileManagerEntity != null)
    {
      int i = ahav.getFileType(localFileManagerEntity.fileName);
      if (i != 2) {
        break label89;
      }
      bool = true;
      if ((i == 2) || (i == 0)) {
        break label95;
      }
    }
    label540:
    label552:
    for (;;)
    {
      return;
      label89:
      bool = false;
      break;
      label95:
      if (localFileManagerEntity.status == 16)
      {
        if (QLog.isDebugVersion()) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file but is invalid. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "]");
        }
        a(paramChatThumbView, bool, 0, 0);
        return;
      }
      Object localObject2 = localFileManagerEntity.strMiddleThumPath;
      Object localObject1 = localObject2;
      if (!aqhq.fileExistsAndNotEmpty((String)localObject2)) {
        localObject1 = localFileManagerEntity.strLargeThumPath;
      }
      localObject2 = localObject1;
      if (!aqhq.fileExistsAndNotEmpty((String)localObject1))
      {
        if (!bool) {
          break label503;
        }
        if (localFileManagerEntity.peerType != 3000) {
          break label490;
        }
        paramQQAppInterface = paramQQAppInterface.a().b(localFileManagerEntity);
        localObject2 = paramQQAppInterface;
        if (!aqhq.fileExistsAndNotEmpty(paramQQAppInterface))
        {
          if ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)) {
            break label540;
          }
          localObject1 = ahbh.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, "");
          if (QLog.isDebugVersion()) {
            QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set default. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + ((ahbh.a)localObject1).width + "]");
          }
          a(paramChatThumbView, bool, ((ahbh.a)localObject1).width, ((ahbh.a)localObject1).height);
        }
      }
      for (localObject2 = paramQQAppInterface;; localObject2 = paramQQAppInterface)
      {
        if (!aqhq.fileExistsAndNotEmpty((String)localObject2)) {
          break label552;
        }
        if ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)) {
          break label554;
        }
        paramQQAppInterface = ahbh.a(localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, (String)localObject2);
        if (QLog.isDebugVersion()) {
          QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle offline file set thumb. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.width + "]");
        }
        a(paramChatThumbView, bool, paramQQAppInterface.width, paramQQAppInterface.height, (String)localObject2);
        return;
        label490:
        paramQQAppInterface = paramQQAppInterface.a().a(localFileManagerEntity);
        break;
        label503:
        if (ahbh.u(localFileManagerEntity))
        {
          paramQQAppInterface = paramQQAppInterface.a().a(localFileManagerEntity, 7);
          break;
        }
        paramQQAppInterface = paramQQAppInterface.a().a(localFileManagerEntity, 5);
        break;
        a(paramChatThumbView, bool, 0, 0);
      }
    }
    label554:
    a(paramChatThumbView, bool, 0, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    int i = 1;
    int j = 8;
    if ((paramMessageRecord == null) && (!"0X800A36B".equals(paramString))) {
      return;
    }
    if ((paramMessageRecord instanceof MessageForText)) {}
    for (;;)
    {
      anot.a(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
      return;
      if ((paramMessageRecord instanceof MessageForPic))
      {
        i = 2;
      }
      else if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        i = 3;
      }
      else if (((paramMessageRecord instanceof MessageForVideo)) || ((paramMessageRecord instanceof MessageForShortVideo)))
      {
        i = 4;
      }
      else if (((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForTroopFile)))
      {
        i = 5;
      }
      else
      {
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          paramMessageRecord = (MessageForStructing)paramMessageRecord;
          i = j;
          if (paramMessageRecord.structingMsg != null) {
            switch (paramMessageRecord.structingMsg.mMsgServiceID)
            {
            default: 
              i = j;
            }
          }
          for (;;)
          {
            break;
            i = 6;
            continue;
            i = 7;
          }
        }
        if ((paramMessageRecord instanceof MessageForArkApp)) {
          try
          {
            paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
            i = j;
            if (paramMessageRecord != null) {
              i = aejg.F(paramMessageRecord.appName, paramMessageRecord.appView);
            }
          }
          catch (Exception paramMessageRecord)
          {
            QLog.e("ReplyTextItemBuilder", 1, "reportReplyItemEvent error for MessageForArkApp:" + paramMessageRecord.getMessage());
            i = 8;
          }
        } else {
          i = 8;
        }
      }
    }
  }
  
  private static void a(MessageRecord paramMessageRecord1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString1, MessageRecord paramMessageRecord2, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2)
  {
    boolean bool2 = false;
    Object localObject2 = null;
    int i;
    Object localObject1;
    boolean bool1;
    if ((paramMessageRecord1 instanceof MessageForPic)) {
      if (acei.W(paramMessageRecord1))
      {
        i = 1;
        localObject1 = paramString1;
        bool1 = bool2;
        paramString2 = localObject2;
      }
    }
    for (;;)
    {
      if (bool1)
      {
        paramBubbleImageView.setVisibility(0);
        paramBubbleImageView.setTag(2131364518, null);
        paramSourceMsgInfo = (ViewGroup)paramBubbleImageView.getParent();
        if (paramSourceMsgInfo != null) {
          paramSourceMsgInfo.setVisibility(0);
        }
        paramBubbleImageView.setVisibility(0);
        a(paramContext, paramQQAppInterface, paramBubbleImageView, paramMessageRecord2, paramString2);
        label87:
        a(paramETTextView1, paramETTextView2, i, (String)localObject1, paramMessageRecord1);
        a(paramQQAppInterface, paramContext, paramETTextView1, paramMessageRecord1, (String)localObject1);
        paramMessageRecord1 = wja.a(paramETTextView1);
        if ((paramMessageRecord1 != null) && ((paramMessageRecord1 instanceof xmb.c))) {
          ((xmb.c)paramMessageRecord1).j = paramBubbleImageView;
        }
        return;
        bool1 = true;
        i = 0;
        paramString2 = paramMessageRecord1;
        localObject1 = paramString1;
        continue;
        if ((paramMessageRecord1 instanceof MessageForShortVideo))
        {
          bool1 = true;
          i = 0;
          paramString2 = paramMessageRecord1;
          localObject1 = paramString1;
        }
        else if ((paramMessageRecord1 instanceof MessageForMixedMsg))
        {
          localObject1 = a((MessageForMixedMsg)paramMessageRecord1);
          bool1 = ((xmb.b)localObject1).bhJ;
          i = ((xmb.b)localObject1).textType;
          paramString1 = ((xmb.b)localObject1).e;
          localObject1 = ((xmb.b)localObject1).aVK;
          if (TextUtils.isEmpty(paramString2)) {
            break label617;
          }
        }
      }
    }
    for (;;)
    {
      if (paramSourceMsgInfo.mSourceSummaryFlag != 1) {
        paramString2 = paramSourceMsgInfo.mSourceMsgText;
      }
      localObject1 = paramString2;
      paramString2 = paramString1;
      break;
      if ((paramMessageRecord1 instanceof MessageForLongMsg))
      {
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (paramMessageRecord1.msgtype != -1036) {
          break;
        }
        paramSourceMsgInfo = (MessageForMixedMsg)((MessageForLongMsg)paramMessageRecord1).rebuildLongMsg();
        if (paramSourceMsgInfo == null) {
          break label609;
        }
        paramString1 = a(paramSourceMsgInfo);
        bool1 = paramString1.bhJ;
        paramInt = paramString1.textType;
        paramSourceMsgInfo = paramString1.e;
        paramString1 = paramString1.aVK;
      }
      for (;;)
      {
        paramString2 = paramSourceMsgInfo;
        i = paramInt;
        localObject1 = paramString1;
        break;
        if ((paramMessageRecord1 instanceof MessageForLongTextMsg))
        {
          paramString2 = (MessageForLongTextMsg)paramMessageRecord1;
          if (paramString2 != null) {}
          for (CharSequence localCharSequence = paramString2.sb;; localCharSequence = null)
          {
            paramString2 = localObject2;
            bool1 = bool2;
            i = paramInt;
            localObject1 = paramString1;
            if (localCharSequence == null) {
              break;
            }
            paramString2 = localObject2;
            bool1 = bool2;
            i = paramInt;
            localObject1 = paramString1;
            if (paramSourceMsgInfo.mSourceMsgText.equals(localCharSequence.toString())) {
              break;
            }
            localObject1 = localCharSequence.toString();
            paramString2 = localObject2;
            bool1 = bool2;
            i = paramInt;
            break;
          }
        }
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!ahav.ax(paramMessageRecord1)) {
          break;
        }
        paramSourceMsgInfo = a(paramQQAppInterface, paramMessageRecord1);
        if ((paramSourceMsgInfo instanceof MessageForFile))
        {
          paramString2 = localObject2;
          bool1 = bool2;
          i = paramInt;
          localObject1 = paramString1;
          if (!e(paramQQAppInterface, paramSourceMsgInfo)) {
            break;
          }
          bool1 = true;
          i = 0;
          paramString2 = paramMessageRecord1;
          localObject1 = paramString1;
          break;
        }
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!(paramSourceMsgInfo instanceof MessageForTroopFile)) {
          break;
        }
        paramString2 = localObject2;
        bool1 = bool2;
        i = paramInt;
        localObject1 = paramString1;
        if (!a(paramQQAppInterface, (MessageForTroopFile)paramSourceMsgInfo)) {
          break;
        }
        bool1 = true;
        i = 0;
        paramString2 = paramMessageRecord1;
        localObject1 = paramString1;
        break;
        a(paramBubbleImageView);
        break label87;
        label609:
        paramSourceMsgInfo = null;
        bool1 = false;
      }
      label617:
      paramString2 = (String)localObject1;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    boolean bool2 = false;
    paramQQAppInterface = apsv.a(paramQQAppInterface, paramMessageForTroopFile);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      int i = ahav.getFileType(paramQQAppInterface.FileName);
      if (i != 2)
      {
        bool1 = bool2;
        if (i != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReplyTextItemBuilder", 2, "sendUin= " + paramSourceMsgInfo.mSourceMsgSenderUin + " toUin=" + paramSourceMsgInfo.mSourceMsgToUin + " session curFin=" + paramSessionInfo.aTl + " type=" + paramSessionInfo.cZ);
    }
    String str1 = paramSourceMsgInfo.mSourceMsgToUin + "";
    String str2 = paramSourceMsgInfo.mSourceMsgSenderUin + "";
    if (paramSourceMsgInfo.mSourceMsgToUin <= 0L)
    {
      paramSourceMsgInfo.mSourceMsgToUin = a(paramQQAppInterface, paramSessionInfo, paramSourceMsgInfo.mSourceMsgSenderUin);
      return true;
    }
    if (paramSessionInfo.cZ == 3000) {
      return str1.equals(paramSessionInfo.aTl);
    }
    if (paramSessionInfo.cZ == 1)
    {
      if (str1.equals(paramSessionInfo.aTl)) {
        return true;
      }
      paramSourceMsgInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo.aTl);
      return (paramSourceMsgInfo != null) && (str1.equals(paramSourceMsgInfo.troopcode));
    }
    if ((str2.equals(paramSessionInfo.aTl)) && (str1.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      return true;
    }
    return (str1.equals(paramSessionInfo.aTl)) && (str2.equals(paramQQAppInterface.getCurrentAccountUin()));
  }
  
  private static Bitmap aj()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://GrayCommonProgress");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = aqcu.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130841695);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://GrayCommonProgress", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  protected static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, xmb.e parame)
  {
    ThreadManager.post(new ReplyTextItemBuilder.4(paramMessageRecord, paramQQAppInterface, parame, paramContext, paramChatThumbView), 8, null, true);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramMessageRecord;
    localMessageForTroopFile.doParse();
    apcy localapcy = apsv.a(paramQQAppInterface, localMessageForTroopFile);
    if (localapcy == null)
    {
      a(paramChatThumbView, false, 0, 0);
      return;
    }
    int k = ahav.getFileType(localapcy.FileName);
    if ((localapcy == null) || (localapcy.Status == 12))
    {
      if (k == 2) {}
      for (bool = true;; bool = false)
      {
        a(paramChatThumbView, bool, 0, 0);
        return;
      }
    }
    if (aqhq.fileExistsAndNotEmpty(localapcy.coc)) {}
    for (String str = localapcy.coc; aqhq.fileExistsAndNotEmpty(str); str = localapcy.ThumbnailFile_Large)
    {
      if (k == 2) {
        bool = true;
      }
      paramQQAppInterface = ahbh.a(localMessageForTroopFile.width, localMessageForTroopFile.height, str);
      if (QLog.isDebugVersion()) {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set thumb. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.width + "]");
      }
      a(paramChatThumbView, bool, paramQQAppInterface.width, paramQQAppInterface.height, str);
      return;
    }
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(localMessageForTroopFile.frienduin));
    int j = 383;
    int i = j;
    if (ahbh.aY(localMessageForTroopFile.width, localMessageForTroopFile.height))
    {
      i = j;
      if (!ahbj.fileExistsAndNotEmpty(localapcy.ThumbnailFile_Large)) {
        i = 640;
      }
    }
    if (localapcy.Status != 12)
    {
      if (localapcy.Id != null)
      {
        paramQQAppInterface.a(localapcy.Id, i);
        paramChatThumbView.setTag(2131364518, new Boolean(true));
      }
    }
    else {
      if (k != 2) {
        break label486;
      }
    }
    label486:
    for (bool = true;; bool = false)
    {
      a(paramChatThumbView, bool, 0, 0);
      if ((localMessageForTroopFile.width <= 0) || (localMessageForTroopFile.height <= 0)) {
        break label492;
      }
      paramQQAppInterface = ahbh.a(localMessageForTroopFile.width, localMessageForTroopFile.height, "");
      if (QLog.isDebugVersion()) {
        QLog.i("ReplyTextItemBuilder<QFile>", 1, "setThumbNailReplyImg: handle troop file set default. msgSeq[" + paramMessageRecord.msgseq + "] msgUniseq[" + paramMessageRecord.uniseq + "] width[" + paramQQAppInterface.width + "]");
      }
      a(paramChatThumbView, bool, paramQQAppInterface.width, paramQQAppInterface.height);
      return;
      paramQQAppInterface.e(localapcy.FilePath, localapcy.FileName, localapcy.BusId, i);
      break;
    }
    label492:
    a(paramChatThumbView, bool, 0, 0);
  }
  
  protected static void c(Context paramContext, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView, MessageRecord paramMessageRecord, xmb.e parame)
  {
    ThreadManager.post(new ReplyTextItemBuilder.5(paramMessageRecord, paramQQAppInterface, parame, paramContext, paramChatThumbView), 8, null, true);
  }
  
  private static boolean e(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.status == 16) {
        break label63;
      }
      int i = ahav.getFileType(paramQQAppInterface.fileName);
      if (i != 2)
      {
        bool1 = bool2;
        if (i != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    label63:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("ReplyTextItemBuilder", 2, "renderReply: handle offline file , but invalid. msgUniseq[" + paramMessageRecord.uniseq + "] msgSeq[" + paramMessageRecord.msgseq + "]");
    return false;
  }
  
  private int extractBgThemeColor(Bitmap paramBitmap)
  {
    int i = 0;
    int j = 0;
    long l1 = 0L;
    if (paramBitmap != null)
    {
      int k = paramBitmap.getWidth() / 2;
      int m = paramBitmap.getHeight();
      long l2 = 0L;
      long l3 = 0L;
      i = j;
      while (i < m)
      {
        j = paramBitmap.getPixel(k, i);
        l3 += Color.red(j);
        l2 += Color.green(j);
        l1 += Color.blue(j);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "count r=" + l3 + " g=" + l2 + " b=" + l1 + " height=" + m);
      }
      i = Color.rgb((int)l3 / m, (int)l2 / m, (int)l1 / m);
    }
    return i;
  }
  
  public static boolean hP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.indexOf(acfp.m(2131713895)) == -1) {
      return false;
    }
    return true;
  }
  
  private static void i(URLDrawable paramURLDrawable)
  {
    String str = paramURLDrawable.getURL().toString();
    ThreadManager.getSubThreadHandler().post(new ReplyTextItemBuilder.12(str, paramURLDrawable));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (localMessageForReplyText.mSourceMsgInfo == null) {
      return super.a(paramChatMessage);
    }
    int i = localMessageForReplyText.mSourceMsgInfo.mType;
    return super.a(paramChatMessage);
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView != null)
    {
      localc = (xmb.c)paramView.getTag();
      if (localc != null) {
        this.jdField_a_of_type_Xmb$d.q(localc.mType, paramView);
      }
    }
    xmb.c localc = (xmb.c)parame;
    int i;
    if (localMessageForReplyText.mSourceMsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReplyTextItemBuilder", 2, "text.mSourceMsgInfo为null, text:" + localMessageForReplyText.toString());
      }
      localc.mType = -1;
      parame = this.jdField_a_of_type_Xmb$d.A(-1);
      if (parame != null) {
        break label643;
      }
      parame = new LinearLayout(localContext);
      parame.setOrientation(1);
      paramView = new ETTextView(localContext);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131167322));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131167316));
      paramView.setEditableFactory(aofr.a);
      paramView.setSpannableFactory(aofk.a);
      paramView.setMaxWidth(BaseChatItemLayout.bNS);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      int j = BaseChatItemLayout.bOc;
      i = BaseChatItemLayout.bOd;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.bOd;
        i = BaseChatItemLayout.bOc;
      }
      paramView.setPadding(j, BaseChatItemLayout.bOa, i, BaseChatItemLayout.bOb);
      paramView.setId(2131364506);
      localc.mText = paramView;
      paramView = new LinearLayout.LayoutParams(-2, -2);
      paramView.topMargin = wja.dp2px(5.0F, localContext.getResources());
      parame.addView(localc.mText, paramView);
    }
    label643:
    for (;;)
    {
      ((ETTextView)localc.mText).setFont(0, paramChatMessage.uniseq);
      localc.mText.setTypeface(lf.a(paramChatMessage));
      localc.mText.setTextSize(0, this.sessionInfo.cN);
      localc.mText.setText(localMessageForReplyText.sb);
      super.a(localc.mText, paramChatMessage);
      parame.setOnTouchListener(paramwlz);
      parame.setOnLongClickListener(paramwlz);
      localc.mText.setOnTouchListener(paramwlz);
      localc.mText.setOnLongClickListener(paramwlz);
      paramView = parame;
      if ((localc.mText instanceof AnimationTextView))
      {
        ((AnimationTextView)localc.mText).onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$a;
        paramView = parame;
      }
      if (paramView != null)
      {
        paramView.setTag(localc);
        paramView.setPadding(0, 0, 0, 0);
        if ((AppSetting.enableTalkBack) && (this.sessionInfo.cZ == 0))
        {
          parame = aofy.og(paramChatMessage.msg);
          if (!paramChatMessage.isSend()) {
            break label604;
          }
          paramView.setContentDescription(acfp.m(2131713892) + this.sessionInfo.aTn + acfp.m(2131713897) + parame);
        }
      }
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, "reply type is" + localMessageForReplyText.mSourceMsgInfo.mType);
      }
      i = localMessageForReplyText.mSourceMsgInfo.mType;
      if (localMessageForReplyText.mSourceMsgInfo.oriMsgType == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramView = a(paramBaseChatItemLayout, localContext, localc, localMessageForReplyText, paramwlz, bool);
        break;
      }
      label604:
      paramView.setContentDescription(this.sessionInfo.aTn + acfp.m(2131713894) + parame);
      return paramView;
    }
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (xmb.c)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.j;
      }
    }
    return null;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xmb.c();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    wta.a(this.mContext, this.app, paramChatMessage, 3);
    Bundle localBundle = new Bundle();
    localBundle.putInt("selection_mode", this.bOY);
    Object localObject = (MessageForReplyText)paramChatMessage;
    if (aavp.a().isSelected())
    {
      paramContext = aavp.a().qL();
      if (paramContext == null) {
        if (((MessageForReplyText)localObject).sb != null)
        {
          paramContext = ((MessageForReplyText)localObject).sb.toString();
          label107:
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      label109:
      if (paramInt != 0)
      {
        localBundle.putInt("forward_type", -6);
        localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
        localObject = (alvj)this.app.getManager(340);
        MessageRecord localMessageRecord = a(this.app, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage, ((MessageForReplyText)paramChatMessage).mSourceMsgInfo);
        ((MessageForReplyText)paramChatMessage).setSourceMessageRecord(localMessageRecord);
        ((alvj)localObject).Y(paramChatMessage);
      }
      for (;;)
      {
        localBundle.putString("forward_text", paramContext);
        localBundle.putInt("forward_source_uin_type", this.sessionInfo.cZ);
        paramContext = new Intent();
        paramContext.putExtras(localBundle);
        ahgq.f((Activity)this.mContext, paramContext, 21);
        anot.a(this.app, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (!paramChatMessage.isMultiMsg) {
          break;
        }
        anot.a(this.app, "dc00898", "", "", "0X8009D66", "0X8009D66", 1, 0, "1", "", "", "");
        return;
        paramContext = ((MessageForReplyText)localObject).msg;
        break label107;
        if (paramContext.length() != aavp.a().length()) {
          break label394;
        }
        paramInt = 1;
        break label109;
        if (((MessageForReplyText)localObject).sb != null) {}
        for (paramContext = ((MessageForReplyText)localObject).sb.toString();; paramContext = ((MessageForReplyText)localObject).msg)
        {
          paramInt = 1;
          break;
        }
        localBundle.putInt("forward_type", -1);
      }
      label394:
      paramInt = 0;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (xmb.c)paramView.getTag();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (paramView.Jm == null) {
      QLog.e("ReplyTextItemBuilder", 1, "updateBubblePadding error, holder.mNameETTV=null");
    }
    int i;
    do
    {
      return;
      i = wja.dp2px(1.0F, paramView.Jm.getResources());
    } while (localMessageForReplyText.mSourceMsgInfo == null);
    int j = localMessageForReplyText.mSourceMsgInfo.mType;
    j = BaseChatItemLayout.bNS - wja.dp2px(16.0F, paramView.Jm.getResources());
    if (paramChatMessage.isSend())
    {
      paramView.mText.setPadding(bTv, 0, bTu, bTt);
      paramChatMessage = (LinearLayout.LayoutParams)paramView.jdField_do.getLayoutParams();
      paramChatMessage.leftMargin = bTv;
      paramChatMessage.rightMargin = (bTu + i * 2);
      paramChatMessage.topMargin = (bTs + i * 4);
      paramChatMessage.bottomMargin = 0;
      paramView.jdField_do.setLayoutParams(paramChatMessage);
      i = j - bTv - bTu - i * 2;
    }
    for (;;)
    {
      float f = paramView.JL.getPaint().measureText(paramView.JL.getText().toString());
      f = wja.dp2px(37.0F, paramView.Jm.getResources()) + f;
      paramView.Jm.setMaxWidth(i - (int)f);
      paramChatMessage = (String)paramView.Jm.getTag(2131379213);
      paramChatMessage = aofy.a(paramView.Jm, paramChatMessage, i - (int)f);
      paramView.Jm.setText(paramChatMessage);
      paramView.JK.setMaxWidth(i);
      paramView.d.setMaxWidth(i);
      paramView.e.setMaxWidth(i);
      return;
      paramView.mText.setPadding(bTu, 0, bTv, bTt);
      paramChatMessage = (LinearLayout.LayoutParams)paramView.jdField_do.getLayoutParams();
      paramChatMessage.leftMargin = (bTu + i * 2);
      paramChatMessage.rightMargin = bTu;
      paramChatMessage.topMargin = (i * 4 + bTs);
      paramChatMessage.bottomMargin = 0;
      i = j - bTu - bTu;
      paramView.jdField_do.setLayoutParams(paramChatMessage);
    }
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    xmb.c localc = (xmb.c)parame;
    parame = (MessageForReplyText)paramChatMessage;
    if (parame.mSourceMsgInfo == null) {
      return;
    }
    Object localObject = BitmapFactory.decodeResource(this.mContext.getResources(), 2130838357);
    localObject = new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject);
    int i = parame.mSourceMsgInfo.mType;
    if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()) || (anlm.ayn()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        parame = paramView.getColorStateList(2131167326);
        localc.mText.setTextColor(parame);
        localc.JK.setTextColor(parame);
        localc.JL.setTextColor(parame);
        localc.Jm.setTextColor(parame);
        localc.d.setTextColor(parame);
        localc.e.setTextColor(parame);
        ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(parame.getDefaultColor(), PorterDuff.Mode.SRC_ATOP));
        localc.tv.setImageDrawable((Drawable)localObject);
        if (!paramChatMessage.isSend()) {
          break label294;
        }
      }
      label294:
      for (parame = paramView.getColorStateList(2131167325);; parame = paramView.getColorStateList(2131167324))
      {
        localc.mText.setLinkTextColor(parame);
        localc.d.setLinkTextColor(parame);
        localc.e.setLinkTextColor(parame);
        ImmersiveUtils.setAlpha(localc.JK, 0.5F);
        ImmersiveUtils.setAlpha(localc.Jm, 0.9F);
        ImmersiveUtils.setAlpha(localc.JL, 0.9F);
        ImmersiveUtils.setAlpha(localc.d, 0.9F);
        ImmersiveUtils.setAlpha(localc.e, 0.9F);
        return;
        parame = paramView.getColorStateList(2131167322);
        break;
      }
    }
    if (paramadxp.mTextColor == 0)
    {
      localc.mText.setTextColor(-16777216);
      localc.Jm.setTextColor(-16777216);
      localc.JL.setTextColor(-16777216);
      localc.JK.setTextColor(-16777216);
      localc.d.setTextColor(-16777216);
      localc.e.setTextColor(-16777216);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      localc.tv.setImageDrawable((Drawable)localObject);
      label407:
      if (paramadxp.mLinkColor != 0) {
        break label749;
      }
      parame = paramView.getResources().getColorStateList(2131167324);
      localc.mText.setLinkTextColor(parame);
      localc.d.setLinkTextColor(parame);
      localc.e.setLinkTextColor(parame);
    }
    for (;;)
    {
      ImmersiveUtils.setAlpha(localc.JL, 0.9F);
      ImmersiveUtils.setAlpha(localc.Jm, 0.9F);
      ImmersiveUtils.setAlpha(localc.d, 0.9F);
      ImmersiveUtils.setAlpha(localc.e, 0.9F);
      if ((!paramadxp.bRF) || (((ChatBackgroundManager)this.app.getManager(63)).a(this.mContext, this.sessionInfo, localc.mText.getCurrentTextColor(), 10000.0D * localc.b.cs) != 1)) {
        break;
      }
      parame = (ETTextView)localc.mText;
      float f2 = parame.getTextSize() * 3.0F / 16.0F;
      float f1 = f2;
      if (f2 > 25.0F) {
        f1 = 25.0F;
      }
      parame.setTextColor(-1);
      parame.setShadowLayer(f1, 0.0F, 0.0F, paramadxp.mStrokeColor);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localc.tv.setImageDrawable((Drawable)localObject);
      return;
      localc.mText.setTextColor(paramadxp.mTextColor);
      localc.Jm.setTextColor(paramadxp.mTextColor);
      localc.JL.setTextColor(paramadxp.mTextColor);
      localc.JK.setTextColor(paramadxp.mTextColor);
      localc.d.setTextColor(paramadxp.mTextColor);
      localc.e.setTextColor(paramadxp.mTextColor);
      ((Drawable)localObject).setColorFilter(new PorterDuffColorFilter(paramadxp.mTextColor, PorterDuff.Mode.SRC_ATOP));
      localc.tv.setImageDrawable((Drawable)localObject);
      break label407;
      label749:
      localc.mText.setLinkTextColor(paramadxp.mLinkColor);
      localc.d.setLinkTextColor(paramadxp.mLinkColor);
      localc.e.setLinkTextColor(paramadxp.mLinkColor);
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    paramChatMessage = aqhu.g(parame.E.getBackground());
    if (paramChatMessage == null) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyTextItemBuilder", 2, new Object[] { "color=", Integer.valueOf(paramInt1), " ", Integer.valueOf((0xFF0000 & paramInt1) >> 16), " ", Integer.valueOf((0xFF00 & paramInt1) >> 8), " ", Integer.valueOf(paramInt1 & 0xFF) });
      }
      if ((parame instanceof xmb.c))
      {
        paramChatMessage = ((xmb.c)parame).jdField_do;
        if (paramChatMessage != null) {
          paramChatMessage.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838355));
        }
      }
      return;
      paramInt2 = extractBgThemeColor(paramChatMessage);
      paramInt1 = paramInt2;
      if (!paramChatMessage.isRecycled())
      {
        paramChatMessage.recycle();
        paramInt1 = paramInt2;
      }
    }
  }
  
  public void b(BaseBubbleBuilder.e parame, ChatMessage paramChatMessage)
  {
    int i = 0;
    if (!(parame instanceof xmb.c)) {}
    xmb.c localc;
    do
    {
      do
      {
        do
        {
          return;
          localc = (xmb.c)parame;
        } while (!(paramChatMessage instanceof MessageForReplyText));
        paramChatMessage = (MessageForReplyText)paramChatMessage;
        parame = null;
        if (!TextUtils.isEmpty(paramChatMessage.sb)) {
          parame = paramChatMessage.sb;
        }
      } while ((parame == null) || (!(parame instanceof aofk)));
      paramChatMessage = (aofk)parame;
      parame = (aofk.a[])paramChatMessage.getSpans(0, parame.length(), aofk.a.class);
    } while ((parame.length <= 0) || (paramChatMessage.AF().length() != 0));
    int j = parame.length;
    while (i < j)
    {
      parame[i].setSize(ankt.dip2px(26.0F));
      i += 1;
    }
    localc.e.setText(paramChatMessage);
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Xmb$d.clear();
    super.destroy();
  }
  
  public void ei(View paramView)
  {
    if (wja.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForReplyText)wja.a(paramView);
      str1 = this.mContext.getString(2131690230);
      str2 = this.mContext.getString(2131690231);
    } while (!paramView.isSendFromLocal());
    aqha.a(this.mContext, 230, str1, str2, new xmh(this, paramView), new xmi(this)).show();
  }
  
  public static class a
  {
    Rect bl;
    int height;
    boolean isDynamic;
    float qp;
    float scale;
    URL url;
    int width;
  }
  
  static class b
  {
    String aVK;
    boolean bhJ;
    MessageForPic e;
    int textType;
    
    public b(MessageForPic paramMessageForPic, String paramString, int paramInt, boolean paramBoolean)
    {
      this.e = paramMessageForPic;
      this.aVK = paramString;
      this.textType = paramInt;
      this.bhJ = paramBoolean;
    }
  }
  
  class c
    extends xov.a
  {
    protected TextView JK;
    protected TextView JL;
    protected TextView Jm;
    protected ETTextView d;
    protected ViewGroup jdField_do;
    protected ETTextView e;
    protected BubbleImageView j;
    public int mType;
    protected ImageView tv;
    
    c() {}
  }
  
  static class d
  {
    private Map<Integer, LinkedList<View>> hO = new HashMap();
    
    View A(int paramInt)
    {
      LinkedList localLinkedList = (LinkedList)this.hO.get(Integer.valueOf(paramInt));
      if (localLinkedList == null) {
        return null;
      }
      return (View)localLinkedList.poll();
    }
    
    void clear()
    {
      this.hO.clear();
    }
    
    void q(int paramInt, View paramView)
    {
      LinkedList localLinkedList2 = (LinkedList)this.hO.get(Integer.valueOf(paramInt));
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        this.hO.put(Integer.valueOf(paramInt), localLinkedList1);
      }
      localLinkedList1.add(paramView);
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmb
 * JD-Core Version:    0.7.0.1
 */
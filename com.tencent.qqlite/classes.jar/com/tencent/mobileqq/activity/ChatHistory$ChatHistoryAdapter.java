package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import aea;
import aec;
import aed;
import aee;
import aeg;
import aeh;
import aei;
import aek;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.mobileqq.widget.PatchedTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlite.data.MarkFaceMessage;
import java.util.List;
import localpb.richMsg.RichMsg.PttRec;

public class ChatHistory$ChatHistoryAdapter
  extends CursorAdapter
{
  public static final int b = 2;
  public static final int c = 1;
  public static final int d = 0;
  public static final int e = 2;
  public static final int f = 1;
  public static final int g = 0;
  public int a;
  public Context a;
  private LayoutInflater a;
  private int h = 1000;
  private int i;
  
  public ChatHistory$ChatHistoryAdapter(ChatHistory paramChatHistory, Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramChatHistory.jdField_a_of_type_Float < 1.0F)
    {
      paramChatHistory.g = ((int)(100.0F * paramChatHistory.jdField_a_of_type_Float));
      paramChatHistory.f = ((int)(paramChatHistory.jdField_a_of_type_Float * 34.0F));
      paramChatHistory.h = ((int)(paramChatHistory.jdField_a_of_type_Float * 14.0F));
    }
    for (paramChatHistory.i = ((int)(paramChatHistory.jdField_a_of_type_Float * 15.0F));; paramChatHistory.i = ((int)(paramChatHistory.jdField_a_of_type_Float * 15.0F)))
    {
      paramChatHistory = paramContext.getResources().getDisplayMetrics();
      this.i = Math.min(paramChatHistory.widthPixels, paramChatHistory.heightPixels);
      return;
      paramChatHistory.g = ((int)(120.0F * paramChatHistory.jdField_a_of_type_Float));
      paramChatHistory.f = ((int)(paramChatHistory.jdField_a_of_type_Float * 34.0F));
      paramChatHistory.h = ((int)(paramChatHistory.jdField_a_of_type_Float * 14.0F));
    }
  }
  
  private int a(int paramInt)
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
    int j;
    if (paramInt >= 60) {
      j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g;
    }
    do
    {
      do
      {
        return j;
        if ((paramInt > 45) && (paramInt < 60)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 15 / 16 + (paramInt - 45) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        if ((paramInt > 30) && (paramInt <= 45)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 13 / 16 + (paramInt - 30) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 2 / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        if ((paramInt > 15) && (paramInt <= 30)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 9 / 16 + (paramInt - 15) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 4 / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        j = k;
      } while (paramInt <= 0);
      j = k;
    } while (paramInt > 15);
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * paramInt * 9 / 16 / 15 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
  }
  
  private String a(long paramLong)
  {
    Time localTime1 = new Time();
    Time localTime2 = new Time();
    localTime1.set(paramLong);
    localTime2.setToNow();
    if (localTime1.year != localTime2.year) {
      return localTime1.format("%Y-%m-%d %H:%M:%S");
    }
    if (localTime1.yearDay != localTime2.yearDay) {
      return localTime1.format("%m-%d %H:%M:%S");
    }
    return localTime1.format("%H:%M:%S");
  }
  
  private void a(ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2)
  {
    if (paramMarkFaceMessage == null)
    {
      a(paramImageView1, 0, null);
      return;
    }
    paramMarkFaceMessage = EmoticonUtils.a(paramMarkFaceMessage, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app);
    paramImageView2.setTag(paramMarkFaceMessage);
    int j;
    int k;
    if (paramMarkFaceMessage != null) {
      if (paramMarkFaceMessage.b())
      {
        j = 2;
        if (!paramMarkFaceMessage.a()) {
          break label127;
        }
        paramImageView2.setVisibility(0);
        paramImageView2.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130839022));
        k = j;
      }
    }
    for (;;)
    {
      paramImageView1.setMinimumHeight((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float * 100.0F));
      paramImageView1.setMinimumWidth((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float * 100.0F));
      a(paramImageView1, k, paramMarkFaceMessage);
      return;
      if (paramMarkFaceMessage.c())
      {
        j = 1;
        break;
        label127:
        k = j;
        if (j != 1) {
          continue;
        }
        paramImageView2.setVisibility(0);
        paramImageView2.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130837529));
        k = j;
        continue;
      }
      j = 0;
      break;
      k = 0;
    }
  }
  
  private void a(ImageViewParameter paramImageViewParameter)
  {
    Object localObject = PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramImageViewParameter.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    paramImageViewParameter.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    paramImageViewParameter.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    int j = paramImageViewParameter.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.msgtype;
    localObject = paramImageViewParameter.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.action;
    paramImageViewParameter.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new aeh(this, j, paramImageViewParameter, (String)localObject));
  }
  
  public void a()
  {
    super.changeCursor(null);
  }
  
  public void a(ImageView paramImageView, int paramInt, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if (paramPicEmoticonInfo == null) {
      paramImageView.setImageResource(2130837527);
    }
    do
    {
      do
      {
        return;
        if (paramInt != 2) {
          break label206;
        }
        if (paramPicEmoticonInfo.a()) {
          break;
        }
        paramPicEmoticonInfo = paramPicEmoticonInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float);
      } while (paramPicEmoticonInfo == null);
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
      paramImageView.setOnClickListener(null);
      return;
    } while (paramPicEmoticonInfo.a(true) == null);
    paramImageView.setOnClickListener(new aeg(this, paramPicEmoticonInfo));
    Object localObject = (View)paramImageView.getParent();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(0, paramImageView.getTag())))
    {
      paramImageView = EmosmUtils.getEmoticonSoundPath(paramPicEmoticonInfo.a.epId, paramPicEmoticonInfo.a.eId);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a((View)localObject, paramImageView);
      if (localObject == null) {
        break label243;
      }
    }
    label206:
    label243:
    for (paramImageView = (ImageView)((View)localObject).findViewById(2131296820);; paramImageView = null)
    {
      ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramImageView);
      return;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131296820);; localObject = null)
      {
        ChatHistory.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, (ImageView)localObject);
        ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramImageView, paramPicEmoticonInfo);
        return;
        if (paramInt == 1)
        {
          paramPicEmoticonInfo = paramPicEmoticonInfo.a();
          if (paramPicEmoticonInfo == null) {
            break;
          }
          paramImageView.setImageDrawable(paramPicEmoticonInfo);
          return;
        }
        if (paramInt != 0) {
          break;
        }
        paramImageView.setImageResource(2130837527);
        return;
      }
    }
  }
  
  public void a(MixedMsgLinearLayout paramMixedMsgLinearLayout, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageForMixedMsg.parse();
    int k = paramMessageForMixedMsg.msgElemList.size();
    int j = 0;
    while (j < k)
    {
      localObject1 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(j);
      if (((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).time == 0L)) {
        MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
      }
      j += 1;
    }
    paramMixedMsgLinearLayout.a(paramMessageForMixedMsg.msgElemList);
    Object localObject1 = new MixedImageOnclickListener();
    ((MixedImageOnclickListener)localObject1).a = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory);
    k = paramMessageForMixedMsg.msgElemList.size();
    j = 0;
    if (j < k)
    {
      Object localObject2 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(j);
      View localView = paramMixedMsgLinearLayout.getChildAt(j);
      Object localObject3;
      if ((localObject2 instanceof MessageForText))
      {
        localObject3 = (AnimationTextView)localView;
        ((AnimationTextView)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getColor(2131427492));
        ((AnimationTextView)localObject3).setTextSize(0, AIOUtils.a(16.0F, paramMixedMsgLinearLayout.getContext().getResources()));
        ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb);
      }
      for (;;)
      {
        localView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
        localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
        j += 1;
        break;
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = (MessageForPic)localObject2;
          localObject3 = (ChatThumbView)localView;
          URLDrawable localURLDrawable = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject2, (ChatThumbView)localObject3);
          ((ChatThumbView)localObject3).setTag(2131296318, localObject2);
          ((ChatThumbView)localObject3).setImageDrawable(localURLDrawable);
          ((ChatThumbView)localObject3).setOnClickListener((View.OnClickListener)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("ChatHistory", 2, "mixed type not support yet." + localObject2.getClass().getSimpleName());
        }
      }
    }
    paramMixedMsgLinearLayout.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
    paramMixedMsgLinearLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    String str1;
    switch (paramInt1)
    {
    default: 
      str1 = "ORDER BY time asc , longMsgIndex asc";
    }
    for (;;)
    {
      String str2 = MessageRecord.getTableName(paramString, paramInt1);
      paramString = MessageRecord.getOldTableName(paramString, paramInt1);
      str1 = "( msgtype " + MsgProxyUtils.b() + " and isValid=1 ) " + str1 + " limit " + paramInt2 + "," + String.valueOf(8);
      ThreadManager.b().post(new aei(this, str2, paramString, str1));
      return;
      str1 = "ORDER BY shmsgseq";
      continue;
      str1 = "ORDER BY shmsgseq";
    }
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    Object localObject1 = (aek)paramView.getTag();
    if (localObject1 == null)
    {
      localObject1 = new aek(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, null);
      paramView.setTag(localObject1);
    }
    for (;;)
    {
      String str1 = MessageRecord.getTableName(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int);
      ((aek)localObject1).a = ((MessageRecord)ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).a(MessageRecord.class, str1, paramCursor));
      if (((aek)localObject1).a == null) {
        if (QLog.isColorLevel()) {
          QLog.w("ChatHistory", 2, "bindView message is null !!");
        }
      }
      label101:
      TextView localTextView1;
      PatchedTextView localPatchedTextView;
      ImageView localImageView2;
      int k;
      label621:
      String str2;
      label974:
      label1006:
      label1012:
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().a(((aek)localObject1).a.frienduin, ((aek)localObject1).a.istroop, ((aek)localObject1).a);
          long l3 = paramCursor.getLong(0);
          ((aek)localObject1).a.setId(l3);
          TextView localTextView2 = (TextView)paramView.findViewById(2131296814);
          localTextView1 = (TextView)paramView.findViewById(2131296815);
          TextView localTextView3 = (TextView)paramView.findViewById(2131296816);
          localPatchedTextView = (PatchedTextView)paramView.findViewById(2131296817);
          localImageView2 = (ImageView)paramView.findViewById(2131296818);
          MixedMsgLinearLayout localMixedMsgLinearLayout = (MixedMsgLinearLayout)paramView.findViewById(2131296823);
          ImageView localImageView1 = (ImageView)paramView.findViewById(2131296819);
          ImageView localImageView4 = (ImageView)paramView.findViewById(2131296821);
          Button localButton = (Button)paramView.findViewById(2131296822);
          ImageView localImageView3 = (ImageView)paramView.findViewById(2131296820);
          localImageView3.setVisibility(8);
          localTextView2.setVisibility(8);
          localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
          String str3 = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
          String str4 = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
          j = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
          int m = paramCursor.getInt(paramCursor.getColumnIndex("issend"));
          k = paramCursor.getInt(paramCursor.getColumnIndex("time"));
          int n;
          if ((paramCursor.getColumnIndex("versionCode") < 0) || (paramCursor.getInt(paramCursor.getColumnIndex("versionCode")) <= 0))
          {
            str1 = paramCursor.getString(paramCursor.getColumnIndex("msg"));
            n = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
            str1 = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, j, n, str1, m).msg;
            Object localObject2 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(8);
            TroopInfo localTroopInfo = ((FriendsManagerImp)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b);
            if ((localTroopInfo != null) && (localTroopInfo.cGroupRankSysFlag == 1) && (localTroopInfo.cGroupRankUserFlag == 1))
            {
              localObject2 = ((FriendsManagerImp)localObject2).a(str3, str4, paramContext);
              if ((localObject2 != null) && (((String)localObject2).length() > 0))
              {
                localTextView2.setVisibility(0);
                localTextView2.setText((CharSequence)localObject2);
              }
            }
            if (!AnonymousChatHelper.a(((aek)localObject1).a)) {
              break label974;
            }
            localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getString(2131362568) + AnonymousChatHelper.a(((aek)localObject1).a).b);
            localTextView2.setVisibility(8);
            localTextView3.setText(a(k * 1000L));
            k = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
            if (k != 32768) {
              break label1006;
            }
          }
          for (j = 1;; j = 0)
          {
            for (;;)
            {
              if (j != 0) {
                localPatchedTextView.setMaxWidth((int)(paramContext.getResources().getDisplayMetrics().widthPixels - 70.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float));
              }
              localImageView1.setVisibility(8);
              localPatchedTextView.setVisibility(8);
              localImageView2.setVisibility(8);
              localImageView4.setVisibility(8);
              localButton.setVisibility(8);
              localMixedMsgLinearLayout.setVisibility(8);
              localPatchedTextView.setOnTouchListener(null);
              localPatchedTextView.setOnLongClickListener(null);
              localPatchedTextView.setOnClickListener(null);
              localButton.setOnClickListener(null);
              n = paramCursor.getInt(getCursor().getColumnIndex("msgtype"));
              if (n != -2007) {
                break label1012;
              }
              localImageView1.setVisibility(0);
              localPatchedTextView.setVisibility(8);
              localImageView2.setVisibility(8);
              localImageView4.setVisibility(8);
              localButton.setVisibility(8);
              localImageView1.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
              localImageView1.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
              paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              localImageView1.setTag(str3 + l3);
              localImageView3.setTag(null);
              try
              {
                a(localImageView1, (MarkFaceMessage)MessagePkgUtils.a(paramView), localImageView3);
                return;
              }
              catch (Exception paramView)
              {
                paramView.printStackTrace();
                a(localImageView1, null, localImageView3);
                return;
              }
              try
              {
                str1 = new String(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")), "UTF-8");
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
                str2 = "";
              }
            }
            break;
            localTextView1.setText(ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory), MsgUtils.a(m), str4));
            break label621;
          }
          long l1;
          if (n == -2010)
          {
            localImageView1.setVisibility(8);
            localPatchedTextView.setVisibility(0);
            localImageView2.setVisibility(8);
            localImageView4.setVisibility(8);
            localButton.setVisibility(8);
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
            if ((str2 == null) || (str2.length() <= 0) || (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b(str2.toString()))) {
              break label3227;
            }
            paramContext = str2.split("\026")[1].split("\\|");
            paramCursor = paramContext[0];
            if (paramContext.length >= 2) {
              break label2759;
            }
            j = 1;
            long l2 = 0L;
            l1 = l2;
            if (paramContext != null)
            {
              l1 = l2;
              if (paramContext.length > 1) {
                if (paramContext[1] != null) {
                  break label2773;
                }
              }
            }
          }
          for (paramContext = "0";; paramContext = paramContext[1])
          {
            l1 = Long.parseLong(paramContext);
            switch (j)
            {
            default: 
              return;
            case 0: 
              localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131363572));
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
              return;
              if (n == -2011)
              {
                paramView = StructMsgFactory.a(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")));
                paramView = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramView);
                if (TextUtils.isEmpty(paramView)) {
                  break label101;
                }
                localPatchedTextView.setText(paramView);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                return;
              }
              if ((n == -2000) || (n == -20000) || (n == -3004) || (n == -3005) || (n == -3000) || (n == -3001))
              {
                if ((((aek)localObject1).a != null) && ((((aek)localObject1).a instanceof MessageForPic)))
                {
                  paramView = (MessageForPic)((aek)localObject1).a;
                  paramView.parse();
                  paramContext = new ImageViewParameter();
                  localImageView1.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                  localImageView1.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                  paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramView;
                  paramContext.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localImageView1);
                  if (QLog.isColorLevel()) {
                    QLog.d("history", 2, "bindView pic.path:" + paramView.path + ",pic.uuid:" + paramView.uuid);
                  }
                  if ((paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) || (paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.path == null)) {
                    break label101;
                  }
                  a(paramContext);
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break label101;
                }
                QLog.d("history", 2, "holy shit,not messageforpicuniseq:" + ((aek)localObject1).a.uniseq + ",dbid:" + ((aek)localObject1).a.getId() + "istroop:" + ((aek)localObject1).a.istroop + ",msgtype:" + ((aek)localObject1).a.msgtype);
                return;
              }
              if (n == -2002)
              {
                localObject1 = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramContext = new RichMsg.PttRec();
                try
                {
                  paramContext.mergeFrom((byte[])localObject1);
                  j = 1;
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    j = 0;
                    localException2.printStackTrace();
                  }
                  localButton.setText(String.valueOf(j) + "\"");
                  localButton.setPadding(m, 0, a(j), 0);
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo == null) {
                    break label2019;
                  }
                }
                if (j == 0) {
                  break label1078;
                }
                paramCursor = paramContext.localPath.get();
                l1 = paramContext.size.get();
                m = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.h;
                j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.i;
                localButton.setTag(paramCursor + str3 + l3);
                localButton.setVisibility(0);
                localButton.setText("");
                localButton.setText(null);
                localButton.setCompoundDrawables(null, null, null, null);
                localButton.setPadding(m, 0, j, 0);
                localButton.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                localButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                k = paramContext.voiceLength.get();
                j = k;
                if (k <= 0) {
                  j = QQRecorder.a(paramCursor);
                }
                if ((!paramCursor.startsWith(AppConstants.as)) || (j <= 0))
                {
                  localButton.setCompoundDrawables(null, null, null, null);
                  localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131363413) + "]");
                  localButton.setOnClickListener(null);
                  return;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(0, localButton.getTag())) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(paramView, paramCursor);
                }
                for (;;)
                {
                  localButton.setOnClickListener(new aea(this, j, paramCursor));
                  return;
                  paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839253);
                  paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
                  localButton.setCompoundDrawables(paramView, null, null, null);
                  if (l1 <= 0L) {
                    localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131363414) + "]");
                  }
                }
              }
              if (n == -1035)
              {
                localMixedMsgLinearLayout.setVisibility(0);
                a(localMixedMsgLinearLayout, (MessageForMixedMsg)localException2.a);
                return;
              }
              if (n == -2017)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(MsgUtils.a(null));
                return;
              }
              if (n == -2020)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnClickListener(new aec(this, str3));
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                if (MsgUtils.a(m))
                {
                  localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().getString(2131362968, new Object[] { ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).d }));
                  return;
                }
                localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().getString(2131362967));
                return;
              }
              if (n == -3008)
              {
                localPatchedTextView.setText(BaseApplicationImpl.getContext().getString(2131362031) + "\"" + str2 + "\"");
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                return;
              }
              if (n == -2022)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131364417));
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                return;
              }
              if (n == -5002)
              {
                if ((localException2.a != null) && ((localException2.a instanceof MessageForIncompatibleGrayTips)))
                {
                  paramView = (MessageForIncompatibleGrayTips)localException2.a;
                  paramView.parse();
                  localPatchedTextView.setText(paramView.msg);
                  localPatchedTextView.setVisibility(0);
                  paramCursor = paramView.url;
                  paramContext = new SpannableString(paramView.msg);
                  paramCursor = new aed(this, paramCursor, str3);
                  paramContext.setSpan(new ForegroundColorSpan(2131427331), paramView.linkStart, paramView.linkEnd, 33);
                  paramContext.setSpan(paramCursor, paramView.linkStart, paramView.linkEnd, 33);
                  localPatchedTextView.setText(paramContext);
                  localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
                  localPatchedTextView.setHighlightColor(17170445);
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break label101;
                }
                QLog.d("history", 2, "holy shit,not MessageForIncompatibleGrayTipsuniseq:" + localException2.a.uniseq + ",dbid:" + localException2.a.getId() + "istroop:" + localException2.a.istroop + ",msgtype:" + localException2.a.msgtype);
                return;
              }
              if (n != -2025) {
                break label1078;
              }
              paramView = new MessageForQQWalletMsg();
              paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramView.parse();
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(paramView.getMsgSummary());
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
              return;
              j = Integer.valueOf(paramContext[2]).intValue();
              break label1136;
            }
          }
          localImageView1.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
          localImageView1.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
          return;
          j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.h;
          k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.i;
          localButton.setTag(paramCursor + str3 + l3);
          localButton.setVisibility(0);
          localButton.setText("");
          localButton.setText(null);
          localButton.setCompoundDrawables(null, null, null, null);
          localButton.setPadding(j, 0, k, 0);
          localButton.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
          localButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
          k = QQRecorder.a(paramCursor);
          if ((!paramCursor.startsWith(AppConstants.as)) || (k <= 0))
          {
            localButton.setCompoundDrawables(null, null, null, null);
            localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131363413) + "]");
            localButton.setOnClickListener(null);
            return;
          }
          localButton.setText(String.valueOf(k) + "\"");
          localButton.setPadding(j, 0, a(k), 0);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(0, localButton.getTag()))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(paramView, paramCursor);
          }
          for (;;)
          {
            localButton.setOnClickListener(new aee(this, k, paramCursor));
            return;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839253);
            paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
            localButton.setCompoundDrawables(paramView, null, null, null);
            if (l1 <= 0L) {
              localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131363414) + "]");
            }
          }
          localImageView1.setVisibility(0);
          localImageView1.setOnClickListener(null);
          localImageView1.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
          localImageView1.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
          localImageView1.setImageResource(2130837698);
          return;
          j = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
          localPatchedTextView.setVisibility(0);
          if (!MessageUtils.a(n))
          {
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Aej);
          }
          if (!String.valueOf(AppConstants.Y).equals(str3)) {
            break;
          }
          paramView = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, str2, str4, j);
        } while (paramView == null);
        localPatchedTextView.setText(paramView.message);
      } while (k != 32769);
      label1078:
      label1136:
      localTextView1.setText(paramView.troopCode);
      label2019:
      return;
      label2759:
      label2773:
      if (-2008 == j)
      {
        localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131364075));
        return;
      }
      label3227:
      int j = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
      if ((localImageView2 != null) && (j == 32768)) {
        localImageView2.setVisibility(0);
      }
      localPatchedTextView.setText(new QQText(str2, 13, 32, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int));
      return;
    }
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      if (getCursor() != null) {
        getCursor().deactivate();
      }
      super.changeCursor(paramCursor);
      notifyDataSetChanged();
    }
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903109, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */
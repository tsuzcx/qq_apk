package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ciq;
import cis;
import cit;
import civ;
import ciw;
import cix;
import ciz;
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
import com.tencent.mobileqq.content.Message;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPlayTogetherResult.PlayTogetherResultInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.mobileqq.widget.PatchedTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
    paramMarkFaceMessage = EmoticonUtils.a(paramMarkFaceMessage, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
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
        paramImageView2.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130839146));
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
        paramImageView2.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130837630));
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
    paramImageViewParameter.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new ciw(this, j, paramImageViewParameter, (String)localObject));
  }
  
  public void a()
  {
    super.changeCursor(null);
  }
  
  public void a(ImageView paramImageView, int paramInt, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if (paramPicEmoticonInfo == null) {
      paramImageView.setImageResource(2130837628);
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
    paramImageView.setOnClickListener(new civ(this, paramPicEmoticonInfo));
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
    for (paramImageView = (ImageView)((View)localObject).findViewById(2131231353);; paramImageView = null)
    {
      ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramImageView);
      return;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131231353);; localObject = null)
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
        paramImageView.setImageResource(2130837628);
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
        ((AnimationTextView)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getColor(2131362093));
        ((AnimationTextView)localObject3).setTextSize(0, AIOUtils.a(16.0F, paramMixedMsgLinearLayout.getContext().getResources()));
        ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb);
      }
      for (;;)
      {
        localView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
        localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
        j += 1;
        break;
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = (MessageForPic)localObject2;
          localObject3 = (ChatThumbView)localView;
          URLDrawable localURLDrawable = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject2, (ChatThumbView)localObject3);
          ((ChatThumbView)localObject3).setTag(2131230791, localObject2);
          ((ChatThumbView)localObject3).setImageDrawable(localURLDrawable);
          ((ChatThumbView)localObject3).setOnClickListener((View.OnClickListener)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("ChatHistory", 2, "mixed type not support yet." + localObject2.getClass().getSimpleName());
        }
      }
    }
    paramMixedMsgLinearLayout.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
    paramMixedMsgLinearLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    String str = "";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Message.a);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localStringBuilder.append('/');
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localStringBuilder.append('/');
      localStringBuilder.append(paramString);
      paramString = Uri.parse(localStringBuilder.toString());
      str = "( msgtype " + MsgProxyUtils.b() + " and isValid=1 ) " + str + " limit " + paramInt2 + "," + String.valueOf(8);
      ThreadManager.b().post(new cix(this, paramString, str));
      return;
      localStringBuilder.append("troop_local_history");
      str = "ORDER BY shmsgseq";
      continue;
      localStringBuilder.append("friend_local_history");
      str = "ORDER BY time asc , longMsgIndex asc";
      continue;
      localStringBuilder.append("discussion_local_history");
      str = "ORDER BY shmsgseq";
    }
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    Object localObject2 = (ciz)paramView.getTag();
    if (localObject2 == null)
    {
      localObject2 = new ciz(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, null);
      paramView.setTag(localObject2);
    }
    label1045:
    label1103:
    for (;;)
    {
      String str1 = MessageRecord.getTableName(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int);
      ((ciz)localObject2).a = ((MessageRecord)ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).a(MessageRecord.class, str1, paramCursor));
      if (((ciz)localObject2).a == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ChatHistory", 2, "bindView message is null !!");
        }
        label101:
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((ciz)localObject2).a.frienduin, ((ciz)localObject2).a.istroop, ((ciz)localObject2).a);
      long l3 = paramCursor.getLong(0);
      ((ciz)localObject2).a.setId(l3);
      TextView localTextView2 = (TextView)paramView.findViewById(2131231347);
      TextView localTextView1 = (TextView)paramView.findViewById(2131231348);
      TextView localTextView3 = (TextView)paramView.findViewById(2131231349);
      PatchedTextView localPatchedTextView = (PatchedTextView)paramView.findViewById(2131231350);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131231351);
      MixedMsgLinearLayout localMixedMsgLinearLayout = (MixedMsgLinearLayout)paramView.findViewById(2131231356);
      ChatThumbView localChatThumbView = (ChatThumbView)paramView.findViewById(2131231352);
      ImageView localImageView3 = (ImageView)paramView.findViewById(2131231354);
      Button localButton = (Button)paramView.findViewById(2131231355);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131231353);
      localImageView2.setVisibility(8);
      localTextView2.setVisibility(8);
      localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
      String str3 = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
      String str4 = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
      int j = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
      int m = paramCursor.getInt(paramCursor.getColumnIndex("issend"));
      int k = paramCursor.getInt(paramCursor.getColumnIndex("time"));
      int n;
      String str2;
      if ((paramCursor.getColumnIndex("versionCode") < 0) || (paramCursor.getInt(paramCursor.getColumnIndex("versionCode")) <= 0))
      {
        str1 = paramCursor.getString(paramCursor.getColumnIndex("msg"));
        n = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
        str2 = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, j, n, str1, m).msg;
        if ((!str2.equals("你的QQ暂不支持查看视频短片，请期待后续版本")) && (!str2.equals("[视频]你的QQ暂不支持查看视频短片，请升级到最新版本后查看。"))) {
          break label3064;
        }
      }
      Object localObject1;
      label979:
      label2393:
      label2407:
      label3064:
      for (str1 = "[视频] 您的QQ版本暂不支持查看视频短片。";; localObject1 = str2)
      {
        Object localObject3 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        TroopInfo localTroopInfo = ((FriendsManagerImp)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_JavaLangString);
        if ((localTroopInfo != null) && (localTroopInfo.cGroupRankSysFlag == 1) && (localTroopInfo.cGroupRankUserFlag == 1))
        {
          localObject3 = ((FriendsManagerImp)localObject3).a(str3, str4);
          if ((localObject3 != null) && (((String)localObject3).length() > 0))
          {
            localTextView2.setVisibility(0);
            localTextView2.setText((CharSequence)localObject3);
          }
        }
        localTextView2.setVisibility(8);
        localTextView1.setText(ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory), MsgUtils.a(m), str4));
        localTextView3.setText(a(k * 1000L));
        k = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
        if (k == 32768) {}
        for (j = 1;; j = 0)
        {
          for (;;)
          {
            if (j != 0) {
              localPatchedTextView.setMaxWidth((int)(paramContext.getResources().getDisplayMetrics().widthPixels - 70.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float));
            }
            localChatThumbView.setVisibility(8);
            localPatchedTextView.setVisibility(8);
            localImageView1.setVisibility(8);
            localImageView3.setVisibility(8);
            localButton.setVisibility(8);
            localMixedMsgLinearLayout.setVisibility(8);
            localPatchedTextView.setOnTouchListener(null);
            localPatchedTextView.setOnLongClickListener(null);
            localPatchedTextView.setOnClickListener(null);
            localButton.setOnClickListener(null);
            n = paramCursor.getInt(getCursor().getColumnIndex("msgtype"));
            if (n != -2007) {
              break label979;
            }
            localChatThumbView.setVisibility(0);
            localPatchedTextView.setVisibility(8);
            localImageView1.setVisibility(8);
            localImageView3.setVisibility(8);
            localButton.setVisibility(8);
            localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
            localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
            paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
            localChatThumbView.setTag(str3 + l3);
            localImageView2.setTag(null);
            try
            {
              a(localChatThumbView, (MarkFaceMessage)MessagePkgUtils.a(paramView), localImageView2);
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              a(localChatThumbView, null, localImageView2);
              return;
            }
            try
            {
              str1 = new String(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")), "UTF-8");
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              localObject1 = "";
            }
          }
          break;
        }
        long l1;
        if (n == -2010)
        {
          localChatThumbView.setVisibility(8);
          localPatchedTextView.setVisibility(0);
          localImageView1.setVisibility(8);
          localImageView3.setVisibility(8);
          localButton.setVisibility(8);
          localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
          localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b(((String)localObject1).toString()))) {
            break label2861;
          }
          paramContext = str2.split("\026")[1].split("\\|");
          paramCursor = paramContext[0];
          if (paramContext.length >= 2) {
            break label2393;
          }
          j = 1;
          if (paramContext.length >= 5) {
            localObject2 = paramContext[4];
          }
          if (paramContext.length >= 6) {
            TransfileUtile.a(((String)localObject1).toString());
          }
          long l2 = 0L;
          l1 = l2;
          if (paramContext != null)
          {
            l1 = l2;
            if (paramContext.length > 1) {
              if (paramContext[1] != null) {
                break label2407;
              }
            }
          }
        }
        for (paramContext = "0";; paramContext = paramContext[1])
        {
          l1 = Long.parseLong(paramContext);
          Uri.parse(paramCursor);
          switch (j)
          {
          default: 
            return;
          case 0: 
            localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131561540));
            localPatchedTextView.setVisibility(0);
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
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
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
              return;
            }
            if (n == -1038)
            {
              paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramContext = new MessageForPlayTogetherResult.PlayTogetherResultInfo();
              paramContext.fromBytes(paramView);
              localPatchedTextView.setText(paramContext.mGameName);
              return;
            }
            if ((n == -2000) || (n == -20000) || (n == -3004) || (n == -3005) || (n == -3000) || (n == -3001))
            {
              if ((((ciz)localObject2).a != null) && ((((ciz)localObject2).a instanceof MessageForPic)))
              {
                paramView = (MessageForPic)((ciz)localObject2).a;
                paramView.parse();
                paramContext = new ImageViewParameter();
                localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
                localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
                paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramView;
                paramContext.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localChatThumbView);
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
              QLog.d("history", 2, "holy shit,not messageforpicuniseq:" + ((ciz)localObject2).a.uniseq + ",dbid:" + ((ciz)localObject2).a.getId() + "istroop:" + ((ciz)localObject2).a.istroop + ",msgtype:" + ((ciz)localObject2).a.msgtype);
              return;
            }
            if (n == -2002)
            {
              localObject2 = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramContext = new RichMsg.PttRec();
              try
              {
                paramContext.mergeFrom((byte[])localObject2);
                j = 1;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  j = 0;
                  localException2.printStackTrace();
                }
                localButton.setText(String.valueOf(k) + "\"");
                localButton.setPadding(j, 0, a(k), 0);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo == null) {
                  break label2048;
                }
              }
              if (j == 0) {
                break label1045;
              }
              paramCursor = paramContext.localPath.get();
              l1 = paramContext.size.get();
              j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.h;
              k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.i;
              localButton.setTag(paramCursor + str3 + l3);
              localButton.setVisibility(0);
              localButton.setText("");
              localButton.setText(null);
              localButton.setCompoundDrawables(null, null, null, null);
              localButton.setPadding(j, 0, k, 0);
              localButton.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
              localButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
              k = QQRecorder.a(paramCursor);
              if ((!paramCursor.startsWith(AppConstants.an)) || (k <= 0))
              {
                localButton.setCompoundDrawables(null, null, null, null);
                localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131561427) + "]");
                localButton.setOnClickListener(null);
                return;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(0, localButton.getTag())) {
                this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(paramView, paramCursor);
              }
              for (;;)
              {
                localButton.setOnClickListener(new ciq(this, k, paramCursor));
                return;
                paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839780);
                paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
                localButton.setCompoundDrawables(paramView, null, null, null);
                if (l1 <= 0L) {
                  localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131563198) + "]");
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
              localPatchedTextView.setOnClickListener(new cis(this, str3));
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
              if (MsgUtils.a(m))
              {
                localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563283, new Object[] { ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).d }));
                return;
              }
              localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562920));
              return;
            }
            if (n != -3008) {
              break label1045;
            }
            localPatchedTextView.setText(BaseApplicationImpl.getContext().getString(2131558773) + "\"" + (String)localObject1 + "\"");
            localPatchedTextView.setVisibility(0);
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
            return;
            j = Integer.valueOf(paramContext[2]).intValue();
            break label1103;
          }
        }
        localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
        localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
        return;
        j = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.h;
        k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.i;
        localButton.setTag(paramCursor + str3 + l3);
        localButton.setVisibility(0);
        localButton.setText("");
        localButton.setText(null);
        localButton.setCompoundDrawables(null, null, null, null);
        localButton.setPadding(j, 0, k, 0);
        localButton.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
        localButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
        k = QQRecorder.a(paramCursor);
        if ((!paramCursor.startsWith(AppConstants.an)) || (k <= 0))
        {
          localButton.setCompoundDrawables(null, null, null, null);
          localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131561427) + "]");
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
          localButton.setOnClickListener(new cit(this, k, paramCursor));
          return;
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839780);
          paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
          localButton.setCompoundDrawables(paramView, null, null, null);
          if (l1 <= 0L) {
            localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131563198) + "]");
          }
        }
        localChatThumbView.setVisibility(0);
        localChatThumbView.setOnClickListener(null);
        localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
        localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
        localChatThumbView.setImageResource(2130837753);
        return;
        j = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
        localPatchedTextView.setVisibility(0);
        if (!MessageUtils.a(n))
        {
          localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
          localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Ciy);
        }
        if (String.valueOf(AppConstants.U).equals(str3))
        {
          paramView = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str2, str4, j);
          if (paramView == null) {
            break;
          }
          localPatchedTextView.setText(paramView.message);
          if (k != 32769) {
            break;
          }
          localTextView1.setText(paramView.troopCode);
          return;
        }
        if (-2008 == j)
        {
          localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131561552));
          return;
        }
        j = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
        if ((localImageView1 != null) && (j == 32768)) {
          localImageView1.setVisibility(0);
        }
        localPatchedTextView.setText(new QQText((CharSequence)localObject1, 13, 32, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int));
        return;
      }
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
    return this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903130, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPlayTogetherResult;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ItemBuilderFactory
{
  private static final int A = 25;
  private static final int B = 26;
  private static final int C = 27;
  private static final int D = 28;
  public static final int a = 29;
  public static CharSequence a;
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  private static final int f = 4;
  private static final int g = 5;
  private static final int h = 6;
  private static final int i = 7;
  private static final int j = 8;
  private static final int k = 9;
  private static final int l = 10;
  private static final int m = 11;
  private static final int n = 12;
  private static final int o = 13;
  private static final int p = 14;
  private static final int q = 15;
  private static final int r = 16;
  private static final int s = 17;
  private static final int t = 18;
  private static final int u = 19;
  private static final int v = 20;
  private static final int w = 21;
  private static final int x = 22;
  private static final int y = 23;
  private static final int z = 24;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  ActivityChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder;
  AppSharePicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder;
  EnterTroopChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder;
  FileItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder;
  GrayTipsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder;
  LocationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder;
  LongMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder;
  MarketFaceItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder;
  MixedMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder;
  MyEnterTroopChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder;
  PAMultiItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder;
  PASingleItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder;
  PATextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder;
  PicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder;
  PlayTogetherResultItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPlayTogetherResultItemBuilder;
  PttItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder;
  QzoneFeedItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder;
  RichStatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder;
  ShakeItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder;
  StructTroopNotificationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder;
  StructingMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder;
  TextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder;
  TextSignatureItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTextSignatureItemBuilder;
  TextTranslationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder;
  TroopFileItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder;
  TroopUnreadTipsChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder;
  VideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ItemBuilderFactory(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText))
    {
      if (((MessageForText)paramChatMessage).locationUrl != null)
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559156);
        return 10;
      }
      if (!paramChatMessage.isSend())
      {
        if ((paramChatMessage.msg.equals("你的QQ暂不支持查看视频短片，请期待后续版本")) || (paramChatMessage.msg.equals("[视频]你的QQ暂不支持查看视频短片，请升级到最新版本后查看。")))
        {
          paramChatMessage.msg = "[视频] 您的QQ版本暂不支持查看视频短片。";
          ((MessageForText)paramChatMessage).sb = "[视频] 您的QQ版本暂不支持查看视频短片。";
        }
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559163);
        return 9;
      }
      if ((paramChatMessage.isSend()) && ((paramChatMessage.msg.equals("你的QQ暂不支持查看视频短片，请期待后续版本")) || (paramChatMessage.msg.equals("[视频]你的QQ暂不支持查看视频短片，请升级到最新版本后查看。"))))
      {
        paramChatMessage.msg = "[视频] 您的QQ版本暂不支持查看视频短片。";
        ((MessageForText)paramChatMessage).sb = "[视频] 您的QQ版本暂不支持查看视频短片。";
      }
    }
    do
    {
      do
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559163);
        return 9;
        if ((paramChatMessage instanceof MessageForGrayTips))
        {
          jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559155);
          return 15;
        }
        if ((paramChatMessage instanceof MessageForSafeGrayTips))
        {
          jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559155);
          return 15;
        }
        if ((paramChatMessage instanceof MessageForPic))
        {
          if (((MessageForPic)paramChatMessage).isMixed) {
            return 24;
          }
          jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559158);
          return 1;
        }
        if ((paramChatMessage instanceof MessageForPtt))
        {
          jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559159);
          return 2;
        }
        if ((paramChatMessage instanceof MessageForFile))
        {
          jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559154);
          return 3;
        }
        if ((paramChatMessage instanceof MessageForVideo))
        {
          jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559164);
          return 11;
        }
        if ((paramChatMessage instanceof MessageForMarketFace))
        {
          jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559153);
          return 12;
        }
        if ((paramChatMessage instanceof MessageForRichState))
        {
          jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559162);
          if (((MessageForRichState)paramChatMessage).isRickSignState) {
            return 13;
          }
          return 14;
        }
        if (!(paramChatMessage instanceof MessageForPubAccount)) {
          break;
        }
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559160);
        paramChatMessage = ((MessageForPubAccount)paramChatMessage).mPAMessage;
      } while ((paramChatMessage == null) || (paramChatMessage.items == null) || (paramChatMessage.items.size() == 0));
      if (((PAMessage.Item)paramChatMessage.items.get(0)).cover != null)
      {
        if (paramChatMessage.items.size() == 1) {
          return 6;
        }
        return 7;
      }
      return 8;
      if ((paramChatMessage instanceof MessageForStructing))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559157);
        return 5;
      }
      if ((paramChatMessage instanceof MessageForFunnyFace))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559153);
        return 19;
      }
      if ((paramChatMessage instanceof MessageForPlayTogetherResult))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559157);
        return 20;
      }
      if (((paramChatMessage instanceof MessageForLongMsg)) && (paramChatMessage.msgtype != -1036))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559157);
        return 17;
      }
      if (((paramChatMessage instanceof MessageForMixedMsg)) || ((paramChatMessage != null) && (paramChatMessage.msgtype == -1036)))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559157);
        return 18;
      }
      if ((paramChatMessage instanceof MessageForQzoneFeed))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559161);
        return 21;
      }
      if ((paramChatMessage instanceof MessageForActivity))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559157);
        return 16;
      }
      if ((paramChatMessage instanceof MessageForEnterTroop))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559157);
        return 22;
      }
      if ((paramChatMessage instanceof MessageForMyEnterTroop))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559157);
        return 23;
      }
      if ((paramChatMessage instanceof MessageForTroopFile))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559157);
        return 25;
      }
      if ((paramChatMessage instanceof MessageForShakeWindow))
      {
        jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559157);
        return 26;
      }
    } while (!(paramChatMessage instanceof MessageForTroopUnreadTips));
    jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559157);
    return 27;
  }
  
  public ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    switch (a(paramChatMessage))
    {
    case 4: 
    case 19: 
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder = new TextTranslationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: TextItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder;
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder = new FileItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: FileItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder = new PicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: PicItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder;
    case 24: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder = new AppSharePicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: AppSharePicItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder;
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder = new PttItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: PttItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder;
    case 15: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder = new GrayTipsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: GrayTipsItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder;
    case 6: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder = new PASingleItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: PASingleItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder;
    case 7: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder = new PAMultiItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: PAMultiItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder;
    case 8: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder = new PATextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: PATextItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder;
    case 5: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder = new StructingMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: StructingMsgItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder;
    case 10: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder = new LocationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: LocationItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder;
    case 11: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder = new VideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: VideoItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder;
    case 13: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder = new RichStatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        paramChatMessage = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
        if (paramChatMessage != null) {
          paramChatMessage.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: RichStatItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder;
    case 14: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextSignatureItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextSignatureItemBuilder = new TextSignatureItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: TextSignatureItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextSignatureItemBuilder;
    case 9: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder = new TextTranslationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: TextTranslationItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder;
    case 12: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder = new MarketFaceItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: MarketFaceItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder;
    case 16: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder = new ActivityChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: ActivityChatItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder;
    case 22: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder = new EnterTroopChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: EnterTroopChatItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder;
    case 23: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder = new MyEnterTroopChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: MyEnterTroopChatItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder;
    case 17: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder = new LongMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: LongMsgItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder;
    case 18: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder = new MixedMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: MixedMsgItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder;
    case 20: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPlayTogetherResultItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPlayTogetherResultItemBuilder = new PlayTogetherResultItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: PlayTogetherResultItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPlayTogetherResultItemBuilder;
    case 21: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder = new QzoneFeedItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: QzoneFeedItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder;
    case 25: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder = new TroopFileItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: TroopFileItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder;
    case 26: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder = new ShakeItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: ShakeItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder;
    case 27: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder = new TroopUnreadTipsChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: TroopUnreadTipsChatItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder = new StructTroopNotificationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoMonitor", 2, "ItemBuilder is: StructTroopNotificationItemBuilder");
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */
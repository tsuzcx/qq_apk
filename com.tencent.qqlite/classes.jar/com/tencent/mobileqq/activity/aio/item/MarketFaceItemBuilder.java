package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bvm;
import bvn;
import bvr;
import bvs;
import bvt;
import bvu;
import bvv;
import bvw;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.MagicFaceDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlite.data.MarkFaceMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;

public class MarketFaceItemBuilder
  extends BaseBubbleBuilder
  implements MediaPlayerManager.Callback
{
  public static long a = 0L;
  public static ChatMessage a;
  public static PicEmoticonInfo a;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 1;
  public static final int l = 2;
  public static int m = 1;
  bvu jdField_a_of_type_Bvu = new bvm(this);
  public EmojiManager a;
  MagicFaceDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonMagicFaceDownloadListener = new bvn(this);
  public List a;
  public Context b;
  public String b;
  public int n = 320;
  public int o = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
  
  static
  {
    jdField_a_of_type_Long = 0L;
  }
  
  public MarketFaceItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_b_of_type_JavaLangString = "MarketFaceItemBuilder";
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager = ((EmojiManager)paramQQAppInterface.getManager(39));
  }
  
  private URLDrawable a(ChatMessage paramChatMessage, bvv parambvv, Context paramContext)
  {
    if (parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.b()) {
      if (parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) {
        if (b(paramChatMessage))
        {
          parambvv = parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.b();
          paramChatMessage = parambvv;
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| local existBig getSoundBigDrawable");
            paramChatMessage = parambvv;
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return paramChatMessage;
          parambvv = parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
          paramChatMessage = parambvv;
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| local existBig sound getLoadingDrawable");
        return parambvv;
        parambvv = parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(paramContext, BaseChatItemLayout.d);
        paramChatMessage = parambvv;
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| local existBig getBigDrawable");
      return parambvv;
      int i1 = NetworkUtil.a(this.jdField_b_of_type_AndroidContentContext);
      if ((i1 != 1) && (i1 != 3) && (i1 != 4))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a, 4)) {
          return parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
        }
        if (parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.c()) {
          return parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a();
        }
      }
      parambvv = parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(false);
      paramChatMessage = parambvv;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| getLoadingDrawable local not exist");
    return parambvv;
  }
  
  private void a(bvv parambvv)
  {
    parambvv.jdField_a_of_type_Boolean = false;
  }
  
  private boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    } while ((localChatMessage != paramChatMessage) && ((!(localChatMessage instanceof MessageForMarketFace)) || (localChatMessage.frienduin == null) || (!localChatMessage.frienduin.equals(paramChatMessage.frienduin)) || (localChatMessage.uniseq != paramChatMessage.uniseq)));
    return true;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    paramViewHolder = (bvv)paramViewHolder;
    int i1;
    if (paramView == null)
    {
      paramView = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ImageView localImageView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localImageView.setId(2131296335);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131296305);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131296305);
      localImageView.setImageResource(2130838985);
      paramView.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      localImageView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131296339);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131296335);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FrameLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener = new bvw(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramOnLongClickAndTouchListener, -2, -2);
      localObject2 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject3).gravity = 85;
      ((ImageView)localObject2).setImageResource(2130837529);
      ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject3).setId(2131296334);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131296339);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131296339);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 10;
      ((ImageView)localObject3).setImageResource(2130839018);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((ImageView)localObject3).setOnClickListener(this);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject4).setId(2131296336);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131296339);
      ((RelativeLayout.LayoutParams)localObject5).addRule(15, 2131296339);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = 10;
      ((ImageView)localObject4).setImageResource(2130838985);
      paramView.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      ((ImageView)localObject4).setOnClickListener(this);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131296337);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131296339);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131296339);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = (-AIOUtils.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = (-AIOUtils.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((ImageView)localObject5).setImageResource(2130837532);
      paramView.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext);
      ((ProgressBar)localObject6).setId(2131296303);
      ((ProgressBar)localObject6).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130837910));
      i1 = AIOUtils.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i1, i1);
      localLayoutParams.gravity = 17;
      ((FrameLayout)localObject1).addView((View)localObject6, localLayoutParams);
      paramViewHolder.e = paramOnLongClickAndTouchListener;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
      paramViewHolder.b = ((ImageView)localObject3);
      paramViewHolder.c = localImageView;
      paramViewHolder.d = ((ImageView)localObject4);
      paramViewHolder.f = ((ImageView)localObject5);
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject6);
    }
    for (;;)
    {
      if ((a(paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b != null)) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setContentDescription("表情发送失败");
      }
      if (paramBaseChatItemLayout.mMarkFaceMessage == null) {
        paramBaseChatItemLayout.parse();
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = EmoticonUtils.a(paramBaseChatItemLayout.mMarkFaceMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) {
        break;
      }
      paramViewHolder.e.setImageResource(2130837527);
      return paramView;
      paramViewHolder.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      if ((paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (paramViewHolder.b != null) && ((paramViewHolder.b.getDrawable() instanceof AnimationDrawable))) {
        paramViewHolder.b.setImageResource(2130839018);
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
    }
    paramBaseChatItemLayout = a(paramChatMessage, paramViewHolder, this.jdField_b_of_type_AndroidContentContext);
    int i2;
    if ((paramBaseChatItemLayout != null) && (paramBaseChatItemLayout.getStatus() == 1) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.h != 3))
    {
      i2 = paramBaseChatItemLayout.getIntrinsicWidth();
      i1 = paramBaseChatItemLayout.getIntrinsicHeight();
      i2 = (i2 * this.o + (this.n >> 1)) / this.n;
      i1 = (i1 * this.o + (this.n >> 1)) / this.n;
      paramViewHolder.e.setLayoutParams(new FrameLayout.LayoutParams(i2, i1));
      paramViewHolder.e.setImageDrawable(paramBaseChatItemLayout);
      if (paramBaseChatItemLayout != null) {}
      switch (paramBaseChatItemLayout.getStatus())
      {
      default: 
        paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        label972:
        paramViewHolder.d.setVisibility(8);
        paramViewHolder.c.setVisibility(8);
        if ((paramChatMessage.isMarketFaceFlow) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 0))
        {
          if (!paramChatMessage.isSend()) {
            break label1380;
          }
          paramViewHolder.c.setVisibility(0);
        }
        break;
      }
    }
    for (;;)
    {
      a(paramViewHolder, paramBaseChatItemLayout);
      a(paramViewHolder);
      return paramView;
      if ((paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || (paramBaseChatItemLayout.getStatus() == 1)) {
        break;
      }
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.width == 0)
      {
        i1 = 200;
        label1076:
        if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.height != 0) {
          break label1187;
        }
      }
      label1187:
      for (i2 = 200;; i2 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.height)
      {
        int i3 = i1;
        if (i1 != i2) {
          i3 = i2;
        }
        i1 = (i3 * this.o + (this.n >> 1)) / this.n;
        i2 = (i2 * this.o + (this.n >> 1)) / this.n;
        paramViewHolder.e.setLayoutParams(new FrameLayout.LayoutParams(i1, i2));
        break;
        i1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.width;
        break label1076;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      i1 = NetworkUtil.a(this.jdField_b_of_type_AndroidContentContext);
      boolean bool = SettingCloneUtil.readValue(this.jdField_b_of_type_AndroidContentContext, null, this.jdField_b_of_type_AndroidContentContext.getString(2131363049), "qqsetting_auto_receive_magic_face_key", true);
      if (((i1 == 1) || (i1 == 3) || (i1 == 4)) && (2 == paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.c(paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)) && (((i1 != 3) && (i1 != 4)) || (bool))) {
        break label972;
      }
      float f1 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
      if ((f1 >= 0.0F) && (1.0F != f1)) {
        break label972;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break label972;
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("表情下载失败");
      break label972;
      label1380:
      paramViewHolder.d.setVisibility(0);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new bvv(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    Object localObject;
    int i1;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      localObject = (MessageForMarketFace)paramChatMessage;
      if (((MessageForMarketFace)localObject).mMarkFaceMessage != null)
      {
        paramChatMessage = EmosmUtils.bytes2eId(((MessageForMarketFace)localObject).mMarkFaceMessage.sbufID, ((MessageForMarketFace)localObject).mMarkFaceMessage.mediaType);
        i1 = ((MessageForMarketFace)localObject).mMarkFaceMessage.dwTabID;
        localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
        if (localObject == null) {
          break label122;
        }
      }
    }
    label122:
    for (paramChatMessage = ((EmoticonManager)localObject).a(String.valueOf(i1), paramChatMessage);; paramChatMessage = null)
    {
      if ((paramChatMessage != null) && (paramChatMessage.name != null)) {}
      for (paramChatMessage = paramChatMessage.name;; paramChatMessage = "") {
        return "发送了商城表情" + paramChatMessage;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131298983) {
      ChatActivityFacade.a(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    do
    {
      return;
      if (paramInt == 2131296289)
      {
        paramContext = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
        EmosmDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
        paramContext.a(this.jdField_b_of_type_AndroidContentContext.getString(2131364050));
        paramContext.show();
        paramChatMessage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
        if ((paramChatMessage != null) && (paramChatMessage.name != null) && ((paramChatMessage.mobileFeetype != 0) || (paramChatMessage.downloadCount != 0)))
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
          i1 = (int)(System.currentTimeMillis() / 1000L);
          if ((i1 - paramInt > 86400) || (i1 < paramInt))
          {
            this.jdField_a_of_type_Bvu.a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.c, this.jdField_a_of_type_Bvu);
            return;
          }
          EmosmDetailActivity.a(6, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, null, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          return;
        }
        this.jdField_a_of_type_Bvu.a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.c, this.jdField_a_of_type_Bvu);
        return;
      }
    } while ((paramInt != 2131296290) && (paramInt != 2131296291));
    int i1 = 0;
    paramContext = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
    if (paramInt == 2131296290)
    {
      if ((2 == jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a()))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131364122, 0);
        return;
      }
      m = 1;
      EmosmDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      i1 = 7;
      paramContext.a(this.jdField_b_of_type_AndroidContentContext.getString(2131364051));
    }
    for (;;)
    {
      paramContext.show();
      if (((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId) != null) {
        break;
      }
      this.jdField_a_of_type_Bvu.a(i1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.c, this.jdField_a_of_type_Bvu);
      return;
      if (paramInt == 2131296291)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
        {
          ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131362558, 0);
          return;
        }
        paramContext.a(this.jdField_b_of_type_AndroidContentContext.getString(2131364052));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "");
        i1 = 107;
      }
    }
    EmosmDetailActivity.a(i1, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, null, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  protected void a(View paramView)
  {
    paramView = (bvv)AIOUtils.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131363070);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131363071);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
      }
    }
    do
    {
      return;
      DialogUtil.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new bvr(this, paramView), new bvs(this)).show();
      return;
      paramView = paramView.e.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(bvv parambvv, URLDrawable paramURLDrawable)
  {
    parambvv.b.setVisibility(8);
    parambvv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    parambvv.f.setVisibility(8);
    String str = paramURLDrawable.getURL().getHost();
    int i1 = paramURLDrawable.getStatus();
    if ("aio_preview".equals(str)) {
      if (parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) {
        parambvv.b.setVisibility(0);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((i1 != 1) || (parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.h != 3));
        parambvv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
        if (!"big_img".equals(str)) {
          break;
        }
        paramURLDrawable = paramURLDrawable.getHeader("image_dl_extra_info");
      } while ((paramURLDrawable == null) || (!Boolean.TRUE.toString().equals(paramURLDrawable.getValue())) || (i1 == 1));
      if (parambvv.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a())
      {
        parambvv.b.setVisibility(0);
        return;
      }
      parambvv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    } while (!"big_sound".equals(str));
    if (b(parambvv.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      parambvv.b.setVisibility(0);
      paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130968636);
      parambvv.b.setImageDrawable(paramURLDrawable);
      paramURLDrawable.start();
      return;
    }
    parambvv.b.setVisibility(0);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace == null) || (paramPicEmoticonInfo == null) || (paramPicEmoticonInfo.a == null) || (paramPicEmoticonInfo.a.epId == null)) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_b_of_type_AndroidContentContext, null, 2131624119);
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getString(2131364047));
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131364048), 1);
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131364049), 1);
    localActionSheet.d(2131362790);
    localActionSheet.a(new bvt(this, paramPicEmoticonInfo, localActionSheet, paramMessageForMarketFace));
    localActionSheet.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = (bvv)AIOUtils.a(paramView);
      if (EmosmDetailActivity.f != null) {
        EmosmDetailActivity.f.setImageResource(2130839018);
      }
      paramXListView.b.setImageResource(2130839018);
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
      if (EmosmDetailActivity.e != null) {
        EmosmDetailActivity.e.setImageDrawable(paramView);
      }
      paramXListView.e.setImageDrawable(paramView);
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    paramXListView = (bvv)AIOUtils.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null)) {
      return false;
    }
    if ((paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (paramAudioPlayer.a(EmosmUtils.getEmoticonSoundPath(paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId))))
    {
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.b();
      if (EmosmDetailActivity.e != null)
      {
        EmosmDetailActivity.e.setImageDrawable(paramView);
        PicEmoticonInfo.a(paramView);
        paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130968636);
        if (EmosmDetailActivity.f == null) {
          break label144;
        }
        EmosmDetailActivity.f.setImageDrawable(paramView);
      }
      for (;;)
      {
        paramView.start();
        return true;
        paramXListView.e.setImageDrawable(paramView);
        break;
        label144:
        paramXListView.b.setImageDrawable(paramView);
      }
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (bvv)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 1)
    {
      jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
      jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localQQCustomMenu.a(2131296289, this.jdField_b_of_type_AndroidContentContext.getString(2131363943));
      localQQCustomMenu.a(2131296290, this.jdField_b_of_type_AndroidContentContext.getString(2131363568));
      if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 2) {
        localQQCustomMenu.a(2131296291, this.jdField_b_of_type_AndroidContentContext.getString(2131363942));
      }
      EmosmDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    if (super.a()) {}
    Object localObject2;
    Object localObject3;
    label568:
    for (;;)
    {
      return;
      if (paramView.getId() != 2131296339) {
        break label680;
      }
      paramView = (bvv)AIOUtils.a(paramView);
      localObject1 = paramView.e.getDrawable();
      if ((localObject1 instanceof URLDrawable))
      {
        localObject2 = (URLDrawable)localObject1;
        localObject3 = ((URLDrawable)localObject2).getURL().getHost();
        switch (((URLDrawable)localObject1).getStatus())
        {
        }
        for (;;)
        {
          if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 0) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 2)) || ((((URLDrawable)localObject1).getStatus() != 1) && (!paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.c()))) {
            break label568;
          }
          localObject1 = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
          if ((((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).b((String)localObject1) == null) && (!EmoticonUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1))) {
            break label570;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
          if (localObject2 == null) {
            break;
          }
          ((Handler)localObject2).obtainMessage(22, localObject1).sendToTarget();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_aio_pkg_tab", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, (String)localObject1, "", "");
          return;
          ((URLDrawable)localObject2).restartDownload();
          if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfo", 2, "msgOnclickListener| urldrawable restartDownload status=" + ((URLDrawable)localObject2).getStatus());
          }
          a(paramView, (URLDrawable)localObject2);
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && ("big_sound".equals(localObject3)))
          {
            jdField_a_of_type_Long = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
            continue;
            if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 0) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 2))
            {
              paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
              if ("big_sound".equals(localObject3))
              {
                if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.isSound)) {
                  if (b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
                    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                  } else {
                    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
                  }
                }
              }
              else if ("aio_preview".equals(localObject3))
              {
                localObject2 = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
                if (localObject2 != null)
                {
                  paramView.e.setImageDrawable((Drawable)localObject2);
                  paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                  a(paramView, (URLDrawable)localObject2);
                  if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) {
                    jdField_a_of_type_Long = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
                  }
                }
              }
            }
          }
        }
      }
    }
    label570:
    jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramView = new Intent(this.jdField_b_of_type_AndroidContentContext, EmosmDetailActivity.class);
    paramView.putExtras(new Bundle());
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    paramView.putExtra("key_emojimall_detail_chat_type", i1);
    paramView.putExtra("key_emojimall_detail_chat_uin", (String)localObject1);
    EmosmDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ep_detail_aio", 0);
    this.jdField_b_of_type_AndroidContentContext.startActivity(paramView);
    return;
    label680:
    if (paramView.getId() == 2131296334)
    {
      localObject1 = (bvv)AIOUtils.a(paramView);
      if ((((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.isSound))
      {
        if (!b(((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
          break label756;
        }
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      label756:
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131363137, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
      }
      else
      {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        continue;
        if ((paramView.getId() == 2131296336) || (paramView.getId() == 2131296335))
        {
          localObject1 = (bvv)AIOUtils.a(paramView);
          if ((((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null))
          {
            localObject2 = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
            ((QQProgressDialog)localObject2).a(this.jdField_b_of_type_AndroidContentContext.getString(2131364052));
            ((QQProgressDialog)localObject2).show();
            localObject3 = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ep_mall", "Clk_button_follow", 0, 0, "", ((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId, "", "");
            if (localObject3 == null)
            {
              this.jdField_a_of_type_Bvu.a(107, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, ((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, (QQProgressDialog)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.c, this.jdField_a_of_type_Bvu);
            }
            else
            {
              EmosmDetailActivity.a(107, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, null, (QQProgressDialog)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            }
          }
        }
        else if (paramView.getId() == 2131296337)
        {
          localObject1 = (bvv)AIOUtils.a(paramView);
          if ((((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (2 == ((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType))
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false)))
            {
              this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonMagicFaceDownloadListener);
              localObject2 = new EmoticonPackage();
              ((EmoticonPackage)localObject2).epId = ((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
              ((EmoticonPackage)localObject2).jobType = 3;
              ((EmoticonPackage)localObject2).type = 1;
              ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
              ((bvv)localObject1).jdField_a_of_type_Boolean = false;
              ((MessageForMarketFace)((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
              ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
              this.jdField_a_of_type_JavaUtilList.add(localObject1);
              ((bvv)localObject1).f.setVisibility(8);
              ((bvv)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
              this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject2, false);
            }
            ReportController.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, ((bvv)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder
 * JD-Core Version:    0.7.0.1
 */
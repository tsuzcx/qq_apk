package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
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
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticon.EmoticonController.MagicFaceDownloader;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import dzk;
import dzl;
import dzo;
import dzp;
import dzq;
import dzr;
import dzs;
import dzt;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;

public class MarketFaceItemBuilder
  extends BaseBubbleBuilder
  implements MediaPlayerManager.Callback
{
  private static long jdField_a_of_type_Long = 0L;
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
  EmoticonController.MagicFaceDownloader jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$MagicFaceDownloader = new dzl(this);
  public dzr a;
  public List a;
  public Context b;
  String b;
  public int n = 320;
  public int o = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
  
  public MarketFaceItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_JavaLangString = "MarketFaceItemBuilder";
    this.jdField_a_of_type_Dzr = new dzk(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private URLDrawable a(ChatMessage paramChatMessage, dzs paramdzs, Context paramContext)
  {
    if (paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.b()) {
      if (paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) {
        if (c(paramChatMessage))
        {
          paramdzs = paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.b();
          paramChatMessage = paramdzs;
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| local existBig getSoundBigDrawable");
            paramChatMessage = paramdzs;
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
          paramdzs = paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
          paramChatMessage = paramdzs;
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| local existBig sound getLoadingDrawable");
        return paramdzs;
        paramdzs = paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(paramContext, BaseChatItemLayout.d);
        paramChatMessage = paramdzs;
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| local existBig getBigDrawable");
      return paramdzs;
      int i1 = NetworkUtil.a(this.jdField_b_of_type_AndroidContentContext);
      if ((i1 != 1) && (i1 != 3) && (i1 != 4))
      {
        if (EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a, 4)) {
          return paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
        }
        if (paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.c()) {
          return paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a();
        }
      }
      paramdzs = paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(false);
      paramChatMessage = paramdzs;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "generateEmotionDrawable| getLoadingDrawable local not exist");
    return paramdzs;
  }
  
  private void a(dzs paramdzs)
  {
    paramdzs.jdField_a_of_type_Boolean = false;
    if ((2 != paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (((MessageForMarketFace)paramdzs.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!MagicfaceViewController.a())) {}
    do
    {
      int i1;
      boolean bool;
      do
      {
        return;
        i1 = NetworkUtil.a(this.jdField_b_of_type_AndroidContentContext);
        if (EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)) {
          break;
        }
        if ((i1 != 1) && (i1 != 3) && (i1 != 4))
        {
          paramdzs.f.setVisibility(8);
          return;
        }
        bool = SettingCloneUtil.readValue(this.jdField_b_of_type_AndroidContentContext, null, this.jdField_b_of_type_AndroidContentContext.getString(2131563451), "qqsetting_auto_receive_magic_face_key", true);
      } while (((i1 == 3) || (i1 == 4)) && ((!bool) || (EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false))) || (-1.0F != EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))));
      EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$MagicFaceDownloader);
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      ((EmoticonPackage)localObject).jobType = 3;
      ((EmoticonPackage)localObject).type = 1;
      ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12)).a(paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
      this.jdField_a_of_type_JavaUtilList.add(paramdzs);
      paramdzs.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramdzs.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
      paramdzs.f.setVisibility(8);
      paramdzs.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      ((MessageForMarketFace)paramdzs.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((EmoticonPackage)localObject, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
      return;
      paramdzs.f.setVisibility(0);
    } while (!((MessageForMarketFace)paramdzs.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay);
    ((MessageForMarketFace)paramdzs.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    Object localObject = new Emoticon();
    ((Emoticon)localObject).eId = paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId;
    ((Emoticon)localObject).epId = paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
    ((Emoticon)localObject).magicValue = paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue;
    ((Emoticon)localObject).jobType = paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType;
    ((ChatActivity)this.jdField_b_of_type_AndroidContentContext).a((Emoticon)localObject, 1, ((MessageForMarketFace)paramdzs.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
  }
  
  private boolean c(ChatMessage paramChatMessage)
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
    paramViewHolder = (dzs)paramViewHolder;
    int i1;
    if (paramView == null)
    {
      paramView = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ImageView localImageView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localImageView.setId(2131230807);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131230779);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131230779);
      localImageView.setImageResource(2130839113);
      paramView.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      localImageView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131230811);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131230807);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FrameLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener = new dzt(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramOnLongClickAndTouchListener, -2, -2);
      localObject2 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject3).gravity = 85;
      ((ImageView)localObject2).setImageResource(2130837630);
      ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject3).setId(2131230806);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131230811);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131230811);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 10;
      ((ImageView)localObject3).setImageResource(2130839148);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((ImageView)localObject3).setOnClickListener(this);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject4).setId(2131230808);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131230811);
      ((RelativeLayout.LayoutParams)localObject5).addRule(15, 2131230811);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = 10;
      ((ImageView)localObject4).setImageResource(2130839113);
      paramView.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      ((ImageView)localObject4).setOnClickListener(this);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131230809);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131230811);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131230811);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = -24;
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = -24;
      ((ImageView)localObject5).setImageResource(2130837633);
      paramView.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext);
      ((ProgressBar)localObject6).setId(2131230777);
      ((ProgressBar)localObject6).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130837856));
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
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = EmoticonUtils.a(paramBaseChatItemLayout.mMarkFaceMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) {
        break;
      }
      paramViewHolder.e.setImageResource(2130837628);
      return paramView;
      paramViewHolder.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      if ((paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (paramViewHolder.b != null) && ((paramViewHolder.b.getDrawable() instanceof AnimationDrawable))) {
        paramViewHolder.b.setImageResource(2130839148);
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
        label948:
        paramViewHolder.d.setVisibility(8);
        paramViewHolder.c.setVisibility(8);
        if ((paramChatMessage.isMarketFaceFlow) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 0))
        {
          if (!paramChatMessage.isSend()) {
            break label1366;
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
        label1052:
        if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.height != 0) {
          break label1163;
        }
      }
      label1163:
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
        break label1052;
      }
      if (!MagicfaceViewController.a()) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
      i1 = NetworkUtil.a(this.jdField_b_of_type_AndroidContentContext);
      boolean bool = SettingCloneUtil.readValue(this.jdField_b_of_type_AndroidContentContext, null, this.jdField_b_of_type_AndroidContentContext.getString(2131563451), "qqsetting_auto_receive_magic_face_key", true);
      if (((i1 == 1) || (i1 == 3) || (i1 == 4)) && (2 == paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (!EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)) && (((i1 != 3) && (i1 != 4)) || (bool))) {
        break label948;
      }
      float f1 = EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
      if ((f1 >= 0.0F) && (1.0F != f1)) {
        break label948;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break label948;
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("表情下载失败");
      break label948;
      label1366:
      paramViewHolder.d.setVisibility(0);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new dzs(this);
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
        localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
        if (localObject == null) {
          break label132;
        }
      }
    }
    label132:
    for (paramChatMessage = ((EmoticonManager)localObject).a(String.valueOf(i1), paramChatMessage);; paramChatMessage = null)
    {
      if ((paramChatMessage != null) && (paramChatMessage.name != null)) {}
      for (paramChatMessage = paramChatMessage.name;; paramChatMessage = "") {
        return this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131558896) + paramChatMessage;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131234873) {
      ChatActivityFacade.a(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    do
    {
      return;
      if (paramInt == 2131230764)
      {
        paramContext = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
        EmosmDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
        paramContext.a(this.jdField_b_of_type_AndroidContentContext.getString(2131561618));
        paramContext.show();
        paramChatMessage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
        if ((paramChatMessage != null) && (paramChatMessage.name != null) && ((paramChatMessage.mobileFeetype != 0) || (paramChatMessage.downloadCount != 0)))
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
          i1 = (int)(System.currentTimeMillis() / 1000L);
          if ((i1 - paramInt > 86400) || (i1 < paramInt))
          {
            this.jdField_a_of_type_Dzr.a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Dzr);
            EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
            return;
          }
          EmosmDetailActivity.a(6, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, null, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          return;
        }
        this.jdField_a_of_type_Dzr.a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Dzr);
        EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
        return;
      }
    } while ((paramInt != 2131230765) && (paramInt != 2131230766));
    int i1 = 0;
    paramContext = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
    if (paramInt == 2131230765)
    {
      if ((2 == jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (!EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131562210, 0);
        return;
      }
      m = 1;
      EmosmDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      i1 = 7;
      paramContext.a(this.jdField_b_of_type_AndroidContentContext.getString(2131562658));
    }
    for (;;)
    {
      paramContext.show();
      if (((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId) != null) {
        break;
      }
      this.jdField_a_of_type_Dzr.a(i1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Dzr);
      EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
      return;
      if (paramInt == 2131230766)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
        {
          ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131560675, 0);
          return;
        }
        paramContext.a(this.jdField_b_of_type_AndroidContentContext.getString(2131562874));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "");
        i1 = 107;
      }
    }
    EmosmDetailActivity.a(i1, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, null, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  protected void a(View paramView)
  {
    paramView = (dzs)AIOUtils.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131562859);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131561439);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
      }
    }
    do
    {
      return;
      DialogUtil.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new dzo(this, paramView), new dzp(this)).show();
      return;
      paramView = paramView.e.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace == null) || (paramPicEmoticonInfo == null) || (paramPicEmoticonInfo.a == null) || (paramPicEmoticonInfo.a.epId == null)) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_b_of_type_AndroidContentContext, null);
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getString(2131561470));
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131563177), 1);
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131562789), 1);
    localActionSheet.d(2131561746);
    localActionSheet.a(new dzq(this, paramMessageForMarketFace, paramPicEmoticonInfo, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = (dzs)AIOUtils.a(paramView);
      if (EmosmDetailActivity.f != null) {
        EmosmDetailActivity.f.setImageResource(2130839148);
      }
      paramXListView.b.setImageResource(2130839148);
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
      if (EmosmDetailActivity.e != null) {
        EmosmDetailActivity.e.setImageDrawable(paramView);
      }
      paramXListView.e.setImageDrawable(paramView);
    }
  }
  
  public void a(dzs paramdzs, URLDrawable paramURLDrawable)
  {
    paramdzs.b.setVisibility(8);
    paramdzs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramdzs.f.setVisibility(8);
    String str = paramURLDrawable.getURL().getHost();
    int i1 = paramURLDrawable.getStatus();
    if ("aio_preview".equals(str)) {
      if (paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) {
        paramdzs.b.setVisibility(0);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((i1 != 1) || (paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.h != 3));
        paramdzs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
        if (!"big_img".equals(str)) {
          break;
        }
        paramURLDrawable = paramURLDrawable.getHeader("image_dl_extra_info");
      } while ((paramURLDrawable == null) || (!Boolean.TRUE.toString().equals(paramURLDrawable.getValue())) || (i1 == 1));
      if (paramdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a())
      {
        paramdzs.b.setVisibility(0);
        return;
      }
      paramdzs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    } while (!"big_sound".equals(str));
    if (c(paramdzs.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      paramdzs.b.setVisibility(0);
      paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130968666);
      paramdzs.b.setImageDrawable(paramURLDrawable);
      paramURLDrawable.start();
      return;
    }
    paramdzs.b.setVisibility(0);
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
    paramXListView = (dzs)AIOUtils.a(paramView);
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
        paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130968666);
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
    return null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder
 * JD-Core Version:    0.7.0.1
 */
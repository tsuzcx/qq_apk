package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.rookery.translate.AITranslator;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.TransMemCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.type.Language;
import com.rookery.translate.widget.BubbleResizeAnimation;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import ebf;
import ebg;
import java.util.HashMap;

public class TextTranslationItemBuilder
  extends TextItemBuilder
{
  public static boolean d = false;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  private static int i;
  private static int j;
  private static int k;
  private long jdField_a_of_type_Long = -1L;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  Trans_entity jdField_a_of_type_ComRookeryTranslateModelTrans_entity;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  private boolean e = true;
  
  public TextTranslationItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.b.setDuration(150L);
    this.b.setFillAfter(true);
  }
  
  private int a(double paramDouble)
  {
    return (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * paramDouble);
  }
  
  public static int a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    String str;
    if (paramInt == 0) {
      str = "0";
    }
    for (;;)
    {
      if (i != 0) {
        StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "", "Translate_external", "Clk_bubble__translate", 0, i, 0, "", str, "", "");
      }
      if (j != 0) {
        StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "", "Translate_external", "Back_original_text", 0, j, 0, "", str, "", "");
      }
      if (k != 0) {
        StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "", "Translate_external", "Same_language", 0, k, 0, "", str, "", "");
      }
      i = 0;
      j = 0;
      k = 0;
      return 0;
      if (paramInt == 1) {
        str = "1";
      } else if (paramInt == 3000) {
        str = "2";
      } else {
        str = "";
      }
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    Drawable localDrawable = paramView.getBackground();
    Rect localRect = new Rect();
    if (localDrawable != null) {
      localDrawable.getPadding(localRect);
    }
    paramView.setBackgroundResource(paramInt);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, TextTranslationItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramHolder.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233300));
    paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramHolder.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131233301));
  }
  
  private void a(TextTranslationItemBuilder.Holder paramHolder)
  {
    a(paramHolder.jdField_a_of_type_AndroidViewViewGroup, 2130840341);
    paramHolder = (AnimationDrawable)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getBackground();
    if (paramHolder != null) {
      paramHolder.start();
    }
  }
  
  @SuppressLint({"NewApi"})
  private void a(TextTranslationItemBuilder.Holder paramHolder, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout = paramChatMessage.msg;
    if (paramHolder.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramHolder.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
    }
    String str = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (!TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long)) {
      b(paramHolder);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = null;
      TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache != null) {
        this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = localTransDiskCache.a(paramBaseChatItemLayout, paramHolder.jdField_a_of_type_Long, str);
      }
      if ((this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity == null) || (!this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity.a().booleanValue()) || (paramChatMessage.isSend())) {
        break;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      a(paramHolder, true);
      return;
      a(paramHolder);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    a(paramHolder, false);
  }
  
  private void a(TextTranslationItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if ((paramHolder != null) && (paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      localObject = paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int m = 0;; m = 8)
    {
      ((LinearLayout)localObject).setVisibility(m);
      if (paramBoolean) {
        break;
      }
      return;
    }
    Object localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if ((((String)localObject).equals(Language.CHINESE.toString())) || (((String)localObject).equals(Language.CHINESE_SIMPLIFIED.toString())) || (((String)localObject).equals(Language.CHINESE_TRADITIONAL.toString())) || (((String)localObject).equals(Language.MS_CHINESE_SIMPLIFIED.toString())) || (((String)localObject).equals(Language.MS_CHINESE_TRADITIONAL.toString())) || (((String)localObject).equals(Language.KOREAN.toString())) || (((String)localObject).equals(Language.JAPANESE.toString())))
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838016);
      return;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838015);
  }
  
  private void b(TextTranslationItemBuilder.Holder paramHolder)
  {
    paramHolder = paramHolder.jdField_a_of_type_AndroidViewViewGroup.getBackground();
    if ((paramHolder != null) && ((paramHolder instanceof AnimationDrawable))) {
      ((AnimationDrawable)paramHolder).stop();
    }
  }
  
  private void b(TextTranslationItemBuilder.Holder paramHolder, ChatMessage paramChatMessage)
  {
    paramHolder.jdField_b_of_type_Int = ((int)paramChatMessage.vipBubbleID);
    paramHolder.jdField_a_of_type_Long = paramChatMessage.uniseq;
    paramHolder.c = paramChatMessage.istroop;
    paramHolder.jdField_a_of_type_JavaLangString = paramChatMessage.msg;
    paramHolder.jdField_b_of_type_JavaLangString = paramChatMessage.msg;
  }
  
  private void c(TextTranslationItemBuilder.Holder paramHolder, ChatMessage paramChatMessage)
  {
    int m = 0;
    paramHolder.jdField_a_of_type_JavaLangString = paramChatMessage.msg;
    Object localObject2;
    if ((paramChatMessage instanceof MessageForText))
    {
      localObject2 = ((MessageForText)paramChatMessage).sb;
      Object localObject1 = localObject2;
      if (paramChatMessage.senderuin.equals("1000000")) {
        localObject1 = LocaleString.q(this.jdField_a_of_type_AndroidContentContext, ((CharSequence)localObject2).toString());
      }
      paramHolder.jdField_b_of_type_JavaLangString = paramChatMessage.msg;
      localObject2 = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = null;
      TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache != null) {
        this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = localTransDiskCache.a(paramChatMessage.msg, paramHolder.jdField_a_of_type_Long, (String)localObject2);
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity != null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity.a().booleanValue())
        {
          localObject2 = localObject1;
          if (!paramChatMessage.isSend())
          {
            paramHolder.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity.a();
            localObject2 = new QQText(paramHolder.jdField_a_of_type_JavaLangString, 13, 32, paramChatMessage.istroop);
          }
        }
      }
      if ((d) && (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity != null) && (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity.a().booleanValue()))
      {
        a(paramHolder);
        b(paramHolder);
      }
      localObject1 = paramHolder.jdField_a_of_type_JavaLangString;
      if (paramHolder.d != 0) {
        break label266;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    }
    label266:
    while ((paramChatMessage.isSend()) || (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity == null) || (paramHolder.d != 1))
    {
      return;
      localObject2 = paramChatMessage.msg;
      break;
    }
    paramChatMessage = paramHolder.jdField_a_of_type_AndroidWidgetTextView.getText();
    int i1 = paramHolder.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
    int n = paramHolder.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight();
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.measure(0, 0);
    if (paramHolder.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() < BaseChatItemLayout.f) {
      m = paramHolder.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() - i1;
    }
    i1 = paramHolder.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight();
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramChatMessage);
    paramChatMessage = new BubbleResizeAnimation(paramHolder.jdField_a_of_type_AndroidViewViewGroup, 300, m, i1 - n);
    paramChatMessage.setAnimationListener(new ebf(this, paramHolder, (CharSequence)localObject2));
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramChatMessage);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (TextTranslationItemBuilder.Holder)paramView.getTag();
    b(paramViewGroup, paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, paramChatMessage);
    paramOnLongClickAndTouchListener = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (localTransDiskCache != null)
    {
      paramOnLongClickAndTouchListener = localTransDiskCache.a(paramViewGroup.jdField_b_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_Long, paramOnLongClickAndTouchListener);
      if (((d) && (paramOnLongClickAndTouchListener == null)) || ((d) && (paramViewGroup.jdField_a_of_type_Boolean) && (paramOnLongClickAndTouchListener != null) && (!paramOnLongClickAndTouchListener.a().booleanValue()) && (MessageCache.a() < paramChatMessage.time + 10L))) {
        a(paramViewGroup, paramChatMessage);
      }
    }
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (TextTranslationItemBuilder.Holder)paramViewHolder;
    if (paramView == null)
    {
      paramViewHolder = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2130903661, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramViewHolder;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((AnimationTextView)paramViewHolder.findViewById(2131231227));
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(BaseChatItemLayout.f);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(new LinkMovementMethod());
    }
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      int m = BaseChatItemLayout.p;
      m = BaseChatItemLayout.q;
      if (paramChatMessage.isSend())
      {
        m = BaseChatItemLayout.q;
        m = BaseChatItemLayout.p;
      }
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return paramViewHolder;
      paramViewHolder = paramView;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TextTranslationItemBuilder.Holder(this);
  }
  
  @Deprecated
  public void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.l, BaseChatItemLayout.i, BaseChatItemLayout.k, BaseChatItemLayout.j);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.i, BaseChatItemLayout.l, BaseChatItemLayout.j);
  }
  
  @TargetApi(16)
  protected void a(TextTranslationItemBuilder.Holder paramHolder, ChatMessage paramChatMessage)
  {
    if (paramHolder == null) {}
    long l1;
    label59:
    do
    {
      do
      {
        return;
      } while ((paramChatMessage.msgtype != -1000) || (paramChatMessage.isSend()));
      if (paramHolder.jdField_b_of_type_Boolean)
      {
        paramHolder.jdField_b_of_type_Boolean = false;
        return;
      }
      long l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramHolder.jdField_a_of_type_Long)) != null) {
        break;
      }
      l1 = 0L;
      if (l2 - l1 < 800L) {
        break label377;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramHolder.jdField_a_of_type_Long), Long.valueOf(l2));
      if (QLog.isColorLevel()) {
        QLog.i("Translator", 2, "on click translate status:" + paramHolder.d);
      }
    } while (paramHolder.d != 0);
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = LocaleUtil.a(localContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramChatMessage = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (paramChatMessage != null) {}
    for (paramChatMessage = paramChatMessage.a(paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long, str);; paramChatMessage = null)
    {
      if (paramChatMessage != null)
      {
        if (!paramChatMessage.a().equalsIgnoreCase(paramHolder.jdField_b_of_type_JavaLangString))
        {
          if (paramChatMessage.a().booleanValue())
          {
            if (!TranslateCache.a(localContext).b(str, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long))
            {
              j += 1;
              TranslateCache.a(localContext).b(str, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long, Boolean.valueOf(true));
            }
            if (paramHolder.jdField_a_of_type_AndroidViewViewGroup != null)
            {
              paramHolder.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
              paramHolder.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
              paramHolder.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130837645);
              TranslateCache.a(localContext).a(str, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long, Boolean.valueOf(false));
            }
          }
          paramChatMessage.a();
          TranslateCache.a(localContext).a(str, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long, paramChatMessage.a());
          paramHolder.d = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
          l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramHolder.jdField_a_of_type_Long))).longValue();
          break label59;
          label377:
          break;
        }
        a(2131563044);
        return;
      }
      i += 1;
      paramHolder.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      if (!AITranslator.a().a(localContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHolder, paramHolder.jdField_a_of_type_JavaLangString, Language.fromString(str), new ebg(this, paramHolder, localContext, str)).booleanValue())
      {
        b(paramHolder);
        TranslateCache.a(this.jdField_a_of_type_AndroidContentContext).a(str, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long, Boolean.valueOf(false));
        return;
      }
      a(paramHolder);
      TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long, Boolean.valueOf(true));
      return;
    }
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    String str1 = paramChatMessage.msg;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      String str2 = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localObject = null;
      TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache != null) {
        localObject = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, str2);
      }
      if ((localObject == null) || (!((Trans_entity)localObject).a().booleanValue()) || (paramChatMessage.isSend())) {}
    }
    for (Object localObject = ((Trans_entity)localObject).a();; localObject = str1)
    {
      QfavBuilder.a((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if ((paramView.getId() == 2131230779) || (paramView.getId() == 2131231227))
    {
      if (QQText.a.booleanValue())
      {
        QQText.a = Boolean.valueOf(false);
        return;
      }
      ChatMessage localChatMessage = AIOUtils.a(paramView);
      paramView = (TextTranslationItemBuilder.Holder)AIOUtils.a(paramView);
      if (!paramView.jdField_a_of_type_Boolean) {
        bool = true;
      }
      paramView.jdField_a_of_type_Boolean = bool;
      a(paramView, localChatMessage);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder
 * JD-Core Version:    0.7.0.1
 */
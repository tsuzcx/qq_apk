package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import emc;
import emd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAioMsgNavigateBar
  extends TroopAioAgent
  implements View.OnClickListener, Animation.AnimationListener
{
  private static long jdField_a_of_type_Long = 2147483647L;
  private float jdField_a_of_type_Float = 0.0F;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private long jdField_b_of_type_Long = jdField_a_of_type_Long;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  private ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  public RelativeLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = 0L;
  public RelativeLayout c;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int e = -1;
  private int f = 0;
  private int g = 0;
  
  public TroopAioMsgNavigateBar()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void h()
  {
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setId(2131296354);
    Object localObject = new RelativeLayout.LayoutParams(-1, this.g);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setId(2131296353);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i;
    label264:
    int j;
    if (bool)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838205);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = -9;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 0, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296360);
      localObject = new RelativeLayout.LayoutParams(-2, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362497), new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      if (!bool) {
        break label775;
      }
      i = 2130838220;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(18);
      if (!bool) {
        break label781;
      }
      j = 2131427432;
      label291:
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(j));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492871));
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131296361);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131296360);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetImageView.setId(2131296363);
      if (!bool) {
        break label787;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838210);
    }
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      i = (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetTextView.setId(2131296362);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131296363);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(16);
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(j));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492871));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(17170445);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(17170445);
      return;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838204);
      break;
      label775:
      i = 2130838219;
      break label264;
      label781:
      j = 2131427439;
      break label291;
      label787:
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838209);
    }
  }
  
  private void i()
  {
    this.jdField_d_of_type_Boolean = false;
    if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8))
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.e != 1) {
        break label111;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    label111:
    do
    {
      return;
      if (this.e == 4)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("此消息提到了我");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
      if (this.e == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("有特别关注的消息");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
    } while (this.e != 2);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("有全体消息");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
  }
  
  private void j()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new emc(this));
      return;
    }
    i();
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
      if (localTroopInfoManager != null) {
        localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      }
      this.e = -1;
      if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidViewAnimationAnimation != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float += paramFloat;
    if ((this.jdField_a_of_type_Float < 0 - this.f / 2) && (this.e == 1)) {
      g();
    }
  }
  
  public void a(List paramList)
  {
    if ((this.jdField_b_of_type_Long == jdField_a_of_type_Long) || (this.jdField_c_of_type_Boolean) || (paramList == null) || (paramList.size() == 0)) {}
    label308:
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (MsgProxyUtils.i(((ChatMessage)localObject2).msgtype));
      }
      for (long l = ((ChatMessage)localObject2).shmsgseq;; l = 0L)
      {
        if ((l > this.jdField_b_of_type_Long) || (this.jdField_b_of_type_Long == 0L) || (l == 0L)) {
          break label308;
        }
        this.jdField_c_of_type_Boolean = true;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject1 = (MessageForTroopUnreadTips)MessageRecordFactory.a(-4009);
        ((MessageForTroopUnreadTips)localObject1).init((String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, "", MessageCache.a(), -4009, 1, 0L);
        ((MessageForTroopUnreadTips)localObject1).shmsgseq = this.jdField_b_of_type_Long;
        Object localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((ArrayList)localObject3, (String)localObject2, false, false);
        localObject2 = new ArrayList();
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject2).add((ChatMessage)((Iterator)localObject3).next());
        }
        MsgProxyUtils.a((List)localObject2, (MessageRecord)localObject1, true);
        paramList.clear();
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramList.add((ChatMessage)((Iterator)localObject1).next());
        }
        break;
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8);
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_Long, "");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.f = localDisplayMetrics.heightPixels;
    this.g = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493057));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0 - this.g, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - this.g);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
  }
  
  public boolean b()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return false;
    }
    this.e = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (this.e == 1)
    {
      if ((this.jdField_d_of_type_Int >= 20) && (this.jdField_d_of_type_Int <= 200)) {
        return true;
      }
    }
    else if ((this.e == 4) || (this.e == 2) || (this.e == 3)) {
      return true;
    }
    return false;
  }
  
  protected void c()
  {
    ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void d()
  {
    if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      Object localObject = (TroopAioAgent.Message)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getTag();
      if (localObject != null)
      {
        long l2 = ((TroopAioAgent.Message)localObject).jdField_a_of_type_Long;
        long l1 = l2;
        if (((TroopAioAgent.Message)localObject).jdField_b_of_type_Long != 0L)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((TroopAioAgent.Message)localObject).jdField_b_of_type_Long);
          l1 = l2;
          if (localObject != null) {
            l1 = ((MessageRecord)localObject).shmsgseq;
          }
        }
        if (l1 > 0L)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q();
          localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i);
          if ((localObject != null) && (((ChatMessage)localObject).shmsgseq <= l1)) {
            g();
          }
        }
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.e == 1)) {
      g();
    }
  }
  
  public void f()
  {
    int j = 0;
    label9:
    Object localObject;
    long l;
    if (!b())
    {
      return;
      break label206;
    }
    else
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
      this.e = ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_Long = ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l = jdField_a_of_type_Long;
      localObject = (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q());
      if (localObject == null) {
        break label744;
      }
      l = ((MessageRecord)localObject).shmsgseq;
    }
    label206:
    label739:
    label744:
    for (;;)
    {
      if (this.e == 1)
      {
        h();
        localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362497), new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) });
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(TroopAioAgent.Message.a(this.e, this.jdField_c_of_type_Long, 0L));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        j();
        i = 1;
        if (i == 0) {
          g();
        }
      }
      else if (this.e == 4)
      {
        h();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
        if ((localObject == null) || (((MessageRecord)localObject).shmsgseq >= l)) {
          break label739;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362495) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject, false));
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(TroopAioAgent.Message.a(this.e, 0L, this.jdField_c_of_type_Long));
        j();
      }
      for (int i = 1;; i = 0)
      {
        break label206;
        if (this.e == 2)
        {
          h();
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
          i = j;
          if (localObject == null) {
            break label206;
          }
          i = j;
          if (((MessageRecord)localObject).shmsgseq >= l) {
            break label206;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362496) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject, false));
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(TroopAioAgent.Message.a(this.e, 0L, this.jdField_c_of_type_Long));
          j();
        }
        for (;;)
        {
          i = 1;
          break label206;
          break label9;
          i = j;
          if (this.e != 3) {
            break;
          }
          h();
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
          i = j;
          if (localObject == null) {
            break;
          }
          i = j;
          if (((MessageRecord)localObject).shmsgseq >= l) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362883) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject, false));
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(TroopAioAgent.Message.a(this.e, 0L, this.jdField_c_of_type_Long));
          j();
        }
      }
    }
  }
  
  public void g()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new emd(this));
      return;
    }
    k();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) || (paramAnimation == null)) {}
    do
    {
      do
      {
        return;
      } while (!paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    } while ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)));
    setChanged();
    notifyObservers(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getTag());
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296353: 
      if (this.e == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
      for (;;)
      {
        this.jdField_d_of_type_Boolean = true;
        g();
        return;
        if (this.e == 4) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        } else if (this.e == 3) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        } else if (this.e == 2) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar
 * JD-Core Version:    0.7.0.1
 */
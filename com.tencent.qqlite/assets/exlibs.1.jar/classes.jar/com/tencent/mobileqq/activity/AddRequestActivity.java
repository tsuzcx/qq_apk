package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import xh;
import xk;
import xl;
import xm;
import xn;
import xo;
import xp;
import xq;
import xr;
import xs;
import xt;
import xu;
import xv;

public class AddRequestActivity
  extends IphoneTitleBarActivity
  implements AppConstants
{
  public static final int a = 1;
  public static final String a = "infoid";
  public static final int b = 2;
  public static final String b = "infouin";
  static final int jdField_c_of_type_Int = 2;
  public static final String c = "infonick";
  public static final String d = "infotime";
  public static final String e = "verify_msg";
  public static final String f = "verify_type";
  private static final int jdField_g_of_type_Int = 0;
  public static final String g = "msg_source";
  private static final int h = 1;
  public static final String h = "msg_source_id";
  private static final int i = 1;
  public static final String i = "msg_type";
  public static final String j = "sig";
  public static final String k = "lToMobile";
  public static final String l = "strNickName";
  public static final String m = "info_dealwith_msg";
  public static final String n = "msg_troopuin";
  public static final String o = "info_troopnickname";
  public static final String p = "msg_title";
  private static final String r = "Q.systemmsg.AddRequestActivity";
  protected float a;
  public long a;
  public Dialog a;
  final Handler jdField_a_of_type_AndroidOsHandler = new xh(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new xs(this);
  public Button a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public CardHandler a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new xn(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new xv(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new xm(this);
  public QQCustomDialog a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
  private boolean jdField_a_of_type_Boolean = false;
  public byte[] a;
  protected float b;
  private long jdField_b_of_type_Long;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new xt(this);
  public Button b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private long jdField_c_of_type_Long;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new xu(this);
  Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public int d;
  private long jdField_d_of_type_Long;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int jdField_f_of_type_Int = 10004;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private final int j = 0;
  private final int k = 1;
  private TextView l;
  private TextView m;
  private TextView n;
  public String q;
  private String s;
  private String t = "";
  private String u = "";
  private String v;
  private String w = "";
  private String x;
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = FriendSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      List localList = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (paramInt < localList.size())
        {
          this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(String paramString)
  {
    if (paramString != null)
    {
      int i1 = 0;
      while (i1 < paramString.length())
      {
        if (!Character.isSpaceChar(paramString.charAt(i1))) {
          return false;
        }
        i1 += 1;
      }
    }
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    int i2 = 0;
    b();
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298490));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298491));
    this.g = ((TextView)findViewById(2131298492));
    TextView localTextView = (TextView)findViewById(2131298501);
    Object localObject2 = (LinearLayout)findViewById(2131298494);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131298500);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296442));
    this.l = ((TextView)findViewById(2131296535));
    Object localObject3 = (TextView)findViewById(2131298495);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298503));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298502));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131298496));
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))) {
      this.t = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    }
    TextPaint localTextPaint = ((TextView)localObject3).getPaint();
    Object localObject1 = localTextPaint;
    if (localTextPaint == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.jdField_c_of_type_Float;
    }
    float f1 = ((TextPaint)localObject1).measureText(this.t);
    label391:
    int i1;
    if (this.jdField_b_of_type_Float - f1 > 30.0F)
    {
      ((TextView)localObject3).setText(this.t);
      localObject1 = localObject3;
      ((LinearLayout)localObject2).setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if ((this.t == null) || (this.t.equals(""))) {
        break label601;
      }
      if ((this.u == null) || (this.u.equals(""))) {
        break label577;
      }
      ((LinearLayout)localObject2).setBackgroundResource(2130837945);
      if (((LinearLayout)localObject2).getVisibility() != 0) {
        ((LinearLayout)localObject2).setVisibility(0);
      }
      localTextView.setText(this.u);
      if (localLinearLayout.getVisibility() != 0) {
        localLinearLayout.setVisibility(0);
      }
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() == null)) {
        break label1446;
      }
      new ArrayList();
      localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label755;
      }
      i1 = 0;
      label464:
      if (i1 >= ((List)localObject2).size()) {
        break label773;
      }
      ((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get();
      if (i1 != 0) {
        break label715;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get());
    }
    for (;;)
    {
      i1 += 1;
      break label464;
      localObject2 = (LinearLayout)findViewById(2131298497);
      localObject1 = (TextView)findViewById(2131298498);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131298499));
      break;
      label577:
      ((LinearLayout)localObject2).setBackgroundResource(2130837944);
      ((LinearLayout)localObject2).setVisibility(0);
      localLinearLayout.setVisibility(8);
      break label391;
      label601:
      if ((this.t != null) && (!this.t.equals(""))) {
        break label391;
      }
      if ((this.u != null) && (!this.u.equals("")))
      {
        ((LinearLayout)localObject2).setVisibility(8);
        localTextView.setText(this.u);
        if (localLinearLayout.getVisibility() == 0) {
          break label391;
        }
        localLinearLayout.setVisibility(0);
        break label391;
      }
      localObject3 = (ViewGroup)findViewById(2131298488);
      ((View)localObject3).setBackgroundResource(2130837942);
      ((View)localObject3).setVisibility(0);
      ((LinearLayout)localObject2).setVisibility(8);
      localLinearLayout.setVisibility(8);
      break label391;
      label715:
      if (i1 == 1)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get());
      }
    }
    label755:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    label773:
    localObject2 = (TextView)findViewById(2131298225);
    if ((this.jdField_f_of_type_Int == 3014) || (this.jdField_f_of_type_Int == 2014))
    {
      ((TextView)localObject2).setVisibility(0);
      label811:
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298507));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298506));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298505));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null))
      {
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.has()) && (!"".equals(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get()))) {
          break label1477;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label969:
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has())) {}
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
      {
      case 4: 
      case 5: 
      default: 
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        label1065:
        this.m = ((TextView)findViewById(2131298489));
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.has() == true))
        {
          this.m.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.get());
          this.m.setVisibility(0);
          label1163:
          localObject2 = ((FriendManager)this.app.getManager(8)).c(this.s);
          if ((localObject2 != null) && (((Friends)localObject2).alias != null) && (((Friends)localObject2).alias.length() != 0)) {
            break label1575;
          }
          this.v = this.s;
          localObject2 = this.app;
          localObject3 = this.app;
          ((FriendListHandler)((QQAppInterface)localObject2).a(1)).a(this.s);
          label1246:
          if (TextUtils.isEmpty(this.q)) {
            break label1587;
          }
          this.l.setText(this.q);
          label1267:
          if ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2007))
          {
            i1 = i2;
            if (this.jdField_f_of_type_Int != 2019) {}
          }
          else
          {
            localObject2 = (FriendManager)this.app.getManager(8);
            if ((localObject2 == null) || (!((FriendManager)localObject2).b(this.s))) {
              break label1601;
            }
            i1 = i2;
          }
          label1346:
          if (i1 == 0) {
            break label1606;
          }
        }
        break;
      }
    }
    label1446:
    label1477:
    label1606:
    for (localObject2 = FaceDrawable.a(this.app, 3000, this.s, true);; localObject2 = FaceDrawable.a(this.app, 1, this.s))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject2);
      ((ViewGroup)findViewById(2131298488)).setOnClickListener(new xo(this));
      if (this.jdField_e_of_type_Int != 2) {
        break label1623;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      ((TextView)localObject1).setText(StringUtil.b(this.t));
      localObject1 = new xp(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject1);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      ((TextView)localObject2).setVisibility(8);
      break label811;
      if ((!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() != 1)) {
        break label969;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label969;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      break label1065;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      break label1065;
      this.m.setVisibility(8);
      a();
      break label1163;
      this.v = ((Friends)localObject2).alias;
      break label1246;
      this.l.setText(this.s);
      break label1267;
      i1 = 1;
      break label1346;
    }
    label1575:
    label1587:
    label1601:
    label1623:
    ((TextView)localObject1).setText(StringUtil.b(this.t));
    if ((this.t == null) || ("".equals(this.t))) {
      ((TextView)localObject1).setVisibility(8);
    }
    localObject1 = new xq(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject1);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject1);
  }
  
  private boolean c()
  {
    long l1 = FriendSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      List localList = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localList != null) && (1 < localList.size()))
      {
        ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(1)).action_info.get()).blacklist.set(true);
        this.jdField_a_of_type_Boolean = true;
        this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(1)).action_info.get(), 1);
        return true;
      }
    }
    return false;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    int i2 = -1;
    Card localCard = ((FriendManager)this.app.getManager(8)).a(this.s);
    Object localObject1;
    if (localCard != null)
    {
      localObject1 = "";
      if ((localCard == null) || ((localCard.shGender != 0) && (localCard.shGender != 1))) {
        break label392;
      }
    }
    label392:
    for (int i1 = localCard.shGender;; i1 = -1)
    {
      if (i1 == 0)
      {
        localObject1 = getString(2131363209);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject1 = "";
        i1 = i2;
        if (localCard != null) {
          i1 = localCard.age;
        }
        if (i1 <= 0) {
          break label353;
        }
        localObject1 = i1 + getString(2131363211);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject2 = "";
        localObject1 = localObject2;
        if (localCard.strProvince != null)
        {
          localObject1 = localObject2;
          if (localCard.strProvince.length() > 0) {
            localObject1 = "" + localCard.strProvince;
          }
        }
        localObject2 = localObject1;
        if (localCard.strCity != null)
        {
          localObject2 = localObject1;
          if (localCard.strCity.length() > 0) {
            localObject2 = (String)localObject1 + "" + localCard.strCity;
          }
        }
        this.g.setText((CharSequence)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.AddRequestActivity", 2, "age:" + localCard.age + "gender:" + localCard.shGender);
        }
        return;
        if (i1 == 1)
        {
          localObject1 = getString(2131363210);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        label353:
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject1 = this.app;
      Object localObject2 = this.app;
      ((FriendListHandler)((QQAppInterface)localObject1).a(1)).a(this.s);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
    finish();
  }
  
  public void a(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3)
  {
    Intent localIntent = new Intent(this, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("infotime", paramLong1);
    localIntent.putExtra("refuse_reason", paramString2);
    localIntent.putExtra("db_id", paramLong2);
    localIntent.putExtra("src_name", paramString3);
    startActivityForResult(localIntent, 0);
  }
  
  public void a(String paramString1, long paramLong1, byte[] paramArrayOfByte, String paramString2, long paramLong2, long paramLong3, String paramString3)
  {
    Intent localIntent = new Intent(this, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 2);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("lToMobile", paramLong1);
    localIntent.putExtra("sig", paramArrayOfByte);
    localIntent.putExtra("nick_name", paramString2);
    localIntent.putExtra("infotime", paramLong2);
    localIntent.putExtra("db_id", paramLong3);
    localIntent.putExtra("src_name", paramString3);
    startActivityForResult(localIntent, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  public void b()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Float = localDisplayMetrics.density;
    this.jdField_a_of_type_Float = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i1 = getResources().getDimensionPixelSize(2131492943);
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - i1 * 1 - 175.0F * this.jdField_c_of_type_Float);
  }
  
  public void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624120);
    localActionSheet.a(getString(2131363507));
    localActionSheet.a(getString(2131363506), 3);
    localActionSheet.a(new xr(this, localActionSheet));
    localActionSheet.d(2131362801);
    localActionSheet.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    long l1 = FriendSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
    this.jdField_b_of_type_Long = getIntent().getLongExtra("infoid", 0L);
    this.s = getIntent().getStringExtra("infouin");
    this.jdField_c_of_type_Long = getIntent().getLongExtra("infotime", 0L);
    this.t = getIntent().getStringExtra("verify_msg");
    this.jdField_e_of_type_Int = getIntent().getIntExtra("verify_type", 1);
    this.u = getIntent().getStringExtra("msg_source");
    this.jdField_f_of_type_Int = getIntent().getIntExtra("msg_source_id", 10004);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("msg_type", -1006);
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("sig");
    this.jdField_a_of_type_Long = getIntent().getLongExtra("lToMobile", 0L);
    this.q = getIntent().getStringExtra("strNickName");
    this.x = getIntent().getStringExtra("info_dealwith_msg");
    this.jdField_d_of_type_Long = getIntent().getLongExtra("msg_troopuin", 0L);
    this.w = getIntent().getStringExtra("msg_title");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    setContentView(2130903551);
    d(2130837660);
    this.n = ((TextView)findViewById(2131298504));
    if ((this.x != null) && (!this.x.equals("")))
    {
      this.n.setText(this.x);
      this.n.setVisibility(0);
    }
    setTitle(this.w);
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a(getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131363029)).setMessage(2131363030).setPositiveButton(2131363031, new xl(this)).setNegativeButton(2131363124, new xk(this));
      return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    }
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624120);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903049);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296473)).setText(2131363035);
    return this.jdField_a_of_type_AndroidAppDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity
 * JD-Core Version:    0.7.0.1
 */
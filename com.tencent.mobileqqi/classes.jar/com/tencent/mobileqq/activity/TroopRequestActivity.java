package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import dsk;
import dsl;
import dsm;
import dsn;
import dso;
import dsp;
import dsq;
import dsr;
import dss;
import dst;
import dsu;
import dsv;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopRequestActivity
  extends IphoneTitleBarActivity
  implements AppConstants, FaceDecoder.DecodeTaskCompletionListener
{
  public static final String a = "troopMsgId";
  public static final int b = 0;
  public static final String b = "troopMsgTpype";
  public static final boolean b = true;
  public static final int c = 1;
  protected static long c = 0L;
  public static final String c = "troopCode";
  private static final int jdField_d_of_type_Int = 2;
  public static long d = 0L;
  public static final String d = "troopmanagerUin";
  private static final int jdField_e_of_type_Int = 0;
  public static final String e = "troopsMsg";
  public static final String f = "troopRequestUin";
  public static final String g = "troopAuth";
  public static final String h = "troopOp";
  public static final String i = "troopsummary";
  public static final String j = "is_unread";
  public static final String k = "infotime";
  public static final String l = "troopMsgDealInfo";
  public static final String m = "troopMsgDealType";
  public static final String n = "troopinvatememUin";
  public static final String o = "troop_describe_uintype";
  private static final String r = "Q.systemmsg.TroopRequestActivity";
  private String A = "";
  public int a;
  public long a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dsr(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dsn(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new dsm(this);
  public TroopHandler a;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dsl(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
  private short jdField_a_of_type_Short;
  public boolean a;
  public byte[] a;
  public long b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new dss(this);
  private Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private TextView c;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int jdField_f_of_type_Int = 0;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private TextView g;
  private TextView h;
  private TextView i;
  public String p;
  public String q;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private String y = null;
  private String z = "";
  
  static
  {
    jdField_c_of_type_Long = 0L;
    jdField_d_of_type_Long = 0L;
  }
  
  public TroopRequestActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new dsv(this);
  }
  
  private void a(Card paramCard)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = "";
    if ((paramCard != null) && ((paramCard.shGender == 0) || (paramCard.shGender == 1))) {}
    for (int i1 = paramCard.shGender;; i1 = -1)
    {
      if (i1 == 0)
      {
        str = getString(2131562338);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (paramCard == null) {
          break label160;
        }
      }
      label160:
      for (i1 = paramCard.age;; i1 = -1)
      {
        if (i1 > 0)
        {
          paramCard = i1 + getString(2131561415);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCard);
          return;
          if (i1 == 1)
          {
            str = getString(2131562104);
            break;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText("");
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText("");
        return;
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(Long.valueOf(l1));
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
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    long l1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(Long.valueOf(l1));
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
        if (localList.size() < 0)
        {
          ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(0)).action_info.get()).blacklist.set(true);
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(0)).action_info.get(), 0);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void i()
  {
    long l1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(Long.valueOf(l1));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null)
    {
      finish();
      return;
    }
    Object localObject2 = (TextView)findViewById(2131232902);
    Object localObject1 = (LinearLayout)findViewById(2131233201);
    ((LinearLayout)localObject1).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.q = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    this.p = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    this.t = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    this.u = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    this.v = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    ImageView localImageView1;
    TextView localTextView;
    ImageView localImageView2;
    Object localObject3;
    int i1;
    if (this.v.startsWith(getString(2131561518)))
    {
      this.v = this.v.replace(getString(2131561518), "");
      this.jdField_b_of_type_Long = getIntent().getLongExtra("infotime", 0L);
      ((TextView)localObject2).setText(TimeFormatterUtils.a(this, 3, this.jdField_b_of_type_Long * 1000L));
      this.jdField_a_of_type_Long = getIntent().getLongExtra("troopMsgId", 0L);
      this.w = getIntent().getExtras().getString("troopMsgDealInfo");
      setTitle(a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()));
      localImageView1 = (ImageView)findViewById(2131230985);
      localTextView = (TextView)findViewById(2131231090);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233195));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233196));
      localObject2 = (TextView)findViewById(2131233203);
      localImageView2 = (ImageView)findViewById(2131231399);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131233202));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131233182));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject3 == null) || (((List)localObject3).size() < 2)) {
        break label670;
      }
      i1 = 0;
      label481:
      if (i1 >= ((List)localObject3).size()) {
        break label759;
      }
      localObject5 = ((structmsg.SystemMsgAction)((List)localObject3).get(i1)).detail_name.get();
      if (i1 != 0) {
        break label594;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject5);
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject5);
    }
    for (;;)
    {
      ((LinearLayout)localObject1).setVisibility(0);
      i1 += 1;
      break label481;
      if (!this.v.startsWith(getString(2131561511))) {
        break;
      }
      this.v = this.v.replace(getString(2131561511), "");
      break;
      label594:
      if (i1 == 1)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject5);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject5);
      }
      else if (i1 == 2)
      {
        this.m.setVisibility(0);
        this.m.setText((CharSequence)localObject5);
        this.m.setContentDescription((CharSequence)localObject5);
        this.m.setEnabled(true);
      }
    }
    label670:
    if ((localObject3 != null) && (((List)localObject3).size() == 1))
    {
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setTextAppearance(this, 2131624326);
      ((TextView)localObject2).setText(((structmsg.SystemMsgAction)((List)localObject3).get(0)).detail_name.get());
      ((TextView)localObject2).setContentDescription(((structmsg.SystemMsgAction)((List)localObject3).get(0)).detail_name.get());
      ((TextView)localObject2).setBackgroundResource(2130837807);
      ((TextView)localObject2).setVisibility(0);
      label759:
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233096));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233100));
      this.e = ((TextView)findViewById(2131233199));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233200));
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
      localObject5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
      if (localObject1 != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (a((String)localObject5))
        {
          localObject1 = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get(), true);
          this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1900;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(3);
          this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(false);
        }
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get())) {
        break label1912;
      }
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get();
      label982:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1919;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      label999:
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get())) {
        break label1980;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131624330);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130837815);
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) || ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 22))) {
        break label1968;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
      label1130:
      localObject1 = new dsk(this, (TextView)localObject2);
      if ((localObject3 != null) && (((List)localObject3).size() == 1)) {
        ((TextView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject1);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject1);
      this.m.setOnClickListener((View.OnClickListener)localObject1);
      localObject2 = new dso(this);
      localObject3 = new dsp(this);
      localObject5 = new dsq(this);
      localObject1 = null;
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
        break label2013;
      }
      localObject1 = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get(), true);
      label1264:
      this.e.setVisibility(0);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label2076;
      }
      this.e.setText("");
      this.jdField_a_of_type_AndroidViewView = ((LinearLayout)findViewById(2131233193));
      switch (TroopNotificationUtils.a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()))
      {
      default: 
        getString(2131561517);
        localObject1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + getString(2131560582);
        localObject5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
        if ((localObject5 == null) || (((String)localObject5).equals("")))
        {
          localTextView.setText(this.p);
          label1443:
          localObject5 = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          if (localObject5 == null) {
            break label2770;
          }
        }
        break;
      }
    }
    label914:
    label1564:
    label1656:
    label1919:
    Object localObject6;
    label1289:
    label1968:
    label1980:
    label2248:
    label2506:
    label2770:
    for (Object localObject5 = ((FriendsManagerImp)localObject5).a(String.valueOf(this.p));; localObject6 = null)
    {
      int i2;
      if ((localObject5 != null) && (((TroopInfo)localObject5).dwGroupClassExt != 0L))
      {
        localObject5 = GroupCatalogTool.a(BaseApplication.getContext()).a(this, Long.toString(((TroopInfo)localObject5).dwGroupClassExt));
        if (localObject5 != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(((GroupCatalogBean)localObject5).a() + "");
        }
        localObject5 = localObject2;
        i1 = 4;
        localObject2 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject5;
        localImageView1.setBackgroundDrawable(TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, (String)localObject3, i1));
        localImageView1.setOnClickListener((View.OnClickListener)localObject1);
        localImageView1.setContentDescription((CharSequence)localObject2);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)localObject1);
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_ext_flag.get() & 0x800) == 0) {
          break label2723;
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.group_auth_type.get() != 2) {
          break label2676;
        }
        localImageView2.setVisibility(0);
        localImageView2.setBackgroundResource(2130838181);
        this.i = ((TextView)findViewById(2131233187));
        this.h = ((TextView)findViewById(2131233186));
        this.g = ((TextView)findViewById(2131233185));
        this.i.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.g.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        i2 = 0;
        this.i.setVisibility(8);
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        this.z = "";
        i1 = i2;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1)
        {
          if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 22)) {
            break label2733;
          }
          this.z = this.u;
          this.A = "1";
          this.jdField_f_of_type_Int = 2131561625;
          i1 = 1;
        }
      }
      while (i1 != 0)
      {
        for (;;)
        {
          for (;;)
          {
            this.i.setVisibility(0);
            this.h.setVisibility(0);
            this.g.setVisibility(0);
            return;
            if ((localObject2 == null) || (this.w.equals(""))) {
              break;
            }
            ((TextView)localObject2).setTextAppearance(getApplicationContext(), 2131624129);
            ((TextView)localObject2).setText(this.w);
            ((TextView)localObject2).setContentDescription(this.w);
            ((TextView)localObject2).setVisibility(0);
            break;
            label1900:
            this.jdField_c_of_type_AndroidWidgetTextView.setText("");
            break label914;
            label1912:
            localObject1 = "";
            break label982;
            localObject1 = "\"" + localObject1 + "\"";
            this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            break label999;
            this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
            break label1130;
            this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131624326);
            this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837807);
            this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
            break label1130;
            label2013:
            if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get())) {
              break label1264;
            }
            localObject1 = getResources().getString(2131562960) + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
            break label1264;
            if (a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
              this.e.setMovementMethod(LinkMovementMethod.getInstance());
            }
            this.e.setTextAppearance(getApplicationContext(), 2131624129);
            this.e.setText((CharSequence)localObject1);
            break label1289;
            getString(2131561518);
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "";
            localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + getString(2131560583);
            localObject5 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
            if ((localObject5 == null) || (((String)localObject5).equals(""))) {
              localTextView.setText((CharSequence)localObject1);
            }
            try
            {
              if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
              {
                localObject5 = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
                if (localObject5 != null)
                {
                  localObject5 = ((FriendManager)localObject5).a((String)localObject1);
                  if ((localObject5 == null) || (((Card)localObject5).age <= 0) || ((((Card)localObject5).shGender != 0) && (((Card)localObject5).shGender != 1))) {
                    break label2348;
                  }
                  a((Card)localObject5);
                }
              }
              for (;;)
              {
                i1 = 1;
                localObject5 = localObject1;
                localObject1 = localObject3;
                localObject3 = localObject5;
                break;
                localTextView.setText((CharSequence)localObject5);
                break label2248;
                ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a((String)localObject1);
              }
            }
            catch (Exception localException2)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TroopRequestActivity", 2, "getCard Exception! ");
              }
              i1 = 1;
              localObject6 = localObject1;
              localObject1 = localObject3;
              localObject3 = localObject6;
            }
          }
          getString(2131561511);
          localObject1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
          localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + getString(2131560584);
          localObject3 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
          if ((localObject3 == null) || (((String)localObject3).equals(""))) {
            localTextView.setText((CharSequence)localObject1);
          }
          try
          {
            if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
            {
              localObject3 = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
              if (localObject3 != null)
              {
                localObject3 = ((FriendManager)localObject3).a((String)localObject1);
                if (localObject3 == null) {
                  break label2577;
                }
                a((Card)localObject3);
              }
            }
            for (;;)
            {
              i1 = 1;
              localObject3 = localObject1;
              localObject1 = localObject6;
              break;
              localTextView.setText((CharSequence)localObject3);
              break label2506;
              ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a((String)localObject1);
            }
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TroopRequestActivity", 2, "getCard Exception! ");
            }
            i1 = 1;
            localObject4 = localObject1;
            localObject1 = localObject6;
          }
        }
        localTextView.setText(localObject6);
        break label1443;
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.c(this.p);
        }
        i1 = 4;
        localObject6 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        Object localObject4 = localObject6;
        break label1564;
        label2676:
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.group_auth_type.get() == 1)
        {
          localImageView2.setVisibility(0);
          localImageView2.setBackgroundResource(2130838357);
          break label1656;
        }
        localImageView2.setVisibility(8);
        break label1656;
        localImageView2.setVisibility(8);
        break label1656;
        i1 = i2;
        if (this.jdField_a_of_type_Int == 2)
        {
          this.z = this.t;
          this.A = "0";
          this.jdField_f_of_type_Int = 2131561626;
          i1 = 1;
        }
      }
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this, AddFriendLogicActivity.class);
    localIntent.putExtra("uin", this.p);
    localIntent.putExtra("troop_code", this.p);
    localIntent.putExtra("name", this.s);
    localIntent.putExtra("group_option", this.jdField_a_of_type_Short);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("join_group_question", this.x);
    startActivityForResult(localIntent, 0);
  }
  
  public SpannableString a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    Matcher localMatcher = Pattern.compile(paramString3).matcher(paramString1);
    Object localObject;
    int i2;
    boolean bool1;
    if (localMatcher.find())
    {
      localObject = new StringBuilder(paramString1);
      ((StringBuilder)localObject).insert(localMatcher.end(), " " + paramString2);
      ((StringBuilder)localObject).toString().length();
      localObject = new SpannableString(((StringBuilder)localObject).toString());
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      i2 = (int)(localDisplayMetrics.density * 17.0F);
      bool1 = paramString3.equals(getString(2131561517));
      if (!bool1) {
        break label246;
      }
    }
    label246:
    for (int i1 = 4;; i1 = 1)
    {
      boolean bool2 = paramString1.contains("处理人");
      paramString1 = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, paramString4, i1);
      paramString1.setBounds(0, 0, i2, i2);
      if (paramBoolean) {
        ((SpannableString)localObject).setSpan(new TroopRequestActivity.NumberSpan(this, bool2, paramString2, paramString4, bool1), localMatcher.end() + 1, localMatcher.end() + paramString2.length() + 1, 33);
      }
      ((SpannableString)localObject).setSpan(new ImageSpan(paramString1, 0), localMatcher.start(), localMatcher.end(), 33);
      return localObject;
      return null;
    }
  }
  
  public SpannableString a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
            if (!paramString.contains(getString(2131561518))) {
              break;
            }
            str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
          } while (TextUtils.isEmpty(str));
          return a(paramString, str, getString(2131561518), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", paramBoolean);
          if (!paramString.contains(getString(2131561511))) {
            break;
          }
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
        } while (TextUtils.isEmpty(str));
        return a(paramString, str, getString(2131561511), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get() + "", paramBoolean);
        if (!paramString.contains(getString(2131561512))) {
          break;
        }
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
      } while (TextUtils.isEmpty(str));
      return a(paramString, str, getString(2131561512), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get() + "", paramBoolean);
      if (!paramString.contains(getString(2131561517))) {
        break;
      }
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
    } while (TextUtils.isEmpty(str));
    return a(paramString, str, getString(2131561517), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", paramBoolean);
    return new SpannableString(paramString);
  }
  
  public String a(int paramInt)
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 8: 
    case 9: 
    case 14: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    default: 
      return getString(2131560761);
    case 1: 
    case 22: 
      return getString(2131560752);
    case 2: 
      return getString(2131560753);
    case 11: 
      return getString(2131560756);
    case 12: 
      return getString(2131560755);
    case 10: 
      return getString(2131560754);
    case 3: 
      return getString(2131560757);
    case 15: 
    case 16: 
      return getString(2131560758);
    case 6: 
    case 7: 
      return getString(2131560759);
    }
    return getString(2131560760);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    paramBitmap = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    if (paramString != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if (a(paramBitmap))
      {
        paramString = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get(), true);
        this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    else
    {
      paramString = null;
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
        break label163;
      }
      paramString = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get(), true);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label225;
      }
      this.e.setText("");
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      break;
      label163:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get())) {
        paramString = getResources().getString(2131562960) + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
      }
    }
    label225:
    if (a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
      this.e.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.e.setTextAppearance(getApplicationContext(), 2131624129);
    this.e.setText(paramString);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).b(d());
    finish();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  boolean a(String paramString)
  {
    return (paramString.contains(getString(2131561518))) || (paramString.contains(getString(2131561512))) || (paramString.contains(getString(2131561517))) || (paramString.contains(getString(2131561511)));
  }
  
  public void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    String str = "";
    if (this.jdField_f_of_type_Int != 0) {
      str = getString(this.jdField_f_of_type_Int);
    }
    localActionSheet.a(str);
    localActionSheet.a(getString(2131561560), 3);
    localActionSheet.a(new dst(this, localActionSheet));
    localActionSheet.d(2131561746);
    localActionSheet.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903635);
    j(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19));
    i();
    if (getIntent().getExtras().getBoolean("groupman_refuse", false))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131562771), 3);
    localActionSheet.a(new dsu(this, localActionSheet));
    localActionSheet.d(2131561746);
    localActionSheet.show();
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131562875));
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), d());
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562645);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
  
  public void h()
  {
    try
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contact;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.circle.IFriendObserver;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import ecu;
import ecv;
import ecw;
import ecx;
import ecz;
import eda;
import edb;
import edc;
import edd;
import ede;
import java.util.ArrayList;
import java.util.List;

public class CircleMemberListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  static final long jdField_a_of_type_Long = 1000L;
  public static final String a = "k_group_name";
  public static final String b = "k_group_id";
  static final boolean jdField_b_of_type_Boolean = true;
  static final int jdField_c_of_type_Int = 1000;
  private static final int jdField_d_of_type_Int = 0;
  private static final String jdField_d_of_type_JavaLangString = "CircleMemberListActivity";
  private static final int e = 1;
  public volatile int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new ecx(this);
  public View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public SearchResultDialog a;
  public CircleManager a;
  FriendManager jdField_a_of_type_ComTencentMobileqqModelFriendManager;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ecw(this);
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private IFriendObserver jdField_a_of_type_ComTencentMobileqqServiceCircleIFriendObserver = new ecv(this);
  IGroupObserver jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver = new ecu(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public edd a;
  public ArrayList a;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  public int b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int f;
  private int g;
  
  public CircleMemberListActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      return;
    }
    Contacts.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = new ecz(this, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setCanceledOnTouchOutside(true);
    paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new eda(this));
    localTranslateAnimation2.setAnimationListener(new edb(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setOnDismissListener(new edc(this, paramInt, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation1);
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837862);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.g = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.g);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, true);
    if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.c(i) == 0)) {
      c();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_Edd = new edd(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Edd);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231116);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231373));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231375));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231455));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131561692);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231456));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.d = ((TextView)findViewById(2131231379));
      if (!this.jdField_a_of_type_Boolean) {
        break label352;
      }
      this.d.setText(2131561746);
      this.d.setVisibility(0);
      this.d.setOnClickListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231460));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      IphoneTitleBarActivity.b(this.jdField_c_of_type_AndroidWidgetTextView);
      IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidWidgetImageView);
      IphoneTitleBarActivity.b(this.jdField_b_of_type_AndroidWidgetTextView);
      findViewById(2131231116).setBackgroundResource(2130837852);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232905));
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837729);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      findViewById(2131231459).setVisibility(0);
      findViewById(2131231459).setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("返回" + this.jdField_c_of_type_AndroidWidgetTextView.getText());
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.d.setContentDescription("取消本次转发");
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558934));
      break;
      label352:
      this.d.setVisibility(8);
    }
  }
  
  private void g()
  {
    Object localObject = (ViewGroup)findViewById(2131231447);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
    localObject = findViewById(2131231373);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
    localObject = (TextView)findViewById(2131231455);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
  }
  
  public View a()
  {
    View localView = getLayoutInflater().inflate(2130903555, null);
    ede localede = new ede(null);
    localede.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131230940));
    localede.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131231394));
    localede.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131231395));
    localede.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131232033));
    localede.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131232034));
    localede.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localede.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    localView.setTag(localede);
    localView.setOnClickListener(this);
    localede.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localede.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    return localView;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList1 == null) || (paramInt1 < 0) || (paramInt1 > localArrayList1.size()) || (paramInt2 < 0) || (paramInt2 > localArrayList1.size())) {}
    ArrayList localArrayList2;
    int i;
    label114:
    do
    {
      int j;
      do
      {
        return;
        localArrayList2 = new ArrayList(50);
        i = paramInt1;
        for (;;)
        {
          if (i > paramInt2) {
            break label114;
          }
          if (this.jdField_a_of_type_Int != 0) {
            break;
          }
          localCircleBuddy = (CircleBuddy)localArrayList1.get(i);
          if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy.uin) == 2) {
            localArrayList2.add(localCircleBuddy.uin);
          }
          i += 1;
        }
        j = localArrayList2.size();
      } while (j == 0);
      i = j;
      if (paramInt2 + 1 < localArrayList1.size())
      {
        i = paramInt2 + 1;
        for (paramInt2 = j;; paramInt2 = j)
        {
          if ((i >= localArrayList1.size()) || (paramInt2 >= 50)) {
            break label231;
          }
          if (this.jdField_a_of_type_Int != 0) {
            break;
          }
          localCircleBuddy = (CircleBuddy)localArrayList1.get(i);
          j = paramInt2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy.uin) == 2)
          {
            localArrayList2.add(localCircleBuddy.uin);
            j = paramInt2 + 1;
          }
          i += 1;
        }
        i = paramInt2;
      }
      if ((i >= 50) || (paramInt1 <= 0)) {
        break;
      }
      paramInt2 = paramInt1 - 1;
      if ((paramInt2 < 0) || (i >= 50)) {
        break;
      }
    } while (this.jdField_a_of_type_Int != 0);
    label231:
    CircleBuddy localCircleBuddy = (CircleBuddy)localArrayList1.get(paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy.uin) == 2) {
      localArrayList2.add(localCircleBuddy.uin);
    }
    for (paramInt1 = i + 1;; paramInt1 = i)
    {
      paramInt2 -= 1;
      i = paramInt1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localArrayList2);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Int != 2))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof ede)))
        {
          localObject = (ede)localObject;
          if (((ede)localObject).jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin.equals(paramString)) {
            ((ede)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(View paramView, CircleBuddy paramCircleBuddy)
  {
    ede localede = (ede)paramView.getTag();
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramCircleBuddy.uin);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (this.jdField_a_of_type_Int != 2) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramCircleBuddy.uin, 1, false, (byte)1);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    localede.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    localede.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy));
    a(localede, paramCircleBuddy);
    localede.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy = paramCircleBuddy;
    paramCircleBuddy = localede.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    paramView.setContentDescription(paramCircleBuddy + ",连按两次进入资料卡");
    localede.jdField_a_of_type_AndroidWidgetButton.setContentDescription("向" + paramCircleBuddy + "发消息按钮");
    localede.jdField_b_of_type_AndroidWidgetButton.setContentDescription("添加" + paramCircleBuddy + "为好友");
  }
  
  void a(CircleBuddy paramCircleBuddy)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.b(paramCircleBuddy.uin);
    Intent localIntent = new Intent(a(), ChatActivity.class);
    localIntent.putExtra("uin", paramCircleBuddy.uin);
    if (bool)
    {
      paramCircleBuddy = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(paramCircleBuddy.uin);
      if (paramCircleBuddy != null)
      {
        localIntent.putExtra("cSpecialFlag", paramCircleBuddy.cSpecialFlag);
        localIntent.putExtra("uinname", ContactUtils.a(paramCircleBuddy));
      }
      if (!bool) {
        break label170;
      }
    }
    label170:
    for (int i = 0;; i = 1021)
    {
      localIntent.putExtra("uintype", i);
      startActivity(localIntent);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Circle_list_send", 0, 0, "", "", "", "");
      return;
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy));
      break;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt = 0;
    while (paramInt < i)
    {
      ede localede = (ede)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
      if (localede != null)
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, localede.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin);
        paramAbsListView = localBitmap;
        if (localBitmap == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(localede.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin, 1, false, (byte)1);
          if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
            this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
          }
          paramAbsListView = this.jdField_a_of_type_AndroidGraphicsBitmap;
        }
        localede.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramAbsListView);
        if (localede.jdField_b_of_type_AndroidWidgetTextView.getText().length() == 0) {
          localede.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localede.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin, 0).a(""));
        }
      }
      paramInt += 1;
    }
    d();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(ede paramede, CircleBuddy paramCircleBuddy)
  {
    paramCircleBuddy = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy.uin, this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(paramCircleBuddy.jdField_c_of_type_JavaLangString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramCircleBuddy.jdField_b_of_type_Int, 200);
      localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
      int i = this.f;
      ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
      paramede.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
    for (paramede.jdField_a_of_type_Int = paramCircleBuddy.jdField_b_of_type_Int;; paramede.jdField_a_of_type_Int = 0)
    {
      paramCircleBuddy = paramCircleBuddy.a(null);
      paramede.jdField_b_of_type_AndroidWidgetTextView.setText(paramCircleBuddy);
      if (this.jdField_a_of_type_Int == 0) {
        d();
      }
      return;
      paramede.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  void b(CircleBuddy paramCircleBuddy)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.b(paramCircleBuddy.uin))
    {
      QQToast.a(this, 2131561423, 0).b(d());
      return;
    }
    Intent localIntent = new Intent(this, AddFriendLogicActivity.class);
    localIntent.putExtra("uin", paramCircleBuddy.uin);
    localIntent.putExtra("source_id", 3003);
    localIntent.putExtra("sub_source_id", 2);
    localIntent.putExtra("nick_name", this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy));
    startActivity(localIntent);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Circle_list_add", 0, 0, "", "", "", "");
  }
  
  void c(CircleBuddy paramCircleBuddy)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.b(paramCircleBuddy.uin);
    Object localObject;
    ForwardOperations localForwardOperations;
    if (bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(paramCircleBuddy.uin);
      if (localObject != null)
      {
        localObject = ContactUtils.a((Friends)localObject);
        localForwardOperations = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
        paramCircleBuddy = paramCircleBuddy.uin;
        if (!bool) {
          break label101;
        }
      }
    }
    label101:
    for (int i = 0;; i = 1021)
    {
      localForwardOperations.a(paramCircleBuddy, i, "", (String)localObject);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy);
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramCircleBuddy);
      break;
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1000)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 1000L);
  }
  
  void d(CircleBuddy paramCircleBuddy)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.b(paramCircleBuddy.uin);
    Object localObject = paramCircleBuddy.uin;
    if (bool) {}
    for (int i = 1;; i = 71)
    {
      localObject = new ProfileActivity.AllInOne((String)localObject, i);
      ((ProfileActivity.AllInOne)localObject).m = paramCircleBuddy.remark;
      ((ProfileActivity.AllInOne)localObject).g = paramCircleBuddy.nickName;
      ((ProfileActivity.AllInOne)localObject).f = 84;
      ProfileActivity.a(a(), (ProfileActivity.AllInOne)localObject);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903554);
    getWindow().setBackgroundDrawable(null);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("k_group_id", 0);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("k_group_name");
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.f = ((int)DisplayUtils.a(this, 12.0F));
    f();
    e();
    g();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.b(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.b(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      paramView = (ede)paramView.getTag();
      if (this.jdField_a_of_type_Boolean)
      {
        setResult(1);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Forward_frd_send", 0, 0, "", "", "", "");
        c(paramView.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy);
      }
      break;
    case 2131232033: 
    case 2131232034: 
    case 2131231459: 
    case 2131231455: 
    case 2131231379: 
      do
      {
        return;
        a(((ede)((View)paramView.getParent()).getTag()).jdField_a_of_type_ComTencentMobileqqDataCircleBuddy);
        return;
        b(((ede)((View)paramView.getParent()).getTag()).jdField_a_of_type_ComTencentMobileqqDataCircleBuddy);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          a(14);
          return;
        }
        a(13);
        return;
        finish();
        return;
      } while (!this.jdField_a_of_type_Boolean);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.u == 11))
      {
        ForwardOperations.a(this, false, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a);
        com.tencent.mobileqq.app.PhoneContactManagerImp.c = false;
      }
      setResult(1);
      finish();
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Prof_in_client", 84, 0, "", "", "", "");
    d(paramView.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.CircleMemberListActivity
 * JD-Core Version:    0.7.0.1
 */
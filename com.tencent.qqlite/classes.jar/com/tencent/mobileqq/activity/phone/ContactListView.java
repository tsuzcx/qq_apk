package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import chp;
import chq;
import chs;
import cht;
import chu;
import chv;
import chw;
import chx;
import chy;
import chz;
import cia;
import cic;
import cid;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@SuppressLint({"ViewConstructor"})
public class ContactListView
  extends BaseActivityView
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, IndexView.OnIndexChangedListener, AbsListView.OnScrollListener
{
  private static final Integer jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
  private static final String jdField_a_of_type_JavaLangString = "未启用通讯录的联系人";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  private static final Integer jdField_b_of_type_JavaLangInteger = Integer.valueOf(2);
  private static final String jdField_b_of_type_JavaLangString = "QQ好友";
  private static final Integer jdField_c_of_type_JavaLangInteger;
  private static final String jdField_c_of_type_JavaLangString = "手机联系人";
  static final int g = 1;
  public static final int h = 2;
  static final int i = 3;
  static final int j = 4;
  public static final int k = 5;
  private static final int m = 1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public chy a;
  chz jdField_a_of_type_Chz;
  private cia jdField_a_of_type_Cia;
  public cid a;
  public ForwardOperations a;
  private PhoneFrameActivity jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new chp(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public List a;
  private boolean jdField_a_of_type_Boolean = false;
  public List b;
  public int l;
  private int n = 0;
  
  static
  {
    c = Integer.valueOf(3);
  }
  
  public ContactListView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    if ((paramInt == 2) && ((paramContext instanceof PhoneFrameActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity = ((PhoneFrameActivity)paramContext);
    }
    a(2130903256);
    this.jdField_a_of_type_Cid = new cid(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297394));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131297395));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, true, false, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    if ((paramInt == 0) || (paramInt == 2))
    {
      this.jdField_a_of_type_Chz = new chz(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Chz);
      return;
    }
    this.jdField_a_of_type_Chy = new chy(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Chy);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
  }
  
  private void a(View paramView)
  {
    paramView = (cic)paramView.getTag();
    Object localObject1 = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    int i1 = paramView.jdField_a_of_type_Int;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (i1 == jdField_b_of_type_JavaLangInteger.intValue())
    {
      paramView = "0";
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_msg", 0, 0, paramView, "", "", "");
      if (i1 != jdField_b_of_type_JavaLangInteger.intValue()) {
        break label218;
      }
      paramView = new Intent(getContext(), ChatActivity.class);
      paramView.putExtra("uin", ((PhoneContact)localObject1).uin);
      localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject2 != null)
      {
        localObject1 = ((FriendManager)localObject2).c(String.valueOf(((PhoneContact)localObject1).uin));
        if (localObject1 != null)
        {
          paramView.putExtra("cSpecialFlag", ((Friends)localObject1).cSpecialFlag);
          paramView.putExtra("uinname", ContactUtils.a((Friends)localObject1));
          if (((Friends)localObject1).cSpecialFlag == 1)
          {
            paramView.setClass(getContext(), ChatActivity.class);
            paramView.putExtra("chat_subType", 1);
          }
        }
      }
      paramView.putExtra("entrance", 3);
      paramView.putExtra("uintype", 0);
      a(paramView);
    }
    label218:
    while (i1 != c.intValue())
    {
      return;
      paramView = "1";
      break;
    }
    paramView = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    localObject2 = paramView.nationCode + paramView.mobileNo;
    paramView = new Intent(getContext(), ChatActivity.class);
    paramView.putExtra("entrance", 3);
    paramView.putExtra("uin", ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode);
    paramView.putExtra("phonenum", (String)localObject2);
    paramView.putExtra("uintype", 1006);
    paramView.putExtra("uinname", ((PhoneContact)localObject1).name);
    localObject2 = new ProfileActivity.AllInOne(((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode, 31);
    ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    ((ProfileActivity.AllInOne)localObject2).h = ((PhoneContact)localObject1).nickName;
    ((ProfileActivity.AllInOne)localObject2).k = ((PhoneContact)localObject1).name;
    ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
    ((ProfileActivity.AllInOne)localObject2).d = ((PhoneContact)localObject1).ability;
    ((ProfileActivity.AllInOne)localObject2).f = 3;
    ((ProfileActivity.AllInOne)localObject2).g = 59;
    paramView.putExtra("AIO_INFO", (Parcelable)localObject2);
    paramView.addFlags(67108864);
    a(paramView);
  }
  
  private void a(View paramView, PhoneContact paramPhoneContact)
  {
    cic localcic = (cic)paramView.getTag();
    localcic.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContact.name);
    localcic.jdField_a_of_type_JavaLangString = null;
    localcic.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
    localcic.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramPhoneContact.uin.equals("0")) {
      if (paramPhoneContact.hasSendAddReq)
      {
        localcic.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        localcic.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localcic.jdField_b_of_type_AndroidWidgetTextView.setText("等待验证");
      }
    }
    for (;;)
    {
      paramView.setContentDescription(paramPhoneContact.name);
      if (paramPhoneContact.uin.equals("0")) {
        break;
      }
      localcic.jdField_a_of_type_Int = jdField_b_of_type_JavaLangInteger.intValue();
      a(localcic, paramPhoneContact.uin, Integer.parseInt(paramPhoneContact.faceUrl), 1);
      return;
      localcic.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      localcic.jdField_b_of_type_AndroidWidgetButton.setContentDescription("添加按钮");
      localcic.jdField_b_of_type_AndroidWidgetButton.setTag(localcic);
      localcic.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      continue;
      localcic.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      localcic.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localcic.jdField_b_of_type_AndroidWidgetTextView.setText("已添加");
    }
    localcic.jdField_a_of_type_Int = c.intValue();
    a(localcic, paramPhoneContact.nationCode + paramPhoneContact.mobileCode, 0, 11);
  }
  
  private void a(cic paramcic, String paramString, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt2, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt2, false);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    paramcic.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    paramcic.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(ListView paramListView, String paramString, Bitmap paramBitmap)
  {
    int i2;
    int i1;
    if (this.n == 0)
    {
      i2 = paramListView.getChildCount();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < i2)
      {
        cic localcic = (cic)paramListView.getChildAt(i1).getTag();
        if ((localcic != null) && (paramString.equals(localcic.jdField_a_of_type_JavaLangString))) {
          localcic.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  private void b(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474C", "0X800474C", 0, 0, "", "", "", "");
    paramView = ((cic)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    a(AddFriendLogicActivity.a(getContext(), 2, paramView.nationCode + paramView.mobileCode, null, 3006, 3, paramView.name, null, null, "手机联系人"));
  }
  
  private void c(View paramView)
  {
    paramView = (cic)paramView.getTag();
    if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null)) {}
    PhoneContact localPhoneContact;
    int i1;
    do
    {
      return;
      localPhoneContact = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      i1 = paramView.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      if (i1 == jdField_b_of_type_JavaLangInteger.intValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(localPhoneContact.uin, 0, localPhoneContact.uin, localPhoneContact.name);
        return;
      }
    } while (i1 != c.intValue());
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(localPhoneContact.nationCode + localPhoneContact.mobileCode, 1006, "", localPhoneContact.name);
    return;
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i1 == jdField_b_of_type_JavaLangInteger.intValue())
      {
        paramView = "0";
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_prof", 0, 0, paramView, "", "", "");
        label176:
        paramView = null;
        if (i1 != jdField_b_of_type_JavaLangInteger.intValue()) {
          break label268;
        }
        paramView = new ProfileActivity.AllInOne(localPhoneContact.uin, 1);
      }
    }
    for (;;)
    {
      if (paramView != null) {
        paramView.g = 65;
      }
      ProfileActivity.b(getContext(), paramView);
      return;
      paramView = "1";
      break;
      if (this.jdField_a_of_type_Int != 3) {
        break label176;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474B", "0X800474B", 0, 0, "", "", "", "");
      break label176;
      label268:
      if (i1 == c.intValue())
      {
        paramView = localPhoneContact.nationCode + localPhoneContact.mobileCode;
        if (localPhoneContact.originBinder == 3L) {}
        for (i1 = 32;; i1 = 31)
        {
          paramView = new ProfileActivity.AllInOne(paramView, i1);
          paramView.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          paramView.h = localPhoneContact.nickName;
          paramView.k = localPhoneContact.name;
          paramView.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(localPhoneContact.name, localPhoneContact.mobileCode, localPhoneContact.nationCode));
          paramView.d = localPhoneContact.ability;
          paramView.f = 3;
          break;
        }
      }
      if (i1 == jdField_a_of_type_JavaLangInteger.intValue())
      {
        localObject = new ProfileActivity.AllInOne(localPhoneContact.nationCode + localPhoneContact.mobileCode, 33);
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        ((ProfileActivity.AllInOne)localObject).k = localPhoneContact.name;
        ((ProfileActivity.AllInOne)localObject).h = localPhoneContact.nickName;
        String[] arrayOfString = localPhoneContact.mobileNo.split("\\|");
        i1 = 0;
        if (i1 < arrayOfString.length)
        {
          ArrayList localArrayList = ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_JavaUtilArrayList;
          StringBuilder localStringBuilder = new StringBuilder().append("电话");
          if (arrayOfString.length > 0) {}
          for (paramView = Integer.valueOf(i1 + 1);; paramView = "")
          {
            localArrayList.add(new ProfileActivity.CardContactInfo(paramView, arrayOfString[i1], localPhoneContact.nationCode));
            i1 += 1;
            break;
          }
        }
        ((ProfileActivity.AllInOne)localObject).d = localPhoneContact.ability;
        ((ProfileActivity.AllInOne)localObject).f = 3;
        paramView = (View)localObject;
      }
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    if (this.jdField_a_of_type_Int == 3) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474D", "0X800474D", 0, 0, "", "", "", "");
    }
    Contacts.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i1;
    if (this.jdField_a_of_type_Int == 2) {
      i1 = 11;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog = new chu(this, getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
      localTranslateAnimation1.setDuration(200L);
      localTranslateAnimation1.setFillAfter(true);
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
      localTranslateAnimation2.setDuration(200L);
      localTranslateAnimation1.setAnimationListener(new chv(this));
      localTranslateAnimation2.setAnimationListener(new chw(this, i1));
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new chx(this, i1, localTranslateAnimation2));
      this.jdField_b_of_type_AndroidViewView.startAnimation(localTranslateAnimation1);
      return;
      if (this.jdField_a_of_type_Int == 0) {
        i1 = 5;
      } else {
        i1 = 15;
      }
    }
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130903257, null);
    cic localcic = new cic(null);
    localcic.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297396));
    localcic.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297397));
    localcic.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131297398));
    localcic.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localcic.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131297400));
    localcic.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    localcic.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297399));
    localcic.jdField_a_of_type_AndroidViewView = localView.findViewById(2131297401);
    if (this.jdField_a_of_type_Int == 3)
    {
      localcic.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localcic.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localView.setTag(localcic);
      return localView;
      localcic.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      localcic.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected void a()
  {
    boolean bool2 = true;
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class, this.jdField_a_of_type_Cid);
    boolean bool1;
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("选择通讯录联系人");
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (this.jdField_a_of_type_Cia == null)
      {
        this.jdField_a_of_type_Cia = new cia(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Cia);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      j();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (i1 == 0) {
        break label211;
      }
      bool1 = true;
      label119:
      localImageView.setEnabled(bool1);
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (i1 == 0) {
        break label216;
      }
      bool1 = bool2;
      label137:
      localImageView.setEnabled(bool1);
      if (i1 != 7)
      {
        if (!NetworkUtil.e(getContext())) {
          break label221;
        }
        h();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("通讯录");
        break;
      }
      if (this.jdField_a_of_type_Int != 3) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText("手机联系人");
      break;
      label211:
      bool1 = false;
      break label119;
      label216:
      bool1 = false;
      break label137;
      label221:
      a(2131363461, 3000L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0)) {
      if (paramInt2 == 2)
      {
        paramIntent = new Intent(getContext(), BindNumberActivity.class);
        paramIntent.putExtra("kNeedUnbind", true);
        paramIntent.putExtra("key_is_first_activity", false);
        a(paramIntent);
      }
    }
    do
    {
      do
      {
        return;
        a(new Intent(getContext(), PhoneLaunchActivity.class));
        return;
      } while (paramInt2 != 0);
      paramInt1 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b();
    } while ((paramInt1 != 1) && (paramInt1 != 2));
    a(new Intent(getContext(), PhoneLaunchActivity.class));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentWidgetXListView, paramString, paramBitmap);
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity.getIntent());
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    if ((NetworkUtil.e(getContext())) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h())) {
      a(2131363392, 0L, false);
    }
  }
  
  public void a(View paramView, PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    paramView = (cic)paramView.getTag();
    if (paramBoolean) {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s(%s)", new Object[] { paramPhoneContact.name, paramPhoneContact.mobileNo }));
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = null;
      paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
      if (!TextUtils.isEmpty(paramPhoneContact.uin)) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramView.jdField_a_of_type_Int = jdField_a_of_type_JavaLangInteger.intValue();
      return;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContact.name);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_a_of_type_Int == 0) {
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    paramView.jdField_a_of_type_AndroidWidgetButton.setTag(paramView);
    paramView.jdField_a_of_type_AndroidWidgetButton.setContentDescription("向" + paramPhoneContact.name + "发消息");
    if (!paramPhoneContact.uin.equals("0"))
    {
      paramView.jdField_a_of_type_Int = jdField_b_of_type_JavaLangInteger.intValue();
      a(paramView, paramPhoneContact.uin, 0, 1);
      return;
    }
    paramView.jdField_a_of_type_Int = c.intValue();
    a(paramView, paramPhoneContact.nationCode + paramPhoneContact.mobileCode, 0, 11);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.n = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    int i2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt = 0;
    label52:
    Bitmap localBitmap;
    if (paramInt < i2)
    {
      paramAbsListView = (cic)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.jdField_a_of_type_JavaLangString)))
      {
        int i1 = 1;
        if (paramAbsListView.jdField_a_of_type_Int == c.intValue()) {
          i1 = 11;
        }
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i1, paramAbsListView.jdField_a_of_type_JavaLangString);
        if (localBitmap != null) {
          break label145;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramAbsListView.jdField_a_of_type_JavaLangString, i1, false);
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label52;
      break;
      label145:
      paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      return;
    }
    if ("&".equals(paramString))
    {
      paramString = this.jdField_a_of_type_ComTencentWidgetXListView;
      i1 = this.jdField_a_of_type_ComTencentWidgetXListView.k();
      paramString.setSelection(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get("QQ好友")).intValue() + i1);
      return;
    }
    if ("+".equals(paramString))
    {
      paramString = this.jdField_a_of_type_ComTencentWidgetXListView;
      i1 = this.jdField_a_of_type_ComTencentWidgetXListView.k();
      paramString.setSelection(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get("未启用通讯录的联系人")).intValue() + i1);
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
      i1 = this.jdField_a_of_type_ComTencentWidgetXListView.k();
      localXListView.setSelectionFromTop(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() + i1, Util.a(getContext(), 25.0F));
      return;
    }
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    int i1 = this.jdField_a_of_type_ComTencentWidgetXListView.k();
    localXListView.setSelection(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() + i1);
  }
  
  protected void b()
  {
    super.b();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
    i();
    g();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    m();
    if (this.jdField_a_of_type_Cia != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Cia);
      this.jdField_a_of_type_Cia = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.d();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a();
    }
    super.e();
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 2)) {
      k();
    }
    int i1;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 3);
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    } while (!QLog.isColorLevel());
    QLog.d("ContactListView", 2, "load contact friend result: " + i1);
  }
  
  void k()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_Cid.sendEmptyMessageDelayed(2, 1000L);
      return;
    }
    Object localObject1 = ((List)this.jdField_a_of_type_JavaUtilList.get(0)).iterator();
    int i1 = 0;
    int i2 = 0;
    if (((Iterator)localObject1).hasNext())
    {
      if ("0".equals(((PhoneContact)((Iterator)localObject1).next()).uin)) {
        i2 += 1;
      }
      for (;;)
      {
        break;
        i1 += 1;
      }
    }
    int i3;
    Object localObject2;
    if (this.jdField_a_of_type_Int == 0)
    {
      if (i2 < 10) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
      localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
      int i4 = localObject1.length;
      i3 = 0;
      while (i3 < i4)
      {
        localObject2 = localObject1[i3];
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(0));
        i3 += 1;
      }
    }
    if ((i1 <= 0) && (((List)this.jdField_a_of_type_JavaUtilList.get(1)).size() <= 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, true, false, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.requestLayout();
      break;
      if ((i1 > 0) && (((List)this.jdField_a_of_type_JavaUtilList.get(1)).size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, true, true, true);
      } else if (((List)this.jdField_a_of_type_JavaUtilList.get(1)).size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, true, false, true);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, true, true, false);
      }
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject4;
    Object localObject3;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject4 = ((List)this.jdField_a_of_type_JavaUtilList.get(0)).iterator();
      for (localObject2 = "*"; ((Iterator)localObject4).hasNext(); localObject2 = localObject3)
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject4).next();
        localObject3 = localPhoneContact.pinyinFirst;
        localObject1 = localObject3;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject3) == null)
        {
          localObject1 = "#";
          localPhoneContact.pinyinFirst = "#";
        }
        localObject3 = localObject2;
        if (!((String)localObject2).equals(localObject1))
        {
          localArrayList.add(null);
          localObject3 = localObject1;
        }
        localArrayList.add(localPhoneContact);
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).intValue() + 1));
      }
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      i1 = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label1028;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      i2 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)).intValue();
      if (i2 == 0) {
        break label1069;
      }
    }
    label1028:
    label1064:
    label1069:
    for (i2 = i2 + i1 + 1;; i2 = i1)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(i1));
      i1 = i2;
      break;
      if (this.jdField_a_of_type_Int == 0) {
        if (i2 > 0)
        {
          localArrayList.add(null);
          localObject3 = ((List)this.jdField_a_of_type_JavaUtilList.get(0)).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (PhoneContact)((PhoneContact)((Iterator)localObject3).next()).clone();
            if (((PhoneContact)localObject4).uin.equals("0"))
            {
              localObject2 = ((PhoneContact)localObject4).pinyinFirst;
              localObject1 = localObject2;
              if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject2) == null) {
                localObject1 = "#";
              }
              ((PhoneContact)localObject4).pinyinFirst = "手机联系人";
              localArrayList.add(localObject4);
              this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).intValue() + 1));
            }
          }
          localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
          i2 = 1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            i3 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)).intValue();
            if (i3 == 0) {
              break label1064;
            }
            i3 += i2;
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(i2));
        i2 = i3;
        break;
        if (i1 > 0)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("QQ好友", Integer.valueOf(localArrayList.size()));
          localArrayList.add(null);
          localObject1 = ((List)this.jdField_a_of_type_JavaUtilList.get(0)).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (PhoneContact)((PhoneContact)((Iterator)localObject1).next()).clone();
            if (!((PhoneContact)localObject2).uin.equals("0"))
            {
              localObject3 = ((PhoneContact)localObject2).pinyinFirst;
              ((PhoneContact)localObject2).pinyinFirst = "QQ好友";
              localArrayList.add(localObject2);
            }
          }
        }
        localObject1 = (List)this.jdField_a_of_type_JavaUtilList.get(1);
        if (((List)localObject1).size() > 0)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("未启用通讯录的联系人", Integer.valueOf(localArrayList.size()));
          localArrayList.add(null);
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (PhoneContact)((Iterator)localObject1).next();
            ((PhoneContact)localObject2).pinyinFirst = "未启用通讯录的联系人";
            localArrayList.add(localObject2);
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
        this.l = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (this.l > 0) {
          m();
        }
        this.jdField_a_of_type_Chz.notifyDataSetChanged();
        return;
        i3 = i2;
      }
    }
  }
  
  public void l()
  {
    if ((a()) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) || (this.l > 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getContext(), 231, getContext().getString(2131362088), getContext().getString(2131362087), 2131362089, 2131362090, new chq(this), new chs(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new cht(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Cid.removeMessages(1);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    switch (paramView.getId())
    {
    default: 
      c(paramView);
      return;
    case 2131296909: 
      n();
      return;
    case 2131296910: 
      if (this.jdField_a_of_type_Int == 2)
      {
        n();
        return;
      }
      b(new Intent(getContext(), SettingActivity2.class), 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
      return;
    case 2131297398: 
      a(paramView);
      return;
    }
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView
 * JD-Core Version:    0.7.0.1
 */
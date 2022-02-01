package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
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
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import eko;
import ekq;
import ekr;
import eks;
import ekt;
import eku;
import ekv;
import ekx;
import eky;
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
  private static final Integer b;
  private static final Integer jdField_c_of_type_JavaLangInteger;
  static final int f = 1;
  public static final int g = 2;
  static final int h = 3;
  static final int i = 4;
  private static final int k = 1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public ForwardOperations a;
  private PhoneFrameActivity jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public eku a;
  private ekv jdField_a_of_type_Ekv;
  public eky a;
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public List a;
  private View jdField_c_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = false;
  public int j;
  private int l = 0;
  
  static
  {
    jdField_b_of_type_JavaLangInteger = Integer.valueOf(2);
    jdField_c_of_type_JavaLangInteger = Integer.valueOf(3);
  }
  
  public ContactListView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    this.jdField_d_of_type_Boolean = paramBoolean;
    if ((paramBoolean) && ((paramContext instanceof PhoneFrameActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity = ((PhoneFrameActivity)paramContext);
    }
    a(2130903304);
    this.jdField_a_of_type_Eky = new eky(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232028));
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130903944, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131233085).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131233086));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_Eku = new eku(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Eku);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131232029));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, true);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230734));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setTextView(this.jdField_d_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
  }
  
  private void a(View paramView)
  {
    paramView = (ekx)paramView.getTag();
    Object localObject1 = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    int m = paramView.jdField_a_of_type_Int;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (m == jdField_b_of_type_JavaLangInteger.intValue())
    {
      paramView = "0";
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_msg", 0, 0, paramView, "", "", "");
      if (m != jdField_b_of_type_JavaLangInteger.intValue()) {
        break label220;
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
          if (((Friends)localObject1).cSpecialFlag == 1) {
            paramView.setClass(getContext(), ChatForEnterpriseActivity.class);
          }
        }
      }
      paramView.putExtra("entrance", 3);
      paramView.putExtra("uintype", 0);
      a(paramView);
    }
    label220:
    while (m != jdField_c_of_type_JavaLangInteger.intValue())
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
    ((ProfileActivity.AllInOne)localObject2).g = ((PhoneContact)localObject1).nickName;
    ((ProfileActivity.AllInOne)localObject2).j = ((PhoneContact)localObject1).name;
    ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
    ((ProfileActivity.AllInOne)localObject2).c = ((PhoneContact)localObject1).ability;
    ((ProfileActivity.AllInOne)localObject2).e = 3;
    ((ProfileActivity.AllInOne)localObject2).f = 59;
    paramView.putExtra("AIO_INFO", (Parcelable)localObject2);
    paramView.addFlags(67108864);
    a(paramView);
  }
  
  private void a(ListView paramListView, String paramString, Bitmap paramBitmap)
  {
    int n;
    int m;
    if (this.l == 0)
    {
      n = paramListView.getChildCount();
      m = 0;
    }
    for (;;)
    {
      if (m < n)
      {
        ekx localekx = (ekx)paramListView.getChildAt(m).getTag();
        if ((localekx != null) && (paramString.equals(localekx.jdField_a_of_type_JavaLangString))) {
          localekx.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      m += 1;
    }
  }
  
  private void a(ekx paramekx, String paramString, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt2, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt2, false);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    paramekx.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    paramekx.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void b(View paramView)
  {
    Object localObject = (ekx)paramView.getTag();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int n;
    int m;
    if (((ekx)localObject).jdField_a_of_type_Int == jdField_b_of_type_JavaLangInteger.intValue())
    {
      paramView = "0";
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_call", 0, 0, paramView, "", "", "");
      paramView = ((ekx)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      n = ((ekx)localObject).jdField_a_of_type_Int;
      m = 0;
      if (n != jdField_b_of_type_JavaLangInteger.intValue()) {
        break label192;
      }
      m = 0;
    }
    for (;;)
    {
      localObject = paramView.nationCode + paramView.mobileCode;
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), m, paramView.uin, paramView.name, (String)localObject, true, null, true, true, null, "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "9", "", "", "");
      return;
      paramView = "1";
      break;
      label192:
      if (n == jdField_c_of_type_JavaLangInteger.intValue()) {
        m = 1006;
      }
    }
  }
  
  private void c(View paramView)
  {
    paramView = (ekx)paramView.getTag();
    if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null)) {}
    PhoneContact localPhoneContact;
    int m;
    do
    {
      return;
      localPhoneContact = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      m = paramView.jdField_a_of_type_Int;
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      if (m == jdField_b_of_type_JavaLangInteger.intValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(localPhoneContact.uin, 0, localPhoneContact.uin, localPhoneContact.name);
        return;
      }
    } while (m != jdField_c_of_type_JavaLangInteger.intValue());
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(localPhoneContact.nationCode + localPhoneContact.mobileCode, 1006, "", localPhoneContact.name);
    return;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (m == jdField_b_of_type_JavaLangInteger.intValue())
    {
      paramView = "0";
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_prof", 0, 0, paramView, "", "", "");
      paramView = null;
      if (m != jdField_b_of_type_JavaLangInteger.intValue()) {
        break label229;
      }
      paramView = new ProfileActivity.AllInOne(localPhoneContact.uin, 1);
    }
    for (;;)
    {
      if (paramView != null) {
        paramView.f = 65;
      }
      ProfileActivity.a(getContext(), paramView);
      return;
      paramView = "1";
      break;
      label229:
      if (m == jdField_c_of_type_JavaLangInteger.intValue())
      {
        paramView = localPhoneContact.nationCode + localPhoneContact.mobileCode;
        if (localPhoneContact.originBinder == 3L) {}
        for (m = 32;; m = 31)
        {
          paramView = new ProfileActivity.AllInOne(paramView, m);
          paramView.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          paramView.g = localPhoneContact.nickName;
          paramView.j = localPhoneContact.name;
          paramView.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(localPhoneContact.name, localPhoneContact.mobileCode, localPhoneContact.nationCode));
          paramView.c = localPhoneContact.ability;
          paramView.e = 3;
          break;
        }
      }
      if (m == jdField_a_of_type_JavaLangInteger.intValue())
      {
        localObject = new ProfileActivity.AllInOne(localPhoneContact.nationCode + localPhoneContact.mobileCode, 33);
        ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        ((ProfileActivity.AllInOne)localObject).j = localPhoneContact.name;
        ((ProfileActivity.AllInOne)localObject).g = localPhoneContact.nickName;
        String[] arrayOfString = localPhoneContact.mobileNo.split("\\|");
        m = 0;
        if (m < arrayOfString.length)
        {
          ArrayList localArrayList = ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_JavaUtilArrayList;
          StringBuilder localStringBuilder = new StringBuilder().append(getResources().getString(2131558969));
          if (arrayOfString.length > 0) {}
          for (paramView = Integer.valueOf(m + 1);; paramView = "")
          {
            localArrayList.add(new ProfileActivity.CardContactInfo(paramView, arrayOfString[m], localPhoneContact.nationCode));
            m += 1;
            break;
          }
        }
        ((ProfileActivity.AllInOne)localObject).c = localPhoneContact.ability;
        ((ProfileActivity.AllInOne)localObject).e = 3;
        paramView = (View)localObject;
      }
    }
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130903305, null);
    ekx localekx = new ekx(null);
    localekx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131232030));
    localekx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131232031));
    localekx.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131232033));
    localekx.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localekx.b = ((Button)localView.findViewById(2131232034));
    localekx.b.setOnClickListener(this);
    localView.setTag(localekx);
    return localView;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class, this.jdField_a_of_type_Eky);
    boolean bool;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558966));
      if (this.jdField_a_of_type_Ekv == null)
      {
        this.jdField_a_of_type_Ekv = new ekv(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ekv);
      }
      j();
      int m = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (m == 0) {
        break label176;
      }
      bool = true;
      label103:
      localTextView.setEnabled(bool);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("设置");
      if ((m != 7) && (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.i()))
      {
        if (!NetworkUtil.e(getContext())) {
          break label181;
        }
        h();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558967));
      break;
      label176:
      bool = false;
      break label103;
      label181:
      a(2131562488, 3000L);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity.getIntent());
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    if ((NetworkUtil.e(getContext())) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.i())) {
      a(2131562875, 0L, false);
    }
  }
  
  public void a(View paramView, PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    paramView = (ekx)paramView.getTag();
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
      paramView.b.setVisibility(8);
      paramView.jdField_a_of_type_Int = jdField_a_of_type_JavaLangInteger.intValue();
      return;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContact.name);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!this.jdField_d_of_type_Boolean)
    {
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramView.b.setVisibility(0);
    }
    paramView.jdField_a_of_type_AndroidWidgetButton.setTag(paramView);
    paramView.b.setTag(paramView);
    paramView.jdField_a_of_type_AndroidWidgetButton.setContentDescription("向" + paramPhoneContact.name + "发消息");
    paramView.b.setContentDescription("向" + paramPhoneContact.name + "发起语音通话");
    if (!paramPhoneContact.uin.equals("0"))
    {
      paramView.jdField_a_of_type_Int = jdField_b_of_type_JavaLangInteger.intValue();
      a(paramView, paramPhoneContact.uin, Integer.parseInt(paramPhoneContact.faceUrl), 1);
      return;
    }
    paramView.jdField_a_of_type_Int = jdField_c_of_type_JavaLangInteger.intValue();
    a(paramView, paramPhoneContact.nationCode + paramPhoneContact.mobileCode, 0, 11);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.l = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    int n = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt = 0;
    label52:
    Bitmap localBitmap;
    if (paramInt < n)
    {
      paramAbsListView = (ekx)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.jdField_a_of_type_JavaLangString)))
      {
        int m = 1;
        if (paramAbsListView.jdField_a_of_type_Int == jdField_c_of_type_JavaLangInteger.intValue()) {
          m = 11;
        }
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(m, paramAbsListView.jdField_a_of_type_JavaLangString);
        if (localBitmap != null) {
          break label145;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramAbsListView.jdField_a_of_type_JavaLangString, m, false);
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
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    int m = this.jdField_a_of_type_ComTencentWidgetXListView.k();
    localXListView.setSelection(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() + m);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Eku.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Ekv != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ekv);
      this.jdField_a_of_type_Ekv = null;
    }
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
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_Eky.sendEmptyMessageDelayed(2, 1000L);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    Object localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
    int n = localObject1.length;
    int m = 0;
    while (m < n)
    {
      localObject2 = localObject1[m];
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(0));
      m += 1;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = "*";
    Iterator localIterator = ((List)this.jdField_a_of_type_JavaUtilList.get(0)).iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      Object localObject3 = localPhoneContact.pinyinFirst;
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
      localObject2 = localObject3;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    m = 0;
    label251:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      n = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)).intValue();
      if (n == 0) {
        break label445;
      }
    }
    label445:
    for (n = n + m + 1;; n = m)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(m));
      m = n;
      break label251;
      if (!this.jdField_d_of_type_Boolean)
      {
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
      }
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      this.j = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.j <= 0) {
        break;
      }
      m();
      return;
    }
  }
  
  public void k()
  {
    if ((a()) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) || (this.j > 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getContext(), 231, getContext().getString(2131559983), getContext().getString(2131559982), 2131559984, 2131559985, new eko(this), new ekq(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new ekr(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    Contacts.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    if (this.jdField_d_of_type_Boolean) {}
    for (int m = 11;; m = 5)
    {
      this.jdField_a_of_type_AndroidAppDialog = new eks(this, getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new ekt(this));
      return;
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_Eky.removeMessages(1);
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
    case 2131233086: 
      l();
      return;
    case 2131231379: 
      b(new Intent(getContext(), SettingActivity2.class), 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
      return;
    case 2131232033: 
      a(paramView);
      return;
    }
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView
 * JD-Core Version:    0.7.0.1
 */
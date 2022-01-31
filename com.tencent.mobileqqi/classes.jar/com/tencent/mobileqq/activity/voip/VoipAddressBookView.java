package com.tencent.mobileqq.activity.voip;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.phone.PhoneInnerFrame;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
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
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import etb;
import etd;
import ete;
import etf;
import etg;
import eth;
import eti;
import etj;
import etl;
import etm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;

@SuppressLint({"ViewConstructor"})
public class VoipAddressBookView
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
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public eti a;
  private etj jdField_a_of_type_Etj;
  public etm a;
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public List a;
  private View jdField_c_of_type_AndroidViewView;
  private boolean d;
  private boolean e = false;
  public int j;
  private int l = 0;
  
  static
  {
    jdField_b_of_type_JavaLangInteger = Integer.valueOf(2);
    jdField_c_of_type_JavaLangInteger = Integer.valueOf(3);
  }
  
  public VoipAddressBookView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    this.d = paramBoolean;
    if ((paramBoolean) && ((paramContext instanceof PhoneFrameActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity = ((PhoneFrameActivity)paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, VoipDetailActivity.class);
      localIntent.putExtra("contactId", paramString);
      localIntent.putExtra("source", "voipAddressBookActivity");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void a(View paramView)
  {
    paramView = (etl)paramView.getTag();
    Object localObject1 = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    int m = etl.a(paramView);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (m == jdField_b_of_type_JavaLangInteger.intValue())
    {
      paramView = "0";
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_msg", 0, 0, paramView, "", "", "");
      if (m != jdField_b_of_type_JavaLangInteger.intValue()) {
        break label207;
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
    label207:
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
  
  private void a(VoipPhoneNumber paramVoipPhoneNumber)
  {
    if (paramVoipPhoneNumber == null) {
      return;
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), VoipDialInterfaceActivity.class);
      if ((paramVoipPhoneNumber.b != null) && (!paramVoipPhoneNumber.b.equals(""))) {
        localIntent.putExtra("dialData", new VoipDialData(paramVoipPhoneNumber.b, paramVoipPhoneNumber.c));
      }
      for (;;)
      {
        localIntent.putExtra("callNow", 1);
        a(localIntent);
        return;
        localIntent.putExtra("dialData", new VoipDialData(paramVoipPhoneNumber.b, paramVoipPhoneNumber.jdField_a_of_type_JavaLangString));
      }
      return;
    }
    catch (Exception paramVoipPhoneNumber) {}
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
        etl localetl = (etl)paramListView.getChildAt(m).getTag();
        if ((localetl != null) && (paramString.equals(localetl.jdField_a_of_type_JavaLangString))) {
          localetl.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      m += 1;
    }
  }
  
  private void a(etl parametl, String paramString, int paramInt1, PhoneContact paramPhoneContact, int paramInt2)
  {
    if ((paramPhoneContact != null) && (paramPhoneContact.photoUri != null)) {
      parametl.jdField_a_of_type_AndroidWidgetImageView.setImageURI(paramPhoneContact.photoUri);
    }
    do
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver() != null)
        {
          paramString = MediaStore.Images.Media.getBitmap(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver(), paramPhoneContact.photoUri);
          paramString = ImageUtil.a(paramString, paramString.getWidth(), paramString.getWidth(), paramString.getHeight());
          parametl.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        do
        {
          paramString = getResources().getDrawable(2130840369);
        } while (paramString == null);
        parametl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
        return;
      }
      paramString = getResources().getDrawable(2130840369);
    } while (paramString == null);
    parametl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
  
  private void b(View paramView)
  {
    Object localObject1 = (etl)paramView.getTag();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (etl.a((etl)localObject1) == jdField_b_of_type_JavaLangInteger.intValue())
    {
      paramView = "0";
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_call", 0, 0, paramView, "", "", "");
      paramView = ((etl)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (paramView.allPhoneNumber.size() != 1) {
        break label96;
      }
      a((VoipPhoneNumber)paramView.allPhoneNumber.get(0));
    }
    label96:
    while (paramView.allPhoneNumber.size() <= 1)
    {
      return;
      paramView = "1";
      break;
    }
    localObject1 = new ArrayList();
    localObject2 = paramView.allPhoneNumber.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((VoipPhoneNumber)((Iterator)localObject2).next()).jdField_a_of_type_JavaLangString);
    }
    localObject1 = (String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]);
    localObject2 = new AlertDialog.Builder(getContext());
    ((AlertDialog.Builder)localObject2).setTitle(paramView.name);
    ((AlertDialog.Builder)localObject2).setItems((CharSequence[])localObject1, new eth(this, paramView));
    ((AlertDialog.Builder)localObject2).show();
  }
  
  private void c(View paramView)
  {
    paramView = (etl)paramView.getTag();
    if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null)) {
      return;
    }
    PhoneContact localPhoneContact = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    etl.a(paramView);
    a(getContext(), localPhoneContact.lookupID);
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130904052, null);
    etl localetl = new etl(null);
    localetl.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131232031));
    localetl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131232032));
    localetl.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131232035));
    localetl.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    localView.setTag(localetl);
    return localView;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(VoipAddressBookView.class, this.jdField_a_of_type_Etm);
    boolean bool;
    if (this.d)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getContext().getString(2131558966));
      if (this.jdField_a_of_type_Etj == null)
      {
        this.jdField_a_of_type_Etj = new etj(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Etj);
      }
      j();
      int m = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (m == 0) {
        break label172;
      }
      bool = true;
      label99:
      localTextView.setEnabled(bool);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("设置");
      if ((m != 7) && (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.i()))
      {
        if (!NetworkUtil.e(getContext())) {
          break label177;
        }
        h();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getContext().getString(2131558967));
      break;
      label172:
      bool = false;
      break label99;
      label177:
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
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, paramString, paramBitmap);
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrameActivity.getIntent());
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    a(2130904051);
    this.jdField_a_of_type_Etm = new etm(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131234660));
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130903944, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131233086).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131233087));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_Eti = new eti(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Eti);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131232030));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  }
  
  public void a(View paramView, PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    paramView = (etl)paramView.getTag();
    if (paramBoolean) {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s(%s)", new Object[] { paramPhoneContact.name, paramPhoneContact.mobileNo }));
    }
    for (;;)
    {
      paramView.jdField_a_of_type_JavaLangString = null;
      paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
      if (paramPhoneContact.allPhoneNumber.size() < 1) {
        break label193;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      if ((paramPhoneContact.uin == null) || (paramPhoneContact.uin.length() <= 0) || (paramPhoneContact.uin.equals("0")) || (paramPhoneContact.faceUrl == null)) {
        break;
      }
      etl.a(paramView, jdField_b_of_type_JavaLangInteger.intValue());
      a(paramView, paramPhoneContact.uin, Integer.parseInt(paramPhoneContact.faceUrl), paramPhoneContact, 1);
      return;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContact.name);
    }
    etl.a(paramView, jdField_c_of_type_JavaLangInteger.intValue());
    a(paramView, "0", 0, paramPhoneContact, 11);
    return;
    label193:
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.l = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    }
    int m;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      m = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount();
      paramInt = 0;
    } while (paramInt >= m);
    paramAbsListView = (etl)this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(paramInt).getTag();
    if ((paramAbsListView != null) && (paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.photoUri == null)) {
        break label205;
      }
      paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageURI(paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.photoUri);
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = MediaStore.Images.Media.getBitmap(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver(), paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.photoUri);
        localBitmap = ImageUtil.a(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
        paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        paramInt += 1;
      }
      catch (Exception localException)
      {
        localDrawable = getResources().getDrawable(2130840369);
        if (localDrawable == null) {
          continue;
        }
        paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        continue;
      }
      label205:
      Drawable localDrawable = getResources().getDrawable(2130840369);
      if (localDrawable != null) {
        paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      if ("$".equals(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
        return;
      }
      PinnedDividerListView localPinnedDividerListView = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      int m = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k();
      localPinnedDividerListView.setSelection(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() + m);
      return;
    }
    catch (Exception paramString) {}
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Eti.notifyDataSetChanged();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(VoipAddressBookView.class);
    i();
    g();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    n();
    if (this.jdField_a_of_type_Etj != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Etj);
      this.jdField_a_of_type_Etj = null;
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
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_Etm.sendEmptyMessageDelayed(2, 1000L);
      return;
    }
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    label243:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      n = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)).intValue();
      if (n == 0) {
        break label337;
      }
    }
    label337:
    for (n = n + m + 1;; n = m)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(m));
      m = n;
      break label243;
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      this.j = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.j <= 0) {
        break;
      }
      n();
      return;
    }
  }
  
  public void k()
  {
    if ((a()) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) || (this.j > 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getContext(), 231, getContext().getString(2131559983), getContext().getString(2131559982), 2131559984, 2131559985, new etb(this), new etd(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new ete(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void l()
  {
    Contacts.a += 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    if (this.d) {}
    for (int m = 15;; m = 16)
    {
      this.jdField_a_of_type_AndroidAppDialog = new etf(this, getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new etg(this));
      return;
    }
  }
  
  public void m()
  {
    b(new Intent(getContext(), SettingActivity2.class), 1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
  }
  
  public void n()
  {
    this.jdField_a_of_type_Etm.removeMessages(1);
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
    case 2131233087: 
      l();
      return;
    case 2131231380: 
      b(new Intent(getContext(), SettingActivity2.class), 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
      return;
    case 2131232034: 
      a(paramView);
      return;
    }
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipAddressBookView
 * JD-Core Version:    0.7.0.1
 */
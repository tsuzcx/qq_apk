package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import abdz;
import abdz.b;
import abdz.c;
import acff;
import acfp;
import ajdo;
import amop;
import ampt;
import amsf.a;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqcl;
import aqdf;
import aqdf.a;
import aqha;
import aqhu;
import aqju;
import arwx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import urq;
import urr;
import urs;
import ysf;
import ysf.a;

public class ContactBindedActivity
  extends IphoneTitleBarActivity
  implements abdz.c, amsf.a, Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, ViewStub.OnInflateListener, AdapterView.OnItemClickListener, IndexView.a, AbsListView.e, ysf.a
{
  public static final String[] ck = { "$", "★", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  public static final String[] cl = { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  TextView Co = null;
  private abdz jdField_a_of_type_Abdz;
  private aqdf jdField_a_of_type_Aqdf;
  private a jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$a;
  private c jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$c = new c(null);
  public PhoneContact a;
  private ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  private CustomHorizontalScrollView jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView;
  private ysf jdField_a_of_type_Ysf;
  boolean aOc = false;
  private ArrayList<PhoneContact> aQ = new ArrayList();
  protected boolean aUI = true;
  private boolean aUJ;
  private boolean aUK;
  private EditText av;
  private EditText aw;
  PhoneContactManagerImp jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  IndexView jdField_b_of_type_ComTencentMobileqqWidgetIndexView;
  public int bFY = -1;
  private int bnP = -1;
  private PinnedDividerListView c;
  private Button de;
  private Bitmap dk;
  private GridView h;
  private int mFromType = 1;
  private View mRoot;
  public Handler mSubHandler;
  private TextView mTitleTextView;
  public Handler mUiHandler;
  public ArrayList<PhoneContact> pa;
  private View sa;
  private View sb;
  private View sc;
  private View sd;
  private View se;
  View sf;
  private aqju u;
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("check_permission_result");
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, String.format("startFromOther [%s, %s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str }));
    }
    paramIntent = BaseActivity.sTopActivity;
    if (paramIntent != null)
    {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X80077CF", "0X80077CF", 0, 0, "", "", "", "");
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X800796B", "0X800796B", 0, 0, "", "", "", "");
      paramQQAppInterface = new Intent(paramIntent, ContactBindedActivity.class);
      paramQQAppInterface.putExtra("from_type", 0);
      paramQQAppInterface.putExtra("kSrouce", paramInt1);
      paramQQAppInterface.putExtra("fromKeyForContactBind", paramInt2);
      paramIntent.startActivityForResult(paramQQAppInterface, 222);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<PhoneContact> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "startFromOther requestCode: " + paramInt + "  starList:" + paramArrayList);
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8007971", "0X8007971", 0, 0, "", "", "", "");
      paramQQAppInterface = new Intent(localBaseActivity, ContactBindedActivity.class);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        ArrayList localArrayList = new ArrayList(paramArrayList.size());
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(((PhoneContact)paramArrayList.next()).mobileNo);
        }
        paramQQAppInterface.putExtra("isBindAction", localArrayList);
      }
      paramQQAppInterface.putExtra("from_type", 1);
      localBaseActivity.startActivityForResult(paramQQAppInterface, paramInt);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "startFromOtherPage requestCode: " + paramInt1 + "  fromPage:" + paramInt2);
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      if (paramInt2 == 1) {
        anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009EC5", "0X8009EC5", 0, 0, "", "", "", "");
      }
      paramQQAppInterface = new Intent(localBaseActivity, ContactBindedActivity.class);
      paramQQAppInterface.putExtra("from_type", 0);
      paramQQAppInterface.putExtra("from_page", paramInt2);
      localBaseActivity.startActivityForResult(paramQQAppInterface, paramInt1);
    }
  }
  
  private void b(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean)
    {
      if (this.aQ.size() >= 100)
      {
        QQToast.a(this, 1, 2131692003, 0).show(getTitleBarHeight());
        paramBoolean = false;
      }
      for (;;)
      {
        this.av.setText("");
        this.jdField_a_of_type_Abdz.d(paramPhoneContact, paramBoolean);
        if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.mi(this.aQ);
        }
        if (!this.aQ.isEmpty()) {
          break;
        }
        paramPhoneContact = getString(2131692001);
        label92:
        this.de.setText(paramPhoneContact);
        paramPhoneContact = this.de;
        paramBoolean = bool;
        if (!this.aQ.isEmpty()) {
          paramBoolean = true;
        }
        paramPhoneContact.setEnabled(paramBoolean);
        cz(true);
        return;
        this.aQ.add(paramPhoneContact);
      }
    }
    int i = 0;
    label145:
    if (i < this.aQ.size()) {
      if (!TextUtils.equals(((PhoneContact)this.aQ.get(i)).unifiedCode, paramPhoneContact.unifiedCode)) {}
    }
    for (;;)
    {
      this.aQ.remove(i);
      break;
      i += 1;
      break label145;
      paramPhoneContact = getString(2131692002, new Object[] { Integer.valueOf(this.aQ.size()) });
      break label92;
      i = -1;
    }
  }
  
  private void bLW()
  {
    int j = 1;
    if (this.aQ.isEmpty()) {
      return;
    }
    Object localObject;
    int i;
    if (this.aQ.size() == 1)
    {
      localObject = (ajdo)this.app.getManager(11);
      i = 3006;
      if (((ajdo)localObject).Uv()) {
        break label168;
      }
      i = 3075;
    }
    for (;;)
    {
      localObject = (PhoneContact)this.aQ.get(0);
      startActivityForResult(AddFriendLogicActivity.a(this, 2, ((PhoneContact)localObject).unifiedCode, null, i, j, ((PhoneContact)localObject).name, null, null, acfp.m(2131704362), null), 102);
      return;
      if (this.aQ.size() > 100) {
        break;
      }
      localObject = (ajdo)this.app.getManager(11);
      i = 3078;
      if (!((ajdo)localObject).Uv()) {
        i = 3079;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.aQ, i, null, acfp.m(2131704365), null, this.mFromType), 101);
      return;
      label168:
      j = 13;
    }
  }
  
  private void refreshData(boolean paramBoolean)
  {
    this.mSubHandler.removeMessages(2);
    this.mSubHandler.sendMessageDelayed(this.mSubHandler.obtainMessage(2, Boolean.valueOf(paramBoolean)), 100L);
  }
  
  private void wH(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    if (!this.aOc)
    {
      bool1 = true;
      this.aOc = bool1;
      if (!this.aOc) {
        break label297;
      }
      this.leftView.setVisibility(8);
      this.sa.setVisibility(0);
      this.sd.setVisibility(0);
      if (!this.aQ.isEmpty()) {
        break label268;
      }
      localObject = getString(2131692001);
      label68:
      this.de.setText((CharSequence)localObject);
      this.c.removeHeaderView(this.se);
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment = ContactSearchFragment.a(19, 524288, null, null, this);
        localObject = getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction)localObject).add(2131377813, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
      }
      label139:
      if (paramBoolean)
      {
        this.aQ.clear();
        this.jdField_a_of_type_Abdz.vG.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.mi(this.aQ);
      }
      localObject = this.de;
      paramBoolean = bool2;
      if (!this.aQ.isEmpty()) {
        paramBoolean = true;
      }
      ((Button)localObject).setEnabled(paramBoolean);
      localObject = this.rightViewText;
      if (!this.aOc) {
        break label370;
      }
    }
    label268:
    label297:
    label370:
    for (int i = 2131721058;; i = 2131692006)
    {
      ((TextView)localObject).setText(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$a.notifyDataSetChanged();
      this.jdField_a_of_type_Abdz.Dl(this.aOc);
      this.av.setText("");
      cz(true);
      return;
      bool1 = false;
      break;
      localObject = getString(2131692002, new Object[] { Integer.valueOf(this.aQ.size()) });
      break label68;
      this.leftView.setVisibility(0);
      this.sc.setVisibility(8);
      this.sa.setVisibility(8);
      this.c.addHeaderView(this.se);
      this.sd.setVisibility(8);
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
      break label139;
    }
  }
  
  public void Az(int paramInt) {}
  
  public void O(String paramString)
  {
    if ("$".equals(paramString)) {
      this.c.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Abdz.m(paramString);
    } while (i == -1);
    this.c.setSelection(i + this.c.getHeaderViewsCount());
  }
  
  public void a(abdz.b paramb)
  {
    if ((paramb.vQ.size() > 0) || (this.aUJ))
    {
      this.sf.setVisibility(8);
      if ((paramb.vQ.size() > 10) && (!this.aUK) && (this.mFromType == 1))
      {
        anot.a(this.app, "dc00898", "", "", "0X8007972", "0X8007972", 0, 0, "", "", "", "");
        this.aUK = true;
      }
      if ((paramb.vQ.size() <= 10) && (!this.aUJ)) {
        break label147;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Abdz.b(paramb);
      this.jdField_a_of_type_Abdz.notifyDataSetChanged();
      return;
      this.sf.setVisibility(0);
      break;
      label147:
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
  }
  
  public void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (paramPhoneContact != null) {
      b(paramPhoneContact, paramBoolean);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    View localView = this.sc;
    if (TextUtils.isEmpty(paramEditable)) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.Id(paramEditable);
      }
      return;
    }
  }
  
  public void bLU()
  {
    refreshData(false);
  }
  
  public void bLV()
  {
    refreshData(false);
  }
  
  protected void bLX()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.mDensity * 40.0F));
    int j = (int)(this.mDensity * 10.0F);
    int i;
    if (this.aQ.size() > 0) {
      if (this.aQ.size() < 5)
      {
        i = (int)((this.aQ.size() * 40 + this.aQ.size() * 10) * this.mDensity) + (int)(this.mDensity * 10.0F);
        this.sb.setVisibility(8);
      }
    }
    for (;;)
    {
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(i, 0, j, 0);
      this.av.setLayoutParams(localLayoutParams);
      return;
      i = (int)(230.0F * this.mDensity);
      break;
      i = (int)(this.mDensity * 40.0F);
      this.sb.setVisibility(0);
    }
  }
  
  public void bLY()
  {
    if (this.Co != null)
    {
      this.Co.clearAnimation();
      this.Co.setVisibility(8);
      this.Co = null;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void cR(View paramView)
  {
    paramView = (ampt)paramView.getTag(2131381960);
    if (paramView == null) {}
    do
    {
      return;
      paramView = ((amop)paramView).f;
    } while (paramView == null);
    b(paramView, true);
  }
  
  protected void cz(boolean paramBoolean)
  {
    this.h.setNumColumns(this.aQ.size());
    ViewGroup.LayoutParams localLayoutParams = this.h.getLayoutParams();
    localLayoutParams.width = ((int)((this.aQ.size() * 40 + this.aQ.size() * 10) * this.mDensity));
    this.h.setLayoutParams(localLayoutParams);
    bLX();
    if (paramBoolean) {
      this.mUiHandler.sendEmptyMessageDelayed(3, 200L);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$a.notifyDataSetChanged();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 101) && (paramInt2 == -1))
    {
      if (paramIntent.hasExtra("result"))
      {
        paramIntent = (ArrayList)paramIntent.getSerializableExtra("result");
        if (!paramIntent.isEmpty())
        {
          localObject2 = new ArrayList();
          localObject3 = new ArrayList();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          localObject1 = (acff)this.app.getManager(51);
          localObject4 = paramIntent.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (FriendListHandler.AddBatchPhoneFriendResult)((Iterator)localObject4).next();
            if (((FriendListHandler.AddBatchPhoneFriendResult)localObject5).sendResult == 0)
            {
              ((acff)localObject1).bF(((FriendListHandler.AddBatchPhoneFriendResult)localObject5).mobile, true);
              ((List)localObject2).add(localObject5);
            }
            else if (((FriendListHandler.AddBatchPhoneFriendResult)localObject5).sendResult == 37)
            {
              localArrayList1.add(localObject5);
            }
            else if ((((FriendListHandler.AddBatchPhoneFriendResult)localObject5).sendResult == 32) || (((FriendListHandler.AddBatchPhoneFriendResult)localObject5).sendResult == 33))
            {
              localArrayList2.add(localObject5);
            }
            else if (((FriendListHandler.AddBatchPhoneFriendResult)localObject5).allowType == 2)
            {
              ((List)localObject3).add(localObject5);
            }
          }
          if (QLog.isColorLevel())
          {
            paramInt1 = paramIntent.size();
            paramInt2 = ((List)localObject2).size();
            i = ((List)localObject3).size();
            j = localArrayList1.size();
            k = localArrayList2.size();
            QLog.d("IphoneTitleBarActivity", 2, "doOnActivityResult, adds=" + ((List)localObject2).size() + ", needAnswers=" + ((List)localObject3).size() + ", security anti=" + localArrayList1.size() + ", upToLimits=" + localArrayList2.size() + ", others=" + (paramInt1 - paramInt2 - i - j - k));
          }
          paramIntent = "";
          localObject4 = new StringBuilder();
          if (!localArrayList1.isEmpty())
          {
            paramIntent = acfp.m(2131704370);
            ((StringBuilder)localObject4).append("部分好友添加失败，请稍后再试。");
          }
          for (;;)
          {
            if ((!localArrayList1.isEmpty()) || (!localArrayList2.isEmpty()) || (!((List)localObject3).isEmpty()))
            {
              this.u = aqha.a(this, 230, paramIntent, ((StringBuilder)localObject4).toString(), new urq(this), null);
              this.mUiHandler.sendEmptyMessageDelayed(6, 900L);
            }
            ((List)localObject3).addAll((Collection)localObject2);
            if (this.pa == null) {
              this.pa = new ArrayList();
            }
            this.pa.clear();
            paramIntent = ((List)localObject3).iterator();
            while (paramIntent.hasNext())
            {
              localObject1 = (FriendListHandler.AddBatchPhoneFriendResult)paramIntent.next();
              localObject2 = this.aQ.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (PhoneContact)((Iterator)localObject2).next();
                if (((FriendListHandler.AddBatchPhoneFriendResult)localObject1).mobile.equals(((PhoneContact)localObject3).unifiedCode)) {
                  this.pa.add(localObject3);
                }
              }
            }
            if (!localArrayList2.isEmpty())
            {
              paramIntent = acfp.m(2131704373);
              ((StringBuilder)localObject4).append("好友已达上限，部分好友未添加。");
            }
            else if (!((List)localObject3).isEmpty())
            {
              paramIntent = getString(2131692005);
              if (((List)localObject3).size() == 1)
              {
                localObject1 = (FriendListHandler.AddBatchPhoneFriendResult)((List)localObject3).get(0);
                localObject5 = this.aQ.iterator();
                while (((Iterator)localObject5).hasNext())
                {
                  localObject6 = (PhoneContact)((Iterator)localObject5).next();
                  if (((FriendListHandler.AddBatchPhoneFriendResult)localObject1).mobile.equals(((PhoneContact)localObject6).unifiedCode)) {
                    if (!TextUtils.isEmpty(((PhoneContact)localObject6).name)) {
                      break label769;
                    }
                  }
                }
                label769:
                for (localObject1 = ((PhoneContact)localObject6).nickName;; localObject1 = ((PhoneContact)localObject6).name)
                {
                  ((StringBuilder)localObject4).append(arwx.h((String)localObject1, 12, true)).append("的好友验证方式需要回答问题, 请单独添加。");
                  break;
                }
              }
              localObject5 = new ArrayList(((List)localObject3).size());
              localObject1 = ((List)localObject3).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject6 = (FriendListHandler.AddBatchPhoneFriendResult)((Iterator)localObject1).next();
                localIterator = this.aQ.iterator();
                while (localIterator.hasNext())
                {
                  localPhoneContact = (PhoneContact)localIterator.next();
                  if (((FriendListHandler.AddBatchPhoneFriendResult)localObject6).mobile.equals(localPhoneContact.unifiedCode)) {
                    ((List)localObject5).add(localPhoneContact);
                  }
                }
              }
              Collections.sort((List)localObject5, this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$c);
              paramInt1 = 0;
              if (paramInt1 < 2)
              {
                localObject1 = (PhoneContact)((List)localObject5).get(paramInt1);
                if (TextUtils.isEmpty(((PhoneContact)localObject1).name)) {}
                for (localObject1 = ((PhoneContact)localObject1).nickName;; localObject1 = ((PhoneContact)localObject1).name)
                {
                  ((StringBuilder)localObject4).append(arwx.h((String)localObject1, 12, true));
                  if (paramInt1 == 0) {
                    ((StringBuilder)localObject4).append("、");
                  }
                  paramInt1 += 1;
                  break;
                }
              }
              ((StringBuilder)localObject4).append("等").append(((List)localObject3).size()).append("位联系人的好友验证方式需要回答问题, 请单独添加。");
              if (this.mFromType == 0) {
                anot.a(this.app, "dc00898", "", "", "0X8007970", "0X8007970", 0, 0, String.valueOf(((List)localObject3).size()), "", "", "");
              } else {
                anot.a(this.app, "dc00898", "", "", "0X8007977", "0X8007977", 0, 0, String.valueOf(((List)localObject3).size()), "", "", "");
              }
            }
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(ck);
          this.aUJ = true;
        }
      }
      refreshData(false);
      wH(true);
      cz(true);
      this.mUiHandler.removeMessages(4);
      this.mUiHandler.sendMessageDelayed(this.mUiHandler.obtainMessage(4), 120L);
    }
    while ((paramInt1 != 102) || (paramInt2 != -1))
    {
      Object localObject2;
      Object localObject3;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      Object localObject1;
      Object localObject4;
      Object localObject5;
      int i;
      int j;
      int k;
      Object localObject6;
      Iterator localIterator;
      PhoneContact localPhoneContact;
      return;
    }
    if (!this.aQ.isEmpty())
    {
      if (this.pa == null) {
        this.pa = new ArrayList();
      }
      this.pa.clear();
      this.pa.add(this.aQ.get(0));
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(ck);
      this.aUJ = true;
    }
    refreshData(false);
    wH(true);
    cz(true);
    this.mUiHandler.removeMessages(4);
    this.mUiHandler.sendMessageDelayed(this.mUiHandler.obtainMessage(4), 120L);
  }
  
  @TargetApi(9)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setSoftInputMode(48);
    setContentView(2131561276);
    paramBundle = getIntent();
    this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = (ArrayList)paramBundle.getSerializableExtra("isBindAction");
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        this.pa = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b((String)localObject2);
        if (localObject2 != null)
        {
          this.pa.add(localObject2);
          continue;
          this.pa = this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.bT();
        }
      }
      this.mFromType = paramBundle.getIntExtra("from_type", 1);
      this.bnP = paramBundle.getIntExtra("from_page", -1);
      if (paramBundle.getIntExtra("fromKeyForContactBind", 0) == 1) {
        QQToast.a(BaseApplication.getContext(), 2, 2131696807, 0);
      }
    }
    this.mUiHandler = new Handler(Looper.getMainLooper(), this);
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mFlingHandler = new b(this);
    this.mRoot = findViewById(2131377546);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      this.mRoot.setFitsSystemWindows(true);
    }
    this.c = ((PinnedDividerListView)findViewById(2131379117));
    this.mTitleTextView = ((TextView)findViewById(2131369627));
    this.mTitleTextView.setVisibility(0);
    this.mTitleTextView.setText(2131696781);
    setTitle(getString(2131696781));
    setLeftViewName(2131691039);
    this.leftView.setOnClickListener(this);
    this.sa = findViewById(2131377825);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)this.sa.findViewById(2131377766));
    this.sb = this.sa.findViewById(2131377780);
    this.av = ((EditText)this.sa.findViewById(2131377838));
    this.av.addTextChangedListener(this);
    this.av.setOnKeyListener(this);
    this.h = ((GridView)this.sa.findViewById(2131377967));
    aqcl.Q(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView, false);
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setOverScrollMode(2);
      this.h.setOverScrollMode(2);
    }
    this.h.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$a = new a(this);
    this.h.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$a);
    this.h.setOnItemClickListener(this);
    this.jdField_a_of_type_Aqdf = new aqdf(this, this.app);
    this.jdField_a_of_type_Aqdf.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$a);
    this.dk = aqhu.G();
    this.sa.setOnClickListener(this);
    this.sc = findViewById(2131377813);
    this.sd = findViewById(2131367180);
    this.de = ((Button)findViewById(2131363914));
    this.de.setOnClickListener(this);
    this.se = LayoutInflater.from(this).inflate(2131563007, this.c, false);
    this.se.findViewById(2131363801).setVisibility(8);
    this.aw = ((EditText)this.se.findViewById(2131366542));
    this.aw.setFocusableInTouchMode(false);
    this.aw.setCursorVisible(false);
    this.aw.setOnClickListener(this);
    this.c.addHeaderView(this.se);
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369141));
    if (this.pa == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(cl);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.sf = findViewById(2131366417);
      this.sa.setVisibility(8);
      paramBundle = this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
      if ((paramBundle != null) && (TextUtils.isEmpty(paramBundle.mobileNo)) && (paramBundle.noBindUploadContacts == true)) {
        anot.a(this.app, "dc00898", "", "", "0X80077CC", "0X80077CC", 0, 0, "", "", "", "");
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.Uv()) {
        anot.a(this.app, "dc00898", "", "", "0X80077D2", "0X80077D2", 0, 0, "", "", "", "");
      }
      paramBundle = this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a;
      if ((paramBundle == null) || (this.pa == null)) {
        paramBundle = new abdz.b();
      }
      this.jdField_a_of_type_Abdz = new abdz(this, this.app, this.c, paramBundle.vQ);
      this.jdField_a_of_type_Abdz.a = this;
      this.jdField_a_of_type_Abdz.jdField_b_of_type_ComTencentMobileqqWidgetIndexView = this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView;
      this.c.setAdapter(this.jdField_a_of_type_Abdz);
      this.c.setOnScrollListener(this);
      if (!paramBundle.vQ.isEmpty())
      {
        localObject1 = paramBundle;
        if (this.pa != null)
        {
          localObject1 = paramBundle;
          if (!this.pa.isEmpty())
          {
            long l1 = System.currentTimeMillis();
            paramBundle = abdz.a(paramBundle.vQ, this.pa, true);
            this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a = paramBundle;
            long l2 = System.currentTimeMillis();
            localObject1 = paramBundle;
            if (QLog.isColorLevel())
            {
              QLog.d("IphoneTitleBarActivity", 2, "constructHashStruct startTime=" + l1 + ", endTime=" + l2 + ", cost=" + String.valueOf(l2 - l1));
              localObject1 = paramBundle;
            }
          }
        }
        a((abdz.b)localObject1);
      }
      refreshData(true);
      this.jdField_a_of_type_Ysf = ((ysf)this.app.getManager(34));
      this.jdField_a_of_type_Ysf.a(this);
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(ck);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bLY();
    if (this.mUiHandler != null)
    {
      this.mUiHandler.removeMessages(1);
      this.mUiHandler.removeMessages(4);
      this.mUiHandler.removeMessages(6);
    }
    if (this.mSubHandler != null) {
      this.mSubHandler.removeMessages(2);
    }
    this.jdField_a_of_type_Ysf.b(this);
    if (this.jdField_a_of_type_Abdz != null) {
      this.jdField_a_of_type_Abdz.destroy();
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.clL();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2;
    Object localObject1;
    label102:
    int i;
    label137:
    PhoneContact localPhoneContact;
    switch (paramMessage.what)
    {
    case 5: 
    default: 
      return false;
    case 1: 
      localObject2 = (abdz.b)paramMessage.obj;
      if (this.pa != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a = ((abdz.b)localObject2);
      }
      if ((this.bFY != -1) && (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.pinyinFirst)) {
          break label237;
        }
        localObject1 = "#";
        localObject1 = (List)((abdz.b)localObject2).D.get(localObject1);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          i = ((List)localObject1).size() - 1;
          if (i < 0) {
            break label517;
          }
          localPhoneContact = (PhoneContact)((List)localObject1).get(i);
          if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
            break label258;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (i != -1)
      {
        localPhoneContact = (PhoneContact)((List)localObject1).remove(i);
        ((List)localObject1).add(this.bFY, localPhoneContact);
      }
      this.bFY = -1;
      this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = null;
      a((abdz.b)localObject2);
      if (paramMessage.arg1 != 1) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.i(true, true, 18);
      return false;
      label237:
      localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.pinyinFirst.charAt(0)).toUpperCase();
      break label102;
      label258:
      i -= 1;
      break label137;
      localObject1 = new ArrayList(this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.cU());
      if ((this.aUJ) && (this.pa != null) && (!this.pa.isEmpty())) {
        localObject2 = this.pa.iterator();
      }
      label512:
      label515:
      for (;;)
      {
        label313:
        if (((Iterator)localObject2).hasNext())
        {
          localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
          i = 0;
          label337:
          if (i >= ((List)localObject1).size()) {
            break label512;
          }
          if (!TextUtils.equals(((PhoneContact)((List)localObject1).get(i)).unifiedCode, localPhoneContact.unifiedCode)) {}
        }
        for (;;)
        {
          if (i < 0) {
            break label515;
          }
          ((List)localObject1).remove(i);
          break label313;
          i += 1;
          break label337;
          localObject1 = abdz.a((List)localObject1, this.pa, false);
          localObject2 = this.mUiHandler;
          if (((Boolean)paramMessage.obj).booleanValue()) {}
          for (i = 1;; i = 0)
          {
            Message.obtain((Handler)localObject2, 1, i, 0, localObject1).sendToTarget();
            return false;
            localObject1 = abdz.a((List)localObject1, this.pa, true);
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.scrollTo(this.h.getLayoutParams().width, 0);
          return false;
          this.c.setSelectionFromTop(0, 0);
          return false;
          if (this.u == null) {
            break;
          }
          this.mUiHandler.removeMessages(6);
          this.u.show();
          return false;
          i = -1;
        }
      }
      label517:
      i = -1;
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.bnP == 1) {
      anot.a(this.app, "dc00898", "", "", "0X8009EC6", "0X8009EC6", 0, 0, "", "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    label163:
    int i;
    switch (paramView.getId())
    {
    default: 
    case 2131369579: 
    case 2131369612: 
    case 2131366542: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.bnP == 1) {
          anot.a(this.app, "dc00898", "", "", "0X8009EC6", "0X8009EC6", 0, 0, "", "", "", "");
        }
        finish();
        continue;
        bLY();
        if (!this.aOc)
        {
          if (this.mFromType != 0) {
            break label163;
          }
          anot.a(this.app, "dc00898", "", "", "0X800796C", "0X800796C", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          wH(true);
          break;
          anot.a(this.app, "dc00898", "", "", "0X8007973", "0X8007973", 0, 0, "", "", "", "");
        }
        bLY();
        ContactSearchComponentActivity.b(this, null, 17, 524288, 561243);
      }
    case 2131363914: 
      if (!this.aQ.isEmpty())
      {
        if ((this.aUJ) || (this.pa == null) || (this.pa.isEmpty())) {
          break label628;
        }
        Iterator localIterator1 = this.pa.iterator();
        i = 0;
        label326:
        while (localIterator1.hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)localIterator1.next();
          Iterator localIterator2 = this.aQ.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (!TextUtils.equals(((PhoneContact)localIterator2.next()).unifiedCode, localPhoneContact.unifiedCode));
          i += 1;
        }
      }
      break;
    }
    for (;;)
    {
      if (this.mFromType == 0)
      {
        anot.a(this.app, "dc00898", "", "", "0X800796D", "0X800796D", 0, 0, "", "", "", "");
        anot.a(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 0, 0, String.valueOf(this.aQ.size()), "", "", "");
        anot.a(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 1, 0, String.valueOf(i), "", "", "");
        anot.a(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 2, 0, String.valueOf(this.aQ.size() - i), "", "", "");
      }
      for (;;)
      {
        bLW();
        break;
        anot.a(this.app, "dc00898", "", "", "0X8007974", "0X8007974", 0, 0, "", "", "", "");
        anot.a(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 0, 0, String.valueOf(this.aQ.size()), "", "", "");
        anot.a(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 1, 0, String.valueOf(i), "", "", "");
        anot.a(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 2, 0, String.valueOf(this.aQ.size() - i), "", "", "");
      }
      bLY();
      break;
      break label326;
      label628:
      i = 0;
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.Co = ((TextView)paramView);
    this.Co.setOnClickListener(this);
    paramViewStub = new urr(this, 0.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    paramViewStub.setDuration(500L);
    paramViewStub.setInterpolator(new OvershootInterpolator());
    paramViewStub.setAnimationListener(new urs(this));
    this.Co.startAnimation(paramViewStub);
    PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("has_contact_bind_act_show_new_guide_" + this.app.getCurrentAccountUin(), true).commit();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView.getTag() != null) {
      b((PhoneContact)paramView.getTag(), false);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67)
    {
      if (paramKeyEvent.getAction() != 0) {
        break label29;
      }
      this.aUI = TextUtils.isEmpty(this.av.getText());
    }
    for (;;)
    {
      return false;
      label29:
      if ((paramKeyEvent.getAction() == 1) && (this.aUI)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$a.bLZ();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public class a
    extends BaseAdapter
    implements aqdf.a
  {
    private boolean aUL;
    private final Drawable dy;
    private Context mContext;
    
    public a(Context paramContext)
    {
      this.dy = paramContext.getResources().getDrawable(2130845851);
      this.mContext = paramContext;
    }
    
    public PhoneContact a(int paramInt)
    {
      return (PhoneContact)ContactBindedActivity.a(ContactBindedActivity.this).get(paramInt);
    }
    
    void bLZ()
    {
      if (this.aUL)
      {
        if ((ContactBindedActivity.a(ContactBindedActivity.this) != null) && (ContactBindedActivity.a(ContactBindedActivity.this).size() > 0))
        {
          PhoneContact localPhoneContact = (PhoneContact)ContactBindedActivity.a(ContactBindedActivity.this).get(ContactBindedActivity.a(ContactBindedActivity.this).size() - 1);
          ContactBindedActivity.a(ContactBindedActivity.this, localPhoneContact, false);
        }
        this.aUL = false;
        return;
      }
      this.aUL = true;
      super.notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return ContactBindedActivity.a(ContactBindedActivity.this).size();
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Bitmap localBitmap = null;
      PhoneContact localPhoneContact = a(paramInt);
      if (paramView == null) {
        paramView = ContactBindedActivity.this.getLayoutInflater().inflate(2131559454, null);
      }
      for (;;)
      {
        paramView.setTag(localPhoneContact);
        ImageView localImageView = (ImageView)paramView.findViewById(2131366624);
        Object localObject = localBitmap;
        if (paramInt == getCount() - 1)
        {
          localObject = localBitmap;
          if (this.aUL) {
            localObject = this.dy;
          }
        }
        localImageView.setImageDrawable((Drawable)localObject);
        localBitmap = ContactBindedActivity.a(ContactBindedActivity.this).b(11, localPhoneContact.unifiedCode);
        localObject = localBitmap;
        if (localBitmap == null)
        {
          ContactBindedActivity.a(ContactBindedActivity.this).a(localPhoneContact.unifiedCode, 11, true, (byte)0);
          localObject = ContactBindedActivity.a(ContactBindedActivity.this);
        }
        localImageView.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject));
        if (AppSetting.enableTalkBack) {
          localImageView.setContentDescription(localPhoneContact.name);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
    
    public void notifyDataSetChanged()
    {
      this.aUL = false;
      super.notifyDataSetChanged();
    }
    
    public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
    {
      if (ContactBindedActivity.a(ContactBindedActivity.this) == null) {}
      for (;;)
      {
        return;
        paramInt1 = 0;
        while (paramInt1 < ContactBindedActivity.a(ContactBindedActivity.this).getChildCount())
        {
          View localView = ContactBindedActivity.a(ContactBindedActivity.this).getChildAt(paramInt1);
          Object localObject = localView.getTag();
          if ((localObject != null) && ((localObject instanceof PhoneContact)) && (paramString.equals(((PhoneContact)localObject).unifiedCode))) {
            ((ImageView)localView.findViewById(2131366624)).setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  class b
    extends FlingGestureHandler
  {
    public b(Activity paramActivity)
    {
      super();
    }
    
    public void flingLToR()
    {
      if (!ContactBindedActivity.this.aOc) {
        super.flingLToR();
      }
    }
  }
  
  static final class c
    implements Comparator<PhoneContact>
  {
    public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
    {
      boolean bool1 = TextUtils.isEmpty(paramPhoneContact1.pinyinFirst);
      boolean bool2 = TextUtils.isEmpty(paramPhoneContact2.pinyinFirst);
      if ((bool1) || (bool2))
      {
        if ((bool1) && (bool2)) {
          return 0;
        }
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return paramPhoneContact1.pinyinFirst.toLowerCase().charAt(0) - paramPhoneContact2.pinyinFirst.toLowerCase().charAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactBindedActivity
 * JD-Core Version:    0.7.0.1
 */
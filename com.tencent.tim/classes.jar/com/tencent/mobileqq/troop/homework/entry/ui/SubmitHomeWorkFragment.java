package com.tencent.mobileqq.troop.homework.entry.ui;

import acfp;
import acms;
import acnd;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import ankt;
import apgk;
import aphc;
import aphz;
import apia;
import apib;
import apic;
import apid;
import apie;
import apif;
import apig;
import apih;
import apkl;
import apkm;
import apkn;
import apko;
import apkp;
import apkr;
import apks;
import apku;
import apkv;
import aple;
import aqcx;
import aqfr;
import aqha;
import aqhu;
import aqiw;
import aqju;
import aqnm;
import arhz;
import aurd;
import ausj;
import awsw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.a;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubmitHomeWorkFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, InputMethodGuard.a
{
  protected static String aFT;
  protected View Im;
  protected View Io;
  protected arhz a;
  protected a a;
  protected InputMethodGuard a;
  protected long agy;
  protected LinkedList<JSONObject> ak;
  protected ausj aq;
  public long arA;
  protected long arC;
  protected acnd b;
  protected apgk b;
  public CommonRecordSoundPanel b;
  protected XMediaEditor b;
  protected acms c;
  public apgk c;
  protected XMediaEditor c;
  protected boolean cQC;
  protected boolean cQD;
  protected boolean cQK;
  protected boolean cQL;
  protected String cpx;
  protected String cpy;
  protected ViewGroup eG;
  protected QQAppInterface mApp;
  protected BroadcastReceiver mReceiver = new apia(this);
  protected int mRetryCount;
  protected View mRoot;
  protected String mTroopUin = "";
  
  public static Intent a(Activity paramActivity, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("hide_title_left_arrow", true);
    localIntent.putExtra("SubmitHomeWorkFragment:valid", "SubmitHomeWorkFragment:valid");
    localIntent.putExtra("HomeWorkConstants:homework_id_default_request_key", paramLong2);
    localIntent.putExtra("extra.GROUP_UIN", String.valueOf(paramLong1));
    localIntent.putExtra("public_fragment_class", SubmitHomeWorkFragment.class.getName());
    localIntent.setClass(paramActivity, PublicFragmentActivity.class);
    return localIntent;
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("hide_title_left_arrow", true);
    localBundle.putLong("HomeWorkConstants:homework_id_default_request_key", paramLong2);
    localBundle.putString("SubmitHomeWorkFragment:valid", "SubmitHomeWorkFragment:valid");
    if (paramLong1 > 0L) {
      localBundle.putString("extra.GROUP_UIN", String.valueOf(paramLong1));
    }
    localIntent.putExtras(localBundle);
    PublicFragmentActivity.start(paramActivity, localIntent, SubmitHomeWorkFragment.class);
  }
  
  public static void cn(Activity paramActivity)
  {
    awsw.gC(BaseApplicationImpl.getContext());
  }
  
  protected void RJ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Im.setVisibility(0);
      return;
    }
    this.Im.setVisibility(8);
  }
  
  public void SR(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("c")) {
          break label140;
        }
        paramString = paramString.getJSONArray("c");
        if (paramString != null)
        {
          this.cpx = paramString.toString();
          if (i < paramString.length())
          {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label169;
            }
            String str = localJSONObject.getString("type");
            if (!TextUtils.isEmpty(str))
            {
              if (Arrays.asList(aphc.hy).contains(str)) {
                this.ak.add(localJSONObject);
              }
            }
            else if (QLog.isColorLevel()) {
              QLog.d("SubmitHomeWorkFragment", 2, "home work must contains type key");
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SubmitHomeWorkFragment", 2, "parse homework json error", paramString);
        }
        return;
      }
      dZD();
      return;
      label140:
      paramString = new IllegalArgumentException("home work json format error");
      if (QLog.isColorLevel())
      {
        QLog.e("SubmitHomeWorkFragment", 2, paramString, new Object[0]);
        return;
        label169:
        i += 1;
      }
    }
  }
  
  protected EditText a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView == null) {
      localObject2 = localObject1;
    }
    int j;
    int i;
    label38:
    do
    {
      return localObject2;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      j = ((ViewGroup)paramView).getChildCount();
      i = 0;
      localObject1 = localObject2;
      localObject2 = localObject1;
    } while (i >= j);
    localObject2 = a(((ViewGroup)paramView).getChildAt(i));
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      i += 1;
      break label38;
      localObject2 = localObject1;
      if (!(paramView instanceof EditText)) {
        break;
      }
      localObject2 = localObject1;
      if (!paramView.isFocused()) {
        break;
      }
      return (EditText)paramView;
    }
  }
  
  @NonNull
  protected List<String> a(apku paramapku)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramapku != null)
    {
      if (!(paramapku instanceof apkv)) {
        break label50;
      }
      localArrayList.add(acfp.m(2131715056) + "");
    }
    label50:
    do
    {
      return localArrayList;
      if ((paramapku instanceof apks))
      {
        localArrayList.add(acfp.m(2131715049) + "");
        return localArrayList;
      }
      if ((paramapku instanceof apkm))
      {
        localArrayList.add(acfp.m(2131715043) + "");
        return localArrayList;
      }
      if ((paramapku instanceof apkl))
      {
        localArrayList.add(acfp.m(2131715052) + "");
        return localArrayList;
      }
    } while (!(paramapku instanceof apkp));
    localArrayList.add(acfp.m(2131715046) + "");
    return localArrayList;
  }
  
  List<Boolean> a(@NonNull JSONArray paramJSONArray1, @NonNull JSONArray paramJSONArray2)
  {
    bool5 = true;
    bool4 = false;
    localArrayList = new ArrayList(3);
    try
    {
      localObject = new JSONArray(this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getData());
      localJSONArray = new JSONArray(this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getData());
      j = ((JSONArray)localObject).length();
      i = 0;
    }
    catch (Exception paramJSONArray1)
    {
      for (;;)
      {
        int i;
        try
        {
          Object localObject;
          JSONArray localJSONArray;
          int j;
          JSONObject localJSONObject;
          if (this.ak.isEmpty()) {
            continue;
          }
          bool2 = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getData().equals(this.cpy);
          if (!bool2)
          {
            bool3 = true;
            bool2 = bool3;
          }
        }
        catch (Exception paramJSONArray1)
        {
          boolean bool1;
          boolean bool6;
          boolean bool7;
          boolean bool8;
          boolean bool2 = false;
          boolean bool3 = false;
          continue;
          bool2 = false;
          bool3 = false;
          continue;
        }
        try
        {
          i = paramJSONArray1.length();
          if (i > 0)
          {
            bool4 = true;
            if (bool3) {
              continue;
            }
          }
        }
        catch (Exception paramJSONArray1)
        {
          bool5 = false;
          bool4 = bool2;
          bool2 = bool5;
          continue;
          continue;
        }
        try
        {
          i = paramJSONArray1.length();
          if (i > 0)
          {
            bool3 = bool5;
            bool5 = bool3;
            bool6 = bool2;
            bool7 = bool4;
            bool8 = bool1;
            localArrayList.add(Boolean.valueOf(bool5));
            localArrayList.add(Boolean.valueOf(bool6));
            localArrayList.add(Boolean.valueOf(bool7));
            localArrayList.add(Boolean.valueOf(bool8));
            return localArrayList;
            bool1 = false;
            continue;
            bool3 = false;
            continue;
            bool4 = false;
            continue;
          }
          bool3 = false;
          continue;
          paramJSONArray1 = paramJSONArray1;
          bool2 = false;
          bool3 = false;
          bool1 = false;
        }
        catch (Exception paramJSONArray1)
        {
          bool5 = bool2;
          bool2 = bool4;
          bool4 = bool5;
          continue;
        }
        bool8 = bool1;
        bool7 = bool2;
        bool6 = bool4;
        bool5 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.e("SubmitHomeWorkFragment", 2, "check isHomeWorkModify error", paramJSONArray1);
          bool8 = bool1;
          bool7 = bool2;
          bool6 = bool4;
          bool5 = bool3;
          continue;
          i += 1;
          continue;
          i += 1;
        }
      }
    }
    if (i < j)
    {
      localJSONObject = ((JSONArray)localObject).optJSONObject(i);
      if (w(localJSONObject)) {
        paramJSONArray1.put(localJSONObject);
      }
    }
    else
    {
      j = localJSONArray.length();
      i = 0;
      if (i < j)
      {
        localObject = localJSONArray.optJSONObject(i);
        if (!w((JSONObject)localObject)) {
          break label433;
        }
        paramJSONArray2.put(localObject);
        break label433;
      }
      bool1 = this.ak.isEmpty();
      if (!bool1) {
        bool1 = true;
      }
    }
  }
  
  public void a(int paramInt, ArrayList<apku> paramArrayList1, ArrayList<apku> paramArrayList2, apgk paramapgk)
  {
    if (paramInt == 0)
    {
      paramapgk = new ArrayList();
      Iterator localIterator = paramArrayList1.iterator();
      while (localIterator.hasNext()) {
        paramapgk.addAll(a((apku)localIterator.next()));
      }
      localIterator = paramArrayList2.iterator();
      while (localIterator.hasNext()) {
        paramapgk.addAll(a((apku)localIterator.next()));
      }
      paramapgk = new ArrayList(new TreeSet(paramapgk));
      if (paramapgk.isEmpty())
      {
        paramapgk = "";
        if (this.mRetryCount != 0) {
          break label352;
        }
        this.mRetryCount += 1;
        if ((this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList1.isEmpty())) {
          this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.fb(paramArrayList1);
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList2.isEmpty())) {
          this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.fb(paramArrayList2);
        }
        paramArrayList1 = getString(2131699715, new Object[] { paramapgk });
        QQToast.a(getActivity(), paramArrayList1, 0).show();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (paramapgk.size() == 1)
      {
        paramapgk = (String)paramapgk.get(0);
        break;
      }
      paramapgk = (String)paramapgk.get(0) + "、" + (String)paramapgk.get(1) + acfp.m(2131715045);
      break;
      label352:
      paramArrayList1 = getString(2131699713, new Object[] { paramapgk });
      QQToast.a(getActivity(), paramArrayList1, 0).show();
      continue;
      if (paramInt == 1) {
        QQToast.a(getActivity(), 2131699677, 0).show();
      } else if (paramInt == 3) {
        QQToast.a(getActivity(), 2131699709, 0).show();
      } else if (paramInt == 2) {
        QQToast.a(getActivity(), 2131696281, 0).show();
      }
    }
  }
  
  protected void am(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.jdField_a_of_type_Arhz == null)
        {
          this.jdField_a_of_type_Arhz = new arhz(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Arhz.setCancelable(false);
          this.jdField_a_of_type_Arhz.show();
        }
        this.jdField_a_of_type_Arhz.setMessage(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void bE(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("detect input method state changed, current state is ");
      if (!paramBoolean) {
        break label50;
      }
    }
    label50:
    for (String str = "on";; str = "off")
    {
      QLog.d("SubmitHomeWorkFragment", 2, str);
      RJ(paramBoolean);
      return;
    }
  }
  
  public void bF()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Arhz.dismiss();
      label24:
      this.jdField_a_of_type_Arhz = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void dZB()
  {
    if (this.mContentView == null) {}
    View localView;
    do
    {
      return;
      this.mRoot = findViewById(2131378955);
      this.Im = findViewById(2131363698);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)findViewById(2131369299));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
      this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)findViewById(2131368685));
      this.eG = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131560814, null, false));
      this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.eG);
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)this.eG.findViewById(2131368692));
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setLeftRightPadding(aqcx.dip2px(getActivity(), 12.0F));
      this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setLeftRightPadding(aqcx.dip2px(getActivity(), 12.0F));
      this.Io = findViewById(2131371946);
      ib(this.Io.findViewById(2131371947));
      this.Io.findViewById(2131371947).setOnClickListener(this);
      localView = findViewById(2131373820);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = findViewById(2131373828);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = findViewById(2131373834);
    } while (localView == null);
    localView.setOnClickListener(this);
  }
  
  protected void dZC()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      String str2 = localBundle.getString("extra.GROUP_UIN");
      if (str2 == null) {}
      for (String str1 = "";; str1 = str2)
      {
        aqfr.b("Grp_edu", "homework", "CompleteHw_Show", 0, 0, new String[] { str1 });
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        this.mTroopUin = str2;
        this.arA = localBundle.getLong("HomeWorkConstants:homework_id_default_request_key");
        if (this.arA <= 0L) {
          break label123;
        }
        am(2131699653);
        this.jdField_c_of_type_Acms.hR(this.arA);
        return;
      }
      QQToast.a(getActivity(), 2131699711, 0).show();
      getActivity().finish();
      return;
      label123:
      QQToast.a(getActivity(), 2131699711, 0).show();
      getActivity().finish();
      return;
    }
    QQToast.a(getActivity(), 2131699711, 0).show();
    getActivity().finish();
  }
  
  protected void dZD()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment$a.sendMessage(localMessage);
  }
  
  protected void dZK()
  {
    this.aq.dismiss();
  }
  
  public void dZL()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment$a.postDelayed(new SubmitHomeWorkFragment.6(this), 400L);
  }
  
  public void dZM()
  {
    int j = 0;
    if (!aqiw.isNetworkAvailable(getActivity()))
    {
      QQToast.a(getActivity(), 0, 2131696270, 0).show();
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    boolean bool;
    label169:
    Object localObject5;
    if (this.mTroopUin == null)
    {
      localObject1 = "";
      aqfr.b("Grp_edu", "homework", "CompleteHw_Sub", 0, 0, new String[] { localObject1 });
      localObject2 = new apgk();
      ((apgk)localObject2).ary = this.arA;
      localObject3 = new JSONArray();
      localObject4 = new JSONArray();
      localObject1 = a((JSONArray)localObject3, (JSONArray)localObject4);
      ((Boolean)((List)localObject1).get(1)).booleanValue();
      bool = ((Boolean)((List)localObject1).get(2)).booleanValue();
      if (!((Boolean)((List)localObject1).get(3)).booleanValue()) {
        break label294;
      }
      for (localObject1 = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.dT().iterator();; localObject1 = acfp.m(2131715047)) {
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject5 = (apkr)((Iterator)localObject1).next();
            if ((localObject5 != null) && (((apkr)localObject5).Lv() == 0)) {
              if (!(localObject5 instanceof apkl)) {
                break;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = getActivity().getString(2131699702, new Object[] { localObject1 });
        QQToast.a(getActivity(), (CharSequence)localObject1, 0).show();
        return;
        localObject1 = this.mTroopUin;
        break;
        if (!(localObject5 instanceof apkp)) {
          break label169;
        }
        localObject1 = acfp.m(2131715042);
        continue;
        label294:
        if (!bool)
        {
          QQToast.a(getActivity(), 2131699701, 0).show();
          return;
        }
      }
      localObject1 = new JSONArray();
      int k = ((JSONArray)localObject4).length();
      int i = 0;
      while (i < k)
      {
        localObject5 = ((JSONArray)localObject4).optJSONObject(i);
        if (localObject5 != null) {
          ((JSONArray)localObject1).put(localObject5);
        }
        i += 1;
      }
      k = ((JSONArray)localObject3).length();
      i = j;
      while (i < k)
      {
        localObject4 = ((JSONArray)localObject3).optJSONObject(i);
        if (localObject4 != null) {
          ((JSONArray)localObject1).put(localObject4);
        }
        i += 1;
      }
      localObject3 = new JSONObject();
      for (;;)
      {
        try
        {
          ((JSONObject)localObject3).put("c", localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, ((JSONObject)localObject3).toString());
          }
        }
        catch (JSONException localJSONException)
        {
          a(3, null, null, null);
          return;
        }
        try
        {
          if (!TextUtils.isEmpty(this.mTroopUin)) {
            break label540;
          }
          ((apgk)localObject2).arw = 0L;
          ((apgk)localObject2).content = ((JSONObject)localObject3).toString();
        }
        catch (Exception localException)
        {
          continue;
        }
        localObject1 = aqha.a(getActivity(), 230);
        localObject2 = new apid(this, (apgk)localObject2);
        ((aqju)localObject1).setMessage(2131699700);
        ((aqju)localObject1).setPositiveButton(2131699676, (DialogInterface.OnClickListener)localObject2);
        ((aqju)localObject1).setNegativeButton(2131699670, (DialogInterface.OnClickListener)localObject2);
        ((aqju)localObject1).show();
        return;
        label540:
        ((apgk)localObject2).arw = Long.valueOf(this.mTroopUin).longValue();
      }
      String str = "";
    }
  }
  
  public void dZN()
  {
    String str;
    Object localObject;
    if (this.mTroopUin == null)
    {
      str = "";
      if (this.jdField_b_of_type_Apgk != null) {
        break label167;
      }
      localObject = "";
    }
    for (;;)
    {
      aqfr.b("Grp_edu", "homework", "CompleteHw_Success", 0, 0, new String[] { str, "", localObject });
      y(1, "CompleteHw_Pic", true);
      y(2, "CompleteHw_Video", true);
      y(3, "CompleteHw_Voice", true);
      y(7, "CompleteHw_Calculate", false);
      y(4, "CompleteHw_Recite", false);
      localObject = new Intent();
      ((Intent)localObject).putExtra("SubmitHomeWorkFragment:js_callback", "{\"submit\":\"true\", \"hw_id\":" + this.arC + "}");
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      return;
      str = this.mTroopUin;
      break;
      label167:
      if (this.jdField_b_of_type_Apgk.content == null) {
        localObject = "";
      } else {
        localObject = this.jdField_b_of_type_Apgk.content;
      }
    }
  }
  
  protected void dZO()
  {
    if (this.aq == null)
    {
      this.aq = ausj.b(getActivity());
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131560053, null));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.mApp, getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment$a);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(ankt.cIE * 0.3F));
      this.aq.addView(this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.aq.setAnimationTime(50);
      this.aq.a(new apie(this));
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.reset();
    this.aq.setOutsideDismissEnableCompat(true);
    aurd.cE(getActivity());
    this.aq.show();
  }
  
  protected void dZP()
  {
    if (this.mTroopUin == null) {}
    for (Object localObject1 = "";; localObject1 = this.mTroopUin)
    {
      aqfr.b("Grp_edu", "homework", "Subhw_hwDetail", 0, 0, new String[] { localObject1 });
      localObject1 = ausj.b(getActivity());
      ViewGroup localViewGroup = (ViewGroup)getActivity().getLayoutInflater().inflate(2131560827, null);
      XMediaEditor localXMediaEditor = (XMediaEditor)localViewGroup.findViewById(2131368691);
      localXMediaEditor.setMaxHeight(ankt.cIE - this.vg.getHeight() - aqnm.getStatusBarHeight(getActivity()) - ankt.dip2px(122.0F));
      localXMediaEditor.setShowType(1);
      Object localObject2 = (TextView)localViewGroup.findViewById(2131368589);
      View localView = localViewGroup.findViewById(2131368588);
      if (this.jdField_c_of_type_Apgk != null)
      {
        if (!TextUtils.isEmpty(this.jdField_c_of_type_Apgk.title)) {
          ((TextView)localObject2).setText(this.jdField_c_of_type_Apgk.title);
        }
        if (!TextUtils.isEmpty(this.jdField_c_of_type_Apgk.coL))
        {
          localObject2 = (Integer)aphc.oi.get(this.jdField_c_of_type_Apgk.coL);
          if (localObject2 != null) {
            localView.setBackgroundResource(((Integer)localObject2).intValue());
          }
        }
      }
      localView = localViewGroup.findViewById(2131368587);
      ib(localView);
      localView.setOnClickListener(new apif(this, (ausj)localObject1));
      if (!TextUtils.isEmpty(this.cpx)) {
        localXMediaEditor.setData(this.cpx);
      }
      ((ausj)localObject1).addView(localViewGroup);
      aurd.cE(getActivity());
      ((ausj)localObject1).setAnimationTime(300);
      ((ausj)localObject1).show();
      return;
    }
  }
  
  protected void dZz()
  {
    this.mTroopUin = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment$a = new a(this, Looper.getMainLooper());
    this.ak = new LinkedList();
    if (getActivity() == null)
    {
      localObject = null;
      this.mApp = ((QQAppInterface)localObject);
      if (this.mApp != null) {
        break label75;
      }
      getActivity().finish();
    }
    label75:
    do
    {
      return;
      localObject = (QQAppInterface)getActivity().getAppInterface();
      break;
      this.jdField_c_of_type_Acms = ((acms)this.mApp.getBusinessHandler(20));
      this.jdField_b_of_type_Acnd = new aphz(this);
      this.mApp.addObserver(this.jdField_b_of_type_Acnd);
    } while (this.cQL);
    this.cQL = true;
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getActivity().registerReceiver(this.mReceiver, (IntentFilter)localObject);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setSoftInputMode(16);
    dZz();
    dZB();
    dZC();
    postInitUI();
    if (BaseApplicationImpl.sProcessId != 9) {
      cn(getActivity());
    }
  }
  
  public void e(apgk paramapgk)
  {
    Object localObject1 = this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.dS();
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.dS();
    if (localObject1 == null) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      if (localObject2 == null) {
        localObject2 = new ArrayList();
      }
      for (;;)
      {
        if ((!((ArrayList)localObject1).isEmpty()) || (!((ArrayList)localObject2).isEmpty()))
        {
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          ArrayList localArrayList3 = new ArrayList();
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            apku localapku = (apku)((Iterator)localObject1).next();
            if (localapku != null) {
              if (localapku.sz() == 1) {
                localArrayList3.add(localapku);
              } else if ((localapku.sz() == 2) || (localapku.sz() == 0)) {
                localArrayList1.add(localapku);
              }
            }
          }
          localObject1 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (apku)((Iterator)localObject1).next();
            if (localObject2 != null) {
              if (((apku)localObject2).sz() == 1) {
                localArrayList3.add(localObject2);
              } else if ((((apku)localObject2).sz() == 2) || (((apku)localObject2).sz() == 0)) {
                localArrayList2.add(localObject2);
              }
            }
          }
          if (!localArrayList3.isEmpty())
          {
            fa(localArrayList3);
            return;
          }
          if ((!localArrayList1.isEmpty()) || (!localArrayList2.isEmpty()))
          {
            a(0, localArrayList1, localArrayList2, paramapgk);
            return;
          }
          a(3, null, null, paramapgk);
          return;
        }
        if ((this.jdField_c_of_type_Acms != null) && (paramapgk != null))
        {
          am(2131699668);
          this.jdField_b_of_type_Apgk = paramapgk;
          this.arC = paramapgk.ary;
          this.jdField_c_of_type_Acms.i(paramapgk.ary, paramapgk.arw, paramapgk.content);
          return;
        }
        a(3, null, null, paramapgk);
        return;
      }
    }
  }
  
  protected void fa(@NonNull ArrayList<apku> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.addAll(a((apku)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet(localArrayList));
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    for (;;)
    {
      paramArrayList = getString(2131699715, new Object[] { paramArrayList });
      QQToast.a(getActivity(), paramArrayList, 0).show();
      return;
      if (paramArrayList.size() == 1) {
        paramArrayList = (String)paramArrayList.get(0);
      } else {
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + acfp.m(2131715054);
      }
    }
  }
  
  protected <T extends View> T findViewById(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public int getContentLayoutId()
  {
    return 2131560815;
  }
  
  protected void hX(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onPictureBtnClick");
    }
    int i = this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(1) + this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(2);
    if (i >= 10)
    {
      if (System.currentTimeMillis() - this.agy >= 2000L)
      {
        QQToast.a(getActivity(), acfp.m(2131715055) + 10 + acfp.m(2131715053), 0).show();
        this.agy = System.currentTimeMillis();
      }
      return;
    }
    paramView = TroopHWJsPlugin.a(10 - i, getActivity(), this.mApp.getCurrentAccountUin());
    paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    startActivity(paramView);
    aurd.cE(getActivity());
  }
  
  protected void hY(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onVideoBtnClick");
    }
    if (this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(1) + this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(2) >= 10)
    {
      if (System.currentTimeMillis() - this.agy >= 2000L)
      {
        QQToast.a(getActivity(), acfp.m(2131715057) + 10 + acfp.m(2131715048), 0).show();
        this.agy = System.currentTimeMillis();
      }
      return;
    }
    aFT = TroopHWJsPlugin.c(getActivity(), 260);
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, new Object[] { "onVideoBtnClick", String.format("mCameraPath=%s", new Object[] { aFT }) });
    }
    aurd.cE(getActivity());
  }
  
  protected void hZ(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.jI(3) >= 6)
    {
      if (System.currentTimeMillis() - this.agy >= 2000L)
      {
        QQToast.a(getActivity(), acfp.m(2131715050) + 6 + acfp.m(2131715044), 0).show();
        this.agy = System.currentTimeMillis();
      }
      return;
    }
    aurd.hide(paramView);
    dZO();
  }
  
  protected void ib(View paramView)
  {
    if (paramView != null) {
      paramView.setOnTouchListener(new apih(this));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, new Object[] { "onActivityResult. requestCode=", Integer.valueOf(paramInt1), ", resultCode=", Integer.valueOf(paramInt2) });
    }
    switch (paramInt1)
    {
    }
    label230:
    do
    {
      return;
      if ((paramIntent != null) && (paramInt2 == 257))
      {
        paramInt1 = paramIntent.getIntExtra("HomeWorkConstants:homework_default_index_key", -2147483648);
        paramIntent = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
        if (!TextUtils.isEmpty(paramIntent))
        {
          if (paramInt1 == -2147483648) {
            break label230;
          }
          this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.dQ(paramInt1, paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "merging: " + this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getData());
          }
          this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
        }
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramIntent)) && (QLog.isColorLevel())) {
          QLog.d("SubmitHomeWorkFragment", 2, "提交新作业->" + paramIntent);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SubmitHomeWorkFragment", 2, "Return from entry");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SubmitHomeWorkFragment", 2, "no index found");
        }
      }
    } while (paramInt2 != -1);
    if (!aqiw.isNetSupport(getActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "no network toast from capture");
      }
      QQToast.a(getActivity(), 2131699442, 0).show();
      return;
    }
    if (!TextUtils.isEmpty(aFT)) {
      try
      {
        aqhu.cn(getActivity(), aFT);
        paramIntent = new apks(aFT);
        this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          QLog.d("SubmitHomeWorkFragment", 1, "onActivityResult save exception", paramIntent);
        }
      }
    }
    QQToast.a(getActivity(), 2131696986, 0).show();
    QLog.d("SubmitHomeWorkFragment", 1, new Object[] { "onActivityResult path=%s", aFT });
  }
  
  public boolean onBackEvent()
  {
    if (((Boolean)a(new JSONArray(), new JSONArray()).get(0)).booleanValue())
    {
      aqju localaqju = aqha.a(getActivity(), 230);
      apig localapig = new apig(this);
      localaqju.setMessage(2131699703);
      localaqju.setPositiveButton(2131699675, localapig);
      localaqju.setNegativeButton(2131699670, localapig);
      localaqju.show();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      hX(paramView);
      continue;
      hY(paramView);
      continue;
      hZ(paramView);
      continue;
      dZP();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.mApp != null) && (this.jdField_b_of_type_Acnd != null)) {
      this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
    }
    TroopHWJsPlugin.eDX();
    if (this.cQL)
    {
      getActivity().unregisterReceiver(this.mReceiver);
      this.cQL = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiSubmitHomeWorkFragment$a.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772002, 2130772369);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    switch (paramIntent.getIntExtra("HomeWorkConstants:homework_request_code_key", 0))
    {
    default: 
      return;
    }
    this.cQD = aple.a(this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.cQD);
  }
  
  public void onPause()
  {
    super.onPause();
    Intent localIntent = new Intent();
    localIntent.setAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
    getActivity().sendBroadcast(localIntent);
  }
  
  protected void postInitUI()
  {
    setLeftButton(2131699699, new apib(this));
    setRightButton(2131699707, new apic(this));
    setTitle(getResources().getString(2131699708));
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setShowType(2);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.mTroopUin);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setScrollable(false);
    this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setShowType(0);
    this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setMinimumHeight((int)(ankt.cIE * 0.4D));
    this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
    this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.mTroopUin);
    this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getActivity().getString(2131699704));
  }
  
  protected boolean w(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str;
    do
    {
      return false;
      str = paramJSONObject.optString("type");
    } while ((TextUtils.isEmpty(str)) || (("str".equals(str)) && (TextUtils.isEmpty(paramJSONObject.optString("text")))));
    return true;
  }
  
  protected void y(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    ArrayList localArrayList;
    JSONArray localJSONArray;
    for (Object localObject = this.jdField_c_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;; localObject = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor)
    {
      localArrayList = ((XMediaEditor)localObject).w(paramInt);
      localJSONArray = new JSONArray();
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        apkn localapkn = (apkn)((Iterator)localObject).next();
        if (localapkn != null) {
          localJSONArray.put(localapkn.af());
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      if (this.mTroopUin == null)
      {
        localObject = "";
        aqfr.b("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, "", String.valueOf(localArrayList.size()), localJSONArray.toString() });
      }
    }
    else
    {
      if (paramInt != 7) {
        break label255;
      }
      paramString = localArrayList.iterator();
      paramInt = 0;
      label162:
      if (!paramString.hasNext()) {
        break label216;
      }
      localObject = (apkn)paramString.next();
      if ((localObject == null) || (!(localObject instanceof apkl))) {
        break label264;
      }
      paramInt = ((apkl)localObject).Lu();
    }
    label264:
    for (;;)
    {
      break label162;
      localObject = this.mTroopUin;
      break;
      label216:
      if (this.mTroopUin == null) {}
      for (paramString = "";; paramString = this.mTroopUin)
      {
        aqfr.b("Grp_edu", "Grp_oral", "Finish_Oral_Number", 0, 0, new String[] { paramString, String.valueOf(paramInt) });
        label255:
        return;
      }
    }
  }
  
  public static class a
    extends Handler
  {
    WeakReference<SubmitHomeWorkFragment> ic;
    
    a(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, Looper paramLooper)
    {
      super();
      this.ic = new WeakReference(paramSubmitHomeWorkFragment);
    }
    
    void a(SubmitHomeWorkFragment paramSubmitHomeWorkFragment)
    {
      if ((paramSubmitHomeWorkFragment.ak == null) || (paramSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor == null)) {}
      do
      {
        do
        {
          return;
          if (paramSubmitHomeWorkFragment.ak.isEmpty())
          {
            paramSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setVisibility(8);
            paramSubmitHomeWorkFragment.c.showKeyboard();
            paramSubmitHomeWorkFragment.c.setHint(paramSubmitHomeWorkFragment.getActivity().getString(2131699705));
            paramSubmitHomeWorkFragment.c.getAdapter().notifyDataSetChanged();
            return;
          }
        } while (paramSubmitHomeWorkFragment.cQK);
        paramSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.clearData();
        Iterator localIterator = paramSubmitHomeWorkFragment.ak.iterator();
        while (localIterator.hasNext())
        {
          JSONObject localJSONObject = (JSONObject)localIterator.next();
          if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "insert special item: " + localJSONObject.optString("type"));
          }
          paramSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(apko.a(localJSONObject));
        }
        paramSubmitHomeWorkFragment.cQK = true;
      } while (paramSubmitHomeWorkFragment.cpy != null);
      paramSubmitHomeWorkFragment.cpy = paramSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getData();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      SubmitHomeWorkFragment localSubmitHomeWorkFragment = (SubmitHomeWorkFragment)this.ic.get();
      if ((localSubmitHomeWorkFragment == null) || (!localSubmitHomeWorkFragment.isAdded())) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3: 
        localSubmitHomeWorkFragment.cQC = true;
        localSubmitHomeWorkFragment.aq.setOutsideDismissEnableCompat(false);
        return;
      case 513: 
        a(localSubmitHomeWorkFragment);
        return;
      case 101: 
        localSubmitHomeWorkFragment.cQC = false;
        localSubmitHomeWorkFragment.dZK();
        return;
      }
      int i = (int)localSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.v();
      if (i < 1000)
      {
        QQToast.a(localSubmitHomeWorkFragment.getActivity(), acfp.m(2131715051), 0).show();
        localSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.reset();
        return;
      }
      if (!aqiw.isNetSupport(localSubmitHomeWorkFragment.getActivity()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubmitHomeWorkFragment", 2, "no network toast");
        }
        QQToast.a(localSubmitHomeWorkFragment.getActivity(), 2131699442, 0).show();
        localSubmitHomeWorkFragment.cQC = false;
        localSubmitHomeWorkFragment.dZK();
        return;
      }
      paramMessage = paramMessage.obj.toString();
      File localFile = new File(paramMessage);
      if (localFile.exists()) {}
      for (long l = localFile.length();; l = 0L)
      {
        paramMessage = new apkm(paramMessage, null, i / 1000, (int)l, localSubmitHomeWorkFragment.mTroopUin);
        localSubmitHomeWorkFragment.c.a(paramMessage);
        localSubmitHomeWorkFragment.cQC = false;
        localSubmitHomeWorkFragment.dZK();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */
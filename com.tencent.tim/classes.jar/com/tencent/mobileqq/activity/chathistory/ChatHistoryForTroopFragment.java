package com.tencent.mobileqq.activity.chathistory;

import acfp;
import ahgq;
import aklr;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.WrapperListAdapter;
import anot;
import aoop;
import aqgq;
import aqgx;
import aqoa;
import arhz;
import aurf;
import avfp;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.d;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Iterator;
import java.util.List;
import rpq;
import wja;
import xsi;
import xsi.a;
import ymk;
import yml;
import ymm;
import zmc;
import zmd;

public class ChatHistoryForTroopFragment
  extends PublicBaseFragment
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, View.OnTouchListener, TextView.OnEditorActionListener, AbsListView.d, AdapterView.c, AdapterView.d, xsi.a
{
  TextView KO;
  arhz jdField_a_of_type_Arhz;
  ymm jdField_a_of_type_Ymm;
  zmc jdField_a_of_type_Zmc;
  zmd jdField_a_of_type_Zmd;
  public AIORichMediaData f;
  QQAppInterface mApp;
  View mContentView;
  View mEmptyView;
  XListView mListView;
  int mMode = 0;
  String mTroopUin;
  String mUin;
  int mUinType;
  EditText v;
  View xP;
  View xQ;
  
  private void a(FragmentActivity paramFragmentActivity)
  {
    if ((this.f != null) && (paramFragmentActivity != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", this.mTroopUin);
      Object localObject = ((ActivityManager)paramFragmentActivity.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.processName.endsWith("mobileqq")) {
          localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", localRunningAppProcessInfo.pid);
        }
      }
      localBundle.putInt("forward_source_uin_type", 1);
      localBundle.putBoolean("extra.NO_FIRST_ENTER_ANIMATION", true);
      localBundle.putBoolean("extra.RIGHT_EXIT_TRANSITION", true);
      localBundle.putBoolean("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", true);
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_CODE", this.mTroopUin);
      localBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
      localBundle.putString("uin", this.mTroopUin);
      localObject = paramFragmentActivity.getCurrentAccountUin();
      if (localObject != null)
      {
        localBundle.putBoolean("extra.OCR", aklr.ae((String)localObject, 7));
        avfp.b(paramFragmentActivity, localBundle, new AIOImageProviderService((String)localObject, this.mTroopUin, 1, null), this.f, -1, 3);
      }
    }
    do
    {
      return;
      paramFragmentActivity = getActivity();
    } while (paramFragmentActivity == null);
    TroopAIOImageEmptyFragment.f(paramFragmentActivity, acfp.m(2131703686), "https://hb.url.cn/myapp/qq_desk/chatfileEmptyImage.png", acfp.m(2131703626));
  }
  
  private void cjJ()
  {
    TroopAIOImageGeter localTroopAIOImageGeter = new TroopAIOImageGeter(getActivity().getCurrentAccountUin(), this.mTroopUin, 1, null);
    localTroopAIOImageGeter.a(new yml(this));
    localTroopAIOImageGeter.loadMedias(0);
  }
  
  private String hM(String paramString)
  {
    return "https://qun.qq.com/qqweb/m/qunurl/index.html?_bid=2010&groupUin=$GCODE$&_wv=3".replace("$GCODE$", paramString);
  }
  
  public void Am(int paramInt)
  {
    if (paramInt < 0)
    {
      String str = this.jdField_a_of_type_Zmd.getKeyword();
      this.KO.setText(acfp.m(2131703632));
      this.jdField_a_of_type_Zmd.j(System.currentTimeMillis(), str, 2);
    }
  }
  
  protected void Eh(int paramInt)
  {
    int i = 8;
    if (this.mMode != paramInt)
    {
      if (paramInt != 1) {
        break label97;
      }
      this.mListView.setAdapter(null);
      this.mListView.setOnItemClickListener(null);
      this.mListView.setOnItemLongClickListener(null);
      this.mListView.setVisibility(0);
      this.mListView.setEmptyView(null);
      this.mEmptyView.setVisibility(8);
      this.xP.setVisibility(8);
      this.mListView.setOnScrollToButtomListener(null);
      this.KO.setVisibility(8);
    }
    for (;;)
    {
      this.mMode = paramInt;
      return;
      label97:
      if (paramInt == 2)
      {
        this.mListView.setAdapter(this.jdField_a_of_type_Zmd);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnItemLongClickListener(this);
        this.mListView.setVisibility(0);
        this.mListView.setEmptyView(this.mEmptyView);
        this.xP.setVisibility(8);
        this.mListView.setOnScrollToButtomListener(this);
        Object localObject = this.KO;
        if (this.jdField_a_of_type_Zmd.Vu()) {}
        for (;;)
        {
          ((TextView)localObject).setVisibility(i);
          this.jdField_a_of_type_Zmd.notifyDataSetChanged();
          ((TextView)this.mEmptyView.findViewById(2131379419)).setText(acfp.m(2131703634));
          localObject = this.mContentView.getContext().getResources();
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = wja.dp2px(320.0F, (Resources)localObject);
          localURLDrawableOptions.mRequestHeight = wja.dp2px(177.5F, (Resources)localObject);
          localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
          localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
          localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171229/54e96094adaf456f9b8f622f191f8fde.png", localURLDrawableOptions);
          ((ImageView)this.mEmptyView.findViewById(2131379638)).setImageDrawable((Drawable)localObject);
          anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "chatRecor_search", "search_exp", 0, 0, this.mTroopUin, "", "", "");
          break;
          i = 0;
        }
      }
      this.mListView.setVisibility(8);
      this.mEmptyView.setVisibility(8);
      this.xP.setVisibility(0);
    }
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("chatHistory.troop.portal", 2, "onLongClick, position = " + paramInt);
    }
    if (paramView == this.KO) {
      return false;
    }
    this.jdField_a_of_type_Zmc = ((zmc)paramAdapterView.getAdapter().getItem(paramInt));
    paramView.setSelected(true);
    paramAdapterView = new aqoa();
    paramAdapterView.Z(2131365509, acfp.m(2131703612), 2130839077);
    paramAdapterView.Z(2131367523, this.mContentView.getContext().getString(2131721067), 2130839086);
    aqgq.a(paramView, paramAdapterView, this, new ymk(this, paramView));
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable == null) || (paramEditable.length() == 0))
    {
      Eh(0);
      this.xQ.setVisibility(8);
      return;
    }
    Eh(1);
    this.xQ.setVisibility(0);
    yR(paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void bm(Bundle paramBundle)
  {
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    localObject = wja.a(new Intent((Context)localObject, SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramBundle));
    startActivity((Intent)localObject);
  }
  
  protected void dismissProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public void fG(long paramLong)
  {
    if ((this.f != null) && (this.f.id == paramLong)) {
      cjJ();
    }
  }
  
  protected void finish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    dismissProgressDialog();
    TextView localTextView;
    if ((paramMessage.obj instanceof List))
    {
      this.KO.setText(acfp.m(2131703664));
      localTextView = this.KO;
      if (!this.jdField_a_of_type_Zmd.Vu()) {
        break label109;
      }
    }
    label109:
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      this.jdField_a_of_type_Zmd.N((List)paramMessage.obj, paramMessage.arg1);
      this.jdField_a_of_type_Zmd.notifyDataSetChanged();
      Eh(2);
      break;
    }
  }
  
  protected void initData(Bundle paramBundle)
  {
    this.mUin = paramBundle.getString("uin");
    this.mUinType = paramBundle.getInt("uintype");
    this.mTroopUin = paramBundle.getString("troop_uin");
    if (this.mTroopUin == null)
    {
      QLog.e("chatHistory.troop.portal", 1, "troop uin id required");
      finish();
      return;
    }
    paramBundle = getActivity();
    if (paramBundle == null) {}
    for (paramBundle = null; (paramBundle instanceof QQAppInterface); paramBundle = paramBundle.getAppInterface())
    {
      this.mApp = ((QQAppInterface)paramBundle);
      cjJ();
      xsi.a().a(this);
      return;
    }
    QLog.e("chatHistory.troop.portal", 1, "app is null");
    finish();
  }
  
  protected void initUI()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    this.xP = this.mContentView.findViewById(2131378273);
    this.mEmptyView = this.mContentView.findViewById(2131366408);
    this.mListView = ((XListView)this.mContentView.findViewById(2131377856));
    this.mListView.setOnTouchListener(this);
    int i = rpq.dip2px(localFragmentActivity, 10.0F);
    this.KO = new TextView(localFragmentActivity);
    this.KO.setTextSize(16.0F);
    this.KO.setTextColor(getResources().getColorStateList(2131167385));
    this.KO.setGravity(1);
    this.KO.setPadding(0, i, 0, i);
    this.KO.setVisibility(8);
    this.mListView.addFooterView(this.KO);
    this.xQ = this.mContentView.findViewById(2131368696);
    this.xQ.setOnClickListener(this);
    this.v = ((EditText)this.mContentView.findViewById(2131366542));
    this.v.addTextChangedListener(this);
    this.v.setOnEditorActionListener(this);
    this.v.setOnKeyListener(this);
    this.v.setOnTouchListener(this);
    this.mContentView.findViewById(2131363801).setOnClickListener(this);
    this.mContentView.findViewById(2131368820).setOnClickListener(this);
    this.mContentView.findViewById(2131366370).setOnClickListener(this);
    this.mContentView.findViewById(2131367016).setOnClickListener(this);
    this.mContentView.findViewById(2131370508).setOnClickListener(this);
    this.mContentView.findViewById(2131365598).setOnClickListener(this);
    this.mContentView.findViewById(2131371219).setOnClickListener(this);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(20);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (-1 != paramInt2);
    bm(paramIntent.getExtras());
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = getActivity();
    if (localObject1 == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2;
      Object localObject3;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363801: 
        finish();
        anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "home", "Clk_cancel", 0, 0, this.mTroopUin, "", "", "");
        break;
      case 2131368696: 
        this.v.setText("");
        ((InputMethodManager)this.v.getContext().getSystemService("input_method")).showSoftInput(this.v, 0);
        break;
      case 2131368820: 
        a((FragmentActivity)localObject1);
        anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "home", "Clk_pic", 0, 0, this.mTroopUin, "", "", "");
        break;
      case 2131366370: 
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("uin", this.mUin);
        ((Intent)localObject2).putExtra("uintype", this.mUinType);
        ((Intent)localObject2).putExtra("troop_uin", this.mTroopUin);
        PublicFragmentActivity.start((Context)localObject1, (Intent)localObject2, TroopAIOEmotionFragment.class);
        break;
      case 2131367016: 
        localObject2 = ((FragmentActivity)localObject1).getCurrentAccountUin();
        aqgx.v((String)localObject2, "troop_file_new", this.mTroopUin, 0);
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra(TroopFileProxyActivity.cjr, this.mTroopUin);
        ((Intent)localObject3).putExtra("param_from", 5000);
        TroopFileProxyActivity.b((Activity)localObject1, (Intent)localObject3, -1, (String)localObject2);
        anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "home", "Clk_file", 0, 0, this.mTroopUin, "", "", "");
        break;
      case 2131370508: 
        localObject1 = new Intent((Context)localObject1, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", hM(this.mTroopUin));
        ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity((Intent)localObject1);
        anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "home", "Clk_link", 0, 0, this.mTroopUin, "", "", "");
        break;
      case 2131365598: 
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("troop_uin", this.mTroopUin);
        PublicFragmentActivity.start((Context)localObject1, (Intent)localObject2, ChatHistoryByDateFragment.class);
        anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "home", "Clk_date", 0, 0, this.mTroopUin, "", "", "");
        break;
      case 2131371219: 
        localObject1 = TroopMemberListActivity.c((Context)localObject1, this.mTroopUin, 18);
        ((Intent)localObject1).putExtra("uin", this.mTroopUin);
        ((Intent)localObject1).putExtra("uintype", 1);
        startActivity((Intent)localObject1);
        anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "home", "Clk_mber", 0, 0, this.mTroopUin, "", "", "");
        break;
      case 2131365509: 
        localObject2 = this.jdField_a_of_type_Zmc;
        if (localObject2 != null) {
          ((ClipboardManager)((FragmentActivity)localObject1).getSystemService("clipboard")).setText(((zmc)localObject2).messageRecord.msg);
        }
        break;
      case 2131367523: 
        localObject3 = this.jdField_a_of_type_Zmc;
        if (localObject3 != null)
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("forward_type", -1);
          ((Bundle)localObject2).putString("forward_text", ((zmc)localObject3).messageRecord.msg);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtras((Bundle)localObject2);
          ahgq.f((Activity)localObject1, (Intent)localObject3, 21);
        }
        break;
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mContentView = paramLayoutInflater.inflate(2131560777, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.mContentView.setFitsSystemWindows(true);
      this.mContentView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    initData(getArguments());
    initUI();
    anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "home", "exp", 0, 0, this.mTroopUin, "", "", "");
    paramLayoutInflater = this.mContentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    dismissProgressDialog();
    xsi.a().b(this);
    super.onDestroyView();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
    {
      paramTextView = paramTextView.getText().toString().trim();
      if (!TextUtils.isEmpty(paramTextView)) {}
    }
    else
    {
      return false;
    }
    yR(paramTextView);
    return true;
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)localFragmentActivity.getSystemService("input_method");
      if ((localInputMethodManager != null) && (localInputMethodManager.isActive())) {
        localInputMethodManager.hideSoftInputFromWindow(localFragmentActivity.getWindow().getDecorView().getWindowToken(), 0);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("chatHistory.troop.portal", 2, "onItemClick, position = " + paramInt);
    }
    if (paramView == this.KO)
    {
      paramAdapterView = this.jdField_a_of_type_Zmd.getKeyword();
      this.KO.setText(acfp.m(2131703688));
      this.jdField_a_of_type_Zmd.j(System.currentTimeMillis(), paramAdapterView, 2);
    }
    do
    {
      do
      {
        return;
        for (paramAdapterView = this.mListView.getAdapter(); (paramAdapterView instanceof WrapperListAdapter); paramAdapterView = ((WrapperListAdapter)paramAdapterView).getWrappedAdapter()) {}
        if (paramAdapterView != this.jdField_a_of_type_Zmd) {
          break;
        }
        paramView = getActivity();
      } while (paramView == null);
      paramAdapterView = ((zmc)paramAdapterView.getItem(paramInt)).messageRecord;
      ChatHistoryBubbleListForTroopFragment.a(paramView, this.mTroopUin, paramAdapterView, 100, 2);
      if (QLog.isColorLevel()) {
        QLog.i("chatHistory.troop.portal", 2, "onItemClick, message = " + paramAdapterView);
      }
      anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "chatRecor_search", "search_clk", 0, 0, this.mTroopUin, "", "", "");
      return;
      if (paramAdapterView == this.jdField_a_of_type_Ymm)
      {
        paramAdapterView = (String)paramAdapterView.getItem(paramInt);
        this.v.setText(paramAdapterView);
        this.v.setSelection(paramAdapterView.length());
        yR(paramAdapterView);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("chatHistory.troop.portal", 2, "onItemClick, unknown data type");
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && ((paramKeyEvent.getKeyCode() == 66) || (paramKeyEvent.getKeyCode() == 84)))
    {
      paramView = ((TextView)paramView).getText().toString().trim();
      if (!TextUtils.isEmpty(paramView)) {}
    }
    else
    {
      return false;
    }
    yR(paramView);
    return true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      if (paramView != this.mListView) {
        break label49;
      }
      ((InputMethodManager)this.v.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.v.getWindowToken(), 0);
    }
    label49:
    while (paramView != this.v) {
      return false;
    }
    anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "home", "Clk_search", 0, 0, this.mTroopUin, "", "", "");
    return false;
  }
  
  public void yR(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("chatHistory.troop.portal", 2, "searchMessage, currentKeyword = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_Zmd == null)
    {
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.aTl = this.mTroopUin;
      localSessionInfo.cZ = 1;
      this.jdField_a_of_type_Zmd = new zmd(this.mContentView.getContext(), new aurf(Looper.getMainLooper(), this), localSessionInfo, this.mApp);
    }
    if (!paramString.equalsIgnoreCase(this.jdField_a_of_type_Zmd.getKeyword())) {
      this.jdField_a_of_type_Zmd.j(System.currentTimeMillis(), paramString, 1);
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00899", "Grp_chatRecord", "", "home", "search_result", 0, 0, this.mTroopUin, "", "", "");
      return;
      Eh(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryForTroopFragment
 * JD-Core Version:    0.7.0.1
 */
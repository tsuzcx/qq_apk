package com.tencent.mobileqq.mini.widget;

import NS_MINI_INTERFACE.INTERFACE.StExampleDetail;
import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqbn;
import aqnm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment;
import com.tencent.mobileqq.mini.mainpage.PhoneNumberManagementFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class AuthDialog
  extends ReportDialog
  implements View.OnClickListener
{
  public static final String KEY_ONCE_SUB_RESULT_CB_1 = "key_once_sub_cb1";
  public static final String KEY_ONCE_SUB_RESULT_CB_2 = "key_once_sub_cb2";
  public static final String KEY_ONCE_SUB_RESULT_CB_3 = "key_once_sub_cb3";
  public static final String KEY_ONCE_SUB_RESULT_CB_MAINTAIN = "key_once_sub_cb_maintain";
  public static final int REQUEST_CODE_ADD_PHONENUMBER = 1088;
  public static final int REQUEST_CODE_MANAGER_ADD_PHONENUMBER = 1090;
  public static final int REQUEST_CODE_PHONE_MANAGER = 1089;
  private static final String TAG = "AuthDialog";
  public static final int TYPE_NORMAL = 1;
  public static final int TYPE_ONCE_SUB_MSG = 3;
  public static final int TYPE_PHONENUMBER = 2;
  private String mAppId;
  private TextView mAuthDesc;
  private ImageView mAuthInfoBackIcon;
  private TextView mAuthInfoDetailText1;
  private TextView mAuthInfoDetailText2;
  private ImageView mAuthInfoImageView;
  private RelativeLayout mAuthInfoLayout;
  private TextView mAuthInfoTitle;
  private TextView mAuthTitle;
  private LinearLayout mConfirmLayout;
  private Activity mContext;
  private Bundle mData;
  private boolean mIsConfirm;
  private boolean mIsRefuse;
  private TextView mLeftBtn;
  private View mLineView1;
  private View mLineView2;
  private View mLineView3;
  private View mLineView4;
  private ImageView mMiniAppIcon;
  private LinearLayout mMiniAppInfoLayout;
  private TextView mMiniAppName;
  private TextView mOperateNumberBtn;
  private TextView mPhoneNumber1;
  private TextView mPhoneNumber2;
  private TextView mPhoneNumber3;
  private RelativeLayout mPhoneNumberLayout;
  private RelativeLayout mPhoneNumberLayout1;
  private RelativeLayout mPhoneNumberLayout2;
  private RelativeLayout mPhoneNumberLayout3;
  private ImageView mPhoneNumberSection1;
  private ImageView mPhoneNumberSection2;
  private ImageView mPhoneNumberSection3;
  private AuthDialogResBuilder mResBuilder;
  private TextView mRightBtn;
  private View mRootView;
  private int mSelectPhoneNumber = 1;
  private int mType = 1;
  private ImageView mUserIcon;
  private TextView mUserName;
  private CheckBox onceSubCheckBox1;
  private CheckBox onceSubCheckBox2;
  private CheckBox onceSubCheckBox3;
  private RelativeLayout onceSubLayout1;
  private RelativeLayout onceSubLayout2;
  private RelativeLayout onceSubLayout3;
  private CheckBox onceSubMaintainCheckBox;
  private TextView onceSubTextView1;
  private TextView onceSubTextView2;
  private TextView onceSubTextView3;
  private ImageView onceSubTips1;
  private ImageView onceSubTips2;
  private ImageView onceSubTips3;
  private String uin;
  
  public AuthDialog(@NonNull Activity paramActivity)
  {
    super(paramActivity, 2131755431);
    this.mContext = paramActivity;
    initView(paramActivity);
  }
  
  public AuthDialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, 2131755431);
    this.mContext = paramActivity;
    this.mType = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      setCanceledOnTouchOutside(true);
      paramActivity = getWindow();
      if (paramActivity != null) {
        paramActivity.setGravity(80);
      }
      setActivityResultListener();
      return;
      initView(paramActivity);
      continue;
      initPhoneNumberView(paramActivity);
      continue;
      initOnceSubMsgView(paramActivity);
    }
  }
  
  private void initOnceSubMsgView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559598, null);
    this.mRootView = paramContext;
    setContentView(paramContext);
    this.mMiniAppIcon = ((ImageView)paramContext.findViewById(2131371608));
    this.mMiniAppName = ((TextView)paramContext.findViewById(2131371623));
    this.mAuthTitle = ((TextView)paramContext.findViewById(2131363115));
    this.mLeftBtn = ((TextView)paramContext.findViewById(2131370358));
    this.mRightBtn = ((TextView)paramContext.findViewById(2131377294));
    this.onceSubLayout1 = ((RelativeLayout)paramContext.findViewById(2131377448));
    this.onceSubLayout2 = ((RelativeLayout)paramContext.findViewById(2131377449));
    this.onceSubLayout3 = ((RelativeLayout)paramContext.findViewById(2131377450));
    this.onceSubCheckBox1 = ((CheckBox)paramContext.findViewById(2131364363));
    this.onceSubCheckBox2 = ((CheckBox)paramContext.findViewById(2131364364));
    this.onceSubCheckBox3 = ((CheckBox)paramContext.findViewById(2131364365));
    this.onceSubMaintainCheckBox = ((CheckBox)paramContext.findViewById(2131364361));
    this.onceSubTextView1 = ((TextView)paramContext.findViewById(2131380830));
    this.onceSubTextView2 = ((TextView)paramContext.findViewById(2131380831));
    this.onceSubTextView3 = ((TextView)paramContext.findViewById(2131380832));
    this.onceSubTips1 = ((ImageView)paramContext.findViewById(2131369826));
    this.onceSubTips2 = ((ImageView)paramContext.findViewById(2131369827));
    this.onceSubTips3 = ((ImageView)paramContext.findViewById(2131369828));
  }
  
  private void initPhoneNumberView(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559601, null);
    this.mRootView = paramContext;
    setContentView(paramContext);
    this.mMiniAppInfoLayout = ((LinearLayout)paramContext.findViewById(2131371609));
    this.mMiniAppIcon = ((ImageView)paramContext.findViewById(2131371608));
    this.mMiniAppName = ((TextView)paramContext.findViewById(2131371623));
    this.mAuthInfoImageView = ((ImageView)paramContext.findViewById(2131371560));
    this.mAuthInfoImageView.setOnClickListener(this);
    this.mAuthTitle = ((TextView)paramContext.findViewById(2131363115));
    this.mPhoneNumberLayout = ((RelativeLayout)paramContext.findViewById(2131371567));
    this.mPhoneNumberLayout1 = ((RelativeLayout)paramContext.findViewById(2131371629));
    this.mPhoneNumber1 = ((TextView)paramContext.findViewById(2131371625));
    this.mPhoneNumberSection1 = ((ImageView)paramContext.findViewById(2131371652));
    this.mPhoneNumberLayout1.setOnClickListener(this);
    this.mPhoneNumberLayout2 = ((RelativeLayout)paramContext.findViewById(2131371630));
    this.mPhoneNumber2 = ((TextView)paramContext.findViewById(2131371626));
    this.mPhoneNumberSection2 = ((ImageView)paramContext.findViewById(2131371653));
    this.mPhoneNumberLayout2.setOnClickListener(this);
    this.mPhoneNumberLayout3 = ((RelativeLayout)paramContext.findViewById(2131371631));
    this.mPhoneNumber3 = ((TextView)paramContext.findViewById(2131371627));
    this.mPhoneNumberSection3 = ((ImageView)paramContext.findViewById(2131371654));
    this.mPhoneNumberLayout3.setOnClickListener(this);
    this.mLineView1 = paramContext.findViewById(2131371562);
    this.mLineView2 = paramContext.findViewById(2131371563);
    this.mLineView3 = paramContext.findViewById(2131371564);
    this.mLineView4 = paramContext.findViewById(2131371565);
    this.mOperateNumberBtn = ((TextView)paramContext.findViewById(2131371566));
    this.mOperateNumberBtn.setOnClickListener(this);
    this.mConfirmLayout = ((LinearLayout)paramContext.findViewById(2131371555));
    this.mLeftBtn = ((TextView)paramContext.findViewById(2131371618));
    this.mRightBtn = ((TextView)paramContext.findViewById(2131371682));
    this.mAuthInfoLayout = ((RelativeLayout)paramContext.findViewById(2131371561));
    this.mAuthInfoBackIcon = ((ImageView)paramContext.findViewById(2131371556));
    this.mAuthInfoTitle = ((TextView)paramContext.findViewById(2131371559));
    this.mAuthInfoDetailText1 = ((TextView)paramContext.findViewById(2131371557));
    this.mAuthInfoDetailText2 = ((TextView)paramContext.findViewById(2131371558));
    this.mAuthInfoBackIcon.setOnClickListener(this);
    this.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  private void initView(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559577, null);
    this.mRootView = paramContext;
    setContentView(paramContext);
    this.mMiniAppIcon = ((ImageView)paramContext.findViewById(2131371608));
    this.mMiniAppName = ((TextView)paramContext.findViewById(2131371623));
    this.mAuthTitle = ((TextView)paramContext.findViewById(2131363115));
    this.mUserIcon = ((ImageView)paramContext.findViewById(2131381405));
    this.mUserName = ((TextView)paramContext.findViewById(2131381433));
    this.mAuthDesc = ((TextView)paramContext.findViewById(2131363105));
    this.mLeftBtn = ((TextView)paramContext.findViewById(2131370358));
    this.mRightBtn = ((TextView)paramContext.findViewById(2131377294));
  }
  
  private void loadOnceSubItemView(List<INTERFACE.StSubscribeMessage> paramList, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.onceSubTextView1.setText(((INTERFACE.StSubscribeMessage)paramList.get(0)).example.title.get());
      this.onceSubTips1.setOnClickListener(new AuthDialog.4(this, paramList));
      return;
    case 1: 
      this.onceSubTextView2.setText(((INTERFACE.StSubscribeMessage)paramList.get(1)).example.title.get());
      this.onceSubTips2.setOnClickListener(new AuthDialog.5(this, paramList));
      return;
    }
    this.onceSubTextView3.setText(((INTERFACE.StSubscribeMessage)paramList.get(2)).example.title.get());
    this.onceSubTips3.setOnClickListener(new AuthDialog.6(this, paramList));
  }
  
  private void loadOnceSubMsgBottomBtn()
  {
    if (this.mLeftBtn != null)
    {
      this.mLeftBtn.setText(acfp.m(2131703113));
      this.mLeftBtn.setVisibility(0);
      this.mLeftBtn.setOnClickListener(new AuthDialog.2(this));
    }
    if (this.mRightBtn != null)
    {
      this.mRightBtn.setText(acfp.m(2131703112));
      this.mRightBtn.setVisibility(0);
      this.mRightBtn.setOnClickListener(new AuthDialog.3(this));
    }
  }
  
  private void loadOnceSubMsgView()
  {
    Object localObject1 = getData();
    if (localObject1 != null)
    {
      Object localObject2 = ((Bundle)localObject1).getByteArray("key_once_sub_rsp_data");
      localObject1 = new INTERFACE.StGetUserSettingRsp();
      if (localObject2 != null) {}
      try
      {
        ((INTERFACE.StGetUserSettingRsp)localObject1).mergeFrom((byte[])localObject2);
        if (((INTERFACE.StGetUserSettingRsp)localObject1).setting != null)
        {
          localObject1 = ((INTERFACE.StGetUserSettingRsp)localObject1).setting.subItems.get();
          localObject2 = new ArrayList();
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            INTERFACE.StSubscribeMessage localStSubscribeMessage = (INTERFACE.StSubscribeMessage)((List)localObject1).get(i);
            if (localStSubscribeMessage.authState.get() == 0) {
              ((List)localObject2).add(localStSubscribeMessage);
            }
            i += 1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("AuthDialog", 1, "loadOnceSubMsgView - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", localThrowable);
        }
        switch (localThrowable.size())
        {
        default: 
          QLog.e("AuthDialog", 1, "subMsgNoMaintainAuth size > 3 || size == 0!!");
        }
      }
    }
    return;
    this.onceSubLayout1.setVisibility(0);
    this.onceSubLayout2.setVisibility(8);
    this.onceSubLayout3.setVisibility(8);
    loadOnceSubItemView(localThrowable, 0);
    return;
    this.onceSubLayout1.setVisibility(0);
    this.onceSubLayout2.setVisibility(0);
    this.onceSubLayout3.setVisibility(8);
    loadOnceSubItemView(localThrowable, 0);
    loadOnceSubItemView(localThrowable, 1);
    return;
    this.onceSubLayout1.setVisibility(0);
    this.onceSubLayout2.setVisibility(0);
    this.onceSubLayout3.setVisibility(0);
    loadOnceSubItemView(localThrowable, 0);
    loadOnceSubItemView(localThrowable, 1);
    loadOnceSubItemView(localThrowable, 2);
  }
  
  private void setActivityResultListener()
  {
    MiniAppController.getInstance().setActivityResultListener(new AuthDialog.1(this));
  }
  
  private void showOnceSubItemDetailDialog(INTERFACE.StSubscribeMessage paramStSubscribeMessage)
  {
    int j = -1;
    QLog.e("AuthDialog", 1, "showOnceSubItemDetailDialog detailItem: " + paramStSubscribeMessage.example.title.get());
    int i;
    if (this.mRootView != null)
    {
      i = this.mRootView.getHeight();
      j = this.mRootView.getWidth();
    }
    for (;;)
    {
      new AuthDetailDialog(this.mContext, paramStSubscribeMessage, i, j, 1).show();
      return;
      i = -1;
    }
  }
  
  private void updatePhoneNumberView(JSONArray paramJSONArray)
  {
    String str;
    if (paramJSONArray != null)
    {
      str = StorageUtil.getPreference().getString(this.uin + "_PhoneNumber", "");
      QLog.d("AuthDialog", 1, "updatePhoneNumberView phoneNumberArray length : " + paramJSONArray.length());
      switch (paramJSONArray.length())
      {
      }
    }
    JSONObject localJSONObject1;
    label466:
    JSONObject localJSONObject2;
    do
    {
      do
      {
        do
        {
          return;
          paramJSONArray = paramJSONArray.optJSONObject(0);
        } while (paramJSONArray == null);
        this.mPhoneNumberLayout.setVisibility(0);
        this.mPhoneNumberLayout1.setVisibility(0);
        this.mPhoneNumberLayout2.setVisibility(8);
        this.mPhoneNumberLayout3.setVisibility(8);
        this.mPhoneNumber1.setText(paramJSONArray.optString("purePhoneNumber"));
        this.mPhoneNumberSection1.setVisibility(0);
        this.mPhoneNumberSection2.setVisibility(8);
        this.mPhoneNumberSection3.setVisibility(8);
        this.mSelectPhoneNumber = 1;
        this.mLineView1.setVisibility(0);
        this.mLineView2.setVisibility(0);
        this.mLineView3.setVisibility(8);
        this.mLineView4.setVisibility(8);
        this.mOperateNumberBtn.setText("使用其他号码");
        this.mOperateNumberBtn.setVisibility(0);
        return;
        localJSONObject1 = paramJSONArray.optJSONObject(0);
        paramJSONArray = paramJSONArray.optJSONObject(1);
      } while ((localJSONObject1 == null) || (paramJSONArray == null));
      this.mPhoneNumberLayout.setVisibility(0);
      this.mPhoneNumberLayout1.setVisibility(0);
      this.mPhoneNumberLayout2.setVisibility(0);
      this.mPhoneNumberLayout3.setVisibility(8);
      this.mPhoneNumber1.setText(localJSONObject1.optString("purePhoneNumber"));
      this.mPhoneNumber2.setText(paramJSONArray.optString("purePhoneNumber"));
      if (str.equals(localJSONObject1.optString("purePhoneNumber")))
      {
        this.mPhoneNumberSection1.setVisibility(0);
        this.mSelectPhoneNumber = 1;
        if (!str.equals(paramJSONArray.optString("purePhoneNumber"))) {
          break label466;
        }
        this.mPhoneNumberSection2.setVisibility(0);
        this.mSelectPhoneNumber = 2;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str)) {
          this.mPhoneNumberSection1.setVisibility(0);
        }
        this.mPhoneNumberSection3.setVisibility(8);
        this.mLineView1.setVisibility(0);
        this.mLineView2.setVisibility(0);
        this.mLineView3.setVisibility(0);
        this.mLineView4.setVisibility(8);
        this.mOperateNumberBtn.setText("管理手机号码");
        this.mOperateNumberBtn.setVisibility(0);
        return;
        this.mPhoneNumberSection1.setVisibility(8);
        break;
        this.mPhoneNumberSection2.setVisibility(8);
      }
      localJSONObject1 = paramJSONArray.optJSONObject(0);
      localJSONObject2 = paramJSONArray.optJSONObject(1);
      paramJSONArray = paramJSONArray.optJSONObject(2);
    } while ((localJSONObject1 == null) || (localJSONObject2 == null) || (paramJSONArray == null));
    this.mPhoneNumberLayout.setVisibility(0);
    this.mPhoneNumberLayout1.setVisibility(0);
    this.mPhoneNumberLayout2.setVisibility(0);
    this.mPhoneNumberLayout3.setVisibility(0);
    this.mPhoneNumber1.setText(localJSONObject1.optString("purePhoneNumber"));
    this.mPhoneNumber2.setText(localJSONObject2.optString("purePhoneNumber"));
    this.mPhoneNumber3.setText(paramJSONArray.optString("purePhoneNumber"));
    if (str.equals(localJSONObject1.optString("purePhoneNumber")))
    {
      this.mPhoneNumberSection1.setVisibility(0);
      this.mSelectPhoneNumber = 1;
      if (!str.equals(localJSONObject2.optString("purePhoneNumber"))) {
        break label730;
      }
      this.mPhoneNumberSection2.setVisibility(0);
      this.mSelectPhoneNumber = 2;
      label640:
      if (!str.equals(paramJSONArray.optString("purePhoneNumber"))) {
        break label742;
      }
      this.mPhoneNumberSection3.setVisibility(0);
      this.mSelectPhoneNumber = 3;
    }
    for (;;)
    {
      this.mLineView1.setVisibility(0);
      this.mLineView2.setVisibility(0);
      this.mLineView3.setVisibility(0);
      this.mLineView4.setVisibility(0);
      this.mOperateNumberBtn.setText("管理手机号码");
      this.mOperateNumberBtn.setVisibility(0);
      return;
      this.mPhoneNumberSection1.setVisibility(8);
      break;
      label730:
      this.mPhoneNumberSection2.setVisibility(8);
      break label640;
      label742:
      this.mPhoneNumberSection3.setVisibility(8);
    }
  }
  
  public void bindData(Bundle paramBundle)
  {
    this.mData = paramBundle;
    if (paramBundle != null) {
      this.mAppId = paramBundle.getString("key_app_id");
    }
  }
  
  public Bundle getData()
  {
    return this.mData;
  }
  
  public JSONObject getSelectPhoneNumber()
  {
    try
    {
      if (this.mResBuilder != null)
      {
        JSONObject localJSONObject = this.mResBuilder.getPhoneNumberList().optJSONObject(this.mSelectPhoneNumber - 1);
        return localJSONObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AuthDialog", 1, "getSelectPhoneNumber error,", localThrowable);
    }
    return null;
  }
  
  protected URLDrawable getUrlDrawable(String paramString, int paramInt)
  {
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt;
    Object localObject1 = null;
    try
    {
      localObject2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("AuthDialog", 2, "getIcon url: " + paramString);
    }
    return localObject1;
    return null;
  }
  
  public boolean isConfirm()
  {
    return this.mIsConfirm;
  }
  
  public boolean isRefuse()
  {
    return this.mIsRefuse;
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
      this.mPhoneNumberSection1.setVisibility(0);
      this.mPhoneNumberSection2.setVisibility(8);
      this.mPhoneNumberSection3.setVisibility(8);
      this.mSelectPhoneNumber = 1;
      continue;
      this.mPhoneNumberSection1.setVisibility(8);
      this.mPhoneNumberSection2.setVisibility(0);
      this.mPhoneNumberSection3.setVisibility(8);
      this.mSelectPhoneNumber = 2;
      continue;
      this.mPhoneNumberSection1.setVisibility(8);
      this.mPhoneNumberSection2.setVisibility(8);
      this.mPhoneNumberSection3.setVisibility(0);
      this.mSelectPhoneNumber = 3;
      continue;
      Intent localIntent = new Intent();
      localIntent.putExtra("appId", this.mAppId);
      if (this.mOperateNumberBtn.getText().equals("管理手机号码"))
      {
        if ((this.mResBuilder != null) && (this.mResBuilder.getPhoneNumberList() != null) && (this.mResBuilder.getPhoneNumberList().length() > 0)) {
          localIntent.putExtra("phoneNumberList", this.mResBuilder.getPhoneNumberList().toString());
        }
        PublicFragmentActivity.b.startForResult(this.mContext, localIntent, PublicFragmentActivityForMini.class, PhoneNumberManagementFragment.class, 1089);
      }
      else
      {
        PublicFragmentActivity.b.startForResult(this.mContext, localIntent, PublicFragmentActivityForMini.class, AddPhoneNumberFragment.class, 1088);
        continue;
        this.mAuthInfoLayout.setVisibility(0);
        this.mAuthTitle.setVisibility(4);
        this.mMiniAppInfoLayout.setVisibility(4);
        this.mAuthInfoImageView.setVisibility(4);
        this.mAuthInfoImageView.setVisibility(4);
        this.mPhoneNumberLayout.setVisibility(4);
        this.mConfirmLayout.setVisibility(4);
        continue;
        this.mAuthInfoLayout.setVisibility(4);
        this.mAuthTitle.setVisibility(0);
        this.mMiniAppInfoLayout.setVisibility(0);
        this.mAuthInfoImageView.setVisibility(0);
        this.mAuthInfoImageView.setVisibility(0);
        this.mPhoneNumberLayout.setVisibility(0);
        this.mConfirmLayout.setVisibility(0);
      }
    }
  }
  
  public void setConfirm(boolean paramBoolean)
  {
    this.mIsConfirm = paramBoolean;
  }
  
  public void setRefuse(boolean paramBoolean)
  {
    this.mIsRefuse = paramBoolean;
  }
  
  public void show(AuthDialogResBuilder paramAuthDialogResBuilder)
  {
    if (paramAuthDialogResBuilder == null)
    {
      QLog.e("AuthDialog", 1, "authdialog show error, resBuilder is null, return.");
      return;
    }
    if ((this.mType == 2) && ((paramAuthDialogResBuilder.getPhoneNumberList() == null) || (paramAuthDialogResBuilder.getPhoneNumberList().length() <= 0)))
    {
      QLog.e("AuthDialog", 1, "authdialog show error, getPhoneNumberList is null, return.");
      return;
    }
    this.mResBuilder = paramAuthDialogResBuilder;
    this.mIsConfirm = false;
    this.mIsRefuse = false;
    int i = aqnm.dpToPx(26.0F);
    URLDrawable localURLDrawable;
    if ((this.mMiniAppIcon != null) && (!TextUtils.isEmpty(paramAuthDialogResBuilder.getMiniAppIconUrl())))
    {
      localURLDrawable = getUrlDrawable(paramAuthDialogResBuilder.getMiniAppIconUrl(), i);
      if (localURLDrawable != null)
      {
        localURLDrawable.setTag(aqbn.d(i, i, aqnm.dpToPx(5.0F)));
        localURLDrawable.setDecodeHandler(aqbn.a);
        this.mMiniAppIcon.setImageDrawable(localURLDrawable);
      }
    }
    if ((this.mMiniAppName != null) && (!TextUtils.isEmpty(paramAuthDialogResBuilder.getMiniAppName()))) {
      this.mMiniAppName.setText(paramAuthDialogResBuilder.getMiniAppName());
    }
    if ((this.mAuthTitle != null) && (!TextUtils.isEmpty(paramAuthDialogResBuilder.getAuthTitle()))) {
      this.mAuthTitle.setText(paramAuthDialogResBuilder.getAuthTitle());
    }
    if (this.mUserIcon != null)
    {
      if (!TextUtils.isEmpty(paramAuthDialogResBuilder.getUserIconUrl()))
      {
        int j = aqnm.dpToPx(40.0F);
        localURLDrawable = getUrlDrawable(paramAuthDialogResBuilder.getUserIconUrl(), j);
        if (localURLDrawable != null)
        {
          localURLDrawable.setTag(aqbn.e(i, i));
          localURLDrawable.setDecodeHandler(aqbn.b);
          this.mUserIcon.setImageDrawable(localURLDrawable);
        }
        this.mUserIcon.setVisibility(0);
      }
    }
    else
    {
      if (this.mUserName != null)
      {
        if (TextUtils.isEmpty(paramAuthDialogResBuilder.getUserName())) {
          break label397;
        }
        this.mUserName.setText(paramAuthDialogResBuilder.getUserName());
        this.mUserName.setVisibility(0);
      }
      label304:
      if (this.mType != 3) {
        break label409;
      }
      loadOnceSubMsgBottomBtn();
      label316:
      if (this.mAuthDesc != null)
      {
        if (TextUtils.isEmpty(paramAuthDialogResBuilder.getAuthDesc())) {
          break label544;
        }
        this.mAuthDesc.setVisibility(0);
        this.mAuthDesc.setText(paramAuthDialogResBuilder.getAuthDesc());
      }
    }
    for (;;)
    {
      if (this.mType == 2) {
        updatePhoneNumberView(paramAuthDialogResBuilder.getPhoneNumberList());
      }
      if (this.mType == 3) {
        loadOnceSubMsgView();
      }
      show();
      return;
      this.mUserIcon.setVisibility(8);
      break;
      label397:
      this.mUserName.setVisibility(8);
      break label304;
      label409:
      if (this.mLeftBtn != null)
      {
        if (TextUtils.isEmpty(paramAuthDialogResBuilder.getLeftBtnText())) {
          break label520;
        }
        this.mLeftBtn.setText(paramAuthDialogResBuilder.getLeftBtnText());
        this.mLeftBtn.setVisibility(0);
        if (paramAuthDialogResBuilder.getLeftBtnClickListener() != null) {
          this.mLeftBtn.setOnClickListener(paramAuthDialogResBuilder.getLeftBtnClickListener());
        }
      }
      for (;;)
      {
        if (this.mRightBtn == null) {
          break label530;
        }
        if (TextUtils.isEmpty(paramAuthDialogResBuilder.getRightBtnText())) {
          break label532;
        }
        this.mRightBtn.setText(paramAuthDialogResBuilder.getRightBtnText());
        this.mRightBtn.setVisibility(0);
        if (paramAuthDialogResBuilder.getRightBtnClickListener() == null) {
          break;
        }
        this.mRightBtn.setOnClickListener(paramAuthDialogResBuilder.getRightBtnClickListener());
        break;
        label520:
        this.mLeftBtn.setVisibility(8);
      }
      label530:
      break label316;
      label532:
      this.mRightBtn.setVisibility(8);
      break label316;
      label544:
      this.mAuthDesc.setVisibility(8);
    }
  }
  
  public static class AuthDialogResBuilder
  {
    private String mAuthDesc;
    private String mAuthTitle;
    private View.OnClickListener mLeftBtnClickListener;
    private String mLeftBtnText;
    private String mMiniAppIconUrl;
    private String mMiniAppName;
    private JSONArray mPhoneNumberList;
    private View.OnClickListener mRightBtnClickListener;
    private String mRightBtnText;
    private String mUserIconUrl;
    private String mUserName;
    
    public String getAuthDesc()
    {
      return this.mAuthDesc;
    }
    
    public String getAuthTitle()
    {
      return this.mAuthTitle;
    }
    
    public View.OnClickListener getLeftBtnClickListener()
    {
      return this.mLeftBtnClickListener;
    }
    
    public String getLeftBtnText()
    {
      return this.mLeftBtnText;
    }
    
    public String getMiniAppIconUrl()
    {
      return this.mMiniAppIconUrl;
    }
    
    public String getMiniAppName()
    {
      return this.mMiniAppName;
    }
    
    public JSONArray getPhoneNumberList()
    {
      return this.mPhoneNumberList;
    }
    
    public View.OnClickListener getRightBtnClickListener()
    {
      return this.mRightBtnClickListener;
    }
    
    public String getRightBtnText()
    {
      return this.mRightBtnText;
    }
    
    public String getUserIconUrl()
    {
      return this.mUserIconUrl;
    }
    
    public String getUserName()
    {
      return this.mUserName;
    }
    
    public AuthDialogResBuilder setAuthDesc(String paramString)
    {
      this.mAuthDesc = paramString;
      return this;
    }
    
    public AuthDialogResBuilder setAuthTitle(String paramString)
    {
      this.mAuthTitle = paramString;
      return this;
    }
    
    public AuthDialogResBuilder setLeftBtnClickListener(View.OnClickListener paramOnClickListener)
    {
      this.mLeftBtnClickListener = paramOnClickListener;
      return this;
    }
    
    public AuthDialogResBuilder setLeftBtnText(String paramString)
    {
      this.mLeftBtnText = paramString;
      return this;
    }
    
    public AuthDialogResBuilder setMiniAppIconUrl(String paramString)
    {
      this.mMiniAppIconUrl = paramString;
      return this;
    }
    
    public AuthDialogResBuilder setMiniAppName(String paramString)
    {
      this.mMiniAppName = paramString;
      return this;
    }
    
    public AuthDialogResBuilder setPhoneNumberList(JSONArray paramJSONArray)
    {
      this.mPhoneNumberList = paramJSONArray;
      return this;
    }
    
    public AuthDialogResBuilder setRightBtnClickListener(View.OnClickListener paramOnClickListener)
    {
      this.mRightBtnClickListener = paramOnClickListener;
      return this;
    }
    
    public AuthDialogResBuilder setRightBtnText(String paramString)
    {
      this.mRightBtnText = paramString;
      return this;
    }
    
    public AuthDialogResBuilder setUserIconUrl(String paramString)
    {
      this.mUserIconUrl = paramString;
      return this;
    }
    
    public AuthDialogResBuilder setUserName(String paramString)
    {
      this.mUserName = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDialog
 * JD-Core Version:    0.7.0.1
 */
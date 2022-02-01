package com.tencent.mobileqq.activity.qwallet.emoj;

import aaay;
import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoop;
import aqmr;
import avor;
import avox;
import avox.a;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import rpq;

public class EmojiFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  private static final String SP_KEY_NAME = "is_first_in";
  private static final String SP_NAME = "red_packet";
  private static final String TAG = "EmojiFragment";
  int availableRight = 0;
  public TemplateBundleInfo bundleInfo = new TemplateBundleInfo();
  public Button confirm;
  public int currSkinId;
  public int currentTempId = -1;
  public String currentWish;
  public EmoticonTemplateRecyclerView emoticonTemplateRecyclerView;
  private SparseArray<ImageView> imgViewSparseArray = new SparseArray();
  public EditText mAmoutTxt;
  public EmojiRedpacketUserGuideDialog mPopupWindow;
  public ImageView mPrefImageView;
  private String mTempId;
  private List<TemplateInfo> mTemplateBundleInfos;
  protected TextWatcher mTextWatcher = new EmojiFragment.1(this);
  public long mlastInvalidatetime;
  public EditText numTxt;
  private TemplateInfo preTemplateInfo;
  public View rootView;
  private SparseArray<URLDrawable> urlDrawableSparseArray = new SparseArray();
  
  private List<TemplateInfo> initData(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    TemplateInfo localTemplateInfo = null;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject;
        if (aqmr.isEmpty(paramString1))
        {
          localJSONObject = getHbPannelConfig(8);
          paramString1 = localTemplateInfo;
          if (localJSONObject != null)
          {
            paramString1 = localJSONObject.optJSONArray("heartList");
            paramString2 = localJSONObject.optString("prefix");
            break label234;
            if (paramString1 == null) {
              break label237;
            }
            if (paramString1.length() != 0) {
              break label240;
            }
            break label237;
          }
        }
        else
        {
          paramString1 = new JSONArray(paramString1);
          continue;
          if (i < paramString1.length())
          {
            localTemplateInfo = new TemplateInfo();
            localTemplateInfo.index = i;
            localJSONObject = paramString1.optJSONObject(i);
            if (localJSONObject != null)
            {
              localTemplateInfo.rId = localJSONObject.optInt("rId");
              localTemplateInfo.skinId = localJSONObject.optInt("skinId");
              localTemplateInfo.text = localJSONObject.optString("text");
              localTemplateInfo.url = (paramString2 + localTemplateInfo.rId + ".png");
              localArrayList.add(localTemplateInfo);
            }
            i += 1;
            continue;
          }
          return localArrayList;
        }
      }
      catch (Throwable paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EmojiFragment", 1, "init emoji template data throw an exception: " + paramString1);
        }
      }
      label234:
      continue;
      label237:
      return localArrayList;
      label240:
      int i = 0;
    }
  }
  
  private void initView(View paramView, Bundle paramBundle)
  {
    try
    {
      avox.a(paramBundle, this.bundleInfo);
      paramView.findViewById(2131369946).setOnClickListener(this);
      this.emoticonTemplateRecyclerView = ((EmoticonTemplateRecyclerView)paramView.findViewById(2131379313));
      paramBundle = new TemplateListAdapter(this.mActivity);
      this.mTemplateBundleInfos = initData(this.bundleInfo.heartList, this.bundleInfo.prefix);
      paramBundle.addTempList(this.mTemplateBundleInfos);
      this.emoticonTemplateRecyclerView.setAdapter(paramBundle);
      this.emoticonTemplateRecyclerView.setLayoutManager(new GridLayoutManager(this.mActivity, 4, 1, false));
      paramBundle = new TempGridItemLayoutDecoration(this.mActivity, 4);
      this.emoticonTemplateRecyclerView.addItemDecoration(paramBundle);
      this.mAmoutTxt = ((EditText)paramView.findViewById(2131362698));
      this.mAmoutTxt.addTextChangedListener(this.mTextWatcher);
      this.numTxt = ((EditText)paramView.findViewById(2131372567));
      if (avox.LH.contains(this.bundleInfo.recv_type))
      {
        this.numTxt.setText("1");
        paramView.findViewById(2131380131).setVisibility(8);
      }
      for (;;)
      {
        if ((this.mTemplateBundleInfos != null) && (this.mTemplateBundleInfos.size() > 0)) {
          setSelected((TemplateInfo)this.mTemplateBundleInfos.get(0));
        }
        paramBundle = this.bundleInfo.biz_params;
        if (!aqmr.isEmpty(paramBundle)) {
          this.mTempId = new JSONObject(paramBundle).optString("temp_id");
        }
        if (!aqmr.isEmpty(this.mTempId)) {
          processDefaultTmpException(this.mTempId);
        }
        this.confirm = ((Button)paramView.findViewById(2131365219));
        this.confirm.setOnClickListener(this);
        freshConfirmBtn();
        return;
        if (!TextUtils.isEmpty(this.bundleInfo.people_num)) {
          this.numTxt.setHint(acfp.m(2131705770) + this.bundleInfo.people_num + acfp.m(2131705771));
        }
        this.numTxt.addTextChangedListener(this.mTextWatcher);
      }
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private void processDefaultTmpException(String paramString)
  {
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString);
        paramString = this.mTemplateBundleInfos.iterator();
        if (paramString.hasNext())
        {
          TemplateInfo localTemplateInfo = (TemplateInfo)paramString.next();
          if (i != localTemplateInfo.rId) {
            continue;
          }
          setSelected(localTemplateInfo);
          i = 1;
          if (i == 0) {
            QQToast.a(getActivity(), 2131698931, 0).show();
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("EmojiFragment", 1, "processDefaultTmpSelected occur an exception: " + paramString);
        QQToast.a(getActivity(), 2131698931, 0).show();
        return;
      }
      int i = 0;
    }
  }
  
  private void setDefaultTempSelected(TemplateInfo paramTemplateInfo, String paramString, ImageView paramImageView)
  {
    try
    {
      if ((Integer.parseInt(paramString) == paramTemplateInfo.rId) && (paramImageView != null)) {
        onTempSelected(paramTemplateInfo, paramImageView);
      }
      return;
    }
    catch (Exception paramTemplateInfo)
    {
      QLog.e("EmojiFragment", 1, "processDefaultTmpSelected occur an exception: " + paramTemplateInfo);
    }
  }
  
  private void setSelected(TemplateInfo paramTemplateInfo)
  {
    if (this.mTemplateBundleInfos != null)
    {
      int i = 0;
      if (i < this.mTemplateBundleInfos.size())
      {
        TemplateInfo localTemplateInfo = (TemplateInfo)this.mTemplateBundleInfos.get(i);
        if (localTemplateInfo.rId == paramTemplateInfo.rId) {}
        for (localTemplateInfo.isSelected = true;; localTemplateInfo.isSelected = false)
        {
          i += 1;
          break;
        }
      }
    }
    if (this.preTemplateInfo != null) {
      handleDrawableSucc((URLDrawable)this.urlDrawableSparseArray.get(this.preTemplateInfo.rId), false, this.preTemplateInfo.rId, (ImageView)this.imgViewSparseArray.get(this.preTemplateInfo.rId));
    }
    if (paramTemplateInfo != null) {
      handleDrawableSucc((URLDrawable)this.urlDrawableSparseArray.get(paramTemplateInfo.rId), true, paramTemplateInfo.rId, (ImageView)this.imgViewSparseArray.get(paramTemplateInfo.rId));
    }
    this.preTemplateInfo = paramTemplateInfo;
  }
  
  public void freshConfirmBtn()
  {
    if (this.confirm == null) {
      return;
    }
    Object localObject = this.numTxt.getText().toString();
    String str = this.mAmoutTxt.getText().toString();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str)) || (this.currentTempId == -1)) {}
    for (int i = 1; i != 0; i = 0)
    {
      QLog.i("EmojiFragment", 2, "info is not complete...");
      this.confirm.setEnabled(false);
      this.confirm.setText(getString(2131699008));
      return;
    }
    if ((avor.h((String)localObject) <= 0.0F) || (avor.h(str) <= 0.0F))
    {
      this.confirm.setEnabled(false);
      this.confirm.setText(getString(2131699008));
      return;
    }
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(getString(2131699008));
    ((StringBuffer)localObject).append(str);
    ((StringBuffer)localObject).append("元");
    this.confirm.setText(((StringBuffer)localObject).toString());
    this.confirm.setEnabled(true);
  }
  
  public void handleDrawableSucc(URLDrawable paramURLDrawable, boolean paramBoolean, int paramInt, ImageView paramImageView)
  {
    if (paramURLDrawable == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return;
        localBundle = new Bundle();
        localBundle.putBoolean("key_play_apng", paramBoolean);
        localObject = paramURLDrawable.getURL().getFile();
        paramURLDrawable = (URLDrawable)localObject;
        if (((String)localObject).startsWith(File.separator)) {
          paramURLDrawable = ((String)localObject).substring(1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("EmojiFragment", 2, "thread name: " + Thread.currentThread().getName());
        }
      } while (paramImageView == null);
      Object localObject = QWalletPicHelper.getNetDrawableForQWallet(paramURLDrawable, aoop.TRANSPARENT, aoop.TRANSPARENT, localBundle);
      paramImageView.setImageDrawable((Drawable)localObject);
      this.urlDrawableSparseArray.put(paramInt, localObject);
    } while (!paramBoolean);
    paramImageView = new Bundle();
    paramImageView.putBoolean("key_play_apng", false);
    ThreadManager.excute(new EmojiFragment.2(this, QWalletPicHelper.getNetDrawableForQWallet(paramURLDrawable, aoop.TRANSPARENT, aoop.TRANSPARENT, paramImageView)), 16, null, true);
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
      onConfirmClick();
      continue;
      showUserGuid();
    }
  }
  
  public void onConfirmClick()
  {
    this.mActivity.zY("phiz.wrappacket.wrap");
    long l = System.currentTimeMillis();
    if (this.mlastInvalidatetime + 1000L > l) {
      return;
    }
    this.mlastInvalidatetime = l;
    String str1 = this.numTxt.getText().toString();
    String str2 = this.mAmoutTxt.getText().toString();
    Map localMap = this.mActivity.Y();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.currentWish);
    localMap.put("feedsid", String.valueOf(this.currentTempId));
    localMap.put("bus_type", "2");
    localMap.put("total_num", str1);
    localMap.put("total_amount", avor.hX(str2));
    localMap.put("channel", this.channel + "");
    localMap.put("skin_id", this.currSkinId + "");
    this.mLogic.Z(localMap);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mActivity.getWindow().setSoftInputMode(32);
    this.rootView = paramLayoutInflater.inflate(2131562098, null);
    initView(this.rootView, getArguments());
    paramLayoutInflater = this.rootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.urlDrawableSparseArray != null) {
      this.urlDrawableSparseArray.clear();
    }
    if (this.imgViewSparseArray != null) {
      this.imgViewSparseArray.clear();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ThreadManager.getUIHandler().post(new EmojiFragment.3(this));
  }
  
  public void onTempSelected(TemplateInfo paramTemplateInfo, ImageView paramImageView)
  {
    this.currentTempId = paramTemplateInfo.rId;
    this.currentWish = paramTemplateInfo.text;
    this.currSkinId = paramTemplateInfo.skinId;
    freshConfirmBtn();
    if (this.mPrefImageView == paramImageView) {
      return;
    }
    paramImageView.setBackgroundResource(2130844178);
    if (this.mPrefImageView != null) {
      this.mPrefImageView.setBackgroundDrawable(null);
    }
    this.mPrefImageView = paramImageView;
    setSelected(paramTemplateInfo);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("EmojiFragment", 2, "phiz redpacket enter...");
      if (this.mActivity != null) {
        this.mActivity.zY("phiz.wrappacket.show");
      }
    }
  }
  
  public void showUserGuid()
  {
    if (this.mPopupWindow == null) {
      this.mPopupWindow = new EmojiRedpacketUserGuideDialog(this.mActivity);
    }
    for (;;)
    {
      this.mPopupWindow.show();
      return;
      if (this.mPopupWindow.isShowing()) {
        this.mPopupWindow.dismiss();
      }
    }
  }
  
  public class TempGridItemLayoutDecoration
    extends RecyclerView.ItemDecoration
  {
    public Context mContext;
    public int mNumColumns;
    
    public TempGridItemLayoutDecoration(Context paramContext, int paramInt)
    {
      this.mContext = paramContext;
      this.mNumColumns = paramInt;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      int i = 0;
      paramView.measure(0, 0);
      int j = (paramRecyclerView.getMeasuredWidth() - paramView.getMeasuredWidth() * this.mNumColumns) / (this.mNumColumns + 1);
      if (QLog.isColorLevel()) {
        QLog.i("EmojiFragment", 2, "getItemOffsets getMeasuredWidth: " + paramView.getMeasuredWidth());
      }
      int k = paramRecyclerView.getChildAdapterPosition(paramView);
      int m = this.mNumColumns;
      int n = ((this.mNumColumns - 1) * j + j + j) / this.mNumColumns;
      if (k % this.mNumColumns == 0)
      {
        paramRect.left = j;
        EmojiFragment.this.availableRight = (n - j);
        paramRect.right = EmojiFragment.this.availableRight;
      }
      for (;;)
      {
        if (paramRecyclerView.getChildAdapterPosition(paramView) < this.mNumColumns) {
          i = 1;
        }
        if (i == 0) {
          paramRect.top = rpq.dip2px(this.mContext, 11.0F);
        }
        return;
        if (k % this.mNumColumns == m - 1)
        {
          paramRect.right = j;
          paramRect.left = (n - j);
        }
        else
        {
          paramRect.left = (j - EmojiFragment.this.availableRight);
          EmojiFragment.this.availableRight = (n - (j - EmojiFragment.this.availableRight));
          paramRect.right = EmojiFragment.this.availableRight;
        }
      }
    }
  }
  
  class TempListItem
    extends FrameLayout
  {
    private ImageView mCornerImageView;
    private ImageView mImageView;
    private TextView mItem;
    private View mLoadingView;
    private LinearLayout mRootLayout;
    
    public TempListItem(@NonNull Context paramContext)
    {
      super();
      this.mRootLayout = new LinearLayout(paramContext);
      this.mRootLayout.setOrientation(1);
      this.mRootLayout.setClickable(true);
      addView(this.mRootLayout);
      this$1 = (FrameLayout.LayoutParams)this.mRootLayout.getLayoutParams();
      EmojiFragment.this.width = -2;
      EmojiFragment.this.height = -2;
      this$1 = new RelativeLayout(paramContext);
      this.mRootLayout.addView(EmojiFragment.this);
      Object localObject = (LinearLayout.LayoutParams)EmojiFragment.this.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = rpq.dip2px(paramContext, 66.0F);
      ((LinearLayout.LayoutParams)localObject).height = rpq.dip2px(paramContext, 66.0F);
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      this.mCornerImageView = new ImageView(paramContext);
      EmojiFragment.this.addView(this.mCornerImageView);
      this.mCornerImageView.getLayoutParams().width = rpq.dip2px(paramContext, 66.0F);
      this.mCornerImageView.getLayoutParams().height = rpq.dip2px(paramContext, 66.0F);
      this.mCornerImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.mCornerImageView.setImageResource(2130844177);
      this.mCornerImageView.setVisibility(8);
      this.mLoadingView = new View(paramContext);
      EmojiFragment.this.addView(this.mLoadingView);
      localObject = (RelativeLayout.LayoutParams)this.mLoadingView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = rpq.dip2px(paramContext, 40.0F);
      ((RelativeLayout.LayoutParams)localObject).height = rpq.dip2px(paramContext, 40.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      this.mImageView = new ImageView(paramContext);
      EmojiFragment.this.addView(this.mImageView);
      this.mImageView.getLayoutParams().width = -1;
      this.mImageView.getLayoutParams().height = -1;
      this.mItem = new TextView(paramContext);
      this.mItem.setSingleLine(true);
      this.mItem.setMaxEms(5);
      this.mItem.setEllipsize(TextUtils.TruncateAt.END);
      this.mItem.setTextSize(1, 14.0F);
      this.mItem.setTextColor(Color.parseColor("#FF777777"));
      this.mRootLayout.addView(this.mItem);
      this$1 = (LinearLayout.LayoutParams)this.mItem.getLayoutParams();
      EmojiFragment.this.width = -2;
      EmojiFragment.this.height = -2;
      EmojiFragment.this.gravity = 1;
      EmojiFragment.this.topMargin = rpq.dip2px(paramContext, 6.0F);
    }
    
    public void setData(EmojiFragment.TemplateInfo paramTemplateInfo)
    {
      if (this.mRootLayout != null) {
        this.mRootLayout.setOnClickListener(new EmojiFragment.TempListItem.1(this, paramTemplateInfo));
      }
      if (this.mItem != null) {
        this.mItem.setText(paramTemplateInfo.text);
      }
      Object localObject1;
      if (this.mImageView != null)
      {
        localObject1 = paramTemplateInfo.url;
        if (QLog.isColorLevel()) {
          QLog.i("EmojiFragment", 2, "模板url: " + (String)localObject1);
        }
        Object localObject2 = getResources().getDrawable(2130844271);
        this.mLoadingView.setBackgroundDrawable((Drawable)localObject2);
        ((Animatable)localObject2).start();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("qwallet_config_md5", paramTemplateInfo.md5);
        localObject1 = QWalletPicHelper.getNetDrawableForQWallet((String)localObject1, aoop.TRANSPARENT, aoop.TRANSPARENT, (Bundle)localObject2);
        this.mImageView.setImageDrawable((Drawable)localObject1);
        if (localObject1 == null) {
          break label252;
        }
        if (((URLDrawable)localObject1).getStatus() != 1) {
          break label230;
        }
        this.mLoadingView.setBackgroundDrawable(null);
        this.mCornerImageView.setVisibility(0);
        EmojiFragment.this.handleDrawableSucc((URLDrawable)localObject1, paramTemplateInfo.isSelected, paramTemplateInfo.rId, this.mImageView);
        ((URLDrawable)localObject1).setURLDrawableListener(new EmojiFragment.TempListItem.2(this, paramTemplateInfo));
      }
      for (;;)
      {
        if (paramTemplateInfo.isSelected) {
          EmojiFragment.this.onTempSelected(paramTemplateInfo, this.mImageView);
        }
        return;
        label230:
        if ((((URLDrawable)localObject1).getStatus() == 1) || (((URLDrawable)localObject1).getStatus() == 0)) {
          break;
        }
        ((URLDrawable)localObject1).restartDownload();
        break;
        label252:
        this.mImageView.setImageDrawable(null);
        this.mLoadingView.setBackgroundDrawable(getResources().getDrawable(2130844348));
        this.mCornerImageView.setVisibility(8);
      }
    }
  }
  
  public static class TemplateBundleInfo
    extends avox.a
  {
    public String heartList;
    public String prefix;
  }
  
  public static class TemplateInfo
  {
    public int index;
    public boolean isSelected;
    public String md5;
    public int rId;
    public int skinId;
    public String text;
    public String url;
  }
  
  public class TemplateListAdapter
    extends RecyclerView.Adapter<TemplateItemVH>
  {
    private Context context;
    private List<EmojiFragment.TemplateInfo> mTemplateBundleInfoList = new ArrayList();
    
    public TemplateListAdapter(Context paramContext)
    {
      this.context = paramContext;
    }
    
    void addTempList(List<EmojiFragment.TemplateInfo> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return;
      }
      this.mTemplateBundleInfoList.addAll(paramList);
      notifyDataSetChanged();
    }
    
    public int getItemCount()
    {
      if ((this.mTemplateBundleInfoList == null) || (this.mTemplateBundleInfoList.isEmpty())) {
        return 0;
      }
      return this.mTemplateBundleInfoList.size();
    }
    
    public void onBindViewHolder(TemplateItemVH paramTemplateItemVH, int paramInt)
    {
      EmojiFragment.TemplateInfo localTemplateInfo = (EmojiFragment.TemplateInfo)this.mTemplateBundleInfoList.get(paramInt);
      if (localTemplateInfo == null) {}
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramTemplateItemVH, paramInt, getItemId(paramInt));
        return;
        EmojiFragment.TempListItem localTempListItem = paramTemplateItemVH.tempListItem;
        if (localTempListItem != null)
        {
          EmojiFragment.this.imgViewSparseArray.put(localTemplateInfo.rId, localTempListItem.mImageView);
          localTempListItem.setData(localTemplateInfo);
        }
      }
    }
    
    public TemplateItemVH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new TemplateItemVH(new EmojiFragment.TempListItem(EmojiFragment.this, this.context));
    }
    
    public class TemplateItemVH
      extends RecyclerView.ViewHolder
    {
      public EmojiFragment.TempListItem tempListItem;
      
      public TemplateItemVH(View paramView)
      {
        super();
        this.tempListItem = ((EmojiFragment.TempListItem)paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import acfp;
import albb;
import alcn;
import alcs;
import alhi;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import aqft;
import aqiw;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import cooperation.qzone.model.CoverCacheData;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VipPhotoViewForSimple
  extends LinearLayout
  implements Handler.Callback
{
  public static float yw = 1.43F;
  public int Cl = -1;
  private alcn a;
  public HorizontalScrollView a;
  public int aGK = -1;
  public int aGL = -1;
  public QQAppInterface app;
  public List<QzonePhotoView.b> cE;
  private boolean cwG;
  public int dtM = -1;
  public int dtN = -1;
  public int dtO = -1;
  private int dtf;
  public GridView e;
  private ImageView hL;
  CoverCacheData j;
  private View jo;
  private Activity mActivity;
  View mContentView;
  public int mGridWidth = -1;
  private Handler mHandler;
  private View.OnClickListener mOnClickListener = new alhi(this);
  public int mScreenHeight;
  public int mScreenWidth;
  private String mUin;
  public float yv = 1.5F;
  
  public VipPhotoViewForSimple(Context paramContext)
  {
    super(paramContext);
  }
  
  public VipPhotoViewForSimple(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void NK(boolean paramBoolean)
  {
    String str = "https://ti.qq.com/photowall/index.html?_wv=1027";
    if (!paramBoolean) {
      str = "https://ti.qq.com/photowall/index.html?_wv=1027" + "&uin=" + this.mUin;
    }
    Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", str);
    if (!paramBoolean)
    {
      this.mActivity.startActivity(localIntent);
      return;
    }
    this.mActivity.startActivityForResult(localIntent, 1022);
  }
  
  private List<QzonePhotoView.b> e(String paramString, List<Map<Integer, String>> paramList)
  {
    int k = 0;
    LinkedList localLinkedList = new LinkedList();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update").append("|type = ").append(paramString).append("|vecUrls = ").append(paramList);
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, localStringBuilder.toString());
    }
    if (this.j == null) {
      this.j = new CoverCacheData();
    }
    this.j.type = paramString;
    this.j.EY = ((ArrayList)paramList);
    this.j.uin = Long.parseLong(this.mUin);
    int i;
    if (paramList != null) {
      i = paramList.size();
    }
    while ((k < i) && (k < 16))
    {
      paramString = (Map)paramList.get(k);
      if (paramString != null)
      {
        paramString = new QzonePhotoView.b(k, 100, paramString);
        paramString.cYf = localLinkedList.size();
        paramString.dtw = k;
        localLinkedList.add(paramString);
      }
      k += 1;
      continue;
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updateCoverData photoInfo size=" + localLinkedList.size());
    }
    return localLinkedList;
  }
  
  @TargetApi(9)
  public void a(BaseActivity paramBaseActivity, alcn paramalcn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "initView");
    }
    this.app = paramBaseActivity.app;
    this.mActivity = paramBaseActivity;
    this.jdField_a_of_type_Alcn = paramalcn;
    this.mHandler = new Handler(this);
    this.mUin = paramalcn.e.uin;
    this.mContentView = LayoutInflater.from(this.app.getApplication()).inflate(2131562228, this, true);
    this.e = ((GridView)this.mContentView.findViewById(2131373194));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.mContentView.findViewById(2131373195));
    this.hL = ((ImageView)this.mContentView.findViewById(2131373655));
    this.jo = this.mContentView.findViewById(2131375573);
    paramBaseActivity = getResources().getDisplayMetrics();
    this.mScreenWidth = paramBaseActivity.widthPixels;
    this.mScreenHeight = paramBaseActivity.heightPixels;
    int i = (int)(this.mScreenWidth / this.yv);
    this.Cl = i;
    this.mGridWidth = i;
    this.aGK = ((int)(this.mGridWidth / yw));
    this.dtN = getResources().getDimensionPixelSize(2131298982);
    this.dtO = getResources().getDimensionPixelSize(2131298981);
    this.dtM = (this.aGK + this.dtN + this.dtO);
    this.aGL = getResources().getDimensionPixelSize(2131298983);
    if (paramalcn.e.pa == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.cwG = bool;
      if (VersionUtils.isGingerBread()) {
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
      }
      paramBaseActivity = this.mUin;
      ThreadManager.post(new VipPhotoViewForSimple.1(this), 8, null, true);
      paramBaseActivity = Message.obtain();
      paramBaseActivity.what = 100;
      this.mHandler.sendMessage(paramBaseActivity);
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "onGetQZoneCover|isSuc = " + paramBoolean + ",uin=" + paramString + ",mUin=" + this.mUin);
    }
    if (!aqft.equalsWithNullCheck(paramString, this.mUin)) {}
    label193:
    do
    {
      return;
      if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
      {
        paramString = new ArrayList();
        int i = 0;
        while (i < parammobile_sub_get_photo_wall_rsp.vecUrls.size())
        {
          paramString.add(((PhotoWall)parammobile_sub_get_photo_wall_rsp.vecUrls.get(i)).photoUrls);
          i += 1;
        }
        List localList = e("", paramString);
        i = 0;
        parammobile_sub_get_photo_wall_rsp = null;
        paramString = null;
        for (;;)
        {
          paramBoolean = bool;
          if (i < 16)
          {
            if ((this.cE == null) || (this.cE.size() <= i)) {
              break label287;
            }
            paramString = (QzonePhotoView.b)this.cE.get(i);
            if ((localList == null) || (localList.size() <= i)) {
              break label292;
            }
          }
          for (parammobile_sub_get_photo_wall_rsp = (QzonePhotoView.b)localList.get(i);; parammobile_sub_get_photo_wall_rsp = null)
          {
            if (aqft.equalsWithNullCheck(paramString, parammobile_sub_get_photo_wall_rsp)) {
              break label297;
            }
            paramBoolean = true;
            if (QLog.isColorLevel()) {
              QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
            }
            if ((!paramBoolean) && ((paramString != null) || (parammobile_sub_get_photo_wall_rsp != null))) {
              break;
            }
            lO(localList);
            return;
            paramString = null;
            break label193;
          }
          i += 1;
        }
      }
    } while ((!aqiw.isWifiEnabled(BaseApplication.getContext())) || (this.dtf >= 3));
    label287:
    label292:
    label297:
    paramString = Message.obtain();
    paramString.what = 100;
    this.mHandler.sendMessage(paramString);
  }
  
  public void f(CoverCacheData paramCoverCacheData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updateCoverCacheData data = " + paramCoverCacheData);
    }
    if (paramCoverCacheData != null) {
      lO(e(paramCoverCacheData.type, paramCoverCacheData.EY));
    }
    if ((this.j != null) && (aqft.equalsWithNullCheck("PhotoWallCover", this.j.type)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "need get req cover info");
      }
      paramCoverCacheData = Message.obtain();
      paramCoverCacheData.what = 100;
      this.mHandler.sendMessage(paramCoverCacheData);
    }
  }
  
  public CoverCacheData getCoverCacheData()
  {
    return this.j;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
      }
      ((CardHandler)this.app.getBusinessHandler(2)).eD(this.mUin, "");
      this.mHandler.removeMessages(201);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (CardHandler)this.app.getBusinessHandler(2);
      if (paramMessage != null)
      {
        paramMessage.dq(this.mUin, 2);
        this.dtf += 1;
      }
      this.mHandler.removeMessages(100);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "handleMessage() MSG_UPDATE_PHOTO_VIEW");
      }
      if ((paramMessage.obj instanceof LinkedList)) {
        lO((List)paramMessage.obj);
      }
      this.mHandler.sendEmptyMessage(201);
    }
  }
  
  public void lO(List<QzonePhotoView.b> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "updatePhotoView photoInfo size=" + paramList.size());
    }
    this.cE = paramList;
    if (paramList != null) {}
    for (int i = paramList.size(); i > 0; i = 0)
    {
      this.e.setPadding(0, this.dtN, 0, this.dtO);
      this.e.setColumnWidth(this.Cl);
      this.e.setStretchMode(0);
      this.e.setHorizontalSpacing(this.aGL);
      a locala = new a(this.mActivity);
      locala.bF(paramList);
      i = paramList.size();
      paramList = new LinearLayout.LayoutParams((this.Cl + this.aGL) * i, this.dtM);
      this.e.setLayoutParams(paramList);
      this.e.setNumColumns(i);
      this.e.setAdapter(locala);
      this.hL.setVisibility(8);
      this.jo.setVisibility(8);
      this.e.setVisibility(0);
      setVisibility(0);
      return;
    }
    if (this.cwG)
    {
      alcs.a(this.hL, "src", this.jdField_a_of_type_Alcn.b, "simpleAddSrc");
      this.hL.setTag(new albb(25, null));
      this.hL.setOnClickListener(this.mOnClickListener);
      this.hL.setVisibility(0);
      this.jo.setVisibility(0);
      this.e.setVisibility(8);
      setVisibility(0);
      return;
    }
    this.hL.setVisibility(8);
    this.jo.setVisibility(8);
    setVisibility(8);
  }
  
  public class a
    extends BaseAdapter
  {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    List<QzonePhotoView.b> mList;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.mLayoutInflater = LayoutInflater.from(this.mContext);
    }
    
    public void bF(List<QzonePhotoView.b> paramList)
    {
      this.mList = paramList;
      int i = paramList.size();
      if (i < 16) {
        if (VipPhotoViewForSimple.a(VipPhotoViewForSimple.this)) {
          this.mList.add(new QzonePhotoView.b(paramList.size(), 101, null));
        }
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        paramList = (QzonePhotoView.b)this.mList.get(i - 1);
        paramList.type = 102;
        this.mList.set(i - 1, paramList);
      }
    }
    
    public int getCount()
    {
      if (this.mList != null) {
        return this.mList.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if (this.mList != null) {
        return this.mList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    @TargetApi(16)
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject = null;
      QzonePhotoView.b localb = (QzonePhotoView.b)this.mList.get(paramInt);
      a locala;
      View localView;
      if (paramView == null)
      {
        locala = new a();
        localView = this.mLayoutInflater.inflate(2131562230, null);
        localView.setLayoutParams(new AbsListView.LayoutParams(VipPhotoViewForSimple.this.Cl, VipPhotoViewForSimple.this.aGK));
        locala.e = ((URLImageView)localView.findViewById(2131375576));
        localView.setTag(locala);
        locala.e.setTag(new albb(25, Integer.valueOf(paramInt)));
        locala.e.setOnClickListener(VipPhotoViewForSimple.a(VipPhotoViewForSimple.this));
        paramView = (RelativeLayout.LayoutParams)locala.e.getLayoutParams();
        if (localb != null)
        {
          if ((localb.type != 100) && (localb.type != 102)) {
            break label345;
          }
          if (Build.VERSION.SDK_INT < 16) {
            break label308;
          }
          localView.setBackground(null);
          label179:
          locala.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
      }
      label406:
      for (;;)
      {
        try
        {
          paramView = localb.getOriginalUrl();
          if (paramView == null) {
            break label406;
          }
          paramView = new URL("qzone_cover", "original", paramView);
        }
        catch (Exception localException)
        {
          label308:
          paramView = localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.qzonecover.", 2, localException.toString());
          paramView = localObject;
          continue;
        }
        if (paramView != null) {
          locala.e.setImageDrawable(URLDrawable.getDrawable(paramView, VipPhotoViewForSimple.this.Cl, VipPhotoViewForSimple.this.aGK));
        }
        locala.e.setContentDescription(acfp.m(2131716790) + (paramInt + 1));
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
        break;
        localView.setBackgroundDrawable(null);
        break label179;
        label345:
        if (localException.type == 101)
        {
          locala.e.setScaleType(ImageView.ScaleType.CENTER);
          alcs.a(locala.e, "src", VipPhotoViewForSimple.a(VipPhotoViewForSimple.this).b, "simpleGridAddSrc");
          locala.e.setContentDescription(acfp.m(2131716791));
          continue;
          paramView = null;
        }
      }
    }
    
    class a
    {
      URLImageView e;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipPhotoViewForSimple
 * JD-Core Version:    0.7.0.1
 */
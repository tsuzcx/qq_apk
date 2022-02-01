package com.tencent.mobileqq.profile.view;

import alcn;
import alde;
import algg;
import algh;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import aqep;
import aqft;
import aqiw;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.widget.ProfileCardScrollImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class PhotoViewForShopping
  extends LinearLayout
  implements Handler.Callback
{
  public static float yw = 1.6F;
  public int Cl = -1;
  private alcn jdField_a_of_type_Alcn;
  ProfileShoppingView jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView;
  private Reference<Activity> jdField_a_of_type_JavaLangRefReference;
  public int aGK = -1;
  public int aGL = -1;
  public QQAppInterface app;
  public VipScaledViewPager b;
  public List<alde> cE;
  private boolean cwG;
  private int dsu;
  private int dtf;
  View mContentView;
  private float mDensity;
  private float mDensityScale = 1.0F;
  private Handler mHandler;
  public int mScreenHeight;
  public int mScreenWidth;
  private String mUin;
  List<alde> tR;
  private float yr;
  public float ys = 1.666667F;
  public float yt = 1.775F;
  public float yu = 2.0F;
  public float yv = 1.35F;
  
  public PhotoViewForShopping(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhotoViewForShopping(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private List<alde> bq(List<alde> paramList)
  {
    new ArrayList();
    if (this.tR == null) {
      this.tR = new ArrayList();
    }
    this.tR = paramList;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.ProfileShoppingView", 2, "updateCoverData photoInfo size=" + paramList.size());
    }
    return paramList;
  }
  
  @TargetApi(9)
  public void a(BaseActivity paramBaseActivity, alcn paramalcn, int paramInt, ProfileShoppingView paramProfileShoppingView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.ProfileShoppingView", 2, "initView");
    }
    this.app = paramBaseActivity.app;
    this.jdField_a_of_type_JavaLangRefReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_Alcn = paramalcn;
    this.mHandler = new Handler(this);
    this.mUin = paramalcn.e.uin;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView = paramProfileShoppingView;
    this.mContentView = LayoutInflater.from(this.app.getApplication()).inflate(2131562227, this, true);
    this.b = ((VipScaledViewPager)this.mContentView.findViewById(2131381929));
    paramBaseActivity = getResources().getDisplayMetrics();
    this.mScreenWidth = paramBaseActivity.widthPixels;
    this.mScreenHeight = paramBaseActivity.heightPixels;
    this.mDensity = paramBaseActivity.density;
    this.Cl = ((int)(this.mScreenWidth / this.yv));
    this.aGK = ((int)(this.Cl / yw));
    this.aGL = getResources().getDimensionPixelSize(2131298983);
    boolean bool;
    if (paramalcn.e.pa == 0)
    {
      bool = true;
      this.cwG = bool;
      this.mDensityScale = (this.mDensity / this.yu);
      if (this.mScreenHeight / this.mScreenWidth <= (this.ys + this.yt) / 2.0F) {
        break label374;
      }
      this.dsu = Math.round(this.mScreenHeight / (1136.0F * this.mDensityScale) * aqep.dpToPx(this.app.getApplication(), 15));
    }
    for (this.yr = 0.824503F;; this.yr = 0.8192771F)
    {
      paramBaseActivity = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      paramBaseActivity.height = paramInt;
      this.b.setLayoutParams(paramBaseActivity);
      this.b.setScale(this.yr);
      this.b.setGap(this.dsu);
      this.b.setParentView((ViewGroup)this.b.getParent());
      this.b.setOnPageChangeListener(new algg(this));
      ThreadManager.executeOnFileThread(new PhotoViewForShopping.2(this, paramalcn));
      return;
      bool = false;
      break;
      label374:
      this.dsu = Math.round(this.mScreenHeight / (800.0F * this.mDensityScale) * aqep.dpToPx(this.app.getApplication(), 15));
    }
  }
  
  public void g(boolean paramBoolean, String paramString, List<alde> paramList)
  {
    if (!aqft.equalsWithNullCheck(paramString, this.mUin)) {
      return;
    }
    List localList;
    int i;
    if ((paramBoolean) && (paramList != null))
    {
      localList = bq(paramList);
      i = 0;
      paramList = null;
      paramString = null;
      label34:
      if (i >= 16) {
        break label227;
      }
      if ((this.cE != null) && (this.cE.size() > i))
      {
        paramString = (alde)this.cE.get(i);
        label77:
        if ((localList == null) || (localList.size() <= i)) {
          break label176;
        }
        paramList = (alde)localList.get(i);
        label107:
        if (aqft.equalsWithNullCheck(paramString, paramList)) {
          break label181;
        }
      }
    }
    label176:
    label181:
    label227:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.ProfileShoppingView", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
      }
      if ((!paramBoolean) && ((paramString != null) || (paramList != null))) {
        break;
      }
      lO(localList);
      return;
      paramString = null;
      break label77;
      paramList = null;
      break label107;
      i += 1;
      break label34;
      if ((!aqiw.isWifiEnabled(BaseApplication.getContext())) || (this.dtf >= 3)) {
        break;
      }
      paramString = Message.obtain();
      paramString.what = 100;
      this.mHandler.sendMessage(paramString);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCard.ProfileShoppingView", 2, "handleMessage() MSG_REQ_ALBUM");
        }
        paramMessage = (CardHandler)this.app.getBusinessHandler(2);
        if (paramMessage != null)
        {
          paramMessage.dq(this.mUin, 2);
          this.dtf += 1;
        }
        this.mHandler.removeMessages(100);
        return false;
        paramMessage = (ProfileShoppingPhotoInfo)paramMessage.obj;
        new ArrayList();
      } while ((paramMessage == null) || (this.jdField_a_of_type_JavaLangRefReference.get() == null));
      String str = paramMessage.shopName;
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).bdV = paramMessage.accountFlag;
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).mFollowType = paramMessage.followType;
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).aNg = paramMessage.shopName;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView.fA(str, paramMessage.certifiedGrade);
      }
      paramMessage = paramMessage.getPhotoFromRawData();
    } while (paramMessage == null);
    if (this.tR == null) {
      this.tR = new ArrayList();
    }
    this.tR = paramMessage;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView != null) && (paramMessage.size() > 0) && ((this.jdField_a_of_type_JavaLangRefReference.get() instanceof FriendProfileCardActivity))) {
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).bOM();
    }
    if ((paramMessage.size() > 0) && (this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.e != null))
    {
      if (!this.jdField_a_of_type_Alcn.e.uin.equals(this.app.getCurrentAccountUin())) {
        break label366;
      }
      anot.a(this.app, "P_CliOper", "PhotoView", "", "Shop_Mtemplatewindow", "0X8005B95", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      lO(paramMessage);
      return false;
      label366:
      anot.a(this.app, "P_CliOper", "PhotoView", "", "Shop_Ftemplatewindow", "0X8005B99", 0, 0, "", "", "", "");
    }
  }
  
  public void lO(List<alde> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.i("ProfileCard.ProfileShoppingView", 2, "updatePhotoView photoInfo size=" + paramList.size());
    }
    this.cE = paramList;
    if ((this.app != null) && (this.b != null))
    {
      paramList = new StylePagerAdapter(this.app.getApplication());
      this.b.setAdapter(paramList);
    }
  }
  
  public class StylePagerAdapter
    extends PagerAdapter
  {
    public Context mContext;
    public LayoutInflater mInflater;
    View.OnClickListener mListener = new algh(this);
    
    public StylePagerAdapter(Context paramContext)
    {
      this.mContext = paramContext;
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileShoppingView", 2, "destroyItem, pos = " + paramInt);
      }
      paramObject = (View)paramObject;
      a locala = (a)paramObject.getTag();
      paramViewGroup.removeView(paramObject);
    }
    
    public int getCount()
    {
      return PhotoViewForShopping.this.cE.size();
    }
    
    @TargetApi(16)
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.ProfileShoppingView", 2, "instantiateItem, pos = " + paramInt);
      }
      View localView = this.mInflater.inflate(2131562234, paramViewGroup, false);
      a locala = new a();
      locala.a = ((ProfileCardScrollImageView)localView.findViewById(2131367838));
      localView.setTag(locala);
      locala.a.setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject = (RelativeLayout.LayoutParams)locala.a.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = PhotoViewForShopping.this.Cl;
      ((RelativeLayout.LayoutParams)localObject).height = PhotoViewForShopping.this.aGK;
      locala.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = ((alde)PhotoViewForShopping.this.cE.get(paramInt)).bVR;
      localView.setOnClickListener(this.mListener);
      localObject = this.mContext.getResources().getDrawable(2130848291);
      locala.a.setImageDrawable((Drawable)localObject);
      localView.setId(paramInt);
      paramViewGroup.addView(localView);
      locala.a.setIsScroll(false);
      paramViewGroup = URLDrawable.getDrawable(((alde)PhotoViewForShopping.this.cE.get(paramInt)).bvC, PhotoViewForShopping.this.Cl, PhotoViewForShopping.this.aGK);
      locala.a.setImageDrawable(paramViewGroup);
      locala.a.setTag(Integer.valueOf(paramInt));
      return localView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public class a
    {
      ProfileCardScrollImageView jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView;
      
      public a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.PhotoViewForShopping
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bkk;
import bkl;
import bkm;
import bko;
import bkp;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.ScrollLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MultiVideoMembersHolderUI
  extends RelativeLayout
{
  static final String jdField_a_of_type_JavaLangString = "MultiVideoMembersHolderUI";
  public static final int e = 3;
  public static final int f = 6;
  public static final int g = 3;
  public static final int h = 0;
  public static final int i = 1;
  public int a;
  long jdField_a_of_type_Long = 0L;
  public Resources a;
  public LayoutInflater a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bkl(this);
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new bkm(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public VideoController a;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  public MultiVideoMembersClickListener a;
  public ScrollLayout a;
  public WeakReference a;
  public ArrayList a;
  public int b = 1;
  int c;
  public int d = 6;
  
  public MultiVideoMembersHolderUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvWidgetScrollLayout = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    paramAttributeSet = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramAttributeSet != null) {
      this.jdField_a_of_type_AndroidContentResResources = paramAttributeSet.getResources();
    }
    c();
    this.jdField_a_of_type_ComTencentAvWidgetScrollLayout = new ScrollLayout(paramContext);
    this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.getLayoutParams();
    localLayoutParams.addRule(10);
    this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.setOnScrollListener(new bkk(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramContext.addRule(14);
    int j;
    if (this.jdField_c_of_type_Int == 1)
    {
      j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427656);
      paramContext.topMargin = j;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramContext);
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramAttributeSet.getAppRuntime());
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        break label355;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersHolderUI", 2, "mApp is null!");
      }
    }
    label355:
    do
    {
      do
      {
        return;
        j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427655);
        break;
        this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
          break label388;
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoMembersHolderUI", 2, "mVideoController is null!");
      return;
      this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      if (this.jdField_a_of_type_AndroidViewLayoutInflater != null) {
        break label427;
      }
    } while (!QLog.isColorLevel());
    label388:
    QLog.e("MultiVideoMembersHolderUI", 2, "mInFlater is null!");
    return;
    label427:
    addView(this.jdField_a_of_type_ComTencentAvWidgetScrollLayout);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  private GridView a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "initGridView");
    }
    int k = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    int m = UITools.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    int j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427657);
    if (m <= 320) {
      j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427658);
    }
    for (;;)
    {
      m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427643);
      k = (k - m * 3) / 4;
      GridView localGridView = new GridView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      localGridView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      localGridView.setColumnWidth(m);
      localGridView.setStretchMode(0);
      localGridView.setGravity(1);
      localGridView.setVerticalScrollBarEnabled(false);
      localGridView.setNumColumns(3);
      localGridView.setSelector(new ColorDrawable(0));
      localGridView.setCacheColorHint(0);
      localGridView.setHorizontalSpacing(k);
      localGridView.setVerticalSpacing(j);
      return localGridView;
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "refreshDataSource-->friend size=" + paramArrayList.size() + " mMembersList size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
    int j = 0;
    if (j < paramArrayList.size())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)paramArrayList.get(j);
      if (localGAudioFriends.jdField_a_of_type_Long == l) {}
      for (;;)
      {
        j += 1;
        break;
        bkp localbkp = new bkp(this);
        localbkp.jdField_a_of_type_Long = localGAudioFriends.jdField_a_of_type_Long;
        localbkp.c = localGAudioFriends.c;
        localbkp.b = localGAudioFriends.b;
        localbkp.jdField_a_of_type_Boolean = localGAudioFriends.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_JavaUtilArrayList.add(localbkp);
      }
    }
    d();
  }
  
  private void c()
  {
    int j = UITools.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    float f1 = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
    float f2 = f1 / 160.0F;
    float f3 = j;
    f3 = j * f3 / 1136.0F / f2;
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "initModeAndPageNum-->density=" + f1 + " scale=" + f2 + " height=" + f3);
    }
    if (f3 > 480.0F)
    {
      this.jdField_c_of_type_Int = 0;
      this.d = 6;
      return;
    }
    this.jdField_c_of_type_Int = 1;
    this.d = 3;
  }
  
  private void d()
  {
    c();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() % this.d == 0) {}
    for (this.b = (this.jdField_a_of_type_JavaUtilArrayList.size() / this.d);; this.b = (this.jdField_a_of_type_JavaUtilArrayList.size() / this.d + 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoMembersHolderUI", 2, "initPages-->mTotalPage=" + this.b);
      }
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.a();
    int j = this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.getChildCount();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "fireDateChange-->CurrentPage=" + this.jdField_a_of_type_Int + " PageNum=" + j + " TotalPageNum=" + this.b);
    }
    Object localObject;
    if (j != this.b)
    {
      this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.removeAllViews();
      j = 0;
      while (j < this.b)
      {
        localObject = new bko(this, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), j);
        GridView localGridView = a();
        localGridView.setAdapter((ListAdapter)localObject);
        if (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener != null) {
          localGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
        }
        if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
          localGridView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        }
        this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.addView(localGridView);
        j += 1;
      }
      this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.a(this.jdField_a_of_type_Int);
      a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      f();
      return;
      j = 0;
      while (j < this.b)
      {
        localObject = (GridView)this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.getChildAt(j);
        ((bko)((GridView)localObject).getAdapter()).notifyDataSetChanged();
        ((GridView)localObject).invalidate();
        j += 1;
      }
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "adaptPaperSize");
    }
    int m = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    int n = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427643);
    int i1 = (m - n * 3) / 4;
    int k = (m - n * 3 - i1 * 2) / 2;
    int j;
    if (this.jdField_c_of_type_Int == 0)
    {
      j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427649);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 3) {
        break label163;
      }
      k = this.jdField_a_of_type_JavaUtilArrayList.size();
      m = (m - n * k - (k - 1) * i1) / 2;
      k = j;
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
      localLayoutParams.topMargin = k;
      setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.setPagePos(m);
      return;
      j = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427650);
      break;
      label163:
      m = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427650);
      j = k;
      k = m;
      m = j;
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Bitmap a()
  {
    return ((BitmapDrawable)this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838008)).getBitmap();
  }
  
  public Bitmap a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, paramString, String.valueOf(this.jdField_a_of_type_Long), true, false);
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, paramString, String.valueOf(this.jdField_a_of_type_Long));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "cancelSelectedItem-->remoteUin=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long + " VideoSourceType=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.getChildCount() > 0) {
      ((bko)((GridView)this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.getChildAt(this.jdField_a_of_type_Int)).getAdapter()).notifyDataSetChanged();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MultiVideoMembersHolderUI", 2, "cancelSelectedItem-->mScrollLayout has no child");
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiVideoMembersHolderUI", 2, "setIndicatorSelected-->index = " + paramInt);
    }
    if (this.b <= 1)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      }
      return;
    }
    int k = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427659);
    int m = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    if (m < this.b)
    {
      int n = this.b;
      j = 0;
      while (j < n - m)
      {
        ImageView localImageView = new ImageView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        localImageView.setPadding(k, k, k, k);
        localImageView.setImageResource(2130838266);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView, m + j);
        j += 1;
      }
    }
    if (m > this.b) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(0, m - this.b);
    }
    int j = 0;
    label183:
    if (j < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      if (j != paramInt) {
        break label218;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setSelected(false);
    }
    for (;;)
    {
      j += 1;
      break label183;
      break;
      label218:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setSelected(true);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "onMemberSpeak-->uin=" + paramLong + ",isSpeak" + paramBoolean);
    }
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (((bkp)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Long != paramLong) {}
    }
    for (;;)
    {
      if (j == -1) {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoMembersHolderUI", 2, "onMemberSpeak--> can not find the uin.UIN=" + paramLong + ",isSpeak" + paramBoolean);
        }
      }
      bkp localbkp;
      do
      {
        return;
        j += 1;
        break;
        localbkp = (bkp)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if ((this.jdField_a_of_type_Int * this.d > j) || ((this.jdField_a_of_type_Int + 1) * this.d <= j)) {
          break label337;
        }
        if (localbkp.jdField_a_of_type_Boolean != paramBoolean) {
          break label231;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MultiVideoMembersHolderUI", 2, "onMemberSpeak-->is the same type-->uin=" + paramLong + ",isSpeak" + paramBoolean);
      return;
      label231:
      Object localObject = (GridView)this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.getChildAt(this.jdField_a_of_type_Int);
      j %= this.d;
      ImageView localImageView;
      MultiVideoMembersHolderUI.Holder localHolder;
      if (((GridView)localObject).getChildCount() > j)
      {
        localObject = ((GridView)localObject).getChildAt(j);
        localImageView = (ImageView)((View)localObject).findViewById(2131232244);
        localHolder = (MultiVideoMembersHolderUI.Holder)((View)localObject).getTag();
        if (paramBoolean)
        {
          localImageView.setVisibility(0);
          if (localHolder.b == 0)
          {
            localHolder.b = 5;
            ((View)localObject).setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131560179));
          }
        }
      }
      for (;;)
      {
        label337:
        localbkp.jdField_a_of_type_Boolean = paramBoolean;
        return;
        localImageView.setVisibility(8);
        if (localHolder.b == 5)
        {
          ((View)localObject).setContentDescription(null);
          localHolder.b = 0;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("MultiVideoMembersHolderUI", 2, "onMemberSpeak-->WRONG INDEX AND UIN. UIN=" + paramLong);
          }
        }
      }
      j = -1;
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "notifyAdapterChange,Type=" + paramInt);
    }
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersHolderUI", 2, "notifyAdapterChange-->friends is null");
      }
      return;
    }
    a(paramArrayList);
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "notifyDataSetChanged-->refreshAll=" + paramBoolean);
    }
    if (!paramBoolean)
    {
      GridView localGridView = (GridView)this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.getChildAt(this.jdField_a_of_type_Int);
      ((bko)localGridView.getAdapter()).notifyDataSetChanged();
      localGridView.invalidate();
      return;
    }
    e();
  }
  
  public boolean a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "initMVMLayout-->groupUin=" + paramLong);
    }
    this.jdField_a_of_type_Long = paramLong;
    return true;
  }
  
  public boolean a(bkp parambkp, int paramInt)
  {
    paramInt = 2;
    if (parambkp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersHolderUI", 2, "setSelectedItem-->Item is null");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "setSelectedItem-->uin=" + parambkp.jdField_a_of_type_Long + " isSpeak=" + parambkp.jdField_a_of_type_Boolean + " isShare=" + parambkp.c + " isVideo=" + parambkp.b + " remoteUin=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long + " remoteVideoSrc=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int);
    }
    if (parambkp.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long)
    {
      if ((!parambkp.b) || (!parambkp.c)) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int == 1) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int = paramInt;
        return true;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int != 2) {
          break;
        }
        paramInt = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersHolderUI", 2, "WRONG TYPE OF VIDEOSRC");
      }
      return false;
    }
    if (parambkp.c) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long = parambkp.jdField_a_of_type_Long;
      return true;
      if (!parambkp.b) {
        break;
      }
      paramInt = 1;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.a();
    int k = this.jdField_a_of_type_Int * this.d;
    int m = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), (this.jdField_a_of_type_Int + 1) * this.d);
    int j = k;
    if (j < m) {
      if (((bkp)this.jdField_a_of_type_JavaUtilArrayList.get(j)).d) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoMembersHolderUI", 2, "refreshHeadbitmap,mCurrentPage=" + this.jdField_a_of_type_Int + " minIndex=" + k + " maxIndex=" + m + " needFresh=" + bool);
      }
      if (bool)
      {
        GridView localGridView = (GridView)this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.getChildAt(this.jdField_a_of_type_Int);
        ((bko)localGridView.getAdapter()).notifyDataSetChanged();
        localGridView.invalidate();
      }
      return;
      j += 1;
      break;
    }
  }
  
  public void setOnMemberClickListener(MultiVideoMembersClickListener paramMultiVideoMembersClickListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "setOnMemberClickListener");
    }
    if (paramMultiVideoMembersClickListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersHolderUI", 2, "setOnMemberClickListener-->listener is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = paramMultiVideoMembersClickListener;
  }
  
  public void setSelectedItem(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "setSelectedItem-->uin=" + paramLong);
    }
    int j = 0;
    for (;;)
    {
      if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((bkp)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Long == paramLong)
        {
          a((bkp)this.jdField_a_of_type_JavaUtilArrayList.get(j), j);
          ((bko)((GridView)this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.getChildAt(this.jdField_a_of_type_Int)).getAdapter()).notifyDataSetChanged();
        }
      }
      else {
        return;
      }
      j += 1;
    }
  }
  
  public void setSelectedItem(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersHolderUI", 2, "uin=" + paramLong + " type=" + paramInt);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int = paramInt;
    ((bko)((GridView)this.jdField_a_of_type_ComTencentAvWidgetScrollLayout.getChildAt(this.jdField_a_of_type_Int)).getAdapter()).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoMembersHolderUI
 * JD-Core Version:    0.7.0.1
 */
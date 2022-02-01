import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCommonUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout.a;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.3;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.QueryPhotoTask.1;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
import dov.com.qq.im.ae.view.AECompoundButton;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class awur
  extends ReportFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, awuo.b, AEAlbumPreviewMaskLayout.a
{
  public RecyclerView E;
  public ImageView HR;
  View LV;
  View LW;
  public GridLayoutManager a;
  public awur.a a;
  public awva a;
  public AEAlbumPreviewMaskLayout a;
  public AECropperView a;
  public TextView agP;
  FrameLayout albumListContainer;
  public awuo b;
  public AEAlbumLinearLayout b;
  public final boolean baw = axiz.aOK();
  public AECompoundButton c;
  int mEdgePadding;
  public int mImageHeight;
  public int mImageWidth;
  PhotoListBaseData mPhotoListData;
  public int mTitleBarHeight;
  public LinearLayout mq;
  Dialog pd;
  SharedPreferences pref;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> queryPhotoTask;
  LinearLayout titleLayout;
  TextView titleText;
  
  public static void rotate180Degrees(View paramView, boolean paramBoolean)
  {
    float f2 = 180.0F;
    if (paramBoolean) {}
    for (float f1 = 180.0F;; f1 = 0.0F)
    {
      if (paramBoolean) {
        f2 = 360.0F;
      }
      RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(300L);
      localRotateAnimation.setFillAfter(true);
      paramView.startAnimation(localRotateAnimation);
      return;
    }
  }
  
  public abstract awuo a();
  
  protected abstract awva a();
  
  public void aE(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_Awur$a.getItemViewType(paramInt);
    if (this.jdField_a_of_type_Awva.a != null) {}
    switch (i)
    {
    default: 
      return;
    case 0: 
      if (this.mPhotoListData.isSingleMode)
      {
        this.jdField_a_of_type_Awva.a.aF(paramView, paramInt);
        return;
      }
      paramView = this.jdField_a_of_type_Awva.a.a(paramView, paramInt);
      this.jdField_a_of_type_Awva.startPhotoPreviewActivity(paramView);
      QAlbumUtil.anim(getActivity(), true, true);
      return;
    case 1: 
      this.jdField_a_of_type_Awva.a.aG(paramView, paramInt);
      return;
    }
    this.jdField_a_of_type_Awva.a.aH(paramView, paramInt);
  }
  
  public void cancleProgressDailog()
  {
    if (this.pd != null) {}
    try
    {
      this.pd.cancel();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PhotoListActivity", 2, "cancel dialog error", localIllegalArgumentException);
    }
  }
  
  @TargetApi(8)
  File createImageFile()
    throws IOException
  {
    Object localObject = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String str = "JPEG_" + (String)localObject + "_";
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT > 7)
      {
        localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        bool = true;
      }
      while (bool)
      {
        localObject = File.createTempFile(str, ".jpg", (File)localObject);
        this.mPhotoListData.currentPhotoPath = ((File)localObject).getAbsolutePath();
        return localObject;
        File localFile = new File(Environment.getExternalStorageDirectory(), "DCIM");
        localObject = localFile;
        if (!localFile.exists())
        {
          bool = localFile.mkdirs();
          localObject = localFile;
        }
      }
    }
    return null;
  }
  
  public void eGv()
  {
    this.jdField_a_of_type_Awva.eGv();
  }
  
  public void eGx()
  {
    transAlbumList(false);
  }
  
  public void excuteQueryPhotoTask()
  {
    this.queryPhotoTask = new awur.d();
    this.queryPhotoTask.execute(new Object[0]);
  }
  
  protected Dialog getDialog()
  {
    return new ReportDialog(getActivity());
  }
  
  public abstract Class getJumpActivity();
  
  protected void initUI(View paramView)
  {
    this.albumListContainer = ((FrameLayout)paramView.findViewById(2131362594));
    this.LV = paramView.findViewById(2131369579);
    this.agP = ((TextView)paramView.findViewById(2131369612));
    this.LV.setVisibility(0);
    this.LV.setOnClickListener(this);
    this.agP.setVisibility(0);
    this.agP.setOnClickListener(this);
    this.titleText = ((TextView)paramView.findViewById(2131369627));
    String str;
    if (this.jdField_a_of_type_Awva.mPhotoCommonData.albumName != null) {
      str = this.jdField_a_of_type_Awva.mPhotoCommonData.albumName;
    }
    for (;;)
    {
      setTitle(str);
      this.LW = paramView.findViewById(2131369624);
      this.titleLayout = ((LinearLayout)paramView.findViewById(2131369572));
      this.titleLayout.setOnClickListener(this);
      this.jdField_b_of_type_DovComQqImAeAlbumAEAlbumLinearLayout = ((AEAlbumLinearLayout)paramView.findViewById(2131362329));
      this.jdField_b_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.setScrollListener(new awut(this));
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView = ((AECropperView)paramView.findViewById(2131362330));
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMaxZoom(5.0F);
      this.c = ((AECompoundButton)paramView.findViewById(2131367186));
      this.c.setOnClickListener(this);
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout = ((AEAlbumPreviewMaskLayout)paramView.findViewById(2131367188));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setOnTouchCallback(this);
      this.mq = ((LinearLayout)paramView.findViewById(2131370703));
      this.HR = ((ImageView)paramView.findViewById(2131369825));
      this.E = ((RecyclerView)paramView.findViewById(2131373140));
      ((DefaultItemAnimator)this.E.getItemAnimator()).setSupportsChangeAnimations(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getActivity(), 3);
      this.E.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      this.jdField_a_of_type_Awur$a = new awur.a();
      this.E.setAdapter(this.jdField_a_of_type_Awur$a);
      this.jdField_a_of_type_Awva.postInitUI();
      return;
      if (this.mPhotoListData.showMediaType == 2) {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
    }
  }
  
  public boolean isGif(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public void onAlbumListChoose(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Awva.mPhotoCommonData.albumName == null) {
        break label62;
      }
    }
    label62:
    for (paramQQAlbumInfo = this.jdField_a_of_type_Awva.mPhotoCommonData.albumName;; paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      setTitle(paramQQAlbumInfo);
      this.mPhotoListData.firstResume = true;
      getActivity().runOnUiThread(new AEAbstractPhotoListFragment.3(this));
      transAlbumList(false);
      return;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131375366) {
      this.jdField_a_of_type_Awva.onQualityBtnClick(paramCompoundButton, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Awva == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = paramView.getId();
      if (i == 2131369579)
      {
        this.jdField_a_of_type_Awva.onTitleBtnCancelClick(paramView);
      }
      else if (i == 2131373570)
      {
        this.jdField_a_of_type_Awva.onPreviewBtnClick(paramView);
      }
      else if (i == 2131377990)
      {
        this.jdField_a_of_type_Awva.onSendBtnClick(paramView);
      }
      else
      {
        if (i == 2131369572)
        {
          if ((this.jdField_b_of_type_Awuo == null) || (!this.jdField_b_of_type_Awuo.isAdded())) {}
          for (boolean bool = true;; bool = false)
          {
            if (bool) {
              this.jdField_a_of_type_Awva.enterAlbumListFragment(getActivity().getIntent());
            }
            transAlbumList(bool);
            break;
          }
        }
        if (i == 2131369612)
        {
          this.jdField_a_of_type_Awva.jl(paramView);
          if ((this.jdField_a_of_type_Awva.mPhotoCommonData != null) && (this.jdField_a_of_type_Awva.mPhotoCommonData.selectedPhotoList != null))
          {
            axip.a().a().aCe = axip.as.longValue();
            axip.a().a().cUU = axip.a().HP();
            axim.a().adV(this.jdField_a_of_type_Awva.mPhotoCommonData.selectedPhotoList.size());
          }
        }
        else if (i == 2131367186)
        {
          axxe.a(this.c.H(), 200L, null);
          this.jdField_a_of_type_Awva.jk(paramView);
        }
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    this.jdField_a_of_type_Awva = a();
    this.mPhotoListData = this.jdField_a_of_type_Awva.mPhotoListData;
    this.pref = BaseApplication.getContext().getSharedPreferences("share", 4);
    paramBundle = getResources();
    int i = paramBundle.getDisplayMetrics().widthPixels;
    this.mEdgePadding = paramBundle.getDimensionPixelSize(2131296840);
    this.mImageWidth = ((i - this.mEdgePadding * 2) / 3);
    this.mImageHeight = this.mImageWidth;
    paramBundle = getActivity().getIntent();
    this.jdField_a_of_type_Awva.initData(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onCreate(),extra is:" + paramBundle.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity,hashCode is:" + System.identityHashCode(this));
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558555, paramViewGroup, false);
    ViewCompat.setOnApplyWindowInsetsListener(paramLayoutInflater, new awus(this));
    ViewCompat.requestApplyInsets(paramLayoutInflater);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Awva.doOnDestroy();
    if (this.jdField_b_of_type_DovComQqImAeAlbumAEAlbumLinearLayout != null) {
      this.jdField_b_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.setScrollListener(null);
    }
    if (this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setOnTouchCallback(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.queryPhotoTask = null;
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Awva.doOnResume();
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    initUI(paramView);
  }
  
  public void recordLastPos(String paramString)
  {
    if (this.mPhotoListData.isRecodeLastAlbumPath)
    {
      QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_Awva.mPhotoCommonData.albumId, Integer.valueOf(this.jdField_a_of_type_Awur$a.getItemCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        QAlbumUtil.sLastAlbumPath = paramString;
        HashMap localHashMap = QAlbumUtil.sSelectItemAlbum;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          QAlbumUtil.sLastAlbumId = (String)paramString.first;
          QAlbumUtil.sLastAlbumName = (String)paramString.second;
          QAlbumUtil.putLastAlbumInfo(getActivity(), QAlbumUtil.sLastAlbumId, QAlbumUtil.sLastAlbumName);
        }
      }
    }
    QAlbumUtil.clearSelectItemInfo();
  }
  
  public void selectLimitRemind(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Awva.mPhotoCommonData.selectedPhotoList.size();
    int j;
    if (((i == this.jdField_a_of_type_Awva.mPhotoCommonData.maxSelectNum) && (!paramBoolean)) || ((i == this.jdField_a_of_type_Awva.mPhotoCommonData.maxSelectNum - 1) && (paramBoolean)))
    {
      i = 1;
      if (i == 0) {
        return;
      }
      j = ((GridLayoutManager)this.E.getLayoutManager()).findFirstVisibleItemPosition();
      int k = ((GridLayoutManager)this.E.getLayoutManager()).findLastVisibleItemPosition();
      i = j;
      label89:
      if (i > k) {
        return;
      }
      if (this.jdField_a_of_type_Awur$a.getItemViewType(i) != 2) {
        break label119;
      }
    }
    for (;;)
    {
      i += 1;
      break label89;
      i = 0;
      break;
      label119:
      Object localObject = this.E.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Awur$a.getItem(i);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      else if (localLocalMediaInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
        }
      }
      else
      {
        localObject = (awur.c)this.E.getChildViewHolder((View)localObject);
        if ((paramBoolean) || (localLocalMediaInfo.selectStatus == 1)) {
          ((awur.c)localObject).mImageView.setAlpha(1.0F);
        } else {
          ((awur.c)localObject).mImageView.setAlpha(0.3F);
        }
      }
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    getActivity().setTitle(paramCharSequence);
    this.titleText.setText(paramCharSequence);
  }
  
  public void showProgressDialog()
  {
    try
    {
      if (this.pd != null) {
        cancleProgressDailog();
      }
      while (!this.pd.isShowing())
      {
        this.pd.show();
        return;
        this.pd = getDialog();
        this.pd.setCancelable(true);
        this.pd.show();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListActivity", 2, "show dialog error", localException);
      }
      this.pd = null;
    }
  }
  
  public void transAlbumList(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction;
    ObjectAnimator localObjectAnimator;
    if (this.jdField_b_of_type_Awuo == null)
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_Awuo = a();
        this.jdField_b_of_type_Awuo.a(this);
      }
    }
    else
    {
      localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.setTransition(4097);
      if ((!paramBoolean) || (this.jdField_b_of_type_Awuo.isAdded())) {
        break label166;
      }
      localObjectAnimator = ObjectAnimator.ofInt(this.albumListContainer, "backgroundColor", new int[] { getResources().getColor(2131165626), getResources().getColor(2131165637) });
      rotate180Degrees(this.LW, false);
      localFragmentTransaction.add(2131362594, this.jdField_b_of_type_Awuo, null);
    }
    for (;;)
    {
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.commit();
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.setRepeatMode(2);
      localObjectAnimator.start();
      this.jdField_a_of_type_Awva.onAlbumListShown(paramBoolean);
      return;
      label166:
      localObjectAnimator = ObjectAnimator.ofInt(this.albumListContainer, "backgroundColor", new int[] { getResources().getColor(2131165637), getResources().getColor(2131165626) });
      rotate180Degrees(this.LW, true);
      localFragmentTransaction.remove(this.jdField_b_of_type_Awuo);
    }
  }
  
  public void updateCheckbox(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Awva.mPhotoCommonData.selectedPhotoList;
    int j = ((GridLayoutManager)this.E.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.E.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      label392:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = this.E.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Awur$a.getItem(i);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m;
          awur.c localc;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(localLocalMediaInfo.path);
            if (m >= 0)
            {
              localc = (awur.c)this.E.getChildViewHolder((View)localObject);
              if ((localc != null) && (localc.mCheckBox != null)) {
                localc.mCheckBox.setCheckedNumber(m + 1);
              }
            }
          }
          else
          {
            m = QAlbumUtil.getMediaType(localLocalMediaInfo);
            if ((m == 0) || (m == 1))
            {
              localc = (awur.c)this.E.getChildViewHolder((View)localObject);
              int n = localLocalMediaInfo.selectStatus;
              if (n == 1)
              {
                localc.mCheckBox.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1);
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.enableTalkBack) {
                  break label392;
                }
                localObject = QAlbumUtil.createContentDescriptionWithCheckBox(m, localLocalMediaInfo, i, localc.mCheckBox.isChecked());
                localc.mCheckBox.setContentDescription((CharSequence)localObject);
                break;
                if (n == 3)
                {
                  localc.mCheckBox.setChecked(false);
                }
                else
                {
                  localc.mCheckBox.setChecked(false);
                  if (((View)localObject).getBackground() != null) {
                    ((View)localObject).setBackgroundDrawable(null);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void updateCheckboxForDelete()
  {
    int j = ((GridLayoutManager)this.E.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.E.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      Object localObject = this.E.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Awur$a.getItem(i);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m = this.jdField_a_of_type_Awva.mPhotoCommonData.selectedPhotoList.indexOf(localLocalMediaInfo.path);
          if (m >= 0)
          {
            localObject = (awur.c)this.E.getChildViewHolder((View)localObject);
            if ((localObject != null) && (((awur.c)localObject).mCheckBox != null)) {
              ((awur.c)localObject).mCheckBox.setCheckedNumber(m + 1);
            }
          }
        }
      }
    }
  }
  
  public class a
    extends RecyclerView.Adapter<awur.c>
    implements URLDrawableDownListener
  {
    public ColorDrawable colorDrawable = new ColorDrawable(570425344);
    public ArrayList<LocalMediaInfo> mAllImages = new ArrayList();
    public Drawable mDefaultPhotoDrawable;
    public LayoutInflater mInflater = awur.this.getActivity().getLayoutInflater();
    
    public a() {}
    
    public awur.c a(ViewGroup paramViewGroup, int paramInt)
    {
      switch (paramInt)
      {
      }
      do
      {
        do
        {
          do
          {
            return null;
          } while (awur.this.a.a == null);
          return new awur.c(awur.this, awur.this.a.a.cG());
        } while (awur.this.a.a == null);
        return new awur.c(awur.this, awur.this.a.a.cH());
      } while (awur.this.a.a == null);
      return new awur.c(awur.this, awur.this.a.a.cI());
    }
    
    public void a(awur.c paramc, int paramInt)
    {
      awur.b localb = new awur.b(awur.this);
      switch (getItemViewType(paramInt))
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramc, paramInt, getItemId(paramInt));
        return;
        if (awur.this.a.a != null)
        {
          awur.this.a.a.a(paramInt, paramc, localb);
          continue;
          if (awur.this.a.a != null)
          {
            awur.this.a.a.b(paramInt, paramc, localb);
            continue;
            if (awur.this.a.a != null) {
              awur.this.a.a.c(paramInt, paramc, localb);
            }
          }
        }
      }
    }
    
    public LocalMediaInfo getItem(int paramInt)
    {
      return (LocalMediaInfo)this.mAllImages.get(paramInt);
    }
    
    public int getItemCount()
    {
      return this.mAllImages.size();
    }
    
    public int getItemViewType(int paramInt)
    {
      return QAlbumUtil.getMediaType((LocalMediaInfo)this.mAllImages.get(paramInt));
    }
    
    public List<LocalMediaInfo> getPhotoList()
    {
      return this.mAllImages;
    }
    
    public TextView newImageTypeView()
    {
      TextView localTextView = new TextView(awur.this.getActivity());
      localTextView.setGravity(17);
      localTextView.setTextSize(10.0F);
      localTextView.setTextColor(-1);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      localGradientDrawable.setSize(QAlbumCommonUtil.dp2px(30.0F, awur.this.getResources()), QAlbumCommonUtil.dp2px(18.0F, awur.this.getResources()));
      localGradientDrawable.setCornerRadii(new float[] { QAlbumCommonUtil.dp2px(2.0F, awur.this.getResources()), QAlbumCommonUtil.dp2px(2.0F, awur.this.getResources()), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      localGradientDrawable.setColor(1291845632);
      localTextView.setBackgroundDrawable(localGradientDrawable);
      return localTextView;
    }
    
    public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
    
    public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
    
    public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
    
    public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
    {
      new Rect();
      paramView = (LocalMediaInfo)paramURLDrawable.getTag();
      int i = paramView.listViewPosition;
      if ((i == -1) || (paramView.visableTime == 0L)) {}
      long l1;
      long l2;
      do
      {
        return;
        l1 = SystemClock.uptimeMillis();
        l2 = paramView.visableTime;
      } while (!QLog.isColorLevel());
      QLog.d("PhotoListActivity", 2, "onLoadSuccessed,no next ,listViewPositon:" + i + " costTime:" + (l1 - l2) + " imageInfo;" + paramView);
    }
    
    public void setPhotoList(List<LocalMediaInfo> paramList)
    {
      this.mAllImages.clear();
      if ((paramList == null) || (paramList.size() == 0)) {
        return;
      }
      if ((!awur.this.mPhotoListData.isShowCamera) && (QAlbumUtil.getMediaType((LocalMediaInfo)paramList.get(0)) == 2)) {
        paramList.remove(0);
      }
      this.mAllImages.addAll(paramList);
      awur.this.a.bu(this.mAllImages);
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    CheckBox mCheckBox;
    int mPosition;
    
    public b() {}
    
    public void onClick(View paramView)
    {
      if (awur.this.a.a != null) {
        awur.this.a.a.onCheckBoxClick(paramView, this.mPosition, this.mCheckBox);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public void setCheckBox(CheckBox paramCheckBox)
    {
      this.mCheckBox = paramCheckBox;
    }
    
    public void setPosition(int paramInt)
    {
      this.mPosition = paramInt;
    }
  }
  
  public class c
    extends RecyclerView.ViewHolder
  {
    public awur.b a;
    public NumberCheckBox mCheckBox;
    public URLDrawable mDrawable;
    public TextView mImageType;
    public ImageView mImageView;
    public ImageView mImageViewPanoramaIcon;
    public ImageView mMaskView;
    public ImageView mPhotoFlagView;
    public View mSelectedBtn;
    public ImageView mSelectedIconView;
    public TextView mTextView;
    
    public c(View paramView)
    {
      super();
      this.mImageView = ((ImageView)paramView.findViewById(2131373182));
      this.mImageViewPanoramaIcon = ((ImageView)paramView.findViewById(2131373143));
      this.mMaskView = ((ImageView)paramView.findViewById(2131369477));
      this.mSelectedIconView = ((ImageView)paramView.findViewById(2131373187));
      this.mSelectedBtn = paramView.findViewById(2131373184);
      this.mCheckBox = ((NumberCheckBox)paramView.findViewById(2131373185));
      this.mTextView = ((TextView)paramView.findViewById(2131373188));
      this.mPhotoFlagView = ((ImageView)paramView.findViewById(2131373113));
      if (this.mPhotoFlagView != null) {
        this.mPhotoFlagView.setVisibility(8);
      }
    }
  }
  
  public class d
    extends AsyncTask<Object, Object, List<LocalMediaInfo>>
  {
    public d() {}
    
    protected List<LocalMediaInfo> doInBackground(Object... paramVarArgs)
    {
      PhotoCommonBaseData localPhotoCommonBaseData = awur.this.a.mPhotoCommonData;
      if (localPhotoCommonBaseData.selectedPhotoList == null) {
        localPhotoCommonBaseData.selectedPhotoList = new ArrayList();
      }
      Object localObject2 = localPhotoCommonBaseData.selectedPhotoList;
      if (localPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
        localPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
      }
      Object localObject1 = localPhotoCommonBaseData.selectedMediaInfoHashMap;
      aqip.beginPile();
      paramVarArgs = awur.this.a.getLocalMediaInfos();
      if (paramVarArgs == null) {
        paramVarArgs = new ArrayList();
      }
      for (;;)
      {
        awur.this.mPhotoListData.videoSelectedCnt = 0;
        awur.this.mPhotoListData.gifSelectedCount = 0;
        long l1 = System.currentTimeMillis();
        long l2 = QAlbumUtil.sLastAlbumRecordTime;
        if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(localPhotoCommonBaseData.albumId)) {}
        label1055:
        for (int j = ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(localPhotoCommonBaseData.albumId)).intValue();; j = 0)
        {
          Object localObject3;
          Object localObject4;
          if ((awur.this.mPhotoListData.isShowCamera) && (localPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
          {
            localObject3 = paramVarArgs.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
              if ((localObject4 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).path)))
              {
                PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject4).path);
                ((HashMap)localObject1).remove(((LocalMediaInfo)localObject4).path);
              }
            }
            paramVarArgs.addAll(0, PhotoListBaseData.newCaptureMediaInfo.values());
          }
          int i;
          if ((awur.this.mPhotoListData.showCameraInVideo) && (localPhotoCommonBaseData.albumId.equals("$VideoAlbumId")))
          {
            localObject3 = paramVarArgs.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
              if ((localObject4 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).path)))
              {
                PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject4).path);
                ((HashMap)localObject1).remove(((LocalMediaInfo)localObject4).path);
              }
            }
            localObject3 = PhotoListBaseData.newCaptureMediaInfo.values().iterator();
            i = 0;
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
              if ((localObject4 == null) || (!"video/mp4".equals(((LocalMediaInfo)localObject4).mMimeType))) {
                break label1121;
              }
              paramVarArgs.add(i, localObject4);
              i += 1;
            }
          }
          label938:
          label1074:
          label1121:
          for (;;)
          {
            break;
            awur.this.a.processQueryResult(paramVarArgs);
            int k = paramVarArgs.size();
            localObject3 = new ArrayList(k);
            i = 0;
            if (i < paramVarArgs.size())
            {
              localObject4 = (LocalMediaInfo)paramVarArgs.get(i);
              if (((LocalMediaInfo)localObject4).path == null) {}
              for (;;)
              {
                i += 1;
                break;
                int m = QAlbumUtil.getMediaType((LocalMediaInfo)localObject4);
                ((LocalMediaInfo)localObject4).position = Integer.valueOf(((ArrayList)localObject3).size());
                ((ArrayList)localObject3).add(((LocalMediaInfo)localObject4).path);
                if (((ArrayList)localObject2).contains(((LocalMediaInfo)localObject4).path))
                {
                  ((LocalMediaInfo)localObject4).selectStatus = 1;
                  if (!localPhotoCommonBaseData.selectedIndex.contains(((LocalMediaInfo)localObject4).position)) {
                    localPhotoCommonBaseData.selectedIndex.add(((LocalMediaInfo)localObject4).position);
                  }
                  if ((awur.this.mPhotoListData.isSupportVideoCheckbox) && (m == 1))
                  {
                    PhotoListBaseData localPhotoListBaseData = awur.this.mPhotoListData;
                    localPhotoListBaseData.videoSelectedCnt += 1;
                    if (awur.this.mPhotoListData.videoSelectedCnt == 1) {
                      awur.this.mPhotoListData.selectedVideoInfo = ((LocalMediaInfo)localObject4);
                    }
                  }
                  if ((awur.this.mPhotoListData.isShowCamera) && (!((HashMap)localObject1).containsKey(((LocalMediaInfo)localObject4).path))) {
                    ((HashMap)localObject1).put(((LocalMediaInfo)localObject4).path, localObject4);
                  }
                  if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject4).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject4).mMimeType)))
                  {
                    localObject4 = awur.this.mPhotoListData;
                    ((PhotoListBaseData)localObject4).gifSelectedCount += 1;
                  }
                }
                else if ((((ArrayList)localObject2).size() < localPhotoCommonBaseData.maxSelectNum) && (((LocalMediaInfo)localObject4).path.equals(awur.this.mPhotoListData.currentPhotoPath)))
                {
                  ((LocalMediaInfo)localObject4).selectStatus = 1;
                  ((ArrayList)localObject2).add(((LocalMediaInfo)localObject4).path);
                  localPhotoCommonBaseData.selectedIndex.add(((LocalMediaInfo)localObject4).position);
                  if (localPhotoCommonBaseData.needMediaInfo) {
                    ((HashMap)localObject1).put(((LocalMediaInfo)localObject4).path, localObject4);
                  }
                }
                else if ((awur.this.mPhotoListData.isRecodeLastAlbumPath) && (l1 - l2 <= 60000L) && (j == paramVarArgs.size()) && (((LocalMediaInfo)localObject4).path.equals(QAlbumUtil.sLastAlbumPath)))
                {
                  ((LocalMediaInfo)localObject4).selectStatus = 3;
                }
                else
                {
                  ((LocalMediaInfo)localObject4).selectStatus = 2;
                }
              }
            }
            if (awur.this.a.needVedio())
            {
              if (localPhotoCommonBaseData.allMediaInfoHashMap == null)
              {
                localPhotoCommonBaseData.allMediaInfoHashMap = new HashMap();
                i = 0;
                if (i >= k) {
                  break label1074;
                }
                localObject1 = (LocalMediaInfo)paramVarArgs.get(i);
                if (((LocalMediaInfo)localObject1).path != null) {
                  break label1055;
                }
              }
              for (;;)
              {
                i += 1;
                break label938;
                localObject2 = ((ArrayList)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject4 = (String)((Iterator)localObject2).next();
                  if ((localPhotoCommonBaseData.allMediaInfoHashMap.containsKey(localObject4)) && (!((HashMap)localObject1).containsKey(localObject4))) {
                    ((HashMap)localObject1).put(localObject4, localPhotoCommonBaseData.allMediaInfoHashMap.get(localObject4));
                  }
                }
                localPhotoCommonBaseData.allMediaInfoHashMap.clear();
                break;
                localPhotoCommonBaseData.allMediaInfoHashMap.put(((LocalMediaInfo)localObject1).path, localObject1);
              }
            }
            localPhotoCommonBaseData.mediaPathsList = ((ArrayList)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + paramVarArgs.size());
            }
            return paramVarArgs;
          }
        }
      }
    }
    
    protected void onPostExecute(List<LocalMediaInfo> paramList)
    {
      awur.this.a.onQueryPhoto(paramList);
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      awur.this.getActivity().runOnUiThread(new AEAbstractPhotoListFragment.QueryPhotoTask.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awur
 * JD-Core Version:    0.7.0.1
 */
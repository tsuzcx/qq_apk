package com.tencent.mobileqq.emoticonview;

import afot;
import afqb;
import afqb.b;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import wja;

public class EmotionPreviewFragment
  extends PublicBaseFragment
  implements afqb.b, View.OnClickListener, AdapterView.e
{
  private View BS;
  private TextView Rz;
  private afot jdField_a_of_type_Afot;
  private afqb jdField_a_of_type_Afqb;
  private EmotionGallery jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery;
  private RelativeLayout dh;
  private NumberCheckBox e;
  private RelativeLayout jV;
  private Button o;
  private HorizontalListView p;
  private TextView titleText;
  private ArrayList<EmotionPreviewInfo> wk;
  
  private int Do()
  {
    int j = 0;
    int i = j;
    if (this.wk != null)
    {
      i = j;
      if (this.wk.size() > 0)
      {
        Iterator localIterator = this.wk.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          if (!((EmotionPreviewInfo)localIterator.next()).isCheck) {
            break label66;
          }
          i += 1;
        }
      }
    }
    label66:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private void MR(int paramInt)
  {
    if ((this.titleText != null) && (this.wk != null) && (this.wk.size() > 1)) {
      this.titleText.setText(paramInt + "/" + this.wk.size());
    }
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramIntent != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        EmotionPreviewInfo localEmotionPreviewInfo = new EmotionPreviewInfo();
        localEmotionPreviewInfo.path = str;
        localEmotionPreviewInfo.isCheck = true;
        localArrayList.add(localEmotionPreviewInfo);
      }
      paramIntent.putParcelableArrayListExtra("preview_data", localArrayList);
      PublicFragmentActivity.b.startForResult(paramActivity, paramIntent, PublicFragmentActivity.class, EmotionPreviewFragment.class, 100015);
    }
  }
  
  private void back()
  {
    Intent localIntent = getActivity().getIntent();
    localIntent.setClass(getActivity(), NewPhotoListActivity.class);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_Afqb.getDataList());
    localIntent.addFlags(603979776);
    startActivity(localIntent);
    getActivity().finish();
  }
  
  private int cP(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.wk != null) && (this.wk.size() > 0))
    {
      int j = this.wk.size();
      int i = 0;
      while (i < j)
      {
        if (((EmotionPreviewInfo)this.wk.get(i)).path.equals(paramString)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private void dbe()
  {
    int i;
    StringBuffer localStringBuffer;
    if (this.o != null)
    {
      i = Do();
      localStringBuffer = new StringBuffer(getResources().getString(2131696945));
      if (i < 1) {
        this.o.setText(localStringBuffer.toString());
      }
    }
    else
    {
      return;
    }
    this.o.setText("(" + i + ")");
  }
  
  private void hP(int paramInt1, int paramInt2)
  {
    if (this.e != null)
    {
      EmotionPreviewInfo localEmotionPreviewInfo = (EmotionPreviewInfo)this.wk.get(paramInt1);
      this.e.setChecked(localEmotionPreviewInfo.isCheck);
      if ((localEmotionPreviewInfo.isCheck) && (paramInt2 >= 0)) {
        this.e.setCheckedNumber(paramInt2 + 1);
      }
    }
  }
  
  private void initData()
  {
    this.wk = getActivity().getIntent().getParcelableArrayListExtra("preview_data");
    this.jdField_a_of_type_Afot.kw(this.wk);
    if ((this.wk != null) && (this.wk.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(this.wk.size());
      Iterator localIterator = this.wk.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((EmotionPreviewInfo)localIterator.next()).path);
      }
      this.jdField_a_of_type_Afqb = new afqb(getActivity(), this);
      this.p.setAdapter(this.jdField_a_of_type_Afqb);
      this.p.setVisibility(0);
      this.p.setOnItemClickListener(this.jdField_a_of_type_Afqb);
      this.p.setDividerWidth(wja.dp2px(14.0F, getResources()));
      this.jdField_a_of_type_Afqb.setData(localArrayList);
      this.jdField_a_of_type_Afqb.setCurrentPath(((EmotionPreviewInfo)this.wk.get(0)).path);
    }
    dbe();
    MR(1);
    hP(0, 0);
  }
  
  public void MS(int paramInt)
  {
    if (this.jdField_a_of_type_Afqb != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_Afqb.getDataList();
      if ((localArrayList != null) && (paramInt < localArrayList.size()))
      {
        int i = cP((String)localArrayList.get(paramInt));
        if (i >= 0)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery != null) {
            this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSelection(i);
          }
          MR(i + 1);
          hP(i, paramInt);
        }
      }
    }
  }
  
  public View f(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131559300, paramViewGroup, false);
  }
  
  protected void gw(View paramView)
  {
    this.o = ((Button)paramView.findViewById(2131377990));
    this.o.setOnClickListener(this);
    this.BS = paramView.findViewById(2131367343);
    this.dh = ((RelativeLayout)paramView.findViewById(2131379791));
    ((RelativeLayout.LayoutParams)this.dh.getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = ((EmotionGallery)paramView.findViewById(2131367833));
    this.jdField_a_of_type_Afot = new afot(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setAdapter(this.jdField_a_of_type_Afot);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSpacing(getActivity().getResources().getDimensionPixelSize(2131297406));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemSelectedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnNoBlankListener(this.jdField_a_of_type_Afot);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableDoubleTap(false);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableScaleGesture(false);
    this.p = ((HorizontalListView)paramView.findViewById(2131367344));
    initData();
  }
  
  protected void initTitleBar(View paramView)
  {
    this.Rz = ((TextView)paramView.findViewById(2131369579));
    this.titleText = ((TextView)paramView.findViewById(2131369627));
    this.jV = ((RelativeLayout)paramView.findViewById(2131377943));
    this.e = ((NumberCheckBox)paramView.findViewById(2131377964));
    this.Rz.setOnClickListener(this);
    this.jV.setOnClickListener(this);
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    back();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
    case 2131369579: 
    case 2131377943: 
      EmotionPreviewInfo localEmotionPreviewInfo;
      boolean bool;
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            back();
          }
          i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition();
        } while ((this.wk == null) || (i >= this.wk.size()));
        localEmotionPreviewInfo = (EmotionPreviewInfo)this.wk.get(i);
        if (localEmotionPreviewInfo.isCheck) {
          break;
        }
        bool = true;
        localEmotionPreviewInfo.isCheck = bool;
        this.e.setChecked(localEmotionPreviewInfo.isCheck);
        dbe();
      } while (this.jdField_a_of_type_Afqb == null);
      this.jdField_a_of_type_Afqb.setCurrentPath(localEmotionPreviewInfo.path);
      localArrayList = this.jdField_a_of_type_Afqb.getDataList();
      if (localEmotionPreviewInfo.isCheck) {
        localArrayList.add(localEmotionPreviewInfo.path);
      }
      for (;;)
      {
        try
        {
          hP(i, localArrayList.indexOf(localEmotionPreviewInfo.path));
          if (localArrayList.size() != 0) {
            break label287;
          }
          this.BS.setVisibility(8);
          this.p.setVisibility(8);
          this.jdField_a_of_type_Afqb.setData(localArrayList);
          break;
          bool = false;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("EmotionPreviewFragment", 2, "onClick exception = " + localException.getMessage());
          continue;
        }
        localArrayList.remove(localException.path);
        continue;
        label287:
        this.BS.setVisibility(0);
        this.p.setVisibility(0);
      }
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Afqb != null) {
      localArrayList = this.jdField_a_of_type_Afqb.getDataList();
    }
    for (;;)
    {
      if (localArrayList.size() == 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition();
        if ((this.wk != null) && (i < this.wk.size()))
        {
          localObject = (EmotionPreviewInfo)this.wk.get(i);
          if (!TextUtils.isEmpty(((EmotionPreviewInfo)localObject).path)) {
            localArrayList.add(((EmotionPreviewInfo)localObject).path);
          }
        }
      }
      anot.a(null, "dc00898", "", "", "0X800A6DE", "0X800A6DE", 0, 0, String.valueOf(localArrayList.size()), "", "", "");
      Object localObject = new Intent();
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = f(paramLayoutInflater, paramViewGroup);
    initTitleBar(paramLayoutInflater);
    gw(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if ((this.jdField_a_of_type_Afqb != null) && (this.wk != null) && (paramInt < this.wk.size()))
    {
      paramAdapterView = (EmotionPreviewInfo)this.wk.get(paramInt);
      if (paramAdapterView.path.equals(this.jdField_a_of_type_Afqb.uz())) {
        break label132;
      }
      i = 1;
      this.jdField_a_of_type_Afqb.setCurrentPath(paramAdapterView.path);
      if (i != 0) {
        this.jdField_a_of_type_Afqb.notifyDataSetChanged();
      }
      paramView = this.jdField_a_of_type_Afqb.getDataList();
      if ((paramView != null) && (!TextUtils.isEmpty(paramAdapterView.path)))
      {
        i = paramView.indexOf(paramAdapterView.path);
        if (i < 0) {
          break label138;
        }
        hP(paramInt, i);
      }
    }
    for (;;)
    {
      MR(paramInt + 1);
      return;
      label132:
      i = 0;
      break;
      label138:
      hP(paramInt, -1);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewFragment
 * JD-Core Version:    0.7.0.1
 */
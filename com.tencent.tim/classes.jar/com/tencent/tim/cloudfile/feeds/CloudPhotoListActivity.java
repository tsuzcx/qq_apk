package com.tencent.tim.cloudfile.feeds;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqhq;
import atgd;
import aths;
import aths.a;
import athu;
import atiu;
import atiz;
import atjx;
import atlt;
import atlu;
import atlv;
import atlw;
import atlx;
import atly;
import attf;
import auds;
import audx;
import augx;
import auhh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zsz;

public class CloudPhotoListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, augx
{
  private ArrayList<String> Ed;
  private ImageView Ha;
  private ImageView Hb;
  private List<FileManagerEntity> KA = new ArrayList();
  protected List<Object> KB = new ArrayList();
  private View Kx;
  private TextView MZ;
  aths.a jdField_a_of_type_Aths$a = new atly(this);
  private b jdField_a_of_type_ComTencentTimCloudfileFeedsCloudPhotoListActivity$b;
  protected c a;
  protected long ayj;
  private atgd jdField_b_of_type_Atgd = new atlw(this);
  private atjx jdField_b_of_type_Atjx;
  private auhh jdField_b_of_type_Auhh;
  public int currentMode = 1;
  public boolean dih;
  private Handler handler = new atlx(this);
  private LinearLayout lZ;
  private GestureSelectGridView mGridView;
  int mImageHeight;
  int mImageWidth;
  GestureSelectGridView.b mOnSelectChangeListener = new atlu(this);
  AdapterView.c mPhotoListItemClickListener = new atlv(this);
  protected int maxSelectNum = 20;
  
  private void etZ()
  {
    switch (this.currentMode)
    {
    default: 
      this.MZ.setVisibility(8);
      this.lZ.setVisibility(8);
      this.Kx.setVisibility(8);
      return;
    case 1: 
      this.MZ.setVisibility(0);
      this.MZ.setText(2131721064);
      this.lZ.setVisibility(8);
      this.Kx.setVisibility(8);
      this.KB.clear();
      atiz.clearSelected();
      Iterator localIterator = this.KA.iterator();
      while (localIterator.hasNext()) {
        ((FileManagerEntity)localIterator.next()).setmSelectable(false);
      }
    case 2: 
      this.MZ.setVisibility(0);
      this.MZ.setText(2131721058);
      this.lZ.setVisibility(0);
      this.Kx.setVisibility(0);
      return;
    }
    this.MZ.setVisibility(8);
    this.lZ.setVisibility(8);
    this.Kx.setVisibility(8);
  }
  
  private void ie()
  {
    if (getIntent().getIntExtra("key_file_browser_mode", -1) == 2) {
      this.currentMode = 3;
    }
    etZ();
    this.Ed = getIntent().getStringArrayListExtra("photo_entity_list_intent");
    if ((this.Ed != null) && (!this.Ed.isEmpty()))
    {
      Iterator localIterator = this.Ed.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = this.app.a().a(0L, "", 0, Long.valueOf((String)localObject).longValue());
        this.KA.add(localObject);
        ((FileManagerEntity)localObject).setmSelectable(false);
        if ((this.currentMode == 3) && (atiz.b((atiu)localObject)))
        {
          this.KB.add(localObject);
          ((FileManagerEntity)localObject).setmSelectable(true);
        }
      }
    }
    this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudPhotoListActivity$b = new b();
    this.mGridView.setAdapter(this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudPhotoListActivity$b);
    this.mGridView.setOnItemClickListener(new atlt(this));
  }
  
  private void initUI()
  {
    this.mGridView = ((GestureSelectGridView)findViewById(2131364800));
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.density;
    double d = Math.floor(localDisplayMetrics.widthPixels - f * 5.0F) / 4.0D;
    this.mGridView.setNumColumns(4);
    this.mGridView.setColumnWidth((int)d);
    this.mGridView.setStretchMode(1);
    this.mGridView.setHorizontalSpacing(2);
    this.mGridView.setVerticalSpacing(2);
    this.mGridView.setOnItemClickListener(this.mPhotoListItemClickListener);
    this.mGridView.setOnIndexChangedListener(this.mOnSelectChangeListener);
    this.mImageHeight = ((int)d);
    this.mImageWidth = ((int)d);
    this.MZ = ((TextView)findViewById(2131369612));
    this.MZ.setOnClickListener(this);
    this.lZ = ((LinearLayout)findViewById(2131364806));
    this.Ha = ((ImageView)findViewById(2131364805));
    this.Hb = ((ImageView)findViewById(2131364808));
    this.Kx = findViewById(2131364807);
    this.Ha.setOnClickListener(this);
    this.Hb.setOnClickListener(this);
  }
  
  private void updateButton() {}
  
  private void updateCheckbox(int paramInt, boolean paramBoolean)
  {
    int j = this.mGridView.getFirstVisiblePosition();
    int k = this.mGridView.getLastVisiblePosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      for (;;)
      {
        i += 1;
        break;
        View localView = this.mGridView.getChildAt(i - j);
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudPhotoListActivity$b.a(i);
        if (localView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarActivity", 2, "updateCheckbox view = null at " + i);
          }
        }
        else if (localFileManagerEntity == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else if (paramInt != i)
        {
          if (this.KB.indexOf(localFileManagerEntity) >= 0) {
            ((CloudPhotoListActivity.b.a)localView.getTag()).mCheckBox.setChecked(true);
          }
        }
        else
        {
          CloudPhotoListActivity.b.a locala = (CloudPhotoListActivity.b.a)localView.getTag();
          ImageView localImageView = locala.tO;
          boolean bool = localFileManagerEntity.isSelectable();
          if (this.currentMode == 3) {
            bool = atiz.b(localFileManagerEntity);
          }
          if (bool)
          {
            localImageView.setVisibility(0);
            locala.mCheckBox.setChecked(true);
            if (localView.getBackground() != null) {
              localView.setBackgroundDrawable(null);
            }
          }
          else
          {
            localImageView.setVisibility(4);
            locala.mCheckBox.setChecked(false);
            if (localView.getBackground() != null) {
              localView.setBackgroundDrawable(null);
            }
          }
        }
      }
    }
  }
  
  public boolean Pp()
  {
    return isResume();
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity.isSelectable()) {
      return false;
    }
    if (paramBoolean) {
      if (this.currentMode == 3)
      {
        if (atiz.a(paramFileManagerEntity)) {
          this.KB.add(paramFileManagerEntity);
        }
        label39:
        zsz.q(getIntent(), "param_totalSelNum");
        Intent localIntent = getIntent();
        if (!localIntent.hasExtra("param_initTime")) {
          localIntent.putExtra("param_initTime", System.currentTimeMillis());
        }
        paramFileManagerEntity.setmSelectable(true);
      }
    }
    for (;;)
    {
      if ((!paramFileManagerEntity.isSelectable()) || (!paramBoolean) || (this.KB.size() < this.maxSelectNum)) {
        break label224;
      }
      long l = System.currentTimeMillis();
      if (l - this.ayj < 700L) {
        break;
      }
      QQToast.a(this, "最多只能选择" + this.maxSelectNum + "张图片", 1000).show();
      this.ayj = l;
      this.dih = true;
      return false;
      this.KB.add(paramFileManagerEntity);
      break label39;
      this.KB.remove(paramFileManagerEntity);
      if (this.currentMode == 3) {
        atiz.b(paramFileManagerEntity);
      }
      paramFileManagerEntity.setmSelectable(false);
    }
    label224:
    this.dih = false;
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558986);
    initUI();
    ie();
    this.jdField_b_of_type_Atjx = new atjx(this.app, this, this);
    this.jdField_b_of_type_Auhh = ((auhh)this.jdField_b_of_type_Atjx.a(2));
    this.app.addObserver(this.jdField_b_of_type_Atgd);
    aths.a().a(this.jdField_a_of_type_Aths$a);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_b_of_type_Atgd);
    if (this.jdField_b_of_type_Atjx != null) {
      this.jdField_b_of_type_Atjx.onDestroy();
    }
    aths.a().b(this.jdField_a_of_type_Aths$a);
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
      if (this.currentMode == 1) {
        this.currentMode = 2;
      }
      for (;;)
      {
        etZ();
        this.jdField_a_of_type_ComTencentTimCloudfileFeedsCloudPhotoListActivity$b.notifyDataSetChanged();
        break;
        if (this.currentMode == 2) {
          this.currentMode = 1;
        }
      }
      if ((this.KB != null) && (this.KB.size() > 0))
      {
        this.jdField_b_of_type_Auhh.o(1, this.KB.toArray());
        continue;
        if (this.KB.size() > 20) {
          auds.D(0, String.format(BaseApplicationImpl.getApplication().getResources().getString(2131693814), new Object[] { Integer.valueOf(20) }), 0);
        } else if ((this.KB != null) && (this.KB.size() > 0)) {
          this.jdField_b_of_type_Auhh.nS(this.KB);
        }
      }
    }
  }
  
  class a
    implements View.OnClickListener
  {
    CheckBox mCheckBox;
    int mPosition;
    
    public a() {}
    
    public void onClick(View paramView)
    {
      boolean bool = true;
      if (CloudPhotoListActivity.this.currentMode == 1)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      CloudPhotoListActivity.a(CloudPhotoListActivity.this);
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)CloudPhotoListActivity.a(CloudPhotoListActivity.this).get(this.mPosition);
      if (!localFileManagerEntity.isSelectable()) {}
      for (;;)
      {
        localFileManagerEntity.setmSelectable(bool);
        bool = localFileManagerEntity.isSelectable();
        if ((CloudPhotoListActivity.this.KB.size() != 20) || (!bool)) {
          break label130;
        }
        auds.D(0, "最多只能选择" + CloudPhotoListActivity.this.maxSelectNum + "张图片", 0);
        break;
        bool = false;
      }
      label130:
      if (bool) {
        if (CloudPhotoListActivity.this.currentMode == 3)
        {
          if (atiz.a(localFileManagerEntity)) {
            CloudPhotoListActivity.this.KB.add(localFileManagerEntity);
          }
          label166:
          zsz.q(CloudPhotoListActivity.this.getIntent(), "param_totalSelNum");
          Intent localIntent = CloudPhotoListActivity.this.getIntent();
          if (!localIntent.hasExtra("param_initTime")) {
            localIntent.putExtra("param_initTime", System.currentTimeMillis());
          }
        }
      }
      for (;;)
      {
        if (CloudPhotoListActivity.this.a != null) {
          CloudPhotoListActivity.this.a.b(bool, localFileManagerEntity);
        }
        CloudPhotoListActivity.a(CloudPhotoListActivity.this, this.mPosition, bool);
        CloudPhotoListActivity.a(CloudPhotoListActivity.this);
        break;
        CloudPhotoListActivity.this.KB.add(localFileManagerEntity);
        break label166;
        CloudPhotoListActivity.this.KB.remove(localFileManagerEntity);
        if (CloudPhotoListActivity.this.currentMode == 3) {
          atiz.b(localFileManagerEntity);
        }
      }
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
  
  public class b
    extends BaseAdapter
  {
    ColorDrawable colorDrawable = new ColorDrawable(570425344);
    Drawable mDefaultPhotoDrawable = this.mResources.getDrawable(2130848704);
    LayoutInflater mInflater = CloudPhotoListActivity.this.getLayoutInflater();
    Resources mResources = CloudPhotoListActivity.this.getResources();
    
    public b() {}
    
    public FileManagerEntity a(int paramInt)
    {
      return (FileManagerEntity)CloudPhotoListActivity.a(CloudPhotoListActivity.this).get(paramInt);
    }
    
    public int getCount()
    {
      return CloudPhotoListActivity.a(CloudPhotoListActivity.this).size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      switch (getItemViewType(paramInt))
      {
      default: 
        localView = paramView;
      }
      label404:
      label416:
      label448:
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
        a locala;
        if (paramView == null)
        {
          localView = this.mInflater.inflate(2131558965, null);
          localView.setLayoutParams(new AbsListView.LayoutParams(CloudPhotoListActivity.this.mImageWidth, CloudPhotoListActivity.this.mImageHeight));
          locala = new a();
          locala.k = ((AsyncImageView)localView.findViewById(2131368820));
          locala.tO = ((ImageView)localView.findViewById(2131368836));
          locala.mSelectedBtn = localView.findViewById(2131373184);
          locala.mCheckBox = ((NumberCheckBox)localView.findViewById(2131373185));
          locala.cF = ((ImageView)localView.findViewById(2131381579));
          locala.a = new CloudPhotoListActivity.a(CloudPhotoListActivity.this);
          if (locala.mSelectedBtn != null) {
            locala.mSelectedBtn.setOnClickListener(locala.a);
          }
          localView.setTag(locala);
          label212:
          if (CloudPhotoListActivity.this.currentMode != 1) {
            break label404;
          }
          locala.mSelectedBtn.setVisibility(4);
        }
        Object localObject;
        for (;;)
        {
          locala.a.setPosition(paramInt);
          locala.a.setCheckBox(locala.mCheckBox);
          localObject = locala.k;
          ((AsyncImageView)localObject).setAdjustViewBounds(false);
          FileManagerEntity localFileManagerEntity = a(paramInt);
          ((AsyncImageView)localObject).setAsyncClipSize(CloudPhotoListActivity.this.mImageWidth, CloudPhotoListActivity.this.mImageHeight);
          locala.cF.setVisibility(8);
          athu.c((AsyncImageView)localObject, localFileManagerEntity);
          if ((audx.fM(localFileManagerEntity.fileName) == 2) && (aqhq.fileExistsAndNotEmpty(athu.j(localFileManagerEntity)))) {
            locala.cF.setVisibility(0);
          }
          localObject = locala.tO;
          if (!localFileManagerEntity.isSelectable()) {
            break label416;
          }
          ((ImageView)localObject).setVisibility(0);
          locala.mCheckBox.setChecked(true);
          if (localView.getBackground() == null) {
            break label448;
          }
          localView.setBackgroundDrawable(null);
          break;
          locala = (a)paramView.getTag();
          localView = paramView;
          break label212;
          locala.mSelectedBtn.setVisibility(0);
        }
        ((ImageView)localObject).setVisibility(4);
        locala.mCheckBox.setChecked(false);
        if (localView.getBackground() != null) {
          localView.setBackgroundDrawable(null);
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    class a
    {
      CloudPhotoListActivity.a a;
      ImageView cF;
      AsyncImageView k;
      NumberCheckBox mCheckBox;
      View mSelectedBtn;
      ImageView tO;
      
      a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void b(boolean paramBoolean, FileManagerEntity paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity
 * JD-Core Version:    0.7.0.1
 */
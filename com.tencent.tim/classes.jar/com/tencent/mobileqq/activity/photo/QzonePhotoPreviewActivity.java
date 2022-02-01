package com.tencent.mobileqq.activity.photo;

import NS_MOBILE_OPERATION.PicInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.TextView;
import aoop;
import aqfy;
import aqnm;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.LocalPhotoLinearGradientView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import zsd;
import zse;
import zsf;

public class QzonePhotoPreviewActivity
  extends PublicBaseFragment
{
  public int Cv = 0;
  protected TextView Nl;
  protected b a;
  protected LocalPhotoLinearGradientView f;
  protected HashMap<String, PicInfo> ht;
  private boolean isFromQzoneAlbum;
  public ArrayList<String> paths;
  protected ListView q;
  protected ArrayList<a> rK;
  protected HashMap<String, LocalMediaInfo> selectedMediaInfoHashMap;
  
  private void cry()
  {
    this.rK = new ArrayList(1);
    int i = 0;
    if (i < this.paths.size())
    {
      Object localObject;
      if ((this.ht != null) && (this.ht.size() > 0) && (this.ht.containsKey(this.paths.get(i))))
      {
        localObject = (PicInfo)this.ht.get(this.paths.get(i));
        if ((localObject != null) && (((PicInfo)localObject).picwidth > 0)) {
          this.rK.add(new a((String)this.paths.get(i), (float)(((PicInfo)localObject).picheight * 1.0D / ((PicInfo)localObject).picwidth)));
        }
      }
      int j;
      if ((this.selectedMediaInfoHashMap != null) && (this.selectedMediaInfoHashMap.containsKey(this.paths.get(i))))
      {
        localObject = (LocalMediaInfo)this.selectedMediaInfoHashMap.get(this.paths.get(i));
        if ((((LocalMediaInfo)localObject).orientation != 90) && (((LocalMediaInfo)localObject).orientation != 270)) {
          break label256;
        }
        j = ((LocalMediaInfo)localObject).mediaWidth;
      }
      for (int k = ((LocalMediaInfo)localObject).mediaHeight;; k = ((LocalMediaInfo)localObject).mediaWidth)
      {
        this.rK.add(new a((String)this.paths.get(i), (float)(j * 1.0D / k)));
        i += 1;
        break;
        label256:
        j = ((LocalMediaInfo)localObject).mediaHeight;
      }
    }
  }
  
  private Intent getIntent()
  {
    return getActivity().getIntent();
  }
  
  private void initUI(View paramView)
  {
    this.f = ((LocalPhotoLinearGradientView)paramView.findViewById(2131376545));
    LinearGradient localLinearGradient = new LinearGradient(0.0F, aqnm.dip2px(79.0F), 0.0F, 0.0F, -14869219, 0, Shader.TileMode.CLAMP);
    this.f.setShader(localLinearGradient);
    this.q = ((ListView)paramView.findViewById(2131376546));
    this.Nl = ((TextView)paramView.findViewById(2131376544));
    this.q.setOnItemClickListener(new zsd(this));
    this.Nl.setOnClickListener(new zse(this));
    this.a = new b(getActivity());
    this.q.setAdapter(this.a);
  }
  
  private void parseIntent()
  {
    this.paths = getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    this.ht = ((HashMap)getIntent().getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.selectedMediaInfoHashMap = ((HashMap)getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"));
    this.Cv = getIntent().getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    this.isFromQzoneAlbum = getIntent().getBooleanExtra("PhotoConst.IS_FROM_QZONE_ALBUM", false);
    cry();
  }
  
  public void back()
  {
    Intent localIntent = getIntent();
    localIntent.setClass(getActivity(), NewPhotoListActivity.class);
    startActivity(localIntent);
    getActivity().finish();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.isFromQzoneAlbum)
      {
        getActivity().finish();
        aqfy.anim(getActivity(), true, false);
        return true;
      }
      back();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131562660, null);
    getActivity().getWindow().addFlags(1024);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    parseIntent();
    initUI(paramView);
  }
  
  class a
  {
    String path;
    float re;
    
    public a(String paramString, float paramFloat)
    {
      this.path = paramString;
      this.re = paramFloat;
    }
  }
  
  public class b
    extends BaseAdapter
  {
    private final String TAG = "VerticalPictureAdapter";
    
    public b(Context paramContext)
    {
      abS();
    }
    
    private void a(a parama, int paramInt)
    {
      QzonePhotoPreviewActivity.a locala = (QzonePhotoPreviewActivity.a)getItem(paramInt);
      if (locala == null)
      {
        QZLog.e("VerticalPictureAdapter", "photoInfo == null");
        return;
      }
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)parama.I.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -2);
      }
      QZLog.d("VerticalPictureAdapter", 1, new Object[] { "photoInfo.heightWeightProportion:", Float.valueOf(locala.re) });
      if (locala.re != 0.0F)
      {
        float f = aqnm.getScreenWidth();
        localLayoutParams1.height = ((int)(locala.re * f));
      }
      parama.I.setLayoutParams(localLayoutParams1);
      parama.I.setImageDrawable(null);
    }
    
    private void abS()
    {
      QzonePhotoPreviewActivity.this.q.setRecyclerListener(new zsf(this));
    }
    
    private void b(a parama, int paramInt)
    {
      Object localObject = (QzonePhotoPreviewActivity.a)getItem(paramInt);
      if ((localObject == null) || (TextUtils.isEmpty(((QzonePhotoPreviewActivity.a)localObject).path))) {
        QZLog.e("VerticalPictureAdapter", "loadImageData: bigUrl is empty");
      }
      for (;;)
      {
        return;
        File localFile = new File(((QzonePhotoPreviewActivity.a)localObject).path);
        if (localFile.exists())
        {
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = aqnm.getScreenWidth();
          float f = aqnm.getScreenWidth();
          localURLDrawableOptions.mRequestHeight = ((int)(((QzonePhotoPreviewActivity.a)localObject).re * f));
          localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
          try
          {
            localObject = localFile.toURI().toURL();
            if (localObject != null)
            {
              localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
              if (localObject != null) {
                switch (((URLDrawable)localObject).getStatus())
                {
                default: 
                  ((URLDrawable)localObject).startDownload();
                }
              }
              if (localObject != null)
              {
                parama.I.setImageDrawable((Drawable)localObject);
                return;
              }
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              localMalformedURLException.printStackTrace();
              localURLDrawable = null;
            }
          }
        }
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = aqnm.getScreenWidth();
      localURLDrawableOptions.mRequestHeight = ((int)(aqnm.getScreenWidth() * localURLDrawable.re));
      localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
      URLDrawable localURLDrawable = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(localURLDrawable.path), localURLDrawableOptions);
      if (localURLDrawable == null) {
        QLog.w("PEAK", 2, "drawable == null");
      }
      parama.I.setImageDrawable(localURLDrawable);
    }
    
    public int getCount()
    {
      if (QzonePhotoPreviewActivity.this.rK != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VerticalPictureAdapter", 2, "wywy getCount =" + QzonePhotoPreviewActivity.this.rK.size());
        }
        return QzonePhotoPreviewActivity.this.rK.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((QzonePhotoPreviewActivity.this.rK != null) && (paramInt < QzonePhotoPreviewActivity.this.rK.size()) && (paramInt >= 0)) {
        return QzonePhotoPreviewActivity.this.rK.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      a locala = new a(null);
      if (paramView == null)
      {
        locala.I = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
        locala.I.setTag(locala);
      }
      for (paramView = locala;; paramView = (a)paramView.getTag())
      {
        a(paramView, paramInt);
        b(paramView, paramInt);
        paramView = paramView.I;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
    
    public class a
    {
      public URLImageView I;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */
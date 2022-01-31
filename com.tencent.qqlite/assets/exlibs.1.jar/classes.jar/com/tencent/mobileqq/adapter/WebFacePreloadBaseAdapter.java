package com.tencent.mobileqq.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import cpk;
import cpl;
import java.util.ArrayList;

public class WebFacePreloadBaseAdapter
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  protected static final int a = 1;
  protected static final String a = "WebFacePreloadBaseAdapter";
  public static final String b = "com.tencent.qqhead.getheadreq";
  public static final String c = "com.tencent.qqhead.getheadresp";
  protected float a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cpk(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  protected Handler a;
  private LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(60);
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected int b;
  private LruCache b;
  protected int c;
  private int d = 0;
  private int e;
  private final int f = 60;
  
  public WebFacePreloadBaseAdapter(Context paramContext, XListView paramXListView, int paramInt)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(120);
    this.jdField_a_of_type_AndroidOsHandler = new cpl(this);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.e = paramInt;
    a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
    }
  }
  
  protected Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    int j = this.jdField_b_of_type_Int;
    int i = this.c;
    float f2 = this.jdField_a_of_type_Float;
    int k = paramBitmap.getWidth();
    float f1 = f2;
    if (k > 0)
    {
      f1 = f2;
      if (k < j * f2) {
        f1 = k / j;
      }
    }
    j = (int)(j * f1);
    i = (int)(f1 * i);
    return ImageUtil.a(paramBitmap, j, j, i);
  }
  
  protected Bitmap a(String paramString)
  {
    return a(paramString, true);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localBitmap1 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        if (localBitmap1 != null) {
          return localBitmap1;
        }
        if (this.d == 0) {
          if (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString)))
          {
            localBitmap4 = BitmapFactory.decodeFile((String)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString));
            if (localBitmap4 != null)
            {
              localBitmap1 = a(localBitmap4);
              localBitmap2 = localBitmap1;
              if (localBitmap4 != null) {
                localBitmap2 = localBitmap1;
              }
            }
          }
        }
      }
      catch (OutOfMemoryError paramString)
      {
        Bitmap localBitmap4;
        Bitmap localBitmap2;
        paramString.printStackTrace();
        return this.jdField_a_of_type_AndroidGraphicsBitmap;
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localBitmap2);
        return localBitmap2;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        continue;
        if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
          d();
        }
        paramString = this.jdField_a_of_type_AndroidGraphicsBitmap;
        return paramString;
      }
      try
      {
        if (!localBitmap4.isRecycled())
        {
          localBitmap4.recycle();
          localBitmap2 = localBitmap1;
        }
      }
      catch (Exception localException)
      {
        Bitmap localBitmap3 = localBitmap1;
        continue;
      }
      if (localBitmap2 != null) {
        continue;
      }
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
      this.jdField_b_of_type_AndroidSupportV4UtilLruCache.remove(paramString);
      localBitmap2 = localBitmap1;
      if (QLog.isColorLevel())
      {
        QLog.d("WebFacePreloadBaseAdapter", 2, "getFaceBitmap, decodeFile failed:" + (String)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString) + " " + paramString);
        localBitmap2 = localBitmap1;
      }
    }
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    for (;;)
    {
      return;
      this.d = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("WebFacePreloadBaseAdapter", 2, "onScrollStateChanged, curState:" + this.d);
      }
      if (paramInt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebFacePreloadBaseAdapter", 2, "onScrollStateChanged, removeMessages");
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
          if ((localObject != null) && ((localObject instanceof WebFacePreloadBaseAdapter.ViewHolder)))
          {
            localObject = (WebFacePreloadBaseAdapter.ViewHolder)localObject;
            if ((localObject != null) && (((WebFacePreloadBaseAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString != null) && (((WebFacePreloadBaseAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString.length() > 0)) {
              ((WebFacePreloadBaseAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((WebFacePreloadBaseAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString, true));
            }
          }
          i += 1;
        }
        d();
      }
      while (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null)
      {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("WebFacePreloadBaseAdapter", 2, "onScrollStateChanged, removeMessages");
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (this.d != 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (QLog.isColorLevel()) {
        QLog.d("WebFacePreloadBaseAdapter", 2, "onScroll, removeMessages");
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebFacePreloadBaseAdapter", 2, "sendQQHeadRequest, reqSize:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " cacheSize:" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size() + " " + this.jdField_b_of_type_AndroidSupportV4UtilLruCache.size());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      return;
    }
    Intent localIntent = new Intent("com.tencent.qqhead.getheadreq");
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    localIntent.putExtra("faceType", this.e);
    localIntent.putStringArrayListExtra("uinList", this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebFacePreloadBaseAdapter", 2, "postQQHeadRequest");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 500L);
  }
  
  public void e()
  {
    b();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache.evictAll();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.WebFacePreloadBaseAdapter
 * JD-Core Version:    0.7.0.1
 */
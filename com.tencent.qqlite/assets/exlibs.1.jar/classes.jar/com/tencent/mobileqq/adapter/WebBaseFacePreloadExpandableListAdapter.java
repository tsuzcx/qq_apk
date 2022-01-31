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
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import cqp;
import cqq;
import java.util.ArrayList;

public class WebBaseFacePreloadExpandableListAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
  implements AbsListView.OnScrollListener
{
  protected static final int a = 1;
  protected static final String a = "WebFacePreloadBaseAdapter";
  public static final String b = "com.tencent.qqhead.getheadreq";
  public static final String c = "com.tencent.qqhead.getheadresp";
  protected float a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cqp(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  protected Handler a;
  private LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(60);
  public ExpandableListView a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected int b;
  private LruCache b;
  protected int c;
  private int d;
  private int e = 0;
  private final int f = 60;
  
  public WebBaseFacePreloadExpandableListAdapter(Context paramContext, ExpandableListView paramExpandableListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = null;
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(120);
    this.jdField_a_of_type_AndroidOsHandler = new cqq(this);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public Bitmap a()
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
  
  public Bitmap a(String paramString)
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
        if (this.e == 0) {
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
  
  public void a(View paramView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView == null) {
      return;
    }
    this.e = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("WebFacePreloadBaseAdapter", 2, "onScrollStateChanged, curState:" + this.e);
    }
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebFacePreloadBaseAdapter", 2, "onScrollStateChanged, removeMessages");
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      int i = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && ((paramAbsListView instanceof WebFacePreloadBaseAdapter.ViewHolder)))
        {
          paramAbsListView = (WebFacePreloadBaseAdapter.ViewHolder)paramAbsListView;
          if ((paramAbsListView != null) && (paramAbsListView.jdField_a_of_type_JavaLangString != null) && (paramAbsListView.jdField_a_of_type_JavaLangString.length() > 0)) {
            paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramAbsListView.jdField_a_of_type_JavaLangString, true));
          }
        }
        paramInt += 1;
      }
      d();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebFacePreloadBaseAdapter", 2, "onScrollStateChanged, removeMessages");
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.e != 0)
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
    localIntent.putExtra("faceType", this.d);
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
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = null;
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache.evictAll();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return null;
  }
  
  public int getGroupCount()
  {
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.WebBaseFacePreloadExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */
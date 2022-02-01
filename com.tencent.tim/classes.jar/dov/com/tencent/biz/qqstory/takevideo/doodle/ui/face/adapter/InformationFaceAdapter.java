package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.Toast;
import aoll;
import aolm;
import aomg;
import aomi;
import aoop;
import aqiw;
import aqqx;
import axov;
import axqg;
import axsz;
import axsz.a;
import axwb;
import axwb.a;
import aykk;
import ayna;
import ayna.c;
import aynb;
import aynh;
import aynh.a;
import aynk;
import aynl;
import ayom;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import ige;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import mqq.os.MqqHandler;
import ram;
import rar;

public class InformationFaceAdapter
  extends aynh<ayna>
  implements View.OnClickListener
{
  private aynh.a<String, Drawable> b = new aynh.a();
  
  public InformationFaceAdapter(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  private void a(Drawable paramDrawable, String paramString1, String paramString2, int paramInt)
  {
    paramDrawable = new aykk(((ayna)this.c).name, paramString2, paramDrawable, paramInt);
    paramString2 = axwb.a();
    this.f.b(paramDrawable, paramString2.x, paramString2.y, (float)((ayna)this.c).scale, paramString1, null);
  }
  
  private void a(ayna.c paramc)
  {
    int j = 7;
    String str = axsz.b(paramc);
    Object localObject1 = ".apng";
    if ((this.context instanceof EditPicActivity)) {
      localObject1 = ".bpng";
    }
    for (int i = 0;; i = 1)
    {
      int k;
      if (paramc.eKF == 8)
      {
        k = Calendar.getInstance().get(7) - 1;
        if (k != 0) {
          break label478;
        }
      }
      for (;;)
      {
        for (str = str + File.separator + j + (String)localObject1;; str = str + File.separator + "city" + (String)localObject1)
        {
          localObject2 = (Drawable)this.b.get(str);
          if (localObject2 != null) {
            break label442;
          }
          if (i == 1) {
            break label299;
          }
          localObject1 = BitmapFactory.decodeFile(str);
          if (localObject1 != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("InformationFaceAdapter", 2, "InformationFaceAdapter decodeFile path:" + str + ",bitmap is null");
          }
          adD(str);
          return;
        }
        ((Bitmap)localObject1).setDensity(this.context.getResources().getDisplayMetrics().densityDpi);
        localObject1 = new BitmapDrawable(this.context.getResources(), (Bitmap)localObject1);
        Object localObject2 = localObject1;
        if (localObject1 != null)
        {
          this.b.h(str, localObject1);
          localObject2 = localObject1;
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label452;
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          a((Drawable)localObject2, str, paramc.cWb, i);
          return;
          label299:
          localObject1 = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), str, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
          if (localObject1 != null)
          {
            j = ((URLDrawable)localObject1).getStatus();
            if (j != 1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("InformationFaceAdapter", 2, "urlDrawable is not  SUCCESSED :" + j);
              }
              if (j == 2) {
                ((URLDrawable)localObject1).restartDownload();
              }
              for (;;)
              {
                ((URLDrawable)localObject1).setURLDrawableListener(new aynk(this, str, paramc));
                localObject1 = localObject2;
                break;
                ((URLDrawable)localObject1).startDownload();
              }
            }
            break;
          }
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("InformationFaceAdapter", 2, "urlDrawable apng error");
          localObject1 = localObject2;
          break;
          label442:
          this.b.eSR();
        }
        label452:
        ram.e("InformationFaceAdapter", "can create drawable from path:" + str);
        return;
        label478:
        j = k;
      }
    }
  }
  
  private void a(Boolean paramBoolean, ayna.c paramc)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      if (paramc.eKF == 8) {
        a(paramc);
      }
    }
    else {
      return;
    }
    if ((aynb.oB(paramc.eKF)) && ("default".equals(((ayna)this.c).awA)))
    {
      Toast.makeText(BaseApplicationImpl.getContext(), 2131701929, 0).show();
      return;
    }
    float f = (float)((ayna)this.c).scale;
    paramBoolean = axwb.a();
    this.f.a(paramc, null, paramBoolean.x, paramBoolean.y, f);
  }
  
  private void adD(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new InformationFaceAdapter.2(this, paramString));
    QQToast.a(this.context, 0, acfp.m(2131707412), 0).show();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (this.c == null) {
      localObject = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      if (paramView == null) {
        localObject = new InformationItemLayout(this.context, paramViewGroup.getWidth(), ((ayna)this.c).tu(), ((ayna)this.c).az(), this, this);
      }
      try
      {
        for (;;)
        {
          ((InformationItemLayout)localObject).a((ayna)this.c, paramInt, getCount(), aQR());
          break;
          localObject = (InformationItemLayout)paramView;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131369259);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131369258);
    int i = ((Integer)localImageView.getTag(2131379225)).intValue();
    ayna.c localc = (ayna.c)((ayna)this.c).items.get(i);
    Boolean localBoolean = (Boolean)localImageView.getTag(2131379203);
    axsz localaxsz = (axsz)axov.a().c(12);
    if (localaxsz.a(localc)) {
      a(localBoolean, localc);
    }
    for (;;)
    {
      rar.b((Activity)paramView.getContext(), "sticker_element", ((ayna)this.c).id, localc.posterId);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aqiw.isNetworkAvailable(paramView.getContext())) {
        localaxsz.a((ayna.c)((ayna)this.c).items.get(i), new a(localQIMCommonLoadingView, localImageView));
      } else {
        QQToast.a(paramView.getContext(), 0, acfp.m(2131707414), 0).show();
      }
    }
  }
  
  public static class InformationItemLayout
    extends LinearLayout
  {
    private aynh b;
    private Context mContext;
    private int mCount;
    private int mItemWidth;
    private View.OnClickListener mListener;
    private int mParentWidth;
    private float nr;
    
    public InformationItemLayout(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener, aynh paramaynh)
    {
      super();
      this.mContext = paramContext;
      this.mListener = paramOnClickListener;
      this.mParentWidth = paramInt1;
      this.mCount = paramInt2;
      this.nr = paramFloat;
      this.b = paramaynh;
      paramInt1 = ayom.dip2px(getContext(), 6.0F);
      this.mItemWidth = ((this.mParentWidth - paramInt1 * ((this.mCount - 1) * 2)) / this.mCount);
      buQ();
    }
    
    private URLDrawable a(ayna.c paramc)
      throws MalformedURLException
    {
      Object localObject1 = (axsz)axov.a().c(12);
      Object localObject2 = axsz.Ig();
      localObject1 = paramc.cWb + "_static.png";
      localObject2 = new File((String)localObject2);
      if (((File)localObject2).exists()) {
        if (!((File)localObject2).isDirectory()) {
          ((File)localObject2).delete();
        }
      }
      for (;;)
      {
        localObject1 = new File((File)localObject2, (String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("InformationFaceAdapter", 2, "static file name:" + ((File)localObject1).getAbsolutePath());
        }
        paramc = new URL(paramc.cXh);
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).Recycle();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT;
        return URLDrawable.getDrawable(paramc, (URLDrawable.URLDrawableOptions)localObject1);
        ((File)localObject2).mkdirs();
      }
    }
    
    private void a(ayna.c paramc, URLImageView paramURLImageView, QIMCommonLoadingView paramQIMCommonLoadingView, ProgressBar paramProgressBar, InformationFaceAdapter.b paramb, boolean paramBoolean, aynh paramaynh)
      throws MalformedURLException
    {
      Object localObject1 = (axsz)axov.a().c(12);
      Object localObject2 = axsz.Ig();
      localObject1 = paramc.cWb + "_dynamic.png";
      localObject2 = new File((String)localObject2);
      String str;
      if (((File)localObject2).exists())
      {
        if (!((File)localObject2).isDirectory()) {
          ((File)localObject2).delete();
        }
        localObject2 = new File((File)localObject2, (String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("InformationFaceAdapter", 2, "apng file name:" + ((File)localObject2).getAbsolutePath());
        }
        str = ((File)localObject2).getAbsolutePath();
        bool2 = false;
        bool1 = false;
        if (!((File)localObject2).exists()) {}
      }
      for (;;)
      {
        try
        {
          bool1 = ApngDrawable.isApngFile((File)localObject2);
          if (!bool1) {}
        }
        catch (IOException localIOException2)
        {
          label227:
          bool1 = bool2;
          continue;
          if (!paramBoolean) {
            continue;
          }
          continue;
        }
        try
        {
          localObject1 = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), ((File)localObject2).getAbsolutePath(), "-Dynamic-", aoop.TRANSPARENT, new int[] { 13 }, "-Dynamic-", null);
          if (localObject1 == null) {
            continue;
          }
          if (((URLDrawable)localObject1).getStatus() != 1) {
            ((URLDrawable)localObject1).restartDownload();
          }
          if (((URLDrawable)localObject1).getStatus() != 1) {
            continue;
          }
          paramb.onLoadSuccessed(paramURLImageView, (URLDrawable)localObject1);
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
      }
      paramURLImageView.setImageDrawable((Drawable)localObject1);
      for (;;)
      {
        if (!bool1)
        {
          paramURLImageView = new java.lang.ref.WeakReference(paramURLImageView);
          paramQIMCommonLoadingView = new java.lang.ref.WeakReference(paramQIMCommonLoadingView);
          paramProgressBar = new mqq.util.WeakReference(paramProgressBar);
          new java.lang.ref.WeakReference(paramaynh);
          paramaynh = paramc.thumbUrl;
          localObject1 = new aoll();
          ((aoll)localObject1).f = new aynl(this, (File)localObject2, paramQIMCommonLoadingView, paramURLImageView, str, paramBoolean, paramb, paramProgressBar);
          ((aoll)localObject1).bZ = paramaynh;
          if (QLog.isColorLevel()) {
            QLog.d("InformationFaceAdapter", 2, "apng url:" + paramaynh);
          }
          ((aoll)localObject1).mHttpMethod = 0;
          ((aoll)localObject1).atY = ((File)localObject2).getAbsolutePath();
          ((aoll)localObject1).mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
          ((aoll)localObject1).bw(paramc);
          ige.a().a((aomg)localObject1);
        }
        return;
        ((File)localObject2).mkdirs();
        break;
        localObject1 = null;
        break label227;
        if (QLog.isColorLevel()) {
          QLog.d("InformationFaceAdapter", 2, "apng invalid file:" + ((File)localObject2).getAbsolutePath());
        }
        ((File)localObject2).delete();
      }
    }
    
    private void buQ()
    {
      setOrientation(0);
      setGravity(17);
      int j = ayom.dip2px(getContext(), 12.0F);
      int k = (int)((this.mItemWidth - j * 2) * this.nr);
      int i = 0;
      if (i < this.mCount)
      {
        View localView = LayoutInflater.from(getContext()).inflate(2131561876, null);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemWidth);
        if (i == 0) {
          localLayoutParams.setMargins(0, j, j / 2, 0);
        }
        for (;;)
        {
          localView.setLayoutParams(localLayoutParams);
          ((ImageView)localView.findViewById(2131369259)).setPadding(k, k, k, k);
          addView(localView);
          i += 1;
          break;
          if (this.mCount - 1 == i) {
            localLayoutParams.setMargins(j / 2, j, 0, 0);
          } else {
            localLayoutParams.setMargins(j / 2, j, j / 2, 0);
          }
        }
      }
    }
    
    private void xB(int paramInt)
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = paramInt;
        if (i >= paramInt) {
          break;
        }
        j = paramInt;
        if (i >= getChildCount()) {
          break;
        }
        getChildAt(i).setVisibility(0);
        i += 1;
      }
      while ((j < this.mCount) && (j < getChildCount()))
      {
        getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    
    public void a(ayna paramayna, int paramInt1, int paramInt2, boolean paramBoolean)
      throws MalformedURLException
    {
      int i = paramInt1 * this.mCount;
      label31:
      Object localObject1;
      Object localObject2;
      URLImageView localURLImageView;
      ProgressBar localProgressBar;
      QIMCommonLoadingView localQIMCommonLoadingView;
      if (paramInt1 == paramInt2 - 1)
      {
        paramInt1 = paramayna.getFaceCount();
        xB(paramInt1 - i);
        paramInt2 = i;
        if (paramInt2 >= paramInt1) {
          return;
        }
        localObject1 = getChildAt(paramInt2 - i);
        localObject2 = ((View)localObject1).findViewById(2131369261);
        localURLImageView = (URLImageView)((View)localObject1).findViewById(2131369259);
        localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131369260);
        localQIMCommonLoadingView = (QIMCommonLoadingView)((View)localObject1).findViewById(2131369258);
        if (!(this.mContext instanceof EditPicActivity)) {
          break label154;
        }
        localObject1 = paramayna.hb(paramInt2);
        label112:
        if (localObject1 != null) {
          break label164;
        }
        ram.e("InformationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", new Object[] { paramayna.toString() });
      }
      for (;;)
      {
        paramInt2 += 1;
        break label31;
        paramInt1 = this.mCount + i;
        break;
        label154:
        localObject1 = paramayna.cc(paramInt2);
        break label112;
        label164:
        ((View)localObject2).setOnClickListener(this.mListener);
        localURLImageView.setTag(2131379225, Integer.valueOf(paramInt2));
        if (!paramBoolean)
        {
          localProgressBar.setVisibility(4);
          localURLImageView.setImageDrawable(null);
        }
        else
        {
          localURLImageView.setTag(2131379238, localObject1);
          localURLImageView.setTag(2131379203, Boolean.valueOf(false));
          localProgressBar.setVisibility(0);
          localObject2 = new InformationFaceAdapter.b((String)localObject1, localURLImageView, localProgressBar);
          localURLImageView.setURLDrawableDownListener((URLDrawableDownListener)localObject2);
          if ((this.mContext instanceof EditPicActivity))
          {
            localObject1 = a((ayna.c)paramayna.items.get(paramInt2));
            if (localObject1 != null)
            {
              if (((URLDrawable)localObject1).getStatus() != 1) {
                ((URLDrawable)localObject1).restartDownload();
              }
              if (((URLDrawable)localObject1).getStatus() == 1) {
                ((InformationFaceAdapter.b)localObject2).onLoadSuccessed(localURLImageView, (URLDrawable)localObject1);
              }
              if (paramBoolean) {}
              for (;;)
              {
                localURLImageView.setImageDrawable((Drawable)localObject1);
                break;
                localObject1 = null;
              }
            }
          }
          else
          {
            a((ayna.c)paramayna.items.get(paramInt2), localURLImageView, localQIMCommonLoadingView, localProgressBar, (InformationFaceAdapter.b)localObject2, paramBoolean, this.b);
          }
        }
      }
    }
  }
  
  class a
    implements axsz.a
  {
    private QIMCommonLoadingView b;
    private Boolean bc;
    private ImageView mImageView;
    
    a(QIMCommonLoadingView paramQIMCommonLoadingView, ImageView paramImageView)
    {
      this.b = paramQIMCommonLoadingView;
      this.mImageView = paramImageView;
      this.bc = ((Boolean)paramImageView.getTag(2131379203));
    }
    
    public void a(float paramFloat, String paramString, int paramInt)
    {
      paramInt = (int)paramFloat;
      this.b.post(new InformationFaceAdapter.DownloadProgressCallback.1(this, paramInt));
    }
    
    public void a(boolean paramBoolean, String paramString, ayna.c paramc)
    {
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceAdapter", 2, "isSucess:" + paramBoolean);
      }
      this.b.post(new InformationFaceAdapter.DownloadProgressCallback.2(this, paramBoolean, paramc));
    }
    
    public void onDestroy()
    {
      this.b = null;
      this.mImageView = null;
      this.bc = null;
    }
  }
  
  public static class b
    implements URLDrawableDownListener
  {
    private final java.lang.ref.WeakReference<ImageView> de;
    private final java.lang.ref.WeakReference<ProgressBar> df;
    private final String url;
    
    public b(@NonNull String paramString, @NonNull ImageView paramImageView, @NonNull ProgressBar paramProgressBar)
    {
      this.url = paramString;
      this.de = new java.lang.ref.WeakReference(paramImageView);
      this.df = new java.lang.ref.WeakReference(paramProgressBar);
    }
    
    private boolean b(ImageView paramImageView)
    {
      paramImageView = (String)paramImageView.getTag(2131379238);
      return (!TextUtils.isEmpty(paramImageView)) && (paramImageView.equals(this.url));
    }
    
    public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
    {
      ram.d("InformationFaceAdapter", "onLoadCanceled,url:" + this.url);
      paramView = (ImageView)this.de.get();
      paramURLDrawable = (ProgressBar)this.df.get();
      if ((paramView != null) && (paramURLDrawable != null) && (b(paramView)))
      {
        paramURLDrawable.setVisibility(4);
        paramView.setTag(2131379203, Boolean.valueOf(false));
        return;
      }
      ram.d("InformationFaceAdapter", "onLoadCanceled error.");
    }
    
    public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
    {
      ram.d("InformationFaceAdapter", "onLoadFialed,url:" + this.url);
      paramView = (ImageView)this.de.get();
      paramURLDrawable = (ProgressBar)this.df.get();
      if ((paramView != null) && (paramURLDrawable != null) && (b(paramView)))
      {
        paramURLDrawable.setVisibility(0);
        paramView.setTag(2131379203, Boolean.valueOf(false));
        return;
      }
      ram.d("InformationFaceAdapter", "onLoadFialed error.");
    }
    
    public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
    
    public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
    {
      ram.d("InformationFaceAdapter", "onLoadProgressed,url:" + this.url);
      paramView = (ImageView)this.de.get();
      paramURLDrawable = (ProgressBar)this.df.get();
      if ((paramView != null) && (paramURLDrawable != null) && (b(paramView)))
      {
        paramURLDrawable.setVisibility(0);
        paramView.setTag(2131379203, Boolean.valueOf(false));
        return;
      }
      ram.d("InformationFaceAdapter", "onLoadProgressed error.");
    }
    
    public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
    {
      ram.d("InformationFaceAdapter", "onLoadSuccessed,url:" + this.url);
      paramView = (ImageView)this.de.get();
      paramURLDrawable = (ProgressBar)this.df.get();
      if ((paramView != null) && (paramURLDrawable != null) && (b(paramView)))
      {
        paramURLDrawable.setVisibility(4);
        paramView.setTag(2131379203, Boolean.valueOf(true));
        return;
      }
      ram.d("InformationFaceAdapter", "onLoadSuccessed error.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter
 * JD-Core Version:    0.7.0.1
 */
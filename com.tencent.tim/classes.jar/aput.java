import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.a;
import com.tencent.mobileqq.troop.widget.AvatarGridAdapter.1;
import com.tencent.mobileqq.troop.widget.BorderURLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.util.WeakReference;

public class aput
  extends BaseAdapter
  implements aqdf.a
{
  public static String TAG = "AvatarGridAdapter";
  public boolean AA;
  protected List<zri> Ir = new ArrayList(8);
  protected boolean Yp;
  protected boolean cSq = true;
  protected boolean cSr;
  protected String crC;
  protected boolean czu;
  protected int dWE;
  protected int dWF;
  protected aqdf e;
  public GridView e;
  protected Handler handler = new Handler(Looper.getMainLooper());
  protected boolean isNightMode;
  protected WeakReference<Activity> mActivity;
  protected QQAppInterface mApp;
  protected int mColumnWidth;
  protected String mTroopUin;
  
  public aput(WeakReference<Activity> paramWeakReference, GridView paramGridView, QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    this.mActivity = paramWeakReference;
    this.jdField_e_of_type_ComTencentWidgetGridView = paramGridView;
    this.mApp = paramQQAppInterface;
    this.mTroopUin = paramString1;
    this.crC = paramString2;
    this.cSr = paramBoolean1;
    Si(paramBoolean2);
    if ((paramWeakReference == null) || (paramWeakReference.get() == null) || (paramQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
      }
      throw new NullPointerException("AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }
    paramString1 = (Activity)paramWeakReference.get();
    this.jdField_e_of_type_Aqdf = new aqdf(paramString1, paramQQAppInterface);
    this.jdField_e_of_type_Aqdf.a(this);
    paramString2 = paramString1.getResources();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramString1.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = paramString2.getDimensionPixelSize(2131298463);
    this.mColumnWidth = u((Activity)paramWeakReference.get());
    this.dWF = zti.fD(this.mColumnWidth);
    paramGridView.setColumnWidth(this.mColumnWidth);
    paramGridView.setVerticalSpacing(i);
    paramGridView.setHorizontalSpacing(i);
    paramGridView.setAdapter(this);
    this.isNightMode = ThemeUtil.isInNightMode(paramQQAppInterface);
  }
  
  public void Si(boolean paramBoolean)
  {
    this.AA = paramBoolean;
  }
  
  public void Xb(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (paramInt != this.jdField_e_of_type_ComTencentWidgetGridView.getNumColumns())
    {
      localLayoutParams = this.jdField_e_of_type_ComTencentWidgetGridView.getLayoutParams();
      localLayoutParams.width = (this.jdField_e_of_type_ComTencentWidgetGridView.getRequestedColumnWidth() * paramInt + (paramInt - 1) * this.jdField_e_of_type_ComTencentWidgetGridView.getVerticalSpacing() + this.jdField_e_of_type_ComTencentWidgetGridView.getPaddingLeft() + this.jdField_e_of_type_ComTencentWidgetGridView.getPaddingRight());
      localLayoutParams.height = -2;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        break label123;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(14);
      if (this.mActivity != null) {
        break label141;
      }
    }
    label141:
    for (Activity localActivity = null;; localActivity = (Activity)this.mActivity.get())
    {
      if ((localActivity == null) || (Thread.currentThread() == localActivity.getMainLooper().getThread())) {
        break label155;
      }
      localActivity.runOnUiThread(new AvatarGridAdapter.1(this, paramInt, localLayoutParams));
      return;
      label123:
      if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
        break;
      }
      ((LinearLayout.LayoutParams)localLayoutParams).gravity = 1;
      break;
    }
    label155:
    this.jdField_e_of_type_ComTencentWidgetGridView.setNumColumns(paramInt);
    this.jdField_e_of_type_ComTencentWidgetGridView.setLayoutParams(localLayoutParams);
  }
  
  public zri a(int paramInt)
  {
    if ((this.Ir != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (zri)this.Ir.get(paramInt);
    }
    return null;
  }
  
  protected void a(aput.a parama, Context paramContext, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    BorderURLImageView localBorderURLImageView = parama.a;
    localBorderURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramBoolean)
    {
      localBorderURLImageView.setBorderWidth(aqcx.dip2px(paramContext, 2.0F));
      localBorderURLImageView.setBorderColor(paramContext.getResources().getColor(2131166803));
      ImageView localImageView = parama.EK;
      localImageView.setVisibility(8);
      if (paramInt1 != 4) {
        break label135;
      }
      if (localBorderURLImageView.getDrawable() != null) {
        localBorderURLImageView.setImageDrawable(null);
      }
      paramContext = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
      parama = paramContext;
      if (paramContext == null) {
        parama = new FrameLayout.LayoutParams(this.mColumnWidth, this.dWF);
      }
      parama.gravity = 17;
      localImageView.setLayoutParams(parama);
      localImageView.setVisibility(0);
    }
    label135:
    do
    {
      do
      {
        do
        {
          return;
          localBorderURLImageView.setBorderWidth(0);
          break;
        } while (paramString == null);
        parama = zti.f(paramString);
      } while (parama == null);
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = aoop.TRANSPARENT;
      paramContext.mMemoryCacheKeySuffix = "thumb";
      parama = URLDrawable.getDrawable(parama, paramContext);
      paramContext = d(paramInt2);
      parama.setTag(aqbn.a(paramContext.left, paramContext.top, paramContext.width(), paramContext.height(), this.mColumnWidth, this.dWF));
      parama.setDecodeHandler(aqbn.x);
      if (this.isNightMode) {
        parama.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localBorderURLImageView.setImageDrawable(parama);
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, String.format("viewFactory: FROM_OTHERS, path=" + paramString, new Object[0]));
  }
  
  public void c(zri paramzri, TroopUploadingThread.a parama)
  {
    int i = 0;
    if (i < this.jdField_e_of_type_ComTencentWidgetGridView.getChildCount())
    {
      Object localObject = this.jdField_e_of_type_ComTencentWidgetGridView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof aput.a)))
      {
        localObject = (aput.a)localObject;
        if (((aput.a)localObject).f.equals(paramzri))
        {
          if (paramzri.isUploading) {
            break label82;
          }
          ((aput.a)localObject).an.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        ((aput.a)localObject).an.setProgress(parama.result);
      }
    }
  }
  
  public Rect d(int paramInt)
  {
    zri localzri = a(paramInt);
    Rect localRect = new Rect();
    if (localzri != null) {
      zti.a(localRect, localzri.clipInfo);
    }
    return localRect;
  }
  
  protected void ebU()
  {
    if ((this.AA) && (this.Ir.size() >= 0) && (this.Ir.size() < 7))
    {
      zri localzri = new zri();
      localzri.fromType = 4;
      this.Ir.add(localzri);
    }
  }
  
  public int getCount()
  {
    int j = 4;
    if (this.Ir != null) {}
    for (int i = this.Ir.size();; i = 0)
    {
      if (i < 4) {
        j = i;
      }
      Xb(j);
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    if (this.mActivity != null) {}
    for (Object localObject1 = (Activity)this.mActivity.get();; localObject1 = null)
    {
      View localView = paramView;
      if (paramView == null)
      {
        if (localObject1 == null)
        {
          localView = paramView;
          localObject1 = paramView;
          paramView = localView;
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localObject1;
        }
        localView = LayoutInflater.from((Context)localObject1).inflate(2131560062, null);
      }
      zri localzri = a(paramInt);
      int i;
      label102:
      aput.a locala2;
      if (localzri != null)
      {
        i = localzri.fromType;
        if (i != 4) {
          break label447;
        }
        paramView = (View)localObject2;
        if (localView.getTag() != null) {
          break label614;
        }
        locala2 = new aput.a();
        locala2.EK = ((ImageView)localView.findViewById(2131362164));
        locala2.an = ((ProgressBar)localView.findViewById(2131368926));
        if (localObject1 == null) {}
      }
      for (;;)
      {
        try
        {
          locala2.an.setProgressDrawable(((Activity)localObject1).getResources().getDrawable(2130844486));
          locala2.a = ((BorderURLImageView)localView.findViewById(2131368846));
          localObject2 = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (localObject2 == null)
          {
            localObject2 = new AbsListView.LayoutParams(this.mColumnWidth, this.dWF);
            locala2.f = localzri;
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localView.setTag(locala2);
            localObject2 = locala2;
            if (localObject1 != null)
            {
              localView.setContentDescription(acfp.m(2131702983) + paramInt);
              if (i == 4) {
                localView.setContentDescription(acfp.m(2131702982));
              }
              a((aput.a)localObject2, (Context)localObject1, i, paramView, paramInt, localzri.isSelected);
            }
            paramView = ((aput.a)localObject2).an;
            if (!localzri.isUploading) {
              break label634;
            }
            if (paramView.getVisibility() != 0) {
              paramView.setVisibility(0);
            }
            paramView.setProgress(localzri.progress);
            paramView.setProgress(100);
            if (!localzri.aYK) {
              break label643;
            }
            if (((aput.a)localObject2).IP == null)
            {
              ((aput.a)localObject2).IP = ((ViewStub)localView.findViewById(2131381497)).inflate();
              localView.setTag(localObject2);
            }
            ((aput.a)localObject2).IP.setVisibility(0);
            if ((!this.czu) || (paramInt != this.dWE) || (this.cSq)) {
              break label664;
            }
            localView.setVisibility(8);
            paramView = localView;
            localObject1 = localView;
            break;
            label447:
            if ((i == 1) && ((localzri.baE == null) || (!new File(localzri.baE).exists())))
            {
              paramView = apqw.oL(apqw.p(localzri.baF, this.mTroopUin, 1));
              break label102;
            }
            if ((i == 2) || ((localzri.baE != null) && (new File(localzri.baE).exists())))
            {
              paramView = localzri.baE;
              break label102;
            }
            paramView = (View)localObject2;
            if (i != 3) {
              break label102;
            }
            paramView = apqw.oL(apqw.p(localzri.baF, this.mTroopUin, 0));
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(TAG, 2, localOutOfMemoryError, new Object[0]);
          continue;
          localOutOfMemoryError.height = this.dWF;
          localOutOfMemoryError.width = this.mColumnWidth;
          continue;
        }
        label614:
        aput.a locala1 = (aput.a)localView.getTag();
        locala1.f = localzri;
        continue;
        label634:
        paramView.setVisibility(8);
        continue;
        label643:
        if (locala1.IP != null)
        {
          locala1.IP.setVisibility(8);
          continue;
          label664:
          localView.setVisibility(0);
        }
      }
    }
  }
  
  public void mU(List<zri> paramList)
  {
    if (this.Yp) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, String.format("updateDataSet %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.Ir.clear();
    this.Ir.addAll(paramList);
    ebU();
    notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
  
  public int u(Activity paramActivity)
  {
    int i = paramActivity.getResources().getDimensionPixelSize(2131298463);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (localDisplayMetrics.widthPixels - ((Activity)this.mActivity.get()).getResources().getDimensionPixelSize(2131298466) * 2 - i * 3) / 4;
  }
  
  public class a
  {
    ImageView EK;
    View IP;
    BorderURLImageView a;
    ProgressBar an;
    zri f;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aput
 * JD-Core Version:    0.7.0.1
 */
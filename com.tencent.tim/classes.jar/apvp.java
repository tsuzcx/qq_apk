import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.a;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class apvp
  extends BaseAdapter
  implements aqdf.a
{
  Setting a;
  Gallery b;
  boolean cOC = true;
  boolean cSJ = false;
  boolean cSL = false;
  boolean cSy = true;
  String crH = null;
  boolean cvT = false;
  protected int dXu;
  protected int dXv;
  protected int dXw;
  protected int dXx;
  protected aqdf e;
  protected boolean isNightMode;
  QQAppInterface mApp;
  Context mContext;
  protected List<zri> mList = new ArrayList(7);
  int mMinSize;
  String mTroopUin;
  
  public apvp(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, Gallery paramGallery)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mTroopUin = paramString;
    this.b = paramGallery;
    this.mMinSize = ((int)paramContext.getResources().getDimension(2131297899));
    this.dXu = paramInt1;
    this.dXv = paramInt2;
    this.e = new aqdf(paramContext, paramQQAppInterface);
    this.e.a(this);
    this.isNightMode = ThemeUtil.isInNightMode(paramQQAppInterface);
  }
  
  public void So(boolean paramBoolean)
  {
    this.cSy = paramBoolean;
  }
  
  public void Sp(boolean paramBoolean)
  {
    this.cSJ = paramBoolean;
  }
  
  public void Sr(boolean paramBoolean)
  {
    this.cOC = paramBoolean;
  }
  
  public void Ua(String paramString)
  {
    this.crH = paramString;
  }
  
  public zri a(int paramInt)
  {
    if ((this.mList != null) && (paramInt < getCount())) {
      return (zri)this.mList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, apvp.a parama)
  {
    if ((parama == null) || (this.mApp == null)) {}
    URLImageView localURLImageView;
    ImageProgressCircle localImageProgressCircle;
    Rect localRect;
    do
    {
      do
      {
        do
        {
          return;
          localURLImageView = parama.I;
          localImageProgressCircle = parama.c;
          parama = fT(paramInt);
          localRect = d(paramInt);
          if (QLog.isColorLevel()) {
            QLog.i("TroopAvatarWallGalleryAdapter", 2, "loadBigImage loadThumbImage() path = " + parama);
          }
        } while (TextUtils.isEmpty(parama));
        parama = zti.f(parama);
      } while (parama == null);
      localObject = a(paramInt);
    } while (localObject == null);
    Object localObject = ((zri)localObject).baF;
    if (((this.a == null) || (this.a.bHeadType == 0)) && (zri.baD.equals(localObject)) && (!this.cSL))
    {
      this.cSL = true;
      if (!this.e.isPausing()) {
        this.e.i(this.mTroopUin, 4, true);
      }
    }
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
    if ((this.cvT) && (this.cOC))
    {
      parama = URLDrawable.getDrawable(parama, (URLDrawable.URLDrawableOptions)localObject);
      parama.setTag(aqbn.a(localRect.left, localRect.top, localRect.width(), localRect.height(), this.dXu, this.dXv));
      parama.setDecodeHandler(aqbn.x);
    }
    for (;;)
    {
      if (this.isNightMode) {
        parama.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localURLImageView.setImageDrawable(parama);
      if (parama.getStatus() == 1) {
        break;
      }
      if (localImageProgressCircle.getVisibility() != 0) {
        localImageProgressCircle.setVisibility(0);
      }
      localImageProgressCircle.setProgress(0);
      localURLImageView.setURLDrawableDownListener(new apvq(this, localImageProgressCircle, localURLImageView));
      return;
      if (!this.cOC)
      {
        parama = URLDrawable.getDrawable(parama, (URLDrawable.URLDrawableOptions)localObject);
        paramInt = Math.min(this.dXw, this.dXx);
        if (anlm.ayn())
        {
          parama.setDecodeHandler(aqbn.a);
          parama.setTag(new int[] { paramInt, paramInt, (int)(paramInt * aqhu.AE) });
        }
        for (;;)
        {
          localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          break;
          parama.setTag(aqbn.e(paramInt, paramInt));
          parama.setDecodeHandler(aqbn.c);
        }
      }
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.dXu;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.dXv;
      parama = URLDrawable.getDrawable(parama, (URLDrawable.URLDrawableOptions)localObject);
      parama.setDecodeHandler(null);
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    a(localImageProgressCircle);
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public void c(Setting paramSetting)
  {
    this.a = paramSetting;
    notifyDataSetChanged();
  }
  
  public void c(zri paramzri, TroopUploadingThread.a parama)
  {
    int i = 0;
    if (i < this.b.getChildCount())
    {
      Object localObject = this.b.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof aput.a)))
      {
        localObject = (apvp.a)localObject;
        if (((apvp.a)localObject).f.equals(paramzri))
        {
          if (paramzri.isUploading) {
            break label82;
          }
          ((apvp.a)localObject).c.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        ((apvp.a)localObject).c.setProgress(parama.result);
      }
    }
  }
  
  public void ce(boolean paramBoolean)
  {
    this.cvT = paramBoolean;
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
  
  public String fT(int paramInt)
  {
    zri localzri = a(paramInt);
    if (localzri == null) {}
    String str;
    do
    {
      return null;
      str = localzri.baF;
    } while ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(localzri.baE)));
    if (this.cSJ) {}
    for (;;)
    {
      return str;
      if ((localzri.fromType == 1) && ((localzri.baE == null) || (!new File(localzri.baE).exists()))) {
        str = apqw.oL(apqw.p(localzri.baF, this.mTroopUin, 1));
      } else if ((localzri.fromType == 2) || ((localzri.baE != null) && (new File(localzri.baE).exists()))) {
        str = localzri.baE;
      } else if (localzri.fromType == 3) {
        str = apqw.oL(apqw.p(localzri.baF, this.mTroopUin, 0));
      } else {
        str = null;
      }
    }
  }
  
  public int getCount()
  {
    if (this.mList != null) {
      return this.mList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563244, null);
      paramView = new apvp.a();
      paramView.I = ((URLImageView)localView.findViewById(2131368820));
      paramView.I.setLayoutParams(new RelativeLayout.LayoutParams(this.dXu, this.dXv));
      paramView.c = ((ImageProgressCircle)localView.findViewById(2131368926));
      localView.setTag(paramView);
    }
    for (;;)
    {
      a(paramInt, paramView);
      paramView.f = a(paramInt);
      paramView.I.setContentDescription(acfp.m(2131715565) + (paramInt + 1));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      apvp.a locala = (apvp.a)paramView.getTag();
      localView = paramView;
      paramView = locala;
    }
  }
  
  public void ke(int paramInt1, int paramInt2)
  {
    this.dXw = paramInt1;
    this.dXx = paramInt2;
  }
  
  public void mU(List<zri> paramList)
  {
    if (zri.i(paramList, this.mList))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("setAvatarList equal return", new Object[0]));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("setAvatarList %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.mList.clear();
    this.mList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
  
  public void onDestroy()
  {
    this.e.destory();
  }
  
  public class a
  {
    URLImageView I;
    ImageProgressCircle c;
    zri f;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apvp
 * JD-Core Version:    0.7.0.1
 */
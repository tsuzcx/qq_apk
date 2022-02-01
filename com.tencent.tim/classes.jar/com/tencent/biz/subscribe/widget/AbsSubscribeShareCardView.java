package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ankt;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import san;
import sio;

public abstract class AbsSubscribeShareCardView
  extends FrameLayout
{
  public static final int bwS = ankt.dip2px(311.0F);
  public static final int bwT = ankt.dip2px(415.0F);
  public static final int bwU = ankt.dip2px(375.0F);
  public static final int bwV = ankt.dip2px(701.0F);
  public static final int bwW = ankt.dip2px(667.0F);
  protected san b;
  protected Bitmap dc;
  protected View mContainerView;
  private volatile int mSuccessCount;
  protected ArrayList<String> nZ = new ArrayList();
  protected ArrayList<ImageView> oa = new ArrayList();
  public float oi = 1.333333F;
  protected View pZ;
  
  public AbsSubscribeShareCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AbsSubscribeShareCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbsSubscribeShareCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    this.mContainerView = LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    u(this.mContainerView);
  }
  
  public void a(FrameLayout paramFrameLayout, int paramInt1, int paramInt2)
  {
    int i = bwW;
    if (b() != null)
    {
      if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != paramInt2)) {
        break label140;
      }
      paramInt2 = bwS;
      paramInt1 = bwS;
    }
    for (;;)
    {
      b().getLayoutParams().width = paramInt2;
      b().getLayoutParams().height = paramInt1;
      b().setLayoutParams(b().getLayoutParams());
      if (paramFrameLayout != null)
      {
        paramFrameLayout.getLayoutParams().width = paramInt2;
        paramFrameLayout.getLayoutParams().height = (i - ankt.dip2px(168.0F));
        paramFrameLayout.setLayoutParams(paramFrameLayout.getLayoutParams());
      }
      this.pZ.getLayoutParams().height = i;
      measure(bwU, i);
      layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      return;
      label140:
      if (paramInt1 > paramInt2)
      {
        paramInt2 = bwS;
        paramInt1 = (int)(paramInt2 / this.oi);
      }
      else
      {
        i = bwV;
        paramInt2 = bwS;
        paramInt1 = Math.min((int)(paramInt2 * this.oi), bwT);
      }
    }
  }
  
  protected void a(ArrayList<String> paramArrayList, ArrayList<ImageView> paramArrayList1, a parama)
  {
    int i = 0;
    if ((paramArrayList != null) && (paramArrayList.size() == paramArrayList1.size()))
    {
      this.mSuccessCount = 0;
      if (i < paramArrayList.size())
      {
        String str = sio.aEk + Md5Utils.getMD5((String)paramArrayList.get(i)) + ".png";
        if (new File(str).exists())
        {
          ((ImageView)paramArrayList1.get(i)).setImageBitmap(SafeBitmapFactory.decodeFile(str));
          this.mSuccessCount += 1;
          if (this.mSuccessCount == paramArrayList.size()) {
            ThreadManager.getUIHandler().post(new AbsSubscribeShareCardView.1(this, parama));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ThreadManagerV2.executeOnFileThread(new AbsSubscribeShareCardView.2(this, paramArrayList1, i, str, paramArrayList, parama));
        }
      }
    }
  }
  
  public void a(san paramsan, Bitmap paramBitmap, a parama)
  {
    this.b = paramsan;
    this.dc = paramBitmap;
    measure(bwU, bwW);
    layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
  }
  
  public Bitmap ab()
  {
    try
    {
      if (this.pZ != null)
      {
        Bitmap localBitmap = Bitmap.createBitmap(this.pZ.getLayoutParams().width, this.pZ.getLayoutParams().height, Bitmap.Config.RGB_565);
        this.pZ.draw(new Canvas(localBitmap));
        return localBitmap;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("AbsSubscribeShareCardView", 4, "failed to get bitmap from view");
      return null;
    }
    return null;
  }
  
  protected abstract URLImageView b();
  
  public void byO() {}
  
  public abstract int getLayoutId();
  
  public abstract void u(View paramView);
  
  public static abstract class a
    implements URLDrawable.URLDrawableListener
  {
    public void onLoadCanceled(URLDrawable paramURLDrawable) {}
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
    
    public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
 * JD-Core Version:    0.7.0.1
 */
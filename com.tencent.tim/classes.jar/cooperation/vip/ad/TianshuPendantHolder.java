package cooperation.vip.ad;

import adud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import ankt;
import aoop;
import aqqx;
import awkm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.c;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;
import wja;

public class TianshuPendantHolder
  extends adud
  implements ARMapHongBaoListView.c
{
  public static float DB = 112.0F;
  private AnimationDrawableProxyView a;
  private TianShuAccess.AdItem b;
  private Rect df;
  private Rect dg;
  private Drawable gW;
  private QQAppInterface mApp;
  private String mJumpUrl;
  
  public TianshuPendantHolder(QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramView);
    this.mApp = paramQQAppInterface;
    if (this.gW == null) {
      this.gW = this.mContext.getResources().getDrawable(2130838429);
    }
  }
  
  private void eEd()
  {
    awkm.b(this.mApp, this.mContext, this.mJumpUrl, 4004);
    if ((this.mParentView != null) && ((this.mParentView instanceof ARMapHongBaoListView)))
    {
      ((ARMapHongBaoListView)this.mParentView).setPendantHolder(null);
      ((ARMapHongBaoListView)this.mParentView).setOnPendentClickListener(null);
    }
    if ((this.mApp != null) && (this.b != null)) {
      awkm.d(this.mApp, 102, String.valueOf(this.b.iAdId.get()), this.b.traceinfo.get());
    }
  }
  
  private void onCloseClick()
  {
    if ((this.mParentView != null) && ((this.mParentView instanceof ARMapHongBaoListView))) {
      ((ARMapHongBaoListView)this.mParentView).setPendantHolder(null);
    }
    if ((this.mApp != null) && (this.b != null)) {
      awkm.d(this.mApp, 122, String.valueOf(this.b.iAdId.get()), this.b.traceinfo.get());
    }
  }
  
  private void reset()
  {
    try
    {
      this.drawable = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  public void Lw(int paramInt)
  {
    super.Lw(paramInt);
  }
  
  public RectF a(int paramInt)
  {
    float f = -wja.dp2px(20.0F, this.mParentView.getResources());
    this.ax.set(this.x - f, this.y - f - paramInt, this.x + this.width + f, f + (this.y + this.height) - paramInt);
    return this.ax;
  }
  
  public void aM(Canvas paramCanvas) {}
  
  public void aN(Canvas paramCanvas)
  {
    super.aN(paramCanvas);
    if (this.gW != null)
    {
      paramCanvas.save();
      this.gW.setBounds(this.df);
      this.gW.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public void aa(float paramFloat1, float paramFloat2)
  {
    if ((this.dg != null) && (this.dg.contains((int)paramFloat1, (int)paramFloat2)))
    {
      onCloseClick();
      return;
    }
    eEd();
  }
  
  public void cUo()
  {
    try
    {
      int j = this.mParentView.getWidth();
      int i = j;
      if (j == 0) {
        i = ankt.SCREEN_WIDTH;
      }
      j = wja.dp2px(160.0F, this.mParentView.getResources());
      a(i - j - 0, 0, j, wja.dp2px(DB, this.mParentView.getResources()), this.mParentView);
      this.df = new Rect(this.x + j - wja.dp2px(23.0F, this.mParentView.getResources()), this.y + wja.dp2px(22.0F, this.mParentView.getResources()), this.x + j - wja.dp2px(8.0F, this.mParentView.getResources()), this.y + wja.dp2px(37.0F, this.mParentView.getResources()));
      this.dg = new Rect(this.x + j - wja.dp2px(23.0F, this.mParentView.getResources()), this.y, j + this.x, this.y + wja.dp2px(37.0F, this.mParentView.getResources()));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  public void e(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null) {
      QLog.e("TianshuPendantHolder", 2, "showLayer with null ");
    }
    do
    {
      do
      {
        return;
        this.b = paramAdItem;
        this.mJumpUrl = null;
        Object localObject = paramAdItem.argList.get().iterator();
        paramAdItem = null;
        if (((Iterator)localObject).hasNext())
        {
          TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)((Iterator)localObject).next();
          if (localMapEntry.key.get().equals("image")) {
            paramAdItem = localMapEntry.value.get();
          }
          for (;;)
          {
            break;
            if (localMapEntry.key.get().equals("url")) {
              this.mJumpUrl = localMapEntry.value.get();
            }
          }
        }
        if ((TextUtils.isEmpty(paramAdItem)) || (TextUtils.isEmpty(this.mJumpUrl))) {
          break;
        }
        localObject = aoop.TRANSPARENT;
        this.drawable = aqqx.a(paramAdItem, new int[] { 2 }, (Drawable)localObject, null, null);
      } while (this.drawable == null);
      this.a = new AnimationDrawableProxyView(this.mContext, this.mParentView, this.drawable);
    } while ((this.mApp == null) || (this.b == null));
    awkm.d(this.mApp, 101, String.valueOf(this.b.iAdId.get()), this.b.traceinfo.get());
    return;
    QLog.e("TianshuPendantHolder", 1, "setpendantres error with image url " + paramAdItem + " jumpUrl " + this.mJumpUrl);
  }
  
  public void stopAnimation()
  {
    try
    {
      reset();
      if (QLog.isColorLevel()) {
        QLog.i("TianshuPendantHolder", 2, "stopAnimation...");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TianshuPendantHolder", 1, localThrowable, new Object[0]);
    }
  }
  
  class AnimationDrawableProxyView
    extends View
  {
    private View mDelegateView;
    
    public AnimationDrawableProxyView(Context paramContext, View paramView, Drawable paramDrawable)
    {
      super();
      this.mDelegateView = paramView;
      setBackgroundDrawable(paramDrawable);
    }
    
    public void invalidateDrawable(Drawable paramDrawable)
    {
      this.mDelegateView.invalidate();
    }
    
    public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      long l = SystemClock.uptimeMillis();
      this.mDelegateView.postDelayed(paramRunnable, paramLong - l);
    }
    
    public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      this.mDelegateView.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuPendantHolder
 * JD-Core Version:    0.7.0.1
 */
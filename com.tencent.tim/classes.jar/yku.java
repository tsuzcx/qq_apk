import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class yku
  extends BaseAdapter
  implements View.OnClickListener, HorizontalListView.e
{
  public static int bZH = 6;
  private long Kh;
  public long Ki;
  public String aYu;
  private int adw;
  private int adx;
  public int bZI;
  private float density;
  private ColorDrawable i = new ColorDrawable();
  private int imgHeight;
  private int imgWidth;
  private int itemPadding;
  public List<ykv> jl;
  private BaseActivity mActivity;
  private QQAppInterface mApp;
  private Context mContext;
  private SessionInfo mSessionInfo;
  public MqqHandler q;
  public List<ykv> sL;
  
  public yku(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mActivity = paramBaseActivity;
    this.mSessionInfo = paramSessionInfo;
    this.q = paramMqqHandler;
    this.Ki = System.currentTimeMillis();
    this.jl = new ArrayList();
    this.sL = new ArrayList();
    int j = 0;
    while (j < bZH)
    {
      this.sL.add(new ykv());
      j += 1;
    }
    this.jl.addAll(this.sL);
    this.density = this.mContext.getResources().getDisplayMetrics().density;
    this.adw = wja.dp2px(85.0F, this.mContext.getResources());
    this.adx = wja.dp2px(85.0F, this.mContext.getResources());
    this.imgWidth = wja.dp2px(80.0F, this.mContext.getResources());
    this.imgHeight = wja.dp2px(80.0F, this.mContext.getResources());
    this.itemPadding = wja.dp2px(2.5F, this.mContext.getResources());
  }
  
  public ykv a(int paramInt)
  {
    if (paramInt < this.jl.size()) {
      return (ykv)this.jl.get(paramInt);
    }
    return null;
  }
  
  public void bt(int paramInt, String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ZhituManager", 2, "ZhituPicAdapter setPicItemCount: picCount = ,mReqKey = " + paramString + ",this.mReqKey =" + this.aYu);
    }
    if (TextUtils.isEmpty(paramString)) {}
    while (paramInt <= 0) {
      return;
    }
    if (!paramString.equals(this.aYu))
    {
      this.jl.clear();
      anot.a(this.mApp, "dc00898", "", "", "0X8008C71", "0X8008C71", ykm.fq(ykm.a(this.mApp).getCurType()), 0, "", "", "", "");
    }
    this.aYu = paramString;
    while (j < paramInt)
    {
      this.jl.add(new ykv());
      j += 1;
    }
    this.bZI = -1;
    notifyDataSetChanged();
  }
  
  public void cja()
  {
    int j = this.jl.size();
    if (TextUtils.isEmpty(((ykv)this.jl.get(j - 1)).aYv)) {}
    while (j <= this.bZI) {
      return;
    }
    this.bZI = j;
    ykm.a(this.mApp).bs(this.jl.size(), this.aYu);
  }
  
  public void fG(View paramView) {}
  
  public void fH(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof yku.a)))
    {
      paramView = (yku.a)paramView.getTag();
      if (paramView.n != null) {
        paramView.n.setImageDrawable(null);
      }
    }
  }
  
  public int getCount()
  {
    return this.jl.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= getCount())
    {
      QLog.e("ZhituManager", 2, "get view position exception , position = " + paramInt + ",size = " + this.jl.size());
      localObject1 = paramView;
    }
    ykv localykv;
    for (paramView = null;; paramView = (View)localObject2)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localykv = a(paramInt);
      if (localykv != null) {
        break;
      }
      QLog.e("ZhituManager", 1, "getView emoticon empty position = " + paramInt);
      localObject2 = null;
      localObject1 = paramView;
    }
    label375:
    Object localObject3;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject1 = new yku.a(null);
      ((yku.a)localObject1).hA = new RelativeLayout(this.mContext);
      paramView = new ViewGroup.LayoutParams(-2, this.adx);
      ((yku.a)localObject1).hA.setLayoutParams(paramView);
      ((yku.a)localObject1).n = new BubbleImageView(this.mContext);
      ((yku.a)localObject1).n.TE(false);
      ((yku.a)localObject1).n.setRadius(5.0F);
      ((yku.a)localObject1).n.bgJ = false;
      ((yku.a)localObject1).n.setScaleType(ImageView.ScaleType.FIT_XY);
      paramView = new RelativeLayout.LayoutParams(-2, this.imgHeight);
      paramView.addRule(13, -1);
      ((yku.a)localObject1).hA.addView(((yku.a)localObject1).n, paramView);
      ((yku.a)localObject1).progressBar = new ProgressBar(this.mContext);
      ((yku.a)localObject1).progressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(2130839651));
      paramView = new RelativeLayout.LayoutParams((int)(this.density * 30.0F), (int)(this.density * 30.0F));
      paramView.addRule(13, -1);
      ((yku.a)localObject1).hA.addView(((yku.a)localObject1).progressBar, paramView);
      paramView = ((yku.a)localObject1).hA;
      paramView.setTag(localObject1);
      paramView.setOnClickListener(this);
      ((yku.a)localObject1).ez = new WeakReference(localykv);
      ((yku.a)localObject1).progressBar.setVisibility(0);
      if (!localykv.bnc) {
        break label893;
      }
      String str = ykm.a(this.mApp).b(localykv);
      localObject3 = ykm.a(str);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        ykm.a(this.mApp).e(localykv);
        localObject2 = localObject3;
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, "get gif image from cache fail, " + str);
        }
      }
    }
    label602:
    label886:
    label893:
    for (Object localObject2 = localObject3;; localObject2 = null)
    {
      if ((localykv.drawable != null) || (localObject2 != null))
      {
        ((yku.a)localObject1).hA.setMinimumWidth(0);
        localObject3 = localykv.drawable;
        ((yku.a)localObject1).n.setTag(localykv.url + localykv.pic_md5);
        if (localObject2 == null) {
          break label886;
        }
      }
      for (localObject2 = new GifDrawable((AbstractGifImage)localObject2);; localObject2 = localObject3)
      {
        int j = ((Drawable)localObject2).getIntrinsicWidth();
        int k = ((Drawable)localObject2).getIntrinsicHeight();
        if (k == this.imgHeight)
        {
          ((yku.a)localObject1).n.setScaleType(ImageView.ScaleType.CENTER);
          ((yku.a)localObject1).n.getLayoutParams().width = j;
          ((yku.a)localObject1).n.setImageDrawable((Drawable)localObject2);
          ((yku.a)localObject1).n.setBackgroundDrawable(null);
          ((yku.a)localObject1).progressBar.setVisibility(8);
          if (paramInt != 0) {
            break label845;
          }
          ((yku.a)localObject1).hA.getLayoutParams().width = (this.itemPadding + j);
          ((yku.a)localObject1).hA.setPadding(0, 0, this.itemPadding, 0);
        }
        for (;;)
        {
          if ((localykv.a != null) && (!localykv.a.isReported))
          {
            ykm.a(this.mApp).c(localykv);
            localykv.a.isReported = true;
          }
          localObject1 = paramView;
          break;
          localObject1 = (yku.a)paramView.getTag();
          break label375;
          if (k > this.imgHeight)
          {
            j = j * this.imgHeight / k;
            ((yku.a)localObject1).n.setScaleType(ImageView.ScaleType.FIT_CENTER);
            break label602;
          }
          j = j * this.imgWidth / k;
          ((yku.a)localObject1).n.setScaleType(ImageView.ScaleType.FIT_XY);
          break label602;
          ((yku.a)localObject1).n.setImageDrawable(this.i);
          ((yku.a)localObject1).n.getLayoutParams().width = this.adw;
          j = this.adw;
          ((yku.a)localObject1).progressBar.setVisibility(0);
          break label644;
          ((yku.a)localObject1).hA.getLayoutParams().width = (this.itemPadding * 2 + j);
          ((yku.a)localObject1).hA.setPadding(this.itemPadding, 0, this.itemPadding, 0);
        }
      }
    }
  }
  
  public void j(ykv paramykv)
  {
    if (paramykv != null)
    {
      int j = paramykv.bZJ;
      if ((j >= 0) && (j < this.jl.size())) {
        ((ykv)this.jl.get(j)).k(paramykv);
      }
      notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.Kh < 200L) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "filter multi click");
      }
    }
    label175:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.Kh = l;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof yku.a))) {}
      for (localObject = (yku.a)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label175;
        }
        localObject = (ykv)((yku.a)localObject).ez.get();
        if ((localObject == null) || (((ykv)localObject).url == null) || (((ykv)localObject).a == null)) {
          break;
        }
        ThreadManager.post(new ZhituPicAdapter.1(this, (ykv)localObject), 8, null, false);
        ykm.a(this.mApp).b((ykv)localObject);
        if (this.q == null) {
          break;
        }
        localObject = this.q.obtainMessage(84);
        ((Message)localObject).arg1 = 1;
        ((Message)localObject).sendToTarget();
        break;
      }
    }
  }
  
  public void resetData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "[ZhituPicAdapter]-resetData");
    }
    this.jl.clear();
    this.jl.addAll(this.sL);
    this.aYu = "";
    this.bZI = -1;
    notifyDataSetChanged();
  }
  
  static class a
  {
    WeakReference<ykv> ez;
    RelativeLayout hA;
    BubbleImageView n;
    ProgressBar progressBar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yku
 * JD-Core Version:    0.7.0.1
 */
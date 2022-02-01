import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ajpu
{
  public List<ilive_feeds_near_anchor.NearAnchorInfo> Dv;
  protected int OE;
  public int dkn;
  protected Drawable eX;
  protected GradientDrawable h;
  protected LinearLayout mContainer;
  protected Context mContext;
  public Handler mHandler;
  protected View.OnClickListener mOnClickListener = new ajpw(this);
  protected AdapterView.OnItemClickListener mOnItemClickListener;
  Runnable runnable = new NearbyFragmentEnterAdapter.1(this);
  protected ArrayList<ajpu.a> xW = new ArrayList();
  protected float xx;
  
  public ajpu(Context paramContext, LinearLayout paramLinearLayout)
  {
    this.mContainer = paramLinearLayout;
    this.mContext = paramContext;
    this.xx = ((float)(aqgz.hK() * 2L / 9L));
    this.mHandler = new Handler(Looper.getMainLooper());
    this.OE = ((int)(this.xx - aqcx.dip2px(this.mContext, 20.0F)));
    int i = aqcx.dip2px(this.mContext, 80.0F);
    if (this.OE > i) {
      this.OE = i;
    }
    this.eX = this.mContext.getResources().getDrawable(2130840647);
    this.h = new GradientDrawable();
    this.h.setColor(Color.parseColor("#FFDDDFE2"));
    this.h.setCornerRadius(this.OE / 2);
    this.h.setShape(0);
    this.h.setSize(this.OE, this.OE);
  }
  
  public ajpu.b a()
  {
    int i = 0;
    while (i < this.mContainer.getChildCount())
    {
      View localView = this.mContainer.getChildAt(i);
      if ((localView != null) && (((Integer)localView.getTag(2131379178)).intValue() == 1)) {
        return (ajpu.b)localView.getTag();
      }
      i += 1;
    }
    return null;
  }
  
  public ilive_feeds_near_anchor.NearAnchorInfo a()
  {
    if (this.Dv != null) {
      return (ilive_feeds_near_anchor.NearAnchorInfo)this.Dv.get(this.dkn);
    }
    return null;
  }
  
  @RequiresApi(api=11)
  public void a(ajpu.b paramb, ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.eX;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.eX;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.OE;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.OE;
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearby_fragment_live_avatar";
    paramNearAnchorInfo = URLDrawable.getDrawable(paramNearAnchorInfo.cover_url.get().toStringUtf8(), (URLDrawable.URLDrawableOptions)localObject);
    paramNearAnchorInfo.setTag(aqbn.e(this.OE, this.OE));
    paramNearAnchorInfo.setDecodeHandler(aqbn.b);
    if (this.Dv.size() != 1)
    {
      localObject = ObjectAnimator.ofFloat(paramb.bp, "alpha", new float[] { 1.0F, 0.2F });
      ((ObjectAnimator)localObject).setInterpolator(new AccelerateInterpolator());
      ((ObjectAnimator)localObject).addListener(new ajpv(this, paramb, paramNearAnchorInfo));
      ((ObjectAnimator)localObject).setDuration(300L).start();
      return;
    }
    paramb.bp.setImageDrawable(paramNearAnchorInfo);
  }
  
  public void d(NearbyAppInterface paramNearbyAppInterface)
  {
    ajvd localajvd = paramNearbyAppInterface.a();
    if (localajvd == null) {
      return;
    }
    int i = 0;
    label14:
    Object localObject2;
    boolean bool1;
    boolean bool2;
    if (i < this.mContainer.getChildCount())
    {
      localObject2 = this.mContainer.getChildAt(i);
      if ((localObject2 != null) && (((View)localObject2).getTag() != null))
      {
        ajpu.b localb = (ajpu.b)((View)localObject2).getTag();
        Object localObject1 = (Integer)((View)localObject2).getTag(2131377002);
        localObject2 = (Integer)((View)localObject2).getTag(2131379178);
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject1 = localajvd.a(((Integer)localObject1).intValue());
          bool1 = localb.redTouch.aux();
          localb.redTouch.c((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          bool2 = localb.redTouch.aux();
          if ((!bool1) || (bool2)) {
            break label162;
          }
          ajrk.a(paramNearbyAppInterface, "op_red_clear", ((Integer)localObject2).intValue());
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label14;
      break;
      label162:
      if ((!bool1) && (bool2)) {
        ajrk.a(paramNearbyAppInterface, "op_red_push", ((Integer)localObject2).intValue());
      }
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.xW.get(paramInt);
  }
  
  public View getView(int paramInt)
  {
    ajpu.a locala = (ajpu.a)this.xW.get(paramInt);
    View localView = LayoutInflater.from(this.mContext).inflate(2131559689, this.mContainer, false);
    ajpu.b localb = new ajpu.b();
    localb.bo = ((URLImageView)localView.findViewById(2131368698));
    localb.bp = ((URLImageView)localView.findViewById(2131368699));
    localb.UW = ((TextView)localView.findViewById(2131381048));
    localb.bq = ((URLImageView)localView.findViewById(2131368723));
    localb.jp = ((LinearLayout)localView.findViewById(2131381092));
    localb.position = paramInt;
    localView.setTag(localb);
    localView.setOnClickListener(this.mOnClickListener);
    Object localObject = (RelativeLayout.LayoutParams)localb.jp.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ((int)this.xx);
    localb.jp.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localb.bo.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.OE;
    ((RelativeLayout.LayoutParams)localObject).height = this.OE;
    localb.bo.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localb.bp.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.OE;
    ((RelativeLayout.LayoutParams)localObject).height = this.OE;
    localb.bp.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localb.bo.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localb.bp.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject = (View)localb.jp.getParent();
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = ((int)this.xx);
    ((View)localObject).setLayoutParams(localLayoutParams);
    localView.setTag(2131379178, Integer.valueOf(locala.id));
    if (locala.bHY != 0)
    {
      localb.redTouch = new RedTouch(this.mContext, localb.bo);
      localb.redTouch.a(53).a();
      localView.setTag(2131377002, Integer.valueOf(locala.bHY));
    }
    if (locala.id == 1) {
      if (this.Dv != null)
      {
        a(localb, (ilive_feeds_near_anchor.NearAnchorInfo)this.Dv.get(this.dkn));
        localb.UW.setTextColor(Color.parseColor("#05d380"));
        localb.bq.setVisibility(0);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif", (URLDrawable.URLDrawableOptions)localObject);
        localb.bq.setImageDrawable((Drawable)localObject);
        localb.bq.setAdjustViewBounds(true);
        localb.bq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localb.bo.setVisibility(4);
      }
    }
    for (;;)
    {
      localb.UW.setText(locala.name);
      return localView;
      m(localb.bp, locala.iconUrl);
      break;
      localb.bo.setVisibility(0);
      localb.UW.setTextColor(Color.parseColor("#777777"));
      localb.bq.setVisibility(8);
      m(localb.bo, locala.iconUrl);
    }
  }
  
  public void lz(List<ilive_feeds_near_anchor.NearAnchorInfo> paramList)
  {
    this.Dv = paramList;
    this.mHandler.removeCallbacksAndMessages(null);
    if ((this.Dv != null) && (this.Dv.size() > 0))
    {
      this.dkn = 0;
      this.mHandler.post(this.runnable);
    }
  }
  
  public void m(ImageView paramImageView, String paramString)
  {
    URLDrawable localURLDrawable = null;
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.OE;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.OE;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.h;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.h;
        ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "nearby_fragment_enter_icon";
        if (!TextUtils.isEmpty(paramString)) {
          localURLDrawable = URLDrawable.getDrawable(aomc.l(paramString), (URLDrawable.URLDrawableOptions)localObject1);
        }
      }
      catch (Exception localException1)
      {
        localObject1 = null;
      }
      try
      {
        localURLDrawable.setTag(aqbn.e(this.OE, this.OE));
        localURLDrawable.setDecodeHandler(aqbn.b);
        if (localURLDrawable.getStatus() != 2)
        {
          localObject1 = localURLDrawable;
          if (localURLDrawable.getStatus() != 3) {}
        }
        else
        {
          localURLDrawable.restartDownload();
          localObject1 = localURLDrawable;
          if (QLog.isColorLevel())
          {
            QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage restartDownload");
            localObject1 = localURLDrawable;
          }
        }
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = this.h;
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localObject1 = localException1;
          Object localObject2 = localException2;
        }
      }
      localObject1 = localURLDrawable;
      if (QLog.isColorLevel())
      {
        QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage empty url");
        localObject1 = localURLDrawable;
        continue;
        paramImageView.setImageDrawable(this.h);
        if (QLog.isColorLevel()) {
          QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage exp: url=" + paramString + ", " + localException1.toString());
        }
      }
    }
  }
  
  public void setData(List<ajpu.a> paramList)
  {
    this.xW.clear();
    if (paramList != null) {
      this.xW.addAll(paramList);
    }
    this.mContainer.removeAllViews();
    int j = this.xW.size();
    int i = 0;
    while (i < j)
    {
      paramList = getView(i);
      this.mContainer.addView(paramList);
      i += 1;
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }
  
  public static class a
  {
    public int bHY;
    public int dko;
    public String iconUrl;
    public int id;
    public String jumpUrl;
    public String name;
    public String packageName;
    public String scheme;
  }
  
  public static class b
  {
    public TextView UW;
    public URLImageView bo;
    public URLImageView bp;
    public URLImageView bq;
    public LinearLayout jp;
    public int position;
    public RedTouch redTouch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpu
 * JD-Core Version:    0.7.0.1
 */
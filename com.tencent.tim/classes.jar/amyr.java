import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import java.util.List;

public class amyr
  extends amyf
{
  public ArrayList<amyr.a> Ah = new ArrayList();
  public TextView Zf;
  public TextView Zg;
  public URLImageView bL;
  public LinearLayout kx;
  
  public amyr(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(amqr paramamqr)
  {
    this.Ah.clear();
    this.kx.removeAllViews();
    if ((paramamqr.Gf == null) || (paramamqr.Gf.size() == 0)) {
      return;
    }
    Context localContext = this.kx.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    int j = 0;
    label60:
    Object localObject2;
    Object localObject1;
    Object localObject3;
    label224:
    label353:
    Object localObject4;
    label257:
    label290:
    label340:
    int i;
    label416:
    int k;
    int m;
    Object localObject5;
    if (j < paramamqr.Gf.size())
    {
      localObject2 = (amoe)paramamqr.Gf.get(j);
      localObject1 = new amyr.a(localContext);
      if (TextUtils.isEmpty(((amoe)localObject2).cbc)) {
        break label780;
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = aqcx.dip2px(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = aqcx.dip2px(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "leftIcon";
      localObject3 = URLDrawable.getDrawable(((amoe)localObject2).cbc, (URLDrawable.URLDrawableOptions)localObject3);
      ((URLDrawable)localObject3).setDecodeHandler(aqbn.b);
      ((amyr.a)localObject1).t.setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((amyr.a)localObject1).t.setVisibility(0);
      if (TextUtils.isEmpty(((amoe)localObject2).userName)) {
        break label793;
      }
      ((amyr.a)localObject1).nameView.setText(((amoe)localObject2).userName);
      ((amyr.a)localObject1).nameView.setVisibility(0);
      if (TextUtils.isEmpty(((amoe)localObject2).cbd)) {
        break label806;
      }
      ((amyr.a)localObject1).Zh.setText(((amoe)localObject2).cbd);
      ((amyr.a)localObject1).Zh.setVisibility(0);
      if (TextUtils.isEmpty(((amoe)localObject2).cbe)) {
        break label831;
      }
      ((amyr.a)localObject1).qp.setVisibility(0);
      if ((((amoe)localObject2).imageList == null) || (((amoe)localObject2).imageList.size() == 0)) {
        break label819;
      }
      ((amyr.a)localObject1).qp.setMaxLines(2);
      ((amyr.a)localObject1).qp.setText(((amoe)localObject2).cbe);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label844;
      }
      ((amyr.a)localObject1).qp.setTextColor(Color.parseColor("#737373"));
      ((amyr.a)localObject1).nameView.setTextColor(Color.parseColor("#4A4A4A"));
      ((amyr.a)localObject1).Zh.setTextColor(Color.parseColor("#4A4A4A"));
      ((amyr.a)localObject1).rootView.setBackgroundResource(2130843202);
      if ((((amoe)localObject2).imageList == null) || (((amoe)localObject2).imageList.size() == 0)) {
        break label1311;
      }
      if (((amoe)localObject2).imageList.size() != 1) {
        break label911;
      }
      ((amyr.a)localObject1).bV.setVisibility(0);
      ((amyr.a)localObject1).kq.setVisibility(8);
      localObject3 = ((amyr.a)localObject1).r;
      localObject4 = localContext.getResources();
      i = ((Resources)localObject4).getDisplayMetrics().widthPixels;
      float f1 = ((Resources)localObject4).getDimension(2131298829);
      float f2 = ((Resources)localObject4).getDimension(2131298829);
      k = aqcx.dip2px(localContext, 2.0F);
      m = ((amyr.a)localObject1).kq.getChildCount();
      i = (int)(i - f1 - f2 - (m - 1) * k) / m;
      ((SquareImageView)localObject3).setLayoutParams(new FrameLayout.LayoutParams(i, i));
      localObject2 = (ampz)((amoe)localObject2).imageList.get(0);
      localObject4 = ((ampz)localObject2).url;
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mPlayGifImage = true;
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject5);
      ((SquareImageView)localObject3).setImageDrawable((Drawable)localObject4);
      if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
        ((URLDrawable)localObject4).restartDownload();
      }
      if (((ampz)localObject2).type != 2) {
        break label898;
      }
      ((amyr.a)localObject1).Dw.setVisibility(0);
    }
    for (;;)
    {
      this.kx.addView(((amyr.a)localObject1).rootView);
      this.Ah.add(localObject1);
      if (j != paramamqr.Gf.size() - 1)
      {
        localObject1 = new View(localContext);
        ((View)localObject1).setBackgroundResource(2130839642);
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, aqcx.dip2px(localContext, 6.0F)));
        this.kx.addView((View)localObject1);
      }
      j += 1;
      break label60;
      break;
      label780:
      ((amyr.a)localObject1).t.setVisibility(8);
      break label224;
      label793:
      ((amyr.a)localObject1).nameView.setVisibility(8);
      break label257;
      label806:
      ((amyr.a)localObject1).Zh.setVisibility(8);
      break label290;
      label819:
      ((amyr.a)localObject1).qp.setMaxLines(3);
      break label340;
      label831:
      ((amyr.a)localObject1).qp.setVisibility(8);
      break label353;
      label844:
      ((amyr.a)localObject1).qp.setTextColor(Color.parseColor("#262626"));
      ((amyr.a)localObject1).nameView.setTextColor(Color.parseColor("#737373"));
      ((amyr.a)localObject1).Zh.setTextColor(Color.parseColor("#737373"));
      ((amyr.a)localObject1).rootView.setBackgroundResource(2130843199);
      break label416;
      label898:
      ((amyr.a)localObject1).Dw.setVisibility(8);
      continue;
      label911:
      ((amyr.a)localObject1).bV.setVisibility(8);
      ((amyr.a)localObject1).kq.setVisibility(0);
      int n = ((amyr.a)localObject1).kq.getChildCount();
      i = 0;
      k = i;
      if (i < ((amoe)localObject2).imageList.size())
      {
        k = i;
        if (i < n)
        {
          localObject4 = ((amyr.a)localObject1).kq.getChildAt(i);
          ((View)localObject4).setVisibility(0);
          localObject3 = (SquareImageView)((View)localObject4).findViewById(2131368923);
          localObject4 = (ImageView)((View)localObject4).findViewById(2131370134);
          localObject5 = (ampz)((amoe)localObject2).imageList.get(i);
          Object localObject6 = ((ampz)localObject5).url;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestHeight = 200;
          localURLDrawableOptions.mRequestWidth = 200;
          localURLDrawableOptions.mFailedDrawable = localColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject6 = URLDrawable.getDrawable((String)localObject6, localURLDrawableOptions);
          ((SquareImageView)localObject3).setImageDrawable((Drawable)localObject6);
          if ((((URLDrawable)localObject6).getStatus() != 1) && (((URLDrawable)localObject6).getStatus() != 0)) {
            ((URLDrawable)localObject6).restartDownload();
          }
          ((SquareImageView)localObject3).setVisibility(0);
          if (((ampz)localObject5).type == 2)
          {
            ((ImageView)localObject4).setVisibility(0);
            label1141:
            if ((i != n - 1) || (((amoe)localObject2).dDa <= n)) {
              break label1264;
            }
            ((ImageView)localObject4).setVisibility(8);
            ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
            m = ((amoe)localObject2).dDa - n;
            k = m;
            if (m > 99) {
              k = 99;
            }
            ((SquareImageView)localObject3).setFilterText("+" + k);
            ((SquareImageView)localObject3).setFilterTextSize(aqcx.dip2px(((SquareImageView)localObject3).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject4).setVisibility(8);
            break label1141;
            label1264:
            ((SquareImageView)localObject3).setFilterColor(-1);
            ((SquareImageView)localObject3).setFilterText("");
          }
        }
      }
      while (k < n)
      {
        ((amyr.a)localObject1).kq.getChildAt(k).setVisibility(4);
        k += 1;
      }
      continue;
      label1311:
      ((amyr.a)localObject1).bV.setVisibility(8);
      ((amyr.a)localObject1).kq.setVisibility(8);
    }
  }
  
  protected void aDR()
  {
    View localView = P(this.acL);
    this.bL = ((URLImageView)localView.findViewById(2131363019));
    this.Zf = ((TextView)localView.findViewById(2131368409));
    this.kx = ((LinearLayout)localView.findViewById(2131362736));
    this.Zg = ((TextView)localView.findViewById(2131362738));
  }
  
  class a
  {
    public ImageView Dw;
    public TextView Zh;
    public FrameLayout bV;
    public int childCount;
    public Context context;
    public LinearLayout kq;
    public TextView nameView;
    public TextView qp;
    public SquareImageView r;
    public View rootView;
    public SquareImageView t;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
      aDR();
    }
    
    public void aDR()
    {
      this.rootView = LayoutInflater.from(this.context).inflate(2131560016, amyr.this.kx, false);
      this.t = ((SquareImageView)this.rootView.findViewById(2131363196));
      this.nameView = ((TextView)this.rootView.findViewById(2131372190));
      this.Zh = ((TextView)this.rootView.findViewById(2131373544));
      this.qp = ((TextView)this.rootView.findViewById(2131365748));
      this.kq = ((LinearLayout)this.rootView.findViewById(2131373270));
      this.bV = ((FrameLayout)this.rootView.findViewById(2131378448));
      this.r = ((SquareImageView)this.bV.findViewById(2131368923));
      this.Dw = ((ImageView)this.bV.findViewById(2131370134));
      this.childCount = this.kq.getChildCount();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyr
 * JD-Core Version:    0.7.0.1
 */
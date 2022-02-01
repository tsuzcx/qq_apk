import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.ThemeURLImageView;
import java.util.ArrayList;
import java.util.List;

public class amyp
  extends amyf
{
  public ArrayList<amyp.a> Ah = new ArrayList();
  public ImageView Dx;
  public View Hg;
  public TextView YJ;
  public TextView Ze;
  public URLImageView bJ;
  public LinearLayout kv;
  public LinearLayout kw;
  public TextView tD;
  public TextView titleView;
  
  public amyp(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(amqq paramamqq)
  {
    this.Ah.clear();
    this.kw.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.tD.setTextColor(Color.parseColor("#004080"));
    }
    if ((paramamqq.Ge == null) || (paramamqq.Ge.size() == 0))
    {
      this.Hg.setVisibility(8);
      this.kw.setVisibility(8);
      return;
    }
    this.Hg.setVisibility(0);
    this.kw.setVisibility(0);
    Context localContext = this.kw.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    int i = 0;
    label116:
    amqz localamqz;
    amyp.a locala;
    if ((i < paramamqq.Ge.size()) && (i < 6))
    {
      localamqz = (amqz)paramamqq.Ge.get(i);
      locala = new amyp.a(localContext);
      if (TextUtils.isEmpty(paramamqq.cbR)) {
        break label410;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aqcx.dip2px(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aqcx.dip2px(localContext, 16.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
      localObject = URLDrawable.getDrawable(paramamqq.cbR, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(aqbn.b);
      locala.I.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      locala.I.setVisibility(0);
      label279:
      locala.Hh.setTag(2131381960, paramamqq);
      if (TextUtils.isEmpty(localamqz.word)) {
        break label423;
      }
      locala.qp.setText(localamqz.word);
      locala.qp.setVisibility(0);
      locala.Hh.setTag(2131379239, localamqz.word);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localamqz.url))
      {
        locala.Hh.setTag(2131379238, localamqz.url);
        locala.Hh.setTag(2131379208, Integer.valueOf(paramamqq.from));
      }
      this.kw.addView(locala.Hh);
      this.Ah.add(locala);
      i += 1;
      break label116;
      break;
      label410:
      locala.I.setVisibility(8);
      break label279;
      label423:
      locala.qp.setVisibility(8);
    }
  }
  
  protected void aDR()
  {
    View localView = P(this.acL);
    this.kv = ((LinearLayout)localView.findViewById(2131366481));
    this.bJ = ((URLImageView)localView.findViewById(2131368820));
    if ((this.bJ instanceof ThemeURLImageView)) {
      ((ThemeURLImageView)this.bJ).setSupportMaskView(false);
    }
    this.titleView = ((TextView)localView.findViewById(2131379769));
    this.tD = ((TextView)localView.findViewById(2131378922));
    this.Ze = ((TextView)localView.findViewById(2131378922));
    this.YJ = ((TextView)localView.findViewById(2131365748));
    this.Dx = ((ImageView)localView.findViewById(2131377302));
    this.Hg = localView.findViewById(2131369266);
    this.kw = ((LinearLayout)localView.findViewById(2131378914));
  }
  
  class a
  {
    public View Hh;
    public URLImageView I;
    public View.OnClickListener fL = new amyq(this);
    public TextView qp;
    
    public a(Context paramContext)
    {
      this.Hh = LayoutInflater.from(paramContext).inflate(2131561654, amyp.this.kw, false);
      this.I = ((URLImageView)this.Hh.findViewById(2131368820));
      this.qp = ((TextView)this.Hh.findViewById(2131365721));
      this.Hh.setOnClickListener(this.fL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyp
 * JD-Core Version:    0.7.0.1
 */
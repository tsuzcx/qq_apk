import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class amyo
  extends amyf
{
  public ArrayList<amyo.a> Ah = new ArrayList();
  public View Hg;
  public TextView YJ;
  public TextView Ze;
  public URLImageView bJ;
  public URLImageView bK;
  public LinearLayout kv;
  public LinearLayout kw;
  public TextView titleView;
  
  public amyo(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(amqp paramamqp)
  {
    this.Ah.clear();
    this.kw.removeAllViews();
    if ((paramamqp.Ge == null) || (paramamqp.Ge.size() == 0))
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
    label92:
    amyo.a locala;
    if (i < paramamqp.Ge.size())
    {
      amqd localamqd = (amqd)paramamqp.Ge.get(i);
      locala = new amyo.a(localContext);
      if (TextUtils.isEmpty(localamqd.cbc)) {
        break label350;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aqcx.dip2px(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aqcx.dip2px(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(localamqd.cbc, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(aqbn.b);
      locala.I.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      locala.I.setVisibility(0);
      label251:
      if (TextUtils.isEmpty(localamqd.desc)) {
        break label363;
      }
      locala.qp.setText(localamqd.desc);
      locala.qp.setVisibility(0);
      label284:
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label376;
      }
      locala.qp.setTextColor(Color.parseColor("#737373"));
      this.Hg.setBackgroundColor(Color.parseColor("#112037"));
    }
    for (;;)
    {
      this.kw.addView(locala.Hh);
      this.Ah.add(locala);
      i += 1;
      break label92;
      break;
      label350:
      locala.I.setVisibility(8);
      break label251;
      label363:
      locala.qp.setVisibility(8);
      break label284;
      label376:
      locala.qp.setTextColor(Color.parseColor("#262626"));
      this.Hg.setBackgroundColor(Color.parseColor("#E6E6E6"));
    }
  }
  
  protected void aDR()
  {
    View localView = P(this.acL);
    this.kv = ((LinearLayout)localView.findViewById(2131366481));
    this.bJ = ((URLImageView)localView.findViewById(2131368820));
    this.titleView = ((TextView)localView.findViewById(2131379769));
    this.Ze = ((TextView)localView.findViewById(2131378922));
    this.YJ = ((TextView)localView.findViewById(2131365748));
    this.bK = ((URLImageView)localView.findViewById(2131377302));
    this.Hg = localView.findViewById(2131369266);
    this.kw = ((LinearLayout)localView.findViewById(2131378914));
  }
  
  class a
  {
    public View Hh;
    public URLImageView I;
    public TextView qp;
    
    public a(Context paramContext)
    {
      this.Hh = LayoutInflater.from(paramContext).inflate(2131560010, amyo.this.kw, false);
      this.I = ((URLImageView)this.Hh.findViewById(2131368820));
      this.qp = ((TextView)this.Hh.findViewById(2131365721));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyo
 * JD-Core Version:    0.7.0.1
 */
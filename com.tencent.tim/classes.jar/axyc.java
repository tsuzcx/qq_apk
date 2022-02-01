import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class axyc
  implements View.OnClickListener
{
  private View MZ;
  private boolean aFr;
  private String cWy;
  private Button id;
  private String mSource;
  private RelativeLayout od;
  private TextView zd;
  
  public axyc(View paramView, String paramString)
  {
    init(paramView);
    this.mSource = paramString;
  }
  
  private void init(View paramView)
  {
    this.od = ((RelativeLayout)paramView.findViewById(2131382199));
    this.id = ((Button)this.od.findViewById(2131363846));
    this.zd = ((TextView)this.od.findViewById(2131380789));
    paramView = this.od.findViewById(2131382328);
    this.MZ = this.od.findViewById(2131382329);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20180423/4c3ece054ae044eb85797d31fa487ce7.jpg", (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new axyc.a(this.zd));
    paramView.setBackgroundDrawable((Drawable)localObject);
    this.id.setOnClickListener(this);
  }
  
  public void P(View.OnClickListener paramOnClickListener)
  {
    this.MZ.setOnClickListener(paramOnClickListener);
  }
  
  public void Ze(boolean paramBoolean)
  {
    if (this.aFr != paramBoolean)
    {
      this.aFr = paramBoolean;
      if (this.aFr) {
        this.id.setText(acfp.m(2131716913));
      }
    }
    else
    {
      return;
    }
    this.id.setText(acfp.m(2131716915));
  }
  
  public void ads(String paramString)
  {
    this.cWy = paramString;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (this.aFr) {
      rpw.p(this.od.getContext(), this.mSource, this.cWy);
    }
    for (String str = "clk_open";; str = "clk_download")
    {
      rar.a("weishi_share", str, 0, 0, new String[0]);
      break;
      QQToast.a(this.od.getContext(), acfp.m(2131716912), 0).show();
      rpw.aU(this.od.getContext(), this.mSource);
    }
  }
  
  public RelativeLayout t()
  {
    return this.od;
  }
  
  public static class a
    implements URLDrawable.URLDrawableListener
  {
    private final WeakReference<TextView> weakReference;
    
    public a(TextView paramTextView)
    {
      this.weakReference = new WeakReference(paramTextView);
    }
    
    public void onLoadCanceled(URLDrawable paramURLDrawable) {}
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
    
    public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      paramURLDrawable = (TextView)this.weakReference.get();
      if (paramURLDrawable != null) {
        paramURLDrawable.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyc
 * JD-Core Version:    0.7.0.1
 */
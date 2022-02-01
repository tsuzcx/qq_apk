import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;

public class amss
  extends amtl
{
  protected amss.a a;
  
  public amss(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  public void a(ampx paramampx, amxy paramamxy, Bitmap paramBitmap)
  {
    if (paramampx.pG() == 103)
    {
      if (paramamxy.w() != null) {
        paramamxy.w().setImageDrawable(amxk.e(paramBitmap));
      }
      return;
    }
    super.a(paramampx, paramamxy, paramBitmap);
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    if ((paramampx instanceof amqc)) {}
    for (Object localObject1 = (amqc)paramampx;; localObject1 = null)
    {
      if ((paramamxy instanceof amyb)) {}
      for (amyb localamyb = (amyb)paramamxy;; localamyb = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (paramampx.getDescription() == null)
        {
          if (localamyb.N() != null) {
            localamyb.N().setVisibility(8);
          }
          if (localamyb.getTitleView() != null) {
            localamyb.getTitleView().setVisibility(8);
          }
          localObject2 = localamyb.d();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localamyb.S();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((amqc)localObject1).getTitle())) {
              ((TextView)localObject2).setText(((amqc)localObject1).getTitle());
            }
          }
          if ((paramamxy.w() != null) && (!TextUtils.isEmpty(((amqc)localObject1).zi())))
          {
            localObject2 = ((amqc)localObject1).zi();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = aqcx.dip2px(paramamxy.getView().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = aqcx.dip2px(paramamxy.getView().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!aurr.isValidUrl((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(aqbn.d(aqcx.dip2px(paramamxy.getView().getContext(), 50.0F), aqcx.dip2px(paramamxy.getView().getContext(), 50.0F), aqcx.dip2px(paramamxy.getView().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(aqbn.a);
            paramamxy.w().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(paramampx, paramamxy);
          if ((localamyb.d() != null) && (((amqc)localObject1).awg()))
          {
            paramampx = ((amqc)localObject1).zj();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = aqcx.dip2px(paramamxy.getView().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = aqcx.dip2px(paramamxy.getView().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            paramampx = URLDrawable.getDrawable(paramampx, (URLDrawable.URLDrawableOptions)localObject2);
            paramampx.setTag(aqbn.d(aqcx.dip2px(paramamxy.getView().getContext(), 38.0F), aqcx.dip2px(paramamxy.getView().getContext(), 12.0F), 0));
            paramampx.setDecodeHandler(aqbn.a);
            localamyb.d().setImageDrawable(paramampx);
            if ((paramampx.getStatus() != 1) && (paramampx.getStatus() != 0)) {
              paramampx.restartDownload();
            }
          }
          return;
          if ((localamyb.N() != null) && (!TextUtils.isEmpty(paramampx.getDescription())))
          {
            localamyb.N().setVisibility(0);
            localamyb.N().setText(paramampx.getDescription());
          }
          for (;;)
          {
            if (localamyb.getTitleView() != null) {
              localamyb.getTitleView().setVisibility(0);
            }
            localObject2 = localamyb.S();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(paramampx.getTitle())) {
              break;
            }
            localamyb.getTitleView().setText(((amqc)localObject1).getTitle());
            break;
            if (paramamxy.N() != null) {
              localamyb.N().setVisibility(8);
            }
          }
          label625:
          paramamxy.w().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(ampx paramampx, amxy paramamxy)
  {
    if (this.a != null)
    {
      if (paramamxy.getView() != null) {
        paramamxy.getView().setOnClickListener(new amst(this));
      }
      return;
    }
    super.c(paramampx, paramamxy);
  }
  
  public static abstract interface a
  {
    public abstract void cR(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amss
 * JD-Core Version:    0.7.0.1
 */
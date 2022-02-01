import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public class amta
  extends amtl
  implements amul
{
  private amta.a a;
  private boolean cEi = true;
  private WeakReference<amlx> fb;
  
  public amta(aqdf paramaqdf, amlx paramamlx)
  {
    super(paramaqdf);
    this.fb = new WeakReference(paramamlx);
  }
  
  private void a(int paramInt1, int paramInt2, amum paramamum)
  {
    if (!(paramamum instanceof amuu)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((amuu)paramamum).Pz(bool);
    if (paramInt1 == 1)
    {
      ((amuu)paramamum).showDivider(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((amuu)paramamum).showDivider(true);
      return;
    case 1: 
      ((amuu)paramamum).showDivider(true);
      return;
    }
    ((amuu)paramamum).showDivider(true);
  }
  
  private void avR()
  {
    if (this.fb == null) {}
    amlx localamlx;
    do
    {
      return;
      localamlx = (amlx)this.fb.get();
    } while (localamlx == null);
    localamlx.notifyDataSetChanged();
  }
  
  public void a(ampx paramampx, amxy paramamxy, Bitmap paramBitmap)
  {
    super.a(paramampx, paramamxy, paramBitmap);
  }
  
  public void a(amuk paramamuk)
  {
    avR();
  }
  
  public void a(amuk paramamuk, String paramString1, String paramString2) {}
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    super.b(paramampx, paramamxy);
    if (!(paramampx instanceof amra)) {}
    do
    {
      do
      {
        return;
      } while (!(paramamxy instanceof amum));
      paramamxy = ((amum)paramamxy).a();
      paramamxy.aT(((amra)paramampx).zk(), ((amra)paramampx).zl(), ((amra)paramampx).getConfig());
      paramamxy.a(this);
    } while (!(paramamxy instanceof amui));
    ((amui)paramamxy).Pw(true);
  }
  
  protected void c(ampx paramampx, amxy paramamxy)
  {
    if (this.a != null)
    {
      if (paramamxy.getView() != null) {
        paramamxy.getView().setOnClickListener(new amtb(this));
      }
      return;
    }
    super.c(paramampx, paramamxy);
  }
  
  public void d(ampx paramampx, amxy paramamxy)
  {
    if (!(paramamxy instanceof amum)) {}
    while (!this.cEi) {
      return;
    }
    a(paramampx.pE(), paramampx.pF(), (amum)paramamxy);
  }
  
  public static abstract interface a
  {
    public abstract void cR(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amta
 * JD-Core Version:    0.7.0.1
 */
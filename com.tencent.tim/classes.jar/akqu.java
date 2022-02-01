import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.a;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

public class akqu
{
  static final String TAG = adca.TAG + "_Guide";
  private ImageView BV;
  private TextView WD;
  private akqu.a a;
  boolean cuj = false;
  private ViewGroup es;
  private LottieDrawable k;
  private Activity l;
  
  public akqu(Activity paramActivity)
  {
    this.l = paramActivity;
    this.es = ((ViewGroup)this.l.findViewById(2131382316));
    this.WD = ((TextView)this.l.findViewById(2131382317));
    this.BV = ((ImageView)this.l.findViewById(2131382315));
  }
  
  private boolean isDestroyed()
  {
    return (this.a == null) || ((this.a != null) && (!this.a.aff()));
  }
  
  public void Nb(boolean paramBoolean)
  {
    ImageView localImageView = this.BV;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.es.setVisibility(0);
      return;
    }
    this.es.setVisibility(this.WD.getVisibility());
  }
  
  public void Sk(int paramInt)
  {
    int i = 1;
    if (isDestroyed())
    {
      QLog.w(TAG, 1, "showText, isDestroyed, textIndex[" + paramInt + "]");
      return;
    }
    if (this.a == null)
    {
      QLog.w(TAG, 1, "showText, mPromotionRes为null, textIndex[" + paramInt + "]");
      return;
    }
    Object localObject = this.a.a();
    if (localObject != null)
    {
      localObject = ((PromotionConfigInfo.a)localObject).dE(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.WD.setText((CharSequence)localObject);
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      localObject = this.WD;
      if (paramInt != 0) {}
      for (i = 0;; i = 8)
      {
        ((TextView)localObject).setVisibility(i);
        if (paramInt == 0) {
          break;
        }
        this.es.setVisibility(0);
        return;
      }
      this.es.setVisibility(this.BV.getVisibility());
      return;
    }
  }
  
  public void a(akqu.a parama)
  {
    this.a = parama;
  }
  
  public void d(PromotionConfigInfo.a parama)
  {
    QLog.w(TAG, 1, "loadRes, hadLoad[" + this.cuj + "]");
    if (isDestroyed()) {}
    while (this.cuj) {
      return;
    }
    this.cuj = true;
    Object localObject = this.l.getResources();
    int i = ((Resources)localObject).getDisplayMetrics().densityDpi;
    int j = ((Resources)localObject).getDisplayMetrics().densityDpi;
    localObject = adbx.b(parama);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.w(TAG, 1, "PromotionGuide, path is null");
      return;
    }
    if (!new File((String)localObject).exists())
    {
      QLog.w(TAG, 1, "PromotionGuide, file not exist");
      return;
    }
    parama = (String)localObject + "guide.json";
    localObject = new akqv(this, (String)localObject, i, j);
    try
    {
      LottieComposition.Factory.fromInputStream(this.l, new FileInputStream(parama), (OnCompositionLoadedListener)localObject);
      return;
    }
    catch (Exception parama)
    {
      QLog.i(TAG, 2, "loadWorldCupGuideAnimation failed. err = " + parama.getMessage());
    }
  }
  
  public void t(AppInterface paramAppInterface)
  {
    this.l = null;
    if (this.BV != null) {
      this.BV.setImageDrawable(null);
    }
    if (this.k != null)
    {
      this.k.cancelAnimation();
      this.k = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract PromotionConfigInfo.a a();
    
    public abstract boolean aff();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqu
 * JD-Core Version:    0.7.0.1
 */
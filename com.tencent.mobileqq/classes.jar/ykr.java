import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

class ykr
  extends LinearLayout
{
  private yri jdField_a_of_type_Yri;
  private yrk jdField_a_of_type_Yrk = new yks(this);
  
  public ykr(Context paramContext, String paramString)
  {
    super(paramContext);
    setGravity(17);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setStroke(1, Color.parseColor("#EFEFEF"));
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(localGradientDrawable);
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      yny.d("GdtBannerImageView", "constructor");
      return;
    }
    paramContext = new URLImageView(paramContext);
    addView(paramContext);
    this.jdField_a_of_type_Yri = new yri(paramString, new WeakReference(this.jdField_a_of_type_Yrk));
    this.jdField_a_of_type_Yri.a();
    paramContext.setImageDrawable(this.jdField_a_of_type_Yri.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ykr
 * JD-Core Version:    0.7.0.1
 */
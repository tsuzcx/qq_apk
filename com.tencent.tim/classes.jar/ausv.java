import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class ausv
  implements auvl
{
  private boolean mEnabled;
  private Locale mLocale;
  
  public ausv(Context paramContext)
  {
    this.mLocale = paramContext.getResources().getConfiguration().locale;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    if (this.mEnabled)
    {
      if (paramCharSequence != null) {
        return paramCharSequence.toString().toUpperCase(this.mLocale);
      }
      return null;
    }
    QLog.w("AllCapsTransformationMethod", 2, "Caller did not enable length changes; not transforming text");
    return paramCharSequence;
  }
  
  public void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
  
  public void setLengthChangesAllowed(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausv
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

public class tti
{
  public static Toast a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    Toast localToast = new Toast(paramContext);
    localToast.setDuration(paramInt);
    paramContext = (TextView)LayoutInflater.from(paramContext).inflate(2131562770, null);
    localToast.setView(paramContext);
    paramContext.setText(paramCharSequence);
    localToast.setGravity(17, 0, 0);
    return localToast;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tti
 * JD-Core Version:    0.7.0.1
 */
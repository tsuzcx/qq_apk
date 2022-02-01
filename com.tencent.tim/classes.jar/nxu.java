import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

public class nxu
{
  public static Toast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    Toast localToast = new Toast(paramContext);
    localToast.setDuration(paramInt);
    paramContext = (TextView)LayoutInflater.from(paramContext).inflate(2131562931, null);
    localToast.setView(paramContext);
    paramContext.setText(paramCharSequence);
    localToast.setGravity(17, 0, 0);
    return localToast;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxu
 * JD-Core Version:    0.7.0.1
 */
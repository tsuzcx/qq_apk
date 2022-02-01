import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

public class rxm
{
  public static TextView a(Context paramContext, float paramFloat, String paramString1, String paramString2)
  {
    paramContext = new TextView(paramContext);
    paramContext.setTextSize(1, paramFloat);
    paramContext.setTextColor(Color.parseColor(paramString1));
    paramContext.setText(paramString2);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxm
 * JD-Core Version:    0.7.0.1
 */
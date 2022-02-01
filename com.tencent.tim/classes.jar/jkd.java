import android.app.Notification;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class jkd
{
  final String SC = "SearchForText";
  final String SD = "SearchForTitle";
  String TAG = "NotificationStyleDiscover";
  float ib = 14.0F;
  float ic = 16.0F;
  Context mContext;
  DisplayMetrics metrics = new DisplayMetrics();
  Integer u = null;
  Integer w = null;
  
  public jkd(Context paramContext)
  {
    this.mContext = paramContext;
    ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.metrics);
    if ((this.u != null) && (this.w != null)) {
      return;
    }
    try
    {
      Object localObject = new Notification();
      ((Notification)localObject).setLatestEventInfo(this.mContext, "SearchForTitle", "SearchForText", null);
      paramContext = new LinearLayout(this.mContext);
      localObject = (ViewGroup)((Notification)localObject).contentView.apply(this.mContext, paramContext);
      c((ViewGroup)localObject);
      d((ViewGroup)localObject);
      paramContext.removeAllViews();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e(this.TAG, 2, "erro");
    }
  }
  
  public float ae()
  {
    return this.ic;
  }
  
  boolean c(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForTitle".equals(localTextView.getText().toString()))
        {
          this.w = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.ic = localTextView.getTextSize();
          this.ic /= this.metrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (c((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean d(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForText".equals(localTextView.getText().toString()))
        {
          this.u = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.ib = localTextView.getTextSize();
          this.ib /= this.metrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (d((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public float getTextSize()
  {
    return this.ib;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkd
 * JD-Core Version:    0.7.0.1
 */
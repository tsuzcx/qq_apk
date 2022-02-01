import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class qui
  extends rsd
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public qui(Context paramContext)
  {
    super(paramContext);
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    paramInt = rpq.getWindowScreenHeight(this.context);
    int i = rpq.getStatusBarHeight(this.context);
    paramqyd.getItemView().getLayoutParams().height = (paramInt - i);
    return paramqyd.getItemView();
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    return new qyd(LayoutInflater.from(this.context).inflate(2131561895, paramViewGroup, false));
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public String getKey()
  {
    return "MemoriesPlaceHolderSegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qui
 * JD-Core Version:    0.7.0.1
 */
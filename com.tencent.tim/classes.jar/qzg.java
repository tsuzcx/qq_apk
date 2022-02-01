import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class qzg
  extends rsd
{
  public static final String KEY = "NewDividerSegment";
  
  public qzg(Context paramContext)
  {
    super(paramContext);
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    return paramqyd.getItemView();
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    return new qyd(LayoutInflater.from(this.context).inflate(2131561822, paramViewGroup, false));
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public String getKey()
  {
    return "NewDividerSegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzg
 * JD-Core Version:    0.7.0.1
 */
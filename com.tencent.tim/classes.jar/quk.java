import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class quk
  extends rsd
{
  public static final String KEY = "MemoriesVideoListEmptySegment";
  
  public quk(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  private void bqN()
  {
    rsd localrsd = a().a("MemoriesVideoListSegment");
    if ((localrsd != null) && (localrsd.getCount() == 0))
    {
      this.isDisplay = true;
      return;
    }
    this.isDisplay = false;
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    paramInt = rpq.getWindowScreenHeight(this.context);
    int i = rpq.getStatusBarHeight(this.context);
    int j = rpq.dip2px(this.context, 225.0F);
    int k = rpq.dip2px(this.context, 50.0F);
    paramqyd.getItemView().getLayoutParams().height = (paramInt - i - j - k);
    return paramqyd.getItemView();
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    return new qyd(LayoutInflater.from(this.context).inflate(2131561895, paramViewGroup, false));
  }
  
  protected void bqO()
  {
    bqN();
  }
  
  public void bqo()
  {
    bqN();
  }
  
  public int getCount()
  {
    if (this.isDisplay) {
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "MemoriesVideoListEmptySegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     quk
 * JD-Core Version:    0.7.0.1
 */
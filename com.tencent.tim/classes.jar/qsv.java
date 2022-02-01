import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class qsv
  extends rsd
{
  public static final String KEY = "DetailEmptySegment";
  
  public qsv(Context paramContext)
  {
    super(paramContext);
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if ((this.context instanceof FragmentActivity)) {}
    for (paramInt = ((FragmentActivity)this.context).getTitleBarHeight();; paramInt = 0)
    {
      int i = rpq.getStatusBarHeight(this.context);
      int j = rpq.getWindowScreenWidth(this.context);
      int k = rpq.getWindowScreenHeight(this.context);
      paramqyd.getItemView().getLayoutParams().width = j;
      paramqyd.getItemView().getLayoutParams().height = (k - paramInt - i);
      ram.b("Q.qqstory.detail.DetailEmptySegment", "titleBarHeight=%d, statusBarHeight=%d, screenHeight=%d.", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k));
      return paramqyd.getItemView();
    }
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    return new qyd(LayoutInflater.from(this.context).inflate(2131561816, paramViewGroup, false));
  }
  
  public void bqo()
  {
    if (((StoryDetailListView)a()).Kx())
    {
      this.isDisplay = false;
      return;
    }
    this.isDisplay = true;
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
    return "DetailEmptySegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsv
 * JD-Core Version:    0.7.0.1
 */
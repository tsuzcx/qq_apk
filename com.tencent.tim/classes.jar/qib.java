import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.widget.AbsListView.LayoutParams;

public class qib
  extends rsd
{
  public static final String KEY = "EmptyPlaceHolderSegment";
  private qyd a;
  private final int mHeight;
  
  public qib(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mHeight = paramInt;
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    return paramqyd.getItemView();
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new View(this.context);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.mHeight));
    if (QQStoryContext.isNightMode()) {
      paramViewGroup.setBackgroundColor(this.context.getResources().getColor(2131166759));
    }
    for (;;)
    {
      this.a = new qyd(paramViewGroup);
      return this.a;
      paramViewGroup.setBackgroundColor(this.context.getResources().getColor(2131165685));
    }
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public String getKey()
  {
    return "EmptyPlaceHolderSegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qib
 * JD-Core Version:    0.7.0.1
 */
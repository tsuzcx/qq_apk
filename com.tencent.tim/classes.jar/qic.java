import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import java.util.List;

public class qic
  extends rsd
{
  public static final String KEY = "PlayerCommentEmptySegment";
  private qhy a;
  public qru a;
  private boolean mIsLoading = true;
  private View mLoadingView;
  
  public qic(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean isOpen()
  {
    return (this.jdField_a_of_type_Qhy == null) || (this.jdField_a_of_type_Qhy.isOpen());
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if (this.mIsLoading) {
      this.mLoadingView.setVisibility(0);
    }
    for (;;)
    {
      return paramqyd.getItemView();
      this.mLoadingView.setVisibility(8);
    }
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.context).inflate(2131561928, paramViewGroup, false);
    this.mLoadingView = paramViewGroup.findViewById(2131370820);
    if (QQStoryContext.isNightMode()) {
      this.mLoadingView.setBackgroundColor(this.context.getResources().getColor(2131166759));
    }
    return new qyd(paramViewGroup);
  }
  
  public void a(qhy paramqhy)
  {
    this.jdField_a_of_type_Qhy = paramqhy;
  }
  
  public void c(qru paramqru)
  {
    this.jdField_a_of_type_Qru = paramqru;
  }
  
  public int getCount()
  {
    if ((this.isDisplay) && ((this.jdField_a_of_type_Qru == null) || (this.jdField_a_of_type_Qru.h(isOpen()).size() == 0))) {
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "PlayerCommentEmptySegment";
  }
  
  public void setLoading(boolean paramBoolean)
  {
    this.mIsLoading = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qic
 * JD-Core Version:    0.7.0.1
 */
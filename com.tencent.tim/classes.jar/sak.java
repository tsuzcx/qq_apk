import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

public abstract class sak<T>
  extends saj<T>
{
  protected int mLayoutId = -1;
  
  public sak(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  protected abstract View G();
  
  public void a(ViewStub paramViewStub, int paramInt)
  {
    if (paramViewStub != null)
    {
      paramViewStub.setLayoutResource(paramInt);
      this.mParentView = paramViewStub.inflate();
      initChildView();
    }
  }
  
  public void addView(View paramView)
  {
    if ((paramView != null) && (isViewGroup())) {
      ((ViewGroup)this.mParentView).addView(paramView);
    }
  }
  
  protected View findViewById(int paramInt)
  {
    if (this.mParentView != null) {
      return this.mParentView.findViewById(paramInt);
    }
    return null;
  }
  
  protected abstract int gn();
  
  protected abstract void initChildView();
  
  public void initLayout(ViewStub paramViewStub)
  {
    if (paramViewStub == null) {
      return;
    }
    if (this.mLayoutId != -1)
    {
      a(paramViewStub, this.mLayoutId);
      return;
    }
    paramViewStub.setLayoutResource(gn());
    this.mParentView = paramViewStub.inflate();
    if (gn() == 2131562672) {
      addView(G());
    }
    initChildView();
  }
  
  protected void initUI()
  {
    this.mParentView = G();
    initChildView();
  }
  
  protected boolean isViewGroup()
  {
    return (this.mParentView != null) && ((this.mParentView instanceof ViewGroup));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sak
 * JD-Core Version:    0.7.0.1
 */
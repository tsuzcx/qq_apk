import android.content.Context;
import android.view.View;
import android.view.ViewStub;

public abstract class ogm<T>
  extends ogl<T>
{
  protected int mPlayMode = 1;
  
  public ogm(Context paramContext)
  {
    super(paramContext);
  }
  
  protected View findViewById(int paramInt)
  {
    if (this.mParentView != null) {
      return this.mParentView.findViewById(paramInt);
    }
    return null;
  }
  
  protected abstract int gn();
  
  public void initLayout(ViewStub paramViewStub)
  {
    paramViewStub.setLayoutResource(gn());
    this.mParentView = paramViewStub.inflate();
    initView();
  }
  
  protected abstract void initView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogm
 * JD-Core Version:    0.7.0.1
 */
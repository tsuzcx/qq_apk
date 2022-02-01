import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView;

public class axap
  extends axgh
{
  private static boolean mIsShow;
  private WatermarkEditView a;
  
  public axap(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    super(paramActivity, paramView, paramaxgi);
  }
  
  private void eIs()
  {
    if (this.a == null)
    {
      ViewStub localViewStub = (ViewStub)this.mActivity.findViewById(2131364219);
      if (localViewStub != null)
      {
        localViewStub.inflate();
        this.a = ((WatermarkEditView)this.mActivity.findViewById(2131364218));
        this.a.p(this.mActivity);
      }
    }
    if (this.a != null) {
      this.a.eIx();
    }
  }
  
  public Object a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(mIsShow);
  }
  
  protected void initView() {}
  
  public void p(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 589825: 
      eIs();
      mIsShow = true;
      return;
    }
    if ((this.a != null) && (this.a.getVisibility() == 0)) {
      this.a.setVisibility(8);
    }
    mIsShow = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axap
 * JD-Core Version:    0.7.0.1
 */
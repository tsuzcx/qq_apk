import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.widget.MaxHeightRelativelayout;

public abstract class ahjf
{
  private TextView Dp;
  protected MaxHeightRelativelayout b;
  private RelativeLayout kz;
  protected Context mContext;
  protected aqju mDialog;
  protected View mRootView;
  private ImageView zS;
  
  public ahjf(aqju paramaqju)
  {
    this.mDialog = paramaqju;
    this.mContext = paramaqju.getContext();
    init();
    this.b.setMaxHeight(Math.max(paramaqju.getRootViewHeight() - this.mContext.getResources().getDimensionPixelSize(2131297368), wja.dp2px(EZ(), this.mContext.getResources())));
  }
  
  protected int EZ()
  {
    return 380;
  }
  
  public void dQ(String paramString)
  {
    this.Dp.setText(paramString);
  }
  
  public void doq()
  {
    onDestroy();
    this.mDialog.removePreviewView();
  }
  
  protected abstract View getContentView();
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public void hideLoadingView()
  {
    this.kz.setVisibility(8);
  }
  
  protected void init()
  {
    this.mRootView = LayoutInflater.from(this.mContext).inflate(2131559132, null);
    this.Dp = ((TextView)this.mRootView.findViewById(2131381164));
    this.b = ((MaxHeightRelativelayout)this.mRootView.findViewById(2131377408));
    this.zS = ((ImageView)this.mRootView.findViewById(2131369093));
    this.kz = ((RelativeLayout)this.mRootView.findViewById(2131377442));
    View localView = getContentView();
    if (localView != null) {
      this.b.addView(localView);
    }
    this.zS.setOnClickListener(new ahjg(this));
    int i = aqnm.dip2px(15.0F);
    wja.i(this.zS, i, i, i, i);
    this.zS.setContentDescription(acfp.m(2131706479));
  }
  
  protected void onDestroy() {}
  
  protected void showLoadingView()
  {
    this.kz.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjf
 * JD-Core Version:    0.7.0.1
 */
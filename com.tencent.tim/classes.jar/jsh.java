import android.widget.LinearLayout;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.c;

public class jsh
  implements BounceScrollView.c
{
  public jsh(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = (int)(this.a.dp.getHeight() - this.a.screenHeight * (1.0D - LebaSearchPluginManagerActivity.aM) + 56.0F * this.a.density);
    this.a.a.setMaxOverScrollY(paramInt1);
    if (LebaSearchPluginManagerActivity.a(this.a))
    {
      this.a.oc(paramInt2);
      LebaSearchPluginManagerActivity.b(this.a, paramInt2);
    }
  }
  
  public void w(float paramFloat1, float paramFloat2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsh
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout.a;

public class jwo
  implements DragFrameLayout.a
{
  public jwo(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 - paramInt3 > aqcx.dip2px(this.this$0, 60.0F))
    {
      PublicAccountAdvertisementActivity.a(this.this$0);
      PublicAccountAdvertisementActivity.b(this.this$0);
      this.this$0.finish();
      return;
    }
    PublicAccountAdvertisementActivity.a(this.this$0).aBc();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public boolean yB()
  {
    return (!PublicAccountAdvertisementActivity.a(this.this$0)) && (!PublicAccountAdvertisementActivity.b(this.this$0)) && (PublicAccountAdvertisementActivity.c(this.this$0));
  }
  
  public boolean yC()
  {
    return false;
  }
  
  public boolean yD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwo
 * JD-Core Version:    0.7.0.1
 */
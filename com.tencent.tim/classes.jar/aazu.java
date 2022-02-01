import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class aazu
  extends avkd.b
{
  public aazu(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public int bs()
  {
    return ShortVideoPlayActivity.d(this.this$0);
  }
  
  public void gv()
  {
    ShortVideoPlayActivity.d(this.this$0);
  }
  
  public void hJ()
  {
    this.this$0.hJ();
  }
  
  public void hK()
  {
    ShortVideoPlayActivity.f(this.this$0);
  }
  
  public void hL()
  {
    this.this$0.hG();
  }
  
  public void iB()
  {
    ShortVideoPlayActivity.e(this.this$0);
  }
  
  public void m(Bundle paramBundle)
  {
    Intent localIntent = this.this$0.b();
    localIntent.putExtras(paramBundle);
    ahgq.a((Activity)this.this$0.mContext, localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_shoucang");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazu
 * JD-Core Version:    0.7.0.1
 */
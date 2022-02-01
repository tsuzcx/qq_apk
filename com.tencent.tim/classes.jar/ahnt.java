import android.graphics.Bitmap;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;

public class ahnt
  extends ajve
{
  public ahnt(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  protected void b(int paramInt, String paramString, Bitmap paramBitmap)
  {
    if ((this.this$0.mMsgUin != null) && (this.this$0.mMsgUin.equals(paramString)) && (paramBitmap != null) && (this.this$0.iZ != null) && (this.this$0.iZ.getVisibility() == 0)) {
      this.this$0.bg.setImageBitmap(paramBitmap);
    }
  }
  
  protected void cA(int paramInt, String paramString) {}
  
  protected void dph()
  {
    if (this.this$0.a != null) {
      this.this$0.a.d(this.this$0.b);
    }
    this.this$0.doY();
    this.this$0.doZ();
  }
  
  protected void onUploadFailed(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnt
 * JD-Core Version:    0.7.0.1
 */
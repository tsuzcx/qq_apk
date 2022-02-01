import android.graphics.Bitmap;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.b;

public class rhq
  implements rfz.a
{
  public rhq(DoodleLayout paramDoodleLayout) {}
  
  public void f(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.this$0.a != null) {
      this.this$0.a.d(paramBitmap, paramBoolean);
    }
  }
  
  public void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.this$0.a != null)
    {
      ram.d("DoodleLayout", "notify outside onDrawMosaic. width:" + paramInt1 + ",height:" + paramInt2);
      this.this$0.a.S(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rhq
 * JD-Core Version:    0.7.0.1
 */
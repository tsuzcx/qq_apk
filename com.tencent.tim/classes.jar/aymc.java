import android.graphics.Bitmap;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.b;

public class aymc
  implements ayju.a
{
  public aymc(DoodleLayout paramDoodleLayout) {}
  
  public void f(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.this$0.b != null) {
      this.this$0.b.d(paramBitmap, paramBoolean);
    }
  }
  
  public void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.this$0.b != null)
    {
      ram.d("DoodleLayout", "notify outside onDrawMosaic. width:" + paramInt1 + ",height:" + paramInt2);
      this.this$0.b.S(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymc
 * JD-Core Version:    0.7.0.1
 */
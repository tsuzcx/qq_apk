import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable.a;

public class inj
  implements BaseGaInvite.GetGaFaceRunnable.a
{
  public inj(BaseGaInvite paramBaseGaInvite) {}
  
  public boolean b(Bitmap paramBitmap, String paramString)
  {
    if (this.this$0.gn != null) {
      this.this$0.gn.setImageBitmap(paramBitmap);
    }
    for (boolean bool = true;; bool = false)
    {
      if (this.this$0.mx != null)
      {
        paramBitmap = BaseGaInvite.a(this.this$0.mApp, this.this$0.mx, paramString, this.this$0.aqx, String.valueOf(this.this$0.mGroupId), this.this$0.l);
        this.this$0.mx.setText(paramBitmap);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     inj
 * JD-Core Version:    0.7.0.1
 */
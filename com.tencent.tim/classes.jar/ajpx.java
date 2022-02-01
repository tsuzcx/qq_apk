import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyIconDecoder.1;
import java.util.ArrayList;
import java.util.List;

public class ajpx
  implements amfa.b, Handler.Callback, aqdu
{
  public List<aqdu.a> Dw;
  List<String> Dx;
  List<String> Dy;
  NearbyAppInterface a;
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    ajrk.f("NearbyIconDecoder", "onDecodeBitmap", new Object[] { paramString1, paramString2, paramBitmap, Integer.valueOf(paramInt) });
    if (paramString1 == null) {}
    while (paramBitmap == null) {
      return;
    }
    v(paramString1, paramBitmap);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    ajrk.f("NearbyIconDecoder", "MSG_GET_ICON_URL", new Object[] { Integer.valueOf(this.Dx.size()), Integer.valueOf(this.Dy.size()) });
    paramMessage = new ArrayList(this.Dx.size());
    synchronized (this.Dx)
    {
      paramMessage.addAll(this.Dx);
      this.Dx.clear();
    }
    synchronized (this.Dy)
    {
      this.Dy.addAll(paramMessage);
      this.a.a().eC(paramMessage);
      return false;
      paramMessage = finally;
      throw paramMessage;
    }
  }
  
  protected void v(String paramString, Bitmap paramBitmap)
  {
    ajrk.f("NearbyIconDecoder", "notifyGetIcon", new Object[] { paramString, paramBitmap });
    this.a.runOnUiThread(new NearbyIconDecoder.1(this, paramString, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpx
 * JD-Core Version:    0.7.0.1
 */
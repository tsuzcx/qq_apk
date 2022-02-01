import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class ahyo
{
  protected ahym b;
  protected int dct;
  protected Bitmap fo;
  protected Context mContext;
  
  public ahyo(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.dct = paramInt;
  }
  
  public ahyo(Context paramContext, int paramInt, ahym paramahym)
  {
    this.mContext = paramContext;
    this.dct = paramInt;
    this.b = paramahym;
  }
  
  public void a(ahym.a parama)
  {
    parama.wJ = 1.0F;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    return null;
  }
  
  public Bitmap ax()
  {
    if (this.b != null) {
      a(this.b.a());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyo
 * JD-Core Version:    0.7.0.1
 */
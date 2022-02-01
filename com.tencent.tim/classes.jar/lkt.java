import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.ListView;

public class lkt
  implements lkf
{
  private lkf jdField_a_of_type_Lkf;
  private nhk jdField_a_of_type_Nhk;
  private lkf b;
  private lie c;
  private Context mContext;
  private int mType;
  
  public lkt(Context paramContext, ndi.c paramc, aqdf paramaqdf, ndi paramndi, autw paramautw, ListView paramListView)
  {
    this.jdField_a_of_type_Lkf = new lko(paramContext, paramaqdf, paramndi, paramListView, paramautw);
    this.b = new lkg(paramContext, paramc, paramndi);
    this.mContext = paramContext;
  }
  
  public void a(nhk paramnhk, lie paramlie, int paramInt)
  {
    this.jdField_a_of_type_Nhk = paramnhk;
    this.c = paramlie;
    this.mType = paramInt;
    this.jdField_a_of_type_Lkf.a(paramnhk, paramlie, paramInt);
    this.b.a(paramnhk, paramlie, paramInt);
    if ((paramnhk != null) && (paramnhk.mx != null))
    {
      if (paramlie.Cw()) {
        paramnhk.mx.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramnhk.mx.setVisibility(0);
  }
  
  public void a(nhk paramnhk, lie paramlie, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Lkf.a(paramnhk, paramlie, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lkt
 * JD-Core Version:    0.7.0.1
 */
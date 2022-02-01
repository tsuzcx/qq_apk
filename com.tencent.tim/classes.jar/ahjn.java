import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ahjn
  implements aqdf.a
{
  ahjn(ahjl paramahjl) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (ahjl.a(this.this$0) == null) {}
    while (ahjl.a(this.this$0).isPausing()) {
      return;
    }
    paramInt2 = ahjl.a(this.this$0).findFirstVisibleItemPosition();
    int i = ahjl.a(this.this$0).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)ahjl.a(this.this$0).BZ.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        ahjl.c localc = (ahjl.c)ahjl.a(this.this$0).getChildViewHolder(ahjl.a(this.this$0).getChildAt(paramInt1));
        if (!(localc instanceof ahjl.b)) {
          break label170;
        }
        ((ahjl.b)localc).zU.setImageBitmap(paramBitmap);
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label74;
      break;
      label170:
      QLog.e("Forward.Preview.Dialog", 2, "onDecodeTaskCompleted viewHolder in wrong instance ! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjn
 * JD-Core Version:    0.7.0.1
 */
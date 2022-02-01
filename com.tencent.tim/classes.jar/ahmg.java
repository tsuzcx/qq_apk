import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ahmg
  implements aqdf.a
{
  ahmg(ahme paramahme) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (ahme.a(this.this$0) == null) {}
    while (ahme.a(this.this$0).isPausing()) {
      return;
    }
    paramInt2 = ahme.a(this.this$0).findFirstVisibleItemPosition();
    int i = ahme.a(this.this$0).getChildCount();
    paramInt1 = 1;
    label74:
    if (paramInt1 < i) {
      if (((String)((Pair)ahme.a(this.this$0).BZ.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        ahme.c localc = (ahme.c)ahme.a(this.this$0).getChildViewHolder(ahme.a(this.this$0).getChildAt(paramInt1));
        if (!(localc instanceof ahme.b)) {
          break label170;
        }
        ((ahme.b)localc).zU.setImageBitmap(paramBitmap);
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label74;
      break;
      label170:
      QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "onDecodeTaskCompleted viewHolder in wrong instance ! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmg
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Collections;
import java.util.List;

class axsv
  implements aykn.e
{
  axsv(axsu paramaxsu) {}
  
  public void D(int paramInt, List<ptr> paramList)
  {
    ram.d("PasterDataManager", "onPOIPostersRequestResult callback");
    this.this$0.aGP = true;
    this.this$0.bn.removeCallbacks(this.this$0.du);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.EMPTY_LIST;
    }
    pmi.a().dispatch(new aykn.c(paramInt, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsv
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.biz.richframework.part.block.MultiViewBlock.1.1;
import com.tencent.biz.richframework.part.block.MultiViewBlock.1.2;
import com.tencent.biz.richframework.part.block.MultiViewBlock.1.3;
import com.tencent.biz.richframework.part.block.MultiViewBlock.1.4;
import com.tencent.biz.richframework.part.block.MultiViewBlock.1.5;
import com.tencent.biz.richframework.part.block.MultiViewBlock.1.6;

public class rxr
  extends RecyclerView.AdapterDataObserver
{
  rxr(rxq paramrxq) {}
  
  public void onChanged()
  {
    rxq.access$000(this.c).post(new MultiViewBlock.1.1(this));
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    rxq.access$000(this.c).post(new MultiViewBlock.1.2(this, paramInt1, paramInt2));
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    rxq.access$000(this.c).post(new MultiViewBlock.1.3(this, paramInt1, paramInt2, paramObject));
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    rxq.access$000(this.c).post(new MultiViewBlock.1.4(this, paramInt1, paramInt2));
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    rxq.access$000(this.c).post(new MultiViewBlock.1.6(this, paramInt1, paramInt2));
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    rxq.access$000(this.c).post(new MultiViewBlock.1.5(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxr
 * JD-Core Version:    0.7.0.1
 */
import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class uvm
  extends uvh
{
  private int b;
  
  public uvm(urv paramurv)
  {
    super(paramurv);
  }
  
  public List<usv> a(ArrayList paramArrayList)
  {
    paramArrayList = new ArrayList();
    Iterator localIterator = uep.a().a().iterator();
    while (localIterator.hasNext()) {
      paramArrayList.addAll((Collection)((uho)localIterator.next()).a());
    }
    paramArrayList = usd.a(paramArrayList);
    if (paramArrayList != null) {
      this.b = paramArrayList.size();
    }
    return paramArrayList;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    paramViewHolder = uep.a().a();
    urv localurv = a();
    int i;
    if (localurv != null)
    {
      i = paramInt;
      if (paramInt >= this.b) {
        i = this.b - 1;
      }
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < paramViewHolder.size())
      {
        uho localuho = (uho)paramViewHolder.get(paramInt);
        if ((localuho.b() <= i) && (localuho.b() + localuho.a() > i))
        {
          localuho.a(true);
          paramViewHolder = new WSFriendFeedExposureEvent((stSimpleMetaFeed)((usv)localurv.a().a(i)).a(), paramInt);
          uhf.a().a(paramViewHolder);
        }
      }
      else
      {
        return;
      }
      paramInt += 1;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    usm.a().a(this);
    return true;
  }
  
  public void b()
  {
    super.b();
    usm.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvm
 * JD-Core Version:    0.7.0.1
 */
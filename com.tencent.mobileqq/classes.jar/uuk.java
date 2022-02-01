import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class uuk
  extends uuf
{
  private int b;
  
  public uuk(uqu paramuqu)
  {
    super(paramuqu);
  }
  
  public List<uru> a(ArrayList paramArrayList)
  {
    paramArrayList = new ArrayList();
    Iterator localIterator = uen.a().a().iterator();
    while (localIterator.hasNext()) {
      paramArrayList.addAll((Collection)((uhj)localIterator.next()).a());
    }
    paramArrayList = urc.a(paramArrayList);
    if (paramArrayList != null) {
      this.b = paramArrayList.size();
    }
    return paramArrayList;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    paramViewHolder = uen.a().a();
    uqu localuqu = a();
    int i;
    if (localuqu != null)
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
        uhj localuhj = (uhj)paramViewHolder.get(paramInt);
        if ((localuhj.b() <= i) && (localuhj.b() + localuhj.a() > i))
        {
          localuhj.a(true);
          paramViewHolder = new WSFriendFeedExposureEvent((stSimpleMetaFeed)((uru)localuqu.a().a(i)).a(), paramInt);
          uhd.a().a(paramViewHolder);
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
    url.a().a(this);
    return true;
  }
  
  public void b()
  {
    super.b();
    url.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuk
 * JD-Core Version:    0.7.0.1
 */
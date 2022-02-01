import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class vdh
  extends vdc
{
  private int b;
  
  public vdh(uzq paramuzq)
  {
    super(paramuzq);
  }
  
  public List<vaq> a(ArrayList paramArrayList)
  {
    paramArrayList = new ArrayList();
    Iterator localIterator = ulf.a().a().iterator();
    while (localIterator.hasNext()) {
      paramArrayList.addAll((Collection)((uof)localIterator.next()).a());
    }
    paramArrayList = uzy.a(paramArrayList);
    if (paramArrayList != null) {
      this.b = paramArrayList.size();
    }
    return paramArrayList;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    paramViewHolder = ulf.a().a();
    uzq localuzq = a();
    int i;
    if (localuzq != null)
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
        uof localuof = (uof)paramViewHolder.get(paramInt);
        if ((localuof.b() <= i) && (localuof.b() + localuof.a() > i))
        {
          localuof.a(true);
          paramViewHolder = new WSFriendFeedExposureEvent((stSimpleMetaFeed)((vaq)localuzq.a().a(i)).a(), paramInt);
          unw.a().a(paramViewHolder);
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
    vah.a().a(this);
    return true;
  }
  
  public void b()
  {
    super.b();
    vah.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdh
 * JD-Core Version:    0.7.0.1
 */
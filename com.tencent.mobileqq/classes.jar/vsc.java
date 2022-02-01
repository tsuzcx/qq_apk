import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class vsc
  extends vrx
{
  private int b;
  
  public vsc(voi paramvoi)
  {
    super(paramvoi);
  }
  
  public List<vpj> a(ArrayList paramArrayList)
  {
    paramArrayList = new ArrayList();
    Iterator localIterator = uzf.a().a().iterator();
    while (localIterator.hasNext()) {
      paramArrayList.addAll((Collection)((vcf)localIterator.next()).a());
    }
    paramArrayList = voq.a(paramArrayList);
    if (paramArrayList != null) {
      this.b = paramArrayList.size();
    }
    return paramArrayList;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    paramViewHolder = uzf.a().a();
    voi localvoi = a();
    int i;
    if (localvoi != null)
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
        vcf localvcf = (vcf)paramViewHolder.get(paramInt);
        if ((localvcf.b() <= i) && (localvcf.b() + localvcf.a() > i))
        {
          localvcf.a(true);
          paramViewHolder = new WSFriendFeedExposureEvent((stSimpleMetaFeed)((vpj)localvoi.a().a(i)).a(), paramInt);
          vbw.a().a(paramViewHolder);
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
    vpa.a().a(this);
    return true;
  }
  
  public void b()
  {
    super.b();
    vpa.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsc
 * JD-Core Version:    0.7.0.1
 */
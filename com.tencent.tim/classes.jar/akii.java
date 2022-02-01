import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import java.util.Iterator;
import java.util.List;

public class akii
  extends akio.c
{
  public akii(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void Nm(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.this$0, paramString);
    if (paramString != null)
    {
      NearbyMomentFragment.a(this.this$0).getData().remove(paramString);
      NearbyMomentFragment.a(this.this$0).notifyDataSetChanged();
      NearbyMomentFragment.b(this.this$0, paramString.feedId);
    }
    if (NearbyMomentFragment.a(this.this$0).getData().size() == 0) {
      this.this$0.RR(1);
    }
    NearbyMomentFragment.a(this.this$0).remove(paramString);
  }
  
  public void Nn(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.this$0, paramString);
    if (paramString != null)
    {
      paramString.commentNum += 1;
      NearbyMomentFragment.a(this.this$0).notifyDataSetChanged();
    }
  }
  
  public void No(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.this$0, paramString);
    if ((paramString instanceof akjm))
    {
      paramString = (akjm)paramString;
      paramString.viewCount += 1;
    }
    for (;;)
    {
      NearbyMomentFragment.a(this.this$0).notifyDataSetChanged();
      return;
      if ((paramString instanceof akjg))
      {
        paramString = (akjg)paramString;
        paramString.viewCount += 1;
      }
    }
  }
  
  public void as(String paramString, long paramLong)
  {
    akjj localakjj = NearbyMomentFragment.a(this.this$0, paramString);
    if (localakjj != null)
    {
      if (localakjj.commentNum > 0) {
        localakjj.commentNum -= 1;
      }
      if ((localakjj.DV != null) && (localakjj.DV.size() > 0))
      {
        Iterator localIterator = localakjj.DV.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (akjh)localIterator.next();
        } while (paramString.adS != paramLong);
      }
    }
    for (;;)
    {
      if (paramString != null) {
        localakjj.DV.remove(paramString);
      }
      NearbyMomentFragment.a(this.this$0).notifyDataSetChanged();
      return;
      paramString = null;
    }
  }
  
  public void at(String paramString, long paramLong)
  {
    paramString = NearbyMomentFragment.a(this.this$0, paramString);
    if (paramString != null)
    {
      if (!paramString.isLiked)
      {
        paramString.isLiked = true;
        paramString.likeNum += 1;
      }
      NearbyMomentFragment.a(this.this$0).notifyDataSetChanged();
    }
  }
  
  public void au(String paramString, long paramLong)
  {
    paramString = NearbyMomentFragment.a(this.this$0, paramString);
    if ((paramString != null) && (paramString.isLiked))
    {
      paramString.isLiked = false;
      if (paramString.likeNum > 0) {
        paramString.likeNum -= 1;
      }
      NearbyMomentFragment.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akii
 * JD-Core Version:    0.7.0.1
 */
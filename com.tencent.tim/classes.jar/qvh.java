import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class qvh
  implements ppv.b<pyk, ppu>
{
  qvh(qvf paramqvf) {}
  
  public void a(@NonNull pyk parampyk, @Nullable ppu paramppu, @NonNull ErrorMessage paramErrorMessage)
  {
    paramppu = (pyk.a)paramppu;
    int j = paramErrorMessage.errorCode;
    int k = parampyk.nl.size();
    if (paramppu == null) {}
    for (int i = 0;; i = paramppu.nm.size())
    {
      ram.w("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), parampyk.nl });
      if ((!paramErrorMessage.isFail()) && (paramppu != null)) {
        break;
      }
      parampyk = parampyk.nk.iterator();
      while (parampyk.hasNext())
      {
        paramppu = (qvd)parampyk.next();
        qvf.i().remove(paramppu.mFeedId);
      }
    }
    if (parampyk.nk.size() != paramppu.nm.size())
    {
      paramErrorMessage = new ArrayList();
      parampyk = parampyk.nk.iterator();
      while (parampyk.hasNext())
      {
        qvd localqvd = (qvd)parampyk.next();
        if (!paramppu.af.contains(localqvd.mFeedId))
        {
          paramErrorMessage.add(localqvd.mFeedId);
          qvf.i().remove(localqvd.mFeedId);
        }
      }
      ram.w("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    parampyk = paramppu.nm.iterator();
    while (parampyk.hasNext())
    {
      paramppu = (qwa)parampyk.next();
      this.this$0.a(paramppu.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvh
 * JD-Core Version:    0.7.0.1
 */
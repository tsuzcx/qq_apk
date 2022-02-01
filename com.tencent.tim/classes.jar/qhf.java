import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class qhf
  implements ppv.b<pza, pza.a>
{
  qhf(qhe paramqhe, qgz.b paramb) {}
  
  public void a(@NonNull pza parampza, @Nullable pza.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (parama == null))
    {
      ram.b("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.b.a(paramErrorMessage, null, false);
      return;
    }
    this.a.a.e(parama.nk, parama.nextCookie, parama.isEnd);
    this.b.a(paramErrorMessage, qgr.aq(parama.nk), parama.isEnd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhf
 * JD-Core Version:    0.7.0.1
 */
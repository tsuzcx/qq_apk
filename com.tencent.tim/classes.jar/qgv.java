import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class qgv
  implements ppv.b<pzh, pzh.a>
{
  qgv(qgu paramqgu, qgz.b paramb) {}
  
  public void a(@NonNull pzh parampzh, @Nullable pzh.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (parama == null))
    {
      ram.b("Q.qqstory.player.data.HomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.b.a(paramErrorMessage, null, false);
      return;
    }
    qgu.a(this.a);
    this.a.a.e(parama.nk, parama.nextCookie, parama.isEnd);
    ((qvf)psx.a(11)).eE(parama.nk);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    boolean bool = qvr.a.a(parama, localAtomicBoolean);
    ram.w("Q.qqstory.player.data.HomeFeedPlayPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(parama.aCG), Integer.valueOf(qgu.b(this.a)), Boolean.valueOf(bool) });
    if ((!parama.isEnd) && (qgu.b(this.a) < 10) && ((!parama.aCG) || (bool)))
    {
      ram.w("Q.qqstory.player.data.HomeFeedPlayPageLoader", "feedId list not end, pull more");
      parampzh.cookie = this.a.a.mP();
      ppv.a().a(parampzh, this);
      return;
    }
    if (localAtomicBoolean.getAndSet(false)) {
      this.a.a.sortList();
    }
    this.b.a(paramErrorMessage, qgr.aq(parama.nk), parama.isEnd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgv
 * JD-Core Version:    0.7.0.1
 */
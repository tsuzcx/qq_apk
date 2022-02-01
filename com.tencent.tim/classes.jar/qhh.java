import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class qhh
  implements ppv.b<pyp, qac>
{
  qhh(qhg.a parama, qgz.c.a parama1) {}
  
  public void a(@NonNull pyp parampyp, @Nullable qac paramqac, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramqac == null) || (paramErrorMessage.isFail()))
    {
      this.b.b(paramErrorMessage, Collections.singletonList(this.a.d));
      return;
    }
    paramqac.nw = ((psu)psx.a(5)).al(paramqac.nw);
    parampyp = paramqac.nw.iterator();
    while (parampyp.hasNext()) {
      ((StoryVideoItem)parampyp.next()).mOwnerUid = qhg.a(this.a.a).uid;
    }
    ((pmq)psx.a(28)).updateList(paramqac.nx);
    parampyp = paramqac.nw.iterator();
    while (parampyp.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)parampyp.next();
      qhg.a.a(this.a).add(paramErrorMessage.mVid);
    }
    if ((paramqac.isEnd) || (paramqac.nw.size() == 0))
    {
      parampyp = new qgy.d(this.a.d);
      parampyp.nv = qhg.a.a(this.a);
      parampyp.rI(qhg.a(this.a.a).feedId);
      this.b.C(Collections.singletonList(parampyp), true);
      return;
    }
    qhg.a.a(this.a);
    if (qhg.a.b(this.a) > 50)
    {
      this.b.b(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.a.d));
      return;
    }
    this.a.a(paramqac.nextCookie, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhh
 * JD-Core Version:    0.7.0.1
 */
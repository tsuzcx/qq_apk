import java.util.Iterator;
import java.util.Set;

class qgf
  extends pmd
{
  qgf(qfz.a parama) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    ram.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = qfz.a.a(this.b).iterator();
    while (localIterator.hasNext()) {
      ((pmd)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgf
 * JD-Core Version:    0.7.0.1
 */
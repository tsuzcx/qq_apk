import java.util.Iterator;
import java.util.Set;

class tih
  extends sgc
{
  tih(tig paramtig) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    urk.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = tig.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((sgc)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tih
 * JD-Core Version:    0.7.0.1
 */
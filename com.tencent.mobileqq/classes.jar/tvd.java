import java.util.Iterator;
import java.util.Set;

class tvd
  extends ssy
{
  tvd(tvc paramtvc) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    veg.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = tvc.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((ssy)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvd
 * JD-Core Version:    0.7.0.1
 */
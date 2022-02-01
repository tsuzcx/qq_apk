import java.util.Iterator;
import java.util.Set;

class xhm
  extends wfi
{
  xhm(xhl paramxhl) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    yqp.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = xhl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((wfi)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhm
 * JD-Core Version:    0.7.0.1
 */
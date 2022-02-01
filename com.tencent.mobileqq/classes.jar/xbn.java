import java.util.Iterator;
import java.util.Set;

class xbn
  extends vzx
{
  xbn(xbm paramxbm) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    ykq.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = xbm.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((vzx)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbn
 * JD-Core Version:    0.7.0.1
 */
import java.util.Iterator;
import java.util.Set;

class vjs
  extends uhn
{
  vjs(vjr paramvjr) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    wsv.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = vjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((uhn)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjs
 * JD-Core Version:    0.7.0.1
 */
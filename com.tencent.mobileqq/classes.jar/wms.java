import java.util.Iterator;
import java.util.Set;

class wms
  extends vlc
{
  wms(wmr paramwmr) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    xvv.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = wmr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((vlc)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wms
 * JD-Core Version:    0.7.0.1
 */
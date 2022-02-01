import java.util.Iterator;
import java.util.Set;

class xlh
  extends wjd
{
  xlh(xlg paramxlg) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    yuk.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = xlg.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((wjd)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlh
 * JD-Core Version:    0.7.0.1
 */
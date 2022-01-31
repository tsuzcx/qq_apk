import java.util.Iterator;
import java.util.Set;

class vob
  extends ulw
{
  vob(voa paramvoa) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    wxe.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = voa.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((ulw)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vob
 * JD-Core Version:    0.7.0.1
 */
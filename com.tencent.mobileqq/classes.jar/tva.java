import java.util.Iterator;
import java.util.Set;

class tva
  extends ssv
{
  tva(tuz paramtuz) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    ved.a("Q.qqstory.playernew.StoryPlayerImpl", "QQStoryObserver, onUpdate, type=%d, isSuccess=%s, data=%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject);
    Iterator localIterator = tuz.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((ssv)localIterator.next()).onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tva
 * JD-Core Version:    0.7.0.1
 */
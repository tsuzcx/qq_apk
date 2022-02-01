import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class ywr
  extends zfi
{
  private final List<zex> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public zex a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (zex)this.a.get(paramInt);
    }
    return null;
  }
  
  public zex a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      zex localzex = (zex)localIterator.next();
      if (TextUtils.equals(paramString, localzex.a)) {
        return localzex;
      }
    }
    return null;
  }
  
  public void a(Collection<zex> paramCollection)
  {
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    this.a.clear();
    this.a.addAll(paramCollection);
    a();
  }
  
  public void a(zex paramzex)
  {
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramzex);
    int i = this.a.indexOf(paramzex);
    if (i >= 0)
    {
      this.a.set(i, paramzex);
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywr
 * JD-Core Version:    0.7.0.1
 */
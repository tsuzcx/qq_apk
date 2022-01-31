import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class wzl
  extends xic
{
  private final List<xhr> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public xhr a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (xhr)this.a.get(paramInt);
    }
    return null;
  }
  
  public xhr a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      xhr localxhr = (xhr)localIterator.next();
      if (TextUtils.equals(paramString, localxhr.a)) {
        return localxhr;
      }
    }
    return null;
  }
  
  public void a(Collection<xhr> paramCollection)
  {
    wxe.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    this.a.clear();
    this.a.addAll(paramCollection);
    a();
  }
  
  public void a(xhr paramxhr)
  {
    wxe.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramxhr);
    int i = this.a.indexOf(paramxhr);
    if (i >= 0)
    {
      this.a.set(i, paramxhr);
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzl
 * JD-Core Version:    0.7.0.1
 */
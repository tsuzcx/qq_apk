import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class vgk
  extends vpb
{
  private final List<voq> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public voq a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (voq)this.a.get(paramInt);
    }
    return null;
  }
  
  public voq a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      voq localvoq = (voq)localIterator.next();
      if (TextUtils.equals(paramString, localvoq.a)) {
        return localvoq;
      }
    }
    return null;
  }
  
  public void a(Collection<voq> paramCollection)
  {
    ved.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    this.a.clear();
    this.a.addAll(paramCollection);
    a();
  }
  
  public void a(voq paramvoq)
  {
    ved.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramvoq);
    int i = this.a.indexOf(paramvoq);
    if (i >= 0)
    {
      this.a.set(i, paramvoq);
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgk
 * JD-Core Version:    0.7.0.1
 */
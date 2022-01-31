import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class wvc
  extends xdt
{
  private final List<xdi> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public xdi a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (xdi)this.a.get(paramInt);
    }
    return null;
  }
  
  public xdi a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      xdi localxdi = (xdi)localIterator.next();
      if (TextUtils.equals(paramString, localxdi.a)) {
        return localxdi;
      }
    }
    return null;
  }
  
  public void a(Collection<xdi> paramCollection)
  {
    wsv.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    this.a.clear();
    this.a.addAll(paramCollection);
    a();
  }
  
  public void a(xdi paramxdi)
  {
    wsv.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramxdi);
    int i = this.a.indexOf(paramxdi);
    if (i >= 0)
    {
      this.a.set(i, paramxdi);
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvc
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class xyc
  extends ygj
{
  private final List<yfy> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public yfy a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (yfy)this.a.get(paramInt);
    }
    return null;
  }
  
  public yfy a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      yfy localyfy = (yfy)localIterator.next();
      if (TextUtils.equals(paramString, localyfy.a)) {
        return localyfy;
      }
    }
    return null;
  }
  
  public void a(Collection<yfy> paramCollection)
  {
    xvv.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    this.a.clear();
    this.a.addAll(paramCollection);
    a();
  }
  
  public void a(yfy paramyfy)
  {
    xvv.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramyfy);
    int i = this.a.indexOf(paramyfy);
    if (i >= 0)
    {
      this.a.set(i, paramyfy);
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyc
 * JD-Core Version:    0.7.0.1
 */
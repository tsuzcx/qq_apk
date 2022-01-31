import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class vgn
  extends vpe
{
  private final List<vot> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public vot a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (vot)this.a.get(paramInt);
    }
    return null;
  }
  
  public vot a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      vot localvot = (vot)localIterator.next();
      if (TextUtils.equals(paramString, localvot.a)) {
        return localvot;
      }
    }
    return null;
  }
  
  public void a(Collection<vot> paramCollection)
  {
    veg.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    this.a.clear();
    this.a.addAll(paramCollection);
    a();
  }
  
  public void a(vot paramvot)
  {
    veg.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramvot);
    int i = this.a.indexOf(paramvot);
    if (i >= 0)
    {
      this.a.set(i, paramvot);
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgn
 * JD-Core Version:    0.7.0.1
 */
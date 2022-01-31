import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class utr
  extends vci
{
  private final List<vbx> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public vbx a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (vbx)this.a.get(paramInt);
    }
    return null;
  }
  
  public vbx a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      vbx localvbx = (vbx)localIterator.next();
      if (TextUtils.equals(paramString, localvbx.a)) {
        return localvbx;
      }
    }
    return null;
  }
  
  public void a(Collection<vbx> paramCollection)
  {
    urk.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    this.a.clear();
    this.a.addAll(paramCollection);
    a();
  }
  
  public void a(vbx paramvbx)
  {
    urk.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramvbx);
    int i = this.a.indexOf(paramvbx);
    if (i >= 0)
    {
      this.a.set(i, paramvbx);
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utr
 * JD-Core Version:    0.7.0.1
 */
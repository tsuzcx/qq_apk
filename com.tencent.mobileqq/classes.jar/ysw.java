import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class ysw
  extends zbn
{
  private final List<zbc> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public zbc a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (zbc)this.a.get(paramInt);
    }
    return null;
  }
  
  public zbc a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      zbc localzbc = (zbc)localIterator.next();
      if (TextUtils.equals(paramString, localzbc.a)) {
        return localzbc;
      }
    }
    return null;
  }
  
  public void a(Collection<zbc> paramCollection)
  {
    yqp.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    this.a.clear();
    this.a.addAll(paramCollection);
    a();
  }
  
  public void a(zbc paramzbc)
  {
    yqp.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramzbc);
    int i = this.a.indexOf(paramzbc);
    if (i >= 0)
    {
      this.a.set(i, paramzbc);
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysw
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class ymv
  extends yvc
{
  private final List<yur> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public yur a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (yur)this.a.get(paramInt);
    }
    return null;
  }
  
  public yur a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      yur localyur = (yur)localIterator.next();
      if (TextUtils.equals(paramString, localyur.a)) {
        return localyur;
      }
    }
    return null;
  }
  
  public void a(Collection<yur> paramCollection)
  {
    ykq.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    this.a.clear();
    this.a.addAll(paramCollection);
    a();
  }
  
  public void a(yur paramyur)
  {
    ykq.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramyur);
    int i = this.a.indexOf(paramyur);
    if (i >= 0)
    {
      this.a.set(i, paramyur);
      a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymv
 * JD-Core Version:    0.7.0.1
 */
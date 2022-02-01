import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anyy
  extends anyz
  implements anxx<anyz>
{
  public List<anxu> children = new ArrayList();
  
  public anyy(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
  }
  
  public void a(anyz paramanyz)
  {
    if (paramanyz.c == null)
    {
      this.children.add(paramanyz);
      paramanyz.c = this;
      paramanyz.onAdded();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public boolean azq()
  {
    boolean bool = super.azq();
    int i = 0;
    while (i < this.children.size())
    {
      bool |= ((anyz)this.children.get(i)).azq();
      i += 1;
    }
    return bool;
  }
  
  public List<anxu> getChildren()
  {
    return this.children;
  }
  
  public void pause()
  {
    Iterator localIterator = this.children.iterator();
    while (localIterator.hasNext()) {
      ((anxu)localIterator.next()).pause();
    }
  }
  
  public void release()
  {
    super.release();
    int i = 0;
    while (i < this.children.size())
    {
      ((anyz)this.children.get(i)).release();
      i += 1;
    }
    this.children.clear();
  }
  
  public void resume()
  {
    Iterator localIterator = this.children.iterator();
    while (localIterator.hasNext()) {
      ((anxu)localIterator.next()).resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyy
 * JD-Core Version:    0.7.0.1
 */
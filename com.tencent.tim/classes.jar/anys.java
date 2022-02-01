import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anys
  extends anyt
  implements anxx<anyt>, anyt.a
{
  public List<anxu> children = new ArrayList();
  
  public anys(SpriteGLView paramSpriteGLView)
  {
    this.b = paramSpriteGLView;
  }
  
  public void a(anyt paramanyt)
  {
    if (paramanyt.c == null)
    {
      this.children.add(paramanyt);
      paramanyt.c = this;
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject = this.children.toArray();
    int i = arrayOfObject.length - 1;
    while (i >= 0)
    {
      if (((arrayOfObject[i] instanceof anyt.a)) && (((anyt.a)arrayOfObject[i]).a(paramMotionEvent, paramInt1, paramInt2))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    int i = 0;
    while (i < this.children.size())
    {
      ((anyt)this.children.get(i)).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      i += 1;
    }
  }
  
  protected void dTS()
  {
    Iterator localIterator = this.children.iterator();
    while (localIterator.hasNext())
    {
      anxu localanxu = (anxu)localIterator.next();
      if ((localanxu instanceof anyu)) {
        ((anyu)localanxu).dTS();
      }
    }
  }
  
  public List<anxu> getChildren()
  {
    return this.children;
  }
  
  public void release()
  {
    super.release();
    int i = 0;
    while (i < this.children.size())
    {
      ((anyt)this.children.get(i)).release();
      i += 1;
    }
    this.children.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anys
 * JD-Core Version:    0.7.0.1
 */
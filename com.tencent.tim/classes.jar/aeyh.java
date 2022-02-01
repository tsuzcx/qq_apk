import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class aeyh
  extends aexy<aexi>
{
  private SparseArray<List<aeyh.a>> cw = new SparseArray();
  
  public abstract aeyh.a a(int paramInt);
  
  public aeys a(aexi paramaexi)
  {
    int i = h(paramaexi.getData());
    List localList = (List)this.cw.get(i);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.cw.put(i, localObject);
    }
    if (((List)localObject).isEmpty()) {
      ((List)localObject).add(a(i));
    }
    localObject = (aeyh.a)((List)localObject).remove(0);
    a(i, (aeyh.a)localObject, paramaexi);
    ((aeyh.a)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramaexi.getScreenWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramaexi.getScreenHeight(), -2147483648));
    ((aeyh.a)localObject).layout(0, 0, ((aeyh.a)localObject).CP(), ((aeyh.a)localObject).getMeasureHeight());
    paramaexi.a((aeyh.a)localObject);
    paramaexi.setContentWidth(((aeyh.a)localObject).CP());
    paramaexi.setContentHeight(((aeyh.a)localObject).getMeasureHeight());
    return new aeys(((aeyh.a)localObject).CP(), ((aeyh.a)localObject).getMeasureHeight());
  }
  
  public abstract void a(int paramInt, aeyh.a parama, aexi paramaexi);
  
  public void a(aexi paramaexi)
  {
    aeyh.a locala = paramaexi.a();
    if (locala != null)
    {
      int i = h(paramaexi.getData());
      List localList = (List)this.cw.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.cw.put(i, localObject);
      }
      ((List)localObject).add(locala);
      paramaexi.a(null);
    }
  }
  
  public void a(Canvas paramCanvas, aexi paramaexi, aexj paramaexj, float paramFloat1, float paramFloat2)
  {
    paramaexj = paramaexi.a();
    if (paramaexj == null) {
      return;
    }
    if (!paramaexi.aiA())
    {
      paramaexj.measure(View.MeasureSpec.makeMeasureSpec(paramaexj.CP(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramaexj.getMeasureHeight(), 1073741824));
      paramaexj.layout(0, 0, paramaexj.CP(), paramaexj.getMeasureHeight());
      paramaexi.HB(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramaexj.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean b(aexe paramaexe)
  {
    return paramaexe instanceof aexi;
  }
  
  public int h(Object paramObject)
  {
    return 0;
  }
  
  public static class a
  {
    private RectF aE = new RectF();
    private Paint bS = new Paint();
    protected final View mItemView;
    
    public a(View paramView)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("itemView may not be null");
      }
      this.mItemView = paramView;
    }
    
    private View a(View paramView, float paramFloat1, float paramFloat2)
    {
      RectF localRectF = new RectF();
      int i = 0;
      Object localObject = null;
      Iterator localIterator = paramView.getTouchables().iterator();
      View localView;
      float f1;
      if (localIterator.hasNext())
      {
        localView = (View)localIterator.next();
        f1 = localView.getX();
        float f2 = localView.getY();
        localRectF.set(f1, f2, localView.getMeasuredWidth() + f1, localView.getMeasuredWidth() + f2);
        if (!localRectF.contains(paramFloat1, paramFloat2)) {
          break label160;
        }
        if (localView.equals(paramView)) {
          i = 1;
        }
      }
      label160:
      for (;;)
      {
        break;
        localObject = localView;
        if ((localView instanceof ViewGroup))
        {
          localObject = a(paramView, paramFloat1 - f1, paramFloat2 - paramFloat1);
          continue;
          if ((i != 0) && (localObject == null)) {
            localObject = paramView;
          }
        }
        else
        {
          return localObject;
        }
        return localObject;
      }
    }
    
    public int CP()
    {
      return this.mItemView.getMeasuredWidth();
    }
    
    public View a(aeyr paramaeyr)
    {
      return a(this.mItemView, paramaeyr.getX(), paramaeyr.getY());
    }
    
    public void draw(Canvas paramCanvas)
    {
      this.aE.set(0.0F, 0.0F, this.mItemView.getMeasuredWidth(), this.mItemView.getMeasuredHeight());
      this.bS.setAlpha((int)(this.mItemView.getAlpha() * 255.0F));
      int i = paramCanvas.saveLayer(this.aE, this.bS, 31);
      this.mItemView.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
    
    public int getMeasureHeight()
    {
      return this.mItemView.getMeasuredHeight();
    }
    
    public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.mItemView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void measure(int paramInt1, int paramInt2)
    {
      this.mItemView.measure(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyh
 * JD-Core Version:    0.7.0.1
 */
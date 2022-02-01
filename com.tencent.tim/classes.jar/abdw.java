import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.PinnedDividerListView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.Hashtable;

public abstract class abdw
  extends PinnedDividerListView.a
  implements aqdf.a, AbsListView.e
{
  private XListView C;
  protected aqdf a;
  private boolean bBY;
  private boolean bBZ;
  protected Bitmap du;
  private Hashtable<String, Bitmap> h = new Hashtable();
  private int mCurrentScrollState = 0;
  
  public abdw(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    this.C = paramXListView;
    if (this.C != null) {
      this.C.setOnScrollListener(this);
    }
    this.bBZ = paramBoolean;
    this.a = new aqdf(paramContext, paramQQAppInterface);
    this.a.a(this);
    if (this.du == null) {
      this.du = aqhu.G();
    }
  }
  
  public Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    return a(paramString, paramInt, paramByte, 0);
  }
  
  public Bitmap a(String paramString, int paramInt1, byte paramByte, int paramInt2)
  {
    Bitmap localBitmap = this.a.b(paramInt1, paramString, paramInt2);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.bBY)
    {
      this.a.edu();
      this.bBY = false;
    }
    if (!this.a.isPausing()) {
      this.a.a(paramString, paramInt1, true, paramByte);
    }
    return this.du;
  }
  
  protected boolean a(abeg.a parama)
  {
    return (parama != null) && (parama.uin != null) && (parama.uin.length() > 0);
  }
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.destory();
    }
    this.C = null;
  }
  
  protected Bitmap e(String paramString, int paramInt)
  {
    return a(paramString, 1, (byte)0, paramInt);
  }
  
  public int getCount()
  {
    return 0;
  }
  
  protected Bitmap getFaceBitmap(String paramString)
  {
    return a(paramString, 1, (byte)0);
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.bBY) {
      if (paramInt1 == 0) {
        this.bBY = false;
      }
    }
    do
    {
      return;
      if (paramBitmap != null) {
        this.h.put(paramString, paramBitmap);
      }
    } while (paramInt1 > 0);
    if ((this.mCurrentScrollState == 0) && (this.C != null))
    {
      paramInt2 = this.C.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.C.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof abeg.a)))
        {
          paramString = (abeg.a)paramString;
          if (a(paramString))
          {
            paramBitmap = (Bitmap)this.h.get(paramString.uin);
            if (paramBitmap != null) {
              paramString.pQ.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
    }
    this.h.clear();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mCurrentScrollState = paramInt;
    if (paramInt != 0)
    {
      this.bBY = false;
      this.a.edu();
      this.a.pause();
    }
    for (;;)
    {
      return;
      if (this.a.isPausing()) {
        this.a.resume();
      }
      if (this.C != null)
      {
        int i = this.C.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          paramAbsListView = (abeg.a)this.C.getChildAt(paramInt).getTag();
          if (a(paramAbsListView)) {
            paramAbsListView.pQ.setImageBitmap(a(paramAbsListView.uin, paramAbsListView.type, (byte)0));
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdw
 * JD-Core Version:    0.7.0.1
 */
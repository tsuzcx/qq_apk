import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rnl
  extends BaseAdapter
{
  private rnm a;
  private Context context;
  private int mFrameCount;
  private int mFrameHeight;
  private int mFrameWidth;
  
  public rnl(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.context = paramContext;
    this.mFrameCount = paramInt1;
    this.mFrameWidth = paramInt2;
    this.mFrameHeight = paramInt3;
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramLocalMediaInfo);
  }
  
  public void a(rnm paramrnm)
  {
    this.a = paramrnm;
  }
  
  public int getCount()
  {
    return this.mFrameCount;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new ImageView(this.context);
      int i = (int)(rex.a(this.context.getResources()) * this.mFrameWidth);
      paramView = new ViewGroup.LayoutParams(this.mFrameWidth, i);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject).setLayoutParams(paramView);
      paramView = new rnl.a();
      paramView.nx = ((ImageView)localObject);
      paramView.nx.setImageDrawable(new ColorDrawable(-12303292));
      ((View)localObject).setTag(paramView);
    }
    for (;;)
    {
      this.a.a(paramView.nx, Integer.valueOf(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      rnl.a locala = (rnl.a)paramView.getTag();
      localObject = paramView;
      paramView = locala;
    }
  }
  
  public Bitmap i(int paramInt)
  {
    return null;
  }
  
  public void release()
  {
    this.a = null;
    this.context = null;
  }
  
  static class a
  {
    public ImageView nx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rnl
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery.LayoutParams;

public class aluy
  extends BaseAdapter
{
  private int dyd;
  private String[] go;
  private Context mContext;
  private int mHeight = 25;
  private int mTextColor;
  
  public aluy(Context paramContext, String[] paramArrayOfString, int paramInt)
  {
    this.mContext = paramContext;
    this.mHeight = ((int)TypedValue.applyDimension(1, paramInt, this.mContext.getResources().getDisplayMetrics()));
    this.go = paramArrayOfString;
    paramContext = this.mContext.getResources();
    this.mTextColor = paramContext.getColor(2131167389);
    this.dyd = paramContext.getColor(2131167363);
  }
  
  public View H(int paramInt)
  {
    return getView(paramInt, null, null);
  }
  
  public int getCount()
  {
    if (this.go != null) {
      return this.go.length;
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new WheelTextView(this.mContext);
      ((View)localObject1).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.mHeight));
    }
    for (paramView = (WheelTextView)localObject1;; paramView = (View)localObject2)
    {
      String str = this.go[paramInt];
      localObject2 = paramView;
      if (paramView == null) {
        localObject2 = (WheelTextView)localObject1;
      }
      ((WheelTextView)localObject2).setTextSize(20.0F);
      ((WheelTextView)localObject2).setTextColor(this.mTextColor);
      ((WheelTextView)localObject2).setGravity(17);
      ((WheelTextView)localObject2).setText(str);
      ((WheelTextView)localObject2).setBackgroundColor(this.dyd);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aluy
 * JD-Core Version:    0.7.0.1
 */
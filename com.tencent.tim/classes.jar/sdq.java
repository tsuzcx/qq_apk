import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sdq
  extends BaseAdapter
{
  public static final int[] ew = { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 43, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105 };
  public static final int[] ex = { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 43, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141 };
  public static final int[] ey = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  sdt a;
  private final int bwt = 2130839207;
  private int bwu;
  private Integer[] d;
  private Context mContext;
  
  public sdq(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, sdt paramsdt)
  {
    this.mContext = paramContext;
    this.d = new Integer[paramInt3];
    this.a = paramsdt;
    this.bwu = paramInt4;
    paramInt4 = 0;
    if (paramInt4 < paramInt3)
    {
      int i;
      if (paramInt4 < paramInt2)
      {
        i = ex[((paramInt1 - 1) * (paramInt3 - 1) + paramInt4)];
        int j = ey[((paramInt1 - 1) * (paramInt3 - 1) + paramInt4)];
        paramContext = "f_static_";
        if (j == 1) {
          paramContext = "f";
        }
        if (i < 10)
        {
          paramContext = paramContext + "00" + i;
          label130:
          if ((i < 0) || (i >= 107)) {
            break label278;
          }
          this.d[paramInt4] = Integer.valueOf(sdy.eA[i]);
          QLog.d("CommentInputPopupWindow", 2, "step1 has current id :" + this.d[paramInt4] + " " + paramContext + "  ");
        }
      }
      for (;;)
      {
        paramInt4 += 1;
        break;
        if (i < 100)
        {
          paramContext = paramContext + "0" + i;
          break label130;
        }
        paramContext = paramContext + "10" + (i - 100);
        break label130;
        label278:
        this.d[paramInt4] = Integer.valueOf(0);
        continue;
        this.d[paramInt4] = Integer.valueOf(0);
      }
    }
    this.d[(paramInt3 - 1)] = Integer.valueOf(2130839207);
  }
  
  public int getCount()
  {
    return this.d.length;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ImageView localImageView;
    LinearLayout localLinearLayout;
    if (paramView == null)
    {
      localImageView = new ImageView(this.mContext);
      int i = wja.dp2px(35.0F, this.mContext.getResources());
      Object localObject = new LinearLayout.LayoutParams(i, i);
      ((LinearLayout.LayoutParams)localObject).setMargins(i / 5, i / 5, i / 5, i / 5);
      localImageView.setAdjustViewBounds(false);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localLinearLayout = new LinearLayout(this.mContext);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      localLinearLayout.setGravity(17);
      localLinearLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new sdq.a(null);
      ((sdq.a)localObject).imageView = localImageView;
      localLinearLayout.setTag(localObject);
    }
    for (;;)
    {
      localImageView = ((sdq.a)localLinearLayout.getTag()).imageView;
      try
      {
        if (this.d[paramInt].intValue() != 0)
        {
          localImageView.setImageResource(this.d[paramInt].intValue());
          localImageView.setVisibility(0);
        }
        for (;;)
        {
          label192:
          localImageView.setOnClickListener(new sdr(this, paramInt));
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localLinearLayout;
          localLinearLayout = (LinearLayout)paramView;
          break;
          localImageView.setVisibility(8);
          QLog.d("CommentInputPopupWindow", 2, "set gone because of 000:");
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label192;
      }
    }
  }
  
  class a
  {
    public ImageView imageView;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdq
 * JD-Core Version:    0.7.0.1
 */
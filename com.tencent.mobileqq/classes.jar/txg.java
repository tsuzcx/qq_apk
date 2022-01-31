import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class txg
  extends BaseAdapter
{
  private float jdField_a_of_type_Float = 11.0F;
  private int jdField_a_of_type_Int = 1;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private final ArrayList<FeedCloudMeta.StTagInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final WeakReference<Context> jdField_a_of_type_MqqUtilWeakReference;
  private final ArrayList<FeedCloudMeta.StTagInfo> b = new ArrayList();
  
  public txg(Context paramContext)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130843642);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(14.0F), ImmersiveUtils.a(14.0F));
    }
  }
  
  private TextView a()
  {
    TextView localTextView = new TextView((Context)this.jdField_a_of_type_MqqUtilWeakReference.get());
    localTextView.setIncludeFontPadding(false);
    localTextView.setPadding(ImmersiveUtils.a(5.0F), 0, ImmersiveUtils.a(10.0F), 0);
    localTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
    localTextView.setCompoundDrawablePadding(ImmersiveUtils.a(2.0F));
    localTextView.setGravity(17);
    localTextView.setTextColor(-1);
    localTextView.setMaxLines(1);
    localTextView.setBackgroundResource(2130843543);
    localTextView.setTextSize(1, this.jdField_a_of_type_Float);
    return localTextView;
  }
  
  private void a(boolean paramBoolean)
  {
    int m = 0;
    this.b.clear();
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(ImmersiveUtils.a(this.jdField_a_of_type_Float));
    int n = ImmersiveUtils.a() - ImmersiveUtils.a(12.0F) * 2 - ImmersiveUtils.a(7.0F) - ImmersiveUtils.a(14.0F) * 2;
    int k;
    int i;
    int j;
    float f1;
    float f2;
    if (paramBoolean)
    {
      k = 1;
      i = 0;
      j = 1;
      f1 = 0.0F;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label300;
      }
      f2 = localTextPaint.measureText(b((FeedCloudMeta.StTagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i))) + ImmersiveUtils.a(14.0F) + ImmersiveUtils.a(4.0F) + ImmersiveUtils.a(13.0F);
      if (f1 + f2 <= n) {
        break label261;
      }
      j += 1;
      if (j <= k) {
        break label250;
      }
      if (!paramBoolean) {
        break label233;
      }
      if (f1 <= n) {
        break label297;
      }
      i -= 1;
    }
    for (;;)
    {
      label169:
      if (j <= k)
      {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_a_of_type_Int = 1;
        j = m;
      }
      for (;;)
      {
        if (j >= i) {
          break label296;
        }
        this.b.add(this.jdField_a_of_type_JavaUtilArrayList.get(j));
        j += 1;
        continue;
        k = 3;
        break;
        label233:
        if (f1 <= n) {
          break label297;
        }
        i -= 1;
        break label169;
        label250:
        for (f1 = f2;; f1 += f2)
        {
          i += 1;
          break;
        }
        label261:
        if (paramBoolean)
        {
          this.jdField_a_of_type_Int = 2;
          j = m;
        }
        else
        {
          this.jdField_a_of_type_Int = 3;
          j = m;
        }
      }
      label296:
      return;
      label297:
      continue;
      label300:
      i = 0;
    }
  }
  
  private static String b(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    String str = paramStTagInfo.tagName.get();
    paramStTagInfo = str;
    if (bdnn.a(str) > 22) {
      paramStTagInfo = bdnn.a(str, 0, 22) + "...";
    }
    return paramStTagInfo;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int != 2) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      notifyDataSetChanged();
      return this.jdField_a_of_type_Int;
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b.clear();
    if ((paramStFeed != null) && (paramStFeed.tagInfos.get().size() > 0))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramStFeed.tagInfos.get());
    }
    for (;;)
    {
      a(true);
      notifyDataSetChanged();
      return;
      wxe.e("FeedTagAdapter", "TagList size 0");
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 2;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new FrameLayout((Context)this.jdField_a_of_type_MqqUtilWeakReference.get());
      paramView = new FrameLayout.LayoutParams(-2, ImmersiveUtils.a(21.0F));
      paramView.rightMargin = ImmersiveUtils.a(6.0F);
      paramView.bottomMargin = ImmersiveUtils.a(9.0F);
      ((FrameLayout)localObject).addView(a(), paramView);
      paramView = new txh((FrameLayout)localObject);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a((FeedCloudMeta.StTagInfo)this.b.get(paramInt), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      ((View)localObject).setTag(2131373881, Integer.valueOf(getItemViewType(paramInt)));
      return localObject;
      paramViewGroup = (txh)paramView.getTag();
      localObject = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txg
 * JD-Core Version:    0.7.0.1
 */
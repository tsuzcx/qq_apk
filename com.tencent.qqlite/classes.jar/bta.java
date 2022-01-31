import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PanelAdapter;
import com.tencent.mobileqq.activity.aio.PanelAdapter.ViewHolder;

public class bta
  extends LinearLayout
{
  public int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  
  public bta(PanelAdapter paramPanelAdapter, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    int k = paramPanelAdapter.a();
    int m = paramPanelAdapter.b();
    int i = 0;
    while (i < m)
    {
      paramPanelAdapter = new LinearLayout(paramContext);
      paramAttributeSet = new LinearLayout.LayoutParams(-1, -1);
      paramAttributeSet.weight = 1.0F;
      paramPanelAdapter.setOrientation(0);
      int j = 0;
      while (j < k)
      {
        Object localObject = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        if (j == 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(23.0F, getContext().getResources());
        }
        if (j == k - 1) {
          ((LinearLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(23.0F, getContext().getResources());
        }
        if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
          this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
        }
        View localView = LayoutInflater.from(paramContext).inflate(2130903099, null);
        paramPanelAdapter.addView(localView, (ViewGroup.LayoutParams)localObject);
        localObject = new PanelAdapter.ViewHolder();
        ((PanelAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296763));
        ((PanelAdapter.ViewHolder)localObject).b = ((ImageView)localView.findViewById(2131296765));
        ((PanelAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296764));
        localView.setTag(localObject);
        j += 1;
      }
      addView(paramPanelAdapter, paramAttributeSet);
      i += 1;
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if (localObject != null)
      {
        localObject = (PanelAdapter.ViewHolder)((View)localObject).getTag();
        if ((localObject != null) && (((PanelAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView != null)) {
          ((PanelAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bta
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.gdtad.api.adbox.GdtAdBoxDialogCompact.1;
import java.util.List;

public class tgw
  extends tgq
{
  private final boolean aOW;
  
  public tgw(@NonNull Context paramContext)
  {
    super(paramContext);
    if (this.mActivity.getResources().getConfiguration().orientation == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.aOW = bool;
      return;
    }
  }
  
  protected void a(tgy paramtgy)
  {
    int i;
    if (this.aOW)
    {
      tkw.d("GdtAdBoxDialog", "bindData() called with: model = [" + paramtgy + "]");
      i = this.jdField_a_of_type_Tgo.a().getAds().size();
      if (i == 0)
      {
        tkw.d("GdtAdBoxDialog", "bindData() called with: total = [" + i + "]");
        this.mContentView.post(new GdtAdBoxDialogCompact.1(this));
        return;
      }
      if (i <= 9) {
        break label399;
      }
      i = 9;
    }
    label399:
    for (;;)
    {
      int m = (int)Math.ceil(i * 1.0F / 3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setColumnCount(3);
      this.jdField_a_of_type_AndroidWidgetGridLayout.setRowCount(m);
      int n = tls.dp2px(21.0F, this.mActivity.getResources());
      int i1 = tls.dp2px(18.0F, this.mActivity.getResources());
      int i2 = tls.dp2px(8.0F, this.mActivity.getResources());
      int i3 = tls.dp2px(0.0F, this.mActivity.getResources());
      int i4 = tls.dp2px(55.0F, this.mActivity.getResources());
      int i5 = i4 + tls.dp2px(21.0F, this.mActivity.getResources());
      int i6 = tls.dp2px(16.0F, this.mActivity.getResources());
      this.jdField_a_of_type_AndroidWidgetGridLayout.removeAllViews();
      paramtgy = LayoutInflater.from(this.mActivity);
      int j = 0;
      if (j < m)
      {
        int k = 0;
        for (;;)
        {
          if ((k >= 3) || (3 * j + k >= i))
          {
            j += 1;
            break;
          }
          LinearLayout localLinearLayout = (LinearLayout)paramtgy.inflate(2131559383, null);
          super.a(3, n, i1, i4, i5, i6, j, k, localLinearLayout);
          this.jdField_a_of_type_AndroidWidgetGridLayout.addView(localLinearLayout);
          k += 1;
        }
      }
      paramtgy = this.mContentView.getLayoutParams();
      paramtgy.width = (3 * (i4 + i6) + n + i2);
      paramtgy.height = ((i5 + i6) * m + i1 + i3);
      this.mContentView.setLayoutParams(paramtgy);
      return;
      super.a(paramtgy);
      return;
    }
  }
  
  protected void bCU()
  {
    if (this.aOW)
    {
      tkw.d("GdtAdBoxDialog", "landscape");
      if (this.mContentView != null)
      {
        ImageView localImageView = (ImageView)this.mContentView.findViewById(2131369916);
        Object localObject = localImageView.getLayoutParams();
        if ((localObject instanceof FrameLayout.LayoutParams))
        {
          localObject = (FrameLayout.LayoutParams)localObject;
          ((FrameLayout.LayoutParams)localObject).width = tls.dp2px(24.0F, this.mActivity.getResources());
          ((FrameLayout.LayoutParams)localObject).height = tls.dp2px(24.0F, this.mActivity.getResources());
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localImageView = (ImageView)findViewById(2131381449);
        int i = tls.dp2px(5.0F, this.mActivity.getResources());
        localImageView.setPadding(i, i, i, i);
      }
      return;
    }
    super.bCU();
    tkw.d("GdtAdBoxDialog", "portrait");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgw
 * JD-Core Version:    0.7.0.1
 */
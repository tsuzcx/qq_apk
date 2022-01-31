import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.RateWidget.1;
import com.tencent.biz.qqstory.view.widget.RateWidget.2;
import dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar;
import java.text.DecimalFormat;

public class vqp
  extends vqf
  implements View.OnClickListener, bisf
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312479);
  private RateWidgetRatingBar jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractRateWidgetRatingBar = (RateWidgetRatingBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131308962);
  private vqq jdField_a_of_type_Vqq;
  private vqr jdField_a_of_type_Vqr;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131308958);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private TextView d;
  
  public vqp(Context paramContext)
  {
    super(paramContext, 2131494992);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractRateWidgetRatingBar.setOnRatingChangeListener(this);
    try
    {
      this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundResource(2130843706);
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      urk.c("RateWidget", "RateWidget set background failed : %s", paramContext);
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView.getHint().toString();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractRateWidgetRatingBar.setRating((int)paramFloat);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    if (paramInt <= 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("0");
      this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
      this.jdField_d_of_type_AndroidWidgetTextView.setText("0人参与");
      return;
    }
    float f = (float)paramLong * 1.0F / (paramInt * 1.0F);
    Object localObject = new DecimalFormat(".0").format(f);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("0");
      this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
      this.jdField_d_of_type_AndroidWidgetTextView.setText("0人参与");
      return;
    }
    localObject = ((String)localObject).split("\\.");
    if (localObject.length == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localObject[0]);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramInt + ajjy.a(2131646911));
      return;
      if (localObject.length == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localObject[0]);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(localObject[1]);
      }
    }
  }
  
  public void a(vqq paramvqq, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Vqq = paramvqq;
      paramvqq = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i = 0;; i = 8)
    {
      paramvqq.setVisibility(i);
      return;
    }
  }
  
  public void a(vqr paramvqr)
  {
    this.jdField_a_of_type_Vqr = paramvqr;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramArrayOfString[0]);
  }
  
  public Rect[] a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidWidgetTextView.getHitRect(localRect);
    return new Rect[] { localRect };
  }
  
  public String[] a()
  {
    return new String[] { this.jdField_a_of_type_AndroidWidgetTextView.getText().toString() };
  }
  
  protected View b()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidViewView.getContext()).inflate(2131494991, null).findViewById(2131308957);
    localView.setLayoutParams(new ViewGroup.LayoutParams(vms.a(this.jdField_a_of_type_AndroidViewView.getContext(), 225.0F), vms.a(this.jdField_a_of_type_AndroidViewView.getContext(), 54.0F)));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131312477));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131312478));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131312228));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131303683));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297252));
    this.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(this);
    return localView;
  }
  
  public void b(float paramFloat)
  {
    if (this.jdField_a_of_type_Vqr != null) {
      this.jdField_a_of_type_Vqr.a(this, paramFloat);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractRateWidgetRatingBar.setRatable(paramBoolean);
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    float f1 = this.e;
    float f2 = this.jdField_a_of_type_Float;
    float f3 = this.jdField_c_of_type_Float;
    float f4 = this.f;
    float f5 = this.jdField_a_of_type_Float;
    float f6 = this.jdField_d_of_type_Float;
    int i = this.jdField_b_of_type_AndroidViewView.getHeight();
    int j = this.jdField_b_of_type_AndroidViewView.getWidth();
    int k = this.jdField_a_of_type_AndroidViewView.getWidth();
    int m = this.jdField_a_of_type_AndroidViewView.getHeight();
    float f7 = -(m * 1.0F / 2.0F + i * 1.0F / 2.0F - vms.a(this.jdField_b_of_type_AndroidViewView.getContext(), 4.0F));
    float[] arrayOfFloat = vlx.a(vms.a(this.jdField_b_of_type_AndroidViewView.getContext(), 37.0F), f7, this.jdField_b_of_type_Float);
    f7 = arrayOfFloat[0];
    float f8 = arrayOfFloat[1];
    this.jdField_b_of_type_AndroidViewView.setX(f1 * f2 + f3 + this.g * f7 - j * 1.0F / 2.0F);
    this.jdField_b_of_type_AndroidViewView.setY(f4 * f5 + f6 + this.h * f8 - i * 1.0F / 2.0F);
    this.jdField_b_of_type_AndroidViewView.setRotation(this.jdField_b_of_type_Float);
    this.jdField_b_of_type_AndroidViewView.setScaleX(this.g);
    this.jdField_b_of_type_AndroidViewView.setScaleY(this.h);
    urk.a("InteractPasterWidget", "relayoutAttendView %d", Integer.valueOf(this.jdField_b_of_type_AndroidViewView.hashCode()));
    urk.b("InteractPasterWidget", "relayoutAttendView 2widgets(%d, %d, %d, %d)  stack=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), vlk.a(5) });
    urk.a("InteractPasterWidget", "relayoutAttendView offset(%.2f, %.2f, %.2f, %.2f)", Float.valueOf(this.jdField_c_of_type_Float), Float.valueOf(this.jdField_d_of_type_Float), Float.valueOf(f7), Float.valueOf(f8));
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 2130843700;; i = 0)
    {
      localTextView.setBackgroundResource(i);
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      while (i < 2500)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RateWidget.1(this), i);
        i += 500;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RateWidget.2(this), i);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    c(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Vqq == null);
    this.jdField_a_of_type_Vqq.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqp
 * JD-Core Version:    0.7.0.1
 */
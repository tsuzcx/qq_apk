import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import java.util.Locale;

public class zpf
  extends zpd
  implements View.OnTouchListener
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c = { 2130844657, 2130844660 };
  public static final int[] d = { 2131378729, 2131378730 };
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public boolean a;
  TextView b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131363877, 2131363878 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130844656, 2130844659 };
  }
  
  public zpf(zpi paramzpi, View paramView, int paramInt)
  {
    super(paramzpi, paramView);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(jdField_a_of_type_ArrayOfInt[paramInt]));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(d[paramInt]));
    paramView.setOnTouchListener(this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView.getText();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(Locale.getDefault(), "%.0f%%", new Object[] { Float.valueOf(paramFloat) }));
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (CharSequence localCharSequence = this.jdField_a_of_type_AndroidWidgetTextView.getHint();; localCharSequence = paramCharSequence)
    {
      int j;
      int k;
      float[] arrayOfFloat1;
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        j = 1;
        if (j == 0) {
          break label201;
        }
        k = zps.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 72.5F);
        arrayOfFloat1 = new float[3];
        float[] tmp55_53 = arrayOfFloat1;
        tmp55_53[0] = 21.0F;
        float[] tmp60_55 = tmp55_53;
        tmp60_55[1] = 18.0F;
        float[] tmp65_60 = tmp60_55;
        tmp65_60[2] = 14.0F;
        tmp65_60;
      }
      int i;
      int n;
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(k);
        float[] arrayOfFloat2 = new float[localCharSequence.length()];
        Paint localPaint = new Paint(this.jdField_a_of_type_AndroidWidgetTextView.getPaint());
        i = 0;
        if (i >= arrayOfFloat1.length) {
          break label335;
        }
        localPaint.setTextSize(TypedValue.applyDimension(1, arrayOfFloat1[i], this.jdField_a_of_type_AndroidWidgetTextView.getResources().getDisplayMetrics()));
        localPaint.getTextWidths(localCharSequence.toString(), arrayOfFloat2);
        n = 0;
        int i1 = arrayOfFloat2.length;
        int m = 0;
        while (m < i1)
        {
          float f = arrayOfFloat2[m];
          n = (int)(n + f);
          m += 1;
        }
        j = 0;
        break;
        label201:
        k = zps.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), 84.0F);
        arrayOfFloat1 = new float[2];
        float[] tmp222_220 = arrayOfFloat1;
        tmp222_220[0] = 28.0F;
        float[] tmp227_222 = tmp222_220;
        tmp227_222[1] = 21.0F;
        tmp227_222;
      }
      if ((n <= k) || (i == arrayOfFloat1.length - 1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, arrayOfFloat1[i]);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        yuk.a("Q.qqstory.widget.PollWidgetUtils", "text size = %s", Float.valueOf(arrayOfFloat1[i]));
      }
      for (;;)
      {
        paramCharSequence = zox.a(this.jdField_a_of_type_AndroidWidgetTextView, 2);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        if ((j != 0) && (i == arrayOfFloat1.length - 1)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
        }
        return;
        i += 1;
        break;
        label335:
        i = -1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130844606);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
  }
  
  public CharSequence b()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView.getHint();
  }
  
  public void b(boolean paramBoolean)
  {
    c(paramBoolean);
    super.b(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(jdField_b_of_type_ArrayOfInt[this.jdField_a_of_type_Int]);
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.01F, 0.0F, 2.0F, -35568);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setShadowLayer(0.01F, 0.0F, 2.0F, -35568);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(c[this.jdField_a_of_type_Int]);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c(this.jdField_b_of_type_Boolean);
  }
  
  public void e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      a(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    }
    while ((paramBoolean) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    a(this.jdField_a_of_type_AndroidWidgetTextView.getText());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((a()) || (this.jdField_a_of_type_Zpc == null) || (!this.jdField_a_of_type_Zpi.a())) {
      return paramView.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return paramView.onTouchEvent(paramMotionEvent);
      c(true);
      continue;
      c(false);
      continue;
      if ((paramMotionEvent.getX() < 0.0F) || (paramMotionEvent.getX() > paramView.getWidth()) || (paramMotionEvent.getY() < 0.0F) || (paramMotionEvent.getY() > paramView.getHeight())) {
        c(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpf
 * JD-Core Version:    0.7.0.1
 */
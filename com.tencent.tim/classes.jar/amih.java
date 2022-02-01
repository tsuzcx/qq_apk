import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.profile.view.ClickPreventableTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class amih
  extends ClickableSpan
  implements amii
{
  private amii.a a;
  private boolean cCK;
  private Object data;
  private ColorStateList p;
  private boolean pressed;
  private ColorStateList q;
  
  public amih(amii.a parama, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2, Object paramObject)
  {
    this.a = parama;
    this.p = paramColorStateList1;
    this.q = paramColorStateList2;
    this.data = paramObject;
  }
  
  public amih(amii.a parama, ColorStateList paramColorStateList, Object paramObject)
  {
    this(parama, paramColorStateList, null, paramObject);
  }
  
  public void M(View paramView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ClickColorTopicSpan", 2, String.format("setPressed %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.pressed != paramBoolean)
    {
      this.pressed = paramBoolean;
      paramView.invalidate();
    }
  }
  
  public void Pk(boolean paramBoolean)
  {
    if (this.cCK != paramBoolean) {
      this.cCK = paramBoolean;
    }
  }
  
  public Object getData()
  {
    return this.data;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof ClickPreventableTextView)) {
      if (!((ClickPreventableTextView)paramView).atz()) {}
    }
    while (this.a == null)
    {
      return;
      ((ClickPreventableTextView)paramView).dFH();
    }
    this.a.a(this, paramView);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.data instanceof Pair))
    {
      Pair localPair = (Pair)this.data;
      localStringBuilder.append("id=").append(localPair.first).append(",");
      localStringBuilder.append("topic=").append((String)localPair.second).append(",");
    }
    return localStringBuilder.toString();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.cCK) {
      return;
    }
    paramTextPaint.setUnderlineText(false);
    if (this.p != null) {
      if (this.pressed)
      {
        i = this.p.getColorForState(new int[] { 16842919 }, 0);
        paramTextPaint.setColor(i);
        label54:
        if (this.q == null) {
          break label130;
        }
        if (!this.pressed) {
          break label115;
        }
      }
    }
    label115:
    for (int i = this.q.getColorForState(new int[] { 16842919 }, 0);; i = this.q.getColorForState(new int[0], 0))
    {
      paramTextPaint.bgColor = i;
      return;
      i = this.p.getColorForState(new int[0], 0);
      break;
      paramTextPaint.setColor(-16777216);
      break label54;
    }
    label130:
    paramTextPaint.bgColor = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amih
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

class yqi
{
  public TextView a;
  
  public yqi(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131378227));
  }
  
  public void a(zhq paramzhq, yqh paramyqh)
  {
    if (TextUtils.isEmpty(paramzhq.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(yqd.a(paramzhq));
    yqd.a(this.a);
    this.a.setOnClickListener(new yqj(this, paramyqh, paramzhq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqi
 * JD-Core Version:    0.7.0.1
 */
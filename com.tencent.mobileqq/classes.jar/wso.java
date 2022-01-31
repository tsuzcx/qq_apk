import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

class wso
{
  public TextView a;
  
  public wso(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131377349));
  }
  
  public void a(xjw paramxjw, wsn paramwsn)
  {
    if (TextUtils.isEmpty(paramxjw.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(wsj.a(paramxjw));
    wsj.a(this.a);
    this.a.setOnClickListener(new wsp(this, paramwsn, paramxjw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wso
 * JD-Core Version:    0.7.0.1
 */
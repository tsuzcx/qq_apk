import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rcx
  implements View.OnClickListener
{
  rcx(rcu paramrcu) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (!TextUtils.isEmpty(this.a.a.mKeyword))
    {
      this.a.azM = this.a.a.mKeyword;
      str = this.a.yo.getText().toString();
      if ((str.equals("##")) || (TextUtils.isEmpty(str)) || (!str.equals("# " + this.a.azM)))
      {
        rdc localrdc = this.a.b;
        if (this.a.b.La())
        {
          str = "2";
          localrdc.c("use_custom_tag", 0, 0, new String[] { str });
        }
      }
      else
      {
        this.a.yo.setText("# " + this.a.azM);
      }
    }
    for (;;)
    {
      this.a.b.changeState(0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = "1";
      break;
      this.a.azM = "";
      this.a.yo.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcx
 * JD-Core Version:    0.7.0.1
 */
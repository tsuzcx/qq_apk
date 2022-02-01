import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class ydm
  extends kdq
{
  ydm(ycd paramycd) {}
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (ycd.a(this.this$0).getVisibility() != 0))
    {
      if (ixa.a().cD(this.this$0.app.getCurrentAccountUin()))
      {
        ycd.b(this.this$0).setVisibility(0);
        ycd.c(this.this$0).setOnClickListener(this.this$0);
        this.this$0.a.setRight2Icon(2130847958, 2130847959);
      }
    }
    else {
      return;
    }
    ycd.d(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydm
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

class xxs
  implements ViewTreeObserver.OnPreDrawListener
{
  xxs(xxh paramxxh, xxh.b paramb) {}
  
  public boolean onPreDraw()
  {
    xxh.a(this.this$0).getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.b.sex == 1)
    {
      xxh.a(this.this$0).setBackgroundDrawable(new afej(Color.parseColor("#1fa4fc"), 5.0F, wja.dp2px(14.0F, this.this$0.mContext.getResources()), wja.dp2px(14.0F, this.this$0.mContext.getResources())));
      xxh.b(this.this$0).setBackgroundDrawable(new afej(Color.parseColor("#1fa4fc"), 5.0F, xxh.b(this.this$0).getMeasuredWidth(), xxh.b(this.this$0).getMeasuredHeight()));
      xxh.a(this.this$0).setImageResource(2130839442);
    }
    for (;;)
    {
      xxh.a(this.this$0).setBackgroundDrawable(new afej(Color.parseColor("#b2b5bd"), 5.0F, xxh.a(this.this$0).getMeasuredWidth(), xxh.a(this.this$0).getMeasuredHeight()));
      xxh.c(this.this$0).setBackgroundDrawable(new afej(Color.parseColor("#b2b5bd"), 5.0F, xxh.c(this.this$0).getMeasuredWidth(), xxh.c(this.this$0).getMeasuredHeight()));
      return true;
      xxh.a(this.this$0).setBackgroundDrawable(new afej(Color.parseColor("#ff5fb5"), 5.0F, wja.dp2px(14.0F, this.this$0.mContext.getResources()), wja.dp2px(14.0F, this.this$0.mContext.getResources())));
      xxh.b(this.this$0).setBackgroundDrawable(new afej(Color.parseColor("#ff5fb5"), 5.0F, xxh.b(this.this$0).getMeasuredWidth(), xxh.b(this.this$0).getMeasuredHeight()));
      xxh.a(this.this$0).setImageResource(2130839441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxs
 * JD-Core Version:    0.7.0.1
 */
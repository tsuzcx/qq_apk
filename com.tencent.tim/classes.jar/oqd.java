import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class oqd
  extends ogm<Object>
{
  private stSimpleMetaFeed b;
  private WSVerticalPageFragment c;
  private View ny;
  private TextView vc;
  private TextView ve;
  
  public oqd(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.c = paramWSVerticalPageFragment;
  }
  
  protected void Hp()
  {
    if ((getData() != null) && ((getData() instanceof stSimpleMetaFeed))) {
      this.b = ((stSimpleMetaFeed)getData());
    }
  }
  
  protected int gn()
  {
    return 2131560197;
  }
  
  protected void initView()
  {
    if (this.c == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131381556);
    oql.a(this.c.getActivity(), localRelativeLayout);
    this.ny = findViewById(2131381555);
    this.ny.setOnClickListener(new oqe(this));
    this.vc = ((TextView)findViewById(2131381548));
    this.ve = ((TextView)findViewById(2131380612));
  }
  
  protected void onRecycle() {}
  
  protected void onUpdateUI()
  {
    if ((this.vc != null) && (this.b != null) && (this.b.collection != null))
    {
      int i = (int)(this.ny.getWidth() * 1.5F);
      int j = opm.getScreenWidth();
      this.vc.setMaxWidth(j - i);
      String str = getResources().getString(2131721921);
      str = str + this.b.collection.name;
      this.vc.setText(str);
    }
  }
  
  public void uT(int paramInt)
  {
    if ((this.ve != null) && (this.b != null) && (this.b.collection != null))
    {
      String str = paramInt + "/" + this.b.collection.feed_count;
      this.ve.setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqd
 * JD-Core Version:    0.7.0.1
 */
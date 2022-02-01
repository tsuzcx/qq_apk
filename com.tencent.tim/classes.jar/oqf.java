import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class oqf
  extends ogm<Object>
{
  private WSVerticalPageFragment c;
  private View nA;
  private View nz;
  
  public oqf(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.c = paramWSVerticalPageFragment;
  }
  
  private void bge()
  {
    if (this.c.a() == null) {
      return;
    }
    osf localosf = this.c.a().a();
    if (localosf != null) {
      localosf.bez();
    }
    bgf();
  }
  
  private void bgf()
  {
    if (this.c.a() != null) {
      this.c.a().a(this.c.getMiniMsgUser());
    }
  }
  
  protected void Hp() {}
  
  public void a(boolean paramBoolean, okg paramokg)
  {
    View localView;
    if ((this.nz != null) && (paramokg != null))
    {
      paramokg.qP(paramBoolean);
      localView = this.nz;
      if ((paramokg.ry() <= 0) || (!paramBoolean)) {
        break label42;
      }
    }
    label42:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  protected int gn()
  {
    return 2131560198;
  }
  
  protected void initView()
  {
    if (this.c == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131381556);
    oql.a(this.c.getActivity(), localRelativeLayout);
    findViewById(2131381557).setOnClickListener(new oqg(this));
    this.nA = findViewById(2131381558);
    this.nA.setOnClickListener(new oqh(this));
    this.nz = findViewById(2131369654);
    this.c.dy(this.nz);
  }
  
  protected void onRecycle() {}
  
  protected void onUpdateUI() {}
  
  public void qU(boolean paramBoolean)
  {
    View localView;
    if (this.nA != null)
    {
      localView = this.nA;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqf
 * JD-Core Version:    0.7.0.1
 */
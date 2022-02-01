import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class ork
  extends ogm<oqr>
{
  private WSVerticalPageFragment c;
  private osf d;
  private stSimpleMetaFeed i;
  private ImageView lw;
  private View nD;
  private TextView vk;
  
  public ork(Context paramContext, osf paramosf)
  {
    super(paramContext);
    this.d = paramosf;
    if (paramosf != null) {
      this.c = paramosf.c;
    }
  }
  
  private void bgy()
  {
    dD(0, 4);
  }
  
  private void bgz()
  {
    dD(1, 7);
  }
  
  private void dD(int paramInt1, int paramInt2)
  {
    if ((this.c != null) && (this.c.c != null))
    {
      this.c.c.bX(osv.fE(this.c.getFrom()), this.c.getPlayScene());
      this.c.c.setPosition(getPosition());
      this.c.c.b(this.i);
      this.c.c.l(paramInt1, paramInt2, this.c.getPlayScene());
    }
  }
  
  protected void Hp()
  {
    if ((getData() != null) && ((((oqr)getData()).B() instanceof stSimpleMetaFeed))) {
      this.i = ((stSimpleMetaFeed)((oqr)getData()).B());
    }
  }
  
  protected int gn()
  {
    return 2131560216;
  }
  
  protected void initView()
  {
    this.vk = ((TextView)findViewById(2131380620));
    this.nD = findViewById(2131372707);
    this.nD.setOnClickListener(new orl(this));
    this.lw = ((ImageView)findViewById(2131369687));
    this.lw.setOnClickListener(new orm(this));
  }
  
  protected void onRecycle() {}
  
  protected void onUpdateUI()
  {
    String str = ohy.a().lt();
    if (!TextUtils.isEmpty(str)) {
      this.vk.setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ork
 * JD-Core Version:    0.7.0.1
 */
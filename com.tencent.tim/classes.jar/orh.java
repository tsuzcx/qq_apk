import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class orh
  extends ogm<oqr>
{
  private WSVerticalPageFragment c;
  private stSimpleMetaFeed h;
  private View nC;
  private TextView vc;
  
  public orh(Context paramContext, osf paramosf)
  {
    super(paramContext);
    if (paramosf != null) {
      this.c = paramosf.c;
    }
  }
  
  private boolean Hk()
  {
    return (this.h != null) && (this.h.collection != null) && (!TextUtils.isEmpty(this.h.collection.cid));
  }
  
  private boolean Hl()
  {
    return (this.nC != null) && (this.nC.getVisibility() == 0) && (!Hm());
  }
  
  private void bgw()
  {
    opw.a(this.c, this.h);
  }
  
  public boolean Hm()
  {
    return (getData() != null) && (((oqr)getData()).Hg());
  }
  
  protected void Hp()
  {
    oqr localoqr = (oqr)getData();
    if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed))) {
      this.h = ((stSimpleMetaFeed)localoqr.B());
    }
  }
  
  public void bgx()
  {
    if (!Hl())
    {
      ooz.e("AbsWsUIGroup", "fail to meet the requirement of playing collection animation");
      return;
    }
    if (getData() != null) {
      ((oqr)getData()).qW(true);
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.nC, "backgroundColor", new int[] { -2147483648, -2139470081 });
    localObjectAnimator.addListener(new orj(this));
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    localObjectAnimator.start();
  }
  
  protected int gn()
  {
    return 2131560215;
  }
  
  protected void initView()
  {
    this.nC = findViewById(2131381537);
    this.nC.setOnClickListener(new ori(this));
    this.vc = ((TextView)findViewById(2131381538));
  }
  
  protected void onRecycle() {}
  
  protected void onUpdateUI()
  {
    if (Hk())
    {
      this.nC.setVisibility(0);
      this.vc.setText(this.h.collection.name);
      if (Hm())
      {
        this.nC.setBackgroundColor(oor.getColor(2131165909));
        return;
      }
      this.nC.setBackgroundColor(oor.getColor(2131165395));
      return;
    }
    this.nC.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orh
 * JD-Core Version:    0.7.0.1
 */
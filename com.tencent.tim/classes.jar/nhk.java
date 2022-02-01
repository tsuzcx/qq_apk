import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.widget.FixSizeImageView;

public class nhk
{
  public KandianUrlImageView J;
  public FixSizeImageView[] a = new FixSizeImageView[4];
  public View bK;
  public ComponentHeaderFriendRecommend c;
  public View commentView;
  public View ev;
  public TextView fW;
  public View[] k = new View[2];
  public View kP;
  public View mA;
  public View mB;
  public View mC;
  private View mView;
  public View mu;
  public View mv;
  public View mw;
  public View mx;
  public View my;
  public View mz;
  public TextView[] n = new TextView[4];
  public TextView qC;
  public TextView qx;
  public TextView tc;
  public TextView td;
  public TextView te;
  
  public nhk(View paramView)
  {
    this.mView = paramView;
    initView();
  }
  
  private void initView()
  {
    this.mx = this.mView.findViewById(2131381256);
    this.my = this.mView.findViewById(2131378995);
    this.mz = this.mView.findViewById(2131372190);
    this.ev = this.mView.findViewById(2131376672);
  }
  
  public boolean Fy()
  {
    if (this.mC != null) {
      return true;
    }
    ViewStub localViewStub = (ViewStub)this.mView.findViewById(2131376695);
    if (localViewStub == null) {
      return false;
    }
    this.mC = localViewStub.inflate();
    this.te = ((TextView)this.mView.findViewById(2131376694));
    return true;
  }
  
  public void aWZ()
  {
    if (this.bK != null) {
      return;
    }
    this.mu = ((ViewStub)this.mView.findViewById(2131376677)).inflate();
    this.bK = this.mu.findViewById(2131363012);
    this.mv = this.mView.findViewById(2131376684);
    this.J = ((KandianUrlImageView)this.mView.findViewById(2131376698));
    this.a[0] = ((FixSizeImageView)this.mView.findViewById(2131376673));
    this.a[1] = ((FixSizeImageView)this.mView.findViewById(2131376674));
    this.a[2] = ((FixSizeImageView)this.mView.findViewById(2131376675));
    this.a[3] = ((FixSizeImageView)this.mView.findViewById(2131376676));
    this.qC = ((TextView)this.mView.findViewById(2131376689));
    this.qx = ((TextView)this.mView.findViewById(2131376680));
    this.mw = this.mView.findViewById(2131381276);
    this.c = ((ComponentHeaderFriendRecommend)this.mView.findViewById(2131368456));
  }
  
  public void aXa()
  {
    if (this.kP != null) {
      return;
    }
    this.kP = ((ViewStub)this.mView.findViewById(2131369995)).inflate();
    this.n[0] = ((TextView)this.mView.findViewById(2131369996));
    this.n[1] = ((TextView)this.mView.findViewById(2131369998));
    this.n[2] = ((TextView)this.mView.findViewById(2131370000));
    this.n[3] = ((TextView)this.mView.findViewById(2131370001));
    this.k[0] = this.mView.findViewById(2131369997);
    this.k[1] = this.mView.findViewById(2131369999);
  }
  
  public void aXb()
  {
    if (this.mA != null) {
      return;
    }
    this.mA = ((ViewStub)this.mView.findViewById(2131367687)).inflate();
    this.tc = ((TextView)this.mView.findViewById(2131367688));
  }
  
  public void aXc()
  {
    if (this.commentView != null) {
      return;
    }
    this.commentView = ((ViewStub)this.mView.findViewById(2131365051)).inflate();
    this.td = ((TextView)this.mView.findViewById(2131365049));
    this.fW = ((TextView)this.mView.findViewById(2131365047));
    this.mB = this.mView.findViewById(2131365008);
  }
  
  public View getView()
  {
    return this.mView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhk
 * JD-Core Version:    0.7.0.1
 */
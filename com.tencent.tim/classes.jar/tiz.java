import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1;

public class tiz
  extends tjd
{
  private Runnable dD = new GdtMvAnimation585V.1(this);
  
  protected tiz(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    tiv localtiv = new tiv();
    localtiv.qR = paramView1;
    localtiv.qV = paramView3;
    localtiv.qW = paramView2;
    localtiv.bBL = tls.i(-406, 1334, tls.ae(this.mContext));
    localtiv.bBM = tls.i(125, 750, tls.af(this.mContext));
    float f = tls.i(220, 750, tls.af(this.mContext));
    if (f > 0.0F)
    {
      localtiv.oz = (Float.valueOf(f * 1.0F / tls.af(this.mContext)).floatValue() - 1.0F);
      localtiv.oA = localtiv.oz;
    }
    localtiv.bBN = tls.i(50, 750, tls.af(this.mContext));
    localtiv.bBO = tls.i(50, 1334, tls.ae(this.mContext));
    localtiv.qS = paramView4;
    localtiv.title = paramView5;
    localtiv.qT = paramView6;
    localtiv.qU = paramView7;
    localtiv.bBB = tls.i(-618, 1334, tls.ae(this.mContext));
    localtiv.bBC = tls.i(275, 750, tls.af(this.mContext));
    localtiv.bBD = tls.i(-457, 1334, tls.ae(this.mContext));
    localtiv.bBE = ((tls.af(this.mContext) - paramView5.getWidth()) / 2 - tls.i(196, 750, tls.af(this.mContext)));
    localtiv.bBF = tls.i(-451, 1334, tls.ae(this.mContext));
    localtiv.bBG = ((tls.af(this.mContext) - paramView6.getWidth()) / 2 - tls.i(196, 750, tls.af(this.mContext)));
    localtiv.bBH = tls.i(-440, 1334, tls.ae(this.mContext));
    localtiv.bBI = ((tls.af(this.mContext) - paramView7.getWidth()) / 2 - tls.i(196, 750, tls.af(this.mContext)));
    a(localtiv, paramView8);
    this.a = localtiv;
  }
  
  public void zu(int paramInt)
  {
    super.zu(paramInt);
    tkw.i("GdtMotiveVideoAd", "585V doAnimation " + this.a + " targetMode " + paramInt);
    tiv localtiv;
    if (this.a != null)
    {
      localtiv = (tiv)this.a;
      bDr();
      if (paramInt == 1)
      {
        if (localtiv.qR != null) {
          localtiv.qR.setVisibility(4);
        }
        o(localtiv.qV, localtiv.bBL, localtiv.bBM);
        o(localtiv.qU, localtiv.bBH, localtiv.bBI);
        o(localtiv.qS, localtiv.bBB, localtiv.bBC);
        o(localtiv.qT, localtiv.bBF, localtiv.bBG);
        o(localtiv.title, localtiv.bBD, localtiv.bBE);
      }
    }
    else
    {
      return;
    }
    this.mUIHandler.removeCallbacks(this.dD);
    this.mUIHandler.postDelayed(this.dD, 300L);
    o(localtiv.qV, -localtiv.bBL, -localtiv.bBM);
    o(localtiv.qU, -localtiv.bBH, -localtiv.bBI);
    o(localtiv.qS, -localtiv.bBB, -localtiv.bBC);
    o(localtiv.qT, -localtiv.bBF, -localtiv.bBG);
    o(localtiv.title, -localtiv.bBD, -localtiv.bBE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tiz
 * JD-Core Version:    0.7.0.1
 */
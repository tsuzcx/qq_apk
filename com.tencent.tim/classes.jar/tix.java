import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H.1;

public class tix
  extends tjd
{
  private Runnable dD = new GdtMvAnimation185H.1(this);
  
  protected tix(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    tit localtit = new tit();
    localtit.qR = paramView1;
    localtit.qV = paramView3;
    localtit.qW = paramView2;
    localtit.qX = paramView8;
    localtit.bBL = tls.i(-85, 750, tls.af(this.mContext));
    localtit.bBM = tls.i(-588, 1334, tls.ae(this.mContext));
    localtit.bBJ = tls.i(416, 1334, tls.ae(this.mContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = tls.i(400, 1334, tls.ae(this.mContext));
    if (f > 0.0F)
    {
      localtit.oz = (Float.valueOf(f * 1.0F / tls.ae(this.mContext)).floatValue() - 1.0F);
      localtit.oA = localtit.oz;
    }
    localtit.bBN = tls.i(50, 1334, tls.ae(this.mContext));
    localtit.bBO = tls.i(50, 750, tls.af(this.mContext));
    localtit.qS = paramView4;
    localtit.title = paramView5;
    localtit.qT = paramView6;
    localtit.qU = paramView7;
    localtit.bBB = tls.i(-436, 750, tls.af(this.mContext));
    localtit.bBC = tls.i(567, 1334, tls.ae(this.mContext));
    localtit.bBD = tls.i(-275, 750, tls.af(this.mContext));
    localtit.bBE = ((tls.ae(this.mContext) - paramView5.getWidth()) / 2 - tls.i(196, 1334, tls.ae(this.mContext)));
    localtit.bBF = tls.i(-269, 750, tls.af(this.mContext));
    localtit.bBG = ((tls.ae(this.mContext) - paramView6.getWidth()) / 2 - tls.i(196, 1334, tls.ae(this.mContext)));
    localtit.bBH = tls.i(-257, 750, tls.af(this.mContext));
    localtit.bBI = ((tls.ae(this.mContext) - paramView7.getWidth()) / 2 - tls.i(196, 1334, tls.ae(this.mContext)));
    a(localtit, paramView8);
    this.a = localtit;
  }
  
  public void zu(int paramInt)
  {
    super.zu(paramInt);
    tkw.i("GdtMotiveVideoAd", "185H doAnimation " + this.a + " targetMode " + paramInt);
    tit localtit;
    if (this.a != null)
    {
      localtit = (tit)this.a;
      bDr();
      if (paramInt == 1)
      {
        if (localtit.qR != null) {
          localtit.qR.setVisibility(4);
        }
        c(localtit.qV, localtit.bBL, localtit.bBM, localtit.bBJ);
        o(localtit.qU, localtit.bBH, localtit.bBI);
        o(localtit.qS, localtit.bBB, localtit.bBC);
        o(localtit.qT, localtit.bBF, localtit.bBG);
        o(localtit.title, localtit.bBD, localtit.bBE);
      }
    }
    else
    {
      return;
    }
    this.mUIHandler.removeCallbacks(this.dD);
    this.mUIHandler.postDelayed(this.dD, 300L);
    c(localtit.qV, -localtit.bBL, -localtit.bBM, -localtit.bBJ);
    o(localtit.qU, -localtit.bBH, -localtit.bBI);
    o(localtit.qS, -localtit.bBB, -localtit.bBC);
    o(localtit.qT, -localtit.bBF, -localtit.bBG);
    o(localtit.title, -localtit.bBD, -localtit.bBE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tix
 * JD-Core Version:    0.7.0.1
 */
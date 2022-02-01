import android.content.Context;
import android.view.View;

public class tiy
  extends tjd
{
  protected tiy(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    tiu localtiu = new tiu();
    localtiu.c = paramView1;
    localtiu.qV = paramView2;
    localtiu.qW = paramView3;
    localtiu.bBK = tls.i(-306, 1334, tls.ae(this.mContext));
    localtiu.bBL = tls.i(-406, 1334, tls.ae(this.mContext));
    localtiu.bBM = tls.i(125, 750, tls.af(this.mContext));
    float f = tls.i(400, 750, tls.af(this.mContext));
    if (f > 0.0F)
    {
      localtiu.oz = (Float.valueOf(f * 1.0F / tls.af(this.mContext)).floatValue() - 1.0F);
      localtiu.oA = localtiu.oz;
    }
    localtiu.bBN = tls.i(50, 750, tls.af(this.mContext));
    localtiu.bBO = tls.i(-100, 1334, tls.ae(this.mContext));
    a(localtiu, paramView4);
    this.a = localtiu;
  }
  
  public void zu(int paramInt)
  {
    super.zu(paramInt);
    tkw.i("GdtMotiveVideoAd", "185V doAnimation " + this.a + " targetMode " + paramInt);
    tiu localtiu;
    if (this.a != null)
    {
      localtiu = (tiu)this.a;
      bDr();
      if (paramInt == 1)
      {
        o(localtiu.c, localtiu.bBK, 0);
        o(localtiu.qV, localtiu.bBL, localtiu.bBM);
      }
    }
    else
    {
      return;
    }
    o(localtiu.c, -localtiu.bBK, 0);
    o(localtiu.qV, -localtiu.bBL, -localtiu.bBM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tiy
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureProgressView;

public class muh
{
  private VideoFeedsGestureProgressView a;
  private VideoFeedsGestureProgressView b;
  private ViewGroup bC;
  private ViewGroup bD;
  private ViewGroup bE;
  private ViewGroup bF;
  private ViewGroup bG;
  private ImageView ka;
  private ImageView kb;
  private int mLastEvent = 0;
  private TextView sj;
  private TextView sk;
  
  public void a(int paramInt, float paramFloat, long paramLong1, long paramLong2)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.mLastEvent = paramInt;
      return;
      String str1 = muj.av(paramLong1);
      String str2 = muj.av(paramLong2);
      this.sj.setText(str1 + "/");
      this.sk.setText(str2);
      if (paramFloat > 0.0F) {
        this.kb.setBackgroundResource(2130843965);
      }
      while (this.bE.getVisibility() == 8)
      {
        muj.a(this.bE, 0, 300);
        break;
        this.kb.setBackgroundResource(2130843963);
      }
      this.b.setProgress(paramFloat);
      if (paramFloat == 0.0F) {
        this.ka.setBackgroundResource(2130843886);
      }
      while (this.bG.getVisibility() == 8)
      {
        muj.a(this.bG, 0, 300);
        break;
        this.ka.setBackgroundResource(2130843887);
      }
      this.a.setProgress(paramFloat);
      if (this.bF.getVisibility() == 8)
      {
        muj.a(this.bF, 0, 300);
        continue;
        if (this.mLastEvent != 0) {
          if (this.mLastEvent == 3)
          {
            if (this.bE.getVisibility() == 0) {
              muj.a(this.bE, 8, 300);
            }
          }
          else if (this.mLastEvent == 2)
          {
            if (this.bF.getVisibility() == 0) {
              muj.a(this.bF, 8, 300);
            }
          }
          else if ((this.mLastEvent == 1) && (this.bG.getVisibility() == 0)) {
            muj.a(this.bG, 8, 300);
          }
        }
      }
    }
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup)
  {
    this.bC = paramViewGroup;
    this.bD = ((ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560512, paramViewGroup));
    this.bE = ((ViewGroup)this.bD.findViewById(2131373693));
    this.bF = ((ViewGroup)this.bD.findViewById(2131363722));
    this.bG = ((ViewGroup)this.bD.findViewById(2131382072));
    this.sj = ((TextView)this.bD.findViewById(2131373691));
    this.sk = ((TextView)this.bD.findViewById(2131373695));
    this.ka = ((ImageView)this.bD.findViewById(2131382071));
    this.kb = ((ImageView)this.bD.findViewById(2131373692));
    this.a = ((VideoFeedsGestureProgressView)this.bD.findViewById(2131363723));
    this.b = ((VideoFeedsGestureProgressView)this.bD.findViewById(2131382073));
  }
  
  public void resetUI()
  {
    if (this.bE != null) {
      this.bE.setVisibility(8);
    }
    if (this.bF != null) {
      this.bF.setVisibility(8);
    }
    if (this.bG != null) {
      this.bG.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     muh
 * JD-Core Version:    0.7.0.1
 */
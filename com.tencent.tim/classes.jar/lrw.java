import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class lrw
  extends ViewBase
{
  public static String TAG = "ReadInJoyFriendsBiu";
  private int ZY = 11;
  private int aPA = 3;
  private int aPB;
  private int aPC = 6;
  private int aPx = 115;
  private int aPy;
  private int aPz;
  private double aV = 0.18D;
  private FrameLayout ag;
  private ArrayList<Long> kN = new ArrayList();
  private int mBorderWidth = 1;
  private Context mContext;
  private int mImageWidth = 22;
  private int mLayoutWidth = 351;
  private TextView pX;
  
  public lrw(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mContext = paramVafContext.getContext();
    this.ag = new FrameLayout(this.mContext);
    this.pX = new TextView(this.mContext);
    this.aPy = Utils.rp2px(this.mImageWidth);
    this.aPz = Utils.rp2px(this.aPx);
    this.mLayoutWidth = Utils.rp2px(this.mLayoutWidth);
    this.ZY = Utils.rp2px(this.ZY);
    this.mBorderWidth = Utils.rp2px(this.mBorderWidth);
    this.aPC = Utils.rp2px(this.aPC);
  }
  
  private void P(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - 1;
    ReadInJoyHeadImageView localReadInJoyHeadImageView;
    FrameLayout.LayoutParams localLayoutParams1;
    int k;
    if (i >= paramInt1 - 1)
    {
      localReadInJoyHeadImageView = new ReadInJoyHeadImageView(this.mContext);
      localLayoutParams1 = new FrameLayout.LayoutParams(this.aPy, this.aPy);
      k = (int)((i - paramInt1 + 1) * (1.0D - this.aV) * this.aPy);
      if (paramInt2 != this.kN.size()) {
        break label216;
      }
    }
    label216:
    for (int j = 20;; j = 0)
    {
      localLayoutParams1.setMargins(k, paramInt3, 0, j);
      localReadInJoyHeadImageView.setHeadImgByUin(((Long)this.kN.get(i)).longValue());
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(this.aPy + this.mBorderWidth * 2, this.aPy + this.mBorderWidth * 2);
      ImageView localImageView = new ImageView(this.mContext);
      localLayoutParams2.setMargins(k - this.mBorderWidth, paramInt3 - this.mBorderWidth, 0, j);
      localImageView.setBackgroundResource(2130850275);
      this.ag.addView(localImageView, localLayoutParams2);
      this.ag.addView(localReadInJoyHeadImageView, localLayoutParams1);
      i -= 1;
      break;
      return;
    }
  }
  
  private void Q(Object paramObject)
  {
    do
    {
      try
      {
        if (this.ag != null) {
          this.ag.removeAllViews();
        }
        this.aPB = 0;
        this.kN.clear();
        paramObject = (JSONObject)paramObject;
        Iterator localIterator = paramObject.keys();
        while (localIterator.hasNext())
        {
          long l = Long.parseLong(paramObject.get((String)localIterator.next()).toString());
          this.aPB += 1;
          if (!this.kN.contains(Long.valueOf(l))) {
            this.kN.add(Long.valueOf(l));
          }
        }
        aNh();
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "parseUinList error:" + paramObject.toString());
        }
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "parseUinList :" + this.kN.size());
  }
  
  private void R(Object paramObject)
  {
    int i = Utils.parseColor(paramObject.toString());
    if (i != 0) {
      this.pX.setTextColor(i);
    }
  }
  
  private void S(Object paramObject)
  {
    Double localDouble = Utils.toDouble(paramObject);
    if (localDouble != null)
    {
      int i = Utils.dp2px(localDouble.doubleValue());
      this.pX.setTextSize(i);
      return;
    }
    QLog.d(TAG, 2, "setTextSize: fail to parse - " + paramObject);
  }
  
  private void aNh()
  {
    int m = oM();
    int n = (int)Math.ceil(this.kN.size() / m);
    int j = 1;
    if (j <= n)
    {
      int i1 = (j - 1) * m;
      if (i1 + m <= this.kN.size()) {}
      for (int i = i1 + m;; i = i1 + this.kN.size() % m)
      {
        int k = i;
        if (i > this.aPA) {
          k = this.aPA;
        }
        P(i1 + 1, k, (j - 1) * this.aPy + this.ZY);
        j += 1;
        break;
      }
    }
    rs(n);
  }
  
  private int oM()
  {
    return (int)((this.mLayoutWidth - this.aPy) / (this.aPy * (1.0D - this.aV)) + 1.0D);
  }
  
  private void rs(int paramInt)
  {
    int i;
    Object localObject;
    label101:
    int j;
    if (!this.kN.isEmpty())
    {
      i = this.kN.size();
      localObject = i + "人也Biu了";
      long l = kxm.getLongAccountUin();
      if ((this.kN.size() != 1) || (l != ((Long)this.kN.get(0)).longValue())) {
        break label251;
      }
      this.pX.setText((CharSequence)localObject);
      i = oM();
      if (this.kN.size() <= i) {
        break label262;
      }
      j = i;
      if (i > this.aPA) {
        j = this.aPA;
      }
      if (j <= 1) {
        break label273;
      }
      i = (int)((j - 1) * (1.0D - this.aV) * this.aPy + this.aPy + this.aPz);
      label152:
      if (i <= this.mLayoutWidth) {
        break label288;
      }
    }
    label262:
    label273:
    label288:
    for (paramInt = this.aPy * paramInt;; paramInt = (paramInt - 1) * this.aPy)
    {
      j = this.aPz;
      localObject = new FrameLayout.LayoutParams(this.aPz, -2);
      ((FrameLayout.LayoutParams)localObject).setMargins(i - j, paramInt + this.ZY, 0, 0);
      this.pX.setTextColor(this.mContext.getResources().getColor(2131165567));
      this.pX.setPadding(this.aPC, 0, 0, 0);
      this.ag.addView(this.pX, (ViewGroup.LayoutParams)localObject);
      return;
      label251:
      if (i <= this.aPA) {
        break;
      }
      break;
      i = this.kN.size();
      break label101;
      i = j * this.aPy + this.aPz;
      break label152;
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.ag.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.ag.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.ag;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ag.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.ag.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool = super.setAttribute(paramInt, paramObject);
    switch (paramInt)
    {
    }
    do
    {
      return bool;
      Q(paramObject);
      return bool;
      S(paramObject);
      return bool;
      R(paramObject);
      return bool;
      try
      {
        this.aPz = Utils.rp2px(Integer.valueOf(paramObject.toString()).intValue());
        return bool;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "parse STR_ID_BORDER_WIDTH error:" + paramObject.toString());
    return bool;
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lrw(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrw
 * JD-Core Version:    0.7.0.1
 */
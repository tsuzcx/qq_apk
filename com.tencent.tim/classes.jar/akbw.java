import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class akbw
{
  public static final String[] fD = { "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#DCEBFF" };
  public static final String[] fE = { "#777777", "#777777", "#777777", "#777777", "#777777", "#777777", "#777777", "#4B83D3" };
  public static final String[] fF = { acfp.m(2131707607), acfp.m(2131707609), acfp.m(2131707603), acfp.m(2131707608), acfp.m(2131707606), acfp.m(2131707604), acfp.m(2131707605) };
  public static final String[] fG = { "0X800554B", "0X800554C", "0X800554D", "0X800554E", "0X800554F", "0X8005550", "0X8005551" };
  public static final int[] lX = { 5, 6, 7, 1, 2, 3, 4, 8 };
  public static final int[] lY = { 2130842192, 2130842201, 2130842187, 2130842195, 2130842183, 2130842177, 2130842200 };
  protected ajuu a;
  protected LinearLayout mContainer;
  protected Context mContext;
  protected LayoutInflater mInflater;
  
  public static int iq(int paramInt)
  {
    int i = 0;
    while (i < lX.length)
    {
      if (paramInt == lX[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected View a(int paramInt1, ajuu paramajuu, int paramInt2)
  {
    View localView = this.mInflater.inflate(tU(), this.mContainer, false);
    a(paramInt1, a(localView, paramInt1, paramajuu, paramInt2), paramajuu.tagInfos);
    return localView;
  }
  
  protected abstract LabelContainer a(View paramView, int paramInt1, ajuu paramajuu, int paramInt2);
  
  protected void a(int paramInt, LabelContainer paramLabelContainer, ArrayList<InterestTagInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      int j = riw.dip2px(this.mContext, 10.0F);
      int k = riw.dip2px(this.mContext, 5.0F);
      int m = riw.dip2px(this.mContext, 2.0F);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramArrayList.next();
        TextView localTextView = new TextView(this.mContext);
        localTextView.setIncludeFontPadding(false);
        localTextView.setTextSize(1, 14.0F);
        localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(Color.parseColor(fD[paramInt]));
        localGradientDrawable.setCornerRadius(m);
        localTextView.setBackgroundDrawable(localGradientDrawable);
        localTextView.setTextColor(Color.parseColor(fE[paramInt]));
        if (this.a != null)
        {
          int i = 0;
          while (i < this.a.tagInfos.size())
          {
            if (((InterestTagInfo)this.a.tagInfos.get(i)).tagName.equals(localInterestTagInfo.tagName))
            {
              localTextView.setTextColor(Color.parseColor(fE[7]));
              localTextView.setBackgroundColor(Color.parseColor(fD[7]));
              this.a.tagInfos.remove(i);
            }
            i += 1;
          }
        }
        if (localInterestTagInfo.tagName != null)
        {
          localInterestTagInfo.tagName = localInterestTagInfo.tagName.replaceAll("\005", "");
          localInterestTagInfo.tagName = localInterestTagInfo.tagName.replaceAll("\006", "");
        }
        localTextView.setText(localInterestTagInfo.tagName);
        localTextView.setPadding(j, k, j, k);
        localTextView.setGravity(17);
        paramLabelContainer.addView(localTextView);
      }
    }
  }
  
  public void a(ajuu paramajuu)
  {
    this.a = paramajuu;
  }
  
  public boolean a(ajuu[] paramArrayOfajuu)
  {
    this.mContainer.removeAllViews();
    boolean bool2;
    if ((paramArrayOfajuu == null) || (paramArrayOfajuu.length == 0)) {
      bool2 = false;
    }
    int i;
    boolean bool1;
    do
    {
      return bool2;
      i = 0;
      bool1 = false;
      bool2 = bool1;
    } while (i >= lX.length);
    int j = 0;
    for (;;)
    {
      bool2 = bool1;
      if (j < paramArrayOfajuu.length)
      {
        if ((lX[i] == paramArrayOfajuu[j].tagType) && ((arH()) || ((paramArrayOfajuu[j].tagInfos != null) && (paramArrayOfajuu[j].tagInfos.size() > 0))))
        {
          View localView = a(i, paramArrayOfajuu[j], paramArrayOfajuu.length);
          this.mContainer.addView(localView);
          bool2 = true;
        }
      }
      else
      {
        i += 1;
        bool1 = bool2;
        break;
      }
      j += 1;
    }
  }
  
  protected boolean arH()
  {
    return false;
  }
  
  public void b(Context paramContext, LinearLayout paramLinearLayout)
  {
    this.mContext = paramContext;
    this.mContainer = paramLinearLayout;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  protected abstract int tU();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbw
 * JD-Core Version:    0.7.0.1
 */
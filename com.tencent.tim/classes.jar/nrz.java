import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class nrz
  extends nrc
{
  private nrz.a a;
  protected boolean mHasInit;
  private int mPos;
  private BaseArticleInfo r;
  
  public nrz(Activity paramActivity, nrz.a parama)
  {
    super(paramActivity);
    this.a = parama;
  }
  
  public void a(View paramView, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.r = paramBaseArticleInfo;
    this.mPos = paramInt;
    if (!this.mHasInit)
    {
      initUI();
      this.mHasInit = true;
    }
    dj(paramView);
  }
  
  public View b(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560436, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, wja.dp2px(60.0F, this.mActivity.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131369459);
    localImageView.setImageResource(2130842506);
    ((TextView)paramLayoutInflater.findViewById(2131369528)).setVisibility(8);
    TextView localTextView = (TextView)paramLayoutInflater.findViewById(2131369532);
    paramLayoutInflater.findViewById(2131369517).setVisibility(8);
    paramLayoutInflater.findViewById(2131378043).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new nsa(this));
    localImageView.setOnClickListener(new nsb(this));
    return paramLayoutInflater;
  }
  
  public static abstract interface a
  {
    public abstract void e(BaseArticleInfo paramBaseArticleInfo, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nrz
 * JD-Core Version:    0.7.0.1
 */
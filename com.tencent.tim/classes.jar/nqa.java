import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class nqa
  extends npy
{
  public nqa(Context paramContext)
  {
    super(paramContext);
  }
  
  public void aXf()
  {
    if (this.a == null) {
      return;
    }
    this.a.S(0L);
    this.a.pn();
  }
  
  public void ag(int paramInt, boolean paramBoolean)
  {
    super.ag(paramInt, paramBoolean);
    if (this.a == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.a.R(0L);
      return;
    }
    if (paramBoolean)
    {
      this.a.pn();
      return;
    }
    this.a.Q(0L);
  }
  
  public View d(ViewGroup paramViewGroup)
  {
    if (this.a == null) {
      this.a = ((PullRefreshHeader)LayoutInflater.from(this.mContext).inflate(2131559847, paramViewGroup, false));
    }
    return (View)this.a;
  }
  
  public void pY(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.S(0L);
  }
  
  public int qC()
  {
    return this.mContext.getResources().getDimensionPixelSize(2131299308);
  }
  
  public void t(boolean paramBoolean, String paramString)
  {
    if (this.a == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.a.K(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.a.tT(0);
      return;
    }
    this.a.tT(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nqa
 * JD-Core Version:    0.7.0.1
 */
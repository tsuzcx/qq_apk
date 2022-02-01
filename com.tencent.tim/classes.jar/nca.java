import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;

public class nca
{
  private Context mContext;
  private View mRoot;
  private Object mTag;
  private View mg;
  private TextView sG;
  private TextView sH;
  private TextView sI;
  private View.OnClickListener x;
  
  public nca(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.mRoot = paramView;
    this.x = paramOnClickListener;
    this.mContext = BaseApplication.getContext();
  }
  
  private void setListener()
  {
    if (this.sH != null)
    {
      this.sH.setOnClickListener(this.x);
      this.sH.setTag(this.mTag);
    }
    if (this.sI != null)
    {
      this.sI.setOnClickListener(this.x);
      this.sI.setTag(this.mTag);
    }
  }
  
  public boolean EW()
  {
    return (this.mg != null) && (this.mg.getVisibility() == 0);
  }
  
  public void a(View.OnClickListener paramOnClickListener, Object paramObject)
  {
    this.x = paramOnClickListener;
    this.mTag = paramObject;
    setListener();
  }
  
  public void aVq()
  {
    if (this.mg != null)
    {
      this.mg.clearAnimation();
      this.mg.setVisibility(8);
    }
  }
  
  public void aVr()
  {
    if (this.mg != null) {
      muj.a(this.mg, 8, 300, true);
    }
  }
  
  public void l(int paramInt, String paramString1, String paramString2)
  {
    if (this.mg == null)
    {
      this.mg = ((ViewStub)this.mRoot.findViewById(2131366510)).inflate();
      this.sG = ((TextView)this.mg.findViewById(2131366511));
      this.sH = ((TextView)this.mg.findViewById(2131366502));
      this.sI = ((TextView)this.mg.findViewById(2131381760));
      this.mg.setOnClickListener(null);
    }
    setListener();
    muj.cT(this.mg);
    this.mg.setVisibility(0);
    Drawable localDrawable = this.mContext.getResources().getDrawable(2130843986);
    int i = riw.dip2px(this.mContext, 18.6F);
    localDrawable.setBounds(0, 0, i, i);
    this.sH.setCompoundDrawables(localDrawable, null, null, null);
    this.sH.setCompoundDrawablePadding(wja.dp2px(6.0F, this.mContext.getResources()));
    this.sG.setText(paramString1);
    this.sH.setText(paramString2);
    if (paramInt == 1)
    {
      this.sI.setVisibility(0);
      paramString1 = this.mContext.getResources().getDrawable(2130842630);
      paramInt = riw.dip2px(this.mContext, 18.6F);
      paramString1.setBounds(0, 0, paramInt, paramInt);
      this.sI.setCompoundDrawables(paramString1, null, null, null);
      this.sI.setCompoundDrawablePadding(wja.dp2px(6.0F, this.mContext.getResources()));
      return;
    }
    this.sI.setVisibility(8);
    this.mg.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nca
 * JD-Core Version:    0.7.0.1
 */
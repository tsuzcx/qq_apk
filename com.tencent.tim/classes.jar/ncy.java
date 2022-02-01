import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.a;
import com.tencent.widget.RangeButtonView.e;
import java.util.ArrayList;
import java.util.List;

public class ncy
{
  private List<RangeButtonView.e> data;
  private PopupWindow mPopupWindow;
  
  public ncy a(View paramView)
  {
    if (this.mPopupWindow != null) {
      this.mPopupWindow.showAtLocation(paramView, 83, 0, 0);
    }
    return this;
  }
  
  public void dismiss()
  {
    if (this.mPopupWindow != null) {
      this.mPopupWindow.dismiss();
    }
  }
  
  public boolean isShowing()
  {
    return (this.mPopupWindow != null) && (this.mPopupWindow.isShowing());
  }
  
  public float l(int paramInt)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (this.data != null)
    {
      f1 = f2;
      if (paramInt < this.data.size()) {
        f1 = ((RangeButtonView.e)this.data.get(paramInt)).getTextSize();
      }
    }
    return f1;
  }
  
  public void onDestroy()
  {
    if (this.mPopupWindow != null)
    {
      this.mPopupWindow.dismiss();
      this.mPopupWindow = null;
    }
  }
  
  public static class a
  {
    private RangeButtonView.a a;
    private int aXQ;
    private List<RangeButtonView.e> data;
    private List<String> jQ;
    private LayoutInflater mLayoutInflater;
    
    public a(LayoutInflater paramLayoutInflater)
    {
      this.mLayoutInflater = paramLayoutInflater;
    }
    
    public a a(int paramInt)
    {
      this.aXQ = paramInt;
      return this;
    }
    
    public a a(RangeButtonView.a parama)
    {
      this.a = parama;
      return this;
    }
    
    public ncy a()
    {
      ncy localncy = new ncy(null);
      Object localObject = this.mLayoutInflater.inflate(2131559312, null);
      ncy.a(localncy, new PopupWindow((View)localObject, -1, -2));
      ncy.a(localncy).setBackgroundDrawable(new BitmapDrawable());
      ncy.a(localncy).setOutsideTouchable(true);
      localObject = (RangeButtonView)((View)localObject).findViewById(2131367439);
      if ((this.data != null) && (this.data.isEmpty())) {}
      ((RangeButtonView)localObject).setTitleData(this.data);
      ncy.a(localncy, this.data);
      if (this.a != null) {
        ((RangeButtonView)localObject).setOnChangerListener(this.a);
      }
      ((RangeButtonView)localObject).setThumbPosition(this.aXQ);
      if ((this.jQ == null) || (this.jQ.isEmpty()))
      {
        this.jQ = new ArrayList();
        this.jQ.add(BaseApplicationImpl.getApplication().getString(2131692122));
        this.jQ.add(BaseApplicationImpl.getApplication().getString(2131692123));
        this.jQ.add(BaseApplicationImpl.getApplication().getString(2131692124));
        this.jQ.add(BaseApplicationImpl.getApplication().getString(2131692125));
        this.jQ.add(BaseApplicationImpl.getApplication().getString(2131692126));
      }
      ((RangeButtonView)localObject).setContentDescList(this.jQ);
      return localncy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncy
 * JD-Core Version:    0.7.0.1
 */
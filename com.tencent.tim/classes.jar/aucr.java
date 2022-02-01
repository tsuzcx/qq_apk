import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.e;
import com.tencent.widget.Gallery;
import java.util.List;

public class aucr
  extends aucp
{
  private atyt b;
  private Gallery c;
  private LinearLayout iU;
  
  public aucr(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void JJ(boolean paramBoolean)
  {
    LinearLayout localLinearLayout;
    if (this.iU != null)
    {
      localLinearLayout = this.iU;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void ON(int paramInt)
  {
    this.c.setSelection(paramInt);
  }
  
  public void a(AdapterView.c paramc)
  {
    if (paramc != null) {
      this.c.setOnItemClickListener(paramc);
    }
  }
  
  public void a(AdapterView.e parame)
  {
    if (parame != null) {
      this.c.setOnItemSelectedListener(parame);
    }
  }
  
  public void dkq()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: PictureFileViewer initFileView");
    if (this.CS == null)
    {
      this.CS = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131563203, this.mRootView, false);
      this.c = ((Gallery)this.CS.findViewById(2131367833));
      this.b = new atyt(BaseApplicationImpl.getContext());
      this.c.setAdapter(this.b);
      this.c.setSpacing(this.CS.getResources().getDimensionPixelSize(2131297406));
      this.iU = ((LinearLayout)this.CS.findViewById(2131372658));
    }
  }
  
  public void dkt()
  {
    if (this.b != null) {
      this.b.notifyDataSetChanged();
    }
  }
  
  public void dku()
  {
    this.c.reset();
  }
  
  public void kN(List<atzy.a> paramList)
  {
    this.b.kK(paramList);
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucr
 * JD-Core Version:    0.7.0.1
 */
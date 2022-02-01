import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mdw
  extends mdu
{
  private int aNZ;
  private int aOa;
  private int aOb;
  private boolean amd;
  private mek b;
  private String rowkey;
  
  public mdw(ViewGroup paramViewGroup, String paramString1, String paramString2, mek parammek, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    super(paramViewGroup);
    this.b = parammek;
    this.aNZ = paramInt1;
    this.aOa = paramInt2;
    this.aOb = paramInt3;
    this.rowkey = paramString3;
    paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
    parammek = new ColorDrawable(0);
    paramViewGroup.mFailedDrawable = parammek;
    paramViewGroup.mLoadingDrawable = parammek;
    paramViewGroup = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200313/09d27592d8034af2a494db92ca9e8e25.png", paramViewGroup);
    this.backgroundView.setImageDrawable(paramViewGroup);
    this.backgroundView.setOnClickListener(this);
    ((TextView)findViewById(2131371105)).setText(paramString1);
    ((TextView)findViewById(2131378922)).setText(paramString2);
    j(paramInt1, paramInt2, paramString3);
  }
  
  protected void aOL()
  {
    i(0, this.aNZ, this.aOa, this.rowkey);
  }
  
  View b(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562918, paramViewGroup, false);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (this.amd) {
      QQToast.a(BaseApplicationImpl.getContext(), 0, BaseApplicationImpl.getContext().getString(2131716160), 0).show();
    }
    for (;;)
    {
      this.amd = true;
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.backgroundView)
      {
        i(1, this.aNZ, this.aOa, this.rowkey);
        this.b.Q(this.aNZ, this.aOa, this.aOb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdw
 * JD-Core Version:    0.7.0.1
 */
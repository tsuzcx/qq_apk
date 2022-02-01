import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class aqrw
  extends ReportDialog
{
  private static int ecp = 150;
  private static int ecq = 56;
  aqrw.a b;
  View.OnClickListener fs = new aqrx(this);
  ImageView mImageView;
  
  public aqrw(Context paramContext)
  {
    super(paramContext, 2131755365);
  }
  
  public void a(aqrw.a parama)
  {
    this.b = parama;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131562242);
    findViewById(2131375595).setOnClickListener(this.fs);
    findViewById(2131375596).setOnClickListener(this.fs);
    findViewById(2131375597).setOnClickListener(this.fs);
    this.mImageView = ((ImageView)findViewById(2131375598));
    paramBundle = new ColorDrawable(15856629);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    float f = localResources.getDisplayMetrics().density;
    localURLDrawableOptions.mRequestWidth = ((int)(localResources.getDisplayMetrics().widthPixels - ecq * f));
    localURLDrawableOptions.mRequestHeight = ((int)(ecp * f));
    localURLDrawableOptions.mFailedDrawable = paramBundle;
    localURLDrawableOptions.mLoadingDrawable = paramBundle;
    paramBundle = URLDrawable.getDrawable("https://gxh.vip.qq.com/xydata/like/app/zanDoubleConfig/single.png", localURLDrawableOptions);
    this.mImageView.setImageDrawable(paramBundle);
  }
  
  public static abstract interface a
  {
    public abstract void bPb();
    
    public abstract void bPc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrw
 * JD-Core Version:    0.7.0.1
 */
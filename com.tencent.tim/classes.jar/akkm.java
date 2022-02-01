import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class akkm
  extends ReportDialog
  implements View.OnClickListener
{
  protected ImageView BN;
  protected TextView Wi;
  protected ajoz a;
  protected RoundRelativeLayout d;
  protected Button dy;
  protected Drawable eY;
  protected ImageView mCloseView;
  protected Context mContext;
  protected int mImgHeight;
  protected int mImgWidth;
  protected TextView mMoreText;
  
  public akkm(Context paramContext)
  {
    super(paramContext, 2131756467);
    this.mContext = paramContext;
    init();
  }
  
  public boolean a(ajoz paramajoz)
  {
    this.a = paramajoz;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAppDownloadDialog", 2, "initContent=" + paramajoz.toString());
    }
    m(this.BN, paramajoz.imageUrl);
    if (!TextUtils.isEmpty(paramajoz.bRT))
    {
      this.dy.setText(paramajoz.bRT);
      this.dy.setVisibility(0);
      if (TextUtils.isEmpty(paramajoz.bRS)) {
        break label141;
      }
      this.Wi.setText(paramajoz.bRS);
      this.Wi.setVisibility(0);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramajoz.moreUrl)) {
        break label153;
      }
      this.mMoreText.setVisibility(0);
      return false;
      this.dy.setVisibility(8);
      break;
      label141:
      this.Wi.setVisibility(8);
    }
    label153:
    this.mMoreText.setVisibility(8);
    return false;
  }
  
  protected void init()
  {
    setContentView(2131559144);
    this.d = ((RoundRelativeLayout)findViewById(2131365389));
    this.dy = ((Button)findViewById(2131363764));
    this.BN = ((ImageView)findViewById(2131363404));
    this.mCloseView = ((ImageView)findViewById(2131368994));
    this.Wi = ((TextView)findViewById(2131379724));
    this.mMoreText = ((TextView)findViewById(2131371927));
    this.mCloseView.setOnClickListener(this);
    this.dy.setOnClickListener(this);
    this.mMoreText.setOnClickListener(this);
    this.d.setRoundLayoutRadius(ankt.dip2px(3.0F));
    this.mImgWidth = (ankt.SCREEN_WIDTH - ankt.dip2px(28.0F) * 2);
    this.mImgHeight = (this.mImgWidth * 150 / 320);
    ViewGroup.LayoutParams localLayoutParams = this.BN.getLayoutParams();
    localLayoutParams.width = this.mImgWidth;
    localLayoutParams.height = this.mImgHeight;
    this.BN.setLayoutParams(localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAppDownloadDialog", 2, "init, w=" + this.mImgWidth + ", h=" + this.mImgHeight);
    }
  }
  
  protected void m(ImageView paramImageView, String paramString)
  {
    if (this.eY == null) {
      this.eY = new ColorDrawable(Color.parseColor("#f4f4f4"));
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAppDownloadDialog", 2, "loadImage, url=" + paramString);
    }
    Object localObject2 = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.mImgHeight;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.mImgWidth;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.eY;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.eY;
        localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      }
      for (;;)
      {
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = this.eY;
        }
        paramImageView.setImageDrawable(paramString);
        return;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("NearbyAppDownloadDialog", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("NearbyAppDownloadDialog", 2, "loadImage exp: url=" + paramString, localException);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131368994)
    {
      dismiss();
      report("pop_new_quit");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131363764)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyAppDownloadDialog", 2, "btn onClick, jumpUrl=" + this.a.btnUrl);
        }
        akks.bJ(this.mContext, this.a.btnUrl);
        dismiss();
        report("pop_new_clk");
      }
      else if (i == 2131371927)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyAppDownloadDialog", 2, "more onClick, jumpUrl=" + this.a.moreUrl);
        }
        akks.bJ(this.mContext, this.a.moreUrl);
      }
    }
  }
  
  protected void report(String paramString)
  {
    new anov(null).a("dc00899").b("grp_lbs").c("home").d(paramString).e(this.a.toUin).a(new String[] { this.a.d1 }).report();
  }
  
  public void show()
  {
    super.show();
    report("pop_new_exp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkm
 * JD-Core Version:    0.7.0.1
 */
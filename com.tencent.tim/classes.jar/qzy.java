import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;

public class qzy
  extends ReportDialog
{
  private boolean aGj;
  private String azi;
  private String azj;
  private int bpj = -1;
  private View.OnClickListener cI;
  private View.OnClickListener cJ;
  private View.OnClickListener cK;
  private String content;
  private Button cq;
  private Button cs;
  private VideoView d;
  private String imgUrl;
  private boolean isLocal;
  private RelativeLayout mContainer;
  private Drawable mDrawable;
  private String mVideoPath;
  private ImageView nd;
  private ImageView ne;
  private TextView yb;
  
  public qzy(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void initVideoView()
  {
    if (!TextUtils.isEmpty(this.mVideoPath))
    {
      this.d.setVisibility(0);
      this.d.setVideoPath(this.mVideoPath);
      this.d.setZOrderOnTop(true);
      this.d.start();
      return;
    }
    this.d.setVisibility(8);
  }
  
  private void setImage()
  {
    if ((this.aGj) && (!TextUtils.isEmpty(this.imgUrl)))
    {
      this.nd.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "story_rename_guide";
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = rpq.dip2px(getContext(), 3.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = rpq.dip2px(getContext(), 155.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = rpq.dip2px(getContext(), 307.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
      if (this.isLocal)
      {
        localObject = URLDrawable.getDrawable(new File(this.imgUrl), (URLDrawable.URLDrawableOptions)localObject);
        if (((URLDrawable)localObject).getStatus() != 1) {
          ((URLDrawable)localObject).restartDownload();
        }
        this.nd.setImageDrawable((Drawable)localObject);
        return;
      }
      localObject = URLDrawable.getDrawable(this.imgUrl, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() != 1) {
        ((URLDrawable)localObject).restartDownload();
      }
      this.nd.setImageDrawable((Drawable)localObject);
      return;
    }
    if (!TextUtils.isEmpty(this.imgUrl))
    {
      this.nd.setVisibility(0);
      rpq.a(this.nd, this.imgUrl, rpq.dip2px(getContext(), 307.0F), rpq.dip2px(getContext(), 155.0F), new qwh(rpq.dip2px(getContext(), 4.0F), 0, 0.504886F, null, null));
      return;
    }
    if (this.bpj != -1)
    {
      this.nd.setVisibility(0);
      this.nd.setImageResource(this.bpj);
      return;
    }
    if (this.mDrawable != null)
    {
      this.nd.setVisibility(8);
      return;
    }
    this.nd.setVisibility(8);
  }
  
  public qzy a(View.OnClickListener paramOnClickListener)
  {
    this.cI = paramOnClickListener;
    return this;
  }
  
  public qzy a(String paramString)
  {
    this.mVideoPath = paramString;
    return this;
  }
  
  public qzy a(boolean paramBoolean)
  {
    this.aGj = paramBoolean;
    return this;
  }
  
  public qzy b(View.OnClickListener paramOnClickListener)
  {
    this.cJ = paramOnClickListener;
    return this;
  }
  
  public qzy b(String paramString)
  {
    this.imgUrl = paramString;
    return this;
  }
  
  public qzy b(boolean paramBoolean)
  {
    this.isLocal = paramBoolean;
    return this;
  }
  
  public qzy c(View.OnClickListener paramOnClickListener)
  {
    this.cK = paramOnClickListener;
    return this;
  }
  
  public qzy c(String paramString)
  {
    this.content = paramString;
    return this;
  }
  
  public qzy d(String paramString)
  {
    this.azi = paramString;
    return this;
  }
  
  public void dismiss()
  {
    if ((this.d != null) && (this.d.isPlaying())) {
      this.d.stopPlayback();
    }
    super.dismiss();
  }
  
  public qzy e(String paramString)
  {
    this.azj = paramString;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561862);
    this.mContainer = ((RelativeLayout)findViewById(2131375165));
    this.d = ((VideoView)findViewById(2131381864));
    this.nd = ((ImageView)findViewById(2131375166));
    this.yb = ((TextView)findViewById(2131375164));
    this.ne = ((ImageView)findViewById(2131375163));
    this.cs = ((Button)findViewById(2131375168));
    this.cq = ((Button)findViewById(2131375169));
    initVideoView();
    setImage();
    if (TextUtils.isEmpty(this.content))
    {
      this.yb.setVisibility(8);
      if (!TextUtils.isEmpty(this.azj)) {
        break label256;
      }
      this.cq.setVisibility(8);
      label148:
      if (!TextUtils.isEmpty(this.azi)) {
        break label314;
      }
      this.cs.setVisibility(8);
    }
    for (;;)
    {
      if (this.cK == null) {
        break label372;
      }
      this.ne.setOnClickListener(this.cK);
      return;
      this.yb.setVisibility(0);
      if (this.yb.getPaint().measureText(this.content) > rpq.dip2px(getContext(), 280.0F)) {
        this.yb.setGravity(3);
      }
      for (;;)
      {
        this.yb.setText(this.content);
        break;
        this.yb.setGravity(17);
      }
      label256:
      this.cq.setVisibility(0);
      this.cq.setText(this.azj);
      if (this.cI != null)
      {
        this.cq.setOnClickListener(this.cI);
        break label148;
      }
      this.cq.setOnClickListener(new qzz(this));
      break label148;
      label314:
      this.cs.setVisibility(0);
      this.cs.setTag(this.azi);
      if (this.cJ != null) {
        this.cs.setOnClickListener(this.cJ);
      } else {
        this.cs.setOnClickListener(new raa(this));
      }
    }
    label372:
    this.ne.setOnClickListener(new rab(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzy
 * JD-Core Version:    0.7.0.1
 */
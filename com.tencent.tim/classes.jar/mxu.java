import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.TopBarInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mxu
  implements DialogInterface.OnShowListener, View.OnClickListener, rrt.a
{
  private mxu.a a;
  private int aVi;
  private boolean apZ;
  private Drawable cH;
  private Activity mActivity;
  private int mFrom;
  private boolean yD;
  
  public mxu(Activity paramActivity, View paramView, mxu.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.apZ = paramBoolean;
    this.mActivity = paramActivity;
    this.mFrom = paramInt1;
    this.aVi = paramInt2;
    this.a = parama;
  }
  
  private void a(VideoInfo paramVideoInfo, ViewGroup paramViewGroup, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(paramVideoInfo, paramViewGroup, paramImageView1, paramTextView, paramImageView2, paramBoolean1))
    {
      if ((paramBoolean2) && (paramViewGroup.getVisibility() == 0)) {
        muj.a(paramViewGroup, 200);
      }
      if (this.apZ) {
        a(paramVideoInfo, "0X800929D", true);
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, "0X800924D", false);
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString, boolean paramBoolean)
  {
    nce.a locala = new nce.a(paramVideoInfo);
    if ((paramVideoInfo.a != null) && (!TextUtils.isEmpty(paramVideoInfo.a.WT))) {
      locala.a(paramVideoInfo.a.WT);
    }
    for (;;)
    {
      locala.h(paramVideoInfo.Wz).v(this.aVi).w(this.mActivity.getIntent().getIntExtra("key_source", 0)).g(paramBoolean);
      kbp.b(null, "", paramString, paramString, 0, 0, String.valueOf(this.mFrom), "", "", locala.a().toJsonString(), false);
      return;
      locala.a(paramVideoInfo.videoReportInfo);
    }
  }
  
  private boolean a(VideoInfo paramVideoInfo, ViewGroup paramViewGroup, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2, boolean paramBoolean)
  {
    paramVideoInfo = paramVideoInfo.a;
    int i;
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.title)) && (!TextUtils.isEmpty(paramVideoInfo.iconUrl)))
    {
      paramTextView.setText(paramVideoInfo.title);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseAutoScaleParams = false;
      if (paramBoolean)
      {
        i = 12;
        i = wja.dp2px(i, this.mActivity.getResources());
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = i;
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
        paramImageView1.setImageDrawable(URLDrawable.getDrawable(paramVideoInfo.iconUrl, localURLDrawableOptions));
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        paramViewGroup.setVisibility(0);
        if ((paramBoolean) && (!TextUtils.isEmpty(paramVideoInfo.backgroundUrl)))
        {
          paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
          paramViewGroup.mRequestWidth = aqcx.dip2px(this.mActivity, 23.0F);
          paramViewGroup.mRequestHeight = aqcx.dip2px(this.mActivity, 23.0F);
          paramImageView2.setImageDrawable(URLDrawable.getDrawable(paramVideoInfo.backgroundUrl, paramViewGroup));
        }
      }
      do
      {
        do
        {
          return bool;
          i = 18;
          break;
        } while (this.cH == null);
        paramImageView2.setImageDrawable(this.cH);
        return bool;
        paramViewGroup.setVisibility(8);
        paramTextView.setText("");
        paramImageView1.setImageDrawable(null);
      } while (this.cH == null);
      paramImageView2.setImageDrawable(this.cH);
      return bool;
    }
  }
  
  private void k(mtg.l paraml)
  {
    if ((paraml instanceof mtg.k))
    {
      paraml = (mtg.k)paraml;
      if (paraml.bm != null) {
        paraml.bm.setVisibility(8);
      }
    }
  }
  
  public void a(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    this.yD = false;
    if (this.a != null)
    {
      paramDialogInterface = this.a;
      if (paramInt != 0) {
        bool = true;
      }
      paramDialogInterface.oF(bool);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, mtg.l paraml, boolean paramBoolean)
  {
    ImageView localImageView = null;
    if ((paramVideoInfo == null) || (paraml == null) || (paramVideoInfo.a == null)) {
      k(paraml);
    }
    label230:
    for (;;)
    {
      return;
      Object localObject;
      ViewGroup localViewGroup;
      TextView localTextView;
      if ((paraml instanceof mtg.k))
      {
        localObject = (mtg.k)paraml;
        if (((mtg.k)localObject).bm == null)
        {
          ((mtg.k)localObject).bm = ((ViewGroup)((ViewStub)((mtg.k)localObject).bt.findViewById(2131381694)).inflate());
          ((mtg.k)localObject).jT = ((ImageView)((mtg.k)localObject).bm.findViewById(2131381674));
          ((mtg.k)localObject).jS = ((ImageView)((mtg.k)localObject).bm.findViewById(2131381675));
          ((mtg.k)localObject).rJ = ((TextView)((mtg.k)localObject).bm.findViewById(2131381689));
        }
        localViewGroup = ((mtg.k)paraml).bm;
        localObject = ((mtg.k)paraml).jS;
        localTextView = ((mtg.k)paraml).rJ;
        localImageView = ((mtg.k)paraml).jT;
      }
      for (paraml = localViewGroup;; paraml = null)
      {
        if ((paraml == null) || (localObject == null) || (localTextView == null)) {
          break label230;
        }
        if (this.cH == null) {
          this.cH = localImageView.getDrawable();
        }
        paraml.setOnClickListener(this);
        if (paraml.getVisibility() == 0) {
          break;
        }
        a(paramVideoInfo, paraml, (ImageView)localObject, localTextView, localImageView, true, paramBoolean);
        return;
        localTextView = null;
        localObject = null;
      }
    }
  }
  
  public boolean cV()
  {
    return this.yD;
  }
  
  public void onClick(View paramView)
  {
    VideoInfo localVideoInfo = this.a.a(paramView);
    if (localVideoInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        if (!this.apZ) {
          break label97;
        }
        a(localVideoInfo, "0x800929E", true);
        break;
        if ((localVideoInfo.a != null) && (localVideoInfo.a.a != null)) {
          muj.a(this.mActivity, localVideoInfo.a.a);
        }
      }
      label97:
      a(localVideoInfo, "0X800924E", false);
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (this.a != null) {
      this.a.aTc();
    }
    this.yD = true;
  }
  
  public static abstract interface a
  {
    public abstract VideoInfo a(View paramView);
    
    public abstract void aTc();
    
    public abstract void oF(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxu
 * JD-Core Version:    0.7.0.1
 */
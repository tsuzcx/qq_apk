import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class apit
{
  public static final String[] hA = { "完美！\n为你打Call。", "真棒！\n背得很流畅哦。", "加油！\n但还可以更好。" };
  private static final String[] hz = { "https://pub.idqqimg.com/pc/misc/files/20180315/a9ebfbc36f364fd6bd186620148066ba.gif", "https://pub.idqqimg.com/pc/misc/files/20180315/43357aa60b24452baba7707ed7f75c88.gif", "https://pub.idqqimg.com/pc/misc/files/20180315/a4c4d2db3416431181d67fa5de1af860.gif" };
  private ImageView Ey;
  private View Iu;
  private View Iv;
  private View Iw;
  private View Ix;
  private View Iy;
  private Animation aW;
  private TextView aaJ;
  private TextView aaK;
  private TextView aaL;
  private SpriteVideoView b;
  private boolean cQT = true;
  public View mContentView;
  private Context mContext;
  private TextView wb;
  private View wu;
  
  public apit(Context paramContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(paramContext).inflate(2131560829, paramViewGroup, false);
    initChildView();
    this.mContentView.setVisibility(8);
  }
  
  private void SU(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = this.cQT;
    localURLDrawableOptions.mRequestWidth = this.Ey.getMeasuredWidth();
    localURLDrawableOptions.mRequestHeight = this.Ey.getMeasuredHeight();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDownloadListener(new apiw(this));
    this.Ey.setImageDrawable(paramString);
    if ((paramString.getStatus() == 1) && (paramString.getCurrDrawable() != null))
    {
      dZU();
      return;
    }
    paramString.startDownload();
  }
  
  private void a(boolean paramBoolean, View paramView1, View paramView2)
  {
    int i = paramView1.getMeasuredHeight();
    int j = paramView2.getMeasuredHeight();
    if (this.aW == null)
    {
      this.aW = new TranslateAnimation(0.0F, 0.0F, i + j, j);
      this.aW.setFillAfter(true);
    }
    paramView2 = this.aW;
    if (paramBoolean) {}
    for (long l = 1000L;; l = 0L)
    {
      paramView2.setDuration(l);
      paramView1.startAnimation(this.aW);
      return;
    }
  }
  
  private CharSequence b(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = new SpannableString(new StringBuilder(paramString1).append(paramString2));
    paramString2.setSpan(new apuw(this.mContext, 0, 20, 1, 7, 14, paramInt, paramString1), 0, paramString1.length(), 33);
    return paramString2;
  }
  
  private void dZS()
  {
    if (this.b != null) {
      this.b.dTU();
    }
    if (this.aW != null) {
      this.aW.cancel();
    }
  }
  
  private void dZT()
  {
    if (this.b != null)
    {
      this.b.setVisibility(0);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        apuo.a((QQAppInterface)localAppRuntime, "qb_troop_hw_recite_result.mp4", "https://pub.idqqimg.com/pc/misc/files/20180312/59583551a1c748dfaae1e64f6e04ca20.mp4", this.b, new apit.a(this.b, null));
      }
    }
  }
  
  private void dZU()
  {
    if (this.cQT)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    AbstractGifImage.pauseAll();
  }
  
  private void initChildView()
  {
    this.Iu = this.mContentView.findViewById(2131381455);
    this.wb = ((TextView)this.mContentView.findViewById(2131380615));
    this.Ey = ((ImageView)this.mContentView.findViewById(2131369731));
    this.Iv = this.mContentView.findViewById(2131381444);
    this.aaJ = ((TextView)this.mContentView.findViewById(2131381031));
    this.aaK = ((TextView)this.mContentView.findViewById(2131380683));
    this.aaL = ((TextView)this.mContentView.findViewById(2131380895));
    this.Iw = this.mContentView.findViewById(2131381445);
    this.Ix = this.mContentView.findViewById(2131381447);
    this.wu = this.mContentView.findViewById(2131381457);
    this.Iy = this.mContentView.findViewById(2131377404);
    this.b = ((SpriteVideoView)this.mContentView.findViewById(2131379038));
  }
  
  public void OY()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      apuo.u((QQAppInterface)localObject1, "qb_troop_hw_recite_result.mp4", "https://pub.idqqimg.com/pc/misc/files/20180312/59583551a1c748dfaae1e64f6e04ca20.mp4");
    }
    localObject1 = hz;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      if ((((URLDrawable)localObject2).getStatus() != 1) || (((URLDrawable)localObject2).getCurrDrawable() == null)) {
        ((URLDrawable)localObject2).startDownload();
      }
      i += 1;
    }
  }
  
  public void a(SpriteVideoView paramSpriteVideoView)
  {
    this.b = paramSpriteVideoView;
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    this.cQT = paramBoolean;
    this.mContentView.setVisibility(0);
    paramString = this.mContext.getResources();
    int j = 2130844608;
    int i = paramString.getColor(2131165381);
    paramInt1 -= 1;
    int k;
    if (paramInt1 < hA.length)
    {
      k = paramInt1;
      if (paramInt1 >= 0) {}
    }
    else
    {
      k = hA.length - 1;
    }
    String str1 = hA[k];
    String str2 = hz[k];
    paramInt1 = 0;
    int m = 2130844588;
    switch (k)
    {
    default: 
      this.Iu.setBackgroundResource(m);
      this.Iu.setLayerType(1, null);
      this.wb.setTextColor(i);
      this.wb.setText(str1);
      if (this.Ey.getMeasuredHeight() > 0)
      {
        SU(str2);
        label168:
        this.Iv.setBackgroundResource(j);
        this.aaJ.setTextColor(i);
        j = (int)(paramLong / 60L);
        m = (int)(paramLong % 60L);
        paramString = new StringBuilder().append(j).append("'");
        if (m != 0) {
          paramString.append(m);
        }
        this.aaJ.setText(b(acfp.m(2131713730), paramString.toString(), paramInt1));
        this.aaK.setTextColor(i);
        this.aaK.setText(b(acfp.m(2131713728), String.valueOf(paramInt2), paramInt1));
        this.aaL.setTextColor(i);
        this.aaL.setText(b(acfp.m(2131713729), String.valueOf(paramInt3), paramInt1));
        if (this.Iy.getMeasuredHeight() != 0) {
          break label440;
        }
        this.Iy.getViewTreeObserver().addOnGlobalLayoutListener(new apiv(this, paramBoolean));
      }
      break;
    }
    for (;;)
    {
      if ((paramBoolean) && (k == 0)) {
        dZT();
      }
      return;
      paramInt1 = Color.parseColor("#636363");
      break;
      paramInt1 = paramString.getColor(2131167654);
      m = 2130844589;
      j = 2130844607;
      i = paramInt1;
      break;
      paramInt1 = paramString.getColor(2131167654);
      j = 2130844606;
      i = paramInt1;
      break;
      this.Ey.getViewTreeObserver().addOnGlobalLayoutListener(new apiu(this, str2));
      break label168;
      label440:
      this.wu.setVisibility(4);
      a(paramBoolean, this.Iy, this.Iw);
    }
  }
  
  public void onDestroy()
  {
    dZS();
  }
  
  public void onPause() {}
  
  public void reset()
  {
    this.mContentView.setVisibility(8);
    this.wu.setVisibility(0);
    if (this.b != null)
    {
      this.b.stop();
      this.b.setVisibility(8);
    }
    if (this.aW != null) {
      this.aW.cancel();
    }
    this.Ey.setImageDrawable(null);
  }
  
  static class a
    implements anyo.a
  {
    final WeakReference<SpriteVideoView> id;
    
    private a(SpriteVideoView paramSpriteVideoView)
    {
      this.id = new WeakReference(paramSpriteVideoView);
    }
    
    public void byj()
    {
      SpriteVideoView localSpriteVideoView = (SpriteVideoView)this.id.get();
      if (localSpriteVideoView != null) {
        localSpriteVideoView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apit
 * JD-Core Version:    0.7.0.1
 */
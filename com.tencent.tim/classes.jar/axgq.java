import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.1;
import dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.3;
import dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.4;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class axgq
  extends RecyclerView.ViewHolder
  implements axie, URLDrawable.URLDrawableListener2
{
  private static final String cUk;
  private static final Drawable he = getAppContext().getResources().getDrawable(2130837905);
  private static final Map<String, WeakReference<URLDrawable>> qI = new HashMap();
  private ImageView Ie;
  private View MA;
  private View MB;
  private URLDrawable T;
  private final String TAG = "AEPlayShowGridViewHolder";
  private axgq.a a;
  private ProgressBar aA;
  private TextView ahb;
  private String cUl = "";
  private String cUm = "";
  private int layoutType;
  axbu m;
  private String mId = "";
  private int mPosition = -1;
  
  static
  {
    File localFile = new File(awtn.d.a.PATH, "play_show_apng");
    cUk = localFile.getPath();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public axgq(View paramView, axgn.a parama, axgq.a parama1, int paramInt)
  {
    super(paramView);
    this.layoutType = paramInt;
    if (paramInt == 1) {
      paramView.post(new AEPlayShowGridViewHolder.1(this, paramView));
    }
    this.a = parama1;
    this.Ie = ((ImageView)paramView.findViewById(2131362321));
    this.MA = paramView.findViewById(2131362322);
    this.ahb = ((TextView)paramView.findViewById(2131362325));
    this.aA = ((ProgressBar)paramView.findViewById(2131362324));
    this.MB = paramView.findViewById(2131362323);
    parama1 = paramView.getLayoutParams();
    parama1.width = parama.itemWidth;
    parama1.height = parama.itemHeight;
    paramView.setLayoutParams(parama1);
    paramView.setOnClickListener(new axgr(this));
  }
  
  private void E(@NonNull axbu paramaxbu)
  {
    this.mId = paramaxbu.id;
    if (TextUtils.isEmpty(paramaxbu.playShowDisplayText)) {}
    for (String str = "";; str = paramaxbu.playShowDisplayText)
    {
      this.cUl = str;
      this.cUm = paramaxbu.playShowCoverImg;
      paramaxbu = cUk + File.separator + this.cUm.hashCode() + "_" + this.mId.hashCode() + ".png";
      eJB();
      this.T = a(paramaxbu, this.cUm);
      if (this.T != null)
      {
        this.T.setURLDrawableListener(this);
        this.Ie.setImageDrawable(this.T);
      }
      return;
    }
  }
  
  private URLDrawable a(@NonNull String paramString1, @NonNull String paramString2)
  {
    return aqqx.a(paramString1, paramString2, he, null, "-GY-PLAY-SHOW-", null);
  }
  
  private void eJB()
  {
    this.MA.setVisibility(0);
    if (this.layoutType != 1) {
      this.MB.setVisibility(0);
    }
    this.ahb.setText(this.cUl);
  }
  
  private static Context getAppContext()
  {
    return BaseApplicationImpl.getApplication();
  }
  
  public void bl(String paramString, int paramInt)
  {
    if ((paramString == null) || (!paramString.equals(this.m.id))) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPlayShowGridViewHolder.3(this, paramInt));
  }
  
  public void c(@NonNull axbu paramaxbu, int paramInt)
  {
    this.m = paramaxbu;
    this.mPosition = paramInt;
    if (this.T != null) {
      this.T.setURLDrawableListener(null);
    }
    E(paramaxbu);
    this.aA.setVisibility(8);
  }
  
  public void dR(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!paramString.equals(this.m.id))) {
      return;
    }
    axiy.i("AEPlayShowGridViewHolder", "【Play Item】onDownloadFinish id:" + paramString);
    axiy.i("AEPlayShowGridViewHolder", "【Play Item】onDownloadFinish isSuccess:" + paramBoolean);
    ThreadManager.getUIHandler().post(new AEPlayShowGridViewHolder.4(this, paramBoolean));
  }
  
  public void eJA()
  {
    this.aA.setVisibility(8);
  }
  
  public void onDownloadStart()
  {
    this.aA.setVisibility(0);
    this.aA.setProgress(0);
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    eJB();
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, axbu paramaxbu, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgq
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController.2;
import com.tencent.mobileqq.trooppiceffects.view.NormalPicView;
import com.tencent.mobileqq.trooppiceffects.view.PhantomPicView;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;
import com.tencent.mobileqq.trooppiceffects.view.VideoPicView;
import com.tencent.qphone.base.util.QLog;

public class apyu
{
  protected apzb a;
  protected ViewGroup cV;
  protected Handler mHandler;
  
  public apyu(ViewGroup paramViewGroup)
  {
    this.cV = paramViewGroup;
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void ih(String paramString1, String paramString2)
  {
    anot.a(null, "dc00899", "show_pic", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt1, Bitmap paramBitmap, int paramInt2, apyu.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "showPicEffect");
    }
    if ((this.a == null) && (this.cV != null)) {
      switch (paramInt1)
      {
      default: 
        this.a = new NormalPicView(this.cV.getContext());
      }
    }
    for (;;)
    {
      this.cV.removeAllViews();
      this.cV.addView(this.a.getView(), -1, paramInt2);
      this.a.setBitmap(paramBitmap);
      this.a.play();
      this.mHandler.postDelayed(new TroopPicEffectsController.2(this, parama), 6000L);
      return;
      this.a = new PhantomPicView(this.cV.getContext());
      continue;
      this.a = new ShakePicView(this.cV.getContext());
      continue;
      this.a = new VideoPicView(this.cV.getContext(), paramInt1);
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean)
  {
    akxq localakxq = akxj.a(6, 1536, 1);
    akxl localakxl = paramMessageForTroopEffectPic.getPicDownloadInfo();
    localakxq.a(paramMessageForTroopEffectPic, localakxl);
    localakxq.b(new apyv(this, localakxl, paramTroopChatPie, paramMessageForTroopEffectPic, paramBoolean));
    akxj.a(localakxq, paramTroopChatPie.app);
  }
  
  public void dZt()
  {
    this.cV = null;
  }
  
  public void ecF()
  {
    if ((this.a != null) && (this.cV != null))
    {
      this.a.onDestroy();
      this.cV.removeView(this.a.getView());
      this.a = null;
    }
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public static abstract interface a
  {
    public abstract void onEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyu
 * JD-Core Version:    0.7.0.1
 */
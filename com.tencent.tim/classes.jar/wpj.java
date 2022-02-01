import android.animation.Animator;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class wpj
{
  public static final String FilePath = aqul.getSDKPrivatePath(acbn.SDCARD_ROOT + "/Tencent/MobileQQ/pttPanelAnimations/");
  public static final String aTO = aqul.getSDKPrivatePath(acbn.SDCARD_ROOT + "/Tencent/MobileQQ/pttPanelAnimations/qq_android_ptt_transition_anim_res/");
  private static Map<Integer, String> hv;
  private Cancellable a;
  private Set<wpj.b> bh;
  private Set<Integer> bi;
  private Map<String, LottieDrawable> hu = new HashMap(20);
  
  private wpj()
  {
    hv = new HashMap(20);
    this.bh = new HashSet();
    this.bi = new CopyOnWriteArraySet();
    hv.put(Integer.valueOf(1), "ptt_voicechange_to_press_anim/");
    hv.put(Integer.valueOf(2), "ptt_press_to_voicechange_anim/");
    hv.put(Integer.valueOf(3), "ptt_press_to_record_anim/");
    hv.put(Integer.valueOf(4), "ptt_record_to_press_anim/");
    hv.put(Integer.valueOf(5), "ptt_record_to_stop_record_anim/");
    hv.put(Integer.valueOf(201), "ptt_recordstop_to_play_anim/");
    hv.put(Integer.valueOf(202), "ptt_play_to_stop_anim/");
    hv.put(Integer.valueOf(203), "ptt_stop_to_play_anim/");
    hv.put(Integer.valueOf(6), "ptt_record_to_voicechange_anim/");
    hv.put(Integer.valueOf(7), "ptt_voicechange_to_record_anim/");
    hv.put(Integer.valueOf(101), "ptt_voicechange_to_press_anim_night/");
    hv.put(Integer.valueOf(102), "ptt_press_to_voicechange_anim_night/");
    hv.put(Integer.valueOf(103), "ptt_press_to_record_anim_night/");
    hv.put(Integer.valueOf(104), "ptt_record_to_press_anim_night/");
    hv.put(Integer.valueOf(105), "ptt_record_to_stop_record_anim_night/");
    hv.put(Integer.valueOf(301), "ptt_recordstop_to_play_anim_night/");
    hv.put(Integer.valueOf(302), "ptt_play_to_stop_anim_night/");
    hv.put(Integer.valueOf(303), "ptt_stop_to_play_anim_night/");
    hv.put(Integer.valueOf(106), "ptt_record_to_voicechange_anim_night/");
    hv.put(Integer.valueOf(107), "ptt_voicechange_to_record_anim_night/");
  }
  
  public static wpj a()
  {
    return wpj.a.b();
  }
  
  private void b(Animator paramAnimator, int paramInt)
  {
    Iterator localIterator = this.bh.iterator();
    while (localIterator.hasNext())
    {
      wpj.b localb = (wpj.b)localIterator.next();
      if (localb != null) {
        localb.a(paramAnimator, paramInt);
      }
    }
  }
  
  private void b(LottieDrawable paramLottieDrawable, int paramInt)
  {
    Iterator localIterator = this.bh.iterator();
    while (localIterator.hasNext())
    {
      wpj.b localb = (wpj.b)localIterator.next();
      if (localb != null) {
        localb.a(paramLottieDrawable, paramInt);
      }
    }
  }
  
  private void can()
  {
    Iterator localIterator = this.hu.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LottieDrawable localLottieDrawable = (LottieDrawable)this.hu.get(str);
      localLottieDrawable.cancelAnimation();
      localLottieDrawable.removeAllAnimatorListeners();
      localLottieDrawable.recycleBitmaps();
      localLottieDrawable.clearCompositionAndCache(str + "data.json");
      localLottieDrawable.setImageAssetDelegate(null);
    }
    this.hu.clear();
  }
  
  public LottieDrawable a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel getDrawable type" + paramInt);
    }
    if ((hv == null) || (!hv.containsKey(Integer.valueOf(paramInt))))
    {
      QLog.e("AudioTransitionAnimManager", 1, "getDrawable mResPathMap error.");
      return null;
    }
    String str = (String)hv.get(Integer.valueOf(paramInt));
    if ((this.hu.containsKey(str)) && (this.hu.get(str) != null)) {
      return (LottieDrawable)this.hu.get(str);
    }
    if (this.bi.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel getDrawable loading type" + paramInt);
      }
      return null;
    }
    this.bi.add(Integer.valueOf(paramInt));
    ThreadManager.post(new AudioTransitionAnimManager.1(this, str, paramContext, paramInt), 5, null, true);
    return null;
  }
  
  public void a(LottieDrawable paramLottieDrawable, float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((paramFloat > 1.0F) || (paramFloat < 0.0F)) {
      return;
    }
    float f = paramFloat;
    if (wpm.gr(paramInt)) {
      f = 1.0F - paramFloat;
    }
    paramLottieDrawable.setProgress(f);
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt, ImageView paramImageView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel playTransitionAnim   type" + paramInt + " drawable=" + paramLottieDrawable + " needDoPlay= " + paramBoolean);
    }
    if ((paramLottieDrawable == null) || (paramImageView == null)) {}
    do
    {
      return;
      paramImageView.setImageDrawable(paramLottieDrawable);
      paramLottieDrawable.removeAllAnimatorListeners();
      paramLottieDrawable.addAnimatorListener(new wpl(this, paramLottieDrawable, paramInt, paramImageView));
    } while (!paramBoolean);
    paramLottieDrawable.playAnimation();
  }
  
  public void a(wpj.b paramb)
  {
    this.bh.add(paramb);
  }
  
  public boolean a(LottieDrawable paramLottieDrawable)
  {
    return paramLottieDrawable.isAnimating();
  }
  
  public void b(LottieDrawable paramLottieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel cancelAnimation drawable=" + paramLottieDrawable);
    }
    paramLottieDrawable.cancelAnimation();
  }
  
  public boolean bT()
  {
    File localFile = new File(aTO);
    return (localFile.exists()) && (localFile.listFiles().length == hv.size());
  }
  
  public void dl(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransitionAnimManager", 2, "AIOAudioPanel preLoadRes");
    }
    if (paramContext != null)
    {
      a(paramContext, 1);
      a(paramContext, 2);
      a(paramContext, 3);
      a(paramContext, 5);
      a(paramContext, 202);
      a(paramContext, 203);
      a(paramContext, 201);
    }
  }
  
  public void onDestory()
  {
    this.bh.clear();
    this.bi.clear();
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
    if (this.hu != null) {
      can();
    }
  }
  
  static class a
  {
    private static final wpj a = new wpj(null);
  }
  
  public static abstract interface b
  {
    public abstract void a(Animator paramAnimator, int paramInt);
    
    public abstract void a(LottieDrawable paramLottieDrawable, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpj
 * JD-Core Version:    0.7.0.1
 */
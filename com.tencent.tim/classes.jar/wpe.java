import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.RenderMode;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.WeakHashMap;

public class wpe
{
  private Queue<wpe.a> D = new LinkedList();
  private BaseChatPie c;
  private DiniFlyAnimationView e;
  private WeakHashMap<String, Bitmap> f = new WeakHashMap();
  private LinearLayout gW;
  
  public wpe(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
  }
  
  private boolean RD()
  {
    if ((this.e == null) || (this.gW == null)) {}
    label387:
    for (;;)
    {
      return false;
      if (this.e.isAnimating()) {
        return true;
      }
      Object localObject1 = "";
      if ((this.D != null) && (this.D.size() > 0)) {
        localObject1 = ((wpe.a)this.D.peek()).aTN;
      }
      for (int i = ((wpe.a)this.D.peek()).id;; i = 0)
      {
        if (((String)localObject1).isEmpty()) {
          break label387;
        }
        Object localObject4 = new File(this.c.mContext.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/" + (String)localObject1 + "/data.json");
        Object localObject3 = new File(this.c.mContext.getFilesDir().getAbsoluteFile() + File.separator + "animConfig/" + (String)localObject1 + "/images");
        if (((File)localObject4).exists()) {}
        for (;;)
        {
          try
          {
            localObject1 = new FileInputStream((File)localObject4);
            if ((localObject1 == null) || (!((File)localObject3).exists())) {
              break;
            }
            localObject3 = ((File)localObject3).getAbsolutePath();
            this.e.setImageAssetDelegate(new wpg(this, (String)localObject3));
            LottieComposition.Factory.fromInputStream(this.e.getContext(), (InputStream)localObject1, new wph(this));
            localObject4 = this.c.oN();
            localObject1 = (TroopManager)this.c.app.getManager(52);
            localObject3 = "";
            if (localObject1 != null)
            {
              localObject1 = ((TroopManager)localObject1).b((String)localObject4);
              if (localObject1 != null) {
                localObject3 = "" + ((TroopInfo)localObject1).dwGroupClassExt;
              }
              anot.a(null, "dc00898", "", this.c.app.getCurrentAccountUin(), "0X800AE17", "0X800AE17", i, 0, (String)localObject4, (String)localObject3, "", "");
              return true;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return false;
          }
          Object localObject2 = null;
          continue;
          localObject2 = null;
        }
      }
    }
  }
  
  public boolean i(Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return false;
    }
    if (paramVarArgs.length > 1)
    {
      String str = (String)paramVarArgs[0];
      int i = ((Integer)paramVarArgs[1]).intValue();
      if ((!str.isEmpty()) && (i != 0)) {
        this.D.add(new wpe.a(str, i, null));
      }
      if ((this.e != null) && (this.e.isAnimating())) {
        return true;
      }
    }
    else
    {
      return false;
    }
    if (this.gW == null)
    {
      this.gW = ((LinearLayout)View.inflate(this.c.mContext, 2131558632, null));
      if (this.gW == null) {
        return false;
      }
      this.e = ((DiniFlyAnimationView)this.gW.findViewById(2131362364));
      if (this.e == null) {
        return false;
      }
      this.e.addAnimatorListener(new wpf(this));
      paramVarArgs = new RelativeLayout.LayoutParams(-1, -1);
      paramVarArgs.addRule(2, 2131369277);
      this.c.i().addView(this.gW, paramVarArgs);
      this.e.setRenderMode(RenderMode.HARDWARE);
    }
    if (!RD())
    {
      this.D.clear();
      stopAnim();
      return false;
    }
    return true;
  }
  
  public void stopAnim()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEggLottieAnimView", 2, "stopAnim");
    }
    if ((this.e == null) || (this.gW == null)) {
      return;
    }
    this.e.removeAllAnimatorListener();
    if (this.e.isAnimating()) {
      this.e.endAnimation();
    }
    if ((this.D != null) && (!this.D.isEmpty())) {
      this.D.clear();
    }
    if ((this.f != null) && (!this.f.isEmpty())) {
      this.f.clear();
    }
    if (this.c != null)
    {
      RelativeLayout localRelativeLayout = this.c.i();
      if (localRelativeLayout != null) {
        localRelativeLayout.removeView(this.gW);
      }
    }
    this.gW = null;
    this.e = null;
  }
  
  public class a
  {
    public String aTN;
    public int id;
    
    private a(String paramString, int paramInt)
    {
      this.id = paramInt;
      this.aTN = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpe
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.mobileqq.widget.AnimationView.MyAnimationListener;
import com.tencent.qphone.base.util.QLog;

public class zxd
{
  private LinearLayout container;
  private AnimationView.AnimationInfo mAnimInfo;
  private AnimationView mAnimationView;
  
  public zxd(Context paramContext, LinearLayout paramLinearLayout, int paramInt, boolean paramBoolean, AnimationView.MyAnimationListener paramMyAnimationListener)
  {
    this.container = paramLinearLayout;
    this.mAnimationView = new AnimationView(paramContext);
    this.mAnimationView.setmRadius(paramInt, paramBoolean);
    this.mAnimationView.setAnimationListener(paramMyAnimationListener);
    this.container.addView(this.mAnimationView, new LinearLayout.LayoutParams(-1, -1));
  }
  
  public zxd(AnimationView paramAnimationView, int paramInt, boolean paramBoolean, AnimationView.MyAnimationListener paramMyAnimationListener)
  {
    this.mAnimationView = paramAnimationView;
    paramAnimationView.setmRadius(paramInt, paramBoolean);
    this.mAnimationView.setAnimationListener(paramMyAnimationListener);
  }
  
  public static void a(AnimationView paramAnimationView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameAnimHelper", 2, "anim stoped...");
    }
    if (paramAnimationView == null) {}
    do
    {
      return;
      paramAnimationView.stop();
      paramAnimationView.setImageDrawable(null);
      paramAnimationView = paramAnimationView.getAnimationFromInfo();
    } while ((!paramBoolean) || (paramAnimationView == null));
    paramAnimationView.destoryBitmaps();
  }
  
  public void b(AnimationView.AnimationInfo paramAnimationInfo)
  {
    AnimationView localAnimationView = this.mAnimationView;
    this.mAnimInfo = paramAnimationInfo;
    localAnimationView.setAnimationFromInfo(paramAnimationInfo);
    this.mAnimationView.play();
  }
  
  public void bi(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameAnimHelper", 2, "task in thread runs isFolder = " + paramBoolean);
    }
    zxd.a locala = new zxd.a(null);
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      locala.execute(new String[] { paramString, str });
      return;
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameAnimHelper", 2, "anim stoped...");
    }
    this.mAnimationView.stop();
    this.mAnimationView.setImageDrawable(null);
    if (this.mAnimInfo != null)
    {
      this.mAnimInfo.destoryBitmaps();
      this.mAnimInfo = null;
    }
  }
  
  class a
    extends AsyncTask<String, Void, AnimationView.AnimationInfo>
  {
    private a() {}
    
    protected AnimationView.AnimationInfo a(String... paramVarArgs)
    {
      if ("1".equals(paramVarArgs[1])) {
        return AnimationView.AnimationInfo.loadFromZip(paramVarArgs[0]);
      }
      return AnimationView.AnimationInfo.loadFromFolder(paramVarArgs[0]);
    }
    
    protected void a(AnimationView.AnimationInfo paramAnimationInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FrameAnimHelper", 2, "task over info = " + paramAnimationInfo);
      }
      zxd.this.b(paramAnimationInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxd
 * JD-Core Version:    0.7.0.1
 */
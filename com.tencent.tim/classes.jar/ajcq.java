import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;

public class ajcq
{
  private boolean a(ajck paramajck, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramajck.d.cacheKey });
    }
    return true;
  }
  
  ajck a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "createApp type=", Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    default: 
      QLog.e("MiniAppLauncher", 1, "createApp error. unknown appType");
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
      return null;
    }
    return new asgn(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(ajck paramajck, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramajck, paramMiniAppOptions)) {
      return;
    }
    aqgz.getDesity();
    paramajck.start();
  }
  
  void a(ajcn paramajcn, @NonNull ajcl paramajcl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramajcn.cacheKey });
    }
    paramajcl.f(paramajcn.bQG, "MiniAppLauncher", paramajcn.cacheKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcq
 * JD-Core Version:    0.7.0.1
 */
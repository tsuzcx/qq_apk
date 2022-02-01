import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.PatchedButton;
import dov.com.qq.im.ptv.AIOBusinessOperation.1;
import dov.com.qq.im.ptv.AIOBusinessOperation.2;
import dov.com.qq.im.ptv.AIOBusinessOperation.4;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ayag
{
  private static HashMap<String, Drawable> ry = new HashMap();
  private static String sCurrentThemeId = "1000";
  
  public static void a(int paramInt, View paramView, PatchedButton paramPatchedButton, boolean paramBoolean, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    }
    while (bool1)
    {
      paramView.setVisibility(8);
      paramPatchedButton.setVisibility(0);
      return;
      bool1 = paramBoolean;
      continue;
      bool1 = bool2;
      if (paramSourceMsgInfo == null) {
        bool1 = false;
      }
    }
    paramPatchedButton.setVisibility(8);
    paramView.setVisibility(0);
  }
  
  public static void a(PatchedButton paramPatchedButton, AIOLongCaptureCtrl paramAIOLongCaptureCtrl)
  {
    if (AppSetting.enableTalkBack)
    {
      paramPatchedButton.setOnTouchListener(null);
      paramPatchedButton.setOnClickListener(new ayah(paramAIOLongCaptureCtrl));
      return;
    }
    paramPatchedButton.setOnClickListener(null);
    paramPatchedButton.setOnTouchListener(paramAIOLongCaptureCtrl);
  }
  
  private static boolean az(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("theme_light_filter_cfg", 4).edit();
    localEditor.putInt(paramString, paramInt);
    return localEditor.commit();
  }
  
  public static void b(Resources paramResources, String paramString)
  {
    if (paramResources == null) {}
    label172:
    label174:
    label177:
    for (;;)
    {
      return;
      paramResources = paramResources.getDrawable(2130850929);
      if ((paramResources instanceof BitmapDrawable)) {
        paramResources = ((BitmapDrawable)paramResources).getBitmap();
      }
      for (;;)
      {
        if (paramResources == null) {
          break label177;
        }
        int j = paramResources.getWidth();
        int k = paramResources.getHeight();
        int i = paramResources.getPixel(j / 2, k / 2);
        j = paramResources.getPixel(j / 3, k / 3);
        k = j >> 24 & 0xFF;
        if (k > 110) {
          az(paramString, j);
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label172;
          }
          QLog.i("AIOBusinessOperation", 2, "extractCurrentThemeColor centerAlpha:" + (i >> 24 & 0xFF) + " thirdAlpha:" + k + " theme:" + paramString);
          return;
          if (!(paramResources instanceof SkinnableBitmapDrawable)) {
            break label174;
          }
          paramResources = ((SkinnableBitmapDrawable)paramResources).getBitmap();
          break;
          az(paramString, i);
        }
        break;
        paramResources = null;
      }
    }
  }
  
  public static void b(PatchedButton paramPatchedButton, AIOLongCaptureCtrl paramAIOLongCaptureCtrl)
  {
    ThreadManager.getUIHandler().postDelayed(new AIOBusinessOperation.4(paramPatchedButton, paramAIOLongCaptureCtrl), 200L);
  }
  
  public static void d(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    ThreadManager.post(new AIOBusinessOperation.1((ImageView)paramViewGroup.findViewById(2131381620), paramBoolean), 5, null, false);
  }
  
  private static int gp(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("theme_light_filter_cfg", 4).getInt(paramString, 0);
  }
  
  private static Bitmap i(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      int i = 0;
      while (i < paramBitmap.getWidth())
      {
        int j = 0;
        while (j < paramBitmap.getHeight())
        {
          localBitmap.setPixel(i, j, paramBitmap.getPixel(i, j) & 0xFF000000 | 0xFFFFFF & paramInt);
          j += 1;
        }
        i += 1;
      }
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  private static void r(ImageView paramImageView, String paramString)
  {
    ThreadManager.post(new AIOBusinessOperation.2(paramString, paramImageView), 5, null, false);
  }
  
  private static void s(ImageView paramImageView, String paramString)
  {
    int j = gp(paramString);
    if (j == 0) {
      b(paramImageView.getResources(), paramString);
    }
    Object localObject = paramImageView.getResources().getDrawable(2130845317);
    int i;
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      i = 0;
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = i((Bitmap)localObject, j);
        if (localObject == null) {
          break label135;
        }
        if (i == 0) {
          break label121;
        }
      }
      label121:
      for (localObject = new SkinnableBitmapDrawable((Bitmap)localObject);; localObject = new BitmapDrawable((Bitmap)localObject))
      {
        paramImageView.setImageDrawable((Drawable)localObject);
        ry.put(paramString, localObject);
        return;
        if (!(localObject instanceof SkinnableBitmapDrawable)) {
          break label145;
        }
        localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
        i = 1;
        break;
      }
      label135:
      ry.put(paramString, null);
      return;
      label145:
      i = 0;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayag
 * JD-Core Version:    0.7.0.1
 */
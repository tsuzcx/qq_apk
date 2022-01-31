import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;

public final class zdl
  implements Runnable
{
  public zdl(Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class);
    localIntent.putExtra("jump_cm_game", true);
    localIntent.putExtra("jump_cm_game_id", this.jdField_a_of_type_Int);
    localIntent.setFlags(337641472);
    Object localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130839210);
    int i = ((Bitmap)localObject1).getDensity();
    Object localObject2 = URLDrawable.getDrawable(this.b, URLDrawable.URLDrawableOptions.obtain());
    if (localObject2 != null) {
      ((URLDrawable)localObject2).restartDownload();
    }
    try
    {
      Thread.sleep(500L);
      if (localObject2 != null)
      {
        localObject2 = ((URLDrawable)localObject2).getCurrDrawable();
        if ((localObject2 instanceof RegionDrawable))
        {
          localObject1 = ((RegionDrawable)localObject2).getBitmap();
          ((Bitmap)localObject1).setDensity(i);
          i = DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext);
          if (i != ((Bitmap)localObject1).getWidth())
          {
            if (!MobileIssueSettings.c) {}
            for (localObject1 = KapalaiAdapterUtil.a().a((Bitmap)localObject1, i); Build.VERSION.SDK_INT >= 26; localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, i, false))
            {
              localObject2 = (ShortcutManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("shortcut");
              if (!((ShortcutManager)localObject2).isRequestPinShortcutSupported()) {
                break;
              }
              localIntent.setAction("android.intent.action.VIEW");
              localObject1 = new ShortcutInfo.Builder(this.jdField_a_of_type_AndroidContentContext, "QQ" + this.jdField_a_of_type_JavaLangString).setIcon(Icon.createWithBitmap((Bitmap)localObject1)).setShortLabel(this.jdField_a_of_type_JavaLangString).setIntent(localIntent).build();
              localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, WebProcessReceiver.class);
              localIntent.setAction("com.tencent.mobileqq.webprocess.cmgame_shortcut");
              ((ShortcutManager)localObject2).requestPinShortcut((ShortcutInfo)localObject1, PendingIntent.getBroadcast(this.jdField_a_of_type_AndroidContentContext, 0, localIntent, 134217728).getIntentSender());
              return;
            }
            localObject2 = new Intent();
            try
            {
              ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", localIntent);
              ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_JavaLangString);
              ((Intent)localObject2).putExtra("android.intent.extra.shortcut.ICON", (Parcelable)localObject1);
              ((Intent)localObject2).putExtra("duplicate", false);
              ((Intent)localObject2).setAction("com.android.launcher.action.INSTALL_SHORTCUT");
              this.jdField_a_of_type_AndroidContentContext.sendOrderedBroadcast((Intent)localObject2, null);
              return;
            }
            catch (Exception localException1)
            {
              QLog.e("ApolloGameUtil", 1, "Install shortcut error,use default icon:", localException1);
              Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130839210);
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", localIntent);
              ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_JavaLangString);
              ((Intent)localObject2).putExtra("android.intent.extra.shortcut.ICON", localBitmap);
              ((Intent)localObject2).putExtra("duplicate", false);
              ((Intent)localObject2).setAction("com.android.launcher.action.INSTALL_SHORTCUT");
              this.jdField_a_of_type_AndroidContentContext.sendOrderedBroadcast((Intent)localObject2, null);
              return;
            }
          }
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zdl
 * JD-Core Version:    0.7.0.1
 */
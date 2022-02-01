import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;

public class acxk
  extends acuk
{
  public acxk(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean ace()
  {
    if (!(this.context instanceof BaseActivity)) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return true;
          localObject1 = ((BaseActivity)this.context).getIntent();
        } while (localObject1 == null);
        localObject2 = ((Intent)localObject1).getExtras();
      } while (localObject2 == null);
      localObject1 = ((Bundle)localObject2).getString("localAPKPath");
      localObject2 = ((Bundle)localObject2).getString("sourceId");
      if (QLog.isColorLevel()) {
        QLog.d("WadlAction", 1, "gamecenter installApk, pkgName=" + this.pkgName + ",localAPKPath=" + (String)localObject1 + ",sourceId=" + (String)localObject2);
      }
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    Intent localIntent = FileProvider7Helper.openApkIntent(this.context, (String)localObject1);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "biz_src_zf_games";
    }
    localIntent.putExtra("big_brother_source_key", (String)localObject1);
    this.context.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxk
 * JD-Core Version:    0.7.0.1
 */
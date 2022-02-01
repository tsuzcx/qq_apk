import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

final class wmo
  extends AsyncTask<Void, Void, ImageInfo>
{
  wmo(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  protected ImageInfo a(Void... paramVarArgs)
  {
    aqhu.a(-1L, this.a.cZ, true, "image_send_prepare", "sessionInfo.handleScreenPhoto");
    String str = aqhu.b(this.val$app.getApplication(), this.val$path, this.a.cZ);
    paramVarArgs = new ImageInfo();
    aqhu.a(paramVarArgs, "compress_start", "sessionInfo.handleScreenPhoto");
    aqhu.a(3, this.val$context, this.val$path, str, true, paramVarArgs, this.a.cZ);
    if (!aqhq.fileExistsAndNotEmpty(paramVarArgs.filePath)) {
      return null;
    }
    try
    {
      int i = this.a.cZ;
      QQAppInterface localQQAppInterface = this.val$app;
      zsz.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return paramVarArgs;
    }
    catch (Exception localException) {}
    return paramVarArgs;
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    if (paramImageInfo != null)
    {
      Object localObject = new akxy.a();
      ((akxy.a)localObject).setLocalPath(paramImageInfo.filePath);
      ((akxy.a)localObject).So(1027);
      ((akxy.a)localObject).NP(this.a.aTl);
      if (paramImageInfo.ceG == 2) {}
      for (int i = aooh.a.dQD;; i = aooh.a.dQC)
      {
        ((akxy.a)localObject).setProtocolType(i);
        ((akxy.a)localObject).NT(this.a.troopUin);
        ((akxy.a)localObject).kc(this.val$app.getCurrentAccountUin());
        ((akxy.a)localObject).Sp(this.a.cZ);
        akxq localakxq = akxj.a(2, 1027);
        localakxq.c(((akxy.a)localObject).a());
        akxj.a(localakxq, this.val$app);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramImageInfo);
        aqhu.a(this.val$context, (List)localObject, this.a.cZ);
        return;
      }
    }
    aqhu.a(-1L, this.a.cZ, true, "image_send_prepared_failed", "sessionInfo.handleScreenPhoto");
    QQToast.a(this.val$context, this.val$context.getResources().getString(2131696981), 0).show(this.val$context.getResources().getDimensionPixelSize(2131299627));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wmo
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class jjt
  implements jjq.a
{
  jjt(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, String paramString) {}
  
  private void bC(Context paramContext)
  {
    if ((paramContext instanceof JumpActivity)) {
      ((Activity)paramContext).finish();
    }
  }
  
  public void a(int paramInt1, jjq.c paramc, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      bC(this.val$context);
    }
    do
    {
      do
      {
        return;
        avfh.a(this.val$app, this.val$context, this.val$intent, 1);
        return;
        Intent localIntent = new Intent(this.val$context, QQBrowserActivity.class);
        localIntent.putExtra("url", paramc.url);
        if (!(this.val$context instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        this.val$context.startActivity(localIntent);
        bC(this.val$context);
        return;
        ((aicu)this.val$app.getManager(236)).e(this.val$context, this.val$app.getCurrentAccountUin(), this.Sx, "4", "openRoom");
        return;
        if ((this.val$context instanceof Activity))
        {
          jjq.a(this.val$context, paramc.Sy, paramc.Sz, new jju(this));
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "context is not Activity");
      return;
      if ((this.val$context instanceof Activity))
      {
        jjq.a(this.val$context, paramc.Sy, paramc.Sz, new jjv(this));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "context is not Activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jjt
 * JD-Core Version:    0.7.0.1
 */
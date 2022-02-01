import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class apsi
  extends smq.b
{
  apsi(apsf paramapsf) {}
  
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null) {
      return;
    }
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627);
    paramBundle = paramBundle.getString("fileId");
    apef.b.i("TroopFileManager", apef.b.USR, "delete onActionResult: fileId:" + paramBundle + " isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    if (paramBoolean)
    {
      this.c.TR(paramBundle);
      return;
    }
    switch (paramInt)
    {
    default: 
      QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131715722), 0).show(i);
      return;
    case -302: 
    case -301: 
    case -103: 
      QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131715719), 0).show(i);
      this.c.TQ(paramBundle);
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131715703), 0).show(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsi
 * JD-Core Version:    0.7.0.1
 */
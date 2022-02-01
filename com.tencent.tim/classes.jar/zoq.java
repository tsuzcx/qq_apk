import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;

public class zoq
  extends zof
{
  private asgx a;
  
  public zoq(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
    this.aSd = true;
  }
  
  protected void Ib()
  {
    this.TAG = "MiniPieForStranger";
  }
  
  public asgx a()
  {
    if (this.a == null) {
      this.a = ((asgx)this.mApp.getManager(165));
    }
    return this.a;
  }
  
  protected void aC()
  {
    super.aC();
    if (this.brV)
    {
      bFq();
      cqD();
    }
  }
  
  protected void bFq()
  {
    if (!this.brV) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
        } while ((!this.aSd) || ((this.mSessionInfo.cZ == 1025) && (a().sH(this.mSessionInfo.aTl))) || (this.mSessionInfo.cZ != 1006));
        localObject = ((ajdo)this.mApp.getManager(11)).c(this.mSessionInfo.aTl);
        if ((localObject == null) || (aqgv.aU(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) == 0)) {
          break;
        }
        localObject = aqgv.a((PhoneContact)localObject);
        vU(true);
        this.MV.setText((CharSequence)localObject);
      } while (!AppSetting.enableTalkBack);
      this.MV.setContentDescription((CharSequence)localObject);
      return;
    } while (this.MV.getVisibility() != 0);
    vU(false);
  }
  
  protected void cqD()
  {
    if (!this.brV) {}
    for (;;)
    {
      return;
      if (this.vr != null)
      {
        this.vr.setOnClickListener(null);
        if ((ChatActivityUtils.f(this.mApp, this.mSessionInfo)) || (jqs.c(this.mApp, this.mSessionInfo.aTl, this.mSessionInfo.cZ)) || (this.mSessionInfo.cZ == 1)) {
          if (ixa.a().cD(this.mApp.getCurrentAccountUin()))
          {
            this.vr.setVisibility(0);
            this.vr.setContentDescription(this.mContext.getResources().getString(2131700698));
          }
        }
        while ((this.mSessionInfo.cZ != 0) && (this.mSessionInfo.cZ != 1025))
        {
          this.vr.setVisibility(8);
          return;
          this.vr.setVisibility(8);
          continue;
          if ((this.mTitleText.getText() != null) && (this.mTitleText.getText().length() < 6)) {
            this.vr.setVisibility(4);
          } else {
            this.vr.setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zoq
 * JD-Core Version:    0.7.0.1
 */
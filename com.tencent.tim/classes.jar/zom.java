import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.BaseApplication;

public class zom
  extends zof
{
  private asgx a;
  
  public zom(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
    if (paramQQAppInterface.iz(165)) {
      this.a = ((asgx)paramQQAppInterface.getManager(165));
    }
    this.aSd = true;
  }
  
  private void cqC()
  {
    if ((this.mTitleText == null) || (this.mContext == null)) {}
    label176:
    for (;;)
    {
      return;
      Object localObject1 = this.mTitleText.getParent();
      if ((localObject1 instanceof ViewGroup)) {}
      for (localObject1 = (ViewGroup)localObject1;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label176;
        }
        if (aprg.V(this.mApp, this.mSessionInfo.aTl))
        {
          int i = ((ViewGroup)localObject1).indexOfChild(this.mTitleText);
          localObject2 = amip.a(this.mContext);
          if (localObject2 == null) {
            break;
          }
          ((View)localObject2).setId(2131377535);
          ((View)localObject2).setPadding(wja.dp2px(4.0F, this.mTitleText.getResources()), wja.dp2px(6.0F, this.mTitleText.getResources()), 0, 0);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(1, 2131379769);
          localLayoutParams.addRule(6, 2131379769);
          ((View)localObject2).setLayoutParams(localLayoutParams);
          ((ViewGroup)localObject1).addView((View)localObject2, i);
          return;
        }
        Object localObject2 = ((ViewGroup)localObject1).findViewById(2131377535);
        if (localObject2 == null) {
          break;
        }
        ((ViewGroup)localObject1).removeView((View)localObject2);
        return;
      }
    }
  }
  
  protected void Ib()
  {
    this.TAG = "MiniPieForC2C";
  }
  
  protected boolean Vz()
  {
    return true;
  }
  
  protected void aC()
  {
    this.brX = true;
    super.aC();
    if (this.brV)
    {
      bFq();
      if (!TextUtils.equals(this.mSessionInfo.aTl, this.mApp.getCurrentUin())) {
        aqnm.setVisible(this.vr, 0);
      }
    }
    cqC();
  }
  
  protected void bFq()
  {
    if (!this.brV) {}
    label593:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                this.mSessionInfo.beq = false;
                this.mSessionInfo.ber = false;
                if (this.mSessionInfo.cZ == 0)
                {
                  xva.a().k(this.mApp, this.mSessionInfo);
                  yhv.a().k(this.mApp, this.mSessionInfo);
                }
                if ((!this.mSessionInfo.beq) || (!this.mSessionInfo.beu)) {
                  break;
                }
                this.MV.setTextColor(-1);
                this.MV.setAlpha(0.8F);
                localObject = ((acff)this.mApp.getManager(51)).e(this.mSessionInfo.aTl);
                if ((localObject != null) && ((aqgv.aU(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || (!TextUtils.isEmpty(((Friends)localObject).strTermDesc))))
                {
                  localObject = aqgv.d((Friends)localObject);
                  this.MV.setCompoundDrawablePadding(wja.dp2px(2.0F, BaseApplicationImpl.getContext().getResources()));
                  this.MV.setCompoundDrawables(xva.a().o(5), null, null, null);
                  this.MV.setOnClickListener(null);
                  this.MV.setText((CharSequence)localObject);
                  vU(true);
                  return;
                }
              } while (this.MV.getVisibility() != 0);
              vU(false);
              return;
              if ((!this.mSessionInfo.ber) || (!this.mSessionInfo.bet)) {
                break;
              }
              this.MV.setTextColor(-1);
              this.MV.setAlpha(0.8F);
              localObject = ((acff)this.mApp.getManager(51)).e(this.mSessionInfo.aTl);
              if ((localObject != null) && ((aqgv.aU(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || (!TextUtils.isEmpty(((Friends)localObject).strTermDesc))))
              {
                localObject = aqgv.d((Friends)localObject);
                this.MV.setCompoundDrawablePadding(wja.dp2px(2.0F, BaseApplicationImpl.getContext().getResources()));
                this.MV.setCompoundDrawables(yhv.a().r(5), null, null, null);
                this.MV.setText((CharSequence)localObject);
                vU(true);
                return;
              }
            } while (this.MV.getVisibility() != 0);
            vU(false);
            return;
            this.MV.setTextColor(-1);
            this.MV.setAlpha(0.8F);
            this.MV.setCompoundDrawables(null, null, null, null);
            this.MV.setOnClickListener(null);
            System.currentTimeMillis();
          } while ((!this.aSd) || ((this.a != null) && (this.a.sH(this.mSessionInfo.aTl))));
          localObject = (acff)this.mApp.getManager(51);
        } while (this.mSessionInfo.cZ == 1008);
        localObject = ((acff)localObject).e(this.mSessionInfo.aTl);
        if ((localObject == null) || ((aqgv.aU(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) == 0) && ((TextUtils.isEmpty(((Friends)localObject).strTermDesc)) || (!((Friends)localObject).strTermDesc.contains("TIM"))))) {
          break label593;
        }
        localObject = aqgv.d((Friends)localObject);
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (aqft.rj(this.mSessionInfo.aTl))) {
          break;
        }
        this.MV.setText((CharSequence)localObject);
        vU(true);
      } while (!AppSetting.enableTalkBack);
      this.MV.setContentDescription((CharSequence)localObject);
      return;
      vU(false);
      return;
    } while (this.MV.getVisibility() != 0);
    vU(false);
  }
  
  protected void cjI()
  {
    super.cjI();
  }
  
  protected void cqk()
  {
    super.cqk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zom
 * JD-Core Version:    0.7.0.1
 */
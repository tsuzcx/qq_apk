import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xxi
  implements View.OnClickListener
{
  xxi(xxh paramxxh) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (abhh)this.this$0.app.getManager(153);
    abmi localabmi = ((abhh)localObject).a();
    switch (paramView.getId())
    {
    default: 
    case 2131362774: 
    case 2131362773: 
    case 2131363769: 
    case 2131363768: 
    case 2131380844: 
    case 2131380538: 
    case 2131380890: 
    case 2131380606: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "1" });
        this.this$0.zJ(false);
        ((abhh)localObject).a().dc(this.this$0.oL(), 319);
        continue;
        this.this$0.zI(false);
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "1" });
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131693404, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
        }
        else
        {
          localabmi.Cf(this.this$0.sessionInfo.aTl);
          VipUtils.a(null, "cmshow", "Apollo", "addPlaymate", 0, 0, new String[] { "" });
          continue;
          if (!aqiw.isNetSupport(BaseApplication.getContext()))
          {
            QQToast.a(BaseApplication.getContext(), 2131693404, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
          }
          else
          {
            localabmi.Cg(this.this$0.sessionInfo.aTl);
            VipUtils.a(null, "cmshow", "Apollo", "acceptBtn", 0, 0, new String[] { "" });
            continue;
            if (!aqiw.isNetSupport(BaseApplication.getContext()))
            {
              QQToast.a(BaseApplication.getContext(), 2131693404, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
            }
            else
            {
              xxh.a(this.this$0, (int)(System.currentTimeMillis() / 1000L));
              localabmi.gF(xxh.a(this.this$0).gameId, xxh.a(this.this$0));
              xxh.a(this.this$0).setState(1);
              VipUtils.a(null, "cmshow", "Apollo", "moreGame", 0, 0, new String[] { xxh.a(this.this$0).gameId + "" });
              continue;
              if (!aqiw.isNetSupport(BaseApplication.getContext()))
              {
                QQToast.a(BaseApplication.getContext(), 2131693404, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
              }
              else
              {
                if ((this.this$0.app != null) && (this.this$0.sessionInfo != null))
                {
                  if (!abmk.gM(this.this$0.sessionInfo.aTl)) {
                    break label645;
                  }
                  this.this$0.f(xxh.a(this.this$0).gameId, xxh.a(this.this$0).roomId, xxh.a(this.this$0).re());
                }
                for (;;)
                {
                  xxh.a(this.this$0).dismiss();
                  VipUtils.a(null, "cmshow", "Apollo", "acceptInvitation", 0, 0, new String[] { xxh.a(this.this$0).gameId + "" });
                  break;
                  label645:
                  localabmi.c(true, this.this$0.sessionInfo.aTl, xxh.a(this.this$0).gameId, xxh.a(this.this$0).roomId);
                }
                if ((this.this$0.app != null) && (this.this$0.sessionInfo != null))
                {
                  localabmi.c(false, this.this$0.sessionInfo.aTl, xxh.a(this.this$0).gameId, xxh.a(this.this$0).roomId);
                  abmh.a(this.this$0.app, this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, xxh.a(this.this$0).gameId, xxh.a(this.this$0).roomId);
                }
                xxh.a(this.this$0).dismiss();
                VipUtils.a(null, "cmshow", "Apollo", "refuseInvitation", 0, 0, new String[] { xxh.a(this.this$0).gameId + "" });
                continue;
                xxh.a(this.this$0).dismiss();
                if (xxh.b(this.this$0) >= 2) {
                  this.this$0.cfN();
                }
              }
            }
          }
        }
      }
    }
    if (((acff)this.this$0.app.getManager(51)).isFriend(this.this$0.sessionInfo.aTl)) {
      localObject = new ProfileActivity.AllInOne(this.this$0.sessionInfo.aTl, 1);
    }
    for (((ProfileActivity.AllInOne)localObject).nickname = this.this$0.sessionInfo.aTn;; ((ProfileActivity.AllInOne)localObject).nickname = this.this$0.sessionInfo.aTn)
    {
      ((ProfileActivity.AllInOne)localObject).aOF = this.this$0.sessionInfo.aTl;
      ((ProfileActivity.AllInOne)localObject).bIX = this.this$0.sessionInfo.cZ;
      ((ProfileActivity.AllInOne)localObject).bIZ = 2;
      ((ProfileActivity.AllInOne)localObject).bJa = 106;
      ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject);
      VipUtils.a(null, "cmshow", "Apollo", "clickArea", 0, 0, new String[] { "" });
      break;
      localObject = new ProfileActivity.AllInOne(this.this$0.sessionInfo.aTl, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xxi
 * JD-Core Version:    0.7.0.1
 */
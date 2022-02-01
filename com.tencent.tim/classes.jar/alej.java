import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementPanelView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class alej
  implements alea.c
{
  public alej(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  public void ao(View paramView, int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "onClickAchivement position = " + paramInt);
    }
    paramView = this.a.b.a(paramInt);
    if (paramView != null)
    {
      if (paramView.type == 2)
      {
        alee.bM(LifeAchivementPanelView.c(this.a), this.a.bVZ);
        if (LifeAchivementPanelView.a(this.a)) {
          i = 1;
        }
        anot.a(null, "", "", "", "0X800AE59", "0X800AE59", i, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    if (paramView.type == 1)
    {
      alee.eM(LifeAchivementPanelView.d(this.a));
      anot.a(null, "", "", "", "0X800AE54", "0X800AE54", 2, 0, "", "", "", "");
      return;
    }
    alee.t(LifeAchivementPanelView.e(this.a), this.a.bVZ, paramView.id);
    if (LifeAchivementPanelView.a(this.a)) {
      i = 1;
    }
    anot.a(null, "", "", "", "0X800AE58", "0X800AE58", i, 0, "", "", "", "");
  }
  
  public void ap(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LifeAchivementPanelView", 2, "onClickPraise position = " + paramInt + ",isSelf = " + LifeAchivementPanelView.a(this.a) + ",isFriend = " + LifeAchivementPanelView.b(this.a));
    }
    alee.aC(paramView);
    if ((!LifeAchivementPanelView.a(this.a)) && (!LifeAchivementPanelView.b(this.a)))
    {
      QQToast.a(LifeAchivementPanelView.f(this.a), paramView.getResources().getString(2131701299), 0).show();
      return;
    }
    paramView = this.a.b.a(paramInt);
    if (paramView.hasPraised) {}
    for (int i = 2;; i = 1)
    {
      LifeAchivementPanelView.a(this.a, paramView, paramInt, i);
      if (this.a.a != null) {
        this.a.a.C(this.a.userUin, paramView.id, i);
      }
      if (LifeAchivementPanelView.a(this.a)) {}
      for (paramInt = 1;; paramInt = 2)
      {
        anot.a(null, "", "", "", "0X800AE56", "0X800AE56", paramInt, 0, "", "", "", "");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alej
 * JD-Core Version:    0.7.0.1
 */
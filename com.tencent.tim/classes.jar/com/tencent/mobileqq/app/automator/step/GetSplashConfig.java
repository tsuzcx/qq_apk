package com.tencent.mobileqq.app.automator.step;

import aevk;
import aevo;
import awml;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinConfigServlet;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.qphone.base.util.QLog;
import irz;
import java.util.Locale;
import vvu;

public class GetSplashConfig
  extends AsyncStep
{
  public int od()
  {
    Object localObject = this.a.app.a(this.a.app.getCurrentAccountUin(), true);
    if (QLog.isColorLevel()) {
      QLog.i("PushBannerConfig", 2, String.format(Locale.getDefault(), "GetSplashConfig config: %s", new Object[] { localObject }));
    }
    aevk.W(this.a.app, this.a.app.getCurrentAccountUin());
    aevo.W(this.a.app, this.a.app.getCurrentUin());
    ((irz)this.a.app.getManager(254)).UD = true;
    ShortVideoResourceManager.H(this.a.app, 1);
    aevk.ab(this.a.app, this.a.app.getCurrentAccountUin());
    aevk.ac(this.a.app, this.a.app.getCurrentAccountUin());
    localObject = (OlympicManager)this.a.app.getManager(167);
    OlympicServlet.g(this.a.app, ((OlympicManager)localObject).getVersion());
    AladdinConfigServlet.i(this.a.app, this.a.app.getCurrentUin());
    awml.a().eY(this.a.app);
    this.a.app.b().addObserver(new vvu());
    this.a.app.Jx(1);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSplashConfig
 * JD-Core Version:    0.7.0.1
 */
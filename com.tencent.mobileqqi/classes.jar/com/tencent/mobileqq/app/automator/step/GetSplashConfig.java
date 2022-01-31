package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;

public class GetSplashConfig
  extends AsyncStep
{
  protected int a()
  {
    this.a.a.b(this.a.a.a());
    ConfigServlet.a(this.a.a, this.a.a.a());
    ConfigServlet.b(this.a.a, this.a.a.a());
    ConfigServlet.a(this.a.a);
    ConfigServlet.c(this.a.a, this.a.a.a());
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSplashConfig
 * JD-Core Version:    0.7.0.1
 */
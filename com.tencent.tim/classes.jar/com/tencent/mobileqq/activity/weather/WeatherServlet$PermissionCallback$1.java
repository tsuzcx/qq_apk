package com.tencent.mobileqq.activity.weather;

import abcz.a;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.NewIntent;

public class WeatherServlet$PermissionCallback$1
  implements Runnable
{
  public WeatherServlet$PermissionCallback$1(abcz.a parama, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.putExtra("adcode", 0);
    this.val$app.startServlet(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.WeatherServlet.PermissionCallback.1
 * JD-Core Version:    0.7.0.1
 */
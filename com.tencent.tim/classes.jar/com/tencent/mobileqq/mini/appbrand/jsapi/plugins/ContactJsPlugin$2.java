package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import acfp;
import ausj;

class ContactJsPlugin$2
  implements Runnable
{
  ContactJsPlugin$2(ContactJsPlugin paramContactJsPlugin, String paramString1, String paramString2) {}
  
  public void run()
  {
    ausj localausj = ausj.b(this.this$0.jsPluginEngine.getActivityContext());
    localausj.addButton(acfp.m(2131704384), 7);
    localausj.addButton(acfp.m(2131704380), 7);
    localausj.a(new ContactJsPlugin.2.1(this, localausj));
    localausj.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ContactJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
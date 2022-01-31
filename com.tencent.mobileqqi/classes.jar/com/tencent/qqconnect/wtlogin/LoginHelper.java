package com.tencent.qqconnect.wtlogin;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import hul;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

public class LoginHelper
{
  protected static final String a = "LoginHelper";
  public LoginHelper.Callback a;
  private SSOAccountObserver a;
  
  public LoginHelper(Context paramContext, AppInterface paramAppInterface, LoginHelper.Callback paramCallback)
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new hul(this);
    this.jdField_a_of_type_ComTencentQqconnectWtloginLoginHelper$Callback = paramCallback;
    paramAppInterface.ssoGetTicketNoPasswd(paramAppInterface.getAccount(), 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.LoginHelper
 * JD-Core Version:    0.7.0.1
 */
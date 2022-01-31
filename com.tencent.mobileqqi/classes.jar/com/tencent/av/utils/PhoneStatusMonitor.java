package com.tencent.av.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import bma;
import bmb;

public class PhoneStatusMonitor
{
  static final String jdField_a_of_type_JavaLangString = "PhoneStatusMonitor";
  public Context a;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener;
  bma jdField_a_of_type_Bma;
  public PhoneStatusMonitor.PhoneStatusListener a;
  public boolean a;
  
  public PhoneStatusMonitor(Context paramContext, PhoneStatusMonitor.PhoneStatusListener paramPhoneStatusListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = paramPhoneStatusListener;
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = new bmb(this);
    this.jdField_a_of_type_Bma = new bma(this);
    PhoneStatusTools.a(paramContext, this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 32);
    paramPhoneStatusListener = new IntentFilter();
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE2");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_2");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_EXT");
    paramPhoneStatusListener.addAction("android.intent.action.NEW_OUTGOING_CALL");
    paramContext.registerReceiver(this.jdField_a_of_type_Bma, paramPhoneStatusListener);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void finalize()
  {
    PhoneStatusTools.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Bma);
    this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = null;
    this.jdField_a_of_type_Bma = null;
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor
 * JD-Core Version:    0.7.0.1
 */
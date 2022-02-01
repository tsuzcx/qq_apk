package com.tencent.token;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.PersistableBundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.IccOpenLogicalChannelResponse;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager.UssdResponseCallback;
import android.telephony.VisualVoicemailSmsFilterSettings;
import java.util.List;

public class akc
  extends ld
{
  private TelephonyManager a;
  
  public akc(Context paramContext, TelephonyManager paramTelephonyManager)
  {
    super(paramContext, paramTelephonyManager);
    this.a = paramTelephonyManager;
  }
  
  public boolean canChangeDtmfToneLength()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 23) {
      return this.a.canChangeDtmfToneLength();
    }
    return false;
  }
  
  public TelephonyManager createForPhoneAccountHandle(PhoneAccountHandle paramPhoneAccountHandle)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.createForPhoneAccountHandle(paramPhoneAccountHandle);
    }
    return null;
  }
  
  public TelephonyManager createForSubscriptionId(int paramInt)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.createForSubscriptionId(paramInt);
    }
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public List<CellInfo> getAllCellInfo()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 17) {
      return this.a.getAllCellInfo();
    }
    return null;
  }
  
  public int getCallState()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getCallState();
  }
  
  @SuppressLint({"MissingPermission"})
  public PersistableBundle getCarrierConfig()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getCarrierConfig();
    }
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public CellLocation getCellLocation()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getCellLocation();
  }
  
  public int getDataActivity()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getDataActivity();
  }
  
  @SuppressLint({"MissingPermission"})
  public int getDataNetworkType()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getDataNetworkType();
    }
    return 0;
  }
  
  public int getDataState()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getDataState();
  }
  
  @SuppressLint({"MissingPermission"})
  public String getDeviceId()
  {
    return akb.j();
  }
  
  @SuppressLint({"MissingPermission"})
  public String getDeviceId(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("getDeviceId,,,TelephonyManagerInvoke::doGetDeviceId, slotIndex:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    return akb.d(paramInt);
  }
  
  @SuppressLint({"MissingPermission"})
  public String getDeviceSoftwareVersion()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getDeviceSoftwareVersion();
  }
  
  @SuppressLint({"MissingPermission"})
  public String[] getForbiddenPlmns()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getForbiddenPlmns();
    }
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public String getGroupIdLevel1()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 18) {
      return this.a.getGroupIdLevel1();
    }
    return null;
  }
  
  public String getIccAuthentication(int paramInt1, int paramInt2, String paramString)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getIccAuthentication(paramInt1, paramInt2, paramString);
    }
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public String getImei()
  {
    return akb.k();
  }
  
  @SuppressLint({"MissingPermission"})
  public String getImei(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("getImei,,,TelephonyManagerInvoke::doGetImei, slotIndex:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    return akb.e(paramInt);
  }
  
  @SuppressLint({"MissingPermission"})
  public String getLine1Number()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getLine1Number();
  }
  
  @SuppressLint({"MissingPermission"})
  public String getMeid()
  {
    return akb.l();
  }
  
  @SuppressLint({"MissingPermission"})
  public String getMeid(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("getMeid,,,TelephonyManagerInvoke::doGetMeid, slotIndex:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    return akb.f(paramInt);
  }
  
  public String getMmsUAProfUrl()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 19) {
      return this.a.getMmsUAProfUrl();
    }
    return null;
  }
  
  public String getMmsUserAgent()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 19) {
      return this.a.getMmsUserAgent();
    }
    return null;
  }
  
  public String getNetworkCountryIso()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getNetworkCountryIso();
  }
  
  public String getNetworkOperator()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getNetworkOperator();
  }
  
  public String getNetworkOperatorName()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getNetworkOperatorName();
  }
  
  public String getNetworkSpecifier()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getNetworkSpecifier();
    }
    return null;
  }
  
  public int getNetworkType()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getNetworkType();
  }
  
  public int getPhoneCount()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 23) {
      return this.a.getPhoneCount();
    }
    return 0;
  }
  
  public int getPhoneType()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getPhoneType();
  }
  
  @SuppressLint({"MissingPermission"})
  public ServiceState getServiceState()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getServiceState();
    }
    return null;
  }
  
  public String getSimCountryIso()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getSimCountryIso();
  }
  
  public String getSimOperator()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getSimOperator();
  }
  
  public String getSimOperatorName()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getSimOperatorName();
  }
  
  @SuppressLint({"MissingPermission"})
  public String getSimSerialNumber()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getSimSerialNumber();
  }
  
  public int getSimState()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getSimState();
  }
  
  public int getSimState(int paramInt)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getSimState(paramInt);
    }
    return 0;
  }
  
  @SuppressLint({"MissingPermission"})
  public String getSubscriberId()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getSubscriberId();
  }
  
  @SuppressLint({"MissingPermission"})
  public String getVisualVoicemailPackageName()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getVisualVoicemailPackageName();
    }
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public String getVoiceMailAlphaTag()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getVoiceMailAlphaTag();
  }
  
  @SuppressLint({"MissingPermission"})
  public String getVoiceMailNumber()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.getVoiceMailNumber();
  }
  
  @SuppressLint({"MissingPermission"})
  public int getVoiceNetworkType()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getVoiceNetworkType();
    }
    return 0;
  }
  
  public Uri getVoicemailRingtoneUri(PhoneAccountHandle paramPhoneAccountHandle)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getVoicemailRingtoneUri(paramPhoneAccountHandle);
    }
    return null;
  }
  
  public boolean hasCarrierPrivileges()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 22) {
      return this.a.hasCarrierPrivileges();
    }
    return false;
  }
  
  public boolean hasIccCard()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.hasIccCard();
  }
  
  public boolean iccCloseLogicalChannel(int paramInt)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.iccCloseLogicalChannel(paramInt);
    }
    return false;
  }
  
  public byte[] iccExchangeSimIO(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.iccExchangeSimIO(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString);
    }
    return null;
  }
  
  public IccOpenLogicalChannelResponse iccOpenLogicalChannel(String paramString)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.iccOpenLogicalChannel(paramString);
    }
    return null;
  }
  
  public IccOpenLogicalChannelResponse iccOpenLogicalChannel(String paramString, int paramInt)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.iccOpenLogicalChannel(paramString, paramInt);
    }
    return null;
  }
  
  public String iccTransmitApduBasicChannel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.iccTransmitApduBasicChannel(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString);
    }
    return null;
  }
  
  public String iccTransmitApduLogicalChannel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.iccTransmitApduLogicalChannel(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramString);
    }
    return null;
  }
  
  public boolean isConcurrentVoiceAndDataSupported()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.isConcurrentVoiceAndDataSupported();
    }
    return false;
  }
  
  public boolean isDataEnabled()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.isDataEnabled();
    }
    return false;
  }
  
  public boolean isHearingAidCompatibilitySupported()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 23) {
      return this.a.isHearingAidCompatibilitySupported();
    }
    return false;
  }
  
  public boolean isNetworkRoaming()
  {
    akg.a("[API]TelephonyManager_");
    return this.a.isNetworkRoaming();
  }
  
  public boolean isSmsCapable()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.isSmsCapable();
    }
    return false;
  }
  
  public boolean isTtyModeSupported()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 23) {
      return this.a.isTtyModeSupported();
    }
    return false;
  }
  
  public boolean isVoiceCapable()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 22) {
      return this.a.isVoiceCapable();
    }
    return false;
  }
  
  public boolean isVoicemailVibrationEnabled(PhoneAccountHandle paramPhoneAccountHandle)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.isVoicemailVibrationEnabled(paramPhoneAccountHandle);
    }
    return false;
  }
  
  public boolean isWorldPhone()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 23) {
      return this.a.isWorldPhone();
    }
    return false;
  }
  
  public void listen(PhoneStateListener paramPhoneStateListener, int paramInt)
  {
    akg.a("[API]TelephonyManager_");
    this.a.listen(paramPhoneStateListener, paramInt);
  }
  
  public void sendDialerSpecialCode(String paramString)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.sendDialerSpecialCode(paramString);
    }
  }
  
  public String sendEnvelopeWithStatus(String paramString)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.sendEnvelopeWithStatus(paramString);
    }
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public void sendUssdRequest(String paramString, TelephonyManager.UssdResponseCallback paramUssdResponseCallback, Handler paramHandler)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.sendUssdRequest(paramString, paramUssdResponseCallback, paramHandler);
    }
  }
  
  public void sendVisualVoicemailSms(String paramString1, int paramInt, String paramString2, PendingIntent paramPendingIntent)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.sendVisualVoicemailSms(paramString1, paramInt, paramString2, paramPendingIntent);
    }
  }
  
  @SuppressLint({"MissingPermission"})
  public void setDataEnabled(boolean paramBoolean)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.setDataEnabled(paramBoolean);
    }
  }
  
  public boolean setLine1NumberForDisplay(String paramString1, String paramString2)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 22) {
      return this.a.setLine1NumberForDisplay(paramString1, paramString2);
    }
    return false;
  }
  
  public boolean setOperatorBrandOverride(String paramString)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 22) {
      return this.a.setOperatorBrandOverride(paramString);
    }
    return false;
  }
  
  public boolean setPreferredNetworkTypeToGlobal()
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 22) {
      return this.a.setPreferredNetworkTypeToGlobal();
    }
    return false;
  }
  
  public void setVisualVoicemailSmsFilterSettings(VisualVoicemailSmsFilterSettings paramVisualVoicemailSmsFilterSettings)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.setVisualVoicemailSmsFilterSettings(paramVisualVoicemailSmsFilterSettings);
    }
  }
  
  public boolean setVoiceMailNumber(String paramString1, String paramString2)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 22) {
      return this.a.setVoiceMailNumber(paramString1, paramString2);
    }
    return false;
  }
  
  public void setVoicemailRingtoneUri(PhoneAccountHandle paramPhoneAccountHandle, Uri paramUri)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.setVoicemailRingtoneUri(paramPhoneAccountHandle, paramUri);
    }
  }
  
  public void setVoicemailVibrationEnabled(PhoneAccountHandle paramPhoneAccountHandle, boolean paramBoolean)
  {
    akg.a("[API]TelephonyManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.setVoicemailVibrationEnabled(paramPhoneAccountHandle, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akc
 * JD-Core Version:    0.7.0.1
 */
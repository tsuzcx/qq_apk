package com.tencent.av.core;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.SoLoadUtil;

public class VcController
  implements IVcAudioData, IVcController
{
  public VcCapability a;
  VcControllerImpl a;
  
  public VcController(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, AbstractNetChannel paramAbstractNetChannel, IVideoEventListener paramIVideoEventListener, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramString1;
    long l;
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        str = "0";
      }
      l = Long.parseLong(str);
      if (!UpdateAvSo.a(paramContext)) {
        throw new UnsatisfiedLinkError();
      }
    }
    catch (NumberFormatException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    a(paramContext);
    ConfigInfo.instance().init(paramContext);
    try
    {
      this.a = new VcControllerImpl(this);
      this.a.init_deviceinfos(paramContext, paramInt1, paramInt2);
      this.a.setScreenSize(paramInt1, paramInt2);
      this.a.Initialize(paramContext, l, 1, paramString2, paramString3, paramString4, paramString5, VcSystemInfo.a(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, VcSystemInfo.c(), paramInt3);
      a(paramContext, Integer.parseInt(paramString2));
      a(paramAbstractNetChannel);
      a(paramIVideoEventListener);
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      throw new UnsatisfiedLinkError();
    }
  }
  
  static void a(Context paramContext)
  {
    try
    {
      SoLoadUtil.a(paramContext, "xplatform", 0, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          UpdateAvSo.a(paramContext, "VideoCtrl");
          return;
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          paramContext.printStackTrace();
        }
        localUnsatisfiedLinkError = localUnsatisfiedLinkError;
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  private void a(Context paramContext, int paramInt)
  {
    ClientLogReport.instance().init(paramContext, paramInt);
  }
  
  private void a(AbstractNetChannel paramAbstractNetChannel)
  {
    this.a.mNetChannel = paramAbstractNetChannel;
    this.a.mNetChannel.a(this);
  }
  
  private void a(IVideoEventListener paramIVideoEventListener)
  {
    this.a.mEventListener = paramIVideoEventListener;
  }
  
  public int a()
  {
    return this.a.getEncodeFrameFunctionPtrFunPtr();
  }
  
  public int a(int paramInt)
  {
    return this.a.SetAudioSpeakerVolume(paramInt);
  }
  
  public int a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.PauseVideo(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int a(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.Reject(l, paramInt);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.Accept(l, paramInt1, (int)paramLong, paramInt2, paramInt3);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, byte[] paramArrayOfByte)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "0";
    }
    paramString1 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString1 = "0";
    }
    paramString5 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      paramString5 = "0";
    }
    try
    {
      long l1 = Long.parseLong(str);
      long l2 = Long.parseLong(paramString1);
      long l3 = Long.parseLong(paramString5);
      return this.a.Request(l1, paramInt1, (int)paramLong, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramInt4, l2, l3, paramArrayOfByte);
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.SetAudioInputMute(l, paramBoolean);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int a(String paramString, byte[] paramArrayOfByte)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.onRecvVideoRequest(l, paramArrayOfByte, 0, 0);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    return this.a.AudioInData(paramArrayOfByte, paramInt);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    return 0;
  }
  
  public int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    return this.a.GetAudioDeviceParam(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public long a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.getTrafficSize(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1L;
  }
  
  public void a(int paramInt)
  {
    this.a.setProcessDecoderFrameFunctionptr(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.setCameraAngleFix(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      this.a.uploadSharpReport(paramInt1, paramInt2, l);
      return;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.a.SetNetIPAndPort(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setBackground(paramBoolean);
  }
  
  public boolean a()
  {
    return this.a.isEngineActive();
  }
  
  public boolean a(long paramLong)
  {
    return this.a.hasVShiftAbility(paramLong) != -1;
  }
  
  public int b()
  {
    return this.a.updateConfigInfo();
  }
  
  public int b(int paramInt)
  {
    return this.a.onApnChanged(paramInt);
  }
  
  public int b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.ResumeVideo(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int b(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.Ignore(l, paramInt);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int b(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.SetAudioOutputMute(l, paramBoolean);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int b(byte[] paramArrayOfByte, int paramInt)
  {
    return this.a.AudioOutData(paramArrayOfByte, paramInt);
  }
  
  public boolean b()
  {
    return this.a.ismSharpFlag();
  }
  
  public int c()
  {
    return this.a.onLogOutByKicked();
  }
  
  public int c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.UpdateSelfUIN(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int c(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.Close(l, paramInt);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int c(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.notifyAnotherSelfIsRing(l, paramBoolean);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int d(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      int i = this.a.switchAudio(l);
      if (i == -1) {
        this.a.mfAudio2VideoFlag = false;
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int e(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.switchVideo(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int f(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.switchVideoConfirm(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  protected void finalize()
  {
    if (this.a != null) {
      this.a.Uninitialize();
    }
    super.finalize();
  }
  
  public int g(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.switchVideoCancel(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int h(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.getPeerTerminalType(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int i(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = Long.parseLong(paramString);
      return this.a.getPeerSharpVersion(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.core.VcController
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.magicface.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.ActionCountdownOver;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionProcess;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfacebackText;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.magicface.model.RecordVolume;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView.MagicfaceGestureListener;
import com.tencent.mobileqq.statistics.ReportController;
import gex;
import gey;
import gez;
import gfa;
import java.util.List;
import mqq.app.AppRuntime;

public class MagicfaceActionManager
  implements ActionGlobalData.ActionCountdownOver, MagicfaceContainerView.MagicfaceGestureListener
{
  private static final float jdField_a_of_type_Float = 9.81F;
  public static final int a = 0;
  public static final String a = "sendSound";
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 1.4F, 1.5F, 1.6F, 1.7F, 1.8F, 1.9F, 2.0F, 2.1F, 2.2F, 2.3F };
  private static final int[] jdField_a_of_type_ArrayOfInt = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
  public static final int b = 1;
  public static final String b = "receiveSound";
  public static final String c = "send.xml";
  public static final String d = "receive.xml";
  public static final String e = "MagicfaceActionManager";
  private long jdField_a_of_type_Long;
  private ChatActivity jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
  private ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener = new gez(this);
  private Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  private Action jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction;
  private ActionGlobalData jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = null;
  private MagicfaceActionDecoder jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder;
  private MagicfaceResLoader jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader;
  private RecordVolume jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume = new RecordVolume(new gfa(this));
  private MagicfaceActionManager.MagicfaceActionListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener;
  private MagicfaceActionManager.MagicfaceCloseListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener;
  private MagicfaceActionManager.MagicfaceSensorOperation jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceSensorOperation = new gex(this);
  private MagicfaceActionManager.MagicfaceTextUpdateListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener;
  private MagicfacePlayManager jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager;
  private SoundPoolUtil jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
  private List jdField_a_of_type_JavaUtilList;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = false;
  public int c;
  private volatile boolean c;
  private String f;
  private int j = 0;
  
  public MagicfaceActionManager(ChatActivity paramChatActivity)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity = paramChatActivity;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder = new MagicfaceActionDecoder();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = new SoundPoolUtil();
  }
  
  public static ActionGlobalData a(Emoticon paramEmoticon, int paramInt)
  {
    MagicfaceResLoader localMagicfaceResLoader = new MagicfaceResLoader(EmosmUtils.getMagicfaceFolderPath(paramEmoticon.epId, paramEmoticon.eId));
    paramEmoticon = null;
    if (paramInt == 0) {
      paramEmoticon = localMagicfaceResLoader.a("send.xml");
    }
    for (;;)
    {
      return new MagicfaceActionDecoder().a(paramEmoticon);
      if (paramInt == 1) {
        paramEmoticon = localMagicfaceResLoader.a("receive.xml");
      }
    }
  }
  
  private void a(ActionGlobalData paramActionGlobalData)
  {
    c(paramActionGlobalData);
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener.a(paramActionGlobalData);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.a(paramActionGlobalData.j);
      if (this.jdField_c_of_type_Int == 1)
      {
        if (paramActionGlobalData.l == null) {
          break label118;
        }
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.b(paramActionGlobalData.l.replace("%param%", "" + paramActionGlobalData.b));
      }
    }
    for (;;)
    {
      if ((paramActionGlobalData != null) && (paramActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText != null))
      {
        paramActionGlobalData.a(this);
        paramActionGlobalData.a();
      }
      return;
      label118:
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.b("");
    }
  }
  
  private void b(ActionGlobalData paramActionGlobalData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramActionGlobalData != null) {
      d(paramActionGlobalData);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener.b(paramActionGlobalData);
    }
  }
  
  private void c(ActionGlobalData paramActionGlobalData)
  {
    if ("mic".equalsIgnoreCase(paramActionGlobalData.h)) {
      ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume);
    }
    do
    {
      return;
      if ("gravity".equalsIgnoreCase(paramActionGlobalData.h))
      {
        paramActionGlobalData = (SensorManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSystemService("sensor");
        paramActionGlobalData.registerListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener, paramActionGlobalData.getDefaultSensor(1), 0);
        return;
      }
    } while (!"touch".equalsIgnoreCase(paramActionGlobalData.h));
  }
  
  private void d(ActionGlobalData paramActionGlobalData)
  {
    if ("mic".equalsIgnoreCase(paramActionGlobalData.h)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume.a();
    }
    while (!"gravity".equalsIgnoreCase(paramActionGlobalData.h)) {
      return;
    }
    ((SensorManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = new MagicfaceResLoader(EmosmUtils.getMagicfaceFolderPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId));
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue != null)
    {
      String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue.split("&");
      if ((arrayOfString.length >= 0) && (arrayOfString[0].contains("value")))
      {
        arrayOfString = arrayOfString[0].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.b = Integer.parseInt(arrayOfString[1]);
        }
      }
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText != null)) {
      return this.j;
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.a();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.b();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.k != null))
    {
      this.j = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.b;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(this.j, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float));
    }
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramEmoticon;
    this.jdField_c_of_type_Int = paramInt;
    this.f = paramString;
    new Thread(new gey(this, paramInt)).start();
  }
  
  public void a(MagicfaceActionManager.MagicfaceActionListener paramMagicfaceActionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener = paramMagicfaceActionListener;
  }
  
  public void a(MagicfaceActionManager.MagicfaceCloseListener paramMagicfaceCloseListener)
  {
    if (paramMagicfaceCloseListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener = paramMagicfaceCloseListener;
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.a(null);
    }
  }
  
  public void a(MagicfaceActionManager.MagicfaceTextUpdateListener paramMagicfaceTextUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener = paramMagicfaceTextUpdateListener;
  }
  
  public void a(MagicfacePlayManager paramMagicfacePlayManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager = paramMagicfacePlayManager;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getAppRuntime().getPreferences().edit().putBoolean("sendSound", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.c(paramInt, this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceSensorOperation);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction == null) {}
    do
    {
      do
      {
        ActionProcess localActionProcess;
        do
        {
          return;
          localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.a;
        } while ((localActionProcess == null) || (!"gravity".equalsIgnoreCase(localActionProcess.d)));
        if (!"record".equalsIgnoreCase(localActionProcess.c)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener == null);
      this.j = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.b;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.k);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(1, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getAppRuntime().getPreferences().edit().putBoolean("receiveSound", paramBoolean).commit();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getAppRuntime().getPreferences().getBoolean("sendSound", false);
  }
  
  public void c()
  {
    a(null);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_c_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getAppRuntime().getPreferences().getBoolean("receiveSound", false);
  }
  
  public void d()
  {
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, this.jdField_c_of_type_Int, this.f);
  }
  
  public void e()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = null;
    }
    if ((this.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long > 0L)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, "CliOper", "", "", "MbFasong", "MbZhizuoShichang", 0, 0, String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager
 * JD-Core Version:    0.7.0.1
 */
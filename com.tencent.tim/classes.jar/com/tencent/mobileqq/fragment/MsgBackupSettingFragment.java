package com.tencent.mobileqq.fragment;

import aajt;
import acfp;
import ahni;
import ahnj;
import ahnk;
import ahnl;
import ahnm;
import ajds;
import ajdu;
import ajee;
import ajek;
import ajeo;
import ajer;
import ajet;
import ajev;
import ajez;
import ajgr;
import ajgv;
import alkz;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import aqhq;
import arhz;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.a;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import rop;

public class MsgBackupSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static ajer a;
  public static String bLa;
  public static int dai;
  private ajds jdField_a_of_type_Ajds;
  private ajdu jdField_a_of_type_Ajdu = new ahnl(this);
  private ajeo jdField_a_of_type_Ajeo;
  private ajet jdField_a_of_type_Ajet;
  private ajev jdField_a_of_type_Ajev;
  private MsgBackupEndPoint jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint;
  MsgBackupJniProxy jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy;
  private String aFc = acfp.m(2131708487);
  private MsgBackupEndPoint b;
  private String bKY;
  private String bKZ = acfp.m(2131708504);
  private int bizType;
  private int dah;
  private final int daj = 0;
  private final int dak = 1;
  private final int dal = 2;
  private final int dam = 3;
  private String[] fj;
  private arhz g;
  private String mFilePath;
  private MqqHandler mUIHandler;
  private String mUin;
  private int mUinType;
  long session;
  private String sig;
  private MqqHandler t;
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    this.mUin = paramString1;
    this.mUinType = paramInt1;
    this.mFilePath = paramString2;
    this.mUIHandler.obtainMessage(0).sendToTarget();
    if (paramBoolean)
    {
      paramString1 = this.t.obtainMessage(2);
      paramString1.arg1 = paramInt2;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return;
    }
    this.mUIHandler.sendEmptyMessage(3);
  }
  
  private void aQ(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      xq(acfp.m(2131708508));
      return;
    }
    ath();
  }
  
  private void bo(Object paramObject)
  {
    if ((paramObject instanceof ajet))
    {
      paramObject = (ajet)paramObject;
      this.bizType = paramObject.Gi();
      this.sig = paramObject.xn();
      QLog.d("MsgBackup", 1, "onProcessPush0x11b confirmQrRsp = " + paramObject);
      ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.8(this));
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    QLog.d("MsgBackup", 1, "onProcessPush0x11b data = " + paramObject);
  }
  
  private void doO()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.6(this));
  }
  
  private void doQ()
  {
    if (TextUtils.isEmpty(this.mFilePath)) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = new File(this.mFilePath).listFiles();
    } while ((arrayOfFile == null) || (arrayOfFile.length <= 0));
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfFile[i].getAbsolutePath();
      int k = this.mUinType;
      String str2 = this.mUin;
      Intent localIntent = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("uin", str2);
      localIntent.putExtra("uintype", k);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      new SendPhotoTask(getActivity(), localIntent, null).run();
      i += 1;
    }
    this.mUIHandler.sendEmptyMessageDelayed(1, 0L);
  }
  
  private void eN(String paramString, int paramInt)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    int m;
    int j;
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    int k;
    int n;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = new File(paramString).listFiles(new ahnm(this));
        } while ((localObject1 == null) || (localObject1.length <= 0));
        localObject2 = localObject1[0];
        localObject1 = BitmapFactory.decodeFile(((File)localObject2).getAbsolutePath());
        m = ((Bitmap)localObject1).getWidth();
        j = ((Bitmap)localObject1).getHeight();
      } while (localObject1 == null);
      localBitmap = Bitmap.createBitmap(m, j, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setColor(-16777216);
      k = j / 4;
      localPaint.setTextSize(k);
      localCanvas.save();
      localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
      localCanvas.restore();
      m /= 2;
      n = j / 2;
      localObject2 = ((File)localObject2).getName().split("\\.");
    } while ((localObject2 == null) || (localObject2.length < 1));
    Object localObject2 = localObject2[0];
    for (;;)
    {
      if (i < paramInt)
      {
        n = localCanvas.save();
        localCanvas.drawText(String.valueOf(i), m, j - k, localPaint);
        String str = paramString + File.separator + (String)localObject2 + "_" + i;
        File localFile = new File(str);
        if (!localFile.exists()) {}
        try
        {
          localFile.createNewFile();
        }
        catch (IOException localIOException)
        {
          try
          {
            for (;;)
            {
              rop.d(localBitmap, str);
              localCanvas.restoreToCount(n);
              i += 1;
              break;
              localIOException = localIOException;
              localIOException.printStackTrace();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
    localBitmap.recycle();
    ((Bitmap)localObject1).recycle();
    this.t.sendEmptyMessage(3);
  }
  
  private void f(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  private void loadSo()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.5(this));
  }
  
  public String[] N()
  {
    String[] arrayOfString = new String[2];
    Object localObject = (WifiManager)getActivity().getApplicationContext().getSystemService("wifi");
    if (localObject != null)
    {
      localObject = alkz.a((WifiManager)localObject);
      arrayOfString[0] = ((WifiInfo)localObject).getSSID();
      arrayOfString[1] = ((WifiInfo)localObject).getBSSID();
    }
    return arrayOfString;
  }
  
  public void ai(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2: 
      eN((String)paramMessage.obj, paramMessage.arg1);
      return;
    }
    doQ();
  }
  
  public void ath()
  {
    try
    {
      if ((this.g != null) && (this.g.isShowing())) {
        this.g.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("IphoneTitleBarFragment", 2, localException.toString());
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Ajds = ((ajds)getActivity().app.getBusinessHandler(162));
    getActivity().app.addObserver(this.jdField_a_of_type_Ajdu);
    this.vg.setRightButton(acfp.m(2131708506));
    this.vg.setLeftButton(acfp.m(2131708507));
    ((Button)this.mContentView.findViewById(2131370773)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131377166)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131365221)).setOnClickListener(this);
    this.mContentView.findViewById(2131377093).setOnClickListener(this);
    this.mContentView.findViewById(2131375374).setOnClickListener(this);
    this.mContentView.findViewById(2131379984).setOnClickListener(this);
    this.mContentView.findViewById(2131366588).setOnClickListener(this);
    this.mContentView.findViewById(2131374648).setOnClickListener(this);
    this.mContentView.findViewById(2131365583).setOnClickListener(this);
    this.mContentView.findViewById(2131364653).setOnClickListener(this);
    this.mContentView.findViewById(2131364650).setOnClickListener(this);
    this.mContentView.findViewById(2131365457).setOnClickListener(this);
    this.mContentView.findViewById(2131378699).setOnClickListener(this);
    this.mContentView.findViewById(2131365222).setOnClickListener(this);
    this.mContentView.findViewById(2131365226).setOnClickListener(this);
    this.mContentView.findViewById(2131368683).setOnClickListener(this);
    this.mContentView.findViewById(2131366454).setOnClickListener(this);
    this.mContentView.findViewById(2131378032).setOnClickListener(this);
    this.mContentView.findViewById(2131377165).setOnClickListener(this);
    this.mContentView.findViewById(2131377164).setOnClickListener(this);
    this.mContentView.findViewById(2131381370).setOnClickListener(this);
    this.mContentView.findViewById(2131381369).setOnClickListener(this);
    this.mContentView.findViewById(2131378033).setOnClickListener(this);
    this.mContentView.findViewById(2131372003).setOnClickListener(this);
    this.mContentView.findViewById(2131372021).setOnClickListener(this);
    this.mContentView.findViewById(2131381366).setOnClickListener(this);
    paramLayoutInflater = (TextView)this.mContentView.findViewById(2131378032);
    paramViewGroup = (TextView)this.mContentView.findViewById(2131378033);
    ((EditText)this.mContentView.findViewById(2131369290)).addTextChangedListener(new ahni(this, paramLayoutInflater, paramViewGroup));
    paramLayoutInflater.setText(String.format(this.aFc, new Object[] { "10000" }));
    paramViewGroup.setText(String.format(this.bKZ, new Object[] { "1000" }));
    paramViewGroup = PreferenceManager.getDefaultGlobalPreference(getActivity());
    paramBundle = paramViewGroup.getString("msgbackup_uin", "");
    String str1 = paramViewGroup.getString("msgbackup_picfilepath", "");
    String str2 = paramViewGroup.getString("msgbackup_inputcount", "");
    String str3 = paramViewGroup.getString("msgbackup_isNeedGeneratedStr", "");
    if (!TextUtils.isEmpty(paramBundle))
    {
      int i = paramViewGroup.getInt("msgbackup_uintype", 0);
      ((EditText)this.mContentView.findViewById(2131366589)).setText(paramBundle);
      ((EditText)this.mContentView.findViewById(2131366590)).setText(String.valueOf(i));
      ((EditText)this.mContentView.findViewById(2131367066)).setText(str1);
      ((EditText)this.mContentView.findViewById(2131369290)).setText(str2);
      ((EditText)this.mContentView.findViewById(2131369377)).setText(str3);
    }
    paramLayoutInflater.requestFocus();
    this.fj = N();
    this.mUIHandler = new MqqHandler(Looper.getMainLooper(), new ahnj(this));
    this.t = new MqqHandler(ThreadManager.getSubThreadLooper(), new ahnk(this));
  }
  
  public void doP()
  {
    String str1 = getActivity().app.getCurrentUin();
    String str2 = str1 + ".db";
    str1 = getActivity().getDatabasePath(str2).getAbsolutePath();
    str2 = ajgr.ROOT_PATH + "test/" + str2;
    ajgv.b("qqdb copy fromPath = %s,toPath = %s,result = %b", str1, new Object[] { str2, Boolean.valueOf(aqhq.copyFile(str1, str2)) });
  }
  
  protected int getContentLayoutId()
  {
    return 2131561686;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    Object localObject1 = ((EditText)this.mContentView.findViewById(2131366589)).getText().toString();
    Object localObject5 = ((EditText)this.mContentView.findViewById(2131366590)).getText().toString();
    Object localObject3 = ((EditText)this.mContentView.findViewById(2131369290)).getText().toString();
    Object localObject2 = ((EditText)this.mContentView.findViewById(2131367066)).getText().toString();
    Object localObject4 = ((EditText)this.mContentView.findViewById(2131369377)).getText().toString();
    boolean bool;
    int j;
    int i;
    if ("1".equals(localObject4))
    {
      bool = true;
      j = 0;
      i = 0;
    }
    try
    {
      k = Integer.parseInt((String)localObject5);
      j = k;
    }
    catch (Exception localException1)
    {
      int k;
      label139:
      label149:
      label166:
      ArrayList localArrayList;
      break label139;
    }
    try
    {
      k = Integer.parseInt((String)localObject3);
      i = k;
    }
    catch (Exception localException2)
    {
      break label149;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = bLa;
      j = dai;
      localObject3 = ajee.a();
      localObject4 = (ajds)getActivity().app.getBusinessHandler(162);
      localObject5 = new MsgBackupUserData.a();
      localArrayList = new ArrayList(2);
      switch (m)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      bLa = (String)localObject1;
      dai = j;
      localObject5 = PreferenceManager.getDefaultGlobalPreference(getActivity());
      ((SharedPreferences)localObject5).edit().putString("msgbackup_uin", (String)localObject1).apply();
      ((SharedPreferences)localObject5).edit().putInt("msgbackup_uintype", j).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_picfilepath", (String)localObject2).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_inputcount", (String)localObject3).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_isNeedGeneratedStr", (String)localObject4).apply();
      break label166;
      loadSo();
      continue;
      if ((this.b != null) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null))
      {
        QQToast.a(getActivity(), -1, acfp.m(2131708505), 1).show();
        ((MsgBackupUserData.a)localObject5).c(this.fj[1]);
        ((MsgBackupUserData.a)localObject5).b(this.fj[0]);
        ((MsgBackupUserData.a)localObject5).a(ajgv.ez(this.b.ipv4));
        localArrayList.add(Integer.valueOf(this.b.port));
        localArrayList.add(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
        ((MsgBackupUserData.a)localObject5).a(localArrayList);
        ((MsgBackupUserData.a)localObject5).a(9);
        ((ajds)localObject4).a(((MsgBackupUserData.a)localObject5).b(), 3, false);
        continue;
        if ((this.b != null) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null))
        {
          QQToast.a(getActivity(), -1, acfp.m(2131708502), 1).show();
          if (jdField_a_of_type_Ajer != null)
          {
            ((MsgBackupUserData.a)localObject5).c(this.fj[1]);
            ((MsgBackupUserData.a)localObject5).b(this.fj[0]);
            ((MsgBackupUserData.a)localObject5).a(ajgv.ez(this.b.ipv4));
            localArrayList.add(Integer.valueOf(this.b.port));
            localArrayList.add(Integer.valueOf(this.b.port));
            ((MsgBackupUserData.a)localObject5).a(localArrayList);
            ((MsgBackupUserData.a)localObject5).a(9);
            ((ajds)localObject4).a(((MsgBackupUserData.a)localObject5).b(), jdField_a_of_type_Ajer.xm(), 3);
          }
          else
          {
            QLog.d("MsgBackup", 1, "case confirmQR qrResponse is null!");
            continue;
            if (jdField_a_of_type_Ajer != null)
            {
              ((ajds)localObject4).fj(jdField_a_of_type_Ajer.xm(), 3);
            }
            else
            {
              QLog.d("MsgBackup", 1, "case rejectQR qrResponse is null!");
              continue;
              if (jdField_a_of_type_Ajer != null)
              {
                ((ajds)localObject4).Mq(jdField_a_of_type_Ajer.xm());
              }
              else
              {
                QLog.d("MsgBackup", 1, "case queryQRState qrResponse is null!");
                continue;
                if (this.jdField_a_of_type_Ajeo != null)
                {
                  ((ajds)localObject4).Mo(this.jdField_a_of_type_Ajeo.getToken());
                }
                else
                {
                  QLog.d("MsgBackup", 1, "case tokenConfirm qrConfirmReponse is null!");
                  continue;
                  ((ajee)localObject3).bi.clear();
                  getActivity().app.a().a();
                  localObject1 = aajt.makeKey((String)localObject1, j);
                  localObject1 = aajt.a().a((String)localObject1);
                  if (localObject1 != null)
                  {
                    ((ajee)localObject3).bi.add(localObject1);
                    localObject1 = new ajek();
                    ((ajek)localObject1).bj = ajee.a().bi;
                    ((ajek)localObject1).dir = 0;
                    ((ajee)localObject3).d((ajek)localObject1);
                  }
                  else
                  {
                    QLog.d("MsgBackup", 1, "test export submit,recentBaseData is null");
                    continue;
                    ajee.a().f(null);
                    continue;
                    localObject2 = new SessionInfo();
                    ((SessionInfo)localObject2).aTl = ((String)localObject1);
                    ((SessionInfo)localObject2).cZ = j;
                    if (i > 0) {}
                    for (;;)
                    {
                      ThreadManager.newFreeThread(new MsgBackupSettingFragment.4(this, i, (SessionInfo)localObject2), "msgbackup_testSendMsg", 1).start();
                      break;
                      i = 0;
                    }
                    a((String)localObject1, j, (String)localObject2, i, bool);
                    continue;
                    f((String)localObject1, j, (String)localObject2, i);
                    continue;
                    getActivity().app.b().N((String)localObject1, j);
                    continue;
                    ((ajee)localObject3).dwB();
                    continue;
                    doP();
                    continue;
                    doO();
                    continue;
                    bo(this.jdField_a_of_type_Ajet);
                    continue;
                    bo(this.jdField_a_of_type_Ajet);
                    continue;
                    QQToast.a(getActivity(), -1, acfp.m(2131708501), 1).show();
                    continue;
                    localObject1 = MsgBackupJniProxy.encryptFromString("i am a hero!!!", "1111111111111111");
                    ajgv.b("MsgBackup", acfp.m(2131708509), new Object[] { "i am a hero!!!", localObject1 });
                    localObject2 = MsgBackupJniProxy.decryptFromString((String)localObject1, "1111111111111111");
                    ajgv.b("MsgBackup", acfp.m(2131708493), new Object[] { localObject1, localObject2 });
                    localObject2 = new byte[12];
                    Object tmp1352_1350 = localObject2;
                    tmp1352_1350[0] = 73;
                    Object tmp1358_1352 = tmp1352_1350;
                    tmp1358_1352[1] = 32;
                    Object tmp1364_1358 = tmp1358_1352;
                    tmp1364_1358[2] = 65;
                    Object tmp1370_1364 = tmp1364_1358;
                    tmp1370_1364[3] = 77;
                    Object tmp1376_1370 = tmp1370_1364;
                    tmp1376_1370[4] = 32;
                    Object tmp1382_1376 = tmp1376_1370;
                    tmp1382_1376[5] = 65;
                    Object tmp1388_1382 = tmp1382_1376;
                    tmp1388_1382[6] = 32;
                    Object tmp1395_1388 = tmp1388_1382;
                    tmp1395_1388[7] = 72;
                    Object tmp1402_1395 = tmp1395_1388;
                    tmp1402_1395[8] = 69;
                    Object tmp1409_1402 = tmp1402_1395;
                    tmp1409_1402[9] = 82;
                    Object tmp1416_1409 = tmp1409_1402;
                    tmp1416_1409[10] = 79;
                    Object tmp1423_1416 = tmp1416_1409;
                    tmp1423_1416[11] = 33;
                    tmp1423_1416;
                    localObject1 = MsgBackupJniProxy.encryptFromByteArray((byte[])localObject2, "1111111111111111");
                    ajgv.b("MsgBackup", acfp.m(2131708495), new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(localObject1.length) });
                    localObject2 = MsgBackupJniProxy.decryptFromByteArray((byte[])localObject1, "1111111111111111");
                    ajgv.b("MsgBackup", acfp.m(2131708480), new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(localObject2.length) });
                    continue;
                    this.jdField_a_of_type_Ajds.dwr();
                    continue;
                    if (!TextUtils.isEmpty(ajee.bQR))
                    {
                      this.jdField_a_of_type_Ajds.Mp(ajee.bQR);
                      continue;
                      this.bKY = Uri.encode("111111111111111111");
                      ajgv.b("IphoneTitleBarFragment", "编码之后的value = %s", new Object[] { this.bKY });
                      continue;
                      if (this.bKY != null)
                      {
                        ajgv.b("IphoneTitleBarFragment", "解码之后的value = %s", new Object[] { Uri.decode(this.bKY) });
                        continue;
                        ajez.dr(getActivity().app);
                        continue;
                        if (i > 0) {}
                        for (;;)
                        {
                          localObject2 = ajez.a(null, i, (String)localObject1, j, getActivity().app.getCurrentUin());
                          if (((List)localObject2).size() > 0) {
                            ajez.h(getActivity().app, (List)localObject2);
                          }
                          localObject1 = MessageRecord.getTableName((String)localObject1, j);
                          i = getActivity().app.b().a((String)localObject1, 0L, 9223372036854775807L, false);
                          ((TextView)getActivity().findViewById(2131372020)).setText("result:msgSize =  " + i);
                          break;
                          i = 0;
                        }
                        loadSo();
                        localObject1 = ajgv.b("http://10.71.161.35:8001/4EFF91728050FE643749C167C73EBCDA6CD8EE193B8636D01B445730BB8A31EE1374186F5611658FD9217AB6FF9BC857DE9D9A8DFA5CFF3C8E063D3B2FA3BB0B1B0EDC7D8B162F850C0A375A45E4CE3B70846A812C626CB5ED09EB107556EECB765BCF39A41BACA755747BE723749A26655D46D004D3DBA34C374CA622B8B0F3E3B2F0E582BA37B4", ajgv.dB("10.71.161.35"), 8001, "'U}MXig2f9zi:$?_");
                        QLog.e("MsgBackupSettingFragment", 1, "RESULT = " + (String)localObject1);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (getActivity() != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Ajdu);
    }
    super.onDestroy();
  }
  
  public void xq(String paramString)
  {
    try
    {
      if (this.g == null) {
        this.g = new arhz(getActivity(), getActivity().getTitleBarHeight());
      }
      this.g.setMessage(paramString);
      this.g.setBackAndSearchFilter(false);
      this.g.show();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("IphoneTitleBarFragment", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment
 * JD-Core Version:    0.7.0.1
 */
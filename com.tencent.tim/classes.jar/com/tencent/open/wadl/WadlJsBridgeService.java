package com.tencent.open.wadl;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import asbt;
import awok;
import awol;
import cooperation.wadl.ipc.WadlParams;
import mqq.app.AppService;

public class WadlJsBridgeService
  extends AppService
{
  private static String TAG = "WadlJsBridgeService";
  private awol jdField_a_of_type_Awol;
  private a jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeService$a;
  private Looper looper;
  
  public WadlJsBridgeService()
  {
    asbt.i(TAG, "##@WadlJsBridgeService()");
  }
  
  private int fG(String paramString)
  {
    awok.eEF();
    asbt.i(TAG, "##@doWadlJob = " + paramString);
    if ("start".equals(paramString)) {
      return 0;
    }
    if ("complete".equals(paramString)) {
      return 1;
    }
    if ("open".equals(paramString)) {
      return 2;
    }
    if ("restart".equals(paramString)) {
      return 4;
    }
    if ("pause".equals(paramString)) {
      return 5;
    }
    return -1;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    asbt.i(TAG, "wadlJsBridgeService onCreate()");
    HandlerThread localHandlerThread = new HandlerThread("WadlJsBridgeService.Thread", 10);
    localHandlerThread.start();
    this.looper = localHandlerThread.getLooper();
    this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeService$a = new a(this.looper);
    if (this.jdField_a_of_type_Awol == null)
    {
      this.jdField_a_of_type_Awol = new awol();
      asbt.i(TAG, "##@MessageService-->onCreate():" + this.jdField_a_of_type_Awol + "," + this.app);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Awol != null) {
      this.jdField_a_of_type_Awol.destroy();
    }
    asbt.i(TAG, "Service is Destroyed");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    asbt.i(TAG, "##@Service is Started():onStartCommand: ," + paramInt1 + "," + paramInt2 + ":" + paramIntent);
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("ACTIONNAME");
      paramIntent = paramIntent.getStringExtra("appid");
      asbt.i(TAG, "##@ACTIONNAME = " + str + "," + paramIntent);
      Message localMessage = this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeService$a.obtainMessage();
      localMessage.what = fG(str);
      localMessage.obj = paramIntent;
      this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeService$a.sendMessage(localMessage);
    }
    return 2;
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      String str = (String)paramMessage.obj;
      asbt.i(WadlJsBridgeService.TAG, "The obj field of msg:" + paramMessage.what + "," + paramMessage.obj);
      switch (paramMessage.what)
      {
      case 2: 
      case 3: 
      default: 
      case 0: 
      case 4: 
        for (;;)
        {
          WadlJsBridgeService.this.stopSelf(paramMessage.arg1);
          return;
          awok.a().eF(4, str);
        }
      case 5: 
        awok.a().eE(4, str);
        return;
      }
      paramMessage = new WadlParams(str, "");
      paramMessage.from = 4;
      paramMessage.sourceId = "biz_src_zf_games";
      awok.a().c(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeService
 * JD-Core Version:    0.7.0.1
 */
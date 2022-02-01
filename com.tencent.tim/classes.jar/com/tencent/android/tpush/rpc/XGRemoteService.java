package com.tencent.android.tpush.rpc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.service.b;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.SERVICESCHECK})
public class XGRemoteService
  extends Service
{
  private a.a a = new d();
  
  public IBinder onBind(Intent paramIntent)
  {
    b.b(getApplicationContext());
    return this.a;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.rpc.XGRemoteService
 * JD-Core Version:    0.7.0.1
 */
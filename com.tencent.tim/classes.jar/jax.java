import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.8.1;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.AutoCheckVideoRunnable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class jax
  extends iid
{
  public jax(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    super.b(paramLong1, paramLong2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onGroupSecurityLimit-->groupid=" + paramLong1 + " info=" + paramLong2 + " strMsg=" + paramString);
    }
    if (this.this$0.aqx != 1) {}
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 33);
      localIntent.putExtra("relationId", paramLong1);
      localIntent.putExtra("uinType", this.this$0.mUinType);
      localIntent.putExtra("info", paramLong2);
      localIntent.putExtra("strMsg", paramString);
      localIntent.putExtra("from", "MultiVideoCtrlLayerUI4NewGroupChat1");
      paramString = (AVActivity)this.this$0.mContext.get();
      if (paramString != null)
      {
        localIntent.setPackage(this.this$0.mApp.getApplication().getPackageName());
        paramString.sendBroadcast(localIntent);
        MultiVideoCtrlLayerUI4NewGroupChat.b(this.this$0, true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.this$0.TAG, 2, "onGroupSecurityLimit-->can not get the activity");
  }
  
  protected void c(int paramInt, byte[] paramArrayOfByte)
  {
    if (MultiVideoCtrlLayerUI4NewGroupChat.a(this.this$0))
    {
      this.this$0.ath();
      if (paramInt == 0) {
        this.this$0.g(0L, null);
      }
      while ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
        return;
      }
      paramArrayOfByte = new String(paramArrayOfByte);
      String str = this.this$0.a().getString(2131721737);
      aqha.a(this.this$0.a(), 230, null, paramArrayOfByte, null, str, new jay(this), null).show();
      return;
    }
    paramArrayOfByte = this.this$0.a().getResources().getString(2131697877);
    QQToast.a(this.this$0.a(), -1, paramArrayOfByte, 0).show();
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.c(paramLong1, paramLong2, paramBoolean);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QO = true;
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().anb == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.d(this.this$0);
    }
  }
  
  protected void c(long paramLong, boolean paramBoolean, int paramInt)
  {
    this.this$0.O(0L, 65535);
  }
  
  protected void d(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.d(paramLong1, paramLong2, paramBoolean);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().QO = false;
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().anb == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.c(this.this$0);
    }
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().PY) {}
  }
  
  protected void l(long paramLong, int paramInt1, int paramInt2)
  {
    this.this$0.v(paramLong, paramInt1, paramInt2);
  }
  
  protected void y(long paramLong1, long paramLong2)
  {
    int j = 3;
    if (this.this$0.isDestroyed()) {
      return;
    }
    if (paramLong2 != this.this$0.md)
    {
      QLog.i(this.this$0.TAG, 1, "onCreateRoomSuc, not right session. [" + paramLong2 + "," + this.this$0.md + "]");
      return;
    }
    Object localObject = this.this$0.jdField_a_of_type_ComTencentAvVideoController.b();
    QLog.w(this.this$0.TAG, 1, "onCreateRoomSuc, GroupID[" + paramLong2 + "], seq[" + paramLong1 + "], sessionId[" + ((iiv)localObject).sessionId + "]");
    if (this.this$0.isVideo) {}
    for (int i = 4;; i = 3)
    {
      jfq.aj(i, this.this$0.jdField_a_of_type_ComTencentAvVideoController.bw() + "");
      i = j;
      if (this.this$0.isVideo) {
        i = 4;
      }
      anon.aj(i, this.this$0.jdField_a_of_type_ComTencentAvVideoController.bw() + "");
      this.this$0.atn();
      this.this$0.dq(paramLong1);
      this.this$0.jdField_a_of_type_Jkz.lj(true);
      this.this$0.jdField_a_of_type_Jkz.li(true);
      this.this$0.jdField_a_of_type_Jkz.onConnected();
      ((iiv)localObject).QX = true;
      this.this$0.mApp.ak(this.this$0.md);
      if (((iiv)localObject).any != 4) {
        break;
      }
      localObject = (AVActivity)this.this$0.mContext.get();
      if ((localObject == null) || (((AVActivity)localObject).isFinishing())) {
        break;
      }
      ((AVActivity)localObject).runOnUiThread(new MultiVideoCtrlLayerUI4NewGroupChat.8.1(this, paramLong1));
      return;
    }
  }
  
  protected void z(long paramLong1, long paramLong2)
  {
    int j = 4;
    if (this.this$0.isDestroyed()) {
      return;
    }
    QLog.w(this.this$0.TAG, 1, "onEnterRoomSuc, GroupID[" + paramLong2 + "], seq[" + paramLong1 + "]");
    if (this.this$0.isVideo)
    {
      i = 4;
      jfq.aj(i, this.this$0.jdField_a_of_type_ComTencentAvVideoController.bw() + "");
      if (!this.this$0.isVideo) {
        break label260;
      }
    }
    label260:
    for (int i = j;; i = 3)
    {
      anon.aj(i, this.this$0.jdField_a_of_type_ComTencentAvVideoController.bw() + "");
      this.this$0.atn();
      this.this$0.dq(paramLong1);
      this.this$0.jdField_a_of_type_Jkz.lj(true);
      this.this$0.jdField_a_of_type_Jkz.li(true);
      this.this$0.jdField_a_of_type_Jkz.onConnected();
      this.this$0.mApp.getHandler().postDelayed(new MultiVideoCtrlLayerUI4NewGroupChat.AutoCheckVideoRunnable(this.this$0), 500L);
      MultiVideoCtrlLayerUI4NewGroupChat.b(this.this$0);
      this.this$0.O(paramLong1, 65535);
      this.this$0.asB();
      return;
      i = 3;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jax
 * JD-Core Version:    0.7.0.1
 */
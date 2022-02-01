import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable.a;
import com.tencent.av.ui.BaseInviteFloatBarUICtr.2;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.MobileQQ;

public abstract class ixs
{
  public static int avs = 6000;
  String OD = null;
  String OE = null;
  public final String TAG = getClass().getSimpleName() + "_" + AudioHelper.hG();
  boolean VL = false;
  BaseGaInvite.GetGaFaceRunnable.a jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$a = new ixt(this);
  BaseGaInvite.GetGaFaceRunnable jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
  public jet a;
  int aqx = 0;
  Runnable bJ = new BaseInviteFloatBarUICtr.2(this);
  Bitmap bu = null;
  public iiv e = null;
  public VideoAppInterface mApp = null;
  long mGroupId = 0L;
  public String mPeerUin = null;
  public int mUinType = 0;
  long mf = 0L;
  long[] o = null;
  
  void asb()
  {
    if (this.bJ != null)
    {
      this.mApp.getHandler().removeCallbacks(this.bJ);
      this.bJ = null;
    }
  }
  
  public abstract void asc();
  
  public void jn(String paramString)
  {
    String str = String.valueOf(this.mGroupId);
    if (this.jdField_a_of_type_Jet != null) {}
    for (TextView localTextView = this.jdField_a_of_type_Jet.o();; localTextView = null)
    {
      this.OE = BaseGaInvite.a(this.mApp, localTextView, this.mUinType, this.aqx, str, this.o);
      this.bu = this.mApp.a(this.mUinType, str, null, true, false);
      if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable == null) {
        this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = new BaseGaInvite.GetGaFaceRunnable(this.TAG, this.mApp, this.mUinType, this.aqx, this.mGroupId, this.mf, this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$a);
      }
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.jo(paramString);
      return;
    }
  }
  
  void jw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "refreshUI, isMultiCall[" + jjc.co(this.mUinType) + "], multiIncomingCall[" + paramBoolean + "], mUinType[" + this.mUinType + "], mIsAudioMode[" + this.VL + "]");
    }
    String str = this.mPeerUin;
    int j = this.mUinType;
    if (jjc.co(this.mUinType)) {
      jn("refreshUI");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Jet == null)
      {
        this.jdField_a_of_type_Jet = new jet(this.mApp.getApp().getApplicationContext());
        this.jdField_a_of_type_Jet.a(this.bu, this.OE);
        localObject = new Date();
        localObject = new SimpleDateFormat("HH:mm").format((Date)localObject);
        this.jdField_a_of_type_Jet.setTimeStamp((String)localObject);
        this.jdField_a_of_type_Jet.i(this.VL, jjc.co(this.mUinType), paramBoolean);
        if (jjc.co(this.mUinType)) {
          this.mApp.getHandler().postDelayed(this.bJ, avs);
        }
      }
      Object localObject = (Vibrator)this.mApp.getApplication().getSystemService("vibrator");
      if (localObject != null) {
        ((Vibrator)localObject).vibrate(200L);
      }
      return;
      int i = j;
      localObject = str;
      if (this.e != null)
      {
        i = j;
        localObject = str;
        if (this.e.bindType == 1)
        {
          i = j;
          localObject = str;
          if (this.mUinType == 9500)
          {
            i = j;
            localObject = str;
            if (!TextUtils.isEmpty(this.e.MX))
            {
              localObject = this.e.MX;
              i = 0;
            }
          }
        }
      }
      this.bu = this.mApp.a(i, (String)localObject, this.OD, true, true);
      this.OE = this.mApp.getDisplayName(i, (String)localObject, this.OD);
      if ((this.mUinType == 25) && (this.OE.equals(this.mPeerUin)))
      {
        if (this.e != null) {
          this.OE = this.e.gK();
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 2, "refreshUI mPeerName = " + this.OE);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.d(this.TAG, 1, "onDestroy");
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable != null) {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.cancel();
    }
    if (this.jdField_a_of_type_Jet != null)
    {
      this.jdField_a_of_type_Jet.hide();
      this.jdField_a_of_type_Jet = null;
    }
    asb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixs
 * JD-Core Version:    0.7.0.1
 */
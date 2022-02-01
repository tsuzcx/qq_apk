import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.util.Arrays;

class alvu
  extends alvq.a
{
  alvu(alvs paramalvs) {}
  
  public void K(int paramInt, Bundle paramBundle)
    throws RemoteException
  {
    alvr.d("PTV.RichmediaClient", "sendRequest. cmd = " + paramInt + ",data = " + paramBundle);
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              return;
              paramBundle = (BinderWarpper)paramBundle.getParcelable("binder_presendService");
              if (paramBundle != null)
              {
                localObject = PresendPicMgr.a();
                if (localObject != null) {
                  ((PresendPicMgr)localObject).release();
                }
                paramBundle = PresendPicMgr.b(akxc.a.a(paramBundle.binder));
                alvr.d("PTV.RichmediaClient", "ICALLBACK_CMD_INIT_PRESEND_PIC_MGR  presendMgr = " + paramBundle);
                return;
              }
              alvr.d("PTV.RichmediaClient", "ICALLBACK_CMD_INIT_PRESEND_PIC_MGR  failed, bw is null ! ");
              return;
              localObject = paramBundle.getString("key_presend_path");
              paramInt = paramBundle.getInt("entrance", 0);
              paramBundle = PresendPicMgr.a();
            } while ((localObject == null) || (paramBundle == null));
            paramBundle.ay((String)localObject, 1052, paramInt);
            return;
            localObject = paramBundle.getString("key_presend_path");
            paramInt = paramBundle.getInt("key_presend_cancel_type");
            paramBundle = PresendPicMgr.a();
          } while ((localObject == null) || (paramBundle == null));
          paramBundle.fx((String)localObject, paramInt);
          return;
          paramInt = paramBundle.getInt("key_presend_cancel_type");
          paramBundle = PresendPicMgr.a();
        } while (paramBundle == null);
        paramBundle.IP(paramInt);
        paramBundle.release();
        return;
        paramBundle = paramBundle.getIntArray("key_compress_config");
      } while ((paramBundle == null) || (paramBundle.length < 9));
      akyl.dqc = paramBundle[0];
      akyl.dqd = paramBundle[1];
      akyl.dqe = paramBundle[2];
      akyl.dqf = paramBundle[3];
      akyl.dqg = paramBundle[4];
      akyl.dqh = paramBundle[5];
      akyl.dpY = paramBundle[6];
      akyl.dpZ = paramBundle[7];
      akyl.dqa = paramBundle[8];
    } while (!QLog.isColorLevel());
    QLog.d("PTV.RichmediaClient", 2, "ICALLBACK_CMD_INIT_COMPRESS_CONFIG, compressConfig = " + Arrays.toString(paramBundle));
  }
  
  public Bundle b(int paramInt, Bundle paramBundle)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    PresendPicMgr localPresendPicMgr;
    if (paramInt == 16)
    {
      alvr.d("PTV.RichmediaClient", "ICallBack.Stub() getData start. ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER");
      localPresendPicMgr = PresendPicMgr.a();
      Object localObject = null;
      if ((localPresendPicMgr != null) && (localPresendPicMgr.cvf)) {
        break label113;
      }
      paramBundle = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("PTV.RichmediaClient", 2, "ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER failed, presendMgr is null or disable preCompress,presendMgr = " + localPresendPicMgr);
        paramBundle = localObject;
      }
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        localBundle.putParcelable("key_presend_mgr_handler", new BinderWarpper(paramBundle));
        localBundle.putInt("PhotoConst.PHOTO_COUNT", localPresendPicMgr.Hj());
      }
      return localBundle;
      label113:
      paramBundle = new Messenger(localPresendPicMgr.a).getBinder();
      alvr.d("PTV.RichmediaClient", "ICallBack.Stub() getData. ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER , b = " + paramBundle);
    }
  }
  
  public void e(CompressInfo paramCompressInfo)
    throws RemoteException
  {
    alvr.d("PTV.RichmediaClient", "ICallBack.Stub() compress start. info.src = " + paramCompressInfo.srcPath + ",uuid = " + paramCompressInfo.localUUID);
    akyj.b(paramCompressInfo);
    alvr.d("PTV.RichmediaClient", "ICallBack.Stub() compress finish. info = " + paramCompressInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvu
 * JD-Core Version:    0.7.0.1
 */
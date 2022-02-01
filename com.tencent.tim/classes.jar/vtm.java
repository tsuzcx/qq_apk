import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SendMultiPictureHelper.7;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class vtm
{
  DialogInterface.OnClickListener A = new vtq(this);
  DialogInterface.OnClickListener B = new vtr(this);
  protected vtm.a a;
  public String aPS;
  protected String aPT;
  public String aPU;
  INetEventHandler b = null;
  protected boolean bam;
  protected boolean ban;
  public boolean bao;
  public aghq c = new vto(this);
  private aook g = new vtn(this);
  public BaseActivity mActivity;
  public QQAppInterface mApp;
  public int mCurrentIndex;
  public aqju mDialog;
  protected Bundle mExtra;
  protected boolean mPause;
  public int mTotalSize;
  public int mType;
  public String mUin;
  public ArrayList<vtm.a> pz;
  List<FileManagerEntity> rd = null;
  DialogInterface.OnClickListener z = new vtp(this);
  
  public vtm(BaseActivity paramBaseActivity)
  {
    this.mActivity = paramBaseActivity;
    this.mApp = ((QQAppInterface)this.mActivity.getAppRuntime());
    this.aPU = this.mActivity.getString(2131719520);
  }
  
  private long a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (aqhq.fileExists(paramString1))
    {
      if ((paramInt != 1) && (paramInt != 0) && (paramInt != 1001) && (paramInt != 10002) && (paramInt != 3000)) {
        break label192;
      }
      aqhu.a(-1L, paramInt, true, "compress_start", "SendMultiPictureHelper.doSendPictues");
      String str = aqhu.b(this.mActivity, paramString1, paramInt);
      ImageInfo localImageInfo = new ImageInfo();
      aqhu.a(4, this.mActivity, paramString1, str, true, localImageInfo, paramInt);
      paramString1 = localImageInfo.filePath;
    }
    label192:
    for (;;)
    {
      long l1;
      if (!aqhu.b(null, paramString1, 1, null, "SendMultiPictureHelper.doSendPictues")) {
        l1 = 0L;
      }
      long l2;
      do
      {
        return l1;
        l2 = a(paramString1, paramString2, paramString3, paramInt);
        b(paramInt, paramString3, paramString1, l2, 1009);
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.d("streamptt", 2, "ChatActivity.handleForwardData uploadImage,uniseq:" + l2 + ",filePath:" + paramString1 + ",curType:" + paramInt);
      return l2;
      return 0L;
    }
  }
  
  private long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    long l = 0L;
    if (paramString1 != null)
    {
      paramString2 = anbi.a(this.mApp, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = akxq.xP();
      paramString2.md5 = aqhs.bytes2HexStr(MD5.getFileMd5(paramString2.path));
      paramString2.serial();
      this.mApp.b().b(paramString2, this.mApp.getCurrentAccountUin());
      l = paramString2.uniseq;
    }
    return l;
  }
  
  private void b(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    aool localaool = new aool();
    localaool.mSelfUin = this.mApp.getAccount();
    localaool.mPeerUin = paramString1;
    localaool.mUinType = paramInt1;
    localaool.mFileType = 1;
    localaool.mUniseq = paramLong;
    localaool.cNy = true;
    localaool.mBusiType = paramInt2;
    localaool.dQ = paramString2;
    this.mApp.a().a(localaool);
  }
  
  private void cancel()
  {
    if (this.a.uniseq == -1L) {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "uniseq -1");
      }
    }
    do
    {
      do
      {
        return;
        aojn localaojn = (aojn)this.mApp.a().a(this.mUin + this.a.uniseq);
        if (localaojn == null) {
          break;
        }
        localaojn.stop();
        this.mApp.a().oy(this.mUin + this.a.uniseq);
      } while (!QLog.isColorLevel());
      QLog.d("SendMultiPictureHelper", 2, "stop send " + this.mUin + this.a.uniseq);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("SendMultiPictureHelper", 2, "processor null");
  }
  
  private void e(int paramInt, String paramString, long paramLong)
  {
    paramString = this.mApp.a().a(paramString + paramLong);
    if ((paramString instanceof aojn)) {
      ((aojn)paramString).pause();
    }
  }
  
  private void pause() {}
  
  private void resume()
  {
    aojn localaojn = (aojn)this.mApp.a().a(this.mUin + this.a.uniseq);
    if (localaojn != null)
    {
      if (this.ban)
      {
        this.ban = false;
        QLog.w("SendMultiPictureHelper", 2, this.mUin + this.a.uniseq + "has error");
        localaojn.stop();
        bVo();
      }
      for (;;)
      {
        QLog.w("SendMultiPictureHelper", 2, "continue send " + this.mUin + this.a.uniseq);
        return;
        localaojn.EN();
      }
    }
    QLog.w("SendMultiPictureHelper", 2, "processor null");
    if (this.ban) {
      bVo();
    }
    this.ban = false;
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle, ArrayList<String> paramArrayList)
  {
    this.mUin = paramString2;
    this.aPS = paramString1;
    this.mType = paramInt;
    this.aPT = paramString3;
    this.mExtra = paramBundle;
    this.mApp.a().a(this.g);
    this.g.addFilter(new Class[] { aojs.class, aojv.class, aokv.class, aokp.class });
    this.mDialog = aqha.a(this.mActivity, 230, this.aPT, this.mActivity.getString(2131691984), null, this.z);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.mDialog.setCancelable(false);
    this.mDialog.show();
    this.pz = new ArrayList();
    paramString1 = paramArrayList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramString3 = new vtm.a();
      paramString3.path = paramString2;
      paramString3.uniseq = -1L;
      this.pz.add(paramString3);
    }
    paramString1 = ((vtm.a)this.pz.get(0)).path;
    this.mTotalSize = this.pz.size();
    this.a = ((vtm.a)this.pz.get(0));
    this.mCurrentIndex = 0;
    if (!aqiw.isNetSupport(this.mActivity))
    {
      this.bao = true;
      this.mApp.a().deleteObserver(this.c);
      paramInt = 0;
      while (paramInt < this.pz.size())
      {
        this.mDialog.setMessage(String.format(this.aPU, new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(this.mTotalSize), Integer.valueOf(0) }));
        a((vtm.a)this.pz.get(paramInt), this.mType, this.aPS, this.mUin);
        paramInt += 1;
      }
      bKx();
      return;
    }
    this.mDialog.setMessage(String.format(this.aPU, new Object[] { Integer.valueOf(1), Integer.valueOf(this.mTotalSize), Integer.valueOf(0) }));
    if (new File(paramString1).length() == 0L)
    {
      if (this.mType != 0) {
        break label521;
      }
      Toast.makeText(BaseApplicationImpl.getApplication(), this.mActivity.getString(2131693659), 0).show();
    }
    for (;;)
    {
      a((vtm.a)this.pz.get(0), this.mType, this.aPS, this.mUin);
      if (this.b == null) {
        this.b = new vts(this);
      }
      AppNetConnInfo.registerNetChangeReceiver(this.mActivity, this.b);
      return;
      label521:
      Toast.makeText(BaseApplicationImpl.getApplication(), this.mActivity.getString(2131696961), 0).show();
    }
  }
  
  public void a(vtm.a parama, int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new SendMultiPictureHelper.7(this, parama, paramInt, paramString1, paramString2));
  }
  
  public void bKx()
  {
    Intent localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtras(this.mExtra);
    this.mActivity.startActivity(localIntent);
    this.mActivity.setResult(-1);
    this.mActivity.finish();
  }
  
  void bVo()
  {
    for (;;)
    {
      synchronized (this.pz)
      {
        if (this.pz.size() > 0) {
          this.pz.remove(0);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SendMultiPictureHelper", 2, "sendNext " + (this.mCurrentIndex + 1));
        }
        this.mCurrentIndex += 1;
        if (this.pz.size() <= 0) {
          break label261;
        }
        vtm.a locala = (vtm.a)this.pz.get(0);
        Object localObject2 = locala.path;
        this.a = locala;
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists())
        {
          this.ban = true;
          Toast.makeText(BaseApplicationImpl.getApplication(), ((File)localObject2).getName() + acfp.m(2131714300), 0).show();
          if (!this.mPause) {
            bVo();
          }
          return;
        }
        if (((File)localObject2).length() == 0L)
        {
          if (this.mType == 0) {
            Toast.makeText(BaseApplicationImpl.getApplication(), this.mActivity.getString(2131693659), 0).show();
          }
        }
        else
        {
          a(locala, this.mType, this.aPS, this.mUin);
          return;
        }
      }
      Toast.makeText(BaseApplicationImpl.getApplication(), this.mActivity.getString(2131696961), 0).show();
      continue;
      label261:
      if (this.mDialog != null) {
        this.mDialog.cancel();
      }
      bKx();
    }
  }
  
  public void destory()
  {
    this.mApp.a().b(this.g);
    this.mApp.a().deleteObserver(this.c);
    try
    {
      this.mDialog.dismiss();
      label35:
      this.mDialog = null;
      if (this.b != null) {
        AppNetConnInfo.unregisterNetEventHandler(this.b);
      }
      if (this.pz != null) {
        this.pz.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  void ii()
  {
    Object localObject = this.mActivity.getString(2131691986);
    localObject = aqha.a(this.mActivity, 230, this.mActivity.getString(2131721103), (String)localObject, 2131694366, 2131696322, this.B, this.A);
    ((aqju)localObject).setCancelable(false);
    ((aqju)localObject).show();
  }
  
  public class a
  {
    public String path;
    public volatile long uniseq;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vtm
 * JD-Core Version:    0.7.0.1
 */
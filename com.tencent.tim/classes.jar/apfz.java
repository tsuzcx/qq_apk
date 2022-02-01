import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class apfz
  implements apfs, apft.a, apfx.b
{
  private long Yw;
  private apfr jdField_a_of_type_Apfr;
  private smq.q jdField_a_of_type_Smq$q = new apga(this);
  private long art = 0L;
  private String bHx;
  private String bHz;
  private boolean bkn = true;
  protected long bz;
  private TroopFileProtoReqMgr.b c;
  private boolean cQn;
  private int cXl = 102;
  private String coH;
  private String coI;
  private String coJ;
  private String coK;
  private String coy;
  private UUID d;
  private int dUa;
  private int dUb;
  private int dUc;
  private byte[] gt;
  private byte[] gu;
  private byte[] gv;
  private List<apfx.c> mListeners = new LinkedList();
  private int mStatus = 0;
  private long mTroopUin;
  
  public apfz(UUID paramUUID, long paramLong, String paramString1, String paramString2)
  {
    this.d = paramUUID;
    this.coy = this.d.toString();
    this.mTroopUin = paramLong;
    this.bHx = paramString1;
    this.bHz = paramString2;
  }
  
  private void RC(boolean paramBoolean)
  {
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] onUploadSuc. bHit:" + paramBoolean);
    WE(5);
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((apfx.c)localIterator.next()).a(this.d, true, 0, this);
    }
  }
  
  private void WE(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  private void WG(int paramInt)
  {
    apef.b.e("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] onUploadErr ResultCode:" + paramInt);
    this.bkn = true;
    WE(6);
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((apfx.c)localIterator.next()).a(this.d, false, paramInt, this);
    }
  }
  
  private void dZn()
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] reqUploadFile app=null");
      this.cQn = true;
      WG(apue.a.dWt);
      return;
    }
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] reqUploadFile");
    this.c = smq.a(localQQAppInterface, this.mTroopUin, this.bHx, this.bHz, this.Yw, this.gt, this.gu, this.cXl, "", null, this.jdField_a_of_type_Smq$q);
    WE(2);
  }
  
  public String Bh()
  {
    return this.coH;
  }
  
  public String Bi()
  {
    return agoy.t(this.gt);
  }
  
  public String Bj()
  {
    return agoy.t(this.gu);
  }
  
  public void IC(String paramString)
  {
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] onChangeUrl:" + paramString);
  }
  
  public int Lp()
  {
    return this.cXl;
  }
  
  protected void RE(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] startUpload app=null");
      this.cQn = true;
      WG(apue.a.dWt);
      return;
    }
    if (this.jdField_a_of_type_Apfr != null)
    {
      this.jdField_a_of_type_Apfr.bme();
      this.jdField_a_of_type_Apfr.a(null);
    }
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] startUpload firstIP=" + this.coI);
    String str1 = HexUtil.bytes2HexStr(this.gv);
    String str2 = HexUtil.bytes2HexStr(this.gu);
    long l = apef.hr();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.coI);
    if ((!paramBoolean) && (!TextUtils.isEmpty(this.coJ)))
    {
      if (!agke.a().l(localQQAppInterface, 3)) {
        break label486;
      }
      QLog.i("TroopFileUploadSimpleWorker", 1, "[" + this.coy + "] [IPv6-File] upload troopfile. is config enable IPv6. domain[" + this.coJ + "]");
      Object localObject = new agke.a(this.coJ, 0);
      localObject = agke.a().a(localQQAppInterface, (agke.a)localObject, 3);
      if ((localObject == null) || (((agke.c)localObject).alz())) {
        break label437;
      }
      if (agke.alt())
      {
        QLog.d("TroopFileUploadSimpleWorker", 1, "[" + this.coy + "] [IPv6-File] upload troopfile. debugIsDisableIPv4OnDoubleStack");
        localArrayList.clear();
      }
      agke.a(((agke.c)localObject).Bb, localArrayList, true, false);
      QLog.i("TroopFileUploadSimpleWorker", 1, "[" + this.coy + "] [IPv6-File] upload troopfile. use IPv6. iplist:" + localArrayList.toString());
    }
    for (;;)
    {
      paramBoolean = apsv.bR(localQQAppInterface);
      this.jdField_a_of_type_Apfr = apge.a(localQQAppInterface, l, this.bHz, str1, str2, localArrayList, "/ftn_handler", paramBoolean, this.coJ);
      if (this.jdField_a_of_type_Apfr != null) {
        break;
      }
      this.cQn = true;
      WG(apue.a.dWt);
      return;
      label437:
      QLog.i("TroopFileUploadSimpleWorker", 1, "[" + this.coy + "] [IPv6-File] upload troopfile. use IPv4:");
      localArrayList.add(this.coJ);
      continue;
      label486:
      localArrayList.add(this.coJ);
    }
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] startUpload. nSessionId:" + l + " firstIP=" + this.coI);
    this.jdField_a_of_type_Apfr.a(this);
    this.jdField_a_of_type_Apfr.ame();
    WE(3);
  }
  
  public UUID a()
  {
    return this.d;
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Bundle paramBundle, int paramInt)
  {
    if (this.art != paramLong1) {
      return;
    }
    if (this.bkn)
    {
      apef.b.w("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] onFileScanResult. but had stop");
      return;
    }
    if (paramInt != 0)
    {
      this.cQn = true;
      int i = apue.a.dWi;
      if (paramInt == -2) {
        i = apue.a.dWp;
      }
      for (;;)
      {
        apef.b.e("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] onFileScanResult. errCode:" + paramInt);
        WG(i);
        return;
        if (paramInt == -1) {
          i = apue.a.dWd;
        } else if (paramInt == -4) {
          i = apue.a.dWb;
        } else if (paramInt == -3) {
          i = apue.a.dWg;
        }
      }
    }
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      apef.b.e("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] onFileScanResult. md5 or sha is null");
      this.cQn = true;
      WG(apue.a.dWi);
      return;
    }
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] onFileScanResult. errCode:" + paramInt);
    if ((paramLong2 != 0L) && (this.Yw == 0L)) {
      this.Yw = paramLong2;
    }
    this.gt = paramArrayOfByte1;
    this.gu = paramArrayOfByte2;
    if (paramBundle != null)
    {
      this.dUa = paramBundle.getInt("_with_", 0);
      this.dUb = paramBundle.getInt("_height_", 0);
      this.dUc = paramBundle.getInt("_duration_", 0);
    }
    dZn();
  }
  
  public void a(apfx.c paramc)
  {
    this.mListeners.add(paramc);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.bkn) {}
    while (!paramBoolean) {
      return;
    }
    apef.b.e("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] onHasErr. upload fail. errCode:" + paramInt + " transferedSize:" + paramLong + " rspHeader:" + paramString2 + " errMsg:" + paramString1);
    this.cQn = true;
    WG(paramInt);
  }
  
  public boolean aAY()
  {
    return this.cQn;
  }
  
  public void aK(long paramLong1, long paramLong2)
  {
    if (this.art != paramLong1) {}
    while ((paramLong2 == 0L) || (this.Yw != 0L)) {
      return;
    }
    this.Yw = paramLong2;
  }
  
  public void c(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.bkn) {}
    while (!paramBoolean) {
      return;
    }
    this.cQn = true;
    WG(apue.a.dWs);
  }
  
  public void dYV()
  {
    WE(7);
  }
  
  public void dgA()
  {
    if (this.bkn) {
      return;
    }
    RC(false);
  }
  
  public void dgB()
  {
    if (this.bkn) {
      return;
    }
    this.cQn = true;
    apef.b.e("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] onOutDate. upload fail");
    WG(206);
  }
  
  public void dgC()
  {
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] onRetrySend");
  }
  
  public void dgz()
  {
    if (this.bkn) {
      return;
    }
    RC(true);
  }
  
  public String getFilePath()
  {
    return this.bHz;
  }
  
  public long getFileSize()
  {
    return this.Yw;
  }
  
  public int getImgHeight()
  {
    return this.dUb;
  }
  
  public int getImgWidth()
  {
    return this.dUa;
  }
  
  public int getVideoDuration()
  {
    return this.dUc;
  }
  
  public long hs()
  {
    return this.mTroopUin;
  }
  
  public void jm(long paramLong)
  {
    if (this.bkn) {}
    while (paramLong <= this.bz) {
      return;
    }
    this.bz = paramLong;
  }
  
  protected void scanFile()
  {
    this.art = apft.a().a(this.bHz, this, null);
    if (this.art == 0L)
    {
      this.cQn = true;
      apef.b.e("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] scanFile. startScan failed");
      WG(apue.a.dWt);
      return;
    }
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] scanFile. cookie:" + this.art);
    WE(1);
  }
  
  public boolean start()
  {
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] start filepath:" + this.bHz);
    if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
    {
      apef.b.e("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] no network");
      WE(6);
      return false;
    }
    this.bkn = false;
    scanFile();
    return true;
  }
  
  public void stop(int paramInt)
  {
    if (this.bkn)
    {
      apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] stop. but had stoped. mStatus:" + this.mStatus);
      return;
    }
    this.bkn = true;
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] stop. mStatus:" + this.mStatus + " reason:" + paramInt);
    if (this.mStatus == 1) {
      if (this.art != 0L)
      {
        apft.a().lM(this.art);
        this.art = 0L;
      }
    }
    for (;;)
    {
      if (this.c != null)
      {
        smq.a(apef.getApp(), this.c);
        this.c = null;
      }
      WE(0);
      return;
      if (this.mStatus == 3) {
        if (this.jdField_a_of_type_Apfr == null)
        {
          apef.b.w("TroopFileUploadSimpleWorker", apef.b.USR, "[" + this.coy + "] stop upload. uploader=null");
        }
        else
        {
          this.jdField_a_of_type_Apfr.bme();
          this.jdField_a_of_type_Apfr = null;
        }
      }
    }
  }
  
  public void y(long paramLong1, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfz
 * JD-Core Version:    0.7.0.1
 */
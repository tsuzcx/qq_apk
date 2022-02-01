import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afkv
  implements aolm.b
{
  private afkt jdField_a_of_type_Afkt = new afkt();
  private afkx jdField_a_of_type_Afkx = new afkx();
  protected List<String> zQ = new ArrayList(3);
  
  public static String B(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ux());
    switch (paramInt)
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
      localStringBuilder.append("sysface_res/gif");
      continue;
      localStringBuilder.append("sysface_res/static");
      continue;
      localStringBuilder.append("emoji_res");
    }
  }
  
  public static final afkv a()
  {
    return afkv.b.b();
  }
  
  public static String uw()
  {
    StringBuilder localStringBuilder = new StringBuilder(acbn.SDCARD_PATH);
    localStringBuilder.append("emoji");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("res");
    localStringBuilder.append(File.separator);
    return aqul.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String ux()
  {
    try
    {
      Object localObject = new File(BaseApplicationImpl.getApplication().getFilesDir(), "/qq_emoticon_res");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = ((File)localObject).getAbsolutePath() + File.separator;
      return localObject;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("QQSysAndEmojiResMgr", 1, "npe:", localNullPointerException);
    }
    return "/qq_emoticon_res";
  }
  
  protected boolean A(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_emoticon_sp", 4).edit();
    localEditor.putString("md5_type_" + paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "saveResItem:", Integer.valueOf(paramInt), " ,md5:", paramString });
    }
    return localEditor.commit();
  }
  
  protected int H(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return 101;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return 103;
    }
    File localFile = new File(paramString1);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQSysAndEmojiResMgr", 2, "verifyResMD5 file not exist!");
      }
      return 102;
    }
    StringBuilder localStringBuilder = null;
    try
    {
      paramString1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString1));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("verifyResMD5 configMd5:").append(paramString2).append(", calMd5:").append(paramString1);
        QLog.d("QQSysAndEmojiResMgr", 2, localStringBuilder.toString());
      }
      if (paramString2.equalsIgnoreCase(paramString1)) {
        return 100;
      }
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      for (;;)
      {
        try
        {
          paramString1 = aszr.getFileMD5String(localFile);
        }
        catch (Exception paramString1)
        {
          paramString1 = localStringBuilder;
        }
        return 104;
      }
    }
  }
  
  protected void HZ(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  public QQSysAndEmojiResInfo a(int paramInt)
  {
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_Afkx;
        return localObject1;
      }
      finally {}
      if (paramInt != 2) {
        continue;
      }
      Object localObject1 = this.jdField_a_of_type_Afkt;
    }
    throw new IllegalArgumentException("not support such type:" + paramInt);
  }
  
  protected void a(afkv.a parama)
  {
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = parama.mUrl;
    localaoll.mHttpMethod = 0;
    localaoll.atY = (uw() + parama.mName);
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    localaoll.bw(parama);
    try
    {
      parama = BaseApplicationImpl.getApplication().getRuntime();
      if (QQAppInterface.class.isInstance(parama)) {
        ((QQAppInterface)parama).getNetEngine(0).a(localaoll);
      }
      return;
    }
    catch (Exception parama) {}
  }
  
  protected boolean aT(String paramString1, String paramString2)
  {
    try
    {
      jqp.b(new File(paramString1), paramString2);
      return true;
    }
    catch (IOException paramString1)
    {
      QLog.e("QQSysAndEmojiResMgr", 1, "unzipFile error ", paramString1);
    }
    return false;
  }
  
  public void daa()
  {
    for (;;)
    {
      afkv.a locala;
      try
      {
        Iterator localIterator = eK().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (afkv.a)localIterator.next();
        String str = locala.getSignature();
        if (this.zQ.contains(str))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQSysAndEmojiResMgr", 2, "alreary in download list!");
          continue;
        }
        this.zQ.add(str);
      }
      finally {}
      a(locala);
    }
  }
  
  protected List<afkv.a> eK()
  {
    aenf.c localc = (aenf.c)aeif.a().o(545);
    ArrayList localArrayList = new ArrayList(3);
    if ((!TextUtils.isEmpty(localc.brr)) && (!TextUtils.isEmpty(localc.bzM)) && (z(1, localc.bzM))) {
      localArrayList.add(new afkv.a(localc.brr, localc.bzM, 1));
    }
    if ((!TextUtils.isEmpty(localc.bzN)) && (!TextUtils.isEmpty(localc.bzO)) && (z(2, localc.bzO))) {
      localArrayList.add(new afkv.a(localc.bzN, localc.bzO, 2));
    }
    if ((!TextUtils.isEmpty(localc.bzP)) && (!TextUtils.isEmpty(localc.bzQ)) && (z(3, localc.bzQ))) {
      localArrayList.add(new afkv.a(localc.bzP, localc.bzQ, 3));
    }
    return localArrayList;
  }
  
  public void onResp(aomh paramaomh)
  {
    Object localObject = paramaomh.b;
    String str = ((aomg)localObject).atY;
    localObject = (afkv.a)((aomg)localObject).U();
    if (localObject == null)
    {
      QLog.e("QQSysAndEmojiResMgr", 1, "DownloadResItem is null!");
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (paramaomh.mResult == 0)
    {
      i = H(str, ((afkv.a)localObject).mMd5);
      if (i != 100) {
        break label263;
      }
      if (aT(str, ux()))
      {
        A(((afkv.a)localObject).mType, ((afkv.a)localObject).mMd5);
        if (((afkv.a)localObject).mType != 1) {
          break label223;
        }
        updateConfig();
      }
    }
    label263:
    for (;;)
    {
      HZ(str);
      str = ((afkv.a)localObject).getSignature();
      this.zQ.remove(str);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "onResp:", Integer.valueOf(paramaomh.mResult), " ,type:", Integer.valueOf(((afkv.a)localObject).mType), " ,cost:", Long.valueOf(System.currentTimeMillis() - l), " ,signature:", str.substring(str.lastIndexOf(47)) });
      return;
      label223:
      if (((afkv.a)localObject).mType == 2)
      {
        a(1).cZZ();
      }
      else if (((afkv.a)localObject).mType == 3)
      {
        a(2).cZZ();
        continue;
        QLog.e("QQSysAndEmojiResMgr", 1, new Object[] { "verifyResMD5 failed! ", Integer.valueOf(i) });
      }
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  
  protected void updateConfig()
  {
    QQSysAndEmojiResInfo.HY(ux());
    this.jdField_a_of_type_Afkx.cZW();
    this.jdField_a_of_type_Afkt.cZW();
  }
  
  protected boolean z(int paramInt, String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("qq_emoticon_sp", 4).getString("md5_type_" + paramInt, "");
    if (!str.equals(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "type:", Integer.valueOf(paramInt), " ,needDownload:", Boolean.valueOf(bool), " ,curr:", str, " ,new:", paramString });
      }
      return bool;
    }
  }
  
  public static class a
  {
    public String mMd5;
    public String mName;
    public int mType;
    public String mUrl;
    
    public a(String paramString1, String paramString2, int paramInt)
    {
      this.mUrl = paramString1;
      this.mMd5 = paramString2;
      this.mName = paramString1.substring(paramString1.lastIndexOf("/") + 1);
      this.mType = paramInt;
    }
    
    public String getSignature()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mUrl);
      localStringBuilder.append("_");
      localStringBuilder.append(this.mMd5);
      return localStringBuilder.toString();
    }
  }
  
  public static class b
  {
    private static afkv a = new afkv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkv
 * JD-Core Version:    0.7.0.1
 */
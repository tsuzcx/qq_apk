import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForScribble.FileExistInfo;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils.1;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class amjb
{
  public static int RESULT_SUCCESS = 1;
  public static int dCm;
  public static int dCn = 1;
  public static int dCo = 2;
  public static int dCp = 2;
  public static int dCq = 3;
  public static int dCr = 4;
  public static int dCs = 5;
  public static int dCt = 6;
  public static int dCu = 7;
  
  public static String a(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble != null) && (!TextUtils.isEmpty(paramMessageForScribble.combineFileMd5))) {
      return nc(paramMessageForScribble.combineFileMd5);
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, amjb.a parama)
  {
    dNU();
    new amjb.b(paramQQAppInterface, paramString, paramInt1, paramBitmap, paramInt2, parama).execute(new Void[0]);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble == null) {}
    amiy localamiy;
    MessageForScribble localMessageForScribble;
    do
    {
      return false;
      if (paramMessageForScribble.isSendFromLocal()) {
        paramQQAppInterface.a().oy(paramQQAppInterface.a().y(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq));
      }
      localamiy = new amiy(paramQQAppInterface);
      localMessageForScribble = localamiy.a(paramMessageForScribble);
    } while (localMessageForScribble == null);
    ThreadManager.post(new ScribbleMsgUtils.1(paramQQAppInterface, paramMessageForScribble), 5, null, false);
    localamiy.a(localMessageForScribble);
    return true;
  }
  
  public static String b(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble != null) && (!TextUtils.isEmpty(paramMessageForScribble.combineFileMd5))) {
      return nd(paramMessageForScribble.combineFileMd5);
    }
    return "";
  }
  
  public static int c(MessageForScribble paramMessageForScribble)
  {
    boolean bool1 = paramMessageForScribble.mExistInfo.mDataFileExist;
    if (!paramMessageForScribble.mExistInfo.mInit) {
      bool1 = ahbj.isFileExists(b(paramMessageForScribble));
    }
    boolean bool2 = paramMessageForScribble.mExistInfo.mCombineFileExist;
    if (!paramMessageForScribble.mExistInfo.mInit) {
      bool2 = ahbj.isFileExists(a(paramMessageForScribble));
    }
    if ((bool1) && (bool2)) {
      return dCo;
    }
    if ((!bool1) && (bool2)) {
      return dCn;
    }
    return dCm;
  }
  
  public static int d(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble == null) || (paramMessageForScribble.combineFileMd5 == null)) {
      return dCu;
    }
    String str1 = a(paramMessageForScribble);
    if (!ahbj.isFileExists(str1)) {
      return dCt;
    }
    long l = ahbj.getFileSize(str1);
    if ((paramMessageForScribble.offSet <= 0) || (paramMessageForScribble.offSet >= (int)l))
    {
      QLog.e("ScribbleMsgUtils", 2, " offSet = " + paramMessageForScribble.offSet + " FileSize : " + l);
      return dCu;
    }
    String str2 = b(paramMessageForScribble);
    if (ahbj.isFileExists(str2)) {
      ahbj.deleteFile(str2);
    }
    if (amjg.l(str1, paramMessageForScribble.offSet, str2)) {
      return RESULT_SUCCESS;
    }
    return dCp;
  }
  
  private static void dNU()
  {
    File localFile = new File(yR());
    if (((localFile.exists()) && (!localFile.isDirectory())) || (!localFile.exists())) {
      localFile.mkdirs();
    }
  }
  
  private static String nc(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return yR() + paramString;
    }
    return "";
  }
  
  private static String nd(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return yR() + paramString + "_data";
    }
    return "";
  }
  
  public static String yR()
  {
    return acbn.bng + "ScribbleCache/";
  }
  
  public static abstract interface a
  {
    public abstract void CJ(int paramInt);
    
    public abstract boolean hI(String paramString);
  }
  
  static class b
    extends AsyncTask<Void, Void, Integer>
  {
    private amjb.a a;
    private int bRb;
    private String cai = "";
    private String caj = "";
    private String cak = "";
    private String cal = "SendAfterCombinePicAndDataTask";
    private Bitmap gh;
    private String mPeerUin = "";
    private int mUinType;
    private int offset;
    private QQAppInterface r;
    
    public b(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, amjb.a parama)
    {
      this.r = paramQQAppInterface;
      this.a = parama;
      this.mPeerUin = paramString;
      this.mUinType = paramInt1;
      this.gh = paramBitmap;
      this.bRb = paramInt2;
    }
    
    public byte[] Bitmap2Bytes(Bitmap paramBitmap)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    
    int IM()
    {
      String str1 = amjb.yR() + "temp/" + System.currentTimeMillis();
      String str2 = amjb.yR() + "temp/" + System.currentTimeMillis() + "_data";
      boolean bool = false;
      if (this.a != null) {
        bool = this.a.hI(str2);
      }
      if (!bool) {
        return amjb.dCr;
      }
      if (!ahbj.isFileExists(str2)) {
        return amjb.dCs;
      }
      Object localObject = Bitmap2Bytes(this.gh);
      this.offset = localObject.length;
      if (!amjg.b((byte[])localObject, str2, str1)) {
        return amjb.dCp;
      }
      localObject = amjg.calcMD5(str1);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return amjb.dCq;
      }
      this.cai = ((String)localObject);
      this.caj = amjb.nc(this.cai);
      this.cak = amjb.nd(this.cai);
      if (!amjg.b(str1, this.caj).booleanValue()) {
        return amjb.dCp;
      }
      if (!amjg.b(str2, this.cak).booleanValue()) {
        return amjb.dCp;
      }
      ahbj.deleteFile(str1);
      ahbj.deleteFile(str2);
      return amjb.RESULT_SUCCESS;
    }
    
    protected Integer a(Void... paramVarArgs)
    {
      return Integer.valueOf(IM());
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      super.onPostExecute(paramInteger);
      QLog.i(this.cal, 2, "doBeforeSendScribble result = " + paramInteger);
      if (paramInteger.intValue() == amjb.RESULT_SUCCESS)
      {
        amiy localamiy = new amiy(this.r);
        MessageForScribble localMessageForScribble = localamiy.a(this.caj, this.cai, this.offset, this.mPeerUin, this.mUinType, this.bRb);
        localMessageForScribble.mExistInfo.mCombineFileExist = true;
        localMessageForScribble.mExistInfo.mDataFileExist = true;
        localMessageForScribble.mExistInfo.mLocalPathExist = true;
        localMessageForScribble.mExistInfo.mInit = true;
        localamiy.a(localMessageForScribble);
      }
      if (this.a != null) {
        this.a.CJ(paramInteger.intValue());
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjb
 * JD-Core Version:    0.7.0.1
 */
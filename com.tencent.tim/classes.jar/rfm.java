import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class rfm
  extends rfo
{
  public static final String aAf = Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/capture_ptv_template/share/";
  private String Qr;
  private String aAg;
  private String aAh;
  private String aAi;
  private String aAj;
  private String aAk;
  private String aAl;
  private String aAm;
  private String aAn;
  private String aAo;
  
  protected boolean Ll()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ("share_PK".equals(this.aAh))
    {
      if ((!TextUtils.isEmpty(this.aAj)) && (!TextUtils.isEmpty(this.aAl))) {}
      for (;;)
      {
        bool2 = bool1;
        if (bool1)
        {
          this.mShareUrl = this.aAj;
          this.bN = this.aAl;
          this.aAt = this.aAn;
          bool2 = bool1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DanceMachinePKVideoSharer", 2, "hasShare : " + bool2 + " shareUrl : " + this.mShareUrl + " thumbPath : " + this.bN + " lastShareType" + this.aAh);
        }
        return bool2;
        bool1 = false;
      }
    }
    if ((!TextUtils.isEmpty(this.aAk)) && (!TextUtils.isEmpty(this.aAm))) {}
    for (bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.mShareUrl = this.aAk;
      this.bN = this.aAm;
      this.aAt = this.aAo;
      bool2 = bool1;
      break;
    }
  }
  
  protected String a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ("share_PK".equals(this.aAh))
    {
      paramString1 = acfp.m(2131709671) + paramInt1 + acfp.m(2131709664) + paramInt2 + acfp.m(2131709663);
      this.aAn = paramString1;
      return paramString1;
    }
    this.aAo = super.a(paramInt1, paramString1, paramString2, paramInt2);
    return this.aAo;
  }
  
  public String ai(String paramString1, String paramString2)
  {
    if ("share_PK".equals(this.aAh))
    {
      this.aAj = (this.aAg + String.format("&uuid=%s", new Object[] { paramString1 }));
      return this.aAj;
    }
    this.aAk = super.ai(paramString1, paramString2);
    return this.aAk;
  }
  
  protected boolean b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    return false;
  }
  
  protected void eU(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    super.eU(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ShareActionSheetBuilder.ActionSheetItem)paramList.next()).action == 2) {
        paramList.remove();
      }
    }
  }
  
  public void eh(int paramInt1, int paramInt2)
  {
    if ("share_PK".equals(this.aAh))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("upload_pic_busi_type", 2);
      localIntent.putExtra("dance_machine_rank", this.aAi);
      localIntent.putExtra("dance_machine_score", this.Qr);
      localIntent.putExtra("share_method", paramInt1);
      localIntent.putExtra("pk_rank", this.aAi);
      PublicTransFragmentActivity.startForResult(this.mContext, localIntent, CommonPicUploadFragment.class, 90002);
      return;
    }
    super.eh(paramInt1, paramInt2);
  }
  
  /* Error */
  public String ge(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 50
    //   5: aload_0
    //   6: getfield 52	rfm:aAh	Ljava/lang/String;
    //   9: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +178 -> 190
    //   15: aload_0
    //   16: new 20	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 29	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   26: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: ldc 220
    //   31: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: putfield 68	rfm:aAl	Ljava/lang/String;
    //   40: aload_0
    //   41: getfield 68	rfm:aAl	Ljava/lang/String;
    //   44: invokestatic 226	aqhq:fileExists	(Ljava/lang/String;)Z
    //   47: ifne +60 -> 107
    //   50: aload_0
    //   51: getfield 199	rfm:mContext	Landroid/app/Activity;
    //   54: invokevirtual 232	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   57: ldc 233
    //   59: invokestatic 239	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull +43 -> 107
    //   67: new 241	java/io/FileOutputStream
    //   70: dup
    //   71: aload_0
    //   72: getfield 68	rfm:aAl	Ljava/lang/String;
    //   75: invokestatic 245	aqhq:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   78: invokespecial 248	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: astore_2
    //   82: aload_2
    //   83: astore_1
    //   84: aload_3
    //   85: getstatic 254	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   88: bipush 100
    //   90: aload_2
    //   91: invokevirtual 260	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   94: pop
    //   95: aload_3
    //   96: invokevirtual 263	android/graphics/Bitmap:recycle	()V
    //   99: aload_2
    //   100: ifnull +7 -> 107
    //   103: aload_2
    //   104: invokevirtual 266	java/io/FileOutputStream:close	()V
    //   107: aload_0
    //   108: getfield 68	rfm:aAl	Ljava/lang/String;
    //   111: areturn
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 269	java/lang/OutOfMemoryError:printStackTrace	()V
    //   117: aconst_null
    //   118: astore_3
    //   119: goto -56 -> 63
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 270	java/io/IOException:printStackTrace	()V
    //   127: goto -20 -> 107
    //   130: astore 4
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: astore_1
    //   136: aload 4
    //   138: invokevirtual 271	java/lang/Exception:printStackTrace	()V
    //   141: aload_3
    //   142: invokevirtual 263	android/graphics/Bitmap:recycle	()V
    //   145: aload_2
    //   146: ifnull -39 -> 107
    //   149: aload_2
    //   150: invokevirtual 266	java/io/FileOutputStream:close	()V
    //   153: goto -46 -> 107
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 270	java/io/IOException:printStackTrace	()V
    //   161: goto -54 -> 107
    //   164: astore_1
    //   165: aload 4
    //   167: astore_2
    //   168: aload_3
    //   169: invokevirtual 263	android/graphics/Bitmap:recycle	()V
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 266	java/io/FileOutputStream:close	()V
    //   180: aload_1
    //   181: athrow
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 270	java/io/IOException:printStackTrace	()V
    //   187: goto -7 -> 180
    //   190: aload_0
    //   191: getfield 74	rfm:bN	Ljava/lang/String;
    //   194: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifne +25 -> 222
    //   200: aload_0
    //   201: getfield 74	rfm:bN	Ljava/lang/String;
    //   204: aload_0
    //   205: getfield 68	rfm:aAl	Ljava/lang/String;
    //   208: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifne +11 -> 222
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 74	rfm:bN	Ljava/lang/String;
    //   219: invokevirtual 275	rfm:sw	(Ljava/lang/String;)V
    //   222: aload_0
    //   223: aload_1
    //   224: putfield 105	rfm:aAm	Ljava/lang/String;
    //   227: aload_0
    //   228: getfield 105	rfm:aAm	Ljava/lang/String;
    //   231: areturn
    //   232: astore 4
    //   234: aload_1
    //   235: astore_2
    //   236: aload 4
    //   238: astore_1
    //   239: goto -71 -> 168
    //   242: astore 4
    //   244: goto -110 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	rfm
    //   0	247	1	paramString	String
    //   81	96	2	localObject1	Object
    //   182	2	2	localIOException	java.io.IOException
    //   235	1	2	str	String
    //   62	107	3	localBitmap	android.graphics.Bitmap
    //   1	1	4	localObject2	Object
    //   130	36	4	localException1	java.lang.Exception
    //   232	5	4	localObject3	Object
    //   242	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   50	63	112	java/lang/OutOfMemoryError
    //   95	99	122	java/io/IOException
    //   103	107	122	java/io/IOException
    //   67	82	130	java/lang/Exception
    //   141	145	156	java/io/IOException
    //   149	153	156	java/io/IOException
    //   67	82	164	finally
    //   168	172	182	java/io/IOException
    //   176	180	182	java/io/IOException
    //   84	95	232	finally
    //   136	141	232	finally
    //   84	95	242	java/lang/Exception
  }
  
  public void o(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.aAg = paramString2;
    this.aAh = paramString1;
    this.aAi = paramString3;
    this.Qr = paramString4;
    if (this.a != null) {
      this.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfm
 * JD-Core Version:    0.7.0.1
 */
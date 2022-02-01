import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ywq
  extends yws
{
  public static final String a;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/capture_ptv_template/share/";
  }
  
  protected String a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ("share_PK".equals(this.m))
    {
      paramString1 = anni.a(2131706958) + paramInt1 + anni.a(2131706951) + paramInt2 + anni.a(2131706950);
      this.t = paramString1;
      return paramString1;
    }
    this.u = super.a(paramInt1, paramString1, paramString2, paramInt2);
    return this.u;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 49
    //   5: aload_0
    //   6: getfield 51	ywq:m	Ljava/lang/String;
    //   9: invokevirtual 57	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +178 -> 190
    //   15: aload_0
    //   16: new 20	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 29	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   26: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: ldc 83
    //   31: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: putfield 85	ywq:r	Ljava/lang/String;
    //   40: aload_0
    //   41: getfield 85	ywq:r	Ljava/lang/String;
    //   44: invokestatic 90	bgmg:a	(Ljava/lang/String;)Z
    //   47: ifne +60 -> 107
    //   50: aload_0
    //   51: getfield 93	ywq:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   54: invokevirtual 99	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   57: ldc 100
    //   59: invokestatic 106	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull +43 -> 107
    //   67: new 108	java/io/FileOutputStream
    //   70: dup
    //   71: aload_0
    //   72: getfield 85	ywq:r	Ljava/lang/String;
    //   75: invokestatic 111	bgmg:a	(Ljava/lang/String;)Ljava/io/File;
    //   78: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: astore_2
    //   82: aload_2
    //   83: astore_1
    //   84: aload_3
    //   85: getstatic 120	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   88: bipush 100
    //   90: aload_2
    //   91: invokevirtual 126	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   94: pop
    //   95: aload_3
    //   96: invokevirtual 129	android/graphics/Bitmap:recycle	()V
    //   99: aload_2
    //   100: ifnull +7 -> 107
    //   103: aload_2
    //   104: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   107: aload_0
    //   108: getfield 85	ywq:r	Ljava/lang/String;
    //   111: areturn
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 135	java/lang/OutOfMemoryError:printStackTrace	()V
    //   117: aconst_null
    //   118: astore_3
    //   119: goto -56 -> 63
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   127: goto -20 -> 107
    //   130: astore 4
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: astore_1
    //   136: aload 4
    //   138: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   141: aload_3
    //   142: invokevirtual 129	android/graphics/Bitmap:recycle	()V
    //   145: aload_2
    //   146: ifnull -39 -> 107
    //   149: aload_2
    //   150: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   153: goto -46 -> 107
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   161: goto -54 -> 107
    //   164: astore_1
    //   165: aload 4
    //   167: astore_2
    //   168: aload_3
    //   169: invokevirtual 129	android/graphics/Bitmap:recycle	()V
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   180: aload_1
    //   181: athrow
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   187: goto -7 -> 180
    //   190: aload_0
    //   191: getfield 140	ywq:h	Ljava/lang/String;
    //   194: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifne +25 -> 222
    //   200: aload_0
    //   201: getfield 140	ywq:h	Ljava/lang/String;
    //   204: aload_0
    //   205: getfield 85	ywq:r	Ljava/lang/String;
    //   208: invokevirtual 57	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifne +11 -> 222
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 140	ywq:h	Ljava/lang/String;
    //   219: invokevirtual 149	ywq:a	(Ljava/lang/String;)V
    //   222: aload_0
    //   223: aload_1
    //   224: putfield 151	ywq:s	Ljava/lang/String;
    //   227: aload_0
    //   228: getfield 151	ywq:s	Ljava/lang/String;
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
    //   0	247	0	this	ywq
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
  
  public String a(String paramString1, String paramString2)
  {
    if ("share_PK".equals(this.m))
    {
      this.p = (this.l + String.format("&uuid=%s", new Object[] { paramString1 }));
      return this.p;
    }
    this.q = super.a(paramString1, paramString2);
    return this.q;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ("share_PK".equals(this.m))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("upload_pic_busi_type", 2);
      localIntent.putExtra("dance_machine_rank", this.n);
      localIntent.putExtra("dance_machine_score", this.o);
      localIntent.putExtra("share_method", paramInt1);
      localIntent.putExtra("pk_rank", this.n);
      PublicTransFragmentActivity.b(this.jdField_a_of_type_AndroidAppActivity, localIntent, CommonPicUploadFragment.class, 90002);
      return;
    }
    super.a(paramInt1, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.l = paramString2;
    this.m = paramString1;
    this.n = paramString3;
    this.o = paramString4;
    if (this.jdField_a_of_type_Baqk != null) {
      this.jdField_a_of_type_Baqk.a();
    }
  }
  
  protected void a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    super.a(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ShareActionSheetBuilder.ActionSheetItem)paramList.next()).action == 2) {
        paramList.remove();
      }
    }
  }
  
  protected boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ("share_PK".equals(this.m))
    {
      if ((!TextUtils.isEmpty(this.p)) && (!TextUtils.isEmpty(this.r))) {}
      for (;;)
      {
        bool2 = bool1;
        if (bool1)
        {
          this.i = this.p;
          this.h = this.r;
          this.j = this.t;
          bool2 = bool1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DanceMachinePKVideoSharer", 2, "hasShare : " + bool2 + " shareUrl : " + this.i + " thumbPath : " + this.h + " lastShareType" + this.m);
        }
        return bool2;
        bool1 = false;
      }
    }
    if ((!TextUtils.isEmpty(this.q)) && (!TextUtils.isEmpty(this.s))) {}
    for (bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.i = this.q;
      this.h = this.s;
      this.j = this.u;
      bool2 = bool1;
      break;
    }
  }
  
  protected boolean a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywq
 * JD-Core Version:    0.7.0.1
 */
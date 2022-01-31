package com.tencent.token.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.jni.FaceDetector.IdCardDirection;
import com.tencent.token.global.e;

public class DetectIDPhotoPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private Context a;
  private SurfaceHolder b;
  private ct c;
  private Handler d;
  private String e;
  private FaceDetector.IdCardDirection f;
  
  public DetectIDPhotoPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public final void a()
  {
    if (this.c != null)
    {
      this.c.b();
      this.c = null;
    }
  }
  
  public final void a(Context paramContext, Handler paramHandler)
  {
    this.a = paramContext;
    this.d = paramHandler;
    this.b = getHolder();
    this.b.addCallback(this);
    this.b.setType(3);
  }
  
  public final void a(FaceDetector.IdCardDirection paramIdCardDirection)
  {
    this.f = paramIdCardDirection;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.a(paramBoolean);
    }
  }
  
  /* Error */
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 41	com/tencent/token/ui/DetectIDPhotoPreview:b	Landroid/view/SurfaceHolder;
    //   7: invokeinterface 67 1 0
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: getfield 28	com/tencent/token/ui/DetectIDPhotoPreview:c	Lcom/tencent/token/ui/ct;
    //   20: ifnonnull -5 -> 15
    //   23: aload_0
    //   24: getfield 24	com/tencent/token/ui/DetectIDPhotoPreview:a	Landroid/content/Context;
    //   27: invokevirtual 73	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   30: invokevirtual 79	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   33: ldc 81
    //   35: invokevirtual 87	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore 5
    //   40: new 89	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: getfield 24	com/tencent/token/ui/DetectIDPhotoPreview:a	Landroid/content/Context;
    //   48: ldc 91
    //   50: iconst_0
    //   51: invokevirtual 95	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   54: ldc 81
    //   56: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   59: astore 8
    //   61: aload 8
    //   63: invokevirtual 102	java/io/File:exists	()Z
    //   66: ifeq +68 -> 134
    //   69: aload_0
    //   70: aload 8
    //   72: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   75: putfield 108	com/tencent/token/ui/DetectIDPhotoPreview:e	Ljava/lang/String;
    //   78: aload 5
    //   80: ifnull +8 -> 88
    //   83: aload 5
    //   85: invokevirtual 113	java/io/InputStream:close	()V
    //   88: aload_0
    //   89: new 30	com/tencent/token/ui/ct
    //   92: dup
    //   93: aload_0
    //   94: invokevirtual 117	com/tencent/token/ui/DetectIDPhotoPreview:getContext	()Landroid/content/Context;
    //   97: aload_1
    //   98: aload_0
    //   99: getfield 35	com/tencent/token/ui/DetectIDPhotoPreview:d	Landroid/os/Handler;
    //   102: aload_0
    //   103: getfield 108	com/tencent/token/ui/DetectIDPhotoPreview:e	Ljava/lang/String;
    //   106: aload_0
    //   107: getfield 54	com/tencent/token/ui/DetectIDPhotoPreview:f	Lcom/tencent/jni/FaceDetector$IdCardDirection;
    //   110: invokespecial 120	com/tencent/token/ui/ct:<init>	(Landroid/content/Context;Landroid/view/SurfaceHolder;Landroid/os/Handler;Ljava/lang/String;Lcom/tencent/jni/FaceDetector$IdCardDirection;)V
    //   113: putfield 28	com/tencent/token/ui/DetectIDPhotoPreview:c	Lcom/tencent/token/ui/ct;
    //   116: aload_0
    //   117: getfield 28	com/tencent/token/ui/DetectIDPhotoPreview:c	Lcom/tencent/token/ui/ct;
    //   120: invokevirtual 122	com/tencent/token/ui/ct:a	()V
    //   123: return
    //   124: astore 5
    //   126: aload 5
    //   128: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   131: goto -43 -> 88
    //   134: new 127	java/io/FileOutputStream
    //   137: dup
    //   138: aload 8
    //   140: invokespecial 130	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   143: astore 6
    //   145: sipush 8192
    //   148: newarray byte
    //   150: astore 7
    //   152: aload 5
    //   154: aload 7
    //   156: invokevirtual 134	java/io/InputStream:read	([B)I
    //   159: istore_2
    //   160: iload_2
    //   161: iconst_m1
    //   162: if_icmpeq +55 -> 217
    //   165: aload 6
    //   167: aload 7
    //   169: iconst_0
    //   170: iload_2
    //   171: invokevirtual 138	java/io/FileOutputStream:write	([BII)V
    //   174: goto -22 -> 152
    //   177: astore 7
    //   179: ldc 140
    //   181: invokestatic 145	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   184: aload 5
    //   186: ifnull +8 -> 194
    //   189: aload 5
    //   191: invokevirtual 113	java/io/InputStream:close	()V
    //   194: aload 6
    //   196: ifnull -108 -> 88
    //   199: aload 6
    //   201: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   204: goto -116 -> 88
    //   207: astore 5
    //   209: aload 5
    //   211: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   214: goto -126 -> 88
    //   217: aload_0
    //   218: aload 8
    //   220: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   223: putfield 108	com/tencent/token/ui/DetectIDPhotoPreview:e	Ljava/lang/String;
    //   226: aload 5
    //   228: ifnull +8 -> 236
    //   231: aload 5
    //   233: invokevirtual 113	java/io/InputStream:close	()V
    //   236: aload 6
    //   238: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   241: goto -153 -> 88
    //   244: astore 5
    //   246: aload 5
    //   248: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   251: goto -163 -> 88
    //   254: astore_1
    //   255: aconst_null
    //   256: astore 5
    //   258: aconst_null
    //   259: astore 6
    //   261: aload 5
    //   263: ifnull +8 -> 271
    //   266: aload 5
    //   268: invokevirtual 113	java/io/InputStream:close	()V
    //   271: aload 6
    //   273: ifnull +8 -> 281
    //   276: aload 6
    //   278: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   281: aload_1
    //   282: athrow
    //   283: astore 5
    //   285: aload 5
    //   287: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   290: goto -9 -> 281
    //   293: astore_1
    //   294: aconst_null
    //   295: astore 6
    //   297: goto -36 -> 261
    //   300: astore_1
    //   301: goto -40 -> 261
    //   304: astore_1
    //   305: goto -44 -> 261
    //   308: astore 5
    //   310: aconst_null
    //   311: astore 5
    //   313: aload 7
    //   315: astore 6
    //   317: goto -138 -> 179
    //   320: astore 6
    //   322: aload 7
    //   324: astore 6
    //   326: goto -147 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	DetectIDPhotoPreview
    //   0	329	1	paramSurfaceHolder	SurfaceHolder
    //   0	329	2	paramInt1	int
    //   0	329	3	paramInt2	int
    //   0	329	4	paramInt3	int
    //   38	46	5	localInputStream	java.io.InputStream
    //   124	66	5	localException1	Exception
    //   207	25	5	localException2	Exception
    //   244	3	5	localException3	Exception
    //   256	11	5	localObject1	java.lang.Object
    //   283	3	5	localException4	Exception
    //   308	1	5	localIOException1	java.io.IOException
    //   311	1	5	localObject2	java.lang.Object
    //   143	173	6	localObject3	java.lang.Object
    //   320	1	6	localIOException2	java.io.IOException
    //   324	1	6	localIOException3	java.io.IOException
    //   1	167	7	arrayOfByte	byte[]
    //   177	146	7	localIOException4	java.io.IOException
    //   59	160	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   83	88	124	java/lang/Exception
    //   145	152	177	java/io/IOException
    //   152	160	177	java/io/IOException
    //   165	174	177	java/io/IOException
    //   217	226	177	java/io/IOException
    //   189	194	207	java/lang/Exception
    //   199	204	207	java/lang/Exception
    //   231	236	244	java/lang/Exception
    //   236	241	244	java/lang/Exception
    //   23	40	254	finally
    //   266	271	283	java/lang/Exception
    //   276	281	283	java/lang/Exception
    //   40	78	293	finally
    //   134	145	293	finally
    //   145	152	300	finally
    //   152	160	300	finally
    //   165	174	300	finally
    //   217	226	300	finally
    //   179	184	304	finally
    //   23	40	308	java/io/IOException
    //   40	78	320	java/io/IOException
    //   134	145	320	java/io/IOException
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    e.c("surfaceDestroyed!");
    try
    {
      if (this.c != null)
      {
        this.c.b();
        this.c = null;
      }
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DetectIDPhotoPreview
 * JD-Core Version:    0.7.0.1
 */
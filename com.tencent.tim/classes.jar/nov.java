import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

public class nov
{
  npb<Bitmap> a;
  
  public nov(Bitmap paramBitmap, npc<Bitmap> paramnpc)
  {
    this.a = new npb(paramBitmap, paramnpc);
    if (QLog.isColorLevel()) {
      npe.o(toString(), "onCreate", true);
    }
  }
  
  public nov(npb<Bitmap> paramnpb)
  {
    paramnpb.aZR();
    this.a = paramnpb;
    if (QLog.isColorLevel()) {
      npe.o(toString(), "createFromClone", true);
    }
  }
  
  public Bitmap Q()
  {
    if (this.a != null) {
      return (Bitmap)this.a.get();
    }
    anot.a(null, "dc01160", "", "", "0X80098F1", "0X80098F1", 0, 1, null, null, "", "");
    return null;
  }
  
  public nov a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        npe.o(toString(), "clone", true);
      }
      nov localnov = new nov(this.a);
      return localnov;
    }
    finally {}
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	nov:a	Lnpb;
    //   6: ifnull +34 -> 40
    //   9: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +13 -> 25
    //   15: aload_0
    //   16: invokevirtual 29	nov:toString	()Ljava/lang/String;
    //   19: ldc 78
    //   21: iconst_1
    //   22: invokestatic 37	npe:o	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   25: aload_0
    //   26: getfield 19	nov:a	Lnpb;
    //   29: invokevirtual 81	npb:aZS	()V
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 19	nov:a	Lnpb;
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: invokevirtual 29	nov:toString	()Ljava/lang/String;
    //   44: ldc 83
    //   46: invokestatic 87	npe:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: goto -12 -> 37
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	nov
    //   52	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	52	finally
    //   25	37	52	finally
    //   37	39	52	finally
    //   40	49	52	finally
    //   53	55	52	finally
  }
  
  public boolean isValid()
  {
    return this.a != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("zimage.closeable@").append(hashCode()).append("_bitmap@");
    if ((this.a != null) && (this.a.get() != null)) {}
    for (Integer localInteger = Integer.valueOf(((Bitmap)this.a.get()).hashCode());; localInteger = null) {
      return localInteger;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     nov
 * JD-Core Version:    0.7.0.1
 */
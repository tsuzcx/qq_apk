import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo.QQEmoConfigItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afkx
  extends QQSysAndEmojiResInfo
  implements afkw.a
{
  private int cRK;
  private int cRL;
  
  public int Da()
  {
    return this.cRK;
  }
  
  public int Dd()
  {
    return this.cRL;
  }
  
  public void Mz(int paramInt)
  {
    i(getDrawable(paramInt), paramInt);
    i(y(paramInt), paramInt);
  }
  
  public void cZW()
  {
    Object localObject1 = Z();
    if (localObject1 != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("sysface");
      if (localJSONArray != null)
      {
        if (this.kn == null) {
          this.kn = new HashMap();
        }
        if (this.wi == null) {
          this.wi = new ArrayList();
        }
        if (this.ko == null) {
          this.ko = new HashMap();
        }
        if (this.kp == null) {
          this.kp = new HashMap();
        }
        if (this.kq == null) {
          this.kq = new HashMap();
        }
        this.kn.clear();
        this.wi.clear();
        this.ko.clear();
        this.kp.clear();
        this.kq.clear();
        long l = System.currentTimeMillis();
        int i = 0;
        QQSysAndEmojiResInfo.QQEmoConfigItem localQQEmoConfigItem;
        for (;;)
        {
          if (i >= localJSONArray.length()) {
            break label437;
          }
          localObject1 = null;
          try
          {
            localObject2 = localJSONArray.getJSONObject(i);
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Object localObject2;
              localJSONException.printStackTrace();
            }
          }
          localQQEmoConfigItem = (QQSysAndEmojiResInfo.QQEmoConfigItem)aiio.convertFromJSONObject((JSONObject)localObject1, QQSysAndEmojiResInfo.QQEmoConfigItem.class);
          try
          {
            int j = Integer.parseInt(localQQEmoConfigItem.AQLid);
            int k = Integer.parseInt(localQQEmoConfigItem.QSid);
            if (!TextUtils.isEmpty(localQQEmoConfigItem.EMCode))
            {
              String str = "[em]e" + localQQEmoConfigItem.EMCode + "[/em]";
              localObject2 = localQQEmoConfigItem.QDes;
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = localObject2;
                if (((String)localObject2).equals("/吃瓜")) {
                  localObject1 = "/chigua";
                }
              }
              this.kp.put(localObject1, str);
              this.kq.put(str, Integer.valueOf(j));
            }
            this.kn.put(Integer.valueOf(j), localQQEmoConfigItem);
            this.ko.put(Integer.valueOf(k), Integer.valueOf(j));
            if (!a(localQQEmoConfigItem)) {
              this.wi.add(Integer.valueOf(j));
            }
            if (j > this.cRK) {
              this.cRK = j;
            }
            if (k > this.cRL) {
              this.cRL = k;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              QLog.d("QQSysFaceResInfo", 1, new Object[] { "error occur in sysface AQLid:", localQQEmoConfigItem.AQLid });
            }
          }
          i += 1;
        }
        label437:
        if (QLog.isColorLevel()) {
          QLog.d("QQSysFaceResInfo", 2, new Object[] { "sysface configItem:", Integer.valueOf(this.kn.size()), ", orderlist:", Integer.valueOf(this.wi.size()), ", maxLid:", Integer.valueOf(this.cRK), ", maxSid:", Integer.valueOf(this.cRL), ", cost:", Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
    }
  }
  
  public void cZX()
  {
    this.a = new afkw(this);
  }
  
  public void cZY()
  {
    if (this.kn == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.kn.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if ((localInteger.intValue() >= 260) && (!"-1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.kn.get(localInteger)).QSid))) {
          ((URLDrawable)getDrawable(localInteger.intValue())).downloadImediatly();
        }
      }
    }
  }
  
  public String dY(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.kn != null)
    {
      str1 = str2;
      if (this.kn.containsKey(Integer.valueOf(paramInt))) {
        str1 = ((QQSysAndEmojiResInfo.QQEmoConfigItem)this.kn.get(Integer.valueOf(paramInt))).QDes;
      }
    }
    return str1;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    int i = afky.hl(paramInt);
    for (;;)
    {
      try
      {
        localURL1 = new URL("qqsys_emoji", "host_qqsys_static", String.format("s%d.png", new Object[] { Integer.valueOf(i) }));
        localURL2 = localURL1;
        localURL2 = localURL1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("QQSysFaceResInfo", 2, "getDrawable url:" + localURL1.toString());
            localURL2 = localURL1;
          }
          return a(localURL2, null, false, String.valueOf(paramInt));
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          URL localURL1;
          URL localURL2;
          break label94;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localURL1 = null;
      }
      label94:
      if (QLog.isColorLevel())
      {
        QLog.d("QQSysFaceResInfo", 2, "getDrawable ,", localMalformedURLException1);
        localURL2 = localURL1;
      }
    }
  }
  
  public void hL(int paramInt1, int paramInt2)
  {
    int i = hh(paramInt1);
    paramInt1 = i;
    if (i == 0) {
      paramInt1 = 1000;
    }
    anot.a(null, "dc00898", "", "", "0X800A7A2", "0X800A7A2", paramInt1, 0, String.valueOf(paramInt2), "", "", "");
  }
  
  public int hh(int paramInt)
  {
    int j = -1;
    int i = j;
    if (this.kn != null)
    {
      i = j;
      if (this.kn.containsKey(Integer.valueOf(paramInt))) {
        i = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.kn.get(Integer.valueOf(paramInt))).QSid);
      }
    }
    return i;
  }
  
  public boolean jk(int paramInt)
  {
    boolean bool = false;
    String str = afkv.B(2, String.format("/s%d.png", new Object[] { Integer.valueOf(paramInt) }));
    if (!TextUtils.isEmpty(str)) {
      bool = new File(str).exists();
    }
    return bool;
  }
  
  public boolean jo(int paramInt)
    throws ArrayIndexOutOfBoundsException
  {
    if ((this.kn != null) && (this.kn.containsKey(Integer.valueOf(paramInt)))) {
      return "1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.kn.get(Integer.valueOf(paramInt))).isStatic);
    }
    return aoff.om[paramInt] == aoff.ol[paramInt];
  }
  
  public boolean jp(int paramInt)
  {
    if ((this.kn != null) && (this.kn.containsKey(Integer.valueOf(paramInt)))) {
      return "1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.kn.get(Integer.valueOf(paramInt))).isCMEmoji);
    }
    return false;
  }
  
  /* Error */
  public Drawable y(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iload_1
    //   4: invokestatic 262	afky:hl	(I)I
    //   7: istore_2
    //   8: new 264	java/net/URL
    //   11: dup
    //   12: ldc_w 266
    //   15: ldc_w 349
    //   18: ldc_w 351
    //   21: iconst_1
    //   22: anewarray 173	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: iload_2
    //   28: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: aastore
    //   32: invokestatic 274	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokespecial 277	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   38: astore_3
    //   39: aload_3
    //   40: astore 4
    //   42: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +35 -> 80
    //   48: ldc 171
    //   50: iconst_2
    //   51: new 125	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 353
    //   61: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_3
    //   65: invokevirtual 280	java/net/URL:toString	()Ljava/lang/String;
    //   68: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_3
    //   78: astore 4
    //   80: aload 6
    //   82: astore_3
    //   83: iload_1
    //   84: getstatic 356	aoff:dOp	I
    //   87: if_icmpge +8 -> 95
    //   90: iload_1
    //   91: invokestatic 359	afky:z	(I)Landroid/graphics/drawable/Drawable;
    //   94: astore_3
    //   95: aload_0
    //   96: aload 4
    //   98: aload_3
    //   99: iconst_1
    //   100: iload_1
    //   101: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   104: invokevirtual 288	afkx:a	(Ljava/net/URL;Landroid/graphics/drawable/Drawable;ZLjava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   107: areturn
    //   108: astore 5
    //   110: aconst_null
    //   111: astore_3
    //   112: aload_3
    //   113: astore 4
    //   115: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq -38 -> 80
    //   121: ldc 171
    //   123: iconst_2
    //   124: ldc_w 363
    //   127: aload 5
    //   129: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_3
    //   133: astore 4
    //   135: goto -55 -> 80
    //   138: astore 5
    //   140: goto -28 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	afkx
    //   0	143	1	paramInt	int
    //   7	21	2	i	int
    //   38	95	3	localObject1	Object
    //   40	94	4	localObject2	Object
    //   108	20	5	localMalformedURLException1	MalformedURLException
    //   138	1	5	localMalformedURLException2	MalformedURLException
    //   1	80	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	39	108	java/net/MalformedURLException
    //   42	77	138	java/net/MalformedURLException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkx
 * JD-Core Version:    0.7.0.1
 */
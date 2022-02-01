import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class axtd
  extends axon
{
  public static final File bl = new File(axwf.g(), "dov_doodle_sticker");
  private ArrayList<DoodleEmojiItem> stickerList;
  
  public static boolean aPH()
  {
    boolean bool = new File(bl + File.separator + "doodle_sticker_config.cfg").exists();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPasterConfigManager", 2, "QIMPasterConfigManager isStickerConfigFileExist=" + bool);
    }
    return bool;
  }
  
  private ArrayList<DoodleEmojiItem> ar(String paramString)
  {
    localArrayList = new ArrayList(4);
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("category");
      localArrayList.ensureCapacity(paramString.length());
      int i = 0;
      while (i < paramString.length())
      {
        DoodleEmojiItem localDoodleEmojiItem = DoodleEmojiItem.getDoodleEmojiItemFromJsonObj(paramString.getJSONObject(i));
        if (localDoodleEmojiItem != null) {
          localArrayList.add(localDoodleEmojiItem);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QIMPasterConfigManager", 2, QLog.getStackTraceString(paramString));
      }
    }
  }
  
  public void ado(String paramString)
  {
    Object localObject = ar(paramString);
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      this.stickerList = ((ArrayList)localObject);
      localObject = (axsu)axov.a().c(4);
      if (((axsu)localObject).aA != null) {
        ((axsu)localObject).aA.clear();
      }
      ((aykn)psx.a(39)).oP(this.stickerList);
      a().notifyObservers(axrf.class, 4, true, null);
      if (QLog.isColorLevel()) {
        QLog.i("QIMPasterConfigManager", 2, "paster config send notify");
      }
      axwf.b(bl, "doodle_sticker_config.cfg", paramString);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("paster config handleConfig").append(paramString).append(" result:");
      if (this.stickerList == null) {
        break label149;
      }
    }
    label149:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QIMPasterConfigManager", 2, bool);
      return;
    }
  }
  
  /* Error */
  public ArrayList<DoodleEmojiItem> eK()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 132	axtd:stickerList	Ljava/util/ArrayList;
    //   6: ifnonnull +153 -> 159
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 132	axtd:stickerList	Ljava/util/ArrayList;
    //   15: ifnonnull +142 -> 157
    //   18: getstatic 27	axtd:bl	Ljava/io/File;
    //   21: ldc 48
    //   23: invokestatic 191	axwf:d	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +12 -> 43
    //   34: aload_0
    //   35: aload_0
    //   36: aload_3
    //   37: invokespecial 127	axtd:ar	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   40: putfield 132	axtd:stickerList	Ljava/util/ArrayList;
    //   43: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +39 -> 85
    //   49: new 34	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   56: ldc 198
    //   58: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: astore_3
    //   62: aload_0
    //   63: getfield 132	axtd:stickerList	Ljava/util/ArrayList;
    //   66: ifnull +98 -> 164
    //   69: iconst_1
    //   70: istore_1
    //   71: ldc 65
    //   73: iconst_2
    //   74: aload_3
    //   75: iload_1
    //   76: invokevirtual 70	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   79: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_0
    //   86: getfield 132	axtd:stickerList	Ljava/util/ArrayList;
    //   89: ifnull +13 -> 102
    //   92: aload_0
    //   93: getfield 132	axtd:stickerList	Ljava/util/ArrayList;
    //   96: invokevirtual 201	java/util/ArrayList:size	()I
    //   99: ifne +58 -> 157
    //   102: aload_0
    //   103: aload_0
    //   104: ldc 203
    //   106: invokestatic 207	axwf:py	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokespecial 127	axtd:ar	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   112: putfield 132	axtd:stickerList	Ljava/util/ArrayList;
    //   115: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +39 -> 157
    //   121: new 34	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   128: ldc 209
    //   130: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: astore_3
    //   134: aload_0
    //   135: getfield 132	axtd:stickerList	Ljava/util/ArrayList;
    //   138: ifnull +31 -> 169
    //   141: iload_2
    //   142: istore_1
    //   143: ldc 65
    //   145: iconst_2
    //   146: aload_3
    //   147: iload_1
    //   148: invokevirtual 70	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   151: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_0
    //   160: getfield 132	axtd:stickerList	Ljava/util/ArrayList;
    //   163: areturn
    //   164: iconst_0
    //   165: istore_1
    //   166: goto -95 -> 71
    //   169: iconst_0
    //   170: istore_1
    //   171: goto -28 -> 143
    //   174: astore_3
    //   175: aload_0
    //   176: monitorexit
    //   177: aload_3
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	axtd
    //   70	101	1	bool1	boolean
    //   1	141	2	bool2	boolean
    //   26	121	3	localObject1	Object
    //   174	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	43	174	finally
    //   43	69	174	finally
    //   71	85	174	finally
    //   85	102	174	finally
    //   102	141	174	finally
    //   143	157	174	finally
    //   157	159	174	finally
    //   175	177	174	finally
  }
  
  public void onDestroy() {}
  
  public void onInit()
  {
    eK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axtd
 * JD-Core Version:    0.7.0.1
 */
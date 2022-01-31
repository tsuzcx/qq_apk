import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.DiscOfflinePreviewController;

public class dom
  extends FMObserver
{
  public dom(DiscOfflinePreviewController paramDiscOfflinePreviewController) {}
  
  /* Error */
  protected void a(boolean paramBoolean, int paramInt1, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, java.lang.String paramString4, int paramInt2, java.lang.String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 10	dom:a	Lcom/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController;
    //   6: getfield 20	com/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController:jdField_a_of_type_Boolean	Z
    //   9: ifeq +43 -> 52
    //   12: ldc 22
    //   14: astore 5
    //   16: ldc 24
    //   18: astore 6
    //   20: aload_0
    //   21: getfield 10	dom:a	Lcom/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController;
    //   24: getfield 27	com/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback	Lcom/tencent/mobileqq/filemanager/activity/FilePreviewActivity$ControlerCallback;
    //   27: iload_1
    //   28: aload 5
    //   30: aload 6
    //   32: iload_2
    //   33: i2l
    //   34: aload_3
    //   35: aload 4
    //   37: aload_0
    //   38: getfield 10	dom:a	Lcom/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController;
    //   41: getfield 30	com/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   44: invokeinterface 35 9 0
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload 5
    //   54: ifnull +31 -> 85
    //   57: aload 5
    //   59: invokevirtual 41	java/lang/String:length	()I
    //   62: ifle +23 -> 85
    //   65: aload 5
    //   67: ldc 43
    //   69: invokevirtual 47	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   72: ifne +13 -> 85
    //   75: iload 7
    //   77: invokestatic 51	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   80: astore 6
    //   82: goto -62 -> 20
    //   85: aload 6
    //   87: astore 5
    //   89: goto -14 -> 75
    //   92: astore_3
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_3
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	dom
    //   0	97	1	paramBoolean	boolean
    //   0	97	2	paramInt1	int
    //   0	97	3	paramString1	java.lang.String
    //   0	97	4	paramString2	java.lang.String
    //   0	97	5	paramString3	java.lang.String
    //   0	97	6	paramString4	java.lang.String
    //   0	97	7	paramInt2	int
    //   0	97	8	paramString5	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	12	92	finally
    //   20	49	92	finally
    //   57	75	92	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dom
 * JD-Core Version:    0.7.0.1
 */
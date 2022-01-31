import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;

public class dpa
  extends FMObserver
{
  public dpa(OfflinePreviewController paramOfflinePreviewController) {}
  
  /* Error */
  protected void b(boolean paramBoolean, int paramInt1, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, java.lang.String paramString4, int paramInt2, java.lang.String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 10	dpa:a	Lcom/tencent/mobileqq/filemanager/core/OfflinePreviewController;
    //   6: getfield 21	com/tencent/mobileqq/filemanager/core/OfflinePreviewController:jdField_a_of_type_Boolean	Z
    //   9: ifeq +43 -> 52
    //   12: ldc 23
    //   14: astore 5
    //   16: ldc 25
    //   18: astore 6
    //   20: aload_0
    //   21: getfield 10	dpa:a	Lcom/tencent/mobileqq/filemanager/core/OfflinePreviewController;
    //   24: getfield 28	com/tencent/mobileqq/filemanager/core/OfflinePreviewController:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback	Lcom/tencent/mobileqq/filemanager/activity/FilePreviewActivity$ControlerCallback;
    //   27: iload_1
    //   28: aload 5
    //   30: aload 6
    //   32: iload_2
    //   33: i2l
    //   34: aload_3
    //   35: aload 4
    //   37: aload_0
    //   38: getfield 10	dpa:a	Lcom/tencent/mobileqq/filemanager/core/OfflinePreviewController;
    //   41: getfield 31	com/tencent/mobileqq/filemanager/core/OfflinePreviewController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   44: invokeinterface 36 9 0
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload 5
    //   54: ifnull +21 -> 75
    //   57: aload 5
    //   59: invokevirtual 42	java/lang/String:length	()I
    //   62: ifle +13 -> 75
    //   65: iload 7
    //   67: invokestatic 46	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   70: astore 6
    //   72: goto -52 -> 20
    //   75: aload 6
    //   77: astore 5
    //   79: goto -14 -> 65
    //   82: astore_3
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_3
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	dpa
    //   0	87	1	paramBoolean	boolean
    //   0	87	2	paramInt1	int
    //   0	87	3	paramString1	java.lang.String
    //   0	87	4	paramString2	java.lang.String
    //   0	87	5	paramString3	java.lang.String
    //   0	87	6	paramString4	java.lang.String
    //   0	87	7	paramInt2	int
    //   0	87	8	paramString5	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	12	82	finally
    //   20	49	82	finally
    //   57	65	82	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dpa
 * JD-Core Version:    0.7.0.1
 */
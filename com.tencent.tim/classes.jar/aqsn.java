import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine.TagItemInfo;
import com.tencent.qphone.base.util.QLog;

public class aqsn
  extends aqsm
{
  private void h(String paramString1, long paramLong, String paramString2)
  {
    QLog.e("EmptyCallback", 1, "call empty method:" + paramString1 + " with " + paramLong + "_" + paramString2, new Exception());
  }
  
  protected void _onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    h("_onCompleted", paramLong, paramString1);
  }
  
  protected void _onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    h("_onProgress", paramLong1, paramString1);
  }
  
  public boolean canUpdate(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    h("canUpdate", paramLong, paramString1);
    return false;
  }
  
  public boolean deleteFiles(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    h("deleteFiles", paramLong, paramString);
    return true;
  }
  
  public void download(QQAppInterface paramQQAppInterface, long paramLong, String paramString, aqqq paramaqqq, boolean paramBoolean)
  {
    h("download", paramLong, paramString);
  }
  
  public long getBID()
  {
    return 0L;
  }
  
  public VasQuickUpdateEngine.TagItemInfo getItemInfo(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    h("getItemInfo", paramLong, paramString);
    return null;
  }
  
  public boolean isFileExists(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    h("isFileExists", paramLong, paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsn
 * JD-Core Version:    0.7.0.1
 */
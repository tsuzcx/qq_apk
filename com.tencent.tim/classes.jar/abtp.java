import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class abtp
  implements abto.b
{
  abtp(abhh paramabhh, int[] paramArrayOfInt, AppInterface paramAppInterface, abto.b paramb, boolean paramBoolean, int paramInt) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      File localFile;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        localFile = new File(abto.x(1, paramInt1), "dress.zip");
        if (!localFile.exists()) {}
      }
      try
      {
        paramArrayOfInt = abxi.bir;
        if (paramInt1 == 0) {
          paramArrayOfInt = abxi.bio + "/def/dress/";
        }
        new File(paramArrayOfInt).mkdirs();
        jqp.b(localFile, paramArrayOfInt);
        paramArrayOfInt = abto.j(paramInt1);
        if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
        {
          int j = paramArrayOfInt.length;
          int i = 0;
          while (i < j)
          {
            int k = paramArrayOfInt[i];
            abto.a(this.jdField_b_of_type_Abhh, 2, k);
            i += 1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role succ  id: " + paramInt1 + ", uin: " + paramString);
        }
      }
      catch (Exception paramArrayOfInt)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage(), paramArrayOfInt);
          }
        }
      }
      catch (OutOfMemoryError paramArrayOfInt)
      {
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage());
            }
          }
        } while (this.c == null);
        this.c.onDownLoadFinish(true, paramString, this.crI, this.jV, paramInt2);
        return;
      }
      if ((this.jV != null) && (this.jV.length > 0)) {
        abto.b(this.jdField_b_of_type_ComTencentCommonAppAppInterface, paramString, this.c, -1, this.jV, -1, -1, this.val$forceUpdate);
      }
    }
    do
    {
      return;
      if (this.c != null) {
        this.c.onDownLoadFinish(false, paramString, this.crI, this.jV, paramInt2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role fail id: " + this.crI + ", uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtp
 * JD-Core Version:    0.7.0.1
 */
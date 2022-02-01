import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

final class abyr
  implements abto.b
{
  abyr(String paramString, String[] paramArrayOfString, abyp paramabyp) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloHttpUtil", 2, "fakeResource3DUrlRequest onDownLoadFinish:" + paramInt1 + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramArrayOfInt = new File(this.val$path);
      if (paramArrayOfInt.exists()) {
        try
        {
          paramString = abyq.c(this.dp);
          if (abyq.jI(this.val$path))
          {
            paramArrayOfInt = abyq.b(paramArrayOfInt, paramString);
            this.b.callback(0, paramString, paramArrayOfInt);
          }
          while (QLog.isColorLevel())
          {
            QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest onDownLoadFinish retHeader:", paramString });
            return;
            this.b.callback(0, paramString, ApolloRender.readStream(new FileInputStream(paramArrayOfInt)));
          }
          this.b.callback(-1, null, null);
        }
        catch (Exception paramString)
        {
          QLog.e("ApolloHttpUtil", 1, paramString, new Object[0]);
          return;
        }
      }
    }
    else
    {
      this.b.callback(-1, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abyr
 * JD-Core Version:    0.7.0.1
 */
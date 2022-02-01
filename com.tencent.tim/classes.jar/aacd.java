import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource.b;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.Map;

class aacd
  extends PreloadResource.b
{
  aacd(aacc paramaacc, aquy paramaquy)
  {
    super(paramaquy);
  }
  
  public void onDoneFile(aquz paramaquz)
  {
    long l2 = -1L;
    super.onDoneFile(paramaquz);
    if ((paramaquz != null) && (paramaquz.ov != null) && (!TextUtils.isEmpty(paramaquz.key)))
    {
      File localFile = (File)paramaquz.ov.get(paramaquz.key);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (aopo)((QQAppInterface)localObject).getManager(193);
          String str = paramaquz.key;
          long l1 = l2;
          if (paramaquz.errCode == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((aopo)localObject).be(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacd
 * JD-Core Version:    0.7.0.1
 */
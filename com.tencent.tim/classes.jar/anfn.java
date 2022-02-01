import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class anfn
  extends aehv<anfm>
{
  private String getUin()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
  }
  
  @NonNull
  public anfm a(int paramInt)
  {
    return new anfm();
  }
  
  @Nullable
  public anfm a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      anfm localanfm = anfm.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localanfm;
    }
    return null;
  }
  
  public void a(anfm paramanfm)
  {
    boolean bool2 = true;
    int i = paramanfm.dFh;
    int j = paramanfm.dFi;
    int k = paramanfm.dFj;
    int m = paramanfm.dFk;
    paramanfm = getUin();
    if (ShortVideoUtils.eh(paramanfm) != j)
    {
      ShortVideoUtils.fV(paramanfm, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.cQ(paramanfm, bool1);
        ShortVideoUtils.cFL = false;
      }
    }
    else if (ShortVideoUtils.eg(paramanfm) != m)
    {
      ShortVideoUtils.fU(paramanfm, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.cP(paramanfm, bool1);
      ShortVideoUtils.cFK = false;
      return;
      bool1 = false;
      break;
    }
  }
  
  public Class<anfm> clazz()
  {
    return anfm.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return ShortVideoUtils.ef(getUin());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 325;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfn
 * JD-Core Version:    0.7.0.1
 */
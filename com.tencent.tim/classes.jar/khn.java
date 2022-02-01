import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.QueryTask.a;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class khn
  implements QueryTask.a<afqh, char[]>
{
  public char[] a(afqh paramafqh)
  {
    try
    {
      int i = Integer.parseInt(paramafqh.e.eId);
      int j = Integer.parseInt(paramafqh.e.epId);
      Object localObject = afgc.a(j, i);
      paramafqh = new char[5];
      paramafqh[0] = 20;
      paramafqh[1] = localObject[3];
      paramafqh[2] = localObject[2];
      paramafqh[3] = localObject[1];
      paramafqh[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((ajdg)((AppRuntime)localObject).getManager(14)).b(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramafqh[1] = 511;
        }
      }
      return paramafqh;
    }
    catch (NumberFormatException paramafqh)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion. id is not Int.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     khn
 * JD-Core Version:    0.7.0.1
 */
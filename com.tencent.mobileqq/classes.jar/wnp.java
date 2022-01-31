import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.Map;

public class wnp
  extends QQUIEventReceiver<wni, wna>
{
  public wnp(@NonNull wni paramwni)
  {
    super(paramwni);
  }
  
  public void a(@NonNull wni paramwni, @NonNull wna paramwna)
  {
    switch (paramwna.jdField_a_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
    case 3: 
      CertifiedAccountMeta.StFeed localStFeed;
      int i;
      do
      {
        do
        {
          do
          {
            return;
            paramwni.i();
            return;
            paramwni.j();
            return;
            wni.a(paramwni, false);
            wni.a(paramwni, null);
            wni.a(paramwni, null);
          } while (!(paramwna.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramwna = (Object[])paramwna.jdField_a_of_type_JavaLangObject;
        } while ((paramwna.length < 2) || (!(paramwna[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramwna[1] instanceof Integer)));
        localStFeed = (CertifiedAccountMeta.StFeed)paramwna[0];
        i = ((Integer)paramwna[1]).intValue();
      } while (!paramwni.a(localStFeed));
      wni.c(paramwni).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    wni.a(paramwni, (Object[])paramwna.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return wna.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnp
 * JD-Core Version:    0.7.0.1
 */
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.Map;

public class zfz
  extends QQUIEventReceiver<zfs, zfo>
{
  public zfz(@NonNull zfs paramzfs)
  {
    super(paramzfs);
  }
  
  public void a(@NonNull zfs paramzfs, @NonNull zfo paramzfo)
  {
    switch (paramzfo.jdField_a_of_type_Int)
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
            paramzfs.i();
            return;
            paramzfs.j();
            return;
            zfs.a(paramzfs, false);
            zfs.a(paramzfs, null);
            zfs.a(paramzfs, null);
          } while (!(paramzfo.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramzfo = (Object[])paramzfo.jdField_a_of_type_JavaLangObject;
        } while ((paramzfo.length < 2) || (!(paramzfo[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramzfo[1] instanceof Integer)));
        localStFeed = (CertifiedAccountMeta.StFeed)paramzfo[0];
        i = ((Integer)paramzfo[1]).intValue();
      } while (!paramzfs.a(localStFeed));
      zfs.c(paramzfs).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    zfs.a(paramzfs, (Object[])paramzfo.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return zfo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfz
 * JD-Core Version:    0.7.0.1
 */
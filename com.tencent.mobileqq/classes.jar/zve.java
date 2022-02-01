import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.Map;

public class zve
  extends QQUIEventReceiver<zux, zut>
{
  public zve(@NonNull zux paramzux)
  {
    super(paramzux);
  }
  
  public void a(@NonNull zux paramzux, @NonNull zut paramzut)
  {
    switch (paramzut.jdField_a_of_type_Int)
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
            paramzux.i();
            return;
            paramzux.j();
            return;
            zux.a(paramzux, false);
            zux.a(paramzux, null);
            zux.a(paramzux, null);
          } while (!(paramzut.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramzut = (Object[])paramzut.jdField_a_of_type_JavaLangObject;
        } while ((paramzut.length < 2) || (!(paramzut[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramzut[1] instanceof Integer)));
        localStFeed = (CertifiedAccountMeta.StFeed)paramzut[0];
        i = ((Integer)paramzut[1]).intValue();
      } while (!paramzux.a(localStFeed));
      zux.c(paramzux).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    zux.a(paramzux, (Object[])paramzut.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return zut.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zve
 * JD-Core Version:    0.7.0.1
 */
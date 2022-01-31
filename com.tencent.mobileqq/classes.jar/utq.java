import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class utq
  extends QQUIEventReceiver<uth, uzk>
{
  public utq(@NonNull uth paramuth)
  {
    super(paramuth);
  }
  
  public void a(@NonNull uth paramuth, @NonNull uzk paramuzk)
  {
    utr localutr = paramuth.jdField_a_of_type_Utr;
    int i = paramuzk.jdField_a_of_type_Int;
    paramuzk = paramuzk.jdField_a_of_type_JavaUtilList;
    paramuth = paramuth.jdField_a_of_type_Vca;
    if (localutr != null)
    {
      if (i != 0)
      {
        urk.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
        paramuth.jdField_a_of_type_Boolean = false;
        localutr.a(paramuth);
        urq.a("0X80076CD");
        urq.b("0X80075E2");
        return;
      }
      urk.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
      paramuth.jdField_a_of_type_JavaUtilList.clear();
      paramuzk = paramuzk.iterator();
      while (paramuzk.hasNext())
      {
        srl localsrl = (srl)paramuzk.next();
        if ((TextUtils.isEmpty(localsrl.d)) || (TextUtils.isEmpty(localsrl.a)) || (TextUtils.isEmpty(localsrl.b))) {
          urk.d(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localsrl.d, localsrl.a, localsrl.b });
        }
        vcb localvcb = new vcb();
        localvcb.d = localsrl.d;
        localvcb.b = localsrl.a;
        localvcb.c = localsrl.b;
        localvcb.a = localsrl.c;
        localvcb.e = localsrl.e;
        paramuth.jdField_a_of_type_JavaUtilList.add(localvcb);
      }
      paramuth.jdField_a_of_type_Boolean = false;
      localutr.a(paramuth);
      return;
    }
    urk.b(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return uzk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utq
 * JD-Core Version:    0.7.0.1
 */
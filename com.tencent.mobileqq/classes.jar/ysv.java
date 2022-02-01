import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class ysv
  extends QQUIEventReceiver<ysm, yyp>
{
  public ysv(@NonNull ysm paramysm)
  {
    super(paramysm);
  }
  
  public void a(@NonNull ysm paramysm, @NonNull yyp paramyyp)
  {
    ysw localysw = paramysm.jdField_a_of_type_Ysw;
    int i = paramyyp.jdField_a_of_type_Int;
    paramyyp = paramyyp.jdField_a_of_type_JavaUtilList;
    paramysm = paramysm.jdField_a_of_type_Zbf;
    if (localysw != null)
    {
      if (i != 0)
      {
        yqp.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
        paramysm.jdField_a_of_type_Boolean = false;
        localysw.a(paramysm);
        yqv.a("0X80076CD");
        yqv.b("0X80075E2");
        return;
      }
      yqp.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
      paramysm.jdField_a_of_type_JavaUtilList.clear();
      paramyyp = paramyyp.iterator();
      while (paramyyp.hasNext())
      {
        wqr localwqr = (wqr)paramyyp.next();
        if ((TextUtils.isEmpty(localwqr.d)) || (TextUtils.isEmpty(localwqr.a)) || (TextUtils.isEmpty(localwqr.b))) {
          yqp.d(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localwqr.d, localwqr.a, localwqr.b });
        }
        zbg localzbg = new zbg();
        localzbg.d = localwqr.d;
        localzbg.b = localwqr.a;
        localzbg.c = localwqr.b;
        localzbg.a = localwqr.c;
        localzbg.e = localwqr.e;
        paramysm.jdField_a_of_type_JavaUtilList.add(localzbg);
      }
      paramysm.jdField_a_of_type_Boolean = false;
      localysw.a(paramysm);
      return;
    }
    yqp.b(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return yyp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysv
 * JD-Core Version:    0.7.0.1
 */
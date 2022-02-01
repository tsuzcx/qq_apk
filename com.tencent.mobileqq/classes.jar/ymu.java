import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class ymu
  extends QQUIEventReceiver<yml, ysl>
{
  public ymu(@NonNull yml paramyml)
  {
    super(paramyml);
  }
  
  public void a(@NonNull yml paramyml, @NonNull ysl paramysl)
  {
    ymv localymv = paramyml.jdField_a_of_type_Ymv;
    int i = paramysl.jdField_a_of_type_Int;
    paramysl = paramysl.jdField_a_of_type_JavaUtilList;
    paramyml = paramyml.jdField_a_of_type_Yuu;
    if (localymv != null)
    {
      if (i != 0)
      {
        ykq.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
        paramyml.jdField_a_of_type_Boolean = false;
        localymv.a(paramyml);
        ykw.a("0X80076CD");
        ykw.b("0X80075E2");
        return;
      }
      ykq.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
      paramyml.jdField_a_of_type_JavaUtilList.clear();
      paramysl = paramysl.iterator();
      while (paramysl.hasNext())
      {
        wkx localwkx = (wkx)paramysl.next();
        if ((TextUtils.isEmpty(localwkx.d)) || (TextUtils.isEmpty(localwkx.a)) || (TextUtils.isEmpty(localwkx.b))) {
          ykq.d(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localwkx.d, localwkx.a, localwkx.b });
        }
        yuv localyuv = new yuv();
        localyuv.d = localwkx.d;
        localyuv.b = localwkx.a;
        localyuv.c = localwkx.b;
        localyuv.a = localwkx.c;
        localyuv.e = localwkx.e;
        paramyml.jdField_a_of_type_JavaUtilList.add(localyuv);
      }
      paramyml.jdField_a_of_type_Boolean = false;
      localymv.a(paramyml);
      return;
    }
    ykq.b(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return ysl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymu
 * JD-Core Version:    0.7.0.1
 */
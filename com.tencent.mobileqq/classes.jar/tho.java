import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class tho
  extends QQUIEventReceiver<thh, tdr>
{
  public tho(@NonNull thh paramthh)
  {
    super(paramthh);
  }
  
  public void a(@NonNull thh paramthh, @NonNull tdr paramtdr)
  {
    ved.a(this.TAG, "onEvent, %s", String.valueOf(paramtdr));
    tff localtff = paramthh.a.a(3, "");
    if ((localtff != null) && (paramtdr.jdField_b_of_type_JavaLangString.equals(localtff.jdField_e_of_type_JavaLangString)))
    {
      ved.b(this.TAG, "onEvent, guideInfoNode read");
      paramthh = new tgn();
      paramthh.jdField_b_of_type_JavaLangString = localtff.jdField_a_of_type_JavaLangString;
      paramthh.c = localtff.jdField_a_of_type_Int;
      paramthh.d = 5;
      paramthh.jdField_b_of_type_Long = localtff.jdField_e_of_type_Long;
      syo.a().a(paramthh, null);
      return;
    }
    paramthh.a.a(paramtdr.jdField_a_of_type_JavaLangString, paramtdr.jdField_a_of_type_Long);
  }
  
  public Class acceptEventClass()
  {
    return tdr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tho
 * JD-Core Version:    0.7.0.1
 */
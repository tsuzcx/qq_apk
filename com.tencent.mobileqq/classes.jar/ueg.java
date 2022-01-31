import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;

class ueg
  extends sgl<uec, ucf>
{
  ueg(uec paramuec)
  {
    super(paramuec);
  }
  
  public void a(@NonNull uec paramuec, @NonNull ucf paramucf)
  {
    if ((!paramucf.jdField_a_of_type_JavaLangString.equals(uec.a(paramuec))) || (paramucf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (uec.a(paramuec) == null)) {
      urk.b(this.TAG, "ignore this comment list event. %s.", paramucf.toString());
    }
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      urk.a(this.TAG, "receive comment list event. %s.", paramucf.toString());
      bool2 = uec.a(paramuec);
      bool1 = true;
      if (paramucf.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      uec.a(paramuec).a(bool1);
      uec.a(paramuec).a(bool1, paramucf.b);
      uec.a(paramuec).a(bool1, paramucf.jdField_a_of_type_Boolean);
      uec.a(paramuec).a(paramucf.jdField_a_of_type_JavaUtilList, paramucf.c, bool1);
    } while (bool2 != bool1);
    paramuec.b(paramucf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return ucf.class;
  }
  
  public void b(@NonNull uec paramuec, @NonNull ucf paramucf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ueg
 * JD-Core Version:    0.7.0.1
 */
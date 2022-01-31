import EncounterSvc.RespEncounterInfo;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.util.FaceDecoder;

public class cqm
  implements Runnable
{
  public cqm(PeopleAroundAdapter paramPeopleAroundAdapter, String paramString, RespEncounterInfo paramRespEncounterInfo) {}
  
  public void run()
  {
    FaceDecoder localFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_EncounterSvcRespEncounterInfo.stranger_face_timestamp > 0) {}
    for (long l = this.jdField_a_of_type_EncounterSvcRespEncounterInfo.stranger_face_timestamp;; l = this.jdField_a_of_type_EncounterSvcRespEncounterInfo.common_face_timestamp)
    {
      localFaceDecoder.a(str, 3001, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqm
 * JD-Core Version:    0.7.0.1
 */